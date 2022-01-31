package com.tencent.mm.plugin.mmsight.segment;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSegmentUI$4
  implements a.d
{
  VideoSegmentUI$4(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void Z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(55033);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(VideoSegmentUI.q(this.oME)) });
      AppMethodBeat.o(55033);
      return;
    }
    if (VideoSegmentUI.q(this.oME))
    {
      ab.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
      AppMethodBeat.o(55033);
      return;
    }
    ab.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    VideoSegmentUI.r(this.oME);
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      ab.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      VideoSegmentUI.m(this.oME);
      this.oME.finish();
      VideoSegmentUI.b(this.oME);
      AppMethodBeat.o(55033);
      return;
    }
    VideoSegmentUI.a locala = new VideoSegmentUI.a(this.oME, VideoSegmentUI.s(this.oME), paramInt2, paramInt1, paramInt3, new VideoSegmentUI.b(this.oME, (byte)0), (byte)0);
    if ((VideoSegmentUI.s(this.oME).getWidth() <= 0) || (VideoSegmentUI.s(this.oME).getHeight() <= 0))
    {
      ab.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
      VideoSegmentUI.s(this.oME).post(locala);
      AppMethodBeat.o(55033);
      return;
    }
    locala.run();
    AppMethodBeat.o(55033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.4
 * JD-Core Version:    0.7.0.1
 */