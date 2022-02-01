package midas.x;

import android.text.TextUtils;

public class jo
{
  public int a = -1;
  public String b;
  public Exception c = null;
  public boolean d = false;
  public boolean e = false;
  private jn f;
  private Object g;
  
  public final jn a()
  {
    return this.f;
  }
  
  public final void a(Object paramObject)
  {
    if (paramObject != null) {
      this.g = paramObject;
    }
  }
  
  public final void a(jn paramjn)
  {
    this.f = paramjn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jo
 * JD-Core Version:    0.7.0.1
 */