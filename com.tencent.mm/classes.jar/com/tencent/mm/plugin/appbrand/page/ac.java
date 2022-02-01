package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.g.b.a.ip;
import com.tencent.mm.g.b.a.ip.a;
import com.tencent.mm.g.b.a.iq;
import com.tencent.mm.g.b.a.iq.a;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.aa;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class ac
  extends bj<ad>
{
  private long mgH;
  private long mgI;
  private long mgJ;
  private final Set<String> mgK;
  private as mgL;
  
  public ac(ad paramad)
  {
    super(paramad);
    AppMethodBeat.i(47844);
    this.mgK = new HashSet();
    this.mgL = null;
    AppMethodBeat.o(47844);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    long l2 = 1L;
    AppMethodBeat.i(47859);
    com.tencent.mm.plugin.appbrand.report.quality.a.byG();
    in localin = com.tencent.mm.plugin.appbrand.report.quality.b.l((com.tencent.mm.plugin.appbrand.d)Eo()).rt(paramString1);
    localin.exi = paramString2.length();
    if ((paramString2.startsWith("//XWEB_SCRIPT:")) && (this.mgK.contains(paramString1)))
    {
      l1 = 1L;
      localin.exl = l1;
      if (!bvD()) {
        break label138;
      }
    }
    label138:
    for (long l1 = l2;; l1 = 0L)
    {
      localin.exm = l1;
      localin.on(paramLong1);
      localin.oo(paramLong2);
      localin.om(localin.evJ - localin.evI);
      localin.aLH();
      AppMethodBeat.o(47859);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(222858);
    if (!isRunning())
    {
      AppMethodBeat.o(222858);
      return;
    }
    iq localiq;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, paramString2, paramLong1, paramLong2);
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(getAppId());
      if (localQualitySessionRuntime != null)
      {
        localiq = new iq();
        localiq.rD(localQualitySessionRuntime.lIU);
        localiq.rE(getAppId());
        localiq.etb = localQualitySessionRuntime.mAf;
        localiq.exY = iq.a.jw(localQualitySessionRuntime.myD);
        localiq.euA = localQualitySessionRuntime.apptype;
        localiq.oF(paramLong2 - paramLong1);
        localiq.dWt = localQualitySessionRuntime.scene;
        localiq.oG(paramLong1);
        localiq.oH(paramLong2);
        localiq.rF(paramString1);
        localiq.exi = bu.o(Integer.valueOf(paramString3.length()));
        if ((!paramString3.startsWith("//XWEB_SCRIPT:")) || (!this.mgK.contains(paramString2))) {
          break label290;
        }
      }
    }
    label290:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localiq.exl = paramLong1;
      com.tencent.mm.plugin.appbrand.report.quality.a.byG();
      localiq.exk = com.tencent.mm.plugin.appbrand.report.quality.b.z((ad)Eo());
      paramString1 = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.a.byG();
      localiq.rG(com.tencent.mm.plugin.appbrand.report.quality.b.byH());
      localiq.aLH();
      AppMethodBeat.o(222858);
      return;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", paramString2, paramLong1, paramLong2);
      break;
    }
  }
  
  private boolean bvD()
  {
    AppMethodBeat.i(47858);
    com.tencent.mm.plugin.appbrand.service.c localc = ((ad)Eo()).aXz();
    if (localc == null)
    {
      AppMethodBeat.o(47858);
      return false;
    }
    boolean bool2 = localc.coW.CN();
    boolean bool1 = bool2;
    if (!bool2)
    {
      ak.aYh();
      bool1 = true;
    }
    AppMethodBeat.o(47858);
    return bool1;
  }
  
  public final Map<String, m> DJ()
  {
    AppMethodBeat.i(47851);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewRendererWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(47851);
    return localMap;
  }
  
  public final void DK()
  {
    AppMethodBeat.i(47857);
    super.DK();
    ((p)super.Eq()).jCn.F(4, bu.aO(this.mgI));
    AppBrandPerformanceManager.a((p)super.Eq(), 203, System.currentTimeMillis() - this.mgJ);
    com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.mgJ, System.currentTimeMillis(), "");
    AppMethodBeat.o(47857);
  }
  
  public final int Fc()
  {
    AppMethodBeat.i(47846);
    int i = ((p)super.Eq()).aXx().aDD;
    AppMethodBeat.o(47846);
    return i;
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(47847);
    if (com.tencent.mm.plugin.appbrand.page.a.e.class == paramClass)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.e)super.Q(com.tencent.mm.plugin.appbrand.page.a.e.class);
      if (localObject == null)
      {
        AppMethodBeat.o(47847);
        return null;
      }
      if (this.mgL == null) {
        this.mgL = new as((com.tencent.mm.plugin.appbrand.page.a.e)localObject);
      }
      localObject = ((ad)Eo()).bvG();
      this.mgL.m((com.tencent.mm.plugin.appbrand.jsapi.ac.a)localObject);
      paramClass = paramClass.cast(this.mgL);
      AppMethodBeat.o(47847);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(47847);
    return paramClass;
  }
  
  public final void TG(String paramString)
  {
    AppMethodBeat.i(47856);
    super.TG(paramString);
    com.tencent.mm.plugin.appbrand.report.h.bW(getAppId(), 27);
    AppMethodBeat.o(47856);
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(222857);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    paramObject = parama.scriptName;
    String str = parama.cnx;
    if (TextUtils.isEmpty(paramObject))
    {
      AppMethodBeat.o(222857);
      return;
    }
    label90:
    int i;
    if (!paramBoolean)
    {
      ae.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.kxv, Integer.valueOf(hashCode()) });
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
        AppMethodBeat.o(222857);
        return;
        ae.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.kxv, Integer.valueOf(hashCode()) });
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 1L, 1L, false);
    if ((p)super.Eq() != null)
    {
      if (!paramBoolean) {
        break label420;
      }
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, paramObject, paramLong1, paramLong2);
    }
    while (paramBoolean)
    {
      if ((btk()) || (isRunning())) {
        a(paramObject, str, paramLong1, paramLong2);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(222857);
      return;
      label420:
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramObject, paramLong1, paramLong2);
    }
    ae.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 2L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.h.bW(getAppId(), 24);
    int j = -1;
    parama = ((ad)Eo()).getRuntime();
    if (parama != null)
    {
      i = parama.aXw().kbw.pkgVersion;
      j = parama.aXw().kbw.jLV;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.h.b(getAppId(), i, j, 370, 2);
      AppMethodBeat.o(222857);
      return;
      label602:
      Object localObject;
      if ((btk()) || (isRunning()))
      {
        a(paramObject, str, paramLong1, paramLong2);
        AppMethodBeat.o(222857);
        return;
        a("__APP__", paramObject, str, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(222857);
        return;
        if (paramObject.equals(this.kxv))
        {
          if (!isRunning())
          {
            AppMethodBeat.o(222857);
            return;
          }
          localObject = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(getAppId());
          if (localObject != null)
          {
            parama = new ip();
            parama.esa = parama.t("InstanceId", ((QualitySessionRuntime)localObject).lIU, true);
            parama.euy = parama.t("AppId", getAppId(), true);
            parama.etb = ((QualitySessionRuntime)localObject).mAf;
            parama.exS = ip.a.jv(((QualitySessionRuntime)localObject).myD);
            parama.euA = ((QualitySessionRuntime)localObject).apptype;
            parama.oC(paramLong2 - paramLong1);
            parama.dWt = ((QualitySessionRuntime)localObject).scene;
            parama.oD(paramLong1);
            parama.oE(paramLong2);
            parama.exi = str.length();
            parama.ewR = parama.t("path", com.tencent.mm.compatible.util.q.encode(paramObject), true);
          }
        }
      }
      try
      {
        localObject = ((ad)Eo()).mgv;
        localObject = ((ad)Eo()).getRuntime().aXy().j((q)localObject);
        if (localObject != null) {
          parama.exT = parama.t("referrer", ((q)localObject).getCurrentPageView().kxv, true);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        label831:
        break label831;
      }
      com.tencent.mm.plugin.appbrand.report.quality.a.byG();
      parama.exk = com.tencent.mm.plugin.appbrand.report.quality.b.z((ad)Eo());
      if ((str.startsWith("//XWEB_SCRIPT:")) && (this.mgK.contains(paramObject))) {}
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        parama.exl = paramLong1;
        paramObject = new StringBuilder();
        com.tencent.mm.plugin.appbrand.report.quality.a.byG();
        parama.ewn = parama.t("engineVersion", com.tencent.mm.plugin.appbrand.report.quality.b.byH(), true);
        parama.aLH();
        AppMethodBeat.o(222857);
        return;
      }
      i = 0;
    }
  }
  
  public final ICommLibReader aWe()
  {
    AppMethodBeat.i(47845);
    ICommLibReader localICommLibReader = ((ad)Eo()).aWe();
    AppMethodBeat.o(47845);
    return localICommLibReader;
  }
  
  protected final ba btl()
  {
    AppMethodBeat.i(47853);
    if ((bvC().supportFeature(2002)) && (bvC().supportFeature(2004)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEx, true)))
    {
      localObject = new bf(this)
      {
        public final void Ud(String paramAnonymousString)
        {
          AppMethodBeat.i(222853);
          ac.a(ac.this).add(paramAnonymousString);
          AppMethodBeat.o(222853);
        }
      };
      AppMethodBeat.o(47853);
      return localObject;
    }
    Object localObject = super.btl();
    AppMethodBeat.o(47853);
    return localObject;
  }
  
  protected final boolean bur()
  {
    AppMethodBeat.i(47848);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.aq.o(((ad)Eo()).getRuntime()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    boolean bool = super.bur();
    AppMethodBeat.o(47848);
    return bool;
  }
  
  protected final com.tencent.mm.plugin.appbrand.performance.g but()
  {
    AppMethodBeat.i(175035);
    i locali = new i((ad)Eo());
    AppMethodBeat.o(175035);
    return locali;
  }
  
  public final aj bvC()
  {
    if ((this.mcJ instanceof aj)) {
      return (aj)this.mcJ;
    }
    if ((this.mcJ instanceof aq))
    {
      ax localax = ((aq)this.mcJ).miB;
      if ((localax instanceof aj)) {
        return (aj)localax;
      }
    }
    return null;
  }
  
  public final boolean cZ(String paramString)
  {
    AppMethodBeat.i(47855);
    this.mgJ = System.currentTimeMillis();
    bwb().Z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222854);
        ac.a(ac.this, bu.HQ());
        AppMethodBeat.o(222854);
      }
    });
    for (;;)
    {
      try
      {
        bool = ((p)super.Eq()).jCj;
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
      bwb().ax(((ad)Eo()).getContext());
      bool = super.cZ(paramString);
      com.tencent.mm.plugin.appbrand.e.a((ad)Eo());
      AppMethodBeat.o(47855);
      return bool;
      localAccessibilityManager = (AccessibilityManager)android.support.v4.content.b.a(getContext(), AccessibilityManager.class);
      if ((localAccessibilityManager != null) && (!localAccessibilityManager.isTouchExplorationEnabled())) {
        ((ad)Eo()).kfr.setContentDescription(k.dt(paramString));
      }
    }
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(47849);
    super.cm(paramView);
    if ((bwb() instanceof aq)) {}
    for (paramView = ((aq)bwb()).miB;; paramView = bwb())
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((ad)Eo()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void DD()
        {
          AppMethodBeat.i(47838);
          f.e(false, true, false);
          AppMethodBeat.o(47838);
        }
        
        public final void bib()
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
  
  public final ay dN(final Context paramContext)
  {
    AppMethodBeat.i(47852);
    this.mgH = bu.HQ();
    paramContext = (ay)com.tencent.luggage.sdk.g.c.a("onCreateRealWebView", new d.g.a.a()new d.g.a.q {}, new d.g.a.q() {});
    AppMethodBeat.o(47852);
    return paramContext;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47854);
    if (aa.f((z)Eo()))
    {
      ae.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
      aa.a(((ad)Eo()).aYB(), ((ad)Eo()).aXz().aXX(), ((ad)Eo()).aXX(), getAppId());
    }
    super.dispatchStart();
    Q(com.tencent.mm.plugin.appbrand.page.a.e.class);
    boolean bool = bvC().getIsX5Kernel();
    o.Le(getAppId()).jBV.set(bool);
    com.tencent.mm.plugin.appbrand.report.h.hz(bool);
    bwb().Z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47843);
        ac.this.getRuntime().jCn.F(3, bu.aO(ac.b(ac.this)));
        com.tencent.mm.plugin.appbrand.performance.c.a(ac.this.getAppId(), "Native", "WebViewInit+PageFrameLoad", ac.b(ac.this), System.currentTimeMillis(), "");
        AppMethodBeat.o(47843);
      }
    });
    if (com.tencent.mm.plugin.appbrand.aa.g.am(((ad)Eo()).getRuntime())) {
      super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.mm.plugin.appbrand.aa.d((z)Eo()));
    }
    AppMethodBeat.o(47854);
  }
  
  public final p getRuntime()
  {
    AppMethodBeat.i(224369);
    p localp = (p)super.Eq();
    AppMethodBeat.o(224369);
    return localp;
  }
  
  protected final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(222856);
    if (Eo() == null)
    {
      AppMethodBeat.o(222856);
      return;
    }
    if (isRunning())
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.byG();
      com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.d)Eo(), paramString, paramLong1, paramLong2, bvD(), 0L);
    }
    AppMethodBeat.o(222856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */