package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import java.util.HashSet;
import java.util.Set;

public final class ae
{
  private static final Set<b> jJT;
  
  static
  {
    AppMethodBeat.i(90557);
    jJT = new HashSet();
    AppMethodBeat.o(90557);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(90555);
    synchronized (jJT)
    {
      jJT.add(paramb);
      AppMethodBeat.o(90555);
      return;
    }
  }
  
  static a b(a parama)
  {
    AppMethodBeat.i(90556);
    for (;;)
    {
      int i;
      synchronized (jJT)
      {
        Object[] arrayOfObject = jJT.toArray();
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
  
  public static abstract interface a
  {
    public abstract void a(m paramm);
    
    public abstract void aZS();
    
    public abstract void aZT();
    
    public abstract void aZU();
    
    public abstract void aZV();
    
    public abstract void aZW();
    
    public abstract void aZX();
    
    public abstract void aZY();
    
    public abstract void fI(boolean paramBoolean);
    
    public abstract void fJ(boolean paramBoolean);
    
    public abstract void rU(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract ae.a b(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae
 * JD-Core Version:    0.7.0.1
 */