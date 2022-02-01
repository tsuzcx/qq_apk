package com.tencent.mobileqq.customviews;

import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class CircleMenu$Builder
{
  private final CircleMenu.MenuParams a = new CircleMenu.MenuParams();
  
  public CircleMenu$Builder(ViewGroup paramViewGroup)
  {
    this.a.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public Builder a(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(View.OnClickListener paramOnClickListener)
  {
    this.a.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder a(int[] paramArrayOfInt)
  {
    this.a.b = paramArrayOfInt;
    return this;
  }
  
  public Builder a(int[] paramArrayOfInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder a(Drawable[] paramArrayOfDrawable)
  {
    this.a.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramArrayOfDrawable;
    return this;
  }
  
  public Builder a(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.jdField_a_of_type_ArrayOfJavaLangCharSequence = paramArrayOfCharSequence;
    this.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public CircleMenu a()
  {
    return new CircleMenu(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.CircleMenu.Builder
 * JD-Core Version:    0.7.0.1
 */