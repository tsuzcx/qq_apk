package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMReceivers$ToolsProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a glx = null;
  
  public static void a(MMReceivers.a parama)
  {
    glx = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131894);
    try
    {
      if (glx != null) {
        glx.onReceive(paramContext, paramIntent);
      }
      AppMethodBeat.o(131894);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ToolsProcessReceiver", paramContext, "onReceive error", new Object[0]);
      AppMethodBeat.o(131894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver
 * JD-Core Version:    0.7.0.1
 */