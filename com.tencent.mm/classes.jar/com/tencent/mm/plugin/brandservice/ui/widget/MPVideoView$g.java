package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
public final class MPVideoView$g
  implements d.d
{
  public final void aRo()
  {
    AppMethodBeat.i(7488);
    Log.i(MPVideoView.access$getTAG$cp(), "onSeekPre");
    if (this.sVn.isPlaying()) {
      this.sVn.cEH();
    }
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(7488);
  }
  
  public final void tY(int paramInt)
  {
    AppMethodBeat.i(7489);
    MPVideoView.a(this.sVn, paramInt * 1000);
    MPVideoView.m(this.sVn);
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(7489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.g
 * JD-Core Version:    0.7.0.1
 */