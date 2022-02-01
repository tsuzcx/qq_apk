package com.h.a.a.b;

import com.h.a.a.a.a;
import com.h.a.a.a.b;
import com.h.a.a.a.b.a;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
{
  static
  {
    b localb = f.eaj;
    new b.a("=", (byte)0);
  }
  
  static <V> V a(Map<?, V> paramMap, Object paramObject)
  {
    b.checkNotNull(paramMap);
    try
    {
      paramMap = paramMap.get(paramObject);
      return paramMap;
    }
    catch (ClassCastException paramMap)
    {
      return null;
    }
    catch (NullPointerException paramMap) {}
    return null;
  }
  
  public static <K, V> HashMap<K, V> akS()
  {
    return new HashMap();
  }
  
  static <K, V> Iterator<K> b(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return h.a(paramIterator, a.ean);
  }
  
  static boolean b(Map<?, ?> paramMap, Object paramObject)
  {
    b.checkNotNull(paramMap);
    try
    {
      boolean bool = paramMap.containsKey(paramObject);
      return bool;
    }
    catch (ClassCastException paramMap)
    {
      return false;
    }
    catch (NullPointerException paramMap) {}
    return false;
  }
  
  static <V> V c(Map<?, V> paramMap, Object paramObject)
  {
    b.checkNotNull(paramMap);
    try
    {
      paramMap = paramMap.remove(paramObject);
      return paramMap;
    }
    catch (ClassCastException paramMap)
    {
      return null;
    }
    catch (NullPointerException paramMap) {}
    return null;
  }
  
  static <K, V> Iterator<V> c(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return h.a(paramIterator, a.eao);
  }
  
  public static int lN(int paramInt)
  {
    if (paramInt < 3)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("expectedSize" + " cannot be negative but was: " + paramInt);
      }
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return paramInt / 3 + paramInt;
    }
    return 2147483647;
  }
  
  public static <K, V> Map.Entry<K, V> y(K paramK, V paramV)
  {
    return new g(paramK, paramV);
  }
  
  static abstract enum a
    implements a<Map.Entry<?, ?>, Object>
  {
    static
    {
      a locala = ean;
      locala = eao;
    }
    
    private a() {}
  }
  
  static abstract class b<K, V>
    extends o<Map.Entry<K, V>>
  {
    abstract Map<K, V> akI();
    
    public void clear()
    {
      akI().clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        Object localObject1 = paramObject.getKey();
        Object localObject2 = j.a(akI(), localObject1);
        bool1 = bool2;
        if (b.equal(localObject2, paramObject.getValue())) {
          if (localObject2 == null)
          {
            bool1 = bool2;
            if (!akI().containsKey(localObject1)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public boolean isEmpty()
    {
      return akI().isEmpty();
    }
    
    public boolean remove(Object paramObject)
    {
      if (contains(paramObject))
      {
        paramObject = (Map.Entry)paramObject;
        return akI().keySet().remove(paramObject.getKey());
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.removeAll((Collection)b.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException) {}
      return b.a(this, paramCollection.iterator());
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.retainAll((Collection)b.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = new HashSet(j.lN(paramCollection.size()));
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          Object localObject = paramCollection.next();
          if (contains(localObject)) {
            localHashSet.add(((Map.Entry)localObject).getKey());
          }
        }
        return akI().keySet().retainAll(localHashSet);
      }
    }
    
    public int size()
    {
      return akI().size();
    }
  }
  
  static abstract class c<K, V>
    extends AbstractMap<K, V>
  {
    private transient Collection<V> atb;
    private transient Set<K> eaf;
    private transient Set<Map.Entry<K, V>> eap;
    
    Set<K> akC()
    {
      return new j.d(this);
    }
    
    abstract Set<Map.Entry<K, V>> akH();
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet2 = this.eap;
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = akH();
        this.eap = localSet1;
      }
      return localSet1;
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
    
    public Collection<V> values()
    {
      Collection localCollection = this.atb;
      Object localObject = localCollection;
      if (localCollection == null)
      {
        localObject = new j.e(this);
        this.atb = ((Collection)localObject);
      }
      return localObject;
    }
  }
  
  static class d<K, V>
    extends o<K>
  {
    final Map<K, V> map;
    
    d(Map<K, V> paramMap)
    {
      this.map = ((Map)b.checkNotNull(paramMap));
    }
    
    public void clear()
    {
      this.map.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    public boolean isEmpty()
    {
      return this.map.isEmpty();
    }
    
    public Iterator<K> iterator()
    {
      return j.b(this.map.entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      if (contains(paramObject))
      {
        this.map.remove(paramObject);
        return true;
      }
      return false;
    }
    
    public int size()
    {
      return this.map.size();
    }
  }
  
  static final class e<K, V>
    extends AbstractCollection<V>
  {
    private Map<K, V> map;
    
    e(Map<K, V> paramMap)
    {
      this.map = ((Map)b.checkNotNull(paramMap));
    }
    
    public final void clear()
    {
      this.map.clear();
    }
    
    public final boolean contains(Object paramObject)
    {
      return this.map.containsValue(paramObject);
    }
    
    public final boolean isEmpty()
    {
      return this.map.isEmpty();
    }
    
    public final Iterator<V> iterator()
    {
      return j.c(this.map.entrySet().iterator());
    }
    
    public final boolean remove(Object paramObject)
    {
      try
      {
        boolean bool = super.remove(paramObject);
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Iterator localIterator = this.map.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (b.equal(paramObject, localEntry.getValue()))
          {
            this.map.remove(localEntry.getKey());
            return true;
          }
        }
      }
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.removeAll((Collection)b.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = this.map.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (paramCollection.contains(localEntry.getValue())) {
            localHashSet.add(localEntry.getKey());
          }
        }
        return this.map.keySet().removeAll(localHashSet);
      }
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.retainAll((Collection)b.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = this.map.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (paramCollection.contains(localEntry.getValue())) {
            localHashSet.add(localEntry.getKey());
          }
        }
        return this.map.keySet().retainAll(localHashSet);
      }
    }
    
    public final int size()
    {
      return this.map.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.a.b.j
 * JD-Core Version:    0.7.0.1
 */