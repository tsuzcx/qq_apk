package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  static final Handler handler;
  private static final boolean nw;
  private static final int[] nx;
  private List<Object<B>> callbacks;
  private final android.support.design.g.a nA;
  private Behavior nB;
  private final AccessibilityManager nC;
  final n.a nD;
  private final ViewGroup ny;
  protected final BaseTransientBottomBar.d nz;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      nw = bool;
      nx = new int[] { 2130969547 };
      handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public final boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            ((BaseTransientBottomBar)paramAnonymousMessage.obj).bU();
            return true;
          }
          ((BaseTransientBottomBar)paramAnonymousMessage.obj).H(paramAnonymousMessage.arg1);
          return true;
        }
      });
      return;
    }
  }
  
  private int bW()
  {
    int i = this.nz.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.nz.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin + i;
    }
    return i;
  }
  
  final void H(final int paramInt)
  {
    if ((bZ()) && (this.nz.getVisibility() == 0))
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { 0, bW() });
      localValueAnimator.setInterpolator(android.support.design.a.a.gL);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bY();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bM();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int nF = 0;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.nw) {
            u.s(BaseTransientBottomBar.this.nz, i - this.nF);
          }
          for (;;)
          {
            this.nF = i;
            return;
            BaseTransientBottomBar.this.nz.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
    }
    bY();
  }
  
  final void bU()
  {
    CoordinatorLayout.d locald;
    if (this.nz.getParent() == null)
    {
      localObject = this.nz.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.d))
      {
        locald = (CoordinatorLayout.d)localObject;
        if (this.nB != null) {
          break label131;
        }
      }
    }
    label131:
    for (Object localObject = new Behavior();; localObject = this.nB)
    {
      if ((localObject instanceof Behavior)) {
        Behavior.a((Behavior)localObject, this);
      }
      ((SwipeDismissBehavior)localObject).tU = new SwipeDismissBehavior.a()
      {
        public final void I(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 1: 
          case 2: 
            n.cV().b(BaseTransientBottomBar.this.nD);
            return;
          }
          n.cV().c(BaseTransientBottomBar.this.nD);
        }
        
        public final void onDismiss(View paramAnonymousView)
        {
          paramAnonymousView.setVisibility(8);
          ??? = BaseTransientBottomBar.this;
          paramAnonymousView = n.cV();
          n.a locala = ((BaseTransientBottomBar)???).nD;
          synchronized (paramAnonymousView.lock)
          {
            if (paramAnonymousView.e(locala)) {
              paramAnonymousView.a(paramAnonymousView.tJ);
            }
            while (!paramAnonymousView.f(locala)) {
              return;
            }
            paramAnonymousView.a(paramAnonymousView.tK);
          }
        }
      };
      locald.a((CoordinatorLayout.Behavior)localObject);
      locald.qG = 80;
      this.ny.addView(this.nz);
      this.nz.setOnAttachStateChangeListener(new BaseTransientBottomBar.b()
      {
        public final void ca()
        {
          BaseTransientBottomBar localBaseTransientBottomBar = BaseTransientBottomBar.this;
          if (n.cV().d(localBaseTransientBottomBar.nD)) {
            BaseTransientBottomBar.handler.post(new Runnable()
            {
              public final void run()
              {
                BaseTransientBottomBar.this.bY();
              }
            });
          }
        }
      });
      if (!u.az(this.nz)) {
        break label144;
      }
      if (!bZ()) {
        break;
      }
      bV();
      return;
    }
    bX();
    return;
    label144:
    this.nz.setOnLayoutChangeListener(new BaseTransientBottomBar.c()
    {
      public final void cb()
      {
        BaseTransientBottomBar.this.nz.setOnLayoutChangeListener(null);
        if (BaseTransientBottomBar.this.bZ())
        {
          BaseTransientBottomBar.this.bV();
          return;
        }
        BaseTransientBottomBar.this.bX();
      }
    });
  }
  
  final void bV()
  {
    final int i = bW();
    if (nw) {
      u.s(this.nz, i);
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { i, 0 });
      localValueAnimator.setInterpolator(android.support.design.a.a.gL);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.bX();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.a(BaseTransientBottomBar.this).bL();
        }
      });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int nF = i;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.nw) {
            u.s(BaseTransientBottomBar.this.nz, i - this.nF);
          }
          for (;;)
          {
            this.nF = i;
            return;
            BaseTransientBottomBar.this.nz.setTranslationY(i);
          }
        }
      });
      localValueAnimator.start();
      return;
      this.nz.setTranslationY(i);
    }
  }
  
  final void bX()
  {
    n.cV().a(this.nD);
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
  
  final void bY()
  {
    n localn = n.cV();
    n.a locala = this.nD;
    synchronized (localn.lock)
    {
      if (localn.e(locala))
      {
        localn.tJ = null;
        if ((localn.tK != null) && (localn.tK != null))
        {
          localn.tJ = localn.tK;
          localn.tK = null;
          if ((n.a)localn.tJ.tM.get() == null) {
            localn.tJ = null;
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
    ??? = this.nz.getParent();
    if ((??? instanceof ViewGroup)) {
      ((ViewGroup)???).removeView(this.nz);
    }
  }
  
  final boolean bZ()
  {
    List localList = this.nC.getEnabledAccessibilityServiceList(1);
    return (localList != null) && (localList.isEmpty());
  }
  
  public static class Behavior
    extends SwipeDismissBehavior<View>
  {
    private final BaseTransientBottomBar.a nI = new BaseTransientBottomBar.a(this);
    
    public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      BaseTransientBottomBar.a locala = this.nI;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return super.b(paramCoordinatorLayout, paramView, paramMotionEvent);
        if (paramCoordinatorLayout.d(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          n.cV().b(locala.nD);
          continue;
          n.cV().c(locala.nD);
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
    n.a nD;
    
    public a(SwipeDismissBehavior<?> paramSwipeDismissBehavior)
    {
      paramSwipeDismissBehavior.ua = SwipeDismissBehavior.u(0.1F);
      paramSwipeDismissBehavior.ub = SwipeDismissBehavior.u(0.6F);
      paramSwipeDismissBehavior.tY = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */