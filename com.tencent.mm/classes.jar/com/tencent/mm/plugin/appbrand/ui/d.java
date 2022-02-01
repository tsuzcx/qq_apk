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
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.y.b.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ViewConstructor"})
final class d
  extends com.tencent.mm.ui.statusbar.b
  implements q, v
{
  private o iEx;
  public final boolean iGa;
  private ThreeDotsLoadingView luZ;
  private ImageView lyK;
  private ImageView lyL;
  private ImageView lyM;
  private TextView lyN;
  private LinearLayout lyO;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b lyP;
  private TextView lyQ;
  private e.b lyR;
  private TextView lyS;
  private boolean lyT;
  private Runnable lyU;
  private RelativeLayout lyV;
  private TextView lyW;
  private boolean lyX;
  private boolean lyY;
  private boolean lyZ;
  private int lza;
  private boolean lzb;
  private int lzc;
  private RelativeLayout lzd;
  private ImageView lze;
  private BootstrapProgressBar lzf;
  private boolean lzg;
  private boolean lzh;
  private Boolean lzi;
  
  public d(Context paramContext, o paramo)
  {
    super(paramContext);
    AppMethodBeat.i(48602);
    this.lyR = e.b.lmO;
    this.lyU = null;
    this.lyX = false;
    this.lyY = false;
    this.lyZ = false;
    this.lzb = false;
    this.lzc = 30;
    boolean bool1;
    label230:
    Object localObject2;
    if ((bu.eGT()) || (DebuggerShell.aTY()) || (bu.eGR()) || (h.IS_FLAVOR_RED))
    {
      bool1 = true;
      this.iGa = bool1;
      this.iEx = paramo;
      ad.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
      setClickable(true);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      LayoutInflater.from(getContext()).inflate(2131493063, this);
      this.lzd = ((RelativeLayout)findViewById(2131296717));
      this.lze = ((ImageView)findViewById(2131296718));
      this.lzf = ((BootstrapProgressBar)findViewById(2131296719));
      com.tencent.mm.plugin.appbrand.game.preload.e.aWX().dK(999, 1);
      if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqS, false)) && (this.iEx != null))
      {
        final long l = bt.GC();
        paramo = this.iEx.aNc();
        if (paramo.cfl.jfA != null) {
          break label1131;
        }
        paramContext = null;
        if (bt.isNullOrNil(paramContext)) {
          break label1145;
        }
        this.lyX = true;
        ad.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramContext });
        com.tencent.mm.plugin.appbrand.game.preload.e.aWX().dK(1000, 1);
        com.tencent.mm.cj.a.post(new d.3(this, paramContext, new com.tencent.mm.plugin.appbrand.game.preload.a.a()
        {
          public final void a(final Bitmap paramAnonymousBitmap, final long paramAnonymousLong)
          {
            AppMethodBeat.i(48589);
            ad.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
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
                    com.tencent.mm.plugin.appbrand.game.preload.e.aWX().dK(1002, (int)bt.aS(d.2.this.lzl));
                    com.tencent.mm.plugin.appbrand.game.preload.e.aWX().dK(1001, (int)paramAnonymousLong);
                  }
                  AppMethodBeat.o(48588);
                }
              });
            }
            AppMethodBeat.o(48589);
          }
        }));
        if (paramo.cfl.jfA != null) {
          break label1158;
        }
        paramContext = (Context)localObject1;
        label303:
        if (bt.isNullOrNil(paramContext)) {
          break label1172;
        }
        this.lza = Color.parseColor(paramContext);
        this.lzf.setProgressColor(this.lza);
        ad.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.lza) });
        label351:
        this.lzf.setAnimated(true);
        this.lzf.setStriped(true);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48591);
            d.f(d.this);
            ad.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (d.g(d.this)) {
              d.d(d.this);
            }
            AppMethodBeat.o(48591);
          }
        }, 1000L);
        aq.n(new Runnable()
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
      this.lyV = ((RelativeLayout)findViewById(2131296727));
      this.lyK = ((ImageView)findViewById(2131296723));
      this.lyK.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aua());
      this.lyN = ((TextView)findViewById(2131296724));
      this.lyL = ((ImageView)findViewById(2131296731));
      this.luZ = ((ThreeDotsLoadingView)findViewById(2131296726));
      this.lyM = ((ImageView)findViewById(2131296725));
      this.lyO = ((LinearLayout)findViewById(2131296721));
      this.lyQ = ((TextView)findViewById(2131296728));
      this.lyS = ((TextView)findViewById(2131301494));
      this.lyW = ((TextView)findViewById(2131296730));
      paramContext = (RelativeLayout.LayoutParams)this.luZ.getLayoutParams();
      paramo = (RelativeLayout.LayoutParams)this.lyM.getLayoutParams();
      localObject1 = (RelativeLayout.LayoutParams)this.lyL.getLayoutParams();
      this.lyP = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
      this.lyP.setFullscreenMode(true);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 21;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165772);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165773);
      this.lyO.addView(this.lyP.getActionView(), (ViewGroup.LayoutParams)localObject2);
      if (this.iEx.aNc().originalFlag != 1) {
        break label1203;
      }
      this.lyM.setVisibility(0);
      label690:
      localObject2 = (RelativeLayout.LayoutParams)this.lzf.getLayoutParams();
      this.lyR = this.iEx.getWindowAndroid().getOrientationHandler().aNL();
      ad.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.lyR });
      if ((this.lyR != e.b.lmQ) && (this.lyR != e.b.lmR) && (this.lyR != e.b.lmS) && (this.lyR != e.b.lmT)) {
        break label1247;
      }
      if (this.lyM.getVisibility() != 0) {
        break label1215;
      }
      paramContext.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165778);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165774);
      paramo.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165781);
      this.lyM.setLayoutParams(paramo);
      label843:
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165768);
      ((RelativeLayout.LayoutParams)localObject2).width = com.tencent.mm.cd.a.ap(getContext(), 2131165769);
      this.luZ.setLayoutParams(paramContext);
      this.lzf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.lyL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      L(getResources().getColor(2131099650), true);
      this.lyP.setBackgroundColor(0);
      paramContext = this.lyP;
      if (this.lzi == null) {
        this.lzi = Boolean.valueOf(ai.Eq());
      }
      bool1 = bool2;
      if (!this.lzi.booleanValue()) {
        bool1 = true;
      }
      paramContext.setForegroundStyle(bool1);
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48597);
          com.tencent.mm.plugin.appbrand.g.a(d.e(d.this).mAppId, g.d.iDc);
          d.e(d.this).finish();
          AppMethodBeat.o(48597);
        }
      };
      this.lyP.setCloseButtonClickListener(paramContext);
      this.lyP.setBackButtonClickListener(paramContext);
      r.s(getContext(), true);
      if (this.lyX) {
        break label1373;
      }
      this.luZ.ffb();
    }
    for (;;)
    {
      if ((this.iGa) || (this.iEx.iDx.iOP == 1) || (this.iEx.iDx.iOP == 2))
      {
        paramContext = b.b.lvr;
        localObject1 = com.tencent.mm.plugin.appbrand.y.a.a.bnj();
        localObject2 = new com.tencent.mm.plugin.appbrand.y.c()
        {
          public final void a(String paramAnonymousString, b.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(48586);
            ad.i("MicroMsg.AppBrandGameUILoadingSplash", "onStepEnd sessionId:%s,step:%s,cost:%d", new Object[] { paramAnonymousString, paramAnonymousb.name(), Long.valueOf(paramAnonymousLong) });
            d.boc();
            AppMethodBeat.o(48586);
          }
          
          public final void dR(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            AppMethodBeat.i(48587);
            ad.e("MicroMsg.AppBrandGameUILoadingSplash", "onJsError message:%s,stackTrace:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
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
        paramo = (List)((com.tencent.mm.plugin.appbrand.y.a)localObject1).kax.get("WeAppLaunch");
        paramContext = paramo;
        if (paramo == null)
        {
          paramContext = new LinkedList();
          ((com.tencent.mm.plugin.appbrand.y.a)localObject1).kax.put("WeAppLaunch", paramContext);
        }
        paramContext.add(localObject2);
      }
      AppMethodBeat.o(48602);
      return;
      bool1 = false;
      break;
      label1131:
      paramContext = paramo.cfl.jfA.jfw;
      break label230;
      label1145:
      com.tencent.mm.plugin.appbrand.game.preload.e.aWX().dK(1000, 0);
      break label395;
      label1158:
      paramContext = paramo.cfl.jfA.jfx;
      break label303;
      label1172:
      this.lza = getContext().getResources().getColor(2131099927);
      this.lzf.setProgressColor(this.lza);
      break label351;
      label1203:
      this.lyM.setVisibility(8);
      break label690;
      label1215:
      paramContext.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165782);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165775);
      break label843;
      label1247:
      if (this.lyM.getVisibility() == 0)
      {
        paramContext.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165780);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165775);
        paramo.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165783);
        this.lyM.setLayoutParams(paramo);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = com.tencent.mm.cd.a.ap(getContext(), 2131165771);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165770);
        break;
        paramContext.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165779);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165775);
      }
      label1373:
      this.luZ.setVisibility(4);
      this.lyQ.setVisibility(4);
    }
  }
  
  public final void bhu()
  {
    AppMethodBeat.i(48604);
    ad.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48595);
        final ViewParent localViewParent = d.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          ad.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
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
                ad.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                d.this.setVisibility(8);
                ((ViewGroup)d.6.1.this.lzq).removeView(d.this);
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
  
  public final void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48603);
    com.tencent.mm.modelappbrand.a.b.aub().a(this.lyK, paramString1, null, com.tencent.mm.modelappbrand.a.g.gSK);
    this.lyN.setText(paramString2);
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
    e.b localb = this.iEx.getWindowAndroid().getOrientationHandler().aNL();
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    RelativeLayout.LayoutParams localLayoutParams4;
    if (localb != this.lyR)
    {
      this.lyR = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.luZ.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.lyM.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.lzf.getLayoutParams();
      localLayoutParams4 = (RelativeLayout.LayoutParams)this.lyL.getLayoutParams();
      if ((localb != e.b.lmQ) && (localb != e.b.lmR) && (localb != e.b.lmS) && (localb != e.b.lmT)) {
        break label296;
      }
      if (this.lyM.getVisibility() != 0) {
        break label263;
      }
      localLayoutParams1.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165778);
      localLayoutParams4.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165774);
      localLayoutParams2.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165781);
      this.lyM.setLayoutParams(localLayoutParams2);
    }
    for (;;)
    {
      localLayoutParams3.width = com.tencent.mm.cd.a.ap(getContext(), 2131165769);
      localLayoutParams3.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165768);
      this.lzf.setLayoutParams(localLayoutParams3);
      this.luZ.setLayoutParams(localLayoutParams1);
      this.lyL.setLayoutParams(localLayoutParams4);
      requestLayout();
      AppMethodBeat.o(48605);
      return;
      label263:
      localLayoutParams1.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165782);
      localLayoutParams4.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165775);
    }
    label296:
    if (this.lyM.getVisibility() == 0)
    {
      localLayoutParams1.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165780);
      localLayoutParams4.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165775);
      localLayoutParams2.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165783);
      this.lyM.setLayoutParams(localLayoutParams2);
    }
    for (;;)
    {
      localLayoutParams3.width = com.tencent.mm.cd.a.ap(getContext(), 2131165771);
      localLayoutParams3.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165770);
      break;
      localLayoutParams1.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165779);
      localLayoutParams4.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165775);
    }
  }
  
  public final void qp(final int paramInt)
  {
    AppMethodBeat.i(48607);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48596);
        ad.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
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
    if (!this.lyX)
    {
      if (paramInt < 100)
      {
        this.lyQ.setText(String.format("%d%%", new Object[] { Integer.valueOf(paramInt / 2) }));
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.lzg)
      {
        this.lzg = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 50L);
        AppMethodBeat.o(48606);
      }
    }
    else if ((!this.lyY) && (this.lzb))
    {
      if (paramInt < 100)
      {
        this.lyQ.setText(String.format("%d%%", new Object[] { Integer.valueOf(paramInt / 2) }));
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.lzg)
      {
        this.lzg = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 100L);
        AppMethodBeat.o(48606);
      }
    }
    else if (paramInt < 100)
    {
      if (this.lzd.getVisibility() == 0)
      {
        this.lzf.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
      }
    }
    else if (!this.lzh)
    {
      this.lzh = true;
      new Timer(true).scheduleAtFixedRate(new a(), 0L, 1000 / this.lzc);
    }
    AppMethodBeat.o(48606);
  }
  
  public final void tc(int paramInt) {}
  
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
      aq.f(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */