package com.tencent.luggage.game.e;

import com.tencent.luggage.game.page.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class c$1
  implements Runnable
{
  c$1(c paramc, r paramr, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(140415);
    if (!this.bAZ.isRunning())
    {
      ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
      this.bAZ.h(this.bAX, this.bBb.j("fail", null));
      AppMethodBeat.o(140415);
      return;
    }
    Object localObject = this.bAZ.getCurrentPageView();
    if ((d)((v)localObject).x(d.class) == null)
    {
      this.bAZ.h(this.bAX, this.bBb.j("fail", null));
      AppMethodBeat.o(140415);
      return;
    }
    localObject = c.a((v)localObject, this.bBa, false);
    this.bAZ.h(this.bAX, this.bBb.j(((h.a)localObject).errMsg, ((h.a)localObject).values));
    AppMethodBeat.o(140415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.e.c.1
 * JD-Core Version:    0.7.0.1
 */