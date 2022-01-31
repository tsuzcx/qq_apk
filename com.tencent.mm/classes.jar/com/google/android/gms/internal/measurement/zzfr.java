package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzfr
  extends zzhh
{
  @VisibleForTesting
  static final Pair<String, Long> zzajs;
  private SharedPreferences zzabf;
  public zzfv zzajt;
  public final zzfu zzaju;
  public final zzfu zzajv;
  public final zzfu zzajw;
  public final zzfu zzajx;
  public final zzfu zzajy;
  public final zzfu zzajz;
  public final zzfu zzaka;
  public final zzfw zzakb;
  private String zzakc;
  private boolean zzakd;
  private long zzake;
  private String zzakf;
  private long zzakg;
  private final Object zzakh;
  public final zzfu zzaki;
  public final zzfu zzakj;
  public final zzft zzakk;
  public final zzfu zzakl;
  public final zzfu zzakm;
  public boolean zzakn;
  
  static
  {
    AppMethodBeat.i(68959);
    zzajs = new Pair("", Long.valueOf(0L));
    AppMethodBeat.o(68959);
  }
  
  zzfr(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(68942);
    this.zzaju = new zzfu(this, "last_upload", 0L);
    this.zzajv = new zzfu(this, "last_upload_attempt", 0L);
    this.zzajw = new zzfu(this, "backoff", 0L);
    this.zzajx = new zzfu(this, "last_delete_stale", 0L);
    this.zzaki = new zzfu(this, "time_before_start", 10000L);
    this.zzakj = new zzfu(this, "session_timeout", 1800000L);
    this.zzakk = new zzft(this, "start_new_session", true);
    this.zzakl = new zzfu(this, "last_pause_time", 0L);
    this.zzakm = new zzfu(this, "time_active", 0L);
    this.zzajy = new zzfu(this, "midnight_offset", 0L);
    this.zzajz = new zzfu(this, "first_open_time", 0L);
    this.zzaka = new zzfu(this, "app_install_time", 0L);
    this.zzakb = new zzfw(this, "app_instance_id", null);
    this.zzakh = new Object();
    AppMethodBeat.o(68942);
  }
  
  private final SharedPreferences zziy()
  {
    AppMethodBeat.i(68944);
    zzab();
    zzch();
    SharedPreferences localSharedPreferences = this.zzabf;
    AppMethodBeat.o(68944);
    return localSharedPreferences;
  }
  
  final void setMeasurementEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(68952);
    zzab();
    zzge().zzit().zzg("Setting measurementEnabled", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zziy().edit();
    localEditor.putBoolean("measurement_enabled", paramBoolean);
    localEditor.apply();
    AppMethodBeat.o(68952);
  }
  
  final Pair<String, Boolean> zzbo(String paramString)
  {
    AppMethodBeat.i(68940);
    zzab();
    long l = zzbt().elapsedRealtime();
    if ((this.zzakc != null) && (l < this.zzake))
    {
      paramString = new Pair(this.zzakc, Boolean.valueOf(this.zzakd));
      AppMethodBeat.o(68940);
      return paramString;
    }
    this.zzake = (l + zzgg().zza(paramString, zzew.zzagj));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      if (paramString != null)
      {
        this.zzakc = paramString.getId();
        this.zzakd = paramString.isLimitAdTrackingEnabled();
      }
      if (this.zzakc == null) {
        this.zzakc = "";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        zzge().zzis().zzg("Unable to get advertising id", paramString);
        this.zzakc = "";
      }
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    paramString = new Pair(this.zzakc, Boolean.valueOf(this.zzakd));
    AppMethodBeat.o(68940);
    return paramString;
  }
  
  final String zzbp(String paramString)
  {
    AppMethodBeat.i(68941);
    zzab();
    paramString = (String)zzbo(paramString).first;
    MessageDigest localMessageDigest = zzka.getMessageDigest("MD5");
    if (localMessageDigest == null)
    {
      AppMethodBeat.o(68941);
      return null;
    }
    paramString = String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
    AppMethodBeat.o(68941);
    return paramString;
  }
  
  final void zzbq(String paramString)
  {
    AppMethodBeat.i(68945);
    zzab();
    SharedPreferences.Editor localEditor = zziy().edit();
    localEditor.putString("gmp_app_id", paramString);
    localEditor.apply();
    AppMethodBeat.o(68945);
  }
  
  final void zzbr(String paramString)
  {
    AppMethodBeat.i(68947);
    synchronized (this.zzakh)
    {
      this.zzakf = paramString;
      this.zzakg = zzbt().elapsedRealtime();
      AppMethodBeat.o(68947);
      return;
    }
  }
  
  final void zzf(boolean paramBoolean)
  {
    AppMethodBeat.i(68950);
    zzab();
    zzge().zzit().zzg("Setting useService", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zziy().edit();
    localEditor.putBoolean("use_service", paramBoolean);
    localEditor.apply();
    AppMethodBeat.o(68950);
  }
  
  final boolean zzg(boolean paramBoolean)
  {
    AppMethodBeat.i(68953);
    zzab();
    paramBoolean = zziy().getBoolean("measurement_enabled", paramBoolean);
    AppMethodBeat.o(68953);
    return paramBoolean;
  }
  
  final void zzh(boolean paramBoolean)
  {
    AppMethodBeat.i(68955);
    zzab();
    zzge().zzit().zzg("Updating deferred analytics collection", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zziy().edit();
    localEditor.putBoolean("deferred_analytics_collection", paramBoolean);
    localEditor.apply();
    AppMethodBeat.o(68955);
  }
  
  protected final boolean zzhf()
  {
    return true;
  }
  
  protected final void zzih()
  {
    AppMethodBeat.i(68943);
    this.zzabf = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    this.zzakn = this.zzabf.getBoolean("has_been_opened", false);
    if (!this.zzakn)
    {
      SharedPreferences.Editor localEditor = this.zzabf.edit();
      localEditor.putBoolean("has_been_opened", true);
      localEditor.apply();
    }
    this.zzajt = new zzfv(this, "health_monitor", Math.max(0L, ((Long)zzew.zzagk.get()).longValue()), null);
    AppMethodBeat.o(68943);
  }
  
  final String zziz()
  {
    AppMethodBeat.i(68946);
    zzab();
    String str = zziy().getString("gmp_app_id", null);
    AppMethodBeat.o(68946);
    return str;
  }
  
  final String zzja()
  {
    AppMethodBeat.i(68948);
    synchronized (this.zzakh)
    {
      if (Math.abs(zzbt().elapsedRealtime() - this.zzakg) < 1000L)
      {
        String str = this.zzakf;
        AppMethodBeat.o(68948);
        return str;
      }
      AppMethodBeat.o(68948);
      return null;
    }
  }
  
  final Boolean zzjb()
  {
    AppMethodBeat.i(68949);
    zzab();
    if (!zziy().contains("use_service"))
    {
      AppMethodBeat.o(68949);
      return null;
    }
    boolean bool = zziy().getBoolean("use_service", false);
    AppMethodBeat.o(68949);
    return Boolean.valueOf(bool);
  }
  
  final void zzjc()
  {
    boolean bool1 = true;
    AppMethodBeat.i(68951);
    zzab();
    zzge().zzit().log("Clearing collection preferences.");
    boolean bool2 = zziy().contains("measurement_enabled");
    if (bool2) {
      bool1 = zzg(true);
    }
    SharedPreferences.Editor localEditor = zziy().edit();
    localEditor.clear();
    localEditor.apply();
    if (bool2) {
      setMeasurementEnabled(bool1);
    }
    AppMethodBeat.o(68951);
  }
  
  protected final String zzjd()
  {
    AppMethodBeat.i(68954);
    zzab();
    String str1 = zziy().getString("previous_os_version", null);
    zzfw().zzch();
    String str2 = Build.VERSION.RELEASE;
    if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1)))
    {
      SharedPreferences.Editor localEditor = zziy().edit();
      localEditor.putString("previous_os_version", str2);
      localEditor.apply();
    }
    AppMethodBeat.o(68954);
    return str1;
  }
  
  final boolean zzje()
  {
    AppMethodBeat.i(68956);
    zzab();
    boolean bool = zziy().getBoolean("deferred_analytics_collection", false);
    AppMethodBeat.o(68956);
    return bool;
  }
  
  final boolean zzjf()
  {
    AppMethodBeat.i(68957);
    boolean bool = this.zzabf.contains("deferred_analytics_collection");
    AppMethodBeat.o(68957);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfr
 * JD-Core Version:    0.7.0.1
 */