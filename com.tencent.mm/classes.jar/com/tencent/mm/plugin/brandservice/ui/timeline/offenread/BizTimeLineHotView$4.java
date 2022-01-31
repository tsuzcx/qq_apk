package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class BizTimeLineHotView$4
  implements Runnable
{
  BizTimeLineHotView$4(BizTimeLineHotView paramBizTimeLineHotView, ckd paramckd) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(14310);
    BizTimeLineHotView.a(this.jZn, new ArrayList());
    Object localObject = this.jZq.xUg.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      cke localcke = (cke)((Iterator)localObject).next();
      int j = i + 1;
      if (j > 12) {
        break;
      }
      b localb = new b();
      i = j;
      if (t.nT(localcke.wqR))
      {
        localb.wqR = localcke.wqR;
        BizTimeLineHotView.a(this.jZn).add(localb);
        i = j;
      }
    }
    this.jZn.aXa();
    localObject = this.jZn;
    if (this.jZq.xUi == 1) {
      bool = true;
    }
    BizTimeLineHotView.a((BizTimeLineHotView)localObject, bool);
    BizTimeLineHotView.b(this.jZn);
    AppMethodBeat.o(14310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.4
 * JD-Core Version:    0.7.0.1
 */