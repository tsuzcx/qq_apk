package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public final class q$a
{
  private static boolean bYO = false;
  private static Class bYP;
  private static Field bYQ;
  private static Class bYR;
  private static Field bYS;
  
  public static String h(Message paramMessage)
  {
    AppMethodBeat.i(137991);
    if (!bYO) {}
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
      bYP = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      bYQ = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
      bYR = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      bYS = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      bYO = true;
      if (!bYO)
      {
        AppMethodBeat.o(137991);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
      }
      try
      {
        if (bYP.isInstance(paramMessage.obj)) {}
        for (paramMessage = (Intent)bYQ.get(paramMessage.obj);; paramMessage = (Intent)bYS.get(paramMessage.obj))
        {
          if (paramMessage == null) {
            break label190;
          }
          paramMessage = paramMessage.getComponent().getClassName();
          AppMethodBeat.o(137991);
          return paramMessage;
          if (!bYR.isInstance(paramMessage.obj)) {
            break;
          }
        }
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramMessage, "", new Object[0]);
          paramMessage = null;
        }
        label190:
        AppMethodBeat.o(137991);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.q.a
 * JD-Core Version:    0.7.0.1
 */