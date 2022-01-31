package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public abstract class DragRecyclerView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private GestureDetector gEU;
  DragFeatureView hqY;
  private boolean hqZ = false;
  
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
    this.gEU = new GestureDetector(paramContext, this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    this.gEU.onTouchEvent(paramMotionEvent);
    if (this.hqZ)
    {
      this.hqY.onTouch(this, paramMotionEvent);
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
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      this.hqZ = false;
    }
    if ((this.hqZ) || (super.dispatchTouchEvent(paramMotionEvent))) {
      bool = true;
    }
    return bool;
  }
  
  public DragFeatureView getDragRubbishView()
  {
    return this.hqY;
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
    this.hqY.onLongPress(paramMotionEvent);
    if (this.hqY.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hqZ = bool;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView
 * JD-Core Version:    0.7.0.1
 */