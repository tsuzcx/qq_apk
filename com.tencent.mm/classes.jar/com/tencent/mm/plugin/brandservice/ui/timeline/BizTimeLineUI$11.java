package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineUI$11
  implements Runnable
{
  BizTimeLineUI$11(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(5951);
    if ((this.vIB.activityHasDestroyed()) || (this.vIB.isFinishing()))
    {
      AppMethodBeat.o(5951);
      return;
    }
    BizTimeLineUI.p(this.vIB);
    AppMethodBeat.o(5951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.11
 * JD-Core Version:    0.7.0.1
 */