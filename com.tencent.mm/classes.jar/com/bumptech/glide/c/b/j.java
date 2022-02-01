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
  private static final boolean aFv;
  private final x aFA;
  private final c aFB;
  private final a aFC;
  private final a aFD;
  private final r aFw;
  private final n aFx;
  private final com.bumptech.glide.c.b.b.h aFy;
  private final b aFz;
  
  static
  {
    AppMethodBeat.i(76990);
    aFv = Log.isLoggable("Engine", 2);
    AppMethodBeat.o(76990);
  }
  
  public j(com.bumptech.glide.c.b.b.h paramh, com.bumptech.glide.c.b.b.a.a parama, com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, boolean paramBoolean)
  {
    this(paramh, parama, parama1, parama2, parama3, parama4, paramBoolean, (byte)0);
  }
  
  private j(com.bumptech.glide.c.b.b.h paramh, com.bumptech.glide.c.b.b.a.a parama, com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, boolean paramBoolean, byte paramByte)
  {
    AppMethodBeat.i(76982);
    this.aFy = paramh;
    this.aFB = new c(parama);
    parama = new a(paramBoolean);
    this.aFD = parama;
    parama.aDS = this;
    this.aFx = new n();
    this.aFw = new r();
    this.aFz = new b(parama1, parama2, parama3, parama4, this);
    this.aFC = new a(this.aFB);
    this.aFA = new x();
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
    com.bumptech.glide.h.j.qa();
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
    com.bumptech.glide.h.j.qa();
    if (aFv) {}
    m localm;
    for (long l = com.bumptech.glide.h.e.pY();; l = 0L)
    {
      localm = new m(paramObject, paramh, paramInt1, paramInt2, paramMap, paramClass, paramClass1, paramj);
      if (paramBoolean3) {
        break;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label172;
      }
      paramf.c((u)localObject2, com.bumptech.glide.c.a.aCT);
      if (aFv) {
        a("Loaded resource from active resources", l, localm);
      }
      AppMethodBeat.o(76983);
      return null;
    }
    Object localObject2 = this.aFD;
    Object localObject3 = (a.b)((a)localObject2).aDR.get(localm);
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
        paramf.c((u)localObject2, com.bumptech.glide.c.a.aCT);
        if (aFv) {
          a("Loaded resource from cache", l, localm);
        }
        AppMethodBeat.o(76983);
        return null;
      }
    }
    else
    {
      localObject1 = this.aFy.b(localm);
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
        this.aFD.a(localm, (o)localObject1);
        localObject2 = localObject1;
        break;
        if ((localObject1 instanceof o)) {
          localObject1 = (o)localObject1;
        } else {
          localObject1 = new o((u)localObject1, true, true);
        }
      }
    }
    Object localObject1 = (k)this.aFw.aH(paramBoolean6).get(localm);
    if (localObject1 != null)
    {
      ((k)localObject1).a(paramf);
      if (aFv) {
        a("Added to existing load", l, localm);
      }
      parame = new d(paramf, (k)localObject1);
      AppMethodBeat.o(76983);
      return parame;
    }
    localObject1 = (k)com.bumptech.glide.h.i.checkNotNull((k)this.aFz.aEA.acquire(), "Argument must not be null");
    ((k)localObject1).aDY = localm;
    ((k)localObject1).aDZ = paramBoolean3;
    ((k)localObject1).aFR = paramBoolean4;
    ((k)localObject1).aFS = paramBoolean5;
    ((k)localObject1).aEI = paramBoolean6;
    localObject3 = this.aFC;
    localObject2 = (g)com.bumptech.glide.h.i.checkNotNull((g)((a)localObject3).aEA.acquire(), "Argument must not be null");
    int i = ((a)localObject3).aFE;
    ((a)localObject3).aFE = (i + 1);
    localObject3 = ((g)localObject2).aEx;
    g.d locald = ((g)localObject2).aEp;
    ((f)localObject3).aAw = parame;
    ((f)localObject3).aBp = paramObject;
    ((f)localObject3).aEk = paramh;
    ((f)localObject3).width = paramInt1;
    ((f)localObject3).height = paramInt2;
    ((f)localObject3).aEu = parami;
    ((f)localObject3).aEo = paramClass;
    ((f)localObject3).aEp = locald;
    ((f)localObject3).aBm = paramClass1;
    ((f)localObject3).aEt = paramg;
    ((f)localObject3).aEm = paramj;
    ((f)localObject3).aEq = paramMap;
    ((f)localObject3).aEv = paramBoolean1;
    ((f)localObject3).aEw = paramBoolean2;
    ((g)localObject2).aAw = parame;
    ((g)localObject2).aEk = paramh;
    ((g)localObject2).aEt = paramg;
    ((g)localObject2).aED = localm;
    ((g)localObject2).width = paramInt1;
    ((g)localObject2).height = paramInt2;
    ((g)localObject2).aEu = parami;
    ((g)localObject2).aEI = paramBoolean6;
    ((g)localObject2).aEm = paramj;
    ((g)localObject2).aEE = ((g.a)localObject1);
    ((g)localObject2).order = i;
    ((g)localObject2).aEG = g.f.aFa;
    ((g)localObject2).aBp = paramObject;
    this.aFw.aH(((k)localObject1).aEI).put(localm, localObject1);
    ((k)localObject1).a(paramf);
    ((k)localObject1).aFY = ((g)localObject2);
    parame = ((g)localObject2).a(g.g.aFe);
    if ((parame == g.g.aFf) || (parame == g.g.aFg))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label796;
      }
    }
    label796:
    for (parame = ((k)localObject1).aAF;; parame = ((k)localObject1).ov())
    {
      parame.execute((Runnable)localObject2);
      if (aFv) {
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
    com.bumptech.glide.h.j.qa();
    this.aFw.a(paramh, paramk);
    AppMethodBeat.o(76987);
  }
  
  public final void a(k<?> paramk, com.bumptech.glide.c.h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76986);
    com.bumptech.glide.h.j.qa();
    if (paramo != null)
    {
      paramo.a(paramh, this);
      if (paramo.aDZ) {
        this.aFD.a(paramh, paramo);
      }
    }
    this.aFw.a(paramh, paramk);
    AppMethodBeat.o(76986);
  }
  
  public final void b(com.bumptech.glide.c.h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76989);
    com.bumptech.glide.h.j.qa();
    a.b localb = (a.b)this.aFD.aDR.remove(paramh);
    if (localb != null) {
      localb.reset();
    }
    if (paramo.aDZ)
    {
      this.aFy.a(paramh, paramo);
      AppMethodBeat.o(76989);
      return;
    }
    this.aFA.e(paramo);
    AppMethodBeat.o(76989);
  }
  
  public final void c(u<?> paramu)
  {
    AppMethodBeat.i(76988);
    com.bumptech.glide.h.j.qa();
    this.aFA.e(paramu);
    AppMethodBeat.o(76988);
  }
  
  static final class a
  {
    final l.a<g<?>> aEA;
    final g.d aEp;
    int aFE;
    
    a(g.d paramd)
    {
      AppMethodBeat.i(76978);
      this.aEA = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a() {});
      this.aEp = paramd;
      AppMethodBeat.o(76978);
    }
  }
  
  static final class b
  {
    final com.bumptech.glide.c.b.c.a aAE;
    final com.bumptech.glide.c.b.c.a aAF;
    final com.bumptech.glide.c.b.c.a aAL;
    final l.a<k<?>> aEA;
    final com.bumptech.glide.c.b.c.a aFG;
    final l aFH;
    
    b(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml)
    {
      AppMethodBeat.i(76980);
      this.aEA = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a() {});
      this.aAF = parama1;
      this.aAE = parama2;
      this.aFG = parama3;
      this.aAL = parama4;
      this.aFH = paraml;
      AppMethodBeat.o(76980);
    }
  }
  
  static final class c
    implements g.d
  {
    private final com.bumptech.glide.c.b.b.a.a aFJ;
    private volatile com.bumptech.glide.c.b.b.a aFK;
    
    c(com.bumptech.glide.c.b.b.a.a parama)
    {
      this.aFJ = parama;
    }
    
    public final com.bumptech.glide.c.b.b.a ob()
    {
      AppMethodBeat.i(76981);
      if (this.aFK == null) {}
      try
      {
        if (this.aFK == null) {
          this.aFK = this.aFJ.oI();
        }
        if (this.aFK == null) {
          this.aFK = new b();
        }
        com.bumptech.glide.c.b.b.a locala = this.aFK;
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
    public final k<?> aFL;
    public final com.bumptech.glide.f.f aFM;
    
    d(com.bumptech.glide.f.f paramf, k<?> paramk)
    {
      this.aFM = paramf;
      this.aFL = paramk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.j
 * JD-Core Version:    0.7.0.1
 */