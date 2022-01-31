package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b fel;
  public static final com.tencent.mm.memory.a.a.a.a fem;
  private final String TAG;
  public ConcurrentHashMap<String, b> fdR;
  private b fen;
  
  static
  {
    AppMethodBeat.i(115458);
    com.tencent.mm.memory.a.a.a.a locala = com.tencent.mm.memory.a.a.a.a.Yh();
    fem = locala;
    b localb = Yc();
    a locala1 = new a(locala);
    localb.fdR.put(locala.feA, locala1);
    if (locala.equals(fem)) {
      localb.fen = locala1;
    }
    AppMethodBeat.o(115458);
  }
  
  b()
  {
    AppMethodBeat.i(115452);
    this.TAG = "MicroMsg.CacheInvoke";
    this.fen = null;
    this.fdR = new ConcurrentHashMap();
    AppMethodBeat.o(115452);
  }
  
  public static b Yc()
  {
    AppMethodBeat.i(115453);
    if (fel == null) {}
    try
    {
      if (fel == null) {
        fel = new b();
      }
      b localb = fel;
      AppMethodBeat.o(115453);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(115453);
    }
  }
  
  private static b b(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(115454);
    parama = (b)Yc().fdR.get(parama.feA);
    AppMethodBeat.o(115454);
    return parama;
  }
  
  public static d<String, a> c(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(115455);
    if ((parama == null) || (parama.equals("")))
    {
      AppMethodBeat.o(115455);
      return null;
    }
    if (fem.equals(parama))
    {
      parama = Yc().fen.Yf();
      AppMethodBeat.o(115455);
      return parama;
    }
    Yc();
    parama = b(parama).Yf();
    AppMethodBeat.o(115455);
    return parama;
  }
  
  public static com.tencent.mm.a.f<String, Object> d(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(115456);
    if ((parama == null) || (parama.equals("")))
    {
      AppMethodBeat.o(115456);
      return null;
    }
    if (fem.equals(parama))
    {
      parama = Yc().fen.Yg();
      AppMethodBeat.o(115456);
      return parama;
    }
    Yc();
    parama = b(parama).Yg();
    AppMethodBeat.o(115456);
    return parama;
  }
  
  public static int e(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(115457);
    if ((parama == null) || (parama.equals("")))
    {
      AppMethodBeat.o(115457);
      return 2147483647;
    }
    if (fem.equals(parama))
    {
      i = Yc().fen.Ye().fev;
      AppMethodBeat.o(115457);
      return i;
    }
    Yc();
    int i = b(parama).Ye().fev;
    AppMethodBeat.o(115457);
    return i;
  }
  
  static final class a
    implements b.b
  {
    private static String fer = "//data[%d,%d]::%s::%s";
    private d<String, a> feo;
    private g<String, Object> fep;
    private com.tencent.mm.memory.a.a.a.a feq;
    
    a(com.tencent.mm.memory.a.a.a.a parama)
    {
      AppMethodBeat.i(115450);
      this.feo = null;
      this.fep = null;
      this.feq = parama;
      this.feo = new com.tencent.mm.memory.a.a.a.f(parama, new f.b()new f.c {}, new f.c() {}) {};
      this.fep = new g(10);
      AppMethodBeat.o(115450);
    }
    
    public final void Yd()
    {
      AppMethodBeat.i(115451);
      this.feo.trimToSize(this.feq.fev / 2);
      AppMethodBeat.o(115451);
    }
    
    public final com.tencent.mm.memory.a.a.a.a Ye()
    {
      return this.feq;
    }
    
    public final d Yf()
    {
      return this.feo;
    }
    
    public final com.tencent.mm.a.f Yg()
    {
      return this.fep;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void Yd();
    
    public abstract com.tencent.mm.memory.a.a.a.a Ye();
    
    public abstract d<String, T> Yf();
    
    public abstract com.tencent.mm.a.f<String, T> Yg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.b
 * JD-Core Version:    0.7.0.1
 */