package com.tencent.mm.plugin.exdevice.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceProfileUI$a
  extends GestureDetector.SimpleOnGestureListener
{
  private ExdeviceProfileUI$a(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.a
 * JD-Core Version:    0.7.0.1
 */