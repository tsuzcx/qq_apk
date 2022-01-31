package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzg<T extends zzg>
{
  private final zzh zzace;
  protected final zze zzacf;
  private final List<Object> zzacg;
  
  protected zzg(zzh paramzzh, com.google.android.gms.common.util.zze paramzze)
  {
    zzac.zzw(paramzzh);
    this.zzace = paramzzh;
    this.zzacg = new ArrayList();
    paramzzh = new zze(this, paramzze);
    paramzzh.zzmM();
    this.zzacf = paramzzh;
  }
  
  protected void zza(zze paramzze) {}
  
  protected void zzd(zze paramzze)
  {
    paramzze = this.zzacg.iterator();
    while (paramzze.hasNext()) {
      paramzze.next();
    }
  }
  
  protected zzh zzmK()
  {
    return this.zzace;
  }
  
  public zze zzmN()
  {
    return this.zzacf;
  }
  
  public List<zzi> zzmO()
  {
    return this.zzacf.zzmE();
  }
  
  public zze zzmo()
  {
    zze localzze = this.zzacf.zzmC();
    zzd(localzze);
    return localzze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.analytics.zzg
 * JD-Core Version:    0.7.0.1
 */