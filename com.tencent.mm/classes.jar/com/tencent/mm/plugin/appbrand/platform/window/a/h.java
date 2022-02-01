package com.tencent.mm.plugin.appbrand.platform.window.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Timer;
import java.util.TimerTask;

final class h
{
  int nFa = 0;
  a nFb = null;
  Timer nFc = null;
  
  final void a(final a parama)
  {
    AppMethodBeat.i(176742);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176740);
        h.a(h.this);
        h.this.nFb = parama;
        h.this.nFc = new Timer();
        h.this.nFc.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(176739);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176738);
                Log.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                h localh = h.this;
                localh.nFa += 1;
                if (h.this.nFa > 3)
                {
                  if (h.this.nFb != null) {
                    h.this.nFb.bTS();
                  }
                  h.this.nFc.cancel();
                  AppMethodBeat.o(176738);
                  return;
                }
                if (h.this.nFb != null) {
                  h.this.nFb.bTT();
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
  
  final void bTU()
  {
    AppMethodBeat.i(176743);
    Log.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    MMHandlerThread.postToMainThread(new Runnable()
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
    public abstract void bTS();
    
    public abstract void bTT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.h
 * JD-Core Version:    0.7.0.1
 */