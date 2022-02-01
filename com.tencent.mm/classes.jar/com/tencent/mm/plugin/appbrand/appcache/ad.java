package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import java.util.HashSet;
import java.util.Set;

public final class ad
{
  private static final Set<b> jGT;
  
  static
  {
    AppMethodBeat.i(90557);
    jGT = new HashSet();
    AppMethodBeat.o(90557);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(90555);
    synchronized (jGT)
    {
      jGT.add(paramb);
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
      synchronized (jGT)
      {
        Object[] arrayOfObject = jGT.toArray();
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
    
    public abstract void aZA();
    
    public abstract void aZB();
    
    public abstract void aZv();
    
    public abstract void aZw();
    
    public abstract void aZx();
    
    public abstract void aZy();
    
    public abstract void aZz();
    
    public abstract void fJ(boolean paramBoolean);
    
    public abstract void fK(boolean paramBoolean);
    
    public abstract void rR(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract ad.a b(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */