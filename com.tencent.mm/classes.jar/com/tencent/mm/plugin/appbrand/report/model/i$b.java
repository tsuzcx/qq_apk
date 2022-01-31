package com.tencent.mm.plugin.appbrand.report.model;

import android.support.v4.f.k.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

final class i$b
  implements k.a<i.a>
{
  private final Queue<i.a> gYM = new ConcurrentLinkedQueue();
  
  public final boolean a(i.a parama)
  {
    return this.gYM.offer(parama);
  }
  
  public final i.a aoq()
  {
    i.a locala2 = (i.a)this.gYM.poll();
    i.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new i.a((byte)0);
    }
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.b
 * JD-Core Version:    0.7.0.1
 */