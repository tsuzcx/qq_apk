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
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class bk<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends a<PAGE>
  implements com.tencent.mm.plugin.appbrand.page.b.g
{
  private static final String[] lFF = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean lFA;
  private boolean lFB;
  private boolean lFC;
  private e lFD;
  private String lFE;
  private final bn.a lFG;
  private boolean lyG;
  
  protected bk(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(147471);
    this.lFA = false;
    this.lFB = false;
    this.lFC = false;
    this.lFD = null;
    this.lFG = new bn.a()
    {
      private boolean lFL = false;
      private boolean lFM = false;
      private boolean lFN = false;
      private final String lrg = "page-frame.html";
      
      private void boz()
      {
        AppMethodBeat.i(147464);
        bk.this.bpH();
        if (!this.lFN)
        {
          if (bk.this.lyM) {
            bk.this.dX("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/webview_pf.js"));
          }
          this.lFN = true;
        }
        if (!this.lFL)
        {
          bk.this.dX("wxa_library/android.js", com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/android.js"));
          this.lFL = true;
        }
        if (!this.lFM)
        {
          bk.this.dX("WAWebview.js", bk.this.bpJ().OF("WAWebview.js"));
          this.lFM = true;
        }
        AppMethodBeat.o(147464);
      }
      
      private String brr()
      {
        AppMethodBeat.i(147463);
        String str = brq() + "page-frame.html";
        AppMethodBeat.o(147463);
        return str;
      }
      
      final String brq()
      {
        AppMethodBeat.i(147462);
        String str = "https://servicewechat.com/" + String.format(Locale.US, "%s/%d/", new Object[] { bk.this.getAppId(), Integer.valueOf(bk.this.CO().DB().jEg.pkgVersion) });
        AppMethodBeat.o(147462);
        return str;
      }
      
      public final void brs()
      {
        AppMethodBeat.i(147467);
        z.i((aa)bk.this.CM());
        Object localObject = bk.this;
        ((a)localObject).lyF = false;
        if (((a)localObject).lyQ != null) {
          ((a)localObject).lyQ.brl();
        }
        ((a)localObject).cd(((a)localObject).lyH);
        localObject = new o();
        aa localaa = (aa)bk.this.CM();
        com.tencent.luggage.sdk.b.a.c.c localc = ((com.tencent.luggage.sdk.b.a.c)bk.this.CM()).CP();
        HashMap localHashMap = new HashMap();
        localHashMap.put("path", localaa.jZJ);
        ((o)localObject).A(localHashMap).a(localc, localaa.aUT()).beN();
        AppMethodBeat.o(147467);
      }
      
      public final boolean brt()
      {
        AppMethodBeat.i(147468);
        if (bk.this.lyE.P(e.class) != null)
        {
          AppMethodBeat.o(147468);
          return false;
        }
        boolean bool = z.j((aa)bk.this.CM());
        if (bool)
        {
          bk.this.lyK.removeAll();
          this.lFL = false;
          this.lFM = false;
          this.lFN = false;
        }
        AppMethodBeat.o(147468);
        return bool;
      }
      
      public final String bru()
      {
        AppMethodBeat.i(147469);
        String str = brq();
        AppMethodBeat.o(147469);
        return str;
      }
      
      public final aa brv()
      {
        AppMethodBeat.i(147470);
        aa localaa = (aa)bk.this.CM();
        AppMethodBeat.o(147470);
        return localaa;
      }
      
      public final void hc(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147465);
        ac.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(bk.this.hashCode()), Integer.valueOf(bk.this.brp().hashCode()) });
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)bk.this.CM(), ((com.tencent.luggage.sdk.b.a.c)bk.this.CM()).aUs());
          boz();
          AppMethodBeat.o(147465);
          return;
        }
        Object localObject = bk.this;
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          ((com.tencent.luggage.sdk.b.a.c)((a)localObject).CM()).aUV().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        while (!((com.tencent.luggage.sdk.b.a.c)((a)localObject).CM()).jdX)
        {
          bk.this.brp().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { brr() }), null);
          bk.this.brp().a(";(function(){return window.devicePixelRatio})();", new ValueCallback() {});
          localObject = bk.this.Do().toString();
          String str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { localObject });
          final long l = System.currentTimeMillis();
          bk.this.brp().a(bk.PV("assignWxConfig"), str, new ValueCallback() {});
          boz();
          if ((bk.this.CO().DB().ccn) && (!bk.this.CO().DF())) {
            bk.this.dX("WAVConsole.js", ((ICommLibReader)bk.a(bk.this, ICommLibReader.class)).HL("WAVConsole.js"));
          }
          if (AppBrandPerformanceManager.d(bk.this.CO())) {
            bk.this.dX("WAPerf.js", ((ICommLibReader)bk.b(bk.this, ICommLibReader.class)).HL("WAPerf.js"));
          }
          if (bk.this.CO().DF()) {
            bk.this.dX("WARemoteDebug.js", ((ICommLibReader)bk.c(bk.this, ICommLibReader.class)).HL("WARemoteDebug.js"));
          }
          localObject = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { cg.y("onWxConfigReady", "", 0) });
          bk.this.brp().a(bk.PV("onWxConfigReady"), (String)localObject, new ValueCallback() {});
          bk.this.bpK();
          AppMethodBeat.o(147465);
          return;
        }
        localObject = new IllegalAccessError("Cannot find object_polyfill.js");
        AppMethodBeat.o(147465);
        throw ((Throwable)localObject);
      }
      
      public final void hd(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147466);
        if (paramAnonymousBoolean) {}
        for (String str1 = "https://servicewechat.com/preload/page-frame.html";; str1 = brr())
        {
          String str2 = ((com.tencent.luggage.sdk.b.a.c)bk.this.CM()).aSt().HL("WAPageFrame.html");
          ac.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(bk.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
            bk.this.brp().ac(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(206184);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(bk.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                AppMethodBeat.o(206184);
              }
            });
          }
          bk.this.brp().x(str1, str2);
          AppMethodBeat.o(147466);
          return;
        }
      }
    };
    AppMethodBeat.o(147471);
  }
  
  private void PT(String paramString)
  {
    AppMethodBeat.i(147474);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147474);
      return;
    }
    this.lFE = paramString;
    if (!this.lFA) {
      brp().evaluateJavascript("document.title=\"" + paramString + "\"", null);
    }
    AppMethodBeat.o(147474);
  }
  
  private static URL PU(String paramString)
  {
    AppMethodBeat.i(206187);
    try
    {
      paramString = new URL("https", "servicewechat.com", paramString);
      AppMethodBeat.o(206187);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      AppMethodBeat.o(206187);
    }
    return null;
  }
  
  public final void Cf()
  {
    AppMethodBeat.i(147479);
    ac.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.jZJ });
    super.Cf();
    PT(org.apache.commons.b.g.a(new String[] { getAppId(), this.jZJ, "VISIBLE" }, ":"));
    AppMethodBeat.o(147479);
  }
  
  public final void Cg()
  {
    AppMethodBeat.i(147480);
    super.Cg();
    PT(org.apache.commons.b.g.a(new String[] { getAppId(), this.jZJ, "INVISIBLE" }, ":"));
    AppMethodBeat.o(147480);
  }
  
  public void Ci()
  {
    AppMethodBeat.i(147477);
    ac.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { this.jZJ });
    this.lyG = true;
    super.Ci();
    this.lyD.invalidate();
    if (((com.tencent.luggage.sdk.b.a.c)CM()).lCE)
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
      if (this.lFD == null)
      {
        final e locale = (e)this.lyE.P(e.class);
        if (locale != null)
        {
          this.lFD = new e()
          {
            public final void blo()
            {
              AppMethodBeat.i(147456);
              locale.blo();
              AppMethodBeat.o(147456);
            }
            
            public final void blp()
            {
              AppMethodBeat.i(147457);
              locale.blp();
              if (!TextUtils.isEmpty(bk.a(bk.this))) {
                bk.this.brp().evaluateJavascript("document.title=\"" + bk.a(bk.this) + "(PAUSED)\"", null);
              }
              AppMethodBeat.o(147457);
            }
          };
          paramClass = paramClass.cast(this.lFD);
          AppMethodBeat.o(147473);
          return paramClass;
        }
      }
      paramClass = paramClass.cast(this.lFD);
      AppMethodBeat.o(147473);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(147473);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(206188);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.scriptName)) && (!TextUtils.isEmpty(getAppId()))) {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramLong1, paramLong2);
    }
    AppMethodBeat.o(206188);
  }
  
  public final void a(Map<String, Object> paramMap, bt parambt)
  {
    AppMethodBeat.i(147483);
    super.a(paramMap, parambt);
    if (bt.lGk != parambt)
    {
      parambt = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)CM()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
      if (parambt != null)
      {
        parambt = parambt.PZ(this.jZJ);
        if (!TextUtils.isEmpty(parambt)) {
          try
          {
            paramMap.put("initialRenderingCacheData", new JSONObject(parambt));
            AppMethodBeat.o(147483);
            return;
          }
          catch (Exception paramMap)
          {
            ac.printErrStackTrace("Luggage.MPPageViewRenderer", paramMap, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(147483);
  }
  
  public final boolean aUm()
  {
    AppMethodBeat.i(206186);
    if ((brp() != null) && (brp().aUm()))
    {
      AppMethodBeat.o(206186);
      return true;
    }
    AppMethodBeat.o(206186);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(185225);
    if ((!this.lyG) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch"))) {
        break label153;
      }
      if (((com.tencent.luggage.sdk.b.a.c)CM()).lCE)
      {
        if (!this.lFB)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
          this.lFB = true;
        }
        if (this.lFC)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.lFC = false;
        }
      }
      ac.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { getAppId(), this.jZJ, paramString1, org.apache.commons.b.g.gS(paramString2, 20), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(185225);
      return false;
      label153:
      ac.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { getAppId(), this.jZJ, paramString1, Integer.valueOf(bs.nullAsNil(paramString2).length()), Integer.valueOf(paramInt) });
    }
  }
  
  public final boolean boA()
  {
    AppMethodBeat.i(147476);
    if ((brp() != null) && (brp().boA()))
    {
      AppMethodBeat.o(147476);
      return true;
    }
    AppMethodBeat.o(147476);
    return false;
  }
  
  protected bb boB()
  {
    AppMethodBeat.i(147486);
    bb localbb = super.boB();
    AppMethodBeat.o(147486);
    return localbb;
  }
  
  public final void boy()
  {
    AppMethodBeat.i(147475);
    ((com.tencent.luggage.sdk.b.a.c)CM()).bey();
    brp().boy();
    ((com.tencent.luggage.sdk.b.a.c)CM()).bez();
    AppMethodBeat.o(147475);
  }
  
  protected final void bpL()
  {
    AppMethodBeat.i(147482);
    super.bpL();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)CM()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).PX(this.jZJ);
      localObject = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).PY(this.jZJ);
      if (!TextUtils.isEmpty(str))
      {
        ac.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { this.jZJ, Integer.valueOf(bs.nullAsNil(str).length()), Integer.valueOf(bs.nullAsNil((String)localObject).length()) });
        com.tencent.mm.plugin.appbrand.jsapi.q.a.a(str, (String)localObject, (aa)CM());
      }
    }
    AppMethodBeat.o(147482);
  }
  
  protected final bn brp()
  {
    AppMethodBeat.i(147472);
    if (this.lFA)
    {
      localObject = new UnsupportedOperationException("ViewEngine Stashed after PageNotFound");
      AppMethodBeat.o(147472);
      throw ((Throwable)localObject);
    }
    Object localObject = (bn)this.lyE;
    AppMethodBeat.o(147472);
    return localObject;
  }
  
  public boolean cd(String paramString)
  {
    AppMethodBeat.i(147481);
    this.lyG = false;
    this.lFB = false;
    this.lFC = false;
    brp().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147459);
        final ViewGroup localViewGroup = bk.this.lyD;
        if (t.aC(localViewGroup)) {
          ((com.tencent.luggage.sdk.b.a.c)bk.this.CM()).post(new Runnable()
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
                ac.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { bk.this.jZJ });
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
    PT(org.apache.commons.b.g.a(new String[] { getAppId(), this.jZJ, "INITIAL" }, ":"));
    boolean bool = super.cd(paramString);
    AppMethodBeat.o(147481);
    return bool;
  }
  
  protected az dK(Context paramContext)
  {
    AppMethodBeat.i(147485);
    paramContext = new au(paramContext);
    AppMethodBeat.o(147485);
    return paramContext;
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(147478);
    super.dispatchStart();
    brp().bry();
    AppMethodBeat.o(147478);
  }
  
  protected void q(String paramString, long paramLong1, long paramLong2) {}
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206185);
    if (org.apache.commons.b.a.contains(lFF, paramString1))
    {
      ac.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { getAppId(), this.jZJ, paramString1 });
      if ((CM() != null) && (((com.tencent.luggage.sdk.b.a.c)CM()).lCE) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.lFC = true;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
        if (this.lFB)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.lFC = false;
        }
      }
    }
    AppMethodBeat.o(206185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */