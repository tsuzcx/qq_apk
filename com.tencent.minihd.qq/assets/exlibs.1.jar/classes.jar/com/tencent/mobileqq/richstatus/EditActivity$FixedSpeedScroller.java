package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class EditActivity$FixedSpeedScroller
  extends Scroller
{
  private int jdField_a_of_type_Int = 180;
  
  public EditActivity$FixedSpeedScroller(EditActivity paramEditActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public EditActivity$FixedSpeedScroller(EditActivity paramEditActivity, Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_a_of_type_Int);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity.FixedSpeedScroller
 * JD-Core Version:    0.7.0.1
 */