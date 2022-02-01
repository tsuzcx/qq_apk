package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;

public final class y$a
{
  private static boolean cJC = false;
  private static Class cJD;
  private static Field cJE;
  private static Class cJF;
  private static Field cJG;
  
  public static String h(Message paramMessage)
  {
    AppMethodBeat.i(160115);
    if (!cJC) {}
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
      cJD = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cJE = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
      cJF = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cJG = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      cJC = true;
      if (!cJC)
      {
        AppMethodBeat.o(160115);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
      }
      try
      {
        if (cJD.isInstance(paramMessage.obj)) {}
        for (paramMessage = (Intent)cJE.get(paramMessage.obj);; paramMessage = (Intent)cJG.get(paramMessage.obj))
        {
          if (paramMessage == null) {
            break label190;
          }
          paramMessage = paramMessage.getComponent().getClassName();
          AppMethodBeat.o(160115);
          return paramMessage;
          if (!cJF.isInstance(paramMessage.obj)) {
            break;
          }
        }
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramMessage, "", new Object[0]);
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