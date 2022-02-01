package midas.x;

import android.text.TextUtils;

public class kz
{
  public int a = -1;
  public String b;
  public Exception c = null;
  public boolean d = false;
  public boolean e = false;
  private ky f;
  private Object g;
  
  public final ky a()
  {
    return this.f;
  }
  
  public final void a(Object paramObject)
  {
    if (paramObject != null) {
      this.g = paramObject;
    }
  }
  
  public final void a(ky paramky)
  {
    this.f = paramky;
  }
  
  public final boolean b()
  {
    return (this.f != null) && (this.f.n());
  }
  
  public final Object c()
  {
    return this.g;
  }
  
  public final boolean d()
  {
    return (e()) && (!TextUtils.isEmpty(this.b)) && (this.c == null);
  }
  
  public final boolean e()
  {
    return this.a == 200;
  }
  
  public final boolean f()
  {
    return TextUtils.isEmpty(this.b) ^ true;
  }
  
  public final boolean g()
  {
    return this.c != null;
  }
  
  public final void h()
  {
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kz
 * JD-Core Version:    0.7.0.1
 */