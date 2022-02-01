package com.tencent.component.network.module.common.a;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class f$a
  extends LinkedHashMap
{
  private int b = 5;
  private Object c = new Object();
  
  public f$a(f paramf, int paramInt)
  {
    super(paramInt, 0.75F, true);
    if (paramInt > 0) {
      this.b = paramInt;
    }
  }
  
  public void clear()
  {
    synchronized (this.c)
    {
      super.clear();
      return;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    synchronized (this.c)
    {
      boolean bool = super.containsKey(paramObject);
      return bool;
    }
  }
  
  public Object get(Object paramObject)
  {
    synchronized (this.c)
    {
      paramObject = super.get(paramObject);
      return paramObject;
    }
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    synchronized (this.c)
    {
      paramObject1 = super.put(paramObject1, paramObject2);
      return paramObject1;
    }
  }
  
  public void putAll(Map paramMap)
  {
    synchronized (this.c)
    {
      super.putAll(paramMap);
      return;
    }
  }
  
  public Object remove(Object paramObject)
  {
    synchronized (this.c)
    {
      paramObject = super.remove(paramObject);
      return paramObject;
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.b;
  }
  
  public int size()
  {
    synchronized (this.c)
    {
      int i = super.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.f.a
 * JD-Core Version:    0.7.0.1
 */