package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import java.util.concurrent.ConcurrentHashMap;

final class o$7
  implements Runnable
{
  o$7(o paramo, long paramLong, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(238946);
    q localq = q.bJO();
    long l1 = this.oIC;
    long l2 = this.oIj;
    long l3 = this.oII;
    if (localq.oIL.containsKey(Long.valueOf(l1))) {}
    for (q.d locald = (q.d)localq.oIL.get(Long.valueOf(l1));; locald = new q.d())
    {
      locald.offset = l3;
      locald.total = l2;
      localq.oIL.put(Long.valueOf(l1), locald);
      o.F(this.oID).a(this.oII, this.oIj, this.oID);
      AppMethodBeat.o(238946);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.o.7
 * JD-Core Version:    0.7.0.1
 */