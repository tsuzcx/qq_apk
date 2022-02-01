package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.i;
import d.a.ae;
import d.g.a.b;
import d.o;
import d.u;
import d.y;
import java.util.Map;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class k
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 814;
  public static final String NAME = "NFCSetTimeout";
  public static final a kco;
  
  static
  {
    AppMethodBeat.i(194620);
    kco = new a((byte)0);
    AppMethodBeat.o(194620);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(194619);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
      AppMethodBeat.o(194619);
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(194619);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.ad)localObject).aXM()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(194619);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kcQ;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
      paramc.h(paramInt, k("fail:unknown", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(194619);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
    try
    {
      String str = paramJSONObject.getString("tech");
      int i;
      return;
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        i = paramJSONObject.getInt("timeout");
        d.g.b.k.g(str, "tech");
        paramc = (b)new b(this, paramc, paramInt);
        d.g.b.k.h(str, "techName");
        d.g.b.k.h(paramc, "callback");
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, techName: " + str + ", timeoutMs: " + i);
        h.Iye.f((Runnable)new c.i((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc, str, i), "NFC-IO");
        AppMethodBeat.o(194619);
        return;
      }
      catch (Exception paramJSONObject)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
        paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(194619);
      }
      paramJSONObject = paramJSONObject;
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(194619);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "PARAM_TIMEOUT", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<y>, y>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.k
 * JD-Core Version:    0.7.0.1
 */