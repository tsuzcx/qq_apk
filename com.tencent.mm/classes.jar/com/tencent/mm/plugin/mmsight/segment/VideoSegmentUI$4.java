package com.tencent.mm.plugin.mmsight.segment;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.platformtools.ac;

final class VideoSegmentUI$4
  implements a.d
{
  VideoSegmentUI$4(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void ak(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94468);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ac.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(VideoSegmentUI.q(this.uQl)) });
      AppMethodBeat.o(94468);
      return;
    }
    if (VideoSegmentUI.q(this.uQl))
    {
      ac.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
      AppMethodBeat.o(94468);
      return;
    }
    ac.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    VideoSegmentUI.r(this.uQl);
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      ac.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      VideoSegmentUI.m(this.uQl);
      this.uQl.finish();
      VideoSegmentUI.b(this.uQl);
      AppMethodBeat.o(94468);
      return;
    }
    VideoSegmentUI.a locala = new VideoSegmentUI.a(this.uQl, VideoSegmentUI.s(this.uQl), paramInt2, paramInt1, paramInt3, new VideoSegmentUI.b(this.uQl, (byte)0), (byte)0);
    if ((VideoSegmentUI.s(this.uQl).getWidth() <= 0) || (VideoSegmentUI.s(this.uQl).getHeight() <= 0))
    {
      ac.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
      VideoSegmentUI.s(this.uQl).post(locala);
      AppMethodBeat.o(94468);
      return;
    }
    locala.run();
    AppMethodBeat.o(94468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.4
 * JD-Core Version:    0.7.0.1
 */