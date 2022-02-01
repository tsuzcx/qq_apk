package com.tencent.mm.plugin.appbrand.luggage.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.luggage.natives.LuggageNativeViewJni;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.m.a.a.3;
import com.tencent.mm.plugin.m.a.a.4;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.n.n;
import d.o;
import d.u;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.appbrand.page.a<com.tencent.luggage.sdk.b.a.c>
  implements com.tencent.mm.plugin.appbrand.page.b.g
{
  private boolean jgV = false;
  private boolean lre = false;
  private boolean lrf = false;
  private final String lrg = "page-frame.html";
  
  public a(com.tencent.luggage.sdk.b.a.c paramc)
  {
    super(paramc);
  }
  
  private void boz()
  {
    AppMethodBeat.i(47545);
    if (this.lrf)
    {
      AppMethodBeat.o(47545);
      return;
    }
    ac.i("Luggage.MPPageNativeViewRenderer", "injectSharedEnvFields appId[%s]", new Object[] { getAppId() });
    bpH();
    dX("wxa_library/android.js", com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/android.js"));
    try
    {
      dX("WANativeRendering.js", "var __userAgent__ = 'Mozilla/5.0 (Linux; U; Android 8.1.1; en-us; LV) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30';" + com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/native/WANativeRendering.js"));
      dX("custom_backend_impl.js", com.tencent.mm.plugin.m.a.c.a.aP(getContext(), "wxa_library/native/custom_backend_impl.js"));
      this.lrf = true;
      AppMethodBeat.o(47545);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("Luggage.MPPageNativeViewRenderer", localException, "error", new Object[0]);
      }
    }
  }
  
  public final void Cf()
  {
    AppMethodBeat.i(47540);
    super.Cf();
    AppMethodBeat.o(47540);
  }
  
  public final void Cg()
  {
    AppMethodBeat.i(47541);
    super.Cg();
    AppMethodBeat.o(47541);
  }
  
  public final Map<String, m> Ch()
  {
    AppMethodBeat.i(47548);
    Map localMap = q.beI();
    AppMethodBeat.o(47548);
    return localMap;
  }
  
  public final void Ci()
  {
    AppMethodBeat.i(47549);
    super.Ci();
    com.tencent.mm.plugin.m.a.c.c localc = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.akv("page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.hB("inject_js_Start", "page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.hB("inject_page_js", "page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.hB("ui_create", "page_ready");
    AppMethodBeat.o(47549);
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(186863);
    parama = parama.scriptName;
    ac.i("Luggage.MPPageNativeViewRenderer", "reportBootstrapScriptEvaluateResult appId[%s] url[%s] name[%s] succeed[%b] injectCost[%d]", new Object[] { getAppId(), this.jZJ, parama, Boolean.valueOf(paramBoolean), Long.valueOf(paramLong2 - paramLong1) });
    if ("page-frame.html".equals(parama))
    {
      parama = com.tencent.mm.plugin.m.a.c.c.uAv;
      if (com.tencent.mm.plugin.m.a.c.c.akv("inject_js_End"))
      {
        parama = com.tencent.mm.plugin.m.a.c.c.uAv;
        com.tencent.mm.plugin.m.a.c.c.hB("inject_js_Start", "inject_js_End");
      }
      parama = com.tencent.mm.plugin.m.a.c.c.uAv;
      com.tencent.mm.plugin.m.a.c.c.akv("inject_page_js");
    }
    AppMethodBeat.o(186863);
  }
  
  public final boolean aUm()
  {
    return this.jgV;
  }
  
  public final boolean boA()
  {
    return this.lre;
  }
  
  public final bb boB()
  {
    AppMethodBeat.i(47547);
    bf local2 = new bf(this)
    {
      public final String OF(String paramAnonymousString)
      {
        AppMethodBeat.i(47538);
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          AppMethodBeat.o(47538);
          return null;
        }
        if (paramAnonymousString.equals(a.a(jdField_this)))
        {
          paramAnonymousString = ab.PN(be.d(jdField_this.CO(), paramAnonymousString));
          AppMethodBeat.o(47538);
          return paramAnonymousString;
        }
        paramAnonymousString = super.OF(paramAnonymousString);
        AppMethodBeat.o(47538);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(47547);
    return local2;
  }
  
  public final void boy()
  {
    AppMethodBeat.i(47543);
    this.lre = true;
    ((com.tencent.luggage.sdk.b.a.c)CM()).bey();
    com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)CM(), ((com.tencent.luggage.sdk.b.a.c)CM()).aUs());
    boz();
    this.jgV = true;
    AppMethodBeat.o(47543);
  }
  
  public final boolean cd(String paramString)
  {
    AppMethodBeat.i(47544);
    com.tencent.mm.plugin.m.a.a locala = (com.tencent.mm.plugin.m.a.a)this.lyE;
    Object localObject1 = locala.uzf;
    long l1 = ((LuggageNativeViewJni)localObject1).getPageViewPtr(((LuggageNativeViewJni)localObject1).cbN);
    com.tencent.mm.plugin.m.a.a.a locala1 = locala.uzh;
    long l2 = locala.uzf.cbN;
    localObject1 = (Activity)locala.mContext;
    Object localObject2 = new a.4(locala, locala);
    k.h(localObject1, "activity");
    k.h(paramString, "pagePath");
    k.h(locala, "container");
    k.h(localObject2, "eventHandler");
    com.tencent.mm.plugin.m.a.a.a.uzw.put(Integer.valueOf((int)l1), localObject2);
    localObject2 = locala1.uzs;
    Object localObject3 = (com.tencent.mm.plugin.m.a.a.b)com.tencent.mm.plugin.m.a.a.c.uzz;
    k.h(localObject3, "provider");
    ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).uzX = ((com.tencent.mm.plugin.m.a.a.b)localObject3);
    localObject2 = locala1.uzs;
    localObject3 = (Context)localObject1;
    k.h(localObject3, "context");
    ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).mContext = ((Context)localObject3);
    localObject1 = (com.tencent.mm.plugin.m.a.a.b.a)((com.tencent.mm.plugin.m.a.a.b.b)localObject2).uzU.get(Long.valueOf(l1));
    if (localObject1 == null)
    {
      localObject1 = ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).uzX;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = new com.tencent.mm.plugin.m.a.a.b.c((Context)localObject3, l1, (com.tencent.mm.plugin.m.a.a.b)localObject1);
      ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).uzU.put(Long.valueOf(l1), localObject1);
      localObject1 = (com.tencent.mm.plugin.m.a.a.b.a)localObject1;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.m.a.a.b.a)localObject1).setWxaWebView(locala);
      localObject3 = new HashMap();
      if (-1 == n.f((CharSequence)paramString, "/"))
      {
        ((Map)localObject3).put("workDir", paramString);
        ((Map)localObject3).put("renderPtr", Long.valueOf(l2));
        localObject4 = locala1.uzs;
        k.h(localObject1, "view");
        k.h(localObject3, "params");
        ((com.tencent.mm.plugin.m.a.a.b.b)localObject4).d((com.tencent.mm.plugin.m.a.a.b.a)localObject1);
        localObject2 = d.a.ae.b(new o[] { u.Q("viewId", Long.valueOf(((com.tencent.mm.plugin.m.a.a.b.a)localObject1).getViewId())) });
        ((Map)localObject2).putAll((Map)localObject3);
        localObject3 = ((com.tencent.mm.plugin.m.a.a.b.b)localObject4).uzr;
        localObject4 = com.tencent.mm.plugin.m.a.a.a.a.uzG;
        com.tencent.mm.plugin.m.a.a.a.a.daD().f(((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).uzv, "onCreate", localObject2);
        com.tencent.mm.plugin.m.a.a.b.b.a(locala1.uzs, (com.tencent.mm.plugin.m.a.a.b.a)localObject1, locala);
        locala.uzi = ((com.tencent.mm.plugin.m.a.a.b.a)localObject1);
        locala.uzi.getView().getViewTreeObserver().addOnGlobalLayoutListener(new a.3(locala));
        localObject2 = paramString.substring(0, paramString.lastIndexOf("/"));
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("/")) {
          localObject1 = "/".concat(String.valueOf(localObject2));
        }
        localObject2 = locala.uzf;
        ((LuggageNativeViewJni)localObject2).onPageViewCreate(((LuggageNativeViewJni)localObject2).cbN, (String)localObject1);
        boolean bool = super.cd(paramString);
        e.a((com.tencent.mm.plugin.appbrand.page.ae)CM());
        AppMethodBeat.o(47544);
        return bool;
      }
      Object localObject4 = (Map)localObject3;
      localObject2 = paramString.subSequence(0, n.f((CharSequence)paramString, "/"));
      if (n.d((CharSequence)localObject2, (CharSequence)"/")) {}
      for (;;)
      {
        ((Map)localObject4).put("workDir", localObject2);
        break;
        localObject2 = (CharSequence)("/" + (CharSequence)localObject2);
      }
    }
  }
  
  public final ay dH(Context paramContext)
  {
    AppMethodBeat.i(47539);
    aw.aKT("__appbrand_comm_lib__prefs");
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c();
    localc.setJsExceptionHandler(new h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47537);
        ac.e("MicroMsg.J2V8_Console", "Js Exception" + paramAnonymousString1 + "," + paramAnonymousString2);
        AppMethodBeat.o(47537);
      }
    });
    paramContext = new com.tencent.mm.plugin.m.a.a(paramContext, (aa)CM(), localc);
    AppMethodBeat.o(47539);
    return paramContext;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47542);
    Object localObject = com.tencent.mm.plugin.m.a.c.c.uAv;
    if (com.tencent.mm.plugin.m.a.c.c.akv("inject_js_Start"))
    {
      localObject = com.tencent.mm.plugin.m.a.c.c.uAv;
      com.tencent.mm.plugin.m.a.c.c.hB("ui_create", "inject_js_Start");
    }
    localObject = CO();
    if (((localObject instanceof f)) && ((this.lyE instanceof com.tencent.mm.plugin.m.a.a))) {
      ((com.tencent.mm.plugin.m.a.a)this.lyE).setFlutterRenderEngine(((f)localObject).lrw);
    }
    this.lre = false;
    super.dispatchStart();
    com.tencent.mm.plugin.appbrand.z.g.aH(getContext().getResources().getDisplayMetrics().density);
    localObject = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { Do().toString() });
    ((com.tencent.luggage.sdk.b.a.c)CM()).aUV().evaluateJavascript((String)localObject, null);
    ac.i("Luggage.MPPageNativeViewRenderer", "inject final __wxConfig appId[%s]", new Object[] { getAppId() });
    boz();
    localObject = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { cg.y("onWxConfigReady", "", 0) });
    ((com.tencent.luggage.sdk.b.a.c)CM()).aUV().evaluateJavascript((String)localObject, null);
    bpK();
    AppMethodBeat.o(47542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */