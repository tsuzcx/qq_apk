package com.google.android.gms.internal;

public final class zzbxp
  implements Cloneable
{
  private static final zzbxq zzcuC = new zzbxq();
  private int mSize;
  private boolean zzcuD = false;
  private int[] zzcuE;
  private zzbxq[] zzcuF;
  
  zzbxp()
  {
    this(10);
  }
  
  zzbxp(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.zzcuE = new int[paramInt];
    this.zzcuF = new zzbxq[paramInt];
    this.mSize = 0;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean zza(zzbxq[] paramArrayOfzzbxq1, zzbxq[] paramArrayOfzzbxq2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzbxq1[i].equals(paramArrayOfzzbxq2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int zzrp(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.zzcuE[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (m <= paramInt) {
          return j;
        }
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    return j;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbxp)) {
        return false;
      }
      paramObject = (zzbxp)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
    } while ((zza(this.zzcuE, paramObject.zzcuE, this.mSize)) && (zza(this.zzcuF, paramObject.zzcuF, this.mSize)));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.zzcuE[i]) * 31 + this.zzcuF[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  final int size()
  {
    return this.mSize;
  }
  
  final void zza(int paramInt, zzbxq paramzzbxq)
  {
    int i = zzrp(paramInt);
    if (i >= 0)
    {
      this.zzcuF[i] = paramzzbxq;
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < this.mSize) && (this.zzcuF[i] == zzcuC))
    {
      this.zzcuE[i] = paramInt;
      this.zzcuF[i] = paramzzbxq;
      return;
    }
    if (this.mSize >= this.zzcuE.length)
    {
      int j = idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      zzbxq[] arrayOfzzbxq = new zzbxq[j];
      System.arraycopy(this.zzcuE, 0, arrayOfInt, 0, this.zzcuE.length);
      System.arraycopy(this.zzcuF, 0, arrayOfzzbxq, 0, this.zzcuF.length);
      this.zzcuE = arrayOfInt;
      this.zzcuF = arrayOfzzbxq;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.zzcuE, i, this.zzcuE, i + 1, this.mSize - i);
      System.arraycopy(this.zzcuF, i, this.zzcuF, i + 1, this.mSize - i);
    }
    this.zzcuE[i] = paramInt;
    this.zzcuF[i] = paramzzbxq;
    this.mSize += 1;
  }
  
  public final zzbxp zzaeI()
  {
    int j = size();
    zzbxp localzzbxp = new zzbxp(j);
    System.arraycopy(this.zzcuE, 0, localzzbxp.zzcuE, 0, j);
    int i = 0;
    while (i < j)
    {
      if (this.zzcuF[i] != null) {
        localzzbxp.zzcuF[i] = ((zzbxq)this.zzcuF[i].clone());
      }
      i += 1;
    }
    localzzbxp.mSize = j;
    return localzzbxp;
  }
  
  final zzbxq zzrn(int paramInt)
  {
    paramInt = zzrp(paramInt);
    if ((paramInt < 0) || (this.zzcuF[paramInt] == zzcuC)) {
      return null;
    }
    return this.zzcuF[paramInt];
  }
  
  final zzbxq zzro(int paramInt)
  {
    return this.zzcuF[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxp
 * JD-Core Version:    0.7.0.1
 */