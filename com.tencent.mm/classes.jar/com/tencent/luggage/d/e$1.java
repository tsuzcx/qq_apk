package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  extends AnimatorListenerAdapter
{
  e$1(e parame, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(90772);
    if (this.val$runnable != null) {
      this.val$runnable.run();
    }
    AppMethodBeat.o(90772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.d.e.1
 * JD-Core Version:    0.7.0.1
 */