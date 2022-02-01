package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm
  implements zzn
{
  private final PendingIntent zzat;
  private final Context zzk;
  
  zzm(Context paramContext)
  {
    AppMethodBeat.i(3713);
    this.zzk = paramContext;
    this.zzat = PendingIntent.getBroadcast(paramContext, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
    AppMethodBeat.o(3713);
  }
  
  private final Intent zzh(String paramString)
  {
    AppMethodBeat.i(3717);
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("app", this.zzat);
    localIntent.putExtra("source", 4);
    localIntent.putExtra("source_version", 12451000);
    localIntent.putExtra("scheduler_action", paramString);
    AppMethodBeat.o(3717);
    return localIntent;
  }
  
  public final boolean zzd(ComponentName paramComponentName)
  {
    AppMethodBeat.i(3716);
    Intent localIntent = zzh("CANCEL_ALL");
    localIntent.putExtra("component", paramComponentName);
    this.zzk.sendBroadcast(localIntent);
    AppMethodBeat.o(3716);
    return true;
  }
  
  public final boolean zzd(ComponentName paramComponentName, String paramString)
  {
    AppMethodBeat.i(3715);
    Intent localIntent = zzh("CANCEL_TASK");
    localIntent.putExtra("component", paramComponentName);
    localIntent.putExtra("tag", paramString);
    this.zzk.sendBroadcast(localIntent);
    AppMethodBeat.o(3715);
    return true;
  }
  
  public final boolean zzd(Task paramTask)
  {
    AppMethodBeat.i(3714);
    Intent localIntent = zzh("SCHEDULE_TASK");
    Bundle localBundle = new Bundle();
    paramTask.toBundle(localBundle);
    localIntent.putExtras(localBundle);
    this.zzk.sendBroadcast(localIntent);
    AppMethodBeat.o(3714);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.gcm.zzm
 * JD-Core Version:    0.7.0.1
 */