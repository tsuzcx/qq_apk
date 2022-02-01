package com.tencent.matrix.openglleak.statistics;

import com.tencent.matrix.openglleak.statistics.resource.c.a;
import java.util.Map;

public final class a
{
  private static final a eXg = new a();
  
  public static com.tencent.matrix.openglleak.statistics.resource.c a(c.a parama, long paramLong, int paramInt)
  {
    b localb = b.ayN();
    switch (b.2.eLU[parama.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return b.a(localb.eXj, paramLong, paramInt);
    case 2: 
      int i = paramInt;
      if (b.np(paramInt)) {
        i = 34067;
      }
      return b.a(localb.eXi, paramLong, i);
    }
    return (com.tencent.matrix.openglleak.statistics.resource.c)localb.eXk.get(Long.valueOf(paramLong));
  }
  
  public static void a(c.a parama, int paramInt, long paramLong, com.tencent.matrix.openglleak.statistics.resource.c paramc)
  {
    b localb = b.ayN();
    boolean bool;
    if (parama == c.a.eXN) {
      bool = b.nm(paramInt);
    }
    for (;;)
    {
      if (bool) {
        com.tencent.matrix.openglleak.a.c.ayU().post(new b.1(localb, parama, paramInt, paramLong, paramc));
      }
      return;
      if (parama == c.a.eXO) {
        bool = b.nn(paramInt);
      } else if (parama == c.a.eXQ) {
        bool = b.no(paramInt);
      } else {
        bool = false;
      }
    }
  }
  
  public static a ayM()
  {
    return eXg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.a
 * JD-Core Version:    0.7.0.1
 */