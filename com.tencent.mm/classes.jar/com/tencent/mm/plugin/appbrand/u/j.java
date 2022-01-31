package com.tencent.mm.plugin.appbrand.u;

import android.support.v4.f.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class j<K, V>
{
  private final Map<K, Set<V>> hkY = new a();
  
  private Set<V> b(K paramK, boolean paramBoolean)
  {
    synchronized (this.hkY)
    {
      Set localSet = (Set)this.hkY.get(paramK);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = localSet;
        if (paramBoolean)
        {
          localObject = new HashSet();
          this.hkY.put(paramK, localObject);
        }
      }
      return localObject;
    }
  }
  
  public final Set<V> aV(K paramK)
  {
    if (paramK == null) {
      return null;
    }
    paramK = b(paramK, false);
    if (paramK == null) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet();
    try
    {
      localHashSet.addAll(paramK);
      return localHashSet;
    }
    finally {}
  }
  
  public final Set<V> aW(K paramK)
  {
    if (paramK == null) {
      return null;
    }
    synchronized (this.hkY)
    {
      paramK = (Set)this.hkY.remove(paramK);
      return paramK;
    }
  }
  
  public final void h(K arg1, V paramV)
  {
    if ((??? == null) || (paramV == null)) {
      return;
    }
    synchronized (b(???, true))
    {
      ???.add(paramV);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.j
 * JD-Core Version:    0.7.0.1
 */