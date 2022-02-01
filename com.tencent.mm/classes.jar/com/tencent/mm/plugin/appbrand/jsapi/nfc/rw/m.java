package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.nfc.NdefMessage;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "onNFCDiscoveredEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "getOnNFCDiscoveredEvent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "onNFCDiscoveredEvent$delegate", "Lkotlin/Lazy;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 789;
  public static final String NAME = "startNFCDiscovery";
  public static final a pgq;
  private final f pgp;
  
  static
  {
    AppMethodBeat.i(183657);
    pgq = new a((byte)0);
    AppMethodBeat.o(183657);
  }
  
  public m()
  {
    AppMethodBeat.i(183659);
    this.pgp = g.ar((a)c.pgu);
    AppMethodBeat.o(183659);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183658);
    if (parame == null)
    {
      AppMethodBeat.o(183658);
      return;
    }
    if (!d.bTH())
    {
      parame.j(paramInt, m("fail:system NFC switch not opened", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13001)) })));
      AppMethodBeat.o(183658);
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((localObject != null) && (!((ai)localObject).bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183658);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    localObject = c.a.z(parame);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
      parame.j(paramInt, m("fail:unknown", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183658);
      return;
    }
    if (paramJSONObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c)localObject).iA(paramJSONObject.getBoolean("requireForegroundDispatch"));
      parame = (b)new b(this, parame, paramInt, (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c)localObject);
      p.k(parame, "callback");
      Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "startNFCDiscovery");
      h.ZvG.bc((Runnable)new c.k((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c)localObject, parame));
      AppMethodBeat.o(183658);
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.d("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "parse requireForegroundDispatch failed");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_REQUIRE_FOREGROUND_DISPATCH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(m paramm, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<c>
  {
    public static final c pgu;
    
    static
    {
      AppMethodBeat.i(183656);
      pgu = new c();
      AppMethodBeat.o(183656);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.m
 * JD-Core Version:    0.7.0.1
 */