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
import android.view.ViewGroup;
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
import com.tencent.mm.g.b.a.hz;
import com.tencent.mm.g.b.a.hz.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appusage.a.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragmentActivity.a;
import d.g.b.p;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;

@SuppressLint({"ViewConstructor"})
public class v
  extends u
  implements u.a
{
  private FrameLayout mbh;
  private volatile f mbi;
  private j mbj;
  public boolean mbk;
  public boolean mbl;
  public boolean mbm;
  private long mbn;
  private long mbo;
  private long mbp;
  private String mbq;
  public String mbr;
  private final com.tencent.luggage.sdk.b.a.b.c mbs;
  public final Deque<ae> mbt;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.appbrand.jsapi.video.c.a> mbu;
  private long mbv;
  public boolean mbw;
  
  static
  {
    AppMethodBeat.i(175032);
    com.tencent.mm.plugin.appbrand.m.e.c.lUF = new ModularizingPkgRetrieverWC.1();
    AppMethodBeat.o(175032);
  }
  
  public v(Context paramContext, o paramo)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(47811);
    this.mbk = false;
    this.mbl = false;
    this.mbm = false;
    this.mbi = bsh();
    this.mbt = new LinkedList();
    this.mbu = new com.tencent.mm.sdk.b.c() {};
    this.mbv = 0L;
    this.mbw = false;
    super.setDelegate(this);
    if (paramo.Eb())
    {
      this.mbs = null;
      AppMethodBeat.o(47811);
      return;
    }
    this.mbs = new com.tencent.luggage.sdk.b.a.b.c(this);
    z.hf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxl, true));
    AppMethodBeat.o(47811);
  }
  
  public v(Context paramContext, o paramo, u.a parama)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(47812);
    this.mbk = false;
    this.mbl = false;
    this.mbm = false;
    this.mbi = bsh();
    this.mbt = new LinkedList();
    this.mbu = new com.tencent.mm.sdk.b.c() {};
    this.mbv = 0L;
    this.mbw = false;
    super.setDelegate(parama);
    if (paramo.Eb())
    {
      this.mbs = null;
      AppMethodBeat.o(47812);
      return;
    }
    this.mbs = new com.tencent.luggage.sdk.b.a.b.c(this);
    this.mbs.cog = com.tencent.mm.plugin.appbrand.xweb_ext.c.bGg();
    paramContext = this.mbs;
    if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bGh()) {
      bool = true;
    }
    paramContext.coh = bool;
    this.mbs.coi = com.tencent.mm.plugin.appbrand.xweb_ext.c.bGf();
    AppMethodBeat.o(47812);
  }
  
  private void a(final String paramString, final bs parambs, final u.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(47819);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localg.dD(937, i);
      getRuntime().jwT.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47809);
          switch (v.6.kWz[paramAnonymousd.ordinal()])
          {
          default: 
            AppMethodBeat.o(47809);
            return;
          case 1: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.g.yhR;
            if (paramBoolean) {}
            for (i = 6;; i = 2)
            {
              paramAnonymousd.dD(937, i);
              v.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47804);
                  if (v.5.this.mbB) {
                    v.5.this.mbz.bum();
                  }
                  v.5.this.mbz.proceed();
                  AppMethodBeat.o(47804);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          case 2: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.g.yhR;
            if (paramBoolean) {}
            for (i = 8;; i = 4)
            {
              paramAnonymousd.dD(937, i);
              v.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47805);
                  if ((v.5.this.mbB) && (v.b(v.this) != null))
                  {
                    v.b(v.this).cancel();
                    v.a(v.this, null);
                  }
                  v.5.this.mbz.cancel();
                  AppMethodBeat.o(47805);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          }
          paramAnonymousd = com.tencent.mm.plugin.report.service.g.yhR;
          if (paramBoolean) {}
          for (int i = 7;; i = 3)
          {
            paramAnonymousd.dD(937, i);
            v.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(47808);
                Object localObject1 = v.b(v.this);
                v.a(v.this, new j(v.this.getContext()));
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
                      v.a(v.this, v.5.this.val$url, v.5.this.maH, v.5.this.mbz);
                    }
                  }
                };
                v.b(v.this).setPositiveButton((DialogInterface.OnClickListener)localObject2);
                v.b(v.this).setNegativeButton((DialogInterface.OnClickListener)localObject2);
                localObject2 = v.b(v.this);
                Object localObject3 = v.this;
                Runnable local2 = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(47807);
                    if (this.mbE != null) {
                      this.mbE.btT();
                    }
                    AppMethodBeat.o(47807);
                  }
                };
                p.h(localObject3, "pageContainer");
                ((j)localObject2).com = ((u)localObject3);
                ((u)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                ((j)localObject2).bringToFront();
                localObject3 = ((u)localObject3).getRuntime();
                if (localObject3 == null) {
                  p.gfZ();
                }
                Object localObject4 = ((j)localObject2).lZz;
                com.tencent.mm.modelappbrand.a.b localb;
                if (localObject4 != null)
                {
                  localObject1 = ((AppBrandRuntime)localObject3).Fi();
                  if (localObject1 != null)
                  {
                    localObject1 = ((AppBrandInitConfig)localObject1).doD;
                    if (localObject1 != null)
                    {
                      localObject1 = (CharSequence)localObject1;
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setMainTitle((CharSequence)localObject1);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setBackgroundColor(0);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setForegroundStyle(true);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).hK(true);
                    }
                  }
                }
                else
                {
                  localObject4 = ((j)localObject2).lZA;
                  if (localObject4 != null)
                  {
                    localObject1 = new ColorMatrix();
                    ((ColorMatrix)localObject1).setSaturation(0.0F);
                    ((ImageView)localObject4).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
                    localb = com.tencent.mm.modelappbrand.a.b.aDV();
                    localObject1 = ((AppBrandRuntime)localObject3).Fi();
                    if (localObject1 == null) {
                      break label388;
                    }
                  }
                }
                label388:
                for (localObject1 = ((AppBrandInitConfig)localObject1).iconUrl;; localObject1 = null)
                {
                  localb.a((ImageView)localObject4, (String)localObject1, com.tencent.mm.modelappbrand.a.a.aDU(), (b.h)com.tencent.mm.modelappbrand.a.g.hLC);
                  localObject1 = ((j)localObject2).lZx;
                  if (localObject1 != null) {
                    ((Animation)localObject1).cancel();
                  }
                  ((j)localObject2).lZx = AnimationUtils.loadAnimation(((j)localObject2).getContext(), MMFragmentActivity.a.mOe);
                  localObject1 = ((j)localObject2).lZx;
                  if (localObject1 == null) {
                    p.gfZ();
                  }
                  ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new j.d((j)localObject2, local2));
                  localObject1 = ((j)localObject2).lZx;
                  if (localObject1 == null) {
                    p.gfZ();
                  }
                  ((j)localObject2).startAnimation((Animation)localObject1);
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
  
  private void bun()
  {
    AppMethodBeat.i(47814);
    if (this.mbh != null)
    {
      ad.i("MicroMsg.AppBrandPageContainerWC", "hideWeishiCoverImageIfNeed");
      final FrameLayout localFrameLayout = this.mbh;
      getRuntime().j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47800);
          localFrameLayout.setVisibility(8);
          if ((localFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
          }
          AppMethodBeat.o(47800);
        }
      }, 300L);
      this.mbh = null;
    }
    AppMethodBeat.o(47814);
  }
  
  private void buo()
  {
    AppMethodBeat.i(188680);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().Fb().cmC.scene == 1118)
      {
        if (getRuntime().Fb().cmC != null) {
          break label171;
        }
        localAppBrandRecommendStatObj = null;
        if (localAppBrandRecommendStatObj != null)
        {
          ad.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
          if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.mrj)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.mrk))) {
            break label188;
          }
          this.mbq = (localAppBrandRecommendStatObj.mrj + "?" + localAppBrandRecommendStatObj.mrk);
        }
      }
    }
    for (;;)
    {
      this.mbk = true;
      this.mbo = System.currentTimeMillis();
      if (getRuntime().Fb().cmC.scene == 1162)
      {
        this.mbm = true;
        this.mbo = System.currentTimeMillis();
      }
      AppMethodBeat.o(188680);
      return;
      label171:
      localAppBrandRecommendStatObj = getRuntime().Fb().cmC.mrz;
      break;
      label188:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.mrj)) {
        this.mbq = localAppBrandRecommendStatObj.mrj;
      } else {
        this.mbq = getRuntime().aVW();
      }
    }
  }
  
  public final boolean Dx()
  {
    return false;
  }
  
  public void Sd(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(47816);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    super.Sd(paramString);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    if ((getRuntime().aXb().cmE) || (getRuntime().jzi)) {
      getRuntime().j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47801);
          v.this.bul();
          AppMethodBeat.o(47801);
        }
      }, 10000L);
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
        p.h(this, "pagecontainer");
        if ((getRuntime() instanceof l)) {
          continue;
        }
        localhz = new hz();
        localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(getAppId());
        paramString = localObject2;
        if (localQualitySessionRuntime == null) {
          continue;
        }
        if (localQualitySessionRuntime.mvz <= 0L) {
          continue;
        }
        localhz.eqt = localhz.t("InstanceId", localQualitySessionRuntime.lEv, true);
        localhz.esR = localhz.t("AppId", localQualitySessionRuntime.appId, true);
        localhz.eru = localQualitySessionRuntime.mvi;
        localhz.euo = hz.a.je(localQualitySessionRuntime.mtG);
        localhz.esT = localQualitySessionRuntime.apptype;
        localhz.dVd = localQualitySessionRuntime.scene;
        localhz.nv(localQualitySessionRuntime.mvz);
        localhz.nw(bt.flT());
        localhz.nu(localhz.euc - localhz.eub);
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
        hz localhz;
        QualitySessionRuntime localQualitySessionRuntime;
        ad.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
        continue;
        continue;
        paramString = localQualitySessionRuntime;
        continue;
      }
      localhz.eaw = com.tencent.mm.plugin.appbrand.report.quality.c.y((ae)paramString);
      localhz.aLk();
      continue;
      com.tencent.mm.plugin.appbrand.report.quality.c.a(paramString, "Null session with " + getAppId());
      buo();
      if ((com.tencent.mm.plugin.appbrand.ab.g.am(getRuntime())) && (this.mbu != null)) {
        this.mbu.alive();
      }
      AppMethodBeat.o(47816);
      return;
      paramString = null;
    }
  }
  
  public final r a(String paramString, bs parambs, u paramu, Callable<r> paramCallable)
  {
    return null;
  }
  
  protected final u.h a(r paramr1, r paramr2)
  {
    AppMethodBeat.i(175028);
    u.h localh = super.a(paramr1, paramr2);
    this.mbi.bsj();
    this.mbi.a((ae)paramr2.getCurrentPageView(), (ae)paramr1.getCurrentPageView(), bs.mfN);
    getRuntime().aWS().KG(paramr2.getCurrentUrl());
    if (this.mbs != null)
    {
      com.tencent.luggage.sdk.b.a.b.c localc = this.mbs;
      p.h(paramr1, "out");
      p.h(paramr2, "in");
      localc.com.post((Runnable)new c.c(localc));
      paramr1 = paramr2.getCurrentPageView();
      if (paramr1 != null)
      {
        paramr1 = (e)paramr1.Q(e.class);
        if (paramr1 != null) {
          paramr1.boZ();
        }
      }
    }
    AppMethodBeat.o(175028);
    return localh;
  }
  
  public final u.h a(r paramr1, r paramr2, bs parambs, String paramString)
  {
    AppMethodBeat.i(175029);
    paramr1 = super.a(paramr1, paramr2, parambs, paramString);
    this.mbv = System.currentTimeMillis();
    Object localObject;
    if (((paramr2 instanceof k)) && (ap.n(getRuntime())))
    {
      localObject = ((k)paramr2).getTabBar();
      if (localObject != null) {
        break label210;
      }
      ad.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.ab.g.am(getRuntime()))
      {
        localObject = paramr2.getCurrentPageView();
        bun();
      }
      try
      {
        localObject = ((aa)localObject).lZG;
        this.mbh = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131493006, null));
        ImageView localImageView = (ImageView)this.mbh.findViewById(2131305792);
        ((FrameLayout)localObject).addView(this.mbh, -1, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mm.plugin.appbrand.ab.g.a(getRuntime(), localImageView);
        if (!getRuntime().Eb())
        {
          if (!paramString.startsWith(getRuntime().getAppConfig().bdL()))
          {
            bool = true;
            this.mbw = bool;
          }
        }
        else
        {
          if (this.mbs != null) {
            com.tencent.luggage.sdk.b.a.b.c.a(paramr2, parambs);
          }
          AppMethodBeat.o(175029);
          return paramr1;
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
          bun();
          continue;
          boolean bool = false;
        }
      }
    }
  }
  
  public final void a(r paramr1, r paramr2, bs parambs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(47822);
    super.a(paramr1, paramr2, parambs);
    long l = System.currentTimeMillis() - this.mbv;
    this.mbi.a(l, parambs);
    ad.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    if (this.mbj != null)
    {
      this.mbj.btT();
      this.mbj = null;
    }
    Object localObject2 = this.mbi;
    ae localae = (ae)paramr2.getCurrentPageView();
    if (paramr1 == null)
    {
      ((f)localObject2).a(localae, (ae)localObject1, parambs);
      getRuntime().aWS().KG(paramr2.getCurrentUrl());
      if (this.mbs != null)
      {
        localObject1 = this.mbs;
        p.h(paramr2, "in");
        p.h(parambs, "type");
        if (bs.mfM != parambs) {
          break label573;
        }
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).a(parambs);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (((com.tencent.luggage.sdk.b.a.b.c)localObject1).com.getPageCount() > ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cog) {
          paramr2.aa((Runnable)new d((d.g.a.a)new c.e((com.tencent.luggage.sdk.b.a.b.c)localObject1)));
        }
        localObject2 = paramr2.getCurrentPageView();
        if (localObject2 != null)
        {
          localObject2 = (e)((aa)localObject2).Q(e.class);
          if (localObject2 != null) {
            ((e)localObject2).boZ();
          }
        }
        if ((bs.mfS != parambs) && (bs.mfM != parambs)) {
          ((com.tencent.luggage.sdk.b.a.b.c)localObject1).com.post((Runnable)new c.d((com.tencent.luggage.sdk.b.a.b.c)localObject1, parambs));
        }
        if ((paramr1 != null) && (parambs == bs.mfM) && (getRuntime().Fb().cmC.scene == 1118) && (this.mbk) && (!this.mbl))
        {
          if (paramr1.getCurrentPageView() != null) {
            break label588;
          }
          parambs = "";
          if ((this.mbq != null) && (this.mbq.equals(parambs)))
          {
            ad.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
            this.mbn = ((ae)paramr1.getCurrentPageView()).mcx.bxt();
            this.mbl = true;
          }
        }
        if (!getRuntime().Eb())
        {
          paramr1 = paramr2.getCurrentUrl();
          if (!(paramr2 instanceof k))
          {
            if ((getPageCount() != 1) || (paramr1.startsWith(getRuntime().getAppConfig().bdL())) || (getRuntime().aWT())) {
              break label599;
            }
            i = 1;
            if (i != 0)
            {
              paramr1 = paramr2.getCurrentPageView();
              if ((paramr1 instanceof ae)) {
                ((ae)paramr1).ha(false);
              }
            }
          }
        }
        AppMethodBeat.o(47822);
        return;
        localObject1 = (ae)paramr1.getCurrentPageView();
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).appId + "] type[" + parambs + "] maxKeepPageCount[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cog + "] keepInvisbileTabbarPagesActive[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).coh + ']', new Object[0]);
        continue;
      }
      label573:
      if (bs.mfS == parambs)
      {
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).Ez();
        continue;
        label588:
        parambs = paramr1.getCurrentPageView().lYf;
        continue;
        label599:
        i = 0;
      }
    }
  }
  
  public final boolean a(String paramString, bs parambs, u paramu, final u.d paramd)
  {
    AppMethodBeat.i(47818);
    paramu = getRuntime().jwT;
    if (!paramu.btb()) {
      paramu.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47803);
          v.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47802);
              v.4.this.mbz.proceed();
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
      a(paramString, parambs, paramd, false);
    }
  }
  
  protected f bsh()
  {
    AppMethodBeat.i(47813);
    com.tencent.mm.plugin.appbrand.report.model.a locala = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
    AppMethodBeat.o(47813);
    return locala;
  }
  
  public ae bsi()
  {
    AppMethodBeat.i(175030);
    for (;;)
    {
      synchronized (this.mbt)
      {
        ae localae = (ae)this.mbt.pollFirst();
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
  
  public f getReporter()
  {
    return this.mbi;
  }
  
  public o getRuntime()
  {
    AppMethodBeat.i(47815);
    o localo = (o)super.getRuntime();
    AppMethodBeat.o(47815);
    return localo;
  }
  
  public final Object l(r paramr)
  {
    AppMethodBeat.i(47829);
    paramr = AnimationUtils.loadAnimation(getContext(), 2130772144);
    AppMethodBeat.o(47829);
    return paramr;
  }
  
  public final Object m(r paramr)
  {
    AppMethodBeat.i(47830);
    paramr = AnimationUtils.loadAnimation(getContext(), 2130772141);
    AppMethodBeat.o(47830);
    return paramr;
  }
  
  public final Object n(r paramr)
  {
    AppMethodBeat.i(47831);
    paramr = AnimationUtils.loadAnimation(getContext(), 2130772140);
    AppMethodBeat.o(47831);
    return paramr;
  }
  
  public final Object o(r paramr)
  {
    AppMethodBeat.i(47832);
    paramr = AnimationUtils.loadAnimation(getContext(), 2130772145);
    AppMethodBeat.o(47832);
    return paramr;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(47817);
    if (this.mbj != null)
    {
      this.mbj.dismiss();
      this.mbj = null;
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
      this.mbi.d((ae)getCurrentPage().getCurrentPageView());
    }
    Object localObject1;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().Fb().cmC.scene == 1118) {
        if ((this.mbk) && (!this.mbl))
        {
          localObject1 = getCurrentPage().getCurrentPageView().lYf;
          if ((this.mbq != null) && (this.mbq.equals(localObject1)))
          {
            ad.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
            localObject1 = ((ae)getCurrentPage().getCurrentPageView()).mcx;
            if (localObject1 != null) {
              break label516;
            }
          }
        }
      }
    }
    label516:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject1).bxt())
    {
      this.mbn = l;
      this.mbl = true;
      this.mbp = (System.currentTimeMillis() - this.mbo);
      if ((this.mbk) && (this.mbl) && (getRuntime().Fb().cmC != null))
      {
        ad.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.mbn), Long.valueOf(this.mbp) });
        i.b(1, this.mbn, this.mbp, getRuntime().Fb().cmC.mrz);
      }
      if ((this.mbm) && (getRuntime().Fb().cmC.scene == 1162) && (System.currentTimeMillis() - this.mbo >= 3000L))
      {
        Object localObject2 = getRuntime().aXc().jCZ;
        localObject1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).appId;
        int i = ((AppBrandLaunchFromNotifyReferrer)localObject2).jXN;
        String str1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).jXO;
        String str2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).content;
        int j = ((AppBrandLaunchFromNotifyReferrer)localObject2).jXP;
        localObject2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).jXQ;
        if (!bt.nullAsNil(this.mbr).equals(str1))
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject1, null, null, str1, Integer.valueOf(0), null, str2, Integer.valueOf(i), null, null, localObject2 });
          this.mbr = str1;
        }
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
      this.mbi.c((ae)getCurrentPage().getCurrentPageView());
    }
    if (this.mbj != null)
    {
      this.mbj.cleanup();
      this.mbj = null;
    }
    if (this.mbu != null) {
      this.mbu.dead();
    }
    AppMethodBeat.o(47824);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47825);
    super.onForeground();
    if (getPageCount() > 0) {
      this.mbi.e((ae)getCurrentPage().getCurrentPageView());
    }
    buo();
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
    if ((paramView instanceof r)) {
      bv.cK((r)paramView);
    }
    AppMethodBeat.o(47827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */