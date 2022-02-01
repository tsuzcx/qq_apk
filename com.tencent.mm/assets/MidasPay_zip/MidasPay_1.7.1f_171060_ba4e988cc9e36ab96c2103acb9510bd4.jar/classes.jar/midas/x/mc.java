package midas.x;

import java.util.Arrays;

public final class mc
  implements Cloneable
{
  private int[] a;
  private int b;
  
  public mc()
  {
    this.b = 0;
    this.a = new int[1];
  }
  
  mc(int[] paramArrayOfInt, int paramInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramInt;
  }
  
  private void b(int paramInt)
  {
    if (paramInt > this.a.length * 32)
    {
      int[] arrayOfInt = c(paramInt);
      System.arraycopy(this.a, 0, arrayOfInt, 0, this.a.length);
      this.a = arrayOfInt;
    }
  }
  
  private static int[] c(int paramInt)
  {
    return new int[(paramInt + 31) / 32];
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 32))
    {
      b(this.b + paramInt2);
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
    throw new IllegalArgumentException("Num bits must be between 0 and 32");
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
        if (a(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public void a(mc parammc)
  {
    int j = parammc.b;
    b(this.b + j);
    int i = 0;
    while (i < j)
    {
      a(parammc.a(i));
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(this.b + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.a;
      int i = this.b / 32;
      arrayOfInt[i] |= 1 << (this.b & 0x1F);
    }
    this.b += 1;
  }
  
  public boolean a(int paramInt)
  {
    return (1 << (paramInt & 0x1F) & this.a[(paramInt / 32)]) != 0;
  }
  
  public int b()
  {
    return (this.b + 7) / 8;
  }
  
  public void b(mc parammc)
  {
    if (this.b == parammc.b)
    {
      int i = 0;
      while (i < this.a.length)
      {
        int[] arrayOfInt = this.a;
        arrayOfInt[i] ^= parammc.a[i];
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("Sizes don't match");
  }
  
  public mc c()
  {
    return new mc((int[])this.a.clone(), this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof mc;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (mc)paramObject;
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
    StringBuilder localStringBuilder = new StringBuilder(this.b + this.b / 8 + 1);
    int i = 0;
    while (i < this.b)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      char c;
      if (a(i)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mc
 * JD-Core Version:    0.7.0.1
 */