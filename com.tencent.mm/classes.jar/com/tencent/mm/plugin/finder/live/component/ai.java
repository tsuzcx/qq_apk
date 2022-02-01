package com.tencent.mm.plugin.finder.live.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/VerticalAnimationListener;", "Landroid/animation/Animator$AnimatorListener;", "()V", "animEndCallback", "Lkotlin/Function0;", "", "view", "Landroid/view/View;", "onAnimationCancel", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setup", "callback", "plugin-finder_release"})
public final class ai
  implements Animator.AnimatorListener
{
  View view;
  a<x> ycL;
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(258016);
    paramAnimator = this.view;
    if (paramAnimator != null) {
      paramAnimator.setTranslationY(0.0F);
    }
    paramAnimator = this.ycL;
    if ((paramAnimator == null) || ((x)paramAnimator.invoke() == null))
    {
      paramAnimator = (ai)this;
      Log.i("FinderLiveSlideAnimHelper", "VerticalAnimationListener onAnimationEnd：" + paramAnimator.ycL);
      paramAnimator = x.aazN;
    }
    AppMethodBeat.o(258016);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ai
 * JD-Core Version:    0.7.0.1
 */