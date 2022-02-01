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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.x.b.b;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ViewConstructor"})
final class d
  extends com.tencent.mm.ui.statusbar.b
  implements q, u
{
  private o jez;
  public final boolean jgc;
  private ThreeDotsLoadingView lWT;
  private ImageView maH;
  private ImageView maI;
  private ImageView maJ;
  private TextView maK;
  private LinearLayout maL;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b maM;
  private TextView maN;
  private e.b maO;
  private TextView maP;
  private boolean maQ;
  private Runnable maR;
  private RelativeLayout maS;
  private TextView maT;
  private boolean maU;
  private boolean maV;
  private boolean maW;
  private int maX;
  private boolean maY;
  private int maZ;
  private RelativeLayout mba;
  private ImageView mbb;
  private BootstrapProgressBar mbc;
  private boolean mbd;
  private boolean mbe;
  private Boolean mbf;
  
  public d(Context paramContext, o paramo)
  {
    super(paramContext);
    AppMethodBeat.i(48602);
    this.maO = e.b.lOQ;
    this.maR = null;
    this.maU = false;
    this.maV = false;
    this.maW = false;
    this.maY = false;
    this.maZ = 30;
    boolean bool1;
    label230:
    Object localObject2;
    if ((bt.eWo()) || (DebuggerShell.baW()) || (bt.eWm()) || (h.IS_FLAVOR_RED))
    {
      bool1 = true;
      this.jgc = bool1;
      this.jez = paramo;
      ac.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
      setClickable(true);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      LayoutInflater.from(getContext()).inflate(2131493063, this);
      this.mba = ((RelativeLayout)findViewById(2131296717));
      this.mbb = ((ImageView)findViewById(2131296718));
      this.mbc = ((BootstrapProgressBar)findViewById(2131296719));
      com.tencent.mm.plugin.appbrand.game.preload.e.bdV().dK(999, 1);
      if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUF, false)) && (this.jez != null))
      {
        final long l = bs.Gn();
        paramo = this.jez.aTS();
        if (paramo.cch.jFP != null) {
          break label1131;
        }
        paramContext = null;
        if (bs.isNullOrNil(paramContext)) {
          break label1145;
        }
        this.maU = true;
        ac.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramContext });
        com.tencent.mm.plugin.appbrand.game.preload.e.bdV().dK(1000, 1);
        com.tencent.mm.ci.a.post(new d.3(this, paramContext, new com.tencent.mm.plugin.appbrand.game.preload.a.a()
        {
          public final void a(final Bitmap paramAnonymousBitmap, final long paramAnonymousLong)
          {
            AppMethodBeat.i(48589);
            ac.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
            d.a(d.this);
            if (d.b(d.this) != null) {
              l.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(48588);
                  if (paramAnonymousBitmap != null)
                  {
                    d.b(d.this).setImageBitmap(paramAnonymousBitmap);
                    if (d.c(d.this)) {
                      d.d(d.this);
                    }
                    com.tencent.mm.plugin.appbrand.game.preload.e.bdV().dK(1002, (int)bs.aO(d.2.this.mbi));
                    com.tencent.mm.plugin.appbrand.game.preload.e.bdV().dK(1001, (int)paramAnonymousLong);
                  }
                  AppMethodBeat.o(48588);
                }
              });
            }
            AppMethodBeat.o(48589);
          }
        }));
        if (paramo.cch.jFP != null) {
          break label1158;
        }
        paramContext = (Context)localObject1;
        label303:
        if (bs.isNullOrNil(paramContext)) {
          break label1172;
        }
        this.maX = Color.parseColor(paramContext);
        this.mbc.setProgressColor(this.maX);
        ac.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.maX) });
        label351:
        this.mbc.setAnimated(true);
        this.mbc.setStriped(true);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48591);
            d.f(d.this);
            ac.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (d.g(d.this)) {
              d.d(d.this);
            }
            AppMethodBeat.o(48591);
          }
        }, 1000L);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48592);
            if (d.g(d.this))
            {
              AppMethodBeat.o(48592);
              return;
            }
            d.h(d.this);
            d.i(d.this).setVisibility(0);
            d.j(d.this).setVisibility(0);
            d.k(d.this).setVisibility(0);
            d.l(d.this);
            AppMethodBeat.o(48592);
          }
        }, 2000L);
      }
      label395:
      this.maS = ((RelativeLayout)findViewById(2131296727));
      this.maH = ((ImageView)findViewById(2131296723));
      this.maH.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aAR());
      this.maK = ((TextView)findViewById(2131296724));
      this.maI = ((ImageView)findViewById(2131296731));
      this.lWT = ((ThreeDotsLoadingView)findViewById(2131296726));
      this.maJ = ((ImageView)findViewById(2131296725));
      this.maL = ((LinearLayout)findViewById(2131296721));
      this.maN = ((TextView)findViewById(2131296728));
      this.maP = ((TextView)findViewById(2131301494));
      this.maT = ((TextView)findViewById(2131296730));
      paramContext = (RelativeLayout.LayoutParams)this.lWT.getLayoutParams();
      paramo = (RelativeLayout.LayoutParams)this.maJ.getLayoutParams();
      localObject1 = (RelativeLayout.LayoutParams)this.maI.getLayoutParams();
      this.maM = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
      this.maM.setFullscreenMode(true);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 21;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.cc.a.av(getContext(), 2131165772);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165773);
      this.maL.addView(this.maM.getActionView(), (ViewGroup.LayoutParams)localObject2);
      if (this.jez.aTS().originalFlag != 1) {
        break label1203;
      }
      this.maJ.setVisibility(0);
      label690:
      localObject2 = (RelativeLayout.LayoutParams)this.mbc.getLayoutParams();
      this.maO = this.jez.getWindowAndroid().getOrientationHandler().aUB();
      ac.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.maO });
      if ((this.maO != e.b.lOS) && (this.maO != e.b.lOT) && (this.maO != e.b.lOU) && (this.maO != e.b.lOV)) {
        break label1247;
      }
      if (this.maJ.getVisibility() != 0) {
        break label1215;
      }
      paramContext.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165778);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165774);
      paramo.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165781);
      this.maJ.setLayoutParams(paramo);
      label843:
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165768);
      ((RelativeLayout.LayoutParams)localObject2).width = com.tencent.mm.cc.a.av(getContext(), 2131165769);
      this.lWT.setLayoutParams(paramContext);
      this.mbc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.maI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      L(getResources().getColor(2131099650), true);
      this.maM.setBackgroundColor(0);
      paramContext = this.maM;
      if (this.mbf == null) {
        this.mbf = Boolean.valueOf(aj.DT());
      }
      bool1 = bool2;
      if (!this.mbf.booleanValue()) {
        bool1 = true;
      }
      paramContext.setForegroundStyle(bool1);
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48597);
          com.tencent.mm.plugin.appbrand.g.a(d.e(d.this).mAppId, g.d.jdc);
          d.e(d.this).finish();
          AppMethodBeat.o(48597);
        }
      };
      this.maM.setCloseButtonClickListener(paramContext);
      this.maM.setBackButtonClickListener(paramContext);
      r.s(getContext(), true);
      if (this.maU) {
        break label1373;
      }
      this.lWT.fuW();
    }
    for (;;)
    {
      if ((this.jgc) || (this.jez.jdx.joY == 1) || (this.jez.jdx.joY == 2))
      {
        paramContext = b.b.lXl;
        localObject1 = com.tencent.mm.plugin.appbrand.x.a.a.buf();
        localObject2 = new com.tencent.mm.plugin.appbrand.x.c()
        {
          public final void a(String paramAnonymousString, b.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(48586);
            ac.i("MicroMsg.AppBrandGameUILoadingSplash", "onStepEnd sessionId:%s,step:%s,cost:%d", new Object[] { paramAnonymousString, paramAnonymousb.name(), Long.valueOf(paramAnonymousLong) });
            d.buY();
            AppMethodBeat.o(48586);
          }
          
          public final void ed(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            AppMethodBeat.i(48587);
            ac.e("MicroMsg.AppBrandGameUILoadingSplash", "onJsError message:%s,stackTrace:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            l.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48585);
                Toast.makeText(d.this.getContext(), paramAnonymousString1 + paramAnonymousString2, 1).show();
                AppMethodBeat.o(48585);
              }
            });
            AppMethodBeat.o(48587);
          }
        };
        paramo = (List)((com.tencent.mm.plugin.appbrand.x.a)localObject1).kBk.get("WeAppLaunch");
        paramContext = paramo;
        if (paramo == null)
        {
          paramContext = new LinkedList();
          ((com.tencent.mm.plugin.appbrand.x.a)localObject1).kBk.put("WeAppLaunch", paramContext);
        }
        paramContext.add(localObject2);
      }
      AppMethodBeat.o(48602);
      return;
      bool1 = false;
      break;
      label1131:
      paramContext = paramo.cch.jFP.jFL;
      break label230;
      label1145:
      com.tencent.mm.plugin.appbrand.game.preload.e.bdV().dK(1000, 0);
      break label395;
      label1158:
      paramContext = paramo.cch.jFP.jFM;
      break label303;
      label1172:
      this.maX = getContext().getResources().getColor(2131099927);
      this.mbc.setProgressColor(this.maX);
      break label351;
      label1203:
      this.maJ.setVisibility(8);
      break label690;
      label1215:
      paramContext.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165782);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165775);
      break label843;
      label1247:
      if (this.maJ.getVisibility() == 0)
      {
        paramContext.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165780);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165775);
        paramo.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165783);
        this.maJ.setLayoutParams(paramo);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = com.tencent.mm.cc.a.av(getContext(), 2131165771);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165770);
        break;
        paramContext.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165779);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165775);
      }
      label1373:
      this.lWT.setVisibility(4);
      this.maN.setVisibility(4);
    }
  }
  
  public final void boo()
  {
    AppMethodBeat.i(48604);
    ac.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48595);
        final ViewParent localViewParent = d.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          ac.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(48595);
          return;
        }
        ViewPropertyAnimator localViewPropertyAnimator = d.this.animate();
        localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
        localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
        localViewPropertyAnimator.setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(48594);
            d.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48593);
                ac.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                d.this.setVisibility(8);
                ((ViewGroup)d.6.1.this.mbn).removeView(d.this);
                AppMethodBeat.o(48593);
              }
            });
            AppMethodBeat.o(48594);
          }
        });
        localViewPropertyAnimator.alpha(0.0F).start();
        AppMethodBeat.o(48595);
      }
    });
    AppMethodBeat.o(48604);
  }
  
  public final void dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48603);
    com.tencent.mm.modelappbrand.a.b.aAS().a(this.maH, paramString1, null, com.tencent.mm.modelappbrand.a.g.htk);
    this.maK.setText(paramString2);
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
    e.b localb = this.jez.getWindowAndroid().getOrientationHandler().aUB();
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    RelativeLayout.LayoutParams localLayoutParams4;
    if (localb != this.maO)
    {
      this.maO = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.lWT.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.maJ.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.mbc.getLayoutParams();
      localLayoutParams4 = (RelativeLayout.LayoutParams)this.maI.getLayoutParams();
      if ((localb != e.b.lOS) && (localb != e.b.lOT) && (localb != e.b.lOU) && (localb != e.b.lOV)) {
        break label296;
      }
      if (this.maJ.getVisibility() != 0) {
        break label263;
      }
      localLayoutParams1.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165778);
      localLayoutParams4.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165774);
      localLayoutParams2.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165781);
      this.maJ.setLayoutParams(localLayoutParams2);
    }
    for (;;)
    {
      localLayoutParams3.width = com.tencent.mm.cc.a.av(getContext(), 2131165769);
      localLayoutParams3.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165768);
      this.mbc.setLayoutParams(localLayoutParams3);
      this.lWT.setLayoutParams(localLayoutParams1);
      this.maI.setLayoutParams(localLayoutParams4);
      requestLayout();
      AppMethodBeat.o(48605);
      return;
      label263:
      localLayoutParams1.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165782);
      localLayoutParams4.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165775);
    }
    label296:
    if (this.maJ.getVisibility() == 0)
    {
      localLayoutParams1.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165780);
      localLayoutParams4.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165775);
      localLayoutParams2.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165783);
      this.maJ.setLayoutParams(localLayoutParams2);
    }
    for (;;)
    {
      localLayoutParams3.width = com.tencent.mm.cc.a.av(getContext(), 2131165771);
      localLayoutParams3.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165770);
      break;
      localLayoutParams1.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165779);
      localLayoutParams4.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165775);
    }
  }
  
  public final void rc(final int paramInt)
  {
    AppMethodBeat.i(48607);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48596);
        ac.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (d.m(d.this))
          {
            d.n(d.this).setVisibility(0);
            d.n(d.this).setText(2131755950);
            d.k(d.this).setVisibility(4);
            AppMethodBeat.o(48596);
            return;
          }
          d.a(d.this, this);
        }
        AppMethodBeat.o(48596);
      }
    });
    AppMethodBeat.o(48607);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(48606);
    if (!this.maU)
    {
      if (paramInt < 100)
      {
        this.maN.setText(String.format("%d%%", new Object[] { Integer.valueOf(paramInt / 2) }));
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.mbd)
      {
        this.mbd = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 50L);
        AppMethodBeat.o(48606);
      }
    }
    else if ((!this.maV) && (this.maY))
    {
      if (paramInt < 100)
      {
        this.maN.setText(String.format("%d%%", new Object[] { Integer.valueOf(paramInt / 2) }));
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.mbd)
      {
        this.mbd = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 100L);
        AppMethodBeat.o(48606);
      }
    }
    else if (paramInt < 100)
    {
      if (this.mba.getVisibility() == 0)
      {
        this.mbc.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
      }
    }
    else if (!this.mbe)
    {
      this.mbe = true;
      new Timer(true).scheduleAtFixedRate(new a(), 0L, 1000 / this.maZ);
    }
    AppMethodBeat.o(48606);
  }
  
  public final void tT(int paramInt) {}
  
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
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48598);
          if (d.q(d.this).getVisibility() == 0) {
            d.r(d.this).setProgress(d.a.a(d.a.this));
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
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48600);
          if (d.k(d.this).getVisibility() == 0)
          {
            d.k(d.this).setText(String.format("%d%%", new Object[] { Integer.valueOf(d.b.a(d.b.this)) }));
            if (d.b.a(d.b.this) == 100)
            {
              d.o(d.this);
              if (d.p(d.this) != null)
              {
                d.p(d.this).run();
                d.a(d.this, null);
              }
            }
          }
          AppMethodBeat.o(48600);
        }
      });
      AppMethodBeat.o(48601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */