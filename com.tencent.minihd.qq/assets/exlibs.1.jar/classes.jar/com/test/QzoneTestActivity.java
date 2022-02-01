package com.test;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.app.BaseActivity;
import lup;

public class QzoneTestActivity
  extends BaseActivity
{
  Button a;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904314);
    this.a = ((Button)findViewById(2131301762));
    this.a.setOnClickListener(new lup(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.test.QzoneTestActivity
 * JD-Core Version:    0.7.0.1
 */