package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e$a
{
  private static Method uJ;
  private static boolean uK;
  public static Method uL;
  public static boolean uM;
  
  public static IBinder c(Bundle paramBundle, String paramString)
  {
    if (!uK) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
      uJ = localMethod;
      localMethod.setAccessible(true);
      label32:
      uK = true;
      if (uJ != null) {}
      try
      {
        paramBundle = (IBinder)uJ.invoke(paramBundle, new Object[] { paramString });
        return paramBundle;
      }
      catch (IllegalAccessException paramBundle)
      {
        uJ = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.app.e.a
 * JD-Core Version:    0.7.0.1
 */