package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragFeatureView$1
  implements Animator.AnimatorListener
{
  DragFeatureView$1(DragFeatureView paramDragFeatureView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133897);
    this.jfO.removeView(DragFeatureView.d(this.jfO));
    DragFeatureView.e(this.jfO);
    this.jfO.setRubbishViewVisible(8);
    AppMethodBeat.o(133897);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.1
 * JD-Core Version:    0.7.0.1
 */