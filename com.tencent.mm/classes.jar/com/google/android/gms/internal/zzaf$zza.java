package com.google.android.gms.internal;

public final class zzaf$zza
  extends zzbxn<zza>
{
  public String stackTrace = null;
  public String zzaS = null;
  public Long zzaT = null;
  public String zzaU = null;
  public String zzaV = null;
  public Long zzaW = null;
  public Long zzaX = null;
  public String zzaY = null;
  public Long zzaZ = null;
  public String zzba = null;
  
  public zzaf$zza()
  {
    this.zzcuJ = -1;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzaS != null) {
      paramzzbxm.zzq(1, this.zzaS);
    }
    if (this.zzaT != null) {
      paramzzbxm.zzb(2, this.zzaT.longValue());
    }
    if (this.stackTrace != null) {
      paramzzbxm.zzq(3, this.stackTrace);
    }
    if (this.zzaU != null) {
      paramzzbxm.zzq(4, this.zzaU);
    }
    if (this.zzaV != null) {
      paramzzbxm.zzq(5, this.zzaV);
    }
    if (this.zzaW != null) {
      paramzzbxm.zzb(6, this.zzaW.longValue());
    }
    if (this.zzaX != null) {
      paramzzbxm.zzb(7, this.zzaX.longValue());
    }
    if (this.zzaY != null) {
      paramzzbxm.zzq(8, this.zzaY);
    }
    if (this.zzaZ != null) {
      paramzzbxm.zzb(9, this.zzaZ.longValue());
    }
    if (this.zzba != null) {
      paramzzbxm.zzq(10, this.zzba);
    }
    super.zza(paramzzbxm);
  }
  
  public final zza zze(zzbxl paramzzbxl)
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
        this.zzaS = paramzzbxl.readString();
        break;
      case 16: 
        this.zzaT = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 26: 
        this.stackTrace = paramzzbxl.readString();
        break;
      case 34: 
        this.zzaU = paramzzbxl.readString();
        break;
      case 42: 
        this.zzaV = paramzzbxl.readString();
        break;
      case 48: 
        this.zzaW = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 56: 
        this.zzaX = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 66: 
        this.zzaY = paramzzbxl.readString();
        break;
      case 72: 
        this.zzaZ = Long.valueOf(paramzzbxl.zzaeq());
        break;
      }
      this.zzba = paramzzbxl.readString();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzaS != null) {
      i = j + zzbxm.zzr(1, this.zzaS);
    }
    j = i;
    if (this.zzaT != null) {
      j = i + zzbxm.zzf(2, this.zzaT.longValue());
    }
    i = j;
    if (this.stackTrace != null) {
      i = j + zzbxm.zzr(3, this.stackTrace);
    }
    j = i;
    if (this.zzaU != null) {
      j = i + zzbxm.zzr(4, this.zzaU);
    }
    i = j;
    if (this.zzaV != null) {
      i = j + zzbxm.zzr(5, this.zzaV);
    }
    j = i;
    if (this.zzaW != null) {
      j = i + zzbxm.zzf(6, this.zzaW.longValue());
    }
    i = j;
    if (this.zzaX != null) {
      i = j + zzbxm.zzf(7, this.zzaX.longValue());
    }
    j = i;
    if (this.zzaY != null) {
      j = i + zzbxm.zzr(8, this.zzaY);
    }
    i = j;
    if (this.zzaZ != null) {
      i = j + zzbxm.zzf(9, this.zzaZ.longValue());
    }
    j = i;
    if (this.zzba != null) {
      j = i + zzbxm.zzr(10, this.zzba);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzaf.zza
 * JD-Core Version:    0.7.0.1
 */