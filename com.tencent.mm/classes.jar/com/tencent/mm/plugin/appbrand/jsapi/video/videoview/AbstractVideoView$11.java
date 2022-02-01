package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$11
  implements Runnable
{
  AbstractVideoView$11(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(235188);
    if ((this.mEV.mEB != null) && (this.mEV.mEB.getVisibility() != 8)) {
      this.mEV.mEB.setVisibility(8);
    }
    AppMethodBeat.o(235188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.11
 * JD-Core Version:    0.7.0.1
 */