package com.tencent.mm.modelvoice;

import android.content.ComponentName;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController
{
  private static Method fZD;
  private static Method fZE;
  private AudioManager fZB;
  private ComponentName fZC;
  
  static
  {
    AppMethodBeat.i(116588);
    try
    {
      if (fZD == null) {
        fZD = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      if (fZE == null) {
        fZE = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      AppMethodBeat.o(116588);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(116588);
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(116587);
    for (;;)
    {
      try
      {
        Method localMethod = fZE;
        if (localMethod == null)
        {
          super.finalize();
          AppMethodBeat.o(116587);
          return;
        }
        fZE.invoke(this.fZB, new Object[] { this.fZC });
        RemoteController.RemoteControlReceiver.amj();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Throwable localThrowable = localInvocationTargetException.getCause();
        if (!(localThrowable instanceof RuntimeException)) {
          continue;
        }
        Object localObject = (RuntimeException)localThrowable;
        AppMethodBeat.o(116587);
        throw ((Throwable)localObject);
        if (!(localThrowable instanceof Error)) {
          continue;
        }
        localObject = (Error)localThrowable;
        AppMethodBeat.o(116587);
        throw ((Throwable)localObject);
        localObject = new RuntimeException((Throwable)localObject);
        AppMethodBeat.o(116587);
        throw ((Throwable)localObject);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ab.e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(localIllegalAccessException)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController
 * JD-Core Version:    0.7.0.1
 */