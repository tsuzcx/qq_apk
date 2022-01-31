package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class PluginRecovery$2
  extends BroadcastReceiver
{
  PluginRecovery$2(PluginRecovery paramPluginRecovery) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!"com.tecent.recovery.intent.action.LOG".equals(paramIntent.getAction())) {
        break label24;
      }
      PluginRecovery.access$000(this.exh);
    }
    label24:
    while (!"com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramIntent.getAction())) {
      return;
    }
    PluginRecovery.access$100(this.exh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.2
 * JD-Core Version:    0.7.0.1
 */