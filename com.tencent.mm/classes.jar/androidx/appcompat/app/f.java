package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Map;

final class f
{
  private static Field hl;
  private static boolean hm;
  private static Class hn;
  private static boolean ho;
  private static Field hp;
  private static boolean hq;
  private static Field hr;
  private static boolean hs;
  
  static void a(Resources paramResources)
  {
    AppMethodBeat.i(238415);
    if (Build.VERSION.SDK_INT >= 28)
    {
      AppMethodBeat.o(238415);
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      d(paramResources);
      AppMethodBeat.o(238415);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      c(paramResources);
      AppMethodBeat.o(238415);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      b(paramResources);
    }
    AppMethodBeat.o(238415);
  }
  
  private static void b(Resources paramResources)
  {
    AppMethodBeat.i(238416);
    if (!hm) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      hl = localField;
      localField.setAccessible(true);
      label28:
      hm = true;
      if (hl != null) {}
      try
      {
        paramResources = (Map)hl.get(paramResources);
        if (paramResources != null) {
          paramResources.clear();
        }
        AppMethodBeat.o(238416);
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
      break label28;
    }
  }
  
  private static void c(Resources paramResources)
  {
    AppMethodBeat.i(238417);
    if (!hm) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      hl = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label28:
      hm = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (hl != null) {}
      try
      {
        localObject1 = hl.get(paramResources);
        if (localObject1 == null)
        {
          AppMethodBeat.o(238417);
          return;
        }
        l(localObject1);
        AppMethodBeat.o(238417);
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
      break label28;
    }
  }
  
  private static void d(Resources paramResources)
  {
    Object localObject2 = null;
    AppMethodBeat.i(238418);
    if (!hs) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      hr = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label30:
      hs = true;
      if (hr == null)
      {
        AppMethodBeat.o(238418);
        return;
      }
      try
      {
        paramResources = hr.get(paramResources);
        if (paramResources == null)
        {
          AppMethodBeat.o(238418);
          return;
        }
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          paramResources = null;
        }
        if (!hm) {}
        try
        {
          localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
          hl = (Field)localObject1;
          ((Field)localObject1).setAccessible(true);
          label95:
          hm = true;
          localObject1 = localObject2;
          if (hl != null) {}
          try
          {
            localObject1 = hl.get(paramResources);
            if (localObject1 != null) {
              l(localObject1);
            }
            AppMethodBeat.o(238418);
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
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          break label95;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      break label30;
    }
  }
  
  private static void l(Object paramObject)
  {
    AppMethodBeat.i(238420);
    if (!ho) {}
    try
    {
      hn = Class.forName("android.content.res.ThemedResourceCache");
      label19:
      ho = true;
      if (hn == null)
      {
        AppMethodBeat.o(238420);
        return;
      }
      if (!hq) {}
      try
      {
        Field localField = hn.getDeclaredField("mUnthemedEntries");
        hp = localField;
        localField.setAccessible(true);
        label59:
        hq = true;
        if (hp == null)
        {
          AppMethodBeat.o(238420);
          return;
        }
        try
        {
          paramObject = (LongSparseArray)hp.get(paramObject);
          if (paramObject != null) {
            paramObject.clear();
          }
          AppMethodBeat.o(238420);
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
        break label59;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.appcompat.app.f
 * JD-Core Version:    0.7.0.1
 */