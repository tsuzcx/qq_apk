package com.tencent.mm.memory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
import java.util.Collection;
import java.util.Map;

public final class c<T, V>
  extends a<T, V, V, V>
{
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public c(f.b<T, V> paramb)
  {
    super(paramb);
  }
  
  public final V E(T paramT, V paramV)
  {
    return paramV;
  }
  
  public final T bvY()
  {
    return null;
  }
  
  public final V dr(V paramV)
  {
    return paramV;
  }
  
  public final V dt(V paramV)
  {
    return paramV;
  }
  
  public final Map<T, V> snapshot()
  {
    AppMethodBeat.i(156489);
    Map localMap = this.nOp.snapshot();
    AppMethodBeat.o(156489);
    return localMap;
  }
  
  public final Collection<V> values()
  {
    AppMethodBeat.i(238940);
    Collection localCollection = this.nOp.values();
    AppMethodBeat.o(238940);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.c
 * JD-Core Version:    0.7.0.1
 */