package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;

final class AbstractVideoView$6
  implements e.d
{
  AbstractVideoView$6(AbstractVideoView paramAbstractVideoView) {}
  
  public final void aqD() {}
  
  public final void nM(int paramInt)
  {
    AppMethodBeat.i(206474);
    if (this.lty.c(paramInt, true)) {
      this.lty.boP();
    }
    if (this.lty.ltf != null) {
      this.lty.ltf.setIsPlay(true);
    }
    AppMethodBeat.o(206474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.6
 * JD-Core Version:    0.7.0.1
 */