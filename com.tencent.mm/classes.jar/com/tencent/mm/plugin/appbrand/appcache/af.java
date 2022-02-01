package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.HashSet;
import java.util.Set;

public final class af
{
  private static final Set<b> nFJ;
  
  static
  {
    AppMethodBeat.i(90557);
    nFJ = new HashSet();
    AppMethodBeat.o(90557);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(90555);
    synchronized (nFJ)
    {
      nFJ.add(paramb);
      AppMethodBeat.o(90555);
      return;
    }
  }
  
  static af.a b(a parama)
  {
    AppMethodBeat.i(90556);
    for (;;)
    {
      int i;
      synchronized (nFJ)
      {
        Object[] arrayOfObject = nFJ.toArray();
        int j = arrayOfObject.length;
        i = 0;
        if (i >= j) {
          break;
        }
        ??? = ((b)arrayOfObject[i]).b(parama);
        if (??? != null)
        {
          AppMethodBeat.o(90556);
          return ???;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(90556);
    return null;
  }
  
  public static abstract interface b
  {
    public abstract af.a b(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.af
 * JD-Core Version:    0.7.0.1
 */