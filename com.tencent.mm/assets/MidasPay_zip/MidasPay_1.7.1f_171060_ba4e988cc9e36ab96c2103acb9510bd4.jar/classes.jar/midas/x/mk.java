package midas.x;

public enum mk
{
  private final int[] k;
  private final int l;
  
  private mk(int[] paramArrayOfInt, int paramInt)
  {
    this.k = paramArrayOfInt;
    this.l = paramInt;
  }
  
  public int a()
  {
    return this.l;
  }
  
  public int a(ml paramml)
  {
    int n = paramml.a();
    if (n <= 9) {
      n = 0;
    } else if (n <= 26) {
      n = 1;
    } else {
      n = 2;
    }
    return this.k[n];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mk
 * JD-Core Version:    0.7.0.1
 */