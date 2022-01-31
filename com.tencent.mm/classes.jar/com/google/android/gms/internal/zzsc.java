package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

public class zzsc
{
  private static volatile zzsc zzadR;
  private final Context mContext;
  private final Context zzadS;
  private final zzsp zzadT;
  private final zztd zzadU;
  private final zzh zzadV;
  private final zzry zzadW;
  private final zzst zzadX;
  private final zztn zzadY;
  private final zztg zzadZ;
  private final GoogleAnalytics zzaea;
  private final zzsk zzaeb;
  private final zzrx zzaec;
  private final zzsh zzaed;
  private final zzss zzaee;
  private final zze zzuP;
  
  protected zzsc(zzsd paramzzsd)
  {
    Object localObject1 = paramzzsd.getApplicationContext();
    zzac.zzb(localObject1, "Application context can't be null");
    Object localObject2 = paramzzsd.zzod();
    zzac.zzw(localObject2);
    this.mContext = ((Context)localObject1);
    this.zzadS = ((Context)localObject2);
    this.zzuP = paramzzsd.zzh(this);
    this.zzadT = paramzzsd.zzg(this);
    localObject2 = paramzzsd.zzf(this);
    ((zztd)localObject2).initialize();
    this.zzadU = ((zztd)localObject2);
    localObject2 = zznS();
    Object localObject3 = zzsb.VERSION;
    ((zztd)localObject2).zzbR(String.valueOf(localObject3).length() + 134 + "Google Analytics " + (String)localObject3 + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
    localObject2 = paramzzsd.zzq(this);
    ((zztg)localObject2).initialize();
    this.zzadZ = ((zztg)localObject2);
    localObject2 = paramzzsd.zze(this);
    ((zztn)localObject2).initialize();
    this.zzadY = ((zztn)localObject2);
    localObject2 = paramzzsd.zzl(this);
    localObject3 = paramzzsd.zzd(this);
    zzrx localzzrx = paramzzsd.zzc(this);
    zzsh localzzsh = paramzzsd.zzb(this);
    zzss localzzss = paramzzsd.zza(this);
    localObject1 = paramzzsd.zzao((Context)localObject1);
    ((zzh)localObject1).zza(zzoc());
    this.zzadV = ((zzh)localObject1);
    localObject1 = paramzzsd.zzi(this);
    ((zzsk)localObject3).initialize();
    this.zzaeb = ((zzsk)localObject3);
    localzzrx.initialize();
    this.zzaec = localzzrx;
    localzzsh.initialize();
    this.zzaed = localzzsh;
    localzzss.initialize();
    this.zzaee = localzzss;
    paramzzsd = paramzzsd.zzp(this);
    paramzzsd.initialize();
    this.zzadX = paramzzsd;
    ((zzry)localObject2).initialize();
    this.zzadW = ((zzry)localObject2);
    ((GoogleAnalytics)localObject1).initialize();
    this.zzaea = ((GoogleAnalytics)localObject1);
    ((zzry)localObject2).start();
  }
  
  private void zza(zzsa paramzzsa)
  {
    zzac.zzb(paramzzsa, "Analytics service not created/initialized");
    zzac.zzb(paramzzsa.isInitialized(), "Analytics service not initialized");
  }
  
  public static zzsc zzan(Context paramContext)
  {
    zzac.zzw(paramContext);
    if (zzadR == null) {}
    try
    {
      if (zzadR == null)
      {
        zze localzze = zzi.zzzc();
        long l1 = localzze.elapsedRealtime();
        paramContext = new zzsc(new zzsd(paramContext));
        zzadR = paramContext;
        GoogleAnalytics.zzmx();
        l1 = localzze.elapsedRealtime() - l1;
        long l2 = ((Long)zzsw.zzafZ.get()).longValue();
        if (l1 > l2) {
          paramContext.zznS().zzc("Slow initialization (ms)", Long.valueOf(l1), Long.valueOf(l2));
        }
      }
      return zzadR;
    }
    finally {}
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public zzry zzmA()
  {
    zza(this.zzadW);
    return this.zzadW;
  }
  
  public zztn zzmB()
  {
    zza(this.zzadY);
    return this.zzadY;
  }
  
  public void zzmR() {}
  
  public zze zznR()
  {
    return this.zzuP;
  }
  
  public zztd zznS()
  {
    zza(this.zzadU);
    return this.zzadU;
  }
  
  public zzsp zznT()
  {
    return this.zzadT;
  }
  
  public zzh zznU()
  {
    zzac.zzw(this.zzadV);
    return this.zzadV;
  }
  
  public zzst zznV()
  {
    zza(this.zzadX);
    return this.zzadX;
  }
  
  public zztg zznW()
  {
    zza(this.zzadZ);
    return this.zzadZ;
  }
  
  public zzsh zznZ()
  {
    zza(this.zzaed);
    return this.zzaed;
  }
  
  public zzss zzoa()
  {
    return this.zzaee;
  }
  
  protected Thread.UncaughtExceptionHandler zzoc()
  {
    new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        paramAnonymousThread = zzsc.this.zzoe();
        if (paramAnonymousThread != null) {
          paramAnonymousThread.zze("Job execution failed", paramAnonymousThrowable);
        }
      }
    };
  }
  
  public Context zzod()
  {
    return this.zzadS;
  }
  
  public zztd zzoe()
  {
    return this.zzadU;
  }
  
  public GoogleAnalytics zzof()
  {
    zzac.zzw(this.zzaea);
    zzac.zzb(this.zzaea.isInitialized(), "Analytics instance not initialized");
    return this.zzaea;
  }
  
  public zztg zzog()
  {
    if ((this.zzadZ == null) || (!this.zzadZ.isInitialized())) {
      return null;
    }
    return this.zzadZ;
  }
  
  public zzrx zzoh()
  {
    zza(this.zzaec);
    return this.zzaec;
  }
  
  public zzsk zzoi()
  {
    zza(this.zzaeb);
    return this.zzaeb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzsc
 * JD-Core Version:    0.7.0.1
 */