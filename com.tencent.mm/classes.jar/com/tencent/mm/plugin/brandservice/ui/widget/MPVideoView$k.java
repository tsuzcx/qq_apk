package com.tencent.mm.plugin.brandservice.ui.widget;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "visible", "", "onVisibilityChanged"})
final class MPVideoView$k
  implements d.e
{
  MPVideoView$k(MPVideoView paramMPVideoView) {}
  
  public final void onVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(153018);
    MPVideoView.C(this.kjR);
    MPVideoView.c localc = MPVideoView.m(this.kjR);
    if (localc != null)
    {
      localc.fP(paramBoolean);
      AppMethodBeat.o(153018);
      return;
    }
    AppMethodBeat.o(153018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.k
 * JD-Core Version:    0.7.0.1
 */