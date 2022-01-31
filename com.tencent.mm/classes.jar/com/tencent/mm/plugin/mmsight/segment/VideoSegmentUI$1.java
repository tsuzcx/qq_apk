package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSegmentUI$1
  implements Runnable
{
  VideoSegmentUI$1(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.VideoSegmentUI", "has connect");
    if (CaptureMMProxy.getInstance() != null) {
      q.fa(CaptureMMProxy.getInstance().getDeviceInfoConfig());
    }
    VideoSegmentUI.a(this.mnw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.1
 * JD-Core Version:    0.7.0.1
 */