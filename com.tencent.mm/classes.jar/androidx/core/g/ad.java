package androidx.core.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class ad
{
  private WeakReference<View> btW;
  Runnable btX;
  Runnable btY;
  int btZ;
  
  ad(View paramView)
  {
    AppMethodBeat.i(195751);
    this.btX = null;
    this.btY = null;
    this.btZ = -1;
    this.btW = new WeakReference(paramView);
    AppMethodBeat.o(195751);
  }
  
  private void a(final View paramView, final ae paramae)
  {
    AppMethodBeat.i(195762);
    if (paramae != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(195652);
          paramae.k(paramView);
          AppMethodBeat.o(195652);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(195660);
          paramae.f(paramView);
          AppMethodBeat.o(195660);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(195669);
          paramae.e(paramView);
          AppMethodBeat.o(195669);
        }
      });
      AppMethodBeat.o(195762);
      return;
    }
    paramView.animate().setListener(null);
    AppMethodBeat.o(195762);
  }
  
  public final ad a(final ag paramag)
  {
    AppMethodBeat.i(195878);
    final View localView = (View)this.btW.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 19))
    {
      ValueAnimator.AnimatorUpdateListener local2 = null;
      if (paramag != null) {
        local2 = new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(195658);
            paramag.cf();
            AppMethodBeat.o(195658);
          }
        };
      }
      localView.animate().setUpdateListener(local2);
    }
    AppMethodBeat.o(195878);
    return this;
  }
  
  public final ad ao(float paramFloat)
  {
    AppMethodBeat.i(195779);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    AppMethodBeat.o(195779);
    return this;
  }
  
  public final ad ap(float paramFloat)
  {
    AppMethodBeat.i(195790);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    AppMethodBeat.o(195790);
    return this;
  }
  
  public final ad aq(float paramFloat)
  {
    AppMethodBeat.i(195829);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().scaleX(paramFloat);
    }
    AppMethodBeat.o(195829);
    return this;
  }
  
  public final ad ar(float paramFloat)
  {
    AppMethodBeat.i(195839);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().scaleY(paramFloat);
    }
    AppMethodBeat.o(195839);
    return this;
  }
  
  public final ad b(ae paramae)
  {
    AppMethodBeat.i(195868);
    View localView = (View)this.btW.get();
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label41;
      }
      a(localView, paramae);
    }
    for (;;)
    {
      AppMethodBeat.o(195868);
      return this;
      label41:
      localView.setTag(2113929216, paramae);
      a(localView, new a(this));
    }
  }
  
  public final ad bu(long paramLong)
  {
    AppMethodBeat.i(195772);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    AppMethodBeat.o(195772);
    return this;
  }
  
  public final ad bv(long paramLong)
  {
    AppMethodBeat.i(195821);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().setStartDelay(paramLong);
    }
    AppMethodBeat.o(195821);
    return this;
  }
  
  public final ad c(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(195811);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    AppMethodBeat.o(195811);
    return this;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(195852);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().cancel();
    }
    AppMethodBeat.o(195852);
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(195800);
    View localView = (View)this.btW.get();
    if (localView != null)
    {
      long l = localView.animate().getDuration();
      AppMethodBeat.o(195800);
      return l;
    }
    AppMethodBeat.o(195800);
    return 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(195857);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.animate().start();
    }
    AppMethodBeat.o(195857);
  }
  
  static final class a
    implements ae
  {
    ad bud;
    boolean bue;
    
    a(ad paramad)
    {
      this.bud = paramad;
    }
    
    public final void e(View paramView)
    {
      AppMethodBeat.i(195637);
      this.bue = false;
      if (this.bud.btZ >= 0) {
        paramView.setLayerType(2, null);
      }
      if (this.bud.btX != null)
      {
        localObject = this.bud.btX;
        this.bud.btX = null;
        ((Runnable)localObject).run();
      }
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof ae)) {}
      for (localObject = (ae)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((ae)localObject).e(paramView);
        }
        AppMethodBeat.o(195637);
        return;
      }
    }
    
    public final void f(View paramView)
    {
      AppMethodBeat.i(195649);
      if (this.bud.btZ >= 0)
      {
        paramView.setLayerType(this.bud.btZ, null);
        this.bud.btZ = -1;
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!this.bue))
      {
        if (this.bud.btY != null)
        {
          localObject = this.bud.btY;
          this.bud.btY = null;
          ((Runnable)localObject).run();
        }
        localObject = paramView.getTag(2113929216);
        if (!(localObject instanceof ae)) {
          break label123;
        }
      }
      label123:
      for (Object localObject = (ae)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((ae)localObject).f(paramView);
        }
        this.bue = true;
        AppMethodBeat.o(195649);
        return;
      }
    }
    
    public final void k(View paramView)
    {
      AppMethodBeat.i(195654);
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof ae)) {}
      for (localObject = (ae)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((ae)localObject).k(paramView);
        }
        AppMethodBeat.o(195654);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.ad
 * JD-Core Version:    0.7.0.1
 */