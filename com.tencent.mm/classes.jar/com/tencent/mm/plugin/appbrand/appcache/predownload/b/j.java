package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.b;
import kotlin.x;

public enum j
{
  private volatile boolean kPT = false;
  private volatile f<Void> kPU;
  
  static
  {
    AppMethodBeat.i(44417);
    kPS = new j("INSTANCE");
    kPV = new j[] { kPS };
    AppMethodBeat.o(44417);
  }
  
  private j() {}
  
  public final void bwR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!com.tencent.mm.kernel.g.aAf().hpY)
        {
          Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          if (this.kPU != null) {
            this.kPU.hdy();
          }
          this.kPT = false;
          AppMethodBeat.o(44414);
          return;
        }
        if (this.kPT)
        {
          Log.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(44414);
          continue;
        }
        Log.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.kPT = true;
      this.kPU = com.tencent.mm.co.g.hio();
      this.kPU.i(new com.tencent.mm.vending.c.a()
      {
        private Void buw()
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
              com.tencent.mm.vending.g.g.hdx().ej(null);
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
      if (this.kPU != null) {
        this.kPU.hdy();
      }
      this.kPT = false;
      AppMethodBeat.o(44415);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.j
 * JD-Core Version:    0.7.0.1
 */