package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

final class a<K, V>
  extends ConcurrentHashMap<K, V>
{
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(57023);
    if (paramObject == null)
    {
      AppMethodBeat.o(57023);
      return false;
    }
    boolean bool = super.containsValue(paramObject);
    AppMethodBeat.o(57023);
    return bool;
  }
  
  public final V get(Object paramObject)
  {
    AppMethodBeat.i(57020);
    if (paramObject == null)
    {
      AppMethodBeat.o(57020);
      return null;
    }
    paramObject = super.get(paramObject);
    AppMethodBeat.o(57020);
    return paramObject;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(57021);
    if (paramK == null)
    {
      AppMethodBeat.o(57021);
      return null;
    }
    if (paramV == null)
    {
      paramK = super.remove(paramK);
      AppMethodBeat.o(57021);
      return paramK;
    }
    paramK = super.put(paramK, paramV);
    AppMethodBeat.o(57021);
    return paramK;
  }
  
  public final V remove(Object paramObject)
  {
    AppMethodBeat.i(57022);
    if (paramObject == null)
    {
      AppMethodBeat.o(57022);
      return null;
    }
    paramObject = super.remove(paramObject);
    AppMethodBeat.o(57022);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.a
 * JD-Core Version:    0.7.0.1
 */