package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.g.b.a.eg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.e.d;
import com.tencent.mm.plugin.appbrand.launching.aa.e;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public enum j
{
  private volatile boolean iQp = false;
  private volatile com.tencent.mm.co.f<Void> iQq;
  
  static
  {
    AppMethodBeat.i(44417);
    iQo = new j("INSTANCE");
    iQr = new j[] { iQo };
    AppMethodBeat.o(44417);
  }
  
  private j() {}
  
  public final void aQJ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!com.tencent.mm.kernel.g.afz().gcn)
        {
          ad.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          if (this.iQq != null) {
            this.iQq.fhm();
          }
          this.iQp = false;
          AppMethodBeat.o(44414);
          return;
        }
        if (this.iQp)
        {
          ad.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(44414);
          continue;
        }
        ad.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.iQp = true;
      this.iQq = com.tencent.mm.co.g.fkM();
      this.iQq.i(new com.tencent.mm.vending.c.a()
      {
        private Void aOw()
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
              ad.printErrStackTrace("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", localThrowable, "handleRetry()", new Object[0]);
              com.tencent.mm.vending.g.g.fhl().ea(null);
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
      if (this.iQq != null) {
        this.iQq.fhm();
      }
      this.iQp = false;
      AppMethodBeat.o(44415);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.j
 * JD-Core Version:    0.7.0.1
 */