package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.x;

public enum j
{
  private volatile boolean nJY = false;
  private volatile f<Void> nJZ;
  
  static
  {
    AppMethodBeat.i(44417);
    nJX = new j("INSTANCE");
    nKa = new j[] { nJX };
    AppMethodBeat.o(44417);
  }
  
  private j() {}
  
  public final void bHY()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!h.aHE().kbT)
        {
          Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          if (this.nJZ != null) {
            this.nJZ.ieF();
          }
          this.nJY = false;
          AppMethodBeat.o(44414);
          return;
        }
        if (this.nJY)
        {
          Log.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(44414);
          continue;
        }
        Log.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.nJY = true;
      this.nJZ = com.tencent.mm.cw.g.ijP();
      this.nJZ.i(new com.tencent.mm.vending.c.a()
      {
        private Void bFz()
        {
          AppMethodBeat.i(44404);
          try
          {
            j.a(j.this);
            AppMethodBeat.o(44404);
            return null;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", localThrowable, "handleRetry()", new Object[0]);
              com.tencent.mm.vending.g.g.ieE().eo(null);
              synchronized (j.this)
              {
                j.b(j.this);
              }
            }
          }
        }
      });
      AppMethodBeat.o(44414);
    }
  }
  
  public final void cleanup()
  {
    try
    {
      AppMethodBeat.i(44415);
      if (this.nJZ != null) {
        this.nJZ.ieF();
      }
      this.nJY = false;
      AppMethodBeat.o(44415);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.j
 * JD-Core Version:    0.7.0.1
 */