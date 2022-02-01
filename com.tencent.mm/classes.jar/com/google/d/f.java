package com.google.d;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class f
  extends d<Boolean>
  implements bj.a, ct, RandomAccess
{
  private static final f dIH;
  private boolean[] dII;
  private int size;
  
  static
  {
    f localf = new f(new boolean[0], 0);
    dIH = localf;
    localf.ZP();
  }
  
  f()
  {
    this(new boolean[10], 0);
  }
  
  private f(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.dII = paramArrayOfBoolean;
    this.size = paramInt;
  }
  
  private void H(int paramInt, boolean paramBoolean)
  {
    ZQ();
    if ((paramInt < 0) || (paramInt > this.size)) {
      throw new IndexOutOfBoundsException(jH(paramInt));
    }
    boolean[] arrayOfBoolean;
    if (this.size < this.dII.length)
    {
      arrayOfBoolean = this.dII;
      System.arraycopy(arrayOfBoolean, paramInt, arrayOfBoolean, paramInt + 1, this.size - paramInt);
    }
    for (;;)
    {
      this.dII[paramInt] = paramBoolean;
      this.size += 1;
      this.modCount += 1;
      return;
      arrayOfBoolean = new boolean[this.size * 3 / 2 + 1];
      System.arraycopy(this.dII, 0, arrayOfBoolean, 0, paramInt);
      System.arraycopy(this.dII, paramInt, arrayOfBoolean, paramInt + 1, this.size - paramInt);
      this.dII = arrayOfBoolean;
    }
  }
  
  public static f ZS()
  {
    return dIH;
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
  
  public final boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    boolean bool = false;
    ZQ();
    bj.checkNotNull(paramCollection);
    if (!(paramCollection instanceof f)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (f)paramCollection;
    } while (paramCollection.size == 0);
    if (2147483647 - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.dII.length) {
      this.dII = Arrays.copyOf(this.dII, i);
    }
    System.arraycopy(paramCollection.dII, 0, this.dII, this.size, paramCollection.size);
    this.size = i;
    this.modCount += 1;
    return true;
  }
  
  public final void bY(boolean paramBoolean)
  {
    H(this.size, paramBoolean);
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
      if (!(paramObject instanceof f)) {
        return super.equals(paramObject);
      }
      paramObject = (f)paramObject;
      bool1 = bool2;
    } while (this.size != paramObject.size);
    paramObject = paramObject.dII;
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label81;
      }
      bool1 = bool2;
      if (this.dII[i] != paramObject[i]) {
        break;
      }
      i += 1;
    }
    label81:
    return true;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + bj.hashBoolean(this.dII[i]);
      i += 1;
    }
    return j;
  }
  
  public final bj.a jF(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new f(Arrays.copyOf(this.dII, paramInt), this.size);
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
        if (paramObject.equals(Boolean.valueOf(this.dII[i])))
        {
          System.arraycopy(this.dII, i + 1, this.dII, i, this.size - i - 1);
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
    boolean[] arrayOfBoolean = this.dII;
    System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.f
 * JD-Core Version:    0.7.0.1
 */