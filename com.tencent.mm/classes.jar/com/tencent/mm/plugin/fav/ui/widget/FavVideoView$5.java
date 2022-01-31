package com.tencent.mm.plugin.fav.ui.widget;

import android.widget.ProgressBar;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class FavVideoView$5
  implements Runnable
{
  FavVideoView$5(FavVideoView paramFavVideoView) {}
  
  public final void run()
  {
    if ((FavVideoView.d(this.kjX) != null) && (FavVideoView.d(this.kjX).getVisibility() != 0)) {
      FavVideoView.d(this.kjX).setVisibility(0);
    }
    if ((FavVideoView.e(this.kjX) != null) && (FavVideoView.e(this.kjX).getVisibility() != 8)) {
      FavVideoView.e(this.kjX).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.5
 * JD-Core Version:    0.7.0.1
 */