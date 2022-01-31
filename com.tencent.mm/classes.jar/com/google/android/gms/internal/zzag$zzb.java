package com.google.android.gms.internal;

public final class zzag$zzb
  extends zzbxn<zzb>
{
  public Long zzco = null;
  public Integer zzcp = null;
  public Boolean zzcq = null;
  public int[] zzcr = zzbxw.zzcuO;
  public Long zzcs = null;
  
  public zzag$zzb()
  {
    this.zzcuJ = -1;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzco != null) {
      paramzzbxm.zzb(1, this.zzco.longValue());
    }
    if (this.zzcp != null) {
      paramzzbxm.zzJ(2, this.zzcp.intValue());
    }
    if (this.zzcq != null) {
      paramzzbxm.zzg(3, this.zzcq.booleanValue());
    }
    if ((this.zzcr != null) && (this.zzcr.length > 0))
    {
      int i = 0;
      while (i < this.zzcr.length)
      {
        paramzzbxm.zzJ(4, this.zzcr[i]);
        i += 1;
      }
    }
    if (this.zzcs != null) {
      paramzzbxm.zza(5, this.zzcs.longValue());
    }
    super.zza(paramzzbxm);
  }
  
  public final zzb zzi(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      int j;
      int[] arrayOfInt;
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.zzco = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 16: 
        this.zzcp = Integer.valueOf(paramzzbxl.zzaer());
        break;
      case 24: 
        this.zzcq = Boolean.valueOf(paramzzbxl.zzaet());
        break;
      case 32: 
        j = zzbxw.zzb(paramzzbxl, 32);
        if (this.zzcr == null) {}
        for (i = 0;; i = this.zzcr.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzcr, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        arrayOfInt[j] = paramzzbxl.zzaer();
        this.zzcr = arrayOfInt;
        break;
      case 34: 
        int k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0)
        {
          paramzzbxl.zzaer();
          j += 1;
        }
        paramzzbxl.zzrb(i);
        if (this.zzcr == null) {}
        for (i = 0;; i = this.zzcr.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzcr, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            j += 1;
          }
        }
        this.zzcr = arrayOfInt;
        paramzzbxl.zzra(k);
        break;
      }
      this.zzcs = Long.valueOf(paramzzbxl.zzaep());
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzco != null) {
      i = j + zzbxm.zzf(1, this.zzco.longValue());
    }
    j = i;
    if (this.zzcp != null) {
      j = i + zzbxm.zzL(2, this.zzcp.intValue());
    }
    i = j;
    if (this.zzcq != null) {
      i = j + zzbxm.zzh(3, this.zzcq.booleanValue());
    }
    j = i;
    if (this.zzcr != null)
    {
      j = i;
      if (this.zzcr.length > 0)
      {
        int k = 0;
        int m;
        for (j = 0; k < this.zzcr.length; j = m + j)
        {
          m = zzbxm.zzrf(this.zzcr[k]);
          k += 1;
        }
        j = i + j + this.zzcr.length * 1;
      }
    }
    i = j;
    if (this.zzcs != null) {
      i = j + zzbxm.zze(5, this.zzcs.longValue());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzag.zzb
 * JD-Core Version:    0.7.0.1
 */