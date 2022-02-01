package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(14)
final class zzid
  implements Application.ActivityLifecycleCallbacks
{
  private zzid(zzhk paramzzhk) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(1758);
    for (;;)
    {
      try
      {
        this.zzanw.zzge().zzit().log("onActivityCreated");
        localObject = paramActivity.getIntent();
        if (localObject == null) {
          continue;
        }
        Uri localUri = ((Intent)localObject).getData();
        if ((localUri == null) || (!localUri.isHierarchical())) {
          continue;
        }
        if (paramBundle == null)
        {
          Bundle localBundle = this.zzanw.zzgb().zza(localUri);
          this.zzanw.zzgb();
          if (!zzka.zzd((Intent)localObject)) {
            continue;
          }
          localObject = "gs";
          if (localBundle != null) {
            this.zzanw.logEvent((String)localObject, "_cmp", localBundle);
          }
        }
        localObject = localUri.getQueryParameter("referrer");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool)
        {
          AppMethodBeat.o(1758);
          return;
          localObject = "auto";
          continue;
        }
        if (!((String)localObject).contains("gclid")) {
          continue;
        }
        if ((((String)localObject).contains("utm_campaign")) || (((String)localObject).contains("utm_source")) || (((String)localObject).contains("utm_medium")) || (((String)localObject).contains("utm_term"))) {
          continue;
        }
        if (!((String)localObject).contains("utm_content")) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        this.zzanw.zzge().zzim().zzg("Throwable caught in onActivityCreated", localException);
        continue;
        int i = 1;
        continue;
      }
      if (i != 0) {
        continue;
      }
      this.zzanw.zzge().zzis().log("Activity created with data 'referrer' param without gclid and at least one utm field");
      AppMethodBeat.o(1758);
      return;
      i = 0;
    }
    this.zzanw.zzge().zzis().zzg("Activity created with referrer", localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.zzanw.setUserProperty("auto", "_ldl", localObject);
    }
    this.zzanw.zzfy().onActivityCreated(paramActivity, paramBundle);
    AppMethodBeat.o(1758);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(1759);
    this.zzanw.zzfy().onActivityDestroyed(paramActivity);
    AppMethodBeat.o(1759);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(1760);
    this.zzanw.zzfy().onActivityPaused(paramActivity);
    paramActivity = this.zzanw.zzgc();
    long l = paramActivity.zzbt().elapsedRealtime();
    paramActivity.zzgd().zzc(new zzjl(paramActivity, l));
    AppMethodBeat.o(1760);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(1761);
    this.zzanw.zzfy().onActivityResumed(paramActivity);
    paramActivity = this.zzanw.zzgc();
    long l = paramActivity.zzbt().elapsedRealtime();
    paramActivity.zzgd().zzc(new zzjk(paramActivity, l));
    AppMethodBeat.o(1761);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(1762);
    this.zzanw.zzfy().onActivitySaveInstanceState(paramActivity, paramBundle);
    AppMethodBeat.o(1762);
  }
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzid
 * JD-Core Version:    0.7.0.1
 */