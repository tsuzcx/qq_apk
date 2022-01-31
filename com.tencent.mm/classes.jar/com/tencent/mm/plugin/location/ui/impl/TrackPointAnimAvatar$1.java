package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

final class TrackPointAnimAvatar$1
  implements Animation.AnimationListener
{
  TrackPointAnimAvatar$1(TrackPointAnimAvatar paramTrackPointAnimAvatar) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.lKy.bringToFront();
    TrackPointAnimAvatar.b(this.lKy).startAnimation(TrackPointAnimAvatar.a(this.lKy));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar.1
 * JD-Core Version:    0.7.0.1
 */