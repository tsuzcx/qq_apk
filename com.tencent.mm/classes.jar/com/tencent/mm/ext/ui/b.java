package com.tencent.mm.ext.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.a.b.a;

public final class b
{
  @TargetApi(14)
  public static final void a(View paramView, long paramLong, float paramFloat, a parama)
  {
    AppMethodBeat.i(197823);
    if ((paramView == null) || (a.oE(14)))
    {
      AppMethodBeat.o(197823);
      return;
    }
    Object localObject = (Animator)paramView.getTag(2131306306);
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    com.tencent.liteapp.b.b.i("Changelcai", "[animTran] duration:%s x:%s", new Object[] { Long.valueOf(paramLong), Float.valueOf(paramFloat) });
    paramView.animate().cancel();
    paramView.animate().setListener(null);
    localObject = AnimationUtils.loadInterpolator(paramView.getContext(), 2130772093);
    if (parama == null)
    {
      paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject);
      AppMethodBeat.o(197823);
      return;
    }
    paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(197821);
        this.hfk.awJ();
        AppMethodBeat.o(197821);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(197820);
        this.hfk.onAnimationEnd();
        AppMethodBeat.o(197820);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(197823);
  }
  
  @TargetApi(14)
  public static final void q(View paramView, float paramFloat)
  {
    AppMethodBeat.i(197822);
    if ((paramView == null) || (a.oE(14)))
    {
      AppMethodBeat.o(197822);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(2131306306);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.animate().cancel();
    paramView.setTranslationX(paramFloat);
    paramView.setTranslationY(0.0F);
    AppMethodBeat.o(197822);
  }
  
  public static abstract interface a
  {
    public abstract void awJ();
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ext.ui.b
 * JD-Core Version:    0.7.0.1
 */