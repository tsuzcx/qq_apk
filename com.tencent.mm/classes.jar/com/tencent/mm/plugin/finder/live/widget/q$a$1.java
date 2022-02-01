package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget$hideAppliedBattleTip$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q$a$1
  extends AnimatorListenerAdapter
{
  q$a$1(a<ah> parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(362086);
    paramAnimator = this.EmL;
    if (paramAnimator != null) {
      paramAnimator.invoke();
    }
    AppMethodBeat.o(362086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.q.a.1
 * JD-Core Version:    0.7.0.1
 */