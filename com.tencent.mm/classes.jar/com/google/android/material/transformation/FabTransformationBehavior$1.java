package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FabTransformationBehavior$1
  extends AnimatorListenerAdapter
{
  FabTransformationBehavior$1(FabTransformationBehavior paramFabTransformationBehavior, boolean paramBoolean, View paramView1, View paramView2) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(240653);
    if (!this.bHy)
    {
      this.ck.setVisibility(4);
      this.bHz.setAlpha(1.0F);
      this.bHz.setVisibility(0);
    }
    AppMethodBeat.o(240653);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(240651);
    if (this.bHy)
    {
      this.ck.setVisibility(0);
      this.bHz.setAlpha(0.0F);
      this.bHz.setVisibility(4);
    }
    AppMethodBeat.o(240651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.1
 * JD-Core Version:    0.7.0.1
 */