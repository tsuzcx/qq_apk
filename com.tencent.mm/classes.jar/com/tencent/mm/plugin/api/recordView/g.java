package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  implements View.OnTouchListener
{
  private long jcj = -1L;
  private float jck = -1.0F;
  private int jcl = 0;
  a jcm;
  
  private float w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89269);
    try
    {
      if (this.jcl >= 2)
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
      ac.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(89269);
    }
    return 0.0F;
  }
  
  public final void a(a parama)
  {
    this.jcm = parama;
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
            ac.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
            if ((this.jcj > 0L) && (SystemClock.elapsedRealtime() - this.jcj < 400L)) {
              if (this.jcm == null) {}
            }
            for (;;)
            {
              this.jcj = SystemClock.elapsedRealtime();
              this.jck = -1.0F;
              this.jcl += 1;
              break;
              if (this.jcm != null) {
                this.jcm.D(paramMotionEvent.getX(), paramMotionEvent.getY());
              }
            }
            ac.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.jcl += 1;
            continue;
            ac.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.jcl -= 1;
            continue;
            ac.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.jck = -1.0F;
            this.jcl = 0;
          }
        } while (this.jcl < 2);
        f = w(paramMotionEvent);
        ac.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.jck <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.jck) <= 15.0F);
    if (f > this.jck)
    {
      ac.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.jcm != null) {
        this.jcm.aSi();
      }
    }
    for (;;)
    {
      this.jck = f;
      break;
      ac.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.jcm != null) {
        this.jcm.aSj();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void D(float paramFloat1, float paramFloat2);
    
    public abstract void aSi();
    
    public abstract void aSj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */