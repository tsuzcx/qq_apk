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
  private MotionEvent.PointerCoords ahYT;
  private final d ahYU;
  private AtomicBoolean ahYY;
  private AtomicBoolean ahYZ;
  com.tencent.g.a.a ahZa;
  
  public g(c paramc, com.tencent.h.a.b.c.a.b paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(212231);
    this.ahYY = new AtomicBoolean(false);
    this.ahYU = new d(null, new d.a());
    this.ahYT = new MotionEvent.PointerCoords();
    this.ahYZ = new AtomicBoolean(false);
    this.ahZa = new com.tencent.g.a.a()
    {
      public final void bXC()
      {
        AppMethodBeat.i(212236);
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: run ] mTimeLimitRunnable " + g.this.ahZa);
        if (g.this.ahYE != null) {
          g.this.ahYE.kdj();
        }
        AppMethodBeat.o(212236);
      }
    };
    com.tencent.g.c.i.i("sensor_SingleTouch", "[method: SingleTouch ] " + this.ahZa);
    AppMethodBeat.o(212231);
  }
  
  private void a(int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(212257);
    parami.ahYC = this.ahYU.ahYM.aJe(paramInt);
    AppMethodBeat.o(212257);
  }
  
  private void a(b.a parama, int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(212263);
    if (parama != null)
    {
      a(paramInt, parami);
      com.tencent.g.c.i.i("sensor_SingleTouch", "[method: onCallBack ] info : " + parami.ahYC);
      parama.b(parami);
    }
    AppMethodBeat.o(212263);
  }
  
  private void kdI()
  {
    AppMethodBeat.i(212240);
    com.tencent.g.c.i.i("sensor_SingleTouch", "[method: cancelRunnable ] ");
    if (this.ahYU.ahYM.kdF() <= 0)
    {
      com.tencent.g.c.i.i("sensor_SingleTouch", "[method: cancelRunnable remove] ");
      kdJ();
      resetFlag();
    }
    AppMethodBeat.o(212240);
  }
  
  private void kdJ()
  {
    AppMethodBeat.i(212245);
    com.tencent.g.c.i.i("sensor_SingleTouch", "[method: removeMaxDurationRunnable ] " + this.ahZa);
    if ((this.ahYH != null) && (this.ahYH.kdE() != null)) {
      this.ahYH.kdE().removeCallbacks(this.ahZa);
    }
    AppMethodBeat.o(212245);
  }
  
  private void resetFlag()
  {
    AppMethodBeat.i(212253);
    this.ahYZ.set(false);
    this.ahYY.set(false);
    AppMethodBeat.o(212253);
  }
  
  protected final void a(MotionEvent paramMotionEvent, b.a parama)
  {
    int i = 0;
    AppMethodBeat.i(212272);
    int j = paramMotionEvent.getActionIndex();
    int k = paramMotionEvent.getPointerId(j);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212272);
      return;
      paramMotionEvent.getPointerCoords(j, this.ahYT);
      paramMotionEvent = a(1, paramMotionEvent.getEventTime(), this.ahYT.pressure, this.ahYT.size);
      if (this.ahYE != null)
      {
        boolean bool = this.ahYE.aFF();
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: resumeEngine ] ".concat(String.valueOf(bool)));
        if ((bool) && (this.ahYY.compareAndSet(false, true)))
        {
          com.tencent.g.c.i.i("sensor_SingleTouch", "[method: resumeEngine ] start resume");
          this.ahYE.kdh();
        }
      }
      if (this.ahYZ.compareAndSet(false, true))
      {
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: setMasterDataCallBack ] ");
        kdJ();
        com.tencent.g.c.i.i("sensor_SingleTouch", "[method: postMaxDurationRunnable ] ");
        if (this.ahYE.kdk() == null) {
          break label282;
        }
      }
      label282:
      for (long l = this.ahYE.kdk().hvz;; l = 10000L)
      {
        if ((this.ahYH != null) && (this.ahYH.kdE() != null)) {
          this.ahYH.kdE().postDelayed(this.ahZa, l);
        }
        a(parama, k, paramMotionEvent);
        AppMethodBeat.o(212272);
        return;
      }
      while (i < paramMotionEvent.getPointerCount())
      {
        paramMotionEvent.getPointerCoords(i, this.ahYT);
        com.tencent.h.a.c.b.i locali = a(2, paramMotionEvent.getEventTime(), this.ahYT.pressure, this.ahYT.size);
        a(parama, paramMotionEvent.getPointerId(i), locali);
        i += 1;
      }
      AppMethodBeat.o(212272);
      return;
      paramMotionEvent.getPointerCoords(j, this.ahYT);
      a(parama, k, a(3, paramMotionEvent.getEventTime(), this.ahYT.pressure, this.ahYT.size));
      this.ahYU.ahYM.aJf(k);
      kdI();
      AppMethodBeat.o(212272);
      return;
      paramMotionEvent.getPointerCoords(j, this.ahYT);
      a(parama, k, a(4, paramMotionEvent.getEventTime(), this.ahYT.pressure, this.ahYT.size));
      this.ahYU.ahYM.aJf(k);
      kdI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.g
 * JD-Core Version:    0.7.0.1
 */