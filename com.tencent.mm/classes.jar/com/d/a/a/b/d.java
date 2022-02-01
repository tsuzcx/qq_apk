package com.d.a.a.b;

import com.d.a.a.a.b;
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
  private transient Collection<Map.Entry<K, V>> cjI;
  private transient Set<K> cjJ;
  private transient Collection<V> cjK;
  private transient Map<K, Collection<V>> cjL;
  
  Set<K> KB()
  {
    return new j.d(Kz());
  }
  
  Iterator<V> KC()
  {
    return j.c(KD().iterator());
  }
  
  public Collection<Map.Entry<K, V>> KD()
  {
    Collection localCollection = this.cjI;
    Object localObject = localCollection;
    if (localCollection == null) {
      if (!(this instanceof n)) {
        break label35;
      }
    }
    label35:
    for (localObject = new b((byte)0);; localObject = new a((byte)0))
    {
      this.cjI = ((Collection)localObject);
      return localObject;
    }
  }
  
  abstract Iterator<Map.Entry<K, V>> KE();
  
  abstract Map<K, Collection<V>> KF();
  
  public Map<K, Collection<V>> Kz()
  {
    Map localMap2 = this.cjL;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = KF();
      this.cjL = localMap1;
    }
    return localMap1;
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Iterator localIterator = Kz().values().iterator();
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
      return Kz().equals(paramObject.Kz());
    }
    return false;
  }
  
  public int hashCode()
  {
    return Kz().hashCode();
  }
  
  public boolean k(@Nullable K paramK, @Nullable V paramV)
  {
    return av(paramK).add(paramV);
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = this.cjJ;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = KB();
      this.cjJ = localSet1;
    }
    return localSet1;
  }
  
  public boolean m(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)Kz().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.contains(paramObject2));
  }
  
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)Kz().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.remove(paramObject2));
  }
  
  public String toString()
  {
    return Kz().toString();
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.cjK;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new c();
      this.cjK = ((Collection)localObject);
    }
    return localObject;
  }
  
  class a
    extends l<K, V>
  {
    private a() {}
    
    final k<K, V> KO()
    {
      return d.this;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return d.this.KE();
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
    
    public final boolean contains(@Nullable Object paramObject)
    {
      return d.this.containsValue(paramObject);
    }
    
    public final Iterator<V> iterator()
    {
      return d.this.KC();
    }
    
    public final int size()
    {
      return d.this.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */