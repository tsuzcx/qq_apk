package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.plugin.appbrand.config.q;

final class g$7
  implements Runnable
{
  g$7(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(131783);
    Object localObject = q.Ap(this.ikV.username);
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        com.tencent.mm.modelappbrand.a.b.acD().qx(str);
        i += 1;
      }
    }
    if (g.access$900())
    {
      localObject = new k(12);
      com.tencent.mm.kernel.g.RK().eHt.a((m)localObject, 0);
    }
    AppMethodBeat.o(131783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.7
 * JD-Core Version:    0.7.0.1
 */