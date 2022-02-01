package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isPlay", "", "onPlayStatusChange"})
final class VideoLiteUI$b
  implements VideoLiteControBar.a
{
  VideoLiteUI$b(VideoLiteUI paramVideoLiteUI) {}
  
  public final void jp(boolean paramBoolean)
  {
    AppMethodBeat.i(209141);
    ImageView localImageView = VideoLiteUI.a(this.owz);
    if (localImageView != null)
    {
      if (paramBoolean) {}
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(209141);
        return;
      }
    }
    AppMethodBeat.o(209141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI.b
 * JD-Core Version:    0.7.0.1
 */