package com.tencent.mm.live.core.view;

import android.graphics.Point;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.bf;

final class b$1
  extends GestureDetector.SimpleOnGestureListener
{
  b$1(b paramb) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247560);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(247560);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247552);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(247552);
    return bool;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247542);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    super.onLongPress(paramMotionEvent);
    a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(247542);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(247533);
    if (!b.b(this.mXn))
    {
      AppMethodBeat.o(247533);
      return false;
    }
    if ((this.mXn.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mXn.getLayoutParams();
      int j = (int)(localLayoutParams.leftMargin + (paramMotionEvent2.getX() - paramMotionEvent1.getX()));
      int i = (int)(localLayoutParams.topMargin + (paramMotionEvent2.getY() - paramMotionEvent1.getY()));
      j = Math.max(Math.min(bf.bf(this.mXn.getContext()).x - this.mXn.getWidth(), j), 0);
      i = Math.max(Math.min(bf.bf(this.mXn.getContext()).y - this.mXn.getHeight(), i), 0);
      localLayoutParams.leftMargin = j;
      localLayoutParams.topMargin = i;
      this.mXn.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(247533);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247515);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    if (b.a(this.mXn) != null) {
      b.a(this.mXn).onClick(this.mXn);
    }
    a.a(true, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(247515);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.view.b.1
 * JD-Core Version:    0.7.0.1
 */