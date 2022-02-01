package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class p
{
  long kOB = 0L;
  c.a kOC;
  
  public final void W(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138211);
    ad.i("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138207);
        if (p.this.kOC != null) {
          p.this.kOC.dismiss();
        }
        p.this.kOC = b.ac(paramAppBrandRuntime).a(b.a.lYK);
        p.this.kOB = System.currentTimeMillis();
        AppMethodBeat.o(138207);
      }
    });
    AppMethodBeat.o(138211);
  }
  
  public final void bkA()
  {
    AppMethodBeat.i(138212);
    ad.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138209);
        if (p.this.kOC == null)
        {
          AppMethodBeat.o(138209);
          return;
        }
        long l = System.currentTimeMillis() - p.this.kOB;
        if (l < 3000L)
        {
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(138208);
              p.this.kOC.dismiss();
              AppMethodBeat.o(138208);
            }
          }, 3000L - l);
          AppMethodBeat.o(138209);
          return;
        }
        p.this.kOC.dismiss();
        AppMethodBeat.o(138209);
      }
    });
    AppMethodBeat.o(138212);
  }
  
  public final void bkB()
  {
    AppMethodBeat.i(138213);
    ad.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138210);
        if (p.this.kOC == null)
        {
          AppMethodBeat.o(138210);
          return;
        }
        p.this.kOC.dismiss();
        AppMethodBeat.o(138210);
      }
    });
    AppMethodBeat.o(138213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.p
 * JD-Core Version:    0.7.0.1
 */