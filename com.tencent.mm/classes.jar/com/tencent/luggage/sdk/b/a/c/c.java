package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.b.a.a.e;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetTaskNetworkStateCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.be;
import com.tencent.mm.plugin.appbrand.debugger.l;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.debugger.y;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.plugin.appbrand.utils.u.b;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.protocal.protobuf.ffu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c<Service extends d>
  extends f<Service>
  implements l
{
  volatile boolean cAc;
  private volatile boolean cAd;
  private volatile boolean cAe;
  private final LinkedList<Runnable> cAf;
  private final Map<String, Boolean> cAg;
  private CronetLogic.CronetTaskNetworkStateCallback cuA;
  private com.tencent.mm.plugin.appbrand.debugger.q cum;
  private j cun;
  private o cup;
  private com.tencent.luggage.sdk.b.a.a.d cuu;
  private com.tencent.luggage.sdk.b.a.a.c cuv;
  private e cux;
  private com.tencent.luggage.sdk.b.a.d.b cuy;
  
  public c(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(146798);
    this.cAc = false;
    this.cAd = false;
    this.cAe = false;
    this.cum = null;
    this.cup = null;
    this.cuA = null;
    this.cAf = new LinkedList();
    this.cAg = new HashMap();
    b(l.class, this);
    AppMethodBeat.o(146798);
  }
  
  private void Pi()
  {
    AppMethodBeat.i(146806);
    try
    {
      Object localObject = ((d)QK()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(146806);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((com.tencent.mm.plugin.appbrand.m.i)localObject).Q(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).ke(-2);
      }
      AppMethodBeat.o(146806);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146806);
    }
  }
  
  private void Rg()
  {
    AppMethodBeat.i(146810);
    if (this.cAc)
    {
      AppMethodBeat.o(146810);
      return;
    }
    if (this.cAe)
    {
      AppMethodBeat.o(146810);
      return;
    }
    String str = ((d)QK()).QM().Sj().nYR.pkgPath;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(146810);
      return;
    }
    com.tencent.mm.plugin.appbrand.utils.v.a(((d)QK()).QM(), ((d)QK()).getJsRuntime(), str, "app-service.js", "", "", v.a.riQ, new d("app-service.js", (d)QK(), (byte)0));
    this.cAe = true;
    AppMethodBeat.o(146810);
  }
  
  private b Rh()
  {
    AppMethodBeat.i(146811);
    Object localObject1;
    if (this.cAc) {
      localObject1 = ((d)QK()).bBP().acw("WAServiceMainContext.js");
    }
    for (String str = "WAServiceMainContext.js";; str = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "WAService.js";
        localObject2 = ((d)QK()).bBP().acw("WAService.js");
      }
      localObject1 = new b();
      ((b)localObject1).name = str;
      ((b)localObject1).source = ((String)localObject2);
      AppMethodBeat.o(146811);
      return localObject1;
      localObject1 = null;
    }
  }
  
  private void ch(boolean paramBoolean)
  {
    AppMethodBeat.i(146812);
    Object localObject2;
    String str1;
    String str2;
    if (!this.cAd)
    {
      be.a((com.tencent.mm.plugin.appbrand.g)QK(), ((d)QK()).getJsRuntime());
      localObject1 = Pq();
      final long l = System.currentTimeMillis();
      u.a(((d)QK()).getJsRuntime(), (String)localObject1, new u.a()
      {
        public final void dL(String paramAnonymousString)
        {
          AppMethodBeat.i(237003);
          Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
          AppMethodBeat.o(237003);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(237001);
          Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
          long l1 = System.currentTimeMillis();
          long l2 = l;
          if (this.cAk) {}
          for (int i = 1;; i = 0)
          {
            com.tencent.mm.appbrand.v8.x.a(3, l1 - l2, i, ((d)c.this.QK()).getAppId(), -1, 0, ((d)c.this.QK()).bBP().bGi());
            AppMethodBeat.o(237001);
            return;
          }
        }
      });
      localObject2 = Rh();
      str1 = ((b)localObject2).name;
      str2 = ((b)localObject2).source;
      if (!TextUtils.isEmpty(((b)localObject2).cAm)) {
        break label302;
      }
      localObject1 = str1;
      if (!TextUtils.isEmpty(((b)localObject2).cAn)) {
        break label312;
      }
      localObject2 = "v" + ((d)QK()).bBP().bGi();
      label146:
      if ((((d)QK()).QM() == null) || (!((d)QK()).QM().Rp())) {
        break label322;
      }
      localObject1 = ((d)QK()).bBP().acw("WAServiceRemoteDebug.js");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label380;
      }
    }
    label302:
    label312:
    label322:
    label380:
    for (Object localObject1 = (String)localObject1 + ";";; localObject1 = "")
    {
      com.tencent.mm.plugin.appbrand.utils.v.a((com.tencent.mm.plugin.appbrand.v)QK(), ((d)QK()).getJsRuntime(), str1, (String)localObject1 + str2, v.a.riP, new c(str1, str2, (d)QK(), paramBoolean, (byte)0));
      for (;;)
      {
        this.cAd = true;
        AppMethodBeat.o(146812);
        return;
        localObject1 = ((b)localObject2).cAm;
        break;
        localObject2 = ((b)localObject2).cAn;
        break label146;
        com.tencent.mm.plugin.appbrand.utils.v.a((com.tencent.mm.plugin.appbrand.v)QK(), ((d)QK()).getJsRuntime(), str1, (String)localObject1, (String)localObject2, Pr(), str2, v.a.riP, new c(str1, str2, (d)QK(), paramBoolean, (byte)0));
      }
    }
  }
  
  protected void F(String paramString1, String paramString2) {}
  
  public final String OZ()
  {
    AppMethodBeat.i(237147);
    Object localObject = ((d)QK()).Ro();
    String str = ((d)QK()).QM().getAppConfig().nWl;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(237147);
    return localObject;
  }
  
  public final boolean Pb()
  {
    return this.cAc;
  }
  
  protected com.tencent.mm.plugin.appbrand.m.i Pc()
  {
    AppMethodBeat.i(146799);
    com.tencent.mm.plugin.appbrand.m.c localc = new com.tencent.mm.plugin.appbrand.m.c((byte)0);
    AppMethodBeat.o(146799);
    return localc;
  }
  
  protected void Pd()
  {
    AppMethodBeat.i(146800);
    super.Pd();
    final com.tencent.mm.plugin.appbrand.m.i locali = ((d)QK()).getJsRuntime();
    Object localObject = (com.tencent.mm.plugin.appbrand.m.t)locali.Q(com.tencent.mm.plugin.appbrand.m.t.class);
    if (localObject != null)
    {
      localObject = a((com.tencent.mm.plugin.appbrand.m.t)localObject);
      locali.addJavascriptInterface(localObject, "WeixinJSContext");
      locali.evaluateJavascript(h.cAz, null);
      ((b)localObject).PB();
    }
    for (this.cAc = true;; this.cAc = false)
    {
      if ((QM() != null) && (QM().Rp()))
      {
        Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "run in debug mode, add MPRemoteDebugJSContextInterface");
        QK();
        this.cun = new j();
        locali.addJavascriptInterface(this.cun, "DebuggerConnection");
        if (this.cum != null) {
          this.cun.cAB = this.cum;
        }
      }
      locali.setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.m.h()
      {
        public final void A(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146789);
          Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.t.anl(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.t.anl(paramAnonymousString2) });
          cy.a(locali, "onError", str, 0);
          c.this.F(paramAnonymousString1, paramAnonymousString2);
          Log.e("MicroMsg.AppBrand.JsRuntimeException", str);
          AppMethodBeat.o(146789);
        }
      });
      this.cuu = new com.tencent.luggage.sdk.b.a.a.d();
      this.cuu.b(locali, QK());
      this.cuv = new com.tencent.luggage.sdk.b.a.a.c();
      this.cuv.a(locali, QK());
      this.cux = new e();
      this.cux.a(((d)QK()).getJsRuntime(), QK(), 0);
      this.cuy = new com.tencent.luggage.sdk.b.a.d.b();
      this.cuy.c(locali, QK());
      com.tencent.mm.plugin.appbrand.jsapi.ai.b.d.a(locali, (com.tencent.mm.plugin.appbrand.v)QK());
      AppMethodBeat.o(146800);
      return;
    }
  }
  
  protected void Pe()
  {
    AppMethodBeat.i(146809);
    super.Pe();
    if (this.cuu != null) {
      this.cuu.b(((d)QK()).getJsRuntime());
    }
    if (this.cuv != null) {
      this.cuv.a(((d)QK()).getJsRuntime());
    }
    if (this.cux != null) {
      this.cux.c(((d)QK()).getJsRuntime());
    }
    if (this.cuy != null) {
      this.cuy.d(((d)QK()).getJsRuntime());
    }
    if (this.cuA != null) {
      CronetLogic.removeCronetTaskNetworkStateCallback(this.cuA);
    }
    AppMethodBeat.o(146809);
  }
  
  protected void Pf()
  {
    AppMethodBeat.i(237132);
    super.Pf();
    if (this.cum != null) {
      this.cum.destroy();
    }
    AppMethodBeat.o(237132);
  }
  
  public final void Po()
  {
    AppMethodBeat.i(146804);
    super.Po();
    Pi();
    if (this.cum != null) {
      this.cum.odf.bringToFront();
    }
    AppMethodBeat.o(146804);
  }
  
  public final void Pp()
  {
    AppMethodBeat.i(146805);
    super.Pp();
    try
    {
      Object localObject = ((d)QK()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(146805);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((com.tencent.mm.plugin.appbrand.m.i)localObject).Q(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).ke(10);
      }
      AppMethodBeat.o(146805);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146805);
    }
  }
  
  protected String Pq()
  {
    AppMethodBeat.i(146801);
    String str = "" + com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/android.js");
    str = str + com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/shared_buffer.js");
    str = str + com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/lazy_load.js");
    str = str + com.tencent.mm.plugin.appbrand.jsapi.ai.b.d.bYt();
    AppMethodBeat.o(146801);
    return str;
  }
  
  protected int Pr()
  {
    return 0;
  }
  
  protected final void Pt()
  {
    AppMethodBeat.i(237143);
    super.Pt();
    if ((((d)QK()).QM() != null) && (((d)QK()).QM().Rp()) && (com.tencent.mm.plugin.appbrand.debugger.x.afN(((d)QK()).QM().Sk().extInfo)))
    {
      Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "initRemoteDebug");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(244107);
          c.a(c.this, new com.tencent.mm.plugin.appbrand.debugger.q());
          c.a(c.this, new o());
          c.b(c.this).a((d)c.this.QK(), ((d)c.this.QK()).QM().Sk().extInfo);
          c.c(c.this).a(c.b(c.this));
          if (c.d(c.this) != null) {
            c.d(c.this).cAB = c.c(c.this);
          }
          AppMethodBeat.o(244107);
        }
      });
      V8.setBreakOnStart(Boolean.FALSE);
      com.tencent.mm.plugin.appbrand.utils.v.a(((d)QK()).getJsRuntime(), "xdebug");
      if (((d)QK()).bDV())
      {
        com.tencent.mm.plugin.appbrand.m.i locali = ((d)QK()).getJsRuntime();
        QK();
        com.tencent.mm.plugin.appbrand.utils.v.b(locali, "https://usr/");
      }
    }
    AppMethodBeat.o(237143);
  }
  
  protected void Pu()
  {
    AppMethodBeat.i(146808);
    if (!this.cAd) {
      ((d)QK()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/android.js"), null);
    }
    ((d)QK()).Rq();
    ch(false);
    Rg();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.cAf)
    {
      localLinkedList.addAll(this.cAf);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
  }
  
  protected void Pv()
  {
    AppMethodBeat.i(146814);
    ch(true);
    ((d)QK()).bPA();
    AppMethodBeat.o(146814);
  }
  
  protected b a(com.tencent.mm.plugin.appbrand.m.t paramt)
  {
    AppMethodBeat.i(160992);
    paramt = new i((d)QK(), paramt);
    AppMethodBeat.o(160992);
    return paramt;
  }
  
  protected void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146803);
    super.c(paramAppBrandRuntime);
    Objects.requireNonNull(QK());
    if (this.cux != null) {
      this.cux.a(((d)QK()).getJsRuntime(), (com.tencent.mm.plugin.appbrand.jsapi.j)QK());
    }
    Pi();
    paramAppBrandRuntime.b(af.class, new al(paramAppBrandRuntime));
    com.tencent.mm.plugin.appbrand.jsapi.ai.b.d.a((com.tencent.mm.plugin.appbrand.f.b)((d)QK()).K(com.tencent.mm.plugin.appbrand.f.b.class), (com.tencent.mm.plugin.appbrand.f.a)((d)QK()).K(com.tencent.mm.plugin.appbrand.f.a.class), (com.tencent.mm.plugin.appbrand.v)QK());
    Log.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", "init");
    paramAppBrandRuntime = com.tencent.mm.plugin.appbrand.i.a.bNU();
    SkiaCanvasExternalTextureManager.getInstance().registerPlugin(paramAppBrandRuntime);
    this.cuy.c(QK());
    this.cuA = new CronetLogic.CronetTaskNetworkStateCallback()
    {
      public final void onNetWeakChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(237759);
        com.tencent.mm.plugin.appbrand.jsapi.ab.b.a(c.this.QK(), paramAnonymousBoolean);
        AppMethodBeat.o(237759);
      }
    };
    CronetLogic.addCronetTaskNetworkStateCallback(this.cuA);
    AppMethodBeat.o(146803);
  }
  
  public final void dJ(String paramString)
  {
    AppMethodBeat.i(237145);
    Log.d("Luggage.AppBrandMiniProgramServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    ffu localffu = new ffu();
    localffu.UGl = ((d)QK()).Rn().getComponentId();
    localffu.UGk = paramString;
    paramString = com.tencent.mm.plugin.appbrand.debugger.x.a(localffu, this.cup, "domEvent");
    if (this.cum != null) {
      this.cum.a(paramString);
    }
    AppMethodBeat.o(237145);
  }
  
  public final boolean dK(String arg1)
  {
    AppMethodBeat.i(237140);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(237140);
      return false;
    }
    for (;;)
    {
      Object localObject1;
      synchronized (this.cAg)
      {
        localObject1 = (Boolean)this.cAg.get(???);
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue()))
        {
          Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", new Object[] { getAppId(), ??? });
          bool = false;
          AppMethodBeat.o(237140);
          return bool;
        }
        this.cAg.put(???, Boolean.TRUE);
        Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", new Object[] { getAppId(), ??? });
        localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(247049);
            if (c.this.cAc) {
              try
              {
                localObject3 = new g(paramString);
                com.tencent.mm.plugin.appbrand.v localv = (com.tencent.mm.plugin.appbrand.v)Objects.requireNonNull(c.this.QK());
                p.k(localv, "service");
                JSONObject localJSONObject1;
                for (;;)
                {
                  try
                  {
                    localJSONObject1 = new JSONObject();
                    localJSONObject1.put("moduleName", ((g)localObject3).cAy);
                    Object localObject1 = (AppBrandSysConfigLU)localv.au(AppBrandSysConfigLU.class);
                    if (localObject1 != null)
                    {
                      localObject1 = ((AppBrandSysConfigLU)localObject1).nYR;
                      localObject1 = ((WxaPkgWrappingInfo)localObject1).nId;
                      if (localObject1 == null) {
                        break label276;
                      }
                      Object localObject4 = ((WxaRuntimeModulePluginListMap)localObject1).adi(((g)localObject3).cAy);
                      if (localObject4 == null) {
                        break label276;
                      }
                      localObject1 = new JSONArray();
                      localObject4 = ((Iterable)localObject4).iterator();
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)((Iterator)localObject4).next();
                      JSONObject localJSONObject2 = new JSONObject();
                      localJSONObject2.put("plugin_id", localWxaPluginPkgInfo.provider);
                      localJSONObject2.put("custom_version", localWxaPluginPkgInfo.stringVersion);
                      localJSONObject2.put("prefix_path", localWxaPluginPkgInfo.prefixPath);
                      localJSONObject2.put("inner_version", localWxaPluginPkgInfo.version);
                      ((JSONArray)localObject1).put(localJSONObject2);
                      continue;
                    }
                    localObject2 = null;
                  }
                  catch (JSONException localJSONException)
                  {
                    Log.e(((g)localObject3).TAG, "dispatch with service(" + localv.getAppId() + "), create data failed");
                    AppMethodBeat.o(247049);
                    return;
                  }
                }
                localJSONObject1.put("separatedPlugins", localObject2);
                label276:
                Object localObject2 = localJSONObject1.toString();
                p.j(localObject2, "try {\n            JSONOb…         return\n        }");
                Log.i(((g)localObject3).TAG, "dispatch appId(" + localv.getAppId() + ") onSubPackageReady(" + (String)localObject2 + ')');
                localv.cp("onSubPackageReady", (String)localObject2);
                AppMethodBeat.o(247049);
                return;
              }
              catch (Exception localException)
              {
                Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
                AppMethodBeat.o(247049);
                return;
              }
            }
            if ("__APP__".equals(paramString))
            {
              c.a(c.this);
              AppMethodBeat.o(247049);
              return;
            }
            Object localObject3 = new StringBuilder().append(paramString);
            if (paramString.endsWith("/")) {}
            for (String str = "";; str = "/")
            {
              str = str + "app-service.js";
              localObject3 = bl.N(((d)c.this.QK()).QM()).acD(str).mFile.bOF();
              com.tencent.mm.plugin.appbrand.utils.v.a(((d)c.this.QK()).QM(), ((d)c.this.QK()).getJsRuntime(), (String)localObject3, str, "", "", v.a.riQ, new c.d(str, (d)c.this.QK(), (byte)0));
              AppMethodBeat.o(247049);
              return;
            }
          }
        };
        if (QK() == null) {
          Log.w("Luggage.AppBrandMiniProgramServiceLogicImp", "runOnServiceReady getComponent()==NULL");
        } else if (((d)QK()).isRunning()) {
          ((Runnable)localObject1).run();
        }
      }
      synchronized (this.cAf)
      {
        this.cAf.add(localObject1);
      }
      boolean bool = true;
    }
  }
  
  public final String dZ(String paramString)
  {
    AppMethodBeat.i(237149);
    if (Rp())
    {
      paramString = com.tencent.mm.plugin.appbrand.debugger.x.a(paramString, ((d)QK()).QM());
      AppMethodBeat.o(237149);
      return paramString;
    }
    AppMethodBeat.o(237149);
    return "";
  }
  
  public void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146807);
    super.f(paramJSONObject);
    ((d)QK()).c(paramJSONObject, "isLazyLoad", Boolean.valueOf(((ab)((d)QK()).QM().au(ab.class)).cdQ()));
    AppMethodBeat.o(146807);
  }
  
  public static final class a
    implements b.a
  {}
  
  public static final class b
  {
    public String cAm;
    public String cAn;
    public String name;
    public String source;
  }
  
  static final class c
    implements u.b
  {
    private final d cAo;
    private final boolean cAp;
    private final String cuC;
    private final String cuD;
    private final long cuE;
    private boolean cuF;
    private m.c cuG;
    private final AtomicInteger cuH;
    
    private c(String paramString1, String paramString2, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(146793);
      this.cuF = false;
      this.cuG = null;
      this.cuH = new AtomicInteger(2);
      this.cuC = paramString1;
      this.cuD = paramString2;
      this.cAo = paramd;
      this.cAp = paramBoolean;
      this.cuE = System.currentTimeMillis();
      AppMethodBeat.o(146793);
    }
    
    private void Py()
    {
      AppMethodBeat.i(146797);
      long l1;
      if (this.cuH.decrementAndGet() == 0)
      {
        if (this.cuG != null) {
          break label105;
        }
        l1 = this.cuE;
        if (this.cuG != null) {
          break label116;
        }
      }
      label105:
      label116:
      for (long l2 = System.currentTimeMillis();; l2 = this.cuG.fiS)
      {
        d.a locala = new d.a();
        locala.scriptName = this.cuC;
        locala.cyv = this.cuD;
        locala.cyw = Util.nullAsNil(this.cuD).length();
        this.cAo.a(locala, this.cuF, l1, l2, this.cuG);
        AppMethodBeat.o(146797);
        return;
        l1 = this.cuG.fiR;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(146794);
      this.cuG = paramc;
      Py();
      AppMethodBeat.o(146794);
    }
    
    public final void dL(String paramString)
    {
      AppMethodBeat.i(146796);
      this.cuF = false;
      Py();
      AppMethodBeat.o(146796);
    }
    
    public final void onSuccess(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(146795);
      this.cuF = true;
      Py();
      long l1;
      long l2;
      if (this.cuC.equals("WAService.js"))
      {
        l1 = System.currentTimeMillis();
        l2 = this.cuE;
        if (!this.cAp) {
          break label81;
        }
      }
      for (;;)
      {
        com.tencent.mm.appbrand.v8.x.a(2, l1 - l2, i, this.cAo.getAppId(), -1, 0, this.cAo.bBP().bGi());
        AppMethodBeat.o(146795);
        return;
        label81:
        i = 0;
      }
    }
  }
  
  static final class d
    implements u.b
  {
    private final d cAo;
    private int cAq;
    private final String cuC;
    private final long cuE;
    private boolean cuF;
    private m.c cuG;
    private final AtomicInteger cuH;
    
    private d(String paramString, d paramd)
    {
      AppMethodBeat.i(169433);
      this.cAq = 0;
      this.cuF = false;
      this.cuG = null;
      this.cuH = new AtomicInteger(2);
      this.cuC = paramString;
      this.cAo = paramd;
      this.cuE = System.currentTimeMillis();
      AppMethodBeat.o(169433);
    }
    
    private void Py()
    {
      AppMethodBeat.i(169437);
      long l1;
      if (this.cuH.decrementAndGet() == 0)
      {
        if (this.cuG != null) {
          break label90;
        }
        l1 = this.cuE;
        if (this.cuG != null) {
          break label101;
        }
      }
      label90:
      label101:
      for (long l2 = System.currentTimeMillis();; l2 = this.cuG.fiS)
      {
        d.a locala = new d.a();
        locala.scriptName = this.cuC;
        locala.cyw = this.cAq;
        this.cAo.a(locala, this.cuF, l1, l2, this.cuG);
        AppMethodBeat.o(169437);
        return;
        l1 = this.cuG.fiR;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(169434);
      this.cuG = paramc;
      this.cAq = paramc.sourceLength;
      Py();
      AppMethodBeat.o(169434);
    }
    
    public final void dL(String paramString)
    {
      AppMethodBeat.i(169436);
      this.cuF = false;
      Py();
      AppMethodBeat.o(169436);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(169435);
      this.cuF = true;
      Py();
      AppMethodBeat.o(169435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.c
 * JD-Core Version:    0.7.0.1
 */