package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.plugin.appbrand.widget.e.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

final class a$1
  implements Runnable
{
  a$1(a parama, q paramq, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(138252);
    a locala = this.leB;
    q localq = this.cjP;
    int i = this.cjQ;
    Object localObject;
    try
    {
      u localu = localq.getRuntime().aVN();
      if (localu == null)
      {
        ad.e("MicroMsg.JsApiHideToast", "hideToast uiThread NULL page");
        localq.h(i, locala.e("fail:page don't exist", null));
        AppMethodBeat.o(138252);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localObject = null;
      }
    }
    label179:
    label199:
    for (;;)
    {
      try
      {
        localObject = localq.getRuntime();
        if (localObject != null)
        {
          b.bFA();
          localObject = (b.b)((AppBrandRuntime)localObject).as(b.b.class);
          if (localObject != null)
          {
            bool = false;
            if (((b.b)localObject).nmN.isEmpty()) {
              break label199;
            }
            bool |= ((aa)((b.b)localObject).nmN.poll()).mcc.bFz();
            continue;
            if (!bool) {
              break label179;
            }
            localq.h(i, locala.e("ok", null));
            AppMethodBeat.o(138252);
            return;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localq.h(i, locala.e("fail:internal error", null));
        AppMethodBeat.o(138252);
        return;
      }
      boolean bool = false;
      continue;
      localq.h(i, locala.e("fail:toast can't be found", null));
      AppMethodBeat.o(138252);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.a.1
 * JD-Core Version:    0.7.0.1
 */