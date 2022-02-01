package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;

public final class x$a
{
  private static boolean cMr = false;
  private static Class cMs;
  private static Field cMt;
  private static Class cMu;
  private static Field cMv;
  
  public static String h(Message paramMessage)
  {
    AppMethodBeat.i(160115);
    if (!cMr) {}
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
      cMs = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cMt = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
      cMu = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("intent");
      cMv = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      cMr = true;
      if (!cMr)
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
        if (cMs.isInstance(paramMessage.obj)) {}
        for (paramMessage = (Intent)cMt.get(paramMessage.obj);; paramMessage = (Intent)cMv.get(paramMessage.obj))
        {
          if (paramMessage == null) {
            break label190;
          }
          paramMessage = paramMessage.getComponent().getClassName();
          AppMethodBeat.o(160115);
          return paramMessage;
          if (!cMu.isInstance(paramMessage.obj)) {
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
 * Qualified Name:     com.tencent.mm.app.x.a
 * JD-Core Version:    0.7.0.1
 */