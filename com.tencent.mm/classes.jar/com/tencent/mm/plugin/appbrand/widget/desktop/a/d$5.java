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
    AppMethodBeat.i(134214);
    this.jiB.jis.removeView(this.jiB.jfC);
    if (!this.jiB.jiw)
    {
      this.jiE.aku.setVisibility(0);
      this.bZt.run();
      AppMethodBeat.o(134214);
      return;
    }
    if ((this.jiF != null) && (this.jiF.aku != null)) {
      this.jiF.aku.setVisibility(0);
    }
    if (this.jiE != null)
    {
      this.jiE.aku.setVisibility(0);
      this.jiE.aku.setScaleX(0.0F);
      this.jiE.aku.setScaleY(0.0F);
      this.jiE.aku.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(300L).setListener(null).start();
    }
    this.bZt.run();
    this.jiB.jfC.setScaleX(1.0F);
    this.jiB.jfC.setScaleY(1.0F);
    AppMethodBeat.o(134214);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d.5
 * JD-Core Version:    0.7.0.1
 */