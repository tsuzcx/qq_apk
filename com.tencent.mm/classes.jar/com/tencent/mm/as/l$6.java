package com.tencent.mm.as;

import com.tencent.mm.ah.g;
import java.util.concurrent.ConcurrentHashMap;

final class l$6
  implements Runnable
{
  l$6(l paraml, long paramLong, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    n localn = n.OA();
    long l1 = this.eps;
    long l2 = this.epd;
    long l3 = this.epv;
    if (localn.epz.containsKey(Long.valueOf(l1))) {}
    for (n.d locald = (n.d)localn.epz.get(Long.valueOf(l1));; locald = new n.d())
    {
      locald.pj = l3;
      locald.bRM = l2;
      localn.epz.put(Long.valueOf(l1), locald);
      l.F(this.ept).a(this.epv, this.epd, this.ept);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.as.l.6
 * JD-Core Version:    0.7.0.1
 */