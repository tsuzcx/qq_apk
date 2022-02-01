package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b hzT;
  public static final com.tencent.mm.memory.a.a.a.a hzU;
  private final String TAG;
  private b hzV;
  public ConcurrentHashMap<String, b> hzz;
  
  static
  {
    AppMethodBeat.i(156504);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.azj();
    hzU = locala;
    b localb = aze();
    a locala1 = new a(locala);
    localb.hzz.put(locala.dCl, locala1);
    if (locala.equals(hzU)) {
      localb.hzV = locala1;
    }
    AppMethodBeat.o(156504);
  }
  
  b()
  {
    AppMethodBeat.i(156498);
    this.TAG = "MicroMsg.CacheInvoke";
    this.hzV = null;
    this.hzz = new ConcurrentHashMap();
    AppMethodBeat.o(156498);
  }
  
  public static b aze()
  {
    AppMethodBeat.i(156499);
    if (hzT == null) {}
    try
    {
      if (hzT == null) {
        hzT = new b();
      }
      b localb = hzT;
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
    parama = (b)aze().hzz.get(parama.dCl);
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
    if (hzU.equals(parama))
    {
      parama = aze().hzV.azh();
      AppMethodBeat.o(156501);
      return parama;
    }
    aze();
    parama = b(parama).azh();
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
    if (hzU.equals(parama))
    {
      parama = aze().hzV.azi();
      AppMethodBeat.o(156502);
      return parama;
    }
    aze();
    parama = b(parama).azi();
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
    if (hzU.equals(parama))
    {
      i = aze().hzV.azg().hAd;
      AppMethodBeat.o(156503);
      return i;
    }
    aze();
    int i = b(parama).azg().hAd;
    AppMethodBeat.o(156503);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String hzZ = "//data[%d,%d]::%s::%s";
    private d<String, a> hzW;
    private g<String, Object> hzX;
    private com.tencent.mm.memory.a.a.a.a hzY;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(156496);
      this.hzW = null;
      this.hzX = null;
      this.hzY = parama;
      this.hzW = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.hzX = new g(10);
      AppMethodBeat.o(156496);
    }
    
    public final void azf()
    {
      AppMethodBeat.i(156497);
      this.hzW.trimToSize(this.hzY.hAd / 2);
      AppMethodBeat.o(156497);
    }
    
    public final com.tencent.mm.memory.a.a.a.a azg()
    {
      return this.hzY;
    }
    
    public final d azh()
    {
      return this.hzW;
    }
    
    public final com.tencent.mm.b.f azi()
    {
      return this.hzX;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void azf();
    
    public abstract com.tencent.mm.memory.a.a.a.a azg();
    
    public abstract d<String, T> azh();
    
    public abstract com.tencent.mm.b.f<String, T> azi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */