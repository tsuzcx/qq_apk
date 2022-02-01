package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.z;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"onClick", "", "invoke"})
final class MPVideoPreviewMgr$d
  extends q
  implements kotlin.g.a.a<x>
{
  MPVideoPreviewMgr$d(String paramString, z paramz)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AppMethodBeat.i(265695);
    Object localObject = this.sSD;
    switch (((String)localObject).hashCode())
    {
    }
    do
    {
      localObject = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.aqv(MPVideoPreviewMgr.t(this.sAV));
      localObject = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
      localObject = MPVideoPreviewMgr.sSn;
      com.tencent.mm.plugin.webview.ui.tools.video.a.bnh(MPVideoPreviewMgr.t(this.sAV));
      AppMethodBeat.o(265695);
      return;
    } while (!((String)localObject).equals("PAUSE_FOR_RESUME"));
    localObject = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.aqt("PAUSE_FOR_RESUME");
    AppMethodBeat.o(265695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.d
 * JD-Core Version:    0.7.0.1
 */