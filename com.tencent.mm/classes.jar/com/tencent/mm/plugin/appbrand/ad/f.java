package com.tencent.mm.plugin.appbrand.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.luggage.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class f
  extends FrameLayout
{
  private FrameLayout qzA;
  private LinearLayout qzB;
  public a qzC;
  private a qzD;
  private AppBrandRuntime qzz;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(134634);
    this.qzz = paramAppBrandRuntime;
    if (k.exm.isDarkMode())
    {
      setBackgroundColor(-16777216);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.qzA = new FrameLayout(paramContext);
      addView(this.qzA, new ViewGroup.LayoutParams(-1, -1));
      this.qzB = new LinearLayout(paramContext);
      this.qzB.setOrientation(1);
      addView(this.qzB, new ViewGroup.LayoutParams(-1, -2));
      if ((this.qzB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        paramContext = paramAppBrandRuntime.getWindowAndroid().getStatusBar();
        if (paramContext != null) {
          break label185;
        }
      }
    }
    label185:
    for (int i = 0;; i = paramContext.height)
    {
      ((ViewGroup.MarginLayoutParams)this.qzB.getLayoutParams()).topMargin = i;
      Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "fakeActionBarLayout topMargin=%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134634);
      return;
      setBackgroundColor(-1);
      break;
    }
  }
  
  private void C(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134646);
    Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "hideOnMainThread, animation:%s, source:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOptionButton localAppBrandOptionButton;
    int k;
    int i;
    if (paramBoolean)
    {
      localAppBrandOptionButton = null;
      if ((this.qzz != null) && (this.qzz.qsp != null))
      {
        localAppBrandOptionButton = this.qzz.qsp.cdM();
        if (localAppBrandOptionButton == null) {
          break label194;
        }
        k = localAppBrandOptionButton.getWidth();
        i = localAppBrandOptionButton.getHeight();
        int[] arrayOfInt = new int[2];
        localAppBrandOptionButton.getLocationInWindow(arrayOfInt);
        j = arrayOfInt[0];
        k /= 2;
        i = arrayOfInt[1] + i / 2;
      }
    }
    for (int j = k + j;; j = 0)
    {
      if ((j > 0) && (i > 0))
      {
        a(this, j, i, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134632);
            f.a(f.this, paramString);
            AppMethodBeat.o(134632);
          }
        });
        AppMethodBeat.o(134646);
        return;
        if (this.qzC == null) {
          break;
        }
        localAppBrandOptionButton = this.qzC.cdM();
        break;
      }
      UK(paramString);
      AppMethodBeat.o(134646);
      return;
      UK(paramString);
      AppMethodBeat.o(134646);
      return;
      label194:
      i = 0;
    }
  }
  
  private void UK(String paramString)
  {
    AppMethodBeat.i(134647);
    setVisibility(8);
    if (this.qzD != null) {
      this.qzD.UL(paramString);
    }
    AppMethodBeat.o(134647);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(134648);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, (float)Math.hypot(paramInt1, paramInt2), 0.0F);
      paramView.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(321280);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(321280);
        }
      });
      paramView.setDuration(300L).setInterpolator(new DecelerateInterpolator());
      paramView.start();
      AppMethodBeat.o(134648);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(134648);
  }
  
  private void cdX()
  {
    AppMethodBeat.i(134644);
    setVisibility(0);
    bringToFront();
    AppMethodBeat.o(134644);
  }
  
  public final void B(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134645);
    if (MMHandlerThread.isMainThread())
    {
      C(paramBoolean, paramString);
      AppMethodBeat.o(134645);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134631);
        f.a(f.this, paramBoolean, paramString);
        AppMethodBeat.o(134631);
      }
    });
    AppMethodBeat.o(134645);
  }
  
  public final void cdV()
  {
    AppMethodBeat.i(134635);
    this.qzB.removeAllViews();
    this.qzC = new a(getContext());
    this.qzB.addView(this.qzC.getActionView());
    this.qzC.setFullscreenMode(true);
    this.qzC.ia(false);
    this.qzC.ib(false);
    this.qzC.hZ(false);
    this.qzC.setBackgroundColor(0);
    AppMethodBeat.o(134635);
  }
  
  public final void cdW()
  {
    AppMethodBeat.i(134641);
    if (this.qzC != null) {
      this.qzC.hZ(true);
    }
    AppMethodBeat.o(134641);
  }
  
  public final void cdY()
  {
    AppMethodBeat.i(321336);
    if (MMHandlerThread.isMainThread())
    {
      setVisibility(8);
      AppMethodBeat.o(321336);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(321278);
        f.this.setVisibility(8);
        AppMethodBeat.o(321278);
      }
    });
    AppMethodBeat.o(321336);
  }
  
  public ViewGroup getContentContainer()
  {
    return this.qzA;
  }
  
  public void setActionBarFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(134636);
    if (this.qzC != null) {
      this.qzC.setFullscreenMode(paramBoolean);
    }
    AppMethodBeat.o(134636);
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134637);
    if (this.qzC != null) {
      this.qzC.setBackButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134637);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134639);
    if (this.qzC != null) {
      this.qzC.setCloseButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134639);
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(134642);
    if (this.qzC != null) {
      this.qzC.qyW.setForegroundStyle(paramBoolean);
    }
    AppMethodBeat.o(134642);
  }
  
  public void setOnHideListener(a parama)
  {
    this.qzD = parama;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134638);
    if (this.qzC != null) {
      this.qzC.qyW.setOptionButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134638);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(134640);
    if (this.qzC != null) {
      this.qzC.setMainTitle(paramString);
    }
    AppMethodBeat.o(134640);
  }
  
  public final void show()
  {
    AppMethodBeat.i(134643);
    if (MMHandlerThread.isMainThread())
    {
      cdX();
      AppMethodBeat.o(134643);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134630);
        f.a(f.this);
        AppMethodBeat.o(134630);
      }
    });
    AppMethodBeat.o(134643);
  }
  
  public static abstract interface a
  {
    public abstract void UL(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.f
 * JD-Core Version:    0.7.0.1
 */