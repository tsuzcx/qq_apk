package com.tencent.mm.plugin.game.commlib.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static boolean Itd;
  public static a Ite;
  
  public static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(275347);
      if (paramIntent == null)
      {
        AppMethodBeat.o(275347);
        return;
      }
      if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
      {
        a.Itd = false;
        AppMethodBeat.o(275347);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction())) {
        a.Itd = true;
      }
      AppMethodBeat.o(275347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.a
 * JD-Core Version:    0.7.0.1
 */