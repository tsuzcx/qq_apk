package androidx.core.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class b
{
  public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    AppMethodBeat.i(250232);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramBundle.putBinder(paramString, paramIBinder);
      AppMethodBeat.o(250232);
      return;
    }
    a.a(paramBundle, paramString, paramIBinder);
    AppMethodBeat.o(250232);
  }
  
  public static IBinder b(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(250231);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramBundle = paramBundle.getBinder(paramString);
      AppMethodBeat.o(250231);
      return paramBundle;
    }
    paramBundle = a.b(paramBundle, paramString);
    AppMethodBeat.o(250231);
    return paramBundle;
  }
  
  static final class a
  {
    private static Method HR;
    private static boolean HS;
    private static Method HT;
    private static boolean HU;
    
    public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
    {
      AppMethodBeat.i(250229);
      if (!HU) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        HT = localMethod;
        localMethod.setAccessible(true);
        label42:
        HU = true;
        if (HT != null) {}
        try
        {
          HT.invoke(paramBundle, new Object[] { paramString, paramIBinder });
          AppMethodBeat.o(250229);
          return;
        }
        catch (IllegalAccessException paramBundle)
        {
          HT = null;
          AppMethodBeat.o(250229);
          return;
        }
        catch (IllegalArgumentException paramBundle)
        {
          break label79;
        }
        catch (InvocationTargetException paramBundle)
        {
          label79:
          break label79;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label42;
      }
    }
    
    public static IBinder b(Bundle paramBundle, String paramString)
    {
      AppMethodBeat.i(250226);
      if (!HS) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        HR = localMethod;
        localMethod.setAccessible(true);
        label37:
        HS = true;
        if (HR != null) {}
        try
        {
          paramBundle = (IBinder)HR.invoke(paramBundle, new Object[] { paramString });
          AppMethodBeat.o(250226);
          return paramBundle;
        }
        catch (IllegalAccessException paramBundle)
        {
          HR = null;
          AppMethodBeat.o(250226);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.b
 * JD-Core Version:    0.7.0.1
 */