package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class s
{
  long oVa = 0L;
  i.a oVb;
  
  public final void X(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138211);
    Log.i("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138207);
        if (s.this.oVb != null) {
          s.this.oVb.dismiss();
        }
        s.this.oVb = a.a.ah(paramAppBrandRuntime).a(a.b.qwL);
        s.this.oVa = System.currentTimeMillis();
        AppMethodBeat.o(138207);
      }
    });
    AppMethodBeat.o(138211);
  }
  
  public final void bSm()
  {
    AppMethodBeat.i(138212);
    Log.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138209);
        if (s.this.oVb == null)
        {
          AppMethodBeat.o(138209);
          return;
        }
        long l = System.currentTimeMillis() - s.this.oVa;
        if (l < 3000L)
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(138208);
              s.this.oVb.dismiss();
              AppMethodBeat.o(138208);
            }
          }, 3000L - l);
          AppMethodBeat.o(138209);
          return;
        }
        s.this.oVb.dismiss();
        AppMethodBeat.o(138209);
      }
    });
    AppMethodBeat.o(138212);
  }
  
  public final void bSn()
  {
    AppMethodBeat.i(138213);
    Log.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138210);
        if (s.this.oVb == null)
        {
          AppMethodBeat.o(138210);
          return;
        }
        s.this.oVb.dismiss();
        AppMethodBeat.o(138210);
      }
    });
    AppMethodBeat.o(138213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.s
 * JD-Core Version:    0.7.0.1
 */