package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Map;

final class f
{
  private static Field ih;
  private static boolean ii;
  private static Class ij;
  private static boolean ik;
  private static Field il;
  private static boolean im;
  private static Field in;
  private static boolean io;
  
  static void a(Resources paramResources)
  {
    AppMethodBeat.i(200480);
    if (Build.VERSION.SDK_INT >= 28)
    {
      AppMethodBeat.o(200480);
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      d(paramResources);
      AppMethodBeat.o(200480);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      c(paramResources);
      AppMethodBeat.o(200480);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      b(paramResources);
    }
    AppMethodBeat.o(200480);
  }
  
  private static void b(Resources paramResources)
  {
    AppMethodBeat.i(200493);
    if (!ii) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      ih = localField;
      localField.setAccessible(true);
      label28:
      ii = true;
      if (ih != null) {}
      try
      {
        paramResources = (Map)ih.get(paramResources);
        if (paramResources != null) {
          paramResources.clear();
        }
        AppMethodBeat.o(200493);
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
    AppMethodBeat.i(200501);
    if (!ii) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      ih = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label28:
      ii = true;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (ih != null) {}
      try
      {
        localObject1 = ih.get(paramResources);
        if (localObject1 == null)
        {
          AppMethodBeat.o(200501);
          return;
        }
        o(localObject1);
        AppMethodBeat.o(200501);
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
    AppMethodBeat.i(200510);
    if (!io) {}
    try
    {
      Object localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      in = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      label30:
      io = true;
      if (in == null)
      {
        AppMethodBeat.o(200510);
        return;
      }
      try
      {
        paramResources = in.get(paramResources);
        if (paramResources == null)
        {
          AppMethodBeat.o(200510);
          return;
        }
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          paramResources = null;
        }
        if (!ii) {}
        try
        {
          localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
          ih = (Field)localObject1;
          ((Field)localObject1).setAccessible(true);
          label95:
          ii = true;
          localObject1 = localObject2;
          if (ih != null) {}
          try
          {
            localObject1 = ih.get(paramResources);
            if (localObject1 != null) {
              o(localObject1);
            }
            AppMethodBeat.o(200510);
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
  
  private static void o(Object paramObject)
  {
    AppMethodBeat.i(200521);
    if (!ik) {}
    try
    {
      ij = Class.forName("android.content.res.ThemedResourceCache");
      label19:
      ik = true;
      if (ij == null)
      {
        AppMethodBeat.o(200521);
        return;
      }
      if (!im) {}
      try
      {
        Field localField = ij.getDeclaredField("mUnthemedEntries");
        il = localField;
        localField.setAccessible(true);
        label59:
        im = true;
        if (il == null)
        {
          AppMethodBeat.o(200521);
          return;
        }
        try
        {
          paramObject = (LongSparseArray)il.get(paramObject);
          if (paramObject != null) {
            paramObject.clear();
          }
          AppMethodBeat.o(200521);
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