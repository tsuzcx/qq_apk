package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.g.b.a.in.a;
import com.tencent.mm.g.b.a.io;
import com.tencent.mm.g.b.a.io.a;
import com.tencent.mm.plugin.appbrand.ap;
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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class ad
  extends bk<ae>
{
  private long mcp;
  private long mcq;
  private long mcr;
  private final Set<String> mcs;
  private at mct;
  
  public ad(ae paramae)
  {
    super(paramae);
    AppMethodBeat.i(47844);
    this.mcs = new HashSet();
    this.mct = null;
    AppMethodBeat.o(47844);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    long l2 = 1L;
    AppMethodBeat.i(47859);
    com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
    il localil = com.tencent.mm.plugin.appbrand.report.quality.b.j((com.tencent.mm.plugin.appbrand.d)El()).qY(paramString1);
    localil.evB = paramString2.length();
    if ((paramString2.startsWith("//XWEB_SCRIPT:")) && (this.mcs.contains(paramString1)))
    {
      l1 = 1L;
      localil.evE = l1;
      if (!buS()) {
        break label138;
      }
    }
    label138:
    for (long l1 = l2;; l1 = 0L)
    {
      localil.evF = l1;
      localil.ob(paramLong1);
      localil.oc(paramLong2);
      localil.oa(localil.euc - localil.eub);
      localil.aLk();
      AppMethodBeat.o(47859);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188687);
    if (!isRunning())
    {
      AppMethodBeat.o(188687);
      return;
    }
    io localio;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, paramString2, paramLong1, paramLong2);
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(getAppId());
      if (localQualitySessionRuntime != null)
      {
        localio = new io();
        localio.ri(localQualitySessionRuntime.lEv);
        localio.rj(getAppId());
        localio.eru = localQualitySessionRuntime.mvi;
        localio.ewp = io.a.ju(localQualitySessionRuntime.mtG);
        localio.esT = localQualitySessionRuntime.apptype;
        localio.os(paramLong2 - paramLong1);
        localio.dVd = localQualitySessionRuntime.scene;
        localio.ot(paramLong1);
        localio.ou(paramLong2);
        localio.rk(paramString1);
        localio.evB = bt.n(Integer.valueOf(paramString3.length()));
        if ((!paramString3.startsWith("//XWEB_SCRIPT:")) || (!this.mcs.contains(paramString2))) {
          break label290;
        }
      }
    }
    label290:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localio.evE = paramLong1;
      com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
      localio.evD = com.tencent.mm.plugin.appbrand.report.quality.b.y((ae)El());
      paramString1 = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
      localio.rl(com.tencent.mm.plugin.appbrand.report.quality.b.bxO());
      localio.aLk();
      AppMethodBeat.o(188687);
      return;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", paramString2, paramLong1, paramLong2);
      break;
    }
  }
  
  private boolean buS()
  {
    AppMethodBeat.i(47858);
    com.tencent.mm.plugin.appbrand.service.c localc = ((ae)El()).aXe();
    if (localc == null)
    {
      AppMethodBeat.o(47858);
      return false;
    }
    boolean bool2 = localc.coU.CK();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.plugin.appbrand.ak.aXO();
      bool1 = true;
    }
    AppMethodBeat.o(47858);
    return bool1;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DG()
  {
    AppMethodBeat.i(47851);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewRendererWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(47851);
    return localMap;
  }
  
  public final void DH()
  {
    AppMethodBeat.i(47857);
    super.DH();
    ((o)super.En()).jzm.G(4, bt.aO(this.mcq));
    AppBrandPerformanceManager.a((o)super.En(), 203, System.currentTimeMillis() - this.mcr);
    com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.mcr, System.currentTimeMillis(), "");
    AppMethodBeat.o(47857);
  }
  
  public final int EX()
  {
    AppMethodBeat.i(47846);
    int i = ((o)super.En()).aXc().aDD;
    AppMethodBeat.o(47846);
    return i;
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
      if (this.mct == null) {
        this.mct = new at((com.tencent.mm.plugin.appbrand.page.b.e)localObject);
      }
      localObject = ((ae)El()).buV();
      this.mct.m((com.tencent.mm.plugin.appbrand.jsapi.ab.a)localObject);
      paramClass = paramClass.cast(this.mct);
      AppMethodBeat.o(47847);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(47847);
    return paramClass;
  }
  
  public final void SX(String paramString)
  {
    AppMethodBeat.i(47856);
    super.SX(paramString);
    com.tencent.mm.plugin.appbrand.report.h.bS(getAppId(), 27);
    AppMethodBeat.o(47856);
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(188686);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    paramObject = parama.scriptName;
    String str = parama.cnv;
    if (TextUtils.isEmpty(paramObject))
    {
      AppMethodBeat.o(188686);
      return;
    }
    label90:
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.kuf, Integer.valueOf(hashCode()) });
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
        AppMethodBeat.o(188686);
        return;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.kuf, Integer.valueOf(hashCode()) });
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
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 1L, 1L, false);
    if ((o)super.En() != null)
    {
      if (!paramBoolean) {
        break label420;
      }
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, paramObject, paramLong1, paramLong2);
    }
    while (paramBoolean)
    {
      if ((bsz()) || (isRunning())) {
        a(paramObject, str, paramLong1, paramLong2);
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(188686);
      return;
      label420:
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramObject, paramLong1, paramLong2);
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 2L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.h.bS(getAppId(), 24);
    int j = -1;
    parama = ((ae)El()).getRuntime();
    if (parama != null)
    {
      i = parama.aXb().jYh.pkgVersion;
      j = parama.aXb().jYh.jIU;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.h.b(getAppId(), i, j, 370, 2);
      AppMethodBeat.o(188686);
      return;
      label602:
      Object localObject;
      if ((bsz()) || (isRunning()))
      {
        a(paramObject, str, paramLong1, paramLong2);
        AppMethodBeat.o(188686);
        return;
        a("__APP__", paramObject, str, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(188686);
        return;
        if (paramObject.equals(this.kuf))
        {
          if (!isRunning())
          {
            AppMethodBeat.o(188686);
            return;
          }
          localObject = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(getAppId());
          if (localObject != null)
          {
            parama = new in();
            parama.eqt = parama.t("InstanceId", ((QualitySessionRuntime)localObject).lEv, true);
            parama.esR = parama.t("AppId", getAppId(), true);
            parama.eru = ((QualitySessionRuntime)localObject).mvi;
            parama.ewj = in.a.jt(((QualitySessionRuntime)localObject).mtG);
            parama.esT = ((QualitySessionRuntime)localObject).apptype;
            parama.op(paramLong2 - paramLong1);
            parama.dVd = ((QualitySessionRuntime)localObject).scene;
            parama.oq(paramLong1);
            parama.or(paramLong2);
            parama.evB = str.length();
            parama.evk = parama.t("path", q.encode(paramObject), true);
          }
        }
      }
      try
      {
        localObject = ((ae)El()).mcd;
        localObject = ((ae)El()).getRuntime().aXd().j((r)localObject);
        if (localObject != null) {
          parama.ewk = parama.t("referrer", ((r)localObject).getCurrentPageView().kuf, true);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        label831:
        break label831;
      }
      com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
      parama.evD = com.tencent.mm.plugin.appbrand.report.quality.b.y((ae)El());
      if ((str.startsWith("//XWEB_SCRIPT:")) && (this.mcs.contains(paramObject))) {}
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        parama.evE = paramLong1;
        paramObject = new StringBuilder();
        com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
        parama.euG = parama.t("engineVersion", com.tencent.mm.plugin.appbrand.report.quality.b.bxO(), true);
        parama.aLk();
        AppMethodBeat.o(188686);
        return;
      }
      i = 0;
    }
  }
  
  public final ICommLibReader aVF()
  {
    AppMethodBeat.i(47845);
    ICommLibReader localICommLibReader = ((ae)El()).aVF();
    AppMethodBeat.o(47845);
    return localICommLibReader;
  }
  
  protected final bb bsA()
  {
    AppMethodBeat.i(47853);
    if ((buR().supportFeature(2002)) && (buR().supportFeature(2004)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxr, true)))
    {
      localObject = new ad.5(this, this);
      AppMethodBeat.o(47853);
      return localObject;
    }
    Object localObject = super.bsA();
    AppMethodBeat.o(47853);
    return localObject;
  }
  
  protected final boolean btG()
  {
    AppMethodBeat.i(47848);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (ap.n(((ae)El()).getRuntime()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    boolean bool = super.btG();
    AppMethodBeat.o(47848);
    return bool;
  }
  
  protected final com.tencent.mm.plugin.appbrand.performance.g btI()
  {
    AppMethodBeat.i(175035);
    i locali = new i((ae)El());
    AppMethodBeat.o(175035);
    return locali;
  }
  
  public final ak buR()
  {
    if ((this.lYc instanceof ak)) {
      return (ak)this.lYc;
    }
    if ((this.lYc instanceof ar))
    {
      ay localay = ((ar)this.lYc).meh;
      if ((localay instanceof ak)) {
        return (ak)localay;
      }
    }
    return null;
  }
  
  public final boolean cX(String paramString)
  {
    AppMethodBeat.i(47855);
    this.mcr = System.currentTimeMillis();
    bvq().ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188683);
        ad.a(ad.this, bt.HI());
        AppMethodBeat.o(188683);
      }
    });
    for (;;)
    {
      try
      {
        bool = ((o)super.En()).jzi;
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        AccessibilityManager localAccessibilityManager;
        continue;
      }
      bvq().aw(((ae)El()).getContext());
      bool = super.cX(paramString);
      com.tencent.mm.plugin.appbrand.e.a((ae)El());
      AppMethodBeat.o(47855);
      return bool;
      localAccessibilityManager = (AccessibilityManager)android.support.v4.content.b.a(getContext(), AccessibilityManager.class);
      if ((localAccessibilityManager != null) && (!localAccessibilityManager.isTouchExplorationEnabled())) {
        ((ae)El()).kca.setContentDescription(k.dr(paramString));
      }
    }
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(47849);
    super.cm(paramView);
    if ((bvq() instanceof ar)) {}
    for (paramView = ((ar)bvq()).meh;; paramView = bvq())
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((ae)El()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void DA()
        {
          AppMethodBeat.i(47838);
          f.e(false, true, false);
          AppMethodBeat.o(47838);
        }
        
        public final void bht()
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
  
  public final az dJ(Context paramContext)
  {
    AppMethodBeat.i(47852);
    this.mcp = bt.HI();
    paramContext = (az)com.tencent.luggage.sdk.g.c.a("onCreateRealWebView", new ad.3(this, paramContext), new ad.4(this));
    AppMethodBeat.o(47852);
    return paramContext;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47854);
    if (z.f((aa)El()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
      z.a(((ae)El()).aYh(), ((ae)El()).aXe().aXC(), ((ae)El()).aXC(), getAppId());
    }
    super.dispatchStart();
    Q(com.tencent.mm.plugin.appbrand.page.b.e.class);
    boolean bool = buR().getIsX5Kernel();
    n.KF(getAppId()).jyV.set(bool);
    com.tencent.mm.plugin.appbrand.report.h.hy(bool);
    bvq().ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47843);
        ad.this.getRuntime().jzm.G(3, bt.aO(ad.b(ad.this)));
        com.tencent.mm.plugin.appbrand.performance.c.a(ad.this.getAppId(), "Native", "WebViewInit+PageFrameLoad", ad.b(ad.this), System.currentTimeMillis(), "");
        AppMethodBeat.o(47843);
      }
    });
    if (com.tencent.mm.plugin.appbrand.ab.g.am(((ae)El()).getRuntime())) {
      super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new com.tencent.mm.plugin.appbrand.ab.d((aa)El()));
    }
    AppMethodBeat.o(47854);
  }
  
  public final o getRuntime()
  {
    AppMethodBeat.i(221294);
    o localo = (o)super.En();
    AppMethodBeat.o(221294);
    return localo;
  }
  
  protected final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188685);
    if (El() == null)
    {
      AppMethodBeat.o(188685);
      return;
    }
    if (isRunning())
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
      com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.d)El(), paramString, paramLong1, paramLong2, buS(), 0L);
    }
    AppMethodBeat.o(188685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */