package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class s$6
  implements Runnable
{
  s$6(s params, p paramp, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(132325);
    Set localSet = (Set)s.j(this.ouA).get(Integer.valueOf(this.hxO.getType()));
    Object localObject1;
    if ((localSet != null) && (localSet.size() > 0)) {
      localObject1 = new HashSet();
    }
    h localh;
    try
    {
      ((Set)localObject1).addAll(localSet);
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localh = (h)((Iterator)localObject1).next();
        if ((localh != null) && (localSet.contains(localh))) {
          localh.onSceneEnd(this.val$errType, this.val$errCode, this.val$errMsg, this.hxO);
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
        localh = (h)((Iterator)localObject3).next();
      } while ((localh == null) || (!localSet.contains(localh)));
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
 * Qualified Name:     com.tencent.mm.am.s.6
 * JD-Core Version:    0.7.0.1
 */