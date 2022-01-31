package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class c$6
  extends AnimatorListenerAdapter
{
  c$6(c paramc, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.val$runnable != null) {
      this.hnR.post(this.val$runnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.6
 * JD-Core Version:    0.7.0.1
 */