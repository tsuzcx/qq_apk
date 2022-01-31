package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements Animator.AnimatorListener
{
  e$2(e parame, RecyclerView.v paramv, Runnable paramRunnable) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(134227);
    this.jiI.jis.removeView(this.jiI.jfC);
    this.jiI.jfC.setVisibility(8);
    if (this.jiJ != null) {
      this.jiJ.aku.setVisibility(0);
    }
    this.bZt.run();
    AppMethodBeat.o(134227);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.e.2
 * JD-Core Version:    0.7.0.1
 */