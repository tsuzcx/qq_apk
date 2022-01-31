package com.tencent.mm.plugin.fav.ui.widget;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class FavVideoView$6
  implements Runnable
{
  FavVideoView$6(FavVideoView paramFavVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(74719);
    if ((FavVideoView.d(this.mEC) != null) && (FavVideoView.d(this.mEC).getVisibility() != 8)) {
      FavVideoView.d(this.mEC).setVisibility(8);
    }
    if ((FavVideoView.e(this.mEC) != null) && (FavVideoView.e(this.mEC).getVisibility() != 8)) {
      FavVideoView.e(this.mEC).setVisibility(8);
    }
    AppMethodBeat.o(74719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.6
 * JD-Core Version:    0.7.0.1
 */