package com.tencent.mm.plugin.crashfix.patch.b;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.crashfix.c.a;
import com.tencent.mm.plugin.crashfix.patch.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d
  implements b
{
  private static Object dtd()
  {
    Object localObject1 = null;
    AppMethodBeat.i(145635);
    try
    {
      Object localObject2 = Toast.class.getDeclaredMethod("getService", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      ((Method)localObject2).invoke(null, new Object[0]);
      localObject2 = Toast.class.getDeclaredField("sService");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = localObject2;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ToastBadTokenFix", localNoSuchFieldException.getMessage());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ToastBadTokenFix", localIllegalAccessException.getMessage());
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ToastBadTokenFix", localNoSuchMethodException.getMessage());
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ToastBadTokenFix", localInvocationTargetException.getMessage());
      }
    }
    AppMethodBeat.o(145635);
    return localObject1;
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt < 26;
  }
  
  public final boolean dtc()
  {
    AppMethodBeat.i(145634);
    Object localObject = dtd();
    if (localObject != null)
    {
      localObject = c.ey(localObject);
      if (localObject == null)
      {
        Log.e("MicroMsg.ToastBadTokenFix", "INotificationManagerInvocationHandler.getProxy null");
        AppMethodBeat.o(145634);
        return false;
      }
      Log.i("MicroMsg.ToastBadTokenFix", "INotificationManagerInvocationHandler.getProxy succ");
    }
    try
    {
      Field localField = Toast.class.getDeclaredField("sService");
      localField.setAccessible(true);
      a.f(localField);
      localField.set(null, localObject);
      Log.i("MicroMsg.ToastBadTokenFix", "replace succ");
      AppMethodBeat.o(145634);
      return true;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.e("MicroMsg.ToastBadTokenFix", localNoSuchFieldException.getMessage());
      AppMethodBeat.o(145634);
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ToastBadTokenFix", localIllegalAccessException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.patch.b.d
 * JD-Core Version:    0.7.0.1
 */