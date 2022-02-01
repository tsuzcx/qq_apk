package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$showLoading$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoLayout$o
  implements Animator.AnimatorListener
{
  FinderVideoLayout$o(FinderVideoLayout paramFinderVideoLayout) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(335197);
    FinderVideoLayout.i(this.GqN).setAlpha(1.0F);
    FinderVideoLayout.i(this.GqN).setVisibility(0);
    AppMethodBeat.o(335197);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout.o
 * JD-Core Version:    0.7.0.1
 */