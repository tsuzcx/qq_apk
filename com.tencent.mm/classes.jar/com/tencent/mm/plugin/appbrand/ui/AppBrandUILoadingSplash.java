package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
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
import androidx.annotation.Keep;
import androidx.core.g.w;
import com.tencent.luggage.k.j;
import com.tencent.luggage.l.a.a;
import com.tencent.luggage.l.a.b;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.launching.p;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;

@SuppressLint({"ViewConstructor"})
public final class AppBrandUILoadingSplash
  extends com.tencent.mm.ui.statusbar.b
  implements p, aa, ac, ad
{
  private boolean nnk;
  private AppBrandRuntime nxs;
  private TextView qUB;
  private Boolean qUQ;
  private boolean qUR;
  private ImageView qUt;
  private TextView qUw;
  private AppBrandCircleProgressView qUy;
  private kotlin.g.a.a<kotlin.x> qVQ;
  private ViewGroup qZh;
  private ViewStub qZi;
  private ViewStub qZj;
  private boolean qZk;
  private a qZl;
  
  @Keep
  public AppBrandUILoadingSplash(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(177512);
    this.nnk = false;
    this.qZk = true;
    this.qUR = false;
    init();
    AppMethodBeat.o(177512);
  }
  
  public AppBrandUILoadingSplash(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(147682);
    this.nnk = false;
    this.qZk = true;
    this.qUR = false;
    this.nxs = paramAppBrandRuntime;
    init();
    AppMethodBeat.o(147682);
  }
  
  private boolean So()
  {
    AppMethodBeat.i(234631);
    if ((this.nxs != null) && ((this.nxs instanceof com.tencent.luggage.sdk.e.d)) && (((com.tencent.luggage.sdk.e.d)this.nxs).So()))
    {
      AppMethodBeat.o(234631);
      return true;
    }
    AppMethodBeat.o(234631);
    return false;
  }
  
  private void aD(Context paramContext)
  {
    AppMethodBeat.i(234612);
    int i;
    if ((getContext() instanceof MutableContextWrapper))
    {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
      i = getBgColor();
      if (isDarkMode()) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      T(i, bool);
      AppMethodBeat.o(234612);
      return;
    }
  }
  
  private void bEK()
  {
    int j = -1;
    AppMethodBeat.i(177514);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169537);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this) != null)
        {
          if (AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169537);
            return;
          }
          k.a(AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).mAppId, k.d.ntb);
          AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169537);
          return;
          if (AppBrandUILoadingSplash.k(AppBrandUILoadingSplash.this) != null) {
            AppBrandUILoadingSplash.k(AppBrandUILoadingSplash.this).invoke();
          }
        }
      }
    };
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.qZh.findViewById(a.d.actionbar_capsule_option_btn);
    View localView = this.qZh.findViewById(a.d.actionbar_capsule_area);
    if (isDarkMode())
    {
      i = a.c.app_brand_game_capsule_dark_background;
      localView.setBackgroundResource(i);
      localAppBrandOptionButton.reset();
      if (!isDarkMode()) {
        break label134;
      }
      i = -1;
      label74:
      localAppBrandOptionButton.setColor(i);
      localAppBrandOptionButton = (AppBrandOptionButton)this.qZh.findViewById(a.d.actionbar_capsule_home_btn);
      localAppBrandOptionButton.reset();
      if (!isDarkMode()) {
        break label140;
      }
    }
    label134:
    label140:
    for (int i = j;; i = -16777216)
    {
      localAppBrandOptionButton.setColor(i);
      localAppBrandOptionButton.setOnClickListener(local4);
      AppMethodBeat.o(177514);
      return;
      i = a.c.app_brand_game_capsule_light_background;
      break;
      i = -16777216;
      break label74;
    }
  }
  
  private void d(Configuration paramConfiguration)
  {
    AppMethodBeat.i(147689);
    if (!(this.nxs.getWindowAndroid() instanceof o))
    {
      AppMethodBeat.o(147689);
      return;
    }
    Object localObject = AndroidContextUtil.castActivityOrNull(((o)this.nxs.getWindowAndroid()).mContext);
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
      x.a(paramConfiguration, false, false);
    }
    AppMethodBeat.o(147689);
  }
  
  private int getBgColor()
  {
    AppMethodBeat.i(234610);
    Resources localResources = getResources();
    if (this.nnk) {}
    for (int i = a.a.White;; i = a.a.BG_2)
    {
      i = localResources.getColor(i);
      AppMethodBeat.o(234610);
      return i;
    }
  }
  
  private int getNameTextColor()
  {
    AppMethodBeat.i(234608);
    if (this.nnk)
    {
      i = Color.parseColor("#E6000000");
      AppMethodBeat.o(234608);
      return i;
    }
    int i = getResources().getColor(a.a.normal_text_color);
    AppMethodBeat.o(234608);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(177513);
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(a.e.app_brand_circle_splash_ui, this);
    this.qUt = ((ImageView)findViewById(a.d.app_brand_loading_avatar));
    this.qUt.setImageDrawable(ak.ckz());
    this.qUw = ((TextView)findViewById(a.d.app_brand_loading_name));
    this.qUy = ((AppBrandCircleProgressView)findViewById(a.d.circle_progress_view));
    this.qUy.setCircleColor(androidx.core.content.a.w(getContext(), a.a.BW_0_Alpha_0_1));
    this.qUy.setDotWidth(getResources().getDimensionPixelSize(a.b.app_brand_loading_dotWidth));
    this.qUy.setDotColor(androidx.core.content.a.w(getContext(), a.a.Brand));
    this.qUy.setCircleStrokeWidth(getResources().getDimensionPixelSize(a.b.app_brand_loading_circleWidth));
    this.qUy.setProgressColor(androidx.core.content.a.w(getContext(), a.a.Brand));
    this.qUy.setProgressWidth(getResources().getDimensionPixelSize(a.b.app_brand_loading_progressWidth));
    if (MMApplicationContext.isMainProcess()) {
      this.qUy.setTransitionTimingMs(2147483647);
    }
    this.qZh = ((ViewGroup)findViewById(a.d.app_brand_loading_root));
    this.qZi = ((ViewStub)findViewById(a.d.bottom_label_placeholder));
    this.qZj = ((ViewStub)findViewById(a.d.label_placeholder));
    com.tencent.luggage.sdk.h.d.a("AppBrandUILoadingSplash setupRightButton", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147675);
        if ((AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this) != null) && (AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).getDecorWidgetFactory() != null))
        {
          com.tencent.mm.plugin.appbrand.page.capsulebar.d locald = (com.tencent.mm.plugin.appbrand.page.capsulebar.d)AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).getDecorWidgetFactory().d(AppBrandUILoadingSplash.this.getContext(), com.tencent.mm.plugin.appbrand.page.capsulebar.d.class);
          AppBrandUILoadingSplash.this.setActionBar(locald);
          AppMethodBeat.o(147675);
          return;
        }
        LayoutInflater.from(AppBrandUILoadingSplash.this.getContext()).inflate(a.e.app_brand_capsule_bar_view_layout, AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this));
        AppMethodBeat.o(147675);
      }
    });
    this.qUw.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.ew(getContext());
    bEK();
    AppMethodBeat.o(177513);
  }
  
  private boolean isDarkMode()
  {
    AppMethodBeat.i(162234);
    if (this.nnk)
    {
      AppMethodBeat.o(162234);
      return false;
    }
    if (this.qUQ == null) {
      this.qUQ = Boolean.valueOf(j.cEc.isDarkMode());
    }
    boolean bool = this.qUQ.booleanValue();
    AppMethodBeat.o(162234);
    return bool;
  }
  
  public final void A(kotlin.g.a.a<kotlin.x> parama)
  {
    this.qVQ = parama;
  }
  
  public final void BU(int paramInt)
  {
    AppMethodBeat.i(147686);
    this.qZh.setBackgroundColor(paramInt);
    AppMethodBeat.o(147686);
  }
  
  public final void ao(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(234611);
    Log.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", new Object[] { paramAppBrandRuntime.Sq().fzM });
    this.nxs = paramAppBrandRuntime;
    if (AndroidContextUtil.castActivityOrNull(paramAppBrandRuntime.mContext) != null) {
      aD(AndroidContextUtil.castActivityOrNull(paramAppBrandRuntime.mContext));
    }
    AppMethodBeat.o(234611);
  }
  
  public final void eC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147683);
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.qUt, paramString1, null, g.lzF);
    this.qUw.setText(paramString2);
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
  
  public final void jM(boolean paramBoolean)
  {
    AppMethodBeat.i(234606);
    this.nnk = paramBoolean;
    this.qZh.setBackgroundColor(getBgColor());
    this.qUw.setTextColor(getNameTextColor());
    AppMethodBeat.o(234606);
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(147685);
    super.onAttachedToWindow();
    int i = getBgColor();
    if (!isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      T(i, bool);
      this.qUy.cjx();
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
    AppMethodBeat.i(234634);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(234634);
      return false;
    }
    if ((!w.al(this)) && (So()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(234634);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(234634);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(234635);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(234635);
      return false;
    }
    if ((!w.al(this)) && (So()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(234635);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(234635);
    return bool;
  }
  
  public final void setActionBar(View paramView)
  {
    AppMethodBeat.i(234605);
    View localView = this.qZh.findViewById(a.d.app_brand_ui_loading_splash_action_bar);
    if (localView != null) {
      this.qZh.removeView(localView);
    }
    paramView.setId(a.d.app_brand_ui_loading_splash_action_bar);
    this.qZh.addView(paramView, -1, paramView.getResources().getDimensionPixelSize(a.b.DefaultActionbarHeight));
    AppMethodBeat.o(234605);
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    this.qZk = paramBoolean;
  }
  
  public final void setLabelInjector(a parama)
  {
    AppMethodBeat.i(234629);
    this.qZl = parama;
    if (this.qZl != null)
    {
      this.qZl.a(this.qZj);
      this.qZl.b(this.qZi);
    }
    AppMethodBeat.o(234629);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(234621);
    this.qUy.setProgress(paramInt);
    AppMethodBeat.o(234621);
  }
  
  public final void x(final kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(234613);
    this.qUR = true;
    Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", new Object[] { Boolean.valueOf(this.qZk) });
    if (!this.qZk)
    {
      Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
      final ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof ViewGroup))
      {
        Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
        AppMethodBeat.o(234613);
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
      AppMethodBeat.o(234613);
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
        AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this).cjy();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169534);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            int j = Color.argb(i, Color.red(this.qZn), Color.green(this.qZn), Color.blue(this.qZn));
            AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).setBackgroundColor(j);
            paramAnonymous2ValueAnimator = AppBrandUILoadingSplash.this;
            if (!AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this)) {}
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
                    ((ViewGroup)AppBrandUILoadingSplash.3.1.this.qUZ).removeView(AppBrandUILoadingSplash.this);
                    if (AppBrandUILoadingSplash.3.this.qUY != null) {
                      AppBrandUILoadingSplash.3.this.qUY.invoke();
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
        localValueAnimator.setInterpolator(new androidx.f.a.a.a());
        localValueAnimator.start();
        localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
        ((ValueAnimator)localObject).setDuration(Math.round(160.0F));
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169535);
            float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
            AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).setTextColor(Color.argb(Math.round(255.0F * f), Color.red(this.qoT), Color.green(this.qoT), Color.blue(this.qoT)));
            AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.i(AppBrandUILoadingSplash.this).setAlpha(f);
            paramAnonymous2ValueAnimator = AppBrandUILoadingSplash.this;
            int i = AppBrandUILoadingSplash.d(AppBrandUILoadingSplash.this);
            if (!AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymous2ValueAnimator.T(i, bool);
              AppMethodBeat.o(169535);
              return;
            }
          }
        });
        ((ValueAnimator)localObject).setInterpolator(new androidx.f.a.a.b());
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(169536);
      }
    });
    AppMethodBeat.o(234613);
  }
  
  public final void yL(final int paramInt)
  {
    AppMethodBeat.i(147687);
    if (this.nxs == null)
    {
      AppMethodBeat.o(147687);
      return;
    }
    this.nxs.h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169538);
        Log.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (AppBrandUILoadingSplash.l(AppBrandUILoadingSplash.this) == null)
          {
            ((ViewStub)AppBrandUILoadingSplash.this.findViewById(a.d.appbrand_splash_loading_data_tip_viewstub)).inflate();
            AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this, (TextView)AppBrandUILoadingSplash.this.findViewById(a.d.loading_data_tip));
          }
          AppBrandUILoadingSplash.l(AppBrandUILoadingSplash.this).setVisibility(0);
          AppBrandUILoadingSplash.l(AppBrandUILoadingSplash.this).setText(a.g.appbrand_data_transfer_tip);
          AppBrandUILoadingSplash.m(AppBrandUILoadingSplash.this).setVisibility(8);
        }
        AppMethodBeat.o(169538);
      }
    }, 0L);
    AppMethodBeat.o(147687);
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