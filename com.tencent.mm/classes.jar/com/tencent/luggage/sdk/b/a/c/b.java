package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.ar;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager;
import d.g.b.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b<Service extends c>
  extends e<Service>
{
  private com.tencent.luggage.sdk.b.a.a.c cke;
  private com.tencent.luggage.sdk.b.a.a.d ckg;
  volatile boolean coH;
  private volatile boolean coI;
  private volatile boolean coJ;
  private final LinkedList<Runnable> coK;
  private final Map<String, Boolean> coL;
  
  public b(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(146798);
    this.coH = false;
    this.coI = false;
    this.coJ = false;
    this.coK = new LinkedList();
    this.coL = new HashMap();
    AppMethodBeat.o(146798);
  }
  
  private void CU()
  {
    AppMethodBeat.i(146806);
    try
    {
      Object localObject = ((c)Eo()).aYB();
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
      ae.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146806);
    }
  }
  
  private void EH()
  {
    AppMethodBeat.i(146810);
    if (this.coH)
    {
      AppMethodBeat.o(146810);
      return;
    }
    if (this.coJ)
    {
      AppMethodBeat.o(146810);
      return;
    }
    EJ();
    String str = ((c)Eo()).Eq().Ff().kbw.pkgPath;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(146810);
      return;
    }
    com.tencent.mm.plugin.appbrand.utils.t.a(((c)Eo()).Eq(), ((c)Eo()).aYB(), str, "app-service.js", "", "", t.a.mUc, new d("app-service.js", (c)Eo(), (byte)0));
    this.coJ = true;
    AppMethodBeat.o(146810);
  }
  
  private void bv(boolean paramBoolean)
  {
    AppMethodBeat.i(146812);
    Object localObject1;
    String str1;
    String str2;
    if (!this.coI)
    {
      ar.a((com.tencent.mm.plugin.appbrand.d)Eo(), ((c)Eo()).aYB());
      localObject1 = Dc();
      final long l = System.currentTimeMillis();
      s.a(((c)Eo()).aYB(), (String)localObject1, new s.a()
      {
        public final void cV(String paramAnonymousString)
        {
          AppMethodBeat.i(146791);
          ae.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
          AppMethodBeat.o(146791);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(146790);
          ae.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
          long l1 = System.currentTimeMillis();
          long l2 = l;
          if (this.coP) {}
          for (int i = 1;; i = 0)
          {
            com.tencent.mm.appbrand.v8.x.a(3, l1 - l2, i, ((c)b.this.Eo()).getAppId(), -1, 0, ((c)b.this.Eo()).aWe().aZM());
            AppMethodBeat.o(146790);
            return;
          }
        }
      });
      localObject2 = EI();
      str1 = ((b)localObject2).name;
      str2 = ((b)localObject2).source;
      if (!TextUtils.isEmpty(((b)localObject2).coR)) {
        break label211;
      }
      localObject1 = str1;
      if (!TextUtils.isEmpty(((b)localObject2).coS)) {
        break label221;
      }
    }
    label211:
    label221:
    for (Object localObject2 = "v" + ((c)Eo()).aWe().aZM();; localObject2 = ((b)localObject2).coS)
    {
      com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.r)Eo(), ((c)Eo()).aYB(), str1, (String)localObject1, (String)localObject2, Dd(), str2, t.a.mUb, new c(str1, str2, (c)Eo(), paramBoolean, (byte)0));
      this.coI = true;
      AppMethodBeat.o(146812);
      return;
      localObject1 = ((b)localObject2).coR;
      break;
    }
  }
  
  public final boolean CN()
  {
    return this.coH;
  }
  
  protected i CO()
  {
    AppMethodBeat.i(146799);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(146799);
    return localc;
  }
  
  protected void CP()
  {
    AppMethodBeat.i(146800);
    super.CP();
    final i locali = ((c)Eo()).aYB();
    Object localObject = (com.tencent.mm.plugin.appbrand.jsruntime.t)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.t.class);
    if (localObject != null)
    {
      localObject = a((com.tencent.mm.plugin.appbrand.jsruntime.t)localObject);
      locali.addJavascriptInterface(localObject, "WeixinJSContext");
      locali.evaluateJavascript(g.coZ, null);
      ((a)localObject).Dn();
    }
    for (this.coH = true;; this.coH = false)
    {
      locali.setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.jsruntime.h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146789);
          ae.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.r.VN(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.r.VN(paramAnonymousString2) });
          cj.a(locali, "onError", str, 0);
          b.this.z(paramAnonymousString1, paramAnonymousString2);
          ae.e("MicroMsg.AppBrand.JsRuntimeException", str);
          AppMethodBeat.o(146789);
        }
      });
      this.cke = new com.tencent.luggage.sdk.b.a.a.c();
      this.cke.a(locali, Eo());
      this.ckg = new com.tencent.luggage.sdk.b.a.a.d();
      this.ckg.a(((c)Eo()).aYB(), Eo(), 0);
      com.tencent.mm.plugin.appbrand.jsapi.ad.b.c.a(locali, (com.tencent.mm.plugin.appbrand.r)Eo());
      AppMethodBeat.o(146800);
      return;
    }
  }
  
  protected void CQ()
  {
    AppMethodBeat.i(146809);
    super.CQ();
    if (this.cke != null) {
      this.cke.a(((c)Eo()).aYB());
    }
    if (this.ckg != null) {
      this.ckg.b(((c)Eo()).aYB());
    }
    AppMethodBeat.o(146809);
  }
  
  public final void Da()
  {
    AppMethodBeat.i(146804);
    super.Da();
    CU();
    AppMethodBeat.o(146804);
  }
  
  public final void Db()
  {
    AppMethodBeat.i(146805);
    super.Db();
    try
    {
      Object localObject = ((c)Eo()).aYB();
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
      ae.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146805);
    }
  }
  
  protected String Dc()
  {
    AppMethodBeat.i(146801);
    String str = "" + com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/android.js");
    str = str + com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/shared_buffer.js");
    str = str + com.tencent.mm.plugin.appbrand.jsapi.ad.b.c.bqu();
    AppMethodBeat.o(146801);
    return str;
  }
  
  protected int Dd()
  {
    return 0;
  }
  
  protected void Dg()
  {
    AppMethodBeat.i(146808);
    if (!this.coI) {
      ((c)Eo()).aYB().evaluateJavascript(com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/android.js"), null);
    }
    ((c)Eo()).EQ();
    bv(false);
    EH();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.coK)
    {
      localLinkedList.addAll(this.coK);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
    EK();
    AppMethodBeat.o(146808);
  }
  
  protected void Dh()
  {
    AppMethodBeat.i(146814);
    bv(true);
    ((c)Eo()).biM();
    AppMethodBeat.o(146814);
  }
  
  protected b EI()
  {
    AppMethodBeat.i(146811);
    Object localObject1;
    if (this.coH) {
      localObject1 = ((c)Eo()).aWe().LD("WAServiceMainContext.js");
    }
    for (String str = "WAServiceMainContext.js";; str = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "WAService.js";
        localObject2 = ((c)Eo()).aWe().LD("WAService.js");
      }
      localObject1 = new b();
      ((b)localObject1).name = str;
      ((b)localObject1).source = ((String)localObject2);
      AppMethodBeat.o(146811);
      return localObject1;
      localObject1 = null;
    }
  }
  
  protected void EJ() {}
  
  protected a a(com.tencent.mm.plugin.appbrand.jsruntime.t paramt)
  {
    AppMethodBeat.i(160992);
    paramt = new h((c)Eo(), paramt);
    AppMethodBeat.o(160992);
    return paramt;
  }
  
  protected void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146803);
    Objects.requireNonNull(Eo());
    if (this.ckg != null) {
      this.ckg.b(((c)Eo()).aYB(), Eo());
    }
    CU();
    paramAppBrandRuntime.b(aa.class, new af(com.tencent.mm.sdk.f.a.jw(paramAppBrandRuntime.mContext)));
    com.tencent.mm.plugin.appbrand.jsapi.ad.b.c.a((com.tencent.mm.plugin.appbrand.f.b)((c)Eo()).K(com.tencent.mm.plugin.appbrand.f.b.class), (com.tencent.mm.plugin.appbrand.f.a)((c)Eo()).K(com.tencent.mm.plugin.appbrand.f.a.class), (com.tencent.mm.plugin.appbrand.r)Eo());
    ae.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", "init");
    paramAppBrandRuntime = com.tencent.mm.plugin.appbrand.i.a.bhg();
    SkiaCanvasExternalTextureManager.getInstance().registerPlugin(paramAppBrandRuntime);
    AppMethodBeat.o(146803);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146807);
    super.c(paramJSONObject);
    ((c)Eo()).c(paramJSONObject, "isLazyLoad", Boolean.valueOf(((com.tencent.mm.plugin.appbrand.page.x)((c)Eo()).Eq().ar(com.tencent.mm.plugin.appbrand.page.x.class)).bva()));
    AppMethodBeat.o(146807);
  }
  
  public final boolean cU(String arg1)
  {
    AppMethodBeat.i(220762);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(220762);
      return false;
    }
    for (;;)
    {
      Object localObject1;
      synchronized (this.coL)
      {
        localObject1 = (Boolean)this.coL.get(???);
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue()))
        {
          ae.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", new Object[] { getAppId(), ??? });
          bool = false;
          AppMethodBeat.o(220762);
          return bool;
        }
        this.coL.put(???, Boolean.TRUE);
        ae.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", new Object[] { getAppId(), ??? });
        localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146792);
            if (b.this.coH) {
              try
              {
                localObject3 = new f(paramString);
                com.tencent.mm.plugin.appbrand.r localr = (com.tencent.mm.plugin.appbrand.r)Objects.requireNonNull(b.this.Eo());
                p.h(localr, "service");
                JSONObject localJSONObject1;
                for (;;)
                {
                  try
                  {
                    localJSONObject1 = new JSONObject();
                    localJSONObject1.put("moduleName", ((f)localObject3).coY);
                    Object localObject1 = (AppBrandSysConfigLU)localr.ar(AppBrandSysConfigLU.class);
                    if (localObject1 != null)
                    {
                      localObject1 = ((AppBrandSysConfigLU)localObject1).kbw;
                      localObject1 = ((WxaPkgWrappingInfo)localObject1).jMa;
                      if (localObject1 == null) {
                        break label276;
                      }
                      Object localObject4 = ((WxaRuntimeModulePluginListMap)localObject1).Mq(((f)localObject3).coY);
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
                    ae.e(((f)localObject3).TAG, "dispatch with service(" + localr.getAppId() + "), create data failed");
                    AppMethodBeat.o(146792);
                    return;
                  }
                }
                localJSONObject1.put("separatedPlugins", localObject2);
                label276:
                Object localObject2 = localJSONObject1.toString();
                p.g(localObject2, "try {\n            JSONOb…         return\n        }");
                ae.i(((f)localObject3).TAG, "dispatch appId(" + localr.getAppId() + ") onSubPackageReady(" + (String)localObject2 + ')');
                localr.bX("onSubPackageReady", (String)localObject2);
                AppMethodBeat.o(146792);
                return;
              }
              catch (Exception localException)
              {
                ae.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
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
              localObject3 = w.B(bg.M(((c)b.this.Eo()).Eq()).LK(str).ggb.fTh());
              com.tencent.mm.plugin.appbrand.utils.t.a(((c)b.this.Eo()).Eq(), ((c)b.this.Eo()).aYB(), (String)localObject3, str, "", "", t.a.mUc, new b.d(str, (c)b.this.Eo(), (byte)0));
              AppMethodBeat.o(146792);
              return;
            }
          }
        };
        if (Eo() == null) {
          ae.w("Luggage.AppBrandMiniProgramServiceLogicImp", "runOnServiceReady getComponent()==NULL");
        } else if (((c)Eo()).isRunning()) {
          ((Runnable)localObject1).run();
        }
      }
      synchronized (this.coK)
      {
        this.coK.add(localObject1);
      }
      boolean bool = true;
    }
  }
  
  protected void z(String paramString1, String paramString2) {}
  
  public static final class a
    implements com.tencent.luggage.sdk.b.a.b.a
  {}
  
  public static final class b
  {
    public String coR;
    public String coS;
    public String name;
    public String source;
  }
  
  static final class c
    implements s.b
  {
    private final String ckk;
    private final String ckl;
    private final long ckm;
    private boolean ckn;
    private m.c cko;
    private final AtomicInteger ckp;
    private final c coT;
    private final boolean coU;
    
    private c(String paramString1, String paramString2, c paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(146793);
      this.ckn = false;
      this.cko = null;
      this.ckp = new AtomicInteger(2);
      this.ckk = paramString1;
      this.ckl = paramString2;
      this.coT = paramc;
      this.coU = paramBoolean;
      this.ckm = System.currentTimeMillis();
      AppMethodBeat.o(146793);
    }
    
    private void Dk()
    {
      AppMethodBeat.i(146797);
      long l1;
      if (this.ckp.decrementAndGet() == 0)
      {
        if (this.cko != null) {
          break label105;
        }
        l1 = this.ckm;
        if (this.cko != null) {
          break label116;
        }
      }
      label105:
      label116:
      for (long l2 = System.currentTimeMillis();; l2 = this.cko.cZH)
      {
        d.a locala = new d.a();
        locala.scriptName = this.ckk;
        locala.cnx = this.ckl;
        locala.cny = bu.nullAsNil(this.ckl).length();
        this.coT.a(locala, this.ckn, l1, l2, this.cko);
        AppMethodBeat.o(146797);
        return;
        l1 = this.cko.cZG;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(146794);
      this.cko = paramc;
      Dk();
      AppMethodBeat.o(146794);
    }
    
    public final void cV(String paramString)
    {
      AppMethodBeat.i(146796);
      this.ckn = false;
      Dk();
      AppMethodBeat.o(146796);
    }
    
    public final void onSuccess(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(146795);
      this.ckn = true;
      Dk();
      long l1;
      long l2;
      if (this.ckk.equals("WAService.js"))
      {
        l1 = System.currentTimeMillis();
        l2 = this.ckm;
        if (!this.coU) {
          break label81;
        }
      }
      for (;;)
      {
        com.tencent.mm.appbrand.v8.x.a(2, l1 - l2, i, this.coT.getAppId(), -1, 0, this.coT.aWe().aZM());
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
    private final String ckk;
    private final long ckm;
    private boolean ckn;
    private m.c cko;
    private final AtomicInteger ckp;
    private final c coT;
    private int coV;
    
    private d(String paramString, c paramc)
    {
      AppMethodBeat.i(169433);
      this.coV = 0;
      this.ckn = false;
      this.cko = null;
      this.ckp = new AtomicInteger(2);
      this.ckk = paramString;
      this.coT = paramc;
      this.ckm = System.currentTimeMillis();
      AppMethodBeat.o(169433);
    }
    
    private void Dk()
    {
      AppMethodBeat.i(169437);
      long l1;
      if (this.ckp.decrementAndGet() == 0)
      {
        if (this.cko != null) {
          break label90;
        }
        l1 = this.ckm;
        if (this.cko != null) {
          break label101;
        }
      }
      label90:
      label101:
      for (long l2 = System.currentTimeMillis();; l2 = this.cko.cZH)
      {
        d.a locala = new d.a();
        locala.scriptName = this.ckk;
        locala.cny = this.coV;
        this.coT.a(locala, this.ckn, l1, l2, this.cko);
        AppMethodBeat.o(169437);
        return;
        l1 = this.cko.cZG;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(169434);
      this.cko = paramc;
      this.coV = paramc.sourceLength;
      Dk();
      AppMethodBeat.o(169434);
    }
    
    public final void cV(String paramString)
    {
      AppMethodBeat.i(169436);
      this.ckn = false;
      Dk();
      AppMethodBeat.o(169436);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(169435);
      this.ckn = true;
      Dk();
      AppMethodBeat.o(169435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */