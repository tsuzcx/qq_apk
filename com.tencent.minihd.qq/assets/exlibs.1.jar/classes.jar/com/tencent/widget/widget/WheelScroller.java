package com.tencent.widget.widget;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import luk;
import lul;

public class WheelScroller
{
  public static final int a = 1;
  public static final int b = 0;
  public static final int c = 1;
  private static final int d = 400;
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new lul(this);
  private GestureDetector.SimpleOnGestureListener jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new luk(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private WheelScroller.ScrollingListener jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener;
  private boolean jdField_a_of_type_Boolean;
  private int e;
  
  public WheelScroller(Context paramContext, WheelScroller.ScrollingListener paramScrollingListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener = paramScrollingListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener.c();
    a(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
  }
  
  public void a(int paramInt)
  {
    d();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    this.e = 0;
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    if (paramInt2 != 0) {}
    for (;;)
    {
      localScroller.startScroll(0, 0, 0, paramInt1, paramInt2);
      a(0);
      b();
      return;
      paramInt2 = 400;
    }
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext, paramInterpolator);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1)) {
        e();
      }
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      d();
      continue;
      int i = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Float);
      if (i != 0)
      {
        b();
        this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener.a(i);
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener.b();
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.widget.WheelScroller
 * JD-Core Version:    0.7.0.1
 */