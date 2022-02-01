package com.tencent.mm.plugin.appbrand.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
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
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

@SuppressLint({"ViewConstructor"})
public final class f
  extends FrameLayout
{
  private AppBrandRuntime kGM;
  private FrameLayout kGN;
  private LinearLayout kGO;
  public a kGP;
  private a kGQ;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(134634);
    this.kGM = paramAppBrandRuntime;
    if (j.cDv.isDarkMode())
    {
      setBackgroundColor(-16777216);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.kGN = new FrameLayout(paramContext);
      addView(this.kGN, new ViewGroup.LayoutParams(-1, -1));
      this.kGO = new LinearLayout(paramContext);
      this.kGO.setOrientation(1);
      addView(this.kGO, new ViewGroup.LayoutParams(-1, -2));
      if ((this.kGO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
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
      ((ViewGroup.MarginLayoutParams)this.kGO.getLayoutParams()).topMargin = i;
      Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "fakeActionBarLayout topMargin=%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134634);
      return;
      setBackgroundColor(-1);
      break;
    }
  }
  
  private void UA(String paramString)
  {
    AppMethodBeat.i(134647);
    setVisibility(8);
    if (this.kGQ != null) {
      this.kGQ.UB(paramString);
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
          AppMethodBeat.i(219296);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(219296);
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
  
  private void l(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134646);
    Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "hideOnMainThread, animation:%s, source:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOptionButton localAppBrandOptionButton;
    int k;
    int i;
    if (paramBoolean)
    {
      localAppBrandOptionButton = null;
      if ((this.kGM != null) && (this.kGM.kAx != null))
      {
        localAppBrandOptionButton = this.kGM.kAx.btD();
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
        if (this.kGP == null) {
          break;
        }
        localAppBrandOptionButton = this.kGP.btD();
        break;
      }
      UA(paramString);
      AppMethodBeat.o(134646);
      return;
      UA(paramString);
      AppMethodBeat.o(134646);
      return;
      label194:
      i = 0;
    }
  }
  
  public final void btL()
  {
    AppMethodBeat.i(134635);
    this.kGO.removeAllViews();
    this.kGP = new a(getContext());
    this.kGO.addView(this.kGP.getActionView());
    this.kGP.setFullscreenMode(true);
    this.kGP.gx(false);
    this.kGP.gy(false);
    this.kGP.gz(false);
    this.kGP.setBackgroundColor(0);
    AppMethodBeat.o(134635);
  }
  
  public final void btM()
  {
    AppMethodBeat.i(134641);
    if (this.kGP != null) {
      this.kGP.gz(true);
    }
    AppMethodBeat.o(134641);
  }
  
  public final void btN()
  {
    AppMethodBeat.i(134644);
    setVisibility(0);
    bringToFront();
    AppMethodBeat.o(134644);
  }
  
  public final ViewGroup getContentContainer()
  {
    return this.kGN;
  }
  
  public final void k(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134645);
    if (MMHandlerThread.isMainThread())
    {
      l(paramBoolean, paramString);
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
  
  public final void setActionBarFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(134636);
    if (this.kGP != null) {
      this.kGP.setFullscreenMode(paramBoolean);
    }
    AppMethodBeat.o(134636);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134637);
    if (this.kGP != null) {
      this.kGP.setBackButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134637);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134639);
    if (this.kGP != null) {
      this.kGP.setCloseButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134639);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(134642);
    if (this.kGP != null) {
      this.kGP.kGn.setForegroundStyle(paramBoolean);
    }
    AppMethodBeat.o(134642);
  }
  
  public final void setOnHideListener(a parama)
  {
    this.kGQ = parama;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134638);
    if (this.kGP != null) {
      this.kGP.kGn.setOptionButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134638);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(134640);
    if (this.kGP != null) {
      this.kGP.setMainTitle(paramString);
    }
    AppMethodBeat.o(134640);
  }
  
  public static abstract interface a
  {
    public abstract void UB(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.f
 * JD-Core Version:    0.7.0.1
 */