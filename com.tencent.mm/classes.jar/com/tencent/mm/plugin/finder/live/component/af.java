package com.tencent.mm.plugin.finder.live.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/HorizontalAnimationListener;", "Landroid/animation/Animator$AnimatorListener;", "()V", "animEndCallback", "Lkotlin/Function0;", "", "view", "Landroid/view/View;", "onAnimationCancel", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setup", "callback", "plugin-finder_release"})
public final class af
  implements Animator.AnimatorListener
{
  private View view;
  private a<x> ycL;
  
  public final void c(View paramView, a<x> parama)
  {
    AppMethodBeat.i(290584);
    p.k(paramView, "view");
    this.view = paramView;
    this.ycL = parama;
    AppMethodBeat.o(290584);
  }
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(290585);
    paramAnimator = this.view;
    if (paramAnimator != null) {
      paramAnimator.setTranslationX(0.0F);
    }
    paramAnimator = this.ycL;
    if ((paramAnimator == null) || ((x)paramAnimator.invoke() == null))
    {
      paramAnimator = (af)this;
      Log.i("FinderLiveSlideAnimHelper", "HorizontalAnimationListener onAnimationEnd onAnimationEnd：" + paramAnimator.ycL);
      paramAnimator = x.aazN;
    }
    AppMethodBeat.o(290585);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.af
 * JD-Core Version:    0.7.0.1
 */