package com.google.android.gms.internal;

public final class zzaj$zzc
  extends zzbxn<zzc>
{
  private static volatile zzc[] zzku;
  public String zzaB;
  public long zzkv;
  public long zzkw;
  public boolean zzkx;
  public long zzky;
  
  public zzaj$zzc()
  {
    zzA();
  }
  
  public static zzc[] zzz()
  {
    if (zzku == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzku == null) {
        zzku = new zzc[0];
      }
      return zzku;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzc)) {
        return false;
      }
      paramObject = (zzc)paramObject;
      if (this.zzaB == null)
      {
        if (paramObject.zzaB != null) {
          return false;
        }
      }
      else if (!this.zzaB.equals(paramObject.zzaB)) {
        return false;
      }
      if (this.zzkv != paramObject.zzkv) {
        return false;
      }
      if (this.zzkw != paramObject.zzkw) {
        return false;
      }
      if (this.zzkx != paramObject.zzkx) {
        return false;
      }
      if (this.zzky != paramObject.zzky) {
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
    int m = 0;
    int n = getClass().getName().hashCode();
    int i;
    int i1;
    int i2;
    int j;
    label65:
    int i3;
    if (this.zzaB == null)
    {
      i = 0;
      i1 = (int)(this.zzkv ^ this.zzkv >>> 32);
      i2 = (int)(this.zzkw ^ this.zzkw >>> 32);
      if (!this.zzkx) {
        break label154;
      }
      j = 1231;
      i3 = (int)(this.zzky ^ this.zzky >>> 32);
      k = m;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label161;
        }
      }
    }
    label154:
    label161:
    for (int k = m;; k = this.zzcuA.hashCode())
    {
      return ((j + (((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + k;
      i = this.zzaB.hashCode();
      break;
      j = 1237;
      break label65;
    }
  }
  
  public final zzc zzA()
  {
    this.zzaB = "";
    this.zzkv = 0L;
    this.zzkw = 2147483647L;
    this.zzkx = false;
    this.zzky = 0L;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if ((this.zzaB != null) && (!this.zzaB.equals(""))) {
      paramzzbxm.zzq(1, this.zzaB);
    }
    if (this.zzkv != 0L) {
      paramzzbxm.zzb(2, this.zzkv);
    }
    if (this.zzkw != 2147483647L) {
      paramzzbxm.zzb(3, this.zzkw);
    }
    if (this.zzkx) {
      paramzzbxm.zzg(4, this.zzkx);
    }
    if (this.zzky != 0L) {
      paramzzbxm.zzb(5, this.zzky);
    }
    super.zza(paramzzbxm);
  }
  
  public final zzc zzp(zzbxl paramzzbxl)
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
        this.zzaB = paramzzbxl.readString();
        break;
      case 16: 
        this.zzkv = paramzzbxl.zzaeq();
        break;
      case 24: 
        this.zzkw = paramzzbxl.zzaeq();
        break;
      case 32: 
        this.zzkx = paramzzbxl.zzaet();
        break;
      }
      this.zzky = paramzzbxl.zzaeq();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzaB != null)
    {
      i = j;
      if (!this.zzaB.equals("")) {
        i = j + zzbxm.zzr(1, this.zzaB);
      }
    }
    j = i;
    if (this.zzkv != 0L) {
      j = i + zzbxm.zzf(2, this.zzkv);
    }
    i = j;
    if (this.zzkw != 2147483647L) {
      i = j + zzbxm.zzf(3, this.zzkw);
    }
    j = i;
    if (this.zzkx) {
      j = i + zzbxm.zzh(4, this.zzkx);
    }
    i = j;
    if (this.zzky != 0L) {
      i = j + zzbxm.zzf(5, this.zzky);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zzc
 * JD-Core Version:    0.7.0.1
 */