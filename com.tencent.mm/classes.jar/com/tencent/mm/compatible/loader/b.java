package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<E>
{
  static final Object EU;
  boolean EV;
  long[] EW;
  Object[] EX;
  int mSize;
  
  static
  {
    AppMethodBeat.i(51925);
    EU = new Object();
    AppMethodBeat.o(51925);
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
    AppMethodBeat.i(51924);
    int i = b(this.EW, this.mSize, paramLong);
    if (i >= 0)
    {
      this.EX[i] = paramE;
      AppMethodBeat.o(51924);
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.EX[j] == EU))
    {
      this.EW[j] = paramLong;
      this.EX[j] = paramE;
      AppMethodBeat.o(51924);
      return;
    }
    i = j;
    Object localObject1;
    Object[] arrayOfObject;
    if (this.EV)
    {
      i = j;
      if (this.mSize >= this.EW.length)
      {
        int m = this.mSize;
        localObject1 = this.EW;
        arrayOfObject = this.EX;
        i = 0;
        int k;
        for (j = 0; i < m; j = k)
        {
          Object localObject2 = arrayOfObject[i];
          k = j;
          if (localObject2 != EU)
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
        this.EV = false;
        this.mSize = j;
        i = b(this.EW, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.EW.length)
    {
      j = a.idealIntArraySize(this.mSize + 1);
      localObject1 = new long[j];
      arrayOfObject = new Object[j];
      System.arraycopy(this.EW, 0, localObject1, 0, this.EW.length);
      System.arraycopy(this.EX, 0, arrayOfObject, 0, this.EX.length);
      this.EW = ((long[])localObject1);
      this.EX = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject1 = this.EW;
      System.arraycopy(localObject1, i, localObject1, i + 1, this.mSize - i);
      localObject1 = this.EX;
      System.arraycopy(localObject1, i, localObject1, i + 1, this.mSize - i);
    }
    this.EW[i] = paramLong;
    this.EX[i] = paramE;
    this.mSize += 1;
    AppMethodBeat.o(51924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.b
 * JD-Core Version:    0.7.0.1
 */