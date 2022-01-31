package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ai;

final class h$2
  implements Animation.AnimationListener
{
  h$2(Runnable paramRunnable, i parami) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.gMs != null) {
      ai.d(this.gMs);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.fAy.fyq.setWillNotDraw(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.2
 * JD-Core Version:    0.7.0.1
 */