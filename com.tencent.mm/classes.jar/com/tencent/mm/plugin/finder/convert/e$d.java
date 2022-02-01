package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$10", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
public final class e$d
  implements Animator.AnimatorListener
{
  e$d(View paramView, int paramInt) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(221450);
    paramAnimator = this.rMk;
    p.g(paramAnimator, "maskView");
    paramAnimator.setVisibility(8);
    ad.i("Finder.FinderFeedCommentConvert", "maskView gone " + this.ghM);
    AppMethodBeat.o(221450);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.d
 * JD-Core Version:    0.7.0.1
 */