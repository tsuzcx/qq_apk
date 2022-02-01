package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class s
{
  long san = 0L;
  m.a sao;
  
  public final void al(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138211);
    Log.i("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138207);
        if (s.this.sao != null) {
          s.this.sao.dismiss();
        }
        s.this.sao = a.a.av(paramAppBrandRuntime).a(a.b.tBK);
        s.this.san = System.currentTimeMillis();
        AppMethodBeat.o(138207);
      }
    });
    AppMethodBeat.o(138211);
  }
  
  public final void csr()
  {
    AppMethodBeat.i(138212);
    Log.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138209);
        if (s.this.sao == null)
        {
          AppMethodBeat.o(138209);
          return;
        }
        long l = System.currentTimeMillis() - s.this.san;
        if (l < 3000L)
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(138208);
              s.this.sao.dismiss();
              AppMethodBeat.o(138208);
            }
          }, 3000L - l);
          AppMethodBeat.o(138209);
          return;
        }
        s.this.sao.dismiss();
        AppMethodBeat.o(138209);
      }
    });
    AppMethodBeat.o(138212);
  }
  
  public final void css()
  {
    AppMethodBeat.i(138213);
    Log.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138210);
        if (s.this.sao == null)
        {
          AppMethodBeat.o(138210);
          return;
        }
        s.this.sao.dismiss();
        AppMethodBeat.o(138210);
      }
    });
    AppMethodBeat.o(138213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.s
 * JD-Core Version:    0.7.0.1
 */