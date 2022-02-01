package com.d.a.a.b;

import com.d.a.a.a.a;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class d<K, V>
  implements k<K, V>
{
  private transient Collection<Map.Entry<K, V>> bTq;
  private transient Set<K> bTr;
  private transient Collection<V> bTs;
  private transient Map<K, Collection<V>> bTt;
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Iterator localIterator = zo().values().iterator();
    while (localIterator.hasNext()) {
      if (((Collection)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof k))
    {
      paramObject = (k)paramObject;
      return zo().equals(paramObject.zo());
    }
    return false;
  }
  
  public boolean h(@Nullable K paramK, @Nullable V paramV)
  {
    return an(paramK).add(paramV);
  }
  
  public int hashCode()
  {
    return zo().hashCode();
  }
  
  public boolean j(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)zo().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.contains(paramObject2));
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = this.bTr;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = zq();
      this.bTr = localSet1;
    }
    return localSet1;
  }
  
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)zo().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.remove(paramObject2));
  }
  
  public String toString()
  {
    return zo().toString();
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.bTs;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new c();
      this.bTs = ((Collection)localObject);
    }
    return localObject;
  }
  
  public Map<K, Collection<V>> zo()
  {
    Map localMap2 = this.bTt;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = zu();
      this.bTt = localMap1;
    }
    return localMap1;
  }
  
  Set<K> zq()
  {
    return new j.d(zo());
  }
  
  Iterator<V> zr()
  {
    return j.c(zs().iterator());
  }
  
  public Collection<Map.Entry<K, V>> zs()
  {
    Collection localCollection = this.bTq;
    Object localObject = localCollection;
    if (localCollection == null) {
      if (!(this instanceof n)) {
        break label35;
      }
    }
    label35:
    for (localObject = new b((byte)0);; localObject = new a((byte)0))
    {
      this.bTq = ((Collection)localObject);
      return localObject;
    }
  }
  
  abstract Iterator<Map.Entry<K, V>> zt();
  
  abstract Map<K, Collection<V>> zu();
  
  class a
    extends l<K, V>
  {
    private a() {}
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return d.this.zt();
    }
    
    final k<K, V> zD()
    {
      return d.this;
    }
  }
  
  final class b
    extends d<K, V>.Entries
    implements Set<Map.Entry<K, V>>
  {
    private b()
    {
      super((byte)0);
    }
    
    public final boolean equals(@Nullable Object paramObject)
    {
      return a.b(this, paramObject);
    }
    
    public final int hashCode()
    {
      Iterator localIterator = iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (localObject != null) {}
        for (int j = localObject.hashCode();; j = 0)
        {
          i = i + j ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
          break;
        }
      }
      return i;
    }
  }
  
  final class c
    extends AbstractCollection<V>
  {
    c() {}
    
    public final void clear()
    {
      d.this.clear();
    }
    
    public final boolean contains(@Nullable Object paramObject)
    {
      return d.this.containsValue(paramObject);
    }
    
    public final Iterator<V> iterator()
    {
      return d.this.zr();
    }
    
    public final int size()
    {
      return d.this.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */