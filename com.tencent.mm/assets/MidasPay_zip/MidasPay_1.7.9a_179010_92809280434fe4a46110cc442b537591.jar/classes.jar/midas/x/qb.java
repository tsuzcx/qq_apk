package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class qb
  extends fb
{
  public final ArrayList<b> t;
  public kb u;
  public boolean v;
  public boolean w;
  public boolean x;
  public boolean y;
  
  public qb()
  {
    UUID.randomUUID().toString();
    this.t = new ArrayList();
    this.v = false;
    this.w = true;
    this.x = true;
    this.y = true;
    a("Accept-Charset", "UTF-8");
    a("Content-Type", "application/x-www-form-urlencoded");
  }
  
  public boolean A()
  {
    kb localkb = this.u;
    return (localkb != null) && (!TextUtils.isEmpty(localkb.b)) && ("crypt".equals(this.u.a));
  }
  
  public boolean B()
  {
    kb localkb = this.u;
    return (localkb != null) && (!TextUtils.isEmpty(localkb.b)) && ("secret".equals(this.u.a));
  }
  
  public void C() {}
  
  public void D() {}
  
  public void a(zb paramzb, kb paramkb, String paramString)
  {
    if (paramkb == null)
    {
      ya.b("TencentPay", "Cannot do encode, encode key is null!");
      return;
    }
    if (this.t.isEmpty()) {
      return;
    }
    if (TextUtils.isEmpty(paramkb.b))
    {
      ya.b("TencentPay", "Cannot encode parameter with empty key！");
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      if (paramkb.b()) {
        ya.b("TencentPay", "Current encode key is crypt key but key time is empty!");
      } else {
        ya.c("TencentPay", "Current encode key time is empty!");
      }
    }
    this.u = paramkb;
    ya.a("TencentPay", "Do encode param, call onEncodeStart");
    D();
    paramzb = t();
    if (TextUtils.isEmpty(paramzb))
    {
      ya.b("TencentPay", "Do encode param, encode param empty");
      return;
    }
    String str = hc.b(paramzb, paramkb.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Encode current request with key type = ");
    localStringBuilder.append(paramkb.a);
    ya.a("TencentPay", localStringBuilder.toString());
    paramkb = new StringBuilder();
    paramkb.append("Encode current request with key time = ");
    paramkb.append(paramString);
    ya.a("TencentPay", paramkb.toString());
    b("encrypt_msg", str);
    b("key_len", "newkey");
    b("key_time", paramString);
    b("msg_len", Integer.toString(paramzb.length()));
    ya.a("TencentPay", "Do encode param, call onEncodeFinish");
    C();
  }
  
  public String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ya.b("TencentPay", "Get encode parameter with empty key!");
      return "";
    }
    Object localObject = this.t;
    if (localObject == null)
    {
      ya.a("TencentPay", "Get encode parameter when there is no encode parameter!");
      return "";
    }
    if (((ArrayList)localObject).size() == 0)
    {
      ya.a("TencentPay", "Get encode parameter from 0 size map!");
      return "";
    }
    localObject = this.t.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (paramString.equals(localb.a)) {
        return localb.b;
      }
    }
    return "";
  }
  
  public final void e(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      ya.b("TencentPay", "Cannot add encode parameter with null key!");
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (this.t.size() != 0))
    {
      localObject = this.t.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if (paramString1.equals(localb.a))
        {
          localb.b = paramString2;
          return;
        }
      }
      localObject = new b(null);
      ((b)localObject).a = paramString1;
      ((b)localObject).b = paramString2;
      this.t.add(localObject);
      return;
    }
    Object localObject = new b(null);
    ((b)localObject).a = paramString1;
    ((b)localObject).b = paramString2;
    this.t.add(localObject);
  }
  
  public String t()
  {
    Object localObject = this.t;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (!TextUtils.isEmpty(localb.a))
        {
          ((StringBuilder)localObject).append(localb.a);
          ((StringBuilder)localObject).append("=");
        }
        ((StringBuilder)localObject).append(localb.b);
        ((StringBuilder)localObject).append("&");
      }
      if (((StringBuilder)localObject).length() > 0) {
        ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public final kb u()
  {
    return this.u;
  }
  
  public final String v()
  {
    kb localkb = this.u;
    if (localkb == null)
    {
      ya.b("TencentPay", "Cannot get encode key while not having one!");
      return "";
    }
    return localkb.b;
  }
  
  public final String w()
  {
    String str = a("offer_id");
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get offer id from request parameter success = ");
      localStringBuilder.append(str);
      ya.a("TencentPay", localStringBuilder.toString());
      return str;
    }
    ya.b("TencentPay", "Request parameter has no offer id!");
    return "";
  }
  
  public final String x()
  {
    String str = a("openid");
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get open id from request parameter success = ");
      localStringBuilder.append(str);
      ya.a("TencentPay", localStringBuilder.toString());
      return str;
    }
    ya.b("TencentPay", "Request parameter has no open id!");
    return "";
  }
  
  public final boolean y()
  {
    ArrayList localArrayList = this.t;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public boolean z()
  {
    kb localkb = this.u;
    return (localkb != null) && (!TextUtils.isEmpty(localkb.b)) && ("base".equals(this.u.a));
  }
  
  public static class b
  {
    public String a;
    public String b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.qb
 * JD-Core Version:    0.7.0.1
 */