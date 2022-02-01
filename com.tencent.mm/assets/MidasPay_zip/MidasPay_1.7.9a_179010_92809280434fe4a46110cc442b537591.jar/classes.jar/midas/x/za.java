package midas.x;

import android.text.TextUtils;

public final class za
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public za(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.a = paramString2;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ("http".equals(this.d)) {
      localStringBuilder.append("http://");
    } else if ("https".equals(this.d)) {
      localStringBuilder.append("https://");
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.a)) {
      if (oc.c(this.a))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("]");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      else
      {
        localStringBuilder.append(this.a);
      }
    }
    if (!TextUtils.isEmpty(this.b))
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.b);
    }
    if (!TextUtils.isEmpty(this.c))
    {
      if (this.c.startsWith("/"))
      {
        localObject = this.c;
        this.c = ((String)localObject).substring(1, ((String)localObject).length());
      }
      localStringBuilder.append("/");
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.a)) && (oc.a(this.a));
  }
  
  public boolean c()
  {
    return "https".equals(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.za
 * JD-Core Version:    0.7.0.1
 */