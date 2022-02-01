package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ad;

final class VideoSegmentUI$1
  implements Runnable
{
  VideoSegmentUI$1(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(94462);
    ad.i("MicroMsg.VideoSegmentUI", "has connect");
    if (CaptureMMProxy.getInstance() != null) {
      ae.ph(CaptureMMProxy.getInstance().getDeviceInfoConfig());
    }
    VideoSegmentUI.a(this.tHP);
    AppMethodBeat.o(94462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.1
 * JD-Core Version:    0.7.0.1
 */