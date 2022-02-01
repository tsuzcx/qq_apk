package com.eclipsesource.mmv8.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private Hashtable<String, V> map;
  private Set<String> nulls;
  
  V8PropertyMap()
  {
    AppMethodBeat.i(61769);
    this.map = new Hashtable();
    this.nulls = new HashSet();
    AppMethodBeat.o(61769);
  }
  
  public void clear()
  {
    AppMethodBeat.i(61778);
    this.map.clear();
    this.nulls.clear();
    AppMethodBeat.o(61778);
  }
  
  public boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(61772);
    if ((this.map.containsKey(paramObject)) || (this.nulls.contains(paramObject)))
    {
      AppMethodBeat.o(61772);
      return true;
    }
    AppMethodBeat.o(61772);
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(61773);
    if ((paramObject == null) && (!this.nulls.isEmpty()))
    {
      AppMethodBeat.o(61773);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(61773);
      return false;
    }
    boolean bool = this.map.containsValue(paramObject);
    AppMethodBeat.o(61773);
    return bool;
  }
  
  public Set<Map.Entry<String, V>> entrySet()
  {
    AppMethodBeat.i(61781);
    HashSet localHashSet = new HashSet(this.map.entrySet());
    Iterator localIterator = this.nulls.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(new AbstractMap.SimpleEntry((String)localIterator.next(), null));
    }
    AppMethodBeat.o(61781);
    return localHashSet;
  }
  
  public V get(Object paramObject)
  {
    AppMethodBeat.i(61774);
    if (this.nulls.contains(paramObject))
    {
      AppMethodBeat.o(61774);
      return null;
    }
    paramObject = this.map.get(paramObject);
    AppMethodBeat.o(61774);
    return paramObject;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(61771);
    if ((this.map.isEmpty()) && (this.nulls.isEmpty()))
    {
      AppMethodBeat.o(61771);
      return true;
    }
    AppMethodBeat.o(61771);
    return false;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(61779);
    HashSet localHashSet = new HashSet(this.map.keySet());
    localHashSet.addAll(this.nulls);
    AppMethodBeat.o(61779);
    return localHashSet;
  }
  
  public V put(String paramString, V paramV)
  {
    AppMethodBeat.i(61775);
    if (paramV == null)
    {
      if (this.map.containsKey(paramString)) {
        this.map.remove(paramString);
      }
      this.nulls.add(paramString);
      AppMethodBeat.o(61775);
      return null;
    }
    if (this.nulls.contains(paramString)) {
      this.nulls.remove(paramString);
    }
    paramString = this.map.put(paramString, paramV);
    AppMethodBeat.o(61775);
    return paramString;
  }
  
  public void putAll(Map<? extends String, ? extends V> paramMap)
  {
    AppMethodBeat.i(61777);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put((String)localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(61777);
  }
  
  public V remove(Object paramObject)
  {
    AppMethodBeat.i(61776);
    if (this.nulls.contains(paramObject))
    {
      this.nulls.remove(paramObject);
      AppMethodBeat.o(61776);
      return null;
    }
    paramObject = this.map.remove(paramObject);
    AppMethodBeat.o(61776);
    return paramObject;
  }
  
  public int size()
  {
    AppMethodBeat.i(61770);
    int i = this.map.size();
    int j = this.nulls.size();
    AppMethodBeat.o(61770);
    return i + j;
  }
  
  public Collection<V> values()
  {
    AppMethodBeat.i(61780);
    ArrayList localArrayList = new ArrayList(this.map.values());
    int i = 0;
    while (i < this.nulls.size())
    {
      localArrayList.add(null);
      i += 1;
    }
    AppMethodBeat.o(61780);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.V8PropertyMap
 * JD-Core Version:    0.7.0.1
 */