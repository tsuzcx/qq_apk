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
import java.util.Objects;
import org.json.JSONObject;

public class bk<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends a<PAGE>
  implements com.tencent.mm.plugin.appbrand.page.b.g
{
  private static final String[] mfj = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean lYe;
  private boolean mfe;
  private boolean mff;
  private boolean mfg;
  private e mfh;
  private String mfi;
  private a mfk;
  private final bn.a mfl;
  
  protected bk(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(147471);
    this.mfe = false;
    this.mff = false;
    this.mfg = false;
    this.mfh = null;
    this.mfl = new bn.a()
    {
      private final String lQq = "page-frame.html";
      private boolean mfq = false;
      private boolean mfr = false;
      private boolean mfs = false;
      
      private void bsy()
      {
        AppMethodBeat.i(147464);
        bk.this.btH();
        if (!this.mfs)
        {
          if (bk.this.lYk) {
            bk.this.eh("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/webview_pf.js"));
          }
          this.mfs = true;
        }
        if (!this.mfq)
        {
          bk.this.eh("wxa_library/android.js", com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/android.js"));
          this.mfq = true;
        }
        if (!this.mfr)
        {
          bk.this.eh("WAWebview.js", bk.this.btJ().Si("WAWebview.js"));
          this.mfr = true;
        }
        AppMethodBeat.o(147464);
      }
      
      private String bvs()
      {
        AppMethodBeat.i(147463);
        String str = bvr() + "page-frame.html";
        AppMethodBeat.o(147463);
        return str;
      }
      
      final String bvr()
      {
        AppMethodBeat.i(147462);
        String str = "https://servicewechat.com/" + String.format(Locale.US, "%s/%d/", new Object[] { bk.this.getAppId(), Integer.valueOf(bk.this.En().Fa().jYh.pkgVersion) });
        AppMethodBeat.o(147462);
        return str;
      }
      
      public final void bvt()
      {
        AppMethodBeat.i(147467);
        z.i((aa)bk.this.El());
        Object localObject = bk.this;
        ((a)localObject).lYd = false;
        if (((a)localObject).lYo != null) {
          ((a)localObject).lYo.bvm();
        }
        ((a)localObject).cX(((a)localObject).lYf);
        localObject = new o();
        aa localaa = (aa)bk.this.El();
        com.tencent.luggage.sdk.b.a.c.c localc = ((com.tencent.luggage.sdk.b.a.c)bk.this.El()).Eo();
        HashMap localHashMap = new HashMap();
        localHashMap.put("path", localaa.kuf);
        ((o)localObject).A(localHashMap).a(localc, localaa.aXC()).bir();
        AppMethodBeat.o(147467);
      }
      
      public final boolean bvu()
      {
        AppMethodBeat.i(147468);
        if (bk.this.lYc.P(e.class) != null)
        {
          AppMethodBeat.o(147468);
          return false;
        }
        boolean bool = z.j((aa)bk.this.El());
        if (bool)
        {
          bk.this.lYi.removeAll();
          this.mfq = false;
          this.mfr = false;
          this.mfs = false;
        }
        AppMethodBeat.o(147468);
        return bool;
      }
      
      public final String bvv()
      {
        AppMethodBeat.i(147469);
        String str = bvr();
        AppMethodBeat.o(147469);
        return str;
      }
      
      public final aa bvw()
      {
        AppMethodBeat.i(147470);
        aa localaa = (aa)bk.this.El();
        AppMethodBeat.o(147470);
        return localaa;
      }
      
      public final void hk(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147465);
        ad.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(bk.this.hashCode()), Integer.valueOf(bk.this.bvq().hashCode()) });
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)bk.this.El(), ((com.tencent.luggage.sdk.b.a.c)bk.this.El()).aXD());
          bsy();
          AppMethodBeat.o(147465);
          return;
        }
        Object localObject = bk.this;
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          ((com.tencent.luggage.sdk.b.a.c)((a)localObject).El()).aYh().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        while (!((com.tencent.luggage.sdk.b.a.c)((a)localObject).El()).jxf)
        {
          bk.this.bvq().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { bvs() }), null);
          bk.this.bvq().a(";(function(){return window.devicePixelRatio})();", new ValueCallback() {});
          localObject = bk.this.EN().toString();
          String str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { localObject });
          final long l = System.currentTimeMillis();
          bk.a(bk.this, new bk.a((byte)0));
          bk.b(bk.this).jAi = ((String)localObject);
          bk.b(bk.this).jAj = l;
          ad.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", new Object[] { Integer.valueOf(bk.this.hashCode()) });
          bk.this.bvq().a(bk.Tz("assignWxConfig"), str, new ValueCallback() {});
          bsy();
          if ((bk.this.En().Fa().cmE) && (!bk.this.En().Fe())) {
            bk.this.eh("WAVConsole.js", ((ICommLibReader)bk.a(bk.this, ICommLibReader.class)).Ld("WAVConsole.js"));
          }
          if (AppBrandPerformanceManager.e(bk.this.En())) {
            bk.this.eh("WAPerf.js", ((ICommLibReader)bk.b(bk.this, ICommLibReader.class)).Ld("WAPerf.js"));
          }
          if (bk.this.En().Fe()) {
            bk.this.eh("WARemoteDebug.js", ((ICommLibReader)bk.c(bk.this, ICommLibReader.class)).Ld("WARemoteDebug.js"));
          }
          localObject = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cj.z("onWxConfigReady", "", 0) });
          ad.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", new Object[] { Integer.valueOf(bk.this.hashCode()) });
          l = System.currentTimeMillis();
          bk.this.bvq().a(bk.Tz("onWxConfigReady"), (String)localObject, new ValueCallback() {});
          bk.c(bk.this);
          bk.this.btK();
          AppMethodBeat.o(147465);
          return;
        }
        localObject = new IllegalAccessError("Cannot find object_polyfill.js");
        AppMethodBeat.o(147465);
        throw ((Throwable)localObject);
      }
      
      public final void hl(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147466);
        if (paramAnonymousBoolean) {}
        for (String str1 = "https://servicewechat.com/preload/page-frame.html";; str1 = bvs())
        {
          String str2 = ((com.tencent.luggage.sdk.b.a.c)bk.this.El()).aVF().Ld("WAPageFrame.html");
          ad.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(bk.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
            bk.this.bvq().ab(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(192275);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(bk.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                AppMethodBeat.o(192275);
              }
            });
          }
          bk.this.bvq().x(str1, str2);
          AppMethodBeat.o(147466);
          return;
        }
      }
    };
    AppMethodBeat.o(147471);
  }
  
  private void Tx(String paramString)
  {
    AppMethodBeat.i(147474);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147474);
      return;
    }
    this.mfi = paramString;
    if (((bn)this.lYc).Dp()) {
      ((bn)this.lYc).evaluateJavascript("document.title=\"" + com.tencent.mm.plugin.appbrand.utils.p.Vc(paramString) + "\"", null);
    }
    AppMethodBeat.o(147474);
  }
  
  private static URL Ty(String paramString)
  {
    AppMethodBeat.i(192278);
    try
    {
      paramString = new URL("https", "servicewechat.com", paramString);
      AppMethodBeat.o(192278);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      AppMethodBeat.o(192278);
    }
    return null;
  }
  
  public final void DE()
  {
    AppMethodBeat.i(147479);
    ad.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.kuf });
    super.DE();
    Tx(org.apache.commons.b.g.a(new String[] { getAppId(), this.kuf, "VISIBLE" }, ":"));
    AppMethodBeat.o(147479);
  }
  
  public final void DF()
  {
    AppMethodBeat.i(147480);
    super.DF();
    Tx(org.apache.commons.b.g.a(new String[] { getAppId(), this.kuf, "INVISIBLE" }, ":"));
    AppMethodBeat.o(147480);
  }
  
  public void DH()
  {
    AppMethodBeat.i(147477);
    ad.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { this.kuf });
    this.lYe = true;
    super.DH();
    this.lYb.invalidate();
    if (((com.tencent.luggage.sdk.b.a.c)El()).mcf)
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
      if (this.mfh == null)
      {
        final e locale = (e)this.lYc.P(e.class);
        if (locale != null)
        {
          this.mfh = new e()
          {
            public final void boZ()
            {
              AppMethodBeat.i(147456);
              locale.boZ();
              AppMethodBeat.o(147456);
            }
            
            public final void bpa()
            {
              AppMethodBeat.i(147457);
              locale.bpa();
              if ((!TextUtils.isEmpty(bk.a(bk.this))) && (bk.this.bvq().Dp())) {
                bk.this.bvq().evaluateJavascript("document.title=\"" + com.tencent.mm.plugin.appbrand.utils.p.Vc(new StringBuilder().append(bk.a(bk.this)).append("(PAUSED)").toString()) + "\"", null);
              }
              AppMethodBeat.o(147457);
            }
          };
          paramClass = paramClass.cast(this.mfh);
          AppMethodBeat.o(147473);
          return paramClass;
        }
      }
      paramClass = paramClass.cast(this.mfh);
      AppMethodBeat.o(147473);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(147473);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(192279);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.scriptName)) && (!TextUtils.isEmpty(getAppId()))) {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramLong1, paramLong2);
    }
    if ((!this.mfg) && (El() != null) && (((com.tencent.luggage.sdk.b.a.c)El()).En() != null) && (SW("checkIsAppSharedPageFrameExecutionFinished").Ta(parama.scriptName))) {
      this.mfg = true;
    }
    AppMethodBeat.o(192279);
  }
  
  public final void a(Map<String, Object> paramMap, bs parambs)
  {
    AppMethodBeat.i(147483);
    super.a(paramMap, parambs);
    Objects.requireNonNull(El());
    if (bs.mfN != parambs)
    {
      parambs = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)El()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
      if (parambs != null)
      {
        parambs = parambs.TE(this.kuf);
        if (TextUtils.isEmpty(parambs)) {}
      }
    }
    try
    {
      paramMap.put("initialRenderingCacheData", new JSONObject(parambs));
      parambs = new HashMap();
      paramMap.put("qualityData", parambs);
      parambs.put("navId", String.format(Locale.ENGLISH, "%d_%d", new Object[] { Integer.valueOf(((com.tencent.luggage.sdk.b.a.c)El()).aXC()), Long.valueOf(bt.flT()) }));
      parambs.put("isWebviewPreload", Boolean.valueOf(((bn)this.lYc).bvA()));
      parambs.put("isPreloadPageFrame", Boolean.valueOf(this.mfg));
      AppMethodBeat.o(147483);
      return;
    }
    catch (Exception parambs)
    {
      for (;;)
      {
        ad.printErrStackTrace("Luggage.MPPageViewRenderer", parambs, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
      }
    }
  }
  
  public final boolean aXv()
  {
    AppMethodBeat.i(192277);
    if (((bn)this.lYc != null) && (((bn)this.lYc).aXv()))
    {
      AppMethodBeat.o(192277);
      return true;
    }
    AppMethodBeat.o(192277);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(185225);
    if ((!this.lYe) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch"))) {
        break label153;
      }
      if (((com.tencent.luggage.sdk.b.a.c)El()).mcf)
      {
        if (!this.mfe)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
          this.mfe = true;
        }
        if (this.mff)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.mff = false;
        }
      }
      ad.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { getAppId(), this.kuf, paramString1, org.apache.commons.b.g.hy(paramString2, 20), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(185225);
      return false;
      label153:
      ad.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { getAppId(), this.kuf, paramString1, Integer.valueOf(bt.nullAsNil(paramString2).length()), Integer.valueOf(paramInt) });
    }
  }
  
  protected bb bsA()
  {
    AppMethodBeat.i(147486);
    bb localbb = super.bsA();
    AppMethodBeat.o(147486);
    return localbb;
  }
  
  public final void bsx()
  {
    AppMethodBeat.i(147475);
    ((com.tencent.luggage.sdk.b.a.c)El()).bic();
    ((bn)this.lYc).bsx();
    ((com.tencent.luggage.sdk.b.a.c)El()).bid();
    AppMethodBeat.o(147475);
  }
  
  public final boolean bsz()
  {
    AppMethodBeat.i(147476);
    if (((bn)this.lYc != null) && (((bn)this.lYc).bsz()))
    {
      AppMethodBeat.o(147476);
      return true;
    }
    AppMethodBeat.o(147476);
    return false;
  }
  
  protected final void btL()
  {
    AppMethodBeat.i(147482);
    super.btL();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)((com.tencent.luggage.sdk.b.a.c)El()).K(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).TC(this.kuf);
      localObject = ((com.tencent.mm.plugin.appbrand.page.web_renderingcache.a)localObject).TD(this.kuf);
      if (!TextUtils.isEmpty(str))
      {
        ad.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { this.kuf, Integer.valueOf(bt.nullAsNil(str).length()), Integer.valueOf(bt.nullAsNil((String)localObject).length()) });
        com.tencent.mm.plugin.appbrand.jsapi.t.a.a(str, (String)localObject, (aa)El());
      }
    }
    AppMethodBeat.o(147482);
  }
  
  protected final bn bvq()
  {
    AppMethodBeat.i(147472);
    bn localbn = (bn)this.lYc;
    AppMethodBeat.o(147472);
    return localbn;
  }
  
  public boolean cX(String paramString)
  {
    AppMethodBeat.i(147481);
    this.lYe = false;
    this.mfe = false;
    this.mff = false;
    ((bn)this.lYc).ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147459);
        final ViewGroup localViewGroup = bk.this.lYb;
        if (t.aC(localViewGroup)) {
          ((com.tencent.luggage.sdk.b.a.c)bk.this.El()).post(new Runnable()
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
                ad.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { bk.this.kuf });
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
    Tx(org.apache.commons.b.g.a(new String[] { getAppId(), this.kuf, "INITIAL" }, ":"));
    boolean bool = super.cX(paramString);
    AppMethodBeat.o(147481);
    return bool;
  }
  
  protected az dJ(Context paramContext)
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
    ((bn)this.lYc).bvz();
    AppMethodBeat.o(147478);
  }
  
  protected void q(String paramString, long paramLong1, long paramLong2) {}
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192276);
    if (org.apache.commons.b.a.contains(mfj, paramString1))
    {
      ad.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { getAppId(), this.kuf, paramString1 });
      if ((El() != null) && (((com.tencent.luggage.sdk.b.a.c)El()).mcf) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.mff = true;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
        if (this.mfe)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
          this.mff = false;
        }
      }
    }
    AppMethodBeat.o(192276);
    return false;
  }
  
  static final class a
  {
    String jAi;
    long jAj;
    long jAk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */