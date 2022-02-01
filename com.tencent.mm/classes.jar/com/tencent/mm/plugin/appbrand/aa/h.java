package com.tencent.mm.plugin.appbrand.aa;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h<K, V>
{
  private final Map<K, Set<V>> lLT;
  
  public h()
  {
    AppMethodBeat.i(140836);
    this.lLT = new a();
    AppMethodBeat.o(140836);
  }
  
  private Set<V> d(K paramK, boolean paramBoolean)
  {
    AppMethodBeat.i(140838);
    synchronized (this.lLT)
    {
      Set localSet = (Set)this.lLT.get(paramK);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = localSet;
        if (paramBoolean)
        {
          localObject = new HashSet();
          this.lLT.put(paramK, localObject);
        }
      }
      AppMethodBeat.o(140838);
      return localObject;
    }
  }
  
  public final boolean B(K paramK, V paramV)
  {
    AppMethodBeat.i(140839);
    if (paramV == null)
    {
      AppMethodBeat.o(140839);
      return false;
    }
    paramK = d(paramK, false);
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
  
  public final Map<K, Set<V>> bqk()
  {
    AppMethodBeat.i(140842);
    synchronized (this.lLT)
    {
      HashMap localHashMap = new HashMap(this.lLT);
      AppMethodBeat.o(140842);
      return localHashMap;
    }
  }
  
  public final Set<V> cD(K paramK)
  {
    AppMethodBeat.i(140840);
    if (paramK == null)
    {
      AppMethodBeat.o(140840);
      return null;
    }
    paramK = d(paramK, false);
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
  
  public final Set<V> cE(K paramK)
  {
    AppMethodBeat.i(140841);
    if (paramK == null)
    {
      AppMethodBeat.o(140841);
      return null;
    }
    synchronized (this.lLT)
    {
      paramK = (Set)this.lLT.remove(paramK);
      AppMethodBeat.o(140841);
      return paramK;
    }
  }
  
  public final boolean h(K arg1, V paramV)
  {
    AppMethodBeat.i(140837);
    if ((??? == null) || (paramV == null))
    {
      AppMethodBeat.o(140837);
      return false;
    }
    synchronized (d(???, true))
    {
      boolean bool = ???.add(paramV);
      AppMethodBeat.o(140837);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.h
 * JD-Core Version:    0.7.0.1
 */