package com.tencent.mm.plugin.exdevice.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

final class ExdeviceRankListHeaderView$4
  implements Animation.AnimationListener
{
  ExdeviceRankListHeaderView$4(ExdeviceRankListHeaderView paramExdeviceRankListHeaderView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ExdeviceRankListHeaderView.e(this.jGd).setVisibility(4);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    ExdeviceRankListHeaderView.e(this.jGd).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.4
 * JD-Core Version:    0.7.0.1
 */