package com.google.d;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class bi
  extends d<Integer>
  implements bj.g, ct, RandomAccess
{
  private static final bi dSP;
  private int[] dSQ;
  private int size;
  
  static
  {
    bi localbi = new bi(new int[0], 0);
    dSP = localbi;
    localbi.ZP();
  }
  
  bi()
  {
    this(new int[10], 0);
  }
  
  private bi(int[] paramArrayOfInt, int paramInt)
  {
    this.dSQ = paramArrayOfInt;
    this.size = paramInt;
  }
  
  public static bi aih()
  {
    return dSP;
  }
  
  private void cQ(int paramInt1, int paramInt2)
  {
    ZQ();
    if ((paramInt1 < 0) || (paramInt1 > this.size)) {
      throw new IndexOutOfBoundsException(jH(paramInt1));
    }
    int[] arrayOfInt;
    if (this.size < this.dSQ.length)
    {
      arrayOfInt = this.dSQ;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
    }
    for (;;)
    {
      this.dSQ[paramInt1] = paramInt2;
      this.size += 1;
      this.modCount += 1;
      return;
      arrayOfInt = new int[this.size * 3 / 2 + 1];
      System.arraycopy(this.dSQ, 0, arrayOfInt, 0, paramInt1);
      System.arraycopy(this.dSQ, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
      this.dSQ = arrayOfInt;
    }
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
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    boolean bool = false;
    ZQ();
    bj.checkNotNull(paramCollection);
    if (!(paramCollection instanceof bi)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (bi)paramCollection;
    } while (paramCollection.size == 0);
    if (2147483647 - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.dSQ.length) {
      this.dSQ = Arrays.copyOf(this.dSQ, i);
    }
    System.arraycopy(paramCollection.dSQ, 0, this.dSQ, this.size, paramCollection.size);
    this.size = i;
    this.modCount += 1;
    return true;
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
      if (!(paramObject instanceof bi)) {
        return super.equals(paramObject);
      }
      paramObject = (bi)paramObject;
      bool1 = bool2;
    } while (this.size != paramObject.size);
    paramObject = paramObject.dSQ;
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label81;
      }
      bool1 = bool2;
      if (this.dSQ[i] != paramObject[i]) {
        break;
      }
      i += 1;
    }
    label81:
    return true;
  }
  
  public final int getInt(int paramInt)
  {
    jG(paramInt);
    return this.dSQ[paramInt];
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + this.dSQ[i];
      i += 1;
    }
    return j;
  }
  
  public final bj.g li(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new bi(Arrays.copyOf(this.dSQ, paramInt), this.size);
  }
  
  public final void lj(int paramInt)
  {
    cQ(this.size, paramInt);
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
        if (paramObject.equals(Integer.valueOf(this.dSQ[i])))
        {
          System.arraycopy(this.dSQ, i + 1, this.dSQ, i, this.size - i - 1);
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
    int[] arrayOfInt = this.dSQ;
    System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bi
 * JD-Core Version:    0.7.0.1
 */