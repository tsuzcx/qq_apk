package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.DisplayMetrics;
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
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;

public final class a
  extends com.tencent.mm.plugin.appbrand.widget.header.c
{
  private View awD;
  private View lEz;
  private HeaderContainer lRJ;
  private float lRK;
  private float lRL;
  private int lRM;
  private int lRN;
  private Vibrator lRO;
  private int lRP;
  private com.tencent.mm.plugin.appbrand.widget.header.a lRQ;
  private DynamicBackgroundGLSurfaceView lRR;
  private View lRS;
  private boolean lRT;
  private boolean lRU;
  private boolean lRV;
  private View lRW;
  private boolean lRX;
  private int lRY;
  private int lRZ;
  private boolean lSA;
  private boolean lSB;
  private boolean lSC;
  private Runnable lSD;
  private boolean lSE;
  private PointF lSF;
  private PointF lSG;
  private boolean lSH;
  private boolean lSI;
  private Runnable lSJ;
  private boolean lSK;
  private GyroView lSL;
  private View lSM;
  private boolean lSN;
  private boolean lSO;
  private boolean lSP;
  private int lSa;
  private Runnable lSb;
  private Runnable lSc;
  private com.tencent.e.i.b lSd;
  private com.tencent.e.i.b lSe;
  private boolean lSf;
  private boolean lSg;
  private boolean lSh;
  private boolean lSi;
  private boolean lSj;
  private int lSk;
  private boolean lSl;
  private boolean lSm;
  private boolean lSn;
  private boolean lSo;
  private boolean lSp;
  private int lSq;
  private int lSr;
  private int lSs;
  private int lSt;
  private int lSu;
  private int lSv;
  private int lSw;
  private com.tencent.mm.plugin.appbrand.widget.header.b lSx;
  private boolean lSy;
  private Runnable lSz;
  private Context mContext;
  private ListView mListView;
  
  public a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(49398);
    this.lRK = 0.2F;
    this.lRL = 0.05F;
    this.lRM = 0;
    this.lRN = 0;
    this.lRT = true;
    this.lRU = false;
    this.lRV = false;
    this.lRX = true;
    this.lRY = 0;
    this.lRZ = 0;
    this.lSa = 0;
    this.lSb = null;
    this.lSc = null;
    this.lSd = null;
    this.lSe = null;
    this.lSf = false;
    this.lSg = false;
    this.lSh = true;
    this.lSi = false;
    this.lSj = false;
    this.lSk = 0;
    this.lSl = false;
    this.lSm = true;
    this.lSn = true;
    this.lSo = false;
    this.lSp = false;
    this.lSq = -2;
    this.lSr = 0;
    this.lSs = 0;
    this.lSt = 0;
    this.lSu = 0;
    this.lSv = 0;
    this.lSw = 0;
    this.lSy = false;
    this.lSA = true;
    this.lSB = false;
    this.lSC = false;
    this.lSF = new PointF();
    this.lSG = new PointF();
    this.lSH = false;
    this.lSI = false;
    this.lSJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49392);
        a.j(a.this);
        AppMethodBeat.o(49392);
      }
    };
    this.lSK = true;
    this.lSN = true;
    this.lSO = false;
    this.lSP = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.lRJ = paramHeaderContainer;
    this.lRO = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.lRP = ap.dL(this.mContext);
    boolean bool = paramListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49385);
        a.a(a.this, ap.dL(a.a(a.this)));
        ad.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:" + a.b(a.this));
        AppMethodBeat.o(49385);
      }
    });
    this.lSn = b.aaf();
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.lSn), Integer.valueOf(this.lRP), Boolean.valueOf(bool) });
    bry();
    brz();
    brn();
    this.lSx = new com.tencent.mm.plugin.appbrand.widget.header.b(ao.aD(this.mContext, 2130968584), ao.aD(this.mContext, 2130968585));
    AppMethodBeat.o(49398);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49425);
    ad.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(paramFloat, paramInt1);
    if (this.lRQ != null) {
      this.lRQ.a(paramFloat, paramInt1, paramInt2);
    }
    if (this.lRJ != null) {
      this.lRJ.uD(paramInt1);
    }
    AppMethodBeat.o(49425);
  }
  
  private void aF(float paramFloat)
  {
    AppMethodBeat.i(49426);
    ad.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.lSx.aH(1.0F - paramFloat);
    if (this.lRQ != null) {
      this.lRQ.b(paramFloat, i, i);
    }
    if (this.lRJ != null) {
      this.lRJ.eo(i, i);
    }
    AppMethodBeat.o(49426);
  }
  
  private void brA()
  {
    AppMethodBeat.i(49422);
    boolean bool2 = this.lSn;
    if ((b.aaf()) && (this.lRR != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.lSn = bool1;
      brB();
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.lSn), Boolean.valueOf(bool2) });
      if ((!this.lSh) || (!brv())) {
        break;
      }
      AppMethodBeat.o(49422);
      return;
    }
    if (bool2) {
      if ((this.lRR != null) && (!this.lRT))
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView onPause and set GONE");
        this.lRR.onPause();
        this.lRT = true;
        this.lRU = true;
        this.lRR.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.lRW != null)
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView GradientColorView set GONE");
        this.lRW.setVisibility(8);
      }
      AppMethodBeat.o(49422);
      return;
      if (this.lRR != null)
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView set GONE");
        this.lRR.setVisibility(8);
      }
    }
  }
  
  private void brB()
  {
    AppMethodBeat.i(49424);
    if ((this.lRW instanceof GradientColorBackgroundView)) {
      ((GradientColorBackgroundView)this.lRW).setUpdateMode(1);
    }
    AppMethodBeat.o(49424);
  }
  
  private void brn()
  {
    AppMethodBeat.i(49399);
    try
    {
      this.lRY = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.lRZ = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
      if (this.lRY < this.lRZ) {
        this.lRZ = 0;
      }
      this.lSa = this.lRY;
      this.lSt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 100);
      this.lSw = ao.aD(this.mContext, 2130968577);
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.lRY), Integer.valueOf(this.lSa), Integer.valueOf(this.lSt) });
      AppMethodBeat.o(49399);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(49399);
    }
  }
  
  private int brp()
  {
    AppMethodBeat.i(49403);
    if (this.lRJ.getMeasuredHeight() == 0)
    {
      AppMethodBeat.o(49403);
      return 0;
    }
    int i = this.lRJ.getBottom();
    int j = this.lRP;
    AppMethodBeat.o(49403);
    return i - j;
  }
  
  private boolean brq()
  {
    AppMethodBeat.i(49404);
    if ((this.lRJ != null) && (this.lRJ.getBottom() <= 0))
    {
      AppMethodBeat.o(49404);
      return false;
    }
    int i = brp() - 60;
    if (!brw())
    {
      if (i > brx())
      {
        AppMethodBeat.o(49404);
        return true;
      }
      AppMethodBeat.o(49404);
      return false;
    }
    if (this.lRN == 0) {
      this.lRN = ((int)(this.lRJ.getHeight() * this.lRL));
    }
    if (i < this.lRN)
    {
      AppMethodBeat.o(49404);
      return true;
    }
    AppMethodBeat.o(49404);
    return false;
  }
  
  private void brr()
  {
    AppMethodBeat.i(49411);
    this.lSy = true;
    if (this.lSz != null) {
      this.mListView.removeCallbacks(this.lSz);
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
    this.lSz = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(49411);
  }
  
  private void brt()
  {
    AppMethodBeat.i(49414);
    if (this.lSb != null) {
      aq.az(this.lSb);
    }
    if (this.lSh)
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
      this.lSb = local11;
      aq.n(local11, 500L);
      AppMethodBeat.o(49414);
      return;
    }
    brA();
    AppMethodBeat.o(49414);
  }
  
  private boolean brw()
  {
    AppMethodBeat.i(49419);
    if ((Math.abs(this.lSG.y - this.lSF.y) <= 5.0F) || (this.lSG.y <= this.lSF.y))
    {
      AppMethodBeat.o(49419);
      return true;
    }
    AppMethodBeat.o(49419);
    return false;
  }
  
  private int brx()
  {
    AppMethodBeat.i(49420);
    if (this.lRM == 0) {
      this.lRM = ((int)(this.lRJ.getHeight() * this.lRK));
    }
    int i = this.lRM;
    AppMethodBeat.o(49420);
    return i;
  }
  
  private void bry()
  {
    this.lSP = true;
    this.lSN = true;
  }
  
  private void brz()
  {
    AppMethodBeat.i(49421);
    if (this.lSL != null)
    {
      this.lSL.b(0.0F, brx());
      this.lSL.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49421);
  }
  
  private void uB(int paramInt)
  {
    AppMethodBeat.i(49408);
    ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.lEz != null) {
      this.lEz.getVisibility();
    }
    AppMethodBeat.o(49408);
  }
  
  public final void O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49406);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.lSD);
    this.mListView.removeCallbacks(this.lSc);
    this.lSF.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.lSC = false;
    this.lSy = false;
    this.lSH = true;
    AppMethodBeat.o(49406);
  }
  
  public final void b(long paramLong, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(49402);
    super.b(paramLong, paramInt, paramBoolean);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.lSc != null) {
      this.mListView.removeCallbacks(this.lSc);
    }
    ListView localListView = this.mListView;
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49391);
        a.a(a.this, paramBoolean);
        a.this.uA(paramInt);
        AppMethodBeat.o(49391);
      }
    };
    this.lSc = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(49402);
  }
  
  public final void bro()
  {
    AppMethodBeat.i(49400);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(brv()), Boolean.valueOf(this.lSo) });
    if (!brv())
    {
      AppMethodBeat.o(49400);
      return;
    }
    if ((this.lSN) && (this.lSO)) {
      bd.iH(this.mContext);
    }
    this.lSB = true;
    this.lSj = false;
    uB(8);
    this.mListView.removeCallbacks(this.lSD);
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
    this.lSD = local4;
    ((ListView)localObject).post(local4);
    if (!this.lSn)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(49400);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWw;
    if (!com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bsg())
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(49400);
      return;
    }
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.lSf), Boolean.valueOf(this.lSg) });
    if ((!this.lSf) && (!this.lSg))
    {
      this.lSf = true;
      if (this.lSd != null) {
        this.lSd.cancel();
      }
      this.lSd = new a.2(this);
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
      h.Iye.f(this.lSd, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(49400);
  }
  
  public final void brs()
  {
    AppMethodBeat.i(49412);
    if (this.awD != null)
    {
      this.lSj = true;
      this.awD.setTranslationY(0.0F);
    }
    AppMethodBeat.o(49412);
  }
  
  public final boolean bru()
  {
    AppMethodBeat.i(49417);
    if ((brv()) && (this.lSo))
    {
      AppMethodBeat.o(49417);
      return true;
    }
    AppMethodBeat.o(49417);
    return false;
  }
  
  public final boolean brv()
  {
    AppMethodBeat.i(49418);
    if ((this.lRJ.getBottom() >= this.lRP + 10) && (this.mListView.getFirstVisiblePosition() == 0))
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
      this.lRR = ((DynamicBackgroundGLSurfaceView)paramView1);
    }
    if (this.lRR == null) {
      this.lSn = false;
    }
    this.lRW = paramView2;
    if ((this.lRR != null) && ((this.lRW instanceof GradientColorBackgroundView)))
    {
      this.lRR.setGradientBackgroundView((GradientColorBackgroundView)this.lRW);
      brB();
    }
    AppMethodBeat.o(49423);
  }
  
  public final int getAnimationScrollOffset()
  {
    return this.lSv;
  }
  
  public final void hV()
  {
    AppMethodBeat.i(49415);
    brn();
    this.lSm = false;
    AppMethodBeat.o(49415);
  }
  
  public final void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(49410);
    super.hq(paramBoolean);
    this.lSo = true;
    if ((this.lRW != null) && (this.lRW.getVisibility() == 0)) {
      this.lRW.invalidate();
    }
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.lSj), Boolean.valueOf(this.lSn) });
    if (this.awD == null)
    {
      AppMethodBeat.o(49410);
      return;
    }
    if (this.lSj)
    {
      brs();
      AppMethodBeat.o(49410);
      return;
    }
    if (!brv())
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
      this.awD.setTranslationY(0.0F);
      AppMethodBeat.o(49410);
      return;
    }
    this.awD.animate().translationY(this.awD.getHeight()).setDuration(260L).setListener(new Animator.AnimatorListener()
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
    brr();
    AppMethodBeat.o(49410);
  }
  
  public final void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(49413);
    super.hr(paramBoolean);
    this.lSo = false;
    brz();
    brt();
    if (this.awD == null)
    {
      AppMethodBeat.o(49413);
      return;
    }
    this.awD.setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.awD.animate().translationY(0.0F);
    if (this.awD.getTranslationY() == 0.0F) {}
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
      brr();
      AppMethodBeat.o(49413);
      return;
    }
  }
  
  public final void hs(boolean paramBoolean)
  {
    AppMethodBeat.i(49416);
    if ((this.lRJ.isFullScreen()) && (paramBoolean != this.lSK))
    {
      if (bu.eGT()) {
        ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.lSK) });
      }
      this.lSK = paramBoolean;
      di localdi = new di();
      localdi.dfv.enable = paramBoolean;
      com.tencent.mm.sdk.b.a.ESL.l(localdi);
    }
    AppMethodBeat.o(49416);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49429);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
    if (this.mListView != null)
    {
      if (this.lSc != null)
      {
        this.mListView.removeCallbacks(this.lSc);
        this.lSc = null;
      }
      if (this.lSb != null)
      {
        this.mListView.removeCallbacks(this.lSb);
        this.lSb = null;
      }
      if (this.lSz != null)
      {
        this.mListView.removeCallbacks(this.lSz);
        this.lSz = null;
      }
    }
    h.Iye.aNW("AppBrandDesktopPerformanceMonitor");
    d.lYh.ade();
    d.lYh.release();
    this.lSf = false;
    if (this.lRR != null)
    {
      DynamicBackgroundGLSurfaceView.b localb = this.lRR.fIG;
      if (localb != null) {
        try
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
          DynamicBackgroundNative localDynamicBackgroundNative = localb.fIK;
          if (localDynamicBackgroundNative != null) {
            localDynamicBackgroundNative.nativeRelease();
          }
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
          localb.fIN = 0;
          localb.fIO = 0;
          localb.fIW = false;
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
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, isCurrentMainUI: %b", new Object[] { Boolean.valueOf(brv()), Integer.valueOf(this.lRJ.getBottom()), Integer.valueOf(this.lRJ.getHeight()), Boolean.valueOf(this.lSA) });
    if ((brv()) && (this.lRJ.getBottom() < this.lRJ.getHeight()))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume fastCloseHeader");
      b(0L, 0, true);
    }
    if (!this.lSo)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume enableBottomTabSwitch true");
      hs(true);
      AppMethodBeat.o(49428);
      return;
    }
    if (!this.lSA)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume not main ui and header open, then close header");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49428);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49409);
    if ((!this.lSy) && (paramAbsListView.isInLayout()) && (!this.lSj) && (this.lRJ.getBottom() < this.lRJ.getHeight()) && (this.lSo))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
      uA(0);
      AppMethodBeat.o(49409);
      return;
    }
    if ((this.lSC) && (!this.lSB) && (this.lSE) && (paramInt1 <= 0) && (brv()))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      uA(4);
    }
    if ((this.lRJ != null) && (this.lRJ.getHeight() != this.lSu))
    {
      this.lSv = ((int)(this.lRJ.getHeight() * this.lRK) + 60);
      this.lSr = ((int)(this.lRJ.getHeight() * this.lRK) + 60);
      this.lSs = (this.lRJ.getHeight() - com.tencent.mm.cd.a.fromDPToPix(this.mContext, 50));
      this.lRM = ((int)(this.lRJ.getHeight() * this.lRK));
      this.lRN = ((int)(this.lRJ.getHeight() * this.lRL));
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, listBgStartAlphaOffset: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.lRJ.getHeight()), Integer.valueOf(this.lSu), Integer.valueOf(this.lSv), Integer.valueOf(this.lSr), Integer.valueOf(this.lSs), Integer.valueOf(this.lRM), Integer.valueOf(this.lRN) });
      this.lSu = this.lRJ.getHeight();
    }
    ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.lSE), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.lSC), Integer.valueOf(this.lSr) });
    label854:
    int i;
    float f1;
    int j;
    label1129:
    Object localObject;
    if ((!this.lSC) && (paramInt1 == 0) && (this.lRJ != null))
    {
      ad.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(this.lRJ.getBottom()), Integer.valueOf(this.lRP), Integer.valueOf(this.lRJ.getHeight()), Integer.valueOf(this.lRJ.getBottom()), Boolean.valueOf(this.lRV) });
      if ((this.lRR != null) || (this.lRW != null))
      {
        if (!this.lSn) {
          break label1286;
        }
        if ((brv()) && (this.lRT) && (this.lRV))
        {
          this.lRT = false;
          if (this.lRR != null)
          {
            this.lRR.setVisibility(0);
            this.lRR.setShowGradientView(false);
          }
          if ((this.lRU) && (this.lRR != null))
          {
            ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
            this.lRR.onResume();
            this.lRU = false;
          }
        }
      }
      if (this.lSm) {
        break label1374;
      }
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (g.XM())) && (Build.VERSION.SDK_INT >= 21) && (!bru()))
      {
        if ((this.lRJ != null) && (this.lRJ.getBottom() <= this.lRP + 20))
        {
          if (this.lRW != null) {
            this.lRW.setVisibility(8);
          }
          if (this.lRR != null)
          {
            this.lRR.onPause();
            this.lRT = true;
            this.lRU = true;
            this.lRR.setVisibility(8);
          }
        }
        if ((this.mListView.getFirstVisiblePosition() > 0) || ((this.mListView.getFirstVisiblePosition() == 0) && (!brv())))
        {
          this.mListView.setBackgroundColor(this.mListView.getResources().getColor(2131101053));
          if (this.lRS != null) {
            this.lRS.setBackgroundColor(this.mContext.getResources().getColor(2131101053));
          }
          if (this.lRW != null) {
            this.lRW.setVisibility(4);
          }
        }
      }
      if (brv()) {
        break label1728;
      }
      this.lSC = true;
      if ((brq()) || (!this.lSp)) {
        break label1705;
      }
      y(false, true);
      if (this.lSL == null) {
        this.lSL = ((GyroView)this.lRJ.findViewById(2131300673));
      }
      if (this.lSM == null) {
        this.lSM = this.lRJ.findViewById(2131296708);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = brx();
        paramInt2 = this.lRJ.getBottom();
        paramInt3 = brp();
        i = this.lSs - this.lSr;
        f1 = 1.0F * (paramInt3 - this.lSr) / i;
        this.lSM.setAlpha(f1);
        j = paramInt3 - 60;
        ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.lSr), Integer.valueOf(this.lSs), Boolean.valueOf(this.lSE), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.lRJ.getHeight()), Integer.valueOf(this.lSL.getHeight()) });
        if (((!this.lSE) && (paramInt2 >= 5)) || (this.lSi))
        {
          if (paramInt1 < j) {
            break label1736;
          }
          this.lSL.b(j, paramInt1);
          this.lSL.setAlpha(1.0F);
        }
        f1 = 1.0F * (j - paramInt1) / this.lSt;
        localObject = this.lSL;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.lSL.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.lSP) && (brv()) && (!paramAbsListView.isInLayout()))
        {
          this.lRO.vibrate(10L);
          this.lSP = false;
        }
        if (paramInt2 < this.lRP + 10) {
          bry();
        }
      }
      this.lSI = brv();
      if ((!brv()) || (!this.lSH)) {
        break label1749;
      }
      hs(false);
    }
    for (;;)
    {
      aq.az(this.lSJ);
      aq.n(this.lSJ, 60L);
      AppMethodBeat.o(49409);
      return;
      label1286:
      this.lRT = true;
      this.lRU = true;
      if (this.lRR != null)
      {
        this.lRR.setVisibility(8);
        this.lRR.onPause();
      }
      if ((!brv()) || (this.lRW == null) || ((this.lRW.getVisibility() == 0) && (this.lRW.getAlpha() == 1.0F))) {
        break;
      }
      this.lRW.setAlpha(1.0F);
      this.lRW.setVisibility(0);
      break;
      label1374:
      paramInt3 = brp();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.lSv) / (this.lRJ.getMeasuredHeight() - this.lRP - this.lSv)));
      i = com.tencent.mm.plugin.appbrand.widget.desktop.d.a.a(f1, ao.aD(this.mContext, 2130968577));
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(i);
      }
      if (this.lRS != null) {
        this.lRS.setBackgroundColor(i);
      }
      i = this.lRJ.getHeight() - this.lRP - this.lRY;
      j = brp() - i;
      float f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.lRY - this.lRZ)));
      ad.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
      if ((paramInt3 < this.lSv) || (paramInt3 < this.lSr))
      {
        uB(0);
        a(1.0F, this.lSw, paramInt3);
        aF(1.0F);
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
          uB(8);
          a(f2, this.mContext.getResources().getColor(2131099930), paramInt3);
          aF(1.0F - f2);
        }
      }
      label1705:
      if ((!this.lSI) || (!this.lSp)) {
        break label854;
      }
      y(false, true);
      break label854;
      label1728:
      this.lSC = false;
      break label854;
      label1736:
      this.lSL.b(paramInt1, paramInt1);
      break label1129;
      label1749:
      if (!this.lSo) {
        hs(true);
      } else if (this.lSo) {
        hs(false);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(49407);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(brw()) });
    this.lRV = true;
    int i = this.lSq;
    this.lSq = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.lSp = false;
      if ((this.lSB) && (paramInt == 0))
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
        this.lSB = false;
        if (i == -1)
        {
          ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged checkOpen: %b", new Object[] { Boolean.valueOf(brq()) });
          if ((this.lRJ.getBottom() < 200) || (this.mListView.getFirstVisiblePosition() != 0) || (this.lSo)) {
            break label184;
          }
        }
        label184:
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt != 0) && (brq()))
          {
            ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged header is visible but not open");
            this.lSj = false;
            y(true, false);
          }
          AppMethodBeat.o(49407);
          return;
        }
      }
      if (brq())
      {
        bro();
        AppMethodBeat.o(49407);
        return;
      }
      if ((brw()) && (paramInt == -1))
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
        uA(4);
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == -1)
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        uA(0);
        this.lSi = true;
        AppMethodBeat.o(49407);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.lSE = true;
        this.lSp = true;
        AppMethodBeat.o(49407);
        return;
      }
      if (paramInt == 1)
      {
        this.lSE = false;
        this.lSm = true;
        this.lSp = true;
        if (brw())
        {
          this.lSE = false;
          this.lSk = 4;
        }
      }
    }
    AppMethodBeat.o(49407);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49405);
    if (paramMotionEvent.getAction() == 0) {
      O(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(49405);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.lSH = false;
        this.lSG.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.lRJ != null) && (this.lRJ.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (brw()))
        {
          if (this.lSk == 0) {
            this.lSk = 12;
          }
          ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.lSk) });
        }
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void setActionBar(View paramView)
  {
    this.lEz = paramView;
  }
  
  public final void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.lRQ = parama;
  }
  
  public final void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(49427);
    this.lSA = paramBoolean;
    if ((!paramBoolean) && (this.lSo))
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIsCurrentMainUI and header open, close");
      b(0L, 0, true);
    }
    AppMethodBeat.o(49427);
  }
  
  public final void setStatusBarMaskView(View paramView)
  {
    this.lRS = paramView;
  }
  
  public final void setTabView(View paramView)
  {
    this.awD = paramView;
  }
  
  public final void uA(final int paramInt)
  {
    AppMethodBeat.i(49401);
    ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(brv()), Integer.valueOf(paramInt) });
    this.lSj = true;
    this.lSH = false;
    uB(0);
    if (!brv())
    {
      hr(false);
      AppMethodBeat.o(49401);
      return;
    }
    this.lSB = true;
    this.mListView.removeCallbacks(this.lSD);
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
    this.lSD = local5;
    localListView.post(local5);
    AppMethodBeat.o(49401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */