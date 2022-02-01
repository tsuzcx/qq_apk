package com.tencent.kinda.framework.animate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class KindaGlobalAnimator$1
  extends AnimatorListenerAdapter
{
  KindaGlobalAnimator$1(Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(18327);
    this.val$animOnComplete.run();
    AppMethodBeat.o(18327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaGlobalAnimator.1
 * JD-Core Version:    0.7.0.1
 */