package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
public final class MPVideoView$i
  implements d.i
{
  public final int bUQ()
  {
    AppMethodBeat.i(7491);
    MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVn);
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    int i = localMPExoVideoWrapper.getCacheTimeSec();
    AppMethodBeat.o(7491);
    return i;
  }
  
  public final int bUR()
  {
    AppMethodBeat.i(7492);
    MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVn);
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7492);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.i
 * JD-Core Version:    0.7.0.1
 */