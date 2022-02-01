package com.tencent.mm.plugin.appbrand.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$5
  extends AnimatorListenerAdapter
{
  e$5(e parame, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(197265);
    if (this.val$runnable != null) {
      this.val$runnable.run();
    }
    AppMethodBeat.o(197265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e.5
 * JD-Core Version:    0.7.0.1
 */