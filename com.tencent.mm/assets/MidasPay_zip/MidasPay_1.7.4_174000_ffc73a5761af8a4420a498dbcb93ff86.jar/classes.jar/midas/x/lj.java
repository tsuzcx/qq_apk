package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class lj
  extends ky
{
  private final ArrayList<a> a = new ArrayList();
  private ld b;
  public final String q = UUID.randomUUID().toString();
  boolean r = false;
  protected boolean s = true;
  protected boolean t = true;
  protected boolean u = true;
  
  public lj()
  {
    b("Accept-Charset", "UTF-8");
    b("Content-Type", "application/x-www-form-urlencoded");
  }
  
  protected void A() {}
  
  public final String B()
  {
    String str = b("openid");
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get open id from request parameter success = ");
      localStringBuilder.append(str);
      ks.b("TencentPay", localStringBuilder.toString());
      return str;
    }
    ks.a("TencentPay", "Request parameter has no open id!");
    return "";
  }
  
  public final String C()
  {
    String str = b("offer_id");
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get offer id from request parameter success = ");
      localStringBuilder.append(str);
      ks.b("TencentPay", localStringBuilder.toString());
      return str;
    }
    ks.a("TencentPay", "Request parameter has no offer id!");
    return "";
  }
  
  final boolean D()
  {
    return (this.a != null) && (this.a.size() > 0);
  }
  
  public boolean E()
  {
    return (this.b != null) && (!TextUtils.isEmpty(this.b.b)) && ("base".equals(this.b.a));
  }
  
  public boolean F()
  {
    return (this.b != null) && (!TextUtils.isEmpty(this.b.b)) && ("secret".equals(this.b.a));
  }
  
  public boolean G()
  {
    return (this.b != null) && (!TextUtils.isEmpty(this.b.b)) && ("crypt".equals(this.b.a));
  }
  
  protected String H()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (!TextUtils.isEmpty(locala.a))
        {
          localStringBuilder.append(locala.a);
          localStringBuilder.append("=");
        }
        localStringBuilder.append(locala.b);
        localStringBuilder.append("&");
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(lq paramlq, ld paramld, String paramString)
  {
    if (paramld == null)
    {
      ks.a("TencentPay", "Cannot do encode, encode key is null!");
      return;
    }
    if (this.a.isEmpty()) {
      return;
    }
    if (TextUtils.isEmpty(paramld.b))
    {
      ks.a("TencentPay", "Cannot encode parameter with empty key！");
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      if (paramld.a()) {
        ks.a("TencentPay", "Current encode key is crypt key but key time is empty!");
      } else {
        ks.c("TencentPay", "Current encode key time is empty!");
      }
    }
    this.b = paramld;
    ks.b("TencentPay", "Do encode param, call onEncodeStart");
    a_();
    paramlq = H();
    if (TextUtils.isEmpty(paramlq))
    {
      ks.a("TencentPay", "Do encode param, encode param empty");
      return;
    }
    String str = ly.a(paramlq, paramld.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Encode current request with key type = ");
    localStringBuilder.append(paramld.a);
    ks.b("TencentPay", localStringBuilder.toString());
    paramld = new StringBuilder();
    paramld.append("Encode current request with key time = ");
    paramld.append(paramString);
    ks.b("TencentPay", paramld.toString());
    e("encrypt_msg", str);
    e("key_len", "newkey");
    e("key_time", paramString);
    e("msg_len", Integer.toString(paramlq.length()));
    ks.b("TencentPay", "Do encode param, call onEncodeFinish");
    A();
  }
  
  protected void a_() {}
  
  public String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ks.a("TencentPay", "Get encode parameter with empty key!");
      return "";
    }
    if (this.a == null)
    {
      ks.b("TencentPay", "Get encode parameter when there is no encode parameter!");
      return "";
    }
    if (this.a.size() == 0)
    {
      ks.b("TencentPay", "Get encode parameter from 0 size map!");
      return "";
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.a)) {
        return locala.b;
      }
    }
    return "";
  }
  
  public final void f(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      ks.a("TencentPay", "Cannot add encode parameter with null key!");
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (this.a.size() != 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        if (paramString1.equals(locala.a))
        {
          locala.b = paramString2;
          return;
        }
      }
      localObject = new a(null);
      ((a)localObject).a = paramString1;
      ((a)localObject).b = paramString2;
      this.a.add(localObject);
      return;
    }
    Object localObject = new a(null);
    ((a)localObject).a = paramString1;
    ((a)localObject).b = paramString2;
    this.a.add(localObject);
  }
  
  final ld y()
  {
    return this.b;
  }
  
  public final String z()
  {
    if (this.b == null)
    {
      ks.a("TencentPay", "Cannot get encode key while not having one!");
      return "";
    }
    return this.b.b;
  }
  
  static class a
  {
    public String a;
    public String b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lj
 * JD-Core Version:    0.7.0.1
 */