package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zzsw;
import com.google.android.gms.internal.zzsw.zza;
import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.internal.zztl;
import com.google.android.gms.internal.zztn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics
  extends zza
{
  private static List<Runnable> zzabG = new ArrayList();
  private Set<GoogleAnalytics.zza> zzabH = new HashSet();
  private boolean zzabI;
  private boolean zzabJ;
  private volatile boolean zzabK;
  private boolean zzabL;
  private boolean zztZ;
  
  public GoogleAnalytics(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    return zzsc.zzan(paramContext).zzof();
  }
  
  private zzry zzmA()
  {
    return zzmn().zzmA();
  }
  
  private zztn zzmB()
  {
    return zzmn().zzmB();
  }
  
  public static void zzmx()
  {
    try
    {
      if (zzabG != null)
      {
        Iterator localIterator = zzabG.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        zzabG = null;
      }
    }
    finally {}
  }
  
  public final void dispatchLocalHits()
  {
    zzmA().zznL();
  }
  
  @TargetApi(14)
  public final void enableAutoActivityReports(Application paramApplication)
  {
    int i = Build.VERSION.SDK_INT;
    if (!this.zzabI)
    {
      paramApplication.registerActivityLifecycleCallbacks(new GoogleAnalytics.zzb(this));
      this.zzabI = true;
    }
  }
  
  public final boolean getAppOptOut()
  {
    return this.zzabK;
  }
  
  @Deprecated
  public final Logger getLogger()
  {
    return zztc.getLogger();
  }
  
  public final void initialize()
  {
    zzmw();
    this.zztZ = true;
  }
  
  public final boolean isDryRunEnabled()
  {
    return this.zzabJ;
  }
  
  public final boolean isInitialized()
  {
    return this.zztZ;
  }
  
  public final Tracker newTracker(int paramInt)
  {
    try
    {
      Tracker localTracker = new Tracker(zzmn(), null, null);
      if (paramInt > 0)
      {
        zztl localzztl = (zztl)new zztk(zzmn()).zzaI(paramInt);
        if (localzztl != null) {
          localTracker.zza(localzztl);
        }
      }
      localTracker.initialize();
      return localTracker;
    }
    finally {}
  }
  
  public final Tracker newTracker(String paramString)
  {
    try
    {
      paramString = new Tracker(zzmn(), paramString, null);
      paramString.initialize();
      return paramString;
    }
    finally {}
  }
  
  public final void reportActivityStart(Activity paramActivity)
  {
    if (!this.zzabI) {
      zzm(paramActivity);
    }
  }
  
  public final void reportActivityStop(Activity paramActivity)
  {
    if (!this.zzabI) {
      zzn(paramActivity);
    }
  }
  
  public final void setAppOptOut(boolean paramBoolean)
  {
    this.zzabK = paramBoolean;
    if (this.zzabK) {
      zzmA().zznK();
    }
  }
  
  public final void setDryRun(boolean paramBoolean)
  {
    this.zzabJ = paramBoolean;
  }
  
  public final void setLocalDispatchPeriod(int paramInt)
  {
    zzmA().setLocalDispatchPeriod(paramInt);
  }
  
  @Deprecated
  public final void setLogger(Logger paramLogger)
  {
    zztc.setLogger(paramLogger);
    if (!this.zzabL)
    {
      zzsw.zzafl.get();
      paramLogger = (String)zzsw.zzafl.get();
      new StringBuilder(String.valueOf(paramLogger).length() + 112).append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(paramLogger).append(" DEBUG");
      this.zzabL = true;
    }
  }
  
  final void zza(GoogleAnalytics.zza paramzza)
  {
    this.zzabH.add(paramzza);
    paramzza = zzmn().getContext();
    if ((paramzza instanceof Application)) {
      enableAutoActivityReports((Application)paramzza);
    }
  }
  
  final void zzb(GoogleAnalytics.zza paramzza)
  {
    this.zzabH.remove(paramzza);
  }
  
  final void zzm(Activity paramActivity)
  {
    Iterator localIterator = this.zzabH.iterator();
    while (localIterator.hasNext()) {
      ((GoogleAnalytics.zza)localIterator.next()).zzo(paramActivity);
    }
  }
  
  final void zzmw()
  {
    zztn localzztn = zzmB();
    localzztn.zzpI();
    if (localzztn.zzpM()) {
      setDryRun(localzztn.zzpN());
    }
    localzztn.zzpI();
  }
  
  public final String zzmy()
  {
    zzac.zzdk("getClientId can not be called from the main thread");
    return zzmn().zzoi().zzoQ();
  }
  
  final void zzmz()
  {
    zzmA().zznM();
  }
  
  final void zzn(Activity paramActivity)
  {
    Iterator localIterator = this.zzabH.iterator();
    while (localIterator.hasNext()) {
      ((GoogleAnalytics.zza)localIterator.next()).zzp(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.GoogleAnalytics
 * JD-Core Version:    0.7.0.1
 */