package com.tencent.mm.plugin.bottle.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

final class ThrowBottleAnimUI$2
  implements Animation.AnimationListener
{
  ThrowBottleAnimUI$2(ThrowBottleAnimUI paramThrowBottleAnimUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ThrowBottleAnimUI.c(this.ibk).setVisibility(8);
    ThrowBottleAnimUI.h(this.ibk);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleAnimUI.2
 * JD-Core Version:    0.7.0.1
 */