package com.tencent.mm.plugin.luckymoney.model;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x$2
  implements Animation.AnimationListener
{
  x$2(View paramView, ScaleAnimation paramScaleAnimation) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(42356);
    this.kCq.startAnimation(this.kCr);
    AppMethodBeat.o(42356);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x.2
 * JD-Core Version:    0.7.0.1
 */