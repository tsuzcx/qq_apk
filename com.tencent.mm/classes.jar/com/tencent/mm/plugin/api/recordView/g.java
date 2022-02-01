package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  implements View.OnTouchListener
{
  private long iCi = -1L;
  private float iCj = -1.0F;
  private int iCk = 0;
  a iCl;
  
  private float y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89269);
    try
    {
      if (this.iCk >= 2)
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
      ad.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(89269);
    }
    return 0.0F;
  }
  
  public final void a(a parama)
  {
    this.iCl = parama;
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
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
            if ((this.iCi > 0L) && (SystemClock.elapsedRealtime() - this.iCi < 400L)) {
              if (this.iCl == null) {}
            }
            for (;;)
            {
              this.iCi = SystemClock.elapsedRealtime();
              this.iCj = -1.0F;
              this.iCk += 1;
              break;
              if (this.iCl != null) {
                this.iCl.A(paramMotionEvent.getX(), paramMotionEvent.getY());
              }
            }
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.iCk += 1;
            continue;
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.iCk -= 1;
            continue;
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.iCj = -1.0F;
            this.iCk = 0;
          }
        } while (this.iCk < 2);
        f = y(paramMotionEvent);
        ad.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.iCj <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.iCj) <= 15.0F);
    if (f > this.iCj)
    {
      ad.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.iCl != null) {
        this.iCl.aLr();
      }
    }
    for (;;)
    {
      this.iCj = f;
      break;
      ad.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.iCl != null) {
        this.iCl.aLs();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void A(float paramFloat1, float paramFloat2);
    
    public abstract void aLr();
    
    public abstract void aLs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */