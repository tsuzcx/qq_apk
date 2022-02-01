package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class x
{
  private WeakReference<View> Oe;
  Runnable Of = null;
  Runnable Og = null;
  int Oh = -1;
  
  x(View paramView)
  {
    this.Oe = new WeakReference(paramView);
  }
  
  private void a(final View paramView, final y paramy)
  {
    if (paramy != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          paramy.aJ(paramView);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramy.aI(paramView);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramy.aH(paramView);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public final x a(final aa paramaa)
  {
    final View localView = (View)this.Oe.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 19))
    {
      ValueAnimator.AnimatorUpdateListener local2 = null;
      if (paramaa != null) {
        local2 = new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramaa.fb();
          }
        };
      }
      localView.animate().setUpdateListener(local2);
    }
    return this;
  }
  
  public final x a(y paramy)
  {
    View localView = (View)this.Oe.get();
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        a(localView, paramy);
      }
    }
    else {
      return this;
    }
    localView.setTag(2113929216, paramy);
    a(localView, new a(this));
    return this;
  }
  
  public final x a(Interpolator paramInterpolator)
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public final void cancel()
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public final long getDuration()
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      return localView.animate().getDuration();
    }
    return 0L;
  }
  
  public final x h(long paramLong)
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public final x i(long paramLong)
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().setStartDelay(paramLong);
    }
    return this;
  }
  
  public final void start()
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
  
  public final x w(float paramFloat)
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public final x x(float paramFloat)
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  public final x y(float paramFloat)
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().scaleX(paramFloat);
    }
    return this;
  }
  
  public final x z(float paramFloat)
  {
    View localView = (View)this.Oe.get();
    if (localView != null) {
      localView.animate().scaleY(paramFloat);
    }
    return this;
  }
  
  static final class a
    implements y
  {
    x Ol;
    boolean Om;
    
    a(x paramx)
    {
      this.Ol = paramx;
    }
    
    public final void aH(View paramView)
    {
      this.Om = false;
      if (this.Ol.Oh >= 0) {
        paramView.setLayerType(2, null);
      }
      if (this.Ol.Of != null)
      {
        localObject = this.Ol.Of;
        this.Ol.Of = null;
        ((Runnable)localObject).run();
      }
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof y)) {}
      for (localObject = (y)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((y)localObject).aH(paramView);
        }
        return;
      }
    }
    
    public final void aI(View paramView)
    {
      if (this.Ol.Oh >= 0)
      {
        paramView.setLayerType(this.Ol.Oh, null);
        this.Ol.Oh = -1;
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!this.Om))
      {
        if (this.Ol.Og != null)
        {
          localObject = this.Ol.Og;
          this.Ol.Og = null;
          ((Runnable)localObject).run();
        }
        localObject = paramView.getTag(2113929216);
        if (!(localObject instanceof y)) {
          break label113;
        }
      }
      label113:
      for (Object localObject = (y)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((y)localObject).aI(paramView);
        }
        this.Om = true;
        return;
      }
    }
    
    public final void aJ(View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof y)) {}
      for (localObject = (y)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((y)localObject).aJ(paramView);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.x
 * JD-Core Version:    0.7.0.1
 */