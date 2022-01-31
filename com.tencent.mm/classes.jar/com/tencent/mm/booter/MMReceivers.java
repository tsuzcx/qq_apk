package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MMReceivers
{
  public static class SandBoxProcessReceiver
    extends BroadcastReceiver
  {
    private static MMReceivers.a dYW = null;
    
    public static void a(MMReceivers.a parama)
    {
      dYW = parama;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(57776);
      if (dYW != null) {
        dYW.onReceive(paramContext, paramIntent);
      }
      AppMethodBeat.o(57776);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers
 * JD-Core Version:    0.7.0.1
 */