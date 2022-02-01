package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$10
  implements Runnable
{
  AbstractVideoView$10(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(235187);
    if ((this.mEV.mEB != null) && (this.mEV.mEB.getVisibility() != 0)) {
      this.mEV.mEB.setVisibility(0);
    }
    AppMethodBeat.o(235187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.10
 * JD-Core Version:    0.7.0.1
 */