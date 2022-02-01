package com.tencent.liteav.trtc.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$154
  implements Runnable
{
  TRTCCloudImpl$154(TRTCCloudImpl paramTRTCCloudImpl, TXCloudVideoView paramTXCloudVideoView1, TXCloudVideoView paramTXCloudVideoView2) {}
  
  public void run()
  {
    AppMethodBeat.i(187404);
    if (this.val$view != null) {
      this.val$view.removeVideoView();
    }
    if (this.val$subView != null) {
      this.val$subView.removeVideoView();
    }
    AppMethodBeat.o(187404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.154
 * JD-Core Version:    0.7.0.1
 */