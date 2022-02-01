package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.mm.vending.e.a;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.LinkedList;

public class HybridOpenMaterialView
  extends RelativeLayout
  implements a
{
  private static final int tsD;
  private static final int tsE;
  private final VelocityTracker mVelocityTracker;
  LinearLayout tsF;
  private LinearLayout tsG;
  private FrameLayout tsH;
  MMWebView tsI;
  final boolean tsJ;
  private a tsK;
  private boolean tsL;
  int tsM;
  int tsN;
  int tsO;
  private float tsP;
  private float tsQ;
  private float tsR;
  private float tsS;
  private float tsT;
  private final LinkedList<Integer> tsU;
  private int tsV;
  private float tsW;
  private boolean tsX;
  private float tsY;
  private boolean tsZ;
  private boolean tta;
  boolean ttb;
  private boolean ttc;
  
  static
  {
    AppMethodBeat.i(323850);
    tsD = bd.bs(MMApplicationContext.getContext(), ba.d.Edge_8A);
    tsE = bd.bs(MMApplicationContext.getContext(), ba.d.Edge_3A);
    AppMethodBeat.o(323850);
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
    AppMethodBeat.i(323738);
    this.mVelocityTracker = VelocityTracker.obtain();
    this.tsK = null;
    this.tsL = true;
    this.tsM = 0;
    this.tsN = 0;
    this.tsO = 0;
    this.tsP = 0.0F;
    this.tsQ = 0.0F;
    this.tsR = 0.0F;
    this.tsS = 0.0F;
    this.tsT = 0.0F;
    this.tsU = new LinkedList();
    this.tsV = -1;
    this.tsW = 0.0F;
    this.tsX = false;
    this.tsY = 0.0F;
    this.tsZ = true;
    this.tta = false;
    this.ttb = false;
    this.ttc = false;
    LayoutInflater.from(paramContext).inflate(ba.g.open_material_hybrid_view, this, true);
    paramContext = findViewById(ba.f.open_material_outside_area);
    this.tsF = ((LinearLayout)findViewById(ba.f.open_material_content_area));
    this.tsG = ((LinearLayout)findViewById(ba.f.open_material_title_area));
    this.tsH = ((FrameLayout)findViewById(ba.f.open_material_content_container));
    setFitsSystemWindows(true);
    this.tsJ = isLandscape();
    paramContext.setOnClickListener(new HybridOpenMaterialView.1(this));
    this.tsG.setOnClickListener(new HybridOpenMaterialView.4(this));
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(323732);
        HybridOpenMaterialView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this);
        AppMethodBeat.o(323732);
      }
    });
    AppMethodBeat.o(323738);
  }
  
  private void cDA()
  {
    AppMethodBeat.i(323746);
    MMWebView localMMWebView = this.tsI;
    if (localMMWebView == null)
    {
      Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, contentArea is null");
      AppMethodBeat.o(323746);
      return;
    }
    int i = Math.max(0, (int)(localMMWebView.getHeight() - this.tsF.getTranslationY()));
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, visibleHeight: ".concat(String.valueOf(i)));
    if (this.tsK != null) {
      this.tsK.CB(i);
    }
    AppMethodBeat.o(323746);
  }
  
  private void cDB()
  {
    AppMethodBeat.i(323753);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2FullScreen");
    h(this.tsF.getTranslationY(), this.tsN, true);
    AppMethodBeat.o(323753);
  }
  
  private int getFullScreenTopRemainPx()
  {
    if (this.tsJ) {
      return tsE;
    }
    return tsD;
  }
  
  private void h(float paramFloat1, float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(323762);
    if (paramFloat2 == paramFloat1)
    {
      this.tta = paramBoolean;
      this.tsY = paramFloat2;
      AppMethodBeat.o(323762);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(323716);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        HybridOpenMaterialView.e(HybridOpenMaterialView.this).setTranslationY(f);
        HybridOpenMaterialView.f(HybridOpenMaterialView.this);
        AppMethodBeat.o(323716);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(323729);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
        AppMethodBeat.o(323729);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(323721);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
        HybridOpenMaterialView.c(HybridOpenMaterialView.this, paramBoolean);
        HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "animateSwitch, curWholeContentAreaTranslationY: " + HybridOpenMaterialView.g(HybridOpenMaterialView.this));
        AppMethodBeat.o(323721);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(323713);
        HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
        AppMethodBeat.o(323713);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(323762);
  }
  
  private boolean isLandscape()
  {
    boolean bool = false;
    AppMethodBeat.i(323773);
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
    AppMethodBeat.o(323773);
    return bool;
  }
  
  public void dead()
  {
    AppMethodBeat.i(323877);
    Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "dead");
    if (this.tsI != null) {
      this.tsI.destroy();
    }
    AppMethodBeat.o(323877);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(323866);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, from: %f, to: %d", new Object[] { Float.valueOf(this.tsF.getTranslationY()), Integer.valueOf(this.tsM) });
    this.ttb = false;
    ViewPropertyAnimator localViewPropertyAnimator = this.tsF.animate().translationY(this.tsM);
    if (this.tta) {}
    for (long l = 500L;; l = 300L)
    {
      localViewPropertyAnimator.setDuration(l).setInterpolator(new AccelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(323757);
          HybridOpenMaterialView.a(HybridOpenMaterialView.this, HybridOpenMaterialView.e(HybridOpenMaterialView.this).getTranslationY());
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, curWholeContentAreaTranslationY: %f", new Object[] { Float.valueOf(HybridOpenMaterialView.g(HybridOpenMaterialView.this)) });
          HybridOpenMaterialView.f(HybridOpenMaterialView.this);
          AppMethodBeat.o(323757);
        }
      }).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(323758);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          AppMethodBeat.o(323758);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(323745);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, false);
          HybridOpenMaterialView.c(HybridOpenMaterialView.this, false);
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, onAnimationEnd");
          h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(323768);
              if (HybridOpenMaterialView.c(HybridOpenMaterialView.this) != null) {
                HybridOpenMaterialView.c(HybridOpenMaterialView.this).onHidden();
              }
              AppMethodBeat.o(323768);
            }
          });
          AppMethodBeat.o(323745);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(323733);
          HybridOpenMaterialView.b(HybridOpenMaterialView.this, true);
          AppMethodBeat.o(323733);
        }
      }).start();
      AppMethodBeat.o(323866);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(323885);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, ev: " + paramMotionEvent.getAction());
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool)
    {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, super intercept");
      AppMethodBeat.o(323885);
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
        AppMethodBeat.o(323885);
        return bool;
        this.tsU.addFirst(Integer.valueOf(0));
        this.tsP = paramMotionEvent.getX();
        this.tsQ = paramMotionEvent.getY();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, down, x: %f, y: %f, curTranslationY: %f", new Object[] { Float.valueOf(this.tsP), Float.valueOf(this.tsQ), Float.valueOf(this.tsY) });
        continue;
        int i = 0;
        if (this.tsU.isEmpty()) {
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
          if (paramMotionEvent.getY(j) >= this.tsF.getTranslationY()) {
            break label329;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, outside");
          bool = false;
          break;
          i = ((Integer)this.tsU.getFirst()).intValue();
        }
        label329:
        float f1 = Math.abs(paramMotionEvent.getX(j) - this.tsP);
        float f2 = paramMotionEvent.getY(j) - this.tsQ;
        float f3 = Math.abs(f2);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f4 = Math.abs(this.mVelocityTracker.getXVelocity());
        float f5 = Math.abs(this.mVelocityTracker.getYVelocity());
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, disXFromDown: %f, rawDisYFromDown: %f, xVelocity: %f, yVelocity: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f5) });
        if ((f3 < 5.0F) || (f3 <= f1) || (f5 <= 0.0F) || (f5 <= f4)) {
          break label597;
        }
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, vertical, isShown: %b, isFullScreenShown: %b, isWebViewScroll2Top: %b", new Object[] { Boolean.valueOf(this.ttb), Boolean.valueOf(this.tta), Boolean.valueOf(this.tsZ) });
        if (!this.ttb) {
          break label597;
        }
        if (this.tta)
        {
          if (0.0F > f2) {
            bool = false;
          } else {
            bool = this.tsZ;
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
      bool = this.tsZ;
    }
    label597:
    for (;;)
    {
      break;
      bool = false;
      this.tsU.clear();
      this.tsV = -1;
      this.tsW = 0.0F;
      this.tsX = false;
      break;
    }
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(323896);
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
        AppMethodBeat.o(323896);
        return bool;
        this.tsU.addFirst(Integer.valueOf(0));
        this.tsR = paramMotionEvent.getX();
        this.tsS = paramMotionEvent.getY();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, down, x: %f, y: %f", new Object[] { Float.valueOf(this.tsR), Float.valueOf(this.tsS) });
        AppMethodBeat.o(323896);
        return true;
        i = paramMotionEvent.getActionIndex();
        j = paramMotionEvent.getPointerId(i);
        this.tsU.addFirst(Integer.valueOf(j));
        this.tsR = paramMotionEvent.getX(i);
        this.tsS = paramMotionEvent.getY(i);
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer down, pointerId: %d, x: %f, y: %f", new Object[] { Integer.valueOf(j), Float.valueOf(this.tsR), Float.valueOf(this.tsS) });
        continue;
        if (this.tsU.isEmpty()) {
          Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId not exist");
        }
        for (i = 0;; i = ((Integer)this.tsU.getFirst()).intValue())
        {
          int k = paramMotionEvent.findPointerIndex(i);
          j = k;
          if (k < 0)
          {
            Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, pointerIndex is illegal");
            j = 0;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, activePointerId: %d, pointerIndex: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((0.0F != this.tsR) || (0.0F != this.tsS)) {
            break label408;
          }
          this.tsU.addFirst(Integer.valueOf(0));
          this.tsR = paramMotionEvent.getX(j);
          this.tsS = paramMotionEvent.getY(j);
          break;
        }
        label408:
        if ((-1 != this.tsV) && (this.tsV != i))
        {
          this.tsW = this.tsT;
          Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId changed, disMoveFromDownExceptCurPointerId: " + this.tsW);
        }
        float f2 = paramMotionEvent.getX(j) - this.tsR;
        float f1 = paramMotionEvent.getY(j) - this.tsS + this.tsW;
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, rawDisXFromDown: %f, rawDisYFromDown: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
        if (Math.abs(f1) > Math.abs(f2))
        {
          if ((!this.tsX) || (0.0F <= f1)) {
            break label604;
          }
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, dispatchTouchEvent2Child");
          h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(323756);
              MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setAction(1);
              HybridOpenMaterialView.this.dispatchTouchEvent(localMotionEvent);
              localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setAction(0);
              HybridOpenMaterialView.this.dispatchTouchEvent(localMotionEvent);
              AppMethodBeat.o(323756);
            }
          });
        }
        label780:
        for (;;)
        {
          this.tsT = f1;
          this.tsV = i;
          Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, lastActivePointerId: %d", new Object[] { Integer.valueOf(this.tsV) });
          break;
          label604:
          if ((this.tsL) || (0.0F >= f1))
          {
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll");
            if (this.ttc) {
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, isAnimating");
            }
            for (;;)
            {
              if (this.tsN < this.tsF.getTranslationY()) {
                break label780;
              }
              this.tsX = true;
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, scroll to top, mayDispatchTouchEvent2Child");
              break;
              this.tsT = (0.68F * f1);
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, disMoveFromDown: %f, curWholeContentAreaTranslationY: %f", new Object[] { Float.valueOf(this.tsT), Float.valueOf(this.tsY) });
              f2 = this.tsY;
              float f3 = this.tsT;
              f2 = Math.max(this.tsN, f2 + f3);
              f2 = Math.min(this.tsM, f2);
              Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, newTranslationY: ".concat(String.valueOf(f2)));
              this.tsF.setTranslationY(f2);
              cDA();
            }
          }
        }
        i = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        this.tsU.remove(Integer.valueOf(i));
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer up, pointerId: %d", new Object[] { Integer.valueOf(i) });
      }
    }
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isFullScreenShown: " + this.tta);
    if (this.ttc) {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isAnimating");
    }
    for (;;)
    {
      this.tsR = 0.0F;
      this.tsS = 0.0F;
      this.tsU.clear();
      this.tsV = -1;
      this.tsW = 0.0F;
      this.tsX = false;
      break;
      if (this.tta)
      {
        if ((0.0F < this.tsT) && (0.15F * this.tsM <= Math.abs(this.tsT))) {}
        for (;;)
        {
          if ((i == 0) || (!this.tsL)) {
            break label967;
          }
          hide();
          break;
          i = 0;
        }
        label967:
        cDB();
      }
      else
      {
        if ((0.0F < this.tsT) && (0.15F * this.tsM <= Math.abs(this.tsT))) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (!this.tsL)) {
            break label1031;
          }
          hide();
          break;
        }
        label1031:
        if ((0.0F > this.tsT) && (0.05F * this.tsM <= Math.abs(this.tsT))) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label1082;
          }
          cDB();
          break;
        }
        label1082:
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2HalfScreen");
        h(this.tsF.getTranslationY(), this.tsO, false);
      }
    }
  }
  
  public void setAllowScroll2Hide(boolean paramBoolean)
  {
    this.tsL = paramBoolean;
  }
  
  public void setContentView(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(323855);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setContentView");
    this.tsH.addView(paramMMWebView, -1, -1);
    paramMMWebView.a(new MMWebView.f()
    {
      public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        boolean bool = true;
        AppMethodBeat.i(323728);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onWebViewScrollChanged, l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        HybridOpenMaterialView localHybridOpenMaterialView = HybridOpenMaterialView.this;
        if (paramAnonymousInt2 == 0) {}
        for (;;)
        {
          HybridOpenMaterialView.a(localHybridOpenMaterialView, bool);
          AppMethodBeat.o(323728);
          return;
          bool = false;
        }
      }
    });
    this.tsI = paramMMWebView;
    AppMethodBeat.o(323855);
  }
  
  public void setListener(a parama)
  {
    this.tsK = parama;
  }
  
  public void setTitleView(View paramView)
  {
    AppMethodBeat.i(323852);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setTitleView");
    this.tsG.addView(paramView, -1, -1);
    AppMethodBeat.o(323852);
  }
  
  public static abstract interface a
  {
    public abstract void CB(int paramInt);
    
    public abstract void onHidden();
  }
  
  public static abstract class b
    implements HybridOpenMaterialView.a
  {
    public void CB(int paramInt) {}
    
    public void onHidden() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView
 * JD-Core Version:    0.7.0.1
 */