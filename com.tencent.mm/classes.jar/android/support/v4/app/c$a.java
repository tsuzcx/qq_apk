package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class c$a
{
  private static Method vG;
  private static boolean vH;
  private static Method vI;
  private static boolean vJ;
  
  public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (!vJ) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
      vI = localMethod;
      localMethod.setAccessible(true);
      label37:
      vJ = true;
      if (vI != null) {}
      try
      {
        vI.invoke(paramBundle, new Object[] { paramString, paramIBinder });
        return;
      }
      catch (IllegalAccessException paramBundle)
      {
        vI = null;
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
    if (!vH) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
      vG = localMethod;
      localMethod.setAccessible(true);
      label32:
      vH = true;
      if (vG != null) {}
      try
      {
        paramBundle = (IBinder)vG.invoke(paramBundle, new Object[] { paramString });
        return paramBundle;
      }
      catch (IllegalAccessException paramBundle)
      {
        vG = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.app.c.a
 * JD-Core Version:    0.7.0.1
 */