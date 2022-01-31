package com.tencent.mm.plugin.fav.ui.widget;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class FavVideoView$4
  implements Runnable
{
  FavVideoView$4(FavVideoView paramFavVideoView, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(74717);
    if ((FavVideoView.d(this.mEC) != null) && (FavVideoView.d(this.mEC).getVisibility() != 8)) {
      FavVideoView.d(this.mEC).setVisibility(8);
    }
    if (FavVideoView.e(this.mEC) != null)
    {
      if (FavVideoView.e(this.mEC).getVisibility() != 0) {
        FavVideoView.e(this.mEC).setVisibility(0);
      }
      ab.i("MicroMsg.FavVideoView", "download video update progress offset:%d  total: %d", new Object[] { Integer.valueOf(this.fzv), Integer.valueOf(this.fFB) });
      if ((FavVideoView.e(this.mEC).getMax() != this.fFB) && (this.fFB > 0)) {
        FavVideoView.e(this.mEC).setMax(this.fFB);
      }
      FavVideoView.e(this.mEC).setProgress(this.fzv);
    }
    AppMethodBeat.o(74717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.4
 * JD-Core Version:    0.7.0.1
 */