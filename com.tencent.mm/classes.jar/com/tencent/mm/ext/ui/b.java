package com.tencent.mm.ext.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import com.tencent.liteapp.a.a;
import com.tencent.liteapp.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.a.b.a;

public final class b
{
  public static final void a(View paramView, long paramLong, float paramFloat, a parama)
  {
    AppMethodBeat.i(235350);
    if ((paramView == null) || (a.rc(14)))
    {
      AppMethodBeat.o(235350);
      return;
    }
    Object localObject = (Animator)paramView.getTag(a.d.property_anim);
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    com.tencent.liteapp.b.b.i("Changelcai", "[animTran] duration:%s x:%s", new Object[] { Long.valueOf(paramLong), Float.valueOf(paramFloat) });
    paramView.animate().cancel();
    paramView.animate().setListener(null);
    localObject = AnimationUtils.loadInterpolator(paramView.getContext(), a.a.mm_decelerate_interpolator);
    if (parama == null)
    {
      paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject);
      AppMethodBeat.o(235350);
      return;
    }
    paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(235370);
        this.mqm.aXe();
        AppMethodBeat.o(235370);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(235364);
        this.mqm.onAnimationEnd();
        AppMethodBeat.o(235364);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(235350);
  }
  
  public static final void r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(235337);
    if ((paramView == null) || (a.rc(14)))
    {
      AppMethodBeat.o(235337);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.d.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.animate().cancel();
    paramView.setTranslationX(paramFloat);
    paramView.setTranslationY(0.0F);
    AppMethodBeat.o(235337);
  }
  
  public static abstract interface a
  {
    public abstract void aXe();
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.b
 * JD-Core Version:    0.7.0.1
 */