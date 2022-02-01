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
  private static final boolean lB;
  private static final int[] lC;
  private List<Object<B>> callbacks;
  private final ViewGroup lD;
  protected final d lE;
  private final android.support.design.g.a lF;
  private Behavior lG;
  private final AccessibilityManager lH;
  final n.a lI;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      lB = bool;
      lC = new int[] { 2130969462 };
      handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public final boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            ((BaseTransientBottomBar)paramAnonymousMessage.obj).bD();
            return true;
          }
          ((BaseTransientBottomBar)paramAnonymousMessage.obj).H(paramAnonymousMessage.arg1);
          return true;
        }
      });
      return;
    }
  }
  
  private int bF()
  {
    int i = this.lE.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.lE.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin + i;
    }
    return i;
  }
  
  final void H(final int paramInt)
  {
    if ((bI()) && (this.lE.getVisibility() == 0))
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { 0, bF() });
      localValueAnimator.setInterpolator(android.support.design.a.a.eQ);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bH();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bv();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int lK = 0;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.lB) {
            t.s(BaseTransientBottomBar.this.lE, i - this.lK);
          }
          for (;;)
          {
            this.lK = i;
            return;
            BaseTransientBottomBar.this.lE.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
    }
    bH();
  }
  
  final void bD()
  {
    CoordinatorLayout.d locald;
    if (this.lE.getParent() == null)
    {
      localObject = this.lE.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.d))
      {
        locald = (CoordinatorLayout.d)localObject;
        if (this.lG != null) {
          break label131;
        }
      }
    }
    label131:
    for (Object localObject = new Behavior();; localObject = this.lG)
    {
      if ((localObject instanceof Behavior)) {
        Behavior.a((Behavior)localObject, this);
      }
      ((SwipeDismissBehavior)localObject).rU = new SwipeDismissBehavior.a()
      {
        public final void I(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 1: 
          case 2: 
            n.cD().b(BaseTransientBottomBar.this.lI);
            return;
          }
          n.cD().c(BaseTransientBottomBar.this.lI);
        }
        
        public final void onDismiss(View paramAnonymousView)
        {
          paramAnonymousView.setVisibility(8);
          ??? = BaseTransientBottomBar.this;
          paramAnonymousView = n.cD();
          n.a locala = ((BaseTransientBottomBar)???).lI;
          synchronized (paramAnonymousView.lock)
          {
            if (paramAnonymousView.e(locala)) {
              paramAnonymousView.a(paramAnonymousView.rI);
            }
            while (!paramAnonymousView.f(locala)) {
              return;
            }
            paramAnonymousView.a(paramAnonymousView.rJ);
          }
        }
      };
      locald.a((CoordinatorLayout.Behavior)localObject);
      locald.oL = 80;
      this.lD.addView(this.lE);
      this.lE.setOnAttachStateChangeListener(new b()
      {
        public final void bJ()
        {
          BaseTransientBottomBar localBaseTransientBottomBar = BaseTransientBottomBar.this;
          if (n.cD().d(localBaseTransientBottomBar.lI)) {
            BaseTransientBottomBar.handler.post(new Runnable()
            {
              public final void run()
              {
                BaseTransientBottomBar.this.bH();
              }
            });
          }
        }
      });
      if (!t.ay(this.lE)) {
        break label144;
      }
      if (!bI()) {
        break;
      }
      bE();
      return;
    }
    bG();
    return;
    label144:
    this.lE.setOnLayoutChangeListener(new c()
    {
      public final void bK()
      {
        BaseTransientBottomBar.this.lE.setOnLayoutChangeListener(null);
        if (BaseTransientBottomBar.this.bI())
        {
          BaseTransientBottomBar.this.bE();
          return;
        }
        BaseTransientBottomBar.this.bG();
      }
    });
  }
  
  final void bE()
  {
    final int i = bF();
    if (lB) {
      t.s(this.lE, i);
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { i, 0 });
      localValueAnimator.setInterpolator(android.support.design.a.a.eQ);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bG();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bu();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int lK = i;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.lB) {
            t.s(BaseTransientBottomBar.this.lE, i - this.lK);
          }
          for (;;)
          {
            this.lK = i;
            return;
            BaseTransientBottomBar.this.lE.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
      this.lE.setTranslationY(i);
    }
  }
  
  final void bG()
  {
    n.cD().a(this.lI);
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
  
  final void bH()
  {
    n localn = n.cD();
    n.a locala = this.lI;
    synchronized (localn.lock)
    {
      if (localn.e(locala))
      {
        localn.rI = null;
        if ((localn.rJ != null) && (localn.rJ != null))
        {
          localn.rI = localn.rJ;
          localn.rJ = null;
          if ((n.a)localn.rI.rL.get() == null) {
            localn.rI = null;
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
    ??? = this.lE.getParent();
    if ((??? instanceof ViewGroup)) {
      ((ViewGroup)???).removeView(this.lE);
    }
  }
  
  final boolean bI()
  {
    List localList = this.lH.getEnabledAccessibilityServiceList(1);
    return (localList != null) && (localList.isEmpty());
  }
  
  public static class Behavior
    extends SwipeDismissBehavior<View>
  {
    private final BaseTransientBottomBar.a lN = new BaseTransientBottomBar.a(this);
    
    public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      BaseTransientBottomBar.a locala = this.lN;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return super.b(paramCoordinatorLayout, paramView, paramMotionEvent);
        if (paramCoordinatorLayout.d(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          n.cD().b(locala.lI);
          continue;
          n.cD().c(locala.lI);
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
    n.a lI;
    
    public a(SwipeDismissBehavior<?> paramSwipeDismissBehavior)
    {
      paramSwipeDismissBehavior.sa = SwipeDismissBehavior.w(0.1F);
      paramSwipeDismissBehavior.sc = SwipeDismissBehavior.w(0.6F);
      paramSwipeDismissBehavior.rY = 0;
    }
  }
  
  protected static abstract interface b
  {
    public abstract void bJ();
  }
  
  protected static abstract interface c
  {
    public abstract void bK();
  }
  
  protected static class d
    extends FrameLayout
  {
    private final AccessibilityManager lH;
    private final b.a lO;
    private BaseTransientBottomBar.c lP;
    private BaseTransientBottomBar.b lQ;
    
    protected d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
      if (paramAttributeSet.hasValue(1)) {
        t.k(this, paramAttributeSet.getDimensionPixelSize(1, 0));
      }
      paramAttributeSet.recycle();
      this.lH = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
      this.lO = new b.a()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          BaseTransientBottomBar.d.a(BaseTransientBottomBar.d.this, paramAnonymousBoolean);
        }
      };
      paramContext = this.lH;
      paramAttributeSet = this.lO;
      if ((Build.VERSION.SDK_INT >= 19) && (paramAttributeSet != null)) {
        paramContext.addTouchExplorationStateChangeListener(new b.b(paramAttributeSet));
      }
      setClickableOrFocusableBasedOnAccessibility(this.lH.isTouchExplorationEnabled());
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
      if (this.lQ != null) {
        this.lQ.bJ();
      }
      AccessibilityManager localAccessibilityManager = this.lH;
      b.a locala = this.lO;
      if ((Build.VERSION.SDK_INT >= 19) && (locala != null)) {
        localAccessibilityManager.removeTouchExplorationStateChangeListener(new b.b(locala));
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.lP != null) {
        this.lP.bK();
      }
    }
    
    void setOnAttachStateChangeListener(BaseTransientBottomBar.b paramb)
    {
      this.lQ = paramb;
    }
    
    void setOnLayoutChangeListener(BaseTransientBottomBar.c paramc)
    {
      this.lP = paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */