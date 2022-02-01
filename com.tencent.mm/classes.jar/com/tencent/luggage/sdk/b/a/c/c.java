package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
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
{
  volatile boolean cAU;
  private volatile boolean cAV;
  private volatile boolean cAW;
  private final LinkedList<Runnable> cAX;
  private final Map<String, Boolean> cAY;
  private com.tencent.luggage.sdk.b.a.a.c cwb;
  private com.tencent.luggage.sdk.b.a.a.d cwd;
  
  public c(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(146798);
    this.cAU = false;
    this.cAV = false;
    this.cAW = false;
    this.cAX = new LinkedList();
    this.cAY = new HashMap();
    AppMethodBeat.o(146798);
  }
  
  private void Mq()
  {
    AppMethodBeat.i(146806);
    try
    {
      Object localObject = ((d)NN()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(146806);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((com.tencent.mm.plugin.appbrand.m.i)localObject).R(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).setThreadPriority(-2);
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
  
  private void Oi()
  {
    AppMethodBeat.i(146810);
    if (this.cAU)
    {
      AppMethodBeat.o(146810);
      return;
    }
    if (this.cAW)
    {
      AppMethodBeat.o(146810);
      return;
    }
    Ok();
    String str = ((d)NN()).NP().OM().leE.pkgPath;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(146810);
      return;
    }
    com.tencent.mm.plugin.appbrand.utils.t.a(((d)NN()).NP(), ((d)NN()).getJsRuntime(), str, "app-service.js", "", "", t.a.ohd, new d("app-service.js", (d)NN(), (byte)0));
    this.cAW = true;
    AppMethodBeat.o(146810);
  }
  
  private b Oj()
  {
    AppMethodBeat.i(146811);
    Object localObject1;
    if (this.cAU) {
      localObject1 = ((d)NN()).bqZ().UM("WAServiceMainContext.js");
    }
    for (String str = "WAServiceMainContext.js";; str = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "WAService.js";
        localObject2 = ((d)NN()).bqZ().UM("WAService.js");
      }
      localObject1 = new b();
      ((b)localObject1).name = str;
      ((b)localObject1).source = ((String)localObject2);
      AppMethodBeat.o(146811);
      return localObject1;
      localObject1 = null;
    }
  }
  
  private void bW(boolean paramBoolean)
  {
    AppMethodBeat.i(146812);
    Object localObject1;
    String str1;
    String str2;
    if (!this.cAV)
    {
      bc.a((com.tencent.mm.plugin.appbrand.d)NN(), ((d)NN()).getJsRuntime());
      localObject1 = My();
      final long l = System.currentTimeMillis();
      com.tencent.mm.plugin.appbrand.utils.s.a(((d)NN()).getJsRuntime(), (String)localObject1, new s.a()
      {
        public final void du(String paramAnonymousString)
        {
          AppMethodBeat.i(146791);
          Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
          AppMethodBeat.o(146791);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(146790);
          Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
          long l1 = System.currentTimeMillis();
          long l2 = l;
          if (this.cBc) {}
          for (int i = 1;; i = 0)
          {
            x.a(3, l1 - l2, i, ((d)c.this.NN()).getAppId(), -1, 0, ((d)c.this.NN()).bqZ().bvd());
            AppMethodBeat.o(146790);
            return;
          }
        }
      });
      localObject2 = Oj();
      str1 = ((b)localObject2).name;
      str2 = ((b)localObject2).source;
      if (!TextUtils.isEmpty(((b)localObject2).cBe)) {
        break label211;
      }
      localObject1 = str1;
      if (!TextUtils.isEmpty(((b)localObject2).cBf)) {
        break label221;
      }
    }
    label211:
    label221:
    for (Object localObject2 = "v" + ((d)NN()).bqZ().bvd();; localObject2 = ((b)localObject2).cBf)
    {
      com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.s)NN(), ((d)NN()).getJsRuntime(), str1, (String)localObject1, (String)localObject2, Mz(), str2, t.a.ohc, new c(str1, str2, (d)NN(), paramBoolean, (byte)0));
      this.cAV = true;
      AppMethodBeat.o(146812);
      return;
      localObject1 = ((b)localObject2).cBe;
      break;
    }
  }
  
  protected void MC()
  {
    AppMethodBeat.i(146808);
    if (!this.cAV) {
      ((d)NN()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js"), null);
    }
    ((d)NN()).Os();
    bW(false);
    Oi();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.cAX)
    {
      localLinkedList.addAll(this.cAX);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
    Om();
    AppMethodBeat.o(146808);
  }
  
  protected void MD()
  {
    AppMethodBeat.i(146814);
    bW(true);
    ((d)NN()).bEc();
    AppMethodBeat.o(146814);
  }
  
  public final boolean Mj()
  {
    return this.cAU;
  }
  
  protected com.tencent.mm.plugin.appbrand.m.i Mk()
  {
    AppMethodBeat.i(146799);
    com.tencent.mm.plugin.appbrand.m.c localc = new com.tencent.mm.plugin.appbrand.m.c((byte)0);
    AppMethodBeat.o(146799);
    return localc;
  }
  
  protected void Ml()
  {
    AppMethodBeat.i(146800);
    super.Ml();
    final com.tencent.mm.plugin.appbrand.m.i locali = ((d)NN()).getJsRuntime();
    Object localObject = (com.tencent.mm.plugin.appbrand.m.t)locali.R(com.tencent.mm.plugin.appbrand.m.t.class);
    if (localObject != null)
    {
      localObject = a((com.tencent.mm.plugin.appbrand.m.t)localObject);
      locali.addJavascriptInterface(localObject, "WeixinJSContext");
      locali.evaluateJavascript(h.cBq, null);
      ((b)localObject).MJ();
    }
    for (this.cAU = true;; this.cAU = false)
    {
      locali.setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.m.h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146789);
          Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { r.afJ(paramAnonymousString1), r.afJ(paramAnonymousString2) });
          cx.a(locali, "onError", str, 0);
          c.this.z(paramAnonymousString1, paramAnonymousString2);
          Log.e("MicroMsg.AppBrand.JsRuntimeException", str);
          AppMethodBeat.o(146789);
        }
      });
      this.cwb = new com.tencent.luggage.sdk.b.a.a.c();
      this.cwb.a(locali, NN());
      this.cwd = new com.tencent.luggage.sdk.b.a.a.d();
      this.cwd.a(((d)NN()).getJsRuntime(), NN(), 0);
      com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.a(locali, (com.tencent.mm.plugin.appbrand.s)NN());
      AppMethodBeat.o(146800);
      return;
    }
  }
  
  protected void Mm()
  {
    AppMethodBeat.i(146809);
    super.Mm();
    if (this.cwb != null) {
      this.cwb.a(((d)NN()).getJsRuntime());
    }
    if (this.cwd != null) {
      this.cwd.b(((d)NN()).getJsRuntime());
    }
    AppMethodBeat.o(146809);
  }
  
  public final void Mw()
  {
    AppMethodBeat.i(146804);
    super.Mw();
    Mq();
    AppMethodBeat.o(146804);
  }
  
  public final void Mx()
  {
    AppMethodBeat.i(146805);
    super.Mx();
    try
    {
      Object localObject = ((d)NN()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(146805);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((com.tencent.mm.plugin.appbrand.m.i)localObject).R(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).setThreadPriority(10);
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
  
  protected String My()
  {
    AppMethodBeat.i(146801);
    String str = "" + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js");
    str = str + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/shared_buffer.js");
    str = str + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/lazy_load.js");
    str = str + com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.bMc();
    AppMethodBeat.o(146801);
    return str;
  }
  
  protected int Mz()
  {
    return 0;
  }
  
  protected void Ok() {}
  
  protected b a(com.tencent.mm.plugin.appbrand.m.t paramt)
  {
    AppMethodBeat.i(160992);
    paramt = new i((d)NN(), paramt);
    AppMethodBeat.o(160992);
    return paramt;
  }
  
  protected void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146803);
    super.c(paramAppBrandRuntime);
    Objects.requireNonNull(NN());
    if (this.cwd != null) {
      this.cwd.a(((d)NN()).getJsRuntime(), (k)NN());
    }
    Mq();
    paramAppBrandRuntime.b(ag.class, new al(paramAppBrandRuntime));
    com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.a((com.tencent.mm.plugin.appbrand.f.b)((d)NN()).M(com.tencent.mm.plugin.appbrand.f.b.class), (com.tencent.mm.plugin.appbrand.f.a)((d)NN()).M(com.tencent.mm.plugin.appbrand.f.a.class), (com.tencent.mm.plugin.appbrand.s)NN());
    Log.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", "init");
    paramAppBrandRuntime = com.tencent.mm.plugin.appbrand.i.a.bCz();
    SkiaCanvasExternalTextureManager.getInstance().registerPlugin(paramAppBrandRuntime);
    AppMethodBeat.o(146803);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146807);
    super.c(paramJSONObject);
    ((d)NN()).c(paramJSONObject, "isLazyLoad", Boolean.valueOf(((com.tencent.mm.plugin.appbrand.page.aa)((d)NN()).NP().av(com.tencent.mm.plugin.appbrand.page.aa.class)).bRa()));
    AppMethodBeat.o(146807);
  }
  
  public final boolean dt(String arg1)
  {
    AppMethodBeat.i(229851);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(229851);
      return false;
    }
    for (;;)
    {
      Object localObject1;
      synchronized (this.cAY)
      {
        localObject1 = (Boolean)this.cAY.get(???);
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue()))
        {
          Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", new Object[] { getAppId(), ??? });
          bool = false;
          AppMethodBeat.o(229851);
          return bool;
        }
        this.cAY.put(???, Boolean.TRUE);
        Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", new Object[] { getAppId(), ??? });
        localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146792);
            if (c.this.cAU) {
              try
              {
                localObject3 = new g(paramString);
                com.tencent.mm.plugin.appbrand.s locals = (com.tencent.mm.plugin.appbrand.s)Objects.requireNonNull(c.this.NN());
                p.h(locals, "service");
                JSONObject localJSONObject1;
                for (;;)
                {
                  try
                  {
                    localJSONObject1 = new JSONObject();
                    localJSONObject1.put("moduleName", ((g)localObject3).cBp);
                    Object localObject1 = (AppBrandSysConfigLU)locals.av(AppBrandSysConfigLU.class);
                    if (localObject1 != null)
                    {
                      localObject1 = ((AppBrandSysConfigLU)localObject1).leE;
                      localObject1 = ((WxaPkgWrappingInfo)localObject1).kOb;
                      if (localObject1 == null) {
                        break label276;
                      }
                      Object localObject4 = ((WxaRuntimeModulePluginListMap)localObject1).Vz(((g)localObject3).cBp);
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
                    Log.e(((g)localObject3).TAG, "dispatch with service(" + locals.getAppId() + "), create data failed");
                    AppMethodBeat.o(146792);
                    return;
                  }
                }
                localJSONObject1.put("separatedPlugins", localObject2);
                label276:
                Object localObject2 = localJSONObject1.toString();
                p.g(localObject2, "try {\n            JSONOb…         return\n        }");
                Log.i(((g)localObject3).TAG, "dispatch appId(" + locals.getAppId() + ") onSubPackageReady(" + (String)localObject2 + ')');
                locals.ck("onSubPackageReady", (String)localObject2);
                AppMethodBeat.o(146792);
                return;
              }
              catch (Exception localException)
              {
                Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
                AppMethodBeat.o(146792);
                return;
              }
            }
            if ("__APP__".equals(paramString))
            {
              c.a(c.this);
              AppMethodBeat.o(146792);
              return;
            }
            Object localObject3 = new StringBuilder().append(paramString);
            if (paramString.endsWith("/")) {}
            for (String str = "";; str = "/")
            {
              str = str + "app-service.js";
              localObject3 = com.tencent.mm.vfs.aa.z(bg.M(((d)c.this.NN()).NP()).UT(str).mFile.her());
              com.tencent.mm.plugin.appbrand.utils.t.a(((d)c.this.NN()).NP(), ((d)c.this.NN()).getJsRuntime(), (String)localObject3, str, "", "", t.a.ohd, new c.d(str, (d)c.this.NN(), (byte)0));
              AppMethodBeat.o(146792);
              return;
            }
          }
        };
        if (NN() == null) {
          Log.w("Luggage.AppBrandMiniProgramServiceLogicImp", "runOnServiceReady getComponent()==NULL");
        } else if (((d)NN()).isRunning()) {
          ((Runnable)localObject1).run();
        }
      }
      synchronized (this.cAX)
      {
        this.cAX.add(localObject1);
      }
      boolean bool = true;
    }
  }
  
  protected void z(String paramString1, String paramString2) {}
  
  public static final class a
    implements b.a
  {}
  
  public static final class b
  {
    public String cBe;
    public String cBf;
    public String name;
    public String source;
  }
  
  static final class c
    implements s.b
  {
    private final d cBg;
    private final boolean cBh;
    private final String cwh;
    private final String cwi;
    private final long cwj;
    private boolean cwk;
    private m.c cwl;
    private final AtomicInteger cwm;
    
    private c(String paramString1, String paramString2, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(146793);
      this.cwk = false;
      this.cwl = null;
      this.cwm = new AtomicInteger(2);
      this.cwh = paramString1;
      this.cwi = paramString2;
      this.cBg = paramd;
      this.cBh = paramBoolean;
      this.cwj = System.currentTimeMillis();
      AppMethodBeat.o(146793);
    }
    
    private void MG()
    {
      AppMethodBeat.i(146797);
      long l1;
      if (this.cwm.decrementAndGet() == 0)
      {
        if (this.cwl != null) {
          break label105;
        }
        l1 = this.cwj;
        if (this.cwl != null) {
          break label116;
        }
      }
      label105:
      label116:
      for (long l2 = System.currentTimeMillis();; l2 = this.cwl.dql)
      {
        d.a locala = new d.a();
        locala.scriptName = this.cwh;
        locala.czz = this.cwi;
        locala.czA = Util.nullAsNil(this.cwi).length();
        this.cBg.a(locala, this.cwk, l1, l2, this.cwl);
        AppMethodBeat.o(146797);
        return;
        l1 = this.cwl.dqk;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(146794);
      this.cwl = paramc;
      MG();
      AppMethodBeat.o(146794);
    }
    
    public final void du(String paramString)
    {
      AppMethodBeat.i(146796);
      this.cwk = false;
      MG();
      AppMethodBeat.o(146796);
    }
    
    public final void onSuccess(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(146795);
      this.cwk = true;
      MG();
      long l1;
      long l2;
      if (this.cwh.equals("WAService.js"))
      {
        l1 = System.currentTimeMillis();
        l2 = this.cwj;
        if (!this.cBh) {
          break label81;
        }
      }
      for (;;)
      {
        x.a(2, l1 - l2, i, this.cBg.getAppId(), -1, 0, this.cBg.bqZ().bvd());
        AppMethodBeat.o(146795);
        return;
        label81:
        i = 0;
      }
    }
  }
  
  static final class d
    implements s.b
  {
    private final d cBg;
    private int cBi;
    private final String cwh;
    private final long cwj;
    private boolean cwk;
    private m.c cwl;
    private final AtomicInteger cwm;
    
    private d(String paramString, d paramd)
    {
      AppMethodBeat.i(169433);
      this.cBi = 0;
      this.cwk = false;
      this.cwl = null;
      this.cwm = new AtomicInteger(2);
      this.cwh = paramString;
      this.cBg = paramd;
      this.cwj = System.currentTimeMillis();
      AppMethodBeat.o(169433);
    }
    
    private void MG()
    {
      AppMethodBeat.i(169437);
      long l1;
      if (this.cwm.decrementAndGet() == 0)
      {
        if (this.cwl != null) {
          break label90;
        }
        l1 = this.cwj;
        if (this.cwl != null) {
          break label101;
        }
      }
      label90:
      label101:
      for (long l2 = System.currentTimeMillis();; l2 = this.cwl.dql)
      {
        d.a locala = new d.a();
        locala.scriptName = this.cwh;
        locala.czA = this.cBi;
        this.cBg.a(locala, this.cwk, l1, l2, this.cwl);
        AppMethodBeat.o(169437);
        return;
        l1 = this.cwl.dqk;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(169434);
      this.cwl = paramc;
      this.cBi = paramc.sourceLength;
      MG();
      AppMethodBeat.o(169434);
    }
    
    public final void du(String paramString)
    {
      AppMethodBeat.i(169436);
      this.cwk = false;
      MG();
      AppMethodBeat.o(169436);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(169435);
      this.cwk = true;
      MG();
      AppMethodBeat.o(169435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.c
 * JD-Core Version:    0.7.0.1
 */