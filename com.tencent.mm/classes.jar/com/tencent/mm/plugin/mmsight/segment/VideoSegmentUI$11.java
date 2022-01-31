package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSegmentUI$11
  implements a.c
{
  VideoSegmentUI$11(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void bX(Object paramObject)
  {
    AppMethodBeat.i(55042);
    try
    {
      if (VideoSegmentUI.d(this.oME) != null) {
        VideoSegmentUI.d(this.oME).start();
      }
      AppMethodBeat.o(55042);
      return;
    }
    catch (Exception paramObject)
    {
      ab.printErrStackTrace("MicroMsg.VideoSegmentUI", paramObject, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
      AppMethodBeat.o(55042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.11
 * JD-Core Version:    0.7.0.1
 */