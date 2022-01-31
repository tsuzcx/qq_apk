package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginFTS$9
  extends BroadcastReceiver
{
  PluginFTS$9(PluginFTS paramPluginFTS) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(136593);
    if ((paramIntent == null) || (paramIntent.getAction() == null))
    {
      AppMethodBeat.o(136593);
      return;
    }
    ab.i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + paramIntent.getAction());
    if (paramIntent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED"))
    {
      PluginFTS.access$1602(this.mQm, true);
      AppMethodBeat.o(136593);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
      PluginFTS.access$1602(this.mQm, false);
    }
    AppMethodBeat.o(136593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.9
 * JD-Core Version:    0.7.0.1
 */