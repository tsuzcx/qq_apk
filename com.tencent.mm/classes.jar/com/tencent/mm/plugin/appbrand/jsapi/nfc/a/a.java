package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.a.b;
import d.g.a.q;
import d.g.b.k;
import d.o;
import d.u;
import d.y;
import java.util.Map;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "function", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/ConnectClosePrototype;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final a kCE = new a((byte)0);
  private final q<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c, String, b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<y>, y>, y> kCD;
  
  public a(q<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c, ? super String, ? super b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<y>, y>, y> paramq)
  {
    this.kCD = paramq;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((localObject != null) && (!((ad)localObject).beJ()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kDD;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
      paramc.h(paramInt, k("fail:unknown", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13010)) })));
      return;
    }
    ac.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      q localq = this.kCD;
      k.g(paramJSONObject, "tech");
      localq.d(localObject, paramJSONObject, new b(this, paramc, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse tech failed");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13011)) })));
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose$Companion;", "", "()V", "PARAM_TECH", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<y>, y>
  {
    b(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a
 * JD-Core Version:    0.7.0.1
 */