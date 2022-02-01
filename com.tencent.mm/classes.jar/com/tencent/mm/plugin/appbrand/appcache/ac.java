package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.h.a.c.m;
import java.util.HashSet;
import java.util.Set;

public final class ac
{
  private static final Set<b> iMO;
  
  static
  {
    AppMethodBeat.i(90557);
    iMO = new HashSet();
    AppMethodBeat.o(90557);
  }
  
  static a a(a parama)
  {
    AppMethodBeat.i(90556);
    for (;;)
    {
      int i;
      synchronized (iMO)
      {
        Object[] arrayOfObject = iMO.toArray();
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
    synchronized (iMO)
    {
      iMO.add(paramb);
      AppMethodBeat.o(90555);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(m paramm);
    
    public abstract void aPi();
    
    public abstract void aPj();
    
    public abstract void aPk();
    
    public abstract void aPl();
    
    public abstract void aPm();
    
    public abstract void aPn();
    
    public abstract void aPo();
    
    public abstract void fj(boolean paramBoolean);
    
    public abstract void fk(boolean paramBoolean);
    
    public abstract void qE(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract ac.a a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */