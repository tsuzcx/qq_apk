package com.google.android.gms.internal;

public final class zzaj$zzd
  extends zzbxn<zzd>
{
  public zzak.zza[] zzkA;
  public zzaj.zzc[] zzkB;
  public zzak.zza[] zzkz;
  
  public zzaj$zzd()
  {
    zzB();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzd)) {
        return false;
      }
      paramObject = (zzd)paramObject;
      if (!zzbxr.equals(this.zzkz, paramObject.zzkz)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkA, paramObject.zzkA)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkB, paramObject.zzkB)) {
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
    int j = getClass().getName().hashCode();
    int k = zzbxr.hashCode(this.zzkz);
    int m = zzbxr.hashCode(this.zzkA);
    int n = zzbxr.hashCode(this.zzkB);
    if ((this.zzcuA == null) || (this.zzcuA.isEmpty())) {}
    for (int i = 0;; i = this.zzcuA.hashCode()) {
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final zzd zzB()
  {
    this.zzkz = zzak.zza.zzL();
    this.zzkA = zzak.zza.zzL();
    this.zzkB = zzaj.zzc.zzz();
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((this.zzkz != null) && (this.zzkz.length > 0))
    {
      i = 0;
      while (i < this.zzkz.length)
      {
        localObject = this.zzkz[i];
        if (localObject != null) {
          paramzzbxm.zza(1, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkA != null) && (this.zzkA.length > 0))
    {
      i = 0;
      while (i < this.zzkA.length)
      {
        localObject = this.zzkA[i];
        if (localObject != null) {
          paramzzbxm.zza(2, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkB != null) && (this.zzkB.length > 0))
    {
      i = j;
      while (i < this.zzkB.length)
      {
        localObject = this.zzkB[i];
        if (localObject != null) {
          paramzzbxm.zza(3, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzbxm);
  }
  
  public final zzd zzq(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      Object localObject;
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        j = zzbxw.zzb(paramzzbxl, 10);
        if (this.zzkz == null) {}
        for (i = 0;; i = this.zzkz.length)
        {
          localObject = new zzak.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkz, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzak.zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzak.zza();
        paramzzbxl.zza(localObject[j]);
        this.zzkz = ((zzak.zza[])localObject);
        break;
      case 18: 
        j = zzbxw.zzb(paramzzbxl, 18);
        if (this.zzkA == null) {}
        for (i = 0;; i = this.zzkA.length)
        {
          localObject = new zzak.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkA, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzak.zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzak.zza();
        paramzzbxl.zza(localObject[j]);
        this.zzkA = ((zzak.zza[])localObject);
        break;
      }
      int j = zzbxw.zzb(paramzzbxl, 26);
      if (this.zzkB == null) {}
      for (i = 0;; i = this.zzkB.length)
      {
        localObject = new zzaj.zzc[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.zzkB, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = new zzaj.zzc();
          paramzzbxl.zza(localObject[j]);
          paramzzbxl.zzaen();
          j += 1;
        }
      }
      localObject[j] = new zzaj.zzc();
      paramzzbxl.zza(localObject[j]);
      this.zzkB = ((zzaj.zzc[])localObject);
    }
  }
  
  protected final int zzu()
  {
    int m = 0;
    int j = super.zzu();
    int i = j;
    Object localObject;
    if (this.zzkz != null)
    {
      i = j;
      if (this.zzkz.length > 0)
      {
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.zzkz.length) {
            break;
          }
          localObject = this.zzkz[k];
          i = j;
          if (localObject != null) {
            i = j + zzbxm.zzc(1, (zzbxt)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    j = i;
    if (this.zzkA != null)
    {
      j = i;
      if (this.zzkA.length > 0)
      {
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.zzkA.length) {
            break;
          }
          localObject = this.zzkA[k];
          j = i;
          if (localObject != null) {
            j = i + zzbxm.zzc(2, (zzbxt)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    int k = j;
    if (this.zzkB != null)
    {
      k = j;
      if (this.zzkB.length > 0)
      {
        i = m;
        for (;;)
        {
          k = j;
          if (i >= this.zzkB.length) {
            break;
          }
          localObject = this.zzkB[i];
          k = j;
          if (localObject != null) {
            k = j + zzbxm.zzc(3, (zzbxt)localObject);
          }
          i += 1;
          j = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zzd
 * JD-Core Version:    0.7.0.1
 */