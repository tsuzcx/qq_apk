package com.c.a.a.b;

import com.c.a.a.a.a;
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
  private transient Collection<Map.Entry<K, V>> coh;
  private transient Set<K> coi;
  private transient Collection<V> coj;
  private transient Map<K, Collection<V>> cok;
  
  public Map<K, Collection<V>> JF()
  {
    Map localMap2 = this.cok;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = JL();
      this.cok = localMap1;
    }
    return localMap1;
  }
  
  Set<K> JH()
  {
    return new j.d(JF());
  }
  
  Iterator<V> JI()
  {
    return j.c(JJ().iterator());
  }
  
  public Collection<Map.Entry<K, V>> JJ()
  {
    Collection localCollection = this.coh;
    Object localObject = localCollection;
    if (localCollection == null) {
      if (!(this instanceof n)) {
        break label35;
      }
    }
    label35:
    for (localObject = new b((byte)0);; localObject = new a((byte)0))
    {
      this.coh = ((Collection)localObject);
      return localObject;
    }
  }
  
  abstract Iterator<Map.Entry<K, V>> JK();
  
  abstract Map<K, Collection<V>> JL();
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Iterator localIterator = JF().values().iterator();
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
      return JF().equals(paramObject.JF());
    }
    return false;
  }
  
  public int hashCode()
  {
    return JF().hashCode();
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = this.coi;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = JH();
      this.coi = localSet1;
    }
    return localSet1;
  }
  
  public boolean r(@Nullable K paramK, @Nullable V paramV)
  {
    return az(paramK).add(paramV);
  }
  
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)JF().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.remove(paramObject2));
  }
  
  public boolean t(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)JF().get(paramObject1);
    return (paramObject1 != null) && (paramObject1.contains(paramObject2));
  }
  
  public String toString()
  {
    return JF().toString();
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.coj;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new c();
      this.coj = ((Collection)localObject);
    }
    return localObject;
  }
  
  class a
    extends l<K, V>
  {
    private a() {}
    
    final k<K, V> JU()
    {
      return d.this;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return d.this.JK();
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
      return d.this.JI();
    }
    
    public final int size()
    {
      return d.this.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */