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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.j;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.am;

public final class a
  extends c
{
  private View apa;
  private View iQc;
  private HeaderContainer jbP;
  private float jbQ;
  private float jbR;
  private int jbS;
  private int jbT;
  private Vibrator jbU;
  private int jbV;
  private com.tencent.mm.plugin.appbrand.widget.header.a jbW;
  private DynamicBackgroundGLSurfaceView jbX;
  private View jbY;
  private boolean jbZ;
  private int jcA;
  private int jcB;
  private int jcC;
  private com.tencent.mm.plugin.appbrand.widget.header.b jcD;
  private boolean jcE;
  private Runnable jcF;
  private boolean jcG;
  private boolean jcH;
  private boolean jcI;
  private Runnable jcJ;
  private boolean jcK;
  private PointF jcL;
  private PointF jcM;
  private boolean jcN;
  private boolean jcO;
  private Runnable jcP;
  private boolean jcQ;
  private GyroView jcR;
  private View jcS;
  private boolean jcT;
  private boolean jcU;
  private boolean jcV;
  private boolean jca;
  private boolean jcb;
  private View jcc;
  private boolean jcd;
  private int jce;
  private int jcf;
  private int jcg;
  private Runnable jch;
  private Runnable jci;
  private Runnable jcj;
  private Runnable jck;
  private boolean jcl;
  private boolean jcm;
  private boolean jcn;
  private boolean jco;
  private boolean jcp;
  private int jcq;
  private boolean jcr;
  private boolean jcs;
  private boolean jct;
  private boolean jcu;
  private boolean jcv;
  private int jcw;
  private int jcx;
  private int jcy;
  private int jcz;
  private Context mContext;
  private ListView mListView;
  
  public a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(133676);
    this.jbQ = 0.2F;
    this.jbR = 0.05F;
    this.jbS = 0;
    this.jbT = 0;
    this.jbZ = true;
    this.jca = false;
    this.jcb = false;
    this.jcd = true;
    this.jce = 0;
    this.jcf = 0;
    this.jcg = 0;
    this.jch = null;
    this.jci = null;
    this.jcj = null;
    this.jck = null;
    this.jcl = false;
    this.jcm = false;
    this.jcn = true;
    this.jco = false;
    this.jcp = false;
    this.jcq = 0;
    this.jcr = false;
    this.jcs = true;
    this.jct = true;
    this.jcu = false;
    this.jcv = false;
    this.jcw = -2;
    this.jcx = 0;
    this.jcy = 0;
    this.jcz = 0;
    this.jcA = 0;
    this.jcB = 0;
    this.jcC = 0;
    this.jcE = false;
    this.jcG = false;
    this.jcH = false;
    this.jcI = false;
    this.jcL = new PointF();
    this.jcM = new PointF();
    this.jcN = false;
    this.jcO = false;
    this.jcP = new a.7(this);
    this.jcQ = true;
    this.jcT = true;
    this.jcU = false;
    this.jcV = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.jbP = paramHeaderContainer;
    this.jbU = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jbV = am.di(this.mContext);
    boolean bool = paramListView.post(new a.1(this));
    this.jct = b.aPg();
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.jct), Integer.valueOf(this.jbV), Boolean.valueOf(bool) });
    aPb();
    aPc();
    aOQ();
    this.jcD = new com.tencent.mm.plugin.appbrand.widget.header.b(this.mContext.getResources().getColor(2131689652), this.mContext.getResources().getColor(2131689693));
    AppMethodBeat.o(133676);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143634);
    ab.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.appbrand.widget.desktop.c.a.b(paramFloat, paramInt1);
    if (this.jbW != null) {
      this.jbW.a(paramFloat, paramInt1, paramInt2);
    }
    if (this.jbP != null) {
      this.jbP.pZ(paramInt1);
    }
    AppMethodBeat.o(143634);
  }
  
  private void aC(float paramFloat)
  {
    AppMethodBeat.i(143635);
    ab.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.jcD.aE(1.0F - paramFloat);
    if (this.jbW != null) {
      this.jbW.b(paramFloat, i, i);
    }
    if (this.jbP != null) {
      this.jbP.ds(i, i);
    }
    AppMethodBeat.o(143635);
  }
  
  private void aOQ()
  {
    AppMethodBeat.i(133677);
    try
    {
      this.jce = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.jcf = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
      if (this.jce < this.jcf) {
        this.jcf = 0;
      }
      this.jcg = this.jce;
      this.jcz = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100);
      this.jcC = this.mContext.getResources().getColor(2131690316);
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.jce), Integer.valueOf(this.jcg), Integer.valueOf(this.jcz) });
      AppMethodBeat.o(133677);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(133677);
    }
  }
  
  private int aOS()
  {
    AppMethodBeat.i(143630);
    int i = this.jbP.getBottom();
    int j = this.jbV;
    AppMethodBeat.o(143630);
    return i - j;
  }
  
  private boolean aOT()
  {
    AppMethodBeat.i(133681);
    if ((this.jbP != null) && (this.jbP.getBottom() <= 0))
    {
      AppMethodBeat.o(133681);
      return false;
    }
    int i = aOS() - 60;
    if (!aOZ())
    {
      if (i > aPa())
      {
        AppMethodBeat.o(133681);
        return true;
      }
      AppMethodBeat.o(133681);
      return false;
    }
    if (this.jbT == 0) {
      this.jbT = ((int)(this.jbP.getHeight() * this.jbR));
    }
    if (i < this.jbT)
    {
      AppMethodBeat.o(133681);
      return true;
    }
    AppMethodBeat.o(133681);
    return false;
  }
  
  private void aOU()
  {
    AppMethodBeat.i(143632);
    this.jcE = true;
    if (this.jcF != null) {
      this.mListView.removeCallbacks(this.jcF);
    }
    ListView localListView = this.mListView;
    a.9 local9 = new a.9(this);
    this.jcF = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(143632);
  }
  
  private void aOW()
  {
    AppMethodBeat.i(133687);
    if (this.jch != null) {
      al.ae(this.jch);
    }
    if (this.jcn)
    {
      a.11 local11 = new a.11(this);
      this.jch = local11;
      al.p(local11, 500L);
      AppMethodBeat.o(133687);
      return;
    }
    aPd();
    AppMethodBeat.o(133687);
  }
  
  private boolean aOZ()
  {
    AppMethodBeat.i(133691);
    if ((Math.abs(this.jcM.y - this.jcL.y) <= 5.0F) || (this.jcM.y <= this.jcL.y))
    {
      AppMethodBeat.o(133691);
      return true;
    }
    AppMethodBeat.o(133691);
    return false;
  }
  
  private int aPa()
  {
    AppMethodBeat.i(133692);
    if (this.jbS == 0) {
      this.jbS = ((int)(this.jbP.getHeight() * this.jbQ));
    }
    int i = this.jbS;
    AppMethodBeat.o(133692);
    return i;
  }
  
  private void aPb()
  {
    AppMethodBeat.i(133693);
    this.jcV = true;
    this.jcT = true;
    AppMethodBeat.o(133693);
  }
  
  private void aPc()
  {
    AppMethodBeat.i(133694);
    if (this.jcR != null)
    {
      this.jcR.c(0.0F, aPa());
      this.jcR.setTranslationY(0.0F);
    }
    AppMethodBeat.o(133694);
  }
  
  private void aPd()
  {
    AppMethodBeat.i(133696);
    boolean bool2 = this.jct;
    if ((b.aPg()) && (this.jbX != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jct = bool1;
      aPe();
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.jct), Boolean.valueOf(bool2) });
      if ((!this.jcn) || (!aOY())) {
        break;
      }
      AppMethodBeat.o(133696);
      return;
    }
    if (bool2) {
      if ((this.jbX != null) && (!this.jbZ))
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView onPause and set GONE");
        this.jbX.jhg.onPause();
        this.jbZ = true;
        this.jca = true;
        this.jbX.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.jcc != null)
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView GradientColorView set GONE");
        this.jcc.setVisibility(8);
      }
      AppMethodBeat.o(133696);
      return;
      if (this.jbX != null)
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView set GONE");
        this.jbX.setVisibility(8);
      }
    }
  }
  
  private void aPe()
  {
    AppMethodBeat.i(133698);
    if ((this.jcc instanceof GradientColorBackgroundView)) {
      ((GradientColorBackgroundView)this.jcc).setUpdateMode(1);
    }
    AppMethodBeat.o(133698);
  }
  
  private void pX(int paramInt)
  {
    AppMethodBeat.i(143631);
    ab.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.iQc != null) {
      this.iQc.getVisibility();
    }
    AppMethodBeat.o(143631);
  }
  
  public final void J(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138153);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.jcJ);
    this.mListView.removeCallbacks(this.jci);
    this.jcL.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.jcI = false;
    this.jcE = false;
    this.jcN = true;
    AppMethodBeat.o(138153);
  }
  
  public final void aOR()
  {
    AppMethodBeat.i(133678);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(aOY()), Boolean.valueOf(this.jcu) });
    if (!aOY())
    {
      AppMethodBeat.o(133678);
      return;
    }
    if ((this.jcT) && (this.jcU)) {
      ay.he(this.mContext);
    }
    this.jcH = true;
    this.jcp = false;
    pX(8);
    this.mListView.removeCallbacks(this.jcJ);
    Object localObject = this.mListView;
    a.4 local4 = new a.4(this);
    this.jcJ = local4;
    ((ListView)localObject).post(local4);
    if (!this.jct)
    {
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(133678);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgw;
    if (!com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.aPH())
    {
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(133678);
      return;
    }
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.jcl), Boolean.valueOf(this.jcm) });
    if ((!this.jcl) && (!this.jcm))
    {
      this.jcl = true;
      if (this.jcj != null) {
        com.tencent.mm.sdk.g.d.ysm.remove(this.jcj);
      }
      this.jcj = new a.2(this);
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
      com.tencent.mm.sdk.g.d.ysm.b(this.jcj, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(133678);
  }
  
  public final void aOV()
  {
    AppMethodBeat.i(154864);
    if (this.apa != null)
    {
      this.jcp = true;
      this.apa.setTranslationY(0.0F);
    }
    AppMethodBeat.o(154864);
  }
  
  public final boolean aOX()
  {
    AppMethodBeat.i(143633);
    if ((aOY()) && (this.jcu))
    {
      AppMethodBeat.o(143633);
      return true;
    }
    AppMethodBeat.o(143633);
    return false;
  }
  
  public final boolean aOY()
  {
    AppMethodBeat.i(133690);
    if ((this.jbP.getBottom() >= this.jbV + 10) && (this.mListView.getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(133690);
      return true;
    }
    AppMethodBeat.o(133690);
    return false;
  }
  
  public final void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133680);
    super.c(paramLong, paramInt, paramBoolean);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.jci != null) {
      this.mListView.removeCallbacks(this.jci);
    }
    ListView localListView = this.mListView;
    a.6 local6 = new a.6(this, paramBoolean, paramInt);
    this.jci = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(133680);
  }
  
  public final void e(View paramView1, View paramView2)
  {
    AppMethodBeat.i(133697);
    if ((paramView1 instanceof DynamicBackgroundGLSurfaceView)) {
      this.jbX = ((DynamicBackgroundGLSurfaceView)paramView1);
    }
    if (this.jbX == null) {
      this.jct = false;
    }
    this.jcc = paramView2;
    if ((this.jbX != null) && ((this.jcc instanceof GradientColorBackgroundView)))
    {
      this.jbX.setGradientBackgroundView((GradientColorBackgroundView)this.jcc);
      aPe();
    }
    AppMethodBeat.o(133697);
  }
  
  public final void fc(boolean paramBoolean)
  {
    AppMethodBeat.i(133685);
    super.fc(paramBoolean);
    this.jcu = true;
    if ((this.jcc != null) && (this.jcc.getVisibility() == 0)) {
      this.jcc.invalidate();
    }
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.jcp), Boolean.valueOf(this.jct) });
    if (this.apa == null)
    {
      AppMethodBeat.o(133685);
      return;
    }
    if (this.jcp)
    {
      aOV();
      AppMethodBeat.o(133685);
      return;
    }
    if (!aOY())
    {
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
      this.apa.setTranslationY(0.0F);
      AppMethodBeat.o(133685);
      return;
    }
    this.apa.animate().translationY(this.apa.getHeight()).setDuration(260L).setListener(new a.8(this)).start();
    aOU();
    AppMethodBeat.o(133685);
  }
  
  public final void fd(boolean paramBoolean)
  {
    AppMethodBeat.i(133686);
    super.fd(paramBoolean);
    this.jcu = false;
    aPc();
    aOW();
    if (this.apa == null)
    {
      AppMethodBeat.o(133686);
      return;
    }
    this.apa.setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.apa.animate().translationY(0.0F);
    if (this.apa.getTranslationY() == 0.0F) {}
    for (long l = 130L;; l = 260L)
    {
      localViewPropertyAnimator.setDuration(l).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(143629);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(143629);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(143628);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(143628);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      aOU();
      AppMethodBeat.o(133686);
      return;
    }
  }
  
  public final void fe(boolean paramBoolean)
  {
    AppMethodBeat.i(133689);
    if ((this.jbP.isFullScreen()) && (paramBoolean != this.jcQ))
    {
      if (bp.dud()) {
        ab.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jcQ) });
      }
      this.jcQ = paramBoolean;
      dc localdc = new dc();
      localdc.cqz.enable = paramBoolean;
      com.tencent.mm.sdk.b.a.ymk.l(localdc);
    }
    AppMethodBeat.o(133689);
  }
  
  public final void gA()
  {
    AppMethodBeat.i(133688);
    aOQ();
    this.jcs = false;
    AppMethodBeat.o(133688);
  }
  
  public final int getAnimationScrollOffset()
  {
    return this.jcB;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(133701);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
    if (this.mListView != null)
    {
      if (this.jci != null)
      {
        this.mListView.removeCallbacks(this.jci);
        this.jci = null;
      }
      if (this.jch != null)
      {
        this.mListView.removeCallbacks(this.jch);
        this.jch = null;
      }
      if (this.jcF != null)
      {
        this.mListView.removeCallbacks(this.jcF);
        this.jcF = null;
      }
    }
    com.tencent.mm.sdk.g.d.ysm.remove("AppBrandDesktopPerformanceMonitor");
    com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jiQ.Py();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jiQ.release();
    this.jcl = false;
    AppMethodBeat.o(133701);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(133700);
    super.onResume();
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, isCurrentMainUI: %b", new Object[] { Boolean.valueOf(aOY()), Integer.valueOf(this.jbP.getBottom()), Integer.valueOf(this.jbP.getHeight()), Boolean.valueOf(this.jcG) });
    if ((aOY()) && (this.jbP.getBottom() < this.jbP.getHeight()))
    {
      if (!this.jcG) {
        break label176;
      }
      if (this.jcM.y - this.jcL.y <= 50.0F) {
        break label160;
      }
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume openHeader");
      aOR();
    }
    for (;;)
    {
      if (!this.jcu)
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume enableBottomTabSwitch true");
        fe(true);
      }
      AppMethodBeat.o(133700);
      return;
      label160:
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume closeHeader");
      pW(4);
      continue;
      label176:
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume fastCloseHeader");
      c(0L, 0, true);
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(133684);
    if ((!this.jcE) && (paramAbsListView.isInLayout()) && (!this.jcp) && (this.jbP.getBottom() < this.jbP.getHeight()) && (this.jcu))
    {
      ab.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
      pW(0);
      AppMethodBeat.o(133684);
      return;
    }
    if ((this.jcI) && (!this.jcH) && (this.jcK) && (paramInt1 <= 0) && (aOY()))
    {
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      pW(4);
    }
    if ((this.jbP != null) && (this.jbP.getHeight() != this.jcA))
    {
      this.jcB = ((int)(this.jbP.getHeight() * this.jbQ) + 60);
      this.jcx = ((int)(this.jbP.getHeight() * this.jbQ) + 60);
      this.jcy = (this.jbP.getHeight() - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 50));
      this.jbS = ((int)(this.jbP.getHeight() * this.jbQ));
      this.jbT = ((int)(this.jbP.getHeight() * this.jbR));
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, listBgStartAlphaOffset: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.jbP.getHeight()), Integer.valueOf(this.jcA), Integer.valueOf(this.jcB), Integer.valueOf(this.jcx), Integer.valueOf(this.jcy), Integer.valueOf(this.jbS), Integer.valueOf(this.jbT) });
      this.jcA = this.jbP.getHeight();
    }
    ab.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.jcK), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.jcI), Integer.valueOf(this.jcx) });
    label857:
    int i;
    float f1;
    int j;
    label1132:
    Object localObject;
    if ((!this.jcI) && (paramInt1 == 0) && (this.jbP != null))
    {
      ab.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(this.jbP.getBottom()), Integer.valueOf(this.jbV), Integer.valueOf(this.jbP.getHeight()), Integer.valueOf(this.jbP.getBottom()), Boolean.valueOf(this.jcb) });
      if ((this.jbX != null) || (this.jcc != null))
      {
        if (!this.jct) {
          break label1289;
        }
        if ((aOY()) && (this.jbZ) && (this.jcb))
        {
          this.jbZ = false;
          if (this.jbX != null)
          {
            this.jbX.setVisibility(0);
            this.jbX.setShowGradientView(false);
          }
          if ((this.jca) && (this.jbX != null))
          {
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
            this.jbX.onResume();
            this.jca = false;
          }
        }
      }
      if (this.jcs) {
        break label1380;
      }
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (h.Mo())) && (Build.VERSION.SDK_INT >= 21) && (!aOX()))
      {
        if ((this.jbP != null) && (this.jbP.getBottom() <= this.jbV + 20))
        {
          if (this.jcc != null) {
            this.jcc.setVisibility(8);
          }
          if (this.jbX != null)
          {
            this.jbX.jhg.onPause();
            this.jbZ = true;
            this.jca = true;
            this.jbX.setVisibility(8);
          }
        }
        if ((this.mListView.getFirstVisiblePosition() > 0) || ((this.mListView.getFirstVisiblePosition() == 0) && (!aOY())))
        {
          this.mListView.setBackgroundColor(this.mListView.getResources().getColor(2131690605));
          if (this.jbY != null) {
            this.jbY.setBackgroundColor(this.mContext.getResources().getColor(2131690605));
          }
          if (this.jcc != null) {
            this.jcc.setVisibility(4);
          }
        }
      }
      if (aOY()) {
        break label1737;
      }
      this.jcI = true;
      if ((aOT()) || (!this.jcv)) {
        break label1714;
      }
      s(false, true);
      if (this.jcR == null) {
        this.jcR = ((GyroView)this.jbP.findViewById(2131820627));
      }
      if (this.jcS == null) {
        this.jcS = this.jbP.findViewById(2131821175);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = aPa();
        paramInt2 = this.jbP.getBottom();
        paramInt3 = aOS();
        i = this.jcy - this.jcx;
        f1 = 1.0F * (paramInt3 - this.jcx) / i;
        this.jcS.setAlpha(f1);
        j = paramInt3 - 60;
        ab.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.jcx), Integer.valueOf(this.jcy), Boolean.valueOf(this.jcK), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jbP.getHeight()), Integer.valueOf(this.jcR.getHeight()) });
        if (((!this.jcK) && (paramInt2 >= 5)) || (this.jco))
        {
          if (paramInt1 < j) {
            break label1745;
          }
          this.jcR.c(j, paramInt1);
          this.jcR.setAlpha(1.0F);
        }
        f1 = 1.0F * (j - paramInt1) / this.jcz;
        localObject = this.jcR;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.jcR.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.jcV) && (aOY()) && (!paramAbsListView.isInLayout()))
        {
          this.jbU.vibrate(10L);
          this.jcV = false;
        }
        if (paramInt2 < this.jbV + 10) {
          aPb();
        }
      }
      this.jcO = aOY();
      if ((!aOY()) || (!this.jcN)) {
        break label1758;
      }
      fe(false);
    }
    for (;;)
    {
      al.ae(this.jcP);
      al.p(this.jcP, 60L);
      AppMethodBeat.o(133684);
      return;
      label1289:
      this.jbZ = true;
      this.jca = true;
      if (this.jbX != null)
      {
        this.jbX.setVisibility(8);
        this.jbX.jhg.onPause();
      }
      if ((!aOY()) || (this.jcc == null) || ((this.jcc.getVisibility() == 0) && (this.jcc.getAlpha() == 1.0F))) {
        break;
      }
      this.jcc.setAlpha(1.0F);
      this.jcc.setVisibility(0);
      break;
      label1380:
      paramInt3 = aOS();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.jcB) / (this.jbP.getMeasuredHeight() - this.jbV - this.jcB)));
      i = com.tencent.mm.plugin.appbrand.widget.desktop.c.a.b(f1, this.mContext.getResources().getColor(2131690316));
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(i);
      }
      if (this.jbY != null) {
        this.jbY.setBackgroundColor(i);
      }
      i = this.jbP.getHeight() - this.jbV - this.jce;
      j = aOS() - i;
      float f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.jce - this.jcf)));
      ab.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
      if ((paramInt3 < this.jcB) || (paramInt3 < this.jcx))
      {
        pX(0);
        a(1.0F, this.jcC, paramInt3);
        aC(1.0F);
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
          pX(8);
          a(f2, this.mContext.getResources().getColor(2131689692), paramInt3);
          aC(1.0F - f2);
        }
      }
      label1714:
      if ((!this.jcO) || (!this.jcv)) {
        break label857;
      }
      s(false, true);
      break label857;
      label1737:
      this.jcI = false;
      break label857;
      label1745:
      this.jcR.c(paramInt1, paramInt1);
      break label1132;
      label1758:
      if (!this.jcu) {
        fe(true);
      } else if (this.jcu) {
        fe(false);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(133683);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(aOZ()) });
    this.jcb = true;
    int i = this.jcw;
    this.jcw = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jcv = false;
      if ((this.jcH) && (paramInt == 0))
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
        this.jcH = false;
        if (i == -1)
        {
          ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged checkOpen: %b", new Object[] { Boolean.valueOf(aOT()) });
          if ((this.jbP.getBottom() < 200) || (this.mListView.getFirstVisiblePosition() != 0) || (this.jcu)) {
            break label184;
          }
        }
        label184:
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt != 0) && (aOT()))
          {
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged header is visible but not open");
            this.jcp = false;
            s(true, false);
          }
          AppMethodBeat.o(133683);
          return;
        }
      }
      if (aOT())
      {
        aOR();
        AppMethodBeat.o(133683);
        return;
      }
      if ((aOZ()) && (paramInt == -1))
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
        pW(4);
        AppMethodBeat.o(133683);
        return;
      }
      if (paramInt == -1)
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        pW(0);
        this.jco = true;
        AppMethodBeat.o(133683);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.jcK = true;
        this.jcv = true;
        AppMethodBeat.o(133683);
        return;
      }
      if (paramInt == 1)
      {
        this.jcK = false;
        this.jcs = true;
        this.jcv = true;
        if (aOZ())
        {
          this.jcK = false;
          this.jcq = 4;
        }
      }
    }
    AppMethodBeat.o(133683);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133682);
    if (paramMotionEvent.getAction() == 0) {
      J(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(133682);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.jcN = false;
        this.jcM.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.jbP != null) && (this.jbP.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (aOZ()))
        {
          if (this.jcq == 0) {
            this.jcq = 12;
          }
          ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.jcq) });
        }
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void pW(int paramInt)
  {
    AppMethodBeat.i(133679);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(aOY()), Integer.valueOf(paramInt) });
    this.jcp = true;
    this.jcN = false;
    pX(0);
    if (!aOY())
    {
      fd(false);
      AppMethodBeat.o(133679);
      return;
    }
    this.jcH = true;
    this.mListView.removeCallbacks(this.jcJ);
    ListView localListView = this.mListView;
    a.5 local5 = new a.5(this, paramInt);
    this.jcJ = local5;
    localListView.post(local5);
    AppMethodBeat.o(133679);
  }
  
  public final void setActionBar(View paramView)
  {
    this.iQc = paramView;
  }
  
  public final void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.jbW = parama;
  }
  
  public final void setIsCurrentMainUI(boolean paramBoolean)
  {
    this.jcG = paramBoolean;
  }
  
  public final void setStatusBarMaskView(View paramView)
  {
    this.jbY = paramView;
  }
  
  public final void setTabView(View paramView)
  {
    this.apa = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */