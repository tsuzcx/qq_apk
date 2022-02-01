package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMReceivers$ToolsProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a fmd = null;
  
  public static void a(MMReceivers.a parama)
  {
    fmd = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131894);
    if (fmd != null) {
      fmd.onReceive(paramContext, paramIntent);
    }
    AppMethodBeat.o(131894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver
 * JD-Core Version:    0.7.0.1
 */