package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragFeatureView$4
  implements Animator.AnimatorListener
{
  DragFeatureView$4(DragFeatureView paramDragFeatureView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133900);
    DragFeatureView.e(this.jfO);
    this.jfO.requestLayout();
    if ((DragFeatureView.h(this.jfO)) && ((DragFeatureView.i(this.jfO) instanceof DragRecyclerView)))
    {
      ((DragRecyclerView)DragFeatureView.i(this.jfO)).setLongPress(false);
      DragFeatureView.j(this.jfO);
      DragFeatureView.k(this.jfO);
    }
    AppMethodBeat.o(133900);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.4
 * JD-Core Version:    0.7.0.1
 */