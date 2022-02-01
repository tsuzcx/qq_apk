package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class g
{
  MTimerHandler eln;
  int tLW = 0;
  a tLX = null;
  
  final void a(final a parama)
  {
    AppMethodBeat.i(176742);
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176740);
        g.a(g.this);
        g.this.tLX = parama;
        g.this.eln = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(317511);
            Log.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
            g localg = g.this;
            localg.tLW += 1;
            if (g.this.tLW > 3)
            {
              if (g.this.tLX != null) {
                g.this.tLX.onTimeout();
              }
              AppMethodBeat.o(317511);
              return false;
            }
            if (g.this.tLX != null) {
              g.this.tLX.cHV();
            }
            AppMethodBeat.o(317511);
            return true;
          }
        }, true);
        g.this.eln.startTimer(500L, 500L);
        AppMethodBeat.o(176740);
      }
    });
    AppMethodBeat.o(176742);
  }
  
  final void cHW()
  {
    AppMethodBeat.i(176743);
    Log.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176741);
        Log.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
        g.a(g.this);
        AppMethodBeat.o(176741);
      }
    });
    AppMethodBeat.o(176743);
  }
  
  static abstract interface a
  {
    public abstract void cHV();
    
    public abstract void onTimeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.g
 * JD-Core Version:    0.7.0.1
 */