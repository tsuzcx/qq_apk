package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class VideoCompressUI$1
  implements Runnable
{
  VideoCompressUI$1(VideoCompressUI paramVideoCompressUI) {}
  
  public final void run()
  {
    VideoCompressUI.a(this.mni, CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara());
    if (VideoCompressUI.a(this.mni) == null)
    {
      y.e("VideoCompressUI", "VideoSendPreprocessTask para is null");
      this.mni.setResult(0);
      this.mni.finish();
      return;
    }
    e.post(VideoCompressUI.b(this.mni), "video_remuxing_if_needed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.1
 * JD-Core Version:    0.7.0.1
 */