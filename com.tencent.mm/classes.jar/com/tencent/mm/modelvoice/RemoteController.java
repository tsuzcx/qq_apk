package com.tencent.mm.modelvoice;

import android.content.ComponentName;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController
{
  private static Method pdA;
  private static Method pdB;
  
  static
  {
    AppMethodBeat.i(148427);
    try
    {
      if (pdA == null) {
        pdA = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      if (pdB == null) {
        pdB = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      AppMethodBeat.o(148427);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(148427);
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(148426);
    try
    {
      Method localMethod = pdB;
      if (localMethod != null) {
        break label23;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if (!(localThrowable instanceof RuntimeException)) {
        break label55;
      }
      Object localObject = (RuntimeException)localThrowable;
      AppMethodBeat.o(148426);
      throw ((Throwable)localObject);
      if (!(localThrowable instanceof Error)) {
        break label74;
      }
      localObject = (Error)localThrowable;
      AppMethodBeat.o(148426);
      throw ((Throwable)localObject);
      localObject = new RuntimeException((Throwable)localObject);
      AppMethodBeat.o(148426);
      throw ((Throwable)localObject);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(localIllegalAccessException)));
        RemoteController.RemoteControlReceiver.bOV();
      }
    }
    super.finalize();
    AppMethodBeat.o(148426);
    return;
    label23:
    AppMethodBeat.o(148426);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController
 * JD-Core Version:    0.7.0.1
 */