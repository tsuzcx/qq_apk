package com.tencent.mm.plugin.fav.ui.widget;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class FavVideoView$4
  implements Runnable
{
  FavVideoView$4(FavVideoView paramFavVideoView, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if ((FavVideoView.d(this.kjX) != null) && (FavVideoView.d(this.kjX).getVisibility() != 8)) {
      FavVideoView.d(this.kjX).setVisibility(8);
    }
    if (FavVideoView.e(this.kjX) != null)
    {
      if (FavVideoView.e(this.kjX).getVisibility() != 0) {
        FavVideoView.e(this.kjX).setVisibility(0);
      }
      y.i("MicroMsg.FavVideoView", "download video update progress offset:%d  total: %d", new Object[] { Integer.valueOf(this.ejr), Integer.valueOf(this.epd) });
      if ((FavVideoView.e(this.kjX).getMax() != this.epd) && (this.epd > 0)) {
        FavVideoView.e(this.kjX).setMax(this.epd);
      }
      FavVideoView.e(this.kjX).setProgress(this.ejr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.4
 * JD-Core Version:    0.7.0.1
 */