package com.tencent.mm.plugin.appbrand.jsapi.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class a$5
  implements f.c
{
  a$5(a parama, e parame, c paramc, JSONObject paramJSONObject) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(155140);
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onDestroy");
    this.hER.b(this);
    synchronized (this.iiH.iiG)
    {
      this.iiH.iiF = null;
      g.cm(this.hza.getAppId(), f.g(this.hza, this.bBa));
      AppMethodBeat.o(155140);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.5
 * JD-Core Version:    0.7.0.1
 */