package midas.x;

public final class he
{
  public static final he g;
  public static final he h = new he(285, 256, 0);
  public static final he i = new he(301, 256, 1);
  public final int[] a;
  public final int[] b;
  public final ie c;
  public final int d;
  public final int e;
  public final int f;
  
  static
  {
    new he(4201, 4096, 1);
    new he(1033, 1024, 1);
    g = new he(67, 64, 1);
    new he(19, 16, 1);
  }
  
  public he(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.d = paramInt2;
    this.f = paramInt3;
    this.a = new int[paramInt2];
    this.b = new int[paramInt2];
    int j = 0;
    paramInt3 = 1;
    while (j < paramInt2)
    {
      this.a[j] = paramInt3;
      int k = paramInt3 * 2;
      paramInt3 = k;
      if (k >= paramInt2) {
        paramInt3 = (k ^ paramInt1) & paramInt2 - 1;
      }
      j += 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2 - 1)
    {
      this.b[this.a[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.c = new ie(this, new int[] { 0 });
    new ie(this, new int[] { 1 });
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public int a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public ie a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.c;
      }
      int[] arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
      return new ie(this, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  public int b(int paramInt)
  {
    if (paramInt != 0) {
      return this.a[(this.d - this.b[paramInt] - 1)];
    }
    throw new ArithmeticException();
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int[] arrayOfInt1 = this.a;
      int[] arrayOfInt2 = this.b;
      return arrayOfInt1[((arrayOfInt2[paramInt1] + arrayOfInt2[paramInt2]) % (this.d - 1))];
    }
    return 0;
  }
  
  public ie b()
  {
    return this.c;
  }
  
  public int c(int paramInt)
  {
    if (paramInt != 0) {
      return this.b[paramInt];
    }
    throw new IllegalArgumentException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GF(0x");
    localStringBuilder.append(Integer.toHexString(this.e));
    localStringBuilder.append(',');
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.he
 * JD-Core Version:    0.7.0.1
 */