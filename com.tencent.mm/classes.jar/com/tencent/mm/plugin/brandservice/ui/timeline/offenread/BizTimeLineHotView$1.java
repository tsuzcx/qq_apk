package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.mm.model.s;
import java.util.Iterator;
import java.util.List;

final class BizTimeLineHotView$1
  implements Runnable
{
  BizTimeLineHotView$1(BizTimeLineHotView paramBizTimeLineHotView, String paramString) {}
  
  public final void run()
  {
    if (BizTimeLineHotView.a(this.ihA) == null) {}
    b localb;
    do
    {
      do
      {
        Iterator localIterator;
        do
        {
          return;
          while ((this.dAA == null) || (s.hK(this.dAA))) {}
          localIterator = BizTimeLineHotView.a(this.ihA).iterator();
        } while (!localIterator.hasNext());
        localb = (b)localIterator.next();
      } while (!this.dAA.equals(localb.sxi));
    } while (!BizTimeLineHotView.a(localb));
    BizTimeLineHotView.a(this.ihA, localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.1
 * JD-Core Version:    0.7.0.1
 */