package midas.x;

import android.content.Context;
import android.text.TextUtils;

class ju
  implements jk
{
  static final Object a = new Object();
  
  static void a(kf paramkf, jn paramjn)
  {
    if (paramkf == null)
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099! null net mgr");
      return;
    }
    if (paramjn == null)
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099! null request");
      return;
    }
    if (!(paramjn instanceof jy)) {
      return;
    }
    paramjn = (jy)paramjn;
    Context localContext = paramkf.f();
    if (localContext == null)
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099! null context");
      return;
    }
    Object localObject = paramkf.g();
    if (localObject == null)
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099! null common info getter");
      return;
    }
    localObject = ((kk)localObject).a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099! Empty sdk version!");
      return;
    }
    String str1 = paramjn.C();
    if (TextUtils.isEmpty(str1))
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099! Empty offer id!");
      return;
    }
    String str2 = paramjn.B();
    if (TextUtils.isEmpty(str2))
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099! empty open id");
      return;
    }
    if (paramjn.E())
    {
      jh.a("TencentPay", "Got 1094 or 1099 or 1105 when encode with base key! Base key only for get key!");
      return;
    }
    if (paramjn.F())
    {
      jh.a("TencentPay", "Got 1094 or 1099 or 1105 when encode with secret key! clear all key!");
      paramkf.b(localContext, str2, str1, (String)localObject);
      return;
    }
    if (paramjn.G())
    {
      jh.a("TencentPay", "Got 1094 or 1099 or 1105 when encode with cry key! clear cry key and key time!");
      paramkf.c(localContext, str2, str1, (String)localObject);
    }
  }
  
  static void a(kf paramkf, jo paramjo)
  {
    if (paramkf == null)
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099!  Net manager null!");
      return;
    }
    if (paramjo == null)
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099!  Response null!");
      return;
    }
    jn localjn = paramjo.a();
    if (localjn == null)
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099!  Request null!");
      return;
    }
    if (!paramkf.a(localjn))
    {
      jh.a("TencentPay", "Cannot clear key for 1094 or 1099!  Not get key response!");
      return;
    }
    int i = jz.b(paramjo);
    if ((i == 1099) || (i == 1094) || (i == 1105)) {
      a(paramkf, localjn);
    }
  }
  
  static void a(kf paramkf, jy paramjy)
  {
    if (paramkf == null)
    {
      jh.a("TencentPay", "Cannot clear cry key for need change key! Null net mgr!");
      return;
    }
    if (paramjy == null)
    {
      jh.a("TencentPay", "Cannot clear cry key for need change key! Null request!");
      return;
    }
    Context localContext = paramkf.f();
    if (localContext == null)
    {
      jh.a("TencentPay", "Cannot clear cry key for need change key! Null context!");
      return;
    }
    Object localObject = paramkf.g();
    if (localObject == null)
    {
      jh.a("TencentPay", "Cannot clear cry key for need change key! Null common info getter!");
      return;
    }
    localObject = ((kk)localObject).a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      jh.a("TencentPay", "Cannot clear cry key for need change key! Empty sdk version!");
      return;
    }
    String str = paramjy.C();
    if (TextUtils.isEmpty(str))
    {
      jh.a("TencentPay", "Cannot clear cry key for need change key! Empty offer id!");
      return;
    }
    paramjy = paramjy.B();
    if (TextUtils.isEmpty(paramjy))
    {
      jh.a("TencentPay", "Cannot clear cry key for need change key! Empty open id!");
      return;
    }
    jh.b("TencentPay", "Clear cry key and key time for need change key!");
    paramkf.c(localContext, paramjy, str, (String)localObject);
  }
  
  public jo a(jn paramjn, jo paramjo)
  {
    return null;
  }
  
  jo a(kf paramkf)
  {
    jo localjo = new jo();
    if (paramkf == null) {
      return localjo;
    }
    Object localObject = paramkf.e();
    if (localObject == null) {
      return localjo;
    }
    localObject = paramkf.a((jy)localObject);
    if (jz.c((jo)localObject)) {
      return localObject;
    }
    localObject = paramkf.e();
    if (localObject == null) {
      return localjo;
    }
    ((jy)localObject).r = true;
    return paramkf.a((jy)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ju
 * JD-Core Version:    0.7.0.1
 */