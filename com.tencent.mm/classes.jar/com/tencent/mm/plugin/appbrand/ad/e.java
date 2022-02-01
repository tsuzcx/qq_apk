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
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.s.a.c.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

@SuppressLint({"ViewConstructor"})
public final class e
  extends FrameLayout
{
  private AppBrandRuntime iIE;
  private FrameLayout iIF;
  private LinearLayout iIG;
  public b iIH;
  private e.a iII;
  
  public e(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(134634);
    this.iIE = paramAppBrandRuntime;
    if (i.cjn.Eq())
    {
      setBackgroundColor(-16777216);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.iIF = new FrameLayout(paramContext);
      addView(this.iIF, new ViewGroup.LayoutParams(-1, -1));
      this.iIG = new LinearLayout(paramContext);
      this.iIG.setOrientation(1);
      addView(this.iIG, new ViewGroup.LayoutParams(-1, -2));
      if ((this.iIG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        paramContext = paramAppBrandRuntime.getWindowAndroid().getStatusBar();
        paramAppBrandRuntime = (ViewGroup.MarginLayoutParams)this.iIG.getLayoutParams();
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
  
  private void DB(String paramString)
  {
    AppMethodBeat.i(134647);
    setVisibility(8);
    if (this.iII != null) {
      this.iII.Di(paramString);
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
  
  private void aOc()
  {
    AppMethodBeat.i(134644);
    setVisibility(0);
    bringToFront();
    AppMethodBeat.o(134644);
  }
  
  private void i(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134646);
    ad.i("MicroMsg.AppBrandRuntimeAdViewContainer", "hideOnMainThread, animation:%s, source:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOptionButton localAppBrandOptionButton;
    int j;
    int i;
    if (paramBoolean)
    {
      localAppBrandOptionButton = null;
      if ((this.iIE != null) && (this.iIE.aLK() != null) && (this.iIE.aLK().getPageView() != null))
      {
        localAppBrandOptionButton = this.iIE.aLK().getPageView().bjH().getOptionButton();
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
      ad.i("MicroMsg.AppBrandRuntimeAdViewContainer", "hideOnMainThread, targetX:%s, targetY:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
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
        if (this.iIH == null) {
          break;
        }
        localAppBrandOptionButton = this.iIH.getOptionButton();
        break;
      }
      DB(paramString);
      AppMethodBeat.o(134646);
      return;
      DB(paramString);
      AppMethodBeat.o(134646);
      return;
      label235:
      i = 0;
      j = 0;
    }
  }
  
  public final void aOa()
  {
    AppMethodBeat.i(134635);
    this.iIG.removeAllViews();
    this.iIH = new b(getContext());
    this.iIG.addView(this.iIH.getActionView());
    this.iIH.setFullscreenMode(true);
    this.iIH.ho(false);
    this.iIH.hp(false);
    this.iIH.hd(false);
    this.iIH.setBackgroundColor(0);
    AppMethodBeat.o(134635);
  }
  
  public final void aOb()
  {
    AppMethodBeat.i(134641);
    if (this.iIH != null) {
      this.iIH.hd(true);
    }
    AppMethodBeat.o(134641);
  }
  
  public final ViewGroup getContentContainer()
  {
    return this.iIF;
  }
  
  public final void h(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(134645);
    if (aq.isMainThread())
    {
      i(paramBoolean, paramString);
      AppMethodBeat.o(134645);
      return;
    }
    aq.f(new Runnable()
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
    if (this.iIH != null) {
      this.iIH.setFullscreenMode(paramBoolean);
    }
    AppMethodBeat.o(134636);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134637);
    if (this.iIH != null) {
      this.iIH.setBackButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134637);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134639);
    if (this.iIH != null) {
      this.iIH.setCloseButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134639);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(134642);
    if (this.iIH != null) {
      this.iIH.setForegroundStyle(paramBoolean);
    }
    AppMethodBeat.o(134642);
  }
  
  public final void setOnHideListener(e.a parama)
  {
    this.iII = parama;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134638);
    if (this.iIH != null) {
      this.iIH.setOptionButtonClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134638);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(134640);
    if (this.iIH != null) {
      this.iIH.setMainTitle(paramString);
    }
    AppMethodBeat.o(134640);
  }
  
  public final void show()
  {
    AppMethodBeat.i(134643);
    if (aq.isMainThread())
    {
      aOc();
      AppMethodBeat.o(134643);
      return;
    }
    aq.f(new Runnable()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e
 * JD-Core Version:    0.7.0.1
 */