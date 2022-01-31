package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaca
  implements Cloneable
{
  private static final zzacb zzbxa;
  private int mSize;
  private boolean zzbxb;
  private int[] zzbxc;
  private zzacb[] zzbxd;
  
  static
  {
    AppMethodBeat.i(3493);
    zzbxa = new zzacb();
    AppMethodBeat.o(3493);
  }
  
  zzaca()
  {
    this(10);
  }
  
  private zzaca(int paramInt)
  {
    AppMethodBeat.i(3487);
    this.zzbxb = false;
    paramInt = idealIntArraySize(paramInt);
    this.zzbxc = new int[paramInt];
    this.zzbxd = new zzacb[paramInt];
    this.mSize = 0;
    AppMethodBeat.o(3487);
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
  
  private final int zzav(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.zzbxc[k];
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
    AppMethodBeat.i(3490);
    if (paramObject == this)
    {
      AppMethodBeat.o(3490);
      return true;
    }
    if (!(paramObject instanceof zzaca))
    {
      AppMethodBeat.o(3490);
      return false;
    }
    paramObject = (zzaca)paramObject;
    if (this.mSize != paramObject.mSize)
    {
      AppMethodBeat.o(3490);
      return false;
    }
    Object localObject = this.zzbxc;
    int[] arrayOfInt = paramObject.zzbxc;
    int j = this.mSize;
    int i = 0;
    if (i < j) {
      if (localObject[i] != arrayOfInt[i])
      {
        i = 0;
        label95:
        if (i == 0) {
          break label173;
        }
        localObject = this.zzbxd;
        paramObject = paramObject.zzbxd;
        j = this.mSize;
        i = 0;
        label117:
        if (i >= j) {
          break label168;
        }
        if (localObject[i].equals(paramObject[i])) {
          break label161;
        }
      }
    }
    label161:
    label168:
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label173;
      }
      AppMethodBeat.o(3490);
      return true;
      i += 1;
      break;
      i = 1;
      break label95;
      i += 1;
      break label117;
    }
    label173:
    AppMethodBeat.o(3490);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(3491);
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.zzbxc[i]) * 31 + this.zzbxd[i].hashCode();
      i += 1;
    }
    AppMethodBeat.o(3491);
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
  
  final void zza(int paramInt, zzacb paramzzacb)
  {
    AppMethodBeat.i(3489);
    int i = zzav(paramInt);
    if (i >= 0)
    {
      this.zzbxd[i] = paramzzacb;
      AppMethodBeat.o(3489);
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < this.mSize) && (this.zzbxd[i] == zzbxa))
    {
      this.zzbxc[i] = paramInt;
      this.zzbxd[i] = paramzzacb;
      AppMethodBeat.o(3489);
      return;
    }
    Object localObject;
    if (this.mSize >= this.zzbxc.length)
    {
      int j = idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      zzacb[] arrayOfzzacb = new zzacb[j];
      System.arraycopy(this.zzbxc, 0, localObject, 0, this.zzbxc.length);
      System.arraycopy(this.zzbxd, 0, arrayOfzzacb, 0, this.zzbxd.length);
      this.zzbxc = ((int[])localObject);
      this.zzbxd = arrayOfzzacb;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.zzbxc;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.zzbxd;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.zzbxc[i] = paramInt;
    this.zzbxd[i] = paramzzacb;
    this.mSize += 1;
    AppMethodBeat.o(3489);
  }
  
  final zzacb zzat(int paramInt)
  {
    AppMethodBeat.i(3488);
    paramInt = zzav(paramInt);
    if ((paramInt < 0) || (this.zzbxd[paramInt] == zzbxa))
    {
      AppMethodBeat.o(3488);
      return null;
    }
    zzacb localzzacb = this.zzbxd[paramInt];
    AppMethodBeat.o(3488);
    return localzzacb;
  }
  
  final zzacb zzau(int paramInt)
  {
    return this.zzbxd[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaca
 * JD-Core Version:    0.7.0.1
 */