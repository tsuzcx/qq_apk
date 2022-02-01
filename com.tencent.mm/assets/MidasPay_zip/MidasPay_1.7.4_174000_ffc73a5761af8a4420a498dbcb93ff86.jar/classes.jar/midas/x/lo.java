package midas.x;

import android.text.TextUtils;

final class lo
  extends lc
{
  private final lq a;
  
  lo(lq paramlq)
  {
    this.a = paramlq;
  }
  
  public void a(ky paramky, kz paramkz)
  {
    super.a(paramky, paramkz);
    if (paramky == null) {
      return;
    }
    if (paramkz == null) {
      return;
    }
    if (this.a == null) {
      return;
    }
    if (!(paramky instanceof lj)) {
      return;
    }
    paramky = paramky.t();
    if (TextUtils.isEmpty(paramky)) {
      return;
    }
    if (paramkz.d()) {
      this.a.d(paramky);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lo
 * JD-Core Version:    0.7.0.1
 */