package com.google.android.gms.internal;

public final class zzbld
  extends zzbxn<zzbld>
{
  public zzbld.zza[] zzbVy;
  
  public zzbld()
  {
    zzUA();
  }
  
  public static zzbld zzS(byte[] paramArrayOfByte)
  {
    return (zzbld)zzbxt.zza(new zzbld(), paramArrayOfByte);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbld)) {
        return false;
      }
      paramObject = (zzbld)paramObject;
      if (!zzbxr.equals(this.zzbVy, paramObject.zzbVy)) {
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
    int k = zzbxr.hashCode(this.zzbVy);
    if ((this.zzcuA == null) || (this.zzcuA.isEmpty())) {}
    for (int i = 0;; i = this.zzcuA.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  public final zzbld zzUA()
  {
    this.zzbVy = zzbld.zza.zzUB();
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final zzbld zzX(zzbxl paramzzbxl)
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
      int j = zzbxw.zzb(paramzzbxl, 10);
      if (this.zzbVy == null) {}
      zzbld.zza[] arrayOfzza;
      for (i = 0;; i = this.zzbVy.length)
      {
        arrayOfzza = new zzbld.zza[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.zzbVy, 0, arrayOfzza, 0, i);
          j = i;
        }
        while (j < arrayOfzza.length - 1)
        {
          arrayOfzza[j] = new zzbld.zza();
          paramzzbxl.zza(arrayOfzza[j]);
          paramzzbxl.zzaen();
          j += 1;
        }
      }
      arrayOfzza[j] = new zzbld.zza();
      paramzzbxl.zza(arrayOfzza[j]);
      this.zzbVy = arrayOfzza;
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if ((this.zzbVy != null) && (this.zzbVy.length > 0))
    {
      int i = 0;
      while (i < this.zzbVy.length)
      {
        zzbld.zza localzza = this.zzbVy[i];
        if (localzza != null) {
          paramzzbxm.zza(1, localzza);
        }
        i += 1;
      }
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int i = super.zzu();
    int k = i;
    if (this.zzbVy != null)
    {
      k = i;
      if (this.zzbVy.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.zzbVy.length) {
            break;
          }
          zzbld.zza localzza = this.zzbVy[j];
          k = i;
          if (localzza != null) {
            k = i + zzbxm.zzc(1, localzza);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public static final class zza$zza
    extends zzbxn<zza>
  {
    private static volatile zza[] zzbVB;
    public int type;
    public zzbld.zza.zza.zza zzbVC;
    
    public zza$zza()
    {
      zzUE();
    }
    
    public static zza[] zzUD()
    {
      if (zzbVB == null) {}
      synchronized (zzbxr.zzcuI)
      {
        if (zzbVB == null) {
          zzbVB = new zza[0];
        }
        return zzbVB;
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
        if (this.type != paramObject.type) {
          return false;
        }
        if (this.zzbVC == null)
        {
          if (paramObject.zzbVC != null) {
            return false;
          }
        }
        else if (!this.zzbVC.equals(paramObject.zzbVC)) {
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
      int k = 0;
      int m = getClass().getName().hashCode();
      int n = this.type;
      int i;
      if (this.zzbVC == null)
      {
        i = 0;
        j = k;
        if (this.zzcuA != null) {
          if (!this.zzcuA.isEmpty()) {
            break label84;
          }
        }
      }
      label84:
      for (int j = k;; j = this.zzcuA.hashCode())
      {
        return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
        i = this.zzbVC.hashCode();
        break;
      }
    }
    
    public final zza zzUE()
    {
      this.type = 1;
      this.zzbVC = null;
      this.zzcuA = null;
      this.zzcuJ = -1;
      return this;
    }
    
    public final zza zzZ(zzbxl paramzzbxl)
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
          this.type = i;
          break;
        }
        if (this.zzbVC == null) {
          this.zzbVC = new zzbld.zza.zza.zza();
        }
        paramzzbxl.zza(this.zzbVC);
      }
    }
    
    public final void zza(zzbxm paramzzbxm)
    {
      paramzzbxm.zzJ(1, this.type);
      if (this.zzbVC != null) {
        paramzzbxm.zza(2, this.zzbVC);
      }
      super.zza(paramzzbxm);
    }
    
    protected final int zzu()
    {
      int j = super.zzu() + zzbxm.zzL(1, this.type);
      int i = j;
      if (this.zzbVC != null) {
        i = j + zzbxm.zzc(2, this.zzbVC);
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzbld
 * JD-Core Version:    0.7.0.1
 */