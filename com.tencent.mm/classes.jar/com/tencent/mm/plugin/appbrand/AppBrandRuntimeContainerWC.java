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
import androidx.core.g.w;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.page.cd;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.report.model.r;
import com.tencent.mm.plugin.appbrand.report.quality.a.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;

public class AppBrandRuntimeContainerWC
  extends com.tencent.luggage.sdk.e.b
{
  private boolean nvI;
  private final Class[] nvJ;
  
  static
  {
    AppMethodBeat.i(43852);
    u.a.a(g.qaK);
    AppMethodBeat.o(43852);
  }
  
  public AppBrandRuntimeContainerWC(com.tencent.mm.plugin.appbrand.task.q paramq)
  {
    super(paramq, t.class);
    AppMethodBeat.i(43841);
    this.nvI = false;
    this.nvJ = new Class[] { com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.class };
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext();
      if (com.tencent.mm.plugin.appbrand.widget.input.a.cnX()) {
        com.tencent.mm.plugin.appbrand.widget.o.a(AndroidContextUtil.castActivityOrNull(this.mContext), AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getDecorView());
      }
    }
    if (Build.VERSION.SDK_INT >= 26) {
      this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(174649);
          Object localObject;
          if (w.al(AppBrandRuntimeContainerWC.this.mContentView))
          {
            localObject = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainerWC.this.mContext);
            if ((localObject != null) && (((Activity)localObject).getWindow() != null))
            {
              bool = au.auk(((Activity)localObject).getWindow().getNavigationBarColor());
              localObject = ((Activity)localObject).getWindow();
              if (bool) {
                break label73;
              }
            }
          }
          label73:
          for (boolean bool = true;; bool = false)
          {
            ar.e((Window)localObject, bool);
            AppMethodBeat.o(174649);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(43841);
  }
  
  private static void a(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180171);
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(180171);
      return;
    }
    paramConfiguration.uiMode &= 0xFFFFFFCF;
    if (!ar.isDarkMode()) {}
    for (paramConfiguration.uiMode |= 0x10;; paramConfiguration.uiMode |= 0x20)
    {
      MMApplicationContext.getContext().getResources().updateConfiguration(paramConfiguration, MMApplicationContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(180171);
      return;
    }
  }
  
  private void bDe()
  {
    AppMethodBeat.i(43845);
    if (((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.u.omQ.aUb()).booleanValue())) {
      com.tencent.mm.ui.base.b.bv(AndroidContextUtil.castActivityOrNull(this.mContext));
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
    if (((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).Qv()))
    {
      i = 1;
      if (i == 0) {
        break label140;
      }
    }
    label140:
    for (paramAppBrandInitConfig = aa.dw(this.mContentView);; paramAppBrandInitConfig = com.tencent.luggage.game.widget.input.a.cv(this.mContentView))
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
        paramAppBrandInitConfig = com.tencent.mm.plugin.appbrand.widget.input.n.I(AndroidContextUtil.castActivityOrNull(this.mContext)).getOnLayoutListener();
        if ((paramAppBrandInitConfig instanceof com.tencent.mm.plugin.appbrand.widget.input.u)) {
          ((com.tencent.mm.plugin.appbrand.widget.input.u)paramAppBrandInitConfig).DP(1);
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
  
  public final boolean Se()
  {
    AppMethodBeat.i(43846);
    if (getStackSize() <= 0)
    {
      cl(false);
      AppMethodBeat.o(43846);
      return true;
    }
    AppMethodBeat.o(43846);
    return false;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(277536);
    super.a(paramInt, paramAppBrandRuntime);
    if (((t)paramAppBrandRuntime).bDy().nBE.isEnable())
    {
      com.tencent.mm.ui.base.b.a(AndroidContextUtil.castActivityOrNull(this.mContext), null);
      AppMethodBeat.o(277536);
      return;
    }
    if ((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) {
      com.tencent.mm.ui.base.b.bv(AndroidContextUtil.castActivityOrNull(this.mContext));
    }
    AppMethodBeat.o(277536);
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
        if ((paramLayoutParams instanceof com.tencent.mm.plugin.appbrand.widget.o))
        {
          paramLayoutParams = (com.tencent.mm.plugin.appbrand.widget.o)paramLayoutParams;
          j = AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getNavigationBarColor();
          if (j == paramLayoutParams.rnY) {
            break label118;
          }
        }
      }
    }
    label118:
    for (int i = 1;; i = 0)
    {
      paramLayoutParams.rnY = j;
      if (i != 0) {
        paramLayoutParams.invalidateSelf();
      }
      AppMethodBeat.o(43842);
      return;
    }
  }
  
  public final void a(AppBrandRuntimeContainerWC.a parama)
  {
    AppMethodBeat.i(277529);
    com.tencent.luggage.sdk.e.d locald1 = (com.tencent.luggage.sdk.e.d)getActiveRuntime();
    Iterator localIterator = bCV();
    if ((localIterator.hasNext()) && (l.a(this)))
    {
      Log.i("MicroMsg.AppBrandRuntimeContainerWC", "stashPersistentRuntimesWhenActivityMayDestroy hash[%d], reason[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      for (;;)
      {
        if (localIterator.hasNext())
        {
          com.tencent.luggage.sdk.e.d locald2 = (com.tencent.luggage.sdk.e.d)localIterator.next();
          if ((!locald2.mInitialized) || (locald2.ntU.get()) || (locald2.aol) || (org.apache.commons.b.a.contains(this.nvJ, locald2.getClass()))) {
            continue;
          }
          if ((parama == AppBrandRuntimeContainerWC.a.nvN) && (locald2 == locald1)) {}
          try
          {
            Object localObject1;
            if (!locald2.bBX().getCurrentPage().mSwiping)
            {
              localObject1 = new FrameLayout(getContext());
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locald2.ntC.getWidth(), locald2.ntC.getHeight(), 81);
              Bitmap localBitmap = cd.cW(locald2.ntC);
              ((FrameLayout)localObject1).setBackground(new BitmapDrawable(getContext().getResources(), localBitmap));
              ((FrameLayout)localObject1).setWillNotDraw(false);
              this.mContentView.addView((View)localObject1, localLayoutParams);
              this.mContentView.bringChildToFront((View)localObject1);
            }
            if ((locald2.Sk() instanceof AppBrandInitConfigWC))
            {
              localObject1 = ((AppBrandInitConfigWC)locald2.Sk()).nYv;
              if (localObject1 != null) {
                ((WeAppOpenUICallbackIPCProxy)localObject1).pXQ = true;
              }
              if (locald2.mResumed) {
                locald2.dispatchPause();
              }
              if (localObject1 != null)
              {
                ((WeAppOpenUICallbackIPCProxy)localObject1).pXQ = false;
                ((WeAppOpenUICallbackIPCProxy)localObject1).iT(true);
              }
              localObject1 = locald2.ntC;
              if ((((View)localObject1).getParent() instanceof ViewGroup)) {
                ((ViewGroup)((View)localObject1).getParent()).removeView((View)localObject1);
              }
              D(locald2);
              ((t)locald2).hg(false);
              n.c((t)locald2);
            }
          }
          catch (NullPointerException localNullPointerException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", localNullPointerException, "stashPersistentRuntimesWhenActivityMayDestroy", new Object[0]);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", localOutOfMemoryError, "stashPersistentRuntimesWhenActivityMayDestroy", new Object[0]);
              continue;
              Object localObject2 = null;
            }
          }
        }
      }
    }
    AppMethodBeat.o(277529);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(43844);
    super.b(paramAppBrandRuntime1, paramAppBrandRuntime2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284031);
        paramRunnable.run();
        if ((AppBrandRuntimeContainerWC.this.getActiveRuntime() != null) && (!AppBrandRuntimeWCAccessible.isGame(AppBrandRuntimeContainerWC.this.getActiveRuntime()))) {
          AppBrandRuntimeContainerWC.b(AppBrandRuntimeContainerWC.this);
        }
        AppMethodBeat.o(284031);
      }
    });
    AppMethodBeat.o(43844);
  }
  
  public final void bDf()
  {
    AppMethodBeat.i(277537);
    Iterator localIterator = bCW().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.luggage.sdk.e.d)localIterator.next();
      if ((localObject1 instanceof t))
      {
        localObject1 = (t)localObject1;
        if (((t)localObject1).nwK != null)
        {
          Object localObject2 = ((t)localObject1).nwK;
          localObject1 = new com.tencent.mm.f.b.a.q();
          Object localObject3 = ((r)localObject2).qMv;
          if (localObject3 != null)
          {
            l = ((Long)localObject3).longValue();
            label91:
            ((com.tencent.mm.f.b.a.q)localObject1).gfh = l;
            ((com.tencent.mm.f.b.a.q)localObject1).iJ(((r)localObject2).appId);
            localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.qMz;
            ((com.tencent.mm.f.b.a.q)localObject1).iK(a.a.getFlags());
            ((com.tencent.mm.f.b.a.q)localObject1).gfj = 2L;
            ((com.tencent.mm.f.b.a.q)localObject1).iL(((r)localObject2).sessionId);
            if (((r)localObject2).qMw != null) {
              break label210;
            }
          }
          for (long l = 0L;; l -= ((Long)localObject2).longValue())
          {
            ((com.tencent.mm.f.b.a.q)localObject1).gfi = l;
            Log.d("MicroMsg.kv_21804", "onFinishReport: process[%s]" + ((com.tencent.mm.f.b.a.q)localObject1).agI(), new Object[] { MMApplicationContext.getProcessName() });
            ((com.tencent.mm.f.b.a.q)localObject1).bpa();
            break;
            l = -1L;
            break label91;
            label210:
            l = System.currentTimeMillis();
            localObject2 = ((r)localObject2).qMw;
            if (localObject2 == null) {
              p.iCn();
            }
          }
        }
      }
    }
    AppMethodBeat.o(277537);
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(43847);
    if (this.nvI)
    {
      Log.i("MicroMsg.AppBrandRuntimeContainerWC", "closeActivity(%b), mKeepActivityFrontOnce=TRUE", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(43847);
      return;
    }
    AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
    super.cl(paramBoolean);
    if (((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) && (AndroidContextUtil.castActivityOrNull(this.mContext).isFinishing()))
    {
      if (localAppBrandRuntime != null) {}
      try
      {
        if (localAppBrandRuntime.bBX().getCurrentPage().mSwiping) {
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
  
  public final void cleanup()
  {
    AppMethodBeat.i(277528);
    Iterator localIterator = bCW().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.luggage.sdk.e.d)localIterator.next();
      if ((localObject1 instanceof t))
      {
        localObject1 = (t)localObject1;
        if (((t)localObject1).nwK != null)
        {
          Object localObject2 = ((t)localObject1).nwK;
          localObject1 = new com.tencent.mm.f.b.a.q();
          Object localObject3 = ((r)localObject2).qMv;
          if (localObject3 != null)
          {
            l = ((Long)localObject3).longValue();
            label91:
            ((com.tencent.mm.f.b.a.q)localObject1).gfh = l;
            ((com.tencent.mm.f.b.a.q)localObject1).iJ(((r)localObject2).appId);
            localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.qMz;
            ((com.tencent.mm.f.b.a.q)localObject1).iK(a.a.getFlags());
            ((com.tencent.mm.f.b.a.q)localObject1).gfj = 1L;
            ((com.tencent.mm.f.b.a.q)localObject1).iL(((r)localObject2).sessionId);
            if (((r)localObject2).qMw != null) {
              break label208;
            }
          }
          for (long l = 0L;; l -= ((Long)localObject2).longValue())
          {
            ((com.tencent.mm.f.b.a.q)localObject1).gfi = l;
            Log.d("MicroMsg.kv_21804", "onDestroyReport: process[%s]" + ((com.tencent.mm.f.b.a.q)localObject1).agI(), new Object[] { MMApplicationContext.getProcessName() });
            ((com.tencent.mm.f.b.a.q)localObject1).bpa();
            break;
            l = -1L;
            break label91;
            label208:
            l = System.currentTimeMillis();
            localObject2 = ((r)localObject2).qMw;
            if (localObject2 == null) {
              p.iCn();
            }
          }
        }
      }
    }
    super.cleanup();
    if ((getContext() instanceof com.tencent.mm.plugin.appbrand.ui.l)) {
      ((com.tencent.mm.plugin.appbrand.ui.l)getContext()).setBaseContext(MMApplicationContext.getContext());
    }
    super.aD(MMApplicationContext.getContext());
    AppMethodBeat.o(277528);
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(180170);
    a(paramConfiguration);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275273);
        AppBrandRuntimeContainerWC.b(paramConfiguration);
        AppMethodBeat.o(275273);
      }
    });
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(180170);
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
    if (((localActivity instanceof AppBrandUI)) && (((AppBrandUI)localActivity).bCS())) {
      super.setWindowDescription(parama);
    }
    AppMethodBeat.o(174652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC
 * JD-Core Version:    0.7.0.1
 */