package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b gEw;
  public static final com.tencent.mm.memory.a.a.a.a gEx;
  private final String TAG;
  public ConcurrentHashMap<String, b> gEc;
  private b gEy;
  
  static
  {
    AppMethodBeat.i(156504);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.apq();
    gEx = locala;
    b localb = apl();
    a locala1 = new a(locala);
    localb.gEc.put(locala.drI, locala1);
    if (locala.equals(gEx)) {
      localb.gEy = locala1;
    }
    AppMethodBeat.o(156504);
  }
  
  b()
  {
    AppMethodBeat.i(156498);
    this.TAG = "MicroMsg.CacheInvoke";
    this.gEy = null;
    this.gEc = new ConcurrentHashMap();
    AppMethodBeat.o(156498);
  }
  
  public static b apl()
  {
    AppMethodBeat.i(156499);
    if (gEw == null) {}
    try
    {
      if (gEw == null) {
        gEw = new b();
      }
      b localb = gEw;
      AppMethodBeat.o(156499);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(156499);
    }
  }
  
  private static b b(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156500);
    parama = (b)apl().gEc.get(parama.drI);
    AppMethodBeat.o(156500);
    return parama;
  }
  
  public static d<String, a> c(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156501);
    if ((parama == null) || (parama.equals("")))
    {
      AppMethodBeat.o(156501);
      return null;
    }
    if (gEx.equals(parama))
    {
      parama = apl().gEy.apo();
      AppMethodBeat.o(156501);
      return parama;
    }
    apl();
    parama = b(parama).apo();
    AppMethodBeat.o(156501);
    return parama;
  }
  
  public static com.tencent.mm.b.f<String, Object> d(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156502);
    if ((parama == null) || (parama.equals("")))
    {
      AppMethodBeat.o(156502);
      return null;
    }
    if (gEx.equals(parama))
    {
      parama = apl().gEy.app();
      AppMethodBeat.o(156502);
      return parama;
    }
    apl();
    parama = b(parama).app();
    AppMethodBeat.o(156502);
    return parama;
  }
  
  public static int e(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156503);
    if ((parama == null) || (parama.equals("")))
    {
      AppMethodBeat.o(156503);
      return 2147483647;
    }
    if (gEx.equals(parama))
    {
      i = apl().gEy.apn().gEG;
      AppMethodBeat.o(156503);
      return i;
    }
    apl();
    int i = b(parama).apn().gEG;
    AppMethodBeat.o(156503);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String gEC = "//data[%d,%d]::%s::%s";
    private g<String, Object> gEA;
    private com.tencent.mm.memory.a.a.a.a gEB;
    private d<String, a> gEz;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(156496);
      this.gEz = null;
      this.gEA = null;
      this.gEB = parama;
      this.gEz = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.gEA = new g(10);
      AppMethodBeat.o(156496);
    }
    
    public final void apm()
    {
      AppMethodBeat.i(156497);
      this.gEz.trimToSize(this.gEB.gEG / 2);
      AppMethodBeat.o(156497);
    }
    
    public final com.tencent.mm.memory.a.a.a.a apn()
    {
      return this.gEB;
    }
    
    public final d apo()
    {
      return this.gEz;
    }
    
    public final com.tencent.mm.b.f app()
    {
      return this.gEA;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void apm();
    
    public abstract com.tencent.mm.memory.a.a.a.a apn();
    
    public abstract d<String, T> apo();
    
    public abstract com.tencent.mm.b.f<String, T> app();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */