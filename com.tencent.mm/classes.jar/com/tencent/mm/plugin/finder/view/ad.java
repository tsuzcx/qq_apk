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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/HorizontalAnimationListener;", "Landroid/animation/Animator$AnimatorListener;", "()V", "animEndCallback", "Lkotlin/Function0;", "", "view", "Landroid/view/View;", "onAnimationCancel", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setup", "callback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  implements Animator.AnimatorListener
{
  private a<ah> GEC;
  private View view;
  
  public final void b(View paramView, a<ah> parama)
  {
    AppMethodBeat.i(344735);
    s.u(paramView, "view");
    this.view = paramView;
    this.GEC = parama;
    AppMethodBeat.o(344735);
  }
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(344754);
    paramAnimator = this.view;
    if (paramAnimator != null) {
      paramAnimator.setTranslationX(0.0F);
    }
    paramAnimator = this.GEC;
    if (paramAnimator == null) {}
    for (paramAnimator = null;; paramAnimator = ah.aiuX)
    {
      if (paramAnimator == null) {
        Log.i("FinderLiveSlideAnimHelper", s.X("HorizontalAnimationListener onAnimationEnd onAnimationEnd：", ((ad)this).GEC));
      }
      AppMethodBeat.o(344754);
      return;
      paramAnimator.invoke();
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ad
 * JD-Core Version:    0.7.0.1
 */