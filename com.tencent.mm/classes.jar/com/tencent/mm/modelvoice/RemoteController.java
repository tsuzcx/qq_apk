package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController
{
  private static Method icR;
  private static Method icS;
  private AudioManager icP;
  private ComponentName icQ;
  
  static
  {
    AppMethodBeat.i(148427);
    try
    {
      if (icR == null) {
        icR = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      if (icS == null) {
        icS = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[] { ComponentName.class });
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
        Method localMethod = icS;
        if (localMethod == null)
        {
          super.finalize();
          AppMethodBeat.o(148426);
          return;
        }
        icS.invoke(this.icP, new Object[] { this.icQ });
        RemoteControlReceiver.aKf();
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
        ac.e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(localIllegalAccessException)));
      }
    }
  }
  
  public static class RemoteControlReceiver
    extends BroadcastReceiver
  {
    private static au cLS;
    private static RemoteController.a icT;
    
    public static void aKf()
    {
      AppMethodBeat.i(148425);
      icT = null;
      if (cLS != null)
      {
        cLS.stopTimer();
        cLS = null;
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
        ac.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + paramIntent.getAction());
        AppMethodBeat.o(148424);
        return;
      }
      if ((cLS == null) && (icT != null))
      {
        ac.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
        cLS = new au(new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(148423);
            ac.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
            if (RemoteController.RemoteControlReceiver.aKg() != null) {
              RemoteController.RemoteControlReceiver.aKg();
            }
            RemoteController.RemoteControlReceiver.aKh();
            AppMethodBeat.o(148423);
            return false;
          }
        }, true);
      }
      if (cLS != null) {
        cLS.au(1000L, 1000L);
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