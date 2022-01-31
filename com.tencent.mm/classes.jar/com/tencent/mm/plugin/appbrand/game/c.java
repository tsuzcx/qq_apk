package com.tencent.mm.plugin.appbrand.game;

import android.graphics.Point;
import com.tencent.magicbrush.a.d.f;
import com.tencent.magicbrush.engine.MBRendererJNI;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.s;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.u.d;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.plugin.appbrand.v.l.2;
import com.tencent.mm.plugin.appbrand.v.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends p
  implements g
{
  private com.tencent.mm.plugin.appbrand.debugger.l fSN;
  private com.tencent.mm.plugin.appbrand.i.f fZI;
  private k fZJ;
  private long fZK;
  private long fZL;
  private long fZM;
  private long fZN;
  com.tencent.magicbrush.engine.e fZO = new com.tencent.magicbrush.engine.e();
  private boolean fZP = false;
  
  private boolean agb()
  {
    return this.fZJ != null;
  }
  
  private void agd()
  {
    if (this.fZI == null) {
      y.e("MicroMsg.WAGameAppService", "initSubContext Error. Engine == null");
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        return;
      } while (this.fZP);
      this.fZP = true;
      this.fZL = System.currentTimeMillis();
      this.fZJ.agu();
      y.i("MicroMsg.WAGameAppService", "Inject WAGame to MainContext");
      localObject1 = d.wB("wxa_library/android.js") + d.wB("wxa_library/NativeGlobal.js");
      com.tencent.mm.plugin.appbrand.v.k.a(this.fZI, (String)localObject1, new c.5(this));
      localObject2 = WxaCommLibRuntimeReader.qX("WAGame.js");
      localObject3 = "v" + WxaCommLibRuntimeReader.abQ().fEN;
      h.nFQ.a(778L, 13L, 1L, false);
      final long l = System.currentTimeMillis();
      final boolean bool = aan();
      if (localObject2 == null) {}
      for (int i = 0;; i = ((String)localObject2).length())
      {
        localObject1 = new k.a()
        {
          public final void fM(String paramAnonymousString)
          {
            int j = 0;
            y.e("MicroMsg.WAGameAppService", "Inject SDK WAGame Script Failed: %s", new Object[] { paramAnonymousString });
            if (c.this.getRuntime() != null) {
              c.this.getRuntime().fzG.n(11, System.currentTimeMillis() - c.k(c.this));
            }
            h.nFQ.a(778L, 14L, 1L, false);
            com.tencent.mm.plugin.appbrand.report.c.H(c.this.mAppId, 24, 0);
            int i = -1;
            paramAnonymousString = c.this.getRuntime();
            if (paramAnonymousString != null)
            {
              j = paramAnonymousString.aaa().fPS.fEN;
              i = paramAnonymousString.aaa().fPS.fEM;
            }
            com.tencent.mm.plugin.appbrand.report.c.a(c.this.mAppId, j, i, 778, 14);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            y.i("MicroMsg.WAGameAppService", "Inject SDK WAGame Script suc: %s", new Object[] { paramAnonymousString });
            com.tencent.mm.plugin.appbrand.report.quality.a.aov();
            com.tencent.mm.plugin.appbrand.report.quality.b.a(bool, c.this.mAppId, l, "WAGame.js", this.fAf);
            if (c.this.getRuntime() != null) {
              c.this.getRuntime().fzG.n(11, System.currentTimeMillis() - c.k(c.this));
            }
            h.nFQ.a(778L, 15L, 1L, false);
          }
        };
        if ((getRuntime() == null) || (!getRuntime().aah())) {
          break label356;
        }
        str = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);" + (String)localObject2;
        localObject3 = this.fZI;
        localObject2 = l.a.hlv;
        if (!bk.bl(str)) {
          break;
        }
        ((k.a)localObject1).fM("isNullOrNil script");
        return;
      }
      localObject3 = (com.tencent.mm.plugin.appbrand.i.i)((com.tencent.mm.plugin.appbrand.i.f)localObject3).I(com.tencent.mm.plugin.appbrand.i.i.class);
    } while (localObject3 == null);
    String str = str + String.format(";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    label356:
    try
    {
      localObject2 = new URL(com.tencent.mm.plugin.appbrand.v.l.a(this, (l.a)localObject2) + "WAGame.js");
      ((com.tencent.mm.plugin.appbrand.i.i)localObject3).a(str, ((URL)localObject2).toString(), new l.2((k.a)localObject1));
      return;
    }
    catch (MalformedURLException localMalformedURLException) {}
    com.tencent.mm.plugin.appbrand.v.l.a(this, this.fZI, "WAGame.js", "WAGame.js", (String)localObject3, (String)localObject2, l.a.hlv, (k.a)localObject1);
    return;
  }
  
  private void g(Runnable paramRunnable)
  {
    b localb = agc();
    if (localb != null)
    {
      localb.g(paramRunnable);
      return;
    }
    y.e("MicroMsg.WAGameAppService", "runOnRenderThread can't find the IRenderThreadHandler");
  }
  
  public final void C(int paramInt, String paramString)
  {
    if (!isRunning()) {
      return;
    }
    g(new c.3(this, paramInt, paramString));
  }
  
  public final boolean aaC()
  {
    return agb();
  }
  
  protected final void aao()
  {
    y.i("MicroMsg.WAGameAppService", "start preload");
    this.fzX = true;
    agd();
    y.i("MicroMsg.WAGameAppService", "WAGameAppService preloaded.");
  }
  
  public final com.tencent.mm.plugin.appbrand.i.f aat()
  {
    y.i("MicroMsg.WAGameAppService", "createJsRuntime");
    long l = System.currentTimeMillis();
    this.fZI = new f(com.tencent.mm.plugin.appbrand.i.r.alA(), this);
    this.fZJ = new k(this, this.fZI);
    y.i("MicroMsg.WAGameAppService", "createMagicBrush");
    e locale = i.gad.gae;
    if (locale == null) {
      throw new IllegalStateException("There is no mainJsContext here.");
    }
    com.tencent.magicbrush.engine.e locale1 = this.fZO;
    com.tencent.magicbrush.engine.c localc = ((e)locale).fZW;
    float f = com.tencent.mm.cb.a.getDensity(ae.getContext());
    int i = ((e)locale).fZV;
    d.f.i("MagicBrush", "JsContext %d, id %d", new Object[] { Long.valueOf(localc.bkz), Integer.valueOf(i) });
    locale1.bkI.nativeCreated(f, localc.bkz, i);
    com.tencent.mm.plugin.appbrand.report.quality.a.aov();
    com.tencent.mm.plugin.appbrand.report.quality.b.a(aan(), this.mAppId, l, com.tencent.mm.plugin.appbrand.report.a.gXw);
    this.fZN = (System.currentTimeMillis() - l);
    return this.fZI;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.i> aau()
  {
    return com.tencent.mm.plugin.appbrand.game.d.e.agz();
  }
  
  public final b agc()
  {
    if ((getRuntime() == null) || (getRuntime().aad() == null) || (getRuntime().aad().getCurrentPage() == null))
    {
      y.e("MicroMsg.WAGameAppService", "hy: one of the necessary elements is null!");
      return null;
    }
    q localq = getRuntime().aad().getCurrentPage().getCurrentPageView();
    if ((localq instanceof b)) {
      return (b)localq;
    }
    y.e("MicroMsg.WAGameAppService", "runOnRenderThread can't find the IRenderThreadHandler");
    return null;
  }
  
  protected final void cE(boolean paramBoolean)
  {
    super.cE(paramBoolean);
    if (this.fSN != null) {
      this.fSN.fSq.bringToFront();
    }
  }
  
  public final void cleanup()
  {
    super.cleanup();
    if (this.fSN != null) {
      this.fSN.destroy();
    }
  }
  
  protected final void h(JSONObject paramJSONObject)
  {
    super.h(paramJSONObject);
    AppBrandSysConfigWC localAppBrandSysConfigWC = getRuntime().aaa();
    Object localObject1 = null;
    try
    {
      localObject2 = paramJSONObject.optJSONObject("wxAppInfo");
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      label101:
      for (;;)
      {
        Object localObject2;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new JSONObject();
      try
      {
        localObject2 = new JSONArray();
        int i = 0;
        while (i < localAppBrandSysConfigWC.fQq.fOU.length)
        {
          ((JSONArray)localObject2).put(localAppBrandSysConfigWC.fQq.fOU[i]);
          i += 1;
        }
        a((JSONObject)localObject1, "subContextImgDomain", localObject2);
      }
      catch (Exception localException1)
      {
        float f;
        break label101;
      }
      a(paramJSONObject, "wxAppInfo", localObject1);
      localObject1 = new Point();
      l.gav.d((Point)localObject1);
      f = com.tencent.mm.cb.a.getDensity(getContext());
      y.i("MicroMsg.WAGameAppService", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(((Point)localObject1).x), Integer.valueOf(((Point)localObject1).y) });
      if (com.tencent.mm.plugin.appbrand.config.e.o(getRuntime()))
      {
        y.i("MicroMsg.WAGameAppService", "screen in right orientation");
        a(paramJSONObject, "screenWidth", Float.valueOf(((Point)localObject1).x / f));
        a(paramJSONObject, "screenHeight", Float.valueOf(((Point)localObject1).y / f));
      }
      for (;;)
      {
        a(paramJSONObject, "devicePixelRatio", Float.valueOf(f));
        a(paramJSONObject, "isIsolateContext", Boolean.valueOf(agb()));
        return;
        y.w("MicroMsg.WAGameAppService", "screen in reverse orientation");
        a(paramJSONObject, "screenWidth", Float.valueOf(((Point)localObject1).y / f));
        a(paramJSONObject, "screenHeight", Float.valueOf(((Point)localObject1).x / f));
      }
    }
  }
  
  public final void i(String paramString1, String paramString2, int paramInt)
  {
    if (!isRunning()) {
      return;
    }
    g(new c.4(this, paramString1, paramString2, paramInt));
  }
  
  protected final void i(JSONObject paramJSONObject)
  {
    super.i(paramJSONObject);
    a(paramJSONObject, "isIsolateContext", Boolean.valueOf(agb()));
  }
  
  public final void pT()
  {
    y.i("MicroMsg.WAGameAppService", "WAGameAppService.init");
    if (getRuntime() != null) {
      getRuntime().fzG.n(7, this.fZN);
    }
    g(new c.1(this, System.currentTimeMillis()));
  }
  
  public final void qJ(String paramString)
  {
    y.i("MicroMsg.WAGameAppService", "hy: do nothing in game service when called from modularizing helper");
  }
  
  public final String qK(String paramString)
  {
    if ((getRuntime() != null) && (getRuntime().aah())) {
      return com.tencent.mm.plugin.appbrand.debugger.r.a(paramString, getRuntime());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c
 * JD-Core Version:    0.7.0.1
 */