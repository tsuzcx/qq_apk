package midas.x;

final class nr
{
  private final nq a;
  private final int[] b;
  
  nr(nq paramnq, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length != 0)
    {
      this.a = paramnq;
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
  
  nr a(int paramInt1, int paramInt2)
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
      return new nr(this.a, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  nr a(nr paramnr)
  {
    if (this.a.equals(paramnr.a))
    {
      if (c()) {
        return paramnr;
      }
      if (paramnr.c()) {
        return this;
      }
      int[] arrayOfInt1 = this.b;
      int[] arrayOfInt3 = paramnr.b;
      int[] arrayOfInt2 = arrayOfInt1;
      paramnr = arrayOfInt3;
      if (arrayOfInt1.length > arrayOfInt3.length)
      {
        arrayOfInt2 = arrayOfInt3;
        paramnr = arrayOfInt1;
      }
      arrayOfInt1 = new int[paramnr.length];
      int j = paramnr.length - arrayOfInt2.length;
      System.arraycopy(paramnr, 0, arrayOfInt1, 0, j);
      int i = j;
      while (i < paramnr.length)
      {
        arrayOfInt1[i] = nq.b(arrayOfInt2[(i - j)], paramnr[i]);
        i += 1;
      }
      return new nr(this.a, arrayOfInt1);
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
  
  nr b(nr paramnr)
  {
    if (this.a.equals(paramnr.a))
    {
      if ((!c()) && (!paramnr.c()))
      {
        int[] arrayOfInt1 = this.b;
        int k = arrayOfInt1.length;
        paramnr = paramnr.b;
        int m = paramnr.length;
        int[] arrayOfInt2 = new int[k + m - 1];
        int i = 0;
        while (i < k)
        {
          int n = arrayOfInt1[i];
          int j = 0;
          while (j < m)
          {
            int i1 = i + j;
            arrayOfInt2[i1] = nq.b(arrayOfInt2[i1], this.a.c(n, paramnr[j]));
            j += 1;
          }
          i += 1;
        }
        return new nr(this.a, arrayOfInt2);
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
  
  nr[] c(nr paramnr)
  {
    if (this.a.equals(paramnr.a))
    {
      if (!paramnr.c())
      {
        nr localnr2 = this.a.a();
        int i = paramnr.a(paramnr.b());
        i = this.a.c(i);
        nr localnr3;
        for (nr localnr1 = this; (localnr1.b() >= paramnr.b()) && (!localnr1.c()); localnr1 = localnr1.a(localnr3))
        {
          int j = localnr1.b() - paramnr.b();
          int k = this.a.c(localnr1.a(localnr1.b()), i);
          localnr3 = paramnr.a(j, k);
          localnr2 = localnr2.a(this.a.a(j, k));
        }
        return new nr[] { localnr2, localnr1 };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nr
 * JD-Core Version:    0.7.0.1
 */