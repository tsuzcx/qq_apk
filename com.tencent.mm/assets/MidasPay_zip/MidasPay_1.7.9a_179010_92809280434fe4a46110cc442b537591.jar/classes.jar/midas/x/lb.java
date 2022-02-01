package midas.x;

import android.text.TextUtils;

public final class lb
  extends jb
{
  public final zb a;
  
  public lb(zb paramzb)
  {
    this.a = paramzb;
  }
  
  public final kb a(qb paramqb)
  {
    kb localkb = new kb();
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return localkb;
    }
    if (paramqb == null) {
      return localkb;
    }
    localObject1 = ((zb)localObject1).a();
    localkb.a = "base";
    localkb.b = ((String)localObject1);
    if (paramqb.v)
    {
      ya.a("EncodeParameterHandler", "Request set to use base key!");
      return localkb;
    }
    if (this.a.d() == null) {
      return localkb;
    }
    localObject1 = paramqb.x();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ya.b("EncodeParameterHandler", "Cannot get open id from request for getting encode key!");
      return localkb;
    }
    boolean bool = this.a.e();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Get encode key, can use cry key to encode get key request = ");
    ((StringBuilder)localObject2).append(bool);
    ya.a("EncodeParameterHandler", ((StringBuilder)localObject2).toString());
    localObject2 = paramqb.w();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ya.b("EncodeParameterHandler", "Cannot get offer id from request for getting encode key!");
      return localkb;
    }
    String str = this.a.c((String)localObject1, (String)localObject2);
    if (!TextUtils.isEmpty(str))
    {
      localkb.a = "secret";
      localkb.b = str;
    }
    localObject1 = this.a.a((String)localObject1, (String)localObject2);
    if (bool)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localkb.a = "crypt";
        localkb.b = ((String)localObject1);
        return localkb;
      }
    }
    else
    {
      bool = this.a.a(paramqb);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!bool))
      {
        localkb.a = "crypt";
        localkb.b = ((String)localObject1);
      }
    }
    return localkb;
  }
  
  public void a(fb paramfb)
  {
    super.a(paramfb);
    ya.a("EncodeParameterHandler", "Encode parameter handler http start!");
    if (paramfb == null)
    {
      ya.b("EncodeParameterHandler", "Encode parameter handler http start error, request is null!");
      return;
    }
    b(paramfb);
  }
  
  public final String b(qb paramqb)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return "";
    }
    if (paramqb == null) {
      return "";
    }
    if (((zb)localObject).d() == null) {
      return "";
    }
    localObject = paramqb.x();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ya.b("EncodeParameterHandler", "Cannot get open id from request for getting key time!");
      return "";
    }
    paramqb = paramqb.w();
    if (TextUtils.isEmpty(paramqb))
    {
      ya.b("EncodeParameterHandler", "Cannot get offer id from request for getting key time!");
      return "";
    }
    paramqb = this.a.b((String)localObject, paramqb);
    if (TextUtils.isEmpty(paramqb)) {
      return "";
    }
    return paramqb;
  }
  
  public final void b(fb paramfb)
  {
    if (paramfb == null)
    {
      ya.b("EncodeParameterHandler", "Encode parameter handler, handle encode error, request is null!");
      return;
    }
    if (!(paramfb instanceof qb))
    {
      ya.b("EncodeParameterHandler", "Encode parameter handler, handle encode error, not midas request!");
      return;
    }
    if (this.a == null)
    {
      ya.b("EncodeParameterHandler", "Encode parameter handler, net manager null!");
      return;
    }
    ya.a("EncodeParameterHandler", "Encode parameter handler, handle encode!");
    paramfb = (qb)paramfb;
    if (!paramfb.y())
    {
      ya.a("EncodeParameterHandler", "Handle encode, no encode parameter!");
      return;
    }
    String str = b(paramfb);
    kb localkb = a(paramfb);
    if ((!this.a.a(paramfb)) && (localkb.a())) {
      ya.b("EncodeParameterHandler", "Cannot use base key to encode normal request");
    }
    if (TextUtils.isEmpty(localkb.b))
    {
      ya.b("EncodeParameterHandler", "Handle encode, key empty!");
      return;
    }
    paramfb.a(this.a, localkb, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.lb
 * JD-Core Version:    0.7.0.1
 */