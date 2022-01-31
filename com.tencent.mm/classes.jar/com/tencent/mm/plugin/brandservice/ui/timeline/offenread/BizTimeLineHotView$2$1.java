package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ah.a;
import java.util.Iterator;
import java.util.List;

final class BizTimeLineHotView$2$1
  implements Runnable
{
  BizTimeLineHotView$2$1(BizTimeLineHotView.2 param2, ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(14306);
    Iterator localIterator = BizTimeLineHotView.a(this.jZp.jZn).iterator();
    b localb;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localb = (b)localIterator.next();
    } while (!this.jZo.cnr.userName.equals(localb.wqR));
    for (;;)
    {
      if (localb != null) {
        BizTimeLineHotView.a(this.jZp.jZn).remove(localb);
      }
      BizTimeLineHotView.b(this.jZp.jZn);
      AppMethodBeat.o(14306);
      return;
      localb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.2.1
 * JD-Core Version:    0.7.0.1
 */