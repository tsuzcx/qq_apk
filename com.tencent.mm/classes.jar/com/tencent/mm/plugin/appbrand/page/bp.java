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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class bp<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends a<PAGE>
  implements com.tencent.mm.plugin.appbrand.page.b.g
{
  private static final String[] lfL = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean kWW;
  private boolean lfG;
  private boolean lfH;
  private boolean lfI;
  private e lfJ;
  private String lfK;
  private final bs.a lfM;
  
  protected bp(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(147471);
    this.lfG = false;
    this.lfH = false;
    this.lfI = false;
    this.lfJ = null;
    this.lfM = new bs.a()
    {
      private final String kPH = "page-frame.html";
      private boolean lfR = false;
      private boolean lfS = false;
      private boolean lfT = false;
      
      private void bhF()
      {
        AppMethodBeat.i(147464);
        bp.this.biO();
        if (!this.lfT)
        {
          if (bp.this.kXc) {
            bp.this.dL("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/webview_pf.js"));
          }
          this.lfT = true;
        }
        if (!this.lfR)
        {
          bp.this.dL("wxa_library/android.js", com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/android.js"));
          this.lfR = true;
        }
        if (!this.lfS)
        {
          bp.this.dL("WAWebview.js", bp.this.biQ().Ky("WAWebview.js"));
          this.lfS = true;
        }
        AppMethodBeat.o(147464);
      }
      
      private String bkC()
      {
        AppMethodBeat.i(147463);
        String str = bkB() + "page-frame.html";
        AppMethodBeat.o(147463);
        return str;
      }
      
      final String bkB()
      {
        AppMethodBeat.i(147462);
        String str = "https://servicewechat.com/" + String.format(Locale.US, "%s/%d/", new Object[] { bp.this.getAppId(), Integer.valueOf(bp.this.Dl().DY().jdS.pkgVersion) });
        AppMethodBeat.o(147462);
        return str;
      }
      
      public final void bkD()
      {
        AppMethodBeat.i(147467);
        z.i((aa)bp.this.Dj());
        Object localObject = bp.this;
        ((a)localObject).kWV = false;
        if (((a)localObject).kXg != null) {
          ((a)localObject).kXg.bkw();
        }
        ((a)localObject).cn(((a)localObject).kWX);
        localObject = new n();
        aa localaa = (aa)bp.this.Dj();
        com.tencent.luggage.sdk.b.a.c.c localc = ((com.tencent.luggage.sdk.b.a.c)bp.this.Dj()).Dm();
        HashMap localHashMap = new HashMap();
        localHashMap.put("path", localaa.jzm);
        ((n)localObject).B(localHashMap).a(localc, localaa.aOd()).aXQ();
        AppMethodBeat.o(147467);
      }
      
      public final boolean bkE()
      {
        AppMethodBeat.i(147468);
        if (bp.this.kWU.P(e.class) != null)
        {
          AppMethodBeat.o(147468);
          return false;
        }
        boolean bool = z.j((aa)bp.this.Dj());
        if (bool)
        {
          bp.this.kXa.removeAll();
          this.lfR = false;
          this.lfS = false;
          this.lfT = false;
        }
        AppMethodBeat.o(147468);
        return bool;
      }
      
      public final String bkF()
      {
        AppMethodBeat.i(147469);
        String str = bkB();
        AppMethodBeat.o(147469);
        return str;
      }
      
      public final aa bkG()
      {
        AppMethodBeat.i(147470);
        aa localaa = (aa)bp.this.Dj();
        AppMethodBeat.o(147470);
        return localaa;
      }
      
      public final void gI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147465);
        ad.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(bp.this.hashCode()), Integer.valueOf(bp.this.bkA().hashCode()) });
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)bp.this.Dj(), ((com.tencent.luggage.sdk.b.a.c)bp.this.Dj()).aNC());
          bhF();
          AppMethodBeat.o(147465);
          return;
        }
        Object localObject = bp.this;
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          ((com.tencent.luggage.sdk.b.a.c)((a)localObject).Dj()).aOf().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        while (!((com.tencent.luggage.sdk.b.a.c)((a)localObject).Dj()).iDV)
        {
          bp.this.bkA().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { bkC() }), null);
          bp.this.bkA().a(";(function(){return window.devicePixelRatio})();", new ValueCallback() {});
          localObject = bp.this.DL().toString();
          String str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { localObject });
          final long l = System.currentTimeMillis();
          bp.this.bkA().a(bp.LP("assignWxConfig"), str, new ValueCallback() {});
          bhF();
          if ((bp.this.Dl().DY().cfq) && (!bp.this.Dl().Ec())) {
            bp.this.dL("WAVConsole.js", ((ICommLibReader)bp.a(bp.this, ICommLibReader.class)).DH("WAVConsole.js"));
          }
          if (AppBrandPerformanceManager.d(bp.this.Dl())) {
            bp.this.dL("WAPerf.js", ((ICommLibReader)bp.b(bp.this, ICommLibReader.class)).DH("WAPerf.js"));
          }
          if (bp.this.Dl().Ec()) {
            bp.this.dL("WARemoteDebug.js", ((ICommLibReader)bp.c(bp.this, ICommLibReader.class)).DH("WARemoteDebug.js"));
          }
          localObject = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { cg.x("onWxConfigReady", "", 0) });
          bp.this.bkA().a(bp.LP("onWxConfigReady"), (String)localObject, new ValueCallback() {});
          bp.this.biR();
          AppMethodBeat.o(147465);
          return;
        }
        localObject = new IllegalAccessError("Cannot find object_polyfill.js");
        AppMethodBeat.o(147465);
        throw ((Throwable)localObject);
      }
      
      public final void gJ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147466);
        if (paramAnonymousBoolean) {}
        for (String str1 = "https://servicewechat.com/preload/page-frame.html";; str1 = bkC())
        {
          String str2 = ((com.tencent.luggage.sdk.b.a.c)bp.this.Dj()).aLC().DH("WAPageFrame.html");
          ad.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(bp.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
            bp.this.bkA().aa(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(186900);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(bp.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                AppMethodBeat.o(186900);
              }
            });
          }
          bp.this.bkA().u(str1, str2);
          AppMethodBeat.o(147466);
          return;
        }
      }
    };
    AppMethodBeat.o(147471);
  }
  
  private void LN(String paramString)
  {
    AppMethodBeat.i(147474);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147474);
      return;
    }
    this.lfK = paramString;
    if (!this.lfG) {
      bkA().evaluateJavascript("document.title=\"" + paramString + "\"", null);
    }
    AppMethodBeat.o(147474);
  }
  
  private static URL LO(String paramString)
  {
    AppMethodBeat.i(186903);
    try
    {
      paramString = new URL("https", "servicewechat.com", paramString);
      AppMethodBeat.o(186903);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      AppMethodBeat.o(186903);
    }
    return null;
  }
  
  public final void CB()
  {
    AppMethodBeat.i(147479);
    ad.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.jzm });
    super.CB();
    LN(org.apache.commons.b.g.a(new String[] { getAppId(), this.jzm, "VISIBLE" }, ":"));
    AppMethodBeat.o(147479);
  }
  
  public final void CC()
  {
    AppMethodBeat.i(147480);
    super.CC();
    LN(org.apache.commons.b.g.a(new String[] { getAppId(), this.jzm, "INVISIBLE" }, ":"));
    AppMethodBeat.o(147480);
  }
  
  public void CE()
  {
    AppMethodBeat.i(147477);
    ad.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { this.jzm });
    this.kWW = true;
    super.CE();
    this.kWT.invalidate();
    if (((com.tencent.luggage.sdk.b.a.c)Dj()).lbf)
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
      if (this.lfJ == null)
      {
        final e locale = (e)this.kWU.P(e.class);
        if (locale != null)
        {
          this.lfJ = new e()
          {
            public final void beu()
            {
              AppMethodBeat.i(147456);
              locale.beu();
              AppMethodBeat.o(147456);
            }
            
            public final void bev()
            {
              AppMethodBeat.i(147457);
              locale.bev();
              if (!TextUtils.isEmpty(bp.a(bp.this))) {
                bp.this.bkA().evaluateJavascript("document.title=\"" + bp.a(bp.this) + "(PAUSED)\"", null);
              }
              AppMethodBeat.o(147457);
            }
          };
          paramClass = paramClass.cast(this.lfJ);
          AppMethodBeat.o(147473);
          return paramClass;
        }
      }
      paramClass = paramClass.cast(this.lfJ);
      AppMethodBeat.o(147473);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(147473);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(186904);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.scriptName)) && (!TextUtils.isEmpty(getAppId()))) {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramLong1, paramLong2);
    }
    AppMethodBeat.o(186904);
  }
  
  public final void a(Map<String, Object> paramMap, by paramby)
  {
    AppMethodBeat.i(147483);
    super.a(paramMap, paramby);
    if (by.lgq != paramby)
    {
      paramby = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)Dj()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
      if (paramby != null)
      {
        paramby = paramby.LT(this.jzm);
        if (!TextUtils.isEmpty(paramby)) {
          try
          {
            paramMap.put("initialRenderingCacheData", new JSONObject(paramby));
            AppMethodBeat.o(147483);
            return;
          }
          catch (Exception paramMap)
          {
            ad.printErrStackTrace("Luggage.MPPageViewRenderer", paramMap, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(147483);
  }
  
  public final boolean aNw()
  {
    AppMethodBeat.i(186902);
    if ((bkA() != null) && (bkA().aNw()))
    {
      AppMethodBeat.o(186902);
      return true;
    }
    AppMethodBeat.o(186902);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(185225);
    if ((!this.kWW) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch"))) {
        break label153;
      }
      if (((com.tencent.luggage.sdk.b.a.c)Dj()).lbf)
      {
        if (!this.lfH)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
          this.lfH = true;
        }
        if (this.lfI)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.lfI = false;
        }
      }
      ad.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { getAppId(), this.jzm, paramString1, org.apache.commons.b.g.gM(paramString2, 20), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(185225);
      return false;
      label153:
      ad.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { getAppId(), this.jzm, paramString1, Integer.valueOf(bt.nullAsNil(paramString2).length()), Integer.valueOf(paramInt) });
    }
  }
  
  public final void bhE()
  {
    AppMethodBeat.i(147475);
    ((com.tencent.luggage.sdk.b.a.c)Dj()).aXB();
    bkA().bhE();
    ((com.tencent.luggage.sdk.b.a.c)Dj()).aXC();
    AppMethodBeat.o(147475);
  }
  
  public final boolean bhG()
  {
    AppMethodBeat.i(147476);
    if ((bkA() != null) && (bkA().bhG()))
    {
      AppMethodBeat.o(147476);
      return true;
    }
    AppMethodBeat.o(147476);
    return false;
  }
  
  protected bg bhH()
  {
    AppMethodBeat.i(147486);
    bg localbg = super.bhH();
    AppMethodBeat.o(147486);
    return localbg;
  }
  
  protected final void biS()
  {
    AppMethodBeat.i(147482);
    super.biS();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)Dj()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).LR(this.jzm);
      localObject = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).LS(this.jzm);
      if (!TextUtils.isEmpty(str))
      {
        ad.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { this.jzm, Integer.valueOf(bt.nullAsNil(str).length()), Integer.valueOf(bt.nullAsNil((String)localObject).length()) });
        com.tencent.mm.plugin.appbrand.jsapi.r.a.a(str, (String)localObject, (aa)Dj());
      }
    }
    AppMethodBeat.o(147482);
  }
  
  protected final bs bkA()
  {
    AppMethodBeat.i(147472);
    if (this.lfG)
    {
      localObject = new UnsupportedOperationException("ViewEngine Stashed after PageNotFound");
      AppMethodBeat.o(147472);
      throw ((Throwable)localObject);
    }
    Object localObject = (bs)this.kWU;
    AppMethodBeat.o(147472);
    return localObject;
  }
  
  public boolean cn(String paramString)
  {
    AppMethodBeat.i(147481);
    this.kWW = false;
    this.lfH = false;
    this.lfI = false;
    bkA().aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147459);
        final ViewGroup localViewGroup = bp.this.kWT;
        if (t.aC(localViewGroup)) {
          ((com.tencent.luggage.sdk.b.a.c)bp.this.Dj()).post(new Runnable()
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
                ad.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { bp.this.jzm });
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
    LN(org.apache.commons.b.g.a(new String[] { getAppId(), this.jzm, "INITIAL" }, ":"));
    boolean bool = super.cn(paramString);
    AppMethodBeat.o(147481);
    return bool;
  }
  
  protected be dB(Context paramContext)
  {
    AppMethodBeat.i(147485);
    paramContext = new az(paramContext);
    AppMethodBeat.o(147485);
    return paramContext;
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(147478);
    super.dispatchStart();
    bkA().bkJ();
    AppMethodBeat.o(147478);
  }
  
  protected void t(String paramString, long paramLong1, long paramLong2) {}
  
  public final boolean x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186901);
    if (org.apache.commons.b.a.contains(lfL, paramString1))
    {
      ad.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { getAppId(), this.jzm, paramString1 });
      if ((Dj() != null) && (((com.tencent.luggage.sdk.b.a.c)Dj()).lbf) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.lfI = true;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
        if (this.lfH)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.lfI = false;
        }
      }
    }
    AppMethodBeat.o(186901);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bp
 * JD-Core Version:    0.7.0.1
 */