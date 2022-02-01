package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class bj<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends a<PAGE>
  implements com.tencent.mm.plugin.appbrand.page.a.g
{
  private static final String[] mjE = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean mcL;
  private boolean mjA;
  private boolean mjB;
  private e mjC;
  private String mjD;
  private a mjF;
  private final bm.a mjG;
  private boolean mjz;
  
  protected bj(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(147471);
    this.mjz = false;
    this.mjA = false;
    this.mjB = false;
    this.mjC = null;
    this.mjG = new bm.a()
    {
      private final String lUR = "page-frame.html";
      private boolean mjL = false;
      private boolean mjM = false;
      private boolean mjN = false;
      
      private void btj()
      {
        AppMethodBeat.i(147464);
        bj.this.bus();
        if (!this.mjN)
        {
          if (bj.this.mcR) {
            bj.this.ek("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/webview_pf.js"));
          }
          this.mjN = true;
        }
        if (!this.mjL)
        {
          bj.this.ek("wxa_library/android.js", com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/android.js"));
          this.mjL = true;
        }
        if (!this.mjM)
        {
          bj.this.ek("WAWebview.js", bj.this.buu().SR("WAWebview.js"));
          this.mjM = true;
        }
        AppMethodBeat.o(147464);
      }
      
      private String bwd()
      {
        AppMethodBeat.i(147463);
        String str = bwc() + "page-frame.html";
        AppMethodBeat.o(147463);
        return str;
      }
      
      final String bwc()
      {
        AppMethodBeat.i(147462);
        String str = "https://servicewechat.com/" + String.format(Locale.US, "%s/%d/", new Object[] { bj.this.getAppId(), Integer.valueOf(bj.this.Eq().Ff().kbw.pkgVersion) });
        AppMethodBeat.o(147462);
        return str;
      }
      
      public final void bwe()
      {
        AppMethodBeat.i(147467);
        y.h((z)bj.this.Eo());
        Object localObject = bj.this;
        ((a)localObject).mcK = false;
        if (((a)localObject).mcV != null) {
          ((a)localObject).mcV.bvX();
        }
        ((a)localObject).cZ(((a)localObject).mcM);
        localObject = new n();
        z localz = (z)bj.this.Eo();
        com.tencent.luggage.sdk.b.a.c.c localc = ((com.tencent.luggage.sdk.b.a.c)bj.this.Eo()).Er();
        HashMap localHashMap = new HashMap();
        localHashMap.put("path", localz.kxv);
        ((n)localObject).H(localHashMap).a(localc, localz.aXX()).bja();
        AppMethodBeat.o(147467);
      }
      
      public final boolean bwf()
      {
        AppMethodBeat.i(147468);
        if (bj.this.mcJ.P(e.class) != null)
        {
          AppMethodBeat.o(147468);
          return false;
        }
        boolean bool = y.i((z)bj.this.Eo());
        if (bool)
        {
          bj.this.mcP.removeAll();
          this.mjL = false;
          this.mjM = false;
          this.mjN = false;
        }
        AppMethodBeat.o(147468);
        return bool;
      }
      
      public final String bwg()
      {
        AppMethodBeat.i(147469);
        String str = bwc();
        AppMethodBeat.o(147469);
        return str;
      }
      
      public final z bwh()
      {
        AppMethodBeat.i(147470);
        z localz = (z)bj.this.Eo();
        AppMethodBeat.o(147470);
        return localz;
      }
      
      public final void hl(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147465);
        ae.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(bj.this.hashCode()), Integer.valueOf(bj.this.bwb().hashCode()) });
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)bj.this.Eo(), ((com.tencent.luggage.sdk.b.a.c)bj.this.Eo()).aXY());
          btj();
          AppMethodBeat.o(147465);
          return;
        }
        Object localObject = bj.this;
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          ((com.tencent.luggage.sdk.b.a.c)((a)localObject).Eo()).aYB().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        while (!((com.tencent.luggage.sdk.b.a.c)((a)localObject).Eo()).jAe)
        {
          bj.this.bwb().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { bwd() }), null);
          bj.this.bwb().a(";(function(){return window.devicePixelRatio})();", new ValueCallback() {});
          localObject = bj.this.EP().toString();
          String str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { localObject });
          final long l = System.currentTimeMillis();
          bj.a(bj.this, new bj.a((byte)0));
          bj.b(bj.this).jDl = ((String)localObject);
          bj.b(bj.this).jDm = l;
          ae.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", new Object[] { Integer.valueOf(bj.this.hashCode()) });
          bj.this.bwb().a(bj.Uj("assignWxConfig"), str, new ValueCallback() {});
          btj();
          if ((bj.this.Eq().Ff().cmG) && (!bj.this.Eq().Fj())) {
            bj.this.ek("WAVConsole.js", ((ICommLibReader)bj.a(bj.this, ICommLibReader.class)).LD("WAVConsole.js"));
          }
          if (AppBrandPerformanceManager.e(bj.this.Eq())) {
            bj.this.ek("WAPerf.js", ((ICommLibReader)bj.b(bj.this, ICommLibReader.class)).LD("WAPerf.js"));
          }
          if (bj.this.Eq().Fj()) {
            bj.this.ek("WARemoteDebug.js", ((ICommLibReader)bj.c(bj.this, ICommLibReader.class)).LD("WARemoteDebug.js"));
          }
          localObject = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cj.z("onWxConfigReady", "", 0) });
          ae.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", new Object[] { Integer.valueOf(bj.this.hashCode()) });
          l = System.currentTimeMillis();
          bj.this.bwb().a(bj.Uj("onWxConfigReady"), (String)localObject, new ValueCallback() {});
          bj.c(bj.this);
          bj.this.buv();
          AppMethodBeat.o(147465);
          return;
        }
        localObject = new IllegalAccessError("Cannot find object_polyfill.js");
        AppMethodBeat.o(147465);
        throw ((Throwable)localObject);
      }
      
      public final void hm(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147466);
        if (paramAnonymousBoolean) {}
        for (String str1 = "https://servicewechat.com/preload/page-frame.html";; str1 = bwd())
        {
          String str2 = ((com.tencent.luggage.sdk.b.a.c)bj.this.Eo()).aWe().LD("WAPageFrame.html");
          ae.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(bj.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
            bj.this.bwb().Z(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(220848);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(bj.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                AppMethodBeat.o(220848);
              }
            });
          }
          bj.this.bwb().x(str1, str2);
          AppMethodBeat.o(147466);
          return;
        }
      }
    };
    AppMethodBeat.o(147471);
  }
  
  private void J(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(220850);
    String str = org.apache.commons.b.g.a(new String[] { paramString1, paramString2, paramString3 }, ":");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(220850);
      return;
    }
    this.mjD = str;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("appUrl", paramString2);
    localHashMap.put("appStatus", paramString3);
    ((bm)this.mcJ).setAppBrandInfo(localHashMap);
    if (((bm)this.mcJ).Ds()) {
      ((bm)this.mcJ).evaluateJavascript("document.title=\"" + r.VN(str) + "\"", null);
    }
    AppMethodBeat.o(220850);
  }
  
  private static URL Ui(String paramString)
  {
    AppMethodBeat.i(220852);
    try
    {
      paramString = new URL("https", "servicewechat.com", paramString);
      AppMethodBeat.o(220852);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      AppMethodBeat.o(220852);
    }
    return null;
  }
  
  public final void DH()
  {
    AppMethodBeat.i(147479);
    ae.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.kxv });
    super.DH();
    J(getAppId(), this.kxv, "VISIBLE");
    AppMethodBeat.o(147479);
  }
  
  public final void DI()
  {
    AppMethodBeat.i(147480);
    super.DI();
    J(getAppId(), this.kxv, "INVISIBLE");
    AppMethodBeat.o(147480);
  }
  
  public void DK()
  {
    AppMethodBeat.i(147477);
    ae.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { this.kxv });
    this.mcL = true;
    super.DK();
    this.mcI.invalidate();
    if (((com.tencent.luggage.sdk.b.a.c)Eo()).mgx)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageReady);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    }
    AppMethodBeat.o(147477);
  }
  
  public <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(147473);
    if (e.class == paramClass)
    {
      if (this.mjC == null)
      {
        final e locale = (e)this.mcJ.P(e.class);
        if (locale != null)
        {
          this.mjC = new e()
          {
            public final void bpJ()
            {
              AppMethodBeat.i(147456);
              locale.bpJ();
              AppMethodBeat.o(147456);
            }
            
            public final void bpK()
            {
              AppMethodBeat.i(147457);
              locale.bpK();
              if ((!TextUtils.isEmpty(bj.a(bj.this))) && (bj.this.bwb().Ds())) {
                bj.this.bwb().evaluateJavascript("document.title=\"" + r.VN(new StringBuilder().append(bj.a(bj.this)).append("(PAUSED)").toString()) + "\"", null);
              }
              AppMethodBeat.o(147457);
            }
          };
          paramClass = paramClass.cast(this.mjC);
          AppMethodBeat.o(147473);
          return paramClass;
        }
      }
      paramClass = paramClass.cast(this.mjC);
      AppMethodBeat.o(147473);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(147473);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(220853);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.scriptName)) && (!TextUtils.isEmpty(getAppId()))) {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramLong1, paramLong2);
    }
    if ((!this.mjB) && (Eo() != null) && (((com.tencent.luggage.sdk.b.a.c)Eo()).Eq() != null) && (TF("checkIsAppSharedPageFrameExecutionFinished").TJ(parama.scriptName))) {
      this.mjB = true;
    }
    AppMethodBeat.o(220853);
  }
  
  public final void a(Map<String, Object> paramMap, br parambr)
  {
    AppMethodBeat.i(147483);
    super.a(paramMap, parambr);
    Objects.requireNonNull(Eo());
    if (br.mki != parambr)
    {
      parambr = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)Eo()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
      if (parambr != null)
      {
        parambr = parambr.Un(this.kxv);
        if (TextUtils.isEmpty(parambr)) {}
      }
    }
    try
    {
      paramMap.put("initialRenderingCacheData", new JSONObject(parambr));
      parambr = new HashMap();
      paramMap.put("qualityData", parambr);
      parambr.put("navId", String.format(Locale.ENGLISH, "%d_%d", new Object[] { Integer.valueOf(((com.tencent.luggage.sdk.b.a.c)Eo()).aXX()), Long.valueOf(bu.fpO()) }));
      parambr.put("isWebviewPreload", Boolean.valueOf(((bm)this.mcJ).bwl()));
      parambr.put("isPreloadPageFrame", Boolean.valueOf(this.mjB));
      AppMethodBeat.o(147483);
      return;
    }
    catch (Exception parambr)
    {
      for (;;)
      {
        ae.printErrStackTrace("Luggage.MPPageViewRenderer", parambr, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
      }
    }
  }
  
  public final boolean aXQ()
  {
    AppMethodBeat.i(220851);
    if (((bm)this.mcJ != null) && (((bm)this.mcJ).aXQ()))
    {
      AppMethodBeat.o(220851);
      return true;
    }
    AppMethodBeat.o(220851);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(185225);
    if ((!this.mcL) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch"))) {
        break label153;
      }
      if (((com.tencent.luggage.sdk.b.a.c)Eo()).mgx)
      {
        if (!this.mjz)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
          this.mjz = true;
        }
        if (this.mjA)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.mjA = false;
        }
      }
      ae.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { getAppId(), this.kxv, paramString1, org.apache.commons.b.g.hH(paramString2, 20), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(185225);
      return false;
      label153:
      ae.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { getAppId(), this.kxv, paramString1, Integer.valueOf(bu.nullAsNil(paramString2).length()), Integer.valueOf(paramInt) });
    }
  }
  
  public final void bti()
  {
    AppMethodBeat.i(147475);
    ((com.tencent.luggage.sdk.b.a.c)Eo()).biL();
    ((bm)this.mcJ).bti();
    ((com.tencent.luggage.sdk.b.a.c)Eo()).biM();
    AppMethodBeat.o(147475);
  }
  
  public final boolean btk()
  {
    AppMethodBeat.i(147476);
    if (((bm)this.mcJ != null) && (((bm)this.mcJ).btk()))
    {
      AppMethodBeat.o(147476);
      return true;
    }
    AppMethodBeat.o(147476);
    return false;
  }
  
  protected ba btl()
  {
    AppMethodBeat.i(147486);
    ba localba = super.btl();
    AppMethodBeat.o(147486);
    return localba;
  }
  
  protected final void buw()
  {
    AppMethodBeat.i(147482);
    super.buw();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)Eo()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).Ul(this.kxv);
      localObject = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).Um(this.kxv);
      if (!TextUtils.isEmpty(str))
      {
        ae.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { this.kxv, Integer.valueOf(bu.nullAsNil(str).length()), Integer.valueOf(bu.nullAsNil((String)localObject).length()) });
        com.tencent.mm.plugin.appbrand.jsapi.t.a.a(str, (String)localObject, (z)Eo());
      }
    }
    AppMethodBeat.o(147482);
  }
  
  protected final bm bwb()
  {
    AppMethodBeat.i(147472);
    bm localbm = (bm)this.mcJ;
    AppMethodBeat.o(147472);
    return localbm;
  }
  
  public boolean cZ(String paramString)
  {
    AppMethodBeat.i(147481);
    this.mcL = false;
    this.mjz = false;
    this.mjA = false;
    ((bm)this.mcJ).Z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147459);
        final ViewGroup localViewGroup = bj.this.mcI;
        if (t.aC(localViewGroup)) {
          ((com.tencent.luggage.sdk.b.a.c)bj.this.Eo()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(147458);
              if (!t.aC(localViewGroup))
              {
                AppMethodBeat.o(147458);
                return;
              }
              if (!t.ay(localViewGroup))
              {
                ae.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { bj.this.kxv });
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
    boolean bool = super.cZ(paramString);
    J(getAppId(), this.kxv, "INITIAL");
    AppMethodBeat.o(147481);
    return bool;
  }
  
  protected ay dN(Context paramContext)
  {
    AppMethodBeat.i(147485);
    paramContext = new at(paramContext);
    AppMethodBeat.o(147485);
    return paramContext;
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(147478);
    super.dispatchStart();
    ((bm)this.mcJ).bwk();
    AppMethodBeat.o(147478);
  }
  
  protected void q(String paramString, long paramLong1, long paramLong2) {}
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220849);
    if (org.apache.commons.b.a.contains(mjE, paramString1))
    {
      ae.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { getAppId(), this.kxv, paramString1 });
      if ((Eo() != null) && (((com.tencent.luggage.sdk.b.a.c)Eo()).mgx) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.mjA = true;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
        if (this.mjz)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.mjA = false;
        }
      }
    }
    AppMethodBeat.o(220849);
    return false;
  }
  
  static final class a
  {
    String jDl;
    long jDm;
    long jDn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */