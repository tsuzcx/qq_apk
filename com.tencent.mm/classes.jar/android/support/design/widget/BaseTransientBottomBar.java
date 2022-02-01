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
  private static final boolean kC;
  private static final int[] kD;
  private List<Object<B>> callbacks;
  private final ViewGroup kE;
  protected final d kF;
  private final android.support.design.g.a kG;
  private Behavior kH;
  private final AccessibilityManager kI;
  final n.a kJ;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      kC = bool;
      kD = new int[] { 2130969462 };
      handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public final boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            ((BaseTransientBottomBar)paramAnonymousMessage.obj).bw();
            return true;
          }
          ((BaseTransientBottomBar)paramAnonymousMessage.obj).H(paramAnonymousMessage.arg1);
          return true;
        }
      });
      return;
    }
  }
  
  private int by()
  {
    int i = this.kF.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.kF.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin + i;
    }
    return i;
  }
  
  final void H(final int paramInt)
  {
    if ((bB()) && (this.kF.getVisibility() == 0))
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { 0, by() });
      localValueAnimator.setInterpolator(android.support.design.a.a.dQ);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bA();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bo();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int kL = 0;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.kC) {
            t.s(BaseTransientBottomBar.this.kF, i - this.kL);
          }
          for (;;)
          {
            this.kL = i;
            return;
            BaseTransientBottomBar.this.kF.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
    }
    bA();
  }
  
  final void bA()
  {
    n localn = n.cw();
    n.a locala = this.kJ;
    synchronized (localn.lock)
    {
      if (localn.e(locala))
      {
        localn.qI = null;
        if ((localn.qJ != null) && (localn.qJ != null))
        {
          localn.qI = localn.qJ;
          localn.qJ = null;
          if ((n.a)localn.qI.qL.get() == null) {
            localn.qI = null;
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
    ??? = this.kF.getParent();
    if ((??? instanceof ViewGroup)) {
      ((ViewGroup)???).removeView(this.kF);
    }
  }
  
  final boolean bB()
  {
    List localList = this.kI.getEnabledAccessibilityServiceList(1);
    return (localList != null) && (localList.isEmpty());
  }
  
  final void bw()
  {
    CoordinatorLayout.d locald;
    if (this.kF.getParent() == null)
    {
      localObject = this.kF.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.d))
      {
        locald = (CoordinatorLayout.d)localObject;
        if (this.kH != null) {
          break label131;
        }
      }
    }
    label131:
    for (Object localObject = new Behavior();; localObject = this.kH)
    {
      if ((localObject instanceof Behavior)) {
        Behavior.a((Behavior)localObject, this);
      }
      ((SwipeDismissBehavior)localObject).qU = new SwipeDismissBehavior.a()
      {
        public final void I(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 1: 
          case 2: 
            n.cw().b(BaseTransientBottomBar.this.kJ);
            return;
          }
          n.cw().c(BaseTransientBottomBar.this.kJ);
        }
        
        public final void onDismiss(View paramAnonymousView)
        {
          paramAnonymousView.setVisibility(8);
          ??? = BaseTransientBottomBar.this;
          paramAnonymousView = n.cw();
          n.a locala = ((BaseTransientBottomBar)???).kJ;
          synchronized (paramAnonymousView.lock)
          {
            if (paramAnonymousView.e(locala)) {
              paramAnonymousView.a(paramAnonymousView.qI);
            }
            while (!paramAnonymousView.f(locala)) {
              return;
            }
            paramAnonymousView.a(paramAnonymousView.qJ);
          }
        }
      };
      locald.a((CoordinatorLayout.Behavior)localObject);
      locald.nK = 80;
      this.kE.addView(this.kF);
      this.kF.setOnAttachStateChangeListener(new b()
      {
        public final void bC()
        {
          BaseTransientBottomBar localBaseTransientBottomBar = BaseTransientBottomBar.this;
          if (n.cw().d(localBaseTransientBottomBar.kJ)) {
            BaseTransientBottomBar.handler.post(new Runnable()
            {
              public final void run()
              {
                BaseTransientBottomBar.this.bA();
              }
            });
          }
        }
      });
      if (!t.ay(this.kF)) {
        break label144;
      }
      if (!bB()) {
        break;
      }
      bx();
      return;
    }
    bz();
    return;
    label144:
    this.kF.setOnLayoutChangeListener(new c()
    {
      public final void bD()
      {
        BaseTransientBottomBar.this.kF.setOnLayoutChangeListener(null);
        if (BaseTransientBottomBar.this.bB())
        {
          BaseTransientBottomBar.this.bx();
          return;
        }
        BaseTransientBottomBar.this.bz();
      }
    });
  }
  
  final void bx()
  {
    final int i = by();
    if (kC) {
      t.s(this.kF, i);
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { i, 0 });
      localValueAnimator.setInterpolator(android.support.design.a.a.dQ);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bz();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bn();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int kL = i;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.kC) {
            t.s(BaseTransientBottomBar.this.kF, i - this.kL);
          }
          for (;;)
          {
            this.kL = i;
            return;
            BaseTransientBottomBar.this.kF.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
      this.kF.setTranslationY(i);
    }
  }
  
  final void bz()
  {
    n.cw().a(this.kJ);
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
  
  public static class Behavior
    extends SwipeDismissBehavior<View>
  {
    private final BaseTransientBottomBar.a kO = new BaseTransientBottomBar.a(this);
    
    public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      BaseTransientBottomBar.a locala = this.kO;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return super.b(paramCoordinatorLayout, paramView, paramMotionEvent);
        if (paramCoordinatorLayout.d(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          n.cw().b(locala.kJ);
          continue;
          n.cw().c(locala.kJ);
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
    n.a kJ;
    
    public a(SwipeDismissBehavior<?> paramSwipeDismissBehavior)
    {
      paramSwipeDismissBehavior.ra = SwipeDismissBehavior.s(0.1F);
      paramSwipeDismissBehavior.rb = SwipeDismissBehavior.s(0.6F);
      paramSwipeDismissBehavior.qY = 0;
    }
  }
  
  protected static abstract interface b
  {
    public abstract void bC();
  }
  
  protected static abstract interface c
  {
    public abstract void bD();
  }
  
  protected static class d
    extends FrameLayout
  {
    private final AccessibilityManager kI;
    private final b.a kP;
    private BaseTransientBottomBar.c kQ;
    private BaseTransientBottomBar.b kR;
    
    protected d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
      if (paramAttributeSet.hasValue(1)) {
        t.k(this, paramAttributeSet.getDimensionPixelSize(1, 0));
      }
      paramAttributeSet.recycle();
      this.kI = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
      this.kP = new b.a()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          BaseTransientBottomBar.d.a(BaseTransientBottomBar.d.this, paramAnonymousBoolean);
        }
      };
      paramContext = this.kI;
      paramAttributeSet = this.kP;
      if ((Build.VERSION.SDK_INT >= 19) && (paramAttributeSet != null)) {
        paramContext.addTouchExplorationStateChangeListener(new b.b(paramAttributeSet));
      }
      setClickableOrFocusableBasedOnAccessibility(this.kI.isTouchExplorationEnabled());
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
      if (this.kR != null) {
        this.kR.bC();
      }
      AccessibilityManager localAccessibilityManager = this.kI;
      b.a locala = this.kP;
      if ((Build.VERSION.SDK_INT >= 19) && (locala != null)) {
        localAccessibilityManager.removeTouchExplorationStateChangeListener(new b.b(locala));
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.kQ != null) {
        this.kQ.bD();
      }
    }
    
    void setOnAttachStateChangeListener(BaseTransientBottomBar.b paramb)
    {
      this.kR = paramb;
    }
    
    void setOnLayoutChangeListener(BaseTransientBottomBar.c paramc)
    {
      this.kQ = paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */