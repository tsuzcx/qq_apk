package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class p
{
  long jSt = 0L;
  c.a jSu;
  
  public final void ac(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138211);
    ad.i("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138207);
        if (p.this.jSu != null) {
          p.this.jSu.dismiss();
        }
        p.this.jSu = b.ai(paramAppBrandRuntime).a(b.a.kXC);
        p.this.jSt = System.currentTimeMillis();
        AppMethodBeat.o(138207);
      }
    });
    AppMethodBeat.o(138211);
  }
  
  public final void bac()
  {
    AppMethodBeat.i(138212);
    ad.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138209);
        if (p.this.jSu == null)
        {
          AppMethodBeat.o(138209);
          return;
        }
        long l = System.currentTimeMillis() - p.this.jSt;
        if (l < 3000L)
        {
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(138208);
              p.this.jSu.dismiss();
              AppMethodBeat.o(138208);
            }
          }, 3000L - l);
          AppMethodBeat.o(138209);
          return;
        }
        p.this.jSu.dismiss();
        AppMethodBeat.o(138209);
      }
    });
    AppMethodBeat.o(138212);
  }
  
  public final void bad()
  {
    AppMethodBeat.i(138213);
    ad.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138210);
        if (p.this.jSu == null)
        {
          AppMethodBeat.o(138210);
          return;
        }
        p.this.jSu.dismiss();
        AppMethodBeat.o(138210);
      }
    });
    AppMethodBeat.o(138213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.p
 * JD-Core Version:    0.7.0.1
 */