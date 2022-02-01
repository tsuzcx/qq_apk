package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
public final class MPVideoView$i
  implements e.i
{
  public final int bcl()
  {
    AppMethodBeat.i(7491);
    MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.noy);
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    int i = localMPExoVideoWrapper.getCacheTimeSec();
    AppMethodBeat.o(7491);
    return i;
  }
  
  public final int bcm()
  {
    AppMethodBeat.i(7492);
    MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.noy);
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7492);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.i
 * JD-Core Version:    0.7.0.1
 */