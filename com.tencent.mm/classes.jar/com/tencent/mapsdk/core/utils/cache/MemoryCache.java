package com.tencent.mapsdk.core.utils.cache;

import com.tencent.mapsdk.internal.jh;
import com.tencent.mapsdk.internal.ji.a;
import com.tencent.mapsdk.internal.jo;
import com.tencent.mapsdk.internal.kl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class MemoryCache<D extends jh>
  extends jo<D>
{
  private static final float a = 0.9F;
  private static final float b = 0.15F;
  private final MemoryCache.a c;
  private final ji.a<D> d;
  
  public MemoryCache(MemoryCache.a parama)
  {
    AppMethodBeat.i(221155);
    this.c = parama;
    int j = (int)(0.9F * (float)Runtime.getRuntime().totalMemory());
    int k = (int)(0.15F * (float)Runtime.getRuntime().freeMemory());
    int i = j;
    if (this.c != null) {
      i = Math.min(Math.max(this.c.b, k), j);
    }
    this.d = new ji.a(i, parama.c);
    AppMethodBeat.o(221155);
  }
  
  private int a()
  {
    AppMethodBeat.i(221164);
    int i = (int)(0.9F * (float)Runtime.getRuntime().totalMemory());
    int j = (int)(0.15F * (float)Runtime.getRuntime().freeMemory());
    if (this.c != null)
    {
      i = Math.min(Math.max(this.c.b, j), i);
      AppMethodBeat.o(221164);
      return i;
    }
    AppMethodBeat.o(221164);
    return i;
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    AppMethodBeat.i(221180);
    paramClass = (jh)this.d.b(paramString);
    if (paramClass == null) {}
    for (int i = 0;; i = paramClass.a())
    {
      kl.a("MC", paramString, "get data length", Integer.valueOf(i));
      kl.f("MC", paramString);
      AppMethodBeat.o(221180);
      return paramClass;
    }
  }
  
  public final void a(String paramString, D paramD)
  {
    AppMethodBeat.i(221171);
    kl.b("MC", paramString);
    this.d.a(paramString, paramD);
    kl.a("MC", paramString, "put data length", Integer.valueOf(paramD.a()));
    AppMethodBeat.o(221171);
  }
  
  public final boolean a(String paramString)
  {
    AppMethodBeat.i(221186);
    if (this.d.c(paramString) != null)
    {
      AppMethodBeat.o(221186);
      return true;
    }
    AppMethodBeat.o(221186);
    return false;
  }
  
  public final void b()
  {
    AppMethodBeat.i(221192);
    this.d.a();
    AppMethodBeat.o(221192);
  }
  
  public final long c()
  {
    AppMethodBeat.i(221196);
    long l = this.d.d().size();
    AppMethodBeat.o(221196);
    return l;
  }
  
  public final long d()
  {
    AppMethodBeat.i(221202);
    long l = this.d.b();
    AppMethodBeat.o(221202);
    return l;
  }
  
  public final long e()
  {
    AppMethodBeat.i(221208);
    long l = this.d.c();
    AppMethodBeat.o(221208);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.core.utils.cache.MemoryCache
 * JD-Core Version:    0.7.0.1
 */