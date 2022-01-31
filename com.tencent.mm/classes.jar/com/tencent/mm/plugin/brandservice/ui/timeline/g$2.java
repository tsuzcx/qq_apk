package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
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
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.igK.igI.entrySet().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add((g.a)((Map.Entry)localIterator.next()).getValue());
    }
    com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.brandservice.b.g(localLinkedList, this.igK.igF, this.igK.igG, this.igK.igH), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g.2
 * JD-Core Version:    0.7.0.1
 */