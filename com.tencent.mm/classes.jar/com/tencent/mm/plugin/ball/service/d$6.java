package com.tencent.mm.plugin.ball.service;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;

final class d$6
  extends AnimatorListenerAdapter
{
  d$6(d paramd, BallInfo paramBallInfo) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(216990);
    super.onAnimationEnd(paramAnimator);
    if (!d.c(this.oXo)) {
      this.oXo.a(this.oVJ, 1.0F);
    }
    AppMethodBeat.o(216990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d.6
 * JD-Core Version:    0.7.0.1
 */