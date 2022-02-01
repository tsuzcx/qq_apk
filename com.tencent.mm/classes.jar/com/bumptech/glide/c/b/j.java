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
  private static final boolean aEF;
  private final r aEG;
  private final n aEH;
  private final com.bumptech.glide.c.b.b.h aEI;
  private final b aEJ;
  private final x aEK;
  private final c aEL;
  private final a aEM;
  private final a aEN;
  
  static
  {
    AppMethodBeat.i(76990);
    aEF = Log.isLoggable("Engine", 2);
    AppMethodBeat.o(76990);
  }
  
  public j(com.bumptech.glide.c.b.b.h paramh, com.bumptech.glide.c.b.b.a.a parama, com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, boolean paramBoolean)
  {
    this(paramh, parama, parama1, parama2, parama3, parama4, paramBoolean, (byte)0);
  }
  
  private j(com.bumptech.glide.c.b.b.h paramh, com.bumptech.glide.c.b.b.a.a parama, com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, boolean paramBoolean, byte paramByte)
  {
    AppMethodBeat.i(76982);
    this.aEI = paramh;
    this.aEL = new c(parama);
    parama = new a(paramBoolean);
    this.aEN = parama;
    parama.aDb = this;
    this.aEH = new n();
    this.aEG = new r();
    this.aEJ = new b(parama1, parama2, parama3, parama4, this);
    this.aEM = new a(this.aEL);
    this.aEK = new x();
    paramh.a(this);
    AppMethodBeat.o(76982);
  }
  
  private static void a(String paramString, long paramLong, com.bumptech.glide.c.h paramh)
  {
    AppMethodBeat.i(76984);
    new StringBuilder().append(paramString).append(" in ").append(com.bumptech.glide.h.e.n(paramLong)).append("ms, key: ").append(paramh);
    AppMethodBeat.o(76984);
  }
  
  public static void b(u<?> paramu)
  {
    AppMethodBeat.i(76985);
    com.bumptech.glide.h.j.pQ();
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
    com.bumptech.glide.h.j.pQ();
    if (aEF) {}
    m localm;
    for (long l = com.bumptech.glide.h.e.pO();; l = 0L)
    {
      localm = new m(paramObject, paramh, paramInt1, paramInt2, paramMap, paramClass, paramClass1, paramj);
      if (paramBoolean3) {
        break;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label172;
      }
      paramf.c((u)localObject2, com.bumptech.glide.c.a.aCb);
      if (aEF) {
        a("Loaded resource from active resources", l, localm);
      }
      AppMethodBeat.o(76983);
      return null;
    }
    Object localObject2 = this.aEN;
    Object localObject3 = (a.b)((a)localObject2).aDa.get(localm);
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
        paramf.c((u)localObject2, com.bumptech.glide.c.a.aCb);
        if (aEF) {
          a("Loaded resource from cache", l, localm);
        }
        AppMethodBeat.o(76983);
        return null;
      }
    }
    else
    {
      localObject1 = this.aEI.b(localm);
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
        this.aEN.a(localm, (o)localObject1);
        localObject2 = localObject1;
        break;
        if ((localObject1 instanceof o)) {
          localObject1 = (o)localObject1;
        } else {
          localObject1 = new o((u)localObject1, true, true);
        }
      }
    }
    Object localObject1 = (k)this.aEG.aH(paramBoolean6).get(localm);
    if (localObject1 != null)
    {
      ((k)localObject1).a(paramf);
      if (aEF) {
        a("Added to existing load", l, localm);
      }
      parame = new d(paramf, (k)localObject1);
      AppMethodBeat.o(76983);
      return parame;
    }
    localObject1 = (k)com.bumptech.glide.h.i.checkNotNull((k)this.aEJ.aDJ.acquire(), "Argument must not be null");
    ((k)localObject1).aDh = localm;
    ((k)localObject1).aDi = paramBoolean3;
    ((k)localObject1).aFb = paramBoolean4;
    ((k)localObject1).aFc = paramBoolean5;
    ((k)localObject1).aDR = paramBoolean6;
    localObject3 = this.aEM;
    localObject2 = (g)com.bumptech.glide.h.i.checkNotNull((g)((a)localObject3).aDJ.acquire(), "Argument must not be null");
    int i = ((a)localObject3).aEO;
    ((a)localObject3).aEO = (i + 1);
    localObject3 = ((g)localObject2).aDG;
    g.d locald = ((g)localObject2).aDy;
    ((f)localObject3).azC = parame;
    ((f)localObject3).aAv = paramObject;
    ((f)localObject3).aDt = paramh;
    ((f)localObject3).width = paramInt1;
    ((f)localObject3).height = paramInt2;
    ((f)localObject3).aDD = parami;
    ((f)localObject3).aDx = paramClass;
    ((f)localObject3).aDy = locald;
    ((f)localObject3).aAs = paramClass1;
    ((f)localObject3).aDC = paramg;
    ((f)localObject3).aDv = paramj;
    ((f)localObject3).aDz = paramMap;
    ((f)localObject3).aDE = paramBoolean1;
    ((f)localObject3).aDF = paramBoolean2;
    ((g)localObject2).azC = parame;
    ((g)localObject2).aDt = paramh;
    ((g)localObject2).aDC = paramg;
    ((g)localObject2).aDM = localm;
    ((g)localObject2).width = paramInt1;
    ((g)localObject2).height = paramInt2;
    ((g)localObject2).aDD = parami;
    ((g)localObject2).aDR = paramBoolean6;
    ((g)localObject2).aDv = paramj;
    ((g)localObject2).aDN = ((g.a)localObject1);
    ((g)localObject2).order = i;
    ((g)localObject2).aDP = g.f.aEk;
    ((g)localObject2).aAv = paramObject;
    this.aEG.aH(((k)localObject1).aDR).put(localm, localObject1);
    ((k)localObject1).a(paramf);
    ((k)localObject1).aFi = ((g)localObject2);
    parame = ((g)localObject2).a(g.g.aEo);
    if ((parame == g.g.aEp) || (parame == g.g.aEq))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label796;
      }
    }
    label796:
    for (parame = ((k)localObject1).azL;; parame = ((k)localObject1).ol())
    {
      parame.execute((Runnable)localObject2);
      if (aEF) {
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
    com.bumptech.glide.h.j.pQ();
    this.aEG.a(paramh, paramk);
    AppMethodBeat.o(76987);
  }
  
  public final void a(k<?> paramk, com.bumptech.glide.c.h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76986);
    com.bumptech.glide.h.j.pQ();
    if (paramo != null)
    {
      paramo.a(paramh, this);
      if (paramo.aDi) {
        this.aEN.a(paramh, paramo);
      }
    }
    this.aEG.a(paramh, paramk);
    AppMethodBeat.o(76986);
  }
  
  public final void b(com.bumptech.glide.c.h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76989);
    com.bumptech.glide.h.j.pQ();
    a.b localb = (a.b)this.aEN.aDa.remove(paramh);
    if (localb != null) {
      localb.reset();
    }
    if (paramo.aDi)
    {
      this.aEI.a(paramh, paramo);
      AppMethodBeat.o(76989);
      return;
    }
    this.aEK.e(paramo);
    AppMethodBeat.o(76989);
  }
  
  public final void c(u<?> paramu)
  {
    AppMethodBeat.i(76988);
    com.bumptech.glide.h.j.pQ();
    this.aEK.e(paramu);
    AppMethodBeat.o(76988);
  }
  
  static final class a
  {
    final l.a<g<?>> aDJ;
    final g.d aDy;
    int aEO;
    
    a(g.d paramd)
    {
      AppMethodBeat.i(76978);
      this.aDJ = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a() {});
      this.aDy = paramd;
      AppMethodBeat.o(76978);
    }
  }
  
  static final class b
  {
    final l.a<k<?>> aDJ;
    final com.bumptech.glide.c.b.c.a aEQ;
    final l aER;
    final com.bumptech.glide.c.b.c.a azK;
    final com.bumptech.glide.c.b.c.a azL;
    final com.bumptech.glide.c.b.c.a azR;
    
    b(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml)
    {
      AppMethodBeat.i(76980);
      this.aDJ = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a() {});
      this.azL = parama1;
      this.azK = parama2;
      this.aEQ = parama3;
      this.azR = parama4;
      this.aER = paraml;
      AppMethodBeat.o(76980);
    }
  }
  
  static final class c
    implements g.d
  {
    private final com.bumptech.glide.c.b.b.a.a aET;
    private volatile com.bumptech.glide.c.b.b.a aEU;
    
    c(com.bumptech.glide.c.b.b.a.a parama)
    {
      this.aET = parama;
    }
    
    public final com.bumptech.glide.c.b.b.a nR()
    {
      AppMethodBeat.i(76981);
      if (this.aEU == null) {}
      try
      {
        if (this.aEU == null) {
          this.aEU = this.aET.oy();
        }
        if (this.aEU == null) {
          this.aEU = new b();
        }
        com.bumptech.glide.c.b.b.a locala = this.aEU;
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
    public final k<?> aEV;
    public final com.bumptech.glide.f.f aEW;
    
    d(com.bumptech.glide.f.f paramf, k<?> paramk)
    {
      this.aEW = paramf;
      this.aEV = paramk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.j
 * JD-Core Version:    0.7.0.1
 */