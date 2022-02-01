package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.e;
import com.tencent.mm.vending.e.a;
import java.util.LinkedList;

public class HybridOpenMaterialView
  extends RelativeLayout
  implements a
{
  private static final int nmo;
  private static final int nmp;
  private final VelocityTracker mVelocityTracker;
  private float nmA;
  private float nmB;
  private float nmC;
  private float nmD;
  private float nmE;
  private final LinkedList<Integer> nmF;
  private int nmG;
  private float nmH;
  private boolean nmI;
  private float nmJ;
  private boolean nmK;
  private boolean nmL;
  private boolean nmM;
  private boolean nmN;
  private LinearLayout nmq;
  private LinearLayout nmr;
  private FrameLayout nms;
  private MMWebView nmt;
  private final boolean nmu;
  private a nmv;
  private boolean nmw;
  private int nmx;
  private int nmy;
  private int nmz;
  
  static
  {
    AppMethodBeat.i(227258);
    nmo = at.aH(MMApplicationContext.getContext(), 2131165312);
    nmp = at.aH(MMApplicationContext.getContext(), 2131165299);
    AppMethodBeat.o(227258);
  }
  
  public HybridOpenMaterialView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HybridOpenMaterialView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HybridOpenMaterialView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(227243);
    this.mVelocityTracker = VelocityTracker.obtain();
    this.nmv = null;
    this.nmw = true;
    this.nmx = 0;
    this.nmy = 0;
    this.nmz = 0;
    this.nmA = 0.0F;
    this.nmB = 0.0F;
    this.nmC = 0.0F;
    this.nmD = 0.0F;
    this.nmE = 0.0F;
    this.nmF = new LinkedList();
    this.nmG = -1;
    this.nmH = 0.0F;
    this.nmI = false;
    this.nmJ = 0.0F;
    this.nmK = true;
    this.nmL = false;
    this.nmM = false;
    this.nmN = false;
    LayoutInflater.from(paramContext).inflate(2131495889, this, true);
    paramContext = findViewById(2131305626);
    this.nmq = ((LinearLayout)findViewById(2131305624));
    this.nmr = ((LinearLayout)findViewById(2131305627));
    this.nms = ((FrameLayout)findViewById(2131305625));
    setFitsSystemWindows(true);
    this.nmu = isLandscape();
    paramContext.setOnClickListener(new HybridOpenMaterialView.1(this));
    this.nmr.setOnClickListener(new HybridOpenMaterialView.4(this));
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(227230);
        HybridOpenMaterialView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this);
        AppMethodBeat.o(227230);
      }
    });
    AppMethodBeat.o(227243);
  }
  
  private void bQn()
  {
    AppMethodBeat.i(227252);
    MMWebView localMMWebView = this.nmt;
    if (localMMWebView == null)
    {
      Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, contentArea is null");
      AppMethodBeat.o(227252);
      return;
    }
    int i = Math.max(0, (int)(localMMWebView.getHeight() - this.nmq.getTranslationY()));
    Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, visibleHeight: ".concat(String.valueOf(i)));
    if (this.nmv != null) {
      this.nmv.yH(i);
    }
    AppMethodBeat.o(227252);
  }
  
  private void bQo()
  {
    AppMethodBeat.i(227253);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2FullScreen");
    d(this.nmq.getTranslationY(), this.nmy, true);
    AppMethodBeat.o(227253);
  }
  
  private void d(float paramFloat1, float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(227254);
    if (paramFloat2 == paramFloat1)
    {
      this.nmL = paramBoolean;
      this.nmJ = paramFloat2;
      AppMethodBeat.o(227254);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(227225);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        HybridOpenMaterialView.e(HybridOpenMaterialView.this).setTranslationY(f);
        HybridOpenMaterialView.f(HybridOpenMaterialView.this);
        AppMethodBeat.o(227225);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(227228);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
        AppMethodBeat.o(227228);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(227227);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
        HybridOpenMaterialView.c(HybridOpenMaterialView.this, paramBoolean);
        HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "animateSwitch, curWholeContentAreaTranslationY: " + HybridOpenMaterialView.g(HybridOpenMaterialView.this));
        AppMethodBeat.o(227227);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(227226);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
        AppMethodBeat.o(227226);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(227254);
  }
  
  private int getFullScreenTopRemainPx()
  {
    if (this.nmu) {
      return nmp;
    }
    return nmo;
  }
  
  private boolean isLandscape()
  {
    boolean bool = false;
    AppMethodBeat.i(227255);
    try
    {
      int i = getContext().getResources().getConfiguration().orientation;
      if (2 == i) {
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "isLandscape fail since ".concat(String.valueOf(localException)));
      }
    }
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "isLandscape: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(227255);
    return bool;
  }
  
  public final ViewGroup.LayoutParams bQm()
  {
    AppMethodBeat.i(227244);
    if (this.nmu)
    {
      localObject = new Rect();
      getWindowVisibleDisplayFrame((Rect)localObject);
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "generateMyLayoutParams, windowVisibleRect: ".concat(String.valueOf(localObject)));
      localObject = new ViewGroup.LayoutParams((int)(((Rect)localObject).right * 1.0F / 2.0F), -1);
      AppMethodBeat.o(227244);
      return localObject;
    }
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    AppMethodBeat.o(227244);
    return localObject;
  }
  
  public void dead()
  {
    AppMethodBeat.i(227249);
    Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "dead");
    if (this.nmt != null) {
      this.nmt.destroy();
    }
    AppMethodBeat.o(227249);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(227248);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, from: %f, to: %d", new Object[] { Float.valueOf(this.nmq.getTranslationY()), Integer.valueOf(this.nmx) });
    this.nmM = false;
    ViewPropertyAnimator localViewPropertyAnimator = this.nmq.animate().translationY(this.nmx);
    if (this.nmL) {}
    for (long l = 500L;; l = 300L)
    {
      localViewPropertyAnimator.setDuration(l).setInterpolator(new AccelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(227240);
          HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, curWholeContentAreaTranslationY: %f", new Object[] { Float.valueOf(HybridOpenMaterialView.g(HybridOpenMaterialView.this)) });
          HybridOpenMaterialView.f(HybridOpenMaterialView.this);
          AppMethodBeat.o(227240);
        }
      }).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(227239);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          AppMethodBeat.o(227239);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(227238);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          HybridOpenMaterialView.c(HybridOpenMaterialView.this, false);
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, onAnimationEnd");
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(227236);
              if (HybridOpenMaterialView.c(HybridOpenMaterialView.this) != null) {
                HybridOpenMaterialView.c(HybridOpenMaterialView.this).bQd();
              }
              AppMethodBeat.o(227236);
            }
          });
          AppMethodBeat.o(227238);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(227237);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
          AppMethodBeat.o(227237);
        }
      }).start();
      AppMethodBeat.o(227248);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(227250);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, ev: " + paramMotionEvent.getAction());
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool)
    {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, super intercept");
      AppMethodBeat.o(227250);
      return true;
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, intercept: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(227250);
        return bool;
        this.nmF.addFirst(Integer.valueOf(0));
        this.nmA = paramMotionEvent.getX();
        this.nmB = paramMotionEvent.getY();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, down, x: %f, y: %f, curTranslationY: %f", new Object[] { Float.valueOf(this.nmA), Float.valueOf(this.nmB), Float.valueOf(this.nmJ) });
        continue;
        int i = 0;
        if (this.nmF.isEmpty()) {
          Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, empty activePointerIds");
        }
        int j;
        for (;;)
        {
          int k = paramMotionEvent.findPointerIndex(i);
          j = k;
          if (k < 0)
          {
            Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, invalid pointerIndex");
            j = 0;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, activePointerId: %d, pointerIndex: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (paramMotionEvent.getY(j) >= this.nmq.getTranslationY()) {
            break label319;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, outside");
          bool = false;
          break;
          i = ((Integer)this.nmF.getFirst()).intValue();
        }
        label319:
        float f1 = Math.abs(paramMotionEvent.getX(j) - this.nmA);
        float f2 = paramMotionEvent.getY(j) - this.nmB;
        float f3 = Math.abs(f2);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f4 = Math.abs(this.mVelocityTracker.getXVelocity());
        float f5 = Math.abs(this.mVelocityTracker.getYVelocity());
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, disXFromDown: %f, rawDisYFromDown: %f, xVelocity: %f, yVelocity: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f5) });
        if ((f3 < 5.0F) || (f3 <= f1) || (f5 <= 0.0F) || (f5 <= f4)) {
          break label585;
        }
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, vertical, isShown: %b, isFullScreenShown: %b, isWebViewScroll2Top: %b", new Object[] { Boolean.valueOf(this.nmM), Boolean.valueOf(this.nmL), Boolean.valueOf(this.nmK) });
        if (!this.nmM) {
          break label585;
        }
        if (this.nmL)
        {
          if (0.0F > f2) {
            bool = false;
          } else {
            bool = this.nmK;
          }
        }
        else
        {
          if (0.0F <= f2) {
            break;
          }
          bool = true;
        }
      }
      bool = this.nmK;
    }
    label585:
    for (;;)
    {
      break;
      bool = false;
      this.nmF.clear();
      this.nmG = -1;
      this.nmH = 0.0F;
      this.nmI = false;
      break;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(227251);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
    case 6: 
      for (;;)
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(227251);
        return bool;
        this.nmF.addFirst(Integer.valueOf(0));
        this.nmC = paramMotionEvent.getX();
        this.nmD = paramMotionEvent.getY();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, down, x: %f, y: %f", new Object[] { Float.valueOf(this.nmC), Float.valueOf(this.nmD) });
        AppMethodBeat.o(227251);
        return true;
        i = paramMotionEvent.getActionIndex();
        j = paramMotionEvent.getPointerId(i);
        this.nmF.addFirst(Integer.valueOf(j));
        this.nmC = paramMotionEvent.getX(i);
        this.nmD = paramMotionEvent.getY(i);
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer down, pointerId: %d, x: %f, y: %f", new Object[] { Integer.valueOf(j), Float.valueOf(this.nmC), Float.valueOf(this.nmD) });
        continue;
        if (this.nmF.isEmpty()) {
          Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId not exist");
        }
        for (i = 0;; i = ((Integer)this.nmF.getFirst()).intValue())
        {
          int k = paramMotionEvent.findPointerIndex(i);
          j = k;
          if (k < 0)
          {
            Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, pointerIndex is illegal");
            j = 0;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, activePointerId: %d, pointerIndex: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((0.0F != this.nmC) || (0.0F != this.nmD)) {
            break label403;
          }
          this.nmF.addFirst(Integer.valueOf(0));
          this.nmC = paramMotionEvent.getX(j);
          this.nmD = paramMotionEvent.getY(j);
          break;
        }
        label403:
        if ((-1 != this.nmG) && (this.nmG != i))
        {
          this.nmH = this.nmE;
          Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId changed, disMoveFromDownExceptCurPointerId: " + this.nmH);
        }
        float f2 = paramMotionEvent.getX(j) - this.nmC;
        float f1 = paramMotionEvent.getY(j) - this.nmD + this.nmH;
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, rawDisXFromDown: %f, rawDisYFromDown: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
        if (Math.abs(f1) > Math.abs(f2))
        {
          if ((!this.nmI) || (0.0F <= f1)) {
            break label595;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, dispatchTouchEvent2Child");
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(227241);
              MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setAction(1);
              HybridOpenMaterialView.this.dispatchTouchEvent(localMotionEvent);
              localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setAction(0);
              HybridOpenMaterialView.this.dispatchTouchEvent(localMotionEvent);
              AppMethodBeat.o(227241);
            }
          });
        }
        label595:
        label766:
        for (;;)
        {
          this.nmE = f1;
          this.nmG = i;
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, lastActivePointerId: %d", new Object[] { Integer.valueOf(this.nmG) });
          break;
          if ((this.nmw) || (0.0F >= f1))
          {
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll");
            if (this.nmN) {
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, isAnimating");
            }
            for (;;)
            {
              if (this.nmy < this.nmq.getTranslationY()) {
                break label766;
              }
              this.nmI = true;
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, scroll to top, mayDispatchTouchEvent2Child");
              break;
              this.nmE = (0.68F * f1);
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, disMoveFromDown: %f, curWholeContentAreaTranslationY: %f", new Object[] { Float.valueOf(this.nmE), Float.valueOf(this.nmJ) });
              f2 = this.nmJ;
              float f3 = this.nmE;
              f2 = Math.max(this.nmy, f2 + f3);
              f2 = Math.min(this.nmx, f2);
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, newTranslationY: ".concat(String.valueOf(f2)));
              this.nmq.setTranslationY(f2);
              bQn();
            }
          }
        }
        i = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        this.nmF.remove(Integer.valueOf(i));
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer up, pointerId: %d", new Object[] { Integer.valueOf(i) });
      }
    }
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isFullScreenShown: " + this.nmL);
    if (this.nmN) {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isAnimating");
    }
    for (;;)
    {
      this.nmC = 0.0F;
      this.nmD = 0.0F;
      this.nmF.clear();
      this.nmG = -1;
      this.nmH = 0.0F;
      this.nmI = false;
      break;
      if (this.nmL)
      {
        if ((0.0F < this.nmE) && (0.15F * this.nmx <= Math.abs(this.nmE))) {}
        for (;;)
        {
          if ((i == 0) || (!this.nmw)) {
            break label950;
          }
          hide();
          break;
          i = 0;
        }
        label950:
        bQo();
      }
      else
      {
        if ((0.0F < this.nmE) && (0.15F * this.nmx <= Math.abs(this.nmE))) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (!this.nmw)) {
            break label1014;
          }
          hide();
          break;
        }
        label1014:
        if ((0.0F > this.nmE) && (0.05F * this.nmx <= Math.abs(this.nmE))) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label1065;
          }
          bQo();
          break;
        }
        label1065:
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2HalfScreen");
        d(this.nmq.getTranslationY(), this.nmz, false);
      }
    }
  }
  
  public void setAllowScroll2Hide(boolean paramBoolean)
  {
    this.nmw = paramBoolean;
  }
  
  public void setContentView(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(227246);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setContentView");
    this.nms.addView(paramMMWebView, -1, -1);
    paramMMWebView.a(new MMWebView.e()
    {
      public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        boolean bool = true;
        AppMethodBeat.i(227231);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onWebViewScrollChanged, l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        HybridOpenMaterialView localHybridOpenMaterialView = HybridOpenMaterialView.this;
        if (paramAnonymousInt2 == 0) {}
        for (;;)
        {
          HybridOpenMaterialView.a(localHybridOpenMaterialView, bool);
          AppMethodBeat.o(227231);
          return;
          bool = false;
        }
      }
    });
    this.nmt = paramMMWebView;
    AppMethodBeat.o(227246);
  }
  
  public void setListener(a parama)
  {
    this.nmv = parama;
  }
  
  public void setTitleView(View paramView)
  {
    AppMethodBeat.i(227245);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setTitleView");
    this.nmr.addView(paramView, -1, -1);
    AppMethodBeat.o(227245);
  }
  
  public final void show()
  {
    AppMethodBeat.i(227247);
    this.nmM = true;
    if (this.nmu) {}
    for (float f = this.nmy;; f = this.nmz)
    {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "show, from: %d, to: %d", new Object[] { Integer.valueOf(this.nmx), Integer.valueOf((int)f) });
      if (this.nmt != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nmt.getLayoutParams();
        if ((-1 != localLayoutParams.width) || (-1 != localLayoutParams.height))
        {
          localLayoutParams.width = -1;
          localLayoutParams.height = -1;
          this.nmt.setLayoutParams(localLayoutParams);
        }
        this.nmt.setBackgroundColor(getResources().getColor(2131099649));
      }
      this.nmq.setTranslationY(this.nmx);
      this.nmq.animate().translationY(f).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(227235);
          HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
          HybridOpenMaterialView.f(HybridOpenMaterialView.this);
          AppMethodBeat.o(227235);
        }
      }).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(227234);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          AppMethodBeat.o(227234);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(227233);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          HybridOpenMaterialView.c(HybridOpenMaterialView.this, HybridOpenMaterialView.d(HybridOpenMaterialView.this));
          AppMethodBeat.o(227233);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(227232);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "show, onAnimationStart");
          if (HybridOpenMaterialView.c(HybridOpenMaterialView.this) != null) {
            HybridOpenMaterialView.c(HybridOpenMaterialView.this);
          }
          AppMethodBeat.o(227232);
        }
      }).start();
      AppMethodBeat.o(227247);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bQd();
    
    public abstract void yH(int paramInt);
  }
  
  public static abstract class b
    implements HybridOpenMaterialView.a
  {
    public void bQd() {}
    
    public void yH(int paramInt) {}
  }
  
  static final class c
  {
    public final Size nmR;
    public final int nmS;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(227242);
      Point localPoint = au.az(paramContext);
      this.nmR = new Size(localPoint.x, localPoint.y);
      this.nmS = au.aD(paramContext);
      Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "ScreenInfo#<init>, navigationBarHeight: " + this.nmS);
      AppMethodBeat.o(227242);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView
 * JD-Core Version:    0.7.0.1
 */