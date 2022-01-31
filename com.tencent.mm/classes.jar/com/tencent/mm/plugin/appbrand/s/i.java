package com.tencent.mm.plugin.appbrand.s;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class i<K, V>
{
  private final Map<K, Set<V>> iXs;
  
  public i()
  {
    AppMethodBeat.i(91165);
    this.iXs = new a();
    AppMethodBeat.o(91165);
  }
  
  private Set<V> b(K paramK, boolean paramBoolean)
  {
    AppMethodBeat.i(91167);
    synchronized (this.iXs)
    {
      Set localSet = (Set)this.iXs.get(paramK);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = localSet;
        if (paramBoolean)
        {
          localObject = new HashSet();
          this.iXs.put(paramK, localObject);
        }
      }
      AppMethodBeat.o(91167);
      return localObject;
    }
  }
  
  public final Map<K, Set<V>> aNQ()
  {
    AppMethodBeat.i(141841);
    synchronized (this.iXs)
    {
      HashMap localHashMap = new HashMap(this.iXs);
      AppMethodBeat.o(141841);
      return localHashMap;
    }
  }
  
  public final Set<V> br(K paramK)
  {
    AppMethodBeat.i(91168);
    if (paramK == null)
    {
      AppMethodBeat.o(91168);
      return null;
    }
    paramK = b(paramK, false);
    if (paramK == null)
    {
      paramK = Collections.emptySet();
      AppMethodBeat.o(91168);
      return paramK;
    }
    try
    {
      HashSet localHashSet = new HashSet(paramK);
      return localHashSet;
    }
    finally
    {
      AppMethodBeat.o(91168);
    }
  }
  
  public final Set<V> bs(K paramK)
  {
    AppMethodBeat.i(91169);
    if (paramK == null)
    {
      AppMethodBeat.o(91169);
      return null;
    }
    synchronized (this.iXs)
    {
      paramK = (Set)this.iXs.remove(paramK);
      AppMethodBeat.o(91169);
      return paramK;
    }
  }
  
  public final boolean s(K arg1, V paramV)
  {
    AppMethodBeat.i(141839);
    if ((??? == null) || (paramV == null))
    {
      AppMethodBeat.o(141839);
      return false;
    }
    synchronized (b(???, true))
    {
      boolean bool = ???.add(paramV);
      AppMethodBeat.o(141839);
      return bool;
    }
  }
  
  public final boolean t(K paramK, V paramV)
  {
    AppMethodBeat.i(141840);
    if (paramV == null)
    {
      AppMethodBeat.o(141840);
      return false;
    }
    paramK = b(paramK, false);
    if (paramK != null) {
      try
      {
        boolean bool = paramK.remove(paramV);
        return bool;
      }
      finally
      {
        AppMethodBeat.o(141840);
      }
    }
    AppMethodBeat.o(141840);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.i
 * JD-Core Version:    0.7.0.1
 */