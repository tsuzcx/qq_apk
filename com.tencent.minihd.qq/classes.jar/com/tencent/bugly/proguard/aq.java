package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class aq
  extends k
{
  private static Map<String, String> i = new HashMap();
  public long a = 0L;
  public byte b = 0;
  public String c = "";
  public String d = "";
  public String e = "";
  public Map<String, String> f = null;
  public String g = "";
  public boolean h = true;
  
  static
  {
    i.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    this.c = parami.b(2, false);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = ((Map)parami.a(i, 5, false));
    this.g = parami.b(6, false);
    boolean bool = this.h;
    this.h = parami.a(7, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    if (this.c != null) {
      paramj.a(this.c, 2);
    }
    if (this.d != null) {
      paramj.a(this.d, 3);
    }
    if (this.e != null) {
      paramj.a(this.e, 4);
    }
    if (this.f != null) {
      paramj.a(this.f, 5);
    }
    if (this.g != null) {
      paramj.a(this.g, 6);
    }
    paramj.a(this.h, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.aq
 * JD-Core Version:    0.7.0.1
 */