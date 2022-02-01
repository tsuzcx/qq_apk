package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FabTransformationScrimBehavior$1
  extends AnimatorListenerAdapter
{
  FabTransformationScrimBehavior$1(FabTransformationScrimBehavior paramFabTransformationScrimBehavior, boolean paramBoolean, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(240760);
    if (!this.bHy) {
      this.ck.setVisibility(4);
    }
    AppMethodBeat.o(240760);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(240759);
    if (this.bHy) {
      this.ck.setVisibility(0);
    }
    AppMethodBeat.o(240759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationScrimBehavior.1
 * JD-Core Version:    0.7.0.1
 */