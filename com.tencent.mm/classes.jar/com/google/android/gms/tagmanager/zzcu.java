package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcu
  implements zzp.zze
{
  private boolean mClosed;
  private final Context mContext;
  private final String zzbEY;
  private String zzbFw;
  private final ScheduledExecutorService zzbHA;
  private final zzcu.zza zzbHB;
  private ScheduledFuture<?> zzbHC;
  private zzbn<zzaj.zzj> zzbHx;
  private zzt zzbHy;
  
  public zzcu(Context paramContext, String paramString, zzt paramzzt)
  {
    this(paramContext, paramString, paramzzt, null, null);
  }
  
  zzcu(Context paramContext, String paramString, zzt paramzzt, zzcu.zzb paramzzb, zzcu.zza paramzza)
  {
    this.zzbHy = paramzzt;
    this.mContext = paramContext;
    this.zzbEY = paramString;
    paramContext = paramzzb;
    if (paramzzb == null) {
      paramContext = new zzcu.zzb()
      {
        public ScheduledExecutorService zzRk()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.zzbHA = paramContext.zzRk();
    if (paramzza == null)
    {
      this.zzbHB = new zzcu.zza()
      {
        public zzct zza(zzt paramAnonymouszzt)
        {
          return new zzct(zzcu.zza(zzcu.this), zzcu.zzb(zzcu.this), paramAnonymouszzt);
        }
      };
      return;
    }
    this.zzbHB = paramzza;
  }
  
  private void zzRj()
  {
    try
    {
      if (this.mClosed) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  private zzct zzhp(String paramString)
  {
    zzct localzzct = this.zzbHB.zza(this.zzbHy);
    localzzct.zza(this.zzbHx);
    localzzct.zzgZ(this.zzbFw);
    localzzct.zzho(paramString);
    return localzzct;
  }
  
  public void release()
  {
    try
    {
      zzRj();
      if (this.zzbHC != null) {
        this.zzbHC.cancel(false);
      }
      this.zzbHA.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  public void zza(zzbn<zzaj.zzj> paramzzbn)
  {
    try
    {
      zzRj();
      this.zzbHx = paramzzbn;
      return;
    }
    finally
    {
      paramzzbn = finally;
      throw paramzzbn;
    }
  }
  
  public void zzf(long paramLong, String paramString)
  {
    try
    {
      String str = this.zzbEY;
      zzbo.v(String.valueOf(str).length() + 55 + "loadAfterDelay: containerId=" + str + " delay=" + paramLong);
      zzRj();
      if (this.zzbHx == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.zzbHC != null) {
      this.zzbHC.cancel(false);
    }
    this.zzbHC = this.zzbHA.schedule(zzhp(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void zzgZ(String paramString)
  {
    try
    {
      zzRj();
      this.zzbFw = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcu
 * JD-Core Version:    0.7.0.1
 */