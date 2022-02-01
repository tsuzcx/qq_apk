package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;

public final class y$a
{
  private static boolean cVM = false;
  private static Class cVN;
  private static Field cVO;
  private static Class cVP;
  private static Field cVQ;
  
  public static String h(Message paramMessage)
  {
    AppMethodBeat.i(160115);
    if (!cVM) {}
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
      cVN = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cVO = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
      cVP = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cVQ = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      cVM = true;
      if (!cVM)
      {
        AppMethodBeat.o(160115);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
      }
      try
      {
        if (cVN.isInstance(paramMessage.obj)) {}
        for (paramMessage = (Intent)cVO.get(paramMessage.obj);; paramMessage = (Intent)cVQ.get(paramMessage.obj))
        {
          if (paramMessage == null) {
            break label190;
          }
          paramMessage = paramMessage.getComponent().getClassName();
          AppMethodBeat.o(160115);
          return paramMessage;
          if (!cVP.isInstance(paramMessage.obj)) {
            break;
          }
        }
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramMessage, "", new Object[0]);
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