package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p$1
  implements Animator.AnimatorListener
{
  public p$1(p paramp) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(147691);
    this.mFG.setVisibility(8);
    AppMethodBeat.o(147691);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p.1
 * JD-Core Version:    0.7.0.1
 */