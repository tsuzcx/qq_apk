package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.storage.q;
import java.util.Iterator;
import java.util.List;

final class c$2
  implements Runnable
{
  c$2(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(14451);
    Iterator localIterator = this.ieO.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq.dvV()) {
        ((a)g.E(a.class)).b(localq.field_msgId, localq.field_content);
      }
    }
    AppMethodBeat.o(14451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c.2
 * JD-Core Version:    0.7.0.1
 */