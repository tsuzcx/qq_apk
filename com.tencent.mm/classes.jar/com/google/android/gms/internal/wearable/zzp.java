package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzp
  implements Cloneable
{
  private static final zzq zzhe;
  private int mSize;
  private boolean zzhf;
  private int[] zzhg;
  private zzq[] zzhh;
  
  static
  {
    AppMethodBeat.i(100741);
    zzhe = new zzq();
    AppMethodBeat.o(100741);
  }
  
  zzp()
  {
    this(10);
  }
  
  private zzp(int paramInt)
  {
    AppMethodBeat.i(100735);
    this.zzhf = false;
    paramInt = idealIntArraySize(paramInt);
    this.zzhg = new int[paramInt];
    this.zzhh = new zzq[paramInt];
    this.mSize = 0;
    AppMethodBeat.o(100735);
  }
  
  private static int idealIntArraySize(int paramInt)
  {
    int j = paramInt << 2;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  private final int zzq(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.zzhg[k];
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
    AppMethodBeat.i(100738);
    if (paramObject == this)
    {
      AppMethodBeat.o(100738);
      return true;
    }
    if (!(paramObject instanceof zzp))
    {
      AppMethodBeat.o(100738);
      return false;
    }
    paramObject = (zzp)paramObject;
    if (this.mSize != paramObject.mSize)
    {
      AppMethodBeat.o(100738);
      return false;
    }
    Object localObject = this.zzhg;
    int[] arrayOfInt = paramObject.zzhg;
    int j = this.mSize;
    int i = 0;
    if (i < j) {
      if (localObject[i] != arrayOfInt[i])
      {
        i = 0;
        label91:
        if (i == 0) {
          break label168;
        }
        localObject = this.zzhh;
        paramObject = paramObject.zzhh;
        j = this.mSize;
        i = 0;
        label113:
        if (i >= j) {
          break label163;
        }
        if (localObject[i].equals(paramObject[i])) {
          break label156;
        }
      }
    }
    label156:
    label163:
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label168;
      }
      AppMethodBeat.o(100738);
      return true;
      i += 1;
      break;
      i = 1;
      break label91;
      i += 1;
      break label113;
    }
    label168:
    AppMethodBeat.o(100738);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(100739);
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.zzhg[i]) * 31 + this.zzhh[i].hashCode();
      i += 1;
    }
    AppMethodBeat.o(100739);
    return j;
  }
  
  public final boolean isEmpty()
  {
    return this.mSize == 0;
  }
  
  final int size()
  {
    return this.mSize;
  }
  
  final void zza(int paramInt, zzq paramzzq)
  {
    AppMethodBeat.i(100737);
    int i = zzq(paramInt);
    if (i >= 0)
    {
      this.zzhh[i] = paramzzq;
      AppMethodBeat.o(100737);
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < this.mSize) && (this.zzhh[i] == zzhe))
    {
      this.zzhg[i] = paramInt;
      this.zzhh[i] = paramzzq;
      AppMethodBeat.o(100737);
      return;
    }
    Object localObject;
    if (this.mSize >= this.zzhg.length)
    {
      int j = idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      zzq[] arrayOfzzq = new zzq[j];
      System.arraycopy(this.zzhg, 0, localObject, 0, this.zzhg.length);
      System.arraycopy(this.zzhh, 0, arrayOfzzq, 0, this.zzhh.length);
      this.zzhg = ((int[])localObject);
      this.zzhh = arrayOfzzq;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.zzhg;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.zzhh;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.zzhg[i] = paramInt;
    this.zzhh[i] = paramzzq;
    this.mSize += 1;
    AppMethodBeat.o(100737);
  }
  
  final zzq zzo(int paramInt)
  {
    AppMethodBeat.i(100736);
    paramInt = zzq(paramInt);
    if ((paramInt < 0) || (this.zzhh[paramInt] == zzhe))
    {
      AppMethodBeat.o(100736);
      return null;
    }
    zzq localzzq = this.zzhh[paramInt];
    AppMethodBeat.o(100736);
    return localzzq;
  }
  
  final zzq zzp(int paramInt)
  {
    return this.zzhh[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzp
 * JD-Core Version:    0.7.0.1
 */