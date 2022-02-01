package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends AnimatorListenerAdapter
{
  private View nmf;
  private AnimatorListenerAdapter vjz;
  
  public e(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.nmf = paramView;
    this.vjz = null;
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(106054);
    super.onAnimationCancel(paramAnimator);
    if (this.nmf != null) {
      this.nmf.setVisibility(0);
    }
    if (this.vjz != null) {
      this.vjz.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(106054);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(106055);
    super.onAnimationEnd(paramAnimator);
    if (this.nmf != null) {
      this.nmf.setVisibility(0);
    }
    if (this.vjz != null) {
      this.vjz.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(106055);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(106058);
    super.onAnimationPause(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationPause(paramAnimator);
    }
    AppMethodBeat.o(106058);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(106056);
    super.onAnimationRepeat(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(106056);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(106059);
    super.onAnimationResume(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationResume(paramAnimator);
    }
    AppMethodBeat.o(106059);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(106057);
    super.onAnimationStart(paramAnimator);
    if (this.vjz != null) {
      this.vjz.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(106057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.b.e
 * JD-Core Version:    0.7.0.1
 */