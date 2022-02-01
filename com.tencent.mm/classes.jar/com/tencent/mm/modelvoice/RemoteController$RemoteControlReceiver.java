package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public class RemoteController$RemoteControlReceiver
  extends BroadcastReceiver
{
  private static av cOx;
  private static RemoteController.a hCs;
  
  public static void aDo()
  {
    AppMethodBeat.i(148425);
    hCs = null;
    if (cOx != null)
    {
      cOx.stopTimer();
      cOx = null;
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
    if ((cOx == null) && (hCs != null))
    {
      ad.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
      cOx = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(148423);
          ad.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
          if (RemoteController.RemoteControlReceiver.aDp() != null) {
            RemoteController.RemoteControlReceiver.aDp();
          }
          RemoteController.RemoteControlReceiver.aDq();
          AppMethodBeat.o(148423);
          return false;
        }
      }, true);
    }
    if (cOx != null) {
      cOx.av(1000L, 1000L);
    }
    AppMethodBeat.o(148424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController.RemoteControlReceiver
 * JD-Core Version:    0.7.0.1
 */