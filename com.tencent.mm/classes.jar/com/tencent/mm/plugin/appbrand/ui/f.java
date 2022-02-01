package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
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
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.launching.p;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;

@SuppressLint({"ViewConstructor"})
final class f
  extends com.tencent.mm.ui.statusbar.b
  implements p, aa
{
  private t nuJ;
  private e.b qUA;
  private TextView qUB;
  private boolean qUC;
  private Runnable qUD;
  private RelativeLayout qUE;
  private boolean qUF;
  private boolean qUG;
  private boolean qUH;
  private int qUI;
  private boolean qUJ;
  private int qUK;
  private RelativeLayout qUL;
  private ImageView qUM;
  private BootstrapProgressBar qUN;
  private boolean qUO;
  private boolean qUP;
  private Boolean qUQ;
  private boolean qUR;
  private ImageView qUt;
  private ImageView qUu;
  private ImageView qUv;
  private TextView qUw;
  private LinearLayout qUx;
  private AppBrandCircleProgressView qUy;
  private d qUz;
  
  public f(Context paramContext, t paramt)
  {
    super(paramContext);
    AppMethodBeat.i(48602);
    this.qUA = e.b.qGv;
    this.qUD = null;
    this.qUF = false;
    this.qUG = false;
    this.qUH = false;
    this.qUJ = false;
    this.qUK = 30;
    this.qUR = false;
    this.nuJ = paramt;
    Log.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(au.g.app_brand_splash_game_ui, this);
    this.qUL = ((RelativeLayout)findViewById(au.f.app_brand_game_custom_splashscreen));
    this.qUM = ((ImageView)findViewById(au.f.app_brand_game_custom_splashscreen_img));
    this.qUN = ((BootstrapProgressBar)findViewById(au.f.app_brand_game_custom_splashscreen_progressbar));
    com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(999, 1);
    if ((((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGF, false)) && (this.nuJ != null))
    {
      final long l = Util.currentTicks();
      paramt = this.nuJ.bDy();
      if (paramt.cwY.obA == null)
      {
        paramContext = null;
        if (Util.isNullOrNil(paramContext)) {
          break label1026;
        }
        this.qUF = true;
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramContext });
        com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(1000, 1);
        com.tencent.mm.co.a.post(new f.2(this, paramContext, new a.a()
        {
          public final void a(final Bitmap paramAnonymousBitmap, final long paramAnonymousLong)
          {
            AppMethodBeat.i(280507);
            Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
            f.a(f.this);
            if (f.b(f.this) != null) {
              m.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(48585);
                  if (paramAnonymousBitmap != null)
                  {
                    f.b(f.this).setImageBitmap(paramAnonymousBitmap);
                    if (f.c(f.this)) {
                      f.d(f.this);
                    }
                    com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(1002, (int)Util.ticksToNow(f.1.this.qUS));
                    com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(1001, (int)paramAnonymousLong);
                  }
                  AppMethodBeat.o(48585);
                }
              });
            }
            AppMethodBeat.o(280507);
          }
        }));
        if (paramt.cwY.obA != null) {
          break label1039;
        }
        paramContext = (Context)localObject;
        label278:
        if (Util.isNullOrNil(paramContext)) {
          break label1053;
        }
        this.qUI = Color.parseColor(paramContext);
        this.qUN.setProgressColor(this.qUI);
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.qUI) });
        label326:
        this.qUN.setAnimated(true);
        this.qUN.setStriped(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48590);
            f.f(f.this);
            Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (f.g(f.this)) {
              f.d(f.this);
            }
            AppMethodBeat.o(48590);
          }
        }, 1000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48591);
            if (f.g(f.this))
            {
              AppMethodBeat.o(48591);
              return;
            }
            f.h(f.this);
            f.i(f.this).setVisibility(0);
            f.j(f.this);
            AppMethodBeat.o(48591);
          }
        }, 2000L);
      }
    }
    else
    {
      label370:
      this.qUE = ((RelativeLayout)findViewById(au.f.app_brand_game_policy_loading));
      this.qUt = ((ImageView)findViewById(au.f.app_brand_game_loading_avatar));
      this.qUt.setImageDrawable(com.tencent.mm.modelappbrand.a.a.bhg());
      this.qUw = ((TextView)findViewById(au.f.app_brand_game_loading_name));
      this.qUu = ((ImageView)findViewById(au.f.app_brand_game_wagame_name));
      this.qUv = ((ImageView)findViewById(au.f.app_brand_game_loading_original));
      this.qUx = ((LinearLayout)findViewById(au.f.app_brand_game_loading_ab_container));
      this.qUB = ((TextView)findViewById(au.f.loading_data_tip));
      this.qUy = ((AppBrandCircleProgressView)findViewById(au.f.app_brand_game_loading_circle_progress_view));
      this.qUy.setCircleColor(getResources().getColor(au.c.BW_0_Alpha_0_1));
      this.qUy.setDotWidth(getResources().getDimensionPixelSize(au.d.app_brand_loading_dotWidth));
      this.qUy.setDotColor(getResources().getColor(au.c.Brand));
      this.qUy.setCircleStrokeWidth(getResources().getDimensionPixelSize(au.d.app_brand_loading_circleWidth));
      this.qUy.setProgressColor(getResources().getColor(au.c.Brand));
      this.qUy.setProgressWidth(getResources().getDimensionPixelSize(au.d.app_brand_loading_progressWidth));
      if (MMApplicationContext.isMainProcess()) {
        this.qUy.setTransitionTimingMs(2147483647);
      }
      paramContext = (RelativeLayout.LayoutParams)this.qUv.getLayoutParams();
      paramt = (RelativeLayout.LayoutParams)this.qUu.getLayoutParams();
      this.qUz = ((d)this.nuJ.bDh().d(getContext(), d.class));
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 21;
      com.tencent.mm.plugin.appbrand.page.capsulebar.k.cZ(this.qUz);
      this.qUx.addView(this.qUz, (ViewGroup.LayoutParams)localObject);
      if (this.nuJ.bDy().originalFlag != 1) {
        break label1084;
      }
      this.qUv.setVisibility(0);
      label720:
      localObject = (RelativeLayout.LayoutParams)this.qUN.getLayoutParams();
      this.qUA = this.nuJ.getWindowAndroid().getOrientationHandler().cgS();
      Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.qUA });
      if ((this.qUA != e.b.qGx) && (this.qUA != e.b.qGy) && (this.qUA != e.b.qGz) && (this.qUA != e.b.qGA)) {
        break label1113;
      }
      if (this.qUv.getVisibility() != 0) {
        break label1096;
      }
      paramt.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_landspace_bottom_margin);
      paramContext.topMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_original_landspace_top_margin);
      this.qUv.setLayoutParams(paramContext);
      label858:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_landscape_bottom_margin);
      ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_landscape_width);
      this.qUN.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.qUu.setLayoutParams(paramt);
      T(getResources().getColor(au.c.BG_2), true);
      this.qUz.setBackgroundColor(0);
      paramContext = this.qUz;
      if (this.qUQ == null) {
        this.qUQ = Boolean.valueOf(ar.isDarkMode());
      }
      if (!this.qUQ.booleanValue()) {
        break label1209;
      }
    }
    label1026:
    label1039:
    label1053:
    label1209:
    for (int i = -1;; i = -16777216)
    {
      paramContext.setStyleColor(i);
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(277170);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (f.r(f.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(277170);
            return;
          }
          com.tencent.mm.plugin.appbrand.k.a(f.e(f.this).mAppId, k.d.ntb);
          f.e(f.this).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277170);
        }
      };
      this.qUz.setHomeButtonOnClickListener(paramContext);
      x.A(getContext(), true);
      if (!this.qUF) {
        this.qUy.cjx();
      }
      AppMethodBeat.o(48602);
      return;
      paramContext = paramt.cwY.obA.obw;
      break;
      com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(1000, 0);
      break label370;
      paramContext = paramt.cwY.obA.obx;
      break label278;
      this.qUI = getContext().getResources().getColor(au.c.app_brand_custom_splashscreen_progressbar_color);
      this.qUN.setProgressColor(this.qUI);
      break label326;
      label1084:
      this.qUv.setVisibility(8);
      break label720;
      label1096:
      paramt.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_portrait_bottom_margin);
      break label858;
      label1113:
      if (this.qUv.getVisibility() == 0)
      {
        paramt.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_portrait_bottom_margin);
        paramContext.topMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_original_portrait_top_margin);
        this.qUv.setLayoutParams(paramContext);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_portrait_width);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_portrait_bottom_margin);
        break;
        paramt.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_portrait_bottom_margin);
      }
    }
  }
  
  public final void BU(int paramInt) {}
  
  public final void eC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48603);
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.qUt, paramString1, null, g.lzF);
    this.qUw.setText(paramString2);
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
    e.b localb = this.nuJ.getWindowAndroid().getOrientationHandler().cgS();
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    if (localb != this.qUA)
    {
      this.qUA = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.qUv.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.qUN.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.qUu.getLayoutParams();
      if ((localb != e.b.qGx) && (localb != e.b.qGy) && (localb != e.b.qGz) && (localb != e.b.qGA)) {
        break label245;
      }
      if (this.qUv.getVisibility() != 0) {
        break label227;
      }
      localLayoutParams3.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_landspace_bottom_margin);
      localLayoutParams1.topMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_original_landspace_top_margin);
      this.qUv.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_landscape_width);
      localLayoutParams2.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_landscape_bottom_margin);
      this.qUN.setLayoutParams(localLayoutParams2);
      this.qUu.setLayoutParams(localLayoutParams3);
      requestLayout();
      AppMethodBeat.o(48605);
      return;
      label227:
      localLayoutParams3.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_portrait_bottom_margin);
    }
    label245:
    if (this.qUv.getVisibility() == 0)
    {
      localLayoutParams3.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_portrait_bottom_margin);
      localLayoutParams1.topMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_original_portrait_top_margin);
      this.qUv.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_portrait_width);
      localLayoutParams2.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_customsplash_progressbar_portrait_bottom_margin);
      break;
      localLayoutParams3.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_game_splash_gametext_portrait_bottom_margin);
    }
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(48606);
    if (!this.qUF)
    {
      if (paramInt < 100)
      {
        this.qUy.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.qUO)
      {
        this.qUO = true;
        new MTimerHandler(Looper.getMainLooper(), new b((byte)0), true).startTimer(0L, 50L);
        AppMethodBeat.o(48606);
      }
    }
    else if ((!this.qUG) && (this.qUJ))
    {
      if (paramInt < 100)
      {
        this.qUy.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.qUO)
      {
        this.qUO = true;
        new MTimerHandler(Looper.getMainLooper(), new b((byte)0), true).startTimer(0L, 100L);
        AppMethodBeat.o(48606);
      }
    }
    else if (paramInt < 100)
    {
      if (this.qUL.getVisibility() == 0)
      {
        this.qUN.setProgress(paramInt / 2.0F);
        AppMethodBeat.o(48606);
      }
    }
    else if (!this.qUP)
    {
      this.qUP = true;
      new MTimerHandler(Looper.getMainLooper(), new a((byte)0), true).startTimer(0L, 1000 / this.qUK);
    }
    AppMethodBeat.o(48606);
  }
  
  public final void x(final kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(280223);
    this.qUR = true;
    Log.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48592);
        final ViewParent localViewParent = f.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(48592);
          return;
        }
        f.k(f.this).cjy();
        ViewPropertyAnimator localViewPropertyAnimator = f.this.animate();
        localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
        localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
        localViewPropertyAnimator.setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(266707);
            f.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(272440);
                Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                f.this.setVisibility(8);
                ((ViewGroup)f.5.1.this.qUZ).removeView(f.this);
                if (f.5.this.qUY != null) {
                  f.5.this.qUY.invoke();
                }
                AppMethodBeat.o(272440);
              }
            });
            AppMethodBeat.o(266707);
          }
        });
        localViewPropertyAnimator.alpha(0.0F).start();
        AppMethodBeat.o(48592);
      }
    });
    AppMethodBeat.o(280223);
  }
  
  public final void yL(final int paramInt)
  {
    AppMethodBeat.i(48607);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48595);
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (f.l(f.this))
          {
            f.m(f.this).setVisibility(0);
            f.m(f.this).setText(au.i.appbrand_data_transfer_tip);
            AppMethodBeat.o(48595);
            return;
          }
          f.a(f.this, this);
        }
        AppMethodBeat.o(48595);
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
      AppMethodBeat.i(277239);
      if (this.progress >= 100.0F)
      {
        AppMethodBeat.o(277239);
        return false;
      }
      this.progress += 0.33F;
      if (f.p(f.this).getVisibility() == 0) {
        f.q(f.this).setProgress(this.progress);
      }
      AppMethodBeat.o(277239);
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
      AppMethodBeat.i(280019);
      if (this.progress >= 100)
      {
        AppMethodBeat.o(280019);
        return false;
      }
      this.progress += 1;
      f.k(f.this).setProgress(this.progress);
      if (this.progress == 100)
      {
        f.n(f.this);
        if (f.o(f.this) != null)
        {
          f.o(f.this).run();
          f.a(f.this, null);
        }
      }
      AppMethodBeat.o(280019);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f
 * JD-Core Version:    0.7.0.1
 */