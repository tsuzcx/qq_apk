package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.nfc.NdefMessage;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "onNFCDiscoveredEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "getOnNFCDiscoveredEvent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "onNFCDiscoveredEvent$delegate", "Lkotlin/Lazy;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  public static final int CTRL_INDEX = 789;
  public static final String NAME = "startNFCDiscovery";
  public static final m.a slK;
  private final kotlin.j slL;
  
  static
  {
    AppMethodBeat.i(183657);
    slK = new m.a((byte)0);
    AppMethodBeat.o(183657);
  }
  
  public m()
  {
    AppMethodBeat.i(183659);
    this.slL = k.cm((a)c.slO);
    AppMethodBeat.o(183659);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183658);
    if (paramf == null)
    {
      AppMethodBeat.o(183658);
      return;
    }
    if (!d.ctM())
    {
      paramf.callback(paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.j.a((p)this, 13001, "fail:system NFC switch not opened", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13001)) })));
      AppMethodBeat.o(183658);
      return;
    }
    Object localObject = (al)e.T(al.class);
    if ((localObject != null) && (!((al)localObject).cpS()))
    {
      paramf.callback(paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.j.a((p)this, 13019, "fail:user is not authorized", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183658);
      return;
    }
    localObject = g.smq;
    localObject = g.a.B(paramf);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
      paramf.callback(paramInt, com.tencent.mm.plugin.appbrand.jsapi.nfc.j.a((p)this, 13010, "fail:unknown", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183658);
      return;
    }
    if (paramJSONObject != null) {}
    try
    {
      boolean bool = paramJSONObject.getBoolean("requireForegroundDispatch");
      ((g)localObject).smr.jE(bool);
      ((g)localObject).R((kotlin.g.a.b)new b(paramf, paramInt, this, (g)localObject));
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<h<ah>, ah>
  {
    b(f paramf, int paramInt, m paramm, g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<c>
  {
    public static final c slO;
    
    static
    {
      AppMethodBeat.i(183656);
      slO = new c();
      AppMethodBeat.o(183656);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.m
 * JD-Core Version:    0.7.0.1
 */