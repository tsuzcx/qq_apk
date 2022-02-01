package midas.x;

import android.text.TextUtils;

public final class xb
  extends jb
{
  public final zb a;
  
  public xb(zb paramzb)
  {
    this.a = paramzb;
  }
  
  public void a(fb paramfb, gb paramgb)
  {
    super.a(paramfb, paramgb);
    if (paramfb == null) {
      return;
    }
    if (paramgb == null) {
      return;
    }
    if (this.a == null) {
      return;
    }
    if (!(paramfb instanceof qb)) {
      return;
    }
    paramfb = paramfb.g();
    if (TextUtils.isEmpty(paramfb)) {
      return;
    }
    if (paramgb.f()) {
      this.a.d(paramfb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.xb
 * JD-Core Version:    0.7.0.1
 */