package com.google.android.gms.internal;

public final class zzaj$zze
  extends zzbxn<zze>
{
  private static volatile zze[] zzkC;
  public int key;
  public int value;
  
  public zzaj$zze()
  {
    zzD();
  }
  
  public static zze[] zzC()
  {
    if (zzkC == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzkC == null) {
        zzkC = new zze[0];
      }
      return zzkC;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zze)) {
        return false;
      }
      paramObject = (zze)paramObject;
      if (this.key != paramObject.key) {
        return false;
      }
      if (this.value != paramObject.value) {
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
    int k = this.key;
    int m = this.value;
    if ((this.zzcuA == null) || (this.zzcuA.isEmpty())) {}
    for (int i = 0;; i = this.zzcuA.hashCode()) {
      return i + (((j + 527) * 31 + k) * 31 + m) * 31;
    }
  }
  
  public final zze zzD()
  {
    this.key = 0;
    this.value = 0;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    paramzzbxm.zzJ(1, this.key);
    paramzzbxm.zzJ(2, this.value);
    super.zza(paramzzbxm);
  }
  
  public final zze zzr(zzbxl paramzzbxl)
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
        this.key = paramzzbxl.zzaer();
        break;
      }
      this.value = paramzzbxl.zzaer();
    }
  }
  
  protected final int zzu()
  {
    return super.zzu() + zzbxm.zzL(1, this.key) + zzbxm.zzL(2, this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zze
 * JD-Core Version:    0.7.0.1
 */