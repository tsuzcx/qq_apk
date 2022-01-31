package com.tencent.mm.plugin.appbrand.widget.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$11
  extends AnimatorListenerAdapter
{
  a$11(a parama, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(87540);
    if (this.val$runnable != null) {
      this.jwQ.post(this.val$runnable);
    }
    AppMethodBeat.o(87540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.a.11
 * JD-Core Version:    0.7.0.1
 */