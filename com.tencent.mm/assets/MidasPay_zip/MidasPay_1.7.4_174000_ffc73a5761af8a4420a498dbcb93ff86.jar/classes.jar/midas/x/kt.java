package midas.x;

import android.text.TextUtils;

public final class kt
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public kt(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.a = paramString2;
  }
  
  String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if ("http".equals(this.d)) {
      localStringBuilder1.append("http://");
    } else if ("https".equals(this.d)) {
      localStringBuilder1.append("https://");
    }
    if (!TextUtils.isEmpty(this.a)) {
      if (mf.c(this.a))
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[");
        localStringBuilder2.append(this.a);
        localStringBuilder2.append("]");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else
      {
        localStringBuilder1.append(this.a);
      }
    }
    if (!TextUtils.isEmpty(this.b))
    {
      localStringBuilder1.append(":");
      localStringBuilder1.append(this.b);
    }
    if (!TextUtils.isEmpty(this.c))
    {
      if (this.c.startsWith("/")) {
        this.c = this.c.substring(1, this.c.length());
      }
      localStringBuilder1.append("/");
      localStringBuilder1.append(this.c);
    }
    return localStringBuilder1.toString();
  }
  
  boolean b()
  {
    return (!TextUtils.isEmpty(this.a)) && (mf.b(this.a));
  }
  
  boolean c()
  {
    return "https".equals(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kt
 * JD-Core Version:    0.7.0.1
 */