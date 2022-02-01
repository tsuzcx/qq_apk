package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$5
  implements Animator.AnimatorListener
{
  k$5(k paramk, RecyclerView.v paramv1, Runnable paramRunnable, RecyclerView.v paramv2) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(49825);
    this.lXS.lOR.removeView(this.lXS.lVI);
    if (!this.lXS.lXN)
    {
      this.lXV.arI.setVisibility(0);
      this.val$callback.run();
      AppMethodBeat.o(49825);
      return;
    }
    if ((this.lXW != null) && (this.lXW.arI != null)) {
      this.lXW.arI.setVisibility(0);
    }
    if (this.lXV != null)
    {
      this.lXV.arI.setVisibility(0);
      this.lXV.arI.setScaleX(0.0F);
      this.lXV.arI.setScaleY(0.0F);
      this.lXV.arI.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(300L).setListener(null).start();
    }
    this.val$callback.run();
    this.lXS.lVI.setScaleX(1.0F);
    this.lXS.lVI.setScaleY(1.0F);
    AppMethodBeat.o(49825);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.k.5
 * JD-Core Version:    0.7.0.1
 */