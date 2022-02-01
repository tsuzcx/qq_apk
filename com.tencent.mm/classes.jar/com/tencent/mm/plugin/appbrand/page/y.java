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
import androidx.core.g.w;
import com.tencent.luggage.sdk.b.a.b.c.c;
import com.tencent.luggage.sdk.b.a.b.c.d;
import com.tencent.luggage.sdk.b.a.b.c.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ou;
import com.tencent.mm.f.b.a.ou.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.au.a;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.bd;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.p.a.b;
import com.tencent.mm.plugin.appbrand.p.a.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import kotlin.g.b.p;
import kotlin.o;

@SuppressLint({"ViewConstructor"})
public class y
  extends x
  implements x.a
{
  private FrameLayout qrK;
  private volatile com.tencent.mm.plugin.appbrand.report.model.f qrL;
  private m qrM;
  public boolean qrN;
  public boolean qrO;
  public boolean qrP;
  private long qrQ;
  private long qrR;
  private long qrS;
  private String qrT;
  public String qrU;
  private final com.tencent.luggage.sdk.b.a.b.c qrV;
  public final Deque<ah> qrW;
  private String qrX;
  private IListener<com.tencent.mm.plugin.appbrand.jsapi.video.c.a> qrY;
  private long qrZ;
  
  static
  {
    AppMethodBeat.i(175032);
    ModularizingPkgRetrieverSeparatedPluginsCompatible.a locala = ModularizingPkgRetrieverSeparatedPluginsCompatible.pWK;
    Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverSeparatedPluginsCompatible", "trigger <clinit>");
    AppMethodBeat.o(175032);
  }
  
  public y(Context paramContext, t paramt)
  {
    super(paramContext, paramt);
    AppMethodBeat.i(47811);
    this.qrN = false;
    this.qrO = false;
    this.qrP = false;
    this.qrL = caN();
    this.qrW = new LinkedList();
    this.qrY = new IListener() {};
    this.qrZ = 0L;
    super.setDelegate(this);
    if (paramt.Qv())
    {
      this.qrV = null;
      AppMethodBeat.o(47811);
      return;
    }
    this.qrV = new com.tencent.luggage.sdk.b.a.b.c(this);
    ac.je(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEq, true));
    AppMethodBeat.o(47811);
  }
  
  public y(Context paramContext, t paramt, x.a parama)
  {
    super(paramContext, paramt);
    AppMethodBeat.i(47812);
    this.qrN = false;
    this.qrO = false;
    this.qrP = false;
    this.qrL = caN();
    this.qrW = new LinkedList();
    this.qrY = new IListener() {};
    this.qrZ = 0L;
    super.setDelegate(parama);
    if (paramt.Qv())
    {
      this.qrV = null;
      AppMethodBeat.o(47812);
      return;
    }
    this.qrV = new com.tencent.luggage.sdk.b.a.b.c(this);
    this.qrV.czt = com.tencent.mm.plugin.appbrand.xweb_ext.e.cqO();
    paramContext = this.qrV;
    if (!com.tencent.mm.plugin.appbrand.xweb_ext.e.cqP()) {
      bool = true;
    }
    paramContext.czu = bool;
    paramContext = this.qrV;
    com.tencent.mm.plugin.appbrand.xweb_ext.e.cqN();
    paramContext.czv = true;
    AppMethodBeat.o(47812);
  }
  
  private void a(final String paramString, final ca paramca, final x.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(47819);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localh.el(937, i);
      getRuntime().ntS.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(279725);
          switch (y.7.pdA[paramAnonymousd.ordinal()])
          {
          default: 
            AppMethodBeat.o(279725);
            return;
          case 1: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.h.IzE;
            if (paramBoolean) {}
            for (i = 6;; i = 2)
            {
              paramAnonymousd.el(937, i);
              y.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(282300);
                  if (y.6.this.qse) {
                    y.6.this.qsc.cdN();
                  }
                  y.6.this.qsc.proceed();
                  AppMethodBeat.o(282300);
                }
              });
              AppMethodBeat.o(279725);
              return;
            }
          case 2: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.h.IzE;
            if (paramBoolean) {}
            for (i = 8;; i = 4)
            {
              paramAnonymousd.el(937, i);
              y.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(257269);
                  if ((y.6.this.qse) && (y.b(y.this) != null))
                  {
                    y.b(y.this).cancel();
                    y.a(y.this, null);
                  }
                  y.6.this.qsc.cancel();
                  AppMethodBeat.o(257269);
                }
              });
              AppMethodBeat.o(279725);
              return;
            }
          }
          paramAnonymousd = com.tencent.mm.plugin.report.service.h.IzE;
          if (paramBoolean) {}
          for (int i = 7;; i = 3)
          {
            paramAnonymousd.el(937, i);
            y.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(280269);
                Object localObject1 = y.b(y.this);
                y.a(y.this, new m(y.this.getContext()));
                Object localObject2 = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(270957);
                    switch (paramAnonymous3Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(270957);
                      return;
                      y.a(y.this, y.6.this.val$url, y.6.this.qri, y.6.this.qsc);
                    }
                  }
                };
                y.b(y.this).setPositiveButton((DialogInterface.OnClickListener)localObject2);
                y.b(y.this).setNegativeButton((DialogInterface.OnClickListener)localObject2);
                localObject2 = y.b(y.this);
                Object localObject3 = y.this;
                Runnable local2 = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(282549);
                    if (this.qsh != null) {
                      this.qsh.cdu();
                    }
                    AppMethodBeat.o(282549);
                  }
                };
                p.k(localObject3, "pageContainer");
                ((m)localObject2).czz = ((x)localObject3);
                ((x)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                ((m)localObject2).bringToFront();
                localObject3 = ((x)localObject3).getRuntime();
                if (localObject3 == null) {
                  p.iCn();
                }
                Object localObject4 = ((m)localObject2).nzU;
                com.tencent.mm.modelappbrand.a.b localb;
                if (localObject4 != null)
                {
                  localObject1 = ((AppBrandRuntime)localObject3).Sq();
                  if (localObject1 != null)
                  {
                    localObject1 = ((AppBrandInitConfig)localObject1).fzM;
                    if (localObject1 != null)
                    {
                      localObject1 = (CharSequence)localObject1;
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setMainTitle((CharSequence)localObject1);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setBackgroundColor(0);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setForegroundStyle(true);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).hk(true);
                    }
                  }
                }
                else
                {
                  localObject4 = ((m)localObject2).qpT;
                  if (localObject4 != null)
                  {
                    localObject1 = new ColorMatrix();
                    ((ColorMatrix)localObject1).setSaturation(0.0F);
                    ((ImageView)localObject4).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
                    localb = com.tencent.mm.modelappbrand.a.b.bhh();
                    localObject1 = ((AppBrandRuntime)localObject3).Sq();
                    if (localObject1 == null) {
                      break label388;
                    }
                  }
                }
                label388:
                for (localObject1 = ((AppBrandInitConfig)localObject1).iconUrl;; localObject1 = null)
                {
                  localb.a((ImageView)localObject4, (String)localObject1, com.tencent.mm.modelappbrand.a.a.bhg(), (b.h)com.tencent.mm.modelappbrand.a.g.lzF);
                  localObject1 = ((m)localObject2).qpR;
                  if (localObject1 != null) {
                    ((Animation)localObject1).cancel();
                  }
                  ((m)localObject2).qpR = AnimationUtils.loadAnimation(((m)localObject2).getContext(), MMFragmentActivity.a.rhY);
                  localObject1 = ((m)localObject2).qpR;
                  if (localObject1 == null) {
                    p.iCn();
                  }
                  ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new m.d((m)localObject2, local2));
                  localObject1 = ((m)localObject2).qpR;
                  if (localObject1 == null) {
                    p.iCn();
                  }
                  ((m)localObject2).startAnimation((Animation)localObject1);
                  AppMethodBeat.o(280269);
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
  
  private void cdO()
  {
    AppMethodBeat.i(47814);
    if (this.qrK != null)
    {
      Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed");
      Object localObject = this.qrK;
      t localt = getRuntime();
      localt.h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47801);
          this.qsb.setVisibility(8);
          if ((this.qsb.getParent() instanceof ViewGroup)) {
            ((ViewGroup)this.qsb.getParent()).removeView(this.qsb);
          }
          AppMethodBeat.o(47801);
        }
      }, 300L);
      this.qrK = null;
      localObject = localt.bCz();
      if ((localObject instanceof ae))
      {
        Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed, hide");
        ((ae)localObject).o(true, "");
      }
    }
    AppMethodBeat.o(47814);
  }
  
  private void cdP()
  {
    AppMethodBeat.i(242916);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().Sk().cxf.scene == 1118)
      {
        if (getRuntime().Sk().cxf != null) {
          break label173;
        }
        localAppBrandRecommendStatObj = null;
        if (localAppBrandRecommendStatObj != null)
        {
          Log.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
          if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.qJr)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.qJs))) {
            break label190;
          }
          this.qrT = (localAppBrandRecommendStatObj.qJr + "?" + localAppBrandRecommendStatObj.qJs);
        }
      }
    }
    for (;;)
    {
      this.qrN = true;
      this.qrR = System.currentTimeMillis();
      if (getRuntime().Sk().cxf.scene == 1162)
      {
        this.qrP = true;
        this.qrR = System.currentTimeMillis();
      }
      AppMethodBeat.o(242916);
      return;
      label173:
      localAppBrandRecommendStatObj = getRuntime().Sk().cxf.qJH;
      break;
      label190:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.qJr)) {
        this.qrT = localAppBrandRecommendStatObj.qJr;
      } else {
        this.qrT = getRuntime().bCi();
      }
    }
  }
  
  protected final void NR()
  {
    AppMethodBeat.i(47823);
    super.NR();
    ReportStorageSizeTask localReportStorageSizeTask = new ReportStorageSizeTask();
    localReportStorageSizeTask.appId = getRuntime().mAppId;
    localReportStorageSizeTask.bsM();
    AppMethodBeat.o(47823);
  }
  
  public final boolean PP()
  {
    return false;
  }
  
  public final u a(String paramString, ca paramca, x paramx, Callable<u> paramCallable)
  {
    return null;
  }
  
  protected final x.h a(u paramu1, u paramu2)
  {
    AppMethodBeat.i(175028);
    x.h localh = super.a(paramu1, paramu2);
    this.qrL.caP();
    this.qrL.a((ah)paramu2.getCurrentPageView(), (ah)paramu1.getCurrentPageView(), ca.qwz);
    getRuntime().bDk().abX(paramu2.getCurrentUrl());
    if (this.qrV != null)
    {
      com.tencent.luggage.sdk.b.a.b.c localc = this.qrV;
      p.k(paramu1, "out");
      p.k(paramu2, "in");
      localc.czz.post((Runnable)new c.c(localc));
      paramu1 = paramu2.getCurrentPageView();
      if (paramu1 != null)
      {
        paramu1 = (com.tencent.mm.plugin.appbrand.page.a.e)paramu1.R(com.tencent.mm.plugin.appbrand.page.a.e.class);
        if (paramu1 != null) {
          paramu1.bXq();
        }
      }
    }
    AppMethodBeat.o(175028);
    return localh;
  }
  
  public final x.h a(u paramu1, u paramu2, ca paramca, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(242910);
    paramu1 = super.a(paramu1, paramu2, paramca, paramString, paramBoolean);
    this.qrZ = System.currentTimeMillis();
    if (((paramu2 instanceof n)) && (bd.s(getRuntime())))
    {
      paramString = ((n)paramu2).getTabBar();
      if (paramString != null) {
        break label191;
      }
      Log.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.ag.g.ap(getRuntime()))
      {
        paramString = paramu2.getCurrentPageView();
        cdO();
      }
      try
      {
        paramString = paramString.qpZ;
        this.qrK = ((FrameLayout)LayoutInflater.from(getContext()).inflate(au.g.app_brand_launch_proxy_weishi, null));
        ImageView localImageView = (ImageView)this.qrK.findViewById(au.f.thumb);
        paramString.addView(this.qrK, -1, new FrameLayout.LayoutParams(-1, -1));
        Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, showLaunchThumb");
        com.tencent.mm.plugin.appbrand.ag.g.a(getRuntime(), localImageView, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47800);
            Object localObject = y.this.getRuntime();
            if (localObject == null)
            {
              AppMethodBeat.o(47800);
              return;
            }
            localObject = ((t)localObject).bCz();
            if ((localObject instanceof ae))
            {
              Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, hide");
              ((ae)localObject).o(true, "");
            }
            AppMethodBeat.o(47800);
          }
        });
        if (this.qrV != null) {
          com.tencent.luggage.sdk.b.a.b.c.a(paramu2, paramca);
        }
        AppMethodBeat.o(242910);
        return paramu1;
        label191:
        Log.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic set tab gone");
        if (paramString.getVisibility() != 0) {
          continue;
        }
        paramString.setVisibility(8);
      }
      catch (NullPointerException paramString)
      {
        for (;;)
        {
          Log.i("MicroMsg.AppBrandPageContainerWC", "revealWeishiCoverImageIfNeed, exception, hide without animation");
          cdO();
        }
      }
    }
  }
  
  public final void a(u paramu1, u paramu2, ca paramca)
  {
    Object localObject = null;
    AppMethodBeat.i(47822);
    super.a(paramu1, paramu2, paramca);
    long l = System.currentTimeMillis() - this.qrZ;
    this.qrL.a(l, paramca);
    Log.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    if (this.qrM != null)
    {
      this.qrM.cdu();
      this.qrM = null;
    }
    com.tencent.mm.plugin.appbrand.report.model.f localf = this.qrL;
    ah localah = (ah)paramu2.getCurrentPageView();
    if (paramu1 == null)
    {
      localf.a(localah, (ah)localObject, paramca);
      getRuntime().bDk().abX(paramu2.getCurrentUrl());
      if (this.qrV != null)
      {
        localObject = this.qrV;
        p.k(paramu2, "in");
        p.k(paramca, "type");
        if (ca.qwy != paramca) {
          break label481;
        }
        ((com.tencent.luggage.sdk.b.a.b.c)localObject).a(paramca);
      }
    }
    for (;;)
    {
      try
      {
        if (((com.tencent.luggage.sdk.b.a.b.c)localObject).czz.getPageCount() > ((com.tencent.luggage.sdk.b.a.b.c)localObject).czt) {
          paramu2.ai((Runnable)new com.tencent.luggage.sdk.b.a.b.d((kotlin.g.a.a)new c.e((com.tencent.luggage.sdk.b.a.b.c)localObject)));
        }
        paramu2 = paramu2.getCurrentPageView();
        if (paramu2 != null)
        {
          paramu2 = (com.tencent.mm.plugin.appbrand.page.a.e)paramu2.R(com.tencent.mm.plugin.appbrand.page.a.e.class);
          if (paramu2 != null) {
            paramu2.bXq();
          }
        }
        if ((ca.qwE != paramca) && (ca.qwy != paramca)) {
          ((com.tencent.luggage.sdk.b.a.b.c)localObject).czz.post((Runnable)new c.d((com.tencent.luggage.sdk.b.a.b.c)localObject, paramca));
        }
        if ((paramu1 != null) && (paramca == ca.qwy) && (getRuntime().Sk().cxf.scene == 1118) && (this.qrN) && (!this.qrO))
        {
          if (paramu1.getCurrentPageView() != null) {
            break label496;
          }
          paramu2 = "";
          if ((this.qrT != null) && (this.qrT.equals(paramu2)))
          {
            Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
            this.qrQ = ((ah)paramu1.getCurrentPageView()).qtk.chO();
            this.qrO = true;
          }
        }
        AppMethodBeat.o(47822);
        return;
        localObject = (ah)paramu1.getCurrentPageView();
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject).appId + "] type[" + paramca + "] maxKeepPageCount[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject).czt + "] keepInvisbileTabbarPagesActive[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject).czu + ']', new Object[0]);
        continue;
      }
      label481:
      if (ca.qwE == paramca)
      {
        ((com.tencent.luggage.sdk.b.a.b.c)localObject).Ra();
        continue;
        label496:
        paramu2 = paramu1.getCurrentPageView().qoI;
      }
    }
  }
  
  public final boolean a(String paramString, ca paramca, x paramx, final x.d paramd)
  {
    AppMethodBeat.i(47818);
    paramx = getRuntime().ntS;
    if (!paramx.cbE()) {
      paramx.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47809);
          y.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47804);
              y.5.this.qsc.proceed();
              AppMethodBeat.o(47804);
            }
          });
          AppMethodBeat.o(47809);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(47818);
      return true;
      a(paramString, paramca, paramd, false);
    }
  }
  
  protected final void b(ca paramca, u paramu1, u paramu2, float paramFloat)
  {
    AppMethodBeat.i(242923);
    super.b(paramca, paramu1, paramu2, paramFloat);
    Log.i("MicroMsg.AppBrandPageContainerWC", "[onPageSwitchProgress]  percent[%f]", new Object[] { Float.valueOf(paramFloat) });
    com.tencent.mm.plugin.appbrand.widget.c.e locale = getRuntime().nwI;
    p.k(paramca, "type");
    if (com.tencent.mm.plugin.appbrand.widget.c.e.a(locale.nAH, paramca))
    {
      paramca = locale.nAH.bDy();
      p.j(paramca, "runtime.initConfig");
      paramca = locale.a(paramu1, paramu2, paramca);
      if (((Boolean)paramca.Mx).booleanValue())
      {
        paramu1 = locale.cnN();
        if ((paramu1 instanceof AppBrandSingleCloseCapsuleBar)) {
          if (!((Boolean)paramca.My).booleanValue()) {
            break label140;
          }
        }
      }
    }
    for (;;)
    {
      paramu1.setHeaderAlpha(paramFloat);
      AppMethodBeat.o(242923);
      return;
      label140:
      paramFloat = 100.0F - paramFloat;
    }
  }
  
  protected final void b(u paramu, ca paramca)
  {
    AppMethodBeat.i(242911);
    super.b(paramu, paramca);
    com.tencent.mm.plugin.appbrand.widget.c.e locale = getRuntime().nwI;
    paramu = (ah)paramu.getCurrentPageView();
    p.k(paramu, "pageView");
    p.k(paramca, "type");
    paramu = paramu.getRuntime();
    p.j(paramu, "runtime");
    if (!com.tencent.mm.plugin.appbrand.widget.c.e.a(paramca, paramu))
    {
      paramu = locale.rta;
      if (paramu != null)
      {
        paramu.a(com.tencent.mm.plugin.appbrand.widget.f.rnL);
        AppMethodBeat.o(242911);
        return;
      }
    }
    AppMethodBeat.o(242911);
  }
  
  protected com.tencent.mm.plugin.appbrand.report.model.f caN()
  {
    AppMethodBeat.i(47813);
    com.tencent.mm.plugin.appbrand.report.model.a locala = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
    AppMethodBeat.o(47813);
    return locala;
  }
  
  public ah caO()
  {
    AppMethodBeat.i(175030);
    for (;;)
    {
      synchronized (this.qrW)
      {
        ah localah1 = (ah)this.qrW.pollFirst();
        if (localah1 != null)
        {
          bool = true;
          Log.i("MicroMsg.AppBrandPageContainerWC", "onCreatePageView preloaded[%b] appId[%s]", new Object[] { Boolean.valueOf(bool), getAppId() });
          if (TextUtils.isEmpty(this.qrX)) {
            break label121;
          }
          if (!(localah1 instanceof bv)) {
            break;
          }
          AppMethodBeat.o(175030);
          return localah1;
        }
      }
      boolean bool = false;
    }
    ??? = new bv(this.qrX);
    AppMethodBeat.o(175030);
    return ???;
    label121:
    if (localah2 != null)
    {
      AppMethodBeat.o(175030);
      return localah2;
    }
    ??? = new ah();
    AppMethodBeat.o(175030);
    return ???;
  }
  
  protected final void d(ca paramca, u paramu1, u paramu2)
  {
    AppMethodBeat.i(242919);
    super.d(paramca, paramu1, paramu2);
    Log.i("MicroMsg.AppBrandPageContainerWC", "[onPageSwitchStart]");
    paramu1 = getRuntime().nwI;
    p.k(paramca, "type");
    paramca = paramu1.nAH.bDy().nBE;
    if ((paramca.isEnable()) && (paramca.nZE)) {}
    for (int i = 1; (i != 0) && (paramu2 != null); i = 0)
    {
      paramu2.setForceDisableMeasureCache(true);
      AppMethodBeat.o(242919);
      return;
    }
    AppMethodBeat.o(242919);
  }
  
  protected final void e(ca paramca, u paramu1, u paramu2)
  {
    AppMethodBeat.i(242921);
    super.e(paramca, paramu1, paramu2);
    Log.i("MicroMsg.AppBrandPageContainerWC", "[onPageSwitchEnd]");
    com.tencent.mm.plugin.appbrand.widget.c.e locale = getRuntime().nwI;
    p.k(paramca, "type");
    if (com.tencent.mm.plugin.appbrand.widget.c.e.a(locale.nAH, paramca))
    {
      paramca = locale.nAH.bDy();
      p.j(paramca, "runtime.initConfig");
      paramca = locale.a(paramu1, paramu2, paramca);
      if (((Boolean)paramca.Mx).booleanValue())
      {
        paramu1 = locale.cnN();
        if ((paramu1 instanceof AppBrandSingleCloseCapsuleBar)) {
          paramu1.B(((Boolean)paramca.My).booleanValue(), false);
        }
      }
    }
    locale.cnO();
    AppMethodBeat.o(242921);
  }
  
  protected boolean e(u paramu)
  {
    boolean bool2 = false;
    AppMethodBeat.i(242915);
    boolean bool3 = super.e(paramu);
    int j;
    label41:
    int k;
    label54:
    int m;
    label67:
    int i;
    if (!getRuntime().bDl())
    {
      bool1 = true;
      if (getRuntime().Qv()) {
        break label155;
      }
      j = 1;
      if (com.tencent.mm.plugin.appbrand.ag.g.ap(getRuntime())) {
        break label161;
      }
      k = 1;
      if (bd.s(getRuntime())) {
        break label167;
      }
      m = 1;
      i = 0;
      label69:
      if (i >= 5) {
        break label180;
      }
      if (new boolean[] { bool3, bool1, j, k, m }[i] != 0) {
        break label173;
      }
      Log.i("MicroMsg.AppBrandPageContainerWC", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition", new Object[] { paramu.getAppId(), paramu.getCurrentUrl(), Integer.valueOf(i) });
    }
    label155:
    label161:
    label167:
    label173:
    label180:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      AppMethodBeat.o(242915);
      return bool1;
      bool1 = false;
      break;
      j = 0;
      break label41;
      k = 0;
      break label54;
      m = 0;
      break label67;
      i += 1;
      break label69;
    }
  }
  
  protected final void f(ca paramca, u paramu1, u paramu2)
  {
    AppMethodBeat.i(242922);
    super.f(paramca, paramu1, paramu2);
    Log.i("MicroMsg.AppBrandPageContainerWC", "[onPageSwitchCancel]");
    com.tencent.mm.plugin.appbrand.widget.c.e locale = getRuntime().nwI;
    p.k(paramca, "type");
    if (com.tencent.mm.plugin.appbrand.widget.c.e.a(locale.nAH, paramca))
    {
      paramca = locale.nAH.bDy();
      p.j(paramca, "runtime.initConfig");
      paramca = locale.a(paramu1, paramu2, paramca);
      if (((Boolean)paramca.Mx).booleanValue())
      {
        paramu1 = locale.cnN();
        if ((paramu1 instanceof AppBrandSingleCloseCapsuleBar)) {
          if (((Boolean)paramca.My).booleanValue()) {
            break label130;
          }
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      paramu1.B(bool, false);
      AppMethodBeat.o(242922);
      return;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.report.model.f getReporter()
  {
    return this.qrL;
  }
  
  public t getRuntime()
  {
    AppMethodBeat.i(47815);
    t localt = (t)super.getRuntime();
    AppMethodBeat.o(47815);
    return localt;
  }
  
  public void init(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(47816);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInit);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI_Game);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup_Game);
    super.init(paramString);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepCreatePageUI_Game);
    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInitUIGroup_Game);
    if (!getRuntime().bDx().cxh)
    {
      getRuntime();
      if (!t.nwr) {}
    }
    else
    {
      getRuntime().h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268414);
          y.this.cdL();
          AppMethodBeat.o(268414);
        }
      }, 10000L);
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.appbrand.report.quality.b.cik();
        p.k(this, "pagecontainer");
        if ((getRuntime() instanceof l)) {
          continue;
        }
        localou = new ou();
        localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.amO(getAppId());
        paramString = localObject2;
        if (localQualitySessionRuntime == null) {
          continue;
        }
        if (localQualitySessionRuntime.qNO <= 0L) {
          continue;
        }
        localou.gfn = localou.z("InstanceId", localQualitySessionRuntime.cBH, true);
        localou.gmF = localou.z("AppId", localQualitySessionRuntime.appId, true);
        localou.gYL = localQualitySessionRuntime.qNx;
        localou.hdh = ou.a.ot(localQualitySessionRuntime.qLQ);
        localou.gYN = localQualitySessionRuntime.apptype;
        localou.gnP = localQualitySessionRuntime.scene;
        localou.Bm(localQualitySessionRuntime.qNO);
        localou.Bn(Util.nowMilliSecond());
        localou.Bl(localou.hcV - localou.hcU);
        paramString = getCurrentPage();
        if (paramString == null) {
          continue;
        }
        paramString = paramString.getCurrentPageView();
        if ((paramString instanceof ah)) {
          continue;
        }
        paramString = localObject1;
      }
      catch (Throwable paramString)
      {
        ou localou;
        QualitySessionRuntime localQualitySessionRuntime;
        Log.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
        continue;
        continue;
        paramString = localQualitySessionRuntime;
        continue;
      }
      localou.grp = com.tencent.mm.plugin.appbrand.report.quality.d.x((ah)paramString);
      localou.bpa();
      continue;
      com.tencent.mm.plugin.appbrand.report.quality.d.a(paramString, "Null session with " + getAppId());
      cdP();
      if ((com.tencent.mm.plugin.appbrand.ag.g.ap(getRuntime())) && (this.qrY != null)) {
        this.qrY.alive();
      }
      AppMethodBeat.o(47816);
      return;
      paramString = null;
    }
  }
  
  public final Object n(u paramu)
  {
    AppMethodBeat.i(47829);
    paramu = AnimationUtils.loadAnimation(getContext(), au.a.slide_right_in);
    AppMethodBeat.o(47829);
    return paramu;
  }
  
  public final Object o(u paramu)
  {
    AppMethodBeat.i(47830);
    paramu = AnimationUtils.loadAnimation(getContext(), au.a.slide_left_out);
    AppMethodBeat.o(47830);
    return paramu;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(47817);
    if (this.qrM != null)
    {
      this.qrM.dismiss();
      this.qrM = null;
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
      this.qrL.e((ah)getCurrentPage().getCurrentPageView());
    }
    Object localObject1;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().Sk().cxf.scene == 1118) {
        if ((this.qrN) && (!this.qrO))
        {
          localObject1 = getCurrentPage().getCurrentPageView().qoI;
          if ((this.qrT != null) && (this.qrT.equals(localObject1)))
          {
            Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
            localObject1 = ((ah)getCurrentPage().getCurrentPageView()).qtk;
            if (localObject1 != null) {
              break label516;
            }
          }
        }
      }
    }
    label516:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject1).chO())
    {
      this.qrQ = l;
      this.qrO = true;
      this.qrS = (System.currentTimeMillis() - this.qrR);
      if ((this.qrN) && (this.qrO) && (getRuntime().Sk().cxf != null))
      {
        Log.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.qrQ), Long.valueOf(this.qrS) });
        com.tencent.mm.plugin.appbrand.appusage.a.i.b(1, this.qrQ, this.qrS, getRuntime().Sk().cxf.qJH);
      }
      if ((this.qrP) && (getRuntime().Sk().cxf.scene == 1162) && (System.currentTimeMillis() - this.qrR >= 3000L))
      {
        Object localObject2 = getRuntime().bDy().nBB;
        localObject1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).appId;
        int i = ((AppBrandLaunchFromNotifyReferrer)localObject2).nYx;
        String str1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).nYy;
        String str2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).content;
        int j = ((AppBrandLaunchFromNotifyReferrer)localObject2).nYz;
        localObject2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).nYA;
        if (!Util.nullAsNil(this.qrU).equals(str1))
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject1, null, null, str1, Integer.valueOf(0), null, str2, Integer.valueOf(i), null, null, localObject2 });
          this.qrU = str1;
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
      this.qrL.d((ah)getCurrentPage().getCurrentPageView());
    }
    if (this.qrM != null)
    {
      this.qrM.cleanup();
      this.qrM = null;
    }
    if (this.qrY != null) {
      this.qrY.dead();
    }
    AppMethodBeat.o(47824);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47825);
    super.onForeground();
    if (getPageCount() > 0) {
      this.qrL.f((ah)getCurrentPage().getCurrentPageView());
    }
    cdP();
    getRuntime().nwI.cnO();
    AppMethodBeat.o(47825);
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(47827);
    super.onViewAdded(paramView);
    if ((paramView instanceof u)) {
      ce.cX((u)paramView);
    }
    AppMethodBeat.o(47827);
  }
  
  public final Object p(u paramu)
  {
    AppMethodBeat.i(47831);
    paramu = AnimationUtils.loadAnimation(getContext(), au.a.slide_left_in);
    AppMethodBeat.o(47831);
    return paramu;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(242917);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(242917);
      return false;
    }
    if ((!w.al(this)) && (getRuntime() != null) && (getRuntime().So()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(242917);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(242917);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(242918);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(242918);
      return false;
    }
    if ((!w.al(this)) && (getRuntime() != null) && (getRuntime().So()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(242918);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(242918);
    return bool;
  }
  
  public final Object q(u paramu)
  {
    AppMethodBeat.i(47832);
    paramu = AnimationUtils.loadAnimation(getContext(), au.a.slide_right_out);
    AppMethodBeat.o(47832);
    return paramu;
  }
  
  public void setWAAutoWebViewJs(String paramString)
  {
    this.qrX = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */