package com.tencent.mm.plugin.appbrand.widget.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  extends AnimatorListenerAdapter
{
  a$3(a parama) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(87526);
    a.b(this.juf);
    AppMethodBeat.o(87526);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(87525);
    this.juf.setVisibility(8);
    a.b(this.juf);
    AppMethodBeat.o(87525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.a.3
 * JD-Core Version:    0.7.0.1
 */