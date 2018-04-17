package com.example.yihsiu.hw1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* Fields that will store our EditText and Button */
    private EditText mWordEntry; //輸入的文字
    private Button mDoSomethingCoolButton;


    public void buttonOnClick(View view) {
        //此行可讓程式不crash
        Button button = (Button) view;
        //點擊後要產生什麼訊息
        Toast toast = Toast.makeText(this, "按鈕已經被點擊", Toast.LENGTH_SHORT);
        //顯示出來
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          /*
         * Using findViewById, we get a reference to our Button from xml. This allows us to
         * do things like set the onClickListener which determines what happens when the button
         * is clicked.
         */
        mDoSomethingCoolButton = (Button) findViewById(R.id.b_do_something_cool);

        //輸入的文字(從EditText拿)
        mWordEntry = (EditText) findViewById(R.id.et_text_entry);

        /* Setting an OnClickListener allows us to do something when this button is clicked. */
        mDoSomethingCoolButton.setOnClickListener(new OnClickListener() {

            /**
             * The onClick method is triggered when this button (mDoSomethingCoolButton) is clicked.
             *
             * @param v The view that is clicked. In this case, it's mDoSomethingCoolButton.
             */
            @Override
            public void onClick(View v) {
                // COMPLETED (1) Retrieve the text from the EditText and store it in a variable
                /* We'll first get the text entered by the user in the EditText */

                //拿到輸入的文字儲存成String (textEntered）
                String textEntered = mWordEntry.getText().toString();

                /*
                 * Storing the Context in a variable in this case is redundant since we could have
                 * just used "this" or "MainActivity.this" in the method call below. However, we
                 * wanted to demonstrate what parameter we were using "MainActivity.this" for as
                 * clear as possible.
                 * 如果在MainActivity中產生Intent，那就是代表MainActivity本身，
                 * 可使用「this」關鍵字，第二個參數則需給予轉換目的地的類別
                 */
                //ＡＡＡ第一個建構子參數是context 表示從這裡出發
                Context context = MainActivity.this;

                /* This is the class that we want to start (and open) when the button is clicked. */
                //ＢＢＢ按鈕按下去時要做的事的物件（destinationActivity）（內容是ChildActivity.class）
                Class destinationActivity = ChildActivity.class;
                /*
                 * Here, we create the Intent that will start the Activity we specified above in
                 * the destinationActivity variable. The constructor for an Intent also requires a
                 * context, which we stored in the variable named "context".
                 * Intent:按下一個按鈕後轉換到另一個畫面(也就是另一個Activity)
                 * 用來執行context跟destinationActivity（ＡＡＡ,BBB）
                 */
                Intent startChildActivityIntent = new Intent(context, destinationActivity);

                // COMPLETED (2) Use the putExtra method to put the String from the EditText in the Intent
                /*
                 * We use the putExtra method of the Intent class to pass some extra stuff to the
                 * Activity that we are starting. Generally, this data is quite simple, such as
                 * a String or a number. However, there are ways to pass more complex objects.
                 * 可以在Intent物件中夾帶資料，在轉換後再取出資料後使用，這種在Intent中的資料稱為「Extra」額外附帶的資料。
                 * 在這裡用來夾帶 String textEntered
                 */
                startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textEntered);

                /*
                 * Once the Intent has been created, we can use Activity's method, "startActivity"
                 * to start the ChildActivity.
                 */
                startActivity(startChildActivityIntent);//開始下一個程式ChildActivity
            }
        });
    }
}

