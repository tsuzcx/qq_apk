package android.support.v7.app;

import android.content.res.Resources;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class k
{
  private static Field Qi;
  private static boolean Qj;
  private static Class Qk;
  private static boolean Ql;
  private static Field Qm;
  private static boolean Qn;
  private static Field Qo;
  private static boolean Qp;
  
  private static boolean K(Object paramObject)
  {
    if (!Ql) {}
    try
    {
      Qk = Class.forName("android.content.res.ThemedResourceCache");
      label14:
      Ql = true;
      if (Qk == null) {
        return false;
      }
      if (!Qn) {}
      try
      {
        Field localField = Qk.getDeclaredField("mUnthemedEntries");
        Qm = localField;
        localField.setAccessible(true);
        label50:
        Qn = true;
        if (Qm == null) {
          return false;
        }
        try
        {
          paramObject = (LongSparseArray)Qm.get(paramObject);
          if (paramObject != null)
          {
            paramObject.clear();
            return true;
          }
        }
        catch (IllegalAccessException paramObject)
        {
          for (;;)
          {
            paramObject = null;
          }
        }
        return false;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label50;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label14;
    }
  }
  
  static boolean a(Resources paramResources)
  {
    if (!Qj) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      Qi = localField;
      localField.setAccessible(true);
      label23:
      Qj = true;
      if (Qi != null) {
        try
        {
          paramResources = (Map)Qi.get(paramResources);
          if (paramResources != null)
          {
            paramResources.clear();
            return true;
          }
        }
        catch (IllegalAccessException paramResources)
        {
          for (;;)
          {
            paramResources = null;
          }
        }
      }
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  static boolean b(Resources paramResources)
  {
    if (!Qj) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      Qi = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label23:
      Qj = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (Qi != null) {}
      try
      {
        localObject1 = Qi.get(paramResources);
        if (localObject1 == null) {}
        while ((localObject1 == null) || (!K(localObject1))) {
          return false;
        }
        return true;
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
  
  static boolean c(Resources paramResources)
  {
    Object localObject2 = null;
    if (!Qp) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      Qo = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label25:
      Qp = true;
      if (Qo == null) {}
      for (;;)
      {
        return false;
        try
        {
          paramResources = Qo.get(paramResources);
          if (paramResources == null) {
            continue;
          }
          if (Qj) {}
        }
        catch (IllegalAccessException paramResources)
        {
          try
          {
            localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
            Qi = (Field)localObject1;
            ((Field)localObject1).setAccessible(true);
            label74:
            Qj = true;
            localObject1 = localObject2;
            if (Qi != null) {}
            try
            {
              localObject1 = Qi.get(paramResources);
              if ((localObject1 == null) || (!K(localObject1))) {
                continue;
              }
              return true;
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
            break label74;
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
 * Qualified Name:     android.support.v7.app.k
 * JD-Core Version:    0.7.0.1
 */