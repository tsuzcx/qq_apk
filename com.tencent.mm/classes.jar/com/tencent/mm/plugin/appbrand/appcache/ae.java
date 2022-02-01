package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import java.util.HashSet;
import java.util.Set;

public final class ae
{
  private static final Set<b> kLQ;
  
  static
  {
    AppMethodBeat.i(90557);
    kLQ = new HashSet();
    AppMethodBeat.o(90557);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(90555);
    synchronized (kLQ)
    {
      kLQ.add(paramb);
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
      synchronized (kLQ)
      {
        Object[] arrayOfObject = kLQ.toArray();
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
    
    public abstract void bvj();
    
    public abstract void bvk();
    
    public abstract void bvl();
    
    public abstract void bvm();
    
    public abstract void bvn();
    
    public abstract void bvo();
    
    public abstract void bvp();
    
    public abstract void gE(boolean paramBoolean);
    
    public abstract void gF(boolean paramBoolean);
    
    public abstract void vQ(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract ae.a b(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae
 * JD-Core Version:    0.7.0.1
 */