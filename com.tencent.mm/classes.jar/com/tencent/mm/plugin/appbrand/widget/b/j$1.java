package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$1
  extends AnimatorListenerAdapter
{
  j$1(j paramj, Runnable paramRunnable) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.jka.ggX = null;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(77420);
    if (this.inP != null) {
      this.inP.run();
    }
    this.jka.ggX = null;
    AppMethodBeat.o(77420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.j.1
 * JD-Core Version:    0.7.0.1
 */