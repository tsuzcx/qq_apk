package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.os.Looper;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class h
{
  MTimerHandler cts;
  int qHm = 0;
  a qHn = null;
  
  final void a(final a parama)
  {
    AppMethodBeat.i(176742);
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176740);
        h.a(h.this);
        h.this.qHn = parama;
        h.this.cts = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(244342);
            Log.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
            h localh = h.this;
            localh.qHm += 1;
            if (h.this.qHm > 3)
            {
              if (h.this.qHn != null) {
                h.this.qHn.onTimeout();
              }
              AppMethodBeat.o(244342);
              return false;
            }
            if (h.this.qHn != null) {
              h.this.qHn.cgY();
            }
            AppMethodBeat.o(244342);
            return true;
          }
        }, true);
        h.this.cts.startTimer(500L, 500L);
        AppMethodBeat.o(176740);
      }
    });
    AppMethodBeat.o(176742);
  }
  
  final void cgZ()
  {
    AppMethodBeat.i(176743);
    Log.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176741);
        Log.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
        h.a(h.this);
        AppMethodBeat.o(176741);
      }
    });
    AppMethodBeat.o(176743);
  }
  
  static abstract interface a
  {
    public abstract void cgY();
    
    public abstract void onTimeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.h
 * JD-Core Version:    0.7.0.1
 */