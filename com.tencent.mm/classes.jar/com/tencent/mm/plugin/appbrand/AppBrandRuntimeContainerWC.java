package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.report.model.r;
import com.tencent.mm.plugin.appbrand.report.quality.a.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.x;

public class AppBrandRuntimeContainerWC
  extends com.tencent.luggage.sdk.d.b
{
  private boolean kCy;
  private final Class[] kCz;
  
  static
  {
    AppMethodBeat.i(43852);
    r.a.a(g.nav);
    AppMethodBeat.o(43852);
  }
  
  public AppBrandRuntimeContainerWC(com.tencent.mm.plugin.appbrand.task.k paramk)
  {
    super(paramk, q.class);
    AppMethodBeat.i(43841);
    this.kCy = false;
    this.kCz = new Class[] { com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.class };
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext();
      if (com.tencent.mm.plugin.appbrand.widget.input.a.caQ()) {
        com.tencent.mm.plugin.appbrand.widget.l.a(AndroidContextUtil.castActivityOrNull(this.mContext), AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getDecorView());
      }
    }
    if (Build.VERSION.SDK_INT >= 26) {
      this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(174649);
          Object localObject;
          if (u.aD(AppBrandRuntimeContainerWC.this.mContentView))
          {
            localObject = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainerWC.this.mContext);
            if ((localObject != null) && (((Activity)localObject).getWindow() != null))
            {
              bool = ar.aln(((Activity)localObject).getWindow().getNavigationBarColor());
              localObject = ((Activity)localObject).getWindow();
              if (bool) {
                break label73;
              }
            }
          }
          label73:
          for (boolean bool = true;; bool = false)
          {
            ao.e((Window)localObject, bool);
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
    if (!ao.isDarkMode()) {}
    for (paramConfiguration.uiMode |= 0x10;; paramConfiguration.uiMode |= 0x20)
    {
      MMApplicationContext.getContext().getResources().updateConfiguration(paramConfiguration, MMApplicationContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(180171);
      return;
    }
  }
  
  private void bsk()
  {
    AppMethodBeat.i(43845);
    if (((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) && (((Boolean)s.lrT.aLT()).booleanValue())) {
      com.tencent.mm.ui.base.b.bp(AndroidContextUtil.castActivityOrNull(this.mContext));
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
    if (((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).NA()))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramAppBrandInitConfig = com.tencent.mm.plugin.appbrand.widget.input.w.dc(this.mContentView);; paramAppBrandInitConfig = com.tencent.luggage.game.widget.input.a.cd(this.mContentView))
    {
      if ((paramAppBrandInitConfig != null) && ((paramAppBrandInitConfig.getParent() instanceof ViewGroup))) {
        ((ViewGroup)paramAppBrandInitConfig.getParent()).removeView(paramAppBrandInitConfig);
      }
      AppMethodBeat.o(43843);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean OH()
  {
    AppMethodBeat.i(43846);
    if (getStackSize() <= 0)
    {
      bY(false);
      AppMethodBeat.o(43846);
      return true;
    }
    AppMethodBeat.o(43846);
    return false;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(226173);
    super.a(paramInt, paramAppBrandRuntime);
    if (((q)paramAppBrandRuntime).bsC().kHL.isEnable())
    {
      com.tencent.mm.ui.base.b.a(AndroidContextUtil.castActivityOrNull(this.mContext), null);
      AppMethodBeat.o(226173);
      return;
    }
    if ((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) {
      com.tencent.mm.ui.base.b.bp(AndroidContextUtil.castActivityOrNull(this.mContext));
    }
    AppMethodBeat.o(226173);
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
        if ((paramLayoutParams instanceof com.tencent.mm.plugin.appbrand.widget.l))
        {
          paramLayoutParams = (com.tencent.mm.plugin.appbrand.widget.l)paramLayoutParams;
          j = AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getNavigationBarColor();
          if (j == paramLayoutParams.olB) {
            break label118;
          }
        }
      }
    }
    label118:
    for (int i = 1;; i = 0)
    {
      paramLayoutParams.olB = j;
      if (i != 0) {
        paramLayoutParams.invalidateSelf();
      }
      AppMethodBeat.o(43842);
      return;
    }
  }
  
  public final void a(AppBrandRuntimeContainerWC.a parama)
  {
    AppMethodBeat.i(226172);
    d locald1 = (d)getActiveRuntime();
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).addAll(this.kCb);
    ((LinkedList)localObject1).addAll(this.kCc.values());
    Iterator localIterator = ((LinkedList)localObject1).iterator();
    if ((localIterator.hasNext()) && (i.a(this)))
    {
      Log.i("MicroMsg.AppBrandRuntimeContainerWC", "stashPersistentRuntimesWhenActivityMayDestroy hash[%d], reason[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      for (;;)
      {
        if (localIterator.hasNext())
        {
          d locald2 = (d)localIterator.next();
          if ((!locald2.mInitialized) || (locald2.isDestroyed()) || (locald2.SO) || (org.apache.commons.b.a.contains(this.kCz, locald2.getClass()))) {
            continue;
          }
          if ((parama == AppBrandRuntimeContainerWC.a.kCD) && (locald2 == locald1)) {}
          try
          {
            if (!locald2.brh().getCurrentPage().mSwiping)
            {
              localObject1 = new FrameLayout(getContext());
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locald2.kAt.getWidth(), locald2.kAt.getHeight(), 81);
              Bitmap localBitmap = ca.cD(locald2.kAt);
              ((FrameLayout)localObject1).setBackground(new BitmapDrawable(getContext().getResources(), localBitmap));
              ((FrameLayout)localObject1).setWillNotDraw(false);
              this.mContentView.addView((View)localObject1, localLayoutParams);
              this.mContentView.bringChildToFront((View)localObject1);
            }
            if (locald2.mResumed)
            {
              if (!(locald2.ON() instanceof AppBrandInitConfigWC)) {
                break label417;
              }
              localObject1 = ((AppBrandInitConfigWC)locald2.ON()).leh;
              if (localObject1 != null) {
                ((WeAppOpenUICallbackIPCProxy)localObject1).mXw = true;
              }
              locald2.dispatchPause();
              if (localObject1 != null)
              {
                ((WeAppOpenUICallbackIPCProxy)localObject1).mXw = false;
                ((WeAppOpenUICallbackIPCProxy)localObject1).hY(true);
              }
            }
            localObject1 = locald2.kAt;
            if ((((View)localObject1).getParent() instanceof ViewGroup)) {
              ((ViewGroup)((View)localObject1).getParent()).removeView((View)localObject1);
            }
            B(locald2);
            ((q)locald2).bsA();
            k.c((q)locald2);
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
              label417:
              Object localObject2 = null;
            }
          }
        }
      }
    }
    AppMethodBeat.o(226172);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(43844);
    super.b(paramAppBrandRuntime1, paramAppBrandRuntime2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226166);
        paramRunnable.run();
        if ((AppBrandRuntimeContainerWC.this.getActiveRuntime() != null) && (!AppBrandRuntimeWCAccessible.isGame(AppBrandRuntimeContainerWC.this.getActiveRuntime()))) {
          AppBrandRuntimeContainerWC.b(AppBrandRuntimeContainerWC.this);
        }
        AppMethodBeat.o(226166);
      }
    });
    AppMethodBeat.o(43844);
  }
  
  public final void bY(boolean paramBoolean)
  {
    AppMethodBeat.i(43847);
    if (this.kCy)
    {
      Log.i("MicroMsg.AppBrandRuntimeContainerWC", "closeActivity(%b), mKeepActivityFrontOnce=TRUE", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(43847);
      return;
    }
    AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
    super.bY(paramBoolean);
    if (((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI)) && (AndroidContextUtil.castActivityOrNull(this.mContext).isFinishing()))
    {
      if (localAppBrandRuntime != null) {}
      try
      {
        if (localAppBrandRuntime.brh().getCurrentPage().mSwiping) {
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
  
  public final void bsl()
  {
    AppMethodBeat.i(226174);
    Iterator localIterator = bse().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (d)localIterator.next();
      if ((localObject1 instanceof q))
      {
        localObject1 = (q)localObject1;
        if (((q)localObject1).kDy != null)
        {
          Object localObject2 = ((q)localObject1).kDy;
          localObject1 = new com.tencent.mm.g.b.a.n();
          Object localObject3 = ((r)localObject2).nKj;
          if (localObject3 != null)
          {
            l = ((Long)localObject3).longValue();
            label91:
            ((com.tencent.mm.g.b.a.n)localObject1).ekC = l;
            ((com.tencent.mm.g.b.a.n)localObject1).hR(((r)localObject2).appId);
            localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.nKn;
            ((com.tencent.mm.g.b.a.n)localObject1).hS(a.a.getFlags());
            ((com.tencent.mm.g.b.a.n)localObject1).ekE = 2L;
            ((com.tencent.mm.g.b.a.n)localObject1).hT(((r)localObject2).sessionId);
            if (((r)localObject2).nKk != null) {
              break label210;
            }
          }
          for (long l = 0L;; l -= ((Long)localObject2).longValue())
          {
            ((com.tencent.mm.g.b.a.n)localObject1).ekD = l;
            Log.d("MicroMsg.kv_21804", "onFinishReport: process[%s]" + ((com.tencent.mm.g.b.a.n)localObject1).abW(), new Object[] { MMApplicationContext.getProcessName() });
            ((com.tencent.mm.g.b.a.n)localObject1).bfK();
            break;
            l = -1L;
            break label91;
            label210:
            l = System.currentTimeMillis();
            localObject2 = ((r)localObject2).nKk;
            if (localObject2 == null) {
              p.hyc();
            }
          }
        }
      }
    }
    AppMethodBeat.o(226174);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(226171);
    Iterator localIterator = bse().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (d)localIterator.next();
      if ((localObject1 instanceof q))
      {
        localObject1 = (q)localObject1;
        if (((q)localObject1).kDy != null)
        {
          Object localObject2 = ((q)localObject1).kDy;
          localObject1 = new com.tencent.mm.g.b.a.n();
          Object localObject3 = ((r)localObject2).nKj;
          if (localObject3 != null)
          {
            l = ((Long)localObject3).longValue();
            label91:
            ((com.tencent.mm.g.b.a.n)localObject1).ekC = l;
            ((com.tencent.mm.g.b.a.n)localObject1).hR(((r)localObject2).appId);
            localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.nKn;
            ((com.tencent.mm.g.b.a.n)localObject1).hS(a.a.getFlags());
            ((com.tencent.mm.g.b.a.n)localObject1).ekE = 1L;
            ((com.tencent.mm.g.b.a.n)localObject1).hT(((r)localObject2).sessionId);
            if (((r)localObject2).nKk != null) {
              break label208;
            }
          }
          for (long l = 0L;; l -= ((Long)localObject2).longValue())
          {
            ((com.tencent.mm.g.b.a.n)localObject1).ekD = l;
            Log.d("MicroMsg.kv_21804", "onDestroyReport: process[%s]" + ((com.tencent.mm.g.b.a.n)localObject1).abW(), new Object[] { MMApplicationContext.getProcessName() });
            ((com.tencent.mm.g.b.a.n)localObject1).bfK();
            break;
            l = -1L;
            break label91;
            label208:
            l = System.currentTimeMillis();
            localObject2 = ((r)localObject2).nKk;
            if (localObject2 == null) {
              p.hyc();
            }
          }
        }
      }
    }
    super.cleanup();
    if ((getContext() instanceof com.tencent.mm.plugin.appbrand.ui.n)) {
      ((com.tencent.mm.plugin.appbrand.ui.n)getContext()).setBaseContext(MMApplicationContext.getContext());
    }
    super.aG(MMApplicationContext.getContext());
    AppMethodBeat.o(226171);
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(180170);
    a(paramConfiguration);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226167);
        AppBrandRuntimeContainerWC.b(paramConfiguration);
        AppMethodBeat.o(226167);
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
    if (((localActivity instanceof AppBrandUI)) && (((AppBrandUI)localActivity).bsc())) {
      super.setWindowDescription(parama);
    }
    AppMethodBeat.o(174652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC
 * JD-Core Version:    0.7.0.1
 */