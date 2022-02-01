package midas.x;

import android.text.TextUtils;

public class jq
  extends ju
{
  private kf b;
  
  jq(kf paramkf)
  {
    this.b = paramkf;
  }
  
  private static jo a()
  {
    jh.b("FrontGetKey", "Front get key request success!");
    jo localjo = jz.a(20007, "内部参数错误！");
    localjo.d = true;
    return localjo;
  }
  
  public jo a(jn paramjn, jo paramjo)
  {
    if (paramjn == null)
    {
      jh.a("FrontGetKey", "Null request, drop front get key!");
      return a();
    }
    if (!(paramjn instanceof jy))
    {
      jh.a("FrontGetKey", "Not midas request, drop front get key!");
      return paramjo;
    }
    ??? = (jy)paramjn;
    if (!((jy)???).s)
    {
      jh.c("FrontGetKey", "Request set no need to front get key!");
      return paramjo;
    }
    if (!((jy)???).D())
    {
      jh.b("FrontGetKey", "Current request has no encode parameter, drop front get key!");
      return paramjo;
    }
    if (this.b == null)
    {
      jh.a("FrontGetKey", "No network manager, drop front get key!");
      return a();
    }
    if (this.b.e() == null)
    {
      jh.a("FrontGetKey", "No get key request, drop front get key!");
      return paramjo;
    }
    if (this.b.a(paramjn))
    {
      jh.a("FrontGetKey", "Current request is get key request, drop front get key!");
      return paramjo;
    }
    Object localObject2 = this.b.g();
    if (localObject2 == null)
    {
      jh.a("FrontGetKey", "No comm info getter, drop front get key!");
      return a();
    }
    paramjn = this.b.f();
    if (paramjn == null)
    {
      jh.a("FrontGetKey", "Null context, drop front get key!");
      return a();
    }
    String str1 = ((jy)???).C();
    if (TextUtils.isEmpty(str1))
    {
      jh.a("FrontGetKey", "Cannot get offer id from request for front get key process!");
      return a();
    }
    localObject2 = ((kk)localObject2).a();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      jh.a("FrontGetKey", "Cannot get sdkVersion for front get key process!");
      return a();
    }
    String str2 = ((jy)???).B();
    if (TextUtils.isEmpty(str2))
    {
      jh.a("FrontGetKey", "Cannot get open id from request for front get key process!");
      return a();
    }
    if (!this.b.a(paramjn, str2, str1, (String)localObject2))
    {
      jh.b("FrontGetKey", "First need change key return false, drop front get key!");
      return paramjo;
    }
    jh.b("FrontGetKey", "First need change key return true!");
    synchronized (a)
    {
      if (!this.b.a(paramjn, str2, str1, (String)localObject2))
      {
        jh.a("FrontGetKey", "Second need change key return false, drop front get key!");
        return paramjo;
      }
      jh.b("FrontGetKey", "Second need change key return true! Start get key!");
      paramjn = a(this.b);
      if (jz.c(paramjn))
      {
        jh.b("FrontGetKey", "Front get key request success!");
        this.b.a(paramjn);
        return paramjo;
      }
      jh.a("FrontGetKey", "Front get key request fail!");
      a(this.b, paramjn);
      paramjn.d = true;
      return paramjn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jq
 * JD-Core Version:    0.7.0.1
 */