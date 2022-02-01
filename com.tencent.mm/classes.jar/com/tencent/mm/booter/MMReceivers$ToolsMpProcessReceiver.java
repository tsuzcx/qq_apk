package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class MMReceivers$ToolsMpProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a fEk = null;
  
  public static void a(MMReceivers.a parama)
  {
    fEk = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131893);
    try
    {
      if (fEk != null) {
        fEk.onReceive(paramContext, paramIntent);
      }
      AppMethodBeat.o(131893);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.printErrStackTrace("MicroMsg.ToolsMpProcessReceiver", paramContext, "onReceive error", new Object[0]);
      AppMethodBeat.o(131893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver
 * JD-Core Version:    0.7.0.1
 */