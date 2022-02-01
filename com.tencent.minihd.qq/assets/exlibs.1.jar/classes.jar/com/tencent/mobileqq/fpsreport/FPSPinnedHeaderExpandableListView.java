package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.widget.PinnedHeaderExpandableListView;

public class FPSPinnedHeaderExpandableListView
  extends PinnedHeaderExpandableListView
{
  private FPSCalculator jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator;
  private FPSPinnedHeaderExpandableListView.OnInterceptTouchListener jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView$OnInterceptTouchListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private long h = 0L;
  
  public FPSPinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      PerformanceReportUtils.a(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis());
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView$OnInterceptTouchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView$OnInterceptTouchListener.a(this, paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setOnInterceptTouchListener(FPSPinnedHeaderExpandableListView.OnInterceptTouchListener paramOnInterceptTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView$OnInterceptTouchListener = paramOnInterceptTouchListener;
  }
  
  public void setStartTime(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.h = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */