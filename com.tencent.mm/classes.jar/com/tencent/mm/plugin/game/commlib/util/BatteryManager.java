package com.tencent.mm.plugin.game.commlib.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BatteryManager
{
  public static boolean tSV;
  public static BatteryChangedReceiver tSW;
  
  public static final class BatteryChangedReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(215761);
      if (paramIntent == null)
      {
        AppMethodBeat.o(215761);
        return;
      }
      if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
      {
        BatteryManager.tSV = false;
        AppMethodBeat.o(215761);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction())) {
        BatteryManager.tSV = true;
      }
      AppMethodBeat.o(215761);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.util.BatteryManager
 * JD-Core Version:    0.7.0.1
 */