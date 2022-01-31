package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.protocal.c.bxq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class BizTimeLineHotView$5
  implements Runnable
{
  BizTimeLineHotView$5(BizTimeLineHotView paramBizTimeLineHotView, bxp parambxp) {}
  
  public final void run()
  {
    boolean bool = false;
    BizTimeLineHotView.a(this.ihA, new ArrayList());
    Object localObject = this.ihD.tNF.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      bxq localbxq = (bxq)((Iterator)localObject).next();
      int j = i + 1;
      if (j > 12) {
        break;
      }
      b localb = new b();
      i = j;
      if (s.hk(localbxq.sxi))
      {
        localb.sxi = localbxq.sxi;
        BizTimeLineHotView.a(this.ihA).add(localb);
        i = j;
      }
    }
    this.ihA.ayf();
    localObject = this.ihA;
    if (this.ihD.tNH == 1) {
      bool = true;
    }
    BizTimeLineHotView.a((BizTimeLineHotView)localObject, bool);
    BizTimeLineHotView.b(this.ihA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.5
 * JD-Core Version:    0.7.0.1
 */