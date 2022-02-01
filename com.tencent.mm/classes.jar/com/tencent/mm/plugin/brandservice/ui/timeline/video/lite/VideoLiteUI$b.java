package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isPlay", "", "onPlayStatusChange"})
final class VideoLiteUI$b
  implements VideoLiteControBar.a
{
  VideoLiteUI$b(VideoLiteUI paramVideoLiteUI) {}
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(210107);
    ImageView localImageView = VideoLiteUI.a(this.oqd);
    if (localImageView != null)
    {
      if (paramBoolean) {}
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(210107);
        return;
      }
    }
    AppMethodBeat.o(210107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI.b
 * JD-Core Version:    0.7.0.1
 */