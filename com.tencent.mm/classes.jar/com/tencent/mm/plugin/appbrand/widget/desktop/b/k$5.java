package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$5
  implements Animator.AnimatorListener
{
  k$5(k paramk, RecyclerView.w paramw1, Runnable paramRunnable, RecyclerView.w paramw2) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(49825);
    this.naC.cuk.removeView(this.naC.mYs);
    if (!this.naC.nax)
    {
      this.naF.auu.setVisibility(0);
      this.val$callback.run();
      AppMethodBeat.o(49825);
      return;
    }
    if ((this.naG != null) && (this.naG.auu != null)) {
      this.naG.auu.setVisibility(0);
    }
    if (this.naF != null)
    {
      this.naF.auu.setVisibility(0);
      this.naF.auu.setScaleX(0.0F);
      this.naF.auu.setScaleY(0.0F);
      this.naF.auu.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(300L).setListener(null).start();
    }
    this.val$callback.run();
    this.naC.mYs.setScaleX(1.0F);
    this.naC.mYs.setScaleY(1.0F);
    AppMethodBeat.o(49825);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.k.5
 * JD-Core Version:    0.7.0.1
 */