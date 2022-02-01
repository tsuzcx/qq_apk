package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.j;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.u;
import d.z;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class k
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 814;
  public static final String NAME = "NFCSetTimeout";
  public static final a lcR;
  
  static
  {
    AppMethodBeat.i(208205);
    lcR = new a((byte)0);
    AppMethodBeat.o(208205);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(208204);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
      AppMethodBeat.o(208204);
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
      paramc.h(paramInt, n("fail:invalid parameter", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(208204);
      return;
    }
    Object localObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((localObject != null) && (!((ad)localObject).biW()))
    {
      paramc.h(paramInt, n("fail:user is not authorized", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(208204);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.ldv;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
      paramc.h(paramInt, n("fail:unknown", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(208204);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
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
        p.g(str, "tech");
        paramc = (b)new b(this, paramc, paramInt);
        p.h(str, "techName");
        p.h(paramc, "callback");
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, techName: " + str + ", timeoutMs: " + i);
        h.MqF.f((Runnable)new c.j((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc, str, i), "NFC-IO");
        AppMethodBeat.o(208204);
        return;
      }
      catch (Exception paramJSONObject)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
        paramc.h(paramInt, n("fail:invalid parameter", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(208204);
      }
      paramJSONObject = paramJSONObject;
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
      paramc.h(paramInt, n("fail:invalid parameter", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(208204);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "PARAM_TIMEOUT", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.k
 * JD-Core Version:    0.7.0.1
 */