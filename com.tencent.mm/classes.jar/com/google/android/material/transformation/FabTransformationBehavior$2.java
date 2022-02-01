package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FabTransformationBehavior$2
  implements ValueAnimator.AnimatorUpdateListener
{
  FabTransformationBehavior$2(FabTransformationBehavior paramFabTransformationBehavior, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(240668);
    this.ck.invalidate();
    AppMethodBeat.o(240668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.2
 * JD-Core Version:    0.7.0.1
 */