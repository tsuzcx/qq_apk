package com.tencent.mm.plugin.exdevice.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.a;

final class ExdeviceProfileUI$26
  implements MMPullDownView.a
{
  ExdeviceProfileUI$26(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179622);
    boolean bool = ExdeviceProfileUI.G(this.peX).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(179622);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.26
 * JD-Core Version:    0.7.0.1
 */