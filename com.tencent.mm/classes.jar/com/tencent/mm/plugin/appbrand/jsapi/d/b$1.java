package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb, c paramc, Integer paramInteger, int paramInt) {}
  
  public final void run()
  {
    if (!this.grj.isRunning()) {
      return;
    }
    Object localObject = this.grj;
    if ((localObject instanceof q))
    {
      localObject = (q)localObject;
      if (!com.tencent.mm.plugin.appbrand.widget.input.n.a((q)localObject, this.grk)) {
        break label106;
      }
    }
    label106:
    for (localObject = "ok";; localObject = "fail:input not exists")
    {
      this.grj.C(this.dIS, this.grl.h((String)localObject, null));
      return;
      if ((localObject instanceof o))
      {
        localObject = ((o)localObject).getRuntime().Zz().getCurrentPage().getCurrentPageView();
        break;
      }
      y.e("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.b.1
 * JD-Core Version:    0.7.0.1
 */