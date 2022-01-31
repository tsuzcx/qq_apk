package com.tencent.mm.modelvoice;

import android.content.ComponentName;
import android.media.AudioManager;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController
{
  private static Method eKb;
  private static Method eKc;
  private AudioManager eJZ;
  private ComponentName eKa;
  
  static
  {
    try
    {
      if (eKb == null) {
        eKb = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      if (eKc == null) {
        eKc = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  protected final void finalize()
  {
    for (;;)
    {
      try
      {
        Method localMethod = eKc;
        if (localMethod == null)
        {
          super.finalize();
          return;
        }
        eKc.invoke(this.eJZ, new Object[] { this.eKa });
        RemoteController.RemoteControlReceiver.SY();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Throwable localThrowable = localInvocationTargetException.getCause();
        if (!(localThrowable instanceof RuntimeException)) {
          continue;
        }
        throw ((RuntimeException)localThrowable);
        if (!(localThrowable instanceof Error)) {
          continue;
        }
        throw ((Error)localThrowable);
        throw new RuntimeException(localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        y.e("MicroMsg.RemoteControlReceiver", "unexpected " + localIllegalAccessException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController
 * JD-Core Version:    0.7.0.1
 */