package midas.x;

final class mg
{
  private final mf a;
  private final int[] b;
  
  mg(mf parammf, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length != 0)
    {
      this.a = parammf;
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
        System.arraycopy(paramArrayOfInt, i, this.b, 0, this.b.length);
        return;
      }
      this.b = paramArrayOfInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  int a(int paramInt)
  {
    return this.b[(this.b.length - 1 - paramInt)];
  }
  
  mg a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.a.a();
      }
      int i = this.b.length;
      int[] arrayOfInt = new int[paramInt1 + i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        arrayOfInt[paramInt1] = this.a.c(this.b[paramInt1], paramInt2);
        paramInt1 += 1;
      }
      return new mg(this.a, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  mg a(mg parammg)
  {
    if (this.a.equals(parammg.a))
    {
      if (c()) {
        return parammg;
      }
      if (parammg.c()) {
        return this;
      }
      int[] arrayOfInt1 = this.b;
      int[] arrayOfInt3 = parammg.b;
      int[] arrayOfInt2 = arrayOfInt1;
      parammg = arrayOfInt3;
      if (arrayOfInt1.length > arrayOfInt3.length)
      {
        arrayOfInt2 = arrayOfInt3;
        parammg = arrayOfInt1;
      }
      arrayOfInt1 = new int[parammg.length];
      int j = parammg.length - arrayOfInt2.length;
      System.arraycopy(parammg, 0, arrayOfInt1, 0, j);
      int i = j;
      while (i < parammg.length)
      {
        arrayOfInt1[i] = mf.b(arrayOfInt2[(i - j)], parammg[i]);
        i += 1;
      }
      return new mg(this.a, arrayOfInt1);
    }
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  int[] a()
  {
    return this.b;
  }
  
  int b()
  {
    return this.b.length - 1;
  }
  
  mg b(mg parammg)
  {
    if (this.a.equals(parammg.a))
    {
      if ((!c()) && (!parammg.c()))
      {
        int[] arrayOfInt1 = this.b;
        int k = arrayOfInt1.length;
        parammg = parammg.b;
        int m = parammg.length;
        int[] arrayOfInt2 = new int[k + m - 1];
        int i = 0;
        while (i < k)
        {
          int n = arrayOfInt1[i];
          int j = 0;
          while (j < m)
          {
            int i1 = i + j;
            arrayOfInt2[i1] = mf.b(arrayOfInt2[i1], this.a.c(n, parammg[j]));
            j += 1;
          }
          i += 1;
        }
        return new mg(this.a, arrayOfInt2);
      }
      return this.a.a();
    }
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  boolean c()
  {
    int[] arrayOfInt = this.b;
    boolean bool = false;
    if (arrayOfInt[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  mg[] c(mg parammg)
  {
    if (this.a.equals(parammg.a))
    {
      if (!parammg.c())
      {
        mg localmg2 = this.a.a();
        int i = parammg.a(parammg.b());
        i = this.a.c(i);
        mg localmg3;
        for (mg localmg1 = this; (localmg1.b() >= parammg.b()) && (!localmg1.c()); localmg1 = localmg1.a(localmg3))
        {
          int j = localmg1.b() - parammg.b();
          int k = this.a.c(localmg1.a(localmg1.b()), i);
          localmg3 = parammg.a(j, k);
          localmg2 = localmg2.a(this.a.a(j, k));
        }
        return new mg[] { localmg2, localmg1 };
      }
      throw new IllegalArgumentException("Divide by 0");
    }
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
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
          j = this.a.b(j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mg
 * JD-Core Version:    0.7.0.1
 */