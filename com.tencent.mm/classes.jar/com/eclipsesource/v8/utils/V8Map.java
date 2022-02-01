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
    AppMethodBeat.i(61714);
    this.map = new HashMap();
    this.twinMap = new HashMap();
    AppMethodBeat.o(61714);
  }
  
  public void clear()
  {
    AppMethodBeat.i(61724);
    this.map.clear();
    Iterator localIterator = this.twinMap.keySet().iterator();
    while (localIterator.hasNext()) {
      ((V8Value)localIterator.next()).release();
    }
    this.twinMap.clear();
    AppMethodBeat.o(61724);
  }
  
  public boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(61718);
    boolean bool = this.map.containsKey(paramObject);
    AppMethodBeat.o(61718);
    return bool;
  }
  
  public boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(61719);
    boolean bool = this.map.containsValue(paramObject);
    AppMethodBeat.o(61719);
    return bool;
  }
  
  public Set<Map.Entry<V8Value, V>> entrySet()
  {
    AppMethodBeat.i(61727);
    Set localSet = this.map.entrySet();
    AppMethodBeat.o(61727);
    return localSet;
  }
  
  public V get(Object paramObject)
  {
    AppMethodBeat.i(61720);
    paramObject = this.map.get(paramObject);
    AppMethodBeat.o(61720);
    return paramObject;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(61717);
    boolean bool = this.map.isEmpty();
    AppMethodBeat.o(61717);
    return bool;
  }
  
  public Set<V8Value> keySet()
  {
    AppMethodBeat.i(61725);
    Set localSet = this.map.keySet();
    AppMethodBeat.o(61725);
    return localSet;
  }
  
  public V put(V8Value paramV8Value, V paramV)
  {
    AppMethodBeat.i(61721);
    remove(paramV8Value);
    paramV8Value = paramV8Value.twin();
    this.twinMap.put(paramV8Value, paramV8Value);
    paramV8Value = this.map.put(paramV8Value, paramV);
    AppMethodBeat.o(61721);
    return paramV8Value;
  }
  
  public void putAll(Map<? extends V8Value, ? extends V> paramMap)
  {
    AppMethodBeat.i(61723);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put((V8Value)localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(61723);
  }
  
  public void release()
  {
    AppMethodBeat.i(61715);
    clear();
    AppMethodBeat.o(61715);
  }
  
  public V remove(Object paramObject)
  {
    AppMethodBeat.i(61722);
    Object localObject = this.map.remove(paramObject);
    paramObject = (V8Value)this.twinMap.remove(paramObject);
    if (paramObject != null) {
      paramObject.release();
    }
    AppMethodBeat.o(61722);
    return localObject;
  }
  
  public int size()
  {
    AppMethodBeat.i(61716);
    int i = this.map.size();
    AppMethodBeat.o(61716);
    return i;
  }
  
  public Collection<V> values()
  {
    AppMethodBeat.i(61726);
    Collection localCollection = this.map.values();
    AppMethodBeat.o(61726);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8Map
 * JD-Core Version:    0.7.0.1
 */