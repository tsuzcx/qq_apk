package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FavVideoView$1
  implements Runnable
{
  FavVideoView$1(FavVideoView paramFavVideoView, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(74714);
    ab.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[] { Boolean.valueOf(this.kvP) });
    View localView = (View)FavVideoView.a(this.mEC);
    if (this.kvP)
    {
      localView.setAlpha(1.0F);
      localView.setVisibility(0);
      FavVideoView.b(this.mEC).setVisibility(8);
      AppMethodBeat.o(74714);
      return;
    }
    localView.setVisibility(8);
    FavVideoView.b(this.mEC).setVisibility(0);
    AppMethodBeat.o(74714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.1
 * JD-Core Version:    0.7.0.1
 */