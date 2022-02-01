package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
public final class FinderCommentFooter$f$b
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(200066);
    paramAnimator = this.LeI.qWm.getReplyBtn().getLayoutParams();
    paramAnimator.width = this.LeI.qWm.getReplyBtnWidth();
    this.LeI.qWm.getReplyBtn().setLayoutParams(paramAnimator);
    this.LeI.qWm.getReplyBtn().setAlpha(1.0F);
    AppMethodBeat.o(200066);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(200065);
    paramAnimator = this.LeI.qWm.getReplyBtn().getLayoutParams();
    paramAnimator.width = this.LeI.qWm.getReplyBtnWidth();
    this.LeI.qWm.getReplyBtn().setLayoutParams(paramAnimator);
    this.LeI.qWm.getReplyBtn().setAlpha(1.0F);
    AppMethodBeat.o(200065);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(200067);
    this.LeI.qWm.getReplyBtn().setVisibility(0);
    AppMethodBeat.o(200067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter.f.b
 * JD-Core Version:    0.7.0.1
 */