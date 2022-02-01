package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import androidx.core.g.z;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class bp<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends a<PAGE>
  implements com.tencent.mm.plugin.appbrand.page.a.g
{
  private static final String[] tAJ = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean tAE;
  private boolean tAF;
  private boolean tAG;
  private e tAH;
  private String tAI;
  private a tAK;
  private final bs.a tAL;
  private boolean ttk;
  
  protected bp(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(147471);
    this.tAE = false;
    this.tAF = false;
    this.tAG = false;
    this.tAH = null;
    this.tAL = new bs.a()
    {
      private final String tAQ = "page-frame.html";
      private boolean tAR = false;
      private boolean tAS = false;
      private boolean tAT = false;
      
      private String cFV()
      {
        AppMethodBeat.i(147463);
        String str = cFU() + "page-frame.html";
        AppMethodBeat.o(147463);
        return str;
      }
      
      private void cFW()
      {
        AppMethodBeat.i(147464);
        bp localbp = bp.this;
        Object localObject = new JSONObject();
        DisplayMetrics localDisplayMetrics = ((com.tencent.luggage.sdk.b.a.c)localbp.aqX()).qwF.getVDisplayMetrics();
        int i = localDisplayMetrics.widthPixels;
        int j = localDisplayMetrics.heightPixels;
        localbp.d((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(i / localDisplayMetrics.density)));
        localbp.d((JSONObject)localObject, "pixelRatio", Float.valueOf(localDisplayMetrics.density));
        localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", new Object[] { ((JSONObject)localObject).toString(), ((JSONObject)localObject).toString() });
        ((com.tencent.luggage.sdk.b.a.c)localbp.aqX()).getJsRuntime().evaluateJavascript((String)localObject, null);
        if ((localbp.tth == null) || (!z.ay(localbp.tth))) {
          localbp.tti.cZ(i, j);
        }
        if (!this.tAT)
        {
          if (bp.this.ttq) {
            bp.this.fi("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/webview_pf.js"));
          }
          this.tAT = true;
        }
        if (!this.tAR)
        {
          bp.this.fi("wxa_library/android-webview.js", com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/android-webview.js"));
          this.tAR = true;
        }
        if (!this.tAS)
        {
          bp.this.fi("WAWebview.js", bp.this.cDH().aeU("WAWebview.js"));
          this.tAS = true;
        }
        AppMethodBeat.o(147464);
      }
      
      final String cFU()
      {
        AppMethodBeat.i(147462);
        String str = com.tencent.luggage.sdk.b.a.d.eqM + String.format(Locale.US, "%s/%d/", new Object[] { bp.this.getAppId(), Integer.valueOf(bp.this.aqZ().asz().qYY.pkgVersion) });
        AppMethodBeat.o(147462);
        return str;
      }
      
      public final void cFX()
      {
        AppMethodBeat.i(147467);
        ac.l((ad)bp.this.aqX());
        Object localObject = bp.this;
        ((a)localObject).ttj = false;
        if (((a)localObject).ttu != null) {
          ((a)localObject).ttu.ate();
        }
        ((a)localObject).b(((a)localObject).ttl, cb.tBv);
        localObject = new r();
        ad localad = (ad)bp.this.aqX();
        com.tencent.luggage.sdk.b.a.d.d locald = ((com.tencent.luggage.sdk.b.a.c)bp.this.aqX()).ara();
        HashMap localHashMap = new HashMap();
        localHashMap.put("path", localad.cgR());
        ((r)localObject).K(localHashMap).a(locald, localad.getComponentId()).cpV();
        AppMethodBeat.o(147467);
      }
      
      public final boolean cFY()
      {
        AppMethodBeat.i(147468);
        if (bp.this.tti.Z(e.class) != null)
        {
          AppMethodBeat.o(147468);
          return false;
        }
        boolean bool = ac.m((ad)bp.this.aqX());
        if (bool)
        {
          bp.this.tto.removeAll();
          this.tAR = false;
          this.tAS = false;
          this.tAT = false;
        }
        AppMethodBeat.o(147468);
        return bool;
      }
      
      public final String cFZ()
      {
        AppMethodBeat.i(147469);
        String str = cFU();
        AppMethodBeat.o(147469);
        return str;
      }
      
      public final ad cGa()
      {
        AppMethodBeat.i(147470);
        ad localad = (ad)bp.this.aqX();
        AppMethodBeat.o(147470);
        return localad;
      }
      
      public final void ku(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147465);
        Log.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(bp.this.hashCode()), Integer.valueOf(((bs)bp.this.tti).hashCode()) });
        if (paramAnonymousBoolean)
        {
          ((com.tencent.luggage.sdk.b.a.c)bp.this.aqX()).Y(((com.tencent.luggage.sdk.b.a.c)bp.this.aqX()).cdo());
          cFW();
          AppMethodBeat.o(147465);
          return;
        }
        Object localObject = bp.this;
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          ((com.tencent.luggage.sdk.b.a.c)((a)localObject).aqX()).getJsRuntime().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        while (!((com.tencent.luggage.sdk.b.a.c)((a)localObject).aqX()).qsQ)
        {
          ((bs)bp.this.tti).evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { cFV() }), null);
          ((bs)bp.this.tti).a(";(function(){return window.devicePixelRatio})();", new ValueCallback() {});
          localObject = bp.this.arC().toString();
          String str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { localObject });
          final long l = System.currentTimeMillis();
          bp.a(bp.this, new bp.a((byte)0));
          bp.b(bp.this).qwQ = ((String)localObject);
          bp.b(bp.this).qwR = l;
          Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", new Object[] { Integer.valueOf(bp.this.hashCode()) });
          ((bs)bp.this.tti).a(bp.aeY("assignWxConfig"), str, new ValueCallback() {});
          cFW();
          if ((bp.this.aqZ().asz().epz) && (!bp.this.aqZ().arD())) {
            bp.this.fi("WAVConsole.js", ((ICommLibReader)bp.a(bp.this, ICommLibReader.class)).UW("WAVConsole.js"));
          }
          if (AppBrandPerformanceManager.k(bp.this.aqZ())) {
            bp.this.fi("WAPerf.js", ((ICommLibReader)bp.b(bp.this, ICommLibReader.class)).UW("WAPerf.js"));
          }
          if (bp.this.aqZ().arD()) {
            bp.this.fi("WARemoteDebug.js", ((ICommLibReader)bp.c(bp.this, ICommLibReader.class)).UW("WARemoteDebug.js"));
          }
          localObject = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { di.H("onWxConfigReady", "", 0) });
          Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", new Object[] { Integer.valueOf(bp.this.hashCode()) });
          l = System.currentTimeMillis();
          ((bs)bp.this.tti).a(bp.aeY("onWxConfigReady"), (String)localObject, new ValueCallback() {});
          bp.c(bp.this);
          bp.this.atd();
          AppMethodBeat.o(147465);
          return;
        }
        localObject = new IllegalAccessError("Cannot find object_polyfill.js");
        AppMethodBeat.o(147465);
        throw ((Throwable)localObject);
      }
      
      public final void kv(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147466);
        if (paramAnonymousBoolean) {}
        for (String str1 = com.tencent.luggage.sdk.b.a.d.eqM + "preload/page-frame.html";; str1 = cFV())
        {
          String str2 = ((com.tencent.luggage.sdk.b.a.c)bp.this.aqX()).cbl().UW("WAPageFrame.html");
          Log.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(bp.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
            ((bs)bp.this.tti).n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(325184);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(bp.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                AppMethodBeat.o(325184);
              }
            });
          }
          ((bs)bp.this.tti).G(str1, str2);
          AppMethodBeat.o(147466);
          return;
        }
      }
    };
    AppMethodBeat.o(147471);
  }
  
  private void P(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(325009);
    String str = org.apache.commons.c.i.b(new String[] { paramString1, paramString2, paramString3 }, ":");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(325009);
      return;
    }
    this.tAI = str;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("appUrl", paramString2);
    localHashMap.put("appStatus", paramString3);
    ((bs)this.tti).setAppBrandInfo(localHashMap);
    if (((bs)this.tti).apQ()) {
      ((bs)this.tti).evaluateJavascript("document.title=\"" + y.agF(str) + "\"", null);
    }
    AppMethodBeat.o(325009);
  }
  
  private static URL aeX(String paramString)
  {
    AppMethodBeat.i(325016);
    try
    {
      paramString = new URL("https", WeChatHosts.domainString(a.g.host_servicewechat_com), paramString);
      AppMethodBeat.o(325016);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      AppMethodBeat.o(325016);
    }
    return null;
  }
  
  public final boolean H(String paramString1, String paramString2)
  {
    AppMethodBeat.i(325080);
    if (org.apache.commons.c.a.contains(tAJ, paramString1))
    {
      Log.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { getAppId(), this.rAF, paramString1 });
      if ((aqX() != null) && (((com.tencent.luggage.sdk.b.a.c)aqX()).txm) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.tAF = true;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
        if (this.tAE)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.tAF = false;
        }
      }
    }
    AppMethodBeat.o(325080);
    return false;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(325175);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.scriptName)) && (!TextUtils.isEmpty(getAppId()))) {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramLong1, paramLong2);
    }
    if ((!this.tAG) && (aqX() != null) && (((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ() != null) && (aeu("checkIsAppSharedPageFrameExecutionFinished").fG(parama.scriptName))) {
      this.tAG = true;
    }
    AppMethodBeat.o(325175);
  }
  
  public void a(Map<String, Object> paramMap, cb paramcb)
  {
    AppMethodBeat.i(147483);
    super.a(paramMap, paramcb);
    Objects.requireNonNull((com.tencent.luggage.sdk.b.a.c)aqX());
    if (cb.tBo != paramcb)
    {
      paramcb = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)aqX()).T(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
      if (paramcb != null)
      {
        paramcb = paramcb.aff(this.rAF);
        if (TextUtils.isEmpty(paramcb)) {}
      }
    }
    try
    {
      paramMap.put("initialRenderingCacheData", new JSONObject(paramcb));
      paramcb = new HashMap();
      paramMap.put("qualityData", paramcb);
      paramcb.put("navId", String.format(Locale.ENGLISH, "%d_%d", new Object[] { Integer.valueOf(((com.tencent.luggage.sdk.b.a.c)aqX()).getComponentId()), Long.valueOf(Util.nowMilliSecond()) }));
      paramcb.put("isWebviewPreload", Boolean.valueOf(((bs)this.tti).ata()));
      paramcb.put("isPreloadPageFrame", Boolean.valueOf(this.tAG));
      paramMap.put("prerender", Boolean.valueOf(aqZ().asE()));
      AppMethodBeat.o(147483);
      return;
    }
    catch (Exception paramcb)
    {
      for (;;)
      {
        Log.printErrStackTrace("Luggage.MPPageViewRenderer", paramcb, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
      }
    }
  }
  
  public <T> T aa(Class<T> paramClass)
  {
    AppMethodBeat.i(147473);
    if (e.class == paramClass)
    {
      if (this.tAH == null)
      {
        final e locale = (e)this.tti.Z(e.class);
        if (locale != null)
        {
          this.tAH = new e()
          {
            public final void cxC()
            {
              AppMethodBeat.i(147456);
              locale.cxC();
              AppMethodBeat.o(147456);
            }
            
            public final void cxD()
            {
              AppMethodBeat.i(147457);
              locale.cxD();
              if ((!TextUtils.isEmpty(bp.a(bp.this))) && (((bs)bp.this.tti).apQ())) {
                ((bs)bp.this.tti).evaluateJavascript("document.title=\"" + y.agF(new StringBuilder().append(bp.a(bp.this)).append("(PAUSED)").toString()) + "\"", null);
              }
              AppMethodBeat.o(147457);
            }
          };
          paramClass = paramClass.cast(this.tAH);
          AppMethodBeat.o(147473);
          return paramClass;
        }
      }
      paramClass = paramClass.cast(this.tAH);
      AppMethodBeat.o(147473);
      return paramClass;
    }
    paramClass = super.aa(paramClass);
    AppMethodBeat.o(147473);
    return paramClass;
  }
  
  public void aqe()
  {
    AppMethodBeat.i(147479);
    Log.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.rAF });
    super.aqe();
    P(getAppId(), this.rAF, "VISIBLE");
    AppMethodBeat.o(147479);
  }
  
  public final void aqf()
  {
    AppMethodBeat.i(147480);
    super.aqf();
    P(getAppId(), this.rAF, "INVISIBLE");
    AppMethodBeat.o(147480);
  }
  
  public void aqi()
  {
    AppMethodBeat.i(147477);
    Log.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { this.rAF });
    this.ttk = true;
    super.aqi();
    this.tth.invalidate();
    if (((com.tencent.luggage.sdk.b.a.c)aqX()).txm)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageReady);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    }
    AppMethodBeat.o(147477);
  }
  
  public final void asX()
  {
    AppMethodBeat.i(147475);
    ((com.tencent.luggage.sdk.b.a.c)aqX()).cpF();
    ((bs)this.tti).asX();
    ((com.tencent.luggage.sdk.b.a.c)aqX()).cpG();
    AppMethodBeat.o(147475);
  }
  
  public final boolean asZ()
  {
    AppMethodBeat.i(325103);
    if (((bs)this.tti != null) && (((bs)this.tti).asZ()))
    {
      AppMethodBeat.o(325103);
      return true;
    }
    AppMethodBeat.o(325103);
    return false;
  }
  
  public final boolean atb()
  {
    AppMethodBeat.i(147476);
    if (((bs)this.tti != null) && (((bs)this.tti).atb()))
    {
      AppMethodBeat.o(147476);
      return true;
    }
    AppMethodBeat.o(147476);
    return false;
  }
  
  public boolean b(String paramString, cb paramcb)
  {
    AppMethodBeat.i(325139);
    this.ttk = false;
    this.tAE = false;
    this.tAF = false;
    ((bs)this.tti).n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147459);
        final ViewGroup localViewGroup = bp.this.tth;
        if (z.ay(localViewGroup)) {
          ((com.tencent.luggage.sdk.b.a.c)bp.this.aqX()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(147458);
              if (!z.ay(localViewGroup))
              {
                AppMethodBeat.o(147458);
                return;
              }
              if (!z.au(localViewGroup))
              {
                Log.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { bp.this.rAF });
                localViewGroup.forceLayout();
                Object localObject = localViewGroup.getParent();
                ViewParent localViewParent;
                do
                {
                  ((View)localObject).forceLayout();
                  localViewParent = ((ViewParent)localObject).getParent();
                  localObject = localViewParent;
                } while ((localViewParent instanceof View));
                if (localViewParent != null) {
                  localViewParent.requestLayout();
                }
              }
              AppMethodBeat.o(147458);
            }
          });
        }
        AppMethodBeat.o(147459);
      }
    });
    boolean bool = super.b(paramString, paramcb);
    P(getAppId(), this.rAF, "INITIAL");
    AppMethodBeat.o(325139);
    return bool;
  }
  
  protected bg cDI()
  {
    AppMethodBeat.i(147486);
    bg localbg = super.cDI();
    AppMethodBeat.o(147486);
    return localbg;
  }
  
  protected final void cDK()
  {
    AppMethodBeat.i(147482);
    super.cDK();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)aqX()).T(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).afd(this.rAF);
      localObject = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).afe(this.rAF);
      if (!TextUtils.isEmpty(str))
      {
        Log.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { this.rAF, Integer.valueOf(Util.nullAsNil(str).length()), Integer.valueOf(Util.nullAsNil((String)localObject).length()) });
        com.tencent.mm.plugin.appbrand.jsapi.z.a.a(str, (String)localObject, (ad)aqX());
      }
    }
    AppMethodBeat.o(147482);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(147478);
    super.dispatchStart();
    ((bs)this.tti).asY();
    AppMethodBeat.o(147478);
  }
  
  public final boolean e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(185225);
    if ((!this.ttk) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch"))) {
        break label154;
      }
      if (((com.tencent.luggage.sdk.b.a.c)aqX()).txm)
      {
        if (!this.tAE)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
          this.tAE = true;
        }
        if (this.tAF)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.tAF = false;
        }
      }
      Log.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { getAppId(), this.rAF, paramString1, org.apache.commons.c.i.bD(paramString2, 0, 20), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(185225);
      return false;
      label154:
      Log.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { getAppId(), this.rAF, paramString1, Integer.valueOf(Util.nullAsNil(paramString2).length()), Integer.valueOf(paramInt) });
    }
  }
  
  protected be fd(Context paramContext)
  {
    AppMethodBeat.i(147485);
    paramContext = new ay(paramContext);
    AppMethodBeat.o(147485);
    return paramContext;
  }
  
  public bs fe(Context paramContext)
  {
    AppMethodBeat.i(325161);
    paramContext = new bt(fd(paramContext));
    paramContext.a(this.tAL);
    super.b(com.tencent.luggage.sdk.b.a.c.a.a.class, paramContext);
    AppMethodBeat.o(325161);
    return paramContext;
  }
  
  protected void s(String paramString, long paramLong1, long paramLong2) {}
  
  static final class a
  {
    String qwQ;
    long qwR;
    long qwS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bp
 * JD-Core Version:    0.7.0.1
 */