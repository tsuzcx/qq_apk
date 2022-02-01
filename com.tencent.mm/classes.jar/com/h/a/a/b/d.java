package com.h.a.a.b;

import com.h.a.a.a.b;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class d<K, V>
  implements k<K, V>
{
  private transient Collection<V> atb;
  private transient Collection<Map.Entry<K, V>> eae;
  private transient Set<K> eaf;
  private transient Map<K, Collection<V>> eag;
  
  public Map<K, Collection<V>> akA()
  {
    Map localMap2 = this.eag;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = akG();
      this.eag = localMap1;
    }
    return localMap1;
  }
  
  Set<K> akC()
  {
    return new j.d(akA());
  }
  
  Iterator<V> akD()
  {
    return j.c(akE().iterator());
  }
  
  public Collection<Map.Entry<K, V>> akE()
  {
    Collection localCollection = this.eae;
    Object localObject = localCollection;
    if (localCollection == null) {
      if (!(this instanceof n)) {
        break label35;
      }
    }
    label35:
    for (localObject = new b((byte)0);; localObject = new a((byte)0))
    {
      this.eae = ((Collection)localObject);
      return localObject;
    }
  }
  
  abstract Iterator<Map.Entry<K, V>> akF();
  
  abstract Map<K, Collection<V>> akG();
  
  public boolean containsValue(Object paramObject)
  {
    Iterator localIterator = akA().values().iterator();
    while (localIterator.hasNext()) {
      if (((Collection)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof k))
    {
      paramObject = (k)paramObject;
      return akA().equals(paramObject.akA());
    }
    return false;
  }
  
  public int hashCode()
  {
    return akA().hashCode();
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = this.eaf;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = akC();
      this.eaf = localSet1;
    }
    return localSet1;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Collection)akA().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.remove(paramObject2));
  }
  
  public String toString()
  {
    return akA().toString();
  }
  
  public boolean v(K paramK, V paramV)
  {
    return bQ(paramK).add(paramV);
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.atb;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new c();
      this.atb = ((Collection)localObject);
    }
    return localObject;
  }
  
  public boolean x(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Collection)akA().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.contains(paramObject2));
  }
  
  class a
    extends l<K, V>
  {
    private a() {}
    
    final k<K, V> akP()
    {
      return d.this;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return d.this.akF();
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
    
    public final boolean equals(Object paramObject)
    {
      return b.b(this, paramObject);
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
    
    public final boolean contains(Object paramObject)
    {
      return d.this.containsValue(paramObject);
    }
    
    public final Iterator<V> iterator()
    {
      return d.this.akD();
    }
    
    public final int size()
    {
      return d.this.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */