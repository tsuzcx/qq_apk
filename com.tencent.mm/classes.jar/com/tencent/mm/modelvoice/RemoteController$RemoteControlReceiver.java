package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class RemoteController$RemoteControlReceiver
  extends BroadcastReceiver
{
  private static RemoteController.a pdC;
  private static MTimerHandler timer;
  
  public static void bOV()
  {
    AppMethodBeat.i(148425);
    pdC = null;
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
    if ((timer == null) && (pdC != null))
    {
      Log.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
      timer = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(148423);
          Log.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
          if (RemoteController.RemoteControlReceiver.bOW() != null) {
            RemoteController.RemoteControlReceiver.bOW();
          }
          RemoteController.RemoteControlReceiver.bOX();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController.RemoteControlReceiver
 * JD-Core Version:    0.7.0.1
 */