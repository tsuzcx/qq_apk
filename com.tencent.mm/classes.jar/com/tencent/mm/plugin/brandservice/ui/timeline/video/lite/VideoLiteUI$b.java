package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isPlay", "", "onPlayStatusChange"})
final class VideoLiteUI$b
  implements VideoLiteControBar.a
{
  VideoLiteUI$b(VideoLiteUI paramVideoLiteUI) {}
  
  public final void kr(boolean paramBoolean)
  {
    AppMethodBeat.i(195962);
    ImageView localImageView = VideoLiteUI.a(this.pKd);
    if (localImageView != null)
    {
      if (paramBoolean) {}
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(195962);
        return;
      }
    }
    AppMethodBeat.o(195962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI.b
 * JD-Core Version:    0.7.0.1
 */