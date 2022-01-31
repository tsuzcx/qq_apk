package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.c.a;

final class VideoSegmentUI$3
  implements c.a
{
  private Runnable oMF;
  
  VideoSegmentUI$3(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void zx(int paramInt)
  {
    AppMethodBeat.i(55032);
    if (VideoSegmentUI.j(this.oME) == null)
    {
      AppMethodBeat.o(55032);
      return;
    }
    if (this.oMF != null) {
      ((View)VideoSegmentUI.j(this.oME)).removeCallbacks(this.oMF);
    }
    this.oMF = new VideoSegmentUI.c(VideoSegmentUI.j(this.oME), paramInt, VideoSegmentUI.e(this.oME));
    ((View)VideoSegmentUI.j(this.oME)).post(this.oMF);
    AppMethodBeat.o(55032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.3
 * JD-Core Version:    0.7.0.1
 */