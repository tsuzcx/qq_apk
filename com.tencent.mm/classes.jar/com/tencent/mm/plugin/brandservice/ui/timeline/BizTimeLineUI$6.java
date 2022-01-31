package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BizTimeLineUI$6
  implements Runnable
{
  BizTimeLineUI$6(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(14188);
    BizTimeLineUI.n(this.jXh);
    if (!this.jXh.isFinishing())
    {
      this.jXh.aWS();
      AppMethodBeat.o(14188);
      return;
    }
    ab.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
    AppMethodBeat.o(14188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.6
 * JD-Core Version:    0.7.0.1
 */