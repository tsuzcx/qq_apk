package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.ListView;
import kyx;

public class ScrollerRunnable
  implements Runnable
{
  private static final int jdField_b_of_type_Int = 500;
  private static final int c = 1;
  private static final int d = 2;
  private static final int k = 10;
  int jdField_a_of_type_Int = 0;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean jdField_b_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private final int i;
  private int j = -1;
  
  public ScrollerRunnable(ListView paramListView)
  {
    this.b = false;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.i = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledFadingEdgeLength();
    if (DeviceInfoUtil.c() / 1048576L > 512L) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    c();
  }
  
  private void c()
  {
    int m = this.jdField_a_of_type_ComTencentWidgetListView.s();
    if (this.j < m) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(this.j - m);
    } while (localView == null);
    localView.postDelayed(new kyx(this, localView), 300L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
    this.b = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, null);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    a();
    this.j = paramInt2;
    this.f = paramInt1;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_ComTencentWidgetListView.post(this);
  }
  
  public void run()
  {
    int m;
    label72:
    int i2;
    if (!this.b)
    {
      this.b = true;
      this.jdField_a_of_type_Int = 0;
      m = this.jdField_a_of_type_ComTencentWidgetListView.s();
      n = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + m - 1;
      if (this.f <= m)
      {
        m = m - this.f + 1;
        this.e = 2;
        if (m <= 0) {
          break label168;
        }
        this.h = (500 / m);
        this.g = -1;
      }
    }
    else
    {
      n = this.jdField_a_of_type_ComTencentWidgetListView.getHeight();
      i2 = this.jdField_a_of_type_ComTencentWidgetListView.s();
      switch (this.e)
      {
      }
    }
    label168:
    View localView;
    label295:
    label358:
    do
    {
      int i1;
      do
      {
        do
        {
          return;
          if (this.f >= n)
          {
            m = this.f - n + 1;
            this.e = 1;
            break;
          }
        } while (this.jdField_a_of_type_JavaLangRunnable == null);
        this.jdField_a_of_type_JavaLangRunnable.run();
        this.jdField_a_of_type_JavaLangRunnable = null;
        return;
        this.h = 500;
        break label72;
        i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
        i2 += i1;
      } while (i1 < 0);
      if (i2 == this.g)
      {
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.f);
          b();
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        this.jdField_a_of_type_Int += 1;
        return;
      }
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1);
      int i3 = localView.getHeight();
      int i4 = localView.getTop();
      if (i2 < this.jdField_a_of_type_ComTencentWidgetListView.b() - 1)
      {
        m = this.i;
        if (!this.jdField_a_of_type_Boolean) {
          break label358;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.e(m + (i3 - (n - i4)), this.h);
      }
      for (;;)
      {
        this.g = i2;
        if (i2 >= this.f) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        return;
        m = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingBottom();
        break label295;
        if (i2 < this.f) {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(i1);
        }
      }
      if (i2 == this.g)
      {
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.f);
          b();
          return;
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        return;
      }
      this.jdField_a_of_type_Int = 0;
      if (i2 <= this.f)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.f);
        b();
      }
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
    } while (localView == null);
    int n = localView.getTop();
    if (i2 > this.f)
    {
      m = this.i;
      label496:
      if (!this.jdField_a_of_type_Boolean) {
        break label553;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.e(n - m, this.h);
    }
    for (;;)
    {
      this.g = i2;
      if (i2 <= this.f) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      return;
      m = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingTop();
      break label496;
      label553:
      if (i2 > this.f) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable
 * JD-Core Version:    0.7.0.1
 */