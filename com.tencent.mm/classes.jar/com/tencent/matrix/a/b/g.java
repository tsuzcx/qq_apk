package com.tencent.matrix.a.b;

import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  private static boolean eTs;
  private static n.b eTt = new n.b()
  {
    public final Object a(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      long l1;
      float f1;
      long l2;
      float f2;
      int i;
      if ("requestLocationUpdates".equals(paramAnonymousMethod.getName()))
      {
        l1 = -1L;
        f1 = -1.0F;
        l2 = l1;
        f2 = f1;
        if (paramAnonymousArrayOfObject != null)
        {
          int j = paramAnonymousArrayOfObject.length;
          i = 0;
          l2 = l1;
          f2 = f1;
          if (i < j)
          {
            paramAnonymousMethod = paramAnonymousArrayOfObject[i];
            if ((paramAnonymousMethod == null) || (!"android.location.LocationRequest".equals(paramAnonymousMethod.getClass().getName()))) {
              break label218;
            }
            l2 = l1;
          }
        }
      }
      label218:
      for (;;)
      {
        try
        {
          Method localMethod = paramAnonymousMethod.getClass().getDeclaredMethod("getFastestInterval", new Class[0]);
          l2 = l1;
          localMethod.setAccessible(true);
          l2 = l1;
          l1 = ((Long)localMethod.invoke(paramAnonymousMethod, new Object[0])).longValue();
          l2 = l1;
          localMethod = paramAnonymousMethod.getClass().getDeclaredMethod("getSmallestDisplacement", new Class[0]);
          l2 = l1;
          localMethod.setAccessible(true);
          l2 = l1;
          f2 = ((Float)localMethod.invoke(paramAnonymousMethod, new Object[0])).floatValue();
          f1 = f2;
        }
        finally
        {
          l1 = l2;
          c.printErrStackTrace("Matrix.battery.LocationHooker", paramAnonymousMethod, "", new Object[0]);
          continue;
        }
        i += 1;
        break;
        g.k(l2, f2);
        return;
      }
    }
  };
  private static n eTu = new n("location", "android.location.ILocationManager", eTt);
  private static List<a> eTv = new ArrayList();
  
  public static void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        if (eTv.contains(parama)) {
          continue;
        }
        eTv.add(parama);
        if ((eTs) || (eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.LocationHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(eTu.doHook()) });
        eTs = true;
      }
      finally {}
    }
  }
  
  public static void b(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        eTv.remove(parama);
        if ((!eTs) || (!eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.LocationHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(eTu.doUnHook()) });
        eTs = false;
      }
      finally {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void j(long paramLong, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.g
 * JD-Core Version:    0.7.0.1
 */