package com.tencent.mm.plugin.brandservice.ui.timeline.a.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    if (c.b(this.iiv).get()) {
      y.e("MicroMsg.Preload.BizAppMsgContextService", "isSyncing, return");
    }
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      localLinkedList.addAll(c.c(this.iiv).values());
      c.c(this.iiv).clear();
    } while (localLinkedList.size() <= 0);
    c.b(this.iiv).set(true);
    c.a(this.iiv, localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.c.2
 * JD-Core Version:    0.7.0.1
 */