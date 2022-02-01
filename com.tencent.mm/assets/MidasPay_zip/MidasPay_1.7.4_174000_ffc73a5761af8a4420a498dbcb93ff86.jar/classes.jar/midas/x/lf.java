package midas.x;

import android.content.Context;
import android.text.TextUtils;

class lf
  implements kv
{
  static final Object a = new Object();
  
  static void a(lq paramlq, ky paramky)
  {
    if (paramlq == null)
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099! null net mgr");
      return;
    }
    if (paramky == null)
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099! null request");
      return;
    }
    if (!(paramky instanceof lj)) {
      return;
    }
    paramky = (lj)paramky;
    Context localContext = paramlq.f();
    if (localContext == null)
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099! null context");
      return;
    }
    Object localObject = paramlq.g();
    if (localObject == null)
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099! null common info getter");
      return;
    }
    localObject = ((lv)localObject).a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099! Empty sdk version!");
      return;
    }
    String str1 = paramky.C();
    if (TextUtils.isEmpty(str1))
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099! Empty offer id!");
      return;
    }
    String str2 = paramky.B();
    if (TextUtils.isEmpty(str2))
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099! empty open id");
      return;
    }
    if (paramky.E())
    {
      ks.a("TencentPay", "Got 1094 or 1099 or 1105 when encode with base key! Base key only for get key!");
      return;
    }
    if (paramky.F())
    {
      ks.a("TencentPay", "Got 1094 or 1099 or 1105 when encode with secret key! clear all key!");
      paramlq.b(localContext, str2, str1, (String)localObject);
      return;
    }
    if (paramky.G())
    {
      ks.a("TencentPay", "Got 1094 or 1099 or 1105 when encode with cry key! clear cry key and key time!");
      paramlq.c(localContext, str2, str1, (String)localObject);
    }
  }
  
  static void a(lq paramlq, kz paramkz)
  {
    if (paramlq == null)
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099!  Net manager null!");
      return;
    }
    if (paramkz == null)
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099!  Response null!");
      return;
    }
    ky localky = paramkz.a();
    if (localky == null)
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099!  Request null!");
      return;
    }
    if (!paramlq.a(localky))
    {
      ks.a("TencentPay", "Cannot clear key for 1094 or 1099!  Not get key response!");
      return;
    }
    int i = lk.b(paramkz);
    if ((i == 1099) || (i == 1094) || (i == 1105)) {
      a(paramlq, localky);
    }
  }
  
  static void a(lq paramlq, lj paramlj)
  {
    if (paramlq == null)
    {
      ks.a("TencentPay", "Cannot clear cry key for need change key! Null net mgr!");
      return;
    }
    if (paramlj == null)
    {
      ks.a("TencentPay", "Cannot clear cry key for need change key! Null request!");
      return;
    }
    Context localContext = paramlq.f();
    if (localContext == null)
    {
      ks.a("TencentPay", "Cannot clear cry key for need change key! Null context!");
      return;
    }
    Object localObject = paramlq.g();
    if (localObject == null)
    {
      ks.a("TencentPay", "Cannot clear cry key for need change key! Null common info getter!");
      return;
    }
    localObject = ((lv)localObject).a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ks.a("TencentPay", "Cannot clear cry key for need change key! Empty sdk version!");
      return;
    }
    String str = paramlj.C();
    if (TextUtils.isEmpty(str))
    {
      ks.a("TencentPay", "Cannot clear cry key for need change key! Empty offer id!");
      return;
    }
    paramlj = paramlj.B();
    if (TextUtils.isEmpty(paramlj))
    {
      ks.a("TencentPay", "Cannot clear cry key for need change key! Empty open id!");
      return;
    }
    ks.b("TencentPay", "Clear cry key and key time for need change key!");
    paramlq.c(localContext, paramlj, str, (String)localObject);
  }
  
  public kz a(ky paramky, kz paramkz)
  {
    return null;
  }
  
  kz a(lq paramlq)
  {
    kz localkz = new kz();
    if (paramlq == null) {
      return localkz;
    }
    Object localObject = paramlq.e();
    if (localObject == null) {
      return localkz;
    }
    localObject = paramlq.a((lj)localObject);
    if (lk.c((kz)localObject)) {
      return localObject;
    }
    localObject = paramlq.e();
    if (localObject == null) {
      return localkz;
    }
    ((lj)localObject).r = true;
    return paramlq.a((lj)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lf
 * JD-Core Version:    0.7.0.1
 */