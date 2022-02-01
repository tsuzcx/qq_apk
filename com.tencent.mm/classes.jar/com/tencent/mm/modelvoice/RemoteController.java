package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController
{
  private static Method iwn;
  private static Method iwo;
  private AudioManager iwl;
  private ComponentName iwm;
  
  static
  {
    AppMethodBeat.i(148427);
    try
    {
      if (iwn == null) {
        iwn = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[] { ComponentName.class });
      }
      if (iwo == null) {
        iwo = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[] { ComponentName.class });
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
        Method localMethod = iwo;
        if (localMethod == null)
        {
          super.finalize();
          AppMethodBeat.o(148426);
          return;
        }
        iwo.invoke(this.iwl, new Object[] { this.iwm });
        RemoteControlReceiver.aNo();
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
        ad.e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(localIllegalAccessException)));
      }
    }
  }
  
  public static class RemoteControlReceiver
    extends BroadcastReceiver
  {
    private static av cXg;
    private static RemoteController.a iwp;
    
    public static void aNo()
    {
      AppMethodBeat.i(148425);
      iwp = null;
      if (cXg != null)
      {
        cXg.stopTimer();
        cXg = null;
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
        ad.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + paramIntent.getAction());
        AppMethodBeat.o(148424);
        return;
      }
      if ((cXg == null) && (iwp != null))
      {
        ad.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
        cXg = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(148423);
            ad.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
            if (RemoteController.RemoteControlReceiver.aNp() != null) {
              RemoteController.RemoteControlReceiver.aNp();
            }
            RemoteController.RemoteControlReceiver.aNq();
            AppMethodBeat.o(148423);
            return false;
          }
        }, true);
      }
      if (cXg != null) {
        cXg.az(1000L, 1000L);
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