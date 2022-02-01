package com.tencent.mm.plugin.appbrand.luggage.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.luggage.natives.LuggageNativeViewJni;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.m.a.a.3;
import com.tencent.mm.plugin.m.a.a.4;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.appbrand.page.a<com.tencent.luggage.sdk.b.a.c>
  implements com.tencent.mm.plugin.appbrand.page.b.g
{
  private boolean iGS = false;
  private boolean kPF = false;
  private boolean kPG = false;
  private final String kPH = "page-frame.html";
  
  public a(com.tencent.luggage.sdk.b.a.c paramc)
  {
    super(paramc);
  }
  
  private void bhF()
  {
    AppMethodBeat.i(47545);
    if (this.kPG)
    {
      AppMethodBeat.o(47545);
      return;
    }
    ad.i("Luggage.MPPageNativeViewRenderer", "injectSharedEnvFields appId[%s]", new Object[] { getAppId() });
    biO();
    dL("wxa_library/android.js", d.Ne("wxa_library/android.js"));
    try
    {
      dL("WANativeRendering.js", "var __userAgent__ = 'Mozilla/5.0 (Linux; U; Android 8.1.1; en-us; LV) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30';" + d.Ne("wxa_library/native/WANativeRendering.js"));
      dL("custom_backend_impl.js", com.tencent.mm.plugin.m.a.c.a.aO(getContext(), "wxa_library/native/custom_backend_impl.js"));
      this.kPG = true;
      AppMethodBeat.o(47545);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("Luggage.MPPageNativeViewRenderer", localException, "error", new Object[0]);
      }
    }
  }
  
  public final void CB()
  {
    AppMethodBeat.i(47540);
    super.CB();
    AppMethodBeat.o(47540);
  }
  
  public final void CC()
  {
    AppMethodBeat.i(47541);
    super.CC();
    AppMethodBeat.o(47541);
  }
  
  public final Map<String, m> CD()
  {
    AppMethodBeat.i(47548);
    Map localMap = q.aXL();
    AppMethodBeat.o(47548);
    return localMap;
  }
  
  public final void CE()
  {
    AppMethodBeat.i(47549);
    super.CE();
    com.tencent.mm.plugin.m.a.c.c localc = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.afB("page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.hi("inject_js_Start", "page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.hi("inject_page_js", "page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.hi("ui_create", "page_ready");
    AppMethodBeat.o(47549);
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(196039);
    parama = parama.scriptName;
    ad.i("Luggage.MPPageNativeViewRenderer", "reportBootstrapScriptEvaluateResult appId[%s] url[%s] name[%s] succeed[%b] injectCost[%d]", new Object[] { getAppId(), this.jzm, parama, Boolean.valueOf(paramBoolean), Long.valueOf(paramLong2 - paramLong1) });
    if ("page-frame.html".equals(parama))
    {
      parama = com.tencent.mm.plugin.m.a.c.c.tsc;
      if (com.tencent.mm.plugin.m.a.c.c.afB("inject_js_End"))
      {
        parama = com.tencent.mm.plugin.m.a.c.c.tsc;
        com.tencent.mm.plugin.m.a.c.c.hi("inject_js_Start", "inject_js_End");
      }
      parama = com.tencent.mm.plugin.m.a.c.c.tsc;
      com.tencent.mm.plugin.m.a.c.c.afB("inject_page_js");
    }
    AppMethodBeat.o(196039);
  }
  
  public final boolean aNw()
  {
    return this.iGS;
  }
  
  public final void bhE()
  {
    AppMethodBeat.i(47543);
    this.kPF = true;
    ((com.tencent.luggage.sdk.b.a.c)Dj()).aXB();
    com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)Dj(), ((com.tencent.luggage.sdk.b.a.c)Dj()).aNC());
    bhF();
    this.iGS = true;
    AppMethodBeat.o(47543);
  }
  
  public final boolean bhG()
  {
    return this.kPF;
  }
  
  public final bg bhH()
  {
    AppMethodBeat.i(47547);
    a.2 local2 = new a.2(this, this, this);
    AppMethodBeat.o(47547);
    return local2;
  }
  
  public final boolean cn(String paramString)
  {
    AppMethodBeat.i(47544);
    com.tencent.mm.plugin.m.a.a locala = (com.tencent.mm.plugin.m.a.a)this.kWU;
    long l = locala.tqO.CR();
    locala.sOm = locala.sOn.a(locala, l, locala.tqO.ceQ, (Activity)locala.mContext, paramString, locala, new a.4(locala, locala));
    locala.sOm.getView().getViewTreeObserver().addOnGlobalLayoutListener(new a.3(locala));
    String str2 = paramString.substring(0, paramString.lastIndexOf("/"));
    String str1 = str2;
    if (!str2.startsWith("/")) {
      str1 = "/".concat(String.valueOf(str2));
    }
    locala.tqO.cp(str1);
    boolean bool = super.cn(paramString);
    e.a((ae)Dj());
    AppMethodBeat.o(47544);
    return bool;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47542);
    Object localObject = com.tencent.mm.plugin.m.a.c.c.tsc;
    if (com.tencent.mm.plugin.m.a.c.c.afB("inject_js_Start"))
    {
      localObject = com.tencent.mm.plugin.m.a.c.c.tsc;
      com.tencent.mm.plugin.m.a.c.c.hi("ui_create", "inject_js_Start");
    }
    localObject = Dl();
    if (((localObject instanceof f)) && ((this.kWU instanceof com.tencent.mm.plugin.m.a.a))) {
      ((com.tencent.mm.plugin.m.a.a)this.kWU).setFlutterRenderEngine(((f)localObject).kPX);
    }
    this.kPF = false;
    super.dispatchStart();
    com.tencent.mm.plugin.appbrand.aa.g.aD(getContext().getResources().getDisplayMetrics().density);
    localObject = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { DL().toString() });
    ((com.tencent.luggage.sdk.b.a.c)Dj()).aOf().evaluateJavascript((String)localObject, null);
    ad.i("Luggage.MPPageNativeViewRenderer", "inject final __wxConfig appId[%s]", new Object[] { getAppId() });
    bhF();
    localObject = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { cg.x("onWxConfigReady", "", 0) });
    ((com.tencent.luggage.sdk.b.a.c)Dj()).aOf().evaluateJavascript((String)localObject, null);
    biR();
    AppMethodBeat.o(47542);
  }
  
  public final bd dy(Context paramContext)
  {
    AppMethodBeat.i(47539);
    ax.aFC("__appbrand_comm_lib__prefs");
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c();
    localc.setJsExceptionHandler(new h()
    {
      public final void t(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47537);
        ad.e("MicroMsg.J2V8_Console", "Js Exception" + paramAnonymousString1 + "," + paramAnonymousString2);
        AppMethodBeat.o(47537);
      }
    });
    paramContext = new com.tencent.mm.plugin.m.a.a(paramContext, (aa)Dj(), localc);
    AppMethodBeat.o(47539);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */