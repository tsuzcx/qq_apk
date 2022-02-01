package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.e.d;
import com.tencent.mm.plugin.appbrand.launching.aa.e;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public enum j
{
  private volatile boolean jNF = false;
  private volatile com.tencent.mm.cm.f<Void> jNG;
  
  static
  {
    AppMethodBeat.i(44417);
    jNE = new j("INSTANCE");
    jNH = new j[] { jNE };
    AppMethodBeat.o(44417);
  }
  
  private j() {}
  
  public final void bbE()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!com.tencent.mm.kernel.g.ajP().gDk)
        {
          ae.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          if (this.jNG != null) {
            this.jNG.fSw();
          }
          this.jNF = false;
          AppMethodBeat.o(44414);
          return;
        }
        if (this.jNF)
        {
          ae.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(44414);
          continue;
        }
        ae.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.jNF = true;
      this.jNG = com.tencent.mm.cm.g.fWL();
      this.jNG.i(new com.tencent.mm.vending.c.a()
      {
        private Void aZf()
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
              ae.printErrStackTrace("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", localThrowable, "handleRetry()", new Object[0]);
              com.tencent.mm.vending.g.g.fSv().ef(null);
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
      if (this.jNG != null) {
        this.jNG.fSw();
      }
      this.jNF = false;
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