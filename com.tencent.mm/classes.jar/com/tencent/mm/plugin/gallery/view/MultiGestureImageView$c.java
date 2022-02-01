package com.tencent.mm.plugin.gallery.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MultiGestureImageView$c
  extends GestureDetector.SimpleOnGestureListener
{
  private MultiGestureImageView$c(MultiGestureImageView paramMultiGestureImageView) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198793);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198793);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198790);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    a.a(true, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198790);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198792);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    super.onLongPress(paramMotionEvent);
    a.a(this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(198792);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198791);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198791);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.c
 * JD-Core Version:    0.7.0.1
 */