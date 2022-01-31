package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$2
  implements Runnable
{
  b$2(b paramb, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(17639);
    synchronized (b.ajx())
    {
      Set localSet = (Set)b.ajx().get(Integer.valueOf(this.jFn.getType()));
      if ((localSet != null) && (localSet.size() > 0))
      {
        ??? = new HashSet();
        ((Set)???).addAll(localSet);
        ??? = ((Set)???).iterator();
        while (((Iterator)???).hasNext())
        {
          f localf = (f)((Iterator)???).next();
          if ((localf != null) && (localSet.contains(localf))) {
            localf.onSceneEnd(this.val$errType, this.val$errCode, this.ftO, this.jFn);
          }
        }
      }
    }
    AppMethodBeat.o(17639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b.2
 * JD-Core Version:    0.7.0.1
 */