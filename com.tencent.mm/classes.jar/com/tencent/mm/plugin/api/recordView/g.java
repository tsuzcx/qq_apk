package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g
  implements View.OnTouchListener
{
  private long gOu = -1L;
  private float gOv = -1.0F;
  private int gOw = 0;
  g.a gOx;
  
  private float x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76385);
    try
    {
      if (this.gOw >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        AppMethodBeat.o(76385);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      ab.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(76385);
    }
    return 0.0F;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76384);
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
            AppMethodBeat.o(76384);
            return true;
            ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
            if ((this.gOu > 0L) && (SystemClock.elapsedRealtime() - this.gOu < 400L)) {
              if (this.gOx == null) {}
            }
            for (;;)
            {
              this.gOu = SystemClock.elapsedRealtime();
              this.gOv = -1.0F;
              this.gOw += 1;
              break;
              if (this.gOx != null)
              {
                paramView = this.gOx;
                paramMotionEvent.getX();
                paramMotionEvent.getY();
                paramView.asP();
              }
            }
            ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.gOw += 1;
            continue;
            ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.gOw -= 1;
            continue;
            ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.gOv = -1.0F;
            this.gOw = 0;
          }
        } while (this.gOw < 2);
        f = x(paramMotionEvent);
        ab.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.gOv <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.gOv) <= 15.0F);
    if (f > this.gOv)
    {
      ab.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.gOx != null) {
        this.gOx.asQ();
      }
    }
    for (;;)
    {
      this.gOv = f;
      break;
      ab.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.gOx != null) {
        this.gOx.asR();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */