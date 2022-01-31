package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zztm;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzh
{
  private static volatile zzh zzach;
  private final Context mContext;
  private final List<Object> zzaci;
  private final zzd zzacj;
  private final zzh.zza zzack;
  private volatile zzrk zzacl;
  private Thread.UncaughtExceptionHandler zzacm;
  
  zzh(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    zzac.zzw(paramContext);
    this.mContext = paramContext;
    this.zzack = new zzh.zza(this);
    this.zzaci = new CopyOnWriteArrayList();
    this.zzacj = new zzd();
  }
  
  public static zzh zzam(Context paramContext)
  {
    zzac.zzw(paramContext);
    if (zzach == null) {}
    try
    {
      if (zzach == null) {
        zzach = new zzh(paramContext);
      }
      return zzach;
    }
    finally {}
  }
  
  private void zzb(zze paramzze)
  {
    zzac.zzdk("deliver should be called from worker thread");
    zzac.zzb(paramzze.zzmH(), "Measurement must be submitted");
    Object localObject = paramzze.zzmE();
    if (((List)localObject).isEmpty()) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzi localzzi = (zzi)((Iterator)localObject).next();
        Uri localUri = localzzi.zzmr();
        if (!localHashSet.contains(localUri))
        {
          localHashSet.add(localUri);
          localzzi.zzb(paramzze);
        }
      }
    }
  }
  
  public static void zzmR()
  {
    if (!(Thread.currentThread() instanceof zzh.zzc)) {
      throw new IllegalStateException("Call expected from worker thread");
    }
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final void zza(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.zzacm = paramUncaughtExceptionHandler;
  }
  
  public final <V> Future<V> zzc(Callable<V> paramCallable)
  {
    zzac.zzw(paramCallable);
    if ((Thread.currentThread() instanceof zzh.zzc))
    {
      paramCallable = new FutureTask(paramCallable);
      paramCallable.run();
      return paramCallable;
    }
    return this.zzack.submit(paramCallable);
  }
  
  final void zze(zze paramzze)
  {
    if (paramzze.zzmL()) {
      throw new IllegalStateException("Measurement prototype can't be submitted");
    }
    if (paramzze.zzmH()) {
      throw new IllegalStateException("Measurement can only be submitted once");
    }
    paramzze = paramzze.zzmC();
    paramzze.zzmI();
    this.zzack.execute(new zzh.1(this, paramzze));
  }
  
  public final void zzg(Runnable paramRunnable)
  {
    zzac.zzw(paramRunnable);
    this.zzack.submit(paramRunnable);
  }
  
  public final zzrk zzmP()
  {
    if (this.zzacl == null) {}
    for (;;)
    {
      Object localObject6;
      Object localObject4;
      try
      {
        zzrk localzzrk;
        PackageManager localPackageManager;
        String str2;
        if (this.zzacl == null)
        {
          localzzrk = new zzrk();
          localPackageManager = this.mContext.getPackageManager();
          str2 = this.mContext.getPackageName();
          localzzrk.setAppId(str2);
          localzzrk.setAppInstallerId(localPackageManager.getInstallerPackageName(str2));
          localObject6 = null;
          localObject4 = str2;
        }
        try
        {
          PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.mContext.getPackageName(), 0);
          localObject5 = localObject6;
          String str1 = str2;
          if (localPackageInfo != null)
          {
            localObject4 = str2;
            localObject5 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
            str1 = str2;
            localObject4 = str2;
            if (!TextUtils.isEmpty((CharSequence)localObject5))
            {
              localObject4 = str2;
              str1 = ((CharSequence)localObject5).toString();
            }
            localObject4 = str1;
            localObject5 = localPackageInfo.versionName;
          }
          localzzrk.setAppName(str1);
          localzzrk.setAppVersion((String)localObject5);
          this.zzacl = localzzrk;
          return this.zzacl;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localObject1 = String.valueOf(localObject4);
          if (((String)localObject1).length() == 0) {
            break label196;
          }
        }
        "Error retrieving package info: appName set to ".concat((String)localObject1);
        localObject5 = localObject6;
        Object localObject1 = localObject4;
        continue;
        new String("Error retrieving package info: appName set to ");
      }
      finally {}
      label196:
      Object localObject5 = localObject6;
      Object localObject3 = localObject4;
    }
  }
  
  public final zzrp zzmQ()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    zzrp localzzrp = new zzrp();
    localzzrp.setLanguage(zztm.zza(Locale.getDefault()));
    localzzrp.zzaB(localDisplayMetrics.widthPixels);
    localzzrp.zzaC(localDisplayMetrics.heightPixels);
    return localzzrp;
  }
  
  private static class zzb
    implements ThreadFactory
  {
    private static final AtomicInteger zzacq = new AtomicInteger();
    
    public Thread newThread(Runnable paramRunnable)
    {
      int i = zzacq.incrementAndGet();
      return new zzh.zzc(paramRunnable, 23 + "measurement-" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.analytics.zzh
 * JD-Core Version:    0.7.0.1
 */