package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.luggage.l.m;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ta;
import com.tencent.mm.autogen.mmdata.rpt.td;
import com.tencent.mm.autogen.mmdata.rpt.td.a;
import com.tencent.mm.autogen.mmdata.rpt.te;
import com.tencent.mm.autogen.mmdata.rpt.te.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bj;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.w.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.n.aa;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.w;
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
import kotlin.g.a.q;

public class ag
  extends bp<ah>
  implements w.b
{
  private long txG;
  private long txH;
  private long txI;
  private final Set<String> txJ;
  final Set<at> txK;
  private ax txL;
  private final at txM;
  
  public ag(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(47844);
    this.txJ = new HashSet();
    this.txK = Collections.synchronizedSet(new HashSet());
    this.txL = null;
    this.txM = new ag.3(this);
    AppMethodBeat.o(47844);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    long l2 = 1L;
    AppMethodBeat.i(47859);
    ta localta = com.tencent.mm.plugin.appbrand.report.quality.b.cJb().k((com.tencent.mm.plugin.appbrand.g)aqX()).zt(paramString1);
    localta.jAh = paramString2.length();
    if ((paramString2.startsWith("//XWEB_SCRIPT:")) && (this.txJ.contains(paramString1)))
    {
      l1 = 1L;
      localta.jAk = l1;
      if (!cFd()) {
        break label137;
      }
    }
    label137:
    for (long l1 = l2;; l1 = 0L)
    {
      localta.jAl = l1;
      localta.fZ(paramLong1);
      localta.ga(paramLong2);
      localta.fY(localta.jyJ - localta.jyI);
      localta.bMH();
      AppMethodBeat.o(47859);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(325223);
    if (!isRunning())
    {
      AppMethodBeat.o(325223);
      return;
    }
    te localte;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, paramString2, paramLong1, paramLong2);
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(getAppId());
      if (localQualitySessionRuntime != null)
      {
        localte = new te();
        localte.zH(localQualitySessionRuntime.eup);
        localte.zI(getAppId());
        localte.ind = localQualitySessionRuntime.tSh;
        localte.jBe = te.a.oV(localQualitySessionRuntime.tQx);
        localte.jax = localQualitySessionRuntime.apptype;
        localte.gf(paramLong2 - paramLong1);
        localte.iqr = localQualitySessionRuntime.scene;
        localte.gg(paramLong1);
        localte.gh(paramLong2);
        localte.zJ(paramString1);
        localte.jAh = Util.nullAsNil(Integer.valueOf(paramString3.length()));
        if ((!paramString3.startsWith("//XWEB_SCRIPT:")) || (!this.txJ.contains(paramString2))) {
          break label290;
        }
      }
    }
    label290:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localte.jAk = paramLong1;
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      localte.jAj = com.tencent.mm.plugin.appbrand.report.quality.c.z((ah)aqX());
      paramString1 = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      localte.zK(com.tencent.mm.plugin.appbrand.report.quality.c.cJc());
      localte.bMH();
      AppMethodBeat.o(325223);
      return;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", paramString2, paramLong1, paramLong2);
      break;
    }
  }
  
  private boolean cFd()
  {
    AppMethodBeat.i(47858);
    com.tencent.mm.plugin.appbrand.service.c localc = ((ah)aqX()).ccO();
    if (localc == null)
    {
      AppMethodBeat.o(47858);
      return false;
    }
    boolean bool2 = localc.esM.apj();
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (!com.tencent.mm.plugin.appbrand.at.cdw()) {
        ((ah)aqX()).cbl().cfG();
      }
      bool1 = true;
    }
    AppMethodBeat.o(47858);
    return bool1;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(325355);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (aqX() == null)
    {
      AppMethodBeat.o(325355);
      return;
    }
    String str1 = parama.scriptName;
    String str2 = parama.eqP;
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(325355);
      return;
    }
    if (!paramBoolean) {
      Log.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), str1, this.rAF, Integer.valueOf(hashCode()) });
    }
    while (org.apache.commons.c.a.contains(eqN, str1))
    {
      AppMethodBeat.o(325355);
      return;
      Log.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), str1, this.rAF, Integer.valueOf(hashCode()) });
    }
    if (((w)super.aqZ() != null) && (!org.apache.commons.c.a.contains(eqO, str1)) && (((ab)((ah)aqX()).aN(ab.class)).cEw()))
    {
      if (paramBoolean) {
        a(parama.scriptName, new d.a[] { parama }, new boolean[] { paramBoolean }, new Object[] { paramObject }, paramLong1, paramLong2);
      }
      AppMethodBeat.o(325355);
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
        AppMethodBeat.o(325355);
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
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(370L, 1L, 1L, false);
    if ((w)super.aqZ() != null)
    {
      if (!paramBoolean) {
        break label543;
      }
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, str1, paramLong1, paramLong2);
    }
    while (paramBoolean)
    {
      if ((atb()) || (isRunning())) {
        a(str1, str2, paramLong1, paramLong2);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(325355);
      return;
      label543:
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", str1, paramLong1, paramLong2);
    }
    Log.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(370L, 2L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.j.de(getAppId(), 24);
    int j = 0;
    parama = ((ah)aqX()).getRuntime();
    if (parama != null) {
      j = parama.ccM().qYY.pkgVersion;
    }
    for (i = parama.ccM().qYY.qHO;; i = -1)
    {
      com.tencent.mm.plugin.appbrand.report.j.b(getAppId(), j, i, 370, 2);
      AppMethodBeat.o(325355);
      return;
      if ((atb()) || (isRunning()))
      {
        a(str1, str2, paramLong1, paramLong2);
        AppMethodBeat.o(325355);
        return;
        a("__APP__", str1, str2, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(325355);
        return;
        label725:
        if (str1.equals(this.rAF))
        {
          if (!isRunning())
          {
            AppMethodBeat.o(325355);
            return;
          }
          paramObject = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(getAppId());
          if (paramObject != null)
          {
            parama = new td();
            parama.ilM = parama.F("InstanceId", paramObject.eup, true);
            parama.imT = parama.F("AppId", getAppId(), true);
            parama.ind = paramObject.tSh;
            parama.jAY = td.a.oU(paramObject.tQx);
            parama.jax = paramObject.apptype;
            parama.gc(paramLong2 - paramLong1);
            parama.iqr = paramObject.scene;
            parama.gd(paramLong1);
            parama.ge(paramLong2);
            parama.jAh = str2.length();
            parama.jzR = parama.F("path", com.tencent.mm.compatible.util.r.cg(str1), true);
          }
        }
      }
      try
      {
        paramObject = ((ah)aqX()).txk;
        paramObject = ((ah)aqX()).getRuntime().ccN().l(paramObject);
        if (paramObject != null) {
          parama.jAZ = parama.F("referrer", paramObject.getCurrentPageView().cgR(), true);
        }
      }
      catch (NullPointerException paramObject)
      {
        label954:
        break label954;
      }
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      parama.jAj = com.tencent.mm.plugin.appbrand.report.quality.c.z((ah)aqX());
      if ((str2.startsWith("//XWEB_SCRIPT:")) && (this.txJ.contains(str1))) {}
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        parama.jAk = paramLong1;
        paramObject = new StringBuilder();
        com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
        parama.jzn = parama.F("engineVersion", com.tencent.mm.plugin.appbrand.report.quality.c.cJc(), true);
        parama.bMH();
        AppMethodBeat.o(325355);
        return;
      }
    }
  }
  
  public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(325359);
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
      AppMethodBeat.o(325359);
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
        AppMethodBeat.o(325359);
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
        l2 = l1 + paramString.eqQ;
      }
      i += 1;
      l1 = l2;
    }
    paramArrayOfa = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(getAppId());
    if (paramArrayOfa != null)
    {
      paramString = new te();
      paramString.zH(paramArrayOfa.eup);
      paramString.zI(getAppId());
      paramString.ind = paramArrayOfa.tSh;
      paramString.jBe = te.a.oV(paramArrayOfa.tQx);
      paramString.jax = paramArrayOfa.apptype;
      paramString.gf(paramLong2 - paramLong1);
      paramString.iqr = paramArrayOfa.scene;
      paramString.gg(paramLong1);
      paramString.gh(paramLong2);
      paramString.jAh = l1;
      paramString.jAk = 0L;
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      paramString.jAj = com.tencent.mm.plugin.appbrand.report.quality.c.z((ah)aqX());
      paramArrayOfa = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      paramString.zK(com.tencent.mm.plugin.appbrand.report.quality.c.cJc());
      paramString.zL(paramArrayOfObject);
      paramString.bMH();
    }
    AppMethodBeat.o(325359);
  }
  
  public final <T> T aa(Class<T> paramClass)
  {
    AppMethodBeat.i(47847);
    if (com.tencent.mm.plugin.appbrand.page.a.e.class == paramClass)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.e)super.aa(com.tencent.mm.plugin.appbrand.page.a.e.class);
      if (localObject == null)
      {
        AppMethodBeat.o(47847);
        return null;
      }
      if (this.txL == null) {
        this.txL = new ax((com.tencent.mm.plugin.appbrand.page.a.e)localObject);
      }
      localObject = ((ah)Objects.requireNonNull((ah)aqX())).cFg();
      this.txL.d((g.c)localObject);
      paramClass = paramClass.cast(this.txL);
      AppMethodBeat.o(47847);
      return paramClass;
    }
    paramClass = super.aa(paramClass);
    AppMethodBeat.o(47847);
    return paramClass;
  }
  
  public final void aev(String paramString)
  {
    AppMethodBeat.i(47856);
    super.aev(paramString);
    com.tencent.mm.plugin.appbrand.report.j.de(getAppId(), 27);
    AppMethodBeat.o(47856);
  }
  
  public final void aqe()
  {
    AppMethodBeat.i(325307);
    super.aqe();
    HalfScreenConfig localHalfScreenConfig = ((w)super.aqZ()).getInitConfig().qAT;
    if (localHalfScreenConfig.isEnable())
    {
      Object localObject = this.tti;
      if (localHalfScreenConfig.qkq) {
        ((bd)localObject).setBackgroundColor(-1);
      }
      localObject = cFc();
      if (((localObject instanceof j)) && (localHalfScreenConfig.qZO))
      {
        ((j)localObject).setFixSizeEnable(true);
        AppMethodBeat.o(325307);
        return;
      }
      ((j)localObject).setFixSizeEnable(false);
    }
    AppMethodBeat.o(325307);
  }
  
  public Map<String, p> aqh()
  {
    AppMethodBeat.i(47851);
    Map localMap = (Map)com.tencent.luggage.sdk.h.d.b("AppBrandPageViewRendererWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(47851);
    return localMap;
  }
  
  public final void aqi()
  {
    AppMethodBeat.i(47857);
    super.aqi();
    ((w)super.aqZ()).qvz.L(4, Util.ticksToNow(this.txH));
    AppBrandPerformanceManager.a((w)super.aqZ(), 203, System.currentTimeMillis() - this.txI);
    com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.txI, System.currentTimeMillis(), "");
    AppMethodBeat.o(47857);
  }
  
  public final int asw()
  {
    AppMethodBeat.i(47846);
    int i = ((w)super.aqZ()).getInitConfig().appVersion;
    AppMethodBeat.o(47846);
    return i;
  }
  
  public final boolean b(String paramString, cb paramcb)
  {
    AppMethodBeat.i(325315);
    this.txI = System.currentTimeMillis();
    ((bs)this.tti).n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(324928);
        ag.a(ag.this, Util.currentTicks());
        AppMethodBeat.o(324928);
      }
    });
    for (;;)
    {
      try
      {
        super.aqZ();
        bool = w.qvw;
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
      if (aqX() == null) {
        continue;
      }
      localObject1 = ((ah)aqX()).getRuntime();
      if ((localObject1 != null) && (((w)localObject1).getInitConfig().qAT.qkq))
      {
        localObject1 = cFc();
        if ((localObject1 != null) && (((an)localObject1).getSettings() != null))
        {
          ((an)localObject1).getSettings().setForceDarkMode(0);
          Log.i("MicroMsg.AppBrandPageViewRendererWC", "[applyDarkModeConfig] set FORCE_DARK_OFF reason[ half screen force-light-mode]");
        }
      }
      ((bs)this.tti).bm(((ah)aqX()).getContext());
      bool = super.b(paramString, paramcb);
      com.tencent.mm.plugin.appbrand.h.a((ah)aqX());
      AppMethodBeat.o(325315);
      return bool;
      localObject1 = (AccessibilityManager)androidx.core.content.a.a(getContext(), AccessibilityManager.class);
      if ((localObject1 != null) && (!((AccessibilityManager)localObject1).isTouchExplorationEnabled())) {
        ((ah)aqX()).getContentView().setContentDescription(m.fL(paramString));
      }
    }
  }
  
  protected final com.tencent.mm.plugin.appbrand.performance.g cDE()
  {
    AppMethodBeat.i(175035);
    i locali = new i((ah)aqX());
    AppMethodBeat.o(175035);
    return locali;
  }
  
  protected bg cDI()
  {
    AppMethodBeat.i(47853);
    Objects.requireNonNull(cFc());
    if ((cFc().supportFeature(2002)) && (cFc().supportFeature(2004)) && (com.tencent.mm.plugin.appbrand.xweb_ext.e.cTx()))
    {
      localObject = new ag.6(this, this);
      AppMethodBeat.o(47853);
      return localObject;
    }
    Object localObject = super.cDI();
    AppMethodBeat.o(47853);
    return localObject;
  }
  
  protected final String cDJ()
  {
    AppMethodBeat.i(325364);
    if (com.tencent.mm.plugin.appbrand.k.a.a.I((w)super.aqZ()))
    {
      AppMethodBeat.o(325364);
      return "portrait";
    }
    String str = super.cDJ();
    AppMethodBeat.o(325364);
    return str;
  }
  
  public final an cFc()
  {
    if ((this.tti instanceof an)) {
      return (an)this.tti;
    }
    if ((this.tti instanceof av))
    {
      bd localbd = ((av)this.tti).tzF;
      if ((localbd instanceof an)) {
        return (an)localbd;
      }
    }
    return null;
  }
  
  protected final boolean d(cb paramcb)
  {
    AppMethodBeat.i(325261);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(325261);
      return false;
    }
    if (bj.x(((ah)aqX()).getRuntime()))
    {
      AppMethodBeat.o(325261);
      return false;
    }
    if (((ah)aqX()).getRuntime().getInitConfig().qAT.isEnable())
    {
      AppMethodBeat.o(325261);
      return false;
    }
    if (((ah)aqX()).getRuntime().asE())
    {
      AppMethodBeat.o(325261);
      return false;
    }
    if (((ah)aqX()).getRuntime().ccB())
    {
      AppMethodBeat.o(325261);
      return false;
    }
    boolean bool = super.d(paramcb);
    AppMethodBeat.o(325261);
    return bool;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47854);
    if (aa.f((ad)aqX()))
    {
      Log.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
      aa.a(((ah)aqX()).getJsRuntime(), ((ah)aqX()).ccO().getComponentId(), ((ah)aqX()).getComponentId(), getAppId());
    }
    super.dispatchStart();
    aa(com.tencent.mm.plugin.appbrand.page.a.e.class);
    ((bs)this.tti).n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(324921);
        ag.this.getRuntime().qvz.L(3, Util.ticksToNow(ag.c(ag.this)));
        com.tencent.mm.plugin.appbrand.performance.c.a(ag.this.getAppId(), "Native", "WebViewInit+PageFrameLoad", ag.c(ag.this), System.currentTimeMillis(), "");
        AppMethodBeat.o(324921);
      }
    });
    if (com.tencent.mm.plugin.appbrand.weishi.h.aD(((ah)aqX()).getRuntime())) {
      super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.mm.plugin.appbrand.weishi.d((ad)aqX()));
    }
    AppMethodBeat.o(47854);
  }
  
  public final be fd(Context paramContext)
  {
    AppMethodBeat.i(47852);
    this.txG = Util.currentTicks();
    paramContext = (an)com.tencent.luggage.sdk.h.d.a("onCreateRealWebView", new ag.4(this, paramContext), new q() {});
    paramContext.setOverScrolledListener(this.txM);
    AppMethodBeat.o(47852);
    return paramContext;
  }
  
  public final w getRuntime()
  {
    AppMethodBeat.i(370023);
    w localw = (w)super.aqZ();
    AppMethodBeat.o(370023);
    return localw;
  }
  
  public final void onViewCreated(View paramView)
  {
    AppMethodBeat.i(47849);
    super.onViewCreated(paramView);
    if (((bs)this.tti instanceof av)) {}
    for (paramView = ((av)this.tti).tzF;; paramView = (bs)this.tti)
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((ah)aqX()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void aqb()
        {
          AppMethodBeat.i(47838);
          com.tencent.mm.plugin.ball.f.f.d(false, true, false);
          AppMethodBeat.o(47838);
        }
        
        public final void cpc()
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
  
  protected final void s(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(325335);
    if (aqX() == null)
    {
      AppMethodBeat.o(325335);
      return;
    }
    if (isRunning())
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      com.tencent.mm.plugin.appbrand.report.quality.c.a((com.tencent.mm.plugin.appbrand.g)aqX(), paramString, paramLong1, paramLong2, cFd(), 0L);
    }
    AppMethodBeat.o(325335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag
 * JD-Core Version:    0.7.0.1
 */