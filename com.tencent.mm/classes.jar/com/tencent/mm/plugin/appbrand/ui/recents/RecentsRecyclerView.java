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
  private View oeo;
  
  public RecentsRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49272);
    setChildrenDrawingOrderEnabled(true);
    AppMethodBeat.o(49272);
  }
  
  public RecentsRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49273);
    setChildrenDrawingOrderEnabled(true);
    AppMethodBeat.o(49273);
  }
  
  public RecentsRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49274);
    setChildrenDrawingOrderEnabled(true);
    AppMethodBeat.o(49274);
  }
  
  final void cJ(View paramView)
  {
    AppMethodBeat.i(49279);
    if (paramView.getParent() != this)
    {
      AppMethodBeat.o(49279);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setZ(1.0F);
      AppMethodBeat.o(49279);
      return;
    }
    this.oeo = paramView;
    AppMethodBeat.o(49279);
  }
  
  final void cK(View paramView)
  {
    AppMethodBeat.i(49280);
    if (paramView.getParent() != this)
    {
      AppMethodBeat.o(49280);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setZ(0.0F);
      AppMethodBeat.o(49280);
      return;
    }
    if (this.oeo == paramView) {
      this.oeo = null;
    }
    AppMethodBeat.o(49280);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49277);
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning()))
    {
      AppMethodBeat.o(49277);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(49277);
    return bool;
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49275);
    if (this.oeo == null)
    {
      paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
      AppMethodBeat.o(49275);
      return paramInt1;
    }
    int i = indexOfChild(this.oeo);
    if (i < 0)
    {
      paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
      AppMethodBeat.o(49275);
      return paramInt1;
    }
    if (paramInt2 == paramInt1 - 1)
    {
      AppMethodBeat.o(49275);
      return i;
    }
    if (paramInt2 == i)
    {
      AppMethodBeat.o(49275);
      return paramInt1 - 1;
    }
    paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
    AppMethodBeat.o(49275);
    return paramInt1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49276);
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning()))
    {
      AppMethodBeat.o(49276);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(49276);
    return bool;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49278);
    if ((getItemAnimator() != null) && (getItemAnimator().isRunning()))
    {
      AppMethodBeat.o(49278);
      return false;
    }
    boolean bool;
    try
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(49278);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(3);
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(49278);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.RecentsRecyclerView
 * JD-Core Version:    0.7.0.1
 */