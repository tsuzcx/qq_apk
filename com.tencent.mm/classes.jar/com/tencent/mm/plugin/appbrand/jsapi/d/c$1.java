package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements Runnable
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, Integer paramInteger, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(123526);
    if (!this.hMA.isRunning())
    {
      AppMethodBeat.o(123526);
      return;
    }
    Object localObject = this.hMA;
    if ((localObject instanceof v))
    {
      localObject = (v)localObject;
      if (!com.tencent.mm.plugin.appbrand.widget.input.o.a((v)localObject, this.hMB)) {
        break label121;
      }
    }
    label121:
    for (localObject = "ok";; localObject = "fail:input not exists")
    {
      this.hMA.h(this.bAX, this.hMC.j((String)localObject, null));
      AppMethodBeat.o(123526);
      return;
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.r))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.r)localObject).getRuntime().atj().getCurrentPage().getCurrentPageView();
        break;
      }
      ab.e("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.c.1
 * JD-Core Version:    0.7.0.1
 */