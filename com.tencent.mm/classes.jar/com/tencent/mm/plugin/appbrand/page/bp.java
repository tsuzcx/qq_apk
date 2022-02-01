package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import androidx.core.g.w;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.t;
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
  private static final String[] qvS = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean qoH;
  private boolean qvN;
  private boolean qvO;
  private boolean qvP;
  private e qvQ;
  private String qvR;
  private a qvT;
  private final bs.a qvU;
  
  protected bp(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(147471);
    this.qvN = false;
    this.qvO = false;
    this.qvP = false;
    this.qvQ = null;
    this.qvU = new bs.a()
    {
      private final String qvZ = "page-frame.html";
      private boolean qwa = false;
      private boolean qwb = false;
      private boolean qwc = false;
      
      private String cfi()
      {
        AppMethodBeat.i(147463);
        String str = cfh() + "page-frame.html";
        AppMethodBeat.o(147463);
        return str;
      }
      
      private void cfj()
      {
        AppMethodBeat.i(147464);
        bp localbp = bp.this;
        Object localObject = new JSONObject();
        DisplayMetrics localDisplayMetrics = ((com.tencent.luggage.sdk.b.a.c)localbp.QK()).nxr.getVDisplayMetrics();
        localbp.c((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(localDisplayMetrics.widthPixels / localDisplayMetrics.density)));
        localbp.c((JSONObject)localObject, "pixelRatio", Float.valueOf(localDisplayMetrics.density));
        localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", new Object[] { ((JSONObject)localObject).toString(), ((JSONObject)localObject).toString() });
        ((com.tencent.luggage.sdk.b.a.c)localbp.QK()).getJsRuntime().evaluateJavascript((String)localObject, null);
        if (!this.qwc)
        {
          if (bp.this.qoN) {
            bp.this.eR("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/webview_pf.js"));
          }
          this.qwc = true;
        }
        if (!this.qwa)
        {
          bp.this.eR("wxa_library/android.js", com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/android.js"));
          this.qwa = true;
        }
        if (!this.qwb)
        {
          bp.this.eR("WAWebview.js", bp.this.cdj().alO("WAWebview.js"));
          this.qwb = true;
        }
        AppMethodBeat.o(147464);
      }
      
      final String cfh()
      {
        AppMethodBeat.i(147462);
        String str = com.tencent.luggage.sdk.b.a.d.cys + String.format(Locale.US, "%s/%d/", new Object[] { bp.this.getAppId(), Integer.valueOf(bp.this.QM().Sj().nYR.pkgVersion) });
        AppMethodBeat.o(147462);
        return str;
      }
      
      public final void cfk()
      {
        AppMethodBeat.i(147467);
        ac.k((ad)bp.this.QK());
        Object localObject = bp.this;
        ((a)localObject).qoG = false;
        if (((a)localObject).qoR != null) {
          ((a)localObject).qoR.ceZ();
        }
        ((a)localObject).b(((a)localObject).qoI, ca.qwG);
        localObject = new r();
        ad localad = (ad)bp.this.QK();
        com.tencent.luggage.sdk.b.a.c.d locald = ((com.tencent.luggage.sdk.b.a.c)bp.this.QK()).QN();
        HashMap localHashMap = new HashMap();
        localHashMap.put("path", localad.oxe);
        ((r)localObject).D(localHashMap).a(locald, localad.getComponentId()).bPO();
        AppMethodBeat.o(147467);
      }
      
      public final boolean cfl()
      {
        AppMethodBeat.i(147468);
        if (bp.this.qoF.Q(e.class) != null)
        {
          AppMethodBeat.o(147468);
          return false;
        }
        boolean bool = ac.l((ad)bp.this.QK());
        if (bool)
        {
          bp.this.qoL.removeAll();
          this.qwa = false;
          this.qwb = false;
          this.qwc = false;
        }
        AppMethodBeat.o(147468);
        return bool;
      }
      
      public final String cfm()
      {
        AppMethodBeat.i(147469);
        String str = cfh();
        AppMethodBeat.o(147469);
        return str;
      }
      
      public final ad cfn()
      {
        AppMethodBeat.i(147470);
        ad localad = (ad)bp.this.QK();
        AppMethodBeat.o(147470);
        return localad;
      }
      
      public final void jj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147465);
        Log.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(bp.this.hashCode()), Integer.valueOf(((bs)bp.this.qoF).hashCode()) });
        if (paramAnonymousBoolean)
        {
          ((com.tencent.luggage.sdk.b.a.c)bp.this.QK()).N(((com.tencent.luggage.sdk.b.a.c)bp.this.QK()).bEc());
          cfj();
          AppMethodBeat.o(147465);
          return;
        }
        Object localObject = bp.this;
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          ((com.tencent.luggage.sdk.b.a.c)((a)localObject).QK()).getJsRuntime().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        while (!((com.tencent.luggage.sdk.b.a.c)((a)localObject).QK()).nug)
        {
          ((bs)bp.this.qoF).evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { cfi() }), null);
          ((bs)bp.this.qoF).b(";(function(){return window.devicePixelRatio})();", new ValueCallback() {});
          localObject = bp.this.Ro().toString();
          String str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { localObject });
          final long l = System.currentTimeMillis();
          bp.a(bp.this, new bp.a((byte)0));
          bp.b(bp.this).nxC = ((String)localObject);
          bp.b(bp.this).nxD = l;
          Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", new Object[] { Integer.valueOf(bp.this.hashCode()) });
          ((bs)bp.this.qoF).a(bp.alS("assignWxConfig"), str, new ValueCallback() {});
          cfj();
          if ((bp.this.QM().Sj().cxh) && (!bp.this.QM().Rp())) {
            bp.this.eR("WAVConsole.js", ((ICommLibReader)bp.a(bp.this, ICommLibReader.class)).acw("WAVConsole.js"));
          }
          if (AppBrandPerformanceManager.k(bp.this.QM())) {
            bp.this.eR("WAPerf.js", ((ICommLibReader)bp.b(bp.this, ICommLibReader.class)).acw("WAPerf.js"));
          }
          if (bp.this.QM().Rp()) {
            bp.this.eR("WARemoteDebug.js", ((ICommLibReader)bp.c(bp.this, ICommLibReader.class)).acw("WARemoteDebug.js"));
          }
          localObject = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cy.C("onWxConfigReady", "", 0) });
          Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", new Object[] { Integer.valueOf(bp.this.hashCode()) });
          l = System.currentTimeMillis();
          ((bs)bp.this.qoF).a(bp.alS("onWxConfigReady"), (String)localObject, new ValueCallback() {});
          bp.c(bp.this);
          bp.this.cdl();
          AppMethodBeat.o(147465);
          return;
        }
        localObject = new IllegalAccessError("Cannot find object_polyfill.js");
        AppMethodBeat.o(147465);
        throw ((Throwable)localObject);
      }
      
      public final void jk(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147466);
        if (paramAnonymousBoolean) {}
        for (String str1 = com.tencent.luggage.sdk.b.a.d.cys + "preload/page-frame.html";; str1 = cfi())
        {
          String str2 = ((com.tencent.luggage.sdk.b.a.c)bp.this.QK()).bBP().acw("WAPageFrame.html");
          Log.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(bp.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
            ((bs)bp.this.qoF).aj(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(238306);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(bp.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                AppMethodBeat.o(238306);
              }
            });
          }
          ((bs)bp.this.qoF).B(str1, str2);
          AppMethodBeat.o(147466);
          return;
        }
      }
    };
    AppMethodBeat.o(147471);
  }
  
  private void K(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(237318);
    String str = org.apache.commons.b.g.a(new String[] { paramString1, paramString2, paramString3 }, ":");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(237318);
      return;
    }
    this.qvR = str;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("appUrl", paramString2);
    localHashMap.put("appStatus", paramString3);
    ((bs)this.qoF).setAppBrandInfo(localHashMap);
    if (((bs)this.qoF).PG()) {
      ((bs)this.qoF).evaluateJavascript("document.title=\"" + t.anl(str) + "\"", null);
    }
    AppMethodBeat.o(237318);
  }
  
  private static URL alR(String paramString)
  {
    AppMethodBeat.i(237327);
    try
    {
      paramString = new URL("https", WeChatHosts.domainString(a.g.host_servicewechat_com), paramString);
      AppMethodBeat.o(237327);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      AppMethodBeat.o(237327);
    }
    return null;
  }
  
  public final boolean C(String paramString1, String paramString2)
  {
    AppMethodBeat.i(237317);
    if (org.apache.commons.b.a.contains(qvS, paramString1))
    {
      Log.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { getAppId(), this.oxe, paramString1 });
      if ((QK() != null) && (((com.tencent.luggage.sdk.b.a.c)QK()).qsI) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.qvO = true;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
        if (this.qvN)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.qvO = false;
        }
      }
    }
    AppMethodBeat.o(237317);
    return false;
  }
  
  public void PV()
  {
    AppMethodBeat.i(147479);
    Log.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.oxe });
    super.PV();
    K(getAppId(), this.oxe, "VISIBLE");
    AppMethodBeat.o(147479);
  }
  
  public final void PW()
  {
    AppMethodBeat.i(147480);
    super.PW();
    K(getAppId(), this.oxe, "INVISIBLE");
    AppMethodBeat.o(147480);
  }
  
  public void PY()
  {
    AppMethodBeat.i(147477);
    Log.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { this.oxe });
    this.qoH = true;
    super.PY();
    this.qoE.invalidate();
    if (((com.tencent.luggage.sdk.b.a.c)QK()).qsI)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageReady);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    }
    AppMethodBeat.o(147477);
  }
  
  public <T> T R(Class<T> paramClass)
  {
    AppMethodBeat.i(147473);
    if (e.class == paramClass)
    {
      if (this.qvQ == null)
      {
        final e locale = (e)this.qoF.Q(e.class);
        if (locale != null)
        {
          this.qvQ = new e()
          {
            public final void bXq()
            {
              AppMethodBeat.i(147456);
              locale.bXq();
              AppMethodBeat.o(147456);
            }
            
            public final void bXr()
            {
              AppMethodBeat.i(147457);
              locale.bXr();
              if ((!TextUtils.isEmpty(bp.a(bp.this))) && (((bs)bp.this.qoF).PG())) {
                ((bs)bp.this.qoF).evaluateJavascript("document.title=\"" + t.anl(new StringBuilder().append(bp.a(bp.this)).append("(PAUSED)").toString()) + "\"", null);
              }
              AppMethodBeat.o(147457);
            }
          };
          paramClass = paramClass.cast(this.qvQ);
          AppMethodBeat.o(147473);
          return paramClass;
        }
      }
      paramClass = paramClass.cast(this.qvQ);
      AppMethodBeat.o(147473);
      return paramClass;
    }
    paramClass = super.R(paramClass);
    AppMethodBeat.o(147473);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(237329);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.scriptName)) && (!TextUtils.isEmpty(getAppId()))) {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramLong1, paramLong2);
    }
    if ((!this.qvP) && (QK() != null) && (((com.tencent.luggage.sdk.b.a.c)QK()).QM() != null) && (aln("checkIsAppSharedPageFrameExecutionFinished").alr(parama.scriptName))) {
      this.qvP = true;
    }
    AppMethodBeat.o(237329);
  }
  
  public final void a(Map<String, Object> paramMap, ca paramca)
  {
    AppMethodBeat.i(147483);
    super.a(paramMap, paramca);
    Objects.requireNonNull(QK());
    if (ca.qwz != paramca)
    {
      paramca = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)QK()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
      if (paramca != null)
      {
        paramca = paramca.alW(this.oxe);
        if (TextUtils.isEmpty(paramca)) {}
      }
    }
    try
    {
      paramMap.put("initialRenderingCacheData", new JSONObject(paramca));
      paramca = new HashMap();
      paramMap.put("qualityData", paramca);
      paramca.put("navId", String.format(Locale.ENGLISH, "%d_%d", new Object[] { Integer.valueOf(((com.tencent.luggage.sdk.b.a.c)QK()).getComponentId()), Long.valueOf(Util.nowMilliSecond()) }));
      paramca.put("isWebviewPreload", Boolean.valueOf(((bs)this.qoF).cfr()));
      paramca.put("isPreloadPageFrame", Boolean.valueOf(this.qvP));
      paramMap.put("prerender", Boolean.valueOf(QM().So()));
      AppMethodBeat.o(147483);
      return;
    }
    catch (Exception paramca)
    {
      for (;;)
      {
        Log.printErrStackTrace("Luggage.MPPageViewRenderer", paramca, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
      }
    }
  }
  
  public boolean b(String paramString, ca paramca)
  {
    AppMethodBeat.i(237322);
    this.qoH = false;
    this.qvN = false;
    this.qvO = false;
    ((bs)this.qoF).aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147459);
        final ViewGroup localViewGroup = bp.this.qoE;
        if (w.al(localViewGroup)) {
          ((com.tencent.luggage.sdk.b.a.c)bp.this.QK()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(147458);
              if (!w.al(localViewGroup))
              {
                AppMethodBeat.o(147458);
                return;
              }
              if (!w.ah(localViewGroup))
              {
                Log.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { bp.this.oxe });
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
    boolean bool = super.b(paramString, paramca);
    K(getAppId(), this.oxe, "INITIAL");
    AppMethodBeat.o(237322);
    return bool;
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(185225);
    if ((!this.qoH) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch"))) {
        break label154;
      }
      if (((com.tencent.luggage.sdk.b.a.c)QK()).qsI)
      {
        if (!this.qvN)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
          this.qvN = true;
        }
        if (this.qvO)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.qvO = false;
        }
      }
      Log.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { getAppId(), this.oxe, paramString1, org.apache.commons.b.g.bh(paramString2, 0, 20), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(185225);
      return false;
      label154:
      Log.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { getAppId(), this.oxe, paramString1, Integer.valueOf(Util.nullAsNil(paramString2).length()), Integer.valueOf(paramInt) });
    }
  }
  
  public final boolean bDV()
  {
    AppMethodBeat.i(237319);
    if (((bs)this.qoF != null) && (((bs)this.qoF).bDV()))
    {
      AppMethodBeat.o(237319);
      return true;
    }
    AppMethodBeat.o(237319);
    return false;
  }
  
  protected bg cdk()
  {
    AppMethodBeat.i(147486);
    bg localbg = super.cdk();
    AppMethodBeat.o(147486);
    return localbg;
  }
  
  protected final void cdm()
  {
    AppMethodBeat.i(147482);
    super.cdm();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)QK()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).alU(this.oxe);
      localObject = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).alV(this.oxe);
      if (!TextUtils.isEmpty(str))
      {
        Log.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { this.oxe, Integer.valueOf(Util.nullAsNil(str).length()), Integer.valueOf(Util.nullAsNil((String)localObject).length()) });
        com.tencent.mm.plugin.appbrand.jsapi.w.a.a(str, (String)localObject, (ad)QK());
      }
    }
    AppMethodBeat.o(147482);
  }
  
  public final void cer()
  {
    AppMethodBeat.i(147475);
    ((com.tencent.luggage.sdk.b.a.c)QK()).bPz();
    ((bs)this.qoF).cer();
    ((com.tencent.luggage.sdk.b.a.c)QK()).bPA();
    AppMethodBeat.o(147475);
  }
  
  public final boolean cfg()
  {
    AppMethodBeat.i(147476);
    if (((bs)this.qoF != null) && (((bs)this.qoF).cfg()))
    {
      AppMethodBeat.o(147476);
      return true;
    }
    AppMethodBeat.o(147476);
    return false;
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(147478);
    super.dispatchStart();
    ((bs)this.qoF).cfq();
    AppMethodBeat.o(147478);
  }
  
  protected be ei(Context paramContext)
  {
    AppMethodBeat.i(147485);
    paramContext = new ay(paramContext);
    AppMethodBeat.o(147485);
    return paramContext;
  }
  
  protected void q(String paramString, long paramLong1, long paramLong2) {}
  
  static final class a
  {
    String nxC;
    long nxD;
    long nxE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bp
 * JD-Core Version:    0.7.0.1
 */