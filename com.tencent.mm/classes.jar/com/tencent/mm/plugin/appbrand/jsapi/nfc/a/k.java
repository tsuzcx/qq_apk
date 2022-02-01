package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.i;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.a.b;
import d.o;
import d.u;
import d.y;
import java.util.Map;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class k
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 814;
  public static final String NAME = "NFCSetTimeout";
  public static final a kDb;
  
  static
  {
    AppMethodBeat.i(200895);
    kDb = new a((byte)0);
    AppMethodBeat.o(200895);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(200894);
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
      AppMethodBeat.o(200894);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(200894);
      return;
    }
    Object localObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((localObject != null) && (!((ad)localObject).beJ()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(200894);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kDD;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
      paramc.h(paramInt, k("fail:unknown", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(200894);
      return;
    }
    ac.d("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
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
        ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, techName: " + str + ", timeoutMs: " + i);
        h.JZN.f((Runnable)new c.i((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc, str, i), "NFC-IO");
        AppMethodBeat.o(200894);
        return;
      }
      catch (Exception paramJSONObject)
      {
        ac.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
        paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(200894);
      }
      paramJSONObject = paramJSONObject;
      ac.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(200894);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "PARAM_TIMEOUT", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
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