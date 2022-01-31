package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.y;

final class g
  implements View.OnTouchListener
{
  private long fxo = -1L;
  private float fxp = -1.0F;
  private int fxq = 0;
  g.a fxr;
  
  private float s(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.fxq >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      y.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
    }
    return 0.0F;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
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
          return true;
          y.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
          if ((this.fxo > 0L) && (SystemClock.elapsedRealtime() - this.fxo < 400L)) {
            if (this.fxr == null) {}
          }
          for (;;)
          {
            this.fxo = SystemClock.elapsedRealtime();
            this.fxp = -1.0F;
            this.fxq += 1;
            return true;
            if (this.fxr != null)
            {
              paramView = this.fxr;
              paramMotionEvent.getX();
              paramMotionEvent.getY();
              paramView.Zg();
            }
          }
          y.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
          this.fxq += 1;
          return true;
          y.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
          this.fxq -= 1;
          return true;
          y.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
          this.fxp = -1.0F;
          this.fxq = 0;
          return true;
        } while (this.fxq < 2);
        f = s(paramMotionEvent);
        y.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.fxp <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.fxp) <= 15.0F);
    if (f > this.fxp)
    {
      y.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.fxr != null) {
        this.fxr.Zh();
      }
    }
    for (;;)
    {
      this.fxp = f;
      return true;
      y.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.fxr != null) {
        this.fxr.Zi();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */