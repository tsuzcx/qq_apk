package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b heX;
  public static final com.tencent.mm.memory.a.a.a.a heY;
  private final String TAG;
  public ConcurrentHashMap<String, b> heD;
  private b heZ;
  
  static
  {
    AppMethodBeat.i(156504);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.awh();
    heY = locala;
    b localb = awc();
    a locala1 = new a(locala);
    localb.heD.put(locala.dpt, locala1);
    if (locala.equals(heY)) {
      localb.heZ = locala1;
    }
    AppMethodBeat.o(156504);
  }
  
  b()
  {
    AppMethodBeat.i(156498);
    this.TAG = "MicroMsg.CacheInvoke";
    this.heZ = null;
    this.heD = new ConcurrentHashMap();
    AppMethodBeat.o(156498);
  }
  
  public static b awc()
  {
    AppMethodBeat.i(156499);
    if (heX == null) {}
    try
    {
      if (heX == null) {
        heX = new b();
      }
      b localb = heX;
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
    parama = (b)awc().heD.get(parama.dpt);
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
    if (heY.equals(parama))
    {
      parama = awc().heZ.awf();
      AppMethodBeat.o(156501);
      return parama;
    }
    awc();
    parama = b(parama).awf();
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
    if (heY.equals(parama))
    {
      parama = awc().heZ.awg();
      AppMethodBeat.o(156502);
      return parama;
    }
    awc();
    parama = b(parama).awg();
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
    if (heY.equals(parama))
    {
      i = awc().heZ.awe().hfh;
      AppMethodBeat.o(156503);
      return i;
    }
    awc();
    int i = b(parama).awe().hfh;
    AppMethodBeat.o(156503);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String hfd = "//data[%d,%d]::%s::%s";
    private d<String, a> hfa;
    private g<String, Object> hfb;
    private com.tencent.mm.memory.a.a.a.a hfc;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(156496);
      this.hfa = null;
      this.hfb = null;
      this.hfc = parama;
      this.hfa = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.hfb = new g(10);
      AppMethodBeat.o(156496);
    }
    
    public final void awd()
    {
      AppMethodBeat.i(156497);
      this.hfa.trimToSize(this.hfc.hfh / 2);
      AppMethodBeat.o(156497);
    }
    
    public final com.tencent.mm.memory.a.a.a.a awe()
    {
      return this.hfc;
    }
    
    public final d awf()
    {
      return this.hfa;
    }
    
    public final com.tencent.mm.b.f awg()
    {
      return this.hfb;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void awd();
    
    public abstract com.tencent.mm.memory.a.a.a.a awe();
    
    public abstract d<String, T> awf();
    
    public abstract com.tencent.mm.b.f<String, T> awg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */