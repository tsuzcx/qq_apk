package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

final class v$a<K, V>
  extends ConcurrentHashMap<K, V>
{
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(115075);
    if (paramObject == null)
    {
      AppMethodBeat.o(115075);
      return false;
    }
    boolean bool = super.containsValue(paramObject);
    AppMethodBeat.o(115075);
    return bool;
  }
  
  public final V get(Object paramObject)
  {
    AppMethodBeat.i(115072);
    if (paramObject == null)
    {
      AppMethodBeat.o(115072);
      return null;
    }
    paramObject = super.get(paramObject);
    AppMethodBeat.o(115072);
    return paramObject;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(115073);
    if (paramK == null)
    {
      AppMethodBeat.o(115073);
      return null;
    }
    if (paramV == null)
    {
      paramK = super.remove(paramK);
      AppMethodBeat.o(115073);
      return paramK;
    }
    paramK = super.put(paramK, paramV);
    AppMethodBeat.o(115073);
    return paramK;
  }
  
  public final V remove(Object paramObject)
  {
    AppMethodBeat.i(115074);
    if (paramObject == null)
    {
      AppMethodBeat.o(115074);
      return null;
    }
    paramObject = super.remove(paramObject);
    AppMethodBeat.o(115074);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.v.a
 * JD-Core Version:    0.7.0.1
 */