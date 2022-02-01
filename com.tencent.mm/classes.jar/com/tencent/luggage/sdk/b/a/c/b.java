package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
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
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  private com.tencent.luggage.sdk.b.a.a.d ccN;
  private com.tencent.luggage.sdk.b.a.a.e ccP;
  volatile boolean chu;
  private volatile boolean chv;
  private volatile boolean chw;
  private final LinkedList<Runnable> chx;
  
  public b(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(146798);
    this.chu = false;
    this.chv = false;
    this.chw = false;
    this.chx = new LinkedList();
    AppMethodBeat.o(146798);
  }
  
  private void BO()
  {
    AppMethodBeat.i(146806);
    try
    {
      Object localObject = ((c)Dj()).aOf();
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
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146806);
    }
  }
  
  private void DD()
  {
    AppMethodBeat.i(146810);
    if (this.chu)
    {
      AppMethodBeat.o(146810);
      return;
    }
    if (this.chw)
    {
      AppMethodBeat.o(146810);
      return;
    }
    DF();
    String str = ((c)Dj()).Dl().DY().jdS.pkgPath;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(146810);
      return;
    }
    r.a(((c)Dj()).Dl(), ((c)Dj()).aOf(), str, "app-service.js", "", "", r.a.lMy, new d("app-service.js", (c)Dj(), (byte)0));
    this.chw = true;
    AppMethodBeat.o(146810);
  }
  
  private void bv(boolean paramBoolean)
  {
    AppMethodBeat.i(146812);
    Object localObject1;
    String str1;
    String str2;
    if (!this.chv)
    {
      ap.a((com.tencent.mm.plugin.appbrand.d)Dj(), ((c)Dj()).aOf());
      localObject1 = BW();
      final long l = System.currentTimeMillis();
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)Dj()).aOf(), (String)localObject1, new q.a()
      {
        public final void cj(String paramAnonymousString)
        {
          AppMethodBeat.i(146791);
          com.tencent.mm.sdk.platformtools.ad.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
          AppMethodBeat.o(146791);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(146790);
          com.tencent.mm.sdk.platformtools.ad.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
          long l1 = System.currentTimeMillis();
          long l2 = l;
          if (this.chB) {}
          for (int i = 1;; i = 0)
          {
            x.a(3, l1 - l2, i, ((c)b.this.Dj()).getAppId(), -1, 0, ((c)b.this.Dj()).aLC().aPc());
            AppMethodBeat.o(146790);
            return;
          }
        }
      });
      localObject2 = DE();
      str1 = ((b)localObject2).name;
      str2 = ((b)localObject2).source;
      if (!TextUtils.isEmpty(((b)localObject2).chD)) {
        break label216;
      }
      localObject1 = str1;
      if (!TextUtils.isEmpty(((b)localObject2).chE)) {
        break label226;
      }
    }
    label216:
    label226:
    for (Object localObject2 = "v" + ((c)Dj()).aLC().aPc();; localObject2 = ((b)localObject2).chE)
    {
      r.a((com.tencent.mm.plugin.appbrand.q)Dj(), ((c)Dj()).aOf(), str1, (String)localObject1, (String)localObject2, BX(), str2, r.a.lMx, new c(str1, str2, (c)Dj(), paramBoolean, (byte)0));
      this.chv = true;
      bw(paramBoolean);
      AppMethodBeat.o(146812);
      return;
      localObject1 = ((b)localObject2).chD;
      break;
    }
  }
  
  public final boolean BH()
  {
    return this.chu;
  }
  
  protected i BI()
  {
    AppMethodBeat.i(146799);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(146799);
    return localc;
  }
  
  protected void BJ()
  {
    AppMethodBeat.i(146800);
    super.BJ();
    final i locali = ((c)Dj()).aOf();
    Object localObject = (t)locali.P(t.class);
    if (localObject != null)
    {
      localObject = a((t)localObject);
      locali.addJavascriptInterface(localObject, "WeixinJSContext");
      ((a)localObject).Ch();
    }
    for (this.chu = true;; this.chu = false)
    {
      locali.setJsExceptionHandler(new h()
      {
        public final void t(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146789);
          com.tencent.mm.sdk.platformtools.ad.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { p.Nn(paramAnonymousString1), p.Nn(paramAnonymousString2) });
          cg.a(locali, "onError", str, 0);
          b.this.y(paramAnonymousString1, paramAnonymousString2);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.JsRuntimeException", str);
          AppMethodBeat.o(146789);
        }
      });
      this.ccN = new com.tencent.luggage.sdk.b.a.a.d();
      this.ccN.a(locali, Dj());
      this.ccP = new com.tencent.luggage.sdk.b.a.a.e();
      this.ccP.a(((c)Dj()).aOf(), Dj(), 0);
      AppMethodBeat.o(146800);
      return;
    }
  }
  
  protected void BK()
  {
    AppMethodBeat.i(146809);
    super.BK();
    if (this.ccN != null) {
      this.ccN.a(((c)Dj()).aOf());
    }
    if (this.ccP != null) {
      this.ccP.b(((c)Dj()).aOf());
    }
    AppMethodBeat.o(146809);
  }
  
  public final void BU()
  {
    AppMethodBeat.i(146804);
    super.BU();
    BO();
    AppMethodBeat.o(146804);
  }
  
  public final void BV()
  {
    AppMethodBeat.i(146805);
    super.BV();
    try
    {
      Object localObject = ((c)Dj()).aOf();
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
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146805);
    }
  }
  
  protected String BW()
  {
    AppMethodBeat.i(146801);
    String str = com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/shared_buffer.js");
    AppMethodBeat.o(146801);
    return str;
  }
  
  protected int BX()
  {
    return 0;
  }
  
  protected void Ca()
  {
    AppMethodBeat.i(146808);
    if (!this.chv) {
      ((c)Dj()).aOf().evaluateJavascript(com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/android.js"), null);
    }
    ((c)Dj()).DM();
    bv(false);
    DD();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.chx)
    {
      localLinkedList.addAll(this.chx);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
    DG();
    AppMethodBeat.o(146808);
  }
  
  protected void Cb()
  {
    AppMethodBeat.i(146814);
    bv(true);
    ((c)Dj()).aXC();
    AppMethodBeat.o(146814);
  }
  
  protected b DE()
  {
    AppMethodBeat.i(146811);
    Object localObject1;
    if (this.chu) {
      localObject1 = ((c)Dj()).aLC().DH("WAServiceMainContext.js");
    }
    for (String str = "WAServiceMainContext.js";; str = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "WAService.js";
        localObject2 = ((c)Dj()).aLC().DH("WAService.js");
      }
      localObject1 = new b();
      ((b)localObject1).name = str;
      ((b)localObject1).source = ((String)localObject2);
      AppMethodBeat.o(146811);
      return localObject1;
      localObject1 = null;
    }
  }
  
  protected void DF() {}
  
  protected a a(t paramt)
  {
    AppMethodBeat.i(160992);
    paramt = new g((c)Dj(), paramt);
    AppMethodBeat.o(160992);
    return paramt;
  }
  
  protected void bw(boolean paramBoolean) {}
  
  protected void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146803);
    if (this.ccP != null) {
      this.ccP.b(((c)Dj()).aOf(), Dj());
    }
    BO();
    paramAppBrandRuntime.b(com.tencent.mm.plugin.appbrand.ui.y.class, new com.tencent.mm.plugin.appbrand.ui.ad(com.tencent.mm.sdk.f.a.iV(paramAppBrandRuntime.mContext)));
    AppMethodBeat.o(146803);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146807);
    super.c(paramJSONObject);
    ((c)Dj()).c(paramJSONObject, "isLazyLoad", Boolean.valueOf(((com.tencent.mm.plugin.appbrand.page.y)((c)Dj()).Dl().ar(com.tencent.mm.plugin.appbrand.page.y.class)).bjy()));
    AppMethodBeat.o(146807);
  }
  
  protected final void ci(String arg1)
  {
    AppMethodBeat.i(146813);
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146792);
        if (b.this.chu) {
          try
          {
            localObject3 = new f(paramString);
            com.tencent.mm.plugin.appbrand.q localq = (com.tencent.mm.plugin.appbrand.q)b.this.Dj();
            k.h(localq, "service");
            JSONObject localJSONObject1;
            for (;;)
            {
              try
              {
                localJSONObject1 = new JSONObject();
                localJSONObject1.put("moduleName", ((f)localObject3).chK);
                Object localObject1 = (AppBrandSysConfigLU)localq.ar(AppBrandSysConfigLU.class);
                if (localObject1 != null)
                {
                  localObject1 = ((AppBrandSysConfigLU)localObject1).jdS;
                  localObject1 = ((WxaPkgWrappingInfo)localObject1).iOV;
                  if (localObject1 == null) {
                    break label273;
                  }
                  Object localObject4 = ((WxaRuntimeModulePluginListMap)localObject1).Et(((f)localObject3).chK);
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
                com.tencent.mm.sdk.platformtools.ad.e(((f)localObject3).TAG, "dispatch with service(" + localq.getAppId() + "), create data failed");
                AppMethodBeat.o(146792);
                return;
              }
            }
            localJSONObject1.put("separatedPlugins", localObject2);
            label273:
            Object localObject2 = localJSONObject1.toString();
            k.g(localObject2, "try {\n            JSONOb…         return\n        }");
            com.tencent.mm.sdk.platformtools.ad.i(((f)localObject3).TAG, "dispatch appId(" + localq.getAppId() + ") onSubPackageReady(" + (String)localObject2 + ')');
            localq.bN("onSubPackageReady", (String)localObject2);
            AppMethodBeat.o(146792);
            return;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ad.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
            AppMethodBeat.o(146792);
            return;
          }
        }
        if ("__APP__".equals(paramString))
        {
          b.a(b.this);
          AppMethodBeat.o(146792);
          return;
        }
        Object localObject3 = new StringBuilder().append(paramString);
        if (paramString.endsWith("/")) {}
        for (String str = "";; str = "/")
        {
          str = str + "app-service.js";
          localObject3 = com.tencent.mm.vfs.q.B(be.U(((c)b.this.Dj()).Dl()).DO(str).fGL.fhU());
          r.a(((c)b.this.Dj()).Dl(), ((c)b.this.Dj()).aOf(), (String)localObject3, str, "", "", r.a.lMy, new b.d(str, (c)b.this.Dj(), (byte)0));
          AppMethodBeat.o(146792);
          return;
        }
      }
    };
    if (((c)Dj()).isRunning())
    {
      local3.run();
      AppMethodBeat.o(146813);
      return;
    }
    synchronized (this.chx)
    {
      this.chx.add(local3);
      AppMethodBeat.o(146813);
      return;
    }
  }
  
  protected void y(String paramString1, String paramString2) {}
  
  public static final class a
    implements com.tencent.luggage.sdk.b.a.b.a
  {}
  
  public static final class b
  {
    public String chD;
    public String chE;
    public String name;
    public String source;
  }
  
  static final class c
    implements q.b
  {
    private final String ccT;
    private final String ccU;
    private final long ccV;
    private boolean ccW;
    private m.c ccX;
    private final AtomicInteger ccY;
    private final c chF;
    private final boolean chG;
    
    private c(String paramString1, String paramString2, c paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(146793);
      this.ccW = false;
      this.ccX = null;
      this.ccY = new AtomicInteger(2);
      this.ccT = paramString1;
      this.ccU = paramString2;
      this.chF = paramc;
      this.chG = paramBoolean;
      this.ccV = System.currentTimeMillis();
      AppMethodBeat.o(146793);
    }
    
    private void Ce()
    {
      AppMethodBeat.i(146797);
      long l1;
      if (this.ccY.decrementAndGet() == 0)
      {
        if (this.ccX != null) {
          break label105;
        }
        l1 = this.ccV;
        if (this.ccX != null) {
          break label116;
        }
      }
      label105:
      label116:
      for (long l2 = System.currentTimeMillis();; l2 = this.ccX.cPY)
      {
        d.a locala = new d.a();
        locala.scriptName = this.ccT;
        locala.cgh = this.ccU;
        locala.cgj = bt.nullAsNil(this.ccU).length();
        this.chF.a(locala, this.ccW, l1, l2, this.ccX);
        AppMethodBeat.o(146797);
        return;
        l1 = this.ccX.cPX;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(146794);
      this.ccX = paramc;
      Ce();
      AppMethodBeat.o(146794);
    }
    
    public final void cj(String paramString)
    {
      AppMethodBeat.i(146796);
      this.ccW = false;
      Ce();
      AppMethodBeat.o(146796);
    }
    
    public final void onSuccess(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(146795);
      this.ccW = true;
      Ce();
      long l1;
      long l2;
      if (this.ccT.equals("WAService.js"))
      {
        l1 = System.currentTimeMillis();
        l2 = this.ccV;
        if (!this.chG) {
          break label81;
        }
      }
      for (;;)
      {
        x.a(2, l1 - l2, i, this.chF.getAppId(), -1, 0, this.chF.aLC().aPc());
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
    private final String ccT;
    private final long ccV;
    private boolean ccW;
    private m.c ccX;
    private final AtomicInteger ccY;
    private final c chF;
    private int chH;
    
    private d(String paramString, c paramc)
    {
      AppMethodBeat.i(169433);
      this.chH = 0;
      this.ccW = false;
      this.ccX = null;
      this.ccY = new AtomicInteger(2);
      this.ccT = paramString;
      this.chF = paramc;
      this.ccV = System.currentTimeMillis();
      AppMethodBeat.o(169433);
    }
    
    private void Ce()
    {
      AppMethodBeat.i(169437);
      long l1;
      if (this.ccY.decrementAndGet() == 0)
      {
        if (this.ccX != null) {
          break label90;
        }
        l1 = this.ccV;
        if (this.ccX != null) {
          break label101;
        }
      }
      label90:
      label101:
      for (long l2 = System.currentTimeMillis();; l2 = this.ccX.cPY)
      {
        d.a locala = new d.a();
        locala.scriptName = this.ccT;
        locala.cgj = this.chH;
        this.chF.a(locala, this.ccW, l1, l2, this.ccX);
        AppMethodBeat.o(169437);
        return;
        l1 = this.ccX.cPX;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(169434);
      this.ccX = paramc;
      this.chH = paramc.sourceLength;
      Ce();
      AppMethodBeat.o(169434);
    }
    
    public final void cj(String paramString)
    {
      AppMethodBeat.i(169436);
      this.ccW = false;
      Ce();
      AppMethodBeat.o(169436);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(169435);
      this.ccW = true;
      Ce();
      AppMethodBeat.o(169435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */