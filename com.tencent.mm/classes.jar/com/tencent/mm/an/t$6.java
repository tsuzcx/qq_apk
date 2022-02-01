package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class t$6
  implements Runnable
{
  t$6(t paramt, q paramq, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(132325);
    Set localSet = (Set)t.j(this.lCP).get(Integer.valueOf(this.ftz.getType()));
    Object localObject1;
    if ((localSet != null) && (localSet.size() > 0)) {
      localObject1 = new HashSet();
    }
    i locali;
    try
    {
      ((Set)localObject1).addAll(localSet);
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        locali = (i)((Iterator)localObject1).next();
        if ((locali != null) && (localSet.contains(locali))) {
          locali.onSceneEnd(this.val$errType, this.val$errCode, this.val$errMsg, this.ftz);
        }
      }
      if (localSet.size() <= 0) {
        break label267;
      }
    }
    finally
    {
      AppMethodBeat.o(132325);
    }
    Object localObject3 = new HashSet();
    try
    {
      ((Set)localObject3).addAll(localSet);
      localObject3 = ((Set)localObject3).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        locali = (i)((Iterator)localObject3).next();
      } while ((locali == null) || (!localSet.contains(locali)));
      label267:
      return;
    }
    finally
    {
      AppMethodBeat.o(132325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.t.6
 * JD-Core Version:    0.7.0.1
 */