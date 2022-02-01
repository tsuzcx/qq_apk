package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.h.a.c.m;
import java.util.HashSet;
import java.util.Set;

public final class ac
{
  private static final Set<b> jmV;
  
  static
  {
    AppMethodBeat.i(90557);
    jmV = new HashSet();
    AppMethodBeat.o(90557);
  }
  
  static a a(a parama)
  {
    AppMethodBeat.i(90556);
    for (;;)
    {
      int i;
      synchronized (jmV)
      {
        Object[] arrayOfObject = jmV.toArray();
        int j = arrayOfObject.length;
        i = 0;
        if (i >= j) {
          break;
        }
        ??? = ((b)arrayOfObject[i]).a(parama);
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
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(90555);
    synchronized (jmV)
    {
      jmV.add(paramb);
      AppMethodBeat.o(90555);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(m paramm);
    
    public abstract void aWa();
    
    public abstract void aWb();
    
    public abstract void aWc();
    
    public abstract void aWd();
    
    public abstract void aWe();
    
    public abstract void aWf();
    
    public abstract void aWg();
    
    public abstract void fF(boolean paramBoolean);
    
    public abstract void fG(boolean paramBoolean);
    
    public abstract void rr(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract ac.a a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */