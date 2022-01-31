package com.tencent.mm.plugin.crashfix.d.a;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d
  implements com.tencent.mm.plugin.crashfix.d.a
{
  private static Object biI()
  {
    Object localObject1 = null;
    AppMethodBeat.i(151906);
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
        ab.e("MicroMsg.ToastBadTokenFix", localNoSuchFieldException.getMessage());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ToastBadTokenFix", localIllegalAccessException.getMessage());
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ToastBadTokenFix", localNoSuchMethodException.getMessage());
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ToastBadTokenFix", localInvocationTargetException.getMessage());
      }
    }
    AppMethodBeat.o(151906);
    return localObject1;
  }
  
  public final boolean biH()
  {
    AppMethodBeat.i(151905);
    Object localObject = biI();
    if (localObject != null)
    {
      localObject = c.bF(localObject);
      if (localObject == null)
      {
        ab.e("MicroMsg.ToastBadTokenFix", "INotificationManagerInvocationHandler.getProxy null");
        AppMethodBeat.o(151905);
        return false;
      }
      ab.i("MicroMsg.ToastBadTokenFix", "INotificationManagerInvocationHandler.getProxy succ");
    }
    try
    {
      Field localField = Toast.class.getDeclaredField("sService");
      localField.setAccessible(true);
      com.tencent.mm.plugin.crashfix.c.a.b(localField);
      localField.set(null, localObject);
      ab.i("MicroMsg.ToastBadTokenFix", "replace succ");
      AppMethodBeat.o(151905);
      return true;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ab.e("MicroMsg.ToastBadTokenFix", localNoSuchFieldException.getMessage());
      AppMethodBeat.o(151905);
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ToastBadTokenFix", localIllegalAccessException.getMessage());
      }
    }
  }
  
  public final boolean tS(int paramInt)
  {
    return paramInt < 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.d
 * JD-Core Version:    0.7.0.1
 */