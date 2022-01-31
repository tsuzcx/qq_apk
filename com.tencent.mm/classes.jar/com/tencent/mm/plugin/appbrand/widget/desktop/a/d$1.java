package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.FrameLayout;

final class d$1
  implements Animator.AnimatorListener
{
  d$1(d paramd, RecyclerView.v paramv, Runnable paramRunnable) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.hsl.hrW.removeView(this.hsl.hqL);
    this.hsl.hqL.setVisibility(8);
    if (this.hsk != null) {
      this.hsk.aie.setVisibility(0);
    }
    this.bxs.run();
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d.1
 * JD-Core Version:    0.7.0.1
 */