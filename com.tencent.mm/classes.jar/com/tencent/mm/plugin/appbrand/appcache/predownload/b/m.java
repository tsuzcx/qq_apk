package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.predownload.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.launching.w.a;
import com.tencent.mm.plugin.appbrand.launching.w.a.a;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.plugin.appbrand.launching.y.b;
import com.tencent.mm.plugin.appbrand.launching.y.d;
import com.tencent.mm.plugin.appbrand.launching.y.g;
import com.tencent.mm.plugin.appbrand.launching.y.g.c;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.ah;
import kotlin.g.b.s;

public enum m
{
  private volatile boolean qJH = false;
  private volatile f<Void> qJI;
  
  static
  {
    AppMethodBeat.i(44417);
    qJG = new m("INSTANCE");
    qJJ = new m[] { qJG };
    AppMethodBeat.o(44417);
  }
  
  private m() {}
  
  public final void chu()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!com.tencent.mm.kernel.h.baC().mBZ)
        {
          Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          if (this.qJI != null) {
            this.qJI.jJM();
          }
          this.qJH = false;
          AppMethodBeat.o(44414);
          return;
        }
        if (this.qJH)
        {
          Log.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(44414);
          continue;
        }
        Log.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.qJH = true;
      this.qJI = com.tencent.mm.cp.g.jPX();
      this.qJI.i(new com.tencent.mm.vending.c.a()
      {
        private Void ceW()
        {
          AppMethodBeat.i(44404);
          try
          {
            m.a(m.this);
            AppMethodBeat.o(44404);
            return null;
          }
          finally
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", localThrowable, "handleRetry()", new Object[0]);
              com.tencent.mm.vending.g.g.jJL().gM(null);
              synchronized (m.this)
              {
                m.b(m.this);
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
      if (this.qJI != null) {
        this.qJI.jJM();
      }
      this.qJH = false;
      AppMethodBeat.o(44415);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.m
 * JD-Core Version:    0.7.0.1
 */