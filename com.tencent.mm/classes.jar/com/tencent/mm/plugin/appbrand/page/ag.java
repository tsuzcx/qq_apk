package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.luggage.k.l;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ph;
import com.tencent.mm.f.b.a.pk;
import com.tencent.mm.f.b.a.pk.a;
import com.tencent.mm.f.b.a.pl;
import com.tencent.mm.f.b.a.pl.a;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.w.b;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.i;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import kotlin.x;

public class ag
  extends bp<ah>
  implements w.b
{
  private long qta;
  private long qtb;
  private long qtc;
  private final Set<String> qtd;
  final Set<at> qte;
  private ax qtf;
  private final at qtg;
  
  public ag(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(47844);
    this.qtd = new HashSet();
    this.qte = Collections.synchronizedSet(new HashSet());
    this.qtf = null;
    this.qtg = new ag.3(this);
    AppMethodBeat.o(47844);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    long l2 = 1L;
    AppMethodBeat.i(47859);
    ph localph = com.tencent.mm.plugin.appbrand.report.quality.b.cik().p((com.tencent.mm.plugin.appbrand.g)QK()).Ge(paramString1);
    localph.heu = paramString2.length();
    if ((paramString2.startsWith("//XWEB_SCRIPT:")) && (this.qtd.contains(paramString1)))
    {
      l1 = 1L;
      localph.hex = l1;
      if (!ceA()) {
        break label137;
      }
    }
    label137:
    for (long l1 = l2;; l1 = 0L)
    {
      localph.hey = l1;
      localph.BS(paramLong1);
      localph.BT(paramLong2);
      localph.BR(localph.hcV - localph.hcU);
      localph.bpa();
      AppMethodBeat.o(47859);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(280326);
    if (!isRunning())
    {
      AppMethodBeat.o(280326);
      return;
    }
    pl localpl;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, paramString2, paramLong1, paramLong2);
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.amO(getAppId());
      if (localQualitySessionRuntime != null)
      {
        localpl = new pl();
        localpl.Gv(localQualitySessionRuntime.cBH);
        localpl.Gw(getAppId());
        localpl.gYL = localQualitySessionRuntime.qNx;
        localpl.hfp = pl.a.oJ(localQualitySessionRuntime.qLQ);
        localpl.gYN = localQualitySessionRuntime.apptype;
        localpl.Cq(paramLong2 - paramLong1);
        localpl.gnP = localQualitySessionRuntime.scene;
        localpl.Cr(paramLong1);
        localpl.Cs(paramLong2);
        localpl.Gx(paramString1);
        localpl.heu = Util.nullAsNil(Integer.valueOf(paramString3.length()));
        if ((!paramString3.startsWith("//XWEB_SCRIPT:")) || (!this.qtd.contains(paramString2))) {
          break label290;
        }
      }
    }
    label290:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localpl.hex = paramLong1;
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      localpl.hew = com.tencent.mm.plugin.appbrand.report.quality.c.x((ah)QK());
      paramString1 = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      localpl.Gy(com.tencent.mm.plugin.appbrand.report.quality.c.cil());
      localpl.bpa();
      AppMethodBeat.o(280326);
      return;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", paramString2, paramLong1, paramLong2);
      break;
    }
  }
  
  private boolean ceA()
  {
    AppMethodBeat.i(47858);
    com.tencent.mm.plugin.appbrand.service.c localc = ((ah)QK()).bDA();
    if (localc == null)
    {
      AppMethodBeat.o(47858);
      return false;
    }
    boolean bool2 = localc.cAr.Pb();
    boolean bool1 = bool2;
    if (!bool2)
    {
      ao.bEm();
      bool1 = true;
    }
    AppMethodBeat.o(47858);
    return bool1;
  }
  
  public final void PV()
  {
    AppMethodBeat.i(293296);
    super.PV();
    HalfScreenConfig localHalfScreenConfig = ((t)super.QM()).bDy().nBE;
    if (localHalfScreenConfig.isEnable())
    {
      Object localObject = this.qoF;
      if (localHalfScreenConfig.nnk) {
        ((bd)localObject).setBackgroundColor(-1);
      }
      localObject = cez();
      if (((localObject instanceof j)) && (localHalfScreenConfig.nZE))
      {
        ((j)localObject).setFixSizeEnable(true);
        AppMethodBeat.o(293296);
        return;
      }
      ((j)localObject).setFixSizeEnable(false);
    }
    AppMethodBeat.o(293296);
  }
  
  public final Map<String, o> PX()
  {
    AppMethodBeat.i(47851);
    Map localMap = (Map)com.tencent.luggage.sdk.h.d.a("AppBrandPageViewRendererWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(47851);
    return localMap;
  }
  
  public final void PY()
  {
    AppMethodBeat.i(47857);
    super.PY();
    ((t)super.QM()).nwu.I(4, Util.ticksToNow(this.qtb));
    AppBrandPerformanceManager.a((t)super.QM(), 203, System.currentTimeMillis() - this.qtc);
    com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.qtc, System.currentTimeMillis(), "");
    AppMethodBeat.o(47857);
  }
  
  public final <T> T R(Class<T> paramClass)
  {
    AppMethodBeat.i(47847);
    if (com.tencent.mm.plugin.appbrand.page.a.e.class == paramClass)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.e)super.R(com.tencent.mm.plugin.appbrand.page.a.e.class);
      if (localObject == null)
      {
        AppMethodBeat.o(47847);
        return null;
      }
      if (this.qtf == null) {
        this.qtf = new ax((com.tencent.mm.plugin.appbrand.page.a.e)localObject);
      }
      localObject = ((ah)Objects.requireNonNull(QK())).ceE();
      this.qtf.d((g.c)localObject);
      paramClass = paramClass.cast(this.qtf);
      AppMethodBeat.o(47847);
      return paramClass;
    }
    paramClass = super.R(paramClass);
    AppMethodBeat.o(47847);
    return paramClass;
  }
  
  public final int Sg()
  {
    AppMethodBeat.i(47846);
    int i = ((t)super.QM()).bDy().appVersion;
    AppMethodBeat.o(47846);
    return i;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(280324);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (QK() == null)
    {
      AppMethodBeat.o(280324);
      return;
    }
    String str1 = parama.scriptName;
    String str2 = parama.cyv;
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(280324);
      return;
    }
    if (!paramBoolean) {
      Log.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), str1, this.oxe, Integer.valueOf(hashCode()) });
    }
    while (org.apache.commons.b.a.contains(cyt, str1))
    {
      AppMethodBeat.o(280324);
      return;
      Log.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), str1, this.oxe, Integer.valueOf(hashCode()) });
    }
    if (((t)super.QM() != null) && (!org.apache.commons.b.a.contains(cyu, str1)) && (((ab)((ah)QK()).au(ab.class)).cdQ()))
    {
      if (paramBoolean) {
        a(parama.scriptName, new d.a[] { parama }, new boolean[] { paramBoolean }, new Object[] { paramObject }, paramLong1, paramLong2);
      }
      AppMethodBeat.o(280324);
      return;
    }
    int i = -1;
    switch (str1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        if (!str1.endsWith("page-frame.js")) {
          break label725;
        }
        a(str1.substring(0, str1.length() - 13), str1, str2, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(280324);
        return;
        if (str1.equals("WAWebview.js"))
        {
          i = 0;
          continue;
          if (str1.equals("WAVConsole.js"))
          {
            i = 1;
            continue;
            if (str1.equals("app-wxss.js"))
            {
              i = 2;
              continue;
              if (str1.equals("page-frame.html")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 1L, 1L, false);
    if ((t)super.QM() != null)
    {
      if (!paramBoolean) {
        break label543;
      }
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, str1, paramLong1, paramLong2);
    }
    while (paramBoolean)
    {
      if ((cfg()) || (isRunning())) {
        a(str1, str2, paramLong1, paramLong2);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(280324);
      return;
      label543:
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", str1, paramLong1, paramLong2);
    }
    Log.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 2L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.j.cE(getAppId(), 24);
    int j = 0;
    parama = ((ah)QK()).getRuntime();
    if (parama != null) {
      j = parama.bDx().nYR.pkgVersion;
    }
    for (i = parama.bDx().nYR.nHY;; i = -1)
    {
      com.tencent.mm.plugin.appbrand.report.j.b(getAppId(), j, i, 370, 2);
      AppMethodBeat.o(280324);
      return;
      if ((cfg()) || (isRunning()))
      {
        a(str1, str2, paramLong1, paramLong2);
        AppMethodBeat.o(280324);
        return;
        a("__APP__", str1, str2, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(280324);
        return;
        label725:
        if (str1.equals(this.oxe))
        {
          if (!isRunning())
          {
            AppMethodBeat.o(280324);
            return;
          }
          paramObject = com.tencent.mm.plugin.appbrand.report.quality.b.amO(getAppId());
          if (paramObject != null)
          {
            parama = new pk();
            parama.gfn = parama.z("InstanceId", paramObject.cBH, true);
            parama.gmF = parama.z("AppId", getAppId(), true);
            parama.gYL = paramObject.qNx;
            parama.hfj = pk.a.oI(paramObject.qLQ);
            parama.gYN = paramObject.apptype;
            parama.Cn(paramLong2 - paramLong1);
            parama.gnP = paramObject.scene;
            parama.Co(paramLong1);
            parama.Cp(paramLong2);
            parama.heu = str2.length();
            parama.hee = parama.z("path", com.tencent.mm.compatible.util.q.aT(str1), true);
          }
        }
      }
      try
      {
        paramObject = ((ah)QK()).qsG;
        paramObject = ((ah)QK()).getRuntime().bDz().l(paramObject);
        if (paramObject != null) {
          parama.hfk = parama.z("referrer", paramObject.getCurrentPageView().oxe, true);
        }
      }
      catch (NullPointerException paramObject)
      {
        label954:
        break label954;
      }
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      parama.hew = com.tencent.mm.plugin.appbrand.report.quality.c.x((ah)QK());
      if ((str2.startsWith("//XWEB_SCRIPT:")) && (this.qtd.contains(str1))) {}
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        parama.hex = paramLong1;
        paramObject = new StringBuilder();
        com.tencent.mm.plugin.appbrand.report.quality.b.cik();
        parama.hdA = parama.z("engineVersion", com.tencent.mm.plugin.appbrand.report.quality.c.cil(), true);
        parama.bpa();
        AppMethodBeat.o(280324);
        return;
      }
    }
  }
  
  public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(280329);
    paramArrayOfObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramArrayOfObject = paramString;
      if (BuildInfo.DEBUG) {
        paramArrayOfObject = UUID.randomUUID().toString();
      }
    }
    if ((TextUtils.isEmpty(paramArrayOfObject)) || (paramArrayOfa.length == 0) || (paramArrayOfBoolean.length == 0))
    {
      AppMethodBeat.o(280329);
      return;
    }
    int k = 1;
    int m = paramArrayOfa.length;
    int i = 0;
    for (;;)
    {
      j = k;
      if (i < m)
      {
        if (paramArrayOfa[i] != null) {
          j = 0;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        AppMethodBeat.o(280329);
        return;
      }
      i += 1;
    }
    long l1 = 0L;
    int j = paramArrayOfa.length;
    i = 0;
    while (i < j)
    {
      paramString = paramArrayOfa[i];
      long l2 = l1;
      if (paramString != null) {
        l2 = l1 + paramString.cyw;
      }
      i += 1;
      l1 = l2;
    }
    paramArrayOfa = com.tencent.mm.plugin.appbrand.report.quality.b.amO(getAppId());
    if (paramArrayOfa != null)
    {
      paramString = new pl();
      paramString.Gv(paramArrayOfa.cBH);
      paramString.Gw(getAppId());
      paramString.gYL = paramArrayOfa.qNx;
      paramString.hfp = pl.a.oJ(paramArrayOfa.qLQ);
      paramString.gYN = paramArrayOfa.apptype;
      paramString.Cq(paramLong2 - paramLong1);
      paramString.gnP = paramArrayOfa.scene;
      paramString.Cr(paramLong1);
      paramString.Cs(paramLong2);
      paramString.heu = l1;
      paramString.hex = 0L;
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      paramString.hew = com.tencent.mm.plugin.appbrand.report.quality.c.x((ah)QK());
      paramArrayOfa = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      paramString.Gy(com.tencent.mm.plugin.appbrand.report.quality.c.cil());
      paramString.Gz(paramArrayOfObject);
      paramString.bpa();
    }
    AppMethodBeat.o(280329);
  }
  
  public final void alo(String paramString)
  {
    AppMethodBeat.i(47856);
    super.alo(paramString);
    com.tencent.mm.plugin.appbrand.report.j.cE(getAppId(), 27);
    AppMethodBeat.o(47856);
  }
  
  public final boolean b(String paramString, ca paramca)
  {
    AppMethodBeat.i(280321);
    this.qtc = System.currentTimeMillis();
    ((bs)this.qoF).aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271193);
        ag.a(ag.this, Util.currentTicks());
        AppMethodBeat.o(271193);
      }
    });
    for (;;)
    {
      try
      {
        super.QM();
        bool = t.nwr;
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        Object localObject1;
        continue;
        Object localObject2 = null;
        continue;
      }
      if (QK() == null) {
        continue;
      }
      localObject1 = ((ah)QK()).getRuntime();
      if ((localObject1 != null) && (((t)localObject1).bDy().nBE.nnk))
      {
        localObject1 = cez();
        if ((localObject1 != null) && (((an)localObject1).getSettings() != null))
        {
          ((an)localObject1).getSettings().setForceDarkMode(0);
          Log.i("MicroMsg.AppBrandPageViewRendererWC", "[applyDarkModeConfig] set FORCE_DARK_OFF reason[ half screen force-light-mode]");
        }
      }
      ((bs)this.qoF).aD(((ah)QK()).getContext());
      bool = super.b(paramString, paramca);
      com.tencent.mm.plugin.appbrand.h.a((ah)QK());
      AppMethodBeat.o(280321);
      return bool;
      localObject1 = (AccessibilityManager)androidx.core.content.a.a(getContext(), AccessibilityManager.class);
      if ((localObject1 != null) && (!((AccessibilityManager)localObject1).isTouchExplorationEnabled())) {
        ((ah)QK()).getContentView().setContentDescription(l.eo(paramString));
      }
    }
  }
  
  public final ICommLibReader bBP()
  {
    AppMethodBeat.i(47845);
    ICommLibReader localICommLibReader = ((ah)QK()).bBP();
    AppMethodBeat.o(47845);
    return localICommLibReader;
  }
  
  protected final boolean cdh()
  {
    AppMethodBeat.i(47848);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.bd.s(((ah)QK()).getRuntime()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (((ah)QK()).getRuntime().bDy().nBE.isEnable())
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (((ah)QK()).getRuntime().So())
    {
      AppMethodBeat.o(47848);
      return false;
    }
    boolean bool = super.cdh();
    AppMethodBeat.o(47848);
    return bool;
  }
  
  protected final com.tencent.mm.plugin.appbrand.performance.g cdi()
  {
    AppMethodBeat.i(175035);
    i locali = new i((ah)QK());
    AppMethodBeat.o(175035);
    return locali;
  }
  
  protected bg cdk()
  {
    AppMethodBeat.i(47853);
    Objects.requireNonNull(cez());
    if ((cez().supportFeature(2002)) && (cez().supportFeature(2004)))
    {
      com.tencent.mm.plugin.appbrand.xweb_ext.e.cqQ();
      localObject = new ag.6(this, this);
      AppMethodBeat.o(47853);
      return localObject;
    }
    Object localObject = super.cdk();
    AppMethodBeat.o(47853);
    return localObject;
  }
  
  public final an cez()
  {
    if ((this.qoF instanceof an)) {
      return (an)this.qoF;
    }
    if ((this.qoF instanceof av))
    {
      bd localbd = ((av)this.qoF).quO;
      if ((localbd instanceof an)) {
        return (an)localbd;
      }
    }
    return null;
  }
  
  public final void ct(View paramView)
  {
    AppMethodBeat.i(47849);
    super.ct(paramView);
    if (((bs)this.qoF instanceof av)) {}
    for (paramView = ((av)this.qoF).quO;; paramView = (bs)this.qoF)
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((ah)QK()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void PS()
        {
          AppMethodBeat.i(47838);
          com.tencent.mm.plugin.ball.f.f.d(false, true, false);
          AppMethodBeat.o(47838);
        }
        
        public final void bOO()
        {
          AppMethodBeat.i(47837);
          com.tencent.mm.plugin.ball.f.f.d(true, true, false);
          AppMethodBeat.o(47837);
        }
      });
      AppMethodBeat.o(47849);
      return;
    }
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47854);
    if (com.tencent.mm.plugin.appbrand.m.aa.f((ad)QK()))
    {
      Log.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
      com.tencent.mm.plugin.appbrand.m.aa.a(((ah)QK()).getJsRuntime(), ((ah)QK()).bDA().getComponentId(), ((ah)QK()).getComponentId(), getAppId());
    }
    super.dispatchStart();
    R(com.tencent.mm.plugin.appbrand.page.a.e.class);
    ((bs)this.qoF).aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(282351);
        ag.this.getRuntime().nwu.I(3, Util.ticksToNow(ag.c(ag.this)));
        com.tencent.mm.plugin.appbrand.performance.c.a(ag.this.getAppId(), "Native", "WebViewInit+PageFrameLoad", ag.c(ag.this), System.currentTimeMillis(), "");
        AppMethodBeat.o(282351);
      }
    });
    if (com.tencent.mm.plugin.appbrand.ag.g.ap(((ah)QK()).getRuntime())) {
      super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.mm.plugin.appbrand.ag.d((ad)QK()));
    }
    AppMethodBeat.o(47854);
  }
  
  public final be ei(Context paramContext)
  {
    AppMethodBeat.i(47852);
    this.qta = Util.currentTicks();
    paramContext = (an)com.tencent.luggage.sdk.h.d.a("onCreateRealWebView", new ag.4(this, paramContext), new kotlin.g.a.q() {});
    paramContext.setOverScrolledListener(this.qtg);
    AppMethodBeat.o(47852);
    return paramContext;
  }
  
  public final t getRuntime()
  {
    AppMethodBeat.i(293295);
    t localt = (t)super.QM();
    AppMethodBeat.o(293295);
    return localt;
  }
  
  protected final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(280322);
    if (QK() == null)
    {
      AppMethodBeat.o(280322);
      return;
    }
    if (isRunning())
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      com.tencent.mm.plugin.appbrand.report.quality.c.a((com.tencent.mm.plugin.appbrand.g)QK(), paramString, paramLong1, paramLong2, ceA(), 0L);
    }
    AppMethodBeat.o(280322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag
 * JD-Core Version:    0.7.0.1
 */