package com.tencent.mm.plugin.mmsight.segment;

import android.widget.RelativeLayout;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSegmentUI$4
  implements a.d
{
  VideoSegmentUI$4(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void O(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      y.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(VideoSegmentUI.q(this.mnw)) });
      return;
    }
    if (VideoSegmentUI.q(this.mnw))
    {
      y.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
      return;
    }
    y.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    VideoSegmentUI.r(this.mnw);
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      y.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      VideoSegmentUI.m(this.mnw);
      this.mnw.finish();
      VideoSegmentUI.b(this.mnw);
      return;
    }
    VideoSegmentUI.a locala = new VideoSegmentUI.a(this.mnw, VideoSegmentUI.s(this.mnw), paramInt2, paramInt1, paramInt3, new VideoSegmentUI.b(this.mnw, (byte)0), (byte)0);
    if ((VideoSegmentUI.s(this.mnw).getWidth() <= 0) || (VideoSegmentUI.s(this.mnw).getHeight() <= 0))
    {
      y.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
      VideoSegmentUI.s(this.mnw).post(locala);
      return;
    }
    locala.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.4
 * JD-Core Version:    0.7.0.1
 */