package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$11
  implements Runnable
{
  AbstractVideoView$11(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(328877);
    if ((this.sJt.sIZ != null) && (this.sJt.sIZ.getVisibility() != 8)) {
      this.sJt.sIZ.setVisibility(8);
    }
    AppMethodBeat.o(328877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.11
 * JD-Core Version:    0.7.0.1
 */