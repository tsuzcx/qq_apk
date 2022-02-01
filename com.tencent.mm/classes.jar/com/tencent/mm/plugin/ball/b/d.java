package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends AnimatorListenerAdapter
{
  private View nmf;
  private AnimatorListenerAdapter vjz;
  
  public d(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.nmf = paramView;
    this.vjz = paramAnimatorListenerAdapter;
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(106048);
    super.onAnimationCancel(paramAnimator);
    if (this.nmf != null) {
      this.nmf.setVisibility(8);
    }
    if (this.vjz != null) {
      this.vjz.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(106048);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(106049);
    super.onAnimationEnd(paramAnimator);
    if (this.nmf != null) {
      this.nmf.setVisibility(8);
    }
    if (this.vjz != null) {
      this.vjz.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(106049);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(106052);
    super.onAnimationPause(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationPause(paramAnimator);
    }
    AppMethodBeat.o(106052);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(106050);
    super.onAnimationRepeat(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(106050);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(106053);
    super.onAnimationResume(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationResume(paramAnimator);
    }
    AppMethodBeat.o(106053);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(106051);
    super.onAnimationStart(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(106051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.b.d
 * JD-Core Version:    0.7.0.1
 */