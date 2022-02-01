package com.tencent.luggage.sdk.b.a.d;

import android.text.TextUtils;
import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.b.e;
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
import com.tencent.mm.plugin.appbrand.bk;
import com.tencent.mm.plugin.appbrand.debugger.l;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.n.t;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.ui.am;
import com.tencent.mm.plugin.appbrand.ui.at;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
import com.tencent.mm.protocal.protobuf.gcg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c<Service extends d>
  extends f<Service>
  implements l
{
  private com.tencent.mm.plugin.appbrand.debugger.q emf;
  private j emg;
  private o emi;
  private com.tencent.luggage.sdk.b.a.b.d emm;
  private com.tencent.luggage.sdk.b.a.b.c emn;
  private e emp;
  private com.tencent.luggage.sdk.b.a.e.b emq;
  private CronetLogic.CronetTaskNetworkStateCallback ems;
  private final LinkedList<Runnable> esA;
  private final LinkedList<Runnable> esB;
  private final Map<String, Boolean> esC;
  volatile boolean esx;
  private volatile boolean esy;
  private volatile boolean esz;
  
  public c(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(146798);
    this.esx = false;
    this.esy = false;
    this.esz = false;
    this.emf = null;
    this.emi = null;
    this.ems = null;
    this.esA = new LinkedList();
    this.esB = new LinkedList();
    this.esC = new HashMap();
    b(l.class, this);
    AppMethodBeat.o(146798);
  }
  
  private void apq()
  {
    AppMethodBeat.i(146806);
    try
    {
      Object localObject = ((d)aqX()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(146806);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.n.q)((com.tencent.mm.plugin.appbrand.n.i)localObject).Z(com.tencent.mm.plugin.appbrand.n.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.n.q)localObject).nM(-2);
      }
      AppMethodBeat.o(146806);
      return;
    }
    finally
    {
      Log.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146806);
    }
  }
  
  private void arv()
  {
    AppMethodBeat.i(146810);
    if (this.esx)
    {
      AppMethodBeat.o(146810);
      return;
    }
    if (this.esz)
    {
      AppMethodBeat.o(146810);
      return;
    }
    String str = ((d)aqX()).aqZ().asz().qYY.pkgPath;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(146810);
      return;
    }
    aa.a(((d)aqX()).aqZ(), ((d)aqX()).getJsRuntime(), str, "app-service.js", "", "", aa.a.urc, new d("app-service.js", (d)aqX(), (byte)0));
    this.esz = true;
    AppMethodBeat.o(146810);
  }
  
  private b arw()
  {
    AppMethodBeat.i(146811);
    Object localObject1;
    if (this.esx) {
      localObject1 = ((d)aqX()).cbl().UW("WAServiceMainContext.js");
    }
    for (String str = "WAServiceMainContext.js";; str = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "WAService.js";
        localObject2 = ((d)aqX()).cbl().UW("WAService.js");
      }
      localObject1 = new b();
      ((b)localObject1).name = str;
      ((b)localObject1).source = ((String)localObject2);
      AppMethodBeat.o(146811);
      return localObject1;
      localObject1 = null;
    }
  }
  
  private void cO(boolean paramBoolean)
  {
    AppMethodBeat.i(146812);
    String str2;
    String str3;
    if (!this.esy)
    {
      bk.a((com.tencent.mm.plugin.appbrand.g)aqX(), ((d)aqX()).getJsRuntime());
      ??? = apy();
      final long l = System.currentTimeMillis();
      z.a(((d)aqX()).getJsRuntime(), (String)???, new z.a()
      {
        public final void eW(String paramAnonymousString)
        {
          AppMethodBeat.i(220323);
          Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
          AppMethodBeat.o(220323);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(220321);
          Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
          long l1 = System.currentTimeMillis();
          long l2 = l;
          if (this.esG) {}
          for (int i = 1;; i = 0)
          {
            com.tencent.mm.appbrand.v8.x.a(3, l1 - l2, i, ((d)c.this.aqX()).getAppId(), -1, 0, ((d)c.this.aqX()).cbl().cfG());
            AppMethodBeat.o(220321);
            return;
          }
        }
      });
      Object localObject2 = arw();
      str2 = ((b)localObject2).name;
      str3 = ((b)localObject2).source;
      if (TextUtils.isEmpty(((b)localObject2).esH))
      {
        ??? = str2;
        if (!TextUtils.isEmpty(((b)localObject2).esI)) {
          break label356;
        }
        localObject2 = "v" + ((d)aqX()).cbl().cfG();
        label146:
        if ((((d)aqX()).aqZ() == null) || (!((d)aqX()).aqZ().arD())) {
          break label366;
        }
        ??? = ((d)aqX()).cbl().UW("WAServiceRemoteDebug.js");
        if (TextUtils.isEmpty((CharSequence)???)) {
          break label439;
        }
      }
    }
    label424:
    label439:
    for (??? = (String)??? + ";";; ??? = "")
    {
      aa.a((com.tencent.mm.plugin.appbrand.y)aqX(), ((d)aqX()).getJsRuntime(), str2, (String)??? + str3, aa.a.urb, new c(str2, str3, (d)aqX(), paramBoolean, (byte)0));
      for (;;)
      {
        this.esy = true;
        synchronized (this.esB)
        {
          if (this.esB.isEmpty()) {
            break label424;
          }
          ((Runnable)this.esB.pollFirst()).run();
        }
        ??? = localObject3.esH;
        break;
        label356:
        String str1 = localObject3.esI;
        break label146;
        label366:
        aa.a((com.tencent.mm.plugin.appbrand.y)aqX(), ((d)aqX()).getJsRuntime(), str2, (String)???, str1, apz(), str3, aa.a.urb, new c(str2, str3, (d)aqX(), paramBoolean, (byte)0));
      }
      AppMethodBeat.o(146812);
      return;
      AppMethodBeat.o(146812);
      return;
    }
  }
  
  protected void J(String paramString1, String paramString2) {}
  
  protected b a(com.tencent.mm.plugin.appbrand.n.i parami, t paramt)
  {
    AppMethodBeat.i(146802);
    parami = new i((d)aqX(), paramt);
    AppMethodBeat.o(146802);
    return parami;
  }
  
  protected final void apB()
  {
    AppMethodBeat.i(220418);
    super.apB();
    if ((((d)aqX()).aqZ() != null) && (((d)aqX()).aqZ().arD()) && (com.tencent.mm.plugin.appbrand.debugger.x.Ym(((d)aqX()).aqZ().asA().extInfo)))
    {
      Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "initRemoteDebug");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220306);
          c.a(c.this, new com.tencent.mm.plugin.appbrand.debugger.q());
          c.a(c.this, new o());
          c.b(c.this).a((d)c.this.aqX(), ((d)c.this.aqX()).aqZ().asA().extInfo);
          c.b(c.this).eoY = ((d)c.this.aqX()).aqZ().asA().eoY;
          c.c(c.this).a(c.b(c.this));
          if (c.d(c.this) != null) {
            c.d(c.this).esW = c.c(c.this);
          }
          AppMethodBeat.o(220306);
        }
      });
      V8.setBreakOnStart(Boolean.FALSE);
      aa.a(((d)aqX()).getJsRuntime(), "xdebug");
      if (((d)aqX()).asZ())
      {
        com.tencent.mm.plugin.appbrand.n.i locali = ((d)aqX()).getJsRuntime();
        aqX();
        aa.b(locali, "https://usr/");
      }
    }
    AppMethodBeat.o(220418);
  }
  
  protected void apC()
  {
    AppMethodBeat.i(146808);
    if (!this.esy) {
      ((d)aqX()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/android.js"), null);
    }
    ((d)aqX()).arE();
    cO(false);
    arv();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.esA)
    {
      localLinkedList.addAll(this.esA);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
  }
  
  protected void apD()
  {
    AppMethodBeat.i(146814);
    ((d)aqX()).cpG();
    cO(true);
    AppMethodBeat.o(146814);
  }
  
  public final String aph()
  {
    AppMethodBeat.i(220429);
    Object localObject = ((d)aqX()).arC();
    String str = ((d)aqX()).aqZ().getAppConfig().qVW;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(220429);
    return localObject;
  }
  
  public final boolean apj()
  {
    return this.esx;
  }
  
  protected com.tencent.mm.plugin.appbrand.n.i apk()
  {
    AppMethodBeat.i(146799);
    com.tencent.mm.plugin.appbrand.n.c localc = new com.tencent.mm.plugin.appbrand.n.c((byte)0);
    AppMethodBeat.o(146799);
    return localc;
  }
  
  protected void apl()
  {
    AppMethodBeat.i(146800);
    super.apl();
    final com.tencent.mm.plugin.appbrand.n.i locali = ((d)aqX()).getJsRuntime();
    Object localObject = (t)locali.Z(t.class);
    if (localObject != null)
    {
      localObject = a(locali, (t)localObject);
      if (localObject != null)
      {
        locali.addJavascriptInterface(localObject, "WeixinJSContext");
        locali.evaluateJavascript(h.esV, null);
        ((b)localObject).apJ();
      }
    }
    for (this.esx = true;; this.esx = false)
    {
      if ((aqZ() != null) && (aqZ().arD()))
      {
        Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "run in debug mode, add MPRemoteDebugJSContextInterface");
        aqX();
        this.emg = new j();
        locali.addJavascriptInterface(this.emg, "DebuggerConnection");
        if (this.emf != null) {
          this.emg.esW = this.emf;
        }
      }
      locali.setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.n.h()
      {
        public final void handleException(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146789);
          Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.y.agF(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.y.agF(paramAnonymousString2) });
          di.a(locali, "onError", str, 0);
          c.this.J(paramAnonymousString1, paramAnonymousString2);
          Log.e("MicroMsg.AppBrand.JsRuntimeException", str);
          AppMethodBeat.o(146789);
        }
      });
      this.emm = new com.tencent.luggage.sdk.b.a.b.d();
      this.emm.b(locali, aqX());
      this.emn = new com.tencent.luggage.sdk.b.a.b.c();
      this.emn.a(locali, aqX());
      this.emp = new e();
      this.emp.a(((d)aqX()).getJsRuntime(), aqX(), 0);
      this.emq = new com.tencent.luggage.sdk.b.a.e.b();
      this.emq.c(locali, aqX());
      com.tencent.mm.plugin.appbrand.jsapi.al.b.d.a(locali, (com.tencent.mm.plugin.appbrand.y)aqX());
      AppMethodBeat.o(146800);
      return;
    }
  }
  
  protected void apm()
  {
    AppMethodBeat.i(146809);
    super.apm();
    if (this.emm != null) {
      this.emm.b(((d)aqX()).getJsRuntime());
    }
    if (this.emn != null) {
      this.emn.a(((d)aqX()).getJsRuntime());
    }
    if (this.emp != null) {
      this.emp.c(((d)aqX()).getJsRuntime());
    }
    if (this.emq != null) {
      this.emq.d(((d)aqX()).getJsRuntime());
    }
    if (this.ems != null) {
      CronetLogic.removeCronetTaskNetworkStateCallback(this.ems);
    }
    AppMethodBeat.o(146809);
  }
  
  protected void apn()
  {
    AppMethodBeat.i(220390);
    super.apn();
    if (this.emf != null) {
      this.emf.destroy();
    }
    AppMethodBeat.o(220390);
  }
  
  public final void apw()
  {
    AppMethodBeat.i(146804);
    super.apw();
    apq();
    if (this.emf != null) {
      this.emf.rdV.bringToFront();
    }
    AppMethodBeat.o(146804);
  }
  
  public final void apx()
  {
    AppMethodBeat.i(146805);
    super.apx();
    try
    {
      Object localObject = ((d)aqX()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(146805);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.n.q)((com.tencent.mm.plugin.appbrand.n.i)localObject).Z(com.tencent.mm.plugin.appbrand.n.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.n.q)localObject).nM(10);
      }
      AppMethodBeat.o(146805);
      return;
    }
    finally
    {
      Log.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146805);
    }
  }
  
  protected String apy()
  {
    AppMethodBeat.i(146801);
    String str = "" + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/android.js");
    str = str + "\n;(function(global){ delete global.NativeGlobal.invokeHandler; })(this);\n";
    str = str + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/shared_buffer.js");
    str = str + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/lazy_load.js");
    str = str + com.tencent.mm.plugin.appbrand.jsapi.al.b.d.cyJ();
    AppMethodBeat.o(146801);
    return str;
  }
  
  protected int apz()
  {
    return 0;
  }
  
  protected void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146803);
    super.c(paramAppBrandRuntime);
    Objects.requireNonNull((d)aqX());
    if (this.emp != null) {
      this.emp.a(((d)aqX()).getJsRuntime(), (k)aqX());
    }
    apq();
    paramAppBrandRuntime.b(am.class, new at(paramAppBrandRuntime));
    com.tencent.mm.plugin.appbrand.jsapi.al.b.d.a((com.tencent.mm.plugin.appbrand.f.b)((d)aqX()).T(com.tencent.mm.plugin.appbrand.f.b.class), (com.tencent.mm.plugin.appbrand.f.a)((d)aqX()).T(com.tencent.mm.plugin.appbrand.f.a.class), (com.tencent.mm.plugin.appbrand.y)aqX());
    Log.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", "init");
    paramAppBrandRuntime = com.tencent.mm.plugin.appbrand.i.a.coh();
    SkiaCanvasExternalTextureManager.getInstance().registerPlugin(paramAppBrandRuntime);
    this.emq.c(aqX());
    this.ems = new CronetLogic.CronetTaskNetworkStateCallback()
    {
      public final void onNetWeakChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(220319);
        com.tencent.mm.plugin.appbrand.jsapi.ae.b.a(c.this.aqX(), paramAnonymousBoolean);
        AppMethodBeat.o(220319);
      }
    };
    CronetLogic.addCronetTaskNetworkStateCallback(this.ems);
    AppMethodBeat.o(146803);
  }
  
  public void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146807);
    super.e(paramJSONObject);
    Objects.requireNonNull((d)aqX());
    Objects.requireNonNull(((d)aqX()).aqZ());
    ((d)aqX()).d(paramJSONObject, "isLazyLoad", Boolean.valueOf(((ab)((d)aqX()).aqZ().aN(ab.class)).cEw()));
    ((d)aqX()).d(paramJSONObject, "supportInvokeWithAppId", Boolean.valueOf(((d)aqX()).aqZ().evw.tEy));
    AppMethodBeat.o(146807);
  }
  
  public final void eU(String paramString)
  {
    AppMethodBeat.i(220424);
    Log.d("Luggage.AppBrandMiniProgramServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    gcg localgcg = new gcg();
    localgcg.acau = ((d)aqX()).arB().getComponentId();
    localgcg.rRQ = paramString;
    paramString = com.tencent.mm.plugin.appbrand.debugger.x.a(localgcg, this.emi, "domEvent");
    if (this.emf != null) {
      this.emf.a(paramString);
    }
    AppMethodBeat.o(220424);
  }
  
  public final boolean eV(String arg1)
  {
    AppMethodBeat.i(220406);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(220406);
      return false;
    }
    for (;;)
    {
      Object localObject1;
      synchronized (this.esC)
      {
        localObject1 = (Boolean)this.esC.get(???);
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue()))
        {
          Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", new Object[] { getAppId(), ??? });
          bool = false;
          AppMethodBeat.o(220406);
          return bool;
        }
        this.esC.put(???, Boolean.TRUE);
        Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", new Object[] { getAppId(), ??? });
        localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220310);
            if (c.this.esx) {
              try
              {
                localObject3 = new g(paramString);
                com.tencent.mm.plugin.appbrand.y localy = (com.tencent.mm.plugin.appbrand.y)Objects.requireNonNull((d)c.this.aqX());
                kotlin.g.b.s.u(localy, "service");
                JSONObject localJSONObject1;
                for (;;)
                {
                  try
                  {
                    localJSONObject1 = new JSONObject();
                    localJSONObject1.put("moduleName", ((g)localObject3).esT);
                    Object localObject1 = (AppBrandSysConfigLU)localy.aN(AppBrandSysConfigLU.class);
                    if (localObject1 == null)
                    {
                      localObject1 = null;
                      localObject1 = ((WxaPkgWrappingInfo)localObject1).qHT;
                      if (localObject1 == null) {
                        break label279;
                      }
                      Object localObject4 = ((WxaRuntimeModulePluginListMap)localObject1).VE(((g)localObject3).esT);
                      if (localObject4 == null) {
                        break label279;
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
                    localObject2 = localJSONException.qYY;
                  }
                  catch (JSONException localJSONException)
                  {
                    Log.e(((g)localObject3).TAG, "dispatch with service(" + localy.getAppId() + "), create data failed");
                    AppMethodBeat.o(220310);
                    return;
                  }
                }
                localJSONObject1.put("separatedPlugins", localObject2);
                label279:
                Object localObject2 = localJSONObject1.toString();
                kotlin.g.b.s.s(localObject2, "try {\n            JSONOb…         return\n        }");
                Log.i(((g)localObject3).TAG, "dispatch appId(" + localy.getAppId() + ") onSubPackageReady(" + (String)localObject2 + ')');
                localy.cF("onSubPackageReady", (String)localObject2);
                AppMethodBeat.o(220310);
                return;
              }
              catch (Exception localException)
              {
                Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
                AppMethodBeat.o(220310);
                return;
              }
            }
            if ("__APP__".equals(paramString))
            {
              c.a(c.this);
              AppMethodBeat.o(220310);
              return;
            }
            Object localObject3 = new StringBuilder().append(paramString);
            if (paramString.endsWith("/")) {}
            for (String str = "";; str = "/")
            {
              str = str + "app-service.js";
              localObject3 = ah.v(bl.R(((d)c.this.aqX()).aqZ()).Vc(str).mFile.jKT());
              aa.a(((d)c.this.aqX()).aqZ(), ((d)c.this.aqX()).getJsRuntime(), (String)localObject3, str, "", "", aa.a.urc, new c.d(str, (d)c.this.aqX(), (byte)0));
              AppMethodBeat.o(220310);
              return;
            }
          }
        };
        if (aqX() == null) {
          Log.w("Luggage.AppBrandMiniProgramServiceLogicImp", "runOnServiceReady getComponent()==NULL");
        } else if (((d)aqX()).isRunning()) {
          ((Runnable)localObject1).run();
        }
      }
      synchronized (this.esA)
      {
        this.esA.add(localObject1);
      }
      boolean bool = true;
    }
  }
  
  public final String fs(String paramString)
  {
    AppMethodBeat.i(220437);
    if (arD())
    {
      paramString = com.tencent.mm.plugin.appbrand.debugger.x.a(paramString, ((d)aqX()).aqZ());
      AppMethodBeat.o(220437);
      return paramString;
    }
    AppMethodBeat.o(220437);
    return "";
  }
  
  protected final void l(Runnable paramRunnable)
  {
    AppMethodBeat.i(220401);
    if (this.esy)
    {
      paramRunnable.run();
      AppMethodBeat.o(220401);
      return;
    }
    synchronized (this.esB)
    {
      this.esB.addLast(paramRunnable);
      AppMethodBeat.o(220401);
      return;
    }
  }
  
  public static final class a
    implements b.a
  {}
  
  public static final class b
  {
    public String esH;
    public String esI;
    public String name;
    public String source;
  }
  
  static final class c
    implements z.b
  {
    private final String emu;
    private final String emv;
    private final long emw;
    private boolean emx;
    private m.c emy;
    private final AtomicInteger emz;
    private final d esJ;
    private final boolean esK;
    
    private c(String paramString1, String paramString2, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(146793);
      this.emx = false;
      this.emy = null;
      this.emz = new AtomicInteger(2);
      this.emu = paramString1;
      this.emv = paramString2;
      this.esJ = paramd;
      this.esK = paramBoolean;
      this.emw = System.currentTimeMillis();
      AppMethodBeat.o(146793);
    }
    
    private void apG()
    {
      AppMethodBeat.i(146797);
      long l1;
      if (this.emz.decrementAndGet() == 0)
      {
        if (this.emy != null) {
          break label105;
        }
        l1 = this.emw;
        if (this.emy != null) {
          break label116;
        }
      }
      label105:
      label116:
      for (long l2 = System.currentTimeMillis();; l2 = this.emy.hnf)
      {
        d.a locala = new d.a();
        locala.scriptName = this.emu;
        locala.eqP = this.emv;
        locala.eqQ = Util.nullAsNil(this.emv).length();
        this.esJ.a(locala, this.emx, l1, l2, this.emy);
        AppMethodBeat.o(146797);
        return;
        l1 = this.emy.hne;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(146794);
      this.emy = paramc;
      apG();
      AppMethodBeat.o(146794);
    }
    
    public final void eW(String paramString)
    {
      AppMethodBeat.i(146796);
      this.emx = false;
      apG();
      AppMethodBeat.o(146796);
    }
    
    public final void onSuccess(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(146795);
      this.emx = true;
      apG();
      long l1;
      long l2;
      if (this.emu.equals("WAService.js"))
      {
        l1 = System.currentTimeMillis();
        l2 = this.emw;
        if (!this.esK) {
          break label81;
        }
      }
      for (;;)
      {
        com.tencent.mm.appbrand.v8.x.a(2, l1 - l2, i, this.esJ.getAppId(), -1, 0, this.esJ.cbl().cfG());
        AppMethodBeat.o(146795);
        return;
        label81:
        i = 0;
      }
    }
  }
  
  static final class d
    implements z.b
  {
    private final String emu;
    private final long emw;
    private boolean emx;
    private m.c emy;
    private final AtomicInteger emz;
    private final d esJ;
    private int esL;
    
    private d(String paramString, d paramd)
    {
      AppMethodBeat.i(169433);
      this.esL = 0;
      this.emx = false;
      this.emy = null;
      this.emz = new AtomicInteger(2);
      this.emu = paramString;
      this.esJ = paramd;
      this.emw = System.currentTimeMillis();
      AppMethodBeat.o(169433);
    }
    
    private void apG()
    {
      AppMethodBeat.i(169437);
      long l1;
      if (this.emz.decrementAndGet() == 0)
      {
        if (this.emy != null) {
          break label90;
        }
        l1 = this.emw;
        if (this.emy != null) {
          break label101;
        }
      }
      label90:
      label101:
      for (long l2 = System.currentTimeMillis();; l2 = this.emy.hnf)
      {
        d.a locala = new d.a();
        locala.scriptName = this.emu;
        locala.eqQ = this.esL;
        this.esJ.a(locala, this.emx, l1, l2, this.emy);
        AppMethodBeat.o(169437);
        return;
        l1 = this.emy.hne;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(169434);
      this.emy = paramc;
      this.esL = paramc.sourceLength;
      apG();
      AppMethodBeat.o(169434);
    }
    
    public final void eW(String paramString)
    {
      AppMethodBeat.i(169436);
      this.emx = false;
      apG();
      AppMethodBeat.o(169436);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(169435);
      this.emx = true;
      apG();
      AppMethodBeat.o(169435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.c
 * JD-Core Version:    0.7.0.1
 */