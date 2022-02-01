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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import d.y;

@SuppressLint({"ViewConstructor"})
public final class AppBrandUILoadingSplash
  extends com.tencent.mm.ui.statusbar.b
  implements q, v, w, x
{
  AppBrandRuntime iGV;
  private d.g.a.a<y> lAm;
  private ViewGroup lDb;
  private boolean lDc;
  private ThreeDotsLoadingView luZ;
  private ImageView lyK;
  private TextView lyN;
  private TextView lyS;
  private Boolean lzi;
  
  @Keep
  public AppBrandUILoadingSplash(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(177512);
    this.lDc = true;
    init();
    AppMethodBeat.o(177512);
  }
  
  public AppBrandUILoadingSplash(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(147682);
    this.lDc = true;
    this.iGV = paramAppBrandRuntime;
    init();
    AppMethodBeat.o(147682);
  }
  
  private void aOa()
  {
    int j = -1;
    AppMethodBeat.i(177514);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169537);
        if (AppBrandUILoadingSplash.f(AppBrandUILoadingSplash.this) != null)
        {
          com.tencent.mm.plugin.appbrand.g.a(AppBrandUILoadingSplash.f(AppBrandUILoadingSplash.this).mAppId, g.d.iDc);
          AppBrandUILoadingSplash.f(AppBrandUILoadingSplash.this).finish();
          AppMethodBeat.o(169537);
          return;
        }
        if (AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this) != null) {
          AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).invoke();
        }
        AppMethodBeat.o(169537);
      }
    };
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.lDb.findViewById(2131296402);
    View localView = this.lDb.findViewById(2131296399);
    if (Eq())
    {
      i = 2131230978;
      localView.setBackgroundResource(i);
      localAppBrandOptionButton.reset();
      if (!Eq()) {
        break label129;
      }
      i = -1;
      label71:
      localAppBrandOptionButton.setColor(i);
      localAppBrandOptionButton = (AppBrandOptionButton)this.lDb.findViewById(2131296401);
      localAppBrandOptionButton.reset();
      if (!Eq()) {
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
    if (!(this.iGV.getWindowAndroid() instanceof o))
    {
      AppMethodBeat.o(147689);
      return;
    }
    Object localObject = com.tencent.mm.sdk.f.a.iV(((o)this.iGV.getWindowAndroid()).mContext);
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
      r.a(paramConfiguration, false, false);
    }
    AppMethodBeat.o(147689);
  }
  
  private void init()
  {
    AppMethodBeat.i(177513);
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493065, this);
    this.lyK = ((ImageView)findViewById(2131296765));
    this.lyK.setImageDrawable(ac.boO());
    this.lyN = ((TextView)findViewById(2131296770));
    this.luZ = ((ThreeDotsLoadingView)findViewById(2131296773));
    this.lDb = ((ViewGroup)findViewById(2131296771));
    com.tencent.luggage.sdk.g.c.a("AppBrandUILoadingSplash setupRightButton", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147675);
        LayoutInflater.from(AppBrandUILoadingSplash.this.getContext()).inflate(2131493066, AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this));
        AppMethodBeat.o(147675);
      }
    });
    int i = com.tencent.mm.plugin.appbrand.widget.b.dL(getContext());
    this.lyN.getLayoutParams().height = i;
    aOa();
    AppMethodBeat.o(177513);
  }
  
  final boolean Eq()
  {
    AppMethodBeat.i(162234);
    if (this.lzi == null) {
      this.lzi = Boolean.valueOf(i.cjn.Eq());
    }
    boolean bool = this.lzi.booleanValue();
    AppMethodBeat.o(162234);
    return bool;
  }
  
  public final void bhu()
  {
    AppMethodBeat.i(147684);
    ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", new Object[] { Boolean.valueOf(this.lDc) });
    if (!this.lDc)
    {
      final ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof ViewGroup))
      {
        ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
        AppMethodBeat.o(147684);
        return;
      }
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147679);
          ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
          AppBrandUILoadingSplash.this.setVisibility(8);
          ((ViewGroup)localViewParent).removeView(AppBrandUILoadingSplash.this);
          AppMethodBeat.o(147679);
        }
      });
      AppMethodBeat.o(147684);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169536);
        Object localObject = AppBrandUILoadingSplash.this.getParent();
        if (!(localObject instanceof ViewGroup))
        {
          ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(169536);
          return;
        }
        AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).ffc();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169534);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            int j = Color.argb(i, Color.red(this.lDe), Color.green(this.lDe), Color.blue(this.lDe));
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
                    ad.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
                    AppBrandUILoadingSplash.this.setVisibility(8);
                    ((ViewGroup)AppBrandUILoadingSplash.3.1.this.lzq).removeView(AppBrandUILoadingSplash.this);
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
            AppBrandUILoadingSplash.d(AppBrandUILoadingSplash.this).setTextColor(Color.argb(Math.round(255.0F * f), Color.red(this.kXi), Color.green(this.kXi), Color.blue(this.kXi)));
            AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this).setScaleY(f);
            AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this).setScaleX(f);
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
    AppMethodBeat.o(147684);
  }
  
  public final void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147683);
    com.tencent.mm.modelappbrand.a.b.aub().a(this.lyK, paramString1, null, com.tencent.mm.modelappbrand.a.g.gSK);
    this.lyN.setText(paramString2);
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
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(147685);
    super.onAttachedToWindow();
    int i = getResources().getColor(2131099650);
    boolean bool;
    if (!Eq()) {
      bool = true;
    }
    for (;;)
    {
      L(i, bool);
      this.luZ.ffb();
      try
      {
        d(getContext().getResources().getConfiguration());
        label57:
        if ((this.iGV != null) && (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class) != null) && (((com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class)).N(this.iGV)))
        {
          ad.i("MicroMsg.AppBrandUILoadingSplash", "onAttachedToWindow, may show launchAd, request orientation PORTRAIT, appId:%s", new Object[] { this.iGV.mAppId });
          this.iGV.getWindowAndroid().getOrientationHandler().a(e.b.lmO, null);
        }
        AppMethodBeat.o(147685);
        return;
        bool = false;
      }
      catch (Exception localException)
      {
        break label57;
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
  
  public final void q(d.g.a.a<y> parama)
  {
    this.lAm = parama;
  }
  
  public final void qp(final int paramInt)
  {
    AppMethodBeat.i(147687);
    if (this.iGV == null)
    {
      AppMethodBeat.o(147687);
      return;
    }
    this.iGV.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169538);
        ad.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this) == null)
          {
            ((ViewStub)AppBrandUILoadingSplash.this.findViewById(2131296900)).inflate();
            AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this, (TextView)AppBrandUILoadingSplash.this.findViewById(2131301494));
          }
          AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this).setVisibility(0);
          AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this).setText(2131755950);
        }
        AppMethodBeat.o(169538);
      }
    }, 0L);
    AppMethodBeat.o(147687);
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    this.lDc = paramBoolean;
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void tc(int paramInt)
  {
    AppMethodBeat.i(147686);
    this.lDb.setBackgroundColor(paramInt);
    AppMethodBeat.o(147686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash
 * JD-Core Version:    0.7.0.1
 */