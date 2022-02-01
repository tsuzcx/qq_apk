package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class DateLineFrameLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int = -1;
  private boolean jdField_a_of_type_Boolean = false;
  
  public DateLineFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DateLineFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DateLineFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4 - paramInt2;
    if ((this.jdField_a_of_type_Int < 0) && (paramBoolean) && (i > 0))
    {
      this.jdField_a_of_type_Int = i;
      if ((this.jdField_a_of_type_Int <= i) || (this.jdField_a_of_type_Int - i <= 0.2F * this.jdField_a_of_type_Int)) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      if (i <= this.jdField_a_of_type_Int) {
        break;
      }
      this.jdField_a_of_type_Int = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DateLineFrameLayout
 * JD-Core Version:    0.7.0.1
 */