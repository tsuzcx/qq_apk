package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import d.z;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ViewConstructor"})
final class e
  extends com.tencent.mm.ui.statusbar.b
  implements q, v
{
  private o jxG;
  private ImageView mAR;
  private ImageView mAS;
  private ImageView mAT;
  private TextView mAU;
  private LinearLayout mAV;
  private AppBrandCircleProgressView mAW;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b mAX;
  private com.tencent.mm.plugin.appbrand.r.a.e.b mAY;
  private TextView mAZ;
  private boolean mBa;
  private Runnable mBb;
  private RelativeLayout mBc;
  private boolean mBd;
  private boolean mBe;
  private boolean mBf;
  private int mBg;
  private boolean mBh;
  private int mBi;
  private RelativeLayout mBj;
  private ImageView mBk;
  private BootstrapProgressBar mBl;
  private boolean mBm;
  private boolean mBn;
  private Boolean mzu;
  
  public e(Context paramContext, o paramo)
  {
    super(paramContext);
    AppMethodBeat.i(48602);
    this.mAY = com.tencent.mm.plugin.appbrand.r.a.e.b.moG;
    this.mBb = null;
    this.mBd = false;
    this.mBe = false;
    this.mBf = false;
    this.mBh = false;
    this.mBi = 30;
    this.jxG = paramo;
    ad.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493063, this);
    this.mBj = ((RelativeLayout)findViewById(2131296717));
    this.mBk = ((ImageView)findViewById(2131296718));
    this.mBl = ((BootstrapProgressBar)findViewById(2131296719));
    com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(999, 1);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzl, false)) && (this.jxG != null))
    {
      final long l = bt.HI();
      paramo = this.jxG.aXc();
      if (paramo.cmy.jZY == null)
      {
        paramContext = null;
        if (bt.isNullOrNil(paramContext)) {
          break label1050;
        }
        this.mBd = true;
        ad.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramContext });
        com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(1000, 1);
        com.tencent.mm.ci.a.post(new e.2(this, paramContext, new a.a()
        {
          public final void a(final Bitmap paramAnonymousBitmap, final long paramAnonymousLong)
          {
            AppMethodBeat.i(188853);
            ad.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
            e.a(e.this);
            if (e.b(e.this) != null) {
              m.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(48585);
                  if (paramAnonymousBitmap != null)
                  {
                    e.b(e.this).setImageBitmap(paramAnonymousBitmap);
                    if (e.c(e.this)) {
                      e.d(e.this);
                    }
                    com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(1002, (int)bt.aO(e.1.this.mBo));
                    com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(1001, (int)paramAnonymousLong);
                  }
                  AppMethodBeat.o(48585);
                }
              });
            }
            AppMethodBeat.o(188853);
          }
        }));
        if (paramo.cmy.jZY != null) {
          break label1063;
        }
        paramContext = (Context)localObject;
        label267:
        if (bt.isNullOrNil(paramContext)) {
          break label1077;
        }
        this.mBg = Color.parseColor(paramContext);
        this.mBl.setProgressColor(this.mBg);
        ad.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.mBg) });
        label314:
        this.mBl.setAnimated(true);
        this.mBl.setStriped(true);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48590);
            e.f(e.this);
            ad.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (e.g(e.this)) {
              e.d(e.this);
            }
            AppMethodBeat.o(48590);
          }
        }, 1000L);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48591);
            if (e.g(e.this))
            {
              AppMethodBeat.o(48591);
              return;
            }
            e.h(e.this);
            e.i(e.this).setVisibility(0);
            e.j(e.this);
            AppMethodBeat.o(48591);
          }
        }, 2000L);
      }
    }
    else
    {
      label358:
      this.mBc = ((RelativeLayout)findViewById(2131296727));
      this.mAR = ((ImageView)findViewById(2131296723));
      this.mAR.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aDU());
      this.mAU = ((TextView)findViewById(2131296724));
      this.mAS = ((ImageView)findViewById(2131296731));
      this.mAT = ((ImageView)findViewById(2131296725));
      this.mAV = ((LinearLayout)findViewById(2131296721));
      this.mAZ = ((TextView)findViewById(2131301494));
      this.mAW = ((AppBrandCircleProgressView)findViewById(2131299117));
      this.mAW.setCircleColor(getResources().getColor(2131099656));
      this.mAW.setDotWidth(getResources().getDimensionPixelSize(2131167060));
      this.mAW.setDotColor(getResources().getColor(2131099699));
      this.mAW.setCircleStrokeWidth(getResources().getDimensionPixelSize(2131167059));
      this.mAW.setProgressColor(getResources().getColor(2131099699));
      this.mAW.setProgressWidth(getResources().getDimensionPixelSize(2131167061));
      if (aj.cmR()) {
        this.mAW.setTransitionTimingMs(2147483647);
      }
      paramContext = (RelativeLayout.LayoutParams)this.mAT.getLayoutParams();
      paramo = (RelativeLayout.LayoutParams)this.mAS.getLayoutParams();
      this.mAX = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
      this.mAX.setFullscreenMode(true);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 21;
      ((LinearLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165772);
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165773);
      this.mAV.addView(this.mAX.getActionView(), (ViewGroup.LayoutParams)localObject);
      if (this.jxG.aXc().originalFlag != 1) {
        break label1108;
      }
      this.mAT.setVisibility(0);
      label734:
      localObject = (RelativeLayout.LayoutParams)this.mBl.getLayoutParams();
      this.mAY = this.jxG.getWindowAndroid().getOrientationHandler().aXN();
      ad.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.mAY });
      if ((this.mAY != com.tencent.mm.plugin.appbrand.r.a.e.b.moI) && (this.mAY != com.tencent.mm.plugin.appbrand.r.a.e.b.moJ) && (this.mAY != com.tencent.mm.plugin.appbrand.r.a.e.b.moK) && (this.mAY != com.tencent.mm.plugin.appbrand.r.a.e.b.moL)) {
        break label1137;
      }
      if (this.mAT.getVisibility() != 0) {
        break label1120;
      }
      paramo.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165774);
      paramContext.topMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165781);
      this.mAT.setLayoutParams(paramContext);
      label872:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165768);
      ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cc.a.ay(getContext(), 2131165769);
      this.mBl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mAS.setLayoutParams(paramo);
      L(getResources().getColor(2131099650), true);
      this.mAX.setBackgroundColor(0);
      paramContext = this.mAX;
      if (this.mzu == null) {
        this.mzu = Boolean.valueOf(al.isDarkMode());
      }
      if (this.mzu.booleanValue()) {
        break label1233;
      }
    }
    label1050:
    label1063:
    label1077:
    label1233:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setForegroundStyle(bool);
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(188857);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.appbrand.g.a(e.e(e.this).mAppId, g.d.jwl);
          e.e(e.this).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(188857);
        }
      };
      this.mAX.setCloseButtonClickListener(paramContext);
      this.mAX.setBackButtonClickListener(paramContext);
      s.u(getContext(), true);
      if (!this.mBd) {
        this.mAW.bzc();
      }
      AppMethodBeat.o(48602);
      return;
      paramContext = paramo.cmy.jZY.jZU;
      break;
      com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(1000, 0);
      break label358;
      paramContext = paramo.cmy.jZY.jZV;
      break label267;
      this.mBg = getContext().getResources().getColor(2131099927);
      this.mBl.setProgressColor(this.mBg);
      break label314;
      label1108:
      this.mAT.setVisibility(8);
      break label734;
      label1120:
      paramo.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165775);
      break label872;
      label1137:
      if (this.mAT.getVisibility() == 0)
      {
        paramo.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165775);
        paramContext.topMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165783);
        this.mAT.setLayoutParams(paramContext);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cc.a.ay(getContext(), 2131165771);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165770);
        break;
        paramo.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165775);
      }
    }
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48603);
    com.tencent.mm.modelappbrand.a.b.aDV().a(this.mAR, paramString1, null, com.tencent.mm.modelappbrand.a.g.hLC);
    this.mAU.setText(paramString2);
    AppMethodBeat.o(48603);
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(48605);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.plugin.appbrand.r.a.e.b localb = this.jxG.getWindowAndroid().getOrientationHandler().aXN();
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    if (localb != this.mAY)
    {
      this.mAY = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.mAT.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.mBl.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.mAS.getLayoutParams();
      if ((localb != com.tencent.mm.plugin.appbrand.r.a.e.b.moI) && (localb != com.tencent.mm.plugin.appbrand.r.a.e.b.moJ) && (localb != com.tencent.mm.plugin.appbrand.r.a.e.b.moK) && (localb != com.tencent.mm.plugin.appbrand.r.a.e.b.moL)) {
        break label245;
      }
      if (this.mAT.getVisibility() != 0) {
        break label227;
      }
      localLayoutParams3.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165774);
      localLayoutParams1.topMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165781);
      this.mAT.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cc.a.ay(getContext(), 2131165769);
      localLayoutParams2.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165768);
      this.mBl.setLayoutParams(localLayoutParams2);
      this.mAS.setLayoutParams(localLayoutParams3);
      requestLayout();
      AppMethodBeat.o(48605);
      return;
      label227:
      localLayoutParams3.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165775);
    }
    label245:
    if (this.mAT.getVisibility() == 0)
    {
      localLayoutParams3.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165775);
      localLayoutParams1.topMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165783);
      this.mAT.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cc.a.ay(getContext(), 2131165771);
      localLayoutParams2.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165770);
      break;
      localLayoutParams3.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165775);
    }
  }
  
  public final void rC(final int paramInt)
  {
    AppMethodBeat.i(48607);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48595);
        ad.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (e.l(e.this))
          {
            e.m(e.this).setVisibility(0);
            e.m(e.this).setText(2131755950);
            AppMethodBeat.o(48595);
            return;
          }
          e.a(e.this, this);
        }
        AppMethodBeat.o(48595);
      }
    });
    AppMethodBeat.o(48607);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(48606);
    if (!this.mBd)
    {
      if (paramInt < 100)
      {
        this.mAW.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.mBm)
      {
        this.mBm = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 50L);
        AppMethodBeat.o(48606);
      }
    }
    else if ((!this.mBe) && (this.mBh))
    {
      if (paramInt < 100)
      {
        this.mAW.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.mBm)
      {
        this.mBm = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 100L);
        AppMethodBeat.o(48606);
      }
    }
    else if (paramInt < 100)
    {
      if (this.mBj.getVisibility() == 0)
      {
        this.mBl.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
      }
    }
    else if (!this.mBn)
    {
      this.mBn = true;
      new Timer(true).scheduleAtFixedRate(new a(), 0L, 1000 / this.mBi);
    }
    AppMethodBeat.o(48606);
  }
  
  public final void u(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(188858);
    ad.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48592);
        final ViewParent localViewParent = e.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          ad.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(48592);
          return;
        }
        e.k(e.this).bzd();
        ViewPropertyAnimator localViewPropertyAnimator = e.this.animate();
        localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
        localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
        localViewPropertyAnimator.setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(188856);
            e.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(188855);
                ad.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                e.this.setVisibility(8);
                ((ViewGroup)e.5.1.this.mBv).removeView(e.this);
                if (e.5.this.mBu != null) {
                  e.5.this.mBu.invoke();
                }
                AppMethodBeat.o(188855);
              }
            });
            AppMethodBeat.o(188856);
          }
        });
        localViewPropertyAnimator.alpha(0.0F).start();
        AppMethodBeat.o(48592);
      }
    });
    AppMethodBeat.o(188858);
  }
  
  public final void ux(int paramInt) {}
  
  public final class a
    extends TimerTask
  {
    private float progress = 50.0F;
    
    public a() {}
    
    public final void run()
    {
      AppMethodBeat.i(48599);
      if (this.progress >= 100.0F)
      {
        cancel();
        AppMethodBeat.o(48599);
        return;
      }
      this.progress += 0.33F;
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48598);
          if (e.p(e.this).getVisibility() == 0) {
            e.q(e.this).setProgress(e.a.a(e.a.this));
          }
          AppMethodBeat.o(48598);
        }
      });
      AppMethodBeat.o(48599);
    }
  }
  
  public final class b
    extends TimerTask
  {
    private int progress = 50;
    
    public b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48601);
      if (this.progress >= 100)
      {
        cancel();
        AppMethodBeat.o(48601);
        return;
      }
      this.progress += 1;
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48600);
          e.k(e.this).setProgress(e.b.a(e.b.this));
          if (e.b.a(e.b.this) == 100)
          {
            e.n(e.this);
            if (e.o(e.this) != null)
            {
              e.o(e.this).run();
              e.a(e.this, null);
            }
          }
          AppMethodBeat.o(48600);
        }
      });
      AppMethodBeat.o(48601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */