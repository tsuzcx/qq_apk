package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.j;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 814;
  public static final String NAME = "NFCSetTimeout";
  public static final a pgl;
  
  static
  {
    AppMethodBeat.i(241752);
    pgl = new a((byte)0);
    AppMethodBeat.o(241752);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(241748);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
      AppMethodBeat.o(241748);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(241748);
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((localObject != null) && (!((ai)localObject).bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(241748);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    localObject = c.a.z(parame);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
      parame.j(paramInt, m("fail:unknown", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(241748);
      return;
    }
    Log.d("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, appId: " + parame.getAppId() + ", data: " + paramJSONObject);
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
        p.j(str, "tech");
        parame = (b)new b(this, parame, paramInt);
        p.k(str, "techName");
        p.k(parame, "callback");
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, techName: " + str + ", timeoutMs: " + i);
        h.ZvG.d((Runnable)new c.j((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c)localObject, parame, str, i), "NFC-IO");
        AppMethodBeat.o(241748);
        return;
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
        parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(241748);
      }
      paramJSONObject = paramJSONObject;
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(241748);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "PARAM_TIMEOUT", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.k
 * JD-Core Version:    0.7.0.1
 */