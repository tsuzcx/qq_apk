package com.google.android.gms.internal;

public abstract class zzbxn<M extends zzbxn<M>>
  extends zzbxt
{
  protected zzbxp zzcuA;
  
  private void zza(int paramInt, zzbxv paramzzbxv)
  {
    zzbxq localzzbxq1 = null;
    if (this.zzcuA == null) {
      this.zzcuA = new zzbxp();
    }
    for (;;)
    {
      zzbxq localzzbxq2 = localzzbxq1;
      if (localzzbxq1 == null)
      {
        localzzbxq2 = new zzbxq();
        this.zzcuA.zza(paramInt, localzzbxq2);
      }
      localzzbxq2.zza(paramzzbxv);
      return;
      localzzbxq1 = this.zzcuA.zzrn(paramInt);
    }
  }
  
  public final <T> T zza(zzbxo<M, T> paramzzbxo)
  {
    if (this.zzcuA == null) {}
    zzbxq localzzbxq;
    do
    {
      return null;
      localzzbxq = this.zzcuA.zzrn(zzbxw.zzrr(paramzzbxo.tag));
    } while (localzzbxq == null);
    return localzzbxq.zzb(paramzzbxo);
  }
  
  public void zza(zzbxm paramzzbxm)
  {
    if (this.zzcuA == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.zzcuA.size())
      {
        this.zzcuA.zzro(i).zza(paramzzbxm);
        i += 1;
      }
    }
  }
  
  protected final boolean zza(zzbxl paramzzbxl, int paramInt)
  {
    int i = paramzzbxl.getPosition();
    if (!paramzzbxl.zzqX(paramInt)) {
      return false;
    }
    zza(zzbxw.zzrr(paramInt), new zzbxv(paramInt, paramzzbxl.zzI(i, paramzzbxl.getPosition() - i)));
    return true;
  }
  
  public M zzaeG()
  {
    zzbxn localzzbxn = (zzbxn)super.zzaeH();
    zzbxr.zza(this, localzzbxn);
    return localzzbxn;
  }
  
  protected int zzu()
  {
    if (this.zzcuA != null)
    {
      int j = 0;
      for (int i = 0;; i = k + i)
      {
        k = i;
        if (j >= this.zzcuA.size()) {
          break;
        }
        k = this.zzcuA.zzro(j).zzu();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxn
 * JD-Core Version:    0.7.0.1
 */