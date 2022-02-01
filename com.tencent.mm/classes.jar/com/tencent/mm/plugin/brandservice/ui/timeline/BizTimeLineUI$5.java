package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineUI$5
  implements Runnable
{
  BizTimeLineUI$5(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(264719);
    if ((this.sCH.activityHasDestroyed()) || (this.sCH.isFinishing()))
    {
      AppMethodBeat.o(264719);
      return;
    }
    BizTimeLineUI.o(this.sCH);
    AppMethodBeat.o(264719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.5
 * JD-Core Version:    0.7.0.1
 */