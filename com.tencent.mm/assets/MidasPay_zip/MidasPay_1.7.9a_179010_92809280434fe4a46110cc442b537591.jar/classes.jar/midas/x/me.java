package midas.x;

public enum me
{
  public final int[] a;
  public final int b;
  
  public me(int[] paramArrayOfInt, int paramInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramInt;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(ne paramne)
  {
    int n = paramne.c();
    if (n <= 9) {
      n = 0;
    } else if (n <= 26) {
      n = 1;
    } else {
      n = 2;
    }
    return this.a[n];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.me
 * JD-Core Version:    0.7.0.1
 */