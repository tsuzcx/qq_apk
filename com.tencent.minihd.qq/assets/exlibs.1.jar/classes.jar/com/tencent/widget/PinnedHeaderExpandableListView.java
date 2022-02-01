package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import com.tencent.qphone.base.util.QLog;
import lsq;

public class PinnedHeaderExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private static final int jdField_a_of_type_Int = -1;
  private static final int jdField_b_of_type_Int = 0;
  private static final int g = 1;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private View jdField_a_of_type_AndroidViewView = null;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  private ExpandableListView.OnGroupClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = null;
  private PinnedHeaderExpandableListView.ExpandableListAdapter jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = null;
  private PinnedHeaderExpandableListView.OnLayoutListener jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean;
  private int h = 0;
  private int i = 0;
  private int j = -1;
  
  public PinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    this.b = false;
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = false;
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = false;
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int k = b(b(paramInt));
    View localView;
    if (k != 2) {
      if (k == 0) {
        if ((b(b(paramInt + 1)) == 0) || (b(b(paramInt + 1)) == 2))
        {
          this.h = -1;
          if (this.h == -1) {
            break label294;
          }
          if (this.h != 1) {
            break label286;
          }
          localView = getChildAt(1);
          int m = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          if (localView == null) {
            break label281;
          }
          k = localView.getTop();
          label93:
          this.i = (m - k);
          label101:
          paramInt = c(b(paramInt));
          if ((paramInt != this.j) || (paramBoolean) || (this.b))
          {
            this.b = false;
            this.j = paramInt;
            this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, paramInt);
            paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
            k = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
            this.jdField_a_of_type_AndroidViewView.measure(paramInt, k);
            this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
          }
        }
      }
    }
    for (;;)
    {
      return;
      this.h = 0;
      break;
      if (getChildAt(0).getBottom() > this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())
      {
        this.h = 0;
        break;
      }
      if (b(b(paramInt + 1)) == 0)
      {
        this.h = 1;
        break;
      }
      this.h = 0;
      break;
      this.h = -1;
      break;
      label281:
      k = 0;
      break label93;
      label286:
      this.i = 0;
      break label101;
      label294:
      if (paramBoolean) {
        this.b = true;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a())
      {
        k = getChildCount();
        paramInt = 0;
        while (paramInt < k)
        {
          localView = getChildAt(paramInt);
          if ((!c(localView)) && (localView != null) && (localView.getVisibility() != 0)) {
            localView.setVisibility(0);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  private void c(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int k = 0;
      while (k < localViewGroup.getChildCount())
      {
        c(localViewGroup.getChildAt(k));
        k += 1;
      }
    }
    paramView.refreshDrawableState();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    try
    {
      a(s(), false);
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("XListView", 2, "configHeaderView crash" + localException);
      }
    }
  }
  
  public View d()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.jdField_a_of_type_Boolean = false;
        }
        return bool;
      }
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (f1 >= 0.0F) && (f1 <= this.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.i) && (paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      c(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    try
    {
      a(s(), true);
      if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener != null) {
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("XListView", 2, "configHeaderView crash" + localException);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int k = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a();
      if (k != 0)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(k, this, false);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new lsq(this));
        }
        requestLayout();
      }
    }
  }
  
  public void setHeaderViewBgColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt);
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeaderExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */