package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import android.nfc.NdefMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import d.a.ae;
import d.f;
import d.g;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import d.z;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "onNFCDiscoveredEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "getOnNFCDiscoveredEvent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "onNFCDiscoveredEvent$delegate", "Lkotlin/Lazy;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 789;
  public static final String NAME = "startNFCDiscovery";
  public static final a kZn;
  private final f kZm;
  
  static
  {
    AppMethodBeat.i(183657);
    kZn = new a((byte)0);
    AppMethodBeat.o(183657);
  }
  
  public m()
  {
    AppMethodBeat.i(183659);
    this.kZm = g.O((d.g.a.a)c.kZr);
    AppMethodBeat.o(183659);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183658);
    if (paramc == null)
    {
      AppMethodBeat.o(183658);
      return;
    }
    if (!d.blQ())
    {
      paramc.h(paramInt, m("fail:system NFC switch not opened", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13001)) })));
      AppMethodBeat.o(183658);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.ad)localObject).bin()))
    {
      paramc.h(paramInt, m("fail:user is not authorized", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183658);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kZM;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
      paramc.h(paramInt, m("fail:unknown", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183658);
      return;
    }
    if (paramJSONObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject).gO(paramJSONObject.getBoolean("requireForegroundDispatch"));
      paramc = (b)new b(this, paramc, paramInt, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject);
      p.h(paramc, "callback");
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "startNFCDiscovery");
      com.tencent.mm.plugin.appbrand.z.m.runOnUiThread((Runnable)new c.k((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc));
      AppMethodBeat.o(183658);
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "parse requireForegroundDispatch failed");
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_REQUIRE_FOREGROUND_DISPATCH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends d.g.b.q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>
  {
    b(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c paramc1)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<c>
  {
    public static final c kZr;
    
    static
    {
      AppMethodBeat.i(183656);
      kZr = new c();
      AppMethodBeat.o(183656);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.m
 * JD-Core Version:    0.7.0.1
 */