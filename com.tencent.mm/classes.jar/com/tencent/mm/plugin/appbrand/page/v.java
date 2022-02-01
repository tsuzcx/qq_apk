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
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.g.b.a.gw.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.appusage.a.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;

@SuppressLint({"ViewConstructor"})
public class v
  extends u
  implements u.a
{
  private FrameLayout lBG;
  private volatile com.tencent.mm.plugin.appbrand.report.model.f lBH;
  private j lBI;
  public boolean lBJ;
  public boolean lBK;
  public boolean lBL;
  private long lBM;
  private long lBN;
  private long lBO;
  private String lBP;
  public String lBQ;
  private final com.tencent.luggage.sdk.b.a.b.c lBR;
  public final Deque<ae> lBS;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.appbrand.jsapi.video.c.a> lBT;
  private long lBU;
  public boolean lBV;
  
  static
  {
    AppMethodBeat.i(175032);
    com.tencent.mm.plugin.appbrand.n.e.c.lvw = new ModularizingPkgRetrieverWC.1();
    AppMethodBeat.o(175032);
  }
  
  public v(Context paramContext, o paramo)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(47811);
    this.lBJ = false;
    this.lBK = false;
    this.lBL = false;
    this.lBH = bop();
    this.lBS = new LinkedList();
    this.lBT = new com.tencent.mm.sdk.b.c() {};
    this.lBU = 0L;
    this.lBV = false;
    super.setDelegate(this);
    if (paramo.CC())
    {
      this.lBR = null;
      AppMethodBeat.o(47811);
      return;
    }
    this.lBR = new com.tencent.luggage.sdk.b.a.b.c(this);
    z.gW(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSH, true));
    AppMethodBeat.o(47811);
  }
  
  public v(Context paramContext, o paramo, u.a parama)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(47812);
    this.lBJ = false;
    this.lBK = false;
    this.lBL = false;
    this.lBH = bop();
    this.lBS = new LinkedList();
    this.lBT = new com.tencent.mm.sdk.b.c() {};
    this.lBU = 0L;
    this.lBV = false;
    super.setDelegate(parama);
    if (paramo.CC())
    {
      this.lBR = null;
      AppMethodBeat.o(47812);
      return;
    }
    this.lBR = new com.tencent.luggage.sdk.b.a.b.c(this);
    this.lBR.cdQ = com.tencent.mm.plugin.appbrand.xweb_ext.c.bCc();
    paramContext = this.lBR;
    if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bCd()) {
      bool = true;
    }
    paramContext.cdR = bool;
    this.lBR.cdS = com.tencent.mm.plugin.appbrand.xweb_ext.c.bCb();
    AppMethodBeat.o(47812);
  }
  
  private void a(final String paramString, final bt parambt, final u.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(47819);
    h localh = h.wUl;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localh.dB(937, i);
      getRuntime().jdL.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47809);
          switch (v.6.kAr[paramAnonymousd.ordinal()])
          {
          default: 
            AppMethodBeat.o(47809);
            return;
          case 1: 
            paramAnonymousd = h.wUl;
            if (paramBoolean) {}
            for (i = 6;; i = 2)
            {
              paramAnonymousd.dB(937, i);
              v.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47804);
                  if (v.5.this.lCa) {
                    v.5.this.lBY.bqm();
                  }
                  v.5.this.lBY.proceed();
                  AppMethodBeat.o(47804);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          case 2: 
            paramAnonymousd = h.wUl;
            if (paramBoolean) {}
            for (i = 8;; i = 4)
            {
              paramAnonymousd.dB(937, i);
              v.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(47805);
                  if ((v.5.this.lCa) && (v.b(v.this) != null))
                  {
                    v.b(v.this).cancel();
                    v.a(v.this, null);
                  }
                  v.5.this.lBY.cancel();
                  AppMethodBeat.o(47805);
                }
              });
              AppMethodBeat.o(47809);
              return;
            }
          }
          paramAnonymousd = h.wUl;
          if (paramBoolean) {}
          for (int i = 7;; i = 3)
          {
            paramAnonymousd.dB(937, i);
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
                      v.a(v.this, v.5.this.val$url, v.5.this.lBh, v.5.this.lBY);
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
                    if (this.lCd != null) {
                      this.lCd.bpT();
                    }
                    AppMethodBeat.o(47807);
                  }
                };
                d.g.b.k.h(localObject3, "pageContainer");
                ((j)localObject2).cdW = ((u)localObject3);
                ((u)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                ((j)localObject2).bringToFront();
                localObject3 = ((u)localObject3).getRuntime();
                if (localObject3 == null) {
                  d.g.b.k.fOy();
                }
                Object localObject4 = ((j)localObject2).lAb;
                com.tencent.mm.modelappbrand.a.b localb;
                if (localObject4 != null)
                {
                  localObject1 = ((AppBrandRuntime)localObject3).DJ();
                  if (localObject1 != null)
                  {
                    localObject1 = ((AppBrandInitConfig)localObject1).ddh;
                    if (localObject1 != null)
                    {
                      localObject1 = (CharSequence)localObject1;
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setMainTitle((CharSequence)localObject1);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setBackgroundColor(0);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setForegroundStyle(true);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).hA(true);
                    }
                  }
                }
                else
                {
                  localObject4 = ((j)localObject2).lAc;
                  if (localObject4 != null)
                  {
                    localObject1 = new ColorMatrix();
                    ((ColorMatrix)localObject1).setSaturation(0.0F);
                    ((ImageView)localObject4).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
                    localb = com.tencent.mm.modelappbrand.a.b.aAS();
                    localObject1 = ((AppBrandRuntime)localObject3).DJ();
                    if (localObject1 == null) {
                      break label388;
                    }
                  }
                }
                label388:
                for (localObject1 = ((AppBrandInitConfig)localObject1).iconUrl;; localObject1 = null)
                {
                  localb.a((ImageView)localObject4, (String)localObject1, com.tencent.mm.modelappbrand.a.a.aAR(), (b.h)com.tencent.mm.modelappbrand.a.g.htk);
                  localObject1 = ((j)localObject2).lzZ;
                  if (localObject1 != null) {
                    ((Animation)localObject1).cancel();
                  }
                  ((j)localObject2).lzZ = AnimationUtils.loadAnimation(((j)localObject2).getContext(), MMFragmentActivity.a.mnC);
                  localObject1 = ((j)localObject2).lzZ;
                  if (localObject1 == null) {
                    d.g.b.k.fOy();
                  }
                  ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new j.d((j)localObject2, local2));
                  localObject1 = ((j)localObject2).lzZ;
                  if (localObject1 == null) {
                    d.g.b.k.fOy();
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
  
  private void bqn()
  {
    AppMethodBeat.i(47814);
    if (this.lBG != null)
    {
      ac.i("MicroMsg.AppBrandPageContainerWC", "hideWeishiCoverImageIfNeed");
      final FrameLayout localFrameLayout = this.lBG;
      getRuntime().i(new Runnable()
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
      this.lBG = null;
    }
    AppMethodBeat.o(47814);
  }
  
  private void bqo()
  {
    AppMethodBeat.i(186885);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().DC().ccl.scene == 1118)
      {
        if (getRuntime().DC().ccl != null) {
          break label171;
        }
        localAppBrandRecommendStatObj = null;
        if (localAppBrandRecommendStatObj != null)
        {
          ac.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
          if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.lRt)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.lRu))) {
            break label188;
          }
          this.lBP = (localAppBrandRecommendStatObj.lRt + "?" + localAppBrandRecommendStatObj.lRu);
        }
      }
    }
    for (;;)
    {
      this.lBJ = true;
      this.lBN = System.currentTimeMillis();
      if (getRuntime().DC().ccl.scene == 1162)
      {
        this.lBL = true;
        this.lBN = System.currentTimeMillis();
      }
      AppMethodBeat.o(186885);
      return;
      label171:
      localAppBrandRecommendStatObj = getRuntime().DC().ccl.lRJ;
      break;
      label188:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.lRt)) {
        this.lBP = localAppBrandRecommendStatObj.lRt;
      } else {
        this.lBP = getRuntime().aSI();
      }
    }
  }
  
  public final boolean BY()
  {
    return false;
  }
  
  public void OE(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(47816);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    super.OE(paramString);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    if ((getRuntime().aTR().ccn) || (getRuntime().jgc)) {
      getRuntime().i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47801);
          v.this.bql();
          AppMethodBeat.o(47801);
        }
      }, 10000L);
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.btI();
        d.g.b.k.h(this, "pagecontainer");
        if ((getRuntime() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j)) {
          continue;
        }
        localgw = new gw();
        localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.QN(getAppId());
        paramString = localObject2;
        if (localQualitySessionRuntime == null) {
          continue;
        }
        if (localQualitySessionRuntime.lVJ <= 0L) {
          continue;
        }
        localgw.dZT = localgw.t("InstanceId", localQualitySessionRuntime.lht, true);
        localgw.ecm = localgw.t("AppId", localQualitySessionRuntime.appId, true);
        localgw.eaM = localQualitySessionRuntime.lVs;
        localgw.edJ = gw.a.iL(localQualitySessionRuntime.lTR);
        localgw.eco = localQualitySessionRuntime.apptype;
        localgw.dHY = localQualitySessionRuntime.scene;
        localgw.lB(localQualitySessionRuntime.lVJ);
        localgw.lC(bs.eWj());
        localgw.lA(localgw.edx - localgw.edw);
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
        gw localgw;
        QualitySessionRuntime localQualitySessionRuntime;
        ac.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
        continue;
        continue;
        paramString = localQualitySessionRuntime;
        continue;
      }
      localgw.eaY = com.tencent.mm.plugin.appbrand.report.quality.c.x((ae)paramString);
      localgw.aHZ();
      continue;
      com.tencent.mm.plugin.appbrand.report.quality.c.a(paramString, "Null session with " + getAppId());
      bqo();
      if ((com.tencent.mm.plugin.appbrand.ab.g.as(getRuntime())) && (this.lBT != null)) {
        this.lBT.alive();
      }
      AppMethodBeat.o(47816);
      return;
      paramString = null;
    }
  }
  
  public final r a(String paramString, bt parambt, u paramu, Callable<r> paramCallable)
  {
    return null;
  }
  
  protected final u.h a(r paramr1, r paramr2)
  {
    AppMethodBeat.i(175028);
    u.h localh = super.a(paramr1, paramr2);
    this.lBH.bor();
    this.lBH.a((ae)paramr2.getCurrentPageView(), (ae)paramr1.getCurrentPageView(), bt.lGk);
    getRuntime().aTI().Hu(paramr2.getCurrentUrl());
    if (this.lBR != null)
    {
      com.tencent.luggage.sdk.b.a.b.c localc = this.lBR;
      d.g.b.k.h(paramr1, "out");
      d.g.b.k.h(paramr2, "in");
      localc.cdW.post((Runnable)new c.c(localc));
      paramr1 = paramr2.getCurrentPageView();
      if (paramr1 != null)
      {
        paramr1 = (e)paramr1.Q(e.class);
        if (paramr1 != null) {
          paramr1.blo();
        }
      }
    }
    AppMethodBeat.o(175028);
    return localh;
  }
  
  public final u.h a(r paramr1, r paramr2, bt parambt, String paramString)
  {
    AppMethodBeat.i(175029);
    paramr1 = super.a(paramr1, paramr2, parambt, paramString);
    this.lBU = System.currentTimeMillis();
    Object localObject;
    if (((paramr2 instanceof k)) && (ao.w(getRuntime())))
    {
      localObject = ((k)paramr2).getTabBar();
      if (localObject != null) {
        break label210;
      }
      ac.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.ab.g.as(getRuntime()))
      {
        localObject = paramr2.getCurrentPageView();
        bqn();
      }
      try
      {
        localObject = ((aa)localObject).lAi;
        this.lBG = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131493006, null));
        ImageView localImageView = (ImageView)this.lBG.findViewById(2131305792);
        ((FrameLayout)localObject).addView(this.lBG, -1, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mm.plugin.appbrand.ab.g.a(getRuntime(), localImageView);
        if (!getRuntime().CC())
        {
          if (!paramString.startsWith(getRuntime().getAppConfig().bam()))
          {
            bool = true;
            this.lBV = bool;
          }
        }
        else
        {
          if (this.lBR != null) {
            com.tencent.luggage.sdk.b.a.b.c.a(paramr2, parambt);
          }
          AppMethodBeat.o(175029);
          return paramr1;
          label210:
          ac.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic set tab gone");
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
          ac.i("MicroMsg.AppBrandPageContainerWC", "revealWeishiCoverImageIfNeed, exception, hide without animation");
          bqn();
          continue;
          boolean bool = false;
        }
      }
    }
  }
  
  public final void a(r paramr1, r paramr2, bt parambt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(47822);
    super.a(paramr1, paramr2, parambt);
    long l = System.currentTimeMillis() - this.lBU;
    this.lBH.a(l, parambt);
    ac.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    if (this.lBI != null)
    {
      this.lBI.bpT();
      this.lBI = null;
    }
    Object localObject2 = this.lBH;
    ae localae = (ae)paramr2.getCurrentPageView();
    if (paramr1 == null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.f)localObject2).a(localae, (ae)localObject1, parambt);
      getRuntime().aTI().Hu(paramr2.getCurrentUrl());
      if (this.lBR != null)
      {
        localObject1 = this.lBR;
        d.g.b.k.h(paramr2, "in");
        d.g.b.k.h(parambt, "type");
        if (bt.lGj != parambt) {
          break label573;
        }
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).a(parambt);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (((com.tencent.luggage.sdk.b.a.b.c)localObject1).cdW.getPageCount() > ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cdQ) {
          paramr2.ab((Runnable)new d((d.g.a.a)new c.e((com.tencent.luggage.sdk.b.a.b.c)localObject1)));
        }
        localObject2 = paramr2.getCurrentPageView();
        if (localObject2 != null)
        {
          localObject2 = (e)((aa)localObject2).Q(e.class);
          if (localObject2 != null) {
            ((e)localObject2).blo();
          }
        }
        if ((bt.lGp != parambt) && (bt.lGj != parambt)) {
          ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cdW.post((Runnable)new c.d((com.tencent.luggage.sdk.b.a.b.c)localObject1, parambt));
        }
        if ((paramr1 != null) && (parambt == bt.lGj) && (getRuntime().DC().ccl.scene == 1118) && (this.lBJ) && (!this.lBK))
        {
          if (paramr1.getCurrentPageView() != null) {
            break label588;
          }
          parambt = "";
          if ((this.lBP != null) && (this.lBP.equals(parambt)))
          {
            ac.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
            this.lBM = ((ae)paramr1.getCurrentPageView()).lCV.bto();
            this.lBK = true;
          }
        }
        if (!getRuntime().CC())
        {
          paramr1 = paramr2.getCurrentUrl();
          if (!(paramr2 instanceof k))
          {
            if ((getPageCount() != 1) || (paramr1.startsWith(getRuntime().getAppConfig().bam())) || (getRuntime().aTJ())) {
              break label599;
            }
            i = 1;
            if (i != 0)
            {
              paramr1 = paramr2.getCurrentPageView();
              if ((paramr1 instanceof ae)) {
                ((ae)paramr1).gY(false);
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
        ac.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).appId + "] type[" + parambt + "] maxKeepPageCount[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cdQ + "] keepInvisbileTabbarPagesActive[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject1).cdR + ']', new Object[0]);
        continue;
      }
      label573:
      if (bt.lGp == parambt)
      {
        ((com.tencent.luggage.sdk.b.a.b.c)localObject1).Da();
        continue;
        label588:
        parambt = paramr1.getCurrentPageView().lyH;
        continue;
        label599:
        i = 0;
      }
    }
  }
  
  public final boolean a(String paramString, bt parambt, u paramu, final u.d paramd)
  {
    AppMethodBeat.i(47818);
    paramu = getRuntime().jdL;
    if (!paramu.bpc()) {
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
              v.4.this.lBY.proceed();
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
      a(paramString, parambt, paramd, false);
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.report.model.f bop()
  {
    AppMethodBeat.i(47813);
    com.tencent.mm.plugin.appbrand.report.model.a locala = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
    AppMethodBeat.o(47813);
    return locala;
  }
  
  public ae boq()
  {
    AppMethodBeat.i(175030);
    for (;;)
    {
      synchronized (this.lBS)
      {
        ae localae = (ae)this.lBS.pollFirst();
        if (localae != null)
        {
          bool = true;
          ac.i("MicroMsg.AppBrandPageContainerWC", "onCreatePageView preloaded[%b] appId[%s]", new Object[] { Boolean.valueOf(bool), getAppId() });
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
    return this.lBH;
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
    if (this.lBI != null)
    {
      this.lBI.dismiss();
      this.lBI = null;
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
      this.lBH.d((ae)getCurrentPage().getCurrentPageView());
    }
    Object localObject1;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().DC().ccl.scene == 1118) {
        if ((this.lBJ) && (!this.lBK))
        {
          localObject1 = getCurrentPage().getCurrentPageView().lyH;
          if ((this.lBP != null) && (this.lBP.equals(localObject1)))
          {
            ac.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
            localObject1 = ((ae)getCurrentPage().getCurrentPageView()).lCV;
            if (localObject1 != null) {
              break label516;
            }
          }
        }
      }
    }
    label516:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject1).bto())
    {
      this.lBM = l;
      this.lBK = true;
      this.lBO = (System.currentTimeMillis() - this.lBN);
      if ((this.lBJ) && (this.lBK) && (getRuntime().DC().ccl != null))
      {
        ac.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.lBM), Long.valueOf(this.lBO) });
        i.b(1, this.lBM, this.lBO, getRuntime().DC().ccl.lRJ);
      }
      if ((this.lBL) && (getRuntime().DC().ccl.scene == 1162) && (System.currentTimeMillis() - this.lBN >= 3000L))
      {
        Object localObject2 = getRuntime().aTS().jjr;
        localObject1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).appId;
        int i = ((AppBrandLaunchFromNotifyReferrer)localObject2).jDM;
        String str1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).jDN;
        String str2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).content;
        int j = ((AppBrandLaunchFromNotifyReferrer)localObject2).jDO;
        localObject2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).jDP;
        if (!bs.nullAsNil(this.lBQ).equals(str1))
        {
          h.wUl.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject1, null, null, str1, Integer.valueOf(0), null, str2, Integer.valueOf(i), null, null, localObject2 });
          this.lBQ = str1;
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
      this.lBH.c((ae)getCurrentPage().getCurrentPageView());
    }
    if (this.lBI != null)
    {
      this.lBI.cleanup();
      this.lBI = null;
    }
    if (this.lBT != null) {
      this.lBT.dead();
    }
    AppMethodBeat.o(47824);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47825);
    super.onForeground();
    if (getPageCount() > 0) {
      this.lBH.e((ae)getCurrentPage().getCurrentPageView());
    }
    bqo();
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
      bw.cI((r)paramView);
    }
    AppMethodBeat.o(47827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */