package midas.x;

public final class mf
{
  public static final mf a = new mf(4201, 4096, 1);
  public static final mf b = new mf(1033, 1024, 1);
  public static final mf c = new mf(67, 64, 1);
  public static final mf d = new mf(19, 16, 1);
  public static final mf e = new mf(285, 256, 0);
  public static final mf f = new mf(301, 256, 1);
  public static final mf g = f;
  public static final mf h = c;
  private final int[] i;
  private final int[] j;
  private final mg k;
  private final mg l;
  private final int m;
  private final int n;
  private final int o;
  
  public mf(int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = paramInt1;
    this.m = paramInt2;
    this.o = paramInt3;
    this.i = new int[paramInt2];
    this.j = new int[paramInt2];
    int i1 = 0;
    paramInt3 = 1;
    while (i1 < paramInt2)
    {
      this.i[i1] = paramInt3;
      int i2 = paramInt3 * 2;
      paramInt3 = i2;
      if (i2 >= paramInt2) {
        paramInt3 = (i2 ^ paramInt1) & paramInt2 - 1;
      }
      i1 += 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2 - 1)
    {
      this.j[this.i[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.k = new mg(this, new int[] { 0 });
    this.l = new mg(this, new int[] { 1 });
  }
  
  static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  int a(int paramInt)
  {
    return this.i[paramInt];
  }
  
  mg a()
  {
    return this.k;
  }
  
  mg a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.k;
      }
      int[] arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
      return new mg(this, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  public int b()
  {
    return this.o;
  }
  
  int b(int paramInt)
  {
    if (paramInt != 0) {
      return this.j[paramInt];
    }
    throw new IllegalArgumentException();
  }
  
  int c(int paramInt)
  {
    if (paramInt != 0) {
      return this.i[(this.m - this.j[paramInt] - 1)];
    }
    throw new ArithmeticException();
  }
  
  int c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      return this.i[((this.j[paramInt1] + this.j[paramInt2]) % (this.m - 1))];
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GF(0x");
    localStringBuilder.append(Integer.toHexString(this.n));
    localStringBuilder.append(',');
    localStringBuilder.append(this.m);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mf
 * JD-Core Version:    0.7.0.1
 */