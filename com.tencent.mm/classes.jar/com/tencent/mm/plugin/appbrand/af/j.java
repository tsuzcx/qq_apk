package com.tencent.mm.plugin.appbrand.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class j<K, V>
{
  private final Map<K, Set<V>> uqh;
  
  public j()
  {
    AppMethodBeat.i(140836);
    this.uqh = new androidx.b.a();
    AppMethodBeat.o(140836);
  }
  
  private Set<V> f(K paramK, boolean paramBoolean)
  {
    AppMethodBeat.i(140838);
    synchronized (this.uqh)
    {
      Set localSet = (Set)this.uqh.get(paramK);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = localSet;
        if (paramBoolean)
        {
          localObject = new HashSet();
          this.uqh.put(paramK, localObject);
        }
      }
      AppMethodBeat.o(140838);
      return localObject;
    }
  }
  
  public final boolean O(K paramK, V paramV)
  {
    AppMethodBeat.i(140839);
    if (paramV == null)
    {
      AppMethodBeat.o(140839);
      return false;
    }
    paramK = f(paramK, false);
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
  
  public final void a(K paramK, androidx.core.f.a<V> parama)
  {
    AppMethodBeat.i(318728);
    if ((paramK == null) || (parama == null))
    {
      AppMethodBeat.o(318728);
      return;
    }
    paramK = ej(paramK).iterator();
    while (paramK.hasNext()) {
      parama.accept(paramK.next());
    }
    AppMethodBeat.o(318728);
  }
  
  public final boolean b(K arg1, Collection<V> paramCollection)
  {
    AppMethodBeat.i(318719);
    if ((??? == null) || (paramCollection == null))
    {
      AppMethodBeat.o(318719);
      return false;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(318719);
      return false;
    }
    synchronized (f(???, true))
    {
      boolean bool = ???.addAll(paramCollection);
      AppMethodBeat.o(318719);
      return bool;
    }
  }
  
  public final Map<K, Set<V>> cNk()
  {
    AppMethodBeat.i(140842);
    synchronized (this.uqh)
    {
      HashMap localHashMap = new HashMap(this.uqh);
      AppMethodBeat.o(140842);
      return localHashMap;
    }
  }
  
  public final Set<V> ej(K paramK)
  {
    AppMethodBeat.i(140840);
    if (paramK == null)
    {
      AppMethodBeat.o(140840);
      return null;
    }
    paramK = f(paramK, false);
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
  
  public final Set<V> ek(K paramK)
  {
    AppMethodBeat.i(140841);
    if (paramK == null)
    {
      AppMethodBeat.o(140841);
      return null;
    }
    synchronized (this.uqh)
    {
      paramK = (Set)this.uqh.remove(paramK);
      AppMethodBeat.o(140841);
      return paramK;
    }
  }
  
  public final boolean v(K arg1, V paramV)
  {
    AppMethodBeat.i(140837);
    if ((??? == null) || (paramV == null))
    {
      AppMethodBeat.o(140837);
      return false;
    }
    synchronized (f(???, true))
    {
      boolean bool = ???.add(paramV);
      AppMethodBeat.o(140837);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.j
 * JD-Core Version:    0.7.0.1
 */