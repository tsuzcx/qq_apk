package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.h.i;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.aj;
import d.z;

@SuppressLint({"ViewConstructor"})
public final class AppBrandUILoadingSplash
  extends com.tencent.mm.ui.statusbar.b
  implements q, v, x, y
{
  AppBrandRuntime jzY;
  private ImageView mAR;
  private TextView mAU;
  private AppBrandCircleProgressView mAW;
  private TextView mAZ;
  private d.g.a.a<z> mCq;
  private ViewGroup mFt;
  private ViewStub mFu;
  private ViewStub mFv;
  private boolean mFw;
  private a mFx;
  private Boolean mzu;
  
  @Keep
  public AppBrandUILoadingSplash(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(177512);
    this.mFw = true;
    init();
    AppMethodBeat.o(177512);
  }
  
  public AppBrandUILoadingSplash(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(147682);
    this.mFw = true;
    this.jzY = paramAppBrandRuntime;
    init();
    AppMethodBeat.o(147682);
  }
  
  private void aYd()
  {
    int j = -1;
    AppMethodBeat.i(177514);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169537);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this) != null)
        {
          com.tencent.mm.plugin.appbrand.g.a(AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).mAppId, g.d.jwl);
          AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169537);
          return;
          if (AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this) != null) {
            AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this).invoke();
          }
        }
      }
    };
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.mFt.findViewById(2131296402);
    View localView = this.mFt.findViewById(2131296399);
    if (isDarkMode())
    {
      i = 2131230978;
      localView.setBackgroundResource(i);
      localAppBrandOptionButton.reset();
      if (!isDarkMode()) {
        break label129;
      }
      i = -1;
      label71:
      localAppBrandOptionButton.setColor(i);
      localAppBrandOptionButton = (AppBrandOptionButton)this.mFt.findViewById(2131296401);
      localAppBrandOptionButton.reset();
      if (!isDarkMode()) {
        break label135;
      }
    }
    label129:
    label135:
    for (int i = j;; i = -16777216)
    {
      localAppBrandOptionButton.setColor(i);
      localAppBrandOptionButton.setOnClickListener(local4);
      AppMethodBeat.o(177514);
      return;
      i = 2131230979;
      break;
      i = -16777216;
      break label71;
    }
  }
  
  private void d(Configuration paramConfiguration)
  {
    AppMethodBeat.i(147689);
    if (!(this.jzY.getWindowAndroid() instanceof o))
    {
      AppMethodBeat.o(147689);
      return;
    }
    Object localObject = com.tencent.mm.sdk.f.a.jq(((o)this.jzY.getWindowAndroid()).mContext);
    if (paramConfiguration.orientation == 2) {}
    for (int i = 1; (i != 0) && (localObject != null) && (Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()) && (((Activity)localObject).getRequestedOrientation() == 1); i = 0)
    {
      AppMethodBeat.o(147689);
      return;
    }
    if (localObject != null)
    {
      paramConfiguration = ((Activity)localObject).getWindow();
      localObject = paramConfiguration.getDecorView();
      if (i != 0)
      {
        paramConfiguration.addFlags(1024);
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100);
        AppMethodBeat.o(147689);
        return;
      }
      s.a(paramConfiguration, false, false);
    }
    AppMethodBeat.o(147689);
  }
  
  private void init()
  {
    AppMethodBeat.i(177513);
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131496376, this);
    this.mAR = ((ImageView)findViewById(2131296765));
    this.mAR.setImageDrawable(ad.bzP());
    this.mAU = ((TextView)findViewById(2131296770));
    this.mAW = ((AppBrandCircleProgressView)findViewById(2131303533));
    this.mAW.setCircleColor(android.support.v4.content.b.n(getContext(), 2131099656));
    this.mAW.setDotWidth(getResources().getDimensionPixelSize(2131167060));
    this.mAW.setDotColor(android.support.v4.content.b.n(getContext(), 2131099699));
    this.mAW.setCircleStrokeWidth(getResources().getDimensionPixelSize(2131167059));
    this.mAW.setProgressColor(android.support.v4.content.b.n(getContext(), 2131099699));
    this.mAW.setProgressWidth(getResources().getDimensionPixelSize(2131167061));
    if (aj.cmR()) {
      this.mAW.setTransitionTimingMs(2147483647);
    }
    this.mFt = ((ViewGroup)findViewById(2131296771));
    this.mFu = ((ViewStub)findViewById(2131300057));
    this.mFv = ((ViewStub)findViewById(2131308139));
    c.a("AppBrandUILoadingSplash setupRightButton", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147675);
        LayoutInflater.from(AppBrandUILoadingSplash.this.getContext()).inflate(2131493066, AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this));
        AppMethodBeat.o(147675);
      }
    });
    this.mAU.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.dT(getContext());
    aYd();
    AppMethodBeat.o(177513);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147683);
    com.tencent.mm.modelappbrand.a.b.aDV().a(this.mAR, paramString1, null, com.tencent.mm.modelappbrand.a.g.hLC);
    this.mAU.setText(paramString2);
    AppMethodBeat.o(147683);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final boolean hasOverlappingRendering()
  {
    return false;
  }
  
  final boolean isDarkMode()
  {
    AppMethodBeat.i(162234);
    if (this.mzu == null) {
      this.mzu = Boolean.valueOf(i.cqA.isDarkMode());
    }
    boolean bool = this.mzu.booleanValue();
    AppMethodBeat.o(162234);
    return bool;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(147685);
    super.onAttachedToWindow();
    int i = getResources().getColor(2131099650);
    if (!isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      L(i, bool);
      this.mAW.bzc();
      try
      {
        d(getContext().getResources().getConfiguration());
        AppMethodBeat.o(147685);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(147685);
      }
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(147688);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      d(paramConfiguration);
      AppMethodBeat.o(147688);
      return;
    }
    catch (Exception paramConfiguration)
    {
      AppMethodBeat.o(147688);
    }
  }
  
  public final void rC(final int paramInt)
  {
    AppMethodBeat.i(147687);
    if (this.jzY == null)
    {
      AppMethodBeat.o(147687);
      return;
    }
    this.jzY.j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169538);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (AppBrandUILoadingSplash.i(AppBrandUILoadingSplash.this) == null)
          {
            ((ViewStub)AppBrandUILoadingSplash.this.findViewById(2131296900)).inflate();
            AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this, (TextView)AppBrandUILoadingSplash.this.findViewById(2131301494));
          }
          AppBrandUILoadingSplash.i(AppBrandUILoadingSplash.this).setVisibility(0);
          AppBrandUILoadingSplash.i(AppBrandUILoadingSplash.this).setText(2131755950);
          AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this).setVisibility(8);
        }
        AppMethodBeat.o(169538);
      }
    }, 0L);
    AppMethodBeat.o(147687);
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    this.mFw = paramBoolean;
  }
  
  public final void setLabelInjector(a parama)
  {
    AppMethodBeat.i(192325);
    this.mFx = parama;
    if (this.mFx != null)
    {
      this.mFx.a(this.mFv);
      this.mFx.b(this.mFu);
    }
    AppMethodBeat.o(192325);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(192324);
    this.mAW.setProgress(paramInt);
    AppMethodBeat.o(192324);
  }
  
  public final void u(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(192323);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", new Object[] { Boolean.valueOf(this.mFw) });
    if (!this.mFw)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
      final ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof ViewGroup))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
        AppMethodBeat.o(192323);
        return;
      }
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147679);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
          AppBrandUILoadingSplash.this.setVisibility(8);
          ((ViewGroup)localViewParent).removeView(AppBrandUILoadingSplash.this);
          if (parama != null) {
            parama.invoke();
          }
          AppMethodBeat.o(147679);
        }
      });
      AppMethodBeat.o(192323);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169536);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide with animation");
        Object localObject = AppBrandUILoadingSplash.this.getParent();
        if (!(localObject instanceof ViewGroup))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(169536);
          return;
        }
        AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).bzd();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169534);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            int j = Color.argb(i, Color.red(this.mFz), Color.green(this.mFz), Color.blue(this.mFz));
            AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).setBackgroundColor(j);
            paramAnonymous2ValueAnimator = AppBrandUILoadingSplash.this;
            if (!AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this)) {}
            for (boolean bool = true;; bool = false)
            {
              AppBrandUILoadingSplash.a(paramAnonymous2ValueAnimator, j, bool);
              if (i == 0) {
                AppBrandUILoadingSplash.this.post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(169533);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, hide ends && remove splash");
                    AppBrandUILoadingSplash.this.setVisibility(8);
                    ((ViewGroup)AppBrandUILoadingSplash.3.1.this.mBv).removeView(AppBrandUILoadingSplash.this);
                    if (AppBrandUILoadingSplash.3.this.mBu != null) {
                      AppBrandUILoadingSplash.3.this.mBu.invoke();
                    }
                    AppMethodBeat.o(169533);
                  }
                });
              }
              AppMethodBeat.o(169534);
              return;
            }
          }
        });
        localValueAnimator.setStartDelay(Math.round(160.0F));
        localValueAnimator.setDuration(Math.round(40.0F));
        localValueAnimator.setInterpolator(new android.support.v4.view.b.a());
        localValueAnimator.start();
        localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
        ((ValueAnimator)localObject).setDuration(Math.round(160.0F));
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169535);
            float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
            AppBrandUILoadingSplash.d(AppBrandUILoadingSplash.this).setTextColor(Color.argb(Math.round(255.0F * f), Color.red(this.lYq), Color.green(this.lYq), Color.blue(this.lYq)));
            AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.f(AppBrandUILoadingSplash.this).setAlpha(f);
            paramAnonymous2ValueAnimator = AppBrandUILoadingSplash.this;
            int i = AppBrandUILoadingSplash.this.getResources().getColor(2131099650);
            if (!AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymous2ValueAnimator.L(i, bool);
              AppMethodBeat.o(169535);
              return;
            }
          }
        });
        ((ValueAnimator)localObject).setInterpolator(new android.support.v4.view.b.b());
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(169536);
      }
    });
    AppMethodBeat.o(192323);
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(147686);
    this.mFt.setBackgroundColor(paramInt);
    AppMethodBeat.o(147686);
  }
  
  public final void w(d.g.a.a<z> parama)
  {
    this.mCq = parama;
  }
  
  static abstract interface a
  {
    public abstract void a(ViewStub paramViewStub);
    
    public abstract void b(ViewStub paramViewStub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash
 * JD-Core Version:    0.7.0.1
 */