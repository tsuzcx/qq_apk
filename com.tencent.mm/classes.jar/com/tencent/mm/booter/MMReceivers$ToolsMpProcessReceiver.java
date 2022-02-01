package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class MMReceivers$ToolsMpProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a fGo = null;
  
  public static void a(MMReceivers.a parama)
  {
    fGo = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131893);
    try
    {
      if (fGo != null) {
        fGo.onReceive(paramContext, paramIntent);
      }
      AppMethodBeat.o(131893);
      return;
    }
    catch (Throwable paramContext)
    {
      ae.printErrStackTrace("MicroMsg.ToolsMpProcessReceiver", paramContext, "onReceive error", new Object[0]);
      AppMethodBeat.o(131893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver
 * JD-Core Version:    0.7.0.1
 */