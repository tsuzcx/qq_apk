package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class f
{
  private static Field WP;
  private static boolean WQ;
  private static Class WR;
  private static boolean WS;
  private static Field WT;
  private static boolean WU;
  private static Field WV;
  private static boolean WW;
  
  private static void J(Object paramObject)
  {
    if (!WS) {}
    try
    {
      WR = Class.forName("android.content.res.ThemedResourceCache");
      label14:
      WS = true;
      if (WR == null) {}
      for (;;)
      {
        return;
        if (!WU) {}
        try
        {
          Field localField = WR.getDeclaredField("mUnthemedEntries");
          WT = localField;
          localField.setAccessible(true);
          label49:
          WU = true;
          if (WT == null) {
            continue;
          }
          try
          {
            paramObject = (LongSparseArray)WT.get(paramObject);
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
    if (!WQ) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      WP = localField;
      localField.setAccessible(true);
      label23:
      WQ = true;
      if (WP != null) {}
      try
      {
        paramResources = (Map)WP.get(paramResources);
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
    if (!WQ) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      WP = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label23:
      WQ = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (WP != null) {}
      try
      {
        localObject1 = WP.get(paramResources);
        if (localObject1 == null) {
          return;
        }
        J(localObject1);
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
    if (!WW) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      WV = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label25:
      WW = true;
      if (WV == null) {}
      for (;;)
      {
        return;
        try
        {
          paramResources = WV.get(paramResources);
          if (paramResources == null) {
            continue;
          }
          if (WQ) {}
        }
        catch (IllegalAccessException paramResources)
        {
          try
          {
            localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
            WP = (Field)localObject1;
            ((Field)localObject1).setAccessible(true);
            label73:
            WQ = true;
            localObject1 = localObject2;
            if (WP != null) {}
            try
            {
              localObject1 = WP.get(paramResources);
              if (localObject1 == null) {
                continue;
              }
              J(localObject1);
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