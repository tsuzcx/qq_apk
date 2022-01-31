package com.tencent.mm.plugin.brandservice.ui.b;

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
    Iterator localIterator = this.gFL.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      ((a)g.r(a.class)).d(localq.field_msgId, localq.field_content);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c.2
 * JD-Core Version:    0.7.0.1
 */