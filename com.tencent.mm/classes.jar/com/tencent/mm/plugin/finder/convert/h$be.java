package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.y.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showPrivateFeedLikeTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
public final class h$be
  implements Animator.AnimatorListener
{
  h$be(y.f paramf) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(201794);
    paramAnimator = (View)this.rWf.NiY;
    p.g(paramAnimator, "tips");
    paramAnimator.setVisibility(8);
    AppMethodBeat.o(201794);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.be
 * JD-Core Version:    0.7.0.1
 */