package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$13
  extends AnimatorListenerAdapter
{
  r$13(r paramr, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(141668);
    if (this.val$runnable != null) {
      this.iwq.post(this.val$runnable);
    }
    AppMethodBeat.o(141668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r.13
 * JD-Core Version:    0.7.0.1
 */