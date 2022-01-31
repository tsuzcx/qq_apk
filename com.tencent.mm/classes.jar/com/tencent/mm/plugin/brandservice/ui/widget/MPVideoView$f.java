package com.tencent.mm.plugin.brandservice.ui.widget;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
public final class MPVideoView$f
  implements d.c
{
  public final void aFf()
  {
    AppMethodBeat.i(153011);
    ab.i(MPVideoView.access$getTAG$cp(), "onSeekPre");
    AppMethodBeat.o(153011);
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(153012);
    MPVideoView.a(this.kjR, paramInt);
    MPVideoView.c localc = MPVideoView.m(this.kjR);
    if (localc != null)
    {
      localc.aZE();
      AppMethodBeat.o(153012);
      return;
    }
    AppMethodBeat.o(153012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.f
 * JD-Core Version:    0.7.0.1
 */