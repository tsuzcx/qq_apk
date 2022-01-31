package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import java.util.Iterator;
import java.util.List;

final class BizTimeLineHotView$1
  implements Runnable
{
  BizTimeLineHotView$1(BizTimeLineHotView paramBizTimeLineHotView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(14305);
    if (BizTimeLineHotView.a(this.jZn) == null)
    {
      AppMethodBeat.o(14305);
      return;
    }
    if ((this.euc == null) || (t.ot(this.euc)))
    {
      AppMethodBeat.o(14305);
      return;
    }
    Iterator localIterator = BizTimeLineHotView.a(this.jZn).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (this.euc.equals(localb.wqR)) {
        if (BizTimeLineHotView.a(localb))
        {
          BizTimeLineHotView.a(this.jZn, localb);
          AppMethodBeat.o(14305);
          return;
        }
      }
    }
    AppMethodBeat.o(14305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.1
 * JD-Core Version:    0.7.0.1
 */