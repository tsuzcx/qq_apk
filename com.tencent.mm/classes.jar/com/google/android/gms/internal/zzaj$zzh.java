package com.google.android.gms.internal;

public final class zzaj$zzh
  extends zzbxn<zzh>
{
  public static final zzbxo<zzak.zza, zzh> zzle = zzbxo.zza(11, zzh.class, 810L);
  private static final zzh[] zzlf = new zzh[0];
  public int[] zzlg;
  public int[] zzlh;
  public int[] zzli;
  public int zzlj;
  public int[] zzlk;
  public int zzll;
  public int zzlm;
  
  public zzaj$zzh()
  {
    zzH();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzh)) {
        return false;
      }
      paramObject = (zzh)paramObject;
      if (!zzbxr.equals(this.zzlg, paramObject.zzlg)) {
        return false;
      }
      if (!zzbxr.equals(this.zzlh, paramObject.zzlh)) {
        return false;
      }
      if (!zzbxr.equals(this.zzli, paramObject.zzli)) {
        return false;
      }
      if (this.zzlj != paramObject.zzlj) {
        return false;
      }
      if (!zzbxr.equals(this.zzlk, paramObject.zzlk)) {
        return false;
      }
      if (this.zzll != paramObject.zzll) {
        return false;
      }
      if (this.zzlm != paramObject.zzlm) {
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
    int k = zzbxr.hashCode(this.zzlg);
    int m = zzbxr.hashCode(this.zzlh);
    int n = zzbxr.hashCode(this.zzli);
    int i1 = this.zzlj;
    int i2 = zzbxr.hashCode(this.zzlk);
    int i3 = this.zzll;
    int i4 = this.zzlm;
    if ((this.zzcuA == null) || (this.zzcuA.isEmpty())) {}
    for (int i = 0;; i = this.zzcuA.hashCode()) {
      return i + ((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31;
    }
  }
  
  public final zzh zzH()
  {
    this.zzlg = zzbxw.zzcuO;
    this.zzlh = zzbxw.zzcuO;
    this.zzli = zzbxw.zzcuO;
    this.zzlj = 0;
    this.zzlk = zzbxw.zzcuO;
    this.zzll = 0;
    this.zzlm = 0;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    int j = 0;
    int i;
    if ((this.zzlg != null) && (this.zzlg.length > 0))
    {
      i = 0;
      while (i < this.zzlg.length)
      {
        paramzzbxm.zzJ(1, this.zzlg[i]);
        i += 1;
      }
    }
    if ((this.zzlh != null) && (this.zzlh.length > 0))
    {
      i = 0;
      while (i < this.zzlh.length)
      {
        paramzzbxm.zzJ(2, this.zzlh[i]);
        i += 1;
      }
    }
    if ((this.zzli != null) && (this.zzli.length > 0))
    {
      i = 0;
      while (i < this.zzli.length)
      {
        paramzzbxm.zzJ(3, this.zzli[i]);
        i += 1;
      }
    }
    if (this.zzlj != 0) {
      paramzzbxm.zzJ(4, this.zzlj);
    }
    if ((this.zzlk != null) && (this.zzlk.length > 0))
    {
      i = j;
      while (i < this.zzlk.length)
      {
        paramzzbxm.zzJ(5, this.zzlk[i]);
        i += 1;
      }
    }
    if (this.zzll != 0) {
      paramzzbxm.zzJ(6, this.zzll);
    }
    if (this.zzlm != 0) {
      paramzzbxm.zzJ(7, this.zzlm);
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int k = super.zzu();
    int i;
    if ((this.zzlg != null) && (this.zzlg.length > 0))
    {
      i = 0;
      j = 0;
      while (i < this.zzlg.length)
      {
        j += zzbxm.zzrf(this.zzlg[i]);
        i += 1;
      }
    }
    for (int j = k + j + this.zzlg.length * 1;; j = k)
    {
      i = j;
      if (this.zzlh != null)
      {
        i = j;
        if (this.zzlh.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.zzlh.length)
          {
            k += zzbxm.zzrf(this.zzlh[i]);
            i += 1;
          }
          i = j + k + this.zzlh.length * 1;
        }
      }
      j = i;
      if (this.zzli != null)
      {
        j = i;
        if (this.zzli.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.zzli.length)
          {
            k += zzbxm.zzrf(this.zzli[j]);
            j += 1;
          }
          j = i + k + this.zzli.length * 1;
        }
      }
      i = j;
      if (this.zzlj != 0) {
        i = j + zzbxm.zzL(4, this.zzlj);
      }
      j = i;
      if (this.zzlk != null)
      {
        j = i;
        if (this.zzlk.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.zzlk.length)
          {
            k += zzbxm.zzrf(this.zzlk[j]);
            j += 1;
          }
          j = i + k + this.zzlk.length * 1;
        }
      }
      i = j;
      if (this.zzll != 0) {
        i = j + zzbxm.zzL(6, this.zzll);
      }
      j = i;
      if (this.zzlm != 0) {
        j = i + zzbxm.zzL(7, this.zzlm);
      }
      return j;
    }
  }
  
  public final zzh zzu(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      int j;
      int[] arrayOfInt;
      int k;
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        j = zzbxw.zzb(paramzzbxl, 8);
        if (this.zzlg == null) {}
        for (i = 0;; i = this.zzlg.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlg, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        arrayOfInt[j] = paramzzbxl.zzaer();
        this.zzlg = arrayOfInt;
        break;
      case 10: 
        k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0)
        {
          paramzzbxl.zzaer();
          j += 1;
        }
        paramzzbxl.zzrb(i);
        if (this.zzlg == null) {}
        for (i = 0;; i = this.zzlg.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlg, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            j += 1;
          }
        }
        this.zzlg = arrayOfInt;
        paramzzbxl.zzra(k);
        break;
      case 16: 
        j = zzbxw.zzb(paramzzbxl, 16);
        if (this.zzlh == null) {}
        for (i = 0;; i = this.zzlh.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlh, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        arrayOfInt[j] = paramzzbxl.zzaer();
        this.zzlh = arrayOfInt;
        break;
      case 18: 
        k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0)
        {
          paramzzbxl.zzaer();
          j += 1;
        }
        paramzzbxl.zzrb(i);
        if (this.zzlh == null) {}
        for (i = 0;; i = this.zzlh.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlh, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            j += 1;
          }
        }
        this.zzlh = arrayOfInt;
        paramzzbxl.zzra(k);
        break;
      case 24: 
        j = zzbxw.zzb(paramzzbxl, 24);
        if (this.zzli == null) {}
        for (i = 0;; i = this.zzli.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzli, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        arrayOfInt[j] = paramzzbxl.zzaer();
        this.zzli = arrayOfInt;
        break;
      case 26: 
        k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0)
        {
          paramzzbxl.zzaer();
          j += 1;
        }
        paramzzbxl.zzrb(i);
        if (this.zzli == null) {}
        for (i = 0;; i = this.zzli.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzli, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            j += 1;
          }
        }
        this.zzli = arrayOfInt;
        paramzzbxl.zzra(k);
        break;
      case 32: 
        this.zzlj = paramzzbxl.zzaer();
        break;
      case 40: 
        j = zzbxw.zzb(paramzzbxl, 40);
        if (this.zzlk == null) {}
        for (i = 0;; i = this.zzlk.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlk, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        arrayOfInt[j] = paramzzbxl.zzaer();
        this.zzlk = arrayOfInt;
        break;
      case 42: 
        k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0)
        {
          paramzzbxl.zzaer();
          j += 1;
        }
        paramzzbxl.zzrb(i);
        if (this.zzlk == null) {}
        for (i = 0;; i = this.zzlk.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlk, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramzzbxl.zzaer();
            j += 1;
          }
        }
        this.zzlk = arrayOfInt;
        paramzzbxl.zzra(k);
        break;
      case 48: 
        this.zzll = paramzzbxl.zzaer();
        break;
      }
      this.zzlm = paramzzbxl.zzaer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zzh
 * JD-Core Version:    0.7.0.1
 */