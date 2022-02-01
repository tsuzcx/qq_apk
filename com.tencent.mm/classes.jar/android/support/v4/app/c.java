package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class c
{
  public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramBundle.putBinder(paramString, paramIBinder);
      return;
    }
    a.a(paramBundle, paramString, paramIBinder);
  }
  
  public static IBinder c(Bundle paramBundle, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramBundle.getBinder(paramString);
    }
    return a.c(paramBundle, paramString);
  }
  
  static final class a
  {
    private static Method Cd;
    private static boolean Ce;
    private static Method Cf;
    private static boolean Cg;
    
    public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
    {
      if (!Cg) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        Cf = localMethod;
        localMethod.setAccessible(true);
        label37:
        Cg = true;
        if (Cf != null) {}
        try
        {
          Cf.invoke(paramBundle, new Object[] { paramString, paramIBinder });
          return;
        }
        catch (IllegalAccessException paramBundle)
        {
          Cf = null;
          return;
        }
        catch (IllegalArgumentException paramBundle)
        {
          break label69;
        }
        catch (InvocationTargetException paramBundle)
        {
          label69:
          break label69;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label37;
      }
    }
    
    public static IBinder c(Bundle paramBundle, String paramString)
    {
      if (!Ce) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        Cd = localMethod;
        localMethod.setAccessible(true);
        label32:
        Ce = true;
        if (Cd != null) {}
        try
        {
          paramBundle = (IBinder)Cd.invoke(paramBundle, new Object[] { paramString });
          return paramBundle;
        }
        catch (IllegalAccessException paramBundle)
        {
          Cd = null;
          return null;
        }
        catch (IllegalArgumentException paramBundle)
        {
          break label64;
        }
        catch (InvocationTargetException paramBundle)
        {
          label64:
          break label64;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label32;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.app.c
 * JD-Core Version:    0.7.0.1
 */