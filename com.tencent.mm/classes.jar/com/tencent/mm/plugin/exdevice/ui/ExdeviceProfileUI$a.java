package com.tencent.mm.plugin.exdevice.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExdeviceProfileUI$a
  extends GestureDetector.SimpleOnGestureListener
{
  private ExdeviceProfileUI$a(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(231702);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(231702);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(231701);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(231701);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(231700);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    super.onLongPress(paramMotionEvent);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(231700);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(24131);
    if (Math.abs(paramFloat2) < Math.abs(paramFloat1))
    {
      AppMethodBeat.o(24131);
      return true;
    }
    AppMethodBeat.o(24131);
    return false;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(231699);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    a.a(true, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(231699);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.a
 * JD-Core Version:    0.7.0.1
 */