package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.res.downloader.model.l;
import java.util.HashSet;
import java.util.Set;

public final class ag
{
  private static final Set<b> qFD;
  
  static
  {
    AppMethodBeat.i(90557);
    qFD = new HashSet();
    AppMethodBeat.o(90557);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(90555);
    synchronized (qFD)
    {
      qFD.add(paramb);
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
      synchronized (qFD)
      {
        Object[] arrayOfObject = qFD.toArray();
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
    public abstract void a(l paraml);
    
    public abstract void cfP();
    
    public abstract void cfQ();
    
    public abstract void cfR();
    
    public abstract void cfS();
    
    public abstract void cfT();
    
    public abstract void cfU();
    
    public abstract void cfV();
    
    public abstract void ig(boolean paramBoolean);
    
    public abstract void ih(boolean paramBoolean);
    
    public abstract void zo(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract ag.a b(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ag
 * JD-Core Version:    0.7.0.1
 */