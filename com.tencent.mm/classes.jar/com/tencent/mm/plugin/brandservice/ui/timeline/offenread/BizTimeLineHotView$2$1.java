package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.mm.h.a.ag;
import com.tencent.mm.h.a.ag.a;
import java.util.Iterator;
import java.util.List;

final class BizTimeLineHotView$2$1
  implements Runnable
{
  BizTimeLineHotView$2$1(BizTimeLineHotView.2 param2, ag paramag) {}
  
  public final void run()
  {
    Iterator localIterator = BizTimeLineHotView.a(this.ihC.ihA).iterator();
    b localb;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localb = (b)localIterator.next();
    } while (!this.ihB.bGi.userName.equals(localb.sxi));
    for (;;)
    {
      if (localb != null) {
        BizTimeLineHotView.a(this.ihC.ihA).remove(localb);
      }
      BizTimeLineHotView.b(this.ihC.ihA);
      return;
      localb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.2.1
 * JD-Core Version:    0.7.0.1
 */