package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMReceivers$ExdeviceProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a fEk = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131891);
    if (fEk != null) {
      fEk.onReceive(paramContext, paramIntent);
    }
    AppMethodBeat.o(131891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver
 * JD-Core Version:    0.7.0.1
 */