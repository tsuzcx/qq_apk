package com.tencent.mm.plugin.mmsight.segment;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.platformtools.ad;

final class VideoSegmentUI$4
  implements a.d
{
  VideoSegmentUI$4(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void ai(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94468);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ad.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(VideoSegmentUI.q(this.tHP)) });
      AppMethodBeat.o(94468);
      return;
    }
    if (VideoSegmentUI.q(this.tHP))
    {
      ad.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
      AppMethodBeat.o(94468);
      return;
    }
    ad.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    VideoSegmentUI.r(this.tHP);
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      ad.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      VideoSegmentUI.m(this.tHP);
      this.tHP.finish();
      VideoSegmentUI.b(this.tHP);
      AppMethodBeat.o(94468);
      return;
    }
    VideoSegmentUI.a locala = new VideoSegmentUI.a(this.tHP, VideoSegmentUI.s(this.tHP), paramInt2, paramInt1, paramInt3, new VideoSegmentUI.b(this.tHP, (byte)0), (byte)0);
    if ((VideoSegmentUI.s(this.tHP).getWidth() <= 0) || (VideoSegmentUI.s(this.tHP).getHeight() <= 0))
    {
      ad.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
      VideoSegmentUI.s(this.tHP).post(locala);
      AppMethodBeat.o(94468);
      return;
    }
    locala.run();
    AppMethodBeat.o(94468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.4
 * JD-Core Version:    0.7.0.1
 */