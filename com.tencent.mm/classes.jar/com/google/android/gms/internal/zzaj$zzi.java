package com.google.android.gms.internal;

public final class zzaj$zzi
  extends zzbxn<zzi>
{
  private static volatile zzi[] zzln;
  public String name;
  public zzak.zza zzlo;
  public zzaj.zzd zzlp;
  
  public zzaj$zzi()
  {
    zzJ();
  }
  
  public static zzi[] zzI()
  {
    if (zzln == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzln == null) {
        zzln = new zzi[0];
      }
      return zzln;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzi)) {
        return false;
      }
      paramObject = (zzi)paramObject;
      if (this.name == null)
      {
        if (paramObject.name != null) {
          return false;
        }
      }
      else if (!this.name.equals(paramObject.name)) {
        return false;
      }
      if (this.zzlo == null)
      {
        if (paramObject.zzlo != null) {
          return false;
        }
      }
      else if (!this.zzlo.equals(paramObject.zzlo)) {
        return false;
      }
      if (this.zzlp == null)
      {
        if (paramObject.zzlp != null) {
          return false;
        }
      }
      else if (!this.zzlp.equals(paramObject.zzlp)) {
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
    int n = 0;
    int i1 = getClass().getName().hashCode();
    int i;
    int j;
    label33:
    int k;
    if (this.name == null)
    {
      i = 0;
      if (this.zzlo != null) {
        break label106;
      }
      j = 0;
      if (this.zzlp != null) {
        break label117;
      }
      k = 0;
      label42:
      m = n;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label128;
        }
      }
    }
    label128:
    for (int m = n;; m = this.zzcuA.hashCode())
    {
      return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
      i = this.name.hashCode();
      break;
      label106:
      j = this.zzlo.hashCode();
      break label33;
      label117:
      k = this.zzlp.hashCode();
      break label42;
    }
  }
  
  public final zzi zzJ()
  {
    this.name = "";
    this.zzlo = null;
    this.zzlp = null;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if ((this.name != null) && (!this.name.equals(""))) {
      paramzzbxm.zzq(1, this.name);
    }
    if (this.zzlo != null) {
      paramzzbxm.zza(2, this.zzlo);
    }
    if (this.zzlp != null) {
      paramzzbxm.zza(3, this.zzlp);
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.name != null)
    {
      i = j;
      if (!this.name.equals("")) {
        i = j + zzbxm.zzr(1, this.name);
      }
    }
    j = i;
    if (this.zzlo != null) {
      j = i + zzbxm.zzc(2, this.zzlo);
    }
    i = j;
    if (this.zzlp != null) {
      i = j + zzbxm.zzc(3, this.zzlp);
    }
    return i;
  }
  
  public final zzi zzv(zzbxl paramzzbxl)
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
      case 10: 
        this.name = paramzzbxl.readString();
        break;
      case 18: 
        if (this.zzlo == null) {
          this.zzlo = new zzak.zza();
        }
        paramzzbxl.zza(this.zzlo);
        break;
      }
      if (this.zzlp == null) {
        this.zzlp = new zzaj.zzd();
      }
      paramzzbxl.zza(this.zzlp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zzi
 * JD-Core Version:    0.7.0.1
 */