package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b nNU;
  public static final com.tencent.mm.memory.a.a.a.a nNV;
  private final String TAG;
  public ConcurrentHashMap<String, b> nNB;
  private b nNW;
  
  static
  {
    AppMethodBeat.i(156504);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.bwh();
    nNV = locala;
    b localb = bwc();
    a locala1 = new a(locala);
    localb.nNB.put(locala.hTs, locala1);
    if (locala.equals(nNV)) {
      localb.nNW = locala1;
    }
    AppMethodBeat.o(156504);
  }
  
  b()
  {
    AppMethodBeat.i(156498);
    this.TAG = "MicroMsg.CacheInvoke";
    this.nNW = null;
    this.nNB = new ConcurrentHashMap();
    AppMethodBeat.o(156498);
  }
  
  private static b b(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156500);
    parama = (b)bwc().nNB.get(parama.hTs);
    AppMethodBeat.o(156500);
    return parama;
  }
  
  public static b bwc()
  {
    AppMethodBeat.i(156499);
    if (nNU == null) {}
    try
    {
      if (nNU == null) {
        nNU = new b();
      }
      b localb = nNU;
      AppMethodBeat.o(156499);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(156499);
    }
  }
  
  public static d<String, a> c(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156501);
    if ((parama == null) || (parama.equals("")))
    {
      AppMethodBeat.o(156501);
      return null;
    }
    if (nNV.equals(parama))
    {
      parama = bwc().nNW.bwf();
      AppMethodBeat.o(156501);
      return parama;
    }
    bwc();
    parama = b(parama).bwf();
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
    if (nNV.equals(parama))
    {
      parama = bwc().nNW.bwg();
      AppMethodBeat.o(156502);
      return parama;
    }
    bwc();
    parama = b(parama).bwg();
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
    if (nNV.equals(parama))
    {
      i = bwc().nNW.bwe().nOe;
      AppMethodBeat.o(156503);
      return i;
    }
    bwc();
    int i = b(parama).bwe().nOe;
    AppMethodBeat.o(156503);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String nOa = "//data[%d,%d]::%s::%s";
    private d<String, a> nNX;
    private g<String, Object> nNY;
    private com.tencent.mm.memory.a.a.a.a nNZ;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(156496);
      this.nNX = null;
      this.nNY = null;
      this.nNZ = parama;
      this.nNX = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.nNY = new g(10);
      AppMethodBeat.o(156496);
    }
    
    public final void bwd()
    {
      AppMethodBeat.i(156497);
      this.nNX.trimToSize(this.nNZ.nOe / 2);
      AppMethodBeat.o(156497);
    }
    
    public final com.tencent.mm.memory.a.a.a.a bwe()
    {
      return this.nNZ;
    }
    
    public final d bwf()
    {
      return this.nNX;
    }
    
    public final com.tencent.mm.b.f bwg()
    {
      return this.nNY;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void bwd();
    
    public abstract com.tencent.mm.memory.a.a.a.a bwe();
    
    public abstract d<String, T> bwf();
    
    public abstract com.tencent.mm.b.f<String, T> bwg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */