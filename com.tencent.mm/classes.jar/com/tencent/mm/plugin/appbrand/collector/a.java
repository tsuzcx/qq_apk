package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

final class a<K, V>
  extends ConcurrentHashMap<K, V>
{
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(146088);
    if (paramObject == null)
    {
      AppMethodBeat.o(146088);
      return false;
    }
    boolean bool = super.containsValue(paramObject);
    AppMethodBeat.o(146088);
    return bool;
  }
  
  public final V get(Object paramObject)
  {
    AppMethodBeat.i(146085);
    if (paramObject == null)
    {
      AppMethodBeat.o(146085);
      return null;
    }
    paramObject = super.get(paramObject);
    AppMethodBeat.o(146085);
    return paramObject;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(146086);
    if (paramK == null)
    {
      AppMethodBeat.o(146086);
      return null;
    }
    if (paramV == null)
    {
      paramK = super.remove(paramK);
      AppMethodBeat.o(146086);
      return paramK;
    }
    paramK = super.put(paramK, paramV);
    AppMethodBeat.o(146086);
    return paramK;
  }
  
  public final V remove(Object paramObject)
  {
    AppMethodBeat.i(146087);
    if (paramObject == null)
    {
      AppMethodBeat.o(146087);
      return null;
    }
    paramObject = super.remove(paramObject);
    AppMethodBeat.o(146087);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.a
 * JD-Core Version:    0.7.0.1
 */