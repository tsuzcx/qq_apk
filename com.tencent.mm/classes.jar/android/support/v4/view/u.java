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

public final class u
{
  Runnable HA = null;
  Runnable HB = null;
  int HC = -1;
  public WeakReference<View> Hz;
  
  u(View paramView)
  {
    this.Hz = new WeakReference(paramView);
  }
  
  private void a(final View paramView, final v paramv)
  {
    if (paramv != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          paramv.aw(paramView);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramv.av(paramView);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramv.au(paramView);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public final u a(v paramv)
  {
    View localView = (View)this.Hz.get();
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        a(localView, paramv);
      }
    }
    else {
      return this;
    }
    localView.setTag(2113929216, paramv);
    a(localView, new a(this));
    return this;
  }
  
  public final u a(final x paramx)
  {
    final View localView = (View)this.Hz.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 19))
    {
      ValueAnimator.AnimatorUpdateListener local2 = null;
      if (paramx != null) {
        local2 = new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramx.du();
          }
        };
      }
      localView.animate().setUpdateListener(local2);
    }
    return this;
  }
  
  public final u c(Interpolator paramInterpolator)
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public final void cancel()
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public final u k(long paramLong)
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public final u s(float paramFloat)
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public final void start()
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
  
  public final u t(float paramFloat)
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  public final u u(float paramFloat)
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().scaleX(paramFloat);
    }
    return this;
  }
  
  public final u v(float paramFloat)
  {
    View localView = (View)this.Hz.get();
    if (localView != null) {
      localView.animate().scaleY(paramFloat);
    }
    return this;
  }
  
  static final class a
    implements v
  {
    u HG;
    boolean HH;
    
    a(u paramu)
    {
      this.HG = paramu;
    }
    
    public final void au(View paramView)
    {
      this.HH = false;
      if (this.HG.HC >= 0) {
        paramView.setLayerType(2, null);
      }
      if (this.HG.HA != null)
      {
        localObject = this.HG.HA;
        this.HG.HA = null;
        ((Runnable)localObject).run();
      }
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof v)) {}
      for (localObject = (v)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((v)localObject).au(paramView);
        }
        return;
      }
    }
    
    public final void av(View paramView)
    {
      if (this.HG.HC >= 0)
      {
        paramView.setLayerType(this.HG.HC, null);
        this.HG.HC = -1;
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!this.HH))
      {
        if (this.HG.HB != null)
        {
          localObject = this.HG.HB;
          this.HG.HB = null;
          ((Runnable)localObject).run();
        }
        localObject = paramView.getTag(2113929216);
        if (!(localObject instanceof v)) {
          break label113;
        }
      }
      label113:
      for (Object localObject = (v)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((v)localObject).av(paramView);
        }
        this.HH = true;
        return;
      }
    }
    
    public final void aw(View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof v)) {}
      for (localObject = (v)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((v)localObject).aw(paramView);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.u
 * JD-Core Version:    0.7.0.1
 */