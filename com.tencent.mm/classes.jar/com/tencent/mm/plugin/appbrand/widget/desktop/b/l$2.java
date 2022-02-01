package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$2
  implements Animator.AnimatorListener
{
  l$2(l paraml, RecyclerView.w paramw, Runnable paramRunnable) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(49839);
    this.nfR.cuN.removeView(this.nfR.ndz);
    this.nfR.ndz.setVisibility(8);
    if (this.nfS != null) {
      this.nfS.auu.setVisibility(0);
    }
    this.val$callback.run();
    AppMethodBeat.o(49839);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.l.2
 * JD-Core Version:    0.7.0.1
 */