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
import com.tencent.mm.g.a.dm;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d.1;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.Timer;

public final class a
  extends com.tencent.mm.plugin.appbrand.widget.header.c
{
  private View azo;
  private Context mContext;
  private View mGU;
  private ListView mListView;
  private View mUB;
  private boolean mUC;
  private boolean mUD;
  private boolean mUE;
  private View mUF;
  private boolean mUG;
  private int mUH;
  private int mUI;
  private int mUJ;
  private Runnable mUK;
  private Runnable mUL;
  private com.tencent.e.i.b mUM;
  private com.tencent.e.i.b mUN;
  private boolean mUO;
  private boolean mUP;
  private boolean mUQ;
  private boolean mUR;
  private boolean mUS;
  private int mUT;
  private boolean mUU;
  private boolean mUV;
  private boolean mUW;
  private boolean mUX;
  private boolean mUY;
  private int mUZ;
  private HeaderContainer mUr;
  private float mUs;
  private float mUt;
  private int mUu;
  private int mUv;
  private Vibrator mUw;
  private int mUx;
  private com.tencent.mm.plugin.appbrand.widget.header.a mUy;
  private DynamicBackgroundGLSurfaceView mUz;
  private int mVa;
  private int mVb;
  private int mVc;
  private int mVd;
  private int mVe;
  private int mVf;
  private com.tencent.mm.plugin.appbrand.widget.header.b mVg;
  private boolean mVh;
  private Runnable mVi;
  private boolean mVj;
  private boolean mVk;
  private boolean mVl;
  private Runnable mVm;
  private boolean mVn;
  private PointF mVo;
  private PointF mVp;
  private boolean mVq;
  private boolean mVr;
  private Runnable mVs;
  private boolean mVt;
  private GyroView mVu;
  private View mVv;
  private boolean mVw;
  private boolean mVx;
  private boolean mVy;
  
  public a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(49398);
    this.mUs = 0.2F;
    this.mUt = 0.05F;
    this.mUu = 0;
    this.mUv = 0;
    this.mUC = true;
    this.mUD = false;
    this.mUE = false;
    this.mUG = true;
    this.mUH = 0;
    this.mUI = 0;
    this.mUJ = 0;
    this.mUK = null;
    this.mUL = null;
    this.mUM = null;
    this.mUN = null;
    this.mUO = false;
    this.mUP = false;
    this.mUQ = true;
    this.mUR = false;
    this.mUS = false;
    this.mUT = 0;
    this.mUU = false;
    this.mUV = true;
    this.mUW = true;
    this.mUX = false;
    this.mUY = false;
    this.mUZ = -2;
    this.mVa = 0;
    this.mVb = 0;
    this.mVc = 0;
    this.mVd = 0;
    this.mVe = 0;
    this.mVf = 0;
    this.mVh = false;
    this.mVj = true;
    this.mVk = false;
    this.mVl = false;
    this.mVo = new PointF();
    this.mVp = new PointF();
    this.mVq = false;
    this.mVr = false;
    this.mVs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49392);
        a.j(a.this);
        AppMethodBeat.o(49392);
      }
    };
    this.mVt = true;
    this.mVw = true;
    this.mVx = false;
    this.mVy = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.mUr = paramHeaderContainer;
    this.mUw = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.mUx = ar.dT(this.mContext);
    boolean bool = paramListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49385);
        a.a(a.this, ar.dT(a.a(a.this)));
        ad.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:" + a.b(a.this));
        AppMethodBeat.o(49385);
      }
    });
    this.mUW = b.adI();
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.mUW), Integer.valueOf(this.mUx), Boolean.valueOf(bool) });
    bCD();
    bCE();
    bCs();
    this.mVg = new com.tencent.mm.plugin.appbrand.widget.header.b(this.mContext.getResources().getColor(2131099732), this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(49398);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49425);
    ad.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(paramFloat, paramInt1);
    if (this.mUy != null) {
      this.mUy.a(paramFloat, paramInt1, paramInt2);
    }
    if (this.mUr != null) {
      this.mUr.wa(paramInt1);
    }
    AppMethodBeat.o(49425);
  }
  
  private void aM(float paramFloat)
  {
    AppMethodBeat.i(49426);
    ad.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.mVg.aO(1.0F - paramFloat);
    if (this.mUy != null) {
      this.mUy.b(paramFloat, i, i);
    }
    if (this.mUr != null) {
      this.mUr.et(i, i);
    }
    AppMethodBeat.o(49426);
  }
  
  private boolean bCB()
  {
    AppMethodBeat.i(49419);
    if ((Math.abs(this.mVp.y - this.mVo.y) <= 5.0F) || (this.mVp.y <= this.mVo.y))
    {
      AppMethodBeat.o(49419);
      return true;
    }
    AppMethodBeat.o(49419);
    return false;
  }
  
  private int bCC()
  {
    AppMethodBeat.i(49420);
    if (this.mUu == 0) {
      this.mUu = ((int)(this.mUr.getHeight() * this.mUs));
    }
    int i = this.mUu;
    AppMethodBeat.o(49420);
    return i;
  }
  
  private void bCD()
  {
    this.mVy = true;
    this.mVw = true;
  }
  
  private void bCE()
  {
    AppMethodBeat.i(49421);
    if (this.mVu != null)
    {
      this.mVu.b(0.0F, bCC());
      this.mVu.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49421);
  }
  
  private void bCF()
  {
    AppMethodBeat.i(49422);
    boolean bool2 = this.mUW;
    if ((b.adI()) && (this.mUz != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mUW = bool1;
      bCG();
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.mUW), Boolean.valueOf(bool2) });
      if ((!this.mUQ) || (!bCA())) {
        break;
      }
      AppMethodBeat.o(49422);
      return;
    }
    if (bool2) {
      if ((this.mUz != null) && (!this.mUC))
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView onPause and set GONE");
        this.mUz.onPause();
        this.mUC = true;
        this.mUD = true;
        this.mUz.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.mUF != null)
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView GradientColorView set GONE");
        this.mUF.setVisibility(8);
      }
      AppMethodBeat.o(49422);
      return;
      if (this.mUz != null)
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView set GONE");
        this.mUz.setVisibility(8);
      }
    }
  }
  
  private void bCG()
  {
    AppMethodBeat.i(49424);
    if ((this.mUF instanceof GradientColorBackgroundView)) {
      ((GradientColorBackgroundView)this.mUF).setUpdateMode(1);
    }
    AppMethodBeat.o(49424);
  }
  
  private void bCs()
  {
    AppMethodBeat.i(49399);
    try
    {
      this.mUH = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.mUI = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 16);
      if (this.mUH < this.mUI) {
        this.mUI = 0;
      }
      this.mUJ = this.mUH;
      this.mVc = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 100);
      this.mVf = this.mContext.getResources().getColor(2131099648);
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.mUH), Integer.valueOf(this.mUJ), Integer.valueOf(this.mVc) });
      AppMethodBeat.o(49399);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(49399);
    }
  }
  
  private int bCu()
  {
    AppMethodBeat.i(49403);
    if (this.mUr.getMeasuredHeight() == 0)
    {
      AppMethodBeat.o(49403);
      return 0;
    }
    int i = this.mUr.getBottom();
    int j = this.mUx;
    AppMethodBeat.o(49403);
    return i - j;
  }
  
  private boolean bCv()
  {
    AppMethodBeat.i(49404);
    if ((this.mUr != null) && (this.mUr.getBottom() <= 0))
    {
      AppMethodBeat.o(49404);
      return false;
    }
    int i = bCu() - 60;
    if (!bCB())
    {
      if (i > bCC())
      {
        AppMethodBeat.o(49404);
        return true;
      }
      AppMethodBeat.o(49404);
      return false;
    }
    if (this.mUv == 0) {
      this.mUv = ((int)(this.mUr.getHeight() * this.mUt));
    }
    if (i < this.mUv)
    {
      AppMethodBeat.o(49404);
      return true;
    }
    AppMethodBeat.o(49404);
    return false;
  }
  
  private void bCw()
  {
    AppMethodBeat.i(49411);
    this.mVh = true;
    if (this.mVi != null) {
      this.mListView.removeCallbacks(this.mVi);
    }
    ListView localListView = this.mListView;
    Runnable local9 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49394);
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIgnoreInLayout false");
        a.l(a.this);
        AppMethodBeat.o(49394);
      }
    };
    this.mVi = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(49411);
  }
  
  private void bCy()
  {
    AppMethodBeat.i(49414);
    if (this.mUK != null) {
      aq.aA(this.mUK);
    }
    if (this.mUQ)
    {
      Runnable local11 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49397);
          ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayHideBackgroundView");
          a.m(a.this);
          AppMethodBeat.o(49397);
        }
      };
      this.mUK = local11;
      aq.o(local11, 500L);
      AppMethodBeat.o(49414);
      return;
    }
    bCF();
    AppMethodBeat.o(49414);
  }
  
  private void vY(int paramInt)
  {
    AppMethodBeat.i(49408);
    ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.mGU != null) {
      this.mGU.getVisibility();
    }
    AppMethodBeat.o(49408);
  }
  
  public final void K(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49406);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.mVm);
    this.mListView.removeCallbacks(this.mUL);
    this.mVo.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.mVl = false;
    this.mVh = false;
    this.mVq = true;
    AppMethodBeat.o(49406);
  }
  
  public final void b(long paramLong, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(49402);
    super.b(paramLong, paramInt, paramBoolean);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.mUL != null) {
      this.mListView.removeCallbacks(this.mUL);
    }
    ListView localListView = this.mListView;
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49391);
        a.a(a.this, paramBoolean);
        a.this.vX(paramInt);
        AppMethodBeat.o(49391);
      }
    };
    this.mUL = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(49402);
  }
  
  public final boolean bCA()
  {
    AppMethodBeat.i(49418);
    if ((this.mUr.getBottom() >= this.mUx + 10) && (this.mListView.getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(49418);
      return true;
    }
    AppMethodBeat.o(49418);
    return false;
  }
  
  public final void bCt()
  {
    AppMethodBeat.i(49400);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(bCA()), Boolean.valueOf(this.mUX) });
    if (!bCA())
    {
      AppMethodBeat.o(49400);
      return;
    }
    if ((this.mVw) && (this.mVx)) {
      bd.jc(this.mContext);
    }
    this.mVk = true;
    this.mUS = false;
    vY(8);
    this.mListView.removeCallbacks(this.mVm);
    Object localObject = this.mListView;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49389);
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
        int i = a.c(a.this).getTop();
        a.d(a.this).smoothScrollBy(i, 600);
        a.e(a.this);
        AppMethodBeat.o(49389);
      }
    };
    this.mVm = local4;
    ((ListView)localObject).post(local4);
    if (!this.mUW)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(49400);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.mZg;
    if (!com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bDk())
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(49400);
      return;
    }
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.mUO), Boolean.valueOf(this.mUP) });
    if ((!this.mUO) && (!this.mUP))
    {
      this.mUO = true;
      if (this.mUM != null) {
        this.mUM.cancel();
      }
      this.mUM = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "MicroMsg.AppBrandDesktopAnimController#startMonitorRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(49386);
          d locald;
          if (!com.tencent.mm.plugin.appbrand.widget.desktop.c.c.naO.guO)
          {
            ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
            ??? = com.tencent.mm.plugin.appbrand.widget.desktop.c.c.naO;
            if (!((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).guO)
            {
              ((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).guO = true;
              ad.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bt.flS() });
              ((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).ahe().postFrameCallback((Choreographer.FrameCallback)???);
            }
            locald = d.naR;
          }
          synchronized (locald.guV)
          {
            if (locald.isRunning)
            {
              ad.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
              a.n(a.this);
              AppMethodBeat.o(49386);
              return;
            }
            if (locald.mTimer != null) {
              locald.mTimer.cancel();
            }
            System.gc();
            locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
            locald.guT.clear();
            locald.guT.put(Integer.valueOf(1), new com.tencent.mm.plugin.appbrand.widget.desktop.c.a());
            locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
            locald.isRunning = true;
          }
        }
      };
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
      h.LTJ.f(this.mUM, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(49400);
  }
  
  public final void bCx()
  {
    AppMethodBeat.i(49412);
    if (this.azo != null)
    {
      this.mUS = true;
      this.azo.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49412);
  }
  
  public final boolean bCz()
  {
    AppMethodBeat.i(49417);
    if ((bCA()) && (this.mUX))
    {
      AppMethodBeat.o(49417);
      return true;
    }
    AppMethodBeat.o(49417);
    return false;
  }
  
  public final void g(View paramView1, View paramView2)
  {
    AppMethodBeat.i(49423);
    if ((paramView1 instanceof DynamicBackgroundGLSurfaceView)) {
      this.mUz = ((DynamicBackgroundGLSurfaceView)paramView1);
    }
    if (this.mUz == null) {
      this.mUW = false;
    }
    this.mUF = paramView2;
    if ((this.mUz != null) && ((this.mUF instanceof GradientColorBackgroundView)))
    {
      this.mUz.setGradientBackgroundView((GradientColorBackgroundView)this.mUF);
      bCG();
    }
    AppMethodBeat.o(49423);
  }
  
  public final int getAnimationScrollOffset()
  {
    return this.mVe;
  }
  
  public final void hY(boolean paramBoolean)
  {
    AppMethodBeat.i(49410);
    super.hY(paramBoolean);
    this.mUX = true;
    if ((this.mUF != null) && (this.mUF.getVisibility() == 0)) {
      this.mUF.invalidate();
    }
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.mUS), Boolean.valueOf(this.mUW) });
    if (this.azo == null)
    {
      AppMethodBeat.o(49410);
      return;
    }
    if (this.mUS)
    {
      bCx();
      AppMethodBeat.o(49410);
      return;
    }
    if (!bCA())
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
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
    bCw();
    AppMethodBeat.o(49410);
  }
  
  public final void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(49413);
    super.hZ(paramBoolean);
    this.mUX = false;
    bCE();
    bCy();
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
      bCw();
      AppMethodBeat.o(49413);
      return;
    }
  }
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(49416);
    if ((this.mUr.isFullScreen()) && (paramBoolean != this.mVt))
    {
      if (bu.flY()) {
        ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mVt) });
      }
      this.mVt = paramBoolean;
      dm localdm = new dm();
      localdm.dom.enable = paramBoolean;
      com.tencent.mm.sdk.b.a.IbL.l(localdm);
    }
    AppMethodBeat.o(49416);
  }
  
  public final void iv()
  {
    AppMethodBeat.i(49415);
    bCs();
    this.mUV = false;
    AppMethodBeat.o(49415);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49429);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
    if (this.mListView != null)
    {
      if (this.mUL != null)
      {
        this.mListView.removeCallbacks(this.mUL);
        this.mUL = null;
      }
      if (this.mUK != null)
      {
        this.mListView.removeCallbacks(this.mUK);
        this.mUK = null;
      }
      if (this.mVi != null)
      {
        this.mListView.removeCallbacks(this.mVi);
        this.mVi = null;
      }
    }
    h.LTJ.aZz("AppBrandDesktopPerformanceMonitor");
    d.naR.ahg();
    d.naR.release();
    this.mUO = false;
    if (this.mUz != null)
    {
      DynamicBackgroundGLSurfaceView.b localb = this.mUz.gfM;
      if (localb != null) {
        try
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
          DynamicBackgroundNative localDynamicBackgroundNative = localb.gfQ;
          if (localDynamicBackgroundNative != null) {
            localDynamicBackgroundNative.nativeRelease();
          }
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
          localb.gfT = 0;
          localb.gfU = 0;
          localb.ggc = false;
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
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, isCurrentMainUI: %b", new Object[] { Boolean.valueOf(bCA()), Integer.valueOf(this.mUr.getBottom()), Integer.valueOf(this.mUr.getHeight()), Boolean.valueOf(this.mVj) });
    if ((bCA()) && (this.mUr.getBottom() < this.mUr.getHeight()))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume fastCloseHeader");
      b(0L, 0, true);
    }
    if (!this.mUX)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume enableBottomTabSwitch true");
      ia(true);
      AppMethodBeat.o(49428);
      return;
    }
    if (!this.mVj)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume not main ui and header open, then close header");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49428);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49409);
    if ((!this.mVh) && (paramAbsListView.isInLayout()) && (!this.mUS) && (this.mUr.getBottom() < this.mUr.getHeight()) && (this.mUX))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
      vX(0);
      AppMethodBeat.o(49409);
      return;
    }
    if ((this.mVl) && (!this.mVk) && (this.mVn) && (paramInt1 <= 0) && (bCA()))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      vX(4);
    }
    if ((this.mUr != null) && (this.mUr.getHeight() != this.mVd))
    {
      this.mVe = ((int)(this.mUr.getHeight() * this.mUs) + 60);
      this.mVa = ((int)(this.mUr.getHeight() * this.mUs) + 60);
      this.mVb = (this.mUr.getHeight() - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 50));
      this.mUu = ((int)(this.mUr.getHeight() * this.mUs));
      this.mUv = ((int)(this.mUr.getHeight() * this.mUt));
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, listBgStartAlphaOffset: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.mUr.getHeight()), Integer.valueOf(this.mVd), Integer.valueOf(this.mVe), Integer.valueOf(this.mVa), Integer.valueOf(this.mVb), Integer.valueOf(this.mUu), Integer.valueOf(this.mUv) });
      this.mVd = this.mUr.getHeight();
    }
    ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.mVn), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.mVl), Integer.valueOf(this.mVa) });
    label861:
    int i;
    float f1;
    int j;
    label1137:
    Object localObject;
    if ((!this.mVl) && (paramInt1 == 0) && (this.mUr != null))
    {
      ad.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(this.mUr.getBottom()), Integer.valueOf(this.mUx), Integer.valueOf(this.mUr.getHeight()), Integer.valueOf(this.mUr.getBottom()), Boolean.valueOf(this.mUE) });
      if ((this.mUz != null) || (this.mUF != null))
      {
        if (!this.mUW) {
          break label1294;
        }
        if ((bCA()) && (this.mUC) && (this.mUE))
        {
          this.mUC = false;
          if (this.mUz != null)
          {
            this.mUz.setVisibility(0);
            this.mUz.setShowGradientView(false);
          }
          if ((this.mUD) && (this.mUz != null))
          {
            ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
            this.mUz.onResume();
            this.mUD = false;
          }
        }
      }
      if (this.mUV) {
        break label1382;
      }
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (g.abl())) && (Build.VERSION.SDK_INT >= 21) && (!bCz()))
      {
        if ((this.mUr != null) && (this.mUr.getBottom() <= this.mUx + 20))
        {
          if (this.mUF != null) {
            this.mUF.setVisibility(8);
          }
          if (this.mUz != null)
          {
            this.mUz.onPause();
            this.mUC = true;
            this.mUD = true;
            this.mUz.setVisibility(8);
          }
        }
        if ((this.mListView.getFirstVisiblePosition() > 0) || ((this.mListView.getFirstVisiblePosition() == 0) && (!bCA())))
        {
          this.mListView.setBackgroundColor(this.mListView.getResources().getColor(2131101053));
          if (this.mUB != null) {
            this.mUB.setBackgroundColor(this.mContext.getResources().getColor(2131101053));
          }
          if (this.mUF != null) {
            this.mUF.setVisibility(4);
          }
        }
      }
      if (bCA()) {
        break label1740;
      }
      this.mVl = true;
      if ((bCv()) || (!this.mUY)) {
        break label1717;
      }
      z(false, true);
      if (this.mVu == null) {
        this.mVu = ((GyroView)this.mUr.findViewById(2131300673));
      }
      if (this.mVv == null) {
        this.mVv = this.mUr.findViewById(2131296708);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = bCC();
        paramInt2 = this.mUr.getBottom();
        paramInt3 = bCu();
        i = this.mVb - this.mVa;
        f1 = 1.0F * (paramInt3 - this.mVa) / i;
        this.mVv.setAlpha(f1);
        j = paramInt3 - 60;
        ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.mVa), Integer.valueOf(this.mVb), Boolean.valueOf(this.mVn), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mUr.getHeight()), Integer.valueOf(this.mVu.getHeight()) });
        if (((!this.mVn) && (paramInt2 >= 5)) || (this.mUR))
        {
          if (paramInt1 < j) {
            break label1748;
          }
          this.mVu.b(j, paramInt1);
          this.mVu.setAlpha(1.0F);
        }
        f1 = 1.0F * (j - paramInt1) / this.mVc;
        localObject = this.mVu;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.mVu.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.mVy) && (bCA()) && (!paramAbsListView.isInLayout()))
        {
          this.mUw.vibrate(10L);
          this.mVy = false;
        }
        if (paramInt2 < this.mUx + 10) {
          bCD();
        }
      }
      this.mVr = bCA();
      if ((!bCA()) || (!this.mVq)) {
        break label1761;
      }
      ia(false);
    }
    for (;;)
    {
      aq.aA(this.mVs);
      aq.o(this.mVs, 60L);
      AppMethodBeat.o(49409);
      return;
      label1294:
      this.mUC = true;
      this.mUD = true;
      if (this.mUz != null)
      {
        this.mUz.setVisibility(8);
        this.mUz.onPause();
      }
      if ((!bCA()) || (this.mUF == null) || ((this.mUF.getVisibility() == 0) && (this.mUF.getAlpha() == 1.0F))) {
        break;
      }
      this.mUF.setAlpha(1.0F);
      this.mUF.setVisibility(0);
      break;
      label1382:
      paramInt3 = bCu();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.mVe) / (this.mUr.getMeasuredHeight() - this.mUx - this.mVe)));
      i = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(f1, this.mContext.getResources().getColor(2131099648));
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(i);
      }
      if (this.mUB != null) {
        this.mUB.setBackgroundColor(i);
      }
      i = this.mUr.getHeight() - this.mUx - this.mUH;
      j = bCu() - i;
      float f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.mUH - this.mUI)));
      ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
      if ((paramInt3 < this.mVe) || (paramInt3 < this.mVa))
      {
        vY(0);
        a(1.0F, this.mVf, paramInt3);
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
          vY(8);
          a(f2, this.mContext.getResources().getColor(2131099930), paramInt3);
          aM(1.0F - f2);
        }
      }
      label1717:
      if ((!this.mVr) || (!this.mUY)) {
        break label861;
      }
      z(false, true);
      break label861;
      label1740:
      this.mVl = false;
      break label861;
      label1748:
      this.mVu.b(paramInt1, paramInt1);
      break label1137;
      label1761:
      if (!this.mUX) {
        ia(true);
      } else if (this.mUX) {
        ia(false);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(49407);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bCB()) });
    this.mUE = true;
    int i = this.mUZ;
    this.mUZ = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.mUY = false;
      if ((this.mVk) && (paramInt == 0))
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
        this.mVk = false;
        if (i == -1)
        {
          ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged checkOpen: %b", new Object[] { Boolean.valueOf(bCv()) });
          if ((this.mUr.getBottom() < 200) || (this.mListView.getFirstVisiblePosition() != 0) || (this.mUX)) {
            break label188;
          }
        }
        label188:
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt != 0) && (bCv()))
          {
            ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged header is visible but not open");
            this.mUS = false;
            z(true, false);
          }
          AppMethodBeat.o(49407);
          return;
        }
      }
      if (bCv())
      {
        bCt();
        AppMethodBeat.o(49407);
        return;
      }
      if ((bCB()) && (paramInt == -1))
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
        vX(4);
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == -1)
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        vX(0);
        this.mUR = true;
        AppMethodBeat.o(49407);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.mVn = true;
        this.mUY = true;
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == 1)
      {
        this.mVn = false;
        this.mUV = true;
        this.mUY = true;
        if (bCB())
        {
          this.mVn = false;
          this.mUT = 4;
        }
      }
    }
    AppMethodBeat.o(49407);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49405);
    if (paramMotionEvent.getAction() == 0) {
      K(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(49405);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.mVq = false;
        this.mVp.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.mUr != null) && (this.mUr.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (bCB()))
        {
          if (this.mUT == 0) {
            this.mUT = 12;
          }
          ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.mUT) });
        }
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void setActionBar(View paramView)
  {
    this.mGU = paramView;
  }
  
  public final void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.mUy = parama;
  }
  
  public final void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(49427);
    this.mVj = paramBoolean;
    if ((!paramBoolean) && (this.mUX))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIsCurrentMainUI and header open, close");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49427);
  }
  
  public final void setStatusBarMaskView(View paramView)
  {
    this.mUB = paramView;
  }
  
  public final void setTabView(View paramView)
  {
    this.azo = paramView;
  }
  
  public final void vX(final int paramInt)
  {
    AppMethodBeat.i(49401);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(bCA()), Integer.valueOf(paramInt) });
    this.mUS = true;
    this.mVq = false;
    vY(0);
    if (!bCA())
    {
      hZ(false);
      AppMethodBeat.o(49401);
      return;
    }
    this.mVk = true;
    this.mListView.removeCallbacks(this.mVm);
    ListView localListView = this.mListView;
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49390);
        int j = a.c(a.this).getBottom() - a.b(a.this);
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(a.c(a.this).getBottom()) });
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
    this.mVm = local5;
    localListView.post(local5);
    AppMethodBeat.o(49401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */