package com.eclipsesource.v8.utils;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class V8PropertyMap<V>
  implements Map<String, V>
{
  private Hashtable<String, V> map = new Hashtable();
  private Set<String> nulls = new HashSet();
  
  public void clear()
  {
    this.map.clear();
    this.nulls.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return (this.map.containsKey(paramObject)) || (this.nulls.contains(paramObject));
  }
  
  public boolean containsValue(Object paramObject)
  {
    if ((paramObject == null) && (!this.nulls.isEmpty())) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    return this.map.containsValue(paramObject);
  }
  
  public Set<Map.Entry<String, V>> entrySet()
  {
    HashSet localHashSet = new HashSet(this.map.entrySet());
    Iterator localIterator = this.nulls.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(new AbstractMap.SimpleEntry((String)localIterator.next(), null));
    }
    return localHashSet;
  }
  
  public V get(Object paramObject)
  {
    if (this.nulls.contains(paramObject)) {
      return null;
    }
    return this.map.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return (this.map.isEmpty()) && (this.nulls.isEmpty());
  }
  
  public Set<String> keySet()
  {
    HashSet localHashSet = new HashSet(this.map.keySet());
    localHashSet.addAll(this.nulls);
    return localHashSet;
  }
  
  public V put(String paramString, V paramV)
  {
    if (paramV == null)
    {
      if (this.map.containsKey(paramString)) {
        this.map.remove(paramString);
      }
      this.nulls.add(paramString);
      return null;
    }
    if (this.nulls.contains(paramString)) {
      this.nulls.remove(paramString);
    }
    return this.map.put(paramString, paramV);
  }
  
  public void putAll(Map<? extends String, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public V remove(Object paramObject)
  {
    if (this.nulls.contains(paramObject))
    {
      this.nulls.remove(paramObject);
      return null;
    }
    return this.map.remove(paramObject);
  }
  
  public int size()
  {
    return this.map.size() + this.nulls.size();
  }
  
  public Collection<V> values()
  {
    ArrayList localArrayList = new ArrayList(this.map.values());
    int i = 0;
    while (i < this.nulls.size())
    {
      localArrayList.add(null);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8PropertyMap
 * JD-Core Version:    0.7.0.1
 */