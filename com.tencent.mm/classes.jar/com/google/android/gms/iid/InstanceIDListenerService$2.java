package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class InstanceIDListenerService$2
  extends BroadcastReceiver
{
  InstanceIDListenerService$2(InstanceIDListenerService paramInstanceIDListenerService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("InstanceID", 3))
    {
      paramIntent.getStringExtra("registration_id");
      paramContext = String.valueOf(paramIntent.getExtras());
      new StringBuilder(String.valueOf(paramContext).length() + 46).append("Received GSF callback using dynamic receiver: ").append(paramContext);
    }
    this.zzbhT.zzn(paramIntent);
    this.zzbhT.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService.2
 * JD-Core Version:    0.7.0.1
 */