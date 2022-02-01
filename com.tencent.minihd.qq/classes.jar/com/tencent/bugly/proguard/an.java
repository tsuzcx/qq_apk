package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class an
  extends k
{
  private static byte[] i;
  private static Map<String, String> j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public long e = 0L;
  public String f = "";
  public Map<String, String> g = null;
  private String h = "";
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    i = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    j = new HashMap();
    j.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    byte[] arrayOfByte = i;
    this.c = ((byte[])parami.c(2, false));
    this.d = parami.b(3, false);
    this.e = parami.a(this.e, 4, false);
    this.h = parami.b(5, false);
    this.f = parami.b(6, false);
    this.g = ((Map)parami.a(j, 7, false));
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
    paramj.a(this.e, 4);
    if (this.h != null) {
      paramj.a(this.h, 5);
    }
    if (this.f != null) {
      paramj.a(this.f, 6);
    }
    if (this.g != null) {
      paramj.a(this.g, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.an
 * JD-Core Version:    0.7.0.1
 */