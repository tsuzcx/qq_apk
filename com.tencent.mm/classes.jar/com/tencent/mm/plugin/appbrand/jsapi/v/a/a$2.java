package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.v.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.v.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.v.a.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class a$2
  implements Runnable
{
  a$2(a parama, m paramm, com.tencent.luggage.xweb_ext.extendplugin.a parama1, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(154431);
    if ((this.hwN instanceof b))
    {
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "Tummy insert");
      a.a(this.iif, this.bGh);
      a.a(this.iif, this.hza, this.bBa, this.hwN, this.bAX);
      AppMethodBeat.o(154431);
      return;
    }
    if ((this.hwN instanceof e))
    {
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "Tummy update");
      a.b(this.iif, this.hza, this.bBa, this.hwN, this.bAX);
      AppMethodBeat.o(154431);
      return;
    }
    if ((this.hwN instanceof d)) {
      a.a(this.iif, this.hza, this.hwN, this.bAX);
    }
    AppMethodBeat.o(154431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.a.2
 * JD-Core Version:    0.7.0.1
 */