package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.g;
import java.util.concurrent.ConcurrentHashMap;

final class l$6
  implements Runnable
{
  l$6(l paraml, long paramLong, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(78329);
    n localn = n.ahs();
    long l1 = this.fFS;
    long l2 = this.fFB;
    long l3 = this.fFV;
    if (localn.fFZ.containsKey(Long.valueOf(l1))) {}
    for (n.d locald = (n.d)localn.fFZ.get(Long.valueOf(l1));; locald = new n.d())
    {
      locald.offset = l3;
      locald.czn = l2;
      localn.fFZ.put(Long.valueOf(l1), locald);
      l.F(this.fFT).a(this.fFV, this.fFB, this.fFT);
      AppMethodBeat.o(78329);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.at.l.6
 * JD-Core Version:    0.7.0.1
 */