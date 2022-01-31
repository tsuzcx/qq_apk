package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MMReceivers$ExdeviceProcessReceiver
  extends BroadcastReceiver
{
  private static MMReceivers.a dhF = null;
  
  public static void a(MMReceivers.a parama)
  {
    dhF = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (dhF != null) {
      dhF.onReceive(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver
 * JD-Core Version:    0.7.0.1
 */