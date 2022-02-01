package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

public class SlipEdgeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private SlipEdgeLayout.SlipEdgeCallBack jdField_a_of_type_ComTencentMobileqqWidgetSlipEdgeLayout$SlipEdgeCallBack;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  private float c;
  
  public SlipEdgeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlipEdgeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Float = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledPagingTouchSlop();
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    this.jdField_a_of_type_Int = ((int)(this.b * 50.0F));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.c = paramMotionEvent.getX();
      continue;
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      float f = paramMotionEvent.getX() - this.c;
      if ((!this.jdField_a_of_type_Boolean) && (this.c < this.jdField_a_of_type_Int) && (Math.abs(f) > this.jdField_a_of_type_Float) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlipEdgeLayout$SlipEdgeCallBack != null))
      {
        this.jdField_a_of_type_Boolean = true;
        if (f > 0.0F)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlipEdgeLayout$SlipEdgeCallBack.a();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlipEdgeLayout$SlipEdgeCallBack.b();
          continue;
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setSlipEdgeCallBack(SlipEdgeLayout.SlipEdgeCallBack paramSlipEdgeCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlipEdgeLayout$SlipEdgeCallBack = paramSlipEdgeCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlipEdgeLayout
 * JD-Core Version:    0.7.0.1
 */