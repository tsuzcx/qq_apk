package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.l;
import com.tencent.mm.plugin.appbrand.y.m;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.u;
import d.z;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class n
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 794;
  public static final String NAME = "stopNFCDiscovery";
  public static final a ldb;
  
  static
  {
    AppMethodBeat.i(183663);
    ldb = new a((byte)0);
    AppMethodBeat.o(183663);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183662);
    if (paramc == null)
    {
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((paramJSONObject != null) && (!paramJSONObject.biW()))
    {
      paramc.h(paramInt, n("fail:user is not authorized", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.ldv;
    paramJSONObject = c.a.w(paramc);
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.JsApiStopNFCDiscovery", "invoke, can not get activity");
      paramc.h(paramInt, n("fail:unknown", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183662);
      return;
    }
    paramc = (b)new b(this, paramc, paramInt, paramJSONObject);
    p.h(paramc, "callback");
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "stopNFCDiscovery");
    m.runOnUiThread((Runnable)new c.l(paramJSONObject, paramc));
    AppMethodBeat.o(183662);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>
  {
    b(n paramn, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c paramc1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.n
 * JD-Core Version:    0.7.0.1
 */