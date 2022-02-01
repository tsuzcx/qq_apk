package com.tencent.mm.plugin.appbrand.r.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Timer;
import java.util.TimerTask;

final class h
{
  int mpq = 0;
  a mpr = null;
  Timer mps = null;
  
  final void a(final a parama)
  {
    AppMethodBeat.i(176742);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176740);
        h.a(h.this);
        h.this.mpr = parama;
        h.this.mps = new Timer();
        h.this.mps.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(176739);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176738);
                ad.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                h localh = h.this;
                localh.mpq += 1;
                if (h.this.mpq > 3)
                {
                  if (h.this.mpr != null) {
                    h.this.mpr.bwP();
                  }
                  h.this.mps.cancel();
                  AppMethodBeat.o(176738);
                  return;
                }
                if (h.this.mpr != null) {
                  h.this.mpr.bwQ();
                }
                AppMethodBeat.o(176738);
              }
            });
            AppMethodBeat.o(176739);
          }
        }, 500L, 500L);
        AppMethodBeat.o(176740);
      }
    });
    AppMethodBeat.o(176742);
  }
  
  final void bwR()
  {
    AppMethodBeat.i(176743);
    ad.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176741);
        ad.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
        h.a(h.this);
        AppMethodBeat.o(176741);
      }
    });
    AppMethodBeat.o(176743);
  }
  
  static abstract interface a
  {
    public abstract void bwP();
    
    public abstract void bwQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.h
 * JD-Core Version:    0.7.0.1
 */