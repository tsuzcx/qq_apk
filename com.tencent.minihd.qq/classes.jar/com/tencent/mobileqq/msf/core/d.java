package com.tencent.mobileqq.msf.core;

import com.tencent.msf.service.protocol.serverconfig.j;
import com.tencent.qphone.base.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String c = "00000";
  public static final String d = "http";
  public static final String e = "socket";
  public byte f = 1;
  public byte g = 0;
  public boolean h = false;
  public String i = "";
  public AtomicInteger j = new AtomicInteger();
  long k = 0L;
  public boolean l = false;
  private String m = "socket";
  private String n;
  private int o;
  private int p = 20000;
  private boolean q = false;
  
  public static d a(j paramj, int paramInt)
  {
    d locald = new d();
    if ((paramj.e == 2) || (paramj.e == 3))
    {
      locald.m = "http";
      locald.n = paramj.a;
      locald.o = paramj.b;
      locald.i = "";
      locald.f = 0;
      locald.g = paramj.d;
      if (paramj.f <= 20) {
        break label135;
      }
      locald.p = 20000;
      label81:
      if (paramInt != 0) {
        break label168;
      }
      locald.i = "00000";
      locald.a(true);
    }
    for (;;)
    {
      if (paramj.g == 1) {
        locald.q = true;
      }
      return locald;
      if ((paramj.e != 0) && (paramj.e != 1)) {
        break;
      }
      locald.m = "socket";
      break;
      label135:
      if (paramj.f < 5)
      {
        locald.p = 5000;
        break label81;
      }
      locald.p = (paramj.f * 1000);
      break label81;
      label168:
      locald.a(false);
    }
  }
  
  public static d a(String paramString)
  {
    Object localObject = paramString.toLowerCase();
    paramString = new d();
    localObject = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+)(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?(:([a-zA-Z]+))?").matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches())
    {
      if (((Matcher)localObject).group(1) != null) {
        paramString.m = ((Matcher)localObject).group(1);
      }
      if (((Matcher)localObject).group(2) != null) {
        paramString.n = ((Matcher)localObject).group(2);
      }
      if (((Matcher)localObject).group(4) == null) {
        break label210;
      }
    }
    label210:
    for (paramString.o = Integer.parseInt(((Matcher)localObject).group(4));; paramString.o = 80)
    {
      if (((Matcher)localObject).group(6) != null) {
        paramString.i = ((Matcher)localObject).group(6);
      }
      if (((Matcher)localObject).group(8) != null) {
        paramString.f = Byte.parseByte(((Matcher)localObject).group(8));
      }
      if (((Matcher)localObject).group(10) != null) {
        paramString.g = Byte.parseByte(((Matcher)localObject).group(10));
      }
      if (((Matcher)localObject).group(12) != null) {
        paramString.p = (Integer.parseInt(((Matcher)localObject).group(12)) * 1000);
      }
      if (((Matcher)localObject).group(14) != null) {
        paramString.q = Boolean.parseBoolean(((Matcher)localObject).group(14));
      }
      paramString.a(paramString.i.equals("00000"));
      return paramString;
    }
  }
  
  public String a()
  {
    return this.n + ":" + this.o;
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(a parama)
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if ((parama == a.d) || (parama == a.c)) {
      if ((this.k == 0L) || (l1 - this.k > 600000L))
      {
        this.k = l1;
        this.j.incrementAndGet();
      }
    }
    for (;;)
    {
      if (this.j.get() > 19)
      {
        this.j.set(0);
        bool = true;
      }
      return bool;
      this.j.addAndGet(10);
      continue;
      if (parama == a.e) {
        this.j.addAndGet(10);
      } else if (parama == a.p) {
        this.j.addAndGet(20);
      } else if ((parama == a.j) || (parama == a.i)) {
        this.j.addAndGet(20);
      }
    }
  }
  
  public String b()
  {
    return this.m;
  }
  
  public void b(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public String c()
  {
    return this.n;
  }
  
  public void c(String paramString)
  {
    this.n = paramString;
  }
  
  public int d()
  {
    return this.o;
  }
  
  public int e()
  {
    return this.p;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (((d)paramObject).toString().equals(toString()));
  }
  
  public void f()
  {
    this.k = System.currentTimeMillis();
  }
  
  public boolean g()
  {
    return this.l;
  }
  
  public boolean h()
  {
    return this.q;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    return this.m + "://" + this.n + ":" + this.o + "#" + this.i + ":" + this.f + ":" + this.g + ":" + this.p / 1000 + ":" + this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d
 * JD-Core Version:    0.7.0.1
 */