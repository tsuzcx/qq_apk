package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class n
  extends d<f>
{
  public static final int CTRL_INDEX = 794;
  public static final String NAME = "stopNFCDiscovery";
  public static final a mit;
  
  static
  {
    AppMethodBeat.i(183663);
    mit = new a((byte)0);
    AppMethodBeat.o(183663);
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183662);
    if (paramf == null)
    {
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = (ai)com.tencent.luggage.a.e.M(ai.class);
    if ((paramJSONObject != null) && (!paramJSONObject.bEm()))
    {
      paramf.i(paramInt, n("fail:user is not authorized", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = c.miO;
    paramJSONObject = c.a.w(paramf);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiStopNFCDiscovery", "invoke, can not get activity");
      paramf.i(paramInt, n("fail:unknown", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183662);
      return;
    }
    paramf = (b)new b(this, paramf, paramInt, paramJSONObject);
    p.h(paramf, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "stopNFCDiscovery");
    h.RTc.aV((Runnable)new c.l(paramJSONObject, paramf));
    AppMethodBeat.o(183662);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(n paramn, f paramf, int paramInt, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.n
 * JD-Core Version:    0.7.0.1
 */