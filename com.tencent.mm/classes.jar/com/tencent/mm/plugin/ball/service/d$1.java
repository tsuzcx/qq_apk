package com.tencent.mm.plugin.ball.service;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  extends AnimatorListenerAdapter
{
  d$1(d paramd) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(216986);
    super.onAnimationEnd(paramAnimator);
    this.oXo.a(null, 1.0F);
    AppMethodBeat.o(216986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d.1
 * JD-Core Version:    0.7.0.1
 */