package midas.x;

class lr
  extends lc
{
  private final lq a;
  
  lr(lq paramlq)
  {
    this.a = paramlq;
  }
  
  public void a(int paramInt1, int paramInt2, ky paramky, kz paramkz)
  {
    super.a(paramInt1, paramInt2, paramky, paramkz);
    if (paramky == null) {
      return;
    }
    paramky.a(paramInt1, paramInt2, paramky, paramkz);
  }
  
  public void a(ky paramky)
  {
    super.a(paramky);
    paramky.v();
  }
  
  public void a(ky paramky, kz paramkz)
  {
    super.a(paramky, paramkz);
    paramky.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lr
 * JD-Core Version:    0.7.0.1
 */