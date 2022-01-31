package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSegmentUI$10
  implements a.b
{
  VideoSegmentUI$10(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void bs(Object paramObject)
  {
    y.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[] { paramObject });
    try
    {
      if (VideoSegmentUI.d(this.mnw) != null)
      {
        VideoSegmentUI.n(this.mnw);
        VideoSegmentUI.d(this.mnw).start();
      }
      return;
    }
    catch (Exception paramObject)
    {
      y.printErrStackTrace("MicroMsg.VideoSegmentUI", paramObject, "hy: exception when onPrepared waiting for starting", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.10
 * JD-Core Version:    0.7.0.1
 */