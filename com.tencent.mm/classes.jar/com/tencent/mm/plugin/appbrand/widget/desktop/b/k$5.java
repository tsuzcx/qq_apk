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
    this.nfK.cuN.removeView(this.nfK.ndz);
    if (!this.nfK.nfF)
    {
      this.nfN.auu.setVisibility(0);
      this.val$callback.run();
      AppMethodBeat.o(49825);
      return;
    }
    if ((this.nfO != null) && (this.nfO.auu != null)) {
      this.nfO.auu.setVisibility(0);
    }
    if (this.nfN != null)
    {
      this.nfN.auu.setVisibility(0);
      this.nfN.auu.setScaleX(0.0F);
      this.nfN.auu.setScaleY(0.0F);
      this.nfN.auu.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(300L).setListener(null).start();
    }
    this.val$callback.run();
    this.nfK.ndz.setScaleX(1.0F);
    this.nfK.ndz.setScaleY(1.0F);
    AppMethodBeat.o(49825);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.k.5
 * JD-Core Version:    0.7.0.1
 */