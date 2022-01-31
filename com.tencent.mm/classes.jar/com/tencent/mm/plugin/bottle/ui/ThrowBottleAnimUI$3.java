package com.tencent.mm.plugin.bottle.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.ah;

final class ThrowBottleAnimUI$3
  implements Animation.AnimationListener
{
  ThrowBottleAnimUI$3(ThrowBottleAnimUI paramThrowBottleAnimUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ThrowBottleAnimUI.b(this.ibk).setVisibility(8);
    if (ThrowBottleAnimUI.i(this.ibk) == null) {
      ThrowBottleAnimUI.a(this.ibk, (SprayLayout)ThrowBottleAnimUI.a(this.ibk).findViewById(R.h.bottle_spray_fl));
    }
    ThrowBottleAnimUI.i(this.ibk).C(1, ThrowBottleAnimUI.j(this.ibk), ThrowBottleAnimUI.k(this.ibk));
    ThrowBottleAnimUI.l(this.ibk).sendEmptyMessageDelayed(0, 2000L);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleAnimUI.3
 * JD-Core Version:    0.7.0.1
 */