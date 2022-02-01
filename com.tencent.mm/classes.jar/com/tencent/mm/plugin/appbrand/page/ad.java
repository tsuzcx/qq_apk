package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hh;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.g.b.a.hj.a;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.g.b.a.hk.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import d.g.a.q;
import d.y;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class ad
  extends bk<ae>
{
  private long lCN;
  private long lCO;
  private long lCP;
  private final Set<String> lCQ;
  private at lCR;
  
  public ad(ae paramae)
  {
    super(paramae);
    AppMethodBeat.i(47844);
    this.lCQ = new HashSet();
    this.lCR = null;
    AppMethodBeat.o(47844);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    long l2 = 1L;
    AppMethodBeat.i(47859);
    com.tencent.mm.plugin.appbrand.report.quality.a.btI();
    hh localhh = com.tencent.mm.plugin.appbrand.report.quality.b.g((com.tencent.mm.plugin.appbrand.d)CM()).ou(paramString1);
    localhh.eeO = paramString2.length();
    if ((paramString2.startsWith("//XWEB_SCRIPT:")) && (this.lCQ.contains(paramString1)))
    {
      l1 = 1L;
      localhh.eeR = l1;
      if (!bqS()) {
        break label138;
      }
    }
    label138:
    for (long l1 = l2;; l1 = 0L)
    {
      localhh.eeS = l1;
      localhh.md(paramLong1);
      localhh.me(paramLong2);
      localhh.mc(localhh.edx - localhh.edw);
      localhh.aHZ();
      AppMethodBeat.o(47859);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(186891);
    if (!isRunning())
    {
      AppMethodBeat.o(186891);
      return;
    }
    hk localhk;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, paramString2, paramLong1, paramLong2);
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.QN(getAppId());
      if (localQualitySessionRuntime != null)
      {
        localhk = new hk();
        localhk.oB(localQualitySessionRuntime.lht);
        localhk.oC(getAppId());
        localhk.eaM = localQualitySessionRuntime.lVs;
        localhk.efA = hk.a.iX(localQualitySessionRuntime.lTR);
        localhk.eco = localQualitySessionRuntime.apptype;
        localhk.mu(paramLong2 - paramLong1);
        localhk.dHY = localQualitySessionRuntime.scene;
        localhk.mv(paramLong1);
        localhk.mw(paramLong2);
        localhk.oD(paramString1);
        localhk.eeO = bs.m(Integer.valueOf(paramString3.length()));
        if ((!paramString3.startsWith("//XWEB_SCRIPT:")) || (!this.lCQ.contains(paramString2))) {
          break label290;
        }
      }
    }
    label290:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localhk.eeR = paramLong1;
      com.tencent.mm.plugin.appbrand.report.quality.a.btI();
      localhk.eeQ = com.tencent.mm.plugin.appbrand.report.quality.b.x((ae)CM());
      paramString1 = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.a.btI();
      localhk.oE(com.tencent.mm.plugin.appbrand.report.quality.b.btJ());
      localhk.aHZ();
      AppMethodBeat.o(186891);
      return;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", paramString2, paramLong1, paramLong2);
      break;
    }
  }
  
  private boolean bqS()
  {
    AppMethodBeat.i(47858);
    com.tencent.mm.plugin.appbrand.service.c localc = ((ae)CM()).aTU();
    if (localc == null)
    {
      AppMethodBeat.o(47858);
      return false;
    }
    boolean bool2 = localc.ceD.Bl();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.plugin.appbrand.ak.aUC();
      bool1 = true;
    }
    AppMethodBeat.o(47858);
    return bool1;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> Ch()
  {
    AppMethodBeat.i(47851);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewRendererWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(47851);
    return localMap;
  }
  
  public final void Ci()
  {
    AppMethodBeat.i(47857);
    super.Ci();
    ((o)super.CO()).jgg.E(4, bs.aO(this.lCO));
    AppBrandPerformanceManager.a((o)super.CO(), 203, System.currentTimeMillis() - this.lCP);
    com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.lCP, System.currentTimeMillis(), "");
    AppMethodBeat.o(47857);
  }
  
  public final int Dy()
  {
    AppMethodBeat.i(47846);
    int i = ((o)super.CO()).aTS().aBM;
    AppMethodBeat.o(47846);
    return i;
  }
  
  public final void Pv(String paramString)
  {
    AppMethodBeat.i(47856);
    super.Pv(paramString);
    com.tencent.mm.plugin.appbrand.report.g.bP(getAppId(), 27);
    AppMethodBeat.o(47856);
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(47847);
    if (com.tencent.mm.plugin.appbrand.page.b.e.class == paramClass)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.b.e)super.Q(com.tencent.mm.plugin.appbrand.page.b.e.class);
      if (localObject == null)
      {
        AppMethodBeat.o(47847);
        return null;
      }
      if (this.lCR == null) {
        this.lCR = new at((com.tencent.mm.plugin.appbrand.page.b.e)localObject);
      }
      localObject = ((ae)CM()).bqU();
      this.lCR.k((com.tencent.mm.plugin.appbrand.jsapi.y.a)localObject);
      paramClass = paramClass.cast(this.lCR);
      AppMethodBeat.o(47847);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(47847);
    return paramClass;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(186890);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    paramObject = parama.scriptName;
    String str = parama.cde;
    if (TextUtils.isEmpty(paramObject))
    {
      AppMethodBeat.o(186890);
      return;
    }
    label90:
    int i;
    if (!paramBoolean)
    {
      ac.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.jZJ, Integer.valueOf(hashCode()) });
      i = -1;
      switch (paramObject.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        if (!paramObject.endsWith("page-frame.js")) {
          break label602;
        }
        a(paramObject.substring(0, paramObject.length() - 13), paramObject, str, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(186890);
        return;
        ac.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.jZJ, Integer.valueOf(hashCode()) });
        break label90;
        if (paramObject.equals("WAWebview.js"))
        {
          i = 0;
          continue;
          if (paramObject.equals("WAVConsole.js"))
          {
            i = 1;
            continue;
            if (paramObject.equals("app-wxss.js"))
            {
              i = 2;
              continue;
              if (paramObject.equals("page-frame.html")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(370L, 1L, 1L, false);
    if ((o)super.CO() != null)
    {
      if (!paramBoolean) {
        break label420;
      }
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, paramObject, paramLong1, paramLong2);
    }
    while (paramBoolean)
    {
      if ((boA()) || (isRunning())) {
        a(paramObject, str, paramLong1, paramLong2);
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(186890);
      return;
      label420:
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramObject, paramLong1, paramLong2);
    }
    ac.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(370L, 2L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.g.bP(getAppId(), 24);
    int j = -1;
    parama = ((ae)CM()).getRuntime();
    if (parama != null)
    {
      i = parama.aTR().jEg.pkgVersion;
      j = parama.aTR().jEg.jpa;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.g.b(getAppId(), i, j, 370, 2);
      AppMethodBeat.o(186890);
      return;
      label602:
      Object localObject;
      if ((boA()) || (isRunning()))
      {
        a(paramObject, str, paramLong1, paramLong2);
        AppMethodBeat.o(186890);
        return;
        a("__APP__", paramObject, str, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(186890);
        return;
        if (paramObject.equals(this.jZJ))
        {
          if (!isRunning())
          {
            AppMethodBeat.o(186890);
            return;
          }
          localObject = com.tencent.mm.plugin.appbrand.report.quality.a.QN(getAppId());
          if (localObject != null)
          {
            parama = new hj();
            parama.dZT = parama.t("InstanceId", ((QualitySessionRuntime)localObject).lht, true);
            parama.ecm = parama.t("AppId", getAppId(), true);
            parama.eaM = ((QualitySessionRuntime)localObject).lVs;
            parama.efu = hj.a.iW(((QualitySessionRuntime)localObject).lTR);
            parama.eco = ((QualitySessionRuntime)localObject).apptype;
            parama.mr(paramLong2 - paramLong1);
            parama.dHY = ((QualitySessionRuntime)localObject).scene;
            parama.ms(paramLong1);
            parama.mt(paramLong2);
            parama.eeO = str.length();
            parama.eex = parama.t("path", paramObject, true);
          }
        }
      }
      try
      {
        localObject = ((ae)CM()).lCC;
        localObject = ((ae)CM()).getRuntime().aTT().j((r)localObject);
        if (localObject != null) {
          parama.efv = parama.t("referrer", ((r)localObject).getCurrentPageView().jZJ, true);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        label828:
        break label828;
      }
      com.tencent.mm.plugin.appbrand.report.quality.a.btI();
      parama.eeQ = com.tencent.mm.plugin.appbrand.report.quality.b.x((ae)CM());
      if ((str.startsWith("//XWEB_SCRIPT:")) && (this.lCQ.contains(paramObject))) {}
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        parama.eeR = paramLong1;
        paramObject = new StringBuilder();
        com.tencent.mm.plugin.appbrand.report.quality.a.btI();
        parama.eeU = parama.t("engineVersion", com.tencent.mm.plugin.appbrand.report.quality.b.btJ(), true);
        parama.aHZ();
        AppMethodBeat.o(186890);
        return;
      }
      i = 0;
    }
  }
  
  public final ICommLibReader aSt()
  {
    AppMethodBeat.i(47845);
    ICommLibReader localICommLibReader = ((ae)CM()).aSt();
    AppMethodBeat.o(47845);
    return localICommLibReader;
  }
  
  protected final bb boB()
  {
    AppMethodBeat.i(47853);
    if ((bqR().supportFeature(2002)) && (bqR().supportFeature(2004)) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSN, true)))
    {
      localObject = new bg(this)
      {
        public final void PO(String paramAnonymousString)
        {
          AppMethodBeat.i(186887);
          ad.a(ad.this).add(paramAnonymousString);
          AppMethodBeat.o(186887);
        }
      };
      AppMethodBeat.o(47853);
      return localObject;
    }
    Object localObject = super.boB();
    AppMethodBeat.o(47853);
    return localObject;
  }
  
  protected final boolean bpG()
  {
    AppMethodBeat.i(47848);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    boolean bool = super.bpG();
    AppMethodBeat.o(47848);
    return bool;
  }
  
  protected final com.tencent.mm.plugin.appbrand.performance.g bpI()
  {
    AppMethodBeat.i(175035);
    i locali = new i((ae)CM());
    AppMethodBeat.o(175035);
    return locali;
  }
  
  public final ak bqR()
  {
    if ((this.lyE instanceof ak)) {
      return (ak)this.lyE;
    }
    if ((this.lyE instanceof ar))
    {
      ay localay = ((ar)this.lyE).lED;
      if ((localay instanceof ak)) {
        return (ak)localay;
      }
    }
    return null;
  }
  
  public final boolean cd(String paramString)
  {
    AppMethodBeat.i(47855);
    this.lCP = System.currentTimeMillis();
    brp().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186888);
        ad.a(ad.this, bs.Gn());
        AppMethodBeat.o(186888);
      }
    });
    if (((o)super.CO()).jgc) {
      ((ae)CM()).jHO.setContentDescription(k.cp(paramString));
    }
    brp().aw(((ae)CM()).getContext());
    boolean bool = super.cd(paramString);
    com.tencent.mm.plugin.appbrand.e.a((ae)CM());
    AppMethodBeat.o(47855);
    return bool;
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(47849);
    super.cm(paramView);
    if ((brp() instanceof ar)) {}
    for (paramView = ((ar)brp()).lED;; paramView = brp())
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((ae)CM()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void Cb()
        {
          AppMethodBeat.i(47838);
          f.e(false, true, false);
          AppMethodBeat.o(47838);
        }
        
        public final void bdP()
        {
          AppMethodBeat.i(47837);
          f.e(true, true, false);
          AppMethodBeat.o(47837);
        }
      });
      AppMethodBeat.o(47849);
      return;
    }
  }
  
  public final az dK(final Context paramContext)
  {
    AppMethodBeat.i(47852);
    this.lCN = bs.Gn();
    paramContext = (az)com.tencent.luggage.sdk.g.c.a("onCreateRealWebView", new d.g.a.a()new q {}, new q() {});
    AppMethodBeat.o(47852);
    return paramContext;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47854);
    if (z.f((aa)CM()))
    {
      ac.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
      z.a(((ae)CM()).aUV(), ((ae)CM()).aTU().aUT(), ((ae)CM()).aUT(), getAppId());
    }
    super.dispatchStart();
    Q(com.tencent.mm.plugin.appbrand.page.b.e.class);
    boolean bool = bqR().getIsX5Kernel();
    n.Hs(getAppId()).jfP.set(bool);
    com.tencent.mm.plugin.appbrand.report.g.hr(bool);
    brp().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47843);
        ad.this.getRuntime().jgg.E(3, bs.aO(ad.b(ad.this)));
        com.tencent.mm.plugin.appbrand.performance.c.a(ad.this.getAppId(), "Native", "WebViewInit+PageFrameLoad", ad.b(ad.this), System.currentTimeMillis(), "");
        AppMethodBeat.o(47843);
      }
    });
    if (com.tencent.mm.plugin.appbrand.ab.g.as(((ae)CM()).getRuntime())) {
      super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new com.tencent.mm.plugin.appbrand.ab.d((aa)CM()));
    }
    AppMethodBeat.o(47854);
  }
  
  public final o getRuntime()
  {
    AppMethodBeat.i(210158);
    o localo = (o)super.CO();
    AppMethodBeat.o(210158);
    return localo;
  }
  
  protected final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(47860);
    if (CM() == null)
    {
      AppMethodBeat.o(47860);
      return;
    }
    if ((boA()) || (isRunning()))
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.btI();
      com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.d)CM(), paramString, paramLong1, paramLong2, bqS(), 0L);
    }
    AppMethodBeat.o(47860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */