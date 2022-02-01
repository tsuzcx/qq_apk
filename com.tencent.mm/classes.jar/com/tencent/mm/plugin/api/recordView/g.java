package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  implements View.OnTouchListener
{
  private float nwV = -1.0F;
  private int pointerCount = 0;
  private long qqD = -1L;
  public a qqE;
  
  private float x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89269);
    try
    {
      if (this.pointerCount >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        AppMethodBeat.o(89269);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      Log.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(89269);
    }
    return 0.0F;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89268);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    float f;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(89268);
            return true;
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
            if ((this.qqD > 0L) && (SystemClock.elapsedRealtime() - this.qqD < 400L)) {
              if (this.qqE == null) {}
            }
            for (;;)
            {
              this.qqD = SystemClock.elapsedRealtime();
              this.nwV = -1.0F;
              this.pointerCount += 1;
              break;
              if (this.qqE != null) {
                this.qqE.al(paramMotionEvent.getX(), paramMotionEvent.getY());
              }
            }
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.pointerCount += 1;
            continue;
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.pointerCount -= 1;
            continue;
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.nwV = -1.0F;
            this.pointerCount = 0;
          }
        } while (this.pointerCount < 2);
        f = x(paramMotionEvent);
        Log.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.nwV <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.nwV) <= 15.0F);
    if (f > this.nwV)
    {
      Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.qqE != null) {
        this.qqE.bof();
      }
    }
    for (;;)
    {
      this.nwV = f;
      break;
      Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.qqE != null) {
        this.qqE.bog();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void al(float paramFloat1, float paramFloat2);
    
    public abstract void bof();
    
    public abstract void bog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */