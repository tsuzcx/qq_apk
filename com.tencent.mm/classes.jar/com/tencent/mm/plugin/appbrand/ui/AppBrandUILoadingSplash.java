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
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.ak;

@SuppressLint({"ViewConstructor"})
public final class AppBrandUILoadingSplash
  extends com.tencent.mm.ui.statusbar.b
  implements q, w, y, z
{
  AppBrandRuntime jDb;
  private ImageView mFU;
  private TextView mFX;
  private AppBrandCircleProgressView mFZ;
  private TextView mGc;
  private Boolean mGr;
  private boolean mGs;
  private d.g.a.a<d.z> mHv;
  private boolean mKA;
  private a mKB;
  private ViewGroup mKx;
  private ViewStub mKy;
  private ViewStub mKz;
  
  @Keep
  public AppBrandUILoadingSplash(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(177512);
    this.mKA = true;
    this.mGs = false;
    init();
    AppMethodBeat.o(177512);
  }
  
  public AppBrandUILoadingSplash(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(147682);
    this.mKA = true;
    this.mGs = false;
    this.jDb = paramAppBrandRuntime;
    init();
    AppMethodBeat.o(147682);
  }
  
  private void aYx()
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this) != null)
        {
          if (AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169537);
            return;
          }
          h.a(AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).mAppId, h.d.jzh);
          AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169537);
          return;
          if (AppBrandUILoadingSplash.i(AppBrandUILoadingSplash.this) != null) {
            AppBrandUILoadingSplash.i(AppBrandUILoadingSplash.this).invoke();
          }
        }
      }
    };
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.mKx.findViewById(2131296402);
    View localView = this.mKx.findViewById(2131296399);
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
      localAppBrandOptionButton = (AppBrandOptionButton)this.mKx.findViewById(2131296401);
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
    if (!(this.jDb.getWindowAndroid() instanceof o))
    {
      AppMethodBeat.o(147689);
      return;
    }
    Object localObject = com.tencent.mm.sdk.f.a.jw(((o)this.jDb.getWindowAndroid()).mContext);
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
      t.a(paramConfiguration, false, false);
    }
    AppMethodBeat.o(147689);
  }
  
  private void init()
  {
    AppMethodBeat.i(177513);
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131496376, this);
    this.mFU = ((ImageView)findViewById(2131296765));
    this.mFU.setImageDrawable(ae.bAK());
    this.mFX = ((TextView)findViewById(2131296770));
    this.mFZ = ((AppBrandCircleProgressView)findViewById(2131303533));
    this.mFZ.setCircleColor(android.support.v4.content.b.n(getContext(), 2131099656));
    this.mFZ.setDotWidth(getResources().getDimensionPixelSize(2131167060));
    this.mFZ.setDotColor(android.support.v4.content.b.n(getContext(), 2131099699));
    this.mFZ.setCircleStrokeWidth(getResources().getDimensionPixelSize(2131167059));
    this.mFZ.setProgressColor(android.support.v4.content.b.n(getContext(), 2131099699));
    this.mFZ.setProgressWidth(getResources().getDimensionPixelSize(2131167061));
    if (ak.coh()) {
      this.mFZ.setTransitionTimingMs(2147483647);
    }
    this.mKx = ((ViewGroup)findViewById(2131296771));
    this.mKy = ((ViewStub)findViewById(2131300057));
    this.mKz = ((ViewStub)findViewById(2131308139));
    c.a("AppBrandUILoadingSplash setupRightButton", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147675);
        LayoutInflater.from(AppBrandUILoadingSplash.this.getContext()).inflate(2131496508, AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this));
        AppMethodBeat.o(147675);
      }
    });
    this.mFX.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.dX(getContext());
    aYx();
    AppMethodBeat.o(177513);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147683);
    com.tencent.mm.modelappbrand.a.b.aEl().a(this.mFU, paramString1, null, g.hOv);
    this.mFX.setText(paramString2);
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
    if (this.mGr == null) {
      this.mGr = Boolean.valueOf(i.cre.isDarkMode());
    }
    boolean bool = this.mGr.booleanValue();
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
      M(i, bool);
      this.mFZ.bzX();
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
  
  public final void rF(final int paramInt)
  {
    AppMethodBeat.i(147687);
    if (this.jDb == null)
    {
      AppMethodBeat.o(147687);
      return;
    }
    this.jDb.j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169538);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this) == null)
          {
            ((ViewStub)AppBrandUILoadingSplash.this.findViewById(2131296900)).inflate();
            AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this, (TextView)AppBrandUILoadingSplash.this.findViewById(2131301494));
          }
          AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this).setVisibility(0);
          AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this).setText(2131755950);
          AppBrandUILoadingSplash.k(AppBrandUILoadingSplash.this).setVisibility(8);
        }
        AppMethodBeat.o(169538);
      }
    }, 0L);
    AppMethodBeat.o(147687);
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    this.mKA = paramBoolean;
  }
  
  public final void setLabelInjector(a parama)
  {
    AppMethodBeat.i(220900);
    this.mKB = parama;
    if (this.mKB != null)
    {
      this.mKB.a(this.mKz);
      this.mKB.b(this.mKy);
    }
    AppMethodBeat.o(220900);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(220899);
    this.mFZ.setProgress(paramInt);
    AppMethodBeat.o(220899);
  }
  
  public final void uD(int paramInt)
  {
    AppMethodBeat.i(147686);
    this.mKx.setBackgroundColor(paramInt);
    AppMethodBeat.o(147686);
  }
  
  public final void v(final d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(220898);
    this.mGs = true;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", new Object[] { Boolean.valueOf(this.mKA) });
    if (!this.mKA)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
      final ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof ViewGroup))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
        AppMethodBeat.o(220898);
        return;
      }
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147679);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
          AppBrandUILoadingSplash.this.setVisibility(8);
          ((ViewGroup)localViewParent).removeView(AppBrandUILoadingSplash.this);
          if (parama != null) {
            parama.invoke();
          }
          AppMethodBeat.o(147679);
        }
      });
      AppMethodBeat.o(220898);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169536);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide with animation");
        Object localObject = AppBrandUILoadingSplash.this.getParent();
        if (!(localObject instanceof ViewGroup))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(169536);
          return;
        }
        AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).bzY();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169534);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            int j = Color.argb(i, Color.red(this.mKD), Color.green(this.mKD), Color.blue(this.mKD));
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
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, hide ends && remove splash");
                    AppBrandUILoadingSplash.this.setVisibility(8);
                    ((ViewGroup)AppBrandUILoadingSplash.3.1.this.mGA).removeView(AppBrandUILoadingSplash.this);
                    if (AppBrandUILoadingSplash.3.this.mGz != null) {
                      AppBrandUILoadingSplash.3.this.mGz.invoke();
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
            AppBrandUILoadingSplash.d(AppBrandUILoadingSplash.this).setTextColor(Color.argb(Math.round(255.0F * f), Color.red(this.mcX), Color.green(this.mcX), Color.blue(this.mcX)));
            AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.f(AppBrandUILoadingSplash.this).setAlpha(f);
            paramAnonymous2ValueAnimator = AppBrandUILoadingSplash.this;
            int i = AppBrandUILoadingSplash.this.getResources().getColor(2131099650);
            if (!AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymous2ValueAnimator.M(i, bool);
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
    AppMethodBeat.o(220898);
  }
  
  public final void x(d.g.a.a<d.z> parama)
  {
    this.mHv = parama;
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