package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.g.b.a.ml;
import com.tencent.mm.g.b.a.ml.a;
import com.tencent.mm.g.b.a.mm;
import com.tencent.mm.g.b.a.mm.a;
import com.tencent.mm.plugin.appbrand.an;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.w.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class af
  extends bn<ag>
  implements w.b
{
  private long nrk;
  private long nrl;
  private long nrm;
  private final Set<String> nrn;
  private av nro;
  
  public af(ag paramag)
  {
    super(paramag);
    AppMethodBeat.i(47844);
    this.nrn = new HashSet();
    this.nro = null;
    AppMethodBeat.o(47844);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    long l2 = 1L;
    AppMethodBeat.i(47859);
    mj localmj = com.tencent.mm.plugin.appbrand.report.quality.b.bUZ().l((com.tencent.mm.plugin.appbrand.d)NN()).zy(paramString1);
    localmj.fbD = paramString2.length();
    if ((paramString2.startsWith("//XWEB_SCRIPT:")) && (this.nrn.contains(paramString1)))
    {
      l1 = 1L;
      localmj.fbG = l1;
      if (!bRJ()) {
        break label137;
      }
    }
    label137:
    for (long l1 = l2;; l1 = 0L)
    {
      localmj.fbH = l1;
      localmj.vX(paramLong1);
      localmj.vY(paramLong2);
      localmj.vW(localmj.fae - localmj.fad);
      localmj.bfK();
      AppMethodBeat.o(47859);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227287);
    if (!isRunning())
    {
      AppMethodBeat.o(227287);
      return;
    }
    mm localmm;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, paramString2, paramLong1, paramLong2);
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
      if (localQualitySessionRuntime != null)
      {
        localmm = new mm();
        localmm.zK(localQualitySessionRuntime.kEY);
        localmm.zL(getAppId());
        localmm.eXc = localQualitySessionRuntime.nLk;
        localmm.fcv = mm.a.my(localQualitySessionRuntime.nJE);
        localmm.eYW = localQualitySessionRuntime.apptype;
        localmm.wq(paramLong2 - paramLong1);
        localmm.erW = localQualitySessionRuntime.scene;
        localmm.wr(paramLong1);
        localmm.ws(paramLong2);
        localmm.zM(paramString1);
        localmm.fbD = Util.nullAsNil(Integer.valueOf(paramString3.length()));
        if ((!paramString3.startsWith("//XWEB_SCRIPT:")) || (!this.nrn.contains(paramString2))) {
          break label290;
        }
      }
    }
    label290:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localmm.fbG = paramLong1;
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      localmm.fbF = com.tencent.mm.plugin.appbrand.report.quality.c.z((ag)NN());
      paramString1 = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      localmm.zN(com.tencent.mm.plugin.appbrand.report.quality.c.bVa());
      localmm.bfK();
      AppMethodBeat.o(227287);
      return;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", paramString2, paramLong1, paramLong2);
      break;
    }
  }
  
  private boolean bRJ()
  {
    AppMethodBeat.i(47858);
    com.tencent.mm.plugin.appbrand.service.c localc = ((ag)NN()).bsE();
    if (localc == null)
    {
      AppMethodBeat.o(47858);
      return false;
    }
    boolean bool2 = localc.cBj.Mj();
    boolean bool1 = bool2;
    if (!bool2)
    {
      an.btp();
      bool1 = true;
    }
    AppMethodBeat.o(47858);
    return bool1;
  }
  
  public final Map<String, p> Nf()
  {
    AppMethodBeat.i(47851);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewRendererWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(47851);
    return localMap;
  }
  
  public final void Ng()
  {
    AppMethodBeat.i(47857);
    super.Ng();
    ((com.tencent.mm.plugin.appbrand.q)super.NP()).kDk.I(4, Util.ticksToNow(this.nrl));
    AppBrandPerformanceManager.a((com.tencent.mm.plugin.appbrand.q)super.NP(), 203, System.currentTimeMillis() - this.nrm);
    com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.nrm, System.currentTimeMillis(), "");
    AppMethodBeat.o(47857);
  }
  
  public final int OJ()
  {
    AppMethodBeat.i(47846);
    int i = ((com.tencent.mm.plugin.appbrand.q)super.NP()).bsC().appVersion;
    AppMethodBeat.o(47846);
    return i;
  }
  
  public final <T> T S(Class<T> paramClass)
  {
    AppMethodBeat.i(47847);
    if (com.tencent.mm.plugin.appbrand.page.a.e.class == paramClass)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.e)super.S(com.tencent.mm.plugin.appbrand.page.a.e.class);
      if (localObject == null)
      {
        AppMethodBeat.o(47847);
        return null;
      }
      if (this.nro == null) {
        this.nro = new av((com.tencent.mm.plugin.appbrand.page.a.e)localObject);
      }
      localObject = ((ag)NN()).bRM();
      this.nro.m((com.tencent.mm.plugin.appbrand.jsapi.af.a)localObject);
      paramClass = paramClass.cast(this.nro);
      AppMethodBeat.o(47847);
      return paramClass;
    }
    paramClass = super.S(paramClass);
    AppMethodBeat.o(47847);
    return paramClass;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(227286);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (NN() == null)
    {
      AppMethodBeat.o(227286);
      return;
    }
    String str1 = parama.scriptName;
    String str2 = parama.czz;
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(227286);
      return;
    }
    if (!paramBoolean) {
      Log.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), str1, this.lBI, Integer.valueOf(hashCode()) });
    }
    while (org.apache.commons.b.a.contains(czx, str1))
    {
      AppMethodBeat.o(227286);
      return;
      Log.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), str1, this.lBI, Integer.valueOf(hashCode()) });
    }
    if (((com.tencent.mm.plugin.appbrand.q)super.NP() != null) && (!org.apache.commons.b.a.contains(czy, str1)) && (((aa)((ag)NN()).av(aa.class)).bRa()))
    {
      if (paramBoolean) {
        a(parama.scriptName, new d.a[] { parama }, new boolean[] { paramBoolean }, new Object[] { paramObject }, paramLong1, paramLong2);
      }
      AppMethodBeat.o(227286);
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
        AppMethodBeat.o(227286);
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(370L, 1L, 1L, false);
    if ((com.tencent.mm.plugin.appbrand.q)super.NP() != null)
    {
      if (!paramBoolean) {
        break label543;
      }
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, str1, paramLong1, paramLong2);
    }
    while (paramBoolean)
    {
      if ((bSg()) || (isRunning())) {
        a(str1, str2, paramLong1, paramLong2);
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(227286);
      return;
      label543:
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", str1, paramLong1, paramLong2);
    }
    Log.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(370L, 2L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.i.cf(getAppId(), 24);
    int j = 0;
    parama = ((ag)NN()).getRuntime();
    if (parama != null) {
      j = parama.bsB().leE.pkgVersion;
    }
    for (i = parama.bsB().leE.kNW;; i = -1)
    {
      com.tencent.mm.plugin.appbrand.report.i.b(getAppId(), j, i, 370, 2);
      AppMethodBeat.o(227286);
      return;
      if ((bSg()) || (isRunning()))
      {
        a(str1, str2, paramLong1, paramLong2);
        AppMethodBeat.o(227286);
        return;
        a("__APP__", str1, str2, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(227286);
        return;
        label725:
        if (str1.equals(this.lBI))
        {
          if (!isRunning())
          {
            AppMethodBeat.o(227286);
            return;
          }
          paramObject = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
          if (paramObject != null)
          {
            parama = new ml();
            parama.eWb = parama.x("InstanceId", paramObject.kEY, true);
            parama.eJx = parama.x("AppId", getAppId(), true);
            parama.eXc = paramObject.nLk;
            parama.fcp = ml.a.mx(paramObject.nJE);
            parama.eYW = paramObject.apptype;
            parama.wn(paramLong2 - paramLong1);
            parama.erW = paramObject.scene;
            parama.wo(paramLong1);
            parama.wp(paramLong2);
            parama.fbD = str2.length();
            parama.fbm = parama.x("path", com.tencent.mm.compatible.util.q.encode(str1), true);
          }
        }
      }
      try
      {
        paramObject = ((ag)NN()).nqU;
        paramObject = ((ag)NN()).getRuntime().bsD().k(paramObject);
        if (paramObject != null) {
          parama.fcq = parama.x("referrer", paramObject.getCurrentPageView().lBI, true);
        }
      }
      catch (NullPointerException paramObject)
      {
        label954:
        break label954;
      }
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      parama.fbF = com.tencent.mm.plugin.appbrand.report.quality.c.z((ag)NN());
      if ((str2.startsWith("//XWEB_SCRIPT:")) && (this.nrn.contains(str1))) {}
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        parama.fbG = paramLong1;
        paramObject = new StringBuilder();
        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
        parama.faI = parama.x("engineVersion", com.tencent.mm.plugin.appbrand.report.quality.c.bVa(), true);
        parama.bfK();
        AppMethodBeat.o(227286);
        return;
      }
    }
  }
  
  public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227288);
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
      AppMethodBeat.o(227288);
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
        AppMethodBeat.o(227288);
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
        l2 = l1 + paramString.czA;
      }
      i += 1;
      l1 = l2;
    }
    paramArrayOfa = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
    if (paramArrayOfa != null)
    {
      paramString = new mm();
      paramString.zK(paramArrayOfa.kEY);
      paramString.zL(getAppId());
      paramString.eXc = paramArrayOfa.nLk;
      paramString.fcv = mm.a.my(paramArrayOfa.nJE);
      paramString.eYW = paramArrayOfa.apptype;
      paramString.wq(paramLong2 - paramLong1);
      paramString.erW = paramArrayOfa.scene;
      paramString.wr(paramLong1);
      paramString.ws(paramLong2);
      paramString.fbD = l1;
      paramString.fbG = 0L;
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      paramString.fbF = com.tencent.mm.plugin.appbrand.report.quality.c.z((ag)NN());
      paramArrayOfa = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      paramString.zN(com.tencent.mm.plugin.appbrand.report.quality.c.bVa());
      paramString.zO(paramArrayOfObject);
      paramString.bfK();
    }
    AppMethodBeat.o(227288);
  }
  
  public final void adt(String paramString)
  {
    AppMethodBeat.i(47856);
    super.adt(paramString);
    com.tencent.mm.plugin.appbrand.report.i.cf(getAppId(), 27);
    AppMethodBeat.o(47856);
  }
  
  protected final boolean bQr()
  {
    AppMethodBeat.i(47848);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.bb.r(((ag)NN()).getRuntime()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (((ag)NN()).getRuntime().bsC().kHL.isEnable())
    {
      AppMethodBeat.o(47848);
      return false;
    }
    if (((ag)NN()).getRuntime().OS())
    {
      AppMethodBeat.o(47848);
      return false;
    }
    boolean bool = super.bQr();
    AppMethodBeat.o(47848);
    return bool;
  }
  
  protected final com.tencent.mm.plugin.appbrand.performance.g bQs()
  {
    AppMethodBeat.i(175035);
    com.tencent.mm.plugin.appbrand.performance.i locali = new com.tencent.mm.plugin.appbrand.performance.i((ag)NN());
    AppMethodBeat.o(175035);
    return locali;
  }
  
  protected be bQu()
  {
    AppMethodBeat.i(47853);
    if ((bRI().supportFeature(2002)) && (bRI().supportFeature(2004)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXE, true)))
    {
      localObject = new bj(this)
      {
        public final void adR(String paramAnonymousString)
        {
          AppMethodBeat.i(227282);
          af.a(af.this).add(paramAnonymousString);
          AppMethodBeat.o(227282);
        }
      };
      AppMethodBeat.o(47853);
      return localObject;
    }
    Object localObject = super.bQu();
    AppMethodBeat.o(47853);
    return localObject;
  }
  
  public final am bRI()
  {
    if ((this.nmX instanceof am)) {
      return (am)this.nmX;
    }
    if ((this.nmX instanceof at))
    {
      bb localbb = ((at)this.nmX).nsV;
      if ((localbb instanceof am)) {
        return (am)localbb;
      }
    }
    return null;
  }
  
  public final ICommLibReader bqZ()
  {
    AppMethodBeat.i(47845);
    ICommLibReader localICommLibReader = ((ag)NN()).bqZ();
    AppMethodBeat.o(47845);
    return localICommLibReader;
  }
  
  public final void cb(View paramView)
  {
    AppMethodBeat.i(47849);
    super.cb(paramView);
    if (((bq)this.nmX instanceof at)) {}
    for (paramView = ((at)this.nmX).nsV;; paramView = (bq)this.nmX)
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((ag)NN()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void Na()
        {
          AppMethodBeat.i(47838);
          com.tencent.mm.plugin.ball.f.f.e(false, true, false);
          AppMethodBeat.o(47838);
        }
        
        public final void bDq()
        {
          AppMethodBeat.i(47837);
          com.tencent.mm.plugin.ball.f.f.e(true, true, false);
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
    if (com.tencent.mm.plugin.appbrand.m.aa.f((ac)NN()))
    {
      Log.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
      com.tencent.mm.plugin.appbrand.m.aa.a(((ag)NN()).getJsRuntime(), ((ag)NN()).bsE().getComponentId(), ((ag)NN()).getComponentId(), getAppId());
    }
    super.dispatchStart();
    S(com.tencent.mm.plugin.appbrand.page.a.e.class);
    ((bq)this.nmX).ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47843);
        af.this.getRuntime().kDk.I(3, Util.ticksToNow(af.b(af.this)));
        com.tencent.mm.plugin.appbrand.performance.c.a(af.this.getAppId(), "Native", "WebViewInit+PageFrameLoad", af.b(af.this), System.currentTimeMillis(), "");
        AppMethodBeat.o(47843);
      }
    });
    if (com.tencent.mm.plugin.appbrand.af.g.an(((ag)NN()).getRuntime())) {
      super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.mm.plugin.appbrand.af.d((ac)NN()));
    }
    HalfScreenConfig localHalfScreenConfig = ((com.tencent.mm.plugin.appbrand.q)super.NP()).bsC().kHL;
    if ((localHalfScreenConfig.isEnable()) && (localHalfScreenConfig.kuZ)) {
      this.nmX.setBackgroundColor(-1);
    }
    AppMethodBeat.o(47854);
  }
  
  public final boolean dy(String paramString)
  {
    AppMethodBeat.i(47855);
    this.nrm = System.currentTimeMillis();
    ((bq)this.nmX).ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227283);
        af.a(af.this, Util.currentTicks());
        AppMethodBeat.o(227283);
      }
    });
    for (;;)
    {
      try
      {
        bool = com.tencent.mm.plugin.appbrand.q.kDg;
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
      ((bq)this.nmX).aG(((ag)NN()).getContext());
      bool = super.dy(paramString);
      com.tencent.mm.plugin.appbrand.e.a((ag)NN());
      AppMethodBeat.o(47855);
      return bool;
      localAccessibilityManager = (AccessibilityManager)android.support.v4.content.b.a(getContext(), AccessibilityManager.class);
      if ((localAccessibilityManager != null) && (!localAccessibilityManager.isTouchExplorationEnabled())) {
        ((ag)NN()).getContentView().setContentDescription(l.dM(paramString));
      }
    }
  }
  
  public final bc ej(final Context paramContext)
  {
    AppMethodBeat.i(47852);
    this.nrk = Util.currentTicks();
    paramContext = (bc)com.tencent.luggage.sdk.g.c.a("onCreateRealWebView", new kotlin.g.a.a()new kotlin.g.a.q {}, new kotlin.g.a.q() {});
    AppMethodBeat.o(47852);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.appbrand.q getRuntime()
  {
    AppMethodBeat.i(258363);
    com.tencent.mm.plugin.appbrand.q localq = (com.tencent.mm.plugin.appbrand.q)super.NP();
    AppMethodBeat.o(258363);
    return localq;
  }
  
  protected final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227285);
    if (NN() == null)
    {
      AppMethodBeat.o(227285);
      return;
    }
    if (isRunning())
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      com.tencent.mm.plugin.appbrand.report.quality.c.a((com.tencent.mm.plugin.appbrand.d)NN(), paramString, paramLong1, paramLong2, bRJ(), 0L);
    }
    AppMethodBeat.o(227285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */