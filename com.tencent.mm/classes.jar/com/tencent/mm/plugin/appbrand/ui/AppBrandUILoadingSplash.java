package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import androidx.core.g.z;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.List;

public final class AppBrandUILoadingSplash
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.launching.q, ah, aj, ak
{
  private AppBrandRuntime qwG;
  private ImageView tZX;
  private TextView uab;
  private AppBrandCircleProgressView uae;
  private TextView uah;
  private Boolean uax;
  private boolean uay;
  private kotlin.g.a.a<kotlin.ah> uby;
  ViewGroup ufi;
  private ViewStub ufj;
  private ViewStub ufk;
  private HalfScreenConfig.f ufl;
  private boolean ufm;
  private a ufn;
  
  public AppBrandUILoadingSplash(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(177512);
    this.ufl = HalfScreenConfig.f.rav;
    this.ufm = true;
    this.uay = false;
    init();
    AppMethodBeat.o(177512);
  }
  
  public AppBrandUILoadingSplash(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(147682);
    this.ufl = HalfScreenConfig.f.rav;
    this.ufm = true;
    this.uay = false;
    this.qwG = paramAppBrandRuntime;
    init();
    AppMethodBeat.o(147682);
  }
  
  private boolean asE()
  {
    AppMethodBeat.i(322073);
    if ((this.qwG != null) && ((this.qwG instanceof com.tencent.luggage.sdk.e.d)) && (((com.tencent.luggage.sdk.e.d)this.qwG).asE()))
    {
      AppMethodBeat.o(322073);
      return true;
    }
    AppMethodBeat.o(322073);
    return false;
  }
  
  private void bm(Context paramContext)
  {
    AppMethodBeat.i(322053);
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
      aj(i, bool);
      AppMethodBeat.o(322053);
      return;
    }
  }
  
  private void cdV()
  {
    int j = -1;
    AppMethodBeat.i(177514);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169537);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this) != null)
        {
          if (AppBrandUILoadingSplash.j(AppBrandUILoadingSplash.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169537);
            return;
          }
          com.tencent.mm.plugin.appbrand.k.a(AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).mAppId, k.d.qrG);
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
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.ufi.findViewById(a.d.actionbar_capsule_option_btn);
    View localView = this.ufi.findViewById(a.d.actionbar_capsule_area);
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
      localAppBrandOptionButton = (AppBrandOptionButton)this.ufi.findViewById(a.d.actionbar_capsule_home_btn);
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
  
  private void f(Configuration paramConfiguration)
  {
    AppMethodBeat.i(147689);
    if (!(this.qwG.getWindowAndroid() instanceof o))
    {
      AppMethodBeat.o(147689);
      return;
    }
    Object localObject = AndroidContextUtil.castActivityOrNull(((o)this.qwG.getWindowAndroid()).mContext);
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
      ae.a(paramConfiguration, false, false);
    }
    AppMethodBeat.o(147689);
  }
  
  private int getBgColor()
  {
    AppMethodBeat.i(322048);
    switch (6.ufs[this.ufl.ordinal()])
    {
    default: 
      i = getResources().getColor(a.a.BG_2);
      AppMethodBeat.o(322048);
      return i;
    case 1: 
      i = getResources().getColor(a.a.BG_2);
      AppMethodBeat.o(322048);
      return i;
    case 2: 
      i = getResources().getColor(a.a.White);
      AppMethodBeat.o(322048);
      return i;
    }
    int i = Color.parseColor("#191919");
    AppMethodBeat.o(322048);
    return i;
  }
  
  private int getNameTextColor()
  {
    AppMethodBeat.i(322040);
    switch (6.ufs[this.ufl.ordinal()])
    {
    default: 
      i = getResources().getColor(a.a.normal_text_color);
      AppMethodBeat.o(322040);
      return i;
    case 1: 
      i = getResources().getColor(a.a.normal_text_color);
      AppMethodBeat.o(322040);
      return i;
    case 2: 
      i = Color.parseColor("#E6000000");
      AppMethodBeat.o(322040);
      return i;
    }
    int i = Color.parseColor("#CCFFFFFF");
    AppMethodBeat.o(322040);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(177513);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(a.e.app_brand_circle_splash_ui, this);
    this.tZX = ((ImageView)findViewById(a.d.app_brand_loading_avatar));
    this.tZX.setImageDrawable(as.cLN());
    this.uab = ((TextView)findViewById(a.d.app_brand_loading_name));
    this.uae = ((AppBrandCircleProgressView)findViewById(a.d.circle_progress_view));
    cLA();
    this.uae.setCircleColor(androidx.core.content.a.w(getContext(), a.a.BW_0_Alpha_0_1));
    this.uae.setDotWidth(getResources().getDimensionPixelSize(a.b.app_brand_loading_dotWidth));
    this.uae.setDotColor(androidx.core.content.a.w(getContext(), a.a.Brand));
    this.uae.setCircleStrokeWidth(getResources().getDimensionPixelSize(a.b.app_brand_loading_circleWidth));
    this.uae.setProgressColor(androidx.core.content.a.w(getContext(), a.a.Brand));
    this.uae.setProgressWidth(getResources().getDimensionPixelSize(a.b.app_brand_loading_progressWidth));
    if (MMApplicationContext.isMainProcess()) {
      this.uae.setTransitionTimingMs(2147483647);
    }
    this.ufi = ((ViewGroup)findViewById(a.d.app_brand_loading_root));
    this.ufj = ((ViewStub)findViewById(a.d.bottom_label_placeholder));
    this.ufk = ((ViewStub)findViewById(a.d.label_placeholder));
    com.tencent.luggage.sdk.h.d.a("AppBrandUILoadingSplash setupRightButton", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147675);
        if ((AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this) != null) && (AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).getDecorWidgetFactory() != null))
        {
          com.tencent.mm.plugin.appbrand.page.capsulebar.d locald = (com.tencent.mm.plugin.appbrand.page.capsulebar.d)AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this).getDecorWidgetFactory().e(AppBrandUILoadingSplash.this.getContext(), com.tencent.mm.plugin.appbrand.page.capsulebar.d.class);
          AppBrandUILoadingSplash.this.setActionBar(locald);
          AppMethodBeat.o(147675);
          return;
        }
        AppBrandUILoadingSplash.this.setActionBar(LayoutInflater.from(AppBrandUILoadingSplash.this.getContext()).inflate(a.e.app_brand_capsule_bar_view_layout, null));
        AppMethodBeat.o(147675);
      }
    });
    this.uab.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.fs(getContext());
    cdV();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(a.d.app_brand_loading_name));
    localArrayList.add(Integer.valueOf(a.d.actionbar_capsule_option_btn));
    localArrayList.add(Integer.valueOf(a.d.actionbar_capsule_home_btn));
    i.b(localArrayList, getView());
    AppMethodBeat.o(177513);
  }
  
  private boolean isDarkMode()
  {
    AppMethodBeat.i(162234);
    if (this.ufl == HalfScreenConfig.f.raw)
    {
      AppMethodBeat.o(162234);
      return false;
    }
    if (this.uax == null) {
      this.uax = Boolean.valueOf(com.tencent.luggage.l.k.exm.isDarkMode());
    }
    boolean bool = this.uax.booleanValue();
    AppMethodBeat.o(162234);
    return bool;
  }
  
  public final void Cj(int paramInt)
  {
    AppMethodBeat.i(147686);
    this.ufi.setBackgroundColor(paramInt);
    AppMethodBeat.o(147686);
  }
  
  public final void aC(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(322130);
    Log.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", new Object[] { paramAppBrandRuntime.asH().hEy });
    this.qwG = paramAppBrandRuntime;
    if (AndroidContextUtil.castActivityOrNull(paramAppBrandRuntime.mContext) != null) {
      bm(AndroidContextUtil.castActivityOrNull(paramAppBrandRuntime.mContext));
    }
    AppMethodBeat.o(322130);
  }
  
  public final void as(final kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322142);
    this.uay = true;
    Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", new Object[] { Boolean.valueOf(this.ufm) });
    if (!this.ufm)
    {
      Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
      final ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof ViewGroup))
      {
        Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
        AppMethodBeat.o(322142);
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
      AppMethodBeat.o(322142);
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
        AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).cKJ();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169534);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            int j = Color.argb(i, Color.red(this.ufp), Color.green(this.ufp), Color.blue(this.ufp));
            AppBrandUILoadingSplash.d(AppBrandUILoadingSplash.this).setBackgroundColor(j);
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
                    ((ViewGroup)AppBrandUILoadingSplash.3.1.this.uaG).removeView(AppBrandUILoadingSplash.this);
                    if (AppBrandUILoadingSplash.3.this.uaF != null) {
                      AppBrandUILoadingSplash.3.this.uaF.invoke();
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
        localValueAnimator.setInterpolator(new androidx.g.a.a.a());
        localValueAnimator.start();
        localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
        ((ValueAnimator)localObject).setDuration(Math.round(160.0F));
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(169535);
            float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
            AppBrandUILoadingSplash.g(AppBrandUILoadingSplash.this).setTextColor(Color.argb(Math.round(255.0F * f), Color.red(this.ttw), Color.green(this.ttw), Color.blue(this.ttw)));
            AppBrandUILoadingSplash.b(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.h(AppBrandUILoadingSplash.this).setAlpha(f);
            AppBrandUILoadingSplash.i(AppBrandUILoadingSplash.this).setAlpha(f);
            paramAnonymous2ValueAnimator = AppBrandUILoadingSplash.this;
            int i = AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this);
            if (!AppBrandUILoadingSplash.e(AppBrandUILoadingSplash.this)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymous2ValueAnimator.aj(i, bool);
              AppMethodBeat.o(169535);
              return;
            }
          }
        });
        ((ValueAnimator)localObject).setInterpolator(new androidx.g.a.a.b());
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(169536);
      }
    });
    AppMethodBeat.o(322142);
  }
  
  public final void av(kotlin.g.a.a<kotlin.ah> parama)
  {
    this.uby = parama;
  }
  
  public final void cLA()
  {
    AppMethodBeat.i(322119);
    q.a(this.tZX, this.uae, this.uab);
    AppMethodBeat.o(322119);
  }
  
  public final void eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147683);
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.tZX, paramString1, null, g.org);
    this.uab.setText(paramString2);
    AppMethodBeat.o(147683);
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(322192);
    int i = this.uae.getProgress();
    AppMethodBeat.o(322192);
    return i;
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
    int i = getBgColor();
    if (!isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      aj(i, bool);
      this.uae.cKI();
      try
      {
        f(getContext().getResources().getConfiguration());
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
      f(paramConfiguration);
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
    AppMethodBeat.i(322184);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(322184);
      return false;
    }
    if ((!z.ay(this)) && (asE()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(322184);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(322184);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(322188);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(322188);
      return false;
    }
    if ((!z.ay(this)) && (asE()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(322188);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(322188);
    return bool;
  }
  
  public final void setActionBar(View paramView)
  {
    AppMethodBeat.i(322124);
    View localView = this.ufi.findViewById(a.d.app_brand_ui_loading_splash_action_bar);
    if (localView != null) {
      this.ufi.removeView(localView);
    }
    paramView.setId(a.d.app_brand_ui_loading_splash_action_bar);
    this.ufi.addView(paramView, -1, paramView.getResources().getDimensionPixelSize(a.b.DefaultActionbarHeight));
    AppMethodBeat.o(322124);
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    this.ufm = paramBoolean;
  }
  
  public final void setLabelInjector(a parama)
  {
    AppMethodBeat.i(322178);
    this.ufn = parama;
    if (this.ufn != null)
    {
      this.ufn.a(this.ufk);
      this.ufn.b(this.ufj);
    }
    AppMethodBeat.o(322178);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(322160);
    this.uae.setProgress(paramInt);
    AppMethodBeat.o(322160);
  }
  
  public final void setTheme(HalfScreenConfig.f paramf)
  {
    AppMethodBeat.i(322126);
    this.ufl = paramf;
    this.ufi.setBackgroundColor(getBgColor());
    this.uab.setTextColor(getNameTextColor());
    AppMethodBeat.o(322126);
  }
  
  public final void yU(final int paramInt)
  {
    AppMethodBeat.i(147687);
    if (this.qwG == null)
    {
      AppMethodBeat.o(147687);
      return;
    }
    this.qwG.i(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash
 * JD-Core Version:    0.7.0.1
 */