package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.e.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class zzif
  extends zzhh
{
  @VisibleForTesting
  protected zzie zzaol;
  private volatile zzie zzaom;
  private zzie zzaon;
  private long zzaoo;
  private final Map<Activity, zzie> zzaop;
  private zzie zzaoq;
  private String zzaor;
  
  public zzif(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(1763);
    this.zzaop = new a();
    AppMethodBeat.o(1763);
  }
  
  private final void zza(Activity paramActivity, zzie paramzzie, boolean paramBoolean)
  {
    AppMethodBeat.i(1766);
    if (this.zzaom == null) {}
    for (zzie localzzie1 = this.zzaon;; localzzie1 = this.zzaom)
    {
      zzie localzzie2 = paramzzie;
      if (paramzzie.zzaoi == null) {
        localzzie2 = new zzie(paramzzie.zzul, zzca(paramActivity.getClass().getCanonicalName()), paramzzie.zzaoj);
      }
      this.zzaon = this.zzaom;
      this.zzaoo = zzbt().elapsedRealtime();
      this.zzaom = localzzie2;
      zzgd().zzc(new zzig(this, paramBoolean, localzzie1, localzzie2));
      AppMethodBeat.o(1766);
      return;
    }
  }
  
  private final void zza(zzie paramzzie)
  {
    AppMethodBeat.i(1767);
    zzft().zzk(zzbt().elapsedRealtime());
    if (zzgc().zzl(paramzzie.zzaok)) {
      paramzzie.zzaok = false;
    }
    AppMethodBeat.o(1767);
  }
  
  public static void zza(zzie paramzzie, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(1768);
    if ((paramBundle != null) && (paramzzie != null) && ((!paramBundle.containsKey("_sc")) || (paramBoolean)))
    {
      if (paramzzie.zzul != null) {
        paramBundle.putString("_sn", paramzzie.zzul);
      }
      for (;;)
      {
        paramBundle.putString("_sc", paramzzie.zzaoi);
        paramBundle.putLong("_si", paramzzie.zzaoj);
        AppMethodBeat.o(1768);
        return;
        paramBundle.remove("_sn");
      }
    }
    if ((paramBundle != null) && (paramzzie == null) && (paramBoolean))
    {
      paramBundle.remove("_sn");
      paramBundle.remove("_sc");
      paramBundle.remove("_si");
    }
    AppMethodBeat.o(1768);
  }
  
  @VisibleForTesting
  private static String zzca(String paramString)
  {
    AppMethodBeat.i(1770);
    paramString = paramString.split("\\.");
    if (paramString.length > 0) {}
    for (paramString = paramString[(paramString.length - 1)]; paramString.length() > 100; paramString = "")
    {
      paramString = paramString.substring(0, 100);
      AppMethodBeat.o(1770);
      return paramString;
    }
    AppMethodBeat.o(1770);
    return paramString;
  }
  
  private final zzie zze(Activity paramActivity)
  {
    AppMethodBeat.i(1771);
    Preconditions.checkNotNull(paramActivity);
    zzie localzzie2 = (zzie)this.zzaop.get(paramActivity);
    zzie localzzie1 = localzzie2;
    if (localzzie2 == null)
    {
      localzzie1 = new zzie(null, zzca(paramActivity.getClass().getCanonicalName()), zzgb().zzlb());
      this.zzaop.put(paramActivity, localzzie1);
    }
    AppMethodBeat.o(1771);
    return localzzie1;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(1772);
    if (paramBundle == null)
    {
      AppMethodBeat.o(1772);
      return;
    }
    paramBundle = paramBundle.getBundle("com.google.firebase.analytics.screen_service");
    if (paramBundle == null)
    {
      AppMethodBeat.o(1772);
      return;
    }
    paramBundle = new zzie(paramBundle.getString("name"), paramBundle.getString("referrer_name"), paramBundle.getLong("id"));
    this.zzaop.put(paramActivity, paramBundle);
    AppMethodBeat.o(1772);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(1776);
    this.zzaop.remove(paramActivity);
    AppMethodBeat.o(1776);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(1774);
    paramActivity = zze(paramActivity);
    this.zzaon = this.zzaom;
    this.zzaoo = zzbt().elapsedRealtime();
    this.zzaom = null;
    zzgd().zzc(new zzih(this, paramActivity));
    AppMethodBeat.o(1774);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(1773);
    zza(paramActivity, zze(paramActivity), false);
    paramActivity = zzft();
    long l = paramActivity.zzbt().elapsedRealtime();
    paramActivity.zzgd().zzc(new zzdx(paramActivity, l));
    AppMethodBeat.o(1773);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(1775);
    if (paramBundle == null)
    {
      AppMethodBeat.o(1775);
      return;
    }
    paramActivity = (zzie)this.zzaop.get(paramActivity);
    if (paramActivity == null)
    {
      AppMethodBeat.o(1775);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("id", paramActivity.zzaoj);
    localBundle.putString("name", paramActivity.zzul);
    localBundle.putString("referrer_name", paramActivity.zzaoi);
    paramBundle.putBundle("com.google.firebase.analytics.screen_service", localBundle);
    AppMethodBeat.o(1775);
  }
  
  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(1765);
    zzgd();
    if (!zzgg.isMainThread())
    {
      zzge().zzip().log("setCurrentScreen must be called from the main thread");
      AppMethodBeat.o(1765);
      return;
    }
    if (this.zzaom == null)
    {
      zzge().zzip().log("setCurrentScreen cannot be called while no activity active");
      AppMethodBeat.o(1765);
      return;
    }
    if (this.zzaop.get(paramActivity) == null)
    {
      zzge().zzip().log("setCurrentScreen must be called with an activity in the activity lifecycle");
      AppMethodBeat.o(1765);
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = zzca(paramActivity.getClass().getCanonicalName());
    }
    boolean bool1 = this.zzaom.zzaoi.equals(str);
    boolean bool2 = zzka.zzs(this.zzaom.zzul, paramString1);
    if ((bool1) && (bool2))
    {
      zzge().zziq().log("setCurrentScreen cannot be called with the same class and name");
      AppMethodBeat.o(1765);
      return;
    }
    if ((paramString1 != null) && ((paramString1.length() <= 0) || (paramString1.length() > 100)))
    {
      zzge().zzip().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(paramString1.length()));
      AppMethodBeat.o(1765);
      return;
    }
    if ((str != null) && ((str.length() <= 0) || (str.length() > 100)))
    {
      zzge().zzip().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
      AppMethodBeat.o(1765);
      return;
    }
    zzfi localzzfi = zzge().zzit();
    if (paramString1 == null) {}
    for (paramString2 = "null";; paramString2 = paramString1)
    {
      localzzfi.zze("Setting current screen to name, class", paramString2, str);
      paramString1 = new zzie(paramString1, str, zzgb().zzlb());
      this.zzaop.put(paramActivity, paramString1);
      zza(paramActivity, paramString1, true);
      AppMethodBeat.o(1765);
      return;
    }
  }
  
  public final void zza(String paramString, zzie paramzzie)
  {
    AppMethodBeat.i(1769);
    zzab();
    try
    {
      if ((this.zzaor == null) || (this.zzaor.equals(paramString)) || (paramzzie != null))
      {
        this.zzaor = paramString;
        this.zzaoq = paramzzie;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(1769);
    }
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  public final zzie zzkc()
  {
    AppMethodBeat.i(1764);
    zzch();
    zzab();
    zzie localzzie = this.zzaol;
    AppMethodBeat.o(1764);
    return localzzie;
  }
  
  public final zzie zzkd()
  {
    return this.zzaom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzif
 * JD-Core Version:    0.7.0.1
 */