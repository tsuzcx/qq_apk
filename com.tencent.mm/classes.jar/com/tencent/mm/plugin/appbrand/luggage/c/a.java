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
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.ba;
import com.tencent.mm.plugin.appbrand.page.be;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.m.a.a.3;
import com.tencent.mm.plugin.m.a.a.4;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.n.n;
import d.o;
import d.u;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.appbrand.page.a<com.tencent.luggage.sdk.b.a.c>
  implements com.tencent.mm.plugin.appbrand.page.a.g
{
  private boolean jCY = false;
  private boolean lUP = false;
  private boolean lUQ = false;
  private final String lUR = "page-frame.html";
  
  public a(com.tencent.luggage.sdk.b.a.c paramc)
  {
    super(paramc);
  }
  
  private void btj()
  {
    AppMethodBeat.i(47545);
    if (this.lUQ)
    {
      AppMethodBeat.o(47545);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("Luggage.MPPageNativeViewRenderer", "injectSharedEnvFields appId[%s]", new Object[] { getAppId() });
    bus();
    ek("wxa_library/android.js", com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/android.js"));
    try
    {
      ek("WANativeRendering.js", "var __userAgent__ = 'Mozilla/5.0 (Linux; U; Android 8.1.1; en-us; LV) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30';" + com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/native/WANativeRendering.js"));
      ek("custom_backend_impl.js", com.tencent.mm.plugin.m.a.c.a.aU(getContext(), "wxa_library/native/custom_backend_impl.js"));
      this.lUQ = true;
      AppMethodBeat.o(47545);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("Luggage.MPPageNativeViewRenderer", localException, "error", new Object[0]);
      }
    }
  }
  
  public final void DH()
  {
    AppMethodBeat.i(47540);
    super.DH();
    AppMethodBeat.o(47540);
  }
  
  public final void DI()
  {
    AppMethodBeat.i(47541);
    super.DI();
    AppMethodBeat.o(47541);
  }
  
  public final Map<String, m> DJ()
  {
    AppMethodBeat.i(47548);
    Map localMap = q.biV();
    AppMethodBeat.o(47548);
    return localMap;
  }
  
  public final void DK()
  {
    AppMethodBeat.i(47549);
    super.DK();
    com.tencent.mm.plugin.m.a.c.c localc = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.aqn("page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.hU("inject_js_Start", "page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.hU("inject_page_js", "page_ready");
    localc = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.hU("ui_create", "page_ready");
    AppMethodBeat.o(47549);
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(222815);
    parama = parama.scriptName;
    com.tencent.mm.sdk.platformtools.ae.i("Luggage.MPPageNativeViewRenderer", "reportBootstrapScriptEvaluateResult appId[%s] url[%s] name[%s] succeed[%b] injectCost[%d]", new Object[] { getAppId(), this.kxv, parama, Boolean.valueOf(paramBoolean), Long.valueOf(paramLong2 - paramLong1) });
    if ("page-frame.html".equals(parama))
    {
      parama = com.tencent.mm.plugin.m.a.c.c.vPc;
      if (com.tencent.mm.plugin.m.a.c.c.aqn("inject_js_End"))
      {
        parama = com.tencent.mm.plugin.m.a.c.c.vPc;
        com.tencent.mm.plugin.m.a.c.c.hU("inject_js_Start", "inject_js_End");
      }
      parama = com.tencent.mm.plugin.m.a.c.c.vPc;
      com.tencent.mm.plugin.m.a.c.c.aqn("inject_page_js");
    }
    AppMethodBeat.o(222815);
  }
  
  public final boolean aXQ()
  {
    return this.jCY;
  }
  
  public final void bti()
  {
    AppMethodBeat.i(47543);
    this.lUP = true;
    ((com.tencent.luggage.sdk.b.a.c)Eo()).biL();
    com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)Eo(), ((com.tencent.luggage.sdk.b.a.c)Eo()).aXY());
    btj();
    this.jCY = true;
    AppMethodBeat.o(47543);
  }
  
  public final boolean btk()
  {
    return this.lUP;
  }
  
  public final ba btl()
  {
    AppMethodBeat.i(47547);
    be local2 = new be(this)
    {
      public final String SR(String paramAnonymousString)
      {
        AppMethodBeat.i(47538);
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          AppMethodBeat.o(47538);
          return null;
        }
        if (paramAnonymousString.equals(a.a(jdField_this)))
        {
          paramAnonymousString = aa.Uc(bg.d(jdField_this.Eq(), paramAnonymousString));
          AppMethodBeat.o(47538);
          return paramAnonymousString;
        }
        paramAnonymousString = super.SR(paramAnonymousString);
        AppMethodBeat.o(47538);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(47547);
    return local2;
  }
  
  public final boolean cZ(String paramString)
  {
    AppMethodBeat.i(47544);
    com.tencent.mm.plugin.m.a.a locala = (com.tencent.mm.plugin.m.a.a)this.mcJ;
    Object localObject1 = locala.vNM;
    long l1 = ((LuggageNativeViewJni)localObject1).getPageViewPtr(((LuggageNativeViewJni)localObject1).cmg);
    com.tencent.mm.plugin.m.a.a.a locala1 = locala.vNO;
    long l2 = locala.vNM.cmg;
    localObject1 = (Activity)locala.mContext;
    Object localObject2 = new a.4(locala, locala);
    p.h(localObject1, "activity");
    p.h(paramString, "pagePath");
    p.h(locala, "container");
    p.h(localObject2, "eventHandler");
    com.tencent.mm.plugin.m.a.a.a.vOd.put(Integer.valueOf((int)l1), localObject2);
    localObject2 = locala1.vNZ;
    Object localObject3 = (com.tencent.mm.plugin.m.a.a.b)com.tencent.mm.plugin.m.a.a.c.vOg;
    p.h(localObject3, "provider");
    ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).vOE = ((com.tencent.mm.plugin.m.a.a.b)localObject3);
    localObject2 = locala1.vNZ;
    localObject3 = (Context)localObject1;
    p.h(localObject3, "context");
    ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).mContext = ((Context)localObject3);
    localObject1 = (com.tencent.mm.plugin.m.a.a.b.a)((com.tencent.mm.plugin.m.a.a.b.b)localObject2).vOB.get(Long.valueOf(l1));
    if (localObject1 == null)
    {
      localObject1 = ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).vOE;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = new com.tencent.mm.plugin.m.a.a.b.c((Context)localObject3, l1, (com.tencent.mm.plugin.m.a.a.b)localObject1);
      ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).vOB.put(Long.valueOf(l1), localObject1);
      localObject1 = (com.tencent.mm.plugin.m.a.a.b.a)localObject1;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.m.a.a.b.a)localObject1).setWxaWebView(locala);
      localObject3 = new HashMap();
      if (-1 == n.g((CharSequence)paramString, "/"))
      {
        ((Map)localObject3).put("workDir", paramString);
        ((Map)localObject3).put("renderPtr", Long.valueOf(l2));
        localObject4 = locala1.vNZ;
        p.h(localObject1, "view");
        p.h(localObject3, "params");
        ((com.tencent.mm.plugin.m.a.a.b.b)localObject4).d((com.tencent.mm.plugin.m.a.a.b.a)localObject1);
        localObject2 = d.a.ae.b(new o[] { u.R("viewId", Long.valueOf(((com.tencent.mm.plugin.m.a.a.b.a)localObject1).getViewId())) });
        ((Map)localObject2).putAll((Map)localObject3);
        localObject3 = ((com.tencent.mm.plugin.m.a.a.b.b)localObject4).vNY;
        localObject4 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
        com.tencent.mm.plugin.m.a.a.a.a.dmP().g(((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).vOc, "onCreate", localObject2);
        com.tencent.mm.plugin.m.a.a.b.b.a(locala1.vNZ, (com.tencent.mm.plugin.m.a.a.b.a)localObject1, locala);
        locala.vNP = ((com.tencent.mm.plugin.m.a.a.b.a)localObject1);
        locala.vNP.getView().getViewTreeObserver().addOnGlobalLayoutListener(new a.3(locala));
        localObject2 = paramString.substring(0, paramString.lastIndexOf("/"));
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("/")) {
          localObject1 = "/".concat(String.valueOf(localObject2));
        }
        localObject2 = locala.vNM;
        ((LuggageNativeViewJni)localObject2).onPageViewCreate(((LuggageNativeViewJni)localObject2).cmg, (String)localObject1);
        boolean bool = super.cZ(paramString);
        e.a((ad)Eo());
        AppMethodBeat.o(47544);
        return bool;
      }
      Object localObject4 = (Map)localObject3;
      localObject2 = paramString.subSequence(0, n.g((CharSequence)paramString, "/"));
      if (n.d((CharSequence)localObject2, (CharSequence)"/")) {}
      for (;;)
      {
        ((Map)localObject4).put("workDir", localObject2);
        break;
        localObject2 = (CharSequence)("/" + (CharSequence)localObject2);
      }
    }
  }
  
  public final ax dJ(Context paramContext)
  {
    AppMethodBeat.i(47539);
    ay.aRW("__appbrand_comm_lib__prefs");
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c();
    localc.setJsExceptionHandler(new h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47537);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.J2V8_Console", "Js Exception" + paramAnonymousString1 + "," + paramAnonymousString2);
        AppMethodBeat.o(47537);
      }
    });
    paramContext = new com.tencent.mm.plugin.m.a.a(paramContext, (z)Eo(), localc);
    AppMethodBeat.o(47539);
    return paramContext;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47542);
    Object localObject = com.tencent.mm.plugin.m.a.c.c.vPc;
    if (com.tencent.mm.plugin.m.a.c.c.aqn("inject_js_Start"))
    {
      localObject = com.tencent.mm.plugin.m.a.c.c.vPc;
      com.tencent.mm.plugin.m.a.c.c.hU("ui_create", "inject_js_Start");
    }
    localObject = Eq();
    if (((localObject instanceof f)) && ((this.mcJ instanceof com.tencent.mm.plugin.m.a.a))) {
      ((com.tencent.mm.plugin.m.a.a)this.mcJ).setFlutterRenderEngine(((f)localObject).lVh);
    }
    this.lUP = false;
    super.dispatchStart();
    com.tencent.mm.plugin.appbrand.y.g.aK(getContext().getResources().getDisplayMetrics().density);
    localObject = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { EP().toString() });
    ((com.tencent.luggage.sdk.b.a.c)Eo()).aYB().evaluateJavascript((String)localObject, null);
    com.tencent.mm.sdk.platformtools.ae.i("Luggage.MPPageNativeViewRenderer", "inject final __wxConfig appId[%s]", new Object[] { getAppId() });
    btj();
    localObject = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { cj.z("onWxConfigReady", "", 0) });
    ((com.tencent.luggage.sdk.b.a.c)Eo()).aYB().evaluateJavascript((String)localObject, null);
    buv();
    AppMethodBeat.o(47542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */