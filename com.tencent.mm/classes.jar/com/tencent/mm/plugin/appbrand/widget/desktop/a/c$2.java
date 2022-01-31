package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;

final class c$2
  implements Animator.AnimatorListener
{
  c$2(c paramc, RecyclerView.v paramv1, Runnable paramRunnable, RecyclerView.v paramv2) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.hsf.hrW.removeView(this.hsf.hqL);
    if (!this.hsf.hsa)
    {
      this.hsg.aie.setVisibility(0);
      this.bxs.run();
      return;
    }
    if ((this.hsh != null) && (this.hsh.aie != null)) {
      this.hsh.aie.setVisibility(0);
    }
    if (this.hsg != null)
    {
      this.hsg.aie.setVisibility(0);
      this.hsg.aie.setScaleX(0.0F);
      this.hsg.aie.setScaleY(0.0F);
      this.hsg.aie.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setListener(null).start();
    }
    this.bxs.run();
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c.2
 * JD-Core Version:    0.7.0.1
 */