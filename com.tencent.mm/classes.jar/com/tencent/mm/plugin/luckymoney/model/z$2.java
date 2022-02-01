package com.tencent.mm.plugin.luckymoney.model;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class z$2
  implements Animation.AnimationListener
{
  z$2(View paramView, ScaleAnimation paramScaleAnimation) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(65246);
    this.omo.startAnimation(this.omp);
    AppMethodBeat.o(65246);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z.2
 * JD-Core Version:    0.7.0.1
 */