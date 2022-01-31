package com.google.android.gms.internal;

public final class zzaj$zza
  extends zzbxn<zza>
{
  public int level;
  public int zzkn;
  public int zzko;
  
  public zzaj$zza()
  {
    zzw();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      if (this.level != paramObject.level) {
        return false;
      }
      if (this.zzkn != paramObject.zzkn) {
        return false;
      }
      if (this.zzko != paramObject.zzko) {
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
    int k = this.level;
    int m = this.zzkn;
    int n = this.zzko;
    if ((this.zzcuA == null) || (this.zzcuA.isEmpty())) {}
    for (int i = 0;; i = this.zzcuA.hashCode()) {
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.level != 1) {
      paramzzbxm.zzJ(1, this.level);
    }
    if (this.zzkn != 0) {
      paramzzbxm.zzJ(2, this.zzkn);
    }
    if (this.zzko != 0) {
      paramzzbxm.zzJ(3, this.zzko);
    }
    super.zza(paramzzbxm);
  }
  
  public final zza zzn(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        i = paramzzbxl.zzaer();
        switch (i)
        {
        default: 
          break;
        }
        this.level = i;
        break;
      case 16: 
        this.zzkn = paramzzbxl.zzaer();
        break;
      }
      this.zzko = paramzzbxl.zzaer();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.level != 1) {
      i = j + zzbxm.zzL(1, this.level);
    }
    j = i;
    if (this.zzkn != 0) {
      j = i + zzbxm.zzL(2, this.zzkn);
    }
    i = j;
    if (this.zzko != 0) {
      i = j + zzbxm.zzL(3, this.zzko);
    }
    return i;
  }
  
  public final zza zzw()
  {
    this.level = 1;
    this.zzkn = 0;
    this.zzko = 0;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zza
 * JD-Core Version:    0.7.0.1
 */