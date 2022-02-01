package androidx.core.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class aa
{
  private WeakReference<View> NQ;
  Runnable NR;
  Runnable NS;
  int NT;
  
  aa(View paramView)
  {
    AppMethodBeat.i(251847);
    this.NR = null;
    this.NS = null;
    this.NT = -1;
    this.NQ = new WeakReference(paramView);
    AppMethodBeat.o(251847);
  }
  
  private void a(final View paramView, final ab paramab)
  {
    AppMethodBeat.i(251873);
    if (paramab != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(251823);
          paramab.k(paramView);
          AppMethodBeat.o(251823);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(251825);
          paramab.f(paramView);
          AppMethodBeat.o(251825);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(251826);
          paramab.e(paramView);
          AppMethodBeat.o(251826);
        }
      });
      AppMethodBeat.o(251873);
      return;
    }
    paramView.animate().setListener(null);
    AppMethodBeat.o(251873);
  }
  
  public final aa a(final ad paramad)
  {
    AppMethodBeat.i(251877);
    final View localView = (View)this.NQ.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 19))
    {
      ValueAnimator.AnimatorUpdateListener local2 = null;
      if (paramad != null) {
        local2 = new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(251832);
            paramad.bm();
            AppMethodBeat.o(251832);
          }
        };
      }
      localView.animate().setUpdateListener(local2);
    }
    AppMethodBeat.o(251877);
    return this;
  }
  
  public final aa b(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(251856);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    AppMethodBeat.o(251856);
    return this;
  }
  
  public final aa b(ab paramab)
  {
    AppMethodBeat.i(251870);
    View localView = (View)this.NQ.get();
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label41;
      }
      a(localView, paramab);
    }
    for (;;)
    {
      AppMethodBeat.o(251870);
      return this;
      label41:
      localView.setTag(2113929216, paramab);
      a(localView, new a(this));
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(251863);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().cancel();
    }
    AppMethodBeat.o(251863);
  }
  
  public final aa f(long paramLong)
  {
    AppMethodBeat.i(251849);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    AppMethodBeat.o(251849);
    return this;
  }
  
  public final aa g(long paramLong)
  {
    AppMethodBeat.i(251857);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().setStartDelay(paramLong);
    }
    AppMethodBeat.o(251857);
    return this;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(251854);
    View localView = (View)this.NQ.get();
    if (localView != null)
    {
      long l = localView.animate().getDuration();
      AppMethodBeat.o(251854);
      return l;
    }
    AppMethodBeat.o(251854);
    return 0L;
  }
  
  public final aa i(float paramFloat)
  {
    AppMethodBeat.i(251850);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    AppMethodBeat.o(251850);
    return this;
  }
  
  public final aa j(float paramFloat)
  {
    AppMethodBeat.i(251852);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    AppMethodBeat.o(251852);
    return this;
  }
  
  public final aa k(float paramFloat)
  {
    AppMethodBeat.i(251858);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().scaleX(paramFloat);
    }
    AppMethodBeat.o(251858);
    return this;
  }
  
  public final aa l(float paramFloat)
  {
    AppMethodBeat.i(251861);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().scaleY(paramFloat);
    }
    AppMethodBeat.o(251861);
    return this;
  }
  
  public final void start()
  {
    AppMethodBeat.i(251866);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.animate().start();
    }
    AppMethodBeat.o(251866);
  }
  
  static final class a
    implements ab
  {
    aa NX;
    boolean NY;
    
    a(aa paramaa)
    {
      this.NX = paramaa;
    }
    
    public final void e(View paramView)
    {
      AppMethodBeat.i(251842);
      this.NY = false;
      if (this.NX.NT >= 0) {
        paramView.setLayerType(2, null);
      }
      if (this.NX.NR != null)
      {
        localObject = this.NX.NR;
        this.NX.NR = null;
        ((Runnable)localObject).run();
      }
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof ab)) {}
      for (localObject = (ab)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((ab)localObject).e(paramView);
        }
        AppMethodBeat.o(251842);
        return;
      }
    }
    
    @SuppressLint({"WrongConstant"})
    public final void f(View paramView)
    {
      AppMethodBeat.i(251843);
      if (this.NX.NT >= 0)
      {
        paramView.setLayerType(this.NX.NT, null);
        this.NX.NT = -1;
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!this.NY))
      {
        if (this.NX.NS != null)
        {
          localObject = this.NX.NS;
          this.NX.NS = null;
          ((Runnable)localObject).run();
        }
        localObject = paramView.getTag(2113929216);
        if (!(localObject instanceof ab)) {
          break label123;
        }
      }
      label123:
      for (Object localObject = (ab)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((ab)localObject).f(paramView);
        }
        this.NY = true;
        AppMethodBeat.o(251843);
        return;
      }
    }
    
    public final void k(View paramView)
    {
      AppMethodBeat.i(251845);
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof ab)) {}
      for (localObject = (ab)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((ab)localObject).k(paramView);
        }
        AppMethodBeat.o(251845);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.g.aa
 * JD-Core Version:    0.7.0.1
 */