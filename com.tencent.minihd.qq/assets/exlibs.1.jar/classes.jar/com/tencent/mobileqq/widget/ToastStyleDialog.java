package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

public class ToastStyleDialog
  extends Dialog
{
  private static final int jdField_a_of_type_Int = 10;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ToastStyleDialog(Context paramContext)
  {
    super(paramContext, 2131558873);
    getWindow().setFlags(16, 16);
    getWindow().setFlags(8, 8);
    getWindow().setGravity(17);
    if (!(paramContext instanceof Activity)) {
      getWindow().getAttributes().type = 2005;
    }
    setContentView(2130904040);
    this.a = ((TextView)findViewById(2131298079));
    setCancelable(false);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ToastStyleDialog
 * JD-Core Version:    0.7.0.1
 */