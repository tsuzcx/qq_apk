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
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ib;
import com.tencent.mm.g.b.a.ib.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.d;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;

@SuppressLint({"ViewConstructor"})
public class u
  extends t
  implements t.a
{
  private FrameLayout mfA;
  private volatile f mfB;
  private i mfC;
  public boolean mfD;
  public boolean mfE;
  public boolean mfF;
  private long mfG;
  private long mfH;
  private long mfI;
  private String mfJ;
  public String mfK;
  private final com.tencent.luggage.sdk.b.a.b.c mfL;
  public final Deque<ad> mfM;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.appbrand.jsapi.video.c.a> mfN;
  private long mfO;
  public boolean mfP;
  
  static
  {
    AppMethodBeat.i(175032);
    com.tencent.mm.plugin.appbrand.m.e.c.lZi = new ModularizingPkgRetrieverWC.1();
    AppMethodBeat.o(175032);
  }
  
  public u(Context paramContext, com.tencent.mm.plugin.appbrand.p paramp)
  {
    super(paramContext, paramp);
    AppMethodBeat.i(47811);
    this.mfD = false;
    this.mfE = false;
    this.mfF = false;
    this.mfB = bsS();
    this.mfM = new LinkedList();
    this.mfN = new com.tencent.mm.sdk.b.c() {};
    this.mfO = 0L;
    this.mfP = false;
    super.setDelegate(this);
    if (paramp.Ee())
    {
      this.mfL = null;
      AppMethodBeat.o(47811);
      return;
    }
    this.mfL = new com.tencent.luggage.sdk.b.a.b.c(this);
    y.hg(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEr, true));
    AppMethodBeat.o(47811);
  }
  
  public u(Context paramContext, com.tencent.mm.plugin.appbrand.p paramp, t.a parama)
  {
    super(paramContext, paramp);
    AppMethodBeat.i(47812);
    this.mfD = false;
    this.mfE = false;
    this.mfF = false;
    this.mfB = bsS();
    this.mfM = new LinkedList();
    this.mfN = new com.tencent.mm.sdk.b.c() {};
    this.mfO = 0L;
    this.mfP = false;
    super.setDelegate(parama);
    if (paramp.Ee())
    {
      this.mfL = null;
      AppMethodBeat.o(47812);
      return;
    }
    this.mfL = new com.tencent.luggage.sdk.b.a.b.c(this);
    this.mfL.coi = com.tencent.mm.plugin.appbrand.xweb_ext.c.bHc();
    paramContext = this.mfL;
    if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bHd()) {
      bool = true;
    }
    paramContext.coj = bool;
    this.mfL.cok = com.tencent.mm.plugin.appbrand.xweb_ext.c.bHb();
    AppMethodBeat.o(47812);
  }
  
  private void a(final String paramString, final br parambr, final t.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(47819);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localg.dD(937, i);
      getRuntime().jzR.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47809);
          switch (u.6.lah[paramAnonymousd.ordinal()])
          {
          default: 
            AppMethodBeat.o(47809);
            return;
          case 1: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.g.yxI;
            if (paramBoolean) {}
            for (i = 6;; i = 2)
            {
              paramAnonymousd.dD(937, i);
              u.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47804);
                  if (u.5.this.mfU) {
                    u.5.this.mfS.buX();
                  }
                  u.5.this.mfS.proceed();
                  AppMethodBeat.o(47804);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          case 2: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.g.yxI;
            if (paramBoolean) {}
            for (i = 8;; i = 4)
            {
              paramAnonymousd.dD(937, i);
              u.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47805);
                  if ((u.5.this.mfU) && (u.b(u.this) != null))
                  {
                    u.b(u.this).cancel();
                    u.a(u.this, null);
                  }
                  u.5.this.mfS.cancel();
                  AppMethodBeat.o(47805);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          }
          paramAnonymousd = com.tencent.mm.plugin.report.service.g.yxI;
          if (paramBoolean) {}
          for (int i = 7;; i = 3)
          {
            paramAnonymousd.dD(937, i);
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
                      u.a(u.this, u.5.this.val$url, u.5.this.meZ, u.5.this.mfS);
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
                    if (this.mfX != null) {
                      this.mfX.buE();
                    }
                    AppMethodBeat.o(47807);
                  }
                };
                d.g.b.p.h(localObject3, "pageContainer");
                ((i)localObject2).coo = ((t)localObject3);
                ((t)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                ((i)localObject2).bringToFront();
                localObject3 = ((t)localObject3).getRuntime();
                if (localObject3 == null) {
                  d.g.b.p.gkB();
                }
                Object localObject4 = ((i)localObject2).jED;
                com.tencent.mm.modelappbrand.a.b localb;
                if (localObject4 != null)
                {
                  localObject1 = ((AppBrandRuntime)localObject3).Fn();
                  if (localObject1 != null)
                  {
                    localObject1 = ((AppBrandInitConfig)localObject1).dpI;
                    if (localObject1 != null)
                    {
                      localObject1 = (CharSequence)localObject1;
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setMainTitle((CharSequence)localObject1);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setBackgroundColor(0);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setForegroundStyle(true);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).fE(true);
                    }
                  }
                }
                else
                {
                  localObject4 = ((i)localObject2).mdS;
                  if (localObject4 != null)
                  {
                    localObject1 = new ColorMatrix();
                    ((ColorMatrix)localObject1).setSaturation(0.0F);
                    ((ImageView)localObject4).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
                    localb = com.tencent.mm.modelappbrand.a.b.aEl();
                    localObject1 = ((AppBrandRuntime)localObject3).Fn();
                    if (localObject1 == null) {
                      break label388;
                    }
                  }
                }
                label388:
                for (localObject1 = ((AppBrandInitConfig)localObject1).iconUrl;; localObject1 = null)
                {
                  localb.a((ImageView)localObject4, (String)localObject1, com.tencent.mm.modelappbrand.a.a.aEk(), (b.h)com.tencent.mm.modelappbrand.a.g.hOv);
                  localObject1 = ((i)localObject2).mdQ;
                  if (localObject1 != null) {
                    ((Animation)localObject1).cancel();
                  }
                  ((i)localObject2).mdQ = AnimationUtils.loadAnimation(((i)localObject2).getContext(), MMFragmentActivity.a.mTi);
                  localObject1 = ((i)localObject2).mdQ;
                  if (localObject1 == null) {
                    d.g.b.p.gkB();
                  }
                  ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new i.d((i)localObject2, local2));
                  localObject1 = ((i)localObject2).mdQ;
                  if (localObject1 == null) {
                    d.g.b.p.gkB();
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
  
  private void buY()
  {
    AppMethodBeat.i(47814);
    if (this.mfA != null)
    {
      ae.i("MicroMsg.AppBrandPageContainerWC", "hideWeishiCoverImageIfNeed");
      final FrameLayout localFrameLayout = this.mfA;
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
      this.mfA = null;
    }
    AppMethodBeat.o(47814);
  }
  
  private void buZ()
  {
    AppMethodBeat.i(222851);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().Fg().cmE.scene == 1118)
      {
        if (getRuntime().Fg().cmE != null) {
          break label171;
        }
        localAppBrandRecommendStatObj = null;
        if (localAppBrandRecommendStatObj != null)
        {
          ae.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
          if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.mwh)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.mwi))) {
            break label188;
          }
          this.mfJ = (localAppBrandRecommendStatObj.mwh + "?" + localAppBrandRecommendStatObj.mwi);
        }
      }
    }
    for (;;)
    {
      this.mfD = true;
      this.mfH = System.currentTimeMillis();
      if (getRuntime().Fg().cmE.scene == 1162)
      {
        this.mfF = true;
        this.mfH = System.currentTimeMillis();
      }
      AppMethodBeat.o(222851);
      return;
      label171:
      localAppBrandRecommendStatObj = getRuntime().Fg().cmE.mwx;
      break;
      label188:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.mwh)) {
        this.mfJ = localAppBrandRecommendStatObj.mwh;
      } else {
        this.mfJ = getRuntime().aWx();
      }
    }
  }
  
  public final boolean DA()
  {
    return false;
  }
  
  public void SM(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(47816);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    super.SM(paramString);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    if ((getRuntime().aXw().cmG) || (getRuntime().jCj)) {
      getRuntime().j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47801);
          u.this.buW();
          AppMethodBeat.o(47801);
        }
      }, 10000L);
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.byG();
        d.g.b.p.h(this, "pagecontainer");
        if ((getRuntime() instanceof l)) {
          continue;
        }
        localib = new ib();
        localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(getAppId());
        paramString = localObject2;
        if (localQualitySessionRuntime == null) {
          continue;
        }
        if (localQualitySessionRuntime.mAw <= 0L) {
          continue;
        }
        localib.esa = localib.t("InstanceId", localQualitySessionRuntime.lIU, true);
        localib.euy = localib.t("AppId", localQualitySessionRuntime.appId, true);
        localib.etb = localQualitySessionRuntime.mAf;
        localib.evV = ib.a.jg(localQualitySessionRuntime.myD);
        localib.euA = localQualitySessionRuntime.apptype;
        localib.dWt = localQualitySessionRuntime.scene;
        localib.nH(localQualitySessionRuntime.mAw);
        localib.nI(bu.fpO());
        localib.nG(localib.evJ - localib.evI);
        paramString = getCurrentPage();
        if (paramString == null) {
          continue;
        }
        paramString = paramString.getCurrentPageView();
        if ((paramString instanceof ad)) {
          continue;
        }
        paramString = localObject1;
      }
      catch (Throwable paramString)
      {
        ib localib;
        QualitySessionRuntime localQualitySessionRuntime;
        ae.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
        continue;
        continue;
        paramString = localQualitySessionRuntime;
        continue;
      }
      localib.ebQ = com.tencent.mm.plugin.appbrand.report.quality.c.z((ad)paramString);
      localib.aLH();
      continue;
      com.tencent.mm.plugin.appbrand.report.quality.c.a(paramString, "Null session with " + getAppId());
      buZ();
      if ((com.tencent.mm.plugin.appbrand.aa.g.am(getRuntime())) && (this.mfN != null)) {
        this.mfN.alive();
      }
      AppMethodBeat.o(47816);
      return;
      paramString = null;
    }
  }
  
  public final q a(String paramString, br parambr, t paramt, Callable<q> paramCallable)
  {
    return null;
  }
  
  protected final t.h a(q paramq1, q paramq2)
  {
    AppMethodBeat.i(175028);
    t.h localh = super.a(paramq1, paramq2);
    this.mfB.bsU();
    this.mfB.a((ad)paramq2.getCurrentPageView(), (ad)paramq1.getCurrentPageView(), br.mki);
    getRuntime().aXn().Lf(paramq2.getCurrentUrl());
    if (this.mfL != null)
    {
      com.tencent.luggage.sdk.b.a.b.c localc = this.mfL;
      d.g.b.p.h(paramq1, "out");
      d.g.b.p.h(paramq2, "in");
      localc.coo.post((Runnable)new c.c(localc));
      paramq1 = paramq2.getCurrentPageView();
      if (paramq1 != null)
      {
        paramq1 = (e)paramq1.Q(e.class);
        if (paramq1 != null) {
          paramq1.bpJ();
        }
      }
    }
    AppMethodBeat.o(175028);
    return localh;
  }
  
  public final t.h a(q paramq1, q paramq2, br parambr, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(222850);
    paramq1 = super.a(paramq1, paramq2, parambr, paramString, paramBoolean);
    this.mfO = System.currentTimeMillis();
    Object localObject;
    if (((paramq2 instanceof j)) && (aq.o(getRuntime())))
    {
      localObject = ((j)paramq2).getTabBar();
      if (localObject != null) {
        break label212;
      }
      ae.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.aa.g.am(getRuntime()))
      {
        localObject = paramq2.getCurrentPageView();
        buY();
      }
      try
      {
        localObject = ((z)localObject).mdY;
        this.mfA = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131493006, null));
        ImageView localImageView = (ImageView)this.mfA.findViewById(2131305792);
        ((FrameLayout)localObject).addView(this.mfA, -1, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mm.plugin.appbrand.aa.g.a(getRuntime(), localImageView);
        if (!getRuntime().Ee())
        {
          if (!paramString.startsWith(getRuntime().getAppConfig().ber()))
          {
            paramBoolean = true;
            this.mfP = paramBoolean;
          }
        }
        else
        {
          if (this.mfL != null) {
            com.tencent.luggage.sdk.b.a.b.c.a(paramq2, parambr);
          }
          AppMethodBeat.o(222850);
          return paramq1;
          label212:
          ae.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic set tab gone");
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
          ae.i("MicroMsg.AppBrandPageContainerWC", "revealWeishiCoverImageIfNeed, exception, hide without animation");
          buY();
          continue;
          paramBoolean = false;
        }
      }
    }
  }
  
  public final void a(q paramq1, q paramq2, br parambr)
  {
    Object localObject1 = null;
    AppMethodBeat.i(47822);
    super.a(paramq1, paramq2, parambr);
    long l = System.currentTimeMillis() - this.mfO;
    this.mfB.a(l, parambr);
    ae.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    if (this.mfC != null)
    {
      this.mfC.buE();
      this.mfC = null;
    }
    Object localObject2 = this.mfB;
    ad localad = (ad)paramq2.getCurrentPageView();
    if (paramq1 == null)
    {
      ((f)localObject2).a(localad, (ad)localObject1, parambr);
      getRuntime().aXn().Lf(paramq2.getCurrentUrl());
      if (this.mfL != null)
      {
        localObject1 = this.mfL;
        d.g.b.p.h(paramq2, "in");
        d.g.b.p.h(parambr, "type");
        if (br.mkh != parambr) {
          break label573;
        }
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).a(parambr);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (((com.tencent.luggage.sdk.b.a.b.c)localObject1).coo.getPageCount() > ((com.tencent.luggage.sdk.b.a.b.c)localObject1).coi) {
          paramq2.Y((Runnable)new com.tencent.luggage.sdk.b.a.b.d((d.g.a.a)new c.e((com.tencent.luggage.sdk.b.a.b.c)localObject1)));
        }
        localObject2 = paramq2.getCurrentPageView();
        if (localObject2 != null)
        {
          localObject2 = (e)((z)localObject2).Q(e.class);
          if (localObject2 != null) {
            ((e)localObject2).bpJ();
          }
        }
        if ((br.mkn != parambr) && (br.mkh != parambr)) {
          ((com.tencent.luggage.sdk.b.a.b.c)localObject1).coo.post((Runnable)new c.d((com.tencent.luggage.sdk.b.a.b.c)localObject1, parambr));
        }
        if ((paramq1 != null) && (parambr == br.mkh) && (getRuntime().Fg().cmE.scene == 1118) && (this.mfD) && (!this.mfE))
        {
          if (paramq1.getCurrentPageView() != null) {
            break label588;
          }
          parambr = "";
          if ((this.mfJ != null) && (this.mfJ.equals(parambr)))
          {
            ae.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
            this.mfG = ((ad)paramq1.getCurrentPageView()).mgP.bym();
            this.mfE = true;
          }
        }
        if (!getRuntime().Ee())
        {
          paramq1 = paramq2.getCurrentUrl();
          if (!(paramq2 instanceof j))
          {
            if ((getPageCount() != 1) || (paramq1.startsWith(getRuntime().getAppConfig().ber())) || (getRuntime().aXo())) {
              break label599;
            }
            i = 1;
            if (i != 0)
            {
              paramq1 = paramq2.getCurrentPageView();
              if ((paramq1 instanceof ad)) {
                ((ad)paramq1).ha(false);
              }
            }
          }
        }
        AppMethodBeat.o(47822);
        return;
        localObject1 = (ad)paramq1.getCurrentPageView();
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).appId + "] type[" + parambr + "] maxKeepPageCount[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).coi + "] keepInvisbileTabbarPagesActive[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).coj + ']', new Object[0]);
        continue;
      }
      label573:
      if (br.mkn == parambr)
      {
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).EB();
        continue;
        label588:
        parambr = paramq1.getCurrentPageView().mcM;
        continue;
        label599:
        i = 0;
      }
    }
  }
  
  public final boolean a(String paramString, br parambr, t paramt, final t.d paramd)
  {
    AppMethodBeat.i(47818);
    paramt = getRuntime().jzR;
    if (!paramt.btM()) {
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
              u.4.this.mfS.proceed();
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
      a(paramString, parambr, paramd, false);
    }
  }
  
  protected f bsS()
  {
    AppMethodBeat.i(47813);
    com.tencent.mm.plugin.appbrand.report.model.a locala = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
    AppMethodBeat.o(47813);
    return locala;
  }
  
  public ad bsT()
  {
    AppMethodBeat.i(175030);
    for (;;)
    {
      synchronized (this.mfM)
      {
        ad localad = (ad)this.mfM.pollFirst();
        if (localad != null)
        {
          bool = true;
          ae.i("MicroMsg.AppBrandPageContainerWC", "onCreatePageView preloaded[%b] appId[%s]", new Object[] { Boolean.valueOf(bool), getAppId() });
          if (localad == null) {
            break;
          }
          AppMethodBeat.o(175030);
          return localad;
        }
      }
      boolean bool = false;
    }
    ??? = new ad();
    AppMethodBeat.o(175030);
    return ???;
  }
  
  public f getReporter()
  {
    return this.mfB;
  }
  
  public com.tencent.mm.plugin.appbrand.p getRuntime()
  {
    AppMethodBeat.i(47815);
    com.tencent.mm.plugin.appbrand.p localp = (com.tencent.mm.plugin.appbrand.p)super.getRuntime();
    AppMethodBeat.o(47815);
    return localp;
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
    if (this.mfC != null)
    {
      this.mfC.dismiss();
      this.mfC = null;
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
      this.mfB.d((ad)getCurrentPage().getCurrentPageView());
    }
    Object localObject1;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().Fg().cmE.scene == 1118) {
        if ((this.mfD) && (!this.mfE))
        {
          localObject1 = getCurrentPage().getCurrentPageView().mcM;
          if ((this.mfJ != null) && (this.mfJ.equals(localObject1)))
          {
            ae.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
            localObject1 = ((ad)getCurrentPage().getCurrentPageView()).mgP;
            if (localObject1 != null) {
              break label516;
            }
          }
        }
      }
    }
    label516:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject1).bym())
    {
      this.mfG = l;
      this.mfE = true;
      this.mfI = (System.currentTimeMillis() - this.mfH);
      if ((this.mfD) && (this.mfE) && (getRuntime().Fg().cmE != null))
      {
        ae.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.mfG), Long.valueOf(this.mfI) });
        com.tencent.mm.plugin.appbrand.appusage.a.i.b(1, this.mfG, this.mfI, getRuntime().Fg().cmE.mwx);
      }
      if ((this.mfF) && (getRuntime().Fg().cmE.scene == 1162) && (System.currentTimeMillis() - this.mfH >= 3000L))
      {
        Object localObject2 = getRuntime().aXx().jFX;
        localObject1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).appId;
        int i = ((AppBrandLaunchFromNotifyReferrer)localObject2).kbc;
        String str1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).kbd;
        String str2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).content;
        int j = ((AppBrandLaunchFromNotifyReferrer)localObject2).kbe;
        localObject2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).kbf;
        if (!bu.nullAsNil(this.mfK).equals(str1))
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject1, null, null, str1, Integer.valueOf(0), null, str2, Integer.valueOf(i), null, null, localObject2 });
          this.mfK = str1;
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
      this.mfB.c((ad)getCurrentPage().getCurrentPageView());
    }
    if (this.mfC != null)
    {
      this.mfC.cleanup();
      this.mfC = null;
    }
    if (this.mfN != null) {
      this.mfN.dead();
    }
    AppMethodBeat.o(47824);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47825);
    super.onForeground();
    if (getPageCount() > 0) {
      this.mfB.e((ad)getCurrentPage().getCurrentPageView());
    }
    buZ();
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
      bv.cL((q)paramView);
    }
    AppMethodBeat.o(47827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */