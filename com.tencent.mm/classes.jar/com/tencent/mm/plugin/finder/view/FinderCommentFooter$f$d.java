package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
public final class FinderCommentFooter$f$d
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(200070);
    this.LeI.qWm.getReplyBtn().setVisibility(8);
    AppMethodBeat.o(200070);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(200069);
    this.LeI.qWm.getReplyBtn().setVisibility(8);
    AppMethodBeat.o(200069);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(200071);
    this.LeI.qWm.getReplyBtn().setVisibility(0);
    AppMethodBeat.o(200071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter.f.d
 * JD-Core Version:    0.7.0.1
 */