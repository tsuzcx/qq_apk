package com.tencent.mm.memory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
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
  
  public final T aph()
  {
    return null;
  }
  
  public final V bP(V paramV)
  {
    return paramV;
  }
  
  public final V bR(V paramV)
  {
    return paramV;
  }
  
  public final V r(T paramT, V paramV)
  {
    return paramV;
  }
  
  public final Map<T, V> snapshot()
  {
    AppMethodBeat.i(156489);
    Map localMap = this.gER.snapshot();
    AppMethodBeat.o(156489);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.a.c
 * JD-Core Version:    0.7.0.1
 */