package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMReceivers$ToolsMpProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a fiJ = null;
  
  public static void a(MMReceivers.a parama)
  {
    fiJ = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131893);
    if (fiJ != null) {
      fiJ.onReceive(paramContext, paramIntent);
    }
    AppMethodBeat.o(131893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver
 * JD-Core Version:    0.7.0.1
 */