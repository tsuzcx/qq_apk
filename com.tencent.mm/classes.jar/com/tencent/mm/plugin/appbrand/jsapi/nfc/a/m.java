package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import android.nfc.NdefMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "onNFCDiscoveredEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "getOnNFCDiscoveredEvent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "onNFCDiscoveredEvent$delegate", "Lkotlin/Lazy;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 789;
  public static final String NAME = "startNFCDiscovery";
  public static final a lcW;
  private final f lcV;
  
  static
  {
    AppMethodBeat.i(183657);
    lcW = new a((byte)0);
    AppMethodBeat.o(183657);
  }
  
  public m()
  {
    AppMethodBeat.i(183659);
    this.lcV = g.O((d.g.a.a)c.lda);
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
    if (!d.bmz())
    {
      paramc.h(paramInt, n("fail:system NFC switch not opened", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13001)) })));
      AppMethodBeat.o(183658);
      return;
    }
    Object localObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((localObject != null) && (!((ad)localObject).biW()))
    {
      paramc.h(paramInt, n("fail:user is not authorized", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183658);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.ldv;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
      paramc.h(paramInt, n("fail:unknown", (Map)d.a.ae.c(new o[] { u.R("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183658);
      return;
    }
    if (paramJSONObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject).gN(paramJSONObject.getBoolean("requireForegroundDispatch"));
      paramc = (b)new b(this, paramc, paramInt, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject);
      p.h(paramc, "callback");
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "startNFCDiscovery");
      com.tencent.mm.plugin.appbrand.y.m.runOnUiThread((Runnable)new c.k((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc));
      AppMethodBeat.o(183658);
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "parse requireForegroundDispatch failed");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_REQUIRE_FOREGROUND_DISPATCH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends d.g.b.q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>
  {
    b(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c paramc1)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<c>
  {
    public static final c lda;
    
    static
    {
      AppMethodBeat.i(183656);
      lda = new c();
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