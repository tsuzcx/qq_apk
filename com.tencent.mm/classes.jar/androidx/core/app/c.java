package androidx.core.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class c
{
  public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    AppMethodBeat.i(196347);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramBundle.putBinder(paramString, paramIBinder);
      AppMethodBeat.o(196347);
      return;
    }
    if (!a.bnX) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
      a.bnW = localMethod;
      localMethod.setAccessible(true);
      label62:
      a.bnX = true;
      if (a.bnW != null) {}
      try
      {
        a.bnW.invoke(paramBundle, new Object[] { paramString, paramIBinder });
        AppMethodBeat.o(196347);
        return;
      }
      catch (IllegalAccessException paramBundle)
      {
        a.bnW = null;
        AppMethodBeat.o(196347);
        return;
      }
      catch (IllegalArgumentException paramBundle)
      {
        break label99;
      }
      catch (InvocationTargetException paramBundle)
      {
        label99:
        break label99;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label62;
    }
  }
  
  public static IBinder b(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(196331);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramBundle = paramBundle.getBinder(paramString);
      AppMethodBeat.o(196331);
      return paramBundle;
    }
    paramBundle = a.b(paramBundle, paramString);
    AppMethodBeat.o(196331);
    return paramBundle;
  }
  
  static final class a
  {
    private static Method bnU;
    private static boolean bnV;
    static Method bnW;
    static boolean bnX;
    
    public static IBinder b(Bundle paramBundle, String paramString)
    {
      AppMethodBeat.i(196430);
      if (!bnV) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        bnU = localMethod;
        localMethod.setAccessible(true);
        label37:
        bnV = true;
        if (bnU != null) {}
        try
        {
          paramBundle = (IBinder)bnU.invoke(paramBundle, new Object[] { paramString });
          AppMethodBeat.o(196430);
          return paramBundle;
        }
        catch (IllegalAccessException paramBundle)
        {
          bnU = null;
          AppMethodBeat.o(196430);
          return null;
        }
        catch (IllegalArgumentException paramBundle)
        {
          break label74;
        }
        catch (InvocationTargetException paramBundle)
        {
          label74:
          break label74;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label37;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.app.c
 * JD-Core Version:    0.7.0.1
 */