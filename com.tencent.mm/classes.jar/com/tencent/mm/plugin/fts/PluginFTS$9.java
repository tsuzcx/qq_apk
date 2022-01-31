package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class PluginFTS$9
  extends BroadcastReceiver
{
  PluginFTS$9(PluginFTS paramPluginFTS) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      return;
      y.i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + paramIntent.getAction());
      if (paramIntent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED"))
      {
        PluginFTS.access$1602(this.kuy, true);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED"));
    PluginFTS.access$1602(this.kuy, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.9
 * JD-Core Version:    0.7.0.1
 */