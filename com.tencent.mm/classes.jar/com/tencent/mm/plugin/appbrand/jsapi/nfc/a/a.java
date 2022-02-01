package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import d.a.ae;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import d.z;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "function", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/ConnectClosePrototype;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final a kYL = new a((byte)0);
  private final d.g.a.q<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c, String, b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>, z> kYK;
  
  public a(d.g.a.q<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c, ? super String, ? super b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>, z> paramq)
  {
    this.kYK = paramq;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
      paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.ad)localObject).bin()))
    {
      paramc.h(paramInt, m("fail:user is not authorized", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kZM;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
      paramc.h(paramInt, m("fail:unknown", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13010)) })));
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      d.g.a.q localq = this.kYK;
      p.g(paramJSONObject, "tech");
      localq.d(localObject, paramJSONObject, new b(this, paramc, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse tech failed");
      paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13011)) })));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose$Companion;", "", "()V", "PARAM_TECH", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends d.g.b.q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>
  {
    b(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a
 * JD-Core Version:    0.7.0.1
 */