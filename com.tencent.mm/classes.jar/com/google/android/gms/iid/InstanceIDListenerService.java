package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class InstanceIDListenerService
  extends zze
{
  static void zzd(Context paramContext, zzak paramzzak)
  {
    AppMethodBeat.i(2474);
    paramzzak.zzx();
    paramzzak = new Intent("com.google.android.gms.iid.InstanceID");
    paramzzak.putExtra("CMD", "RST");
    paramzzak.setClassName(paramContext, "com.google.android.gms.gcm.GcmReceiver");
    paramContext.sendBroadcast(paramzzak);
    AppMethodBeat.o(2474);
  }
  
  public void handleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(2473);
    if (!"com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))
    {
      AppMethodBeat.o(2473);
      return;
    }
    Object localObject = null;
    String str = paramIntent.getStringExtra("subtype");
    if (str != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("subtype", str);
    }
    localObject = InstanceID.getInstance(this, (Bundle)localObject);
    paramIntent = paramIntent.getStringExtra("CMD");
    if (Log.isLoggable("InstanceID", 3)) {
      new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(paramIntent).length()).append("Service command. subtype:").append(str).append(" command:").append(paramIntent);
    }
    if ("RST".equals(paramIntent))
    {
      ((InstanceID)localObject).zzm();
      onTokenRefresh();
      AppMethodBeat.o(2473);
      return;
    }
    if ("RST_FULL".equals(paramIntent))
    {
      if (!InstanceID.zzn().isEmpty())
      {
        InstanceID.zzn().zzx();
        onTokenRefresh();
        AppMethodBeat.o(2473);
      }
    }
    else if ("SYNC".equals(paramIntent))
    {
      InstanceID.zzn().zzi(String.valueOf(str).concat("|T|"));
      onTokenRefresh();
    }
    AppMethodBeat.o(2473);
  }
  
  public void onTokenRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService
 * JD-Core Version:    0.7.0.1
 */