package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.c;

final class a$2
  implements Animator.AnimatorListener
{
  a$2(a parama) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(116137);
    this.bVB.bVC = true;
    this.bVB.bVD = false;
    this.bVB.bVy = 0L;
    this.bVB.bVr.CL();
    this.bVB.bVr.CJ();
    if (this.bVB.nx != null) {
      this.bVB.nx.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(116137);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.bVB.bVr.cdv = true;
    this.bVB.bVC = false;
    this.bVB.bVD = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.b.a.2
 * JD-Core Version:    0.7.0.1
 */