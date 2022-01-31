package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

public class zzsd
{
  private final Context zzaeg;
  private final Context zzwi;
  
  public zzsd(Context paramContext)
  {
    zzac.zzw(paramContext);
    paramContext = paramContext.getApplicationContext();
    zzac.zzb(paramContext, "Application context can't be null");
    this.zzwi = paramContext;
    this.zzaeg = paramContext;
  }
  
  public Context getApplicationContext()
  {
    return this.zzwi;
  }
  
  protected zzss zza(zzsc paramzzsc)
  {
    return new zzss(paramzzsc);
  }
  
  protected zzh zzao(Context paramContext)
  {
    return zzh.zzam(paramContext);
  }
  
  protected zzsh zzb(zzsc paramzzsc)
  {
    return new zzsh(paramzzsc);
  }
  
  protected zzrx zzc(zzsc paramzzsc)
  {
    return new zzrx(paramzzsc);
  }
  
  protected zzsk zzd(zzsc paramzzsc)
  {
    return new zzsk(paramzzsc);
  }
  
  protected zztn zze(zzsc paramzzsc)
  {
    return new zztn(paramzzsc);
  }
  
  protected zztd zzf(zzsc paramzzsc)
  {
    return new zztd(paramzzsc);
  }
  
  protected zzsp zzg(zzsc paramzzsc)
  {
    return new zzsp(paramzzsc);
  }
  
  protected zze zzh(zzsc paramzzsc)
  {
    return zzi.zzzc();
  }
  
  protected GoogleAnalytics zzi(zzsc paramzzsc)
  {
    return new GoogleAnalytics(paramzzsc);
  }
  
  zzsi zzj(zzsc paramzzsc)
  {
    return new zzsi(paramzzsc, this);
  }
  
  zzte zzk(zzsc paramzzsc)
  {
    return new zzte(paramzzsc);
  }
  
  protected zzry zzl(zzsc paramzzsc)
  {
    return new zzry(paramzzsc, this);
  }
  
  public zzsg zzm(zzsc paramzzsc)
  {
    return new zzsg(paramzzsc);
  }
  
  public zztf zzn(zzsc paramzzsc)
  {
    return new zztf(paramzzsc);
  }
  
  public zzsf zzo(zzsc paramzzsc)
  {
    return new zzsf(paramzzsc);
  }
  
  public Context zzod()
  {
    return this.zzaeg;
  }
  
  public zzst zzp(zzsc paramzzsc)
  {
    return new zzst(paramzzsc);
  }
  
  public zztg zzq(zzsc paramzzsc)
  {
    return new zztg(paramzzsc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzsd
 * JD-Core Version:    0.7.0.1
 */