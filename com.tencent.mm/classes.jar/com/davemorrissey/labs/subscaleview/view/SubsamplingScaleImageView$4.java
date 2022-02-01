package com.davemorrissey.labs.subscaleview.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SubsamplingScaleImageView$4
  extends GestureDetector.SimpleOnGestureListener
{
  SubsamplingScaleImageView$4(SubsamplingScaleImageView paramSubsamplingScaleImageView) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213543);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(213543);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213542);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(213542);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213541);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    super.onLongPress(paramMotionEvent);
    a.a(this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(213541);
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157379);
    this.aZm.performClick();
    AppMethodBeat.o(157379);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213540);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(213540);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.4
 * JD-Core Version:    0.7.0.1
 */