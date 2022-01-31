package com.tencent.mm.plugin.exdevice.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceRankListHeaderView$4
  implements Animation.AnimationListener
{
  ExdeviceRankListHeaderView$4(ExdeviceRankListHeaderView paramExdeviceRankListHeaderView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(20207);
    ExdeviceRankListHeaderView.e(this.lPB).setVisibility(4);
    AppMethodBeat.o(20207);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(20206);
    ExdeviceRankListHeaderView.e(this.lPB).setVisibility(0);
    AppMethodBeat.o(20206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.4
 * JD-Core Version:    0.7.0.1
 */