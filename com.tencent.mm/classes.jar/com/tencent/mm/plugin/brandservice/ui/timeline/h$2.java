package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(5931);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mXJ.mXH.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)((Map.Entry)localIterator.next()).getValue();
      localLinkedList.add(locala);
      if (locala.CKc == 0) {
        localStringBuilder.append(locala.ePa).append(",").append(locala.CKh).append(" ");
      }
    }
    ad.i("MicroMsg.BizTimeLineReport", "reportExpose %s.", new Object[] { localStringBuilder.toString() });
    g.afA().gcy.a(new l(localLinkedList, this.mXJ.mXF, this.mXJ.mXG, this.mXJ.dcS), 0);
    AppMethodBeat.o(5931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.h.2
 * JD-Core Version:    0.7.0.1
 */