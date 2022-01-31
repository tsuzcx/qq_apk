package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSegmentUI$1
  implements Runnable
{
  VideoSegmentUI$1(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(55027);
    ab.i("MicroMsg.VideoSegmentUI", "has connect");
    if (CaptureMMProxy.getInstance() != null) {
      ac.ll(CaptureMMProxy.getInstance().getDeviceInfoConfig());
    }
    VideoSegmentUI.a(this.oME);
    AppMethodBeat.o(55027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.1
 * JD-Core Version:    0.7.0.1
 */