package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class s$7
  implements Runnable
{
  public s$7(s params, int paramInt1, int paramInt2, String paramString, p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(236779);
    Set localSet = (Set)s.j(this.ouA).get(Integer.valueOf(-1));
    Object localObject1;
    if ((localSet != null) && (localSet.size() > 0)) {
      localObject1 = new HashSet();
    }
    try
    {
      ((Set)localObject1).addAll(localSet);
      localObject1 = ((Set)localObject1).iterator();
      h localh;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localh = (h)((Iterator)localObject1).next();
      } while ((localh == null) || (!localSet.contains(localh)));
      return;
    }
    finally
    {
      AppMethodBeat.o(236779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.s.7
 * JD-Core Version:    0.7.0.1
 */