package com.tencent.mm.plugin.exdevice.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.a;

final class ExdeviceProfileUI$23
  implements MMPullDownView.a
{
  ExdeviceProfileUI$23(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(231698);
    GestureDetector localGestureDetector = ExdeviceProfileUI.A(this.rJu);
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$30", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$30", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(231698);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.23
 * JD-Core Version:    0.7.0.1
 */