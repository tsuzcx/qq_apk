package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.luggage.sdk.b.a.b.c.c;
import com.tencent.luggage.sdk.b.a.b.c.d;
import com.tencent.luggage.sdk.b.a.b.c.e;
import com.tencent.luggage.sdk.b.a.b.d;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fe;
import com.tencent.mm.g.b.a.fe.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.o.a.b;
import com.tencent.mm.plugin.appbrand.o.a.d;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragmentActivity.a;
import d.g.b.k;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;

@SuppressLint({"ViewConstructor"})
public class u
  extends t
  implements t.a
{
  private FrameLayout kZW;
  private volatile com.tencent.mm.plugin.appbrand.report.model.f kZX;
  private i kZY;
  public boolean kZZ;
  public boolean laa;
  public boolean lab;
  private long lac;
  private long lad;
  private long lae;
  private String laf;
  private final com.tencent.luggage.sdk.b.a.b.c lag;
  public final Deque<ae> lah;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.appbrand.jsapi.video.c.a> lai;
  private long laj;
  public boolean lak;
  
  static
  {
    AppMethodBeat.i(175032);
    com.tencent.mm.plugin.appbrand.o.e.c.kTR = new ModularizingPkgRetrieverWC.1();
    AppMethodBeat.o(175032);
  }
  
  public u(Context paramContext, o paramo)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(47811);
    this.kZZ = false;
    this.laa = false;
    this.lab = false;
    this.kZX = bhv();
    this.lah = new LinkedList();
    this.lai = new u.1(this);
    this.laj = 0L;
    this.lak = false;
    super.setDelegate(this);
    if (paramo.CZ())
    {
      this.lag = null;
      AppMethodBeat.o(47811);
      return;
    }
    this.lag = new com.tencent.luggage.sdk.b.a.b.c(this);
    z.gz(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poW, true));
    AppMethodBeat.o(47811);
  }
  
  public u(Context paramContext, o paramo, t.a parama)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(47812);
    this.kZZ = false;
    this.laa = false;
    this.lab = false;
    this.kZX = bhv();
    this.lah = new LinkedList();
    this.lai = new u.1(this);
    this.laj = 0L;
    this.lak = false;
    super.setDelegate(parama);
    if (paramo.CZ())
    {
      this.lag = null;
      AppMethodBeat.o(47812);
      return;
    }
    this.lag = new com.tencent.luggage.sdk.b.a.b.c(this);
    this.lag.cgV = com.tencent.mm.plugin.appbrand.xweb_ext.c.bvf();
    paramContext = this.lag;
    if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bvg()) {
      bool = true;
    }
    paramContext.cgW = bool;
    this.lag.cgX = com.tencent.mm.plugin.appbrand.xweb_ext.c.bve();
    AppMethodBeat.o(47812);
  }
  
  private void a(final String paramString, final by paramby, final t.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(47819);
    h localh = h.vKh;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localh.dB(937, i);
      getRuntime().iDL.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47809);
          switch (u.6.jZE[paramAnonymousd.ordinal()])
          {
          default: 
            AppMethodBeat.o(47809);
            return;
          case 1: 
            paramAnonymousd = h.vKh;
            if (paramBoolean) {}
            for (i = 6;; i = 2)
            {
              paramAnonymousd.dB(937, i);
              u.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47804);
                  if (u.5.this.lap) {
                    u.5.this.lan.bju();
                  }
                  u.5.this.lan.proceed();
                  AppMethodBeat.o(47804);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          case 2: 
            paramAnonymousd = h.vKh;
            if (paramBoolean) {}
            for (i = 8;; i = 4)
            {
              paramAnonymousd.dB(937, i);
              u.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47805);
                  if ((u.5.this.lap) && (u.b(u.this) != null))
                  {
                    u.b(u.this).cancel();
                    u.a(u.this, null);
                  }
                  u.5.this.lan.cancel();
                  AppMethodBeat.o(47805);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          }
          paramAnonymousd = h.vKh;
          if (paramBoolean) {}
          for (int i = 7;; i = 3)
          {
            paramAnonymousd.dB(937, i);
            u.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(47808);
                Object localObject1 = u.b(u.this);
                u.a(u.this, new i(u.this.getContext()));
                Object localObject2 = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(47806);
                    switch (paramAnonymous3Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(47806);
                      return;
                      u.a(u.this, u.5.this.val$url, u.5.this.kZx, u.5.this.lan);
                    }
                  }
                };
                u.b(u.this).setPositiveButton((DialogInterface.OnClickListener)localObject2);
                u.b(u.this).setNegativeButton((DialogInterface.OnClickListener)localObject2);
                localObject2 = u.b(u.this);
                Object localObject3 = u.this;
                Runnable local2 = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(47807);
                    if (this.las != null) {
                      this.las.bjb();
                    }
                    AppMethodBeat.o(47807);
                  }
                };
                k.h(localObject3, "pageContainer");
                ((i)localObject2).chb = ((t)localObject3);
                ((t)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                ((i)localObject2).bringToFront();
                localObject3 = ((t)localObject3).getRuntime();
                if (localObject3 == null) {
                  k.fvU();
                }
                Object localObject4 = ((i)localObject2).kYr;
                com.tencent.mm.modelappbrand.a.b localb;
                if (localObject4 != null)
                {
                  localObject1 = ((AppBrandRuntime)localObject3).Eg();
                  if (localObject1 != null)
                  {
                    localObject1 = ((AppBrandInitConfig)localObject1).dfM;
                    if (localObject1 != null)
                    {
                      localObject1 = (CharSequence)localObject1;
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setMainTitle((CharSequence)localObject1);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setBackgroundColor(0);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setForegroundStyle(true);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).hd(true);
                    }
                  }
                }
                else
                {
                  localObject4 = ((i)localObject2).kYs;
                  if (localObject4 != null)
                  {
                    localObject1 = new ColorMatrix();
                    ((ColorMatrix)localObject1).setSaturation(0.0F);
                    ((ImageView)localObject4).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
                    localb = com.tencent.mm.modelappbrand.a.b.aub();
                    localObject1 = ((AppBrandRuntime)localObject3).Eg();
                    if (localObject1 == null) {
                      break label388;
                    }
                  }
                }
                label388:
                for (localObject1 = ((AppBrandInitConfig)localObject1).iconUrl;; localObject1 = null)
                {
                  localb.a((ImageView)localObject4, (String)localObject1, com.tencent.mm.modelappbrand.a.a.aua(), (b.h)com.tencent.mm.modelappbrand.a.g.gSK);
                  localObject1 = ((i)localObject2).kYp;
                  if (localObject1 != null) {
                    ((Animation)localObject1).cancel();
                  }
                  ((i)localObject2).kYp = AnimationUtils.loadAnimation(((i)localObject2).getContext(), MMFragmentActivity.a.lLF);
                  localObject1 = ((i)localObject2).kYp;
                  if (localObject1 == null) {
                    k.fvU();
                  }
                  ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new i.d((i)localObject2, local2));
                  localObject1 = ((i)localObject2).kYp;
                  if (localObject1 == null) {
                    k.fvU();
                  }
                  ((i)localObject2).startAnimation((Animation)localObject1);
                  AppMethodBeat.o(47808);
                  return;
                  localObject1 = (CharSequence)"";
                  break;
                }
              }
            });
            break;
          }
        }
      });
      AppMethodBeat.o(47819);
      return;
    }
  }
  
  private void bjv()
  {
    AppMethodBeat.i(47814);
    if (this.kZW != null)
    {
      ad.i("MicroMsg.AppBrandPageContainerWC", "hideWeishiCoverImageIfNeed");
      FrameLayout localFrameLayout = this.kZW;
      getRuntime().i(new u.2(this, localFrameLayout), 300L);
      this.kZW = null;
    }
    AppMethodBeat.o(47814);
  }
  
  private void bjw()
  {
    AppMethodBeat.i(196053);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().DZ().cfo.scene == 1118)
      {
        if (getRuntime().DZ().cfo != null) {
          break label171;
        }
        localAppBrandRecommendStatObj = null;
        if (localAppBrandRecommendStatObj != null)
        {
          ad.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
          if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.lpx)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.lpy))) {
            break label188;
          }
          this.laf = (localAppBrandRecommendStatObj.lpx + "?" + localAppBrandRecommendStatObj.lpy);
        }
      }
    }
    for (;;)
    {
      this.kZZ = true;
      this.lad = System.currentTimeMillis();
      if (getRuntime().DZ().cfo.scene == 1162)
      {
        this.lab = true;
        this.lad = System.currentTimeMillis();
      }
      AppMethodBeat.o(196053);
      return;
      label171:
      localAppBrandRecommendStatObj = getRuntime().DZ().cfo.lpN;
      break;
      label188:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.lpx)) {
        this.laf = localAppBrandRecommendStatObj.lpx;
      } else {
        this.laf = getRuntime().aLS();
      }
    }
  }
  
  public final boolean Cu()
  {
    return false;
  }
  
  public void Kx(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(47816);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    super.Kx(paramString);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    if ((getRuntime().aNb().cfq) || (getRuntime().iGa)) {
      getRuntime().i(new u.3(this), 10000L);
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
        k.h(this, "pagecontainer");
        if ((getRuntime() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j)) {
          continue;
        }
        localfe = new fe();
        localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.ME(getAppId());
        paramString = localObject2;
        if (localQualitySessionRuntime == null) {
          continue;
        }
        if (localQualitySessionRuntime.ltP <= 0L) {
          continue;
        }
        localfe.dYa = localfe.t("InstanceId", localQualitySessionRuntime.kGa, true);
        localfe.eag = localfe.t("AppId", localQualitySessionRuntime.appId, true);
        localfe.dYT = localQualitySessionRuntime.lty;
        localfe.ebD = fe.a.iN(localQualitySessionRuntime.lrW);
        localfe.eai = localQualitySessionRuntime.apptype;
        localfe.dKe = localQualitySessionRuntime.scene;
        localfe.hZ(localQualitySessionRuntime.ltP);
        localfe.ia(bt.eGO());
        localfe.hY(localfe.ebr - localfe.ebq);
        paramString = getCurrentPage();
        if (paramString == null) {
          continue;
        }
        paramString = paramString.getCurrentPageView();
        if ((paramString instanceof ae)) {
          continue;
        }
        paramString = localObject1;
      }
      catch (Throwable paramString)
      {
        fe localfe;
        QualitySessionRuntime localQualitySessionRuntime;
        ad.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
        continue;
        continue;
        paramString = localQualitySessionRuntime;
        continue;
      }
      localfe.dZg = com.tencent.mm.plugin.appbrand.report.quality.c.x((ae)paramString);
      localfe.aBj();
      continue;
      com.tencent.mm.plugin.appbrand.report.quality.c.a(paramString, "Null session with " + getAppId());
      bjw();
      if ((com.tencent.mm.plugin.appbrand.ac.g.as(getRuntime())) && (this.lai != null)) {
        this.lai.alive();
      }
      AppMethodBeat.o(47816);
      return;
      paramString = null;
    }
  }
  
  public final q a(String paramString, by paramby, t paramt, Callable<q> paramCallable)
  {
    return null;
  }
  
  protected final t.h a(q paramq1, q paramq2)
  {
    AppMethodBeat.i(175028);
    t.h localh = super.a(paramq1, paramq2);
    this.kZX.bhx();
    this.kZX.a((ae)paramq2.getCurrentPageView(), (ae)paramq1.getCurrentPageView(), by.lgq);
    getRuntime().aMS().Dr(paramq2.getCurrentUrl());
    if (this.lag != null)
    {
      com.tencent.luggage.sdk.b.a.b.c localc = this.lag;
      k.h(paramq1, "out");
      k.h(paramq2, "in");
      localc.chb.post((Runnable)new c.c(localc));
      paramq1 = paramq2.getCurrentPageView();
      if (paramq1 != null)
      {
        paramq1 = (e)paramq1.Q(e.class);
        if (paramq1 != null) {
          paramq1.beu();
        }
      }
    }
    AppMethodBeat.o(175028);
    return localh;
  }
  
  public final t.h a(q paramq1, q paramq2, by paramby, String paramString)
  {
    AppMethodBeat.i(175029);
    paramq1 = super.a(paramq1, paramq2, paramby, paramString);
    this.laj = System.currentTimeMillis();
    Object localObject;
    if (((paramq2 instanceof j)) && (ao.w(getRuntime())))
    {
      localObject = ((j)paramq2).getTabBar();
      if (localObject != null) {
        break label210;
      }
      ad.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.ac.g.as(getRuntime()))
      {
        localObject = paramq2.getCurrentPageView();
        bjv();
      }
      try
      {
        localObject = ((aa)localObject).kYy;
        this.kZW = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131493006, null));
        ImageView localImageView = (ImageView)this.kZW.findViewById(2131305792);
        ((FrameLayout)localObject).addView(this.kZW, -1, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mm.plugin.appbrand.ac.g.a(getRuntime(), localImageView);
        if (!getRuntime().CZ())
        {
          if (!paramString.startsWith(getRuntime().getAppConfig().aTo()))
          {
            bool = true;
            this.lak = bool;
          }
        }
        else
        {
          if (this.lag != null) {
            com.tencent.luggage.sdk.b.a.b.c.a(paramq2, paramby);
          }
          AppMethodBeat.o(175029);
          return paramq1;
          label210:
          ad.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic set tab gone");
          if (((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject).getVisibility() != 0) {
            continue;
          }
          ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject).setVisibility(8);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          ad.i("MicroMsg.AppBrandPageContainerWC", "revealWeishiCoverImageIfNeed, exception, hide without animation");
          bjv();
          continue;
          boolean bool = false;
        }
      }
    }
  }
  
  public final void a(q paramq1, q paramq2, by paramby)
  {
    Object localObject1 = null;
    AppMethodBeat.i(47822);
    super.a(paramq1, paramq2, paramby);
    long l = System.currentTimeMillis() - this.laj;
    this.kZX.a(l, paramby);
    ad.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    if (this.kZY != null)
    {
      this.kZY.bjb();
      this.kZY = null;
    }
    Object localObject2 = this.kZX;
    ae localae = (ae)paramq2.getCurrentPageView();
    if (paramq1 == null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.f)localObject2).a(localae, (ae)localObject1, paramby);
      getRuntime().aMS().Dr(paramq2.getCurrentUrl());
      if (this.lag != null)
      {
        localObject1 = this.lag;
        k.h(paramq2, "in");
        k.h(paramby, "type");
        if (by.lgp != paramby) {
          break label573;
        }
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).a(paramby);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (((com.tencent.luggage.sdk.b.a.b.c)localObject1).chb.getPageCount() > ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cgV) {
          paramq2.Z((Runnable)new d((d.g.a.a)new c.e((com.tencent.luggage.sdk.b.a.b.c)localObject1)));
        }
        localObject2 = paramq2.getCurrentPageView();
        if (localObject2 != null)
        {
          localObject2 = (e)((aa)localObject2).Q(e.class);
          if (localObject2 != null) {
            ((e)localObject2).beu();
          }
        }
        if ((by.lgv != paramby) && (by.lgp != paramby)) {
          ((com.tencent.luggage.sdk.b.a.b.c)localObject1).chb.post((Runnable)new c.d((com.tencent.luggage.sdk.b.a.b.c)localObject1, paramby));
        }
        if ((paramq1 != null) && (paramby == by.lgp) && (getRuntime().DZ().cfo.scene == 1118) && (this.kZZ) && (!this.laa))
        {
          if (paramq1.getCurrentPageView() != null) {
            break label588;
          }
          paramby = "";
          if ((this.laf != null) && (this.laf.equals(paramby)))
          {
            ad.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
            this.lac = ((ae)paramq1.getCurrentPageView()).lbw.bms();
            this.laa = true;
          }
        }
        if (!getRuntime().CZ())
        {
          paramq1 = paramq2.getCurrentUrl();
          if (!(paramq2 instanceof j))
          {
            if ((getPageCount() != 1) || (paramq1.startsWith(getRuntime().getAppConfig().aTo())) || (getRuntime().aMT())) {
              break label599;
            }
            i = 1;
            if (i != 0)
            {
              paramq1 = paramq2.getCurrentPageView();
              if ((paramq1 instanceof ae)) {
                ((ae)paramq1).gB(false);
              }
            }
          }
        }
        AppMethodBeat.o(47822);
        return;
        localObject1 = (ae)paramq1.getCurrentPageView();
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).appId + "] type[" + paramby + "] maxKeepPageCount[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cgV + "] keepInvisbileTabbarPagesActive[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cgW + ']', new Object[0]);
        continue;
      }
      label573:
      if (by.lgv == paramby)
      {
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).Dx();
        continue;
        label588:
        paramby = paramq1.getCurrentPageView().kWX;
        continue;
        label599:
        i = 0;
      }
    }
  }
  
  public final boolean a(String paramString, by paramby, t paramt, final t.d paramd)
  {
    AppMethodBeat.i(47818);
    paramt = getRuntime().iDL;
    if (!paramt.bii()) {
      paramt.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47803);
          u.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47802);
              u.4.this.lan.proceed();
              AppMethodBeat.o(47802);
            }
          });
          AppMethodBeat.o(47803);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(47818);
      return true;
      a(paramString, paramby, paramd, false);
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.report.model.f bhv()
  {
    AppMethodBeat.i(47813);
    com.tencent.mm.plugin.appbrand.report.model.a locala = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
    AppMethodBeat.o(47813);
    return locala;
  }
  
  public ae bhw()
  {
    AppMethodBeat.i(175030);
    for (;;)
    {
      synchronized (this.lah)
      {
        ae localae = (ae)this.lah.pollFirst();
        if (localae != null)
        {
          bool = true;
          ad.i("MicroMsg.AppBrandPageContainerWC", "onCreatePageView preloaded[%b] appId[%s]", new Object[] { Boolean.valueOf(bool), getAppId() });
          if (localae == null) {
            break;
          }
          AppMethodBeat.o(175030);
          return localae;
        }
      }
      boolean bool = false;
    }
    ??? = new ae();
    AppMethodBeat.o(175030);
    return ???;
  }
  
  public com.tencent.mm.plugin.appbrand.report.model.f getReporter()
  {
    return this.kZX;
  }
  
  public o getRuntime()
  {
    AppMethodBeat.i(47815);
    o localo = (o)super.getRuntime();
    AppMethodBeat.o(47815);
    return localo;
  }
  
  public final Object l(q paramq)
  {
    AppMethodBeat.i(47829);
    paramq = AnimationUtils.loadAnimation(getContext(), 2130772144);
    AppMethodBeat.o(47829);
    return paramq;
  }
  
  public final Object m(q paramq)
  {
    AppMethodBeat.i(47830);
    paramq = AnimationUtils.loadAnimation(getContext(), 2130772141);
    AppMethodBeat.o(47830);
    return paramq;
  }
  
  public final Object n(q paramq)
  {
    AppMethodBeat.i(47831);
    paramq = AnimationUtils.loadAnimation(getContext(), 2130772140);
    AppMethodBeat.o(47831);
    return paramq;
  }
  
  public final Object o(q paramq)
  {
    AppMethodBeat.i(47832);
    paramq = AnimationUtils.loadAnimation(getContext(), 2130772145);
    AppMethodBeat.o(47832);
    return paramq;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(47817);
    if (this.kZY != null)
    {
      this.kZY.dismiss();
      this.kZY = null;
      AppMethodBeat.o(47817);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(47817);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(47826);
    super.onBackground();
    if (getPageCount() > 0) {
      this.kZX.d((ae)getCurrentPage().getCurrentPageView());
    }
    Object localObject;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().DZ().cfo.scene == 1118) {
        if ((this.kZZ) && (!this.laa))
        {
          localObject = getCurrentPage().getCurrentPageView().kWX;
          if ((this.laf != null) && (this.laf.equals(localObject)))
          {
            ad.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
            localObject = ((ae)getCurrentPage().getCurrentPageView()).lbw;
            if (localObject != null) {
              break label482;
            }
          }
        }
      }
    }
    label482:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).bms())
    {
      this.lac = l;
      this.laa = true;
      this.lae = (System.currentTimeMillis() - this.lad);
      if ((this.kZZ) && (this.laa) && (getRuntime().DZ().cfo != null))
      {
        ad.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.lac), Long.valueOf(this.lae) });
        com.tencent.mm.plugin.appbrand.appusage.a.i.b(1, this.lac, this.lae, getRuntime().DZ().cfo.lpN);
      }
      if ((this.lab) && (getRuntime().DZ().cfo.scene == 1162) && (System.currentTimeMillis() - this.lad >= 3000L))
      {
        localObject = getRuntime().aNc().iJn;
        String str1 = ((AppBrandLaunchFromNotifyReferrer)localObject).appId;
        int i = ((AppBrandLaunchFromNotifyReferrer)localObject).jdz;
        String str2 = ((AppBrandLaunchFromNotifyReferrer)localObject).jdA;
        String str3 = ((AppBrandLaunchFromNotifyReferrer)localObject).content;
        int j = ((AppBrandLaunchFromNotifyReferrer)localObject).jdB;
        h.vKh.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str1, null, null, str2, Integer.valueOf(0), null, str3, Integer.valueOf(i), null, null });
      }
      AppMethodBeat.o(47826);
      return;
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(47824);
    super.onDestroy();
    if (getPageCount() > 0) {
      this.kZX.c((ae)getCurrentPage().getCurrentPageView());
    }
    if (this.kZY != null)
    {
      this.kZY.cleanup();
      this.kZY = null;
    }
    if (this.lai != null) {
      this.lai.dead();
    }
    AppMethodBeat.o(47824);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47825);
    super.onForeground();
    if (getPageCount() > 0) {
      this.kZX.e((ae)getCurrentPage().getCurrentPageView());
    }
    bjw();
    AppMethodBeat.o(47825);
  }
  
  protected final void onReady()
  {
    AppMethodBeat.i(47823);
    super.onReady();
    ReportStorageSizeTask localReportStorageSizeTask = new ReportStorageSizeTask();
    localReportStorageSizeTask.appId = getRuntime().mAppId;
    AppBrandMainProcessService.a(localReportStorageSizeTask);
    AppMethodBeat.o(47823);
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(47827);
    super.onViewAdded(paramView);
    if ((paramView instanceof q)) {
      cb.cG((q)paramView);
    }
    AppMethodBeat.o(47827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */