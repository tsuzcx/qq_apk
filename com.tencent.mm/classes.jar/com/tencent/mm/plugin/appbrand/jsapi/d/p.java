package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public final class p
{
  long ktf = 0L;
  c.a ktg;
  
  public final void ac(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138211);
    ac.i("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138207);
        if (p.this.ktg != null) {
          p.this.ktg.dismiss();
        }
        p.this.ktg = b.ai(paramAppBrandRuntime).a(b.a.lzm);
        p.this.ktf = System.currentTimeMillis();
        AppMethodBeat.o(138207);
      }
    });
    AppMethodBeat.o(138211);
  }
  
  public final void bgV()
  {
    AppMethodBeat.i(138212);
    ac.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138209);
        if (p.this.ktg == null)
        {
          AppMethodBeat.o(138209);
          return;
        }
        long l = System.currentTimeMillis() - p.this.ktf;
        if (l < 3000L)
        {
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(138208);
              p.this.ktg.dismiss();
              AppMethodBeat.o(138208);
            }
          }, 3000L - l);
          AppMethodBeat.o(138209);
          return;
        }
        p.this.ktg.dismiss();
        AppMethodBeat.o(138209);
      }
    });
    AppMethodBeat.o(138212);
  }
  
  public final void bgW()
  {
    AppMethodBeat.i(138213);
    ac.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138210);
        if (p.this.ktg == null)
        {
          AppMethodBeat.o(138210);
          return;
        }
        p.this.ktg.dismiss();
        AppMethodBeat.o(138210);
      }
    });
    AppMethodBeat.o(138213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.p
 * JD-Core Version:    0.7.0.1
 */