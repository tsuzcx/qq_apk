package com.google.d;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class bz
  implements bx
{
  public final Map<?, ?> bB(Object paramObject)
  {
    return (bw)paramObject;
  }
  
  public final Map<?, ?> bC(Object paramObject)
  {
    return (bw)paramObject;
  }
  
  public final boolean bD(Object paramObject)
  {
    return !((bw)paramObject).dIE;
  }
  
  public final Object bE(Object paramObject)
  {
    ((bw)paramObject).dIE = false;
    return paramObject;
  }
  
  public final Object bF(Object paramObject)
  {
    return bw.aiN().aiO();
  }
  
  public final bu.a<?, ?> bG(Object paramObject)
  {
    throw null;
  }
  
  public final int f(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (bw)paramObject1;
    if (paramObject1.isEmpty()) {}
    do
    {
      return 0;
      paramObject1 = paramObject1.entrySet().iterator();
    } while (!paramObject1.hasNext());
    paramObject1 = (Map.Entry)paramObject1.next();
    paramObject1.getKey();
    paramObject1.getValue();
    k.ko(paramInt);
    throw null;
  }
  
  public final Object s(Object paramObject1, Object paramObject2)
  {
    bw localbw1 = (bw)paramObject1;
    bw localbw2 = (bw)paramObject2;
    paramObject2 = localbw1;
    if (!localbw2.isEmpty())
    {
      paramObject1 = localbw1;
      if (!localbw1.dIE) {
        paramObject1 = localbw1.aiO();
      }
      paramObject1.aiL();
      paramObject2 = paramObject1;
      if (!localbw2.isEmpty())
      {
        paramObject1.putAll(localbw2);
        paramObject2 = paramObject1;
      }
    }
    return paramObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bz
 * JD-Core Version:    0.7.0.1
 */