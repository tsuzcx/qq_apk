package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget$hideApplyBattleTip$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q$b$1
  extends AnimatorListenerAdapter
{
  q$b$1(a<ah> parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(361186);
    paramAnimator = this.EmL;
    if (paramAnimator != null) {
      paramAnimator.invoke();
    }
    AppMethodBeat.o(361186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.q.b.1
 * JD-Core Version:    0.7.0.1
 */