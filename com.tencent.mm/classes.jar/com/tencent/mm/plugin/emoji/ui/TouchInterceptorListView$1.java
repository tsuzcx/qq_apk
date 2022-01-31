package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TouchInterceptorListView$1
  extends GestureDetector.SimpleOnGestureListener
{
  TouchInterceptorListView$1(TouchInterceptorListView paramTouchInterceptorListView) {}
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(53526);
    if (TouchInterceptorListView.a(this.lon) != null)
    {
      if (paramFloat1 > 1000.0F)
      {
        paramMotionEvent1 = TouchInterceptorListView.b(this.lon);
        TouchInterceptorListView.a(this.lon).getDrawingRect(paramMotionEvent1);
        if (paramMotionEvent2.getX() > paramMotionEvent1.right * 2 / 3)
        {
          TouchInterceptorListView.c(this.lon);
          TouchInterceptorListView.e(this.lon);
          TouchInterceptorListView.d(this.lon);
          TouchInterceptorListView.f(this.lon);
        }
      }
      AppMethodBeat.o(53526);
      return true;
    }
    AppMethodBeat.o(53526);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView.1
 * JD-Core Version:    0.7.0.1
 */