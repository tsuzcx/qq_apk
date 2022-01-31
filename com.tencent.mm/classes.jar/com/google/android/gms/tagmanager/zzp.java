package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzaaf;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzbjd.zza;
import com.google.android.gms.internal.zzbje;
import com.google.android.gms.internal.zzbjf.zzc;

public class zzp
  extends zzaaf<ContainerHolder>
{
  private final Context mContext;
  private final String zzbEY;
  private long zzbFd;
  private final TagManager zzbFk;
  private final zzp.zzd zzbFn;
  private final zzcl zzbFo;
  private final int zzbFp;
  private final zzq zzbFq;
  private zzp.zzf zzbFr;
  private zzbje zzbFs;
  private volatile zzo zzbFt;
  private volatile boolean zzbFu;
  private zzaj.zzj zzbFv;
  private String zzbFw;
  private zzp.zze zzbFx;
  private zzp.zza zzbFy;
  private final Looper zzrs;
  private final zze zzuP;
  
  zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzp.zzf paramzzf, zzp.zze paramzze, zzbje paramzzbje, zze paramzze1, zzcl paramzzcl, zzq paramzzq) {}
  
  public zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzt paramzzt)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new zzcv(paramContext, paramString), new zzcu(paramContext, paramString, paramzzt), new zzbje(paramContext), zzi.zzzc(), new zzbm(1, 5, 900000L, 5000L, "refreshing", zzi.zzzc()), new zzq(paramContext, paramString));
    this.zzbFs.zzig(paramzzt.zzQu());
  }
  
  private boolean zzQm()
  {
    zzcj localzzcj = zzcj.zzRd();
    return ((localzzcj.zzRe() == zzcj.zza.zzbHm) || (localzzcj.zzRe() == zzcj.zza.zzbHn)) && (this.zzbEY.equals(localzzcj.getContainerId()));
  }
  
  private void zza(zzaj.zzj paramzzj)
  {
    try
    {
      if (this.zzbFr != null)
      {
        zzbjd.zza localzza = new zzbjd.zza();
        localzza.zzbNi = this.zzbFd;
        localzza.zzlr = new zzaj.zzf();
        localzza.zzbNj = paramzzj;
        this.zzbFr.zzb(localzza);
      }
      return;
    }
    finally
    {
      paramzzj = finally;
      throw paramzzj;
    }
  }
  
  private void zza(zzaj.zzj paramzzj, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = this.zzbFu;
        if (isReady())
        {
          zzo localzzo = this.zzbFt;
          if (localzzo == null) {
            return;
          }
        }
        this.zzbFv = paramzzj;
        this.zzbFd = paramLong;
        long l = this.zzbFq.zzQp();
        zzay(Math.max(0L, Math.min(l, this.zzbFd + l - this.zzuP.currentTimeMillis())));
        paramzzj = new Container(this.mContext, this.zzbFk.getDataLayer(), this.zzbEY, paramLong, paramzzj);
        if (this.zzbFt == null)
        {
          this.zzbFt = new zzo(this.zzbFk, this.zzrs, paramzzj, this.zzbFn);
          if ((!isReady()) && (this.zzbFy.zzb(paramzzj))) {
            zzb(this.zzbFt);
          }
        }
        else
        {
          this.zzbFt.zza(paramzzj);
        }
      }
      finally {}
    }
  }
  
  private void zzaR(boolean paramBoolean)
  {
    this.zzbFr.zza(new zzb(null));
    this.zzbFx.zza(new zzc(null));
    zzbjf.zzc localzzc = this.zzbFr.zznz(this.zzbFp);
    if (localzzc != null) {
      this.zzbFt = new zzo(this.zzbFk, this.zzrs, new Container(this.mContext, this.zzbFk.getDataLayer(), this.zzbEY, 0L, localzzc), this.zzbFn);
    }
    this.zzbFy = new zzp.3(this, paramBoolean);
    if (zzQm())
    {
      this.zzbFx.zzf(0L, "");
      return;
    }
    this.zzbFr.zzQo();
  }
  
  /* Error */
  private void zzay(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/google/android/gms/tagmanager/zzp:zzbFx	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   6: ifnonnull +12 -> 18
    //   9: ldc_w 305
    //   12: invokestatic 310	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 79	com/google/android/gms/tagmanager/zzp:zzbFx	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   22: lload_1
    //   23: aload_0
    //   24: getfield 93	com/google/android/gms/tagmanager/zzp:zzbFv	Lcom/google/android/gms/internal/zzaj$zzj;
    //   27: getfield 313	com/google/android/gms/internal/zzaj$zzj:zzls	Ljava/lang/String;
    //   30: invokeinterface 300 4 0
    //   35: goto -20 -> 15
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	zzp
    //   0	43	1	paramLong	long
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	38	finally
    //   18	35	38	finally
  }
  
  String zzQg()
  {
    try
    {
      String str = this.zzbFw;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void zzQj()
  {
    Object localObject = this.zzbFr.zznz(this.zzbFp);
    if (localObject != null)
    {
      localObject = new Container(this.mContext, this.zzbFk.getDataLayer(), this.zzbEY, 0L, (zzbjf.zzc)localObject);
      zzb(new zzo(this.zzbFk, this.zzrs, (Container)localObject, new zzp.2(this)));
    }
    for (;;)
    {
      this.zzbFx = null;
      this.zzbFr = null;
      return;
      zzbo.e("Default was requested, but no default container was found");
      zzb(zzbN(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  public void zzQk()
  {
    zzaR(false);
  }
  
  public void zzQl()
  {
    zzaR(true);
  }
  
  protected ContainerHolder zzbN(Status paramStatus)
  {
    if (this.zzbFt != null) {
      return this.zzbFt;
    }
    if (paramStatus == Status.zzazA) {
      zzbo.e("timer expired: setting result to failure");
    }
    return new zzo(paramStatus);
  }
  
  void zzgW(String paramString)
  {
    try
    {
      this.zzbFw = paramString;
      if (this.zzbFx != null) {
        this.zzbFx.zzgZ(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private class zzb
    implements zzbn<zzbjd.zza>
  {
    private zzb() {}
    
    public void zza(zzbjd.zza paramzza)
    {
      zzaj.zzj localzzj;
      if (paramzza.zzbNj != null) {
        localzzj = paramzza.zzbNj;
      }
      for (;;)
      {
        zzp.zza(zzp.this, localzzj, paramzza.zzbNi, true);
        return;
        zzaj.zzf localzzf = paramzza.zzlr;
        localzzj = new zzaj.zzj();
        localzzj.zzlr = localzzf;
        localzzj.zzlq = null;
        localzzj.zzls = localzzf.version;
      }
    }
    
    public void zza(zzbn.zza paramzza)
    {
      if (!zzp.zze(zzp.this)) {
        zzp.zza(zzp.this, 0L);
      }
    }
  }
  
  private class zzc
    implements zzbn<zzaj.zzj>
  {
    private zzc() {}
    
    public void zza(zzbn.zza arg1)
    {
      if (??? == zzbn.zza.zzbGP) {
        zzp.zzc(zzp.this).zzQr();
      }
      synchronized (zzp.this)
      {
        if (!zzp.this.isReady())
        {
          if (zzp.zzb(zzp.this) != null) {
            zzp.this.zzb(zzp.zzb(zzp.this));
          }
        }
        else
        {
          long l = zzp.zzc(zzp.this).zzQq();
          zzp.zza(zzp.this, l);
          return;
        }
        zzp.this.zzb(zzp.this.zzbN(Status.zzazA));
      }
    }
    
    public void zzb(zzaj.zzj paramzzj)
    {
      zzp.zzc(zzp.this).zzQs();
      synchronized (zzp.this)
      {
        if (paramzzj.zzlr == null)
        {
          if (zzp.zzf(zzp.this).zzlr == null)
          {
            zzbo.e("Current resource is null; network resource is also null");
            l = zzp.zzc(zzp.this).zzQq();
            zzp.zza(zzp.this, l);
            return;
          }
          paramzzj.zzlr = zzp.zzf(zzp.this).zzlr;
        }
        zzp.zza(zzp.this, paramzzj, zzp.zzd(zzp.this).currentTimeMillis(), false);
        long l = zzp.zzg(zzp.this);
        zzbo.v(58 + "setting refresh time to current time: " + l);
        if (!zzp.zzh(zzp.this)) {
          zzp.zza(zzp.this, paramzzj);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzp
 * JD-Core Version:    0.7.0.1
 */