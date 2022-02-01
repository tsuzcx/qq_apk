package com.google.d;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class bb
  extends d<Float>
  implements bj.f, ct, RandomAccess
{
  private static final bb dRE;
  private float[] dRF;
  private int size;
  
  static
  {
    bb localbb = new bb(new float[0], 0);
    dRE = localbb;
    localbb.ZP();
  }
  
  bb()
  {
    this(new float[10], 0);
  }
  
  private bb(float[] paramArrayOfFloat, int paramInt)
  {
    this.dRF = paramArrayOfFloat;
    this.size = paramInt;
  }
  
  public static bb ahU()
  {
    return dRE;
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
  
  private void m(int paramInt, float paramFloat)
  {
    ZQ();
    if ((paramInt < 0) || (paramInt > this.size)) {
      throw new IndexOutOfBoundsException(jH(paramInt));
    }
    float[] arrayOfFloat;
    if (this.size < this.dRF.length)
    {
      arrayOfFloat = this.dRF;
      System.arraycopy(arrayOfFloat, paramInt, arrayOfFloat, paramInt + 1, this.size - paramInt);
    }
    for (;;)
    {
      this.dRF[paramInt] = paramFloat;
      this.size += 1;
      this.modCount += 1;
      return;
      arrayOfFloat = new float[this.size * 3 / 2 + 1];
      System.arraycopy(this.dRF, 0, arrayOfFloat, 0, paramInt);
      System.arraycopy(this.dRF, paramInt, arrayOfFloat, paramInt + 1, this.size - paramInt);
      this.dRF = arrayOfFloat;
    }
  }
  
  public final boolean addAll(Collection<? extends Float> paramCollection)
  {
    boolean bool = false;
    ZQ();
    bj.checkNotNull(paramCollection);
    if (!(paramCollection instanceof bb)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (bb)paramCollection;
    } while (paramCollection.size == 0);
    if (2147483647 - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.dRF.length) {
      this.dRF = Arrays.copyOf(this.dRF, i);
    }
    System.arraycopy(paramCollection.dRF, 0, this.dRF, this.size, paramCollection.size);
    this.size = i;
    this.modCount += 1;
    return true;
  }
  
  public final void be(float paramFloat)
  {
    m(this.size, paramFloat);
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
      if (!(paramObject instanceof bb)) {
        return super.equals(paramObject);
      }
      paramObject = (bb)paramObject;
      bool1 = bool2;
    } while (this.size != paramObject.size);
    paramObject = paramObject.dRF;
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label87;
      }
      bool1 = bool2;
      if (Float.floatToIntBits(this.dRF[i]) != Float.floatToIntBits(paramObject[i])) {
        break;
      }
      i += 1;
    }
    label87:
    return true;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + Float.floatToIntBits(this.dRF[i]);
      i += 1;
    }
    return j;
  }
  
  public final bj.f lh(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new bb(Arrays.copyOf(this.dRF, paramInt), this.size);
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
        if (paramObject.equals(Float.valueOf(this.dRF[i])))
        {
          System.arraycopy(this.dRF, i + 1, this.dRF, i, this.size - i - 1);
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
    float[] arrayOfFloat = this.dRF;
    System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bb
 * JD-Core Version:    0.7.0.1
 */