package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/VerticalAnimationListener;", "Landroid/animation/Animator$AnimatorListener;", "()V", "animEndCallback", "Lkotlin/Function0;", "", "view", "Landroid/view/View;", "onAnimationCancel", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setup", "callback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  implements Animator.AnimatorListener
{
  public a<ah> GEC;
  public View view;
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(344690);
    paramAnimator = this.view;
    if (paramAnimator != null) {
      paramAnimator.setTranslationY(0.0F);
    }
    paramAnimator = this.GEC;
    if (paramAnimator == null) {}
    for (paramAnimator = null;; paramAnimator = ah.aiuX)
    {
      if (paramAnimator == null) {
        Log.i("FinderLiveSlideAnimHelper", s.X("VerticalAnimationListener onAnimationEnd：", ((ai)this).GEC));
      }
      AppMethodBeat.o(344690);
      return;
      paramAnimator.invoke();
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ai
 * JD-Core Version:    0.7.0.1
 */