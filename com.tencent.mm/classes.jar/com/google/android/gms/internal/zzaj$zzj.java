package com.google.android.gms.internal;

public final class zzaj$zzj
  extends zzbxn<zzj>
{
  public zzaj.zzi[] zzlq;
  public zzaj.zzf zzlr;
  public String zzls;
  
  public zzaj$zzj()
  {
    zzK();
  }
  
  public static zzj zzg(byte[] paramArrayOfByte)
  {
    return (zzj)zzbxt.zza(new zzj(), paramArrayOfByte);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzj)) {
        return false;
      }
      paramObject = (zzj)paramObject;
      if (!zzbxr.equals(this.zzlq, paramObject.zzlq)) {
        return false;
      }
      if (this.zzlr == null)
      {
        if (paramObject.zzlr != null) {
          return false;
        }
      }
      else if (!this.zzlr.equals(paramObject.zzlr)) {
        return false;
      }
      if (this.zzls == null)
      {
        if (paramObject.zzls != null) {
          return false;
        }
      }
      else if (!this.zzls.equals(paramObject.zzls)) {
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
    int i1 = zzbxr.hashCode(this.zzlq);
    int i;
    int j;
    if (this.zzlr == null)
    {
      i = 0;
      if (this.zzls != null) {
        break label104;
      }
      j = 0;
      label42:
      k = m;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label115;
        }
      }
    }
    label104:
    label115:
    for (int k = m;; k = this.zzcuA.hashCode())
    {
      return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      i = this.zzlr.hashCode();
      break;
      j = this.zzls.hashCode();
      break label42;
    }
  }
  
  public final zzj zzK()
  {
    this.zzlq = zzaj.zzi.zzI();
    this.zzlr = null;
    this.zzls = "";
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if ((this.zzlq != null) && (this.zzlq.length > 0))
    {
      int i = 0;
      while (i < this.zzlq.length)
      {
        zzaj.zzi localzzi = this.zzlq[i];
        if (localzzi != null) {
          paramzzbxm.zza(1, localzzi);
        }
        i += 1;
      }
    }
    if (this.zzlr != null) {
      paramzzbxm.zza(2, this.zzlr);
    }
    if ((this.zzls != null) && (!this.zzls.equals(""))) {
      paramzzbxm.zzq(3, this.zzls);
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int i = super.zzu();
    int j = i;
    if (this.zzlq != null)
    {
      j = i;
      if (this.zzlq.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.zzlq.length) {
            break;
          }
          zzaj.zzi localzzi = this.zzlq[k];
          j = i;
          if (localzzi != null) {
            j = i + zzbxm.zzc(1, localzzi);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.zzlr != null) {
      i = j + zzbxm.zzc(2, this.zzlr);
    }
    j = i;
    if (this.zzls != null)
    {
      j = i;
      if (!this.zzls.equals("")) {
        j = i + zzbxm.zzr(3, this.zzls);
      }
    }
    return j;
  }
  
  public final zzj zzw(zzbxl paramzzbxl)
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
        int j = zzbxw.zzb(paramzzbxl, 10);
        if (this.zzlq == null) {}
        zzaj.zzi[] arrayOfzzi;
        for (i = 0;; i = this.zzlq.length)
        {
          arrayOfzzi = new zzaj.zzi[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlq, 0, arrayOfzzi, 0, i);
            j = i;
          }
          while (j < arrayOfzzi.length - 1)
          {
            arrayOfzzi[j] = new zzaj.zzi();
            paramzzbxl.zza(arrayOfzzi[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        arrayOfzzi[j] = new zzaj.zzi();
        paramzzbxl.zza(arrayOfzzi[j]);
        this.zzlq = arrayOfzzi;
        break;
      case 18: 
        if (this.zzlr == null) {
          this.zzlr = new zzaj.zzf();
        }
        paramzzbxl.zza(this.zzlr);
        break;
      }
      this.zzls = paramzzbxl.readString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zzj
 * JD-Core Version:    0.7.0.1
 */