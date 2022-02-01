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
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.z;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ViewConstructor"})
final class f
  extends com.tencent.mm.ui.statusbar.b
  implements q, w
{
  private p jAF;
  private ImageView mFU;
  private ImageView mFV;
  private ImageView mFW;
  private TextView mFX;
  private LinearLayout mFY;
  private AppBrandCircleProgressView mFZ;
  private d mGa;
  private e.b mGb;
  private TextView mGc;
  private boolean mGd;
  private Runnable mGe;
  private RelativeLayout mGf;
  private boolean mGg;
  private boolean mGh;
  private boolean mGi;
  private int mGj;
  private boolean mGk;
  private int mGl;
  private RelativeLayout mGm;
  private ImageView mGn;
  private BootstrapProgressBar mGo;
  private boolean mGp;
  private boolean mGq;
  private Boolean mGr;
  private boolean mGs;
  
  public f(Context paramContext, p paramp)
  {
    super(paramContext);
    AppMethodBeat.i(48602);
    this.mGb = e.b.mtD;
    this.mGe = null;
    this.mGg = false;
    this.mGh = false;
    this.mGi = false;
    this.mGk = false;
    this.mGl = 30;
    this.mGs = false;
    this.jAF = paramp;
    ae.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493063, this);
    this.mGm = ((RelativeLayout)findViewById(2131296717));
    this.mGn = ((ImageView)findViewById(2131296718));
    this.mGo = ((BootstrapProgressBar)findViewById(2131296719));
    com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(999, 1);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGr, false)) && (this.jAF != null))
    {
      final long l = bu.HQ();
      paramp = this.jAF.aXx();
      if (paramp.cmA.kdp == null)
      {
        paramContext = null;
        if (bu.isNullOrNil(paramContext)) {
          break label1037;
        }
        this.mGg = true;
        ae.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramContext });
        com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(1000, 1);
        com.tencent.mm.ch.a.post(new f.2(this, paramContext, new a.a()
        {
          public final void a(final Bitmap paramAnonymousBitmap, final long paramAnonymousLong)
          {
            AppMethodBeat.i(223085);
            ae.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
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
                    com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(1002, (int)bu.aO(f.1.this.mGt));
                    com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(1001, (int)paramAnonymousLong);
                  }
                  AppMethodBeat.o(48585);
                }
              });
            }
            AppMethodBeat.o(223085);
          }
        }));
        if (paramp.cmA.kdp != null) {
          break label1050;
        }
        paramContext = (Context)localObject;
        label274:
        if (bu.isNullOrNil(paramContext)) {
          break label1064;
        }
        this.mGj = Color.parseColor(paramContext);
        this.mGo.setProgressColor(this.mGj);
        ae.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.mGj) });
        label322:
        this.mGo.setAnimated(true);
        this.mGo.setStriped(true);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48590);
            f.f(f.this);
            ae.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (f.g(f.this)) {
              f.d(f.this);
            }
            AppMethodBeat.o(48590);
          }
        }, 1000L);
        ar.o(new Runnable()
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
      label366:
      this.mGf = ((RelativeLayout)findViewById(2131296727));
      this.mFU = ((ImageView)findViewById(2131296723));
      this.mFU.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aEk());
      this.mFX = ((TextView)findViewById(2131296724));
      this.mFV = ((ImageView)findViewById(2131296731));
      this.mFW = ((ImageView)findViewById(2131296725));
      this.mFY = ((LinearLayout)findViewById(2131296721));
      this.mGc = ((TextView)findViewById(2131301494));
      this.mFZ = ((AppBrandCircleProgressView)findViewById(2131299117));
      this.mFZ.setCircleColor(getResources().getColor(2131099656));
      this.mFZ.setDotWidth(getResources().getDimensionPixelSize(2131167060));
      this.mFZ.setDotColor(getResources().getColor(2131099699));
      this.mFZ.setCircleStrokeWidth(getResources().getDimensionPixelSize(2131167059));
      this.mFZ.setProgressColor(getResources().getColor(2131099699));
      this.mFZ.setProgressWidth(getResources().getDimensionPixelSize(2131167061));
      if (ak.coh()) {
        this.mFZ.setTransitionTimingMs(2147483647);
      }
      paramContext = (RelativeLayout.LayoutParams)this.mFW.getLayoutParams();
      paramp = (RelativeLayout.LayoutParams)this.mFV.getLayoutParams();
      this.mGa = new d(getContext());
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 21;
      ((LinearLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165772);
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165773);
      this.mFY.addView(this.mGa, (ViewGroup.LayoutParams)localObject);
      if (this.jAF.aXx().originalFlag != 1) {
        break label1095;
      }
      this.mFW.setVisibility(0);
      label731:
      localObject = (RelativeLayout.LayoutParams)this.mGo.getLayoutParams();
      this.mGb = this.jAF.getWindowAndroid().getOrientationHandler().aYg();
      ae.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.mGb });
      if ((this.mGb != e.b.mtF) && (this.mGb != e.b.mtG) && (this.mGb != e.b.mtH) && (this.mGb != e.b.mtI)) {
        break label1124;
      }
      if (this.mFW.getVisibility() != 0) {
        break label1107;
      }
      paramp.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165774);
      paramContext.topMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165781);
      this.mFW.setLayoutParams(paramContext);
      label869:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165768);
      ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cb.a.ay(getContext(), 2131165769);
      this.mGo.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mFV.setLayoutParams(paramp);
      M(getResources().getColor(2131099650), true);
      this.mGa.setBackgroundColor(0);
      paramContext = this.mGa;
      if (this.mGr == null) {
        this.mGr = Boolean.valueOf(al.isDarkMode());
      }
      if (!this.mGr.booleanValue()) {
        break label1220;
      }
    }
    label1037:
    label1050:
    label1064:
    label1220:
    for (int i = -1;; i = -16777216)
    {
      paramContext.setStyleColor(i);
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(223089);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (f.r(f.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(223089);
            return;
          }
          h.a(f.e(f.this).mAppId, h.d.jzh);
          f.e(f.this).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223089);
        }
      };
      this.mGa.setHomeButtonOnClickListener(paramContext);
      t.u(getContext(), true);
      if (!this.mGg) {
        this.mFZ.bzX();
      }
      AppMethodBeat.o(48602);
      return;
      paramContext = paramp.cmA.kdp.kdl;
      break;
      com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(1000, 0);
      break label366;
      paramContext = paramp.cmA.kdp.kdm;
      break label274;
      this.mGj = getContext().getResources().getColor(2131099927);
      this.mGo.setProgressColor(this.mGj);
      break label322;
      label1095:
      this.mFW.setVisibility(8);
      break label731;
      label1107:
      paramp.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165775);
      break label869;
      label1124:
      if (this.mFW.getVisibility() == 0)
      {
        paramp.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165775);
        paramContext.topMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165783);
        this.mFW.setLayoutParams(paramContext);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cb.a.ay(getContext(), 2131165771);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165770);
        break;
        paramp.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165775);
      }
    }
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48603);
    com.tencent.mm.modelappbrand.a.b.aEl().a(this.mFU, paramString1, null, com.tencent.mm.modelappbrand.a.g.hOv);
    this.mFX.setText(paramString2);
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
    e.b localb = this.jAF.getWindowAndroid().getOrientationHandler().aYg();
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    if (localb != this.mGb)
    {
      this.mGb = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.mFW.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.mGo.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.mFV.getLayoutParams();
      if ((localb != e.b.mtF) && (localb != e.b.mtG) && (localb != e.b.mtH) && (localb != e.b.mtI)) {
        break label245;
      }
      if (this.mFW.getVisibility() != 0) {
        break label227;
      }
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165774);
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165781);
      this.mFW.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cb.a.ay(getContext(), 2131165769);
      localLayoutParams2.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165768);
      this.mGo.setLayoutParams(localLayoutParams2);
      this.mFV.setLayoutParams(localLayoutParams3);
      requestLayout();
      AppMethodBeat.o(48605);
      return;
      label227:
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165775);
    }
    label245:
    if (this.mFW.getVisibility() == 0)
    {
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165775);
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165783);
      this.mFW.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cb.a.ay(getContext(), 2131165771);
      localLayoutParams2.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165770);
      break;
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165775);
    }
  }
  
  public final void rF(final int paramInt)
  {
    AppMethodBeat.i(48607);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48595);
        ae.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (f.l(f.this))
          {
            f.m(f.this).setVisibility(0);
            f.m(f.this).setText(2131755950);
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
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(48606);
    if (!this.mGg)
    {
      if (paramInt < 100)
      {
        this.mFZ.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.mGp)
      {
        this.mGp = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 50L);
        AppMethodBeat.o(48606);
      }
    }
    else if ((!this.mGh) && (this.mGk))
    {
      if (paramInt < 100)
      {
        this.mFZ.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.mGp)
      {
        this.mGp = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 100L);
        AppMethodBeat.o(48606);
      }
    }
    else if (paramInt < 100)
    {
      if (this.mGm.getVisibility() == 0)
      {
        this.mGo.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
      }
    }
    else if (!this.mGq)
    {
      this.mGq = true;
      new Timer(true).scheduleAtFixedRate(new a(), 0L, 1000 / this.mGl);
    }
    AppMethodBeat.o(48606);
  }
  
  public final void uD(int paramInt) {}
  
  public final void v(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223090);
    this.mGs = true;
    ae.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48592);
        final ViewParent localViewParent = f.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          ae.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(48592);
          return;
        }
        f.k(f.this).bzY();
        ViewPropertyAnimator localViewPropertyAnimator = f.this.animate();
        localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
        localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
        localViewPropertyAnimator.setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(223088);
            f.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(223087);
                ae.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                f.this.setVisibility(8);
                ((ViewGroup)f.5.1.this.mGA).removeView(f.this);
                if (f.5.this.mGz != null) {
                  f.5.this.mGz.invoke();
                }
                AppMethodBeat.o(223087);
              }
            });
            AppMethodBeat.o(223088);
          }
        });
        localViewPropertyAnimator.alpha(0.0F).start();
        AppMethodBeat.o(48592);
      }
    });
    AppMethodBeat.o(223090);
  }
  
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
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48598);
          if (f.p(f.this).getVisibility() == 0) {
            f.q(f.this).setProgress(f.a.a(f.a.this));
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
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48600);
          f.k(f.this).setProgress(f.b.a(f.b.this));
          if (f.b.a(f.b.this) == 100)
          {
            f.n(f.this);
            if (f.o(f.this) != null)
            {
              f.o(f.this).run();
              f.a(f.this, null);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f
 * JD-Core Version:    0.7.0.1
 */