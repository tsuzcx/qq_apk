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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.c.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

@SuppressLint({"ViewConstructor"})
public final class e
  extends FrameLayout
{
  private AppBrandRuntime jiI;
  private FrameLayout jiJ;
  private LinearLayout jiK;
  public b jiL;
  private a jiM;
  
  public e(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(134634);
    this.jiI = paramAppBrandRuntime;
    if (i.cgk.DT())
    {
      setBackgroundColor(-16777216);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jiJ = new FrameLayout(paramContext);
      addView(this.jiJ, new ViewGroup.LayoutParams(-1, -1));
      this.jiK = new LinearLayout(paramContext);
      this.jiK.setOrientation(1);
      addView(this.jiK, new ViewGroup.LayoutParams(-1, -2));
      if ((this.jiK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        paramContext = paramAppBrandRuntime.getWindowAndroid().getStatusBar();
        paramAppBrandRuntime = (ViewGroup.MarginLayoutParams)this.jiK.getLayoutParams();
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
  
  private void HE(String paramString)
  {
    AppMethodBeat.i(134647);
    setVisibility(8);
    if (this.jiM != null) {
      this.jiM.Hl(paramString);
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
          AppMethodBeat.i(134633);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(134633);
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
  
  private void aUS()
  {
    AppMethodBeat.i(134644);
    setVisibility(0);
    bringToFront();
    AppMethodBeat.o(134644);
  }
  
  private void j(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134646);
    ac.i("MicroMsg.AppBrandRuntimeAdViewContainer", "hideOnMainThread, animation:%s, source:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOptionButton localAppBrandOptionButton;
    int j;
    int i;
    if (paramBoolean)
    {
      localAppBrandOptionButton = null;
      if ((this.jiI != null) && (this.jiI.aSA() != null) && (this.jiI.aSA().getPageView() != null))
      {
        localAppBrandOptionButton = this.jiI.aSA().getPageView().bqy().getOptionButton();
        if (localAppBrandOptionButton == null) {
          break label235;
        }
        j = localAppBrandOptionButton.getWidth();
        i = localAppBrandOptionButton.getHeight();
        int[] arrayOfInt = new int[2];
        localAppBrandOptionButton.getLocationInWindow(arrayOfInt);
        int k = arrayOfInt[0];
        j = j / 2 + k;
        i = arrayOfInt[1] + i / 2;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandRuntimeAdViewContainer", "hideOnMainThread, targetX:%s, targetY:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (i > 0))
      {
        a(this, j, i, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134632);
            e.a(e.this, paramString);
            AppMethodBeat.o(134632);
          }
        });
        AppMethodBeat.o(134646);
        return;
        if (this.jiL == null) {
          break;
        }
        localAppBrandOptionButton = this.jiL.getOptionButton();
        break;
      }
      HE(paramString);
      AppMethodBeat.o(134646);
      return;
      HE(paramString);
      AppMethodBeat.o(134646);
      return;
      label235:
      i = 0;
      j = 0;
    }
  }
  
  public final void aUQ()
  {
    AppMethodBeat.i(134635);
    this.jiK.removeAllViews();
    this.jiL = new b(getContext());
    this.jiK.addView(this.jiL.getActionView());
    this.jiL.setFullscreenMode(true);
    this.jiL.hM(false);
    this.jiL.hN(false);
    this.jiL.hA(false);
    this.jiL.setBackgroundColor(0);
    AppMethodBeat.o(134635);
  }
  
  public final void aUR()
  {
    AppMethodBeat.i(134641);
    if (this.jiL != null) {
      this.jiL.hA(true);
    }
    AppMethodBeat.o(134641);
  }
  
  public final ViewGroup getContentContainer()
  {
    return this.jiJ;
  }
  
  public final void i(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134645);
    if (ap.isMainThread())
    {
      j(paramBoolean, paramString);
      AppMethodBeat.o(134645);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134631);
        e.a(e.this, paramBoolean, paramString);
        AppMethodBeat.o(134631);
      }
    });
    AppMethodBeat.o(134645);
  }
  
  public final void setActionBarFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(134636);
    if (this.jiL != null) {
      this.jiL.setFullscreenMode(paramBoolean);
    }
    AppMethodBeat.o(134636);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134637);
    if (this.jiL != null) {
      this.jiL.setBackButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134637);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134639);
    if (this.jiL != null) {
      this.jiL.setCloseButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134639);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(134642);
    if (this.jiL != null) {
      this.jiL.setForegroundStyle(paramBoolean);
    }
    AppMethodBeat.o(134642);
  }
  
  public final void setOnHideListener(a parama)
  {
    this.jiM = parama;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134638);
    if (this.jiL != null) {
      this.jiL.setOptionButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134638);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(134640);
    if (this.jiL != null) {
      this.jiL.setMainTitle(paramString);
    }
    AppMethodBeat.o(134640);
  }
  
  public final void show()
  {
    AppMethodBeat.i(134643);
    if (ap.isMainThread())
    {
      aUS();
      AppMethodBeat.o(134643);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134630);
        e.a(e.this);
        AppMethodBeat.o(134630);
      }
    });
    AppMethodBeat.o(134643);
  }
  
  public static abstract interface a
  {
    public abstract void Hl(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e
 * JD-Core Version:    0.7.0.1
 */