package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;

public final class y$a
{
  private static boolean cUP = false;
  private static Class cUQ;
  private static Field cUR;
  private static Class cUS;
  private static Field cUT;
  
  public static String h(Message paramMessage)
  {
    AppMethodBeat.i(160115);
    if (!cUP) {}
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
      cUQ = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cUR = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
      cUS = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cUT = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      cUP = true;
      if (!cUP)
      {
        AppMethodBeat.o(160115);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
      }
      try
      {
        if (cUQ.isInstance(paramMessage.obj)) {}
        for (paramMessage = (Intent)cUR.get(paramMessage.obj);; paramMessage = (Intent)cUT.get(paramMessage.obj))
        {
          if (paramMessage == null) {
            break label190;
          }
          paramMessage = paramMessage.getComponent().getClassName();
          AppMethodBeat.o(160115);
          return paramMessage;
          if (!cUS.isInstance(paramMessage.obj)) {
            break;
          }
        }
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramMessage, "", new Object[0]);
          paramMessage = null;
        }
        label190:
        AppMethodBeat.o(160115);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.y.a
 * JD-Core Version:    0.7.0.1
 */