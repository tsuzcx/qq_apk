package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.h;
import d.a.ae;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.u;
import d.z;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiIsNFCTechConnected;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class d
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 821;
  public static final String NAME = "isNFCTechConnected";
  public static final a kYV;
  
  static
  {
    AppMethodBeat.i(199669);
    kYV = new a((byte)0);
    AppMethodBeat.o(199669);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(199668);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, env is null");
      AppMethodBeat.o(199668);
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, data is null");
      paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(199668);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.ad)localObject).bin()))
    {
      paramc.h(paramInt, m("fail:user is not authorized", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(199668);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kZM;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, can not get activity");
      paramc.h(paramInt, m("fail:unknown", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(199668);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      p.g(paramJSONObject, "tech");
      paramc = (b)new b(this, paramc, paramInt);
      p.h(paramJSONObject, "techName");
      p.h(paramc, "callback");
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "isConnected, techName: ".concat(String.valueOf(paramJSONObject)));
      h.LTJ.f((Runnable)new c.h((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc, paramJSONObject), "NFC-IO");
      AppMethodBeat.o(199668);
      return;
    }
    catch (Exception paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "parse tech failed");
      paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(199668);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiIsNFCTechConnected$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "RESULT_CONNECTED", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<Boolean>, z>
  {
    b(d paramd, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.d
 * JD-Core Version:    0.7.0.1
 */