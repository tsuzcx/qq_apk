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
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

@SuppressLint({"ViewConstructor"})
public final class f
  extends FrameLayout
{
  private AppBrandRuntime jFc;
  private FrameLayout jFd;
  private LinearLayout jFe;
  public a jFf;
  private a jFg;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(134634);
    this.jFc = paramAppBrandRuntime;
    if (i.cre.isDarkMode())
    {
      setBackgroundColor(-16777216);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jFd = new FrameLayout(paramContext);
      addView(this.jFd, new ViewGroup.LayoutParams(-1, -1));
      this.jFe = new LinearLayout(paramContext);
      this.jFe.setOrientation(1);
      addView(this.jFe, new ViewGroup.LayoutParams(-1, -2));
      if ((this.jFe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        paramContext = paramAppBrandRuntime.getWindowAndroid().getStatusBar();
        paramAppBrandRuntime = (ViewGroup.MarginLayoutParams)this.jFe.getLayoutParams();
        if (paramContext != null) {
          break label169;
        }
      }
    }
    label169:
    for (int i = 0;; i = paramContext.height)
    {
      paramAppBrandRuntime.topMargin = i;
      AppMethodBeat.o(134634);
      return;
      setBackgroundColor(-1);
      break;
    }
  }
  
  private void Lr(String paramString)
  {
    AppMethodBeat.i(134647);
    setVisibility(8);
    if (this.jFg != null) {
      this.jFg.Ls(paramString);
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
          AppMethodBeat.i(207745);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(207745);
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
  
  private void k(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134646);
    ae.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "hideOnMainThread, animation:%s, source:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOptionButton localAppBrandOptionButton;
    int k;
    int i;
    if (paramBoolean)
    {
      localAppBrandOptionButton = null;
      if ((this.jFc != null) && (this.jFc.jzJ != null))
      {
        localAppBrandOptionButton = this.jFc.jzJ.aYp();
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
        if (this.jFf == null) {
          break;
        }
        localAppBrandOptionButton = this.jFf.aYp();
        break;
      }
      Lr(paramString);
      AppMethodBeat.o(134646);
      return;
      Lr(paramString);
      AppMethodBeat.o(134646);
      return;
      label194:
      i = 0;
    }
  }
  
  public final void aYx()
  {
    AppMethodBeat.i(134635);
    this.jFe.removeAllViews();
    this.jFf = new a(getContext());
    this.jFe.addView(this.jFf.getActionView());
    this.jFf.setFullscreenMode(true);
    this.jFf.fC(false);
    this.jFf.fD(false);
    this.jFf.fE(false);
    this.jFf.setBackgroundColor(0);
    AppMethodBeat.o(134635);
  }
  
  public final void aYy()
  {
    AppMethodBeat.i(134641);
    if (this.jFf != null) {
      this.jFf.fE(true);
    }
    AppMethodBeat.o(134641);
  }
  
  public final void aYz()
  {
    AppMethodBeat.i(134644);
    setVisibility(0);
    bringToFront();
    AppMethodBeat.o(134644);
  }
  
  public final ViewGroup getContentContainer()
  {
    return this.jFd;
  }
  
  public final void j(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134645);
    if (ar.isMainThread())
    {
      k(paramBoolean, paramString);
      AppMethodBeat.o(134645);
      return;
    }
    ar.f(new Runnable()
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
    if (this.jFf != null) {
      this.jFf.setFullscreenMode(paramBoolean);
    }
    AppMethodBeat.o(134636);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134637);
    if (this.jFf != null) {
      this.jFf.setBackButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134637);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134639);
    if (this.jFf != null) {
      this.jFf.setCloseButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134639);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(134642);
    if (this.jFf != null) {
      this.jFf.jED.setForegroundStyle(paramBoolean);
    }
    AppMethodBeat.o(134642);
  }
  
  public final void setOnHideListener(a parama)
  {
    this.jFg = parama;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134638);
    if (this.jFf != null) {
      this.jFf.jED.setOptionButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134638);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(134640);
    if (this.jFf != null) {
      this.jFf.setMainTitle(paramString);
    }
    AppMethodBeat.o(134640);
  }
  
  public static abstract interface a
  {
    public abstract void Ls(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.f
 * JD-Core Version:    0.7.0.1
 */