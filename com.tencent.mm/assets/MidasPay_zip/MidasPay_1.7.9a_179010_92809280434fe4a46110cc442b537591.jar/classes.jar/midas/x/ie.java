package midas.x;

public final class ie
{
  public final he a;
  public final int[] b;
  
  public ie(he paramhe, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length != 0)
    {
      this.a = paramhe;
      int j = paramArrayOfInt.length;
      if ((j > 1) && (paramArrayOfInt[0] == 0))
      {
        int i = 1;
        while ((i < j) && (paramArrayOfInt[i] == 0)) {
          i += 1;
        }
        if (i == j)
        {
          this.b = new int[] { 0 };
          return;
        }
        this.b = new int[j - i];
        paramhe = this.b;
        System.arraycopy(paramArrayOfInt, i, paramhe, 0, paramhe.length);
        return;
      }
      this.b = paramArrayOfInt;
      return;
    }
    paramhe = new IllegalArgumentException();
    for (;;)
    {
      throw paramhe;
    }
  }
  
  public int a(int paramInt)
  {
    int[] arrayOfInt = this.b;
    return arrayOfInt[(arrayOfInt.length - 1 - paramInt)];
  }
  
  public ie a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.a.b();
      }
      int i = this.b.length;
      localObject = new int[paramInt1 + i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject[paramInt1] = this.a.b(this.b[paramInt1], paramInt2);
        paramInt1 += 1;
      }
      return new ie(this.a, (int[])localObject);
    }
    Object localObject = new IllegalArgumentException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public ie a(ie paramie)
  {
    if (this.a.equals(paramie.a))
    {
      if (c()) {
        return paramie;
      }
      if (paramie.c()) {
        return this;
      }
      int[] arrayOfInt1 = this.b;
      int[] arrayOfInt3 = paramie.b;
      int[] arrayOfInt2 = arrayOfInt1;
      paramie = arrayOfInt3;
      if (arrayOfInt1.length > arrayOfInt3.length)
      {
        arrayOfInt2 = arrayOfInt3;
        paramie = arrayOfInt1;
      }
      arrayOfInt1 = new int[paramie.length];
      int j = paramie.length - arrayOfInt2.length;
      System.arraycopy(paramie, 0, arrayOfInt1, 0, j);
      int i = j;
      while (i < paramie.length)
      {
        arrayOfInt1[i] = he.c(arrayOfInt2[(i - j)], paramie[i]);
        i += 1;
      }
      return new ie(this.a, arrayOfInt1);
    }
    paramie = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramie;
    }
  }
  
  public int[] a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.b.length - 1;
  }
  
  public ie[] b(ie paramie)
  {
    if (this.a.equals(paramie.a))
    {
      if (!paramie.c())
      {
        ie localie2 = this.a.b();
        int i = paramie.a(paramie.b());
        i = this.a.b(i);
        ie localie3;
        for (ie localie1 = this; (localie1.b() >= paramie.b()) && (!localie1.c()); localie1 = localie1.a(localie3))
        {
          int j = localie1.b() - paramie.b();
          int k = this.a.b(localie1.a(localie1.b()), i);
          localie3 = paramie.a(j, k);
          localie2 = localie2.a(this.a.a(j, k));
        }
        return new ie[] { localie2, localie1 };
      }
      throw new IllegalArgumentException("Divide by 0");
    }
    paramie = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramie;
    }
  }
  
  public ie c(ie paramie)
  {
    if (this.a.equals(paramie.a))
    {
      if ((!c()) && (!paramie.c()))
      {
        int[] arrayOfInt1 = this.b;
        int k = arrayOfInt1.length;
        paramie = paramie.b;
        int m = paramie.length;
        int[] arrayOfInt2 = new int[k + m - 1];
        int i = 0;
        while (i < k)
        {
          int n = arrayOfInt1[i];
          int j = 0;
          while (j < m)
          {
            int i1 = i + j;
            arrayOfInt2[i1] = he.c(arrayOfInt2[i1], this.a.b(n, paramie[j]));
            j += 1;
          }
          i += 1;
        }
        return new ie(this.a, arrayOfInt2);
      }
      return this.a.b();
    }
    paramie = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramie;
    }
  }
  
  public boolean c()
  {
    int[] arrayOfInt = this.b;
    boolean bool = false;
    if (arrayOfInt[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(b() * 8);
    int i = b();
    while (i >= 0)
    {
      int k = a(i);
      if (k != 0)
      {
        int j;
        if (k < 0)
        {
          localStringBuilder.append(" - ");
          j = -k;
        }
        else
        {
          j = k;
          if (localStringBuilder.length() > 0)
          {
            localStringBuilder.append(" + ");
            j = k;
          }
        }
        if ((i == 0) || (j != 1))
        {
          j = this.a.c(j);
          if (j == 0)
          {
            localStringBuilder.append('1');
          }
          else if (j == 1)
          {
            localStringBuilder.append('a');
          }
          else
          {
            localStringBuilder.append("a^");
            localStringBuilder.append(j);
          }
        }
        if (i != 0) {
          if (i == 1)
          {
            localStringBuilder.append('x');
          }
          else
          {
            localStringBuilder.append("x^");
            localStringBuilder.append(i);
          }
        }
      }
      i -= 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ie
 * JD-Core Version:    0.7.0.1
 */