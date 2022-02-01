package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.f;
import java.util.LinkedList;

public class HybridOpenMaterialView
  extends RelativeLayout
  implements com.tencent.mm.vending.e.a
{
  private static final int qnW;
  private static final int qnX;
  private final VelocityTracker mVelocityTracker;
  private LinearLayout qnY;
  private LinearLayout qnZ;
  private FrameLayout qoa;
  private MMWebView qob;
  private final boolean qoc;
  private a qod;
  private boolean qoe;
  private int qof;
  private int qog;
  private int qoh;
  private float qoi;
  private float qoj;
  private float qok;
  private float qol;
  private float qom;
  private final LinkedList<Integer> qon;
  private int qoo;
  private float qop;
  private boolean qoq;
  private float qor;
  private boolean qos;
  private boolean qot;
  private boolean qou;
  private boolean qov;
  
  static
  {
    AppMethodBeat.i(272753);
    qnW = aw.aZ(MMApplicationContext.getContext(), au.d.Edge_8A);
    qnX = aw.aZ(MMApplicationContext.getContext(), au.d.Edge_3A);
    AppMethodBeat.o(272753);
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
    AppMethodBeat.i(272727);
    this.mVelocityTracker = VelocityTracker.obtain();
    this.qod = null;
    this.qoe = true;
    this.qof = 0;
    this.qog = 0;
    this.qoh = 0;
    this.qoi = 0.0F;
    this.qoj = 0.0F;
    this.qok = 0.0F;
    this.qol = 0.0F;
    this.qom = 0.0F;
    this.qon = new LinkedList();
    this.qoo = -1;
    this.qop = 0.0F;
    this.qoq = false;
    this.qor = 0.0F;
    this.qos = true;
    this.qot = false;
    this.qou = false;
    this.qov = false;
    LayoutInflater.from(paramContext).inflate(au.g.open_material_hybrid_view, this, true);
    paramContext = findViewById(au.f.open_material_outside_area);
    this.qnY = ((LinearLayout)findViewById(au.f.open_material_content_area));
    this.qnZ = ((LinearLayout)findViewById(au.f.open_material_title_area));
    this.qoa = ((FrameLayout)findViewById(au.f.open_material_content_container));
    setFitsSystemWindows(true);
    this.qoc = isLandscape();
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(261393);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "init, touch outside");
        if (HybridOpenMaterialView.a(HybridOpenMaterialView.this)) {
          HybridOpenMaterialView.this.hide();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(261393);
      }
    });
    this.qnZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(271668);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271668);
      }
    });
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(277333);
        HybridOpenMaterialView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this);
        AppMethodBeat.o(277333);
      }
    });
    AppMethodBeat.o(272727);
  }
  
  private void cdd()
  {
    AppMethodBeat.i(272743);
    MMWebView localMMWebView = this.qob;
    if (localMMWebView == null)
    {
      Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, contentArea is null");
      AppMethodBeat.o(272743);
      return;
    }
    int i = Math.max(0, (int)(localMMWebView.getHeight() - this.qnY.getTranslationY()));
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, visibleHeight: ".concat(String.valueOf(i)));
    if (this.qod != null) {
      this.qod.Cm(i);
    }
    AppMethodBeat.o(272743);
  }
  
  private void cde()
  {
    AppMethodBeat.i(272745);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2FullScreen");
    d(this.qnY.getTranslationY(), this.qog, true);
    AppMethodBeat.o(272745);
  }
  
  private void d(float paramFloat1, float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(272746);
    if (paramFloat2 == paramFloat1)
    {
      this.qot = paramBoolean;
      this.qor = paramFloat2;
      AppMethodBeat.o(272746);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(275757);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        HybridOpenMaterialView.e(HybridOpenMaterialView.this).setTranslationY(f);
        HybridOpenMaterialView.f(HybridOpenMaterialView.this);
        AppMethodBeat.o(275757);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(280501);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
        AppMethodBeat.o(280501);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(280500);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
        HybridOpenMaterialView.c(HybridOpenMaterialView.this, paramBoolean);
        HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "animateSwitch, curWholeContentAreaTranslationY: " + HybridOpenMaterialView.g(HybridOpenMaterialView.this));
        AppMethodBeat.o(280500);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(280499);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
        AppMethodBeat.o(280499);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(272746);
  }
  
  private int getFullScreenTopRemainPx()
  {
    if (this.qoc) {
      return qnX;
    }
    return qnW;
  }
  
  private boolean isLandscape()
  {
    boolean bool = false;
    AppMethodBeat.i(272747);
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
    AppMethodBeat.o(272747);
    return bool;
  }
  
  public final ViewGroup.LayoutParams cdc()
  {
    AppMethodBeat.i(272729);
    if (this.qoc)
    {
      localObject = new Rect();
      getWindowVisibleDisplayFrame((Rect)localObject);
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "generateMyLayoutParams, windowVisibleRect: ".concat(String.valueOf(localObject)));
      localObject = new ViewGroup.LayoutParams((int)(((Rect)localObject).right * 1.0F / 2.0F), -1);
      AppMethodBeat.o(272729);
      return localObject;
    }
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    AppMethodBeat.o(272729);
    return localObject;
  }
  
  public void dead()
  {
    AppMethodBeat.i(272736);
    Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "dead");
    if (this.qob != null) {
      this.qob.destroy();
    }
    AppMethodBeat.o(272736);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(272733);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, from: %f, to: %d", new Object[] { Float.valueOf(this.qnY.getTranslationY()), Integer.valueOf(this.qof) });
    this.qou = false;
    ViewPropertyAnimator localViewPropertyAnimator = this.qnY.animate().translationY(this.qof);
    if (this.qot) {}
    for (long l = 500L;; l = 300L)
    {
      localViewPropertyAnimator.setDuration(l).setInterpolator(new AccelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(275378);
          HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, curWholeContentAreaTranslationY: %f", new Object[] { Float.valueOf(HybridOpenMaterialView.g(HybridOpenMaterialView.this)) });
          HybridOpenMaterialView.f(HybridOpenMaterialView.this);
          AppMethodBeat.o(275378);
        }
      }).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(281519);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          AppMethodBeat.o(281519);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(281518);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          HybridOpenMaterialView.c(HybridOpenMaterialView.this, false);
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, onAnimationEnd");
          h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276882);
              if (HybridOpenMaterialView.c(HybridOpenMaterialView.this) != null) {
                HybridOpenMaterialView.c(HybridOpenMaterialView.this).ccP();
              }
              AppMethodBeat.o(276882);
            }
          });
          AppMethodBeat.o(281518);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(281517);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
          AppMethodBeat.o(281517);
        }
      }).start();
      AppMethodBeat.o(272733);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(272738);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, ev: " + paramMotionEvent.getAction());
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool)
    {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, super intercept");
      AppMethodBeat.o(272738);
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
        AppMethodBeat.o(272738);
        return bool;
        this.qon.addFirst(Integer.valueOf(0));
        this.qoi = paramMotionEvent.getX();
        this.qoj = paramMotionEvent.getY();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, down, x: %f, y: %f, curTranslationY: %f", new Object[] { Float.valueOf(this.qoi), Float.valueOf(this.qoj), Float.valueOf(this.qor) });
        continue;
        int i = 0;
        if (this.qon.isEmpty()) {
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
          if (paramMotionEvent.getY(j) >= this.qnY.getTranslationY()) {
            break label329;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, outside");
          bool = false;
          break;
          i = ((Integer)this.qon.getFirst()).intValue();
        }
        label329:
        float f1 = Math.abs(paramMotionEvent.getX(j) - this.qoi);
        float f2 = paramMotionEvent.getY(j) - this.qoj;
        float f3 = Math.abs(f2);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f4 = Math.abs(this.mVelocityTracker.getXVelocity());
        float f5 = Math.abs(this.mVelocityTracker.getYVelocity());
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, disXFromDown: %f, rawDisYFromDown: %f, xVelocity: %f, yVelocity: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f5) });
        if ((f3 < 5.0F) || (f3 <= f1) || (f5 <= 0.0F) || (f5 <= f4)) {
          break label597;
        }
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, vertical, isShown: %b, isFullScreenShown: %b, isWebViewScroll2Top: %b", new Object[] { Boolean.valueOf(this.qou), Boolean.valueOf(this.qot), Boolean.valueOf(this.qos) });
        if (!this.qou) {
          break label597;
        }
        if (this.qot)
        {
          if (0.0F > f2) {
            bool = false;
          } else {
            bool = this.qos;
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
      bool = this.qos;
    }
    label597:
    for (;;)
    {
      break;
      bool = false;
      this.qon.clear();
      this.qoo = -1;
      this.qop = 0.0F;
      this.qoq = false;
      break;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(272741);
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
        AppMethodBeat.o(272741);
        return bool;
        this.qon.addFirst(Integer.valueOf(0));
        this.qok = paramMotionEvent.getX();
        this.qol = paramMotionEvent.getY();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, down, x: %f, y: %f", new Object[] { Float.valueOf(this.qok), Float.valueOf(this.qol) });
        AppMethodBeat.o(272741);
        return true;
        i = paramMotionEvent.getActionIndex();
        j = paramMotionEvent.getPointerId(i);
        this.qon.addFirst(Integer.valueOf(j));
        this.qok = paramMotionEvent.getX(i);
        this.qol = paramMotionEvent.getY(i);
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer down, pointerId: %d, x: %f, y: %f", new Object[] { Integer.valueOf(j), Float.valueOf(this.qok), Float.valueOf(this.qol) });
        continue;
        if (this.qon.isEmpty()) {
          Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId not exist");
        }
        for (i = 0;; i = ((Integer)this.qon.getFirst()).intValue())
        {
          int k = paramMotionEvent.findPointerIndex(i);
          j = k;
          if (k < 0)
          {
            Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, pointerIndex is illegal");
            j = 0;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, activePointerId: %d, pointerIndex: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((0.0F != this.qok) || (0.0F != this.qol)) {
            break label408;
          }
          this.qon.addFirst(Integer.valueOf(0));
          this.qok = paramMotionEvent.getX(j);
          this.qol = paramMotionEvent.getY(j);
          break;
        }
        label408:
        if ((-1 != this.qoo) && (this.qoo != i))
        {
          this.qop = this.qom;
          Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId changed, disMoveFromDownExceptCurPointerId: " + this.qop);
        }
        float f2 = paramMotionEvent.getX(j) - this.qok;
        float f1 = paramMotionEvent.getY(j) - this.qol + this.qop;
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, rawDisXFromDown: %f, rawDisYFromDown: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
        if (Math.abs(f1) > Math.abs(f2))
        {
          if ((!this.qoq) || (0.0F <= f1)) {
            break label604;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, dispatchTouchEvent2Child");
          h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(281405);
              MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setAction(1);
              HybridOpenMaterialView.this.dispatchTouchEvent(localMotionEvent);
              localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setAction(0);
              HybridOpenMaterialView.this.dispatchTouchEvent(localMotionEvent);
              AppMethodBeat.o(281405);
            }
          });
        }
        label780:
        for (;;)
        {
          this.qom = f1;
          this.qoo = i;
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, lastActivePointerId: %d", new Object[] { Integer.valueOf(this.qoo) });
          break;
          label604:
          if ((this.qoe) || (0.0F >= f1))
          {
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll");
            if (this.qov) {
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, isAnimating");
            }
            for (;;)
            {
              if (this.qog < this.qnY.getTranslationY()) {
                break label780;
              }
              this.qoq = true;
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, scroll to top, mayDispatchTouchEvent2Child");
              break;
              this.qom = (0.68F * f1);
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, disMoveFromDown: %f, curWholeContentAreaTranslationY: %f", new Object[] { Float.valueOf(this.qom), Float.valueOf(this.qor) });
              f2 = this.qor;
              float f3 = this.qom;
              f2 = Math.max(this.qog, f2 + f3);
              f2 = Math.min(this.qof, f2);
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, newTranslationY: ".concat(String.valueOf(f2)));
              this.qnY.setTranslationY(f2);
              cdd();
            }
          }
        }
        i = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        this.qon.remove(Integer.valueOf(i));
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer up, pointerId: %d", new Object[] { Integer.valueOf(i) });
      }
    }
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isFullScreenShown: " + this.qot);
    if (this.qov) {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isAnimating");
    }
    for (;;)
    {
      this.qok = 0.0F;
      this.qol = 0.0F;
      this.qon.clear();
      this.qoo = -1;
      this.qop = 0.0F;
      this.qoq = false;
      break;
      if (this.qot)
      {
        if ((0.0F < this.qom) && (0.15F * this.qof <= Math.abs(this.qom))) {}
        for (;;)
        {
          if ((i == 0) || (!this.qoe)) {
            break label967;
          }
          hide();
          break;
          i = 0;
        }
        label967:
        cde();
      }
      else
      {
        if ((0.0F < this.qom) && (0.15F * this.qof <= Math.abs(this.qom))) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (!this.qoe)) {
            break label1031;
          }
          hide();
          break;
        }
        label1031:
        if ((0.0F > this.qom) && (0.05F * this.qof <= Math.abs(this.qom))) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label1082;
          }
          cde();
          break;
        }
        label1082:
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2HalfScreen");
        d(this.qnY.getTranslationY(), this.qoh, false);
      }
    }
  }
  
  public void setAllowScroll2Hide(boolean paramBoolean)
  {
    this.qoe = paramBoolean;
  }
  
  public void setContentView(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(272731);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setContentView");
    this.qoa.addView(paramMMWebView, -1, -1);
    paramMMWebView.a(new MMWebView.f()
    {
      public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        boolean bool = true;
        AppMethodBeat.i(272117);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onWebViewScrollChanged, l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        HybridOpenMaterialView localHybridOpenMaterialView = HybridOpenMaterialView.this;
        if (paramAnonymousInt2 == 0) {}
        for (;;)
        {
          HybridOpenMaterialView.a(localHybridOpenMaterialView, bool);
          AppMethodBeat.o(272117);
          return;
          bool = false;
        }
      }
    });
    this.qob = paramMMWebView;
    AppMethodBeat.o(272731);
  }
  
  public void setListener(a parama)
  {
    this.qod = parama;
  }
  
  public void setTitleView(View paramView)
  {
    AppMethodBeat.i(272730);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setTitleView");
    this.qnZ.addView(paramView, -1, -1);
    AppMethodBeat.o(272730);
  }
  
  public final void show()
  {
    AppMethodBeat.i(272732);
    this.qou = true;
    if (this.qoc) {}
    for (float f = this.qog;; f = this.qoh)
    {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "show, from: %d, to: %d", new Object[] { Integer.valueOf(this.qof), Integer.valueOf((int)f) });
      if (this.qob != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qob.getLayoutParams();
        if ((-1 != localLayoutParams.width) || (-1 != localLayoutParams.height))
        {
          localLayoutParams.width = -1;
          localLayoutParams.height = -1;
          this.qob.setLayoutParams(localLayoutParams);
        }
        this.qob.setBackgroundColor(getResources().getColor(au.c.BG_1));
      }
      this.qnY.setTranslationY(this.qof);
      this.qnY.animate().translationY(f).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(260649);
          HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
          HybridOpenMaterialView.f(HybridOpenMaterialView.this);
          AppMethodBeat.o(260649);
        }
      }).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(264355);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          AppMethodBeat.o(264355);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(264354);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          HybridOpenMaterialView.c(HybridOpenMaterialView.this, HybridOpenMaterialView.d(HybridOpenMaterialView.this));
          AppMethodBeat.o(264354);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(264353);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "show, onAnimationStart");
          if (HybridOpenMaterialView.c(HybridOpenMaterialView.this) != null) {
            HybridOpenMaterialView.c(HybridOpenMaterialView.this);
          }
          AppMethodBeat.o(264353);
        }
      }).start();
      AppMethodBeat.o(272732);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Cm(int paramInt);
    
    public abstract void ccP();
  }
  
  public static abstract class b
    implements HybridOpenMaterialView.a
  {
    public void Cm(int paramInt) {}
    
    public void ccP() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView
 * JD-Core Version:    0.7.0.1
 */