package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.a.c.a;

final class VideoSegmentUI$3
  implements c.a
{
  private Runnable mnx;
  
  VideoSegmentUI$3(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void ui(int paramInt)
  {
    if (VideoSegmentUI.j(this.mnw) == null) {
      return;
    }
    if (this.mnx != null) {
      ((View)VideoSegmentUI.j(this.mnw)).removeCallbacks(this.mnx);
    }
    this.mnx = new VideoSegmentUI.c(VideoSegmentUI.j(this.mnw), paramInt, VideoSegmentUI.e(this.mnw));
    ((View)VideoSegmentUI.j(this.mnw)).post(this.mnx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.3
 * JD-Core Version:    0.7.0.1
 */