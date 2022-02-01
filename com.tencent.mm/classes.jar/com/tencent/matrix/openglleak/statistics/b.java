package com.tencent.matrix.openglleak.statistics;

import android.os.Build.VERSION;
import com.tencent.matrix.openglleak.statistics.resource.c;
import com.tencent.matrix.openglleak.statistics.resource.c.a;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final b eXh = new b();
  final Map<Long, Map<Integer, c>> eXi = new HashMap();
  final Map<Long, Map<Integer, c>> eXj = new HashMap();
  final Map<Long, c> eXk = new HashMap();
  
  static c a(Map<Long, Map<Integer, c>> paramMap, long paramLong, int paramInt)
  {
    try
    {
      Map localMap = (Map)paramMap.get(Long.valueOf(paramLong));
      Object localObject1 = localMap;
      if (localMap == null)
      {
        localObject1 = new HashMap();
        paramMap.put(Long.valueOf(paramLong), localObject1);
      }
      localObject1 = (c)((Map)localObject1).get(Integer.valueOf(paramInt));
      return localObject1;
    }
    finally {}
  }
  
  static b ayN()
  {
    return eXh;
  }
  
  static boolean nm(int paramInt)
  {
    return (paramInt == 3553) || (paramInt == 32879) || (paramInt == 35866) || (paramInt == 34067);
  }
  
  static boolean nn(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    int i;
    if ((paramInt == 34962) || (paramInt == 36662) || (paramInt == 36663) || (paramInt == 34963) || (paramInt == 35051) || (paramInt == 35052) || (paramInt == 35982) || (paramInt == 35345))
    {
      bool1 = true;
      if (Build.VERSION.SDK_INT < 21) {
        return bool1;
      }
      if ((paramInt != 37568) && (paramInt != 37102) && (paramInt != 36671) && (paramInt != 37074)) {
        break label125;
      }
      i = 1;
      label86:
      if (Build.VERSION.SDK_INT < 24) {
        break label135;
      }
      if (paramInt != 35882) {
        break label130;
      }
      paramInt = 1;
      label102:
      if ((!bool1) && (i == 0))
      {
        bool1 = bool2;
        if (paramInt == 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    label125:
    do
    {
      return bool1;
      bool1 = false;
      break;
      i = 0;
      break label86;
      paramInt = 0;
      break label102;
      if (bool1) {
        break label145;
      }
      bool1 = bool2;
    } while (i == 0);
    label130:
    label135:
    label145:
    return true;
    return bool1;
  }
  
  static boolean no(int paramInt)
  {
    return paramInt == 36161;
  }
  
  static boolean np(int paramInt)
  {
    return (paramInt == 34069) || (paramInt == 34070) || (paramInt == 34071) || (paramInt == 34072) || (paramInt == 34073) || (paramInt == 34074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.b
 * JD-Core Version:    0.7.0.1
 */