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
  private long nrW = -1L;
  private float nrX = -1.0F;
  private int nrY = 0;
  a nrZ;
  
  private float y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89269);
    try
    {
      if (this.nrY >= 2)
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
    this.nrZ = parama;
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
            if ((this.nrW > 0L) && (SystemClock.elapsedRealtime() - this.nrW < 400L)) {
              if (this.nrZ == null) {}
            }
            for (;;)
            {
              this.nrW = SystemClock.elapsedRealtime();
              this.nrX = -1.0F;
              this.nrY += 1;
              break;
              if (this.nrZ != null) {
                this.nrZ.J(paramMotionEvent.getX(), paramMotionEvent.getY());
              }
            }
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.nrY += 1;
            continue;
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.nrY -= 1;
            continue;
            Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.nrX = -1.0F;
            this.nrY = 0;
          }
        } while (this.nrY < 2);
        f = y(paramMotionEvent);
        Log.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.nrX <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.nrX) <= 15.0F);
    if (f > this.nrX)
    {
      Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.nrZ != null) {
        this.nrZ.bBF();
      }
    }
    for (;;)
    {
      this.nrX = f;
      break;
      Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.nrZ != null) {
        this.nrZ.bBG();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void J(float paramFloat1, float paramFloat2);
    
    public abstract void bBF();
    
    public abstract void bBG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */