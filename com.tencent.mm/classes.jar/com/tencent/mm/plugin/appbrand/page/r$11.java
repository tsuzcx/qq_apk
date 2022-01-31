package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$11
  extends AnimatorListenerAdapter
{
  r$11(r paramr, o paramo) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(141667);
    this.iwt.setTag(r.access$1600(), null);
    AppMethodBeat.o(141667);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(87088);
    this.iwt.setTag(r.access$1600(), null);
    AppMethodBeat.o(87088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r.11
 * JD-Core Version:    0.7.0.1
 */