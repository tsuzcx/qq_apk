package c.t.m.g;

import android.text.TextUtils;

public final class dh
{
  public int a;
  String b;
  String c;
  public String d;
  String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public long k;
  public volatile long l = 0L;
  public volatile long m = 0L;
  public volatile long n = 0L;
  public volatile String o = "";
  public String p = "6.4.1.3";
  private String q;
  private String r = "6.4.1.3";
  private String s = "180911";
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "0123456789ABCDEF";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.e)) || (this.e.contains("0000"))) {
      return "0123456789ABCDEF";
    }
    return this.e;
  }
  
  public final String d()
  {
    if (this.r == null) {
      return "None";
    }
    return this.r;
  }
  
  public final String e()
  {
    if (this.s == null) {
      return "None";
    }
    return this.s;
  }
  
  public final String f()
  {
    if (this.q == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(a()).append("_").append(b()).append("_").append(c()).append("_QQGeoLocation");
      this.q = j.e(localStringBuilder.toString());
    }
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.dh
 * JD-Core Version:    0.7.0.1
 */