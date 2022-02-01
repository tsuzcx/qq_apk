package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b iua;
  public static final com.tencent.mm.memory.a.a.a.a iub;
  private final String TAG;
  public ConcurrentHashMap<String, b> itH;
  private b iuc;
  
  static
  {
    AppMethodBeat.i(156504);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.aSp();
    iub = locala;
    b localb = aSk();
    a locala1 = new a(locala);
    localb.itH.put(locala.dUb, locala1);
    if (locala.equals(iub)) {
      localb.iuc = locala1;
    }
    AppMethodBeat.o(156504);
  }
  
  b()
  {
    AppMethodBeat.i(156498);
    this.TAG = "MicroMsg.CacheInvoke";
    this.iuc = null;
    this.itH = new ConcurrentHashMap();
    AppMethodBeat.o(156498);
  }
  
  public static b aSk()
  {
    AppMethodBeat.i(156499);
    if (iua == null) {}
    try
    {
      if (iua == null) {
        iua = new b();
      }
      b localb = iua;
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
    parama = (b)aSk().itH.get(parama.dUb);
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
    if (iub.equals(parama))
    {
      parama = aSk().iuc.aSn();
      AppMethodBeat.o(156501);
      return parama;
    }
    aSk();
    parama = b(parama).aSn();
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
    if (iub.equals(parama))
    {
      parama = aSk().iuc.aSo();
      AppMethodBeat.o(156502);
      return parama;
    }
    aSk();
    parama = b(parama).aSo();
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
    if (iub.equals(parama))
    {
      i = aSk().iuc.aSm().iuk;
      AppMethodBeat.o(156503);
      return i;
    }
    aSk();
    int i = b(parama).aSm().iuk;
    AppMethodBeat.o(156503);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String iug = "//data[%d,%d]::%s::%s";
    private d<String, a> iud;
    private g<String, Object> iue;
    private com.tencent.mm.memory.a.a.a.a iuf;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(156496);
      this.iud = null;
      this.iue = null;
      this.iuf = parama;
      this.iud = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.iue = new g(10);
      AppMethodBeat.o(156496);
    }
    
    public final void aSl()
    {
      AppMethodBeat.i(156497);
      this.iud.trimToSize(this.iuf.iuk / 2);
      AppMethodBeat.o(156497);
    }
    
    public final com.tencent.mm.memory.a.a.a.a aSm()
    {
      return this.iuf;
    }
    
    public final d aSn()
    {
      return this.iud;
    }
    
    public final com.tencent.mm.b.f aSo()
    {
      return this.iue;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void aSl();
    
    public abstract com.tencent.mm.memory.a.a.a.a aSm();
    
    public abstract d<String, T> aSn();
    
    public abstract com.tencent.mm.b.f<String, T> aSo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */