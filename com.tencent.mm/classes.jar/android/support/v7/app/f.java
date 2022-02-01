package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class f
{
  private static Field XK;
  private static boolean XL;
  private static Class XM;
  private static boolean XN;
  private static Field XO;
  private static boolean XP;
  private static Field XQ;
  private static boolean XR;
  
  private static void L(Object paramObject)
  {
    if (!XN) {}
    try
    {
      XM = Class.forName("android.content.res.ThemedResourceCache");
      label14:
      XN = true;
      if (XM == null) {}
      for (;;)
      {
        return;
        if (!XP) {}
        try
        {
          Field localField = XM.getDeclaredField("mUnthemedEntries");
          XO = localField;
          localField.setAccessible(true);
          label49:
          XP = true;
          if (XO == null) {
            continue;
          }
          try
          {
            paramObject = (LongSparseArray)XO.get(paramObject);
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
    if (!XL) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      XK = localField;
      localField.setAccessible(true);
      label23:
      XL = true;
      if (XK != null) {}
      try
      {
        paramResources = (Map)XK.get(paramResources);
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
    if (!XL) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      XK = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label23:
      XL = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (XK != null) {}
      try
      {
        localObject1 = XK.get(paramResources);
        if (localObject1 == null) {
          return;
        }
        L(localObject1);
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
    if (!XR) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      XQ = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label25:
      XR = true;
      if (XQ == null) {}
      for (;;)
      {
        return;
        try
        {
          paramResources = XQ.get(paramResources);
          if (paramResources == null) {
            continue;
          }
          if (XL) {}
        }
        catch (IllegalAccessException paramResources)
        {
          try
          {
            localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
            XK = (Field)localObject1;
            ((Field)localObject1).setAccessible(true);
            label73:
            XL = true;
            localObject1 = localObject2;
            if (XK != null) {}
            try
            {
              localObject1 = XK.get(paramResources);
              if (localObject1 == null) {
                continue;
              }
              L(localObject1);
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