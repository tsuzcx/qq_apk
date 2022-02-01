package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<E>
{
  static final Object LS;
  boolean LT;
  long[] LU;
  Object[] LV;
  int mSize;
  
  static
  {
    AppMethodBeat.i(157478);
    LS = new Object();
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
    int i = b(this.LU, this.mSize, paramLong);
    if (i >= 0)
    {
      this.LV[i] = paramE;
      AppMethodBeat.o(157477);
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.LV[j] == LS))
    {
      this.LU[j] = paramLong;
      this.LV[j] = paramE;
      AppMethodBeat.o(157477);
      return;
    }
    i = j;
    Object localObject1;
    Object[] arrayOfObject;
    if (this.LT)
    {
      i = j;
      if (this.mSize >= this.LU.length)
      {
        int m = this.mSize;
        localObject1 = this.LU;
        arrayOfObject = this.LV;
        i = 0;
        int k;
        for (j = 0; i < m; j = k)
        {
          Object localObject2 = arrayOfObject[i];
          k = j;
          if (localObject2 != LS)
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
        this.LT = false;
        this.mSize = j;
        i = b(this.LU, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.LU.length)
    {
      j = a.idealIntArraySize(this.mSize + 1);
      localObject1 = new long[j];
      arrayOfObject = new Object[j];
      System.arraycopy(this.LU, 0, localObject1, 0, this.LU.length);
      System.arraycopy(this.LV, 0, arrayOfObject, 0, this.LV.length);
      this.LU = ((long[])localObject1);
      this.LV = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject1 = this.LU;
      System.arraycopy(localObject1, i, localObject1, i + 1, this.mSize - i);
      localObject1 = this.LV;
      System.arraycopy(localObject1, i, localObject1, i + 1, this.mSize - i);
    }
    this.LU[i] = paramLong;
    this.LV[i] = paramE;
    this.mSize += 1;
    AppMethodBeat.o(157477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.b
 * JD-Core Version:    0.7.0.1
 */