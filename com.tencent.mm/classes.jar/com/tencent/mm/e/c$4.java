package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$4
  implements Animator.AnimatorListener
{
  c$4(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(116156);
    c.a(this.cdH, false);
    paramAnimator.removeAllListeners();
    AppMethodBeat.o(116156);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(116155);
    c.a(this.cdH, true);
    AppMethodBeat.o(116155);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(116154);
    this.cdH.cdv = true;
    c.a(this.cdH, true);
    AppMethodBeat.o(116154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.4
 * JD-Core Version:    0.7.0.1
 */