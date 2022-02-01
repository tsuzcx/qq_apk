package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Color;
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
import androidx.core.g.z;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.mmdata.rpt.sn;
import com.tencent.mm.autogen.mmdata.rpt.sn.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ba.a;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.bj;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.b.f;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.BaseAppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.a.a.a;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import kotlin.g.b.s;
import kotlin.r;

public class y
  extends x
  implements x.a
{
  private final com.tencent.luggage.sdk.b.a.c.c twA;
  public final Deque<ah> twB;
  private String twC;
  private IListener<com.tencent.mm.plugin.appbrand.jsapi.video.c.a> twD;
  private long twE;
  private FrameLayout twp;
  private volatile com.tencent.mm.plugin.appbrand.report.model.h twq;
  private m twr;
  public boolean tws;
  public boolean twt;
  public boolean twu;
  private long twv;
  private long tww;
  private long twx;
  private String twy;
  public String twz;
  
  static
  {
    AppMethodBeat.i(175032);
    ModularizingPkgRetrieverSeparatedPluginsCompatible.a locala = ModularizingPkgRetrieverSeparatedPluginsCompatible.tbw;
    Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverSeparatedPluginsCompatible", "trigger <clinit>");
    AppMethodBeat.o(175032);
  }
  
  public y(Context paramContext, w paramw)
  {
    super(paramContext, paramw);
    AppMethodBeat.i(47811);
    this.tws = false;
    this.twt = false;
    this.twu = false;
    this.twq = cBi();
    this.twB = new LinkedList();
    if (getRuntime().aqJ()) {
      this.twA = null;
    }
    for (;;)
    {
      this.twD = new AppBrandPageContainerWC.1(this, f.hfK);
      this.twE = 0L;
      super.setDelegate(this);
      AppMethodBeat.o(47811);
      return;
      this.twA = new com.tencent.luggage.sdk.b.a.c.c(this);
      this.twA.erS = com.tencent.mm.plugin.appbrand.xweb_ext.e.cTv();
      paramContext = this.twA;
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.e.cTw()) {
        bool = true;
      }
      paramContext.erT = bool;
      this.twA.erU = com.tencent.mm.plugin.appbrand.xweb_ext.e.cTu();
      ac.kp(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTE, true));
      if (com.tencent.mm.plugin.appbrand.ui.c.cKM()) {
        super.setPageNavigationPushTimeout(com.tencent.mm.plugin.appbrand.ui.c.cKN());
      }
    }
  }
  
  public y(Context paramContext, w paramw, x.a parama)
  {
    super(paramContext, paramw);
    AppMethodBeat.i(47812);
    this.tws = false;
    this.twt = false;
    this.twu = false;
    this.twq = cBi();
    this.twB = new LinkedList();
    if (getRuntime().aqJ()) {
      this.twA = null;
    }
    for (;;)
    {
      this.twD = new AppBrandPageContainerWC.1(this, f.hfK);
      this.twE = 0L;
      super.setDelegate(parama);
      AppMethodBeat.o(47812);
      return;
      this.twA = new com.tencent.luggage.sdk.b.a.c.c(this);
      this.twA.erS = com.tencent.mm.plugin.appbrand.xweb_ext.e.cTv();
      paramContext = this.twA;
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.e.cTw()) {
        bool = true;
      }
      paramContext.erT = bool;
      this.twA.erU = com.tencent.mm.plugin.appbrand.xweb_ext.e.cTu();
      ac.kp(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTE, true));
      if (com.tencent.mm.plugin.appbrand.ui.c.cKM()) {
        super.setPageNavigationPushTimeout(com.tencent.mm.plugin.appbrand.ui.c.cKN());
      }
    }
  }
  
  private void a(final String paramString, final cb paramcb, final x.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(47819);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localh.kJ(937, i);
      getRuntime().qsC.a(paramString, new a.b()
      {
        public final void onLoadResult(a.d paramAnonymousd)
        {
          AppMethodBeat.i(324845);
          switch (y.6.siN[paramAnonymousd.ordinal()])
          {
          default: 
            AppMethodBeat.o(324845);
            return;
          case 1: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.h.OAn;
            if (paramBoolean) {}
            for (i = 6;; i = 2)
            {
              paramAnonymousd.kJ(937, i);
              y.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(324872);
                  if (y.5.this.twJ) {
                    y.5.this.twH.cEt();
                  }
                  y.5.this.twH.proceed();
                  AppMethodBeat.o(324872);
                }
              });
              AppMethodBeat.o(324845);
              return;
            }
          case 2: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.h.OAn;
            if (paramBoolean) {}
            for (i = 8;; i = 4)
            {
              paramAnonymousd.kJ(937, i);
              y.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(324873);
                  if ((y.5.this.twJ) && (y.b(y.this) != null))
                  {
                    y.b(y.this).cancel();
                    y.a(y.this, null);
                  }
                  y.5.this.twH.cancel();
                  AppMethodBeat.o(324873);
                }
              });
              AppMethodBeat.o(324845);
              return;
            }
          }
          paramAnonymousd = com.tencent.mm.plugin.report.service.h.OAn;
          if (paramBoolean) {}
          for (int i = 7;; i = 3)
          {
            paramAnonymousd.kJ(937, i);
            y.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(324874);
                Object localObject1 = y.b(y.this);
                y.a(y.this, new m(y.this.getContext()));
                Object localObject2 = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(325164);
                    switch (paramAnonymous3Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(325164);
                      return;
                      y.a(y.this, y.5.this.val$url, y.5.this.tvL, y.5.this.twH);
                    }
                  }
                };
                y.b(y.this).setPositiveButton((DialogInterface.OnClickListener)localObject2);
                y.b(y.this).setNegativeButton((DialogInterface.OnClickListener)localObject2);
                m localm = y.b(y.this);
                localObject2 = y.this;
                Runnable local2 = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(325157);
                    if (this.twM != null) {
                      this.twM.cDV();
                    }
                    AppMethodBeat.o(325157);
                  }
                };
                s.u(localObject2, "pageContainer");
                localm.erR = ((x)localObject2);
                ((x)localObject2).addView((View)localm, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                localm.bringToFront();
                AppBrandRuntime localAppBrandRuntime = ((x)localObject2).getRuntime();
                s.checkNotNull(localAppBrandRuntime);
                Object localObject3 = localm.qyW;
                if (localObject3 != null)
                {
                  localObject1 = localAppBrandRuntime.asH();
                  if (localObject1 == null)
                  {
                    localObject1 = "";
                    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject3).setMainTitle((CharSequence)localObject1);
                    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject3).setBackgroundColor(0);
                    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject3).setForegroundStyle(true);
                    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject3).hZ(true);
                  }
                }
                else
                {
                  localObject2 = localm.tuy;
                  if (localObject2 != null)
                  {
                    localObject1 = new ColorMatrix();
                    ((ColorMatrix)localObject1).setSaturation(0.0F);
                    localObject3 = kotlin.ah.aiuX;
                    ((ImageView)localObject2).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
                    localObject3 = com.tencent.mm.modelappbrand.a.b.bEY();
                    localObject1 = localAppBrandRuntime.asH();
                    if (localObject1 != null) {
                      break label374;
                    }
                  }
                }
                label374:
                for (localObject1 = null;; localObject1 = ((AppBrandInitConfig)localObject1).iconUrl)
                {
                  ((com.tencent.mm.modelappbrand.a.b)localObject3).a((ImageView)localObject2, (String)localObject1, com.tencent.mm.modelappbrand.a.a.bEX(), (b.h)com.tencent.mm.modelappbrand.a.g.org);
                  localObject1 = localm.tuw;
                  if (localObject1 != null) {
                    ((Animation)localObject1).cancel();
                  }
                  localm.tuw = AnimationUtils.loadAnimation(localm.getContext(), MMFragmentActivity.a.upU);
                  localObject1 = localm.tuw;
                  s.checkNotNull(localObject1);
                  ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new m.b(localm, local2));
                  localObject1 = localm.tuw;
                  s.checkNotNull(localObject1);
                  localm.startAnimation((Animation)localObject1);
                  AppMethodBeat.o(324874);
                  return;
                  localObject2 = ((AppBrandInitConfig)localObject1).hEy;
                  localObject1 = localObject2;
                  if (localObject2 != null) {
                    break;
                  }
                  localObject1 = "";
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
  
  private void cEu()
  {
    AppMethodBeat.i(47814);
    if (this.twp != null)
    {
      Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed");
      Object localObject = this.twp;
      w localw = getRuntime();
      localw.i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47801);
          this.twG.setVisibility(8);
          if ((this.twG.getParent() instanceof ViewGroup)) {
            ((ViewGroup)this.twG.getParent()).removeView(this.twG);
          }
          AppMethodBeat.o(47801);
        }
      }, 300L);
      this.twp = null;
      localObject = localw.cbM();
      if ((localObject instanceof al))
      {
        Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed, hide");
        ((al)localObject).B(true, "");
      }
    }
    AppMethodBeat.o(47814);
  }
  
  private void cEv()
  {
    AppMethodBeat.i(324941);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().asA().epn.scene == 1118)
      {
        if (getRuntime().asA().epn != null) {
          break label173;
        }
        localAppBrandRecommendStatObj = null;
        if (localAppBrandRecommendStatObj != null)
        {
          Log.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
          if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.tNU)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.tNV))) {
            break label190;
          }
          this.twy = (localAppBrandRecommendStatObj.tNU + "?" + localAppBrandRecommendStatObj.tNV);
        }
      }
    }
    for (;;)
    {
      this.tws = true;
      this.tww = System.currentTimeMillis();
      if (getRuntime().asA().epn.scene == 1162)
      {
        this.twu = true;
        this.tww = System.currentTimeMillis();
      }
      AppMethodBeat.o(324941);
      return;
      label173:
      localAppBrandRecommendStatObj = getRuntime().asA().epn.tOl;
      break;
      label190:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.tNU)) {
        this.twy = localAppBrandRecommendStatObj.tNU;
      } else {
        this.twy = getRuntime().cby();
      }
    }
  }
  
  public final u a(String paramString, cb paramcb, x paramx, Callable<u> paramCallable)
  {
    AppMethodBeat.i(325012);
    if ((cb.tBm == paramcb) && (getRuntime().asF()))
    {
      paramString = new com.tencent.mm.plugin.appbrand.headless.b(getContext(), this);
      AppMethodBeat.o(325012);
      return paramString;
    }
    AppMethodBeat.o(325012);
    return null;
  }
  
  public final x.h a(u paramu1, u paramu2, cb paramcb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(324975);
    paramu1 = super.a(paramu1, paramu2, paramcb, paramString, paramBoolean);
    this.twE = System.currentTimeMillis();
    if (((paramu2 instanceof n)) && (bj.x(getRuntime())))
    {
      paramString = ((n)paramu2).getTabBar();
      if (paramString != null) {
        break label191;
      }
      Log.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.weishi.h.aD(getRuntime()))
      {
        paramString = paramu2.getCurrentPageView();
        cEu();
      }
      try
      {
        paramString = paramString.tuD;
        this.twp = ((FrameLayout)LayoutInflater.from(getContext()).inflate(ba.g.app_brand_launch_proxy_weishi, null));
        ImageView localImageView = (ImageView)this.twp.findViewById(ba.f.thumb);
        paramString.addView(this.twp, -1, new FrameLayout.LayoutParams(-1, -1));
        Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, showLaunchThumb");
        com.tencent.mm.plugin.appbrand.weishi.h.a(getRuntime(), localImageView, new Runnable()
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
            localObject = ((w)localObject).cbM();
            if ((localObject instanceof al))
            {
              Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, hide");
              ((al)localObject).B(true, "");
            }
            AppMethodBeat.o(47800);
          }
        });
        if (this.twA != null) {
          com.tencent.luggage.sdk.b.a.c.c.a(paramu2, paramcb);
        }
        AppMethodBeat.o(324975);
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
          cEu();
        }
      }
    }
  }
  
  public final void a(u paramu1, u paramu2, cb paramcb)
  {
    ah localah1 = null;
    AppMethodBeat.i(47822);
    super.a(paramu1, paramu2, paramcb);
    long l = System.currentTimeMillis() - this.twE;
    this.twq.a(l, paramcb);
    Log.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    if (this.twr != null)
    {
      this.twr.cDV();
      this.twr = null;
    }
    com.tencent.mm.plugin.appbrand.report.model.h localh = this.twq;
    ah localah2 = (ah)paramu2.getCurrentPageView();
    if (paramu1 == null)
    {
      localh.a(localah2, localah1, paramcb);
      getRuntime().ccA().Uz(paramu2.getCurrentUrl());
      if (this.twA != null) {
        this.twA.b(paramu2, paramcb);
      }
      if ((paramu1 != null) && (paramcb == cb.tBn) && (getRuntime().asA().epn.scene == 1118) && (this.tws) && (!this.twt)) {
        if (paramu1.getCurrentPageView() != null) {
          break label269;
        }
      }
    }
    label269:
    for (paramu2 = "";; paramu2 = paramu1.getCurrentPageView().cEE())
    {
      if ((this.twy != null) && (this.twy.equals(paramu2)))
      {
        Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
        this.twv = ((ah)paramu1.getCurrentPageView()).txQ.cIJ();
        this.twt = true;
      }
      AppMethodBeat.o(47822);
      return;
      localah1 = (ah)paramu1.getCurrentPageView();
      break;
    }
  }
  
  public final boolean a(ad paramad, String paramString)
  {
    AppMethodBeat.i(325019);
    if (paramad == null)
    {
      AppMethodBeat.o(325019);
      return false;
    }
    com.tencent.luggage.h.d locald = com.tencent.luggage.h.d.evX;
    boolean bool = com.tencent.luggage.h.d.a(getAppConfig(), paramad.cbl(), com.tencent.luggage.l.m.fL(paramString));
    if ((!paramad.asU()) && (!bool))
    {
      AppMethodBeat.o(325019);
      return true;
    }
    if ((paramad.asU()) && (bool))
    {
      this.twB.pollFirst();
      AppMethodBeat.o(325019);
      return true;
    }
    AppMethodBeat.o(325019);
    return false;
  }
  
  public final boolean a(String paramString, cb paramcb, x paramx, final x.d paramd)
  {
    AppMethodBeat.i(47818);
    if (getRuntime().asE()) {
      paramd.cEt();
    }
    paramx = getRuntime().qsC;
    if (!paramx.cBX()) {
      paramx.a(paramString, new a.b()
      {
        public final void onLoadResult(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47809);
          y.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47804);
              y.4.this.twH.proceed();
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
      a(paramString, paramcb, paramd, false);
    }
  }
  
  public ah adu(String paramString)
  {
    AppMethodBeat.i(325022);
    ah localah;
    for (;;)
    {
      synchronized (this.twB)
      {
        localah = (ah)this.twB.pollFirst();
        if (localah != null)
        {
          bool = true;
          Log.i("MicroMsg.AppBrandPageContainerWC", "onCreatePageView preloaded[%b] appId[%s]", new Object[] { Boolean.valueOf(bool), getAppId() });
          if (TextUtils.isEmpty(this.twC)) {
            break label125;
          }
          if (!(localah instanceof bv)) {
            break;
          }
          AppMethodBeat.o(325022);
          return localah;
        }
      }
      bool = false;
    }
    paramString = new bv(this.twC);
    AppMethodBeat.o(325022);
    return paramString;
    label125:
    ??? = com.tencent.luggage.h.d.evX;
    boolean bool = com.tencent.luggage.h.d.a(getAppConfig(), getRuntime().cbl(), com.tencent.luggage.l.m.fL(paramString));
    if (localah != null)
    {
      if ((!localah.asU()) && (!bool))
      {
        this.twB.pollFirst();
        AppMethodBeat.o(325022);
        return localah;
      }
      if ((localah.asU()) && (bool))
      {
        this.twB.pollFirst();
        getRuntime().ccO().cJq();
        AppMethodBeat.o(325022);
        return localah;
      }
    }
    if (bool)
    {
      getRuntime().ccO().cJq();
      paramString = new com.tencent.mm.plugin.appbrand.ab.c();
      AppMethodBeat.o(325022);
      return paramString;
    }
    paramString = new ah();
    AppMethodBeat.o(325022);
    return paramString;
  }
  
  public final boolean apY()
  {
    AppMethodBeat.i(324971);
    if (!getRuntime().aqJ())
    {
      com.tencent.luggage.h.a.b localb = com.tencent.luggage.h.a.b.ewj;
      if (com.tencent.luggage.h.a.b.atc())
      {
        localb = com.tencent.luggage.h.a.b.ewj;
        if ((com.tencent.luggage.h.a.b.a(getRuntime().cbl())) && (org.apache.commons.c.a.contains(getRuntime().getAppConfig().qVP.qWc, "skyline"))) {
          getRuntime().ccO().cJq();
        }
      }
    }
    AppMethodBeat.o(324971);
    return false;
  }
  
  protected final x.h b(u paramu1, u paramu2)
  {
    AppMethodBeat.i(175028);
    x.h localh = super.b(paramu1, paramu2);
    this.twq.cBj();
    this.twq.a((ah)paramu2.getCurrentPageView(), (ah)paramu1.getCurrentPageView(), cb.tBo);
    getRuntime().ccA().Uz(paramu2.getCurrentUrl());
    if (this.twA != null) {
      this.twA.a(paramu1, paramu2);
    }
    AppMethodBeat.o(175028);
    return localh;
  }
  
  protected final void b(cb paramcb, u paramu1, u paramu2, float paramFloat)
  {
    AppMethodBeat.i(325055);
    super.b(paramcb, paramu1, paramu2, paramFloat);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(325055);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.d.d locald = getRuntime().qvN;
    s.u(paramcb, "type");
    float f;
    int i;
    if (com.tencent.mm.plugin.appbrand.widget.d.d.a(locald.qxC, paramcb))
    {
      paramcb = locald.qxC.getInitConfig();
      s.s(paramcb, "runtime.initConfig");
      paramcb = locald.a(paramu1, paramu2, paramcb);
      if (((Boolean)paramcb.bsC).booleanValue())
      {
        paramu1 = locald.cPZ();
        if (paramu1 != null)
        {
          if (!((Boolean)paramcb.bsD).booleanValue()) {
            break label211;
          }
          f = paramFloat;
          paramu1.setHeaderAlpha(f);
          i = paramu1.getContext().getResources().getColor(paramu1.CO(ba.c.white));
          if (!((Boolean)paramcb.bsD).booleanValue()) {
            break label222;
          }
        }
      }
    }
    for (;;)
    {
      i = Color.argb((int)(255.0F * paramFloat / 100.0F), Color.red(i), Color.green(i), Color.blue(i));
      locald.qxC.qsp.setBackgroundColor(i);
      AppMethodBeat.o(325055);
      return;
      label211:
      f = 100.0F - paramFloat;
      break;
      label222:
      paramFloat = 100.0F - paramFloat;
    }
  }
  
  protected final void c(u paramu, cb paramcb)
  {
    AppMethodBeat.i(324979);
    super.c(paramu, paramcb);
    com.tencent.mm.plugin.appbrand.widget.d.d locald = getRuntime().qvN;
    paramu = (ah)paramu.getCurrentPageView();
    s.u(paramu, "pageView");
    s.u(paramcb, "type");
    paramu = paramu.getRuntime();
    s.s(paramu, "runtime");
    if ((!com.tencent.mm.plugin.appbrand.widget.d.d.a(paramcb, paramu)) && (locald.cQc().qZZ))
    {
      paramu = locald.uDE;
      if (paramu != null) {
        paramu.a(com.tencent.mm.plugin.appbrand.widget.g.uxG);
      }
    }
    AppMethodBeat.o(324979);
  }
  
  protected com.tencent.mm.plugin.appbrand.report.model.h cBi()
  {
    AppMethodBeat.i(47813);
    com.tencent.mm.plugin.appbrand.report.model.b localb = new com.tencent.mm.plugin.appbrand.report.model.b(getRuntime());
    AppMethodBeat.o(47813);
    return localb;
  }
  
  public final boolean cEr()
  {
    AppMethodBeat.i(325062);
    Iterator localIterator = super.cEm();
    while (localIterator.hasNext()) {
      if (((u)localIterator.next() instanceof com.tencent.mm.plugin.appbrand.headless.b))
      {
        AppMethodBeat.o(325062);
        return true;
      }
    }
    AppMethodBeat.o(325062);
    return false;
  }
  
  protected final boolean cEs()
  {
    AppMethodBeat.i(325058);
    boolean bool = a.a.jlv().jls();
    AppMethodBeat.o(325058);
    return bool;
  }
  
  protected final void d(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(325042);
    super.d(paramcb, paramu1, paramu2);
    Log.i("MicroMsg.AppBrandPageContainerWC", "[onPageSwitchStart]");
    paramu1 = getRuntime().qvN;
    s.u(paramcb, "type");
    paramcb = paramu1.cQc();
    if ((paramcb.isEnable()) && (paramcb.qZO)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramu2 != null)) {
        paramu2.setForceDisableMeasureCache(true);
      }
      AppMethodBeat.o(325042);
      return;
    }
  }
  
  protected final void e(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(325048);
    super.e(paramcb, paramu1, paramu2);
    Log.i("MicroMsg.AppBrandPageContainerWC", "[onPageSwitchEnd]");
    if (getRuntime() == null)
    {
      AppMethodBeat.o(325048);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.d.d locald = getRuntime().qvN;
    s.u(paramcb, "type");
    if (com.tencent.mm.plugin.appbrand.widget.d.d.a(locald.qxC, paramcb))
    {
      paramcb = locald.qxC.getInitConfig();
      s.s(paramcb, "runtime.initConfig");
      paramcb = locald.a(paramu1, paramu2, paramcb);
      if (((Boolean)paramcb.bsC).booleanValue()) {
        locald.I(((Boolean)paramcb.bsD).booleanValue(), false);
      }
    }
    locald.cQb();
    if ((!TextUtils.isEmpty((CharSequence)locald.qxC.getInitConfig().qYy)) && (!locald.w(paramu1)) && (locald.v(paramu2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramcb = locald.qxC.qvO;
      if (paramcb == null) {
        break label249;
      }
      paramu1 = paramcb.qxC.getInitConfig();
      s.s(paramu1, "runtime.initConfig");
      paramcb.n(paramu1);
      AppMethodBeat.o(325048);
      return;
    }
    paramcb = locald.qxC.qvO;
    if (paramcb != null)
    {
      paramcb = paramcb.qxC;
      if (paramcb != null)
      {
        paramcb = paramcb.qsP;
        if (paramcb != null) {
          paramcb.cDQ();
        }
      }
    }
    label249:
    AppMethodBeat.o(325048);
  }
  
  protected boolean e(u paramu)
  {
    boolean bool2 = false;
    AppMethodBeat.i(325027);
    boolean bool3 = super.e(paramu);
    int j;
    label41:
    int k;
    label54:
    int m;
    label67:
    int i;
    if (!getRuntime().ccB())
    {
      bool1 = true;
      if (getRuntime().aqJ()) {
        break label155;
      }
      j = 1;
      if (com.tencent.mm.plugin.appbrand.weishi.h.aD(getRuntime())) {
        break label161;
      }
      k = 1;
      if (bj.x(getRuntime())) {
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
      AppMethodBeat.o(325027);
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
  
  protected final void f(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(325051);
    super.f(paramcb, paramu1, paramu2);
    Log.i("MicroMsg.AppBrandPageContainerWC", "[onPageSwitchCancel]");
    com.tencent.mm.plugin.appbrand.widget.d.d locald = getRuntime().qvN;
    s.u(paramcb, "type");
    if (com.tencent.mm.plugin.appbrand.widget.d.d.a(locald.qxC, paramcb))
    {
      paramcb = locald.qxC.getInitConfig();
      s.s(paramcb, "runtime.initConfig");
      paramcb = locald.a(paramu1, paramu2, paramcb);
      if (((Boolean)paramcb.bsC).booleanValue()) {
        if (((Boolean)paramcb.bsD).booleanValue()) {
          break label118;
        }
      }
    }
    label118:
    for (boolean bool = true;; bool = false)
    {
      locald.I(bool, false);
      AppMethodBeat.o(325051);
      return;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.report.model.h getReporter()
  {
    return this.twq;
  }
  
  public w getRuntime()
  {
    AppMethodBeat.i(47815);
    w localw = (w)super.getRuntime();
    AppMethodBeat.o(47815);
    return localw;
  }
  
  public void init(String paramString)
  {
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
    if (!getRuntime().ccM().epz)
    {
      getRuntime();
      if (!w.qvw) {}
    }
    else
    {
      getRuntime().i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324843);
          y.this.cEp();
          AppMethodBeat.o(324843);
        }
      }, 10000L);
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      s.u(this, "pagecontainer");
      if (!(getRuntime() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l))
      {
        localsn = new sn();
        localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(getAppId());
        if (localQualitySessionRuntime != null) {
          break label235;
        }
        paramString = null;
        com.tencent.mm.plugin.appbrand.report.quality.d.a(paramString, s.X("Null session with ", getAppId()));
      }
    }
    finally
    {
      for (;;)
      {
        sn localsn;
        QualitySessionRuntime localQualitySessionRuntime;
        Log.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
      }
    }
    cEv();
    if ((com.tencent.mm.plugin.appbrand.weishi.h.aD(getRuntime())) && (this.twD != null)) {
      this.twD.alive();
    }
    AppMethodBeat.o(47816);
    return;
    label235:
    if (localQualitySessionRuntime.tSy > 0L)
    {
      localsn.ilM = localsn.F("InstanceId", localQualitySessionRuntime.eup, true);
      localsn.imT = localsn.F("AppId", localQualitySessionRuntime.appId, true);
      localsn.ind = localQualitySessionRuntime.tSh;
      localsn.jyV = sn.a.oJ(localQualitySessionRuntime.tQx);
      localsn.jax = localQualitySessionRuntime.apptype;
      localsn.iqr = localQualitySessionRuntime.scene;
      localsn.fB(localQualitySessionRuntime.tSy);
      localsn.fC(Util.nowMilliSecond());
      localsn.fA(localsn.jyJ - localsn.jyI);
      paramString = getCurrentPage();
      if (paramString != null) {
        break label390;
      }
      paramString = null;
      if (!(paramString instanceof ah)) {
        break label398;
      }
    }
    label356:
    for (paramString = (ah)paramString;; paramString = null)
    {
      localsn.ixD = com.tencent.mm.plugin.appbrand.report.quality.d.z(paramString);
      localsn.bMH();
      paramString = kotlin.ah.aiuX;
      paramString = localQualitySessionRuntime;
      break;
      paramString = paramString.getCurrentPageView();
      break label356;
    }
  }
  
  public final Object n(u paramu)
  {
    AppMethodBeat.i(47829);
    paramu = AnimationUtils.loadAnimation(getContext(), ba.a.slide_right_in);
    AppMethodBeat.o(47829);
    return paramu;
  }
  
  public final Object o(u paramu)
  {
    AppMethodBeat.i(47830);
    paramu = AnimationUtils.loadAnimation(getContext(), ba.a.slide_left_out);
    AppMethodBeat.o(47830);
    return paramu;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(47817);
    if (this.twr != null)
    {
      this.twr.dismiss();
      this.twr = null;
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
      this.twq.e((ah)getCurrentPage().getCurrentPageView());
    }
    Object localObject1;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().asA().epn.scene == 1118) {
        if ((this.tws) && (!this.twt))
        {
          localObject1 = getCurrentPage().getCurrentPageView().cEE();
          if ((this.twy != null) && (this.twy.equals(localObject1)))
          {
            Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
            localObject1 = ((ah)getCurrentPage().getCurrentPageView()).txQ;
            if (localObject1 != null) {
              break label531;
            }
          }
        }
      }
    }
    label531:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.c)localObject1).cIJ())
    {
      this.twv = l;
      this.twt = true;
      this.twx = (System.currentTimeMillis() - this.tww);
      if ((this.tws) && (this.twt) && (getRuntime().asA().epn != null))
      {
        Log.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.twv), Long.valueOf(this.twx) });
        com.tencent.mm.plugin.appbrand.appusage.a.h.b(1, this.twv, this.twx, getRuntime().asA().epn.tOl);
      }
      if ((this.twu) && (getRuntime().asA().epn.scene == 1162) && (System.currentTimeMillis() - this.tww >= 3000L))
      {
        Object localObject2 = getRuntime().getInitConfig().qAQ;
        localObject1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).appId;
        int i = ((AppBrandLaunchFromNotifyReferrer)localObject2).qYz;
        String str1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).qYA;
        String str2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).content;
        int j = ((AppBrandLaunchFromNotifyReferrer)localObject2).qYB;
        localObject2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).qYC;
        if (!Util.nullAsNil(this.twz).equals(str1))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject1, null, null, str1, Integer.valueOf(0), null, str2, Integer.valueOf(i), null, null, localObject2 });
          this.twz = str1;
        }
      }
      getRuntime().qvN.uDF.onBackground();
      AppMethodBeat.o(47826);
      return;
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(47824);
    super.onDestroy();
    if (getPageCount() > 0) {
      this.twq.d((ah)getCurrentPage().getCurrentPageView());
    }
    if (this.twr != null)
    {
      this.twr.cleanup();
      this.twr = null;
    }
    if (this.twD != null) {
      this.twD.dead();
    }
    AppMethodBeat.o(47824);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47825);
    super.onForeground();
    if (getPageCount() > 0) {
      this.twq.f((ah)getCurrentPage().getCurrentPageView());
    }
    getRuntime().qsp.setBackgroundColor(0);
    cEv();
    com.tencent.mm.plugin.appbrand.widget.d.d locald = getRuntime().qvN;
    locald.cQb();
    locald.cQa();
    AppMethodBeat.o(47825);
  }
  
  protected final void onReady()
  {
    AppMethodBeat.i(47823);
    super.onReady();
    ReportStorageSizeTask localReportStorageSizeTask = new ReportStorageSizeTask();
    localReportStorageSizeTask.appId = getRuntime().mAppId;
    localReportStorageSizeTask.bQt();
    AppMethodBeat.o(47823);
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(47827);
    super.onViewAdded(paramView);
    if ((paramView instanceof u)) {
      ck.dE((u)paramView);
    }
    AppMethodBeat.o(47827);
  }
  
  public final Object p(u paramu)
  {
    AppMethodBeat.i(47831);
    paramu = AnimationUtils.loadAnimation(getContext(), ba.a.slide_left_in);
    AppMethodBeat.o(47831);
    return paramu;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(325036);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(325036);
      return false;
    }
    if ((!z.ay(this)) && (getRuntime() != null) && (getRuntime().asE()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(325036);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(325036);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(325039);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(325039);
      return false;
    }
    if ((!z.ay(this)) && (getRuntime() != null) && (getRuntime().asE()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(325039);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(325039);
    return bool;
  }
  
  public final Object q(u paramu)
  {
    AppMethodBeat.i(47832);
    paramu = AnimationUtils.loadAnimation(getContext(), ba.a.slide_right_out);
    AppMethodBeat.o(47832);
    return paramu;
  }
  
  public void setWAAutoWebViewJs(String paramString)
  {
    this.twC = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */