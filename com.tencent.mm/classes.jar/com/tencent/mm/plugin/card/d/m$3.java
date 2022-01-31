package com.tencent.mm.plugin.card.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m$3
  implements Animation.AnimationListener
{
  public m$3(View paramView, ScaleAnimation paramScaleAnimation) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(88929);
    this.kCq.startAnimation(this.kCr);
    AppMethodBeat.o(88929);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m.3
 * JD-Core Version:    0.7.0.1
 */