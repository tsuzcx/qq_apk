package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.widget.pulltorefresh.library.internal.EmptyViewMethodAccessor;

public class PullToRefreshListView$InternalListView
  extends ListView
  implements EmptyViewMethodAccessor
{
  private boolean jdField_a_of_type_Boolean = false;
  
  public PullToRefreshListView$InternalListView(PullToRefreshListView paramPullToRefreshListView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (IndexOutOfBoundsException paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IndexOutOfBoundsException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((PullToRefreshListView.a(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshListView) != null) && (!this.jdField_a_of_type_Boolean))
    {
      addFooterView(PullToRefreshListView.a(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshListView), null, false);
      this.jdField_a_of_type_Boolean = true;
    }
    super.setAdapter(paramListAdapter);
  }
  
  public void setEmptyView(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshListView.setEmptyView(paramView);
  }
  
  public void setEmptyViewInternal(View paramView)
  {
    super.setEmptyView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshListView.InternalListView
 * JD-Core Version:    0.7.0.1
 */