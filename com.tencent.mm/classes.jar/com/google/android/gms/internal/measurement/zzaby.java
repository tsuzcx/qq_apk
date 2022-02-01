package com.google.android.gms.internal.measurement;

public abstract class zzaby<M extends zzaby<M>>
  extends zzace
{
  protected zzaca zzbww;
  
  protected int zza()
  {
    if (this.zzbww != null)
    {
      int j = 0;
      for (int i = 0;; i = k + i)
      {
        k = i;
        if (j >= this.zzbww.size()) {
          break;
        }
        k = this.zzbww.zzau(j).zza();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public final <T> T zza(zzabz<M, T> paramzzabz)
  {
    if (this.zzbww == null) {}
    zzacb localzzacb;
    do
    {
      return null;
      localzzacb = this.zzbww.zzat(paramzzabz.tag >>> 3);
    } while (localzzacb == null);
    return localzzacb.zzb(paramzzabz);
  }
  
  public void zza(zzabw paramzzabw)
  {
    if (this.zzbww == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.zzbww.size())
      {
        this.zzbww.zzau(i).zza(paramzzabw);
        i += 1;
      }
    }
  }
  
  protected final boolean zza(zzabv paramzzabv, int paramInt)
  {
    int i = paramzzabv.getPosition();
    if (!paramzzabv.zzak(paramInt)) {
      return false;
    }
    int j = paramInt >>> 3;
    zzacg localzzacg = new zzacg(paramInt, paramzzabv.zzc(i, paramzzabv.getPosition() - i));
    paramzzabv = null;
    if (this.zzbww == null) {
      this.zzbww = new zzaca();
    }
    for (;;)
    {
      Object localObject = paramzzabv;
      if (paramzzabv == null)
      {
        localObject = new zzacb();
        this.zzbww.zza(j, (zzacb)localObject);
      }
      ((zzacb)localObject).zza(localzzacg);
      return true;
      paramzzabv = this.zzbww.zzat(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaby
 * JD-Core Version:    0.7.0.1
 */