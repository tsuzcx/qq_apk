package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMReceivers$ToolsProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a dYW = null;
  
  public static void a(MMReceivers.a parama)
  {
    dYW = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(57778);
    if (dYW != null) {
      dYW.onReceive(paramContext, paramIntent);
    }
    AppMethodBeat.o(57778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver
 * JD-Core Version:    0.7.0.1
 */