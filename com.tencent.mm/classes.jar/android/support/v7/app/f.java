package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class f
{
  private static Field PQ;
  private static boolean PR;
  private static Class PS;
  private static boolean PT;
  private static Field PU;
  private static boolean PV;
  private static Field PW;
  private static boolean PX;
  
  private static void K(Object paramObject)
  {
    if (!PT) {}
    try
    {
      PS = Class.forName("android.content.res.ThemedResourceCache");
      label14:
      PT = true;
      if (PS == null) {}
      for (;;)
      {
        return;
        if (!PV) {}
        try
        {
          Field localField = PS.getDeclaredField("mUnthemedEntries");
          PU = localField;
          localField.setAccessible(true);
          label49:
          PV = true;
          if (PU == null) {
            continue;
          }
          try
          {
            paramObject = (LongSparseArray)PU.get(paramObject);
            if (paramObject == null) {
              continue;
            }
            paramObject.clear();
            return;
          }
          catch (IllegalAccessException paramObject)
          {
            for (;;)
            {
              paramObject = null;
            }
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          break label49;
        }
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label14;
    }
  }
  
  static void a(Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 24)
      {
        d(paramResources);
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        c(paramResources);
        return;
      }
    } while (Build.VERSION.SDK_INT < 21);
    b(paramResources);
  }
  
  private static void b(Resources paramResources)
  {
    if (!PR) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      PQ = localField;
      localField.setAccessible(true);
      label23:
      PR = true;
      if (PQ != null) {}
      try
      {
        paramResources = (Map)PQ.get(paramResources);
        if (paramResources != null) {
          paramResources.clear();
        }
        return;
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          paramResources = null;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  private static void c(Resources paramResources)
  {
    if (!PR) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      PQ = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label23:
      PR = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (PQ != null) {}
      try
      {
        localObject1 = PQ.get(paramResources);
        if (localObject1 == null) {
          return;
        }
        K(localObject1);
        return;
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          localObject1 = localObject2;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  private static void d(Resources paramResources)
  {
    Object localObject2 = null;
    if (!PX) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      PW = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label25:
      PX = true;
      if (PW == null) {}
      for (;;)
      {
        return;
        try
        {
          paramResources = PW.get(paramResources);
          if (paramResources == null) {
            continue;
          }
          if (PR) {}
        }
        catch (IllegalAccessException paramResources)
        {
          try
          {
            localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
            PQ = (Field)localObject1;
            ((Field)localObject1).setAccessible(true);
            label73:
            PR = true;
            localObject1 = localObject2;
            if (PQ != null) {}
            try
            {
              localObject1 = PQ.get(paramResources);
              if (localObject1 == null) {
                continue;
              }
              K(localObject1);
              return;
              paramResources = paramResources;
              paramResources = null;
            }
            catch (IllegalAccessException paramResources)
            {
              for (;;)
              {
                localObject1 = localObject2;
              }
            }
          }
          catch (NoSuchFieldException localNoSuchFieldException1)
          {
            break label73;
          }
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      break label25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.f
 * JD-Core Version:    0.7.0.1
 */