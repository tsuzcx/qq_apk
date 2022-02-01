package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class g$2
  implements Runnable
{
  g$2(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(5931);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.obo.obm.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      g.a locala = (g.a)((Map.Entry)localIterator.next()).getValue();
      localLinkedList.add(locala);
      if (locala.FIB == 0) {
        localStringBuilder.append(locala.fkx).append(",").append(locala.FIG).append(" ");
      }
    }
    ad.i("MicroMsg.BizTimeLineReport", "reportExpose %s.", new Object[] { localStringBuilder.toString() });
    com.tencent.mm.kernel.g.ajB().gAO.a(new k(localLinkedList, this.obo.obk, this.obo.obl, this.obo.dlK), 0);
    AppMethodBeat.o(5931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g.2
 * JD-Core Version:    0.7.0.1
 */