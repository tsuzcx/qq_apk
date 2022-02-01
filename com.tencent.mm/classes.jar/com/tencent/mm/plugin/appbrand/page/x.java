package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v4.view.u;
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
import com.tencent.mm.g.b.a.lw;
import com.tencent.mm.g.b.a.lw.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.appusage.a.i;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1;
import com.tencent.mm.plugin.appbrand.p.a.b;
import com.tencent.mm.plugin.appbrand.p.a.d;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.af;
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

@SuppressLint({"ViewConstructor"})
public class x
  extends w
  implements w.a
{
  private FrameLayout npY;
  private volatile f npZ;
  private l nqa;
  public boolean nqb;
  public boolean nqc;
  public boolean nqd;
  private long nqe;
  private long nqf;
  private long nqg;
  private String nqh;
  public String nqi;
  private final com.tencent.luggage.sdk.b.a.b.c nqj;
  public final Deque<ag> nqk;
  private String nql;
  private IListener<com.tencent.mm.plugin.appbrand.jsapi.video.c.a> nqm;
  private long nqn;
  
  static
  {
    AppMethodBeat.i(175032);
    com.tencent.mm.plugin.appbrand.p.e.c.ngP = new ModularizingPkgRetrieverWC.1();
    AppMethodBeat.o(175032);
  }
  
  public x(Context paramContext, q paramq)
  {
    super(paramContext, paramq);
    AppMethodBeat.i(47811);
    this.nqb = false;
    this.nqc = false;
    this.nqd = false;
    this.npZ = bOw();
    this.nqk = new LinkedList();
    this.nqm = new IListener() {};
    this.nqn = 0L;
    super.setDelegate(this);
    if (paramq.NA())
    {
      this.nqj = null;
      AppMethodBeat.o(47811);
      return;
    }
    this.nqj = new com.tencent.luggage.sdk.b.a.b.c(this);
    ab.ih(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXy, true));
    AppMethodBeat.o(47811);
  }
  
  public x(Context paramContext, q paramq, w.a parama)
  {
    super(paramContext, paramq);
    AppMethodBeat.i(47812);
    this.nqb = false;
    this.nqc = false;
    this.nqd = false;
    this.npZ = bOw();
    this.nqk = new LinkedList();
    this.nqm = new IListener() {};
    this.nqn = 0L;
    super.setDelegate(parama);
    if (paramq.NA())
    {
      this.nqj = null;
      AppMethodBeat.o(47812);
      return;
    }
    this.nqj = new com.tencent.luggage.sdk.b.a.b.c(this);
    this.nqj.cAn = com.tencent.mm.plugin.appbrand.xweb_ext.c.cdC();
    paramContext = this.nqj;
    if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.cdD()) {
      bool = true;
    }
    paramContext.cAo = bool;
    this.nqj.cAp = com.tencent.mm.plugin.appbrand.xweb_ext.c.cdB();
    AppMethodBeat.o(47812);
  }
  
  private void a(final String paramString, final bx parambx, final w.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(47819);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localh.dN(937, i);
      getRuntime().kAI.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(227274);
          switch (x.7.mfu[paramAnonymousd.ordinal()])
          {
          default: 
            AppMethodBeat.o(227274);
            return;
          case 1: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.h.CyF;
            if (paramBoolean) {}
            for (i = 6;; i = 2)
            {
              paramAnonymousd.dN(937, i);
              x.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(227269);
                  if (x.6.this.nqs) {
                    x.6.this.nqq.bQX();
                  }
                  x.6.this.nqq.proceed();
                  AppMethodBeat.o(227269);
                }
              });
              AppMethodBeat.o(227274);
              return;
            }
          case 2: 
            paramAnonymousd = com.tencent.mm.plugin.report.service.h.CyF;
            if (paramBoolean) {}
            for (i = 8;; i = 4)
            {
              paramAnonymousd.dN(937, i);
              x.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(227270);
                  if ((x.6.this.nqs) && (x.b(x.this) != null))
                  {
                    x.b(x.this).cancel();
                    x.a(x.this, null);
                  }
                  x.6.this.nqq.cancel();
                  AppMethodBeat.o(227270);
                }
              });
              AppMethodBeat.o(227274);
              return;
            }
          }
          paramAnonymousd = com.tencent.mm.plugin.report.service.h.CyF;
          if (paramBoolean) {}
          for (int i = 7;; i = 3)
          {
            paramAnonymousd.dN(937, i);
            x.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(227273);
                Object localObject1 = x.b(x.this);
                x.a(x.this, new l(x.this.getContext()));
                Object localObject2 = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(227271);
                    switch (paramAnonymous3Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(227271);
                      return;
                      x.a(x.this, x.6.this.val$url, x.6.this.npw, x.6.this.nqq);
                    }
                  }
                };
                x.b(x.this).setPositiveButton((DialogInterface.OnClickListener)localObject2);
                x.b(x.this).setNegativeButton((DialogInterface.OnClickListener)localObject2);
                localObject2 = x.b(x.this);
                Object localObject3 = x.this;
                Runnable local2 = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(227272);
                    if (this.nqv != null) {
                      this.nqv.bQE();
                    }
                    AppMethodBeat.o(227272);
                  }
                };
                p.h(localObject3, "pageContainer");
                ((l)localObject2).cAt = ((w)localObject3);
                ((w)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                ((l)localObject2).bringToFront();
                localObject3 = ((w)localObject3).getRuntime();
                if (localObject3 == null) {
                  p.hyc();
                }
                Object localObject4 = ((l)localObject2).kGn;
                com.tencent.mm.modelappbrand.a.b localb;
                if (localObject4 != null)
                {
                  localObject1 = ((AppBrandRuntime)localObject3).OU();
                  if (localObject1 != null)
                  {
                    localObject1 = ((AppBrandInitConfig)localObject1).brandName;
                    if (localObject1 != null)
                    {
                      localObject1 = (CharSequence)localObject1;
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setMainTitle((CharSequence)localObject1);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setBackgroundColor(0);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setForegroundStyle(true);
                      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).gz(true);
                    }
                  }
                }
                else
                {
                  localObject4 = ((l)localObject2).nok;
                  if (localObject4 != null)
                  {
                    localObject1 = new ColorMatrix();
                    ((ColorMatrix)localObject1).setSaturation(0.0F);
                    ((ImageView)localObject4).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
                    localb = com.tencent.mm.modelappbrand.a.b.aXY();
                    localObject1 = ((AppBrandRuntime)localObject3).OU();
                    if (localObject1 == null) {
                      break label388;
                    }
                  }
                }
                label388:
                for (localObject1 = ((AppBrandInitConfig)localObject1).iconUrl;; localObject1 = null)
                {
                  localb.a((ImageView)localObject4, (String)localObject1, com.tencent.mm.modelappbrand.a.a.aXX(), (b.h)com.tencent.mm.modelappbrand.a.g.iJB);
                  localObject1 = ((l)localObject2).noi;
                  if (localObject1 != null) {
                    ((Animation)localObject1).cancel();
                  }
                  ((l)localObject2).noi = AnimationUtils.loadAnimation(((l)localObject2).getContext(), MMFragmentActivity.a.ogm);
                  localObject1 = ((l)localObject2).noi;
                  if (localObject1 == null) {
                    p.hyc();
                  }
                  ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new l.d((l)localObject2, local2));
                  localObject1 = ((l)localObject2).noi;
                  if (localObject1 == null) {
                    p.hyc();
                  }
                  ((l)localObject2).startAnimation((Animation)localObject1);
                  AppMethodBeat.o(227273);
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
  
  private void bQY()
  {
    AppMethodBeat.i(47814);
    if (this.npY != null)
    {
      Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed");
      Object localObject = this.npY;
      q localq = getRuntime();
      localq.i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47801);
          this.nqp.setVisibility(8);
          if ((this.nqp.getParent() instanceof ViewGroup)) {
            ((ViewGroup)this.nqp.getParent()).removeView(this.nqp);
          }
          AppMethodBeat.o(47801);
        }
      }, 300L);
      this.npY = null;
      localObject = localq.brK();
      if ((localObject instanceof af))
      {
        Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed, hide");
        ((af)localObject).k(true, "");
      }
    }
    AppMethodBeat.o(47814);
  }
  
  private void bQZ()
  {
    AppMethodBeat.i(227278);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().ON().cyA.scene == 1118)
      {
        if (getRuntime().ON().cyA != null) {
          break label173;
        }
        localAppBrandRecommendStatObj = null;
        if (localAppBrandRecommendStatObj != null)
        {
          Log.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
          if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.nHf)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.nHg))) {
            break label190;
          }
          this.nqh = (localAppBrandRecommendStatObj.nHf + "?" + localAppBrandRecommendStatObj.nHg);
        }
      }
    }
    for (;;)
    {
      this.nqb = true;
      this.nqf = System.currentTimeMillis();
      if (getRuntime().ON().cyA.scene == 1162)
      {
        this.nqd = true;
        this.nqf = System.currentTimeMillis();
      }
      AppMethodBeat.o(227278);
      return;
      label173:
      localAppBrandRecommendStatObj = getRuntime().ON().cyA.nHv;
      break;
      label190:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.nHf)) {
        this.nqh = localAppBrandRecommendStatObj.nHf;
      } else {
        this.nqh = getRuntime().brs();
      }
    }
  }
  
  public final boolean MX()
  {
    return false;
  }
  
  public final t a(String paramString, bx parambx, w paramw, Callable<t> paramCallable)
  {
    return null;
  }
  
  protected final w.h a(t paramt1, t paramt2)
  {
    AppMethodBeat.i(175028);
    w.h localh = super.a(paramt1, paramt2);
    this.npZ.bOy();
    this.npZ.a((ag)paramt2.getCurrentPageView(), (ag)paramt1.getCurrentPageView(), bx.nuF);
    getRuntime().bsq().Uo(paramt2.getCurrentUrl());
    if (this.nqj != null)
    {
      com.tencent.luggage.sdk.b.a.b.c localc = this.nqj;
      p.h(paramt1, "out");
      p.h(paramt2, "in");
      localc.cAt.post((Runnable)new c.c(localc));
      paramt1 = paramt2.getCurrentPageView();
      if (paramt1 != null)
      {
        paramt1 = (e)paramt1.S(e.class);
        if (paramt1 != null) {
          paramt1.bLp();
        }
      }
    }
    AppMethodBeat.o(175028);
    return localh;
  }
  
  public final w.h a(t paramt1, t paramt2, bx parambx, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(227276);
    paramt1 = super.a(paramt1, paramt2, parambx, paramString, paramBoolean);
    this.nqn = System.currentTimeMillis();
    if (((paramt2 instanceof m)) && (bb.r(getRuntime())))
    {
      paramString = ((m)paramt2).getTabBar();
      if (paramString != null) {
        break label191;
      }
      Log.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.af.g.an(getRuntime()))
      {
        paramString = paramt2.getCurrentPageView();
        bQY();
      }
      try
      {
        paramString = paramString.noq;
        this.npY = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131493044, null));
        ImageView localImageView = (ImageView)this.npY.findViewById(2131309067);
        paramString.addView(this.npY, -1, new FrameLayout.LayoutParams(-1, -1));
        Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, showLaunchThumb");
        com.tencent.mm.plugin.appbrand.af.g.a(getRuntime(), localImageView, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47800);
            Object localObject = x.this.getRuntime();
            if (localObject == null)
            {
              AppMethodBeat.o(47800);
              return;
            }
            localObject = ((q)localObject).brK();
            if ((localObject instanceof af))
            {
              Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, hide");
              ((af)localObject).k(true, "");
            }
            AppMethodBeat.o(47800);
          }
        });
        if (this.nqj != null) {
          com.tencent.luggage.sdk.b.a.b.c.a(paramt2, parambx);
        }
        AppMethodBeat.o(227276);
        return paramt1;
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
          bQY();
        }
      }
    }
  }
  
  public final void a(t paramt1, t paramt2, bx parambx)
  {
    Object localObject = null;
    AppMethodBeat.i(47822);
    super.a(paramt1, paramt2, parambx);
    long l = System.currentTimeMillis() - this.nqn;
    this.npZ.a(l, parambx);
    Log.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    if (this.nqa != null)
    {
      this.nqa.bQE();
      this.nqa = null;
    }
    f localf = this.npZ;
    ag localag = (ag)paramt2.getCurrentPageView();
    if (paramt1 == null)
    {
      localf.a(localag, (ag)localObject, parambx);
      getRuntime().bsq().Uo(paramt2.getCurrentUrl());
      if (this.nqj != null)
      {
        localObject = this.nqj;
        p.h(paramt2, "in");
        p.h(parambx, "type");
        if (bx.nuE != parambx) {
          break label481;
        }
        ((com.tencent.luggage.sdk.b.a.b.c)localObject).a(parambx);
      }
    }
    for (;;)
    {
      try
      {
        if (((com.tencent.luggage.sdk.b.a.b.c)localObject).cAt.getPageCount() > ((com.tencent.luggage.sdk.b.a.b.c)localObject).cAn) {
          paramt2.af((Runnable)new com.tencent.luggage.sdk.b.a.b.d((kotlin.g.a.a)new c.e((com.tencent.luggage.sdk.b.a.b.c)localObject)));
        }
        paramt2 = paramt2.getCurrentPageView();
        if (paramt2 != null)
        {
          paramt2 = (e)paramt2.S(e.class);
          if (paramt2 != null) {
            paramt2.bLp();
          }
        }
        if ((bx.nuK != parambx) && (bx.nuE != parambx)) {
          ((com.tencent.luggage.sdk.b.a.b.c)localObject).cAt.post((Runnable)new c.d((com.tencent.luggage.sdk.b.a.b.c)localObject, parambx));
        }
        if ((paramt1 != null) && (parambx == bx.nuE) && (getRuntime().ON().cyA.scene == 1118) && (this.nqb) && (!this.nqc))
        {
          if (paramt1.getCurrentPageView() != null) {
            break label496;
          }
          paramt2 = "";
          if ((this.nqh != null) && (this.nqh.equals(paramt2)))
          {
            Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
            this.nqe = ((ag)paramt1.getCurrentPageView()).nrs.bUE();
            this.nqc = true;
          }
        }
        AppMethodBeat.o(47822);
        return;
        localObject = (ag)paramt1.getCurrentPageView();
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject).appId + "] type[" + parambx + "] maxKeepPageCount[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject).cAn + "] keepInvisbileTabbarPagesActive[" + ((com.tencent.luggage.sdk.b.a.b.c)localObject).cAo + ']', new Object[0]);
        continue;
      }
      label481:
      if (bx.nuK == parambx)
      {
        ((com.tencent.luggage.sdk.b.a.b.c)localObject).Oc();
        continue;
        label496:
        paramt2 = paramt1.getCurrentPageView().nna;
      }
    }
  }
  
  public final boolean a(String paramString, bx parambx, w paramw, final w.d paramd)
  {
    AppMethodBeat.i(47818);
    paramw = getRuntime().kAI;
    if (!paramw.bPn()) {
      paramw.a(paramString, new a.b()
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(47809);
          x.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47804);
              x.5.this.nqq.proceed();
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
      a(paramString, parambx, paramd, false);
    }
  }
  
  protected f bOw()
  {
    AppMethodBeat.i(47813);
    com.tencent.mm.plugin.appbrand.report.model.a locala = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
    AppMethodBeat.o(47813);
    return locala;
  }
  
  public ag bOx()
  {
    AppMethodBeat.i(175030);
    for (;;)
    {
      synchronized (this.nqk)
      {
        ag localag1 = (ag)this.nqk.pollFirst();
        if (localag1 != null)
        {
          bool = true;
          Log.i("MicroMsg.AppBrandPageContainerWC", "onCreatePageView preloaded[%b] appId[%s]", new Object[] { Boolean.valueOf(bool), getAppId() });
          if (TextUtils.isEmpty(this.nql)) {
            break label121;
          }
          if (!(localag1 instanceof bs)) {
            break;
          }
          AppMethodBeat.o(175030);
          return localag1;
        }
      }
      boolean bool = false;
    }
    ??? = new bs(this.nql);
    AppMethodBeat.o(175030);
    return ???;
    label121:
    if (localag2 != null)
    {
      AppMethodBeat.o(175030);
      return localag2;
    }
    ??? = new ag();
    AppMethodBeat.o(175030);
    return ???;
  }
  
  protected boolean e(t paramt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(227277);
    boolean bool3 = super.e(paramt);
    int j;
    label41:
    int k;
    label54:
    int m;
    label67:
    int i;
    if (!getRuntime().bsr())
    {
      bool1 = true;
      if (getRuntime().NA()) {
        break label155;
      }
      j = 1;
      if (com.tencent.mm.plugin.appbrand.af.g.an(getRuntime())) {
        break label161;
      }
      k = 1;
      if (bb.r(getRuntime())) {
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
      Log.i("MicroMsg.AppBrandPageContainerWC", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition", new Object[] { paramt.getAppId(), paramt.getCurrentUrl(), Integer.valueOf(i) });
    }
    label155:
    label161:
    label167:
    label173:
    label180:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      AppMethodBeat.o(227277);
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
  
  public f getReporter()
  {
    return this.npZ;
  }
  
  public q getRuntime()
  {
    AppMethodBeat.i(47815);
    q localq = (q)super.getRuntime();
    AppMethodBeat.o(47815);
    return localq;
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
    if (!getRuntime().bsB().cyC)
    {
      getRuntime();
      if (!q.kDg) {}
    }
    else
    {
      getRuntime().i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227268);
          x.this.bQV();
          AppMethodBeat.o(227268);
        }
      }, 10000L);
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
        p.h(this, "pagecontainer");
        if ((getRuntime() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l)) {
          continue;
        }
        locallw = new lw();
        localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
        paramString = localObject2;
        if (localQualitySessionRuntime == null) {
          continue;
        }
        if (localQualitySessionRuntime.nLB <= 0L) {
          continue;
        }
        locallw.eWb = locallw.x("InstanceId", localQualitySessionRuntime.kEY, true);
        locallw.eJx = locallw.x("AppId", localQualitySessionRuntime.appId, true);
        locallw.eXc = localQualitySessionRuntime.nLk;
        locallw.faq = lw.a.mi(localQualitySessionRuntime.nJE);
        locallw.eYW = localQualitySessionRuntime.apptype;
        locallw.erW = localQualitySessionRuntime.scene;
        locallw.vr(localQualitySessionRuntime.nLB);
        locallw.vs(Util.nowMilliSecond());
        locallw.vq(locallw.fae - locallw.fad);
        paramString = getCurrentPage();
        if (paramString == null) {
          continue;
        }
        paramString = paramString.getCurrentPageView();
        if ((paramString instanceof ag)) {
          continue;
        }
        paramString = localObject1;
      }
      catch (Throwable paramString)
      {
        lw locallw;
        QualitySessionRuntime localQualitySessionRuntime;
        Log.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
        continue;
        continue;
        paramString = localQualitySessionRuntime;
        continue;
      }
      locallw.evl = com.tencent.mm.plugin.appbrand.report.quality.d.z((ag)paramString);
      locallw.bfK();
      continue;
      com.tencent.mm.plugin.appbrand.report.quality.d.a(paramString, "Null session with " + getAppId());
      bQZ();
      if ((com.tencent.mm.plugin.appbrand.af.g.an(getRuntime())) && (this.nqm != null)) {
        this.nqm.alive();
      }
      AppMethodBeat.o(47816);
      return;
      paramString = null;
    }
  }
  
  public final Object m(t paramt)
  {
    AppMethodBeat.i(47829);
    paramt = AnimationUtils.loadAnimation(getContext(), 2130772169);
    AppMethodBeat.o(47829);
    return paramt;
  }
  
  public final Object n(t paramt)
  {
    AppMethodBeat.i(47830);
    paramt = AnimationUtils.loadAnimation(getContext(), 2130772166);
    AppMethodBeat.o(47830);
    return paramt;
  }
  
  public final Object o(t paramt)
  {
    AppMethodBeat.i(47831);
    paramt = AnimationUtils.loadAnimation(getContext(), 2130772165);
    AppMethodBeat.o(47831);
    return paramt;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(47817);
    if (this.nqa != null)
    {
      this.nqa.dismiss();
      this.nqa = null;
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
      this.npZ.d((ag)getCurrentPage().getCurrentPageView());
    }
    Object localObject1;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null)) {
      if (getRuntime().ON().cyA.scene == 1118) {
        if ((this.nqb) && (!this.nqc))
        {
          localObject1 = getCurrentPage().getCurrentPageView().nna;
          if ((this.nqh != null) && (this.nqh.equals(localObject1)))
          {
            Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
            localObject1 = ((ag)getCurrentPage().getCurrentPageView()).nrs;
            if (localObject1 != null) {
              break label516;
            }
          }
        }
      }
    }
    label516:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject1).bUE())
    {
      this.nqe = l;
      this.nqc = true;
      this.nqg = (System.currentTimeMillis() - this.nqf);
      if ((this.nqb) && (this.nqc) && (getRuntime().ON().cyA != null))
      {
        Log.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.nqe), Long.valueOf(this.nqg) });
        i.b(1, this.nqe, this.nqg, getRuntime().ON().cyA.nHv);
      }
      if ((this.nqd) && (getRuntime().ON().cyA.scene == 1162) && (System.currentTimeMillis() - this.nqf >= 3000L))
      {
        Object localObject2 = getRuntime().bsC().kHI;
        localObject1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).appId;
        int i = ((AppBrandLaunchFromNotifyReferrer)localObject2).lej;
        String str1 = ((AppBrandLaunchFromNotifyReferrer)localObject2).lek;
        String str2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).content;
        int j = ((AppBrandLaunchFromNotifyReferrer)localObject2).lel;
        localObject2 = ((AppBrandLaunchFromNotifyReferrer)localObject2).lem;
        if (!Util.nullAsNil(this.nqi).equals(str1))
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject1, null, null, str1, Integer.valueOf(0), null, str2, Integer.valueOf(i), null, null, localObject2 });
          this.nqi = str1;
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
      this.npZ.c((ag)getCurrentPage().getCurrentPageView());
    }
    if (this.nqa != null)
    {
      this.nqa.cleanup();
      this.nqa = null;
    }
    if (this.nqm != null) {
      this.nqm.dead();
    }
    AppMethodBeat.o(47824);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47825);
    super.onForeground();
    if (getPageCount() > 0) {
      this.npZ.e((ag)getCurrentPage().getCurrentPageView());
    }
    bQZ();
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
    if ((paramView instanceof t)) {
      cb.cE((t)paramView);
    }
    AppMethodBeat.o(47827);
  }
  
  public final Object p(t paramt)
  {
    AppMethodBeat.i(47832);
    paramt = AnimationUtils.loadAnimation(getContext(), 2130772170);
    AppMethodBeat.o(47832);
    return paramt;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(227279);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(227279);
      return false;
    }
    if ((!u.aD(this)) && (getRuntime() != null) && (getRuntime().OS()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(227279);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(227279);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(227280);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(227280);
      return false;
    }
    if ((!u.aD(this)) && (getRuntime() != null) && (getRuntime().OS()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(227280);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(227280);
    return bool;
  }
  
  public void setWAAutoWebViewJs(String paramString)
  {
    this.nql = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */