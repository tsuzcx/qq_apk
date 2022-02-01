package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b<Service extends c>
  extends e<Service>
{
  private com.tencent.luggage.sdk.b.a.a.d bZK;
  private com.tencent.luggage.sdk.b.a.a.e bZM;
  volatile boolean cep;
  private volatile boolean ceq;
  private volatile boolean cer;
  private final LinkedList<Runnable> ces;
  
  public b(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(146798);
    this.cep = false;
    this.ceq = false;
    this.cer = false;
    this.ces = new LinkedList();
    AppMethodBeat.o(146798);
  }
  
  private void Bs()
  {
    AppMethodBeat.i(146806);
    try
    {
      Object localObject = ((c)CM()).aUV();
      if (localObject == null)
      {
        AppMethodBeat.o(146806);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(-2);
      }
      AppMethodBeat.o(146806);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146806);
    }
  }
  
  private void Dg()
  {
    AppMethodBeat.i(146810);
    if (this.cep)
    {
      AppMethodBeat.o(146810);
      return;
    }
    if (this.cer)
    {
      AppMethodBeat.o(146810);
      return;
    }
    Di();
    String str = ((c)CM()).CO().DB().jEg.pkgPath;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(146810);
      return;
    }
    r.a(((c)CM()).CO(), ((c)CM()).aUV(), str, "app-service.js", "", "", r.a.mov, new d("app-service.js", (c)CM(), (byte)0));
    this.cer = true;
    AppMethodBeat.o(146810);
  }
  
  private void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(146812);
    Object localObject1;
    String str1;
    String str2;
    if (!this.ceq)
    {
      ap.a((com.tencent.mm.plugin.appbrand.d)CM(), ((c)CM()).aUV());
      localObject1 = BA();
      final long l = System.currentTimeMillis();
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)CM()).aUV(), (String)localObject1, new q.a()
      {
        public final void bZ(String paramAnonymousString)
        {
          AppMethodBeat.i(146791);
          com.tencent.mm.sdk.platformtools.ac.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
          AppMethodBeat.o(146791);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(146790);
          com.tencent.mm.sdk.platformtools.ac.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
          long l1 = System.currentTimeMillis();
          long l2 = l;
          if (this.cew) {}
          for (int i = 1;; i = 0)
          {
            com.tencent.mm.appbrand.v8.x.a(3, l1 - l2, i, ((c)b.this.CM()).getAppId(), -1, 0, ((c)b.this.CM()).aSt().aVU());
            AppMethodBeat.o(146790);
            return;
          }
        }
      });
      localObject2 = Dh();
      str1 = ((b)localObject2).name;
      str2 = ((b)localObject2).source;
      if (!TextUtils.isEmpty(((b)localObject2).cey)) {
        break label216;
      }
      localObject1 = str1;
      if (!TextUtils.isEmpty(((b)localObject2).cez)) {
        break label226;
      }
    }
    label216:
    label226:
    for (Object localObject2 = "v" + ((c)CM()).aSt().aVU();; localObject2 = ((b)localObject2).cez)
    {
      r.a((com.tencent.mm.plugin.appbrand.q)CM(), ((c)CM()).aUV(), str1, (String)localObject1, (String)localObject2, BB(), str2, r.a.mou, new c(str1, str2, (c)CM(), paramBoolean, (byte)0));
      this.ceq = true;
      bv(paramBoolean);
      AppMethodBeat.o(146812);
      return;
      localObject1 = ((b)localObject2).cey;
      break;
    }
  }
  
  private void bv(boolean paramBoolean)
  {
    AppMethodBeat.i(206124);
    if (!paramBoolean)
    {
      String str = com.tencent.mm.plugin.appbrand.jsapi.z.b.c.NZ(((c)CM()).getAppId());
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)CM()).aUV(), str, new q.a()
      {
        public final void bZ(String paramAnonymousString)
        {
          AppMethodBeat.i(206122);
          com.tencent.mm.sdk.platformtools.ac.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject skiaCanvasUpdateScript Script Failed");
          AppMethodBeat.o(206122);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(206121);
          com.tencent.mm.sdk.platformtools.ac.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject skiaCanvasUpdateScript Script Success");
          AppMethodBeat.o(206121);
        }
      });
    }
    AppMethodBeat.o(206124);
  }
  
  protected String BA()
  {
    AppMethodBeat.i(146801);
    String str = "" + com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/android.js");
    str = str + com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/shared_buffer.js");
    str = str + com.tencent.mm.plugin.appbrand.jsapi.z.b.c.blZ();
    AppMethodBeat.o(146801);
    return str;
  }
  
  protected int BB()
  {
    return 0;
  }
  
  protected void BE()
  {
    AppMethodBeat.i(146808);
    if (!this.ceq) {
      ((c)CM()).aUV().evaluateJavascript(com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/android.js"), null);
    }
    ((c)CM()).Dp();
    bu(false);
    Dg();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.ces)
    {
      localLinkedList.addAll(this.ces);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
    Dj();
    AppMethodBeat.o(146808);
  }
  
  protected void BF()
  {
    AppMethodBeat.i(146814);
    bu(true);
    ((c)CM()).bez();
    AppMethodBeat.o(146814);
  }
  
  public final boolean Bl()
  {
    return this.cep;
  }
  
  protected i Bm()
  {
    AppMethodBeat.i(146799);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(146799);
    return localc;
  }
  
  protected void Bn()
  {
    AppMethodBeat.i(146800);
    super.Bn();
    final i locali = ((c)CM()).aUV();
    Object localObject = (t)locali.P(t.class);
    if (localObject != null)
    {
      localObject = a((t)localObject);
      locali.addJavascriptInterface(localObject, "WeixinJSContext");
      ((a)localObject).BL();
    }
    for (this.cep = true;; this.cep = false)
    {
      locali.setJsExceptionHandler(new h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146789);
          com.tencent.mm.sdk.platformtools.ac.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { p.Rw(paramAnonymousString1), p.Rw(paramAnonymousString2) });
          cg.a(locali, "onError", str, 0);
          b.this.z(paramAnonymousString1, paramAnonymousString2);
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.JsRuntimeException", str);
          AppMethodBeat.o(146789);
        }
      });
      this.bZK = new com.tencent.luggage.sdk.b.a.a.d();
      this.bZK.a(locali, CM());
      this.bZM = new com.tencent.luggage.sdk.b.a.a.e();
      this.bZM.a(((c)CM()).aUV(), CM(), 0);
      AppMethodBeat.o(146800);
      return;
    }
  }
  
  protected void Bo()
  {
    AppMethodBeat.i(146809);
    super.Bo();
    if (this.bZK != null) {
      this.bZK.a(((c)CM()).aUV());
    }
    if (this.bZM != null) {
      this.bZM.b(((c)CM()).aUV());
    }
    AppMethodBeat.o(146809);
  }
  
  public final void By()
  {
    AppMethodBeat.i(146804);
    super.By();
    Bs();
    AppMethodBeat.o(146804);
  }
  
  public final void Bz()
  {
    AppMethodBeat.i(146805);
    super.Bz();
    try
    {
      Object localObject = ((c)CM()).aUV();
      if (localObject == null)
      {
        AppMethodBeat.o(146805);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(10);
      }
      AppMethodBeat.o(146805);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146805);
    }
  }
  
  protected b Dh()
  {
    AppMethodBeat.i(146811);
    Object localObject1;
    if (this.cep) {
      localObject1 = ((c)CM()).aSt().HL("WAServiceMainContext.js");
    }
    for (String str = "WAServiceMainContext.js";; str = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "WAService.js";
        localObject2 = ((c)CM()).aSt().HL("WAService.js");
      }
      localObject1 = new b();
      ((b)localObject1).name = str;
      ((b)localObject1).source = ((String)localObject2);
      AppMethodBeat.o(146811);
      return localObject1;
      localObject1 = null;
    }
  }
  
  protected void Di() {}
  
  protected a a(t paramt)
  {
    AppMethodBeat.i(160992);
    paramt = new g((c)CM(), paramt);
    AppMethodBeat.o(160992);
    return paramt;
  }
  
  protected final void bY(String arg1)
  {
    AppMethodBeat.i(146813);
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206123);
        if (b.this.cep) {
          try
          {
            localObject3 = new f(paramString);
            com.tencent.mm.plugin.appbrand.q localq = (com.tencent.mm.plugin.appbrand.q)b.this.CM();
            k.h(localq, "service");
            JSONObject localJSONObject1;
            for (;;)
            {
              try
              {
                localJSONObject1 = new JSONObject();
                localJSONObject1.put("moduleName", ((f)localObject3).ceF);
                Object localObject1 = (AppBrandSysConfigLU)localq.ar(AppBrandSysConfigLU.class);
                if (localObject1 != null)
                {
                  localObject1 = ((AppBrandSysConfigLU)localObject1).jEg;
                  localObject1 = ((WxaPkgWrappingInfo)localObject1).jpf;
                  if (localObject1 == null) {
                    break label273;
                  }
                  Object localObject4 = ((WxaRuntimeModulePluginListMap)localObject1).Iw(((f)localObject3).ceF);
                  if (localObject4 == null) {
                    break label273;
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
                com.tencent.mm.sdk.platformtools.ac.e(((f)localObject3).TAG, "dispatch with service(" + localq.getAppId() + "), create data failed");
                AppMethodBeat.o(206123);
                return;
              }
            }
            localJSONObject1.put("separatedPlugins", localObject2);
            label273:
            Object localObject2 = localJSONObject1.toString();
            k.g(localObject2, "try {\n            JSONOb…         return\n        }");
            com.tencent.mm.sdk.platformtools.ac.i(((f)localObject3).TAG, "dispatch appId(" + localq.getAppId() + ") onSubPackageReady(" + (String)localObject2 + ')');
            localq.bV("onSubPackageReady", (String)localObject2);
            AppMethodBeat.o(206123);
            return;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ac.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
            AppMethodBeat.o(206123);
            return;
          }
        }
        if ("__APP__".equals(paramString))
        {
          b.a(b.this);
          AppMethodBeat.o(206123);
          return;
        }
        Object localObject3 = new StringBuilder().append(paramString);
        if (paramString.endsWith("/")) {}
        for (String str = "";; str = "/")
        {
          str = str + "app-service.js";
          localObject3 = com.tencent.mm.vfs.q.B(be.U(((c)b.this.CM()).CO()).HR(str).fKs.fxV());
          r.a(((c)b.this.CM()).CO(), ((c)b.this.CM()).aUV(), (String)localObject3, str, "", "", r.a.mov, new b.d(str, (c)b.this.CM(), (byte)0));
          AppMethodBeat.o(206123);
          return;
        }
      }
    };
    if (((c)CM()).isRunning())
    {
      local4.run();
      AppMethodBeat.o(146813);
      return;
    }
    synchronized (this.ces)
    {
      this.ces.add(local4);
      AppMethodBeat.o(146813);
      return;
    }
  }
  
  protected void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146803);
    if (this.bZM != null) {
      this.bZM.b(((c)CM()).aUV(), CM());
    }
    Bs();
    paramAppBrandRuntime.b(com.tencent.mm.plugin.appbrand.ui.x.class, new com.tencent.mm.plugin.appbrand.ui.ac(com.tencent.mm.sdk.f.a.jg(paramAppBrandRuntime.mContext)));
    AppMethodBeat.o(146803);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146807);
    super.c(paramJSONObject);
    ((c)CM()).c(paramJSONObject, "isLazyLoad", Boolean.valueOf(((y)((c)CM()).CO().ar(y.class)).bqp()));
    AppMethodBeat.o(146807);
  }
  
  protected void z(String paramString1, String paramString2) {}
  
  public static final class a
    implements com.tencent.luggage.sdk.b.a.b.a
  {}
  
  public static final class b
  {
    public String cey;
    public String cez;
    public String name;
    public String source;
  }
  
  static final class c
    implements q.b
  {
    private final String bZQ;
    private final String bZR;
    private final long bZS;
    private boolean bZT;
    private m.c bZU;
    private final AtomicInteger bZV;
    private final c ceA;
    private final boolean ceB;
    
    private c(String paramString1, String paramString2, c paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(146793);
      this.bZT = false;
      this.bZU = null;
      this.bZV = new AtomicInteger(2);
      this.bZQ = paramString1;
      this.bZR = paramString2;
      this.ceA = paramc;
      this.ceB = paramBoolean;
      this.bZS = System.currentTimeMillis();
      AppMethodBeat.o(146793);
    }
    
    private void BI()
    {
      AppMethodBeat.i(146797);
      long l1;
      if (this.bZV.decrementAndGet() == 0)
      {
        if (this.bZU != null) {
          break label105;
        }
        l1 = this.bZS;
        if (this.bZU != null) {
          break label116;
        }
      }
      label105:
      label116:
      for (long l2 = System.currentTimeMillis();; l2 = this.bZU.cNt)
      {
        d.a locala = new d.a();
        locala.scriptName = this.bZQ;
        locala.cde = this.bZR;
        locala.cdf = bs.nullAsNil(this.bZR).length();
        this.ceA.a(locala, this.bZT, l1, l2, this.bZU);
        AppMethodBeat.o(146797);
        return;
        l1 = this.bZU.cNs;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(146794);
      this.bZU = paramc;
      BI();
      AppMethodBeat.o(146794);
    }
    
    public final void bZ(String paramString)
    {
      AppMethodBeat.i(146796);
      this.bZT = false;
      BI();
      AppMethodBeat.o(146796);
    }
    
    public final void onSuccess(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(146795);
      this.bZT = true;
      BI();
      long l1;
      long l2;
      if (this.bZQ.equals("WAService.js"))
      {
        l1 = System.currentTimeMillis();
        l2 = this.bZS;
        if (!this.ceB) {
          break label81;
        }
      }
      for (;;)
      {
        com.tencent.mm.appbrand.v8.x.a(2, l1 - l2, i, this.ceA.getAppId(), -1, 0, this.ceA.aSt().aVU());
        AppMethodBeat.o(146795);
        return;
        label81:
        i = 0;
      }
    }
  }
  
  static final class d
    implements q.b
  {
    private final String bZQ;
    private final long bZS;
    private boolean bZT;
    private m.c bZU;
    private final AtomicInteger bZV;
    private final c ceA;
    private int ceC;
    
    private d(String paramString, c paramc)
    {
      AppMethodBeat.i(169433);
      this.ceC = 0;
      this.bZT = false;
      this.bZU = null;
      this.bZV = new AtomicInteger(2);
      this.bZQ = paramString;
      this.ceA = paramc;
      this.bZS = System.currentTimeMillis();
      AppMethodBeat.o(169433);
    }
    
    private void BI()
    {
      AppMethodBeat.i(169437);
      long l1;
      if (this.bZV.decrementAndGet() == 0)
      {
        if (this.bZU != null) {
          break label90;
        }
        l1 = this.bZS;
        if (this.bZU != null) {
          break label101;
        }
      }
      label90:
      label101:
      for (long l2 = System.currentTimeMillis();; l2 = this.bZU.cNt)
      {
        d.a locala = new d.a();
        locala.scriptName = this.bZQ;
        locala.cdf = this.ceC;
        this.ceA.a(locala, this.bZT, l1, l2, this.bZU);
        AppMethodBeat.o(169437);
        return;
        l1 = this.bZU.cNs;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(169434);
      this.bZU = paramc;
      this.ceC = paramc.sourceLength;
      BI();
      AppMethodBeat.o(169434);
    }
    
    public final void bZ(String paramString)
    {
      AppMethodBeat.i(169436);
      this.bZT = false;
      BI();
      AppMethodBeat.o(169436);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(169435);
      this.bZT = true;
      BI();
      AppMethodBeat.o(169435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */