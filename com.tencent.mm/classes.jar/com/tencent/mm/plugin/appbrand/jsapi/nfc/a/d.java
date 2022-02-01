package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.g;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.a.b;
import d.g.b.k;
import d.o;
import d.u;
import d.y;
import java.util.Map;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiIsNFCTechConnected;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class d
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 821;
  public static final String NAME = "isNFCTechConnected";
  public static final a kCO;
  
  static
  {
    AppMethodBeat.i(200873);
    kCO = new a((byte)0);
    AppMethodBeat.o(200873);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(200872);
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, env is null");
      AppMethodBeat.o(200872);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, data is null");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(200872);
      return;
    }
    Object localObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((localObject != null) && (!((ad)localObject).beJ()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(200872);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kDD;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, can not get activity");
      paramc.h(paramInt, k("fail:unknown", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(200872);
      return;
    }
    ac.i("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      k.g(paramJSONObject, "tech");
      paramc = (b)new b(this, paramc, paramInt);
      k.h(paramJSONObject, "techName");
      k.h(paramc, "callback");
      ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "isConnected, techName: ".concat(String.valueOf(paramJSONObject)));
      h.JZN.f((Runnable)new c.g((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc, paramJSONObject), "NFC-IO");
      AppMethodBeat.o(200872);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ac.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "parse tech failed");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(200872);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiIsNFCTechConnected$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "RESULT_CONNECTED", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<Boolean>, y>
  {
    b(d paramd, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.d
 * JD-Core Version:    0.7.0.1
 */