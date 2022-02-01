package com.tencent.mm.plugin.appbrand.platform.window.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.Timer;
import java.util.TimerTask;

final class h
{
  int mur = 0;
  a mus = null;
  Timer mut = null;
  
  final void a(final a parama)
  {
    AppMethodBeat.i(176742);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176740);
        h.a(h.this);
        h.this.mus = parama;
        h.this.mut = new Timer();
        h.this.mut.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(176739);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176738);
                ae.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                h localh = h.this;
                localh.mur += 1;
                if (h.this.mur > 3)
                {
                  if (h.this.mus != null) {
                    h.this.mus.bxH();
                  }
                  h.this.mut.cancel();
                  AppMethodBeat.o(176738);
                  return;
                }
                if (h.this.mus != null) {
                  h.this.mus.bxI();
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
  
  final void bxJ()
  {
    AppMethodBeat.i(176743);
    ae.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176741);
        ae.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
        h.a(h.this);
        AppMethodBeat.o(176741);
      }
    });
    AppMethodBeat.o(176743);
  }
  
  static abstract interface a
  {
    public abstract void bxH();
    
    public abstract void bxI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.h
 * JD-Core Version:    0.7.0.1
 */