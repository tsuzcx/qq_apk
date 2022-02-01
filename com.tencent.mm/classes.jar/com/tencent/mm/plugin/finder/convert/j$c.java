package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.g.b.y.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
public final class j$c
  implements Animator.AnimatorListener
{
  j$c(y.f paramf, int paramInt) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(201800);
    paramAnimator = (View)this.rWr.NiY;
    p.g(paramAnimator, "maskView");
    paramAnimator.setVisibility(8);
    ae.i(this.rWo.TAG, "maskView gone " + this.gke);
    AppMethodBeat.o(201800);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j.c
 * JD-Core Version:    0.7.0.1
 */