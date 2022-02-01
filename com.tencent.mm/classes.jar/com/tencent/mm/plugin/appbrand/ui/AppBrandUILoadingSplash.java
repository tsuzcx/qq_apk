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
import android.support.v4.view.u;
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
import com.tencent.luggage.h.j;
import com.tencent.luggage.sdk.d.d;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public final class AppBrandUILoadingSplash
  extends com.tencent.mm.ui.statusbar.b
  implements q, ab, ad, ae
{
  AppBrandRuntime kEc;
  private ImageView nSS;
  private TextView nSV;
  private AppBrandCircleProgressView nSX;
  private TextView nTa;
  private Boolean nTp;
  private boolean nTq;
  private kotlin.g.a.a<x> nUt;
  private ViewStub nXA;
  private ViewStub nXB;
  private boolean nXC;
  private a nXD;
  private ViewGroup nXz;
  
  @Keep
  public AppBrandUILoadingSplash(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(177512);
    this.nXC = true;
    this.nTq = false;
    init();
    AppMethodBeat.o(177512);
  }
  
  public AppBrandUILoadingSplash(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(147682);
    this.nXC = true;
    this.nTq = false;
    this.kEc = paramAppBrandRuntime;
    init();
    AppMethodBeat.o(147682);
  }
  
  private boolean OS()
  {
    AppMethodBeat.i(230008);
    if ((this.kEc != null) && ((this.kEc instanceof d)) && (((d)this.kEc).OS()))
    {
      AppMethodBeat.o(230008);
      return true;
    }
    AppMethodBeat.o(230008);
    return false;
  }
  
  private void btL()
  {
    int j = -1;
    AppMethodBeat.i(177514);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169537);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this) != null)
        {
          if (AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169537);
            return;
          }
          h.a(AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).mAppId, h.d.kzP);
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
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.nXz.findViewById(2131296428);
    View localView = this.nXz.findViewById(2131296424);
    if (isDarkMode())
    {
      i = 2131231007;
      localView.setBackgroundResource(i);
      localAppBrandOptionButton.reset();
      if (!isDarkMode()) {
        break label129;
      }
      i = -1;
      label71:
      localAppBrandOptionButton.setColor(i);
      localAppBrandOptionButton = (AppBrandOptionButton)this.nXz.findViewById(2131296427);
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
      i = 2131231008;
      break;
      i = -16777216;
      break label71;
    }
  }
  
  private void d(Configuration paramConfiguration)
  {
    AppMethodBeat.i(147689);
    if (!(this.kEc.getWindowAndroid() instanceof o))
    {
      AppMethodBeat.o(147689);
      return;
    }
    Object localObject = AndroidContextUtil.castActivityOrNull(((o)this.kEc.getWindowAndroid()).mContext);
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
      y.a(paramConfiguration, false, false);
    }
    AppMethodBeat.o(147689);
  }
  
  private void init()
  {
    AppMethodBeat.i(177513);
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493017, this);
    this.nSS = ((ImageView)findViewById(2131296847));
    this.nSS.setImageDrawable(ak.bXP());
    this.nSV = ((TextView)findViewById(2131296852));
    this.nSX = ((AppBrandCircleProgressView)findViewById(2131298730));
    this.nSX.setCircleColor(android.support.v4.content.b.n(getContext(), 2131099657));
    this.nSX.setDotWidth(getResources().getDimensionPixelSize(2131165839));
    this.nSX.setDotColor(android.support.v4.content.b.n(getContext(), 2131099710));
    this.nSX.setCircleStrokeWidth(getResources().getDimensionPixelSize(2131165838));
    this.nSX.setProgressColor(android.support.v4.content.b.n(getContext(), 2131099710));
    this.nSX.setProgressWidth(getResources().getDimensionPixelSize(2131165840));
    if (MMApplicationContext.isMainProcess()) {
      this.nSX.setTransitionTimingMs(2147483647);
    }
    this.nXz = ((ViewGroup)findViewById(2131296853));
    this.nXA = ((ViewStub)findViewById(2131297678));
    this.nXB = ((ViewStub)findViewById(2131302998));
    c.a("AppBrandUILoadingSplash setupRightButton", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147675);
        LayoutInflater.from(AppBrandUILoadingSplash.this.getContext()).inflate(2131493016, AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this));
        AppMethodBeat.o(147675);
      }
    });
    this.nSV.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.eu(getContext());
    btL();
    AppMethodBeat.o(177513);
  }
  
  public final void C(kotlin.g.a.a<x> parama)
  {
    this.nUt = parama;
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147683);
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.nSS, paramString1, null, g.iJB);
    this.nSV.setText(paramString2);
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
    if (this.nTp == null) {
      this.nTp = Boolean.valueOf(j.cDv.isDarkMode());
    }
    boolean bool = this.nTp.booleanValue();
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
      S(i, bool);
      this.nSX.bWT();
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
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(230009);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(230009);
      return false;
    }
    if ((!u.aD(this)) && (OS()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(230009);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(230009);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(230010);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(230010);
      return false;
    }
    if ((!u.aD(this)) && (OS()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(230010);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(230010);
    return bool;
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    this.nXC = paramBoolean;
  }
  
  public final void setLabelInjector(a parama)
  {
    AppMethodBeat.i(230007);
    this.nXD = parama;
    if (this.nXD != null)
    {
      this.nXD.a(this.nXB);
      this.nXD.b(this.nXA);
    }
    AppMethodBeat.o(230007);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(230006);
    this.nSX.setProgress(paramInt);
    AppMethodBeat.o(230006);
  }
  
  public final void vy(final int paramInt)
  {
    AppMethodBeat.i(147687);
    if (this.kEc == null)
    {
      AppMethodBeat.o(147687);
      return;
    }
    this.kEc.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169538);
        Log.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this) == null)
          {
            ((ViewStub)AppBrandUILoadingSplash.this.findViewById(2131297000)).inflate();
            AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this, (TextView)AppBrandUILoadingSplash.this.findViewById(2131303696));
          }
          AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this).setVisibility(0);
          AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this).setText(2131756048);
          AppBrandUILoadingSplash.k(AppBrandUILoadingSplash.this).setVisibility(8);
        }
        AppMethodBeat.o(169538);
      }
    }, 0L);
    AppMethodBeat.o(147687);
  }
  
  public final void yu(int paramInt)
  {
    AppMethodBeat.i(147686);
    this.nXz.setBackgroundColor(paramInt);
    AppMethodBeat.o(147686);
  }
  
  public final void z(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(230005);
    this.nTq = true;
    Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", new Object[] { Boolean.valueOf(this.nXC) });
    if (!this.nXC)
    {
      Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
      final ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof ViewGroup))
      {
        Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
        AppMethodBeat.o(230005);
        return;
      }
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147679);
          Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
          AppBrandUILoadingSplash.this.setVisibility(8);
          ((ViewGroup)localViewParent).removeView(AppBrandUILoadingSplash.this);
          if (parama != null) {
            parama.invoke();
          }
          AppMethodBeat.o(147679);
        }
      });
      AppMethodBeat.o(230005);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169536);
        Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide with animation");
        Object localObject = AppBrandUILoadingSplash.this.getParent();
        if (!(localObject instanceof ViewGroup))
        {
          Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(169536);
          return;
        }
        AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).bWU();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169534);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            int j = Color.argb(i, Color.red(this.nXF), Color.green(this.nXF), Color.blue(this.nXF));
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
                    Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, hide ends && remove splash");
                    AppBrandUILoadingSplash.this.setVisibility(8);
                    ((ViewGroup)AppBrandUILoadingSplash.3.1.this.nTy).removeView(AppBrandUILoadingSplash.this);
                    if (AppBrandUILoadingSplash.3.this.nTx != null) {
                      AppBrandUILoadingSplash.3.this.nTx.invoke();
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
            AppBrandUILoadingSplash.d(AppBrandUILoadingSplash.this).setTextColor(Color.argb(Math.round(255.0F * f), Color.red(this.nnl), Color.green(this.nnl), Color.blue(this.nnl)));
            AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.f(AppBrandUILoadingSplash.this).setAlpha(f);
            paramAnonymous2ValueAnimator = AppBrandUILoadingSplash.this;
            int i = AppBrandUILoadingSplash.this.getResources().getColor(2131099650);
            if (!AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymous2ValueAnimator.S(i, bool);
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
    AppMethodBeat.o(230005);
  }
  
  static abstract interface a
  {
    public abstract void a(ViewStub paramViewStub);
    
    public abstract void b(ViewStub paramViewStub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash
 * JD-Core Version:    0.7.0.1
 */