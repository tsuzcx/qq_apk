package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.HashSet;
import java.util.Set;

public final class z
{
  private static final Set<b> gVk;
  
  static
  {
    AppMethodBeat.i(59444);
    gVk = new HashSet();
    AppMethodBeat.o(59444);
  }
  
  static z.a a(a parama)
  {
    AppMethodBeat.i(59443);
    for (;;)
    {
      int i;
      synchronized (gVk)
      {
        Object[] arrayOfObject = gVk.toArray();
        int j = arrayOfObject.length;
        i = 0;
        if (i >= j) {
          break;
        }
        ??? = ((b)arrayOfObject[i]).a(parama);
        if (??? != null)
        {
          AppMethodBeat.o(59443);
          return ???;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(59443);
    return null;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(59442);
    synchronized (gVk)
    {
      gVk.add(paramb);
      AppMethodBeat.o(59442);
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract z.a a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */