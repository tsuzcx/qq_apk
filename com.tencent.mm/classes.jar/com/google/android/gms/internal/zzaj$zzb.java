package com.google.android.gms.internal;

public final class zzaj$zzb
  extends zzbxn<zzb>
{
  private static volatile zzb[] zzkp;
  public int name;
  public int[] zzkq;
  public int zzkr;
  public boolean zzks;
  public boolean zzkt;
  
  public zzaj$zzb()
  {
    zzy();
  }
  
  public static zzb[] zzx()
  {
    if (zzkp == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzkp == null) {
        zzkp = new zzb[0];
      }
      return zzkp;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      paramObject = (zzb)paramObject;
      if (!zzbxr.equals(this.zzkq, paramObject.zzkq)) {
        return false;
      }
      if (this.zzkr != paramObject.zzkr) {
        return false;
      }
      if (this.name != paramObject.name) {
        return false;
      }
      if (this.zzks != paramObject.zzks) {
        return false;
      }
      if (this.zzkt != paramObject.zzkt) {
        return false;
      }
      if ((this.zzcuA != null) && (!this.zzcuA.isEmpty())) {
        break;
      }
    } while ((paramObject.zzcuA == null) || (paramObject.zzcuA.isEmpty()));
    return false;
    return this.zzcuA.equals(paramObject.zzcuA);
  }
  
  public final int hashCode()
  {
    int j = 1231;
    int m = getClass().getName().hashCode();
    int n = zzbxr.hashCode(this.zzkq);
    int i1 = this.zzkr;
    int i2 = this.name;
    int i;
    if (this.zzks)
    {
      i = 1231;
      if (!this.zzkt) {
        break label121;
      }
      label55:
      if ((this.zzcuA != null) && (!this.zzcuA.isEmpty())) {
        break label128;
      }
    }
    label128:
    for (int k = 0;; k = this.zzcuA.hashCode())
    {
      return k + ((i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + j) * 31;
      i = 1237;
      break;
      label121:
      j = 1237;
      break label55;
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzkt) {
      paramzzbxm.zzg(1, this.zzkt);
    }
    paramzzbxm.zzJ(2, this.zzkr);
    if ((this.zzkq != null) && (this.zzkq.length > 0))
    {
      int i = 0;
      while (i < this.zzkq.length)
      {
        paramzzbxm.zzJ(3, this.zzkq[i]);
        i += 1;
      }
    }
    if (this.name != 0) {
      paramzzbxm.zzJ(4, this.name);
    }
    if (this.zzks) {
      paramzzbxm.zzg(6, this.zzks);
    }
    super.zza(paramzzbxm);
  }
  
  public final zzb zzo(zzbxl paramzzbxl)
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
        this.zzkt = paramzzbxl.zzaet();
        break;
      case 16: 
        this.zzkr = paramzzbxl.zzaer();
        break;
      case 24: 
        j = zzbxw.zzb(paramzzbxl, 24);
        if (this.zzkq == null) {}
        for (i = 0;; i = this.zzkq.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkq, 0, arrayOfInt, 0, i);
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
        this.zzkq = arrayOfInt;
        break;
      case 26: 
        int k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0)
        {
          paramzzbxl.zzaer();
          j += 1;
        }
        paramzzbxl.zzrb(i);
        if (this.zzkq == null) {}
        for (i = 0;; i = this.zzkq.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkq, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            j += 1;
          }
        }
        this.zzkq = arrayOfInt;
        paramzzbxl.zzra(k);
        break;
      case 32: 
        this.name = paramzzbxl.zzaer();
        break;
      }
      this.zzks = paramzzbxl.zzaet();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzkt) {
      i = j + zzbxm.zzh(1, this.zzkt);
    }
    int k = i + zzbxm.zzL(2, this.zzkr);
    if ((this.zzkq != null) && (this.zzkq.length > 0))
    {
      j = 0;
      int m;
      for (i = 0; j < this.zzkq.length; i = m + i)
      {
        m = zzbxm.zzrf(this.zzkq[j]);
        j += 1;
      }
    }
    for (j = k + i + this.zzkq.length * 1;; j = k)
    {
      i = j;
      if (this.name != 0) {
        i = j + zzbxm.zzL(4, this.name);
      }
      j = i;
      if (this.zzks) {
        j = i + zzbxm.zzh(6, this.zzks);
      }
      return j;
    }
  }
  
  public final zzb zzy()
  {
    this.zzkq = zzbxw.zzcuO;
    this.zzkr = 0;
    this.name = 0;
    this.zzks = false;
    this.zzkt = false;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zzb
 * JD-Core Version:    0.7.0.1
 */