package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V8Map<V>
  implements Releasable, Map<V8Value, V>
{
  private Map<V8Value, V> map;
  private Map<V8Value, V8Value> twinMap;
  
  public V8Map()
  {
    AppMethodBeat.i(75090);
    this.map = new HashMap();
    this.twinMap = new HashMap();
    AppMethodBeat.o(75090);
  }
  
  public void clear()
  {
    AppMethodBeat.i(75100);
    this.map.clear();
    Iterator localIterator = this.twinMap.keySet().iterator();
    while (localIterator.hasNext()) {
      ((V8Value)localIterator.next()).release();
    }
    this.twinMap.clear();
    AppMethodBeat.o(75100);
  }
  
  public boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(75094);
    boolean bool = this.map.containsKey(paramObject);
    AppMethodBeat.o(75094);
    return bool;
  }
  
  public boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(75095);
    boolean bool = this.map.containsValue(paramObject);
    AppMethodBeat.o(75095);
    return bool;
  }
  
  public Set<Map.Entry<V8Value, V>> entrySet()
  {
    AppMethodBeat.i(75103);
    Set localSet = this.map.entrySet();
    AppMethodBeat.o(75103);
    return localSet;
  }
  
  public V get(Object paramObject)
  {
    AppMethodBeat.i(75096);
    paramObject = this.map.get(paramObject);
    AppMethodBeat.o(75096);
    return paramObject;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(75093);
    boolean bool = this.map.isEmpty();
    AppMethodBeat.o(75093);
    return bool;
  }
  
  public Set<V8Value> keySet()
  {
    AppMethodBeat.i(75101);
    Set localSet = this.map.keySet();
    AppMethodBeat.o(75101);
    return localSet;
  }
  
  public V put(V8Value paramV8Value, V paramV)
  {
    AppMethodBeat.i(75097);
    remove(paramV8Value);
    paramV8Value = paramV8Value.twin();
    this.twinMap.put(paramV8Value, paramV8Value);
    paramV8Value = this.map.put(paramV8Value, paramV);
    AppMethodBeat.o(75097);
    return paramV8Value;
  }
  
  public void putAll(Map<? extends V8Value, ? extends V> paramMap)
  {
    AppMethodBeat.i(75099);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put((V8Value)localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(75099);
  }
  
  public void release()
  {
    AppMethodBeat.i(75091);
    clear();
    AppMethodBeat.o(75091);
  }
  
  public V remove(Object paramObject)
  {
    AppMethodBeat.i(75098);
    Object localObject = this.map.remove(paramObject);
    paramObject = (V8Value)this.twinMap.remove(paramObject);
    if (paramObject != null) {
      paramObject.release();
    }
    AppMethodBeat.o(75098);
    return localObject;
  }
  
  public int size()
  {
    AppMethodBeat.i(75092);
    int i = this.map.size();
    AppMethodBeat.o(75092);
    return i;
  }
  
  public Collection<V> values()
  {
    AppMethodBeat.i(75102);
    Collection localCollection = this.map.values();
    AppMethodBeat.o(75102);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8Map
 * JD-Core Version:    0.7.0.1
 */