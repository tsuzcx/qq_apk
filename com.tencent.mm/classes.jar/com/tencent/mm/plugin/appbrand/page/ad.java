package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.fr.a;
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.g.b.a.fs.a;
import com.tencent.mm.plugin.appbrand.ak;
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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class ad
  extends bp<ae>
{
  private long lbo;
  private long lbp;
  private long lbq;
  private final Set<String> lbr;
  private ay lbs;
  
  public ad(ae paramae)
  {
    super(paramae);
    AppMethodBeat.i(47844);
    this.lbr = new HashSet();
    this.lbs = null;
    AppMethodBeat.o(47844);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    long l2 = 1L;
    AppMethodBeat.i(47859);
    com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
    fp localfp = com.tencent.mm.plugin.appbrand.report.quality.b.g((com.tencent.mm.plugin.appbrand.d)Dj()).lp(paramString1);
    localfp.ecI = paramString2.length();
    if ((paramString2.startsWith("//XWEB_SCRIPT:")) && (this.lbr.contains(paramString1)))
    {
      l1 = 1L;
      localfp.ecL = l1;
      if (!bkb()) {
        break label138;
      }
    }
    label138:
    for (long l1 = l2;; l1 = 0L)
    {
      localfp.ecM = l1;
      localfp.iB(paramLong1);
      localfp.iC(paramLong2);
      localfp.iA(localfp.ebr - localfp.ebq);
      localfp.aBj();
      AppMethodBeat.o(47859);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(196059);
    if (!isRunning())
    {
      AppMethodBeat.o(196059);
      return;
    }
    fs localfs;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, paramString2, paramLong1, paramLong2);
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.ME(getAppId());
      if (localQualitySessionRuntime != null)
      {
        localfs = new fs();
        localfs.lw(localQualitySessionRuntime.kGa);
        localfs.lx(getAppId());
        localfs.dYT = localQualitySessionRuntime.lty;
        localfs.edu = fs.a.iZ(localQualitySessionRuntime.lrW);
        localfs.eai = localQualitySessionRuntime.apptype;
        localfs.iS(paramLong2 - paramLong1);
        localfs.dKe = localQualitySessionRuntime.scene;
        localfs.iT(paramLong1);
        localfs.iU(paramLong2);
        localfs.ly(paramString1);
        localfs.ecI = bt.l(Integer.valueOf(paramString3.length()));
        if ((!paramString3.startsWith("//XWEB_SCRIPT:")) || (!this.lbr.contains(paramString2))) {
          break label289;
        }
      }
    }
    label289:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localfs.ecL = paramLong1;
      com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
      localfs.ecK = com.tencent.mm.plugin.appbrand.report.quality.b.x((ae)Dj());
      paramString1 = new StringBuilder();
      com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
      localfs.lz(com.tencent.mm.plugin.appbrand.report.quality.b.bmN());
      localfs.aBj();
      AppMethodBeat.o(196059);
      return;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", paramString2, paramLong1, paramLong2);
      break;
    }
  }
  
  private boolean bkb()
  {
    AppMethodBeat.i(47858);
    com.tencent.mm.plugin.appbrand.service.c localc = ((ae)Dj()).aNe();
    if (localc == null)
    {
      AppMethodBeat.o(47858);
      return false;
    }
    boolean bool2 = localc.chI.BH();
    boolean bool1 = bool2;
    if (!bool2)
    {
      ak.aNM();
      bool1 = true;
    }
    AppMethodBeat.o(47858);
    return bool1;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> CD()
  {
    AppMethodBeat.i(47851);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewRendererWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(47851);
    return localMap;
  }
  
  public final void CE()
  {
    AppMethodBeat.i(47857);
    super.CE();
    ((o)super.Dl()).iGe.F(4, bt.aS(this.lbp));
    AppBrandPerformanceManager.a((o)super.Dl(), 203, System.currentTimeMillis() - this.lbq);
    com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.lbq, System.currentTimeMillis(), "");
    AppMethodBeat.o(47857);
  }
  
  public final int DV()
  {
    AppMethodBeat.i(47846);
    int i = ((o)super.Dl()).aNc().aAS;
    AppMethodBeat.o(47846);
    return i;
  }
  
  public final void Ln(String paramString)
  {
    AppMethodBeat.i(47856);
    super.Ln(paramString);
    com.tencent.mm.plugin.appbrand.report.h.bL(getAppId(), 27);
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
      if (this.lbs == null) {
        this.lbs = new ay((com.tencent.mm.plugin.appbrand.page.b.e)localObject);
      }
      localObject = ((ae)Dj()).bkd();
      this.lbs.k((com.tencent.mm.plugin.appbrand.jsapi.z.a)localObject);
      paramClass = paramClass.cast(this.lbs);
      AppMethodBeat.o(47847);
      return paramClass;
    }
    paramClass = super.Q(paramClass);
    AppMethodBeat.o(47847);
    return paramClass;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(196058);
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    paramObject = parama.scriptName;
    String str = parama.cgh;
    if (TextUtils.isEmpty(paramObject))
    {
      AppMethodBeat.o(196058);
      return;
    }
    label90:
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.jzm, Integer.valueOf(hashCode()) });
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
          break label601;
        }
        a(paramObject.substring(0, paramObject.length() - 13), paramObject, str, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(196058);
        return;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramObject, this.jzm, Integer.valueOf(hashCode()) });
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
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(370L, 1L, 1L, false);
    if ((o)super.Dl() != null)
    {
      if (!paramBoolean) {
        break label420;
      }
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, paramObject, paramLong1, paramLong2);
    }
    while (paramBoolean)
    {
      if ((bhG()) || (isRunning())) {
        a(paramObject, str, paramLong1, paramLong2);
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(196058);
      return;
      label420:
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", paramObject, paramLong1, paramLong2);
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(370L, 2L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.h.bL(getAppId(), 24);
    int j = -1;
    parama = ((ae)Dj()).getRuntime();
    if (parama != null)
    {
      i = parama.aNb().jdS.pkgVersion;
      j = parama.aNb().jdS.iOQ;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.h.b(getAppId(), i, j, 370, 2);
      AppMethodBeat.o(196058);
      return;
      label601:
      Object localObject;
      if ((bhG()) || (isRunning()))
      {
        a(paramObject, str, paramLong1, paramLong2);
        AppMethodBeat.o(196058);
        return;
        a("__APP__", paramObject, str, paramBoolean, paramLong1, paramLong2);
        AppMethodBeat.o(196058);
        return;
        if (paramObject.equals(this.jzm))
        {
          if (!isRunning())
          {
            AppMethodBeat.o(196058);
            return;
          }
          localObject = com.tencent.mm.plugin.appbrand.report.quality.a.ME(getAppId());
          if (localObject != null)
          {
            parama = new fr();
            parama.dYa = parama.t("InstanceId", ((QualitySessionRuntime)localObject).kGa, true);
            parama.eag = parama.t("AppId", getAppId(), true);
            parama.dYT = ((QualitySessionRuntime)localObject).lty;
            parama.edo = fr.a.iY(((QualitySessionRuntime)localObject).lrW);
            parama.eai = ((QualitySessionRuntime)localObject).apptype;
            parama.iP(paramLong2 - paramLong1);
            parama.dKe = ((QualitySessionRuntime)localObject).scene;
            parama.iQ(paramLong1);
            parama.iR(paramLong2);
            parama.ecI = str.length();
            parama.ecr = parama.t("path", paramObject, true);
          }
        }
      }
      try
      {
        localObject = ((ae)Dj()).lbd;
        localObject = ((ae)Dj()).getRuntime().aNd().j((q)localObject);
        if (localObject != null) {
          parama.edp = parama.t("referrer", ((q)localObject).getCurrentPageView().jzm, true);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        label827:
        break label827;
      }
      com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
      parama.ecK = com.tencent.mm.plugin.appbrand.report.quality.b.x((ae)Dj());
      if ((str.startsWith("//XWEB_SCRIPT:")) && (this.lbr.contains(paramObject))) {}
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        parama.ecL = paramLong1;
        paramObject = new StringBuilder();
        com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
        parama.ecO = parama.t("engineVersion", com.tencent.mm.plugin.appbrand.report.quality.b.bmN(), true);
        parama.aBj();
        AppMethodBeat.o(196058);
        return;
      }
      i = 0;
    }
  }
  
  public final ICommLibReader aLC()
  {
    AppMethodBeat.i(47845);
    ICommLibReader localICommLibReader = ((ae)Dj()).aLC();
    AppMethodBeat.o(47845);
    return localICommLibReader;
  }
  
  protected final bg bhH()
  {
    AppMethodBeat.i(47853);
    if ((bka().supportFeature(2002)) && (bka().supportFeature(2004)) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppc, true)))
    {
      localObject = new ad.5(this, this);
      AppMethodBeat.o(47853);
      return localObject;
    }
    Object localObject = super.bhH();
    AppMethodBeat.o(47853);
    return localObject;
  }
  
  protected final boolean biN()
  {
    AppMethodBeat.i(47848);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(47848);
      return false;
    }
    boolean bool = super.biN();
    AppMethodBeat.o(47848);
    return bool;
  }
  
  protected final com.tencent.mm.plugin.appbrand.performance.g biP()
  {
    AppMethodBeat.i(175035);
    i locali = new i((ae)Dj());
    AppMethodBeat.o(175035);
    return locali;
  }
  
  public final ap bka()
  {
    if ((this.kWU instanceof ap)) {
      return (ap)this.kWU;
    }
    if ((this.kWU instanceof aw))
    {
      bd localbd = ((aw)this.kWU).leN;
      if ((localbd instanceof ap)) {
        return (ap)localbd;
      }
    }
    return null;
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(47849);
    super.cm(paramView);
    if ((bkA() instanceof aw)) {}
    for (paramView = ((aw)bkA()).leN;; paramView = bkA())
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((ae)Dj()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.s.a.b()
      {
        public final void Cx()
        {
          AppMethodBeat.i(47838);
          f.d(false, true, false);
          AppMethodBeat.o(47838);
        }
        
        public final void aWR()
        {
          AppMethodBeat.i(47837);
          f.d(true, true, false);
          AppMethodBeat.o(47837);
        }
      });
      AppMethodBeat.o(47849);
      return;
    }
  }
  
  public final boolean cn(String paramString)
  {
    AppMethodBeat.i(47855);
    this.lbq = System.currentTimeMillis();
    bkA().aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196056);
        ad.a(ad.this, bt.GC());
        AppMethodBeat.o(196056);
      }
    });
    if (((o)super.Dl()).iGa) {
      ((ae)Dj()).jhz.setContentDescription(k.cA(paramString));
    }
    bkA().av(((ae)Dj()).getContext());
    boolean bool = super.cn(paramString);
    com.tencent.mm.plugin.appbrand.e.a((ae)Dj());
    AppMethodBeat.o(47855);
    return bool;
  }
  
  public final be dB(Context paramContext)
  {
    AppMethodBeat.i(47852);
    this.lbo = bt.GC();
    paramContext = (be)com.tencent.luggage.sdk.g.c.a("onCreateRealWebView", new ad.3(this, paramContext), new ad.4(this));
    AppMethodBeat.o(47852);
    return paramContext;
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(47854);
    if (z.f((aa)Dj()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
      z.a(((ae)Dj()).aOf(), ((ae)Dj()).aNe().aOd(), ((ae)Dj()).aOd(), getAppId());
    }
    super.dispatchStart();
    Q(com.tencent.mm.plugin.appbrand.page.b.e.class);
    boolean bool = bka().getIsX5Kernel();
    n.Dp(getAppId()).iFN.set(bool);
    com.tencent.mm.plugin.appbrand.report.h.gU(bool);
    bkA().aa(new ad.6(this));
    if (com.tencent.mm.plugin.appbrand.ac.g.as(((ae)Dj()).getRuntime())) {
      super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new com.tencent.mm.plugin.appbrand.ac.d((aa)Dj()));
    }
    AppMethodBeat.o(47854);
  }
  
  public final o getRuntime()
  {
    AppMethodBeat.i(205043);
    o localo = (o)super.Dl();
    AppMethodBeat.o(205043);
    return localo;
  }
  
  protected final void t(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(47860);
    if (Dj() == null)
    {
      AppMethodBeat.o(47860);
      return;
    }
    if ((bhG()) || (isRunning()))
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
      com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.d)Dj(), paramString, paramLong1, paramLong2, bkb(), 0L);
    }
    AppMethodBeat.o(47860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */