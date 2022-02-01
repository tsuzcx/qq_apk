package com.google.d;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class br
  extends d<Long>
  implements bj.h, ct, RandomAccess
{
  private static final br dTq;
  private long[] dTr;
  private int size;
  
  static
  {
    br localbr = new br(new long[0], 0);
    dTq = localbr;
    localbr.ZP();
  }
  
  br()
  {
    this(new long[10], 0);
  }
  
  private br(long[] paramArrayOfLong, int paramInt)
  {
    this.dTr = paramArrayOfLong;
    this.size = paramInt;
  }
  
  public static br aiy()
  {
    return dTq;
  }
  
  private void jG(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size)) {
      throw new IndexOutOfBoundsException(jH(paramInt));
    }
  }
  
  private String jH(int paramInt)
  {
    return "Index:" + paramInt + ", Size:" + this.size;
  }
  
  private void v(int paramInt, long paramLong)
  {
    ZQ();
    if ((paramInt < 0) || (paramInt > this.size)) {
      throw new IndexOutOfBoundsException(jH(paramInt));
    }
    long[] arrayOfLong;
    if (this.size < this.dTr.length)
    {
      arrayOfLong = this.dTr;
      System.arraycopy(arrayOfLong, paramInt, arrayOfLong, paramInt + 1, this.size - paramInt);
    }
    for (;;)
    {
      this.dTr[paramInt] = paramLong;
      this.size += 1;
      this.modCount += 1;
      return;
      arrayOfLong = new long[this.size * 3 / 2 + 1];
      System.arraycopy(this.dTr, 0, arrayOfLong, 0, paramInt);
      System.arraycopy(this.dTr, paramInt, arrayOfLong, paramInt + 1, this.size - paramInt);
      this.dTr = arrayOfLong;
    }
  }
  
  public final boolean addAll(Collection<? extends Long> paramCollection)
  {
    boolean bool = false;
    ZQ();
    bj.checkNotNull(paramCollection);
    if (!(paramCollection instanceof br)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (br)paramCollection;
    } while (paramCollection.size == 0);
    if (2147483647 - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.dTr.length) {
      this.dTr = Arrays.copyOf(this.dTr, i);
    }
    System.arraycopy(paramCollection.dTr, 0, this.dTr, this.size, paramCollection.size);
    this.size = i;
    this.modCount += 1;
    return true;
  }
  
  public final void da(long paramLong)
  {
    v(this.size, paramLong);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      return bool1;
      if (!(paramObject instanceof br)) {
        return super.equals(paramObject);
      }
      paramObject = (br)paramObject;
      bool1 = bool2;
    } while (this.size != paramObject.size);
    paramObject = paramObject.dTr;
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label82;
      }
      bool1 = bool2;
      if (this.dTr[i] != paramObject[i]) {
        break;
      }
      i += 1;
    }
    label82:
    return true;
  }
  
  public final long getLong(int paramInt)
  {
    jG(paramInt);
    return this.dTr[paramInt];
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + bj.hashLong(this.dTr[i]);
      i += 1;
    }
    return j;
  }
  
  public final bj.h lk(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new br(Arrays.copyOf(this.dTr, paramInt), this.size);
  }
  
  public final boolean remove(Object paramObject)
  {
    boolean bool2 = false;
    ZQ();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.size)
      {
        if (paramObject.equals(Long.valueOf(this.dTr[i])))
        {
          System.arraycopy(this.dTr, i + 1, this.dTr, i, this.size - i - 1);
          this.size -= 1;
          this.modCount += 1;
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    ZQ();
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }
    long[] arrayOfLong = this.dTr;
    System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.br
 * JD-Core Version:    0.7.0.1
 */