package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$10
  implements Runnable
{
  AbstractVideoView$10(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(328880);
    if ((this.sJt.sIZ != null) && (this.sJt.sIZ.getVisibility() != 0)) {
      this.sJt.sIZ.setVisibility(0);
    }
    AppMethodBeat.o(328880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.10
 * JD-Core Version:    0.7.0.1
 */