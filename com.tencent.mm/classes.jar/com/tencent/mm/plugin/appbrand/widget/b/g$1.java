package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class g$1
  extends AnimatorListenerAdapter
{
  g$1(g paramg, Runnable paramRunnable) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.hsG.hsF = null;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.gMs != null) {
      this.gMs.run();
    }
    this.hsG.hsF = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.g.1
 * JD-Core Version:    0.7.0.1
 */