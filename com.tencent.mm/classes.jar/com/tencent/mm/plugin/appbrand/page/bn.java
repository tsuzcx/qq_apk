package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.r;
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

public class bn<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends a<PAGE>
  implements com.tencent.mm.plugin.appbrand.page.a.g
{
  private static final String[] ntX = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean nmZ;
  private boolean ntS;
  private boolean ntT;
  private boolean ntU;
  private e ntV;
  private String ntW;
  private a ntY;
  private final bq.a ntZ;
  
  protected bn(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(147471);
    this.ntS = false;
    this.ntT = false;
    this.ntU = false;
    this.ntV = null;
    this.ntZ = new bq.a()
    {
      private final String nue = "page-frame.html";
      private boolean nuf = false;
      private boolean nug = false;
      private boolean nuh = false;
      
      private String bSi()
      {
        AppMethodBeat.i(147463);
        String str = bSh() + "page-frame.html";
        AppMethodBeat.o(147463);
        return str;
      }
      
      private void bSj()
      {
        AppMethodBeat.i(147464);
        bn localbn = bn.this;
        Object localObject = new JSONObject();
        DisplayMetrics localDisplayMetrics = ((com.tencent.luggage.sdk.b.a.c)localbn.NN()).kEb.getVDisplayMetrics();
        localbn.c((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(localDisplayMetrics.widthPixels / localDisplayMetrics.density)));
        localbn.c((JSONObject)localObject, "pixelRatio", Float.valueOf(localDisplayMetrics.density));
        localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", new Object[] { ((JSONObject)localObject).toString(), ((JSONObject)localObject).toString() });
        ((com.tencent.luggage.sdk.b.a.c)localbn.NN()).getJsRuntime().evaluateJavascript((String)localObject, null);
        if (!this.nuh)
        {
          if (bn.this.nnf) {
            bn.this.eD("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/webview_pf.js"));
          }
          this.nuh = true;
        }
        if (!this.nuf)
        {
          bn.this.eD("wxa_library/android.js", com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js"));
          this.nuf = true;
        }
        if (!this.nug)
        {
          bn.this.eD("WAWebview.js", bn.this.bQt().adT("WAWebview.js"));
          this.nug = true;
        }
        AppMethodBeat.o(147464);
      }
      
      final String bSh()
      {
        AppMethodBeat.i(147462);
        String str = com.tencent.luggage.sdk.b.a.d.czw + String.format(Locale.US, "%s/%d/", new Object[] { bn.this.getAppId(), Integer.valueOf(bn.this.NP().OM().leE.pkgVersion) });
        AppMethodBeat.o(147462);
        return str;
      }
      
      public final void bSk()
      {
        AppMethodBeat.i(147467);
        ab.k((ac)bn.this.NN());
        Object localObject = bn.this;
        ((a)localObject).nmY = false;
        if (((a)localObject).nnj != null) {
          ((a)localObject).nnj.bSc();
        }
        ((a)localObject).dy(((a)localObject).nna);
        localObject = new q();
        ac localac = (ac)bn.this.NN();
        com.tencent.luggage.sdk.b.a.c.d locald = ((com.tencent.luggage.sdk.b.a.c)bn.this.NN()).NQ();
        HashMap localHashMap = new HashMap();
        localHashMap.put("path", localac.lBI);
        ((q)localObject).K(localHashMap).a(locald, localac.getComponentId()).bEo();
        AppMethodBeat.o(147467);
      }
      
      public final boolean bSl()
      {
        AppMethodBeat.i(147468);
        if (bn.this.nmX.R(e.class) != null)
        {
          AppMethodBeat.o(147468);
          return false;
        }
        boolean bool = ab.l((ac)bn.this.NN());
        if (bool)
        {
          bn.this.nnd.removeAll();
          this.nuf = false;
          this.nug = false;
          this.nuh = false;
        }
        AppMethodBeat.o(147468);
        return bool;
      }
      
      public final String bSm()
      {
        AppMethodBeat.i(147469);
        String str = bSh();
        AppMethodBeat.o(147469);
        return str;
      }
      
      public final ac bSn()
      {
        AppMethodBeat.i(147470);
        ac localac = (ac)bn.this.NN();
        AppMethodBeat.o(147470);
        return localac;
      }
      
      public final void im(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147465);
        Log.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(bn.this.hashCode()), Integer.valueOf(((bq)bn.this.nmX).hashCode()) });
        if (paramAnonymousBoolean)
        {
          l.a((com.tencent.luggage.sdk.b.a.c)bn.this.NN(), ((com.tencent.luggage.sdk.b.a.c)bn.this.NN()).bte());
          bSj();
          AppMethodBeat.o(147465);
          return;
        }
        Object localObject = bn.this;
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          ((com.tencent.luggage.sdk.b.a.c)((a)localObject).NN()).getJsRuntime().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        while (!((com.tencent.luggage.sdk.b.a.c)((a)localObject).NN()).kAU)
        {
          ((bq)bn.this.nmX).evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { bSi() }), null);
          ((bq)bn.this.nmX).a(";(function(){return window.devicePixelRatio})();", new ValueCallback() {});
          localObject = bn.this.Or().toString();
          String str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { localObject });
          final long l = System.currentTimeMillis();
          bn.a(bn.this, new bn.a((byte)0));
          bn.b(bn.this).kEm = ((String)localObject);
          bn.b(bn.this).kEn = l;
          Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", new Object[] { Integer.valueOf(bn.this.hashCode()) });
          ((bq)bn.this.nmX).a(bn.adX("assignWxConfig"), str, new ValueCallback() {});
          bSj();
          if ((bn.this.NP().OM().cyC) && (!bn.this.NP().OQ())) {
            bn.this.eD("WAVConsole.js", ((ICommLibReader)bn.a(bn.this, ICommLibReader.class)).UM("WAVConsole.js"));
          }
          if (AppBrandPerformanceManager.e(bn.this.NP())) {
            bn.this.eD("WAPerf.js", ((ICommLibReader)bn.b(bn.this, ICommLibReader.class)).UM("WAPerf.js"));
          }
          if (bn.this.NP().OQ()) {
            bn.this.eD("WARemoteDebug.js", ((ICommLibReader)bn.c(bn.this, ICommLibReader.class)).UM("WARemoteDebug.js"));
          }
          localObject = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cx.z("onWxConfigReady", "", 0) });
          Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", new Object[] { Integer.valueOf(bn.this.hashCode()) });
          l = System.currentTimeMillis();
          ((bq)bn.this.nmX).a(bn.adX("onWxConfigReady"), (String)localObject, new ValueCallback() {});
          bn.c(bn.this);
          bn.this.bQv();
          AppMethodBeat.o(147465);
          return;
        }
        localObject = new IllegalAccessError("Cannot find object_polyfill.js");
        AppMethodBeat.o(147465);
        throw ((Throwable)localObject);
      }
      
      public final void in(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147466);
        if (paramAnonymousBoolean) {}
        for (String str1 = com.tencent.luggage.sdk.b.a.d.czw + "preload/page-frame.html";; str1 = bSi())
        {
          String str2 = ((com.tencent.luggage.sdk.b.a.c)bn.this.NN()).bqZ().UM("WAPageFrame.html");
          Log.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(bn.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
            ((bq)bn.this.nmX).ag(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(229954);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(bn.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                AppMethodBeat.o(229954);
              }
            });
          }
          ((bq)bn.this.nmX).x(str1, str2);
          AppMethodBeat.o(147466);
          return;
        }
      }
    };
    AppMethodBeat.o(147471);
  }
  
  private void L(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(229956);
    String str = org.apache.commons.b.g.a(new String[] { paramString1, paramString2, paramString3 }, ":");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(229956);
      return;
    }
    this.ntW = str;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("appUrl", paramString2);
    localHashMap.put("appStatus", paramString3);
    ((bq)this.nmX).setAppBrandInfo(localHashMap);
    if (((bq)this.nmX).MO()) {
      ((bq)this.nmX).evaluateJavascript("document.title=\"" + r.afJ(str) + "\"", null);
    }
    AppMethodBeat.o(229956);
  }
  
  private static URL adW(String paramString)
  {
    AppMethodBeat.i(229958);
    try
    {
      paramString = new URL("https", WeChatHosts.domainString(2131761738), paramString);
      AppMethodBeat.o(229958);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      AppMethodBeat.o(229958);
    }
    return null;
  }
  
  public final void Nd()
  {
    AppMethodBeat.i(147479);
    Log.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.lBI });
    super.Nd();
    L(getAppId(), this.lBI, "VISIBLE");
    AppMethodBeat.o(147479);
  }
  
  public final void Ne()
  {
    AppMethodBeat.i(147480);
    super.Ne();
    L(getAppId(), this.lBI, "INVISIBLE");
    AppMethodBeat.o(147480);
  }
  
  public void Ng()
  {
    AppMethodBeat.i(147477);
    Log.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { this.lBI });
    this.nmZ = true;
    super.Ng();
    this.nmW.invalidate();
    if (((com.tencent.luggage.sdk.b.a.c)NN()).nqW)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageReady);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    }
    AppMethodBeat.o(147477);
  }
  
  public <T> T S(Class<T> paramClass)
  {
    AppMethodBeat.i(147473);
    if (e.class == paramClass)
    {
      if (this.ntV == null)
      {
        final e locale = (e)this.nmX.R(e.class);
        if (locale != null)
        {
          this.ntV = new e()
          {
            public final void bLp()
            {
              AppMethodBeat.i(147456);
              locale.bLp();
              AppMethodBeat.o(147456);
            }
            
            public final void bLq()
            {
              AppMethodBeat.i(147457);
              locale.bLq();
              if ((!TextUtils.isEmpty(bn.a(bn.this))) && (((bq)bn.this.nmX).MO())) {
                ((bq)bn.this.nmX).evaluateJavascript("document.title=\"" + r.afJ(new StringBuilder().append(bn.a(bn.this)).append("(PAUSED)").toString()) + "\"", null);
              }
              AppMethodBeat.o(147457);
            }
          };
          paramClass = paramClass.cast(this.ntV);
          AppMethodBeat.o(147473);
          return paramClass;
        }
      }
      paramClass = paramClass.cast(this.ntV);
      AppMethodBeat.o(147473);
      return paramClass;
    }
    paramClass = super.S(paramClass);
    AppMethodBeat.o(147473);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(229959);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.scriptName)) && (!TextUtils.isEmpty(getAppId()))) {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramLong1, paramLong2);
    }
    if ((!this.ntU) && (NN() != null) && (((com.tencent.luggage.sdk.b.a.c)NN()).NP() != null) && (ads("checkIsAppSharedPageFrameExecutionFinished").adw(parama.scriptName))) {
      this.ntU = true;
    }
    AppMethodBeat.o(229959);
  }
  
  public final void a(Map<String, Object> paramMap, bx parambx)
  {
    AppMethodBeat.i(147483);
    super.a(paramMap, parambx);
    Objects.requireNonNull(NN());
    if (bx.nuF != parambx)
    {
      parambx = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)NN()).M(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
      if (parambx != null)
      {
        parambx = parambx.aeb(this.lBI);
        if (TextUtils.isEmpty(parambx)) {}
      }
    }
    try
    {
      paramMap.put("initialRenderingCacheData", new JSONObject(parambx));
      parambx = new HashMap();
      paramMap.put("qualityData", parambx);
      parambx.put("navId", String.format(Locale.ENGLISH, "%d_%d", new Object[] { Integer.valueOf(((com.tencent.luggage.sdk.b.a.c)NN()).getComponentId()), Long.valueOf(Util.nowMilliSecond()) }));
      parambx.put("isWebviewPreload", Boolean.valueOf(((bq)this.nmX).bSr()));
      parambx.put("isPreloadPageFrame", Boolean.valueOf(this.ntU));
      paramMap.put("prerender", Boolean.valueOf(NP().OS()));
      AppMethodBeat.o(147483);
      return;
    }
    catch (Exception parambx)
    {
      for (;;)
      {
        Log.printErrStackTrace("Luggage.MPPageViewRenderer", parambx, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
      }
    }
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(185225);
    if ((!this.nmZ) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch"))) {
        break label153;
      }
      if (((com.tencent.luggage.sdk.b.a.c)NN()).nqW)
      {
        if (!this.ntS)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
          this.ntS = true;
        }
        if (this.ntT)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.ntT = false;
        }
      }
      Log.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { getAppId(), this.lBI, paramString1, org.apache.commons.b.g.id(paramString2, 20), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(185225);
      return false;
      label153:
      Log.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { getAppId(), this.lBI, paramString1, Integer.valueOf(Util.nullAsNil(paramString2).length()), Integer.valueOf(paramInt) });
    }
  }
  
  protected be bQu()
  {
    AppMethodBeat.i(147486);
    be localbe = super.bQu();
    AppMethodBeat.o(147486);
    return localbe;
  }
  
  protected final void bQw()
  {
    AppMethodBeat.i(147482);
    super.bQw();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)NN()).M(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).adZ(this.lBI);
      localObject = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).aea(this.lBI);
      if (!TextUtils.isEmpty(str))
      {
        Log.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { this.lBI, Integer.valueOf(Util.nullAsNil(str).length()), Integer.valueOf(Util.nullAsNil((String)localObject).length()) });
        com.tencent.mm.plugin.appbrand.jsapi.v.a.a(str, (String)localObject, (ac)NN());
      }
    }
    AppMethodBeat.o(147482);
  }
  
  public final void bRA()
  {
    AppMethodBeat.i(147475);
    ((com.tencent.luggage.sdk.b.a.c)NN()).bEb();
    ((bq)this.nmX).bRA();
    ((com.tencent.luggage.sdk.b.a.c)NN()).bEc();
    AppMethodBeat.o(147475);
  }
  
  public final boolean bSg()
  {
    AppMethodBeat.i(147476);
    if (((bq)this.nmX != null) && (((bq)this.nmX).bSg()))
    {
      AppMethodBeat.o(147476);
      return true;
    }
    AppMethodBeat.o(147476);
    return false;
  }
  
  public final boolean bsX()
  {
    AppMethodBeat.i(229957);
    if (((bq)this.nmX != null) && (((bq)this.nmX).bsX()))
    {
      AppMethodBeat.o(229957);
      return true;
    }
    AppMethodBeat.o(229957);
    return false;
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(147478);
    super.dispatchStart();
    ((bq)this.nmX).bSq();
    AppMethodBeat.o(147478);
  }
  
  public boolean dy(String paramString)
  {
    AppMethodBeat.i(147481);
    this.nmZ = false;
    this.ntS = false;
    this.ntT = false;
    ((bq)this.nmX).ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147459);
        final ViewGroup localViewGroup = bn.this.nmW;
        if (u.aD(localViewGroup)) {
          ((com.tencent.luggage.sdk.b.a.c)bn.this.NN()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(147458);
              if (!u.aD(localViewGroup))
              {
                AppMethodBeat.o(147458);
                return;
              }
              if (!u.az(localViewGroup))
              {
                Log.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { bn.this.lBI });
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
    boolean bool = super.dy(paramString);
    L(getAppId(), this.lBI, "INITIAL");
    AppMethodBeat.o(147481);
    return bool;
  }
  
  protected bc ej(Context paramContext)
  {
    AppMethodBeat.i(147485);
    paramContext = new aw(paramContext);
    AppMethodBeat.o(147485);
    return paramContext;
  }
  
  protected void q(String paramString, long paramLong1, long paramLong2) {}
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229955);
    if (org.apache.commons.b.a.contains(ntX, paramString1))
    {
      Log.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { getAppId(), this.lBI, paramString1 });
      if ((NN() != null) && (((com.tencent.luggage.sdk.b.a.c)NN()).nqW) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.ntT = true;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
        if (this.ntS)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.ntT = false;
        }
      }
    }
    AppMethodBeat.o(229955);
    return false;
  }
  
  static final class a
  {
    String kEm;
    long kEn;
    long kEo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bn
 * JD-Core Version:    0.7.0.1
 */