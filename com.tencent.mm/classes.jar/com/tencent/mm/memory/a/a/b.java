package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b ljj;
  public static final com.tencent.mm.memory.a.a.a.a ljk;
  private final String TAG;
  public ConcurrentHashMap<String, b> liQ;
  private b ljl;
  
  static
  {
    AppMethodBeat.i(156504);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.bbm();
    ljk = locala;
    b localb = bbh();
    a locala1 = new a(locala);
    localb.liQ.put(locala.fND, locala1);
    if (locala.equals(ljk)) {
      localb.ljl = locala1;
    }
    AppMethodBeat.o(156504);
  }
  
  b()
  {
    AppMethodBeat.i(156498);
    this.TAG = "MicroMsg.CacheInvoke";
    this.ljl = null;
    this.liQ = new ConcurrentHashMap();
    AppMethodBeat.o(156498);
  }
  
  private static b b(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156500);
    parama = (b)bbh().liQ.get(parama.fND);
    AppMethodBeat.o(156500);
    return parama;
  }
  
  public static b bbh()
  {
    AppMethodBeat.i(156499);
    if (ljj == null) {}
    try
    {
      if (ljj == null) {
        ljj = new b();
      }
      b localb = ljj;
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
    if (ljk.equals(parama))
    {
      parama = bbh().ljl.bbk();
      AppMethodBeat.o(156501);
      return parama;
    }
    bbh();
    parama = b(parama).bbk();
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
    if (ljk.equals(parama))
    {
      parama = bbh().ljl.bbl();
      AppMethodBeat.o(156502);
      return parama;
    }
    bbh();
    parama = b(parama).bbl();
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
    if (ljk.equals(parama))
    {
      i = bbh().ljl.bbj().ljt;
      AppMethodBeat.o(156503);
      return i;
    }
    bbh();
    int i = b(parama).bbj().ljt;
    AppMethodBeat.o(156503);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String ljp = "//data[%d,%d]::%s::%s";
    private d<String, a> ljm;
    private g<String, Object> ljn;
    private com.tencent.mm.memory.a.a.a.a ljo;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(156496);
      this.ljm = null;
      this.ljn = null;
      this.ljo = parama;
      this.ljm = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.ljn = new g(10);
      AppMethodBeat.o(156496);
    }
    
    public final void bbi()
    {
      AppMethodBeat.i(156497);
      this.ljm.trimToSize(this.ljo.ljt / 2);
      AppMethodBeat.o(156497);
    }
    
    public final com.tencent.mm.memory.a.a.a.a bbj()
    {
      return this.ljo;
    }
    
    public final d bbk()
    {
      return this.ljm;
    }
    
    public final com.tencent.mm.b.f bbl()
    {
      return this.ljn;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void bbi();
    
    public abstract com.tencent.mm.memory.a.a.a.a bbj();
    
    public abstract d<String, T> bbk();
    
    public abstract com.tencent.mm.b.f<String, T> bbl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */