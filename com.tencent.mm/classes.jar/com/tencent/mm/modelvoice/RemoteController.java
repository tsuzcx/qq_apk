package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController
{
  private static Method izg;
  private static Method izh;
  private AudioManager ize;
  private ComponentName izf;
  
  static
  {
    AppMethodBeat.i(148427);
    try
    {
      if (izg == null) {
        izg = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      if (izh == null) {
        izh = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[] { ComponentName.class });
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
    for (;;)
    {
      try
      {
        Method localMethod = izh;
        if (localMethod == null)
        {
          super.finalize();
          AppMethodBeat.o(148426);
          return;
        }
        izh.invoke(this.ize, new Object[] { this.izf });
        RemoteControlReceiver.aNM();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Throwable localThrowable = localInvocationTargetException.getCause();
        if (!(localThrowable instanceof RuntimeException)) {
          continue;
        }
        Object localObject = (RuntimeException)localThrowable;
        AppMethodBeat.o(148426);
        throw ((Throwable)localObject);
        if (!(localThrowable instanceof Error)) {
          continue;
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
        ae.e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(localIllegalAccessException)));
      }
    }
  }
  
  public static class RemoteControlReceiver
    extends BroadcastReceiver
  {
    private static aw cYd;
    private static RemoteController.a izi;
    
    public static void aNM()
    {
      AppMethodBeat.i(148425);
      izi = null;
      if (cYd != null)
      {
        cYd.stopTimer();
        cYd = null;
      }
      AppMethodBeat.o(148425);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(148424);
      if (paramIntent == null)
      {
        AppMethodBeat.o(148424);
        return;
      }
      if (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction()))
      {
        ae.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + paramIntent.getAction());
        AppMethodBeat.o(148424);
        return;
      }
      if ((cYd == null) && (izi != null))
      {
        ae.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
        cYd = new aw(new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(148423);
            ae.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
            if (RemoteController.RemoteControlReceiver.aNN() != null) {
              RemoteController.RemoteControlReceiver.aNN();
            }
            RemoteController.RemoteControlReceiver.aNO();
            AppMethodBeat.o(148423);
            return false;
          }
        }, true);
      }
      if (cYd != null) {
        cYd.ay(1000L, 1000L);
      }
      AppMethodBeat.o(148424);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController
 * JD-Core Version:    0.7.0.1
 */