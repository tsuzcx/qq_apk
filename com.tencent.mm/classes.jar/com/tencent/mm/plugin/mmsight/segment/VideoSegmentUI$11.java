package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSegmentUI$11
  implements a.c
{
  VideoSegmentUI$11(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void bt(Object paramObject)
  {
    try
    {
      if (VideoSegmentUI.d(this.mnw) != null) {
        VideoSegmentUI.d(this.mnw).start();
      }
      return;
    }
    catch (Exception paramObject)
    {
      y.printErrStackTrace("MicroMsg.VideoSegmentUI", paramObject, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.11
 * JD-Core Version:    0.7.0.1
 */