package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

final class FavVideoView$1
  implements Runnable
{
  FavVideoView$1(FavVideoView paramFavVideoView, boolean paramBoolean) {}
  
  public final void run()
  {
    y.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[] { Boolean.valueOf(this.iuL) });
    View localView = (View)FavVideoView.a(this.kjX);
    if (this.iuL)
    {
      localView.setAlpha(1.0F);
      localView.setVisibility(0);
      FavVideoView.b(this.kjX).setVisibility(8);
      return;
    }
    localView.setVisibility(8);
    FavVideoView.b(this.kjX).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.1
 * JD-Core Version:    0.7.0.1
 */