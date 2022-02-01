package com.tencent.mapsdk.core.utils.cache;

import com.tencent.mapsdk.internal.jg.a;
import com.tencent.mapsdk.internal.jg.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MemoryCache$a
  implements jg.a
{
  public int b;
  public jg.b c;
  
  private a a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  private <D> a a(jg.b<D> paramb)
  {
    this.c = paramb;
    return this;
  }
  
  private <D> jg.b<D> b()
  {
    return this.c;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221157);
    String str = "Options{mMaxCacheSize=" + this.b + '}';
    AppMethodBeat.o(221157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.core.utils.cache.MemoryCache.a
 * JD-Core Version:    0.7.0.1
 */