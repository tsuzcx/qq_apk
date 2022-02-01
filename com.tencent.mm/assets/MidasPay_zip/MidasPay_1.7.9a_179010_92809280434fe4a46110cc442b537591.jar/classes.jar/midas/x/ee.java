package midas.x;

import java.util.Arrays;

public final class ee
  implements Cloneable
{
  public int[] a;
  public int b;
  
  public ee()
  {
    this.b = 0;
    this.a = new int[1];
  }
  
  public ee(int[] paramArrayOfInt, int paramInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramInt;
  }
  
  public static int[] c(int paramInt)
  {
    return new int[(paramInt + 31) / 32];
  }
  
  public int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.a.length * 32)
    {
      int[] arrayOfInt1 = c(paramInt);
      int[] arrayOfInt2 = this.a;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      this.a = arrayOfInt1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 32))
    {
      a(this.b + paramInt2);
      while (paramInt2 > 0)
      {
        boolean bool = true;
        if ((paramInt1 >> paramInt2 - 1 & 0x1) != 1) {
          bool = false;
        }
        a(bool);
        paramInt2 -= 1;
      }
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (b(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public void a(ee paramee)
  {
    int j = paramee.b;
    a(this.b + j);
    int i = 0;
    while (i < j)
    {
      a(paramee.b(i));
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.b + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.a;
      int i = this.b;
      int j = i / 32;
      arrayOfInt[j] = (1 << (i & 0x1F) | arrayOfInt[j]);
    }
    this.b += 1;
  }
  
  public int b()
  {
    return (this.b + 7) / 8;
  }
  
  public void b(ee paramee)
  {
    if (this.b == paramee.b)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.a;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] ^= paramee.a[i];
        i += 1;
      }
      return;
    }
    paramee = new IllegalArgumentException("Sizes don't match");
    for (;;)
    {
      throw paramee;
    }
  }
  
  public boolean b(int paramInt)
  {
    return (1 << (paramInt & 0x1F) & this.a[(paramInt / 32)]) != 0;
  }
  
  public ee clone()
  {
    return new ee((int[])this.a.clone(), this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ee;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ee)paramObject;
    bool1 = bool2;
    if (this.b == paramObject.b)
    {
      bool1 = bool2;
      if (Arrays.equals(this.a, paramObject.a)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.b * 31 + Arrays.hashCode(this.a);
  }
  
  public String toString()
  {
    int i = this.b;
    StringBuilder localStringBuilder = new StringBuilder(i + i / 8 + 1);
    i = 0;
    while (i < this.b)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      char c;
      if (b(i)) {
        c = 'X';
      } else {
        c = '.';
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ee
 * JD-Core Version:    0.7.0.1
 */