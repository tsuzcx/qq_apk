package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$5
  implements Animator.AnimatorListener
{
  d$5(d paramd, RecyclerView.v paramv1, Runnable paramRunnable, RecyclerView.v paramv2) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(49825);
    this.opG.cIL.removeView(this.opG.ooN);
    if (!this.opG.opB)
    {
      this.opJ.aus.setVisibility(0);
      this.val$callback.run();
      AppMethodBeat.o(49825);
      return;
    }
    if ((this.opK != null) && (this.opK.aus != null)) {
      this.opK.aus.setVisibility(0);
    }
    if (this.opJ != null)
    {
      this.opJ.aus.setVisibility(0);
      this.opJ.aus.setScaleX(0.0F);
      this.opJ.aus.setScaleY(0.0F);
      this.opJ.aus.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(300L).setListener(null).start();
    }
    this.val$callback.run();
    this.opG.ooN.setScaleX(1.0F);
    this.opG.ooN.setScaleY(1.0F);
    AppMethodBeat.o(49825);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d.5
 * JD-Core Version:    0.7.0.1
 */