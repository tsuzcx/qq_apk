package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isPlay", "", "onPlayStatusChange"})
final class VideoLiteUI$b
  implements VideoLiteControBar.a
{
  VideoLiteUI$b(VideoLiteUI paramVideoLiteUI) {}
  
  public final void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(263617);
    ImageView localImageView = VideoLiteUI.a(this.sSP);
    if (localImageView != null)
    {
      if (paramBoolean) {}
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(263617);
        return;
      }
    }
    AppMethodBeat.o(263617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI.b
 * JD-Core Version:    0.7.0.1
 */