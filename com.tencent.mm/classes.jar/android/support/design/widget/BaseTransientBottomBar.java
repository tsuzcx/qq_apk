package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.a;
import android.support.v4.view.a.b.a;
import android.support.v4.view.a.b.b;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  static final Handler handler;
  private static final boolean nu;
  private static final int[] nv;
  private List<Object<B>> callbacks;
  private final AccessibilityManager nA;
  final n.a nB;
  private final ViewGroup nw;
  protected final d nx;
  private final android.support.design.g.a ny;
  private Behavior nz;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      nu = bool;
      nv = new int[] { 2130969462 };
      handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public final boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            ((BaseTransientBottomBar)paramAnonymousMessage.obj).bS();
            return true;
          }
          ((BaseTransientBottomBar)paramAnonymousMessage.obj).H(paramAnonymousMessage.arg1);
          return true;
        }
      });
      return;
    }
  }
  
  private int bU()
  {
    int i = this.nx.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.nx.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin + i;
    }
    return i;
  }
  
  final void H(final int paramInt)
  {
    if ((bX()) && (this.nx.getVisibility() == 0))
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { 0, bU() });
      localValueAnimator.setInterpolator(android.support.design.a.a.gJ);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bW();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bK();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int nD = 0;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.nu) {
            t.s(BaseTransientBottomBar.this.nx, i - this.nD);
          }
          for (;;)
          {
            this.nD = i;
            return;
            BaseTransientBottomBar.this.nx.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
    }
    bW();
  }
  
  final void bS()
  {
    CoordinatorLayout.d locald;
    if (this.nx.getParent() == null)
    {
      localObject = this.nx.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.d))
      {
        locald = (CoordinatorLayout.d)localObject;
        if (this.nz != null) {
          break label131;
        }
      }
    }
    label131:
    for (Object localObject = new Behavior();; localObject = this.nz)
    {
      if ((localObject instanceof Behavior)) {
        Behavior.a((Behavior)localObject, this);
      }
      ((SwipeDismissBehavior)localObject).tN = new SwipeDismissBehavior.a()
      {
        public final void I(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 1: 
          case 2: 
            n.cT().b(BaseTransientBottomBar.this.nB);
            return;
          }
          n.cT().c(BaseTransientBottomBar.this.nB);
        }
        
        public final void onDismiss(View paramAnonymousView)
        {
          paramAnonymousView.setVisibility(8);
          ??? = BaseTransientBottomBar.this;
          paramAnonymousView = n.cT();
          n.a locala = ((BaseTransientBottomBar)???).nB;
          synchronized (paramAnonymousView.lock)
          {
            if (paramAnonymousView.e(locala)) {
              paramAnonymousView.a(paramAnonymousView.tC);
            }
            while (!paramAnonymousView.f(locala)) {
              return;
            }
            paramAnonymousView.a(paramAnonymousView.tD);
          }
        }
      };
      locald.a((CoordinatorLayout.Behavior)localObject);
      locald.qE = 80;
      this.nw.addView(this.nx);
      this.nx.setOnAttachStateChangeListener(new b()
      {
        public final void bY()
        {
          BaseTransientBottomBar localBaseTransientBottomBar = BaseTransientBottomBar.this;
          if (n.cT().d(localBaseTransientBottomBar.nB)) {
            BaseTransientBottomBar.handler.post(new Runnable()
            {
              public final void run()
              {
                BaseTransientBottomBar.this.bW();
              }
            });
          }
        }
      });
      if (!t.ay(this.nx)) {
        break label144;
      }
      if (!bX()) {
        break;
      }
      bT();
      return;
    }
    bV();
    return;
    label144:
    this.nx.setOnLayoutChangeListener(new c()
    {
      public final void bZ()
      {
        BaseTransientBottomBar.this.nx.setOnLayoutChangeListener(null);
        if (BaseTransientBottomBar.this.bX())
        {
          BaseTransientBottomBar.this.bT();
          return;
        }
        BaseTransientBottomBar.this.bV();
      }
    });
  }
  
  final void bT()
  {
    final int i = bU();
    if (nu) {
      t.s(this.nx, i);
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { i, 0 });
      localValueAnimator.setInterpolator(android.support.design.a.a.gJ);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bV();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bJ();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int nD = i;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.nu) {
            t.s(BaseTransientBottomBar.this.nx, i - this.nD);
          }
          for (;;)
          {
            this.nD = i;
            return;
            BaseTransientBottomBar.this.nx.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
      this.nx.setTranslationY(i);
    }
  }
  
  final void bV()
  {
    n.cT().a(this.nB);
    if (this.callbacks != null)
    {
      int i = this.callbacks.size() - 1;
      while (i >= 0)
      {
        this.callbacks.get(i);
        i -= 1;
      }
    }
  }
  
  final void bW()
  {
    n localn = n.cT();
    n.a locala = this.nB;
    synchronized (localn.lock)
    {
      if (localn.e(locala))
      {
        localn.tC = null;
        if ((localn.tD != null) && (localn.tD != null))
        {
          localn.tC = localn.tD;
          localn.tD = null;
          if ((n.a)localn.tC.tF.get() == null) {
            localn.tC = null;
          }
        }
      }
      if (this.callbacks != null)
      {
        int i = this.callbacks.size() - 1;
        if (i >= 0)
        {
          this.callbacks.get(i);
          i -= 1;
        }
      }
    }
    ??? = this.nx.getParent();
    if ((??? instanceof ViewGroup)) {
      ((ViewGroup)???).removeView(this.nx);
    }
  }
  
  final boolean bX()
  {
    List localList = this.nA.getEnabledAccessibilityServiceList(1);
    return (localList != null) && (localList.isEmpty());
  }
  
  public static class Behavior
    extends SwipeDismissBehavior<View>
  {
    private final BaseTransientBottomBar.a nG = new BaseTransientBottomBar.a(this);
    
    public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      BaseTransientBottomBar.a locala = this.nG;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return super.b(paramCoordinatorLayout, paramView, paramMotionEvent);
        if (paramCoordinatorLayout.d(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          n.cT().b(locala.nB);
          continue;
          n.cT().c(locala.nB);
        }
      }
    }
    
    public final boolean j(View paramView)
    {
      return paramView instanceof BaseTransientBottomBar.d;
    }
  }
  
  public static final class a
  {
    n.a nB;
    
    public a(SwipeDismissBehavior<?> paramSwipeDismissBehavior)
    {
      paramSwipeDismissBehavior.tT = SwipeDismissBehavior.u(0.1F);
      paramSwipeDismissBehavior.tU = SwipeDismissBehavior.u(0.6F);
      paramSwipeDismissBehavior.tR = 0;
    }
  }
  
  protected static abstract interface b
  {
    public abstract void bY();
  }
  
  protected static abstract interface c
  {
    public abstract void bZ();
  }
  
  protected static class d
    extends FrameLayout
  {
    private final AccessibilityManager nA;
    private final b.a nH;
    private BaseTransientBottomBar.c nI;
    private BaseTransientBottomBar.b nJ;
    
    protected d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
      if (paramAttributeSet.hasValue(1)) {
        t.k(this, paramAttributeSet.getDimensionPixelSize(1, 0));
      }
      paramAttributeSet.recycle();
      this.nA = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
      this.nH = new b.a()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          BaseTransientBottomBar.d.a(BaseTransientBottomBar.d.this, paramAnonymousBoolean);
        }
      };
      paramContext = this.nA;
      paramAttributeSet = this.nH;
      if ((Build.VERSION.SDK_INT >= 19) && (paramAttributeSet != null)) {
        paramContext.addTouchExplorationStateChangeListener(new b.b(paramAttributeSet));
      }
      setClickableOrFocusableBasedOnAccessibility(this.nA.isTouchExplorationEnabled());
    }
    
    private void setClickableOrFocusableBasedOnAccessibility(boolean paramBoolean)
    {
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        setClickable(bool);
        setFocusable(paramBoolean);
        return;
      }
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      t.ap(this);
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (this.nJ != null) {
        this.nJ.bY();
      }
      AccessibilityManager localAccessibilityManager = this.nA;
      b.a locala = this.nH;
      if ((Build.VERSION.SDK_INT >= 19) && (locala != null)) {
        localAccessibilityManager.removeTouchExplorationStateChangeListener(new b.b(locala));
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.nI != null) {
        this.nI.bZ();
      }
    }
    
    void setOnAttachStateChangeListener(BaseTransientBottomBar.b paramb)
    {
      this.nJ = paramb;
    }
    
    void setOnLayoutChangeListener(BaseTransientBottomBar.c paramc)
    {
      this.nI = paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */