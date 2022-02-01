package midas.x;

import android.text.TextUtils;

public class ib
  extends mb
{
  public zb b;
  
  public ib(zb paramzb)
  {
    this.b = paramzb;
  }
  
  public static gb a()
  {
    ya.a("FrontGetKey", "Front get key request success!");
    gb localgb = rb.b(20007, "内部参数错误！");
    localgb.e = true;
    return localgb;
  }
  
  public gb a(fb paramfb, gb paramgb)
  {
    if (paramfb == null)
    {
      ya.b("FrontGetKey", "Null request, drop front get key!");
      return a();
    }
    if (!(paramfb instanceof qb))
    {
      ya.b("FrontGetKey", "Not midas request, drop front get key!");
      return paramgb;
    }
    ??? = (qb)paramfb;
    if (!((qb)???).w)
    {
      ya.c("FrontGetKey", "Request set no need to front get key!");
      return paramgb;
    }
    if (!((qb)???).y())
    {
      ya.a("FrontGetKey", "Current request has no encode parameter, drop front get key!");
      return paramgb;
    }
    Object localObject2 = this.b;
    if (localObject2 == null)
    {
      ya.b("FrontGetKey", "No network manager, drop front get key!");
      return a();
    }
    if (((zb)localObject2).c() == null)
    {
      ya.b("FrontGetKey", "No get key request, drop front get key!");
      return paramgb;
    }
    if (this.b.a(paramfb))
    {
      ya.b("FrontGetKey", "Current request is get key request, drop front get key!");
      return paramgb;
    }
    Object localObject3 = this.b.d();
    if (localObject3 == null)
    {
      ya.b("FrontGetKey", "No comm info getter, drop front get key!");
      return a();
    }
    paramfb = this.b.b();
    if (paramfb == null)
    {
      ya.b("FrontGetKey", "Null context, drop front get key!");
      return a();
    }
    localObject2 = ((qb)???).w();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ya.b("FrontGetKey", "Cannot get offer id from request for front get key process!");
      return a();
    }
    localObject3 = ((ec)localObject3).b();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      ya.b("FrontGetKey", "Cannot get sdkVersion for front get key process!");
      return a();
    }
    String str = ((qb)???).x();
    if (TextUtils.isEmpty(str))
    {
      ya.b("FrontGetKey", "Cannot get open id from request for front get key process!");
      return a();
    }
    if (!this.b.d(paramfb, str, (String)localObject2, (String)localObject3))
    {
      ya.a("FrontGetKey", "First need change key return false, drop front get key!");
      return paramgb;
    }
    ya.a("FrontGetKey", "First need change key return true!");
    synchronized (mb.a)
    {
      if (!this.b.d(paramfb, str, (String)localObject2, (String)localObject3))
      {
        ya.b("FrontGetKey", "Second need change key return false, drop front get key!");
        return paramgb;
      }
      ya.a("FrontGetKey", "Second need change key return true! Start get key!");
      paramfb = a(this.b);
      if (rb.d(paramfb))
      {
        ya.a("FrontGetKey", "Front get key request success!");
        this.b.a(paramfb);
        return paramgb;
      }
      ya.b("FrontGetKey", "Front get key request fail!");
      mb.a(this.b, paramfb);
      paramfb.e = true;
      return paramfb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ib
 * JD-Core Version:    0.7.0.1
 */