package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.BounceScrollView;

public class AccountDetailBounceScrollView
  extends BounceScrollView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  
  public AccountDetailBounceScrollView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(320.0F * this.jdField_a_of_type_Float));
    this.b = 0;
  }
  
  public AccountDetailBounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(320.0F * this.jdField_a_of_type_Float));
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    super.a(paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_Boolean = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMaxOverScrollY(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailBounceScrollView
 * JD-Core Version:    0.7.0.1
 */