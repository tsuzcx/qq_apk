package midas.x;

import android.text.TextUtils;

public final class le
  extends lc
{
  private final lq a;
  
  public le(lq paramlq)
  {
    this.a = paramlq;
  }
  
  private ld a(lj paramlj)
  {
    ld localld = new ld();
    if (this.a == null) {
      return localld;
    }
    if (paramlj == null) {
      return localld;
    }
    String str1 = this.a.b();
    localld.a = "base";
    localld.b = str1;
    if (paramlj.r)
    {
      ks.b("EncodeParameterHandler", "Request set to use base key!");
      return localld;
    }
    if (this.a.g() == null) {
      return localld;
    }
    str1 = paramlj.B();
    if (TextUtils.isEmpty(str1))
    {
      ks.a("EncodeParameterHandler", "Cannot get open id from request for getting encode key!");
      return localld;
    }
    boolean bool = this.a.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Get encode key, can use cry key to encode get key request = ");
    ((StringBuilder)localObject).append(bool);
    ks.b("EncodeParameterHandler", ((StringBuilder)localObject).toString());
    localObject = paramlj.C();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ks.a("EncodeParameterHandler", "Cannot get offer id from request for getting encode key!");
      return localld;
    }
    String str2 = this.a.b(str1, (String)localObject);
    if (!TextUtils.isEmpty(str2))
    {
      localld.a = "secret";
      localld.b = str2;
    }
    str1 = this.a.a(str1, (String)localObject);
    if (bool)
    {
      if (!TextUtils.isEmpty(str1))
      {
        localld.a = "crypt";
        localld.b = str1;
        return localld;
      }
    }
    else
    {
      bool = this.a.a(paramlj);
      if ((!TextUtils.isEmpty(str1)) && (!bool))
      {
        localld.a = "crypt";
        localld.b = str1;
      }
    }
    return localld;
  }
  
  private String b(lj paramlj)
  {
    if (this.a == null) {
      return "";
    }
    if (paramlj == null) {
      return "";
    }
    if (this.a.g() == null) {
      return "";
    }
    String str = paramlj.B();
    if (TextUtils.isEmpty(str))
    {
      ks.a("EncodeParameterHandler", "Cannot get open id from request for getting key time!");
      return "";
    }
    paramlj = paramlj.C();
    if (TextUtils.isEmpty(paramlj))
    {
      ks.a("EncodeParameterHandler", "Cannot get offer id from request for getting key time!");
      return "";
    }
    paramlj = this.a.c(str, paramlj);
    if (TextUtils.isEmpty(paramlj)) {
      return "";
    }
    return paramlj;
  }
  
  private void b(ky paramky)
  {
    if (paramky == null)
    {
      ks.a("EncodeParameterHandler", "Encode parameter handler, handle encode error, request is null!");
      return;
    }
    if (!(paramky instanceof lj))
    {
      ks.a("EncodeParameterHandler", "Encode parameter handler, handle encode error, not midas request!");
      return;
    }
    if (this.a == null)
    {
      ks.a("EncodeParameterHandler", "Encode parameter handler, net manager null!");
      return;
    }
    ks.b("EncodeParameterHandler", "Encode parameter handler, handle encode!");
    paramky = (lj)paramky;
    if (!paramky.D())
    {
      ks.b("EncodeParameterHandler", "Handle encode, no encode parameter!");
      return;
    }
    String str = b(paramky);
    ld localld = a(paramky);
    if ((!this.a.a(paramky)) && (localld.b())) {
      ks.a("EncodeParameterHandler", "Cannot use base key to encode normal request");
    }
    if (TextUtils.isEmpty(localld.b))
    {
      ks.a("EncodeParameterHandler", "Handle encode, key empty!");
      return;
    }
    paramky.a(this.a, localld, str);
  }
  
  public void a(ky paramky)
  {
    super.a(paramky);
    ks.b("EncodeParameterHandler", "Encode parameter handler http start!");
    if (paramky == null)
    {
      ks.a("EncodeParameterHandler", "Encode parameter handler http start error, request is null!");
      return;
    }
    b(paramky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.le
 * JD-Core Version:    0.7.0.1
 */