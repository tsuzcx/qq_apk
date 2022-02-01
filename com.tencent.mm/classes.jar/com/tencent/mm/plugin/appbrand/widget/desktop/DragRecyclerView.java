package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class DragRecyclerView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private GestureDetector kVo;
  boolean mxR = false;
  DragFeatureView mxY;
  
  public DragRecyclerView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DragRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DragRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.kVo = new GestureDetector(paramContext, this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    this.kVo.onTouchEvent(paramMotionEvent);
    if (this.mxR)
    {
      if (this.mxY != null) {
        this.mxY.onTouch(this, paramMotionEvent);
      }
      int j = paramMotionEvent.getAction();
      paramMotionEvent.setAction(3);
      int i = 0;
      while (i < getChildCount())
      {
        getChildAt(i).dispatchTouchEvent(paramMotionEvent);
        i += 1;
      }
      paramMotionEvent.setAction(j);
    }
    if (paramMotionEvent.getAction() != 3) {
      paramMotionEvent.getAction();
    }
    if ((this.mxR) || (super.dispatchTouchEvent(paramMotionEvent))) {
      bool = true;
    }
    return bool;
  }
  
  public DragFeatureView getDragRubbishView()
  {
    return this.mxY;
  }
  
  public final void l(DragFeatureView paramDragFeatureView)
  {
    this.mxY = paramDragFeatureView;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.mxR) {
      ac.i("DragRecyclerView", "alvinluo onLongPress ignore");
    }
    while (this.mxY == null) {
      return;
    }
    this.mxY.onLongPress(paramMotionEvent);
    if (this.mxY.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mxR = bool;
      return;
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setLongPress(boolean paramBoolean)
  {
    this.mxR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView
 * JD-Core Version:    0.7.0.1
 */