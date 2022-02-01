package midas.x;

import android.content.Context;
import android.text.TextUtils;

public class mb
  implements cb
{
  public static final Object a = new Object();
  
  public static void a(zb paramzb, fb paramfb)
  {
    if (paramzb == null)
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099! null net mgr");
      return;
    }
    if (paramfb == null)
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099! null request");
      return;
    }
    if (!(paramfb instanceof qb)) {
      return;
    }
    paramfb = (qb)paramfb;
    Context localContext = paramzb.b();
    if (localContext == null)
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099! null context");
      return;
    }
    Object localObject = paramzb.d();
    if (localObject == null)
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099! null common info getter");
      return;
    }
    localObject = ((ec)localObject).b();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099! Empty sdk version!");
      return;
    }
    String str1 = paramfb.w();
    if (TextUtils.isEmpty(str1))
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099! Empty offer id!");
      return;
    }
    String str2 = paramfb.x();
    if (TextUtils.isEmpty(str2))
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099! empty open id");
      return;
    }
    if (paramfb.z())
    {
      ya.b("TencentPay", "Got 1094 or 1099 or 1105 when encode with base key! Base key only for get key!");
      return;
    }
    if (paramfb.B())
    {
      ya.b("TencentPay", "Got 1094 or 1099 or 1105 when encode with secret key! clear all key!");
      paramzb.a(localContext, str2, str1, (String)localObject);
      return;
    }
    if (paramfb.A())
    {
      ya.b("TencentPay", "Got 1094 or 1099 or 1105 when encode with cry key! clear cry key and key time!");
      paramzb.b(localContext, str2, str1, (String)localObject);
    }
  }
  
  public static void a(zb paramzb, gb paramgb)
  {
    if (paramzb == null)
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099!  Net manager null!");
      return;
    }
    if (paramgb == null)
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099!  Response null!");
      return;
    }
    fb localfb = paramgb.g();
    if (localfb == null)
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099!  Request null!");
      return;
    }
    if (!paramzb.a(localfb))
    {
      ya.b("TencentPay", "Cannot clear key for 1094 or 1099!  Not get key response!");
      return;
    }
    int i = rb.b(paramgb);
    if ((i == 1099) || (i == 1094) || (i == 1105)) {
      a(paramzb, localfb);
    }
  }
  
  public static void a(zb paramzb, qb paramqb)
  {
    if (paramzb == null)
    {
      ya.b("TencentPay", "Cannot clear cry key for need change key! Null net mgr!");
      return;
    }
    if (paramqb == null)
    {
      ya.b("TencentPay", "Cannot clear cry key for need change key! Null request!");
      return;
    }
    Context localContext = paramzb.b();
    if (localContext == null)
    {
      ya.b("TencentPay", "Cannot clear cry key for need change key! Null context!");
      return;
    }
    Object localObject = paramzb.d();
    if (localObject == null)
    {
      ya.b("TencentPay", "Cannot clear cry key for need change key! Null common info getter!");
      return;
    }
    localObject = ((ec)localObject).b();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ya.b("TencentPay", "Cannot clear cry key for need change key! Empty sdk version!");
      return;
    }
    String str = paramqb.w();
    if (TextUtils.isEmpty(str))
    {
      ya.b("TencentPay", "Cannot clear cry key for need change key! Empty offer id!");
      return;
    }
    paramqb = paramqb.x();
    if (TextUtils.isEmpty(paramqb))
    {
      ya.b("TencentPay", "Cannot clear cry key for need change key! Empty open id!");
      return;
    }
    ya.a("TencentPay", "Clear cry key and key time for need change key!");
    paramzb.b(localContext, paramqb, str, (String)localObject);
  }
  
  public gb a(zb paramzb)
  {
    gb localgb = new gb();
    if (paramzb == null) {
      return localgb;
    }
    Object localObject = paramzb.c();
    if (localObject == null) {
      return localgb;
    }
    localObject = paramzb.a((qb)localObject);
    if (rb.d((gb)localObject)) {
      return localObject;
    }
    localObject = paramzb.c();
    if (localObject == null) {
      return localgb;
    }
    ((qb)localObject).v = true;
    return paramzb.a((qb)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.mb
 * JD-Core Version:    0.7.0.1
 */