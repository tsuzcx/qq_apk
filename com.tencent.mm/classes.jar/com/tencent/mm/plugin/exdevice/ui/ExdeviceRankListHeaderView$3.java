package com.tencent.mm.plugin.exdevice.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ai;

final class ExdeviceRankListHeaderView$3
  implements Animation.AnimationListener
{
  ExdeviceRankListHeaderView$3(ExdeviceRankListHeaderView paramExdeviceRankListHeaderView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ExdeviceRankListHeaderView.d(this.jGd).reset();
    ai.l(ExdeviceRankListHeaderView.f(this.jGd), 4000L);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    ExdeviceRankListHeaderView.e(this.jGd).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.3
 * JD-Core Version:    0.7.0.1
 */