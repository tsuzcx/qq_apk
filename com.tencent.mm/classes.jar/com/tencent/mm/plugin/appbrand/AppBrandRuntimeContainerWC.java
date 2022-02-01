package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.game.a.v;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.page.ch;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.report.quality.a.a;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ah;

public class AppBrandRuntimeContainerWC
  extends com.tencent.luggage.sdk.e.b
{
  private boolean quu;
  private final Class<?>[] quv;
  
  static
  {
    AppMethodBeat.i(43852);
    x.a.a(g.tfQ);
    AppMethodBeat.o(43852);
  }
  
  public AppBrandRuntimeContainerWC(p paramp)
  {
    super(paramp, w.class);
    AppMethodBeat.i(43841);
    this.quu = false;
    this.quv = new Class[] { com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.class };
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext();
      if (com.tencent.mm.plugin.appbrand.widget.input.a.cQz()) {
        r.b(AndroidContextUtil.castActivityOrNull(this.mContext), AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getDecorView());
      }
    }
    if (Build.VERSION.SDK_INT >= 26) {
      this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(174649);
          Object localObject;
          if (androidx.core.g.z.ay(AppBrandRuntimeContainerWC.this.mContentView))
          {
            localObject = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainerWC.this.mContext);
            if ((localObject != null) && (((Activity)localObject).getWindow() != null))
            {
              bool = bb.aAF(((Activity)localObject).getWindow().getNavigationBarColor());
              localObject = ((Activity)localObject).getWindow();
              if (bool) {
                break label73;
              }
            }
          }
          label73:
          for (boolean bool = true;; bool = false)
          {
            aw.d((Window)localObject, bool);
            AppMethodBeat.o(174649);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(43841);
  }
  
  public static void a(w paramw, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(316661);
    paramw.c(paramAppBrandInitConfigWC);
    paramw.cbq();
    AppMethodBeat.o(316661);
  }
  
  private static void c(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180171);
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(180171);
      return;
    }
    paramConfiguration.uiMode &= 0xFFFFFFCF;
    if (!aw.isDarkMode()) {}
    for (paramConfiguration.uiMode |= 0x10;; paramConfiguration.uiMode |= 0x20)
    {
      MMApplicationContext.getContext().getResources().updateConfiguration(paramConfiguration, MMApplicationContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(180171);
      return;
    }
  }
  
  private void ccr()
  {
    AppMethodBeat.i(43845);
    if (((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) && (((Boolean)v.rqA.boF()).booleanValue())) {
      com.tencent.mm.ui.base.b.bZ(AndroidContextUtil.castActivityOrNull(this.mContext));
    }
    AppMethodBeat.o(43845);
  }
  
  private void f(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43843);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(43843);
      return;
    }
    int i;
    if (((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).aqJ()))
    {
      i = 1;
      if (i == 0) {
        break label140;
      }
    }
    label140:
    for (paramAppBrandInitConfig = aa.ek(this.mContentView);; paramAppBrandInitConfig = com.tencent.luggage.game.widget.input.a.cQ(this.mContentView))
    {
      if ((paramAppBrandInitConfig != null) && ((paramAppBrandInitConfig.getParent() instanceof ViewGroup)))
      {
        paramAppBrandInitConfig.hide();
        ((ViewGroup)paramAppBrandInitConfig.getParent()).removeView(paramAppBrandInitConfig);
      }
      if (i != 0) {
        break label168;
      }
      try
      {
        ((Activity)Objects.requireNonNull(AndroidContextUtil.castActivityOrNull(this.mContext))).getWindow().setSoftInputMode(16);
        paramAppBrandInitConfig = com.tencent.mm.plugin.appbrand.widget.input.n.Q(AndroidContextUtil.castActivityOrNull(this.mContext)).getOnLayoutListener();
        if ((paramAppBrandInitConfig instanceof com.tencent.mm.plugin.appbrand.widget.input.u)) {
          ((com.tencent.mm.plugin.appbrand.widget.input.u)paramAppBrandInitConfig).Ep(1);
        }
        AppMethodBeat.o(43843);
        return;
      }
      catch (Exception paramAppBrandInitConfig)
      {
        Log.e("MicroMsg.AppBrandRuntimeContainerWC", "removeUnmatchedSoftInputPanel, fix SoftInputMode for MiniProgram, get exception:%s", new Object[] { paramAppBrandInitConfig });
      }
      i = 0;
      break;
    }
    label168:
    AppMethodBeat.o(43843);
  }
  
  public static void f(w paramw)
  {
    AppMethodBeat.i(316666);
    paramw.dispatchPause();
    AppMethodBeat.o(316666);
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(316723);
    super.a(paramInt, paramAppBrandRuntime);
    if ((((w)paramAppBrandRuntime).getInitConfig().qAT.isEnable()) && (y(paramAppBrandRuntime) == null))
    {
      com.tencent.mm.ui.base.b.a(AndroidContextUtil.castActivityOrNull(this.mContext), null);
      AppMethodBeat.o(316723);
      return;
    }
    if ((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) {
      com.tencent.mm.ui.base.b.bZ(AndroidContextUtil.castActivityOrNull(this.mContext));
    }
    AppMethodBeat.o(316723);
  }
  
  public final void a(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(43842);
    super.a(paramLayoutParams);
    int j;
    if ((AndroidContextUtil.castActivityOrNull(this.mContext) != null) && (AndroidContextUtil.castActivityOrNull(this.mContext).getWindow() != null))
    {
      paramLayoutParams = AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getDecorView();
      if ((paramLayoutParams.getWindowSystemUiVisibility() & 0x2) == 0)
      {
        paramLayoutParams = paramLayoutParams.getBackground();
        if ((paramLayoutParams instanceof r))
        {
          paramLayoutParams = (r)paramLayoutParams;
          j = AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getNavigationBarColor();
          if (j == paramLayoutParams.uxT) {
            break label118;
          }
        }
      }
    }
    label118:
    for (int i = 1;; i = 0)
    {
      paramLayoutParams.uxT = j;
      if (i != 0) {
        paramLayoutParams.invalidateSelf();
      }
      AppMethodBeat.o(43842);
      return;
    }
  }
  
  public final void a(AppBrandRuntimeContainerWC.a parama)
  {
    AppMethodBeat.i(316704);
    d locald1 = (d)getActiveRuntime();
    Iterator localIterator = cci();
    d locald2;
    if ((localIterator.hasNext()) && (l.a(this)))
    {
      Log.i("MicroMsg.AppBrandRuntimeContainerWC", "stashPersistentRuntimesWhenActivityMayDestroy hash[%d], reason[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      for (;;)
      {
        if (localIterator.hasNext())
        {
          locald2 = (d)localIterator.next();
          if ((locald2.mInitialized) && (!locald2.qsE.get()) && (!locald2.ccV) && (!org.apache.commons.c.a.contains(this.quv, locald2.getClass()))) {
            if ((parama != AppBrandRuntimeContainerWC.a.quA) || (locald2 != locald1)) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if ((y.raT == locald2.asA().aqH()) || (com.tencent.mm.plugin.appbrand.config.z.raW == locald2.asA().aqE())) {
          break label491;
        }
        if (!((com.tencent.mm.plugin.appbrand.page.u)Objects.requireNonNull(locald2.getPageContainer().getCurrentPage())).mSwiping) {
          continue;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject1;
        FrameLayout.LayoutParams localLayoutParams;
        Bitmap localBitmap;
        Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", localNullPointerException, "stashPersistentRuntimesWhenActivityMayDestroy", new Object[0]);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", localOutOfMemoryError, "stashPersistentRuntimesWhenActivityMayDestroy", new Object[0]);
        continue;
        Object localObject2 = null;
        continue;
      }
      if (i == 0)
      {
        localObject1 = new FrameLayout(getContext());
        i = 81;
        if (locald2.qsk.getLayoutParams() != null) {
          i = ((FrameLayout.LayoutParams)locald2.qsk.getLayoutParams()).gravity;
        }
        localLayoutParams = new FrameLayout.LayoutParams(locald2.qsk.getWidth(), locald2.qsk.getHeight(), i);
        localBitmap = ch.dD(locald2.qsk);
        ((FrameLayout)localObject1).setBackground(new BitmapDrawable(getContext().getResources(), localBitmap));
        ((FrameLayout)localObject1).setWillNotDraw(false);
        this.mContentView.addView((View)localObject1, localLayoutParams);
        this.mContentView.bringChildToFront((View)localObject1);
      }
      if ((locald2.asA() instanceof AppBrandInitConfigWC))
      {
        localObject1 = ((AppBrandInitConfigWC)locald2.asA()).qYw;
        if (localObject1 != null) {
          ((WeAppOpenUICallbackIPCProxy)localObject1).tcL = true;
        }
        if (locald2.mResumed) {
          locald2.dispatchPause();
        }
        if (localObject1 != null)
        {
          ((WeAppOpenUICallbackIPCProxy)localObject1).tcL = false;
          ((WeAppOpenUICallbackIPCProxy)localObject1).ka(true);
        }
        localObject1 = locald2.qsk;
        if ((((View)localObject1).getParent() instanceof ViewGroup)) {
          ((ViewGroup)((View)localObject1).getParent()).removeView((View)localObject1);
        }
        F(locald2);
        ((w)locald2).hX(false);
        ((w)locald2).a(w.b.qwx);
        n.c((w)locald2);
        break;
        i = 0;
        continue;
      }
      AppMethodBeat.o(316704);
      return;
      label491:
      int i = 1;
    }
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(43846);
    if (getStackSize() <= 0)
    {
      cR(false);
      AppMethodBeat.o(43846);
      return true;
    }
    AppMethodBeat.o(43846);
    return false;
  }
  
  public final void b(final AppBrandRuntime paramAppBrandRuntime1, final AppBrandRuntime paramAppBrandRuntime2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(43844);
    paramAppBrandRuntime1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316867);
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(316892);
            AppBrandRuntimeContainerWC.6.this.evt.run();
            if ((AppBrandRuntimeContainerWC.this.getActiveRuntime() != null) && (!AppBrandRuntimeWCAccessible.isGame(AppBrandRuntimeContainerWC.this.getActiveRuntime()))) {
              AppBrandRuntimeContainerWC.b(AppBrandRuntimeContainerWC.this);
            }
            AppMethodBeat.o(316892);
          }
        };
        AppBrandRuntimeContainerWC.a(AppBrandRuntimeContainerWC.this, paramAppBrandRuntime1, paramAppBrandRuntime2, local1);
        AppMethodBeat.o(316867);
      }
    };
    if (!((w)paramAppBrandRuntime2).qvP.a(paramAppBrandRuntime2, true, paramAppBrandRuntime1)) {
      paramAppBrandRuntime1.run();
    }
    AppMethodBeat.o(43844);
  }
  
  public final void cR(boolean paramBoolean)
  {
    AppMethodBeat.i(43847);
    if (this.quu)
    {
      Log.i("MicroMsg.AppBrandRuntimeContainerWC", "closeActivity(%b), mKeepActivityFrontOnce=TRUE", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(43847);
      return;
    }
    AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
    super.cR(paramBoolean);
    if (((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) && (AndroidContextUtil.castActivityOrNull(this.mContext).isFinishing()))
    {
      if (localAppBrandRuntime != null) {}
      try
      {
        if (localAppBrandRuntime.getPageContainer().getCurrentPage().mSwiping) {
          AndroidContextUtil.castActivityOrNull(this.mContext).overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(43847);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", localNullPointerException, "closeActivity", new Object[0]);
      }
    }
    AppMethodBeat.o(43847);
  }
  
  public final void ccs()
  {
    AppMethodBeat.i(316728);
    Iterator localIterator = ccj().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (d)localIterator.next();
      if ((localObject1 instanceof w))
      {
        localObject1 = (w)localObject1;
        if (((w)localObject1).qvR != null)
        {
          Object localObject2 = ((w)localObject1).qvR;
          localObject1 = new com.tencent.mm.autogen.mmdata.rpt.s();
          Object localObject3 = ((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).tRg;
          if (localObject3 == null)
          {
            l = -1L;
            label89:
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ilG = l;
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ki(((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).appId);
            localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.tRi;
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).kj(a.a.getFlags());
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ilI = 2L;
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).kk(((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).sessionId);
            if (((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).tRh != null) {
              break label200;
            }
          }
          for (long l = 0L;; l -= ((Long)localObject2).longValue())
          {
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ilH = l;
            Log.d("MicroMsg.kv_21804", kotlin.g.b.s.X("onFinishReport: process[%s]", ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).aIF()), new Object[] { MMApplicationContext.getProcessName() });
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).bMH();
            break;
            l = ((Long)localObject3).longValue();
            break label89;
            label200:
            l = System.currentTimeMillis();
            localObject2 = ((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).tRh;
            kotlin.g.b.s.checkNotNull(localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(316728);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(316683);
    Iterator localIterator = ccj().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (d)localIterator.next();
      if ((localObject1 instanceof w))
      {
        localObject1 = (w)localObject1;
        if (((w)localObject1).qvR != null)
        {
          Object localObject2 = ((w)localObject1).qvR;
          localObject1 = new com.tencent.mm.autogen.mmdata.rpt.s();
          Object localObject3 = ((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).tRg;
          if (localObject3 == null)
          {
            l = -1L;
            label89:
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ilG = l;
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ki(((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).appId);
            localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.tRi;
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).kj(a.a.getFlags());
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ilI = 1L;
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).kk(((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).sessionId);
            if (((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).tRh != null) {
              break label198;
            }
          }
          for (long l = 0L;; l -= ((Long)localObject2).longValue())
          {
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).ilH = l;
            Log.d("MicroMsg.kv_21804", kotlin.g.b.s.X("onDestroyReport: process[%s]", ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).aIF()), new Object[] { MMApplicationContext.getProcessName() });
            ((com.tencent.mm.autogen.mmdata.rpt.s)localObject1).bMH();
            break;
            l = ((Long)localObject3).longValue();
            break label89;
            label198:
            l = System.currentTimeMillis();
            localObject2 = ((com.tencent.mm.plugin.appbrand.report.model.u)localObject2).tRh;
            kotlin.g.b.s.checkNotNull(localObject2);
          }
        }
      }
    }
    super.cleanup();
    if ((getContext() instanceof com.tencent.mm.plugin.appbrand.ui.o)) {
      ((com.tencent.mm.plugin.appbrand.ui.o)getContext()).setBaseContext(MMApplicationContext.getContext());
    }
    super.bm(MMApplicationContext.getContext());
    AppMethodBeat.o(316683);
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(180170);
    c(paramConfiguration);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316870);
        AppBrandRuntimeContainerWC.d(paramConfiguration);
        AppMethodBeat.o(316870);
      }
    });
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(180170);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(316733);
    super.onStop();
    Object localObject1 = (d)getActiveRuntime();
    if ((localObject1 != null) && (com.tencent.mm.plugin.appbrand.k.a.a.I((w)localObject1)))
    {
      Object localObject2 = com.tencent.mm.plugin.appbrand.k.a.a.H((w)localObject1);
      if (localObject2 != null)
      {
        localObject2 = ((w)localObject2).qvP;
        localObject1 = ((AppBrandRuntime)localObject1).mAppId;
        kotlin.g.b.s.u(localObject1, "currentEmbedWxaAppId");
        Log.i("MicroMsg.EmbedHalfScreenWxaManager", "[onStop] mark down embedded wxa appid for re-show when host back to the front");
        ((al)localObject2).qxD = ((String)localObject1);
      }
    }
    AppMethodBeat.o(316733);
  }
  
  public void setWindowDescription(c.a parama)
  {
    AppMethodBeat.i(174652);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(174652);
      return;
    }
    if (((localActivity instanceof AppBrandUI)) && (((AppBrandUI)localActivity).ccf())) {
      super.setWindowDescription(parama);
    }
    AppMethodBeat.o(174652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC
 * JD-Core Version:    0.7.0.1
 */