package com.google.android.gms.internal;

public final class zzbxz$zza
  extends zzbxn<zza>
{
  private static volatile zza[] zzcvG;
  public String zzcvH;
  
  public zzbxz$zza()
  {
    zzafi();
  }
  
  public static zza[] zzafh()
  {
    if (zzcvG == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzcvG == null) {
        zzcvG = new zza[0];
      }
      return zzcvG;
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if ((this.zzcvH != null) && (!this.zzcvH.equals(""))) {
      paramzzbxm.zzq(1, this.zzcvH);
    }
    super.zza(paramzzbxm);
  }
  
  public final zza zzaV(zzbxl paramzzbxl)
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
      }
      this.zzcvH = paramzzbxl.readString();
    }
  }
  
  public final zza zzafi()
  {
    this.zzcvH = "";
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzcvH != null)
    {
      i = j;
      if (!this.zzcvH.equals("")) {
        i = j + zzbxm.zzr(1, this.zzcvH);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxz.zza
 * JD-Core Version:    0.7.0.1
 */