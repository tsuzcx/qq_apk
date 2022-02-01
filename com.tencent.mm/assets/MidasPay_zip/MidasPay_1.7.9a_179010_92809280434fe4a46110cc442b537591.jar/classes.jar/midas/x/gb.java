package midas.x;

import android.text.TextUtils;

public class gb
{
  public int a = -1;
  public String b;
  public Exception c = null;
  public fb d;
  public boolean e = false;
  public boolean f = false;
  public Object g;
  
  public final Object a()
  {
    return this.g;
  }
  
  public final void a(Object paramObject)
  {
    if (paramObject != null) {
      this.g = paramObject;
    }
  }
  
  public final void a(fb paramfb)
  {
    this.d = paramfb;
  }
  
  public final boolean b()
  {
    return this.c != null;
  }
  
  public final boolean c()
  {
    return TextUtils.isEmpty(this.b) ^ true;
  }
  
  public final boolean d()
  {
    fb localfb = this.d;
    return (localfb != null) && (localfb.m());
  }
  
  public final boolean e()
  {
    return this.a == 200;
  }
  
  public final boolean f()
  {
    return (e()) && (!TextUtils.isEmpty(this.b)) && (this.c == null);
  }
  
  public final fb g()
  {
    return this.d;
  }
  
  public final void h()
  {
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.gb
 * JD-Core Version:    0.7.0.1
 */