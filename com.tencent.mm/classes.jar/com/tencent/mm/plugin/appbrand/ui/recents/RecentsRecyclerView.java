package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.f;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

class RecentsRecyclerView
  extends LoadMoreRecyclerView
{
  private View hjW;
  
  public RecentsRecyclerView(Context paramContext)
  {
    super(paramContext);
    setChildrenDrawingOrderEnabled(true);
  }
  
  public RecentsRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setChildrenDrawingOrderEnabled(true);
  }
  
  public RecentsRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setChildrenDrawingOrderEnabled(true);
  }
  
  final void bZ(View paramView)
  {
    if (paramView.getParent() != this) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setZ(1.0F);
      return;
    }
    this.hjW = paramView;
  }
  
  final void ca(View paramView)
  {
    if (paramView.getParent() != this) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramView.setZ(0.0F);
        return;
      }
    } while (this.hjW != paramView);
    this.hjW = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning())) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i;
    if (this.hjW == null) {
      i = super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = indexOfChild(this.hjW);
      if (j < 0) {
        return super.getChildDrawingOrder(paramInt1, paramInt2);
      }
      i = j;
    } while (paramInt2 == paramInt1 - 1);
    if (paramInt2 == j) {
      return paramInt1 - 1;
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning())) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning())) {
      return false;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(3);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.RecentsRecyclerView
 * JD-Core Version:    0.7.0.1
 */