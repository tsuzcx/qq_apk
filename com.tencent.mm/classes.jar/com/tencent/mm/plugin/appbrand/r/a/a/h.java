package com.tencent.mm.plugin.appbrand.r.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Timer;
import java.util.TimerTask;

final class h
{
  int lPB = 0;
  a lPC = null;
  Timer lPD = null;
  
  final void a(final a parama)
  {
    AppMethodBeat.i(176742);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176740);
        h.a(h.this);
        h.this.lPC = parama;
        h.this.lPD = new Timer();
        h.this.lPD.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(176739);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176738);
                ac.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                h localh = h.this;
                localh.lPB += 1;
                if (h.this.lPB > 3)
                {
                  if (h.this.lPC != null) {
                    h.this.lPC.bsL();
                  }
                  h.this.lPD.cancel();
                  AppMethodBeat.o(176738);
                  return;
                }
                if (h.this.lPC != null) {
                  h.this.lPC.bsM();
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
  
  final void bsN()
  {
    AppMethodBeat.i(176743);
    ac.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176741);
        ac.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
        h.a(h.this);
        AppMethodBeat.o(176741);
      }
    });
    AppMethodBeat.o(176743);
  }
  
  static abstract interface a
  {
    public abstract void bsL();
    
    public abstract void bsM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.h
 * JD-Core Version:    0.7.0.1
 */