package com.tencent.mm.plugin.appbrand.ad;

import android.animation.Animator;
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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.c.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

@SuppressLint({"ViewConstructor"})
public final class e
  extends FrameLayout
{
  private AppBrandRuntime jCe;
  private FrameLayout jCf;
  private LinearLayout jCg;
  public b jCh;
  private e.a jCi;
  
  public e(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(134634);
    this.jCe = paramAppBrandRuntime;
    if (i.cqA.isDarkMode())
    {
      setBackgroundColor(-16777216);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jCf = new FrameLayout(paramContext);
      addView(this.jCf, new ViewGroup.LayoutParams(-1, -1));
      this.jCg = new LinearLayout(paramContext);
      this.jCg.setOrientation(1);
      addView(this.jCg, new ViewGroup.LayoutParams(-1, -2));
      if ((this.jCg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        paramContext = paramAppBrandRuntime.getWindowAndroid().getStatusBar();
        paramAppBrandRuntime = (ViewGroup.MarginLayoutParams)this.jCg.getLayoutParams();
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
  
  private void KR(String paramString)
  {
    AppMethodBeat.i(134647);
    setVisibility(8);
    if (this.jCi != null) {
      this.jCi.KS(paramString);
    }
    AppMethodBeat.o(134647);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    AppMethodBeat.i(134648);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, (float)Math.hypot(paramInt1, paramInt2), 0.0F);
      paramView.addListener(new e.5(this, paramRunnable));
      paramView.setDuration(300L).setInterpolator(new DecelerateInterpolator());
      paramView.start();
      AppMethodBeat.o(134648);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(134648);
  }
  
  private void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(134646);
    ad.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "hideOnMainThread, animation:%s, source:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOptionButton localAppBrandOptionButton;
    int k;
    int i;
    if (paramBoolean)
    {
      localAppBrandOptionButton = null;
      if ((this.jCe != null) && (this.jCe.aVN() != null) && (this.jCe.aVN().getPageView() != null))
      {
        localAppBrandOptionButton = this.jCe.aVN().getPageView().bux().getOptionButton();
        if (localAppBrandOptionButton == null) {
          break label213;
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
        a(this, j, i, new e.3(this, paramString));
        AppMethodBeat.o(134646);
        return;
        if (this.jCh == null) {
          break;
        }
        localAppBrandOptionButton = this.jCh.getOptionButton();
        break;
      }
      KR(paramString);
      AppMethodBeat.o(134646);
      return;
      KR(paramString);
      AppMethodBeat.o(134646);
      return;
      label213:
      i = 0;
    }
  }
  
  public final void aYd()
  {
    AppMethodBeat.i(134635);
    this.jCg.removeAllViews();
    this.jCh = new b(getContext());
    this.jCg.addView(this.jCh.getActionView());
    this.jCh.setFullscreenMode(true);
    this.jCh.hW(false);
    this.jCh.hX(false);
    this.jCh.hK(false);
    this.jCh.setBackgroundColor(0);
    AppMethodBeat.o(134635);
  }
  
  public final void aYe()
  {
    AppMethodBeat.i(134641);
    if (this.jCh != null) {
      this.jCh.hK(true);
    }
    AppMethodBeat.o(134641);
  }
  
  public final void aYf()
  {
    AppMethodBeat.i(134644);
    setVisibility(0);
    bringToFront();
    AppMethodBeat.o(134644);
  }
  
  public final ViewGroup getContentContainer()
  {
    return this.jCf;
  }
  
  public final void j(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(134645);
    if (aq.isMainThread())
    {
      k(paramBoolean, paramString);
      AppMethodBeat.o(134645);
      return;
    }
    aq.f(new e.2(this, paramBoolean, paramString));
    AppMethodBeat.o(134645);
  }
  
  public final void setActionBarFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(134636);
    if (this.jCh != null) {
      this.jCh.setFullscreenMode(paramBoolean);
    }
    AppMethodBeat.o(134636);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134637);
    if (this.jCh != null) {
      this.jCh.setBackButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134637);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134639);
    if (this.jCh != null) {
      this.jCh.setCloseButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134639);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(134642);
    if (this.jCh != null) {
      this.jCh.setForegroundStyle(paramBoolean);
    }
    AppMethodBeat.o(134642);
  }
  
  public final void setOnHideListener(e.a parama)
  {
    this.jCi = parama;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134638);
    if (this.jCh != null) {
      this.jCh.setOptionButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134638);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(134640);
    if (this.jCh != null) {
      this.jCh.setMainTitle(paramString);
    }
    AppMethodBeat.o(134640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e
 * JD-Core Version:    0.7.0.1
 */