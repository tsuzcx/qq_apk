package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
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
    AppMethodBeat.i(21698);
    synchronized (b.aCw())
    {
      Set localSet = (Set)b.aCw().get(Integer.valueOf(this.vcK.getType()));
      if ((localSet != null) && (localSet.size() > 0))
      {
        ??? = new HashSet();
        ((Set)???).addAll(localSet);
        ??? = ((Set)???).iterator();
        while (((Iterator)???).hasNext())
        {
          h localh = (h)((Iterator)???).next();
          if ((localh != null) && (localSet.contains(localh))) {
            localh.onSceneEnd(this.val$errType, this.val$errCode, this.val$errMsg, this.vcK);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b.2
 * JD-Core Version:    0.7.0.1
 */