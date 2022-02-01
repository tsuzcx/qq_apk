package com.google.a;

import java.util.Map;

public class aq
  implements ap
{
  public final Object au(Object paramObject)
  {
    ((an)paramObject).bNd = false;
    return paramObject;
  }
  
  public final Object m(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (an)paramObject1;
    paramObject2 = (an)paramObject2;
    if (!paramObject1.bNd) {
      new an(paramObject1.bXW, an.c.bYc, ao.d(paramObject1.GV()));
    }
    if (paramObject1.bXT != an.c.bYc)
    {
      if (paramObject1.bXT == an.c.bYd) {
        paramObject1.bXU = paramObject1.C(paramObject1.bXV);
      }
      paramObject1.bXV = null;
      paramObject1.bXT = an.c.bYc;
    }
    paramObject1.bXU.putAll(ao.d(paramObject2.GV()));
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.aq
 * JD-Core Version:    0.7.0.1
 */