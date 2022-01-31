package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
public final class MPVideoView$h
  implements d.h
{
  public final int aEV()
  {
    AppMethodBeat.i(153014);
    MPVideoWrapper localMPVideoWrapper = MPVideoView.i(this.kjR);
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    int i = localMPVideoWrapper.getCacheTimeSec();
    AppMethodBeat.o(153014);
    return i;
  }
  
  public final int aEW()
  {
    AppMethodBeat.i(153015);
    MPVideoWrapper localMPVideoWrapper = MPVideoView.i(this.kjR);
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    int i = localMPVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(153015);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.h
 * JD-Core Version:    0.7.0.1
 */