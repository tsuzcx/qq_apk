package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zztb;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zztl;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.internal.zztn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Tracker
  extends zzsa
{
  private final Map<String, String> zzFP = new HashMap();
  private boolean zzacs;
  private final Map<String, String> zzact = new HashMap();
  private final zztb zzacu;
  private final Tracker.zza zzacv;
  private ExceptionReporter zzacw;
  private zztl zzacx;
  
  Tracker(zzsc paramzzsc, String paramString, zztb paramzztb)
  {
    super(paramzzsc);
    if (paramString != null) {
      this.zzFP.put("&tid", paramString);
    }
    this.zzFP.put("useSecure", "1");
    this.zzFP.put("&a", Integer.toString(new Random().nextInt(2147483647) + 1));
    if (paramzztb == null) {}
    for (this.zzacu = new zztb("tracking", zznR());; this.zzacu = paramzztb)
    {
      this.zzacv = new Tracker.zza(this, paramzzsc);
      return;
    }
  }
  
  private static boolean zza(Map.Entry<String, String> paramEntry)
  {
    String str = (String)paramEntry.getKey();
    paramEntry.getValue();
    return (str.startsWith("&")) && (str.length() >= 2);
  }
  
  private static String zzb(Map.Entry<String, String> paramEntry)
  {
    if (!zza(paramEntry)) {
      return null;
    }
    return ((String)paramEntry.getKey()).substring(1);
  }
  
  private static void zzb(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzac.zzw(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        String str = zzb(localEntry);
        if (str != null) {
          paramMap2.put(str, (String)localEntry.getValue());
        }
      }
    }
  }
  
  private static void zzc(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzac.zzw(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        String str = zzb(localEntry);
        if ((str != null) && (!paramMap2.containsKey(str))) {
          paramMap2.put(str, (String)localEntry.getValue());
        }
      }
    }
  }
  
  private boolean zzmT()
  {
    return this.zzacw != null;
  }
  
  static String zzq(Activity paramActivity)
  {
    zzac.zzw(paramActivity);
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {}
    do
    {
      return null;
      paramActivity = paramActivity.getStringExtra("android.intent.extra.REFERRER_NAME");
    } while (TextUtils.isEmpty(paramActivity));
    return paramActivity;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.zzacs = paramBoolean;
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.zzacv.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (zzmT() == paramBoolean) {
          return;
        }
        if (paramBoolean)
        {
          Context localContext = getContext();
          this.zzacw = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), localContext);
          Thread.setDefaultUncaughtExceptionHandler(this.zzacw);
          zzbP("Uncaught exceptions will be reported to Google Analytics");
          return;
        }
      }
      finally {}
      Thread.setDefaultUncaughtExceptionHandler(this.zzacw.zzmv());
      zzbP("Uncaught exceptions will not be reported to Google Analytics");
    }
  }
  
  public String get(String paramString)
  {
    zzob();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.zzFP.containsKey(paramString)) {
        return (String)this.zzFP.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return zztm.zza(Locale.getDefault());
      }
      if (paramString.equals("&cid")) {
        return zznX().zzoQ();
      }
      if (paramString.equals("&sr")) {
        return zzoa().zzpC();
      }
      if (paramString.equals("&aid")) {
        return zznZ().zzoy().zzke();
      }
      if (paramString.equals("&an")) {
        return zznZ().zzoy().zzmY();
      }
      if (paramString.equals("&av")) {
        return zznZ().zzoy().zzmZ();
      }
    } while (!paramString.equals("&aiid"));
    return zznZ().zzoy().zzna();
  }
  
  public void send(Map<String, String> paramMap)
  {
    long l = zznR().currentTimeMillis();
    if (zzmu().getAppOptOut())
    {
      zzbQ("AppOptOut is set to true. Not sending Google Analytics hit");
      return;
    }
    boolean bool1 = zzmu().isDryRunEnabled();
    HashMap localHashMap = new HashMap();
    zzb(this.zzFP, localHashMap);
    zzb(paramMap, localHashMap);
    boolean bool2 = zztm.zzg((String)this.zzFP.get("useSecure"), true);
    zzc(this.zzact, localHashMap);
    this.zzact.clear();
    paramMap = (String)localHashMap.get("t");
    if (TextUtils.isEmpty(paramMap))
    {
      zznS().zzg(localHashMap, "Missing hit type parameter");
      return;
    }
    String str = (String)localHashMap.get("tid");
    if (TextUtils.isEmpty(str))
    {
      zznS().zzg(localHashMap, "Missing tracking id parameter");
      return;
    }
    boolean bool3 = zzmU();
    try
    {
      if (("screenview".equalsIgnoreCase(paramMap)) || ("pageview".equalsIgnoreCase(paramMap)) || ("appview".equalsIgnoreCase(paramMap)) || (TextUtils.isEmpty(paramMap)))
      {
        int j = Integer.parseInt((String)this.zzFP.get("&a")) + 1;
        int i = j;
        if (j >= 2147483647) {
          i = 1;
        }
        this.zzFP.put("&a", Integer.toString(i));
      }
      zznU().zzg(new Tracker.1(this, localHashMap, bool3, paramMap, l, bool1, bool2, str));
      return;
    }
    finally {}
  }
  
  public void set(String paramString1, String paramString2)
  {
    zzac.zzb(paramString1, "Key should be non-null");
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.zzFP.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", zztm.zzX(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setCampaignParamsOnNextHit(Uri paramUri)
  {
    if ((paramUri == null) || (paramUri.isOpaque())) {}
    do
    {
      return;
      paramUri = paramUri.getQueryParameter("referrer");
    } while (TextUtils.isEmpty(paramUri));
    paramUri = String.valueOf(paramUri);
    if (paramUri.length() != 0) {}
    for (paramUri = "http://hostname/?".concat(paramUri);; paramUri = new String("http://hostname/?"))
    {
      paramUri = Uri.parse(paramUri);
      String str = paramUri.getQueryParameter("utm_id");
      if (str != null) {
        this.zzact.put("&ci", str);
      }
      str = paramUri.getQueryParameter("anid");
      if (str != null) {
        this.zzact.put("&anid", str);
      }
      str = paramUri.getQueryParameter("utm_campaign");
      if (str != null) {
        this.zzact.put("&cn", str);
      }
      str = paramUri.getQueryParameter("utm_content");
      if (str != null) {
        this.zzact.put("&cc", str);
      }
      str = paramUri.getQueryParameter("utm_medium");
      if (str != null) {
        this.zzact.put("&cm", str);
      }
      str = paramUri.getQueryParameter("utm_source");
      if (str != null) {
        this.zzact.put("&cs", str);
      }
      str = paramUri.getQueryParameter("utm_term");
      if (str != null) {
        this.zzact.put("&ck", str);
      }
      str = paramUri.getQueryParameter("dclid");
      if (str != null) {
        this.zzact.put("&dclid", str);
      }
      str = paramUri.getQueryParameter("gclid");
      if (str != null) {
        this.zzact.put("&gclid", str);
      }
      paramUri = paramUri.getQueryParameter("aclid");
      if (paramUri == null) {
        break;
      }
      this.zzact.put("&aclid", paramUri);
      return;
    }
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0))
    {
      zzbS("Invalid width or height. The values should be non-negative.");
      return;
    }
    set("&sr", 23 + paramInt1 + "x" + paramInt2);
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.zzacv.setSessionTimeout(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", zztm.zzX(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
  
  void zza(zztl paramzztl)
  {
    zzbP("Loading Tracker config values");
    this.zzacx = paramzztl;
    if (this.zzacx.zzqs())
    {
      paramzztl = this.zzacx.getTrackingId();
      set("&tid", paramzztl);
      zza("trackingId loaded", paramzztl);
    }
    if (this.zzacx.zzqt())
    {
      paramzztl = Double.toString(this.zzacx.zzqu());
      set("&sf", paramzztl);
      zza("Sample frequency loaded", paramzztl);
    }
    if (this.zzacx.zzqv())
    {
      int i = this.zzacx.getSessionTimeout();
      setSessionTimeout(i);
      zza("Session timeout loaded", Integer.valueOf(i));
    }
    boolean bool;
    if (this.zzacx.zzqw())
    {
      bool = this.zzacx.zzqx();
      enableAutoActivityTracking(bool);
      zza("Auto activity tracking loaded", Boolean.valueOf(bool));
    }
    if (this.zzacx.zzqy())
    {
      bool = this.zzacx.zzqz();
      if (bool) {
        set("&aip", "1");
      }
      zza("Anonymize ip loaded", Boolean.valueOf(bool));
    }
    enableExceptionReporting(this.zzacx.zzqA());
  }
  
  protected void zzmS()
  {
    this.zzacv.initialize();
    String str = zzmB().zzmY();
    if (str != null) {
      set("&an", str);
    }
    str = zzmB().zzmZ();
    if (str != null) {
      set("&av", str);
    }
  }
  
  boolean zzmU()
  {
    return this.zzacs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.Tracker
 * JD-Core Version:    0.7.0.1
 */