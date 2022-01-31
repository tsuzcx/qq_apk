package com.google.android.gms.internal;

public final class zzbld$zza
  extends zzbxn<zza>
{
  private static volatile zza[] zzbVz;
  public String name;
  public zzbld.zza.zza zzbVA;
  
  public zzbld$zza()
  {
    zzUC();
  }
  
  public static zza[] zzUB()
  {
    if (zzbVz == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzbVz == null) {
        zzbVz = new zza[0];
      }
      return zzbVz;
    }
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
      if (this.name == null)
      {
        if (paramObject.name != null) {
          return false;
        }
      }
      else if (!this.name.equals(paramObject.name)) {
        return false;
      }
      if (this.zzbVA == null)
      {
        if (paramObject.zzbVA != null) {
          return false;
        }
      }
      else if (!this.zzbVA.equals(paramObject.zzbVA)) {
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
    int j;
    if (this.name == null)
    {
      i = 0;
      if (this.zzbVA != null) {
        break label89;
      }
      j = 0;
      label33:
      k = m;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label100;
        }
      }
    }
    label89:
    label100:
    for (int k = m;; k = this.zzcuA.hashCode())
    {
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = this.name.hashCode();
      break;
      j = this.zzbVA.hashCode();
      break label33;
    }
  }
  
  public final zza zzUC()
  {
    this.name = "";
    this.zzbVA = null;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final zza zzY(zzbxl paramzzbxl)
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
      }
      if (this.zzbVA == null) {
        this.zzbVA = new zzbld.zza.zza();
      }
      paramzzbxl.zza(this.zzbVA);
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    paramzzbxm.zzq(1, this.name);
    if (this.zzbVA != null) {
      paramzzbxm.zza(2, this.zzbVA);
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int j = super.zzu() + zzbxm.zzr(1, this.name);
    int i = j;
    if (this.zzbVA != null) {
      i = j + zzbxm.zzc(2, this.zzbVA);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzbld.zza
 * JD-Core Version:    0.7.0.1
 */