package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzgb
{
  private final zzge zzala;
  
  public zzgb(zzge paramzzge)
  {
    AppMethodBeat.i(68981);
    Preconditions.checkNotNull(paramzzge);
    this.zzala = paramzzge;
    AppMethodBeat.o(68981);
  }
  
  public static boolean zza(Context paramContext)
  {
    AppMethodBeat.i(68982);
    Preconditions.checkNotNull(paramContext);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null)
      {
        AppMethodBeat.o(68982);
        return false;
      }
      paramContext = localPackageManager.getReceiverInfo(new ComponentName(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
      if (paramContext != null)
      {
        boolean bool = paramContext.enabled;
        if (bool)
        {
          AppMethodBeat.o(68982);
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(68982);
    }
    return false;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(68983);
    zzgl localzzgl = zzgl.zzg(paramContext);
    zzfg localzzfg = localzzgl.zzge();
    if (paramIntent == null)
    {
      localzzfg.zzip().log("Receiver called with null intent");
      AppMethodBeat.o(68983);
      return;
    }
    String str1 = paramIntent.getAction();
    localzzfg.zzit().zzg("Local receiver got", str1);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str1))
    {
      paramIntent = new Intent().setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
      paramIntent.setAction("com.google.android.gms.measurement.UPLOAD");
      localzzfg.zzit().log("Starting wakeful intent.");
      this.zzala.doStartService(paramContext, paramIntent);
      AppMethodBeat.o(68983);
      return;
    }
    if ("com.android.vending.INSTALL_REFERRER".equals(str1)) {
      try
      {
        localzzgl.zzgd().zzc(new zzgc(this, localzzgl, localzzfg));
        localPendingResult = this.zzala.doGoAsync();
        str2 = paramIntent.getStringExtra("referrer");
        if (str2 == null)
        {
          localzzfg.zzit().log("Install referrer extras are null");
          if (localPendingResult != null) {
            localPendingResult.finish();
          }
          AppMethodBeat.o(68983);
          return;
        }
      }
      catch (Exception localException)
      {
        BroadcastReceiver.PendingResult localPendingResult;
        String str2;
        for (;;)
        {
          localzzfg.zzip().zzg("Install Referrer Reporter encountered a problem", localException);
        }
        localzzfg.zzir().zzg("Install referrer extras are", str2);
        Object localObject = str2;
        if (!str2.contains("?"))
        {
          localObject = String.valueOf(str2);
          if (((String)localObject).length() == 0) {
            break label311;
          }
        }
        label311:
        for (localObject = "?".concat((String)localObject);; localObject = new String("?"))
        {
          localObject = Uri.parse((String)localObject);
          localObject = localzzgl.zzgb().zza((Uri)localObject);
          if (localObject != null) {
            break;
          }
          localzzfg.zzit().log("No campaign defined in install referrer broadcast");
          if (localPendingResult == null) {
            break label379;
          }
          localPendingResult.finish();
          AppMethodBeat.o(68983);
          return;
        }
        long l = 1000L * paramIntent.getLongExtra("referrer_timestamp_seconds", 0L);
        if (l == 0L) {
          localzzfg.zzip().log("Install referrer is missing timestamp");
        }
        localzzgl.zzgd().zzc(new zzgd(this, localzzgl, l, (Bundle)localObject, paramContext, localzzfg, localPendingResult));
      }
    }
    label379:
    AppMethodBeat.o(68983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgb
 * JD-Core Version:    0.7.0.1
 */