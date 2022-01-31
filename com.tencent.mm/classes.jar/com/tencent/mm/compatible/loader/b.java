package com.tencent.mm.compatible.loader;

public final class b<E>
{
  static final Object Ee = new Object();
  boolean Ef;
  long[] Eg;
  Object[] Eh;
  int mSize;
  
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
    int i = b(this.Eg, this.mSize, paramLong);
    if (i >= 0)
    {
      this.Eh[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.Eh[j] == Ee))
    {
      this.Eg[j] = paramLong;
      this.Eh[j] = paramE;
      return;
    }
    i = j;
    long[] arrayOfLong;
    Object[] arrayOfObject;
    if (this.Ef)
    {
      i = j;
      if (this.mSize >= this.Eg.length)
      {
        int m = this.mSize;
        arrayOfLong = this.Eg;
        arrayOfObject = this.Eh;
        i = 0;
        int k;
        for (j = 0; i < m; j = k)
        {
          Object localObject = arrayOfObject[i];
          k = j;
          if (localObject != Ee)
          {
            if (i != j)
            {
              arrayOfLong[j] = arrayOfLong[i];
              arrayOfObject[j] = localObject;
            }
            k = j + 1;
          }
          i += 1;
        }
        this.Ef = false;
        this.mSize = j;
        i = b(this.Eg, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.Eg.length)
    {
      j = a.idealIntArraySize(this.mSize + 1);
      arrayOfLong = new long[j];
      arrayOfObject = new Object[j];
      System.arraycopy(this.Eg, 0, arrayOfLong, 0, this.Eg.length);
      System.arraycopy(this.Eh, 0, arrayOfObject, 0, this.Eh.length);
      this.Eg = arrayOfLong;
      this.Eh = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.Eg, i, this.Eg, i + 1, this.mSize - i);
      System.arraycopy(this.Eh, i, this.Eh, i + 1, this.mSize - i);
    }
    this.Eg[i] = paramLong;
    this.Eh[i] = paramE;
    this.mSize += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.b
 * JD-Core Version:    0.7.0.1
 */