package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzfx
{
  private final zzgl zzacw;
  @VisibleForTesting
  volatile zzr zzakw;
  @VisibleForTesting
  private ServiceConnection zzakx;
  
  zzfx(zzgl paramzzgl)
  {
    this.zzacw = paramzzgl;
  }
  
  @VisibleForTesting
  private final boolean zzji()
  {
    AppMethodBeat.i(68975);
    try
    {
      PackageManagerWrapper localPackageManagerWrapper = Wrappers.packageManager(this.zzacw.getContext());
      if (localPackageManagerWrapper == null)
      {
        this.zzacw.zzge().zzir().log("Failed to retrieve Package Manager to check Play Store compatibility");
        AppMethodBeat.o(68975);
        return false;
      }
      if (localPackageManagerWrapper.getPackageInfo("com.android.vending", 128).versionCode >= 80837300)
      {
        AppMethodBeat.o(68975);
        return true;
      }
      AppMethodBeat.o(68975);
      return false;
    }
    catch (Exception localException)
    {
      this.zzacw.zzge().zzir().zzg("Failed to retrieve Play Store version", localException);
      AppMethodBeat.o(68975);
    }
    return false;
  }
  
  @VisibleForTesting
  final void zzc(Bundle paramBundle)
  {
    AppMethodBeat.i(68977);
    this.zzacw.zzab();
    if (paramBundle == null)
    {
      AppMethodBeat.o(68977);
      return;
    }
    long l1 = paramBundle.getLong("install_begin_timestamp_seconds", 0L) * 1000L;
    if (l1 == 0L)
    {
      this.zzacw.zzge().zzim().log("Service response is missing Install Referrer install timestamp");
      AppMethodBeat.o(68977);
      return;
    }
    Object localObject1 = paramBundle.getString("install_referrer");
    if ((localObject1 == null) || (((String)localObject1).isEmpty()))
    {
      this.zzacw.zzge().zzim().log("No referrer defined in install referrer response");
      AppMethodBeat.o(68977);
      return;
    }
    this.zzacw.zzge().zzit().zzg("InstallReferrer API result", localObject1);
    Object localObject2 = this.zzacw.zzgb();
    localObject1 = String.valueOf(localObject1);
    if (((String)localObject1).length() != 0) {}
    for (localObject1 = "?".concat((String)localObject1);; localObject1 = new String("?"))
    {
      localObject1 = ((zzka)localObject2).zza(Uri.parse((String)localObject1));
      if (localObject1 != null) {
        break;
      }
      this.zzacw.zzge().zzim().log("No campaign params defined in install referrer result");
      AppMethodBeat.o(68977);
      return;
    }
    localObject2 = ((Bundle)localObject1).getString("medium");
    int i;
    if ((localObject2 != null) && (!"(not set)".equalsIgnoreCase((String)localObject2)) && (!"organic".equalsIgnoreCase((String)localObject2))) {
      i = 1;
    }
    while (i != 0)
    {
      long l2 = paramBundle.getLong("referrer_click_timestamp_seconds", 0L) * 1000L;
      if (l2 == 0L)
      {
        this.zzacw.zzge().zzim().log("Install Referrer is missing click timestamp for ad campaign");
        AppMethodBeat.o(68977);
        return;
        i = 0;
      }
      else
      {
        ((Bundle)localObject1).putLong("click_timestamp", l2);
      }
    }
    if (l1 == this.zzacw.zzgf().zzaka.get())
    {
      this.zzacw.zzge().zzit().log("Campaign has already been logged");
      AppMethodBeat.o(68977);
      return;
    }
    ((Bundle)localObject1).putString("_cis", "referrer API");
    this.zzacw.zzgf().zzaka.set(l1);
    this.zzacw.zzfu().logEvent("auto", "_cmp", (Bundle)localObject1);
    if (this.zzakx != null) {
      ConnectionTracker.getInstance().unbindService(this.zzacw.getContext(), this.zzakx);
    }
    AppMethodBeat.o(68977);
  }
  
  protected final void zzjh()
  {
    AppMethodBeat.i(68974);
    this.zzacw.zzab();
    if (!zzji())
    {
      this.zzacw.zzge().zzir().log("Install Referrer Reporter is not available");
      this.zzakx = null;
      AppMethodBeat.o(68974);
      return;
    }
    this.zzakx = new zzfz(this, null);
    this.zzacw.zzge().zzir().log("Install Referrer Reporter is initializing");
    this.zzacw.zzab();
    Object localObject1 = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
    ((Intent)localObject1).setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
    Object localObject2 = this.zzacw.getContext().getPackageManager();
    if (localObject2 == null)
    {
      this.zzacw.zzge().zzip().log("Failed to obtain Package Manager to verify binding conditions");
      AppMethodBeat.o(68974);
      return;
    }
    localObject2 = ((PackageManager)localObject2).queryIntentServices((Intent)localObject1, 0);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = (ResolveInfo)((List)localObject2).get(0);
      if (((ResolveInfo)localObject2).serviceInfo != null)
      {
        String str = ((ResolveInfo)localObject2).serviceInfo.packageName;
        if ((((ResolveInfo)localObject2).serviceInfo.name != null) && (this.zzakx != null) && ("com.android.vending".equals(str)) && (zzji()))
        {
          localObject1 = new Intent((Intent)localObject1);
          try
          {
            boolean bool = ConnectionTracker.getInstance().bindService(this.zzacw.getContext(), (Intent)localObject1, this.zzakx, 1);
            localObject2 = this.zzacw.zzge().zzir();
            if (bool) {}
            for (localObject1 = "available";; localObject1 = "not available")
            {
              ((zzfi)localObject2).zzg("Install Referrer Service is", localObject1);
              AppMethodBeat.o(68974);
              return;
            }
            this.zzacw.zzge().zzir().log("Play Store missing or incompatible. Version 8.3.73 or later required");
          }
          catch (Exception localException)
          {
            this.zzacw.zzge().zzim().zzg("Exception occurred while binding to Install Referrer Service", localException.getMessage());
            AppMethodBeat.o(68974);
            return;
          }
        }
      }
      AppMethodBeat.o(68974);
      return;
    }
    this.zzacw.zzge().zzir().log("Play Service for fetching Install Referrer is unavailable on device");
    AppMethodBeat.o(68974);
  }
  
  @VisibleForTesting
  final Bundle zzjj()
  {
    AppMethodBeat.i(68976);
    this.zzacw.zzab();
    if (this.zzakw == null)
    {
      this.zzacw.zzge().zzip().log("Attempting to use Install Referrer Service while it is not initialized");
      AppMethodBeat.o(68976);
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("package_name", this.zzacw.getContext().getPackageName());
    try
    {
      localBundle = this.zzakw.zza(localBundle);
      if (localBundle == null)
      {
        this.zzacw.zzge().zzim().log("Install Referrer Service returned a null response");
        AppMethodBeat.o(68976);
        return null;
      }
    }
    catch (Exception localException)
    {
      this.zzacw.zzge().zzim().zzg("Exception occurred while retrieving the Install Referrer", localException.getMessage());
      AppMethodBeat.o(68976);
      return null;
    }
    AppMethodBeat.o(68976);
    return localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfx
 * JD-Core Version:    0.7.0.1
 */