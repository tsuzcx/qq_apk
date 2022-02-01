package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController
{
  private static Method mjW;
  private static Method mjX;
  
  static
  {
    AppMethodBeat.i(148427);
    try
    {
      if (mjW == null) {
        mjW = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      if (mjX == null) {
        mjX = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[] { ComponentName.class });
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
      Method localMethod = mjX;
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
        RemoteControlReceiver.brp();
      }
    }
    super.finalize();
    AppMethodBeat.o(148426);
    return;
    label23:
    AppMethodBeat.o(148426);
    throw null;
  }
  
  public static class RemoteControlReceiver
    extends BroadcastReceiver
  {
    private static RemoteController.a mjY;
    private static MTimerHandler timer;
    
    public static void brp()
    {
      AppMethodBeat.i(148425);
      mjY = null;
      if (timer != null)
      {
        timer.stopTimer();
        timer = null;
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
        Log.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + paramIntent.getAction());
        AppMethodBeat.o(148424);
        return;
      }
      if ((timer == null) && (mjY != null))
      {
        Log.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
        timer = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(148423);
            Log.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
            if (RemoteController.RemoteControlReceiver.brq() != null) {
              RemoteController.RemoteControlReceiver.brq();
            }
            RemoteController.RemoteControlReceiver.brr();
            AppMethodBeat.o(148423);
            return false;
          }
        }, true);
      }
      if (timer != null) {
        timer.startTimer(1000L);
      }
      AppMethodBeat.o(148424);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController
 * JD-Core Version:    0.7.0.1
 */