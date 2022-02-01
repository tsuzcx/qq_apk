package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public final class y$a
{
  private static boolean dmg = false;
  private static Class dmh;
  private static Field dmi;
  private static Class dmj;
  private static Field dmk;
  
  public static String h(Message paramMessage)
  {
    AppMethodBeat.i(160115);
    if (!dmg) {}
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
      dmh = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      dmi = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
      dmj = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      dmk = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      dmg = true;
      if (!dmg)
      {
        AppMethodBeat.o(160115);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
      }
      try
      {
        if (dmh.isInstance(paramMessage.obj)) {}
        for (paramMessage = (Intent)dmi.get(paramMessage.obj);; paramMessage = (Intent)dmk.get(paramMessage.obj))
        {
          if (paramMessage == null) {
            break label190;
          }
          paramMessage = paramMessage.getComponent().getClassName();
          AppMethodBeat.o(160115);
          return paramMessage;
          if (!dmj.isInstance(paramMessage.obj)) {
            break;
          }
        }
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramMessage, "", new Object[0]);
          paramMessage = null;
        }
        label190:
        AppMethodBeat.o(160115);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.y.a
 * JD-Core Version:    0.7.0.1
 */