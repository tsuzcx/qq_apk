package com.google.android.gms.internal;

public final class zzae$zzc
  extends zzbxn<zzc>
{
  public String zzaN = null;
  public String zzaO = null;
  public String zzaP = null;
  public String zzaQ = null;
  public String zzaR = null;
  
  public zzae$zzc()
  {
    this.zzcuJ = -1;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzaN != null) {
      paramzzbxm.zzq(1, this.zzaN);
    }
    if (this.zzaO != null) {
      paramzzbxm.zzq(2, this.zzaO);
    }
    if (this.zzaP != null) {
      paramzzbxm.zzq(3, this.zzaP);
    }
    if (this.zzaQ != null) {
      paramzzbxm.zzq(4, this.zzaQ);
    }
    if (this.zzaR != null) {
      paramzzbxm.zzq(5, this.zzaR);
    }
    super.zza(paramzzbxm);
  }
  
  public final zzc zzd(zzbxl paramzzbxl)
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
        this.zzaN = paramzzbxl.readString();
        break;
      case 18: 
        this.zzaO = paramzzbxl.readString();
        break;
      case 26: 
        this.zzaP = paramzzbxl.readString();
        break;
      case 34: 
        this.zzaQ = paramzzbxl.readString();
        break;
      }
      this.zzaR = paramzzbxl.readString();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzaN != null) {
      i = j + zzbxm.zzr(1, this.zzaN);
    }
    j = i;
    if (this.zzaO != null) {
      j = i + zzbxm.zzr(2, this.zzaO);
    }
    i = j;
    if (this.zzaP != null) {
      i = j + zzbxm.zzr(3, this.zzaP);
    }
    j = i;
    if (this.zzaQ != null) {
      j = i + zzbxm.zzr(4, this.zzaQ);
    }
    i = j;
    if (this.zzaR != null) {
      i = j + zzbxm.zzr(5, this.zzaR);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzae.zzc
 * JD-Core Version:    0.7.0.1
 */