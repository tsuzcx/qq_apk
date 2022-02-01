package com.google.d;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class an
  extends d<Double>
  implements bj.b, ct, RandomAccess
{
  private static final an dPG;
  private double[] dPH;
  private int size;
  
  static
  {
    an localan = new an(new double[0], 0);
    dPG = localan;
    localan.ZP();
  }
  
  an()
  {
    this(new double[10], 0);
  }
  
  private an(double[] paramArrayOfDouble, int paramInt)
  {
    this.dPH = paramArrayOfDouble;
    this.size = paramInt;
  }
  
  public static an ahv()
  {
    return dPG;
  }
  
  private void e(int paramInt, double paramDouble)
  {
    ZQ();
    if ((paramInt < 0) || (paramInt > this.size)) {
      throw new IndexOutOfBoundsException(jH(paramInt));
    }
    double[] arrayOfDouble;
    if (this.size < this.dPH.length)
    {
      arrayOfDouble = this.dPH;
      System.arraycopy(arrayOfDouble, paramInt, arrayOfDouble, paramInt + 1, this.size - paramInt);
    }
    for (;;)
    {
      this.dPH[paramInt] = paramDouble;
      this.size += 1;
      this.modCount += 1;
      return;
      arrayOfDouble = new double[this.size * 3 / 2 + 1];
      System.arraycopy(this.dPH, 0, arrayOfDouble, 0, paramInt);
      System.arraycopy(this.dPH, paramInt, arrayOfDouble, paramInt + 1, this.size - paramInt);
      this.dPH = arrayOfDouble;
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
  
  public final boolean addAll(Collection<? extends Double> paramCollection)
  {
    boolean bool = false;
    ZQ();
    bj.checkNotNull(paramCollection);
    if (!(paramCollection instanceof an)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (an)paramCollection;
    } while (paramCollection.size == 0);
    if (2147483647 - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.dPH.length) {
      this.dPH = Arrays.copyOf(this.dPH, i);
    }
    System.arraycopy(paramCollection.dPH, 0, this.dPH, this.size, paramCollection.size);
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
      if (!(paramObject instanceof an)) {
        return super.equals(paramObject);
      }
      paramObject = (an)paramObject;
      bool1 = bool2;
    } while (this.size != paramObject.size);
    paramObject = paramObject.dPH;
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label88;
      }
      bool1 = bool2;
      if (Double.doubleToLongBits(this.dPH[i]) != Double.doubleToLongBits(paramObject[i])) {
        break;
      }
      i += 1;
    }
    label88:
    return true;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + bj.hashLong(Double.doubleToLongBits(this.dPH[i]));
      i += 1;
    }
    return j;
  }
  
  public final bj.b le(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new an(Arrays.copyOf(this.dPH, paramInt), this.size);
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
        if (paramObject.equals(Double.valueOf(this.dPH[i])))
        {
          System.arraycopy(this.dPH, i + 1, this.dPH, i, this.size - i - 1);
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
    double[] arrayOfDouble = this.dPH;
    System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.size;
  }
  
  public final void w(double paramDouble)
  {
    e(this.size, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.an
 * JD-Core Version:    0.7.0.1
 */