package com.google.a;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ad
  extends d<Integer>
  implements ae.d, bk, RandomAccess
{
  private static final ad bXn;
  private int[] bXo;
  private int size;
  
  static
  {
    ad localad = new ad(new int[0], 0);
    bXn = localad;
    localad.bNd = false;
  }
  
  ad()
  {
    this(new int[10], 0);
  }
  
  private ad(int[] paramArrayOfInt, int paramInt)
  {
    this.bXo = paramArrayOfInt;
    this.size = paramInt;
  }
  
  public static ad GE()
  {
    return bXn;
  }
  
  private void bw(int paramInt1, int paramInt2)
  {
    yL();
    if ((paramInt1 < 0) || (paramInt1 > this.size)) {
      throw new IndexOutOfBoundsException(gH(paramInt1));
    }
    int[] arrayOfInt;
    if (this.size < this.bXo.length)
    {
      arrayOfInt = this.bXo;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
    }
    for (;;)
    {
      this.bXo[paramInt1] = paramInt2;
      this.size += 1;
      this.modCount += 1;
      return;
      arrayOfInt = new int[this.size * 3 / 2 + 1];
      System.arraycopy(this.bXo, 0, arrayOfInt, 0, paramInt1);
      System.arraycopy(this.bXo, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
      this.bXo = arrayOfInt;
    }
  }
  
  private void gG(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size)) {
      throw new IndexOutOfBoundsException(gH(paramInt));
    }
  }
  
  private String gH(int paramInt)
  {
    return "Index:" + paramInt + ", Size:" + this.size;
  }
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    boolean bool = false;
    yL();
    ae.checkNotNull(paramCollection);
    if (!(paramCollection instanceof ad)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (ad)paramCollection;
    } while (paramCollection.size == 0);
    if (2147483647 - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.bXo.length) {
      this.bXo = Arrays.copyOf(this.bXo, i);
    }
    System.arraycopy(paramCollection.bXo, 0, this.bXo, this.size, paramCollection.size);
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
      if (!(paramObject instanceof ad)) {
        return super.equals(paramObject);
      }
      paramObject = (ad)paramObject;
      bool1 = bool2;
    } while (this.size != paramObject.size);
    paramObject = paramObject.bXo;
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label81;
      }
      bool1 = bool2;
      if (this.bXo[i] != paramObject[i]) {
        break;
      }
      i += 1;
    }
    label81:
    return true;
  }
  
  public final ae.d gE(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new ad(Arrays.copyOf(this.bXo, paramInt), this.size);
  }
  
  public final void gF(int paramInt)
  {
    bw(this.size, paramInt);
  }
  
  public final int getInt(int paramInt)
  {
    gG(paramInt);
    return this.bXo[paramInt];
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + this.bXo[i];
      i += 1;
    }
    return j;
  }
  
  public final boolean remove(Object paramObject)
  {
    boolean bool2 = false;
    yL();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.size)
      {
        if (paramObject.equals(Integer.valueOf(this.bXo[i])))
        {
          System.arraycopy(this.bXo, i + 1, this.bXo, i, this.size - i - 1);
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
    yL();
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }
    int[] arrayOfInt = this.bXo;
    System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ad
 * JD-Core Version:    0.7.0.1
 */