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
  private long kyW = -1L;
  private float kyX = -1.0F;
  private int kyY = 0;
  a kyZ;
  
  private float x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89269);
    try
    {
      if (this.kyY >= 2)
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
  
  public final void a(a parama)
  {
    this.kyZ = parama;
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
            if ((this.kyW > 0L) && (SystemClock.elapsedRealtime() - this.kyW < 400L)) {
              if (this.kyZ == null) {}
            }
            for (;;)
            {
              this.kyW = SystemClock.elapsedRealtime();
              this.kyX = -1.0F;
              this.kyY += 1;
              break;
              if (this.kyZ != null) {
                this.kyZ.I(paramMotionEvent.getX(), paramMotionEvent.getY());
              }
            }
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.kyY += 1;
            continue;
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.kyY -= 1;
            continue;
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.kyX = -1.0F;
            this.kyY = 0;
          }
        } while (this.kyY < 2);
        f = x(paramMotionEvent);
        Log.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.kyX <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.kyX) <= 15.0F);
    if (f > this.kyX)
    {
      Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.kyZ != null) {
        this.kyZ.bqQ();
      }
    }
    for (;;)
    {
      this.kyX = f;
      break;
      Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.kyZ != null) {
        this.kyZ.bqR();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void I(float paramFloat1, float paramFloat2);
    
    public abstract void bqQ();
    
    public abstract void bqR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */