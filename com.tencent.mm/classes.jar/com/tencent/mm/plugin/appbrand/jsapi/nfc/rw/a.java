package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "function", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/ConnectClosePrototype;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class a
  extends d<f>
{
  public static final a mhL = new a((byte)0);
  private final kotlin.g.a.q<c, String, b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>, x> mhK;
  
  public a(kotlin.g.a.q<? super c, ? super String, ? super b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>, x> paramq)
  {
    this.mhK = paramq;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, data is null");
      paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.M(ai.class);
    if ((localObject != null) && (!((ai)localObject).bEm()))
    {
      paramf.i(paramInt, n("fail:user is not authorized", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject = c.miO;
    localObject = c.a.w(paramf);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, can not get activity");
      paramf.i(paramInt, n("fail:unknown", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13010)) })));
      return;
    }
    Log.d("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, appId: " + paramf.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      kotlin.g.a.q localq = this.mhK;
      p.g(paramJSONObject, "tech");
      localq.d(localObject, paramJSONObject, new b(this, paramf, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "parse tech failed");
      paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose$Companion;", "", "()V", "PARAM_TECH", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(a parama, f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a
 * JD-Core Version:    0.7.0.1
 */