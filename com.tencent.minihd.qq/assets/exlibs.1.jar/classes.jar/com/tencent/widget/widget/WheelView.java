package com.tencent.widget.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.tencent.widget.widget.adapters.WheelViewAdapter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import lum;
import lun;

public class WheelView
  extends View
{
  private static final int jdField_a_of_type_Int = 10;
  private static final int[] jdField_a_of_type_ArrayOfInt = { -15658735, 11184810, 11184810 };
  private static final int jdField_b_of_type_Int = 10;
  private static final int jdField_c_of_type_Int = 1;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new lun(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WheelRecycle jdField_a_of_type_ComTencentWidgetWidgetWheelRecycle = new WheelRecycle(this);
  WheelScroller.ScrollingListener jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener = new lum(this);
  private WheelScroller jdField_a_of_type_ComTencentWidgetWidgetWheelScroller;
  private WheelViewAdapter jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  boolean jdField_a_of_type_Boolean = false;
  private List jdField_b_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_b_of_type_Boolean;
  private List jdField_c_of_type_JavaUtilList;
  private int d = 0;
  private int e = 1;
  private int f = 0;
  private int g;
  private int h;
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    this.c = new LinkedList();
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = new LinkedList();
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = new LinkedList();
    a(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
    if (paramInt2 == 1073741824) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      return paramInt2;
      i = Math.max(i + 20, getSuggestedMinimumWidth());
      if (paramInt2 == -2147483648)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < i) {}
      }
      else
      {
        paramInt2 = i;
      }
    }
  }
  
  private int a(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout != null) && (paramLinearLayout.getChildAt(0) != null)) {
      this.f = paramLinearLayout.getChildAt(0).getMeasuredHeight();
    }
    return Math.max(this.f * this.e - this.f * 10 / 50, getSuggestedMinimumHeight());
  }
  
  private View a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter == null) || (this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a() == 0)) {
      return null;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a();
    int i = paramInt;
    if (!a(paramInt)) {
      return this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a(this.jdField_a_of_type_ComTencentWidgetWidgetWheelRecycle.b(), this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    while (i < 0) {
      i += j;
    }
    return this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a(i % j, this.jdField_a_of_type_ComTencentWidgetWidgetWheelRecycle.a(), this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private ItemsRange a()
  {
    if (c() == 0) {
      return null;
    }
    int i = this.d;
    int j = 1;
    while (c() * j < getHeight())
    {
      i -= 1;
      j += 2;
    }
    int m = j;
    int k = i;
    if (this.g != 0)
    {
      k = i;
      if (this.g > 0) {
        k = i - 1;
      }
      i = this.g / c();
      k -= i;
      m = (int)(j + 1 + Math.asin(i));
    }
    return new ItemsRange(k, m);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller = new WheelScroller(getContext(), this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller$ScrollingListener);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = (int)(1.5D * c());
  }
  
  private boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter != null) && (this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a() > 0) && ((this.jdField_a_of_type_Boolean) || ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a())));
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    View localView = a(paramInt);
    if (localView != null)
    {
      if (!paramBoolean) {
        break label32;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, 0);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label32:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    }
  }
  
  private void b(int paramInt)
  {
    this.g += paramInt;
    int m = c();
    paramInt = this.g / m;
    int i = this.d - paramInt;
    int n = this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a();
    int k = this.g % m;
    int j = k;
    if (Math.abs(k) <= m / 2) {
      j = 0;
    }
    if ((this.jdField_a_of_type_Boolean) && (n > 0)) {
      if (j > 0)
      {
        j = i - 1;
        i = paramInt + 1;
        paramInt = j;
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        paramInt += n;
        continue;
        if (j < 0)
        {
          i += 1;
          j = paramInt - 1;
          paramInt = i;
          i = j;
        }
      }
      else
      {
        paramInt %= n;
        for (;;)
        {
          j = this.g;
          if (paramInt != this.d) {
            setCurrentItem(paramInt, false);
          }
          for (;;)
          {
            this.g = (j - i * m);
            if (this.g > getHeight()) {
              this.g = (this.g % getHeight() + getHeight());
            }
            return;
            if (i < 0)
            {
              i = this.d;
              paramInt = 0;
              break;
            }
            if (i >= n)
            {
              i = this.d - n + 1;
              paramInt = n - 1;
              break;
            }
            if ((i > 0) && (j > 0))
            {
              i -= 1;
              j = paramInt + 1;
              paramInt = i;
              i = j;
              break;
            }
            if ((i >= n - 1) || (j >= 0)) {
              break label284;
            }
            i += 1;
            j = paramInt - 1;
            paramInt = i;
            i = j;
            break;
            invalidate();
          }
          label284:
          j = paramInt;
          paramInt = i;
          i = j;
        }
      }
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(10.0F, -((this.d - this.h) * c() + (c() - getHeight()) / 2) + this.g);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private boolean b()
  {
    ItemsRange localItemsRange = a();
    int i;
    boolean bool1;
    label47:
    boolean bool2;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      i = this.jdField_a_of_type_ComTencentWidgetWidgetWheelRecycle.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.h, localItemsRange);
      if (this.h != i)
      {
        bool1 = true;
        this.h = i;
        bool2 = bool1;
        if (!bool1)
        {
          if ((this.h == localItemsRange.a()) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == localItemsRange.c())) {
            break label214;
          }
          bool2 = true;
        }
        label86:
        if ((this.h <= localItemsRange.a()) || (this.h > localItemsRange.b())) {
          break label232;
        }
        i = this.h - 1;
        label117:
        if ((i >= localItemsRange.a()) && (a(i, true))) {
          break label220;
        }
      }
    }
    int j;
    for (;;)
    {
      j = this.h;
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      while (i < localItemsRange.c())
      {
        int k = j;
        if (!a(this.h + i, false))
        {
          k = j;
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
            k = j + 1;
          }
        }
        i += 1;
        j = k;
      }
      bool1 = false;
      break;
      f();
      bool1 = true;
      break label47;
      label214:
      bool2 = false;
      break label86;
      label220:
      this.h = i;
      i -= 1;
      break label117;
      label232:
      this.h = localItemsRange.a();
    }
    this.h = j;
    return bool2;
  }
  
  private int c()
  {
    if (this.f != 0) {
      return this.f;
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != null))
    {
      this.f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).getHeight();
      return this.f;
    }
    return getHeight() / this.e;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(0, 0, paramInt1 - 20, paramInt2);
  }
  
  private void c(Canvas paramCanvas)
  {
    int i = getHeight() / 2;
    i = (int)(c() / 2 * 1.2D);
  }
  
  private void d() {}
  
  private void e()
  {
    if (b())
    {
      a(getWidth(), 1073741824);
      c(getWidth(), getHeight());
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_ComTencentWidgetWidgetWheelRecycle.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.h, new ItemsRange());
    }
    for (;;)
    {
      int j = this.e / 2;
      int i = this.d + j;
      while (i >= this.d - j)
      {
        if (a(i, true)) {
          this.h = i;
        }
        i -= 1;
      }
      f();
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public WheelViewAdapter a()
  {
    return this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelScrollListener)localIterator.next()).a(this);
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelClickedListener)localIterator.next()).a(this, paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelChangedListener)localIterator.next()).a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(OnWheelChangedListener paramOnWheelChangedListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnWheelChangedListener);
  }
  
  public void a(OnWheelClickedListener paramOnWheelClickedListener)
  {
    this.c.add(paramOnWheelClickedListener);
  }
  
  public void a(OnWheelScrollListener paramOnWheelScrollListener)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramOnWheelScrollListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetWidgetWheelRecycle.a();
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      this.g = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_ComTencentWidgetWidgetWheelRecycle.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.h, new ItemsRange());
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelScrollListener)localIterator.next()).b(this);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = c();
    int j = this.g;
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller.a(i * paramInt1 - j, paramInt2);
  }
  
  public void b(OnWheelChangedListener paramOnWheelChangedListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramOnWheelChangedListener);
  }
  
  public void b(OnWheelClickedListener paramOnWheelClickedListener)
  {
    this.c.remove(paramOnWheelClickedListener);
  }
  
  public void b(OnWheelScrollListener paramOnWheelScrollListener)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramOnWheelScrollListener);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller.a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter != null) && (this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a() > 0))
    {
      e();
      b(paramCanvas);
      c(paramCanvas);
    }
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    g();
    j = a(k, j);
    if (i == 1073741824) {}
    for (;;)
    {
      setMeasuredDimension(j, paramInt1);
      return;
      paramInt2 = a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (i == -2147483648) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isEnabled()) || (a() == null)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        if (getParent() != null) {
          getParent().requestDisallowInterceptTouchEvent(true);
        }
      }
    } while (this.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this);
    }
    int i = (int)paramMotionEvent.getY() - getHeight() / 2;
    if (i > 0) {
      i += c() / 2;
    }
    for (;;)
    {
      i /= c();
      if ((i == 0) || (!a(this.d + i))) {
        break;
      }
      a(i + this.d);
      break;
      i -= c() / 2;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter == null) || (this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a() == 0)) {}
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a();
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < j) {
          break;
        }
      }
    } while (!this.jdField_a_of_type_Boolean);
    while (paramInt < 0) {
      paramInt += j;
    }
    int i = paramInt % j;
    if (paramBoolean)
    {
      paramInt = i - this.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label162;
      }
      i = j + Math.min(i, this.d) - Math.max(i, this.d);
      if (i >= Math.abs(paramInt)) {
        break label162;
      }
      if (paramInt < 0) {
        paramInt = i;
      }
    }
    label162:
    for (;;)
    {
      b(paramInt, 0);
      return;
      paramInt = -i;
      continue;
      this.g = 0;
      paramInt = this.d;
      this.d = i;
      a(paramInt, this.d);
      invalidate();
      return;
    }
  }
  
  public void setCurrentItemCallListner(int paramInt)
  {
    setCurrentItem(paramInt, false);
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller.b();
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(false);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelScroller.a(paramInterpolator);
  }
  
  public void setViewAdapter(WheelViewAdapter paramWheelViewAdapter)
  {
    if (this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter != null) {
      this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.b(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter = paramWheelViewAdapter;
    if (this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter != null) {
      this.jdField_a_of_type_ComTencentWidgetWidgetAdaptersWheelViewAdapter.a(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    a(true);
  }
  
  public void setVisibleItems(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setWheelViewOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.widget.WheelView
 * JD-Core Version:    0.7.0.1
 */