package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class BizTimeLineHotListView$7
  implements Runnable
{
  BizTimeLineHotListView$7(BizTimeLineHotListView paramBizTimeLineHotListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(293087);
    if (this.sJe.isAttachedToWindow()) {
      try
      {
        this.sJe.onDetachedFromWindow();
        Log.i("MicroMsg.BizTimeLineHotListView", "dead onDestroy but has not called onDetachedFromWindow!");
        h.IzE.idkeyStat(1378L, 12L, 1L, false);
        AppMethodBeat.o(293087);
        return;
      }
      catch (Exception localException)
      {
        h.IzE.idkeyStat(1378L, 13L, 1L, false);
        Log.e("MicroMsg.BizTimeLineHotListView", "dead onDetachedFromWindow ex %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(293087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.7
 * JD-Core Version:    0.7.0.1
 */