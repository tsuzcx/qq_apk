package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.p;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.List;

final class e
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.launching.q, ah
{
  private w qts;
  private ImageView tZX;
  private ImageView tZY;
  private ImageView tZZ;
  private ImageView uaa;
  private TextView uab;
  private TextView uac;
  private LinearLayout uad;
  private AppBrandCircleProgressView uae;
  private d uaf;
  private com.tencent.mm.plugin.appbrand.platform.window.e.b uag;
  private TextView uah;
  private boolean uai;
  private Runnable uaj;
  private RelativeLayout uak;
  private final int ual;
  private boolean uam;
  private boolean uan;
  private boolean uao;
  private int uap;
  private boolean uaq;
  private int uar;
  private RelativeLayout uas;
  private ImageView uat;
  private BootstrapProgressBar uau;
  private boolean uav;
  private boolean uaw;
  private Boolean uax;
  private boolean uay;
  
  public e(Context paramContext, w paramw)
  {
    super(paramContext);
    AppMethodBeat.i(48602);
    this.uag = com.tencent.mm.plugin.appbrand.platform.window.e.b.tLh;
    this.uaj = null;
    this.ual = 11;
    this.uam = false;
    this.uan = false;
    this.uao = false;
    this.uaq = false;
    this.uar = 30;
    this.uay = false;
    this.qts = paramw;
    Log.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(ba.g.app_brand_splash_game_ui, this);
    this.uas = ((RelativeLayout)findViewById(ba.f.app_brand_game_custom_splashscreen));
    this.uat = ((ImageView)findViewById(ba.f.app_brand_game_custom_splashscreen_img));
    this.uau = ((BootstrapProgressBar)findViewById(ba.f.app_brand_game_custom_splashscreen_progressbar));
    com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(999, 1);
    if ((((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWA, false)) && (this.qts != null))
    {
      final long l = Util.currentTicks();
      paramw = this.qts.getInitConfig();
      if (paramw.epa.rcn == null)
      {
        paramContext = null;
        if (Util.isNullOrNil(paramContext)) {
          break label1393;
        }
        this.uam = true;
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramContext });
        com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(1000, 1);
        com.tencent.mm.ci.a.post(new e.4(this, paramContext, new a.a()
        {
          public final void a(final Bitmap paramAnonymousBitmap, final long paramAnonymousLong)
          {
            AppMethodBeat.i(322353);
            Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
            e.b(e.this);
            if (e.c(e.this) != null) {
              o.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(322577);
                  if (paramAnonymousBitmap != null)
                  {
                    e.c(e.this).setImageBitmap(paramAnonymousBitmap);
                    if (e.d(e.this)) {
                      e.e(e.this);
                    }
                    com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(1002, (int)Util.ticksToNow(e.3.this.uaA));
                    com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(1001, (int)paramAnonymousLong);
                  }
                  AppMethodBeat.o(322577);
                }
              });
            }
            AppMethodBeat.o(322353);
          }
        }));
        if (paramw.epa.rcn != null) {
          break label1406;
        }
        paramContext = (Context)localObject;
        label279:
        if (Util.isNullOrNil(paramContext)) {
          break label1420;
        }
        this.uap = Color.parseColor(paramContext);
        this.uau.setProgressColor(this.uap);
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.uap) });
        label327:
        this.uau.setAnimated(true);
        this.uau.setStriped(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48592);
            e.f(e.this);
            Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (e.g(e.this)) {
              e.e(e.this);
            }
            AppMethodBeat.o(48592);
          }
        }, 1000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48595);
            if (e.g(e.this))
            {
              AppMethodBeat.o(48595);
              return;
            }
            e.h(e.this);
            e.i(e.this).setVisibility(0);
            e.j(e.this);
            AppMethodBeat.o(48595);
          }
        }, 2000L);
      }
    }
    else
    {
      label371:
      this.uak = ((RelativeLayout)findViewById(ba.f.app_brand_game_policy_loading));
      this.tZX = ((ImageView)findViewById(ba.f.app_brand_game_loading_avatar));
      this.tZX.setImageDrawable(com.tencent.mm.modelappbrand.a.a.bEX());
      this.uab = ((TextView)findViewById(ba.f.app_brand_game_loading_name));
      this.tZY = ((ImageView)findViewById(ba.f.app_brand_game_wagame_name));
      this.tZZ = ((ImageView)findViewById(ba.f.app_brand_game_loading_original));
      this.uad = ((LinearLayout)findViewById(ba.f.app_brand_game_loading_ab_container));
      this.uah = ((TextView)findViewById(ba.f.loading_data_tip));
      this.uae = ((AppBrandCircleProgressView)findViewById(ba.f.app_brand_game_loading_circle_progress_view));
      this.uae.setCircleColor(getResources().getColor(ba.c.BW_0_Alpha_0_1));
      this.uae.setDotWidth(getResources().getDimensionPixelSize(ba.d.app_brand_loading_dotWidth));
      this.uae.setDotColor(getResources().getColor(ba.c.Brand));
      this.uae.setCircleStrokeWidth(getResources().getDimensionPixelSize(ba.d.app_brand_loading_circleWidth));
      this.uae.setProgressColor(getResources().getColor(ba.c.Brand));
      this.uae.setProgressWidth(getResources().getDimensionPixelSize(ba.d.app_brand_loading_progressWidth));
      if (MMApplicationContext.isMainProcess()) {
        this.uae.setTransitionTimingMs(2147483647);
      }
      paramContext = (RelativeLayout.LayoutParams)this.tZZ.getLayoutParams();
      paramw = (RelativeLayout.LayoutParams)this.tZY.getLayoutParams();
      this.uaf = ((d)this.qts.ccx().e(getContext(), d.class));
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 21;
      p.dG(this.uaf);
      this.uad.addView(this.uaf, (ViewGroup.LayoutParams)localObject);
      p.dH(this.uad);
      if (this.qts.getInitConfig().originalFlag != 1) {
        break label1451;
      }
      this.tZZ.setVisibility(0);
      label728:
      localObject = (RelativeLayout.LayoutParams)this.uau.getLayoutParams();
      this.uag = this.qts.getWindowAndroid().getOrientationHandler().cHQ();
      Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.uag });
      if ((this.uag != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLj) && (this.uag != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLk) && (this.uag != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLl) && (this.uag != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLm)) {
        break label1480;
      }
      if (this.tZZ.getVisibility() != 0) {
        break label1463;
      }
      paramw.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_landspace_bottom_margin);
      paramContext.topMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_original_landspace_top_margin);
      this.tZZ.setLayoutParams(paramContext);
      label866:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_landscape_bottom_margin);
      ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_landscape_width);
      this.uau.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.tZY.setLayoutParams(paramw);
      aj(getResources().getColor(ba.c.BG_2), true);
      this.uaf.setBackgroundColor(0);
      paramContext = this.uaf;
      if (this.uax == null) {
        this.uax = Boolean.valueOf(aw.isDarkMode());
      }
      if (!this.uax.booleanValue()) {
        break label1576;
      }
    }
    label1420:
    label1576:
    for (int i = -1;; i = -16777216)
    {
      paramContext.setStyleColor(i);
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(322310);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (e.r(e.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(322310);
            return;
          }
          k.a(e.a(e.this).mAppId, k.d.qrG);
          e.a(e.this).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(322310);
        }
      };
      this.uaf.setHomeButtonOnClickListener(paramContext);
      ae.C(getContext(), true);
      if (!this.uam) {
        this.uae.cKI();
      }
      paramContext = new ArrayList();
      paramContext.add(Integer.valueOf(ba.f.app_brand_game_loading_name));
      paramContext.add(Integer.valueOf(ba.f.actionbar_capsule_option_btn));
      paramContext.add(Integer.valueOf(ba.f.actionbar_capsule_home_btn));
      i.b(paramContext, getView());
      this.uac = ((TextView)findViewById(ba.f.app_brand_game_loading_antiaddiction));
      float f = com.tencent.mm.cd.a.getDensity(getContext());
      this.uac.setTextSize(0, f * 11.0F);
      q.a(this.tZX, this.uae, this.uab);
      paramContext = this.tZZ.getLayoutParams();
      paramContext.width = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), ba.d.app_brand_game_splash_original_portrait_width);
      paramContext.height = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), ba.d.app_brand_game_splash_original_portrait_height);
      this.tZZ.setLayoutParams(this.tZZ.getLayoutParams());
      this.uaa = ((ImageView)findViewById(ba.f.app_brand_game_loading_ageappropriate));
      if (this.qts.getInitConfig().qYa <= 0) {
        break label1639;
      }
      try
      {
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "setAgeAppropriateImageView ageAppropriateLevel:%d,ageAppropriateIcon:%s", new Object[] { Integer.valueOf(this.qts.getInitConfig().qYa), AppBrandGlobalSystemConfig.ckD().qXs });
        paramContext = (String)new com.tencent.mm.ad.i(AppBrandGlobalSystemConfig.ckD().qXs).get(String.valueOf(this.qts.getInitConfig().qYa));
        if (paramContext == null) {
          break label1598;
        }
        this.uac.setGravity(19);
        this.uaa.setVisibility(0);
        paramw = "https://game.weixin.qq.com/cgi-bin/minigame/static/age-tips/index.html?appid=" + this.qts.mAppId + "&age=" + this.qts.getInitConfig().qYa + "#wechat_redirect";
        this.uaa.setOnClickListener(new e.1(this, paramw));
        com.tencent.mm.modelappbrand.a.b.bEY().a(this.uaa, paramContext, null, new b.h()
        {
          public final Bitmap P(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(322338);
            paramAnonymousBitmap = BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, com.tencent.mm.cd.a.fromDPToPix(e.this.getContext(), 3) * 1.0F, false);
            AppMethodBeat.o(322338);
            return paramAnonymousBitmap;
          }
          
          public final String key()
          {
            return "appbrand_game_loading_age";
          }
        });
        AppMethodBeat.o(48602);
        return;
      }
      catch (com.tencent.mm.ad.g paramContext)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandGameUILoadingSplash", paramContext, "JSONException: setAgeAppropriateImageView ageAppropriateIcon age error", new Object[0]);
        this.uaa.setVisibility(8);
        this.uac.setGravity(17);
        AppMethodBeat.o(48602);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandGameUILoadingSplash", paramContext, "Exception: setAgeAppropriateImageView ageAppropriateIcon age error", new Object[0]);
        }
      }
      paramContext = paramw.epa.rcn.rcj;
      break;
      label1393:
      com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(1000, 0);
      break label371;
      label1406:
      paramContext = paramw.epa.rcn.rck;
      break label279;
      this.uap = getContext().getResources().getColor(ba.c.app_brand_custom_splashscreen_progressbar_color);
      this.uau.setProgressColor(this.uap);
      break label327;
      label1451:
      this.tZZ.setVisibility(8);
      break label728;
      label1463:
      paramw.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_portrait_bottom_margin);
      break label866;
      label1480:
      if (this.tZZ.getVisibility() == 0)
      {
        paramw.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_portrait_bottom_margin);
        paramContext.topMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_original_portrait_top_margin);
        this.tZZ.setLayoutParams(paramContext);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_portrait_width);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_portrait_bottom_margin);
        break;
        paramw.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_portrait_bottom_margin);
      }
    }
    label1598:
    label1639:
    this.uaa.setVisibility(8);
    this.uac.setGravity(17);
    AppMethodBeat.o(48602);
  }
  
  public final void Cj(int paramInt) {}
  
  public final void as(final kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322219);
    this.uay = true;
    Log.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48596);
        final ViewParent localViewParent = e.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(48596);
          return;
        }
        e.k(e.this).cKJ();
        ViewPropertyAnimator localViewPropertyAnimator = e.this.animate();
        localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
        localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
        localViewPropertyAnimator.setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(322507);
            e.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(321902);
                Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                e.this.setVisibility(8);
                ((ViewGroup)e.7.1.this.uaG).removeView(e.this);
                if (e.7.this.uaF != null) {
                  e.7.this.uaF.invoke();
                }
                AppMethodBeat.o(321902);
              }
            });
            AppMethodBeat.o(322507);
          }
        });
        localViewPropertyAnimator.alpha(0.0F).start();
        AppMethodBeat.o(48596);
      }
    });
    AppMethodBeat.o(322219);
  }
  
  public final void eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48603);
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.tZX, paramString1, null, com.tencent.mm.modelappbrand.a.g.org);
    this.uab.setText(paramString2);
    AppMethodBeat.o(48603);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(48605);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb = this.qts.getWindowAndroid().getOrientationHandler().cHQ();
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    if (localb != this.uag)
    {
      this.uag = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.tZZ.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.uau.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.tZY.getLayoutParams();
      if ((localb != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLj) && (localb != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLk) && (localb != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLl) && (localb != com.tencent.mm.plugin.appbrand.platform.window.e.b.tLm)) {
        break label245;
      }
      if (this.tZZ.getVisibility() != 0) {
        break label227;
      }
      localLayoutParams3.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_landspace_bottom_margin);
      localLayoutParams1.topMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_original_landspace_top_margin);
      this.tZZ.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_landscape_width);
      localLayoutParams2.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_landscape_bottom_margin);
      this.uau.setLayoutParams(localLayoutParams2);
      this.tZY.setLayoutParams(localLayoutParams3);
      requestLayout();
      AppMethodBeat.o(48605);
      return;
      label227:
      localLayoutParams3.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_portrait_bottom_margin);
    }
    label245:
    if (this.tZZ.getVisibility() == 0)
    {
      localLayoutParams3.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_portrait_bottom_margin);
      localLayoutParams1.topMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_original_portrait_top_margin);
      this.tZZ.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_portrait_width);
      localLayoutParams2.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_customsplash_progressbar_portrait_bottom_margin);
      break;
      localLayoutParams3.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_game_splash_gametext_portrait_bottom_margin);
    }
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(48606);
    if (!this.uam)
    {
      if (paramInt < 100)
      {
        this.uae.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.uav)
      {
        this.uav = true;
        new MTimerHandler(Looper.getMainLooper(), new b((byte)0), true).startTimer(0L, 50L);
        AppMethodBeat.o(48606);
      }
    }
    else if ((!this.uan) && (this.uaq))
    {
      if (paramInt < 100)
      {
        this.uae.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.uav)
      {
        this.uav = true;
        new MTimerHandler(Looper.getMainLooper(), new b((byte)0), true).startTimer(0L, 100L);
        AppMethodBeat.o(48606);
      }
    }
    else if (paramInt < 100)
    {
      if (this.uas.getVisibility() == 0)
      {
        this.uau.setProgress(paramInt / 2.0F);
        AppMethodBeat.o(48606);
      }
    }
    else if (!this.uaw)
    {
      this.uaw = true;
      new MTimerHandler(Looper.getMainLooper(), new a((byte)0), true).startTimer(0L, 1000 / this.uar);
    }
    AppMethodBeat.o(48606);
  }
  
  public final void yU(final int paramInt)
  {
    AppMethodBeat.i(48607);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(322300);
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (e.l(e.this))
          {
            e.m(e.this).setVisibility(0);
            e.m(e.this).setText(ba.i.appbrand_data_transfer_tip);
            AppMethodBeat.o(322300);
            return;
          }
          e.a(e.this, this);
        }
        AppMethodBeat.o(322300);
      }
    });
    AppMethodBeat.o(48607);
  }
  
  final class a
    implements MTimerHandler.CallBack
  {
    private float progress = 50.0F;
    
    private a() {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(322294);
      if (this.progress >= 100.0F)
      {
        AppMethodBeat.o(322294);
        return false;
      }
      this.progress += 0.33F;
      if (e.p(e.this).getVisibility() == 0) {
        e.q(e.this).setProgress(this.progress);
      }
      AppMethodBeat.o(322294);
      return true;
    }
  }
  
  final class b
    implements MTimerHandler.CallBack
  {
    private int progress = 50;
    
    private b() {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(322288);
      if (this.progress >= 100)
      {
        AppMethodBeat.o(322288);
        return false;
      }
      this.progress += 1;
      e.k(e.this).setProgress(this.progress);
      if (this.progress == 100)
      {
        e.n(e.this);
        if (e.o(e.this) != null)
        {
          e.o(e.this).run();
          e.a(e.this, null);
        }
      }
      AppMethodBeat.o(322288);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */