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
import com.tencent.mm.g.a.dj;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d.1;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.Timer;

public final class a
  extends com.tencent.mm.plugin.appbrand.widget.header.c
{
  private View axx;
  private Context mContext;
  private ListView mListView;
  private View mgu;
  private HeaderContainer mtL;
  private float mtM;
  private float mtN;
  private int mtO;
  private int mtP;
  private Vibrator mtQ;
  private int mtR;
  private com.tencent.mm.plugin.appbrand.widget.header.a mtS;
  private DynamicBackgroundGLSurfaceView mtT;
  private View mtU;
  private boolean mtV;
  private boolean mtW;
  private boolean mtX;
  private View mtY;
  private boolean mtZ;
  private boolean muA;
  private Runnable muB;
  private boolean muC;
  private boolean muD;
  private boolean muE;
  private Runnable muF;
  private boolean muG;
  private PointF muH;
  private PointF muI;
  private boolean muJ;
  private boolean muK;
  private Runnable muL;
  private boolean muM;
  private GyroView muN;
  private View muO;
  private boolean muP;
  private boolean muQ;
  private boolean muR;
  private int mua;
  private int mub;
  private int muc;
  private Runnable mud;
  private Runnable mue;
  private com.tencent.e.i.b muf;
  private com.tencent.e.i.b mug;
  private boolean muh;
  private boolean mui;
  private boolean muj;
  private boolean muk;
  private boolean mul;
  private int mum;
  private boolean mun;
  private boolean muo;
  private boolean mup;
  private boolean muq;
  private boolean mur;
  private int mus;
  private int mut;
  private int muu;
  private int muv;
  private int muw;
  private int mux;
  private int muy;
  private com.tencent.mm.plugin.appbrand.widget.header.b muz;
  
  public a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(49398);
    this.mtM = 0.2F;
    this.mtN = 0.05F;
    this.mtO = 0;
    this.mtP = 0;
    this.mtV = true;
    this.mtW = false;
    this.mtX = false;
    this.mtZ = true;
    this.mua = 0;
    this.mub = 0;
    this.muc = 0;
    this.mud = null;
    this.mue = null;
    this.muf = null;
    this.mug = null;
    this.muh = false;
    this.mui = false;
    this.muj = true;
    this.muk = false;
    this.mul = false;
    this.mum = 0;
    this.mun = false;
    this.muo = true;
    this.mup = true;
    this.muq = false;
    this.mur = false;
    this.mus = -2;
    this.mut = 0;
    this.muu = 0;
    this.muv = 0;
    this.muw = 0;
    this.mux = 0;
    this.muy = 0;
    this.muA = false;
    this.muC = true;
    this.muD = false;
    this.muE = false;
    this.muH = new PointF();
    this.muI = new PointF();
    this.muJ = false;
    this.muK = false;
    this.muL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49392);
        a.j(a.this);
        AppMethodBeat.o(49392);
      }
    };
    this.muM = true;
    this.muP = true;
    this.muQ = false;
    this.muR = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.mtL = paramHeaderContainer;
    this.mtQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.mtR = com.tencent.mm.ui.ap.dT(this.mContext);
    boolean bool = paramListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49385);
        a.a(a.this, com.tencent.mm.ui.ap.dT(a.a(a.this)));
        ac.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:" + a.b(a.this));
        AppMethodBeat.o(49385);
      }
    });
    this.mup = b.abe();
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.mup), Integer.valueOf(this.mtR), Boolean.valueOf(bool) });
    byy();
    byz();
    byn();
    this.muz = new com.tencent.mm.plugin.appbrand.widget.header.b(ao.aJ(this.mContext, 2130968584), ao.aJ(this.mContext, 2130968585));
    AppMethodBeat.o(49398);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49425);
    ac.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(paramFloat, paramInt1);
    if (this.mtS != null) {
      this.mtS.a(paramFloat, paramInt1, paramInt2);
    }
    if (this.mtL != null) {
      this.mtL.vu(paramInt1);
    }
    AppMethodBeat.o(49425);
  }
  
  private void aJ(float paramFloat)
  {
    AppMethodBeat.i(49426);
    ac.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.muz.aL(1.0F - paramFloat);
    if (this.mtS != null) {
      this.mtS.b(paramFloat, i, i);
    }
    if (this.mtL != null) {
      this.mtL.er(i, i);
    }
    AppMethodBeat.o(49426);
  }
  
  private void byA()
  {
    AppMethodBeat.i(49422);
    boolean bool2 = this.mup;
    if ((b.abe()) && (this.mtT != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mup = bool1;
      byB();
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.mup), Boolean.valueOf(bool2) });
      if ((!this.muj) || (!byv())) {
        break;
      }
      AppMethodBeat.o(49422);
      return;
    }
    if (bool2) {
      if ((this.mtT != null) && (!this.mtV))
      {
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView onPause and set GONE");
        this.mtT.onPause();
        this.mtV = true;
        this.mtW = true;
        this.mtT.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.mtY != null)
      {
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView GradientColorView set GONE");
        this.mtY.setVisibility(8);
      }
      AppMethodBeat.o(49422);
      return;
      if (this.mtT != null)
      {
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView set GONE");
        this.mtT.setVisibility(8);
      }
    }
  }
  
  private void byB()
  {
    AppMethodBeat.i(49424);
    if ((this.mtY instanceof GradientColorBackgroundView)) {
      ((GradientColorBackgroundView)this.mtY).setUpdateMode(1);
    }
    AppMethodBeat.o(49424);
  }
  
  private void byn()
  {
    AppMethodBeat.i(49399);
    try
    {
      this.mua = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.mub = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 16);
      if (this.mua < this.mub) {
        this.mub = 0;
      }
      this.muc = this.mua;
      this.muv = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 100);
      this.muy = ao.aJ(this.mContext, 2130968577);
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.mua), Integer.valueOf(this.muc), Integer.valueOf(this.muv) });
      AppMethodBeat.o(49399);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(49399);
    }
  }
  
  private int byp()
  {
    AppMethodBeat.i(49403);
    if (this.mtL.getMeasuredHeight() == 0)
    {
      AppMethodBeat.o(49403);
      return 0;
    }
    int i = this.mtL.getBottom();
    int j = this.mtR;
    AppMethodBeat.o(49403);
    return i - j;
  }
  
  private boolean byq()
  {
    AppMethodBeat.i(49404);
    if ((this.mtL != null) && (this.mtL.getBottom() <= 0))
    {
      AppMethodBeat.o(49404);
      return false;
    }
    int i = byp() - 60;
    if (!byw())
    {
      if (i > byx())
      {
        AppMethodBeat.o(49404);
        return true;
      }
      AppMethodBeat.o(49404);
      return false;
    }
    if (this.mtP == 0) {
      this.mtP = ((int)(this.mtL.getHeight() * this.mtN));
    }
    if (i < this.mtP)
    {
      AppMethodBeat.o(49404);
      return true;
    }
    AppMethodBeat.o(49404);
    return false;
  }
  
  private void byr()
  {
    AppMethodBeat.i(49411);
    this.muA = true;
    if (this.muB != null) {
      this.mListView.removeCallbacks(this.muB);
    }
    ListView localListView = this.mListView;
    Runnable local9 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49394);
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIgnoreInLayout false");
        a.l(a.this);
        AppMethodBeat.o(49394);
      }
    };
    this.muB = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(49411);
  }
  
  private void byt()
  {
    AppMethodBeat.i(49414);
    if (this.mud != null) {
      com.tencent.mm.sdk.platformtools.ap.aB(this.mud);
    }
    if (this.muj)
    {
      Runnable local11 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49397);
          ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayHideBackgroundView");
          a.m(a.this);
          AppMethodBeat.o(49397);
        }
      };
      this.mud = local11;
      com.tencent.mm.sdk.platformtools.ap.n(local11, 500L);
      AppMethodBeat.o(49414);
      return;
    }
    byA();
    AppMethodBeat.o(49414);
  }
  
  private boolean byw()
  {
    AppMethodBeat.i(49419);
    if ((Math.abs(this.muI.y - this.muH.y) <= 5.0F) || (this.muI.y <= this.muH.y))
    {
      AppMethodBeat.o(49419);
      return true;
    }
    AppMethodBeat.o(49419);
    return false;
  }
  
  private int byx()
  {
    AppMethodBeat.i(49420);
    if (this.mtO == 0) {
      this.mtO = ((int)(this.mtL.getHeight() * this.mtM));
    }
    int i = this.mtO;
    AppMethodBeat.o(49420);
    return i;
  }
  
  private void byy()
  {
    this.muR = true;
    this.muP = true;
  }
  
  private void byz()
  {
    AppMethodBeat.i(49421);
    if (this.muN != null)
    {
      this.muN.b(0.0F, byx());
      this.muN.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49421);
  }
  
  private void vs(int paramInt)
  {
    AppMethodBeat.i(49408);
    ac.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.mgu != null) {
      this.mgu.getVisibility();
    }
    AppMethodBeat.o(49408);
  }
  
  public final void M(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49406);
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.muF);
    this.mListView.removeCallbacks(this.mue);
    this.muH.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.muE = false;
    this.muA = false;
    this.muJ = true;
    AppMethodBeat.o(49406);
  }
  
  public final void b(long paramLong, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(49402);
    super.b(paramLong, paramInt, paramBoolean);
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.mue != null) {
      this.mListView.removeCallbacks(this.mue);
    }
    ListView localListView = this.mListView;
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49391);
        a.a(a.this, paramBoolean);
        a.this.vr(paramInt);
        AppMethodBeat.o(49391);
      }
    };
    this.mue = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(49402);
  }
  
  public final void byo()
  {
    AppMethodBeat.i(49400);
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(byv()), Boolean.valueOf(this.muq) });
    if (!byv())
    {
      AppMethodBeat.o(49400);
      return;
    }
    if ((this.muP) && (this.muQ)) {
      bc.iS(this.mContext);
    }
    this.muD = true;
    this.mul = false;
    vs(8);
    this.mListView.removeCallbacks(this.muF);
    Object localObject = this.mListView;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49389);
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
        int i = a.c(a.this).getTop();
        a.d(a.this).smoothScrollBy(i, 600);
        a.e(a.this);
        AppMethodBeat.o(49389);
      }
    };
    this.muF = local4;
    ((ListView)localObject).post(local4);
    if (!this.mup)
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(49400);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.myy;
    if (!com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bzg())
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(49400);
      return;
    }
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.muh), Boolean.valueOf(this.mui) });
    if ((!this.muh) && (!this.mui))
    {
      this.muh = true;
      if (this.muf != null) {
        this.muf.cancel();
      }
      this.muf = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "MicroMsg.AppBrandDesktopAnimController#startMonitorRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(49386);
          d locald;
          if (!com.tencent.mm.plugin.appbrand.widget.desktop.c.c.mAg.gbe)
          {
            ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
            ??? = com.tencent.mm.plugin.appbrand.widget.desktop.c.c.mAg;
            if (!((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).gbe)
            {
              ((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).gbe = true;
              ac.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bs.eWi() });
              ((com.tencent.mm.plugin.appbrand.widget.desktop.c.c)???).aes().postFrameCallback((Choreographer.FrameCallback)???);
            }
            locald = d.mAj;
          }
          synchronized (locald.gbl)
          {
            if (locald.isRunning)
            {
              ac.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
              a.n(a.this);
              AppMethodBeat.o(49386);
              return;
            }
            if (locald.mTimer != null) {
              locald.mTimer.cancel();
            }
            System.gc();
            locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
            locald.gbj.clear();
            locald.gbj.put(Integer.valueOf(1), new com.tencent.mm.plugin.appbrand.widget.desktop.c.a());
            locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
            locald.isRunning = true;
          }
        }
      };
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
      h.JZN.f(this.muf, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(49400);
  }
  
  public final void bys()
  {
    AppMethodBeat.i(49412);
    if (this.axx != null)
    {
      this.mul = true;
      this.axx.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49412);
  }
  
  public final boolean byu()
  {
    AppMethodBeat.i(49417);
    if ((byv()) && (this.muq))
    {
      AppMethodBeat.o(49417);
      return true;
    }
    AppMethodBeat.o(49417);
    return false;
  }
  
  public final boolean byv()
  {
    AppMethodBeat.i(49418);
    if ((this.mtL.getBottom() >= this.mtR + 10) && (this.mListView.getFirstVisiblePosition() == 0))
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
      this.mtT = ((DynamicBackgroundGLSurfaceView)paramView1);
    }
    if (this.mtT == null) {
      this.mup = false;
    }
    this.mtY = paramView2;
    if ((this.mtT != null) && ((this.mtY instanceof GradientColorBackgroundView)))
    {
      this.mtT.setGradientBackgroundView((GradientColorBackgroundView)this.mtY);
      byB();
    }
    AppMethodBeat.o(49423);
  }
  
  public final int getAnimationScrollOffset()
  {
    return this.mux;
  }
  
  public final void hO(boolean paramBoolean)
  {
    AppMethodBeat.i(49410);
    super.hO(paramBoolean);
    this.muq = true;
    if ((this.mtY != null) && (this.mtY.getVisibility() == 0)) {
      this.mtY.invalidate();
    }
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.mul), Boolean.valueOf(this.mup) });
    if (this.axx == null)
    {
      AppMethodBeat.o(49410);
      return;
    }
    if (this.mul)
    {
      bys();
      AppMethodBeat.o(49410);
      return;
    }
    if (!byv())
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
      this.axx.setTranslationY(0.0F);
      AppMethodBeat.o(49410);
      return;
    }
    this.axx.animate().translationY(this.axx.getHeight()).setDuration(260L).setListener(new Animator.AnimatorListener()
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
    byr();
    AppMethodBeat.o(49410);
  }
  
  public final void hP(boolean paramBoolean)
  {
    AppMethodBeat.i(49413);
    super.hP(paramBoolean);
    this.muq = false;
    byz();
    byt();
    if (this.axx == null)
    {
      AppMethodBeat.o(49413);
      return;
    }
    this.axx.setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.axx.animate().translationY(0.0F);
    if (this.axx.getTranslationY() == 0.0F) {}
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
      byr();
      AppMethodBeat.o(49413);
      return;
    }
  }
  
  public final void hQ(boolean paramBoolean)
  {
    AppMethodBeat.i(49416);
    if ((this.mtL.isFullScreen()) && (paramBoolean != this.muM))
    {
      if (bt.eWo()) {
        ac.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.muM) });
      }
      this.muM = paramBoolean;
      dj localdj = new dj();
      localdj.dcQ.enable = paramBoolean;
      com.tencent.mm.sdk.b.a.GpY.l(localdj);
    }
    AppMethodBeat.o(49416);
  }
  
  public final void ie()
  {
    AppMethodBeat.i(49415);
    byn();
    this.muo = false;
    AppMethodBeat.o(49415);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49429);
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
    if (this.mListView != null)
    {
      if (this.mue != null)
      {
        this.mListView.removeCallbacks(this.mue);
        this.mue = null;
      }
      if (this.mud != null)
      {
        this.mListView.removeCallbacks(this.mud);
        this.mud = null;
      }
      if (this.muB != null)
      {
        this.mListView.removeCallbacks(this.muB);
        this.muB = null;
      }
    }
    h.JZN.aTz("AppBrandDesktopPerformanceMonitor");
    d.mAj.aeu();
    d.mAj.release();
    this.muh = false;
    if (this.mtT != null)
    {
      DynamicBackgroundGLSurfaceView.b localb = this.mtT.fMm;
      if (localb != null) {
        try
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
          DynamicBackgroundNative localDynamicBackgroundNative = localb.fMq;
          if (localDynamicBackgroundNative != null) {
            localDynamicBackgroundNative.nativeRelease();
          }
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
          localb.fMt = 0;
          localb.fMu = 0;
          localb.fMC = false;
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
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, isCurrentMainUI: %b", new Object[] { Boolean.valueOf(byv()), Integer.valueOf(this.mtL.getBottom()), Integer.valueOf(this.mtL.getHeight()), Boolean.valueOf(this.muC) });
    if ((byv()) && (this.mtL.getBottom() < this.mtL.getHeight()))
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume fastCloseHeader");
      b(0L, 0, true);
    }
    if (!this.muq)
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume enableBottomTabSwitch true");
      hQ(true);
      AppMethodBeat.o(49428);
      return;
    }
    if (!this.muC)
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume not main ui and header open, then close header");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49428);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49409);
    if ((!this.muA) && (paramAbsListView.isInLayout()) && (!this.mul) && (this.mtL.getBottom() < this.mtL.getHeight()) && (this.muq))
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
      vr(0);
      AppMethodBeat.o(49409);
      return;
    }
    if ((this.muE) && (!this.muD) && (this.muG) && (paramInt1 <= 0) && (byv()))
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      vr(4);
    }
    if ((this.mtL != null) && (this.mtL.getHeight() != this.muw))
    {
      this.mux = ((int)(this.mtL.getHeight() * this.mtM) + 60);
      this.mut = ((int)(this.mtL.getHeight() * this.mtM) + 60);
      this.muu = (this.mtL.getHeight() - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 50));
      this.mtO = ((int)(this.mtL.getHeight() * this.mtM));
      this.mtP = ((int)(this.mtL.getHeight() * this.mtN));
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, listBgStartAlphaOffset: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.mtL.getHeight()), Integer.valueOf(this.muw), Integer.valueOf(this.mux), Integer.valueOf(this.mut), Integer.valueOf(this.muu), Integer.valueOf(this.mtO), Integer.valueOf(this.mtP) });
      this.muw = this.mtL.getHeight();
    }
    ac.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.muG), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.muE), Integer.valueOf(this.mut) });
    label861:
    int i;
    float f1;
    int j;
    label1137:
    Object localObject;
    if ((!this.muE) && (paramInt1 == 0) && (this.mtL != null))
    {
      ac.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(this.mtL.getBottom()), Integer.valueOf(this.mtR), Integer.valueOf(this.mtL.getHeight()), Integer.valueOf(this.mtL.getBottom()), Boolean.valueOf(this.mtX) });
      if ((this.mtT != null) || (this.mtY != null))
      {
        if (!this.mup) {
          break label1294;
        }
        if ((byv()) && (this.mtV) && (this.mtX))
        {
          this.mtV = false;
          if (this.mtT != null)
          {
            this.mtT.setVisibility(0);
            this.mtT.setShowGradientView(false);
          }
          if ((this.mtW) && (this.mtT != null))
          {
            ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
            this.mtT.onResume();
            this.mtW = false;
          }
        }
      }
      if (this.muo) {
        break label1382;
      }
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (g.YJ())) && (Build.VERSION.SDK_INT >= 21) && (!byu()))
      {
        if ((this.mtL != null) && (this.mtL.getBottom() <= this.mtR + 20))
        {
          if (this.mtY != null) {
            this.mtY.setVisibility(8);
          }
          if (this.mtT != null)
          {
            this.mtT.onPause();
            this.mtV = true;
            this.mtW = true;
            this.mtT.setVisibility(8);
          }
        }
        if ((this.mListView.getFirstVisiblePosition() > 0) || ((this.mListView.getFirstVisiblePosition() == 0) && (!byv())))
        {
          this.mListView.setBackgroundColor(this.mListView.getResources().getColor(2131101053));
          if (this.mtU != null) {
            this.mtU.setBackgroundColor(this.mContext.getResources().getColor(2131101053));
          }
          if (this.mtY != null) {
            this.mtY.setVisibility(4);
          }
        }
      }
      if (byv()) {
        break label1737;
      }
      this.muE = true;
      if ((byq()) || (!this.mur)) {
        break label1714;
      }
      z(false, true);
      if (this.muN == null) {
        this.muN = ((GyroView)this.mtL.findViewById(2131300673));
      }
      if (this.muO == null) {
        this.muO = this.mtL.findViewById(2131296708);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = byx();
        paramInt2 = this.mtL.getBottom();
        paramInt3 = byp();
        i = this.muu - this.mut;
        f1 = 1.0F * (paramInt3 - this.mut) / i;
        this.muO.setAlpha(f1);
        j = paramInt3 - 60;
        ac.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.mut), Integer.valueOf(this.muu), Boolean.valueOf(this.muG), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mtL.getHeight()), Integer.valueOf(this.muN.getHeight()) });
        if (((!this.muG) && (paramInt2 >= 5)) || (this.muk))
        {
          if (paramInt1 < j) {
            break label1745;
          }
          this.muN.b(j, paramInt1);
          this.muN.setAlpha(1.0F);
        }
        f1 = 1.0F * (j - paramInt1) / this.muv;
        localObject = this.muN;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.muN.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.muR) && (byv()) && (!paramAbsListView.isInLayout()))
        {
          this.mtQ.vibrate(10L);
          this.muR = false;
        }
        if (paramInt2 < this.mtR + 10) {
          byy();
        }
      }
      this.muK = byv();
      if ((!byv()) || (!this.muJ)) {
        break label1758;
      }
      hQ(false);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ap.aB(this.muL);
      com.tencent.mm.sdk.platformtools.ap.n(this.muL, 60L);
      AppMethodBeat.o(49409);
      return;
      label1294:
      this.mtV = true;
      this.mtW = true;
      if (this.mtT != null)
      {
        this.mtT.setVisibility(8);
        this.mtT.onPause();
      }
      if ((!byv()) || (this.mtY == null) || ((this.mtY.getVisibility() == 0) && (this.mtY.getAlpha() == 1.0F))) {
        break;
      }
      this.mtY.setAlpha(1.0F);
      this.mtY.setVisibility(0);
      break;
      label1382:
      paramInt3 = byp();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.mux) / (this.mtL.getMeasuredHeight() - this.mtR - this.mux)));
      i = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(f1, ao.aJ(this.mContext, 2130968577));
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(i);
      }
      if (this.mtU != null) {
        this.mtU.setBackgroundColor(i);
      }
      i = this.mtL.getHeight() - this.mtR - this.mua;
      j = byp() - i;
      float f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.mua - this.mub)));
      ac.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
      if ((paramInt3 < this.mux) || (paramInt3 < this.mut))
      {
        vs(0);
        a(1.0F, this.muy, paramInt3);
        aJ(1.0F);
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
          vs(8);
          a(f2, this.mContext.getResources().getColor(2131099930), paramInt3);
          aJ(1.0F - f2);
        }
      }
      label1714:
      if ((!this.muK) || (!this.mur)) {
        break label861;
      }
      z(false, true);
      break label861;
      label1737:
      this.muE = false;
      break label861;
      label1745:
      this.muN.b(paramInt1, paramInt1);
      break label1137;
      label1758:
      if (!this.muq) {
        hQ(true);
      } else if (this.muq) {
        hQ(false);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(49407);
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(byw()) });
    this.mtX = true;
    int i = this.mus;
    this.mus = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.mur = false;
      if ((this.muD) && (paramInt == 0))
      {
        ac.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
        this.muD = false;
        if (i == -1)
        {
          ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged checkOpen: %b", new Object[] { Boolean.valueOf(byq()) });
          if ((this.mtL.getBottom() < 200) || (this.mListView.getFirstVisiblePosition() != 0) || (this.muq)) {
            break label188;
          }
        }
        label188:
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt != 0) && (byq()))
          {
            ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged header is visible but not open");
            this.mul = false;
            z(true, false);
          }
          AppMethodBeat.o(49407);
          return;
        }
      }
      if (byq())
      {
        byo();
        AppMethodBeat.o(49407);
        return;
      }
      if ((byw()) && (paramInt == -1))
      {
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
        vr(4);
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == -1)
      {
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        vr(0);
        this.muk = true;
        AppMethodBeat.o(49407);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.muG = true;
        this.mur = true;
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == 1)
      {
        this.muG = false;
        this.muo = true;
        this.mur = true;
        if (byw())
        {
          this.muG = false;
          this.mum = 4;
        }
      }
    }
    AppMethodBeat.o(49407);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49405);
    if (paramMotionEvent.getAction() == 0) {
      M(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(49405);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.muJ = false;
        this.muI.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.mtL != null) && (this.mtL.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (byw()))
        {
          if (this.mum == 0) {
            this.mum = 12;
          }
          ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.mum) });
        }
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void setActionBar(View paramView)
  {
    this.mgu = paramView;
  }
  
  public final void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.mtS = parama;
  }
  
  public final void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(49427);
    this.muC = paramBoolean;
    if ((!paramBoolean) && (this.muq))
    {
      ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIsCurrentMainUI and header open, close");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49427);
  }
  
  public final void setStatusBarMaskView(View paramView)
  {
    this.mtU = paramView;
  }
  
  public final void setTabView(View paramView)
  {
    this.axx = paramView;
  }
  
  public final void vr(final int paramInt)
  {
    AppMethodBeat.i(49401);
    ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(byv()), Integer.valueOf(paramInt) });
    this.mul = true;
    this.muJ = false;
    vs(0);
    if (!byv())
    {
      hP(false);
      AppMethodBeat.o(49401);
      return;
    }
    this.muD = true;
    this.mListView.removeCallbacks(this.muF);
    ListView localListView = this.mListView;
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49390);
        int j = a.c(a.this).getBottom() - a.b(a.this);
        ac.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(a.c(a.this).getBottom()) });
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
    this.muF = local5;
    localListView.post(local5);
    AppMethodBeat.o(49401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */