package midas.x;

import android.text.TextUtils;

public class lb
  extends lf
{
  private lq b;
  
  lb(lq paramlq)
  {
    this.b = paramlq;
  }
  
  private static kz a()
  {
    ks.b("FrontGetKey", "Front get key request success!");
    kz localkz = lk.a(20007, "内部参数错误！");
    localkz.d = true;
    return localkz;
  }
  
  public kz a(ky paramky, kz paramkz)
  {
    if (paramky == null)
    {
      ks.a("FrontGetKey", "Null request, drop front get key!");
      return a();
    }
    if (!(paramky instanceof lj))
    {
      ks.a("FrontGetKey", "Not midas request, drop front get key!");
      return paramkz;
    }
    ??? = (lj)paramky;
    if (!((lj)???).s)
    {
      ks.c("FrontGetKey", "Request set no need to front get key!");
      return paramkz;
    }
    if (!((lj)???).D())
    {
      ks.b("FrontGetKey", "Current request has no encode parameter, drop front get key!");
      return paramkz;
    }
    if (this.b == null)
    {
      ks.a("FrontGetKey", "No network manager, drop front get key!");
      return a();
    }
    if (this.b.e() == null)
    {
      ks.a("FrontGetKey", "No get key request, drop front get key!");
      return paramkz;
    }
    if (this.b.a(paramky))
    {
      ks.a("FrontGetKey", "Current request is get key request, drop front get key!");
      return paramkz;
    }
    Object localObject2 = this.b.g();
    if (localObject2 == null)
    {
      ks.a("FrontGetKey", "No comm info getter, drop front get key!");
      return a();
    }
    paramky = this.b.f();
    if (paramky == null)
    {
      ks.a("FrontGetKey", "Null context, drop front get key!");
      return a();
    }
    String str1 = ((lj)???).C();
    if (TextUtils.isEmpty(str1))
    {
      ks.a("FrontGetKey", "Cannot get offer id from request for front get key process!");
      return a();
    }
    localObject2 = ((lv)localObject2).a();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ks.a("FrontGetKey", "Cannot get sdkVersion for front get key process!");
      return a();
    }
    String str2 = ((lj)???).B();
    if (TextUtils.isEmpty(str2))
    {
      ks.a("FrontGetKey", "Cannot get open id from request for front get key process!");
      return a();
    }
    if (!this.b.a(paramky, str2, str1, (String)localObject2))
    {
      ks.b("FrontGetKey", "First need change key return false, drop front get key!");
      return paramkz;
    }
    ks.b("FrontGetKey", "First need change key return true!");
    synchronized (a)
    {
      if (!this.b.a(paramky, str2, str1, (String)localObject2))
      {
        ks.a("FrontGetKey", "Second need change key return false, drop front get key!");
        return paramkz;
      }
      ks.b("FrontGetKey", "Second need change key return true! Start get key!");
      paramky = a(this.b);
      if (lk.c(paramky))
      {
        ks.b("FrontGetKey", "Front get key request success!");
        this.b.a(paramky);
        return paramkz;
      }
      ks.a("FrontGetKey", "Front get key request fail!");
      a(this.b, paramky);
      paramky.d = true;
      return paramky;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lb
 * JD-Core Version:    0.7.0.1
 */