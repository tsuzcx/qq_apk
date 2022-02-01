package com.e.a.a.b;

import com.e.a.a.a.a;
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
  private transient Collection<Map.Entry<K, V>> cdD;
  private transient Set<K> cdE;
  private transient Collection<V> cdF;
  private transient Map<K, Collection<V>> cdG;
  
  public Map<K, Collection<V>> AL()
  {
    Map localMap2 = this.cdG;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = AR();
      this.cdG = localMap1;
    }
    return localMap1;
  }
  
  Set<K> AN()
  {
    return new j.d(AL());
  }
  
  Iterator<V> AO()
  {
    return j.c(AP().iterator());
  }
  
  public Collection<Map.Entry<K, V>> AP()
  {
    Collection localCollection = this.cdD;
    Object localObject = localCollection;
    if (localCollection == null) {
      if (!(this instanceof n)) {
        break label35;
      }
    }
    label35:
    for (localObject = new b((byte)0);; localObject = new a((byte)0))
    {
      this.cdD = ((Collection)localObject);
      return localObject;
    }
  }
  
  abstract Iterator<Map.Entry<K, V>> AQ();
  
  abstract Map<K, Collection<V>> AR();
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Iterator localIterator = AL().values().iterator();
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
      return AL().equals(paramObject.AL());
    }
    return false;
  }
  
  public int hashCode()
  {
    return AL().hashCode();
  }
  
  public boolean j(@Nullable K paramK, @Nullable V paramV)
  {
    return aq(paramK).add(paramV);
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = this.cdE;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = AN();
      this.cdE = localSet1;
    }
    return localSet1;
  }
  
  public boolean l(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)AL().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.contains(paramObject2));
  }
  
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)AL().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.remove(paramObject2));
  }
  
  public String toString()
  {
    return AL().toString();
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.cdF;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new c();
      this.cdF = ((Collection)localObject);
    }
    return localObject;
  }
  
  class a
    extends l<K, V>
  {
    private a() {}
    
    final k<K, V> Ba()
    {
      return d.this;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return d.this.AQ();
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
      return d.this.AO();
    }
    
    public final int size()
    {
      return d.this.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */