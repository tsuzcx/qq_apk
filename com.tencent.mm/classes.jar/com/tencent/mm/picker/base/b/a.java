package com.tencent.mm.picker.base.b;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class a
  extends GestureDetector.SimpleOnGestureListener
{
  private final WheelView irq;
  
  public a(WheelView paramWheelView)
  {
    this.irq = paramWheelView;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(175295);
    paramMotionEvent1 = this.irq;
    paramMotionEvent1.aMF();
    paramMotionEvent1.irF = paramMotionEvent1.irE.scheduleWithFixedDelay(new com.tencent.mm.picker.base.c.a(paramMotionEvent1, paramFloat2), 0L, 5L, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(175295);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.b.a
 * JD-Core Version:    0.7.0.1
 */