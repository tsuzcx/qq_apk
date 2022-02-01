package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  implements View.OnTouchListener
{
  private long jyn = -1L;
  private float jyo = -1.0F;
  private int jyp = 0;
  a jyq;
  
  private float t(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89269);
    try
    {
      if (this.jyp >= 2)
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
      ae.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(89269);
    }
    return 0.0F;
  }
  
  public final void a(a parama)
  {
    this.jyq = parama;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(89268);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
            ae.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
            if ((this.jyn > 0L) && (SystemClock.elapsedRealtime() - this.jyn < 400L)) {
              if (this.jyq == null) {}
            }
            for (;;)
            {
              this.jyn = SystemClock.elapsedRealtime();
              this.jyo = -1.0F;
              this.jyp += 1;
              break;
              if (this.jyq != null) {
                this.jyq.E(paramMotionEvent.getX(), paramMotionEvent.getY());
              }
            }
            ae.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
            this.jyp += 1;
            continue;
            ae.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
            this.jyp -= 1;
            continue;
            ae.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
            this.jyo = -1.0F;
            this.jyp = 0;
          }
        } while (this.jyp < 2);
        f = t(paramMotionEvent);
        ae.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.jyo <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.jyo) <= 15.0F);
    if (f > this.jyo)
    {
      ae.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
      if (this.jyq != null) {
        this.jyq.aVT();
      }
    }
    for (;;)
    {
      this.jyo = f;
      break;
      ae.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
      if (this.jyq != null) {
        this.jyq.aVU();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void E(float paramFloat1, float paramFloat2);
    
    public abstract void aVT();
    
    public abstract void aVU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.g
 * JD-Core Version:    0.7.0.1
 */