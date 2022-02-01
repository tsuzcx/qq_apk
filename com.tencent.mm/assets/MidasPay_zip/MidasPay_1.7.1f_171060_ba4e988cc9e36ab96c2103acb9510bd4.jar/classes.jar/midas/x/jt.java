package midas.x;

import android.text.TextUtils;

public final class jt
  extends jr
{
  private final kf a;
  
  public jt(kf paramkf)
  {
    this.a = paramkf;
  }
  
  private js a(jy paramjy)
  {
    js localjs = new js();
    if (this.a == null) {
      return localjs;
    }
    if (paramjy == null) {
      return localjs;
    }
    String str1 = this.a.b();
    localjs.a = "base";
    localjs.b = str1;
    if (paramjy.r)
    {
      jh.b("EncodeParameterHandler", "Request set to use base key!");
      return localjs;
    }
    if (this.a.g() == null) {
      return localjs;
    }
    str1 = paramjy.B();
    if (TextUtils.isEmpty(str1))
    {
      jh.a("EncodeParameterHandler", "Cannot get open id from request for getting encode key!");
      return localjs;
    }
    boolean bool = this.a.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Get encode key, can use cry key to encode get key request = ");
    ((StringBuilder)localObject).append(bool);
    jh.b("EncodeParameterHandler", ((StringBuilder)localObject).toString());
    localObject = paramjy.C();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      jh.a("EncodeParameterHandler", "Cannot get offer id from request for getting encode key!");
      return localjs;
    }
    String str2 = this.a.b(str1, (String)localObject);
    if (!TextUtils.isEmpty(str2))
    {
      localjs.a = "secret";
      localjs.b = str2;
    }
    str1 = this.a.a(str1, (String)localObject);
    if (bool)
    {
      if (!TextUtils.isEmpty(str1))
      {
        localjs.a = "crypt";
        localjs.b = str1;
        return localjs;
      }
    }
    else
    {
      bool = this.a.a(paramjy);
      if ((!TextUtils.isEmpty(str1)) && (!bool))
      {
        localjs.a = "crypt";
        localjs.b = str1;
      }
    }
    return localjs;
  }
  
  private String b(jy paramjy)
  {
    if (this.a == null) {
      return "";
    }
    if (paramjy == null) {
      return "";
    }
    if (this.a.g() == null) {
      return "";
    }
    String str = paramjy.B();
    if (TextUtils.isEmpty(str))
    {
      jh.a("EncodeParameterHandler", "Cannot get open id from request for getting key time!");
      return "";
    }
    paramjy = paramjy.C();
    if (TextUtils.isEmpty(paramjy))
    {
      jh.a("EncodeParameterHandler", "Cannot get offer id from request for getting key time!");
      return "";
    }
    paramjy = this.a.c(str, paramjy);
    if (TextUtils.isEmpty(paramjy)) {
      return "";
    }
    return paramjy;
  }
  
  private void b(jn paramjn)
  {
    if (paramjn == null)
    {
      jh.a("EncodeParameterHandler", "Encode parameter handler, handle encode error, request is null!");
      return;
    }
    if (!(paramjn instanceof jy))
    {
      jh.a("EncodeParameterHandler", "Encode parameter handler, handle encode error, not midas request!");
      return;
    }
    if (this.a == null)
    {
      jh.a("EncodeParameterHandler", "Encode parameter handler, net manager null!");
      return;
    }
    jh.b("EncodeParameterHandler", "Encode parameter handler, handle encode!");
    paramjn = (jy)paramjn;
    if (!paramjn.D())
    {
      jh.b("EncodeParameterHandler", "Handle encode, no encode parameter!");
      return;
    }
    String str = b(paramjn);
    js localjs = a(paramjn);
    if ((!this.a.a(paramjn)) && (localjs.b())) {
      jh.a("EncodeParameterHandler", "Cannot use base key to encode normal request");
    }
    if (TextUtils.isEmpty(localjs.b))
    {
      jh.a("EncodeParameterHandler", "Handle encode, key empty!");
      return;
    }
    paramjn.a(this.a, localjs, str);
  }
  
  public void a(jn paramjn)
  {
    super.a(paramjn);
    jh.b("EncodeParameterHandler", "Encode parameter handler http start!");
    if (paramjn == null)
    {
      jh.a("EncodeParameterHandler", "Encode parameter handler http start error, request is null!");
      return;
    }
    b(paramjn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jt
 * JD-Core Version:    0.7.0.1
 */