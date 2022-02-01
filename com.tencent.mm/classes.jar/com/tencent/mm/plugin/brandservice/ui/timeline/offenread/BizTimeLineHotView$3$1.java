package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.al.a;
import java.util.Iterator;
import java.util.List;

final class BizTimeLineHotView$3$1
  implements Runnable
{
  BizTimeLineHotView$3$1(BizTimeLineHotView.3 param3, al paramal) {}
  
  public final void run()
  {
    AppMethodBeat.i(224129);
    Iterator localIterator = BizTimeLineHotView.a(this.qQb.omP).iterator();
    b localb;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localb = (b)localIterator.next();
    } while (!this.qQa.dmb.userName.equals(localb.FQp));
    for (;;)
    {
      if (localb != null) {
        BizTimeLineHotView.a(this.qQb.omP).remove(localb);
      }
      BizTimeLineHotView.b(this.qQb.omP);
      AppMethodBeat.o(224129);
      return;
      localb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.3.1
 * JD-Core Version:    0.7.0.1
 */