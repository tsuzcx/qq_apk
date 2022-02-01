package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMReceivers$SandBoxProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a fGo = null;
  
  public static void a(MMReceivers.a parama)
  {
    fGo = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131892);
    if (fGo != null) {
      fGo.onReceive(paramContext, paramIntent);
    }
    AppMethodBeat.o(131892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver
 * JD-Core Version:    0.7.0.1
 */