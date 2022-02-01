package com.tencent.i.a.c.c.a;

import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.b.c.b.a;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
  extends a
{
  private MotionEvent.PointerCoords SsQ;
  private final d SsR;
  private AtomicBoolean SsV;
  private AtomicBoolean SsW;
  com.tencent.h.a.a SsX;
  
  public g(c paramc, com.tencent.i.a.b.c.a.b paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(214788);
    this.SsV = new AtomicBoolean(false);
    this.SsR = new d(null, new d.a());
    this.SsQ = new MotionEvent.PointerCoords();
    this.SsW = new AtomicBoolean(false);
    this.SsX = new com.tencent.h.a.a()
    {
      public final void boF()
      {
        AppMethodBeat.i(214787);
        h.i("sensor_SingleTouch", "[method: run ] mTimeLimitRunnable " + g.this.SsX);
        if (g.this.SsB != null) {
          g.this.SsB.hqg();
        }
        AppMethodBeat.o(214787);
      }
    };
    h.i("sensor_SingleTouch", "[method: SingleTouch ] " + this.SsX);
    AppMethodBeat.o(214788);
  }
  
  private void a(int paramInt, i parami)
  {
    AppMethodBeat.i(214793);
    parami.Ssz = this.SsR.SsJ.asD(paramInt);
    AppMethodBeat.o(214793);
  }
  
  private void a(b.a parama, int paramInt, i parami)
  {
    AppMethodBeat.i(214794);
    if (parama != null)
    {
      a(paramInt, parami);
      h.i("sensor_SingleTouch", "[method: onCallBack ] info : " + parami.Ssz);
      parama.b(parami);
    }
    AppMethodBeat.o(214794);
  }
  
  private void hqD()
  {
    AppMethodBeat.i(214790);
    h.i("sensor_SingleTouch", "[method: cancelRunnable ] ");
    if (this.SsR.SsJ.hqA() <= 0)
    {
      h.i("sensor_SingleTouch", "[method: cancelRunnable remove] ");
      hqE();
      resetFlag();
    }
    AppMethodBeat.o(214790);
  }
  
  private void hqE()
  {
    AppMethodBeat.i(214791);
    h.i("sensor_SingleTouch", "[method: removeMaxDurationRunnable ] " + this.SsX);
    if (this.SsE != null) {
      this.SsE.hqz().removeCallbacks(this.SsX);
    }
    AppMethodBeat.o(214791);
  }
  
  private void resetFlag()
  {
    AppMethodBeat.i(214792);
    this.SsW.set(false);
    this.SsV.set(false);
    AppMethodBeat.o(214792);
  }
  
  protected final void a(MotionEvent paramMotionEvent, b.a parama)
  {
    int i = 0;
    AppMethodBeat.i(214789);
    int j = paramMotionEvent.getActionIndex();
    int k = paramMotionEvent.getPointerId(j);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(214789);
      return;
      paramMotionEvent.getPointerCoords(j, this.SsQ);
      paramMotionEvent = a(1, paramMotionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
      if (this.SsB != null)
      {
        boolean bool = this.SsB.YY();
        h.i("sensor_SingleTouch", "[method: resumeEngine ] ".concat(String.valueOf(bool)));
        if ((bool) && (this.SsV.compareAndSet(false, true)))
        {
          h.i("sensor_SingleTouch", "[method: resumeEngine ] start resume");
          this.SsB.hqe();
        }
      }
      if (this.SsW.compareAndSet(false, true))
      {
        h.i("sensor_SingleTouch", "[method: setMasterDataCallBack ] ");
        hqE();
        h.i("sensor_SingleTouch", "[method: postMaxDurationRunnable ] ");
        if (this.SsB.hqh() == null) {
          break label270;
        }
      }
      label270:
      for (long l = this.SsB.hqh().dyB;; l = 10000L)
      {
        if (this.SsE != null) {
          this.SsE.hqz().postDelayed(this.SsX, l);
        }
        a(parama, k, paramMotionEvent);
        AppMethodBeat.o(214789);
        return;
      }
      while (i < paramMotionEvent.getPointerCount())
      {
        paramMotionEvent.getPointerCoords(i, this.SsQ);
        i locali = a(2, paramMotionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
        a(parama, paramMotionEvent.getPointerId(i), locali);
        i += 1;
      }
      AppMethodBeat.o(214789);
      return;
      paramMotionEvent.getPointerCoords(j, this.SsQ);
      a(parama, k, a(3, paramMotionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size));
      this.SsR.SsJ.asE(k);
      hqD();
      AppMethodBeat.o(214789);
      return;
      paramMotionEvent.getPointerCoords(j, this.SsQ);
      a(parama, k, a(4, paramMotionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size));
      this.SsR.SsJ.asE(k);
      hqD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c.a.g
 * JD-Core Version:    0.7.0.1
 */