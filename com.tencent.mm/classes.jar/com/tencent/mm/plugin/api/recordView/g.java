package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  implements View.OnTouchListener
{
  private long jvs = -1L;
  private float jvt = -1.0F;
  private int jvu = 0;
  a jvv;
  
  private float t(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89269);
    try
    {
      if (this.jvu >= 2)
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
    this.jvv = parama;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89268);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
            a.a(true, this, "com/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(89268);
            return true;
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
            if ((this.jvs > 0L) && (SystemClock.elapsedRealtime() - this.jvs < 400L)) {
              if (this.jvv == null) {}
            }
            for (;;)
            {
              this.jvs = SystemClock.elapsedRealtime();
              this.jvt = -1.0F;
              this.jvu += 1;
              break;
              if (this.jvv != null) {
                this.jvv.E(paramMotionEvent.getX(), paramMotionEvent.getY());
              }
            }
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.jvu += 1;
            continue;
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.jvu -= 1;
            continue;
            ad.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.jvt = -1.0F;
            this.jvu = 0;
          }
        } while (this.jvu < 2);
        f = t(paramMotionEvent);
        ad.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.jvt <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.jvt) <= 15.0F);
    if (f > this.jvt)
    {
      ad.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.jvv != null) {
        this.jvv.aVu();
      }
    }
    for (;;)
    {
      this.jvt = f;
      break;
      ad.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.jvv != null) {
        this.jvv.aVv();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void E(float paramFloat1, float paramFloat2);
    
    public abstract void aVu();
    
    public abstract void aVv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */