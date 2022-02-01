package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    Iterator localIterator = this.ohe.ohc.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      g.a locala = (g.a)((Map.Entry)localIterator.next()).getValue();
      if (!bu.isNullOrNil(locala.udb))
      {
        MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.ovZ;
        locala.Gbq = MPVideoPreviewMgr.aIK(locala.udb);
        localMPVideoPreviewMgr = MPVideoPreviewMgr.ovZ;
        locala.Gbr = MPVideoPreviewMgr.aJf(locala.udb);
      }
      localLinkedList.add(locala);
      if (locala.GaY == 0) {
        localStringBuilder.append(locala.fmu).append(",").append(locala.Gbd).append(" ");
      }
    }
    ae.i("MicroMsg.BizTimeLineReport", "reportExpose %s.", new Object[] { localStringBuilder.toString() });
    com.tencent.mm.kernel.g.ajQ().gDv.a(new k(localLinkedList, this.ohe.oha, this.ohe.ohb, this.ohe.dmM), 0);
    AppMethodBeat.o(5931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g.2
 * JD-Core Version:    0.7.0.1
 */