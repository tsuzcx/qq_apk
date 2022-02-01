package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class t$7
  implements Runnable
{
  t$7(t paramt, int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(195902);
    Set localSet = (Set)t.j(this.lCP).get(Integer.valueOf(-1));
    Object localObject1;
    if ((localSet != null) && (localSet.size() > 0)) {
      localObject1 = new HashSet();
    }
    try
    {
      ((Set)localObject1).addAll(localSet);
      localObject1 = ((Set)localObject1).iterator();
      i locali;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        locali = (i)((Iterator)localObject1).next();
      } while ((locali == null) || (!localSet.contains(locali)));
      return;
    }
    finally
    {
      AppMethodBeat.o(195902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.t.7
 * JD-Core Version:    0.7.0.1
 */