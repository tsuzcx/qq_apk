package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<E>
{
  static final Object OT;
  boolean OU;
  long[] OV;
  Object[] OW;
  int mSize;
  
  static
  {
    AppMethodBeat.i(157478);
    OT = new Object();
    AppMethodBeat.o(157478);
  }
  
  static int b(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = paramInt + 0;
    int j = -1;
    while (i - j > 1)
    {
      int k = (i + j) / 2;
      if (paramArrayOfLong[k] < paramLong) {
        j = k;
      } else {
        i = k;
      }
    }
    if (i == paramInt + 0) {
      paramInt = paramInt + 0 ^ 0xFFFFFFFF;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (paramArrayOfLong[i] == paramLong);
    return i ^ 0xFFFFFFFF;
  }
  
  public final void put(long paramLong, E paramE)
  {
    AppMethodBeat.i(157477);
    int i = b(this.OV, this.mSize, paramLong);
    if (i >= 0)
    {
      this.OW[i] = paramE;
      AppMethodBeat.o(157477);
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.OW[j] == OT))
    {
      this.OV[j] = paramLong;
      this.OW[j] = paramE;
      AppMethodBeat.o(157477);
      return;
    }
    i = j;
    Object localObject1;
    Object[] arrayOfObject;
    if (this.OU)
    {
      i = j;
      if (this.mSize >= this.OV.length)
      {
        int m = this.mSize;
        localObject1 = this.OV;
        arrayOfObject = this.OW;
        i = 0;
        int k;
        for (j = 0; i < m; j = k)
        {
          Object localObject2 = arrayOfObject[i];
          k = j;
          if (localObject2 != OT)
          {
            if (i != j)
            {
              localObject1[j] = localObject1[i];
              arrayOfObject[j] = localObject2;
            }
            k = j + 1;
          }
          i += 1;
        }
        this.OU = false;
        this.mSize = j;
        i = b(this.OV, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.OV.length)
    {
      j = a.idealIntArraySize(this.mSize + 1);
      localObject1 = new long[j];
      arrayOfObject = new Object[j];
      System.arraycopy(this.OV, 0, localObject1, 0, this.OV.length);
      System.arraycopy(this.OW, 0, arrayOfObject, 0, this.OW.length);
      this.OV = ((long[])localObject1);
      this.OW = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject1 = this.OV;
      System.arraycopy(localObject1, i, localObject1, i + 1, this.mSize - i);
      localObject1 = this.OW;
      System.arraycopy(localObject1, i, localObject1, i + 1, this.mSize - i);
    }
    this.OV[i] = paramLong;
    this.OW[i] = paramE;
    this.mSize += 1;
    AppMethodBeat.o(157477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.b
 * JD-Core Version:    0.7.0.1
 */