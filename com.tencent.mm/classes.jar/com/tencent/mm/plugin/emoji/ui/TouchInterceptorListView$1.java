package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;

final class TouchInterceptorListView$1
  extends GestureDetector.SimpleOnGestureListener
{
  TouchInterceptorListView$1(TouchInterceptorListView paramTouchInterceptorListView) {}
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (TouchInterceptorListView.a(this.jfv) != null)
    {
      if (paramFloat1 > 1000.0F)
      {
        paramMotionEvent1 = TouchInterceptorListView.b(this.jfv);
        TouchInterceptorListView.a(this.jfv).getDrawingRect(paramMotionEvent1);
        if (paramMotionEvent2.getX() > paramMotionEvent1.right * 2 / 3)
        {
          TouchInterceptorListView.c(this.jfv);
          TouchInterceptorListView.d(this.jfv);
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView.1
 * JD-Core Version:    0.7.0.1
 */