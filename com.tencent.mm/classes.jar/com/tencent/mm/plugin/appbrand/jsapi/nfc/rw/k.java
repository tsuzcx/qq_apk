package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class k
  extends d<f>
{
  public static final int CTRL_INDEX = 814;
  public static final String NAME = "NFCSetTimeout";
  public static final a mii;
  
  static
  {
    AppMethodBeat.i(207141);
    mii = new a((byte)0);
    AppMethodBeat.o(207141);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(207140);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
      AppMethodBeat.o(207140);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
      paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(207140);
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.M(ai.class);
    if ((localObject != null) && (!((ai)localObject).bEm()))
    {
      paramf.i(paramInt, n("fail:user is not authorized", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(207140);
      return;
    }
    localObject = c.miO;
    localObject = c.a.w(paramf);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
      paramf.i(paramInt, n("fail:unknown", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(207140);
      return;
    }
    Log.d("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, appId: " + paramf.getAppId() + ", data: " + paramJSONObject);
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
        paramf = (b)new b(this, paramf, paramInt);
        p.h(str, "techName");
        p.h(paramf, "callback");
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, techName: " + str + ", timeoutMs: " + i);
        h.RTc.b((Runnable)new c.j((c)localObject, paramf, str, i), "NFC-IO");
        AppMethodBeat.o(207140);
        return;
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
        paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(207140);
      }
      paramJSONObject = paramJSONObject;
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
      paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(207140);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "PARAM_TIMEOUT", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(k paramk, f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.k
 * JD-Core Version:    0.7.0.1
 */