package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class RemoteController$RemoteControlReceiver
  extends BroadcastReceiver
{
  private static ap caS;
  private static RemoteController.a fZF;
  
  public static void amj()
  {
    AppMethodBeat.i(116586);
    fZF = null;
    if (caS != null)
    {
      caS.stopTimer();
      caS = null;
    }
    AppMethodBeat.o(116586);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(116585);
    if (paramIntent == null)
    {
      AppMethodBeat.o(116585);
      return;
    }
    if (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction()))
    {
      ab.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + paramIntent.getAction());
      AppMethodBeat.o(116585);
      return;
    }
    if ((caS == null) && (fZF != null))
    {
      ab.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
      caS = new ap(new RemoteController.RemoteControlReceiver.1(this), true);
    }
    if (caS != null) {
      caS.ag(1000L, 1000L);
    }
    AppMethodBeat.o(116585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController.RemoteControlReceiver
 * JD-Core Version:    0.7.0.1
 */