package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.SizeMeasure;

public class QQTabWidget
  extends TabWidget
{
  private static final int d = 50;
  private float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 6;
  private QQTabWidget.onTabWidgetTouchMoveListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int;
  int c;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = -1;
  
  public QQTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public QQTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if (paramInt2 == this.i) {
      return true;
    }
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      return false;
    }
    if ((paramInt1 == paramInt3) && (paramInt3 != 0) && (paramInt4 != 0)) {
      if (paramInt2 < paramInt4) {
        if (Math.abs(paramInt2 - this.e) > this.f) {
          if (!bool) {
            break label129;
          }
        }
      }
    }
    label129:
    for (this.i = paramInt2;; this.i = -1)
    {
      b();
      return bool;
      bool = false;
      break;
      if (Math.abs(paramInt2 - paramInt4) < this.f)
      {
        if ((paramInt4 != this.jdField_b_of_type_Int) && (paramInt4 != this.c)) {
          break;
        }
        bool = false;
        break;
      }
      bool = false;
      break;
    }
  }
  
  private void c()
  {
    this.e = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getHeight();
    this.f = AIOUtils.a(150.0F, getResources());
  }
  
  public void a()
  {
    if (SizeMeasure.b)
    {
      Log.i("app2", "resetTabItemPadding in phone");
      boolean bool = SizeMeasure.a(getContext());
      int j = 0;
      if (j < getChildCount())
      {
        View localView = getChildAt(j).findViewById(2131297978);
        int k = localView.getPaddingLeft();
        int m = localView.getPaddingRight();
        int n = localView.getPaddingTop();
        if (bool) {
          localView.setPadding(k, n, m, getResources().getDimensionPixelSize(2131492899));
        }
        for (;;)
        {
          j += 1;
          break;
          localView.setPadding(k, n, m, getResources().getDimensionPixelSize(2131492898));
        }
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getY();
    if ((getChildCount() > 0) && (paramMotionEvent.getAction() == 0))
    {
      paramMotionEvent = getChildAt(0);
      if ((j > paramMotionEvent.findViewById(2131297979).getHeight()) && (j < paramMotionEvent.getHeight())) {}
      View localView;
      do
      {
        return true;
        if (getChildCount() < this.jdField_a_of_type_Int) {
          break;
        }
        paramMotionEvent = getChildAt(this.jdField_a_of_type_Int - 1);
        localView = paramMotionEvent.findViewById(2131297979);
      } while (j > paramMotionEvent.getTop() + localView.getHeight());
    }
    return false;
  }
  
  public void addView(View paramView)
  {
    int j = getChildCount();
    if ((j > 0) && (j < this.jdField_a_of_type_Int - 1)) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }
    for (;;)
    {
      super.addView(paramView);
      return;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
      localLayoutParams.setMargins(0, 0, 0, 0);
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void b()
  {
    if (SizeMeasure.a(getContext()))
    {
      this.jdField_b_of_type_Int = this.i;
      return;
    }
    this.c = this.i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
    this.e = SizeMeasure.i(getContext());
    this.i = -1;
    this.h = this.e;
    requestLayout();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((f2 < this.jdField_b_of_type_Float) && (this.jdField_b_of_type_Float - f2 > 50.0F) && (this.jdField_b_of_type_Float - f2 > Math.abs(this.jdField_a_of_type_Float - f1)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener.a();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    SizeMeasure.b(getContext());
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int j = paramInt2;
    if (getHeight() > 0)
    {
      j = paramInt2;
      if (a(k, m, this.g, this.h)) {
        j = View.MeasureSpec.makeMeasureSpec(getHeight(), View.MeasureSpec.getMode(paramInt2));
      }
    }
    this.g = k;
    this.h = m;
    super.onMeasure(paramInt1, j);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTabNum(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setTabWidgetMoveListener(QQTabWidget.onTabWidgetTouchMoveListener paramonTabWidgetTouchMoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = paramonTabWidgetTouchMoveListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabWidget
 * JD-Core Version:    0.7.0.1
 */