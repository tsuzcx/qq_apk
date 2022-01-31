package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.f;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

class RecentsRecyclerView
  extends LoadMoreRecyclerView
{
  private View iVD;
  
  public RecentsRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133544);
    setChildrenDrawingOrderEnabled(true);
    AppMethodBeat.o(133544);
  }
  
  public RecentsRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133545);
    setChildrenDrawingOrderEnabled(true);
    AppMethodBeat.o(133545);
  }
  
  public RecentsRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133546);
    setChildrenDrawingOrderEnabled(true);
    AppMethodBeat.o(133546);
  }
  
  final void cC(View paramView)
  {
    AppMethodBeat.i(133551);
    if (paramView.getParent() != this)
    {
      AppMethodBeat.o(133551);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setZ(1.0F);
      AppMethodBeat.o(133551);
      return;
    }
    this.iVD = paramView;
    AppMethodBeat.o(133551);
  }
  
  final void cD(View paramView)
  {
    AppMethodBeat.i(133552);
    if (paramView.getParent() != this)
    {
      AppMethodBeat.o(133552);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setZ(0.0F);
      AppMethodBeat.o(133552);
      return;
    }
    if (this.iVD == paramView) {
      this.iVD = null;
    }
    AppMethodBeat.o(133552);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133549);
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning()))
    {
      AppMethodBeat.o(133549);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(133549);
    return bool;
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133547);
    if (this.iVD == null)
    {
      paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
      AppMethodBeat.o(133547);
      return paramInt1;
    }
    int i = indexOfChild(this.iVD);
    if (i < 0)
    {
      paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
      AppMethodBeat.o(133547);
      return paramInt1;
    }
    if (paramInt2 == paramInt1 - 1)
    {
      AppMethodBeat.o(133547);
      return i;
    }
    if (paramInt2 == i)
    {
      AppMethodBeat.o(133547);
      return paramInt1 - 1;
    }
    paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
    AppMethodBeat.o(133547);
    return paramInt1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133548);
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning()))
    {
      AppMethodBeat.o(133548);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(133548);
    return bool;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133550);
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning()))
    {
      AppMethodBeat.o(133550);
      return false;
    }
    boolean bool;
    try
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(133550);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(3);
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(133550);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.RecentsRecyclerView
 * JD-Core Version:    0.7.0.1
 */