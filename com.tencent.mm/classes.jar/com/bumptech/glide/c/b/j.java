package com.bumptech.glide.c.b;

import android.support.v4.e.l.a;
import android.util.Log;
import com.bumptech.glide.c.b.b.b;
import com.bumptech.glide.c.b.b.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
  implements h.a, l, o.a
{
  private static final boolean aHm;
  private final r aHn;
  private final n aHo;
  private final com.bumptech.glide.c.b.b.h aHp;
  private final b aHq;
  private final x aHr;
  private final c aHs;
  private final a aHt;
  private final a aHu;
  
  static
  {
    AppMethodBeat.i(76990);
    aHm = Log.isLoggable("Engine", 2);
    AppMethodBeat.o(76990);
  }
  
  public j(com.bumptech.glide.c.b.b.h paramh, com.bumptech.glide.c.b.b.a.a parama, com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, boolean paramBoolean)
  {
    this(paramh, parama, parama1, parama2, parama3, parama4, paramBoolean, (byte)0);
  }
  
  private j(com.bumptech.glide.c.b.b.h paramh, com.bumptech.glide.c.b.b.a.a parama, com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, boolean paramBoolean, byte paramByte)
  {
    AppMethodBeat.i(76982);
    this.aHp = paramh;
    this.aHs = new c(parama);
    parama = new a(paramBoolean);
    this.aHu = parama;
    parama.aFJ = this;
    this.aHo = new n();
    this.aHn = new r();
    this.aHq = new b(parama1, parama2, parama3, parama4, this);
    this.aHt = new a(this.aHs);
    this.aHr = new x();
    paramh.a(this);
    AppMethodBeat.o(76982);
  }
  
  private static void a(String paramString, long paramLong, com.bumptech.glide.c.h paramh)
  {
    AppMethodBeat.i(76984);
    new StringBuilder().append(paramString).append(" in ").append(com.bumptech.glide.h.e.p(paramLong)).append("ms, key: ").append(paramh);
    AppMethodBeat.o(76984);
  }
  
  public static void b(u<?> paramu)
  {
    AppMethodBeat.i(76985);
    com.bumptech.glide.h.j.qs();
    if ((paramu instanceof o))
    {
      ((o)paramu).release();
      AppMethodBeat.o(76985);
      return;
    }
    paramu = new IllegalArgumentException("Cannot release anything but an EngineResource");
    AppMethodBeat.o(76985);
    throw paramu;
  }
  
  public final <R> d a(com.bumptech.glide.e parame, Object paramObject, com.bumptech.glide.c.h paramh, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, com.bumptech.glide.g paramg, i parami, Map<Class<?>, com.bumptech.glide.c.m<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, com.bumptech.glide.c.j paramj, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, com.bumptech.glide.f.f paramf)
  {
    AppMethodBeat.i(76983);
    com.bumptech.glide.h.j.qs();
    if (aHm) {}
    m localm;
    for (long l = com.bumptech.glide.h.e.qq();; l = 0L)
    {
      localm = new m(paramObject, paramh, paramInt1, paramInt2, paramMap, paramClass, paramClass1, paramj);
      if (paramBoolean3) {
        break;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label172;
      }
      paramf.c((u)localObject2, com.bumptech.glide.c.a.aEK);
      if (aHm) {
        a("Loaded resource from active resources", l, localm);
      }
      AppMethodBeat.o(76983);
      return null;
    }
    Object localObject2 = this.aHu;
    Object localObject3 = (a.b)((a)localObject2).aFI.get(localm);
    if (localObject3 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      ((o)localObject1).acquire();
      localObject2 = localObject1;
      break;
      localObject1 = (o)((a.b)localObject3).get();
      if (localObject1 == null) {
        ((a)localObject2).a((a.b)localObject3);
      }
    }
    label172:
    if (!paramBoolean3)
    {
      localObject2 = null;
      if (localObject2 != null)
      {
        paramf.c((u)localObject2, com.bumptech.glide.c.a.aEK);
        if (aHm) {
          a("Loaded resource from cache", l, localm);
        }
        AppMethodBeat.o(76983);
        return null;
      }
    }
    else
    {
      localObject1 = this.aHp.b(localm);
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        ((o)localObject1).acquire();
        this.aHu.a(localm, (o)localObject1);
        localObject2 = localObject1;
        break;
        if ((localObject1 instanceof o)) {
          localObject1 = (o)localObject1;
        } else {
          localObject1 = new o((u)localObject1, true, true);
        }
      }
    }
    Object localObject1 = (k)this.aHn.aH(paramBoolean6).get(localm);
    if (localObject1 != null)
    {
      ((k)localObject1).a(paramf);
      if (aHm) {
        a("Added to existing load", l, localm);
      }
      parame = new d(paramf, (k)localObject1);
      AppMethodBeat.o(76983);
      return parame;
    }
    localObject1 = (k)com.bumptech.glide.h.i.checkNotNull((k)this.aHq.aGr.acquire(), "Argument must not be null");
    ((k)localObject1).aFP = localm;
    ((k)localObject1).aFQ = paramBoolean3;
    ((k)localObject1).aHI = paramBoolean4;
    ((k)localObject1).aHJ = paramBoolean5;
    ((k)localObject1).aGz = paramBoolean6;
    localObject3 = this.aHt;
    localObject2 = (g)com.bumptech.glide.h.i.checkNotNull((g)((a)localObject3).aGr.acquire(), "Argument must not be null");
    int i = ((a)localObject3).aHv;
    ((a)localObject3).aHv = (i + 1);
    localObject3 = ((g)localObject2).aGo;
    g.d locald = ((g)localObject2).aGg;
    ((f)localObject3).aCn = parame;
    ((f)localObject3).aDg = paramObject;
    ((f)localObject3).aGb = paramh;
    ((f)localObject3).width = paramInt1;
    ((f)localObject3).height = paramInt2;
    ((f)localObject3).aGl = parami;
    ((f)localObject3).aGf = paramClass;
    ((f)localObject3).aGg = locald;
    ((f)localObject3).aDd = paramClass1;
    ((f)localObject3).aGk = paramg;
    ((f)localObject3).aGd = paramj;
    ((f)localObject3).aGh = paramMap;
    ((f)localObject3).aGm = paramBoolean1;
    ((f)localObject3).aGn = paramBoolean2;
    ((g)localObject2).aCn = parame;
    ((g)localObject2).aGb = paramh;
    ((g)localObject2).aGk = paramg;
    ((g)localObject2).aGu = localm;
    ((g)localObject2).width = paramInt1;
    ((g)localObject2).height = paramInt2;
    ((g)localObject2).aGl = parami;
    ((g)localObject2).aGz = paramBoolean6;
    ((g)localObject2).aGd = paramj;
    ((g)localObject2).aGv = ((g.a)localObject1);
    ((g)localObject2).order = i;
    ((g)localObject2).aGx = g.f.aGR;
    ((g)localObject2).aDg = paramObject;
    this.aHn.aH(((k)localObject1).aGz).put(localm, localObject1);
    ((k)localObject1).a(paramf);
    ((k)localObject1).aHP = ((g)localObject2);
    parame = ((g)localObject2).a(g.g.aGV);
    if ((parame == g.g.aGW) || (parame == g.g.aGX))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label796;
      }
    }
    label796:
    for (parame = ((k)localObject1).aCw;; parame = ((k)localObject1).oN())
    {
      parame.execute((Runnable)localObject2);
      if (aHm) {
        a("Started new load", l, localm);
      }
      parame = new d(paramf, (k)localObject1);
      AppMethodBeat.o(76983);
      return parame;
      paramInt1 = 0;
      break;
    }
  }
  
  public final void a(k<?> paramk, com.bumptech.glide.c.h paramh)
  {
    AppMethodBeat.i(76987);
    com.bumptech.glide.h.j.qs();
    this.aHn.a(paramh, paramk);
    AppMethodBeat.o(76987);
  }
  
  public final void a(k<?> paramk, com.bumptech.glide.c.h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76986);
    com.bumptech.glide.h.j.qs();
    if (paramo != null)
    {
      paramo.a(paramh, this);
      if (paramo.aFQ) {
        this.aHu.a(paramh, paramo);
      }
    }
    this.aHn.a(paramh, paramk);
    AppMethodBeat.o(76986);
  }
  
  public final void b(com.bumptech.glide.c.h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76989);
    com.bumptech.glide.h.j.qs();
    a.b localb = (a.b)this.aHu.aFI.remove(paramh);
    if (localb != null) {
      localb.reset();
    }
    if (paramo.aFQ)
    {
      this.aHp.a(paramh, paramo);
      AppMethodBeat.o(76989);
      return;
    }
    this.aHr.e(paramo);
    AppMethodBeat.o(76989);
  }
  
  public final void c(u<?> paramu)
  {
    AppMethodBeat.i(76988);
    com.bumptech.glide.h.j.qs();
    this.aHr.e(paramu);
    AppMethodBeat.o(76988);
  }
  
  static final class a
  {
    final g.d aGg;
    final l.a<g<?>> aGr;
    int aHv;
    
    a(g.d paramd)
    {
      AppMethodBeat.i(76978);
      this.aGr = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a() {});
      this.aGg = paramd;
      AppMethodBeat.o(76978);
    }
  }
  
  static final class b
  {
    final com.bumptech.glide.c.b.c.a aCC;
    final com.bumptech.glide.c.b.c.a aCv;
    final com.bumptech.glide.c.b.c.a aCw;
    final l.a<k<?>> aGr;
    final com.bumptech.glide.c.b.c.a aHx;
    final l aHy;
    
    b(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml)
    {
      AppMethodBeat.i(76980);
      this.aGr = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a() {});
      this.aCw = parama1;
      this.aCv = parama2;
      this.aHx = parama3;
      this.aCC = parama4;
      this.aHy = paraml;
      AppMethodBeat.o(76980);
    }
  }
  
  static final class c
    implements g.d
  {
    private final com.bumptech.glide.c.b.b.a.a aHA;
    private volatile com.bumptech.glide.c.b.b.a aHB;
    
    c(com.bumptech.glide.c.b.b.a.a parama)
    {
      this.aHA = parama;
    }
    
    public final com.bumptech.glide.c.b.b.a ot()
    {
      AppMethodBeat.i(76981);
      if (this.aHB == null) {}
      try
      {
        if (this.aHB == null) {
          this.aHB = this.aHA.pa();
        }
        if (this.aHB == null) {
          this.aHB = new b();
        }
        com.bumptech.glide.c.b.b.a locala = this.aHB;
        AppMethodBeat.o(76981);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(76981);
      }
    }
  }
  
  public static final class d
  {
    public final k<?> aHC;
    public final com.bumptech.glide.f.f aHD;
    
    d(com.bumptech.glide.f.f paramf, k<?> paramk)
    {
      this.aHD = paramf;
      this.aHC = paramk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.j
 * JD-Core Version:    0.7.0.1
 */