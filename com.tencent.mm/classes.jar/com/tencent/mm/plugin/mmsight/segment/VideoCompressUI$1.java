package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoCompressUI$1
  implements Runnable
{
  VideoCompressUI$1(VideoCompressUI paramVideoCompressUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(3695);
    VideoCompressUI.a(this.oMq, CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara());
    if (VideoCompressUI.a(this.oMq) == null)
    {
      ab.e("MicroMsg.VideoCompressUI", "VideoSendPreprocessTask para is null");
      this.oMq.setResult(0);
      this.oMq.finish();
      AppMethodBeat.o(3695);
      return;
    }
    ac.ll(CaptureMMProxy.getInstance().getDeviceInfoConfig());
    d.post(VideoCompressUI.b(this.oMq), "video_remuxing_if_needed");
    AppMethodBeat.o(3695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.1
 * JD-Core Version:    0.7.0.1
 */