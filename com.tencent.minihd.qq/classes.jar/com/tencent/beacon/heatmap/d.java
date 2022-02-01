package com.tencent.beacon.heatmap;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public final class d
  extends FrameLayout
{
  private final GestureDetector a;
  
  public d(Context paramContext, GestureDetector paramGestureDetector)
  {
    super(paramContext);
    this.a = paramGestureDetector;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.heatmap.d
 * JD-Core Version:    0.7.0.1
 */