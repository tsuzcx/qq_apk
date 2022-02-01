package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.l;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 794;
  public static final String NAME = "stopNFCDiscovery";
  public static final a pgv;
  
  static
  {
    AppMethodBeat.i(183663);
    pgv = new a((byte)0);
    AppMethodBeat.o(183663);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183662);
    if (parame == null)
    {
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((paramJSONObject != null) && (!paramJSONObject.bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    paramJSONObject = c.a.z(parame);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiStopNFCDiscovery", "invoke, can not get activity");
      parame.j(paramInt, m("fail:unknown", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183662);
      return;
    }
    parame = (b)new b(this, parame, paramInt, paramJSONObject);
    p.k(parame, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "stopNFCDiscovery");
    h.ZvG.bc((Runnable)new c.l(paramJSONObject, parame));
    AppMethodBeat.o(183662);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(n paramn, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.n
 * JD-Core Version:    0.7.0.1
 */