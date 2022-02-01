package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d.1;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.HashMap;
import java.util.Timer;

public final class a
  extends com.tencent.mm.plugin.appbrand.widget.header.c
{
  private View azo;
  private Context mContext;
  private View mLY;
  private ListView mListView;
  private float mZA;
  private int mZB;
  private int mZC;
  private Vibrator mZD;
  private int mZE;
  private com.tencent.mm.plugin.appbrand.widget.header.a mZF;
  private DynamicBackgroundGLSurfaceView mZG;
  private View mZH;
  private boolean mZI;
  private boolean mZJ;
  private boolean mZK;
  private View mZL;
  private boolean mZM;
  private int mZN;
  private int mZO;
  private int mZP;
  private Runnable mZQ;
  private Runnable mZR;
  private com.tencent.e.i.b mZS;
  private com.tencent.e.i.b mZT;
  private boolean mZU;
  private boolean mZV;
  private boolean mZW;
  private boolean mZX;
  private boolean mZY;
  private int mZZ;
  private HeaderContainer mZy;
  private float mZz;
  private GyroView naA;
  private View naB;
  private boolean naC;
  private boolean naD;
  private boolean naE;
  private boolean naa;
  private boolean nab;
  private boolean nac;
  private boolean nad;
  private boolean nae;
  private int naf;
  private int nag;
  private int nah;
  private int nai;
  private int naj;
  private int nak;
  private int nal;
  private com.tencent.mm.plugin.appbrand.widget.header.b nam;
  private boolean nan;
  private Runnable nao;
  private boolean nap;
  private boolean naq;
  private boolean nar;
  private Runnable nas;
  private boolean nat;
  private PointF nau;
  private PointF nav;
  private boolean naw;
  private boolean nax;
  private Runnable nay;
  private boolean naz;
  
  public a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(49398);
    this.mZz = 0.2F;
    this.mZA = 0.05F;
    this.mZB = 0;
    this.mZC = 0;
    this.mZI = true;
    this.mZJ = false;
    this.mZK = false;
    this.mZM = true;
    this.mZN = 0;
    this.mZO = 0;
    this.mZP = 0;
    this.mZQ = null;
    this.mZR = null;
    this.mZS = null;
    this.mZT = null;
    this.mZU = false;
    this.mZV = false;
    this.mZW = true;
    this.mZX = false;
    this.mZY = false;
    this.mZZ = 0;
    this.naa = false;
    this.nab = true;
    this.nac = true;
    this.nad = false;
    this.nae = false;
    this.naf = -2;
    this.nag = 0;
    this.nah = 0;
    this.nai = 0;
    this.naj = 0;
    this.nak = 0;
    this.nal = 0;
    this.nan = false;
    this.nap = true;
    this.naq = false;
    this.nar = false;
    this.nau = new PointF();
    this.nav = new PointF();
    this.naw = false;
    this.nax = false;
    this.nay = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49392);
        a.j(a.this);
        AppMethodBeat.o(49392);
      }
    };
    this.naz = true;
    this.naC = true;
    this.naD = false;
    this.naE = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.mZy = paramHeaderContainer;
    this.mZD = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.mZE = com.tencent.mm.ui.ar.dX(this.mContext);
    boolean bool = paramListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49385);
        a.a(a.this, com.tencent.mm.ui.ar.dX(a.a(a.this)));
        ae.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:" + a.b(a.this));
        AppMethodBeat.o(49385);
      }
    });
    this.nac = b.adU();
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.nac), Integer.valueOf(this.mZE), Boolean.valueOf(bool) });
    bDv();
    bDw();
    bDk();
    this.nam = new com.tencent.mm.plugin.appbrand.widget.header.b(this.mContext.getResources().getColor(2131099732), this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(49398);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49425);
    ae.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(paramFloat, paramInt1);
    if (this.mZF != null) {
      this.mZF.a(paramFloat, paramInt1, paramInt2);
    }
    if (this.mZy != null) {
      this.mZy.wf(paramInt1);
    }
    AppMethodBeat.o(49425);
  }
  
  private void aM(float paramFloat)
  {
    AppMethodBeat.i(49426);
    ae.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.nam.aO(1.0F - paramFloat);
    if (this.mZF != null) {
      this.mZF.b(paramFloat, i, i);
    }
    if (this.mZy != null) {
      this.mZy.et(i, i);
    }
    AppMethodBeat.o(49426);
  }
  
  private void bDk()
  {
    AppMethodBeat.i(49399);
    try
    {
      this.mZN = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.mZO = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
      if (this.mZN < this.mZO) {
        this.mZO = 0;
      }
      this.mZP = this.mZN;
      this.nai = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100);
      this.nal = this.mContext.getResources().getColor(2131099648);
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.mZN), Integer.valueOf(this.mZP), Integer.valueOf(this.nai) });
      AppMethodBeat.o(49399);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(49399);
    }
  }
  
  private int bDm()
  {
    AppMethodBeat.i(49403);
    if (this.mZy.getMeasuredHeight() == 0)
    {
      AppMethodBeat.o(49403);
      return 0;
    }
    int i = this.mZy.getBottom();
    int j = this.mZE;
    AppMethodBeat.o(49403);
    return i - j;
  }
  
  private boolean bDn()
  {
    AppMethodBeat.i(49404);
    if ((this.mZy != null) && (this.mZy.getBottom() <= 0))
    {
      AppMethodBeat.o(49404);
      return false;
    }
    int i = bDm() - 60;
    if (!bDt())
    {
      if (i > bDu())
      {
        AppMethodBeat.o(49404);
        return true;
      }
      AppMethodBeat.o(49404);
      return false;
    }
    if (this.mZC == 0) {
      this.mZC = ((int)(this.mZy.getHeight() * this.mZA));
    }
    if (i < this.mZC)
    {
      AppMethodBeat.o(49404);
      return true;
    }
    AppMethodBeat.o(49404);
    return false;
  }
  
  private void bDo()
  {
    AppMethodBeat.i(49411);
    this.nan = true;
    if (this.nao != null) {
      this.mListView.removeCallbacks(this.nao);
    }
    ListView localListView = this.mListView;
    Runnable local9 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49394);
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIgnoreInLayout false");
        a.l(a.this);
        AppMethodBeat.o(49394);
      }
    };
    this.nao = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(49411);
  }
  
  private void bDq()
  {
    AppMethodBeat.i(49414);
    if (this.mZQ != null) {
      com.tencent.mm.sdk.platformtools.ar.ay(this.mZQ);
    }
    if (this.mZW)
    {
      Runnable local11 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49397);
          ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayHideBackgroundView");
          a.m(a.this);
          AppMethodBeat.o(49397);
        }
      };
      this.mZQ = local11;
      com.tencent.mm.sdk.platformtools.ar.o(local11, 500L);
      AppMethodBeat.o(49414);
      return;
    }
    bDx();
    AppMethodBeat.o(49414);
  }
  
  private boolean bDt()
  {
    AppMethodBeat.i(49419);
    if ((Math.abs(this.nav.y - this.nau.y) <= 5.0F) || (this.nav.y <= this.nau.y))
    {
      AppMethodBeat.o(49419);
      return true;
    }
    AppMethodBeat.o(49419);
    return false;
  }
  
  private int bDu()
  {
    AppMethodBeat.i(49420);
    if (this.mZB == 0) {
      this.mZB = ((int)(this.mZy.getHeight() * this.mZz));
    }
    int i = this.mZB;
    AppMethodBeat.o(49420);
    return i;
  }
  
  private void bDv()
  {
    this.naE = true;
    this.naC = true;
  }
  
  private void bDw()
  {
    AppMethodBeat.i(49421);
    if (this.naA != null)
    {
      this.naA.b(0.0F, bDu());
      this.naA.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49421);
  }
  
  private void bDx()
  {
    AppMethodBeat.i(49422);
    boolean bool2 = this.nac;
    if ((b.adU()) && (this.mZG != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.nac = bool1;
      bDy();
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.nac), Boolean.valueOf(bool2) });
      if ((!this.mZW) || (!bDs())) {
        break;
      }
      AppMethodBeat.o(49422);
      return;
    }
    if (bool2) {
      if ((this.mZG != null) && (!this.mZI))
      {
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView onPause and set GONE");
        this.mZG.onPause();
        this.mZI = true;
        this.mZJ = true;
        this.mZG.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.mZL != null)
      {
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView GradientColorView set GONE");
        this.mZL.setVisibility(8);
      }
      AppMethodBeat.o(49422);
      return;
      if (this.mZG != null)
      {
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView set GONE");
        this.mZG.setVisibility(8);
      }
    }
  }
  
  private void bDy()
  {
    AppMethodBeat.i(49424);
    if ((this.mZL instanceof GradientColorBackgroundView)) {
      ((GradientColorBackgroundView)this.mZL).setUpdateMode(1);
    }
    AppMethodBeat.o(49424);
  }
  
  private void wd(int paramInt)
  {
    AppMethodBeat.i(49408);
    ae.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.mLY != null) {
      this.mLY.getVisibility();
    }
    AppMethodBeat.o(49408);
  }
  
  public final void I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49406);
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.nas);
    this.mListView.removeCallbacks(this.mZR);
    this.nau.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.nar = false;
    this.nan = false;
    this.naw = true;
    AppMethodBeat.o(49406);
  }
  
  public final void b(long paramLong, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(49402);
    super.b(paramLong, paramInt, paramBoolean);
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.mZR != null) {
      this.mListView.removeCallbacks(this.mZR);
    }
    ListView localListView = this.mListView;
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49391);
        a.a(a.this, paramBoolean);
        a.this.wc(paramInt);
        AppMethodBeat.o(49391);
      }
    };
    this.mZR = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(49402);
  }
  
  public final void bDl()
  {
    AppMethodBeat.i(49400);
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(bDs()), Boolean.valueOf(this.nad) });
    if (!bDs())
    {
      AppMethodBeat.o(49400);
      return;
    }
    if ((this.naC) && (this.naD)) {
      be.jh(this.mContext);
    }
    this.naq = true;
    this.mZY = false;
    wd(8);
    this.mListView.removeCallbacks(this.nas);
    Object localObject = this.mListView;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49389);
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
        int i = a.c(a.this).getTop();
        a.d(a.this).smoothScrollBy(i, 600);
        a.e(a.this);
        AppMethodBeat.o(49389);
      }
    };
    this.nas = local4;
    ((ListView)localObject).post(local4);
    if (!this.nac)
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(49400);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.nen;
    if (!com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bEc())
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(49400);
      return;
    }
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.mZU), Boolean.valueOf(this.mZV) });
    if ((!this.mZU) && (!this.mZV))
    {
      this.mZU = true;
      if (this.mZS != null) {
        this.mZS.cancel();
      }
      this.mZS = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "MicroMsg.AppBrandDesktopAnimController#startMonitorRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(49386);
          d locald;
          if (!com.tencent.mm.plugin.appbrand.widget.desktop.c.c.nfW.gxv)
          {
            ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
            ??? = com.tencent.mm.plugin.appbrand.widget.desktop.c.c.nfW;
            if (!((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).gxv)
            {
              ((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).gxv = true;
              ae.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bu.fpN() });
              ((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).aht().postFrameCallback((Choreographer.FrameCallback)???);
            }
            locald = d.nfZ;
          }
          synchronized (locald.gxC)
          {
            if (locald.isRunning)
            {
              ae.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
              a.n(a.this);
              AppMethodBeat.o(49386);
              return;
            }
            if (locald.mTimer != null) {
              locald.mTimer.cancel();
            }
            System.gc();
            locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
            locald.gxA.clear();
            locald.gxA.put(Integer.valueOf(1), new com.tencent.mm.plugin.appbrand.widget.desktop.c.a());
            locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
            locald.isRunning = true;
          }
        }
      };
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
      h.MqF.f(this.mZS, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(49400);
  }
  
  public final void bDp()
  {
    AppMethodBeat.i(49412);
    if (this.azo != null)
    {
      this.mZY = true;
      this.azo.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49412);
  }
  
  public final boolean bDr()
  {
    AppMethodBeat.i(49417);
    if ((bDs()) && (this.nad))
    {
      AppMethodBeat.o(49417);
      return true;
    }
    AppMethodBeat.o(49417);
    return false;
  }
  
  public final boolean bDs()
  {
    AppMethodBeat.i(49418);
    if ((this.mZy.getBottom() >= this.mZE + 10) && (this.mListView.getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(49418);
      return true;
    }
    AppMethodBeat.o(49418);
    return false;
  }
  
  public final void g(View paramView1, View paramView2)
  {
    AppMethodBeat.i(49423);
    if ((paramView1 instanceof DynamicBackgroundGLSurfaceView)) {
      this.mZG = ((DynamicBackgroundGLSurfaceView)paramView1);
    }
    if (this.mZG == null) {
      this.nac = false;
    }
    this.mZL = paramView2;
    if ((this.mZG != null) && ((this.mZL instanceof GradientColorBackgroundView)))
    {
      this.mZG.setGradientBackgroundView((GradientColorBackgroundView)this.mZL);
      bDy();
    }
    AppMethodBeat.o(49423);
  }
  
  public final int getAnimationScrollOffset()
  {
    return this.nak;
  }
  
  public final void hW(boolean paramBoolean)
  {
    AppMethodBeat.i(49410);
    super.hW(paramBoolean);
    this.nad = true;
    if ((this.mZL != null) && (this.mZL.getVisibility() == 0)) {
      this.mZL.invalidate();
    }
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.mZY), Boolean.valueOf(this.nac) });
    if (this.azo == null)
    {
      AppMethodBeat.o(49410);
      return;
    }
    if (this.mZY)
    {
      bDp();
      AppMethodBeat.o(49410);
      return;
    }
    if (!bDs())
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
      this.azo.setTranslationY(0.0F);
      AppMethodBeat.o(49410);
      return;
    }
    this.azo.animate().translationY(this.azo.getHeight()).setDuration(260L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49393);
        a.k(a.this).setVisibility(4);
        a.k(a.this).animate().setListener(null);
        AppMethodBeat.o(49393);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    bDo();
    AppMethodBeat.o(49410);
  }
  
  public final void hX(boolean paramBoolean)
  {
    AppMethodBeat.i(49413);
    super.hX(paramBoolean);
    this.nad = false;
    bDw();
    bDq();
    if (this.azo == null)
    {
      AppMethodBeat.o(49413);
      return;
    }
    this.azo.setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.azo.animate().translationY(0.0F);
    if (this.azo.getTranslationY() == 0.0F) {}
    for (long l = 130L;; l = 260L)
    {
      localViewPropertyAnimator.setDuration(l).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49396);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(49396);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49395);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(49395);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      bDo();
      AppMethodBeat.o(49413);
      return;
    }
  }
  
  public final void hY(boolean paramBoolean)
  {
    AppMethodBeat.i(49416);
    if ((this.mZy.isFullScreen()) && (paramBoolean != this.naz))
    {
      if (bv.fpT()) {
        ae.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.naz) });
      }
      this.naz = paramBoolean;
      dn localdn = new dn();
      localdn.dpr.enable = paramBoolean;
      com.tencent.mm.sdk.b.a.IvT.l(localdn);
    }
    AppMethodBeat.o(49416);
  }
  
  public final void iv()
  {
    AppMethodBeat.i(49415);
    bDk();
    this.nab = false;
    AppMethodBeat.o(49415);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49429);
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
    if (this.mListView != null)
    {
      if (this.mZR != null)
      {
        this.mListView.removeCallbacks(this.mZR);
        this.mZR = null;
      }
      if (this.mZQ != null)
      {
        this.mListView.removeCallbacks(this.mZQ);
        this.mZQ = null;
      }
      if (this.nao != null)
      {
        this.mListView.removeCallbacks(this.nao);
        this.nao = null;
      }
    }
    h.MqF.bbc("AppBrandDesktopPerformanceMonitor");
    d.nfZ.ahv();
    d.nfZ.release();
    this.mZU = false;
    if (this.mZG != null)
    {
      DynamicBackgroundGLSurfaceView.b localb = this.mZG.gie;
      if (localb != null) {
        try
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
          DynamicBackgroundNative localDynamicBackgroundNative = localb.gii;
          if (localDynamicBackgroundNative != null) {
            localDynamicBackgroundNative.nativeRelease();
          }
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
          localb.gil = 0;
          localb.gim = 0;
          localb.giu = false;
          AppMethodBeat.o(49429);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo nativeRelease exception", new Object[0]);
          AppMethodBeat.o(49429);
          return;
        }
      }
    }
    AppMethodBeat.o(49429);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49428);
    super.onResume();
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, isCurrentMainUI: %b", new Object[] { Boolean.valueOf(bDs()), Integer.valueOf(this.mZy.getBottom()), Integer.valueOf(this.mZy.getHeight()), Boolean.valueOf(this.nap) });
    if ((bDs()) && (this.mZy.getBottom() < this.mZy.getHeight()))
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume fastCloseHeader");
      b(0L, 0, true);
    }
    if (!this.nad)
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume enableBottomTabSwitch true");
      hY(true);
      AppMethodBeat.o(49428);
      return;
    }
    if (!this.nap)
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume not main ui and header open, then close header");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49428);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49409);
    if ((!this.nan) && (paramAbsListView.isInLayout()) && (!this.mZY) && (this.mZy.getBottom() < this.mZy.getHeight()) && (this.nad))
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
      wc(0);
      AppMethodBeat.o(49409);
      return;
    }
    if ((this.nar) && (!this.naq) && (this.nat) && (paramInt1 <= 0) && (bDs()))
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      wc(4);
    }
    if ((this.mZy != null) && (this.mZy.getHeight() != this.naj))
    {
      this.nak = ((int)(this.mZy.getHeight() * this.mZz) + 60);
      this.nag = ((int)(this.mZy.getHeight() * this.mZz) + 60);
      this.nah = (this.mZy.getHeight() - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 50));
      this.mZB = ((int)(this.mZy.getHeight() * this.mZz));
      this.mZC = ((int)(this.mZy.getHeight() * this.mZA));
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, listBgStartAlphaOffset: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.mZy.getHeight()), Integer.valueOf(this.naj), Integer.valueOf(this.nak), Integer.valueOf(this.nag), Integer.valueOf(this.nah), Integer.valueOf(this.mZB), Integer.valueOf(this.mZC) });
      this.naj = this.mZy.getHeight();
    }
    ae.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.nat), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.nar), Integer.valueOf(this.nag) });
    label861:
    int i;
    float f1;
    int j;
    label1137:
    Object localObject;
    if ((!this.nar) && (paramInt1 == 0) && (this.mZy != null))
    {
      ae.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(this.mZy.getBottom()), Integer.valueOf(this.mZE), Integer.valueOf(this.mZy.getHeight()), Integer.valueOf(this.mZy.getBottom()), Boolean.valueOf(this.mZK) });
      if ((this.mZG != null) || (this.mZL != null))
      {
        if (!this.nac) {
          break label1294;
        }
        if ((bDs()) && (this.mZI) && (this.mZK))
        {
          this.mZI = false;
          if (this.mZG != null)
          {
            this.mZG.setVisibility(0);
            this.mZG.setShowGradientView(false);
          }
          if ((this.mZJ) && (this.mZG != null))
          {
            ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
            this.mZG.onResume();
            this.mZJ = false;
          }
        }
      }
      if (this.nab) {
        break label1382;
      }
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (g.abu())) && (Build.VERSION.SDK_INT >= 21) && (!bDr()))
      {
        if ((this.mZy != null) && (this.mZy.getBottom() <= this.mZE + 20))
        {
          if (this.mZL != null) {
            this.mZL.setVisibility(8);
          }
          if (this.mZG != null)
          {
            this.mZG.onPause();
            this.mZI = true;
            this.mZJ = true;
            this.mZG.setVisibility(8);
          }
        }
        if ((this.mListView.getFirstVisiblePosition() > 0) || ((this.mListView.getFirstVisiblePosition() == 0) && (!bDs())))
        {
          this.mListView.setBackgroundColor(this.mListView.getResources().getColor(2131101053));
          if (this.mZH != null) {
            this.mZH.setBackgroundColor(this.mContext.getResources().getColor(2131101053));
          }
          if (this.mZL != null) {
            this.mZL.setVisibility(4);
          }
        }
      }
      if (bDs()) {
        break label1740;
      }
      this.nar = true;
      if ((bDn()) || (!this.nae)) {
        break label1717;
      }
      z(false, true);
      if (this.naA == null) {
        this.naA = ((GyroView)this.mZy.findViewById(2131300673));
      }
      if (this.naB == null) {
        this.naB = this.mZy.findViewById(2131296708);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = bDu();
        paramInt2 = this.mZy.getBottom();
        paramInt3 = bDm();
        i = this.nah - this.nag;
        f1 = 1.0F * (paramInt3 - this.nag) / i;
        this.naB.setAlpha(f1);
        j = paramInt3 - 60;
        ae.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.nag), Integer.valueOf(this.nah), Boolean.valueOf(this.nat), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mZy.getHeight()), Integer.valueOf(this.naA.getHeight()) });
        if (((!this.nat) && (paramInt2 >= 5)) || (this.mZX))
        {
          if (paramInt1 < j) {
            break label1748;
          }
          this.naA.b(j, paramInt1);
          this.naA.setAlpha(1.0F);
        }
        f1 = 1.0F * (j - paramInt1) / this.nai;
        localObject = this.naA;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.naA.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.naE) && (bDs()) && (!paramAbsListView.isInLayout()))
        {
          this.mZD.vibrate(10L);
          this.naE = false;
        }
        if (paramInt2 < this.mZE + 10) {
          bDv();
        }
      }
      this.nax = bDs();
      if ((!bDs()) || (!this.naw)) {
        break label1761;
      }
      hY(false);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ar.ay(this.nay);
      com.tencent.mm.sdk.platformtools.ar.o(this.nay, 60L);
      AppMethodBeat.o(49409);
      return;
      label1294:
      this.mZI = true;
      this.mZJ = true;
      if (this.mZG != null)
      {
        this.mZG.setVisibility(8);
        this.mZG.onPause();
      }
      if ((!bDs()) || (this.mZL == null) || ((this.mZL.getVisibility() == 0) && (this.mZL.getAlpha() == 1.0F))) {
        break;
      }
      this.mZL.setAlpha(1.0F);
      this.mZL.setVisibility(0);
      break;
      label1382:
      paramInt3 = bDm();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.nak) / (this.mZy.getMeasuredHeight() - this.mZE - this.nak)));
      i = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(f1, this.mContext.getResources().getColor(2131099648));
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(i);
      }
      if (this.mZH != null) {
        this.mZH.setBackgroundColor(i);
      }
      i = this.mZy.getHeight() - this.mZE - this.mZN;
      j = bDm() - i;
      float f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.mZN - this.mZO)));
      ae.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
      if ((paramInt3 < this.nak) || (paramInt3 < this.nag))
      {
        wd(0);
        a(1.0F, this.nal, paramInt3);
        aM(1.0F);
      }
      for (;;)
      {
        paramInt3 = paramInt1;
        while (paramInt3 < paramInt1 + paramInt2)
        {
          localObject = paramAbsListView.getChildAt(paramInt3);
          if ((localObject != null) && (paramInt3 != 0)) {
            ((View)localObject).setAlpha(f1);
          }
          paramInt3 += 1;
        }
        break;
        if (f2 >= 0.0F)
        {
          wd(8);
          a(f2, this.mContext.getResources().getColor(2131099930), paramInt3);
          aM(1.0F - f2);
        }
      }
      label1717:
      if ((!this.nax) || (!this.nae)) {
        break label861;
      }
      z(false, true);
      break label861;
      label1740:
      this.nar = false;
      break label861;
      label1748:
      this.naA.b(paramInt1, paramInt1);
      break label1137;
      label1761:
      if (!this.nad) {
        hY(true);
      } else if (this.nad) {
        hY(false);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(49407);
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bDt()) });
    this.mZK = true;
    int i = this.naf;
    this.naf = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.nae = false;
      if ((this.naq) && (paramInt == 0))
      {
        ae.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
        this.naq = false;
        if (i == -1)
        {
          ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged checkOpen: %b", new Object[] { Boolean.valueOf(bDn()) });
          if ((this.mZy.getBottom() < 200) || (this.mListView.getFirstVisiblePosition() != 0) || (this.nad)) {
            break label188;
          }
        }
        label188:
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt != 0) && (bDn()))
          {
            ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged header is visible but not open");
            this.mZY = false;
            z(true, false);
          }
          AppMethodBeat.o(49407);
          return;
        }
      }
      if (bDn())
      {
        bDl();
        AppMethodBeat.o(49407);
        return;
      }
      if ((bDt()) && (paramInt == -1))
      {
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
        wc(4);
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == -1)
      {
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        wc(0);
        this.mZX = true;
        AppMethodBeat.o(49407);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.nat = true;
        this.nae = true;
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == 1)
      {
        this.nat = false;
        this.nab = true;
        this.nae = true;
        if (bDt())
        {
          this.nat = false;
          this.mZZ = 4;
        }
      }
    }
    AppMethodBeat.o(49407);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49405);
    if (paramMotionEvent.getAction() == 0) {
      I(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(49405);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.naw = false;
        this.nav.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.mZy != null) && (this.mZy.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (bDt()))
        {
          if (this.mZZ == 0) {
            this.mZZ = 12;
          }
          ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.mZZ) });
        }
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void setActionBar(View paramView)
  {
    this.mLY = paramView;
  }
  
  public final void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.mZF = parama;
  }
  
  public final void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(49427);
    this.nap = paramBoolean;
    if ((!paramBoolean) && (this.nad))
    {
      ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIsCurrentMainUI and header open, close");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49427);
  }
  
  public final void setStatusBarMaskView(View paramView)
  {
    this.mZH = paramView;
  }
  
  public final void setTabView(View paramView)
  {
    this.azo = paramView;
  }
  
  public final void wc(final int paramInt)
  {
    AppMethodBeat.i(49401);
    ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(bDs()), Integer.valueOf(paramInt) });
    this.mZY = true;
    this.naw = false;
    wd(0);
    if (!bDs())
    {
      hX(false);
      AppMethodBeat.o(49401);
      return;
    }
    this.naq = true;
    this.mListView.removeCallbacks(this.nas);
    ListView localListView = this.mListView;
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49390);
        int j = a.c(a.this).getBottom() - a.b(a.this);
        ae.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(a.c(a.this).getBottom()) });
        ListView localListView = a.d(a.this);
        int i;
        if (a.f(a.this))
        {
          i = 10;
          localListView.smoothScrollBy(j, i);
          a.g(a.this);
          a.a(a.this, false);
          if (a.h(a.this) == 0) {
            break label148;
          }
          i = a.h(a.this);
          a.i(a.this);
        }
        for (;;)
        {
          a.b(a.this, i);
          AppMethodBeat.o(49390);
          return;
          i = 600;
          break;
          label148:
          i = paramInt;
        }
      }
    };
    this.nas = local5;
    localListView.post(local5);
    AppMethodBeat.o(49401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */