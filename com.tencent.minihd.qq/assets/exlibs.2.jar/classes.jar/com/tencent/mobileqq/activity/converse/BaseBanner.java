package com.tencent.mobileqq.activity.converse;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class BaseBanner
{
  int jdField_a_of_type_Int = 0;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView = null;
  boolean jdField_a_of_type_Boolean = true;
  int b = 0;
  int c = 0;
  int d = 0;
  
  public View a(Context paramContext)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean a(int paramInt)
  {
    if (this.d == paramInt) {
      return false;
    }
    a(paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.converse.BaseBanner
 * JD-Core Version:    0.7.0.1
 */