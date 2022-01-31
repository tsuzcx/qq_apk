package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class BizVideoDetailUI$x
  implements Runnable
{
  BizVideoDetailUI$x(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(152838);
    View localView = BizVideoDetailUI.a(this.kgi);
    j.p(localView, "refreshMask");
    localView.setVisibility(0);
    AppMethodBeat.o(152838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.x
 * JD-Core Version:    0.7.0.1
 */