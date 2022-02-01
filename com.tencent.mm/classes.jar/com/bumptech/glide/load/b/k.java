package com.bumptech.glide.load.b;

import android.support.v4.e.l.a;
import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.g.f;
import com.bumptech.glide.load.b.b.b;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.Executor;

public final class k
  implements com.bumptech.glide.load.b.b.h.a, m, p.a
{
  private static final boolean aHe;
  private final s aHf;
  private final o aHg;
  private final com.bumptech.glide.load.b.b.h aHh;
  private final b aHi;
  private final y aHj;
  private final c aHk;
  private final a aHl;
  private final a aHm;
  
  static
  {
    AppMethodBeat.i(76990);
    aHe = Log.isLoggable("Engine", 2);
    AppMethodBeat.o(76990);
  }
  
  public k(com.bumptech.glide.load.b.b.h paramh, com.bumptech.glide.load.b.b.a.a parama, com.bumptech.glide.load.b.c.a parama1, com.bumptech.glide.load.b.c.a parama2, com.bumptech.glide.load.b.c.a parama3, com.bumptech.glide.load.b.c.a parama4, boolean paramBoolean)
  {
    this(paramh, parama, parama1, parama2, parama3, parama4, paramBoolean, (byte)0);
  }
  
  /* Error */
  private k(com.bumptech.glide.load.b.b.h paramh, com.bumptech.glide.load.b.b.a.a parama, com.bumptech.glide.load.b.c.a parama1, com.bumptech.glide.load.b.c.a parama2, com.bumptech.glide.load.b.c.a parama3, com.bumptech.glide.load.b.c.a parama4, boolean paramBoolean, byte paramByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 74	java/lang/Object:<init>	()V
    //   4: ldc 75
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 77	com/bumptech/glide/load/b/k:aHh	Lcom/bumptech/glide/load/b/b/h;
    //   14: aload_0
    //   15: new 22	com/bumptech/glide/load/b/k$c
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 80	com/bumptech/glide/load/b/k$c:<init>	(Lcom/bumptech/glide/load/b/b/a$a;)V
    //   23: putfield 82	com/bumptech/glide/load/b/k:aHk	Lcom/bumptech/glide/load/b/k$c;
    //   26: new 84	com/bumptech/glide/load/b/a
    //   29: dup
    //   30: iload 7
    //   32: invokespecial 87	com/bumptech/glide/load/b/a:<init>	(Z)V
    //   35: astore_2
    //   36: aload_0
    //   37: aload_2
    //   38: putfield 89	com/bumptech/glide/load/b/k:aHm	Lcom/bumptech/glide/load/b/a;
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_2
    //   44: monitorenter
    //   45: aload_2
    //   46: aload_0
    //   47: putfield 93	com/bumptech/glide/load/b/a:aFB	Lcom/bumptech/glide/load/b/p$a;
    //   50: aload_2
    //   51: monitorexit
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: new 95	com/bumptech/glide/load/b/o
    //   58: dup
    //   59: invokespecial 96	com/bumptech/glide/load/b/o:<init>	()V
    //   62: putfield 98	com/bumptech/glide/load/b/k:aHg	Lcom/bumptech/glide/load/b/o;
    //   65: aload_0
    //   66: new 100	com/bumptech/glide/load/b/s
    //   69: dup
    //   70: invokespecial 101	com/bumptech/glide/load/b/s:<init>	()V
    //   73: putfield 103	com/bumptech/glide/load/b/k:aHf	Lcom/bumptech/glide/load/b/s;
    //   76: aload_0
    //   77: new 17	com/bumptech/glide/load/b/k$b
    //   80: dup
    //   81: aload_3
    //   82: aload 4
    //   84: aload 5
    //   86: aload 6
    //   88: aload_0
    //   89: invokespecial 106	com/bumptech/glide/load/b/k$b:<init>	(Lcom/bumptech/glide/load/b/c/a;Lcom/bumptech/glide/load/b/c/a;Lcom/bumptech/glide/load/b/c/a;Lcom/bumptech/glide/load/b/c/a;Lcom/bumptech/glide/load/b/m;)V
    //   92: putfield 108	com/bumptech/glide/load/b/k:aHi	Lcom/bumptech/glide/load/b/k$b;
    //   95: aload_0
    //   96: new 12	com/bumptech/glide/load/b/k$a
    //   99: dup
    //   100: aload_0
    //   101: getfield 82	com/bumptech/glide/load/b/k:aHk	Lcom/bumptech/glide/load/b/k$c;
    //   104: invokespecial 111	com/bumptech/glide/load/b/k$a:<init>	(Lcom/bumptech/glide/load/b/h$d;)V
    //   107: putfield 113	com/bumptech/glide/load/b/k:aHl	Lcom/bumptech/glide/load/b/k$a;
    //   110: aload_0
    //   111: new 115	com/bumptech/glide/load/b/y
    //   114: dup
    //   115: invokespecial 116	com/bumptech/glide/load/b/y:<init>	()V
    //   118: putfield 118	com/bumptech/glide/load/b/k:aHj	Lcom/bumptech/glide/load/b/y;
    //   121: aload_1
    //   122: aload_0
    //   123: invokeinterface 123 2 0
    //   128: ldc 75
    //   130: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: astore_1
    //   135: aload_2
    //   136: monitorexit
    //   137: ldc 75
    //   139: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: ldc 75
    //   149: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	k
    //   0	154	1	paramh	com.bumptech.glide.load.b.b.h
    //   0	154	2	parama	com.bumptech.glide.load.b.b.a.a
    //   0	154	3	parama1	com.bumptech.glide.load.b.c.a
    //   0	154	4	parama2	com.bumptech.glide.load.b.c.a
    //   0	154	5	parama3	com.bumptech.glide.load.b.c.a
    //   0	154	6	parama4	com.bumptech.glide.load.b.c.a
    //   0	154	7	paramBoolean	boolean
    //   0	154	8	paramByte	byte
    // Exception table:
    //   from	to	target	type
    //   45	52	134	finally
    //   135	137	134	finally
    //   43	45	144	finally
    //   52	54	144	finally
    //   137	144	144	finally
    //   145	147	144	finally
  }
  
  private static void a(String paramString, long paramLong, com.bumptech.glide.load.g paramg)
  {
    AppMethodBeat.i(76984);
    new StringBuilder().append(paramString).append(" in ").append(f.p(paramLong)).append("ms, key: ").append(paramg);
    AppMethodBeat.o(76984);
  }
  
  public static void b(v<?> paramv)
  {
    AppMethodBeat.i(76985);
    if ((paramv instanceof p))
    {
      ((p)paramv).release();
      AppMethodBeat.o(76985);
      return;
    }
    paramv = new IllegalArgumentException("Cannot release anything but an EngineResource");
    AppMethodBeat.o(76985);
    throw paramv;
  }
  
  public final <R> d a(e parame, Object paramObject, com.bumptech.glide.load.g paramg, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, com.bumptech.glide.g paramg1, j paramj, Map<Class<?>, com.bumptech.glide.load.l<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, i parami, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, com.bumptech.glide.e.g paramg2, Executor paramExecutor)
  {
    for (;;)
    {
      long l;
      n localn;
      Object localObject1;
      try
      {
        AppMethodBeat.i(204459);
        if (aHe)
        {
          l = f.qt();
          localn = new n(paramObject, paramg, paramInt1, paramInt2, paramMap, paramClass, paramClass1, parami);
          if (!paramBoolean3)
          {
            localObject1 = null;
            if (localObject1 == null) {
              break label135;
            }
            paramg2.c((v)localObject1, com.bumptech.glide.load.a.aEK);
            if (aHe) {
              a("Loaded resource from active resources", l, localn);
            }
            parame = null;
            AppMethodBeat.o(204459);
            return parame;
          }
        }
        else
        {
          l = 0L;
          continue;
        }
        localObject2 = this.aHm.b(localn);
        localObject1 = localObject2;
        if (localObject2 == null) {
          continue;
        }
        ((p)localObject2).acquire();
        localObject1 = localObject2;
        continue;
        if (paramBoolean3) {
          break label185;
        }
      }
      finally {}
      label135:
      Object localObject2 = null;
      if (localObject2 != null)
      {
        paramg2.c((v)localObject2, com.bumptech.glide.load.a.aEK);
        if (aHe) {
          a("Loaded resource from cache", l, localn);
        }
        parame = null;
        AppMethodBeat.o(204459);
        continue;
        label185:
        localObject1 = this.aHh.d(localn);
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            break;
          }
          ((p)localObject1).acquire();
          this.aHm.a(localn, (p)localObject1);
          localObject2 = localObject1;
          break;
          if ((localObject1 instanceof p)) {
            localObject1 = (p)localObject1;
          } else {
            localObject1 = new p((v)localObject1, true, true);
          }
        }
      }
      else
      {
        localObject1 = (l)this.aHf.aG(paramBoolean6).get(localn);
        if (localObject1 != null)
        {
          ((l)localObject1).a(paramg2, paramExecutor);
          if (aHe) {
            a("Added to existing load", l, localn);
          }
          parame = new d(paramg2, (l)localObject1);
          AppMethodBeat.o(204459);
        }
        else
        {
          localObject1 = ((l)com.bumptech.glide.g.j.checkNotNull((l)this.aHi.aGj.acquire(), "Argument must not be null")).a(localn, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
          Object localObject3 = this.aHl;
          localObject2 = (h)com.bumptech.glide.g.j.checkNotNull((h)((a)localObject3).aGj.acquire(), "Argument must not be null");
          int i = ((a)localObject3).aHn;
          ((a)localObject3).aHn = (i + 1);
          localObject3 = ((h)localObject2).aGg;
          h.d locald = ((h)localObject2).aFY;
          ((g)localObject3).aCm = parame;
          ((g)localObject3).aDf = paramObject;
          ((g)localObject3).aFT = paramg;
          ((g)localObject3).width = paramInt1;
          ((g)localObject3).height = paramInt2;
          ((g)localObject3).aGd = paramj;
          ((g)localObject3).aFX = paramClass;
          ((g)localObject3).aFY = locald;
          ((g)localObject3).aDd = paramClass1;
          ((g)localObject3).aGc = paramg1;
          ((g)localObject3).aFV = parami;
          ((g)localObject3).aFZ = paramMap;
          ((g)localObject3).aGe = paramBoolean1;
          ((g)localObject3).aGf = paramBoolean2;
          ((h)localObject2).aCm = parame;
          ((h)localObject2).aFT = paramg;
          ((h)localObject2).aGc = paramg1;
          ((h)localObject2).aGm = localn;
          ((h)localObject2).width = paramInt1;
          ((h)localObject2).height = paramInt2;
          ((h)localObject2).aGd = paramj;
          ((h)localObject2).aGr = paramBoolean6;
          ((h)localObject2).aFV = parami;
          ((h)localObject2).aGn = ((h.a)localObject1);
          ((h)localObject2).order = i;
          ((h)localObject2).aGp = h.f.aGJ;
          ((h)localObject2).aDf = paramObject;
          this.aHf.aG(((l)localObject1).aGr).put(localn, localObject1);
          ((l)localObject1).a(paramg2, paramExecutor);
          ((l)localObject1).b((h)localObject2);
          if (aHe) {
            a("Started new load", l, localn);
          }
          parame = new d(paramg2, (l)localObject1);
          AppMethodBeat.o(204459);
        }
      }
    }
  }
  
  public final void a(l<?> paraml, com.bumptech.glide.load.g paramg)
  {
    try
    {
      AppMethodBeat.i(76987);
      this.aHf.a(paramg, paraml);
      AppMethodBeat.o(76987);
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public final void a(l<?> paraml, com.bumptech.glide.load.g paramg, p<?> paramp)
  {
    try
    {
      AppMethodBeat.i(76986);
      if (paramp != null)
      {
        paramp.a(paramg, this);
        if (paramp.aFI) {
          this.aHm.a(paramg, paramp);
        }
      }
      this.aHf.a(paramg, paraml);
      AppMethodBeat.o(76986);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void b(com.bumptech.glide.load.g paramg, p<?> paramp)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 370
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 89	com/bumptech/glide/load/b/k:aHm	Lcom/bumptech/glide/load/b/a;
    //   12: aload_1
    //   13: invokevirtual 373	com/bumptech/glide/load/b/a:a	(Lcom/bumptech/glide/load/g;)V
    //   16: aload_2
    //   17: getfield 368	com/bumptech/glide/load/b/p:aFI	Z
    //   20: ifeq +24 -> 44
    //   23: aload_0
    //   24: getfield 77	com/bumptech/glide/load/b/k:aHh	Lcom/bumptech/glide/load/b/b/h;
    //   27: aload_1
    //   28: aload_2
    //   29: invokeinterface 376 3 0
    //   34: pop
    //   35: ldc_w 370
    //   38: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: getfield 118	com/bumptech/glide/load/b/k:aHj	Lcom/bumptech/glide/load/b/y;
    //   48: aload_2
    //   49: invokevirtual 379	com/bumptech/glide/load/b/y:e	(Lcom/bumptech/glide/load/b/v;)V
    //   52: ldc_w 370
    //   55: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -17 -> 41
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	k
    //   0	66	1	paramg	com.bumptech.glide.load.g
    //   0	66	2	paramp	p<?>
    // Exception table:
    //   from	to	target	type
    //   2	41	61	finally
    //   44	58	61	finally
  }
  
  public final void c(v<?> paramv)
  {
    AppMethodBeat.i(76988);
    this.aHj.e(paramv);
    AppMethodBeat.o(76988);
  }
  
  static final class a
  {
    final h.d aFY;
    final l.a<h<?>> aGj;
    int aHn;
    
    a(h.d paramd)
    {
      AppMethodBeat.i(76978);
      this.aGj = com.bumptech.glide.g.a.a.a(150, new com.bumptech.glide.g.a.a.a() {});
      this.aFY = paramd;
      AppMethodBeat.o(76978);
    }
  }
  
  static final class b
  {
    final com.bumptech.glide.load.b.c.a aCB;
    final com.bumptech.glide.load.b.c.a aCu;
    final com.bumptech.glide.load.b.c.a aCv;
    final l.a<l<?>> aGj;
    final com.bumptech.glide.load.b.c.a aHp;
    final m aHq;
    
    b(com.bumptech.glide.load.b.c.a parama1, com.bumptech.glide.load.b.c.a parama2, com.bumptech.glide.load.b.c.a parama3, com.bumptech.glide.load.b.c.a parama4, m paramm)
    {
      AppMethodBeat.i(76980);
      this.aGj = com.bumptech.glide.g.a.a.a(150, new com.bumptech.glide.g.a.a.a() {});
      this.aCv = parama1;
      this.aCu = parama2;
      this.aHp = parama3;
      this.aCB = parama4;
      this.aHq = paramm;
      AppMethodBeat.o(76980);
    }
  }
  
  static final class c
    implements h.d
  {
    private final com.bumptech.glide.load.b.b.a.a aHs;
    private volatile com.bumptech.glide.load.b.b.a aHt;
    
    c(com.bumptech.glide.load.b.b.a.a parama)
    {
      this.aHs = parama;
    }
    
    public final com.bumptech.glide.load.b.b.a oz()
    {
      AppMethodBeat.i(76981);
      if (this.aHt == null) {}
      try
      {
        if (this.aHt == null) {
          this.aHt = this.aHs.pf();
        }
        if (this.aHt == null) {
          this.aHt = new b();
        }
        com.bumptech.glide.load.b.b.a locala = this.aHt;
        AppMethodBeat.o(76981);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(76981);
      }
    }
  }
  
  public final class d
  {
    public final l<?> aHu;
    public final com.bumptech.glide.e.g aHv;
    
    d(l<?> paraml)
    {
      this.aHv = paraml;
      Object localObject;
      this.aHu = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.k
 * JD-Core Version:    0.7.0.1
 */