package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import android.nfc.NdefMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.f;
import d.g;
import d.g.a.b;
import d.g.b.w;
import d.o;
import d.y;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "onNFCDiscoveredEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "getOnNFCDiscoveredEvent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "onNFCDiscoveredEvent$delegate", "Lkotlin/Lazy;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 789;
  public static final String NAME = "startNFCDiscovery";
  public static final a kDg;
  private final f kDf;
  
  static
  {
    AppMethodBeat.i(183657);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(m.class), "onNFCDiscoveredEvent", "getOnNFCDiscoveredEvent()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;")) };
    kDg = new a((byte)0);
    AppMethodBeat.o(183657);
  }
  
  public m()
  {
    AppMethodBeat.i(183659);
    this.kDf = g.K((d.g.a.a)c.kDk);
    AppMethodBeat.o(183659);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183658);
    if (paramc == null)
    {
      AppMethodBeat.o(183658);
      return;
    }
    if (!d.big())
    {
      paramc.h(paramInt, k("fail:system NFC switch not opened", (Map)ae.c(new o[] { d.u.Q("errCode", Integer.valueOf(13001)) })));
      AppMethodBeat.o(183658);
      return;
    }
    paramJSONObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((paramJSONObject != null) && (!paramJSONObject.beJ()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { d.u.Q("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183658);
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kDD;
    paramJSONObject = c.a.w(paramc);
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
      paramc.h(paramInt, k("fail:unknown", (Map)ae.c(new o[] { d.u.Q("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183658);
      return;
    }
    paramc = (b)new b(this, paramc, paramInt, paramJSONObject);
    d.g.b.k.h(paramc, "callback");
    ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "startNFCDiscovery");
    com.tencent.mm.plugin.appbrand.z.l.runOnUiThread((Runnable)new c.j(paramJSONObject, paramc));
    AppMethodBeat.o(183658);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<y>, y>
  {
    b(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c paramc1)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<c>
  {
    public static final c kDk;
    
    static
    {
      AppMethodBeat.i(183656);
      kDk = new c();
      AppMethodBeat.o(183656);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.m
 * JD-Core Version:    0.7.0.1
 */