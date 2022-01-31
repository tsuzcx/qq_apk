package com.tencent.mm.plugin.luckymoney.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;

final class o$1
  implements Animation.AnimationListener
{
  o$1(View paramView, ScaleAnimation paramScaleAnimation) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.izj.startAnimation(this.izk);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.o.1
 * JD-Core Version:    0.7.0.1
 */