package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.g.b.a.gz;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.e.d;
import com.tencent.mm.plugin.appbrand.launching.aa.e;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public enum j
{
  private volatile boolean jKt = false;
  private volatile com.tencent.mm.cn.f<Void> jKu;
  
  static
  {
    AppMethodBeat.i(44417);
    jKs = new j("INSTANCE");
    jKv = new j[] { jKs };
    AppMethodBeat.o(44417);
  }
  
  private j() {}
  
  public final void bbc()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!com.tencent.mm.kernel.g.ajA().gAD)
        {
          ad.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          if (this.jKu != null) {
            this.jKu.fOb();
          }
          this.jKt = false;
          AppMethodBeat.o(44414);
          return;
        }
        if (this.jKt)
        {
          ad.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(44414);
          continue;
        }
        ad.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.jKt = true;
      this.jKu = com.tencent.mm.cn.g.fSm();
      this.jKu.i(new com.tencent.mm.vending.c.a()
      {
        private Void aYJ()
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
              com.tencent.mm.vending.g.g.fOa().ee(null);
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
      if (this.jKu != null) {
        this.jKu.fOb();
      }
      this.jKt = false;
      AppMethodBeat.o(44415);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.j
 * JD-Core Version:    0.7.0.1
 */