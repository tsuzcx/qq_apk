package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMReceivers$ExdeviceProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a dYW = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(57775);
    if (dYW != null) {
      dYW.onReceive(paramContext, paramIntent);
    }
    AppMethodBeat.o(57775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver
 * JD-Core Version:    0.7.0.1
 */