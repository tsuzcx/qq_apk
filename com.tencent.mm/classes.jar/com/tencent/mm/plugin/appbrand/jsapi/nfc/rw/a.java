package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "function", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/ConnectClosePrototype;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final a pfP = new a((byte)0);
  private final kotlin.g.a.q<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c, String, b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>, x> pfO;
  
  public a(kotlin.g.a.q<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c, ? super String, ? super b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>, x> paramq)
  {
    this.pfO = paramq;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, data is null");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((localObject != null) && (!((ai)localObject).bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    localObject = c.a.z(parame);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, can not get activity");
      parame.j(paramInt, m("fail:unknown", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13010)) })));
      return;
    }
    Log.d("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, appId: " + parame.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      kotlin.g.a.q localq = this.pfO;
      p.j(paramJSONObject, "tech");
      localq.c(localObject, paramJSONObject, new b(this, parame, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "parse tech failed");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose$Companion;", "", "()V", "PARAM_TECH", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(a parama, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a
 * JD-Core Version:    0.7.0.1
 */