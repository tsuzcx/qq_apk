package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$11
  implements Runnable
{
  AbstractVideoView$11(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(206479);
    if ((this.lty.lte != null) && (this.lty.lte.getVisibility() != 8)) {
      this.lty.lte.setVisibility(8);
    }
    AppMethodBeat.o(206479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.11
 * JD-Core Version:    0.7.0.1
 */