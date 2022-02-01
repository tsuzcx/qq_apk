package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class f
{
  private static boolean ZA;
  private static Class ZB;
  private static boolean ZC;
  private static Field ZD;
  private static boolean ZE;
  private static Field ZF;
  private static boolean ZG;
  private static Field Zz;
  
  private static void M(Object paramObject)
  {
    if (!ZC) {}
    try
    {
      ZB = Class.forName("android.content.res.ThemedResourceCache");
      label14:
      ZC = true;
      if (ZB == null) {}
      for (;;)
      {
        return;
        if (!ZE) {}
        try
        {
          Field localField = ZB.getDeclaredField("mUnthemedEntries");
          ZD = localField;
          localField.setAccessible(true);
          label49:
          ZE = true;
          if (ZD == null) {
            continue;
          }
          try
          {
            paramObject = (LongSparseArray)ZD.get(paramObject);
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
    if (!ZA) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      Zz = localField;
      localField.setAccessible(true);
      label23:
      ZA = true;
      if (Zz != null) {}
      try
      {
        paramResources = (Map)Zz.get(paramResources);
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
    if (!ZA) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      Zz = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label23:
      ZA = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (Zz != null) {}
      try
      {
        localObject1 = Zz.get(paramResources);
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
    if (!ZG) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      ZF = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label25:
      ZG = true;
      if (ZF == null) {}
      for (;;)
      {
        return;
        try
        {
          paramResources = ZF.get(paramResources);
          if (paramResources == null) {
            continue;
          }
          if (ZA) {}
        }
        catch (IllegalAccessException paramResources)
        {
          try
          {
            localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
            Zz = (Field)localObject1;
            ((Field)localObject1).setAccessible(true);
            label73:
            ZA = true;
            localObject1 = localObject2;
            if (Zz != null) {}
            try
            {
              localObject1 = Zz.get(paramResources);
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