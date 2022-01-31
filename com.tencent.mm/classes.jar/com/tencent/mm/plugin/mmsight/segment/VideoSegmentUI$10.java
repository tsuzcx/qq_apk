package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSegmentUI$10
  implements a.b
{
  VideoSegmentUI$10(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void bW(Object paramObject)
  {
    AppMethodBeat.i(55041);
    ab.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[] { paramObject });
    try
    {
      if (VideoSegmentUI.d(this.oME) != null)
      {
        VideoSegmentUI.n(this.oME);
        VideoSegmentUI.d(this.oME).start();
      }
      AppMethodBeat.o(55041);
      return;
    }
    catch (Exception paramObject)
    {
      ab.printErrStackTrace("MicroMsg.VideoSegmentUI", paramObject, "hy: exception when onPrepared waiting for starting", new Object[0]);
      AppMethodBeat.o(55041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.10
 * JD-Core Version:    0.7.0.1
 */