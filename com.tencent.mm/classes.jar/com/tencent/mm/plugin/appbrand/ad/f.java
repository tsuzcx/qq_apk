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
import com.tencent.luggage.k.j;
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
public class f
  extends FrameLayout
{
  private AppBrandRuntime nAt;
  private FrameLayout nAu;
  private LinearLayout nAv;
  public a nAw;
  private a nAx;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(134634);
    this.nAt = paramAppBrandRuntime;
    if (j.cEc.isDarkMode())
    {
      setBackgroundColor(-16777216);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.nAu = new FrameLayout(paramContext);
      addView(this.nAu, new ViewGroup.LayoutParams(-1, -1));
      this.nAv = new LinearLayout(paramContext);
      this.nAv.setOrientation(1);
      addView(this.nAv, new ViewGroup.LayoutParams(-1, -2));
      if ((this.nAv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
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
      ((ViewGroup.MarginLayoutParams)this.nAv.getLayoutParams()).topMargin = i;
      Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "fakeActionBarLayout topMargin=%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134634);
      return;
      setBackgroundColor(-1);
      break;
    }
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
          AppMethodBeat.i(245680);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(245680);
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
  
  private void ack(String paramString)
  {
    AppMethodBeat.i(134647);
    setVisibility(8);
    if (this.nAx != null) {
      this.nAx.acl(paramString);
    }
    AppMethodBeat.o(134647);
  }
  
  private void p(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134646);
    Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "hideOnMainThread, animation:%s, source:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOptionButton localAppBrandOptionButton;
    int k;
    int i;
    if (paramBoolean)
    {
      localAppBrandOptionButton = null;
      if ((this.nAt != null) && (this.nAt.ntG != null))
      {
        localAppBrandOptionButton = this.nAt.ntG.bEB();
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
        if (this.nAw == null) {
          break;
        }
        localAppBrandOptionButton = this.nAw.bEB();
        break;
      }
      ack(paramString);
      AppMethodBeat.o(134646);
      return;
      ack(paramString);
      AppMethodBeat.o(134646);
      return;
      label194:
      i = 0;
    }
  }
  
  public final void bEK()
  {
    AppMethodBeat.i(134635);
    this.nAv.removeAllViews();
    this.nAw = new a(getContext());
    this.nAv.addView(this.nAw.getActionView());
    this.nAw.setFullscreenMode(true);
    this.nAw.hi(false);
    this.nAw.hj(false);
    this.nAw.hk(false);
    this.nAw.setBackgroundColor(0);
    AppMethodBeat.o(134635);
  }
  
  public final void bEL()
  {
    AppMethodBeat.i(134641);
    if (this.nAw != null) {
      this.nAw.hk(true);
    }
    AppMethodBeat.o(134641);
  }
  
  public final void bEM()
  {
    AppMethodBeat.i(134644);
    setVisibility(0);
    bringToFront();
    AppMethodBeat.o(134644);
  }
  
  public ViewGroup getContentContainer()
  {
    return this.nAu;
  }
  
  public final void o(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134645);
    if (MMHandlerThread.isMainThread())
    {
      p(paramBoolean, paramString);
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
  
  public void setActionBarFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(134636);
    if (this.nAw != null) {
      this.nAw.setFullscreenMode(paramBoolean);
    }
    AppMethodBeat.o(134636);
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134637);
    if (this.nAw != null) {
      this.nAw.setBackButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134637);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134639);
    if (this.nAw != null) {
      this.nAw.setCloseButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134639);
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(134642);
    if (this.nAw != null) {
      this.nAw.nzU.setForegroundStyle(paramBoolean);
    }
    AppMethodBeat.o(134642);
  }
  
  public void setOnHideListener(a parama)
  {
    this.nAx = parama;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134638);
    if (this.nAw != null) {
      this.nAw.nzU.setOptionButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134638);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(134640);
    if (this.nAw != null) {
      this.nAw.setMainTitle(paramString);
    }
    AppMethodBeat.o(134640);
  }
  
  public static abstract interface a
  {
    public abstract void acl(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.f
 * JD-Core Version:    0.7.0.1
 */