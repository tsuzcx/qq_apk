package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.widget.ScrollView;
import kxb;

public class BounceScrollView
  extends ScrollView
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new kxb(this));
  private BounceScrollView.MotionEventInterceptor jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor;
  protected BounceScrollView.OnScrollChangedListener a;
  private boolean jdField_a_of_type_Boolean = false;
  
  public BounceScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(9)
  public BounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOverScrollMode(0);
    setFadingEdgeLength(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor.a(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.dispatchTouchEvent(paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        super.onInterceptTouchEvent(paramMotionEvent);
        return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setMotionEventInterceptor(BounceScrollView.MotionEventInterceptor paramMotionEventInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor = paramMotionEventInterceptor;
  }
  
  public void setNeedHorizontalGesture(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollChangedListener(BounceScrollView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener = paramOnScrollChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BounceScrollView
 * JD-Core Version:    0.7.0.1
 */