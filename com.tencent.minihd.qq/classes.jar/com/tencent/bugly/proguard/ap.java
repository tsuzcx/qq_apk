package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class ap
  extends k
  implements Cloneable
{
  private static ao m;
  private static Map<String, String> n;
  public boolean a = true;
  public boolean b = true;
  public boolean c = true;
  public String d = "";
  public String e = "";
  public ao f = null;
  public Map<String, String> g = null;
  public long h = 0L;
  public int i = 0;
  private String j = "";
  private String k = "";
  private int l = 0;
  
  static
  {
    if (!ap.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      o = bool;
      m = new ao();
      n = new HashMap();
      n.put("", "");
      return;
    }
  }
  
  public final void a(i parami)
  {
    boolean bool = this.a;
    this.a = parami.a(0, true);
    bool = this.b;
    this.b = parami.a(1, true);
    bool = this.c;
    this.c = parami.a(2, true);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = ((ao)parami.a(m, 5, false));
    this.g = ((Map)parami.a(n, 6, false));
    this.h = parami.a(this.h, 7, false);
    this.j = parami.b(8, false);
    this.k = parami.b(9, false);
    this.l = parami.a(this.l, 10, false);
    this.i = parami.a(this.i, 11, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
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
    if (this.j != null) {
      paramj.a(this.j, 8);
    }
    if (this.k != null) {
      paramj.a(this.k, 9);
    }
    paramj.a(this.l, 10);
    paramj.a(this.i, 11);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new h(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "enable");
    paramStringBuilder.a(this.b, "enableUserInfo");
    paramStringBuilder.a(this.c, "enableQuery");
    paramStringBuilder.a(this.d, "url");
    paramStringBuilder.a(this.e, "expUrl");
    paramStringBuilder.a(this.f, "security");
    paramStringBuilder.a(this.g, "valueMap");
    paramStringBuilder.a(this.h, "strategylastUpdateTime");
    paramStringBuilder.a(this.j, "httpsUrl");
    paramStringBuilder.a(this.k, "httpsExpUrl");
    paramStringBuilder.a(this.l, "eventRecordCount");
    paramStringBuilder.a(this.i, "eventTimeInterval");
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (o) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ap)paramObject;
    } while ((!l.a(this.a, paramObject.a)) || (!l.a(this.b, paramObject.b)) || (!l.a(this.c, paramObject.c)) || (!l.a(this.d, paramObject.d)) || (!l.a(this.e, paramObject.e)) || (!l.a(this.f, paramObject.f)) || (!l.a(this.g, paramObject.g)) || (!l.a(this.h, paramObject.h)) || (!l.a(this.j, paramObject.j)) || (!l.a(this.k, paramObject.k)) || (!l.a(this.l, paramObject.l)) || (!l.a(this.i, paramObject.i)));
    return true;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ap
 * JD-Core Version:    0.7.0.1
 */