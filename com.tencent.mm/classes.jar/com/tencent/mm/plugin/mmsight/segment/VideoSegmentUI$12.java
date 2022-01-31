package com.tencent.mm.plugin.mmsight.segment;

import android.widget.Toast;
import com.tencent.mm.plugin.u.a.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class VideoSegmentUI$12
  implements c.a
{
  VideoSegmentUI$12(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void hw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Toast.makeText(this.mnw, a.h.mmsight_clip_failed, 1).show();
      y.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
      VideoSegmentUI.m(this.mnw);
      this.mnw.finish();
      VideoSegmentUI.b(this.mnw);
      return;
    }
    if ((!this.mnw.isFinishing()) && (VideoSegmentUI.j(this.mnw) != null))
    {
      VideoSegmentUI.a(this.mnw, VideoSegmentUI.j(this.mnw).getDurationMs());
      y.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", new Object[] { Integer.valueOf(VideoSegmentUI.e(this.mnw)) });
    }
    try
    {
      if (VideoSegmentUI.d(this.mnw) != null) {
        VideoSegmentUI.d(this.mnw).setLoop((int)(VideoSegmentUI.e(this.mnw) * VideoSegmentUI.j(this.mnw).bjK()), (int)(VideoSegmentUI.e(this.mnw) * VideoSegmentUI.j(this.mnw).bjL()));
      }
      label176:
      VideoSegmentUI.o(this.mnw).countDown();
      return;
    }
    catch (Exception localException)
    {
      break label176;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.12
 * JD-Core Version:    0.7.0.1
 */