package com.google.b;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class bd
  extends d<Integer>
  implements be.d, RandomAccess
{
  private static final bd bZf;
  private int[] bZg;
  private int size;
  
  static
  {
    bd localbd = new bd(new int[0], 0);
    bZf = localbd;
    localbd.Al();
  }
  
  bd()
  {
    this(new int[10], 0);
  }
  
  private bd(int[] paramArrayOfInt, int paramInt)
  {
    this.bZg = paramArrayOfInt;
    this.size = paramInt;
  }
  
  public static bd Il()
  {
    return bZf;
  }
  
  private void bP(int paramInt1, int paramInt2)
  {
    Am();
    if ((paramInt1 < 0) || (paramInt1 > this.size)) {
      throw new IndexOutOfBoundsException(hz(paramInt1));
    }
    int[] arrayOfInt;
    if (this.size < this.bZg.length)
    {
      arrayOfInt = this.bZg;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
    }
    for (;;)
    {
      this.bZg[paramInt1] = paramInt2;
      this.size += 1;
      this.modCount += 1;
      return;
      arrayOfInt = new int[this.size * 3 / 2 + 1];
      System.arraycopy(this.bZg, 0, arrayOfInt, 0, paramInt1);
      System.arraycopy(this.bZg, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
      this.bZg = arrayOfInt;
    }
  }
  
  private void hy(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size)) {
      throw new IndexOutOfBoundsException(hz(paramInt));
    }
  }
  
  private String hz(int paramInt)
  {
    return "Index:" + paramInt + ", Size:" + this.size;
  }
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    boolean bool = false;
    Am();
    be.checkNotNull(paramCollection);
    if (!(paramCollection instanceof bd)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (bd)paramCollection;
    } while (paramCollection.size == 0);
    if (2147483647 - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.bZg.length) {
      this.bZg = Arrays.copyOf(this.bZg, i);
    }
    System.arraycopy(paramCollection.bZg, 0, this.bZg, this.size, paramCollection.size);
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
      if (!(paramObject instanceof bd)) {
        return super.equals(paramObject);
      }
      paramObject = (bd)paramObject;
      bool1 = bool2;
    } while (this.size != paramObject.size);
    paramObject = paramObject.bZg;
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label81;
      }
      bool1 = bool2;
      if (this.bZg[i] != paramObject[i]) {
        break;
      }
      i += 1;
    }
    label81:
    return true;
  }
  
  public final int getInt(int paramInt)
  {
    hy(paramInt);
    return this.bZg[paramInt];
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + this.bZg[i];
      i += 1;
    }
    return j;
  }
  
  public final be.d hw(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new bd(Arrays.copyOf(this.bZg, paramInt), this.size);
  }
  
  public final void hx(int paramInt)
  {
    bP(this.size, paramInt);
  }
  
  public final boolean remove(Object paramObject)
  {
    boolean bool2 = false;
    Am();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.size)
      {
        if (paramObject.equals(Integer.valueOf(this.bZg[i])))
        {
          System.arraycopy(this.bZg, i + 1, this.bZg, i, this.size - i - 1);
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
    Am();
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }
    int[] arrayOfInt = this.bZg;
    System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.bd
 * JD-Core Version:    0.7.0.1
 */