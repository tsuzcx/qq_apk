package com.google.d;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class by
  implements bx
{
  public final Map<?, ?> bB(Object paramObject)
  {
    return ((bv)paramObject).aiH();
  }
  
  public final Map<?, ?> bC(Object paramObject)
  {
    return ((bv)paramObject).aiG();
  }
  
  public final boolean bD(Object paramObject)
  {
    return !((bv)paramObject).dIE;
  }
  
  public final Object bE(Object paramObject)
  {
    ((bv)paramObject).dIE = false;
    return paramObject;
  }
  
  public final Object bF(Object paramObject)
  {
    return bv.d((bt)paramObject);
  }
  
  public final bu.a<?, ?> bG(Object paramObject)
  {
    return ((bt)paramObject).dTv;
  }
  
  public final int f(int paramInt, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {}
    Object localObject;
    do
    {
      return 0;
      localObject = ((bv)paramObject1).aiG();
      paramObject1 = (bt)paramObject2;
    } while (((Map)localObject).isEmpty());
    paramObject2 = ((Map)localObject).entrySet().iterator();
    int j;
    for (int i = 0; paramObject2.hasNext(); i = k.kt(bu.a(paramObject1.dTv, ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue())) + j + i)
    {
      localObject = (Map.Entry)paramObject2.next();
      j = k.ko(paramInt);
    }
    return i;
  }
  
  public final Object s(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (bv)paramObject1;
    paramObject2 = (bv)paramObject2;
    if (!paramObject1.dIE) {
      paramObject1.aiI();
    }
    paramObject1.a(paramObject2);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.by
 * JD-Core Version:    0.7.0.1
 */