package com.tencent.component.network.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class c
  extends HashMap
{
  public int a(Object paramObject)
  {
    paramObject = (Collection)get(paramObject);
    if (paramObject == null) {
      return 0;
    }
    return paramObject.size();
  }
  
  public boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      return false;
    }
    HashSet localHashSet2 = (HashSet)get(paramObject1);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      put(paramObject1, localHashSet1);
    }
    return localHashSet1.add(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.c
 * JD-Core Version:    0.7.0.1
 */