package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiIsNFCTechConnected;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 821;
  public static final String NAME = "isNFCTechConnected";
  public static final a pfY;
  
  static
  {
    AppMethodBeat.i(242240);
    pfY = new a((byte)0);
    AppMethodBeat.o(242240);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(242238);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, env is null");
      AppMethodBeat.o(242238);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, data is null");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(242238);
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((localObject != null) && (!((ai)localObject).bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(242238);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    localObject = c.a.z(parame);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, can not get activity");
      parame.j(paramInt, m("fail:unknown", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(242238);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, appId: " + parame.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      p.j(paramJSONObject, "tech");
      parame = (b)new b(this, parame, paramInt);
      p.k(paramJSONObject, "techName");
      p.k(parame, "callback");
      Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "isConnected, techName: ".concat(String.valueOf(paramJSONObject)));
      h.ZvG.d((Runnable)new c.h((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c)localObject, parame, paramJSONObject), "NFC-IO");
      AppMethodBeat.o(242238);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "parse tech failed");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(242238);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiIsNFCTechConnected$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "RESULT_CONNECTED", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<Boolean>, x>
  {
    b(d paramd, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.d
 * JD-Core Version:    0.7.0.1
 */