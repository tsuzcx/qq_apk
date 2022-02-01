package midas.x;

public enum nv
{
  private final int[] k;
  private final int l;
  
  private nv(int[] paramArrayOfInt, int paramInt)
  {
    this.k = paramArrayOfInt;
    this.l = paramInt;
  }
  
  public int a()
  {
    return this.l;
  }
  
  public int a(nw paramnw)
  {
    int n = paramnw.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nv
 * JD-Core Version:    0.7.0.1
 */