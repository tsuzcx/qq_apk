package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$5
  implements Animator.AnimatorListener
{
  public c$5(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(116158);
    c.b(this.cdH).nx = null;
    AppMethodBeat.o(116158);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(116157);
    c.b(this.cdH).nx = null;
    c.c(this.cdH);
    AppMethodBeat.o(116157);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.5
 * JD-Core Version:    0.7.0.1
 */