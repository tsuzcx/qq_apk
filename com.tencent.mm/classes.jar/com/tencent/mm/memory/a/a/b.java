package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b hxf;
  public static final com.tencent.mm.memory.a.a.a.a hxg;
  private final String TAG;
  public ConcurrentHashMap<String, b> hwL;
  private b hxh;
  
  static
  {
    AppMethodBeat.i(156504);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.ayU();
    hxg = locala;
    b localb = ayP();
    a locala1 = new a(locala);
    localb.hwL.put(locala.dBg, locala1);
    if (locala.equals(hxg)) {
      localb.hxh = locala1;
    }
    AppMethodBeat.o(156504);
  }
  
  b()
  {
    AppMethodBeat.i(156498);
    this.TAG = "MicroMsg.CacheInvoke";
    this.hxh = null;
    this.hwL = new ConcurrentHashMap();
    AppMethodBeat.o(156498);
  }
  
  public static b ayP()
  {
    AppMethodBeat.i(156499);
    if (hxf == null) {}
    try
    {
      if (hxf == null) {
        hxf = new b();
      }
      b localb = hxf;
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
    parama = (b)ayP().hwL.get(parama.dBg);
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
    if (hxg.equals(parama))
    {
      parama = ayP().hxh.ayS();
      AppMethodBeat.o(156501);
      return parama;
    }
    ayP();
    parama = b(parama).ayS();
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
    if (hxg.equals(parama))
    {
      parama = ayP().hxh.ayT();
      AppMethodBeat.o(156502);
      return parama;
    }
    ayP();
    parama = b(parama).ayT();
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
    if (hxg.equals(parama))
    {
      i = ayP().hxh.ayR().hxp;
      AppMethodBeat.o(156503);
      return i;
    }
    ayP();
    int i = b(parama).ayR().hxp;
    AppMethodBeat.o(156503);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String hxl = "//data[%d,%d]::%s::%s";
    private d<String, a> hxi;
    private g<String, Object> hxj;
    private com.tencent.mm.memory.a.a.a.a hxk;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(156496);
      this.hxi = null;
      this.hxj = null;
      this.hxk = parama;
      this.hxi = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.hxj = new g(10);
      AppMethodBeat.o(156496);
    }
    
    public final void ayQ()
    {
      AppMethodBeat.i(156497);
      this.hxi.trimToSize(this.hxk.hxp / 2);
      AppMethodBeat.o(156497);
    }
    
    public final com.tencent.mm.memory.a.a.a.a ayR()
    {
      return this.hxk;
    }
    
    public final d ayS()
    {
      return this.hxi;
    }
    
    public final com.tencent.mm.b.f ayT()
    {
      return this.hxj;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void ayQ();
    
    public abstract com.tencent.mm.memory.a.a.a.a ayR();
    
    public abstract d<String, T> ayS();
    
    public abstract com.tencent.mm.b.f<String, T> ayT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */