package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzf;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzaby
{
  public static final Status zzaDu = new Status(8, "The connection to Google Play services was lost");
  private static final zzaaf<?>[] zzaDv = new zzaaf[0];
  private final Map<Api.zzc<?>, Api.zze> zzaBQ;
  final Set<zzaaf<?>> zzaDw = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final zzaby.zzb zzaDx = new zzaby.1(this);
  
  public zzaby(Map<Api.zzc<?>, Api.zze> paramMap)
  {
    this.zzaBQ = paramMap;
  }
  
  private static void zza(zzaaf<?> paramzzaaf, zzf paramzzf, IBinder paramIBinder)
  {
    if (paramzzaaf.isReady())
    {
      paramzzaaf.zza(new zzaby.zza(paramzzaaf, paramzzf, paramIBinder, null));
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()))
    {
      zzaby.zza localzza = new zzaby.zza(paramzzaaf, paramzzf, paramIBinder, null);
      paramzzaaf.zza(localzza);
      try
      {
        paramIBinder.linkToDeath(localzza, 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        paramzzaaf.cancel();
        paramzzf.remove(paramzzaaf.zzvr().intValue());
        return;
      }
    }
    paramzzaaf.zza(null);
    paramzzaaf.cancel();
    paramzzf.remove(paramzzaaf.zzvr().intValue());
  }
  
  public void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzaDw.size());
  }
  
  public void release()
  {
    zzaaf[] arrayOfzzaaf = (zzaaf[])this.zzaDw.toArray(zzaDv);
    int j = arrayOfzzaaf.length;
    int i = 0;
    if (i < j)
    {
      zzaaf localzzaaf = arrayOfzzaaf[i];
      localzzaaf.zza(null);
      if (localzzaaf.zzvr() == null) {
        if (localzzaaf.zzvF()) {
          this.zzaDw.remove(localzzaaf);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localzzaaf.zzvH();
        zza(localzzaaf, null, ((Api.zze)this.zzaBQ.get(((zzaad.zza)localzzaaf).zzvg())).zzvi());
        this.zzaDw.remove(localzzaaf);
      }
    }
  }
  
  void zzb(zzaaf<? extends Result> paramzzaaf)
  {
    this.zzaDw.add(paramzzaaf);
    paramzzaaf.zza(this.zzaDx);
  }
  
  public void zzxd()
  {
    zzaaf[] arrayOfzzaaf = (zzaaf[])this.zzaDw.toArray(zzaDv);
    int j = arrayOfzzaaf.length;
    int i = 0;
    while (i < j)
    {
      arrayOfzzaaf[i].zzC(zzaDu);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzaby
 * JD-Core Version:    0.7.0.1
 */