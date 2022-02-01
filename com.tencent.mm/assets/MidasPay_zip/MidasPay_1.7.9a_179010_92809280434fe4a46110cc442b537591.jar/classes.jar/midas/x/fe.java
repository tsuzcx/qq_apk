package midas.x;

import java.util.Arrays;

public final class fe
  implements Cloneable
{
  public final int a;
  public final int b;
  public final int c;
  public final int[] d;
  
  public fe(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt2 >= 1))
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = ((paramInt1 + 31) / 32);
      this.d = new int[this.c * paramInt2];
      return;
    }
    throw new IllegalArgumentException("Both dimensions must be greater than 0");
  }
  
  public fe(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramArrayOfInt;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "\n");
  }
  
  public final String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * (this.a + 1));
    int i = 0;
    while (i < this.b)
    {
      int j = 0;
      while (j < this.a)
      {
        String str;
        if (a(j, i)) {
          str = paramString1;
        } else {
          str = paramString2;
        }
        localStringBuilder.append(str);
        j += 1;
      }
      localStringBuilder.append(paramString3);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 >= 0) && (paramInt1 >= 0))
    {
      if ((paramInt4 >= 1) && (paramInt3 >= 1))
      {
        int i = paramInt3 + paramInt1;
        paramInt4 += paramInt2;
        if ((paramInt4 <= this.b) && (i <= this.a))
        {
          while (paramInt2 < paramInt4)
          {
            int j = this.c;
            paramInt3 = paramInt1;
            while (paramInt3 < i)
            {
              localObject = this.d;
              int k = paramInt3 / 32 + j * paramInt2;
              localObject[k] |= 1 << (paramInt3 & 0x1F);
              paramInt3 += 1;
            }
            paramInt2 += 1;
          }
          return;
        }
        throw new IllegalArgumentException("The region must fit inside the matrix");
      }
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    Object localObject = new IllegalArgumentException("Left and top must be nonnegative");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i = this.c;
    int j = paramInt1 / 32;
    return (this.d[(paramInt2 * i + j)] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public fe clone()
  {
    return new fe(this.a, this.b, this.c, (int[])this.d.clone());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof fe;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (fe)paramObject;
    bool1 = bool2;
    if (this.a == paramObject.a)
    {
      bool1 = bool2;
      if (this.b == paramObject.b)
      {
        bool1 = bool2;
        if (this.c == paramObject.c)
        {
          bool1 = bool2;
          if (Arrays.equals(this.d, paramObject.d)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int i = this.a;
    return (((i * 31 + i) * 31 + this.b) * 31 + this.c) * 31 + Arrays.hashCode(this.d);
  }
  
  public String toString()
  {
    return a("X ", "  ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.fe
 * JD-Core Version:    0.7.0.1
 */