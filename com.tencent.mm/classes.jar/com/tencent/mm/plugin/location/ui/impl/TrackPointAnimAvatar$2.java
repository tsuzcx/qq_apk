package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TrackPointAnimAvatar$2
  implements Animation.AnimationListener
{
  TrackPointAnimAvatar$2(TrackPointAnimAvatar paramTrackPointAnimAvatar) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(113732);
    this.ohQ.bringToFront();
    TrackPointAnimAvatar.b(this.ohQ).startAnimation(TrackPointAnimAvatar.c(this.ohQ));
    AppMethodBeat.o(113732);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar.2
 * JD-Core Version:    0.7.0.1
 */