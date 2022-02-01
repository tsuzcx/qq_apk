package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.Scroller;
import java.util.HashMap;

public class ScrollRadioGroup
  extends RadioGroup
{
  private static final int jdField_a_of_type_Int = 1000;
  private static final int b = 1;
  private static final int c = 0;
  private static final int d = 1;
  private static int e;
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int f = 1;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = -1;
  private int m = 80;
  private int n = 0;
  
  public ScrollRadioGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_Float = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    e = (int)(3.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density + 0.5F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131427938));
  }
  
  private void a()
  {
    int i4 = getScrollX();
    int i1;
    if (i4 < 0) {
      i1 = -i4;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i4, 0, i1, 0, Math.abs(i1) * 1);
      invalidate();
      return;
      if (i4 > this.g)
      {
        if (this.g > 0) {
          i1 = this.g - i4;
        } else {
          i1 = -i4;
        }
      }
      else if (this.i > 0)
      {
        int i2 = this.g - i4;
        int i3 = i4 / this.i;
        i1 = i3;
        if (i4 % this.i > this.i / 2) {
          i1 = i3 + 1;
        }
        i3 = getChildAt(i1).getLeft() - i4;
        i1 = i2;
        if (i3 <= i2) {
          i1 = i3;
        }
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  private void b()
  {
    int i1 = getScrollX();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, 0, -i1, 0, Math.abs(i1) * 1);
    invalidate();
  }
  
  private void b(int paramInt)
  {
    View localView = getChildAt(paramInt);
    int i3;
    if (localView != null)
    {
      paramInt = localView.getRight();
      int i1 = localView.getLeft();
      int i2 = getScrollX();
      i3 = getWidth() + getScrollX();
      if (i1 >= i2) {
        break label70;
      }
      paramInt = i1 - i2;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 1);
    }
    label70:
    while (paramInt <= i3) {
      return;
    }
    paramInt -= i3;
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 1);
  }
  
  private void c()
  {
    int i2 = getScrollX();
    if (this.g < 0) {}
    for (int i1 = -i2;; i1 = this.g - i2)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i2, 0, i1, 0, Math.abs(i2) * 1);
      invalidate();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();
      if (paramInt != this.l) {}
    }
    else
    {
      return;
    }
    this.l = paramInt;
    b(this.l);
    invalidate();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    RadioButton localRadioButton = (RadioButton)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903910, null);
    localRadioButton.setCompoundDrawablesWithIntrinsicBounds(0, paramInt1, 0, 0);
    localRadioButton.setText(paramString);
    float f1 = this.m;
    paramString = new RadioGroup.LayoutParams((int)(localDisplayMetrics.density * f1), -2);
    localRadioButton.setGravity(1);
    localRadioButton.setId(paramInt2);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt2), Integer.valueOf(this.n));
    paramInt1 = this.n;
    this.n = (paramInt1 + 1);
    addView(localRadioButton, paramInt1, paramString);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView = getChildAt(this.l);
    if (localView != null)
    {
      int i1 = localView.getLeft();
      int i2 = localView.getRight();
      paramCanvas.drawRect(i1, getHeight() - e, i2, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (this.f != 1)) {}
    for (;;)
    {
      return true;
      int i2 = (int)paramMotionEvent.getX();
      switch (i1)
      {
      }
      while (this.f == 1)
      {
        return false;
        this.k = i2;
        if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
        for (this.f = 1;; this.f = 0)
        {
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break;
        }
        if (Math.abs(i2 - this.k) > this.jdField_a_of_type_Float)
        {
          this.f = 0;
          continue;
          this.f = 1;
          if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = getWidth();
    this.j = getChildCount();
    if (this.j >= 1)
    {
      this.g = (getChildAt(this.j - 1).getRight() - this.h);
      this.i = getChildAt(0).getWidth();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i1 = (int)paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      int i2;
      do
      {
        return true;
        if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
        }
        this.k = i1;
        return true;
        i2 = i1 - this.k;
      } while (Math.abs(i2) <= this.jdField_a_of_type_Float);
      scrollBy(-i2, 0);
      this.k = i1;
      return true;
    case 1: 
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i1 = (int)paramMotionEvent.getXVelocity();
      if (i1 > 1000) {
        b();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.f = 1;
        return true;
        if (i1 < -1000) {
          c();
        } else {
          a();
        }
      }
    }
    this.f = 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollRadioGroup
 * JD-Core Version:    0.7.0.1
 */