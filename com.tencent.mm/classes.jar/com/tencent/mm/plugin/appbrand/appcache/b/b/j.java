package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.fw;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.e.d;
import com.tencent.mm.plugin.appbrand.launching.aa.e;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public enum j
{
  private volatile com.tencent.mm.cn.f<Void> jqA;
  private volatile boolean jqz = false;
  
  static
  {
    AppMethodBeat.i(44417);
    jqy = new j("INSTANCE");
    jqB = new j[] { jqy };
    AppMethodBeat.o(44417);
  }
  
  private j() {}
  
  public final void aXE()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!com.tencent.mm.kernel.g.agP().ggT)
        {
          ac.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          if (this.jqA != null) {
            this.jqA.fxo();
          }
          this.jqz = false;
          AppMethodBeat.o(44414);
          return;
        }
        if (this.jqz)
        {
          ac.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(44414);
          continue;
        }
        ac.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.jqz = true;
      this.jqA = com.tencent.mm.cn.g.fBc();
      this.jqA.i(new com.tencent.mm.vending.c.a()
      {
        private Void aVo()
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
              ac.printErrStackTrace("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", localThrowable, "handleRetry()", new Object[0]);
              com.tencent.mm.vending.g.g.fxn().eb(null);
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
      if (this.jqA != null) {
        this.jqA.fxo();
      }
      this.jqz = false;
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