package com.tencent.mm.plugin.appbrand.ac;

import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h<K, V>
{
  private final Map<K, Set<V>> ril;
  
  public h()
  {
    AppMethodBeat.i(140836);
    this.ril = new a();
    AppMethodBeat.o(140836);
  }
  
  private Set<V> e(K paramK, boolean paramBoolean)
  {
    AppMethodBeat.i(140838);
    synchronized (this.ril)
    {
      Set localSet = (Set)this.ril.get(paramK);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = localSet;
        if (paramBoolean)
        {
          localObject = new HashSet();
          this.ril.put(paramK, localObject);
        }
      }
      AppMethodBeat.o(140838);
      return localObject;
    }
  }
  
  public final boolean D(K paramK, V paramV)
  {
    AppMethodBeat.i(140839);
    if (paramV == null)
    {
      AppMethodBeat.o(140839);
      return false;
    }
    paramK = e(paramK, false);
    if (paramK != null) {
      try
      {
        boolean bool = paramK.remove(paramV);
        return bool;
      }
      finally
      {
        AppMethodBeat.o(140839);
      }
    }
    AppMethodBeat.o(140839);
    return false;
  }
  
  public final boolean b(K arg1, Collection<V> paramCollection)
  {
    AppMethodBeat.i(208751);
    if ((??? == null) || (paramCollection == null))
    {
      AppMethodBeat.o(208751);
      return false;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(208751);
      return false;
    }
    synchronized (e(???, true))
    {
      boolean bool = ???.addAll(paramCollection);
      AppMethodBeat.o(208751);
      return bool;
    }
  }
  
  public final Set<V> cN(K paramK)
  {
    AppMethodBeat.i(140840);
    if (paramK == null)
    {
      AppMethodBeat.o(140840);
      return null;
    }
    paramK = e(paramK, false);
    if (paramK == null)
    {
      paramK = Collections.emptySet();
      AppMethodBeat.o(140840);
      return paramK;
    }
    try
    {
      HashSet localHashSet = new HashSet(paramK);
      return localHashSet;
    }
    finally
    {
      AppMethodBeat.o(140840);
    }
  }
  
  public final Set<V> cO(K paramK)
  {
    AppMethodBeat.i(140841);
    if (paramK == null)
    {
      AppMethodBeat.o(140841);
      return null;
    }
    synchronized (this.ril)
    {
      paramK = (Set)this.ril.remove(paramK);
      AppMethodBeat.o(140841);
      return paramK;
    }
  }
  
  public final Map<K, Set<V>> clT()
  {
    AppMethodBeat.i(140842);
    synchronized (this.ril)
    {
      HashMap localHashMap = new HashMap(this.ril);
      AppMethodBeat.o(140842);
      return localHashMap;
    }
  }
  
  public final boolean k(K arg1, V paramV)
  {
    AppMethodBeat.i(140837);
    if ((??? == null) || (paramV == null))
    {
      AppMethodBeat.o(140837);
      return false;
    }
    synchronized (e(???, true))
    {
      boolean bool = ???.add(paramV);
      AppMethodBeat.o(140837);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.h
 * JD-Core Version:    0.7.0.1
 */