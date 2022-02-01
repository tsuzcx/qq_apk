package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class q
{
  long kSj = 0L;
  i.a kSk;
  
  public final void V(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138211);
    ae.i("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138207);
        if (q.this.kSk != null) {
          q.this.kSk.dismiss();
        }
        q.this.kSk = a.a.ag(paramAppBrandRuntime).a(a.b.mkt);
        q.this.kSj = System.currentTimeMillis();
        AppMethodBeat.o(138207);
      }
    });
    AppMethodBeat.o(138211);
  }
  
  public final void blk()
  {
    AppMethodBeat.i(138212);
    ae.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138209);
        if (q.this.kSk == null)
        {
          AppMethodBeat.o(138209);
          return;
        }
        long l = System.currentTimeMillis() - q.this.kSj;
        if (l < 3000L)
        {
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(138208);
              q.this.kSk.dismiss();
              AppMethodBeat.o(138208);
            }
          }, 3000L - l);
          AppMethodBeat.o(138209);
          return;
        }
        q.this.kSk.dismiss();
        AppMethodBeat.o(138209);
      }
    });
    AppMethodBeat.o(138212);
  }
  
  public final void bll()
  {
    AppMethodBeat.i(138213);
    ae.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138210);
        if (q.this.kSk == null)
        {
          AppMethodBeat.o(138210);
          return;
        }
        q.this.kSk.dismiss();
        AppMethodBeat.o(138210);
      }
    });
    AppMethodBeat.o(138213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.q
 * JD-Core Version:    0.7.0.1
 */