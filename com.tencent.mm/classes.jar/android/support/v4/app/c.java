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
  
  public static IBinder b(Bundle paramBundle, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramBundle.getBinder(paramString);
    }
    return a.b(paramBundle, paramString);
  }
  
  static final class a
  {
    private static Method ET;
    private static boolean EU;
    private static Method EV;
    private static boolean EW;
    
    public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
    {
      if (!EW) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        EV = localMethod;
        localMethod.setAccessible(true);
        label37:
        EW = true;
        if (EV != null) {}
        try
        {
          EV.invoke(paramBundle, new Object[] { paramString, paramIBinder });
          return;
        }
        catch (IllegalAccessException paramBundle)
        {
          EV = null;
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
    
    public static IBinder b(Bundle paramBundle, String paramString)
    {
      if (!EU) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        ET = localMethod;
        localMethod.setAccessible(true);
        label32:
        EU = true;
        if (ET != null) {}
        try
        {
          paramBundle = (IBinder)ET.invoke(paramBundle, new Object[] { paramString });
          return paramBundle;
        }
        catch (IllegalAccessException paramBundle)
        {
          ET = null;
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