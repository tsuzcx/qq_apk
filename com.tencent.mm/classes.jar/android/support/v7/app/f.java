package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class f
{
  private static Field ZM;
  private static boolean ZN;
  private static Class ZO;
  private static boolean ZP;
  private static Field ZQ;
  private static boolean ZR;
  private static Field ZS;
  private static boolean ZT;
  
  private static void M(Object paramObject)
  {
    if (!ZP) {}
    try
    {
      ZO = Class.forName("android.content.res.ThemedResourceCache");
      label14:
      ZP = true;
      if (ZO == null) {}
      for (;;)
      {
        return;
        if (!ZR) {}
        try
        {
          Field localField = ZO.getDeclaredField("mUnthemedEntries");
          ZQ = localField;
          localField.setAccessible(true);
          label49:
          ZR = true;
          if (ZQ == null) {
            continue;
          }
          try
          {
            paramObject = (LongSparseArray)ZQ.get(paramObject);
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
    if (!ZN) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      ZM = localField;
      localField.setAccessible(true);
      label23:
      ZN = true;
      if (ZM != null) {}
      try
      {
        paramResources = (Map)ZM.get(paramResources);
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
    if (!ZN) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      ZM = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label23:
      ZN = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (ZM != null) {}
      try
      {
        localObject1 = ZM.get(paramResources);
        if (localObject1 == null) {
          return;
        }
        M(localObject1);
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
    if (!ZT) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      ZS = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label25:
      ZT = true;
      if (ZS == null) {}
      for (;;)
      {
        return;
        try
        {
          paramResources = ZS.get(paramResources);
          if (paramResources == null) {
            continue;
          }
          if (ZN) {}
        }
        catch (IllegalAccessException paramResources)
        {
          try
          {
            localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
            ZM = (Field)localObject1;
            ((Field)localObject1).setAccessible(true);
            label73:
            ZN = true;
            localObject1 = localObject2;
            if (ZM != null) {}
            try
            {
              localObject1 = ZM.get(paramResources);
              if (localObject1 == null) {
                continue;
              }
              M(localObject1);
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