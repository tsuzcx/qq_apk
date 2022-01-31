package com.tencent.mm.plugin.exdevice.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class ExdeviceProfileUI$a
  extends GestureDetector.SimpleOnGestureListener
{
  private ExdeviceProfileUI$a(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) < Math.abs(paramFloat1);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.a
 * JD-Core Version:    0.7.0.1
 */