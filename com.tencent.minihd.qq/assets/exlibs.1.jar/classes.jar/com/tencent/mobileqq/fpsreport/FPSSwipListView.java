package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.SwipListView;

public class FPSSwipListView
  extends SwipListView
{
  private FPSCalculator jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator;
  private FPSSwipListView.OnInterceptTouchListener jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView$OnInterceptTouchListener;
  
  public FPSSwipListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSSwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public FPSSwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.a();
    }
  }
  
  protected void c(int paramInt)
  {
    super.c(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.a(paramInt);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.b();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView$OnInterceptTouchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView$OnInterceptTouchListener.a(this, paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.a(paramString);
  }
  
  public void setOnInterceptTouchListener(FPSSwipListView.OnInterceptTouchListener paramOnInterceptTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView$OnInterceptTouchListener = paramOnInterceptTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSwipListView
 * JD-Core Version:    0.7.0.1
 */