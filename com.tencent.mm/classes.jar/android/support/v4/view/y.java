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

public final class y
{
  private WeakReference<View> Rd;
  Runnable Re = null;
  Runnable Rf = null;
  int Rg = -1;
  
  y(View paramView)
  {
    this.Rd = new WeakReference(paramView);
  }
  
  private void a(final View paramView, final z paramz)
  {
    if (paramz != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          paramz.aK(paramView);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramz.aJ(paramView);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramz.aI(paramView);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public final y A(float paramFloat)
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().scaleX(paramFloat);
    }
    return this;
  }
  
  public final y B(float paramFloat)
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().scaleY(paramFloat);
    }
    return this;
  }
  
  public final y a(final ab paramab)
  {
    final View localView = (View)this.Rd.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 19))
    {
      ValueAnimator.AnimatorUpdateListener local2 = null;
      if (paramab != null) {
        local2 = new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramab.fH();
          }
        };
      }
      localView.animate().setUpdateListener(local2);
    }
    return this;
  }
  
  public final y a(z paramz)
  {
    View localView = (View)this.Rd.get();
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        a(localView, paramz);
      }
    }
    else {
      return this;
    }
    localView.setTag(2113929216, paramz);
    a(localView, new a(this));
    return this;
  }
  
  public final y a(Interpolator paramInterpolator)
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public final void cancel()
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public final long getDuration()
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      return localView.animate().getDuration();
    }
    return 0L;
  }
  
  public final y j(long paramLong)
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public final y k(long paramLong)
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().setStartDelay(paramLong);
    }
    return this;
  }
  
  public final void start()
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
  
  public final y y(float paramFloat)
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public final y z(float paramFloat)
  {
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  static final class a
    implements z
  {
    y Rk;
    boolean Rl;
    
    a(y paramy)
    {
      this.Rk = paramy;
    }
    
    public final void aI(View paramView)
    {
      this.Rl = false;
      if (this.Rk.Rg >= 0) {
        paramView.setLayerType(2, null);
      }
      if (this.Rk.Re != null)
      {
        localObject = this.Rk.Re;
        this.Rk.Re = null;
        ((Runnable)localObject).run();
      }
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof z)) {}
      for (localObject = (z)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((z)localObject).aI(paramView);
        }
        return;
      }
    }
    
    public final void aJ(View paramView)
    {
      if (this.Rk.Rg >= 0)
      {
        paramView.setLayerType(this.Rk.Rg, null);
        this.Rk.Rg = -1;
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!this.Rl))
      {
        if (this.Rk.Rf != null)
        {
          localObject = this.Rk.Rf;
          this.Rk.Rf = null;
          ((Runnable)localObject).run();
        }
        localObject = paramView.getTag(2113929216);
        if (!(localObject instanceof z)) {
          break label113;
        }
      }
      label113:
      for (Object localObject = (z)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((z)localObject).aJ(paramView);
        }
        this.Rl = true;
        return;
      }
    }
    
    public final void aK(View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof z)) {}
      for (localObject = (z)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((z)localObject).aK(paramView);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.y
 * JD-Core Version:    0.7.0.1
 */