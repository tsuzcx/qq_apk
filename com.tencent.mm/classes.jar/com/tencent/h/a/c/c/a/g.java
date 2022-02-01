package com.tencent.h.a.c.c.a;

import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import com.tencent.h.a.a.c;
import com.tencent.h.a.b.c.b.a;
import com.tencent.h.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
  extends a
{
  com.tencent.g.a.a ZUA;
  private MotionEvent.PointerCoords ZUt;
  private final d ZUu;
  private AtomicBoolean ZUy;
  private AtomicBoolean ZUz;
  
  public g(c paramc, com.tencent.h.a.b.c.a.b paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(207544);
    this.ZUy = new AtomicBoolean(false);
    this.ZUu = new d(null, new d.a());
    this.ZUt = new MotionEvent.PointerCoords();
    this.ZUz = new AtomicBoolean(false);
    this.ZUA = new com.tencent.g.a.a()
    {
      public final void byO()
      {
        AppMethodBeat.i(207448);
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: run ] mTimeLimitRunnable " + g.this.ZUA);
        if (g.this.ZUe != null) {
          g.this.ZUe.itN();
        }
        AppMethodBeat.o(207448);
      }
    };
    com.tencent.g.c.i.i("sensor_SingleTouch", "[method: SingleTouch ] " + this.ZUA);
    AppMethodBeat.o(207544);
  }
  
  private void a(int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(207556);
    parami.ZUc = this.ZUu.ZUm.aCr(paramInt);
    AppMethodBeat.o(207556);
  }
  
  private void a(b.a parama, int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(207560);
    if (parama != null)
    {
      a(paramInt, parami);
      com.tencent.g.c.i.i("sensor_SingleTouch", "[method: onCallBack ] info : " + parami.ZUc);
      parama.b(parami);
    }
    AppMethodBeat.o(207560);
  }
  
  private void ium()
  {
    AppMethodBeat.i(207548);
    com.tencent.g.c.i.i("sensor_SingleTouch", "[method: cancelRunnable ] ");
    if (this.ZUu.ZUm.iuj() <= 0)
    {
      com.tencent.g.c.i.i("sensor_SingleTouch", "[method: cancelRunnable remove] ");
      iun();
      resetFlag();
    }
    AppMethodBeat.o(207548);
  }
  
  private void iun()
  {
    AppMethodBeat.i(207551);
    com.tencent.g.c.i.i("sensor_SingleTouch", "[method: removeMaxDurationRunnable ] " + this.ZUA);
    if (this.ZUh != null) {
      this.ZUh.iui().removeCallbacks(this.ZUA);
    }
    AppMethodBeat.o(207551);
  }
  
  private void resetFlag()
  {
    AppMethodBeat.i(207553);
    this.ZUz.set(false);
    this.ZUy.set(false);
    AppMethodBeat.o(207553);
  }
  
  protected final void a(MotionEvent paramMotionEvent, b.a parama)
  {
    int i = 0;
    AppMethodBeat.i(207546);
    int j = paramMotionEvent.getActionIndex();
    int k = paramMotionEvent.getPointerId(j);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207546);
      return;
      paramMotionEvent.getPointerCoords(j, this.ZUt);
      paramMotionEvent = a(1, paramMotionEvent.getEventTime(), this.ZUt.pressure, this.ZUt.size);
      if (this.ZUe != null)
      {
        boolean bool = this.ZUe.adH();
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: resumeEngine ] ".concat(String.valueOf(bool)));
        if ((bool) && (this.ZUy.compareAndSet(false, true)))
        {
          com.tencent.g.c.i.i("sensor_SingleTouch", "[method: resumeEngine ] start resume");
          this.ZUe.itL();
        }
      }
      if (this.ZUz.compareAndSet(false, true))
      {
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: setMasterDataCallBack ] ");
        iun();
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: postMaxDurationRunnable ] ");
        if (this.ZUe.itO() == null) {
          break label270;
        }
      }
      label270:
      for (long l = this.ZUe.itO().frq;; l = 10000L)
      {
        if (this.ZUh != null) {
          this.ZUh.iui().postDelayed(this.ZUA, l);
        }
        a(parama, k, paramMotionEvent);
        AppMethodBeat.o(207546);
        return;
      }
      while (i < paramMotionEvent.getPointerCount())
      {
        paramMotionEvent.getPointerCoords(i, this.ZUt);
        com.tencent.h.a.c.b.i locali = a(2, paramMotionEvent.getEventTime(), this.ZUt.pressure, this.ZUt.size);
        a(parama, paramMotionEvent.getPointerId(i), locali);
        i += 1;
      }
      AppMethodBeat.o(207546);
      return;
      paramMotionEvent.getPointerCoords(j, this.ZUt);
      a(parama, k, a(3, paramMotionEvent.getEventTime(), this.ZUt.pressure, this.ZUt.size));
      this.ZUu.ZUm.aCs(k);
      ium();
      AppMethodBeat.o(207546);
      return;
      paramMotionEvent.getPointerCoords(j, this.ZUt);
      a(parama, k, a(4, paramMotionEvent.getEventTime(), this.ZUt.pressure, this.ZUt.size));
      this.ZUu.ZUm.aCs(k);
      ium();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.g
 * JD-Core Version:    0.7.0.1
 */