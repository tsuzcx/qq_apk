package com.tencent.mm.plugin.luckymoney.model;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x$1
  implements Animation.AnimationListener
{
  x$1(View paramView, ScaleAnimation paramScaleAnimation) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(42355);
    this.kCq.startAnimation(this.kCr);
    AppMethodBeat.o(42355);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x.1
 * JD-Core Version:    0.7.0.1
 */