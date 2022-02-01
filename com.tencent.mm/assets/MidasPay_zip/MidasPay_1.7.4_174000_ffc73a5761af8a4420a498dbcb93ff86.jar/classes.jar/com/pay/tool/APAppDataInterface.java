package com.pay.tool;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.fz;
import midas.x.h;
import midas.x.i;

public class APAppDataInterface
{
  private static APAppDataInterface a;
  private String A = "";
  private String B = "";
  private String C = "";
  private int D = 15000;
  private int E = 15000;
  private int F = 15000;
  private boolean G = false;
  private boolean H = true;
  private String I = "";
  private int J = 0;
  private int K = 0;
  private boolean L = false;
  private String b = "cpay_1.6.2";
  private String c = "SAjUAcATIzxnw4v3SAjUAcATIzxnw4v3";
  private boolean d = false;
  private String e = "release";
  private String f = "";
  private String g = "";
  private String h = "";
  private boolean i = false;
  private boolean j = true;
  private String k = "";
  private int l = 1;
  private boolean m = true;
  private int n = 0;
  private String o = "";
  private boolean p = true;
  private String q = "r";
  private int r = -1;
  private String s = "";
  private String t = "";
  private String u = "";
  private String v = "";
  private String w = "0";
  private String x = "";
  private String y = "0";
  private String z = "";
  
  public static APAppDataInterface singleton()
  {
    if (a == null) {
      a = new APAppDataInterface();
    }
    return a;
  }
  
  public String A()
  {
    return this.v;
  }
  
  public String B()
  {
    return a.a().d.getApplicationContext().getPackageName();
  }
  
  public String C()
  {
    String str = a.a().d.getPackageName();
    try
    {
      str = h.a(a.a().d.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public String D()
  {
    return this.I;
  }
  
  public String E()
  {
    return this.g;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("X<4w.auBnxNNcjVl");
    localStringBuilder.append(APTools.d);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt)
  {
    a.l = paramInt;
  }
  
  public void a(String paramString)
  {
    a.o = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    a.d = paramBoolean;
  }
  
  public String b()
  {
    return a.b;
  }
  
  public void b(int paramInt)
  {
    a.n = paramInt;
  }
  
  public void b(String paramString)
  {
    a.q = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    a.j = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    a.r = paramInt;
  }
  
  public void c(String paramString)
  {
    a.h = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    a.m = paramBoolean;
  }
  
  public boolean c()
  {
    return a.i;
  }
  
  public void d(int paramInt)
  {
    this.D = paramInt;
    try
    {
      fz localfz = new fz();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1.7.4_");
      ((StringBuilder)localObject).append(em.b().n().a.offerId);
      ((StringBuilder)localObject).append("t4");
      localObject = ((StringBuilder)localObject).toString();
      localfz.a(a.a().d, "TencentUnipay", (String)localObject, i.a(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(String paramString)
  {
    a.s = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    a.p = paramBoolean;
  }
  
  public boolean d()
  {
    return a.j;
  }
  
  public String e()
  {
    return a.e;
  }
  
  public void e(int paramInt)
  {
    this.E = paramInt;
    try
    {
      fz localfz = new fz();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1.7.4_");
      ((StringBuilder)localObject).append(em.b().n().a.offerId);
      ((StringBuilder)localObject).append("t3");
      localObject = ((StringBuilder)localObject).toString();
      localfz.a(a.a().d, "TencentUnipay", (String)localObject, i.a(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e(String paramString)
  {
    a.t = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    a.L = paramBoolean;
  }
  
  public void f(int paramInt)
  {
    this.F = paramInt;
    try
    {
      fz localfz = new fz();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1.7.4_");
      ((StringBuilder)localObject).append(em.b().n().a.offerId);
      ((StringBuilder)localObject).append("t2");
      localObject = ((StringBuilder)localObject).toString();
      localfz.a(a.a().d, "TencentUnipay", (String)localObject, i.a(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f(String paramString)
  {
    a.u = paramString;
  }
  
  public void f(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public boolean f()
  {
    return "release".equals(a.e);
  }
  
  public int g()
  {
    return a.l;
  }
  
  public void g(String paramString)
  {
    a.w = paramString;
  }
  
  public void g(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void h(String paramString)
  {
    a.y = paramString;
  }
  
  public boolean h()
  {
    return a.m;
  }
  
  public int i()
  {
    return a.n;
  }
  
  public void i(String paramString)
  {
    a.x = paramString;
  }
  
  public String j()
  {
    return a.o;
  }
  
  public void j(String paramString)
  {
    a.z = paramString;
  }
  
  public String k()
  {
    return a.q;
  }
  
  public void k(String paramString)
  {
    this.A = paramString;
  }
  
  public String l()
  {
    return a.h;
  }
  
  public void l(String paramString)
  {
    this.B = paramString;
  }
  
  public String m()
  {
    return a.s;
  }
  
  public void m(String paramString)
  {
    this.C = paramString;
  }
  
  public String n()
  {
    return a.t;
  }
  
  public void n(String paramString)
  {
    this.v = paramString;
  }
  
  public int o()
  {
    return a.r;
  }
  
  public void o(String paramString)
  {
    this.I = paramString;
  }
  
  public String p()
  {
    return a.u;
  }
  
  public void p(String paramString)
  {
    this.g = paramString;
  }
  
  public String q()
  {
    return a.w;
  }
  
  public String r()
  {
    return a.y;
  }
  
  public String s()
  {
    return a.x;
  }
  
  public void setEnv(String paramString)
  {
    a.e = paramString;
  }
  
  public String t()
  {
    return a.z;
  }
  
  public int u()
  {
    Object localObject1 = new fz();
    int i2 = this.D;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1.7.4_");
      ((StringBuilder)localObject2).append(em.b().n().a.offerId);
      ((StringBuilder)localObject2).append("t4");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ((fz)localObject1).a(a.a().d, "TencentUnipay", (String)localObject2);
      int i1 = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i1 = i.a((String)localObject1);
      }
      return i1;
    }
    catch (Exception localException) {}
    return i2;
  }
  
  public int v()
  {
    Object localObject1 = new fz();
    int i2 = this.E;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1.7.4_");
      ((StringBuilder)localObject2).append(em.b().n().a.offerId);
      ((StringBuilder)localObject2).append("t3");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ((fz)localObject1).a(a.a().d, "TencentUnipay", (String)localObject2);
      int i1 = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i1 = i.a((String)localObject1);
      }
      return i1;
    }
    catch (Exception localException) {}
    return i2;
  }
  
  public int w()
  {
    Object localObject1 = new fz();
    int i2 = this.F;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1.7.4_");
      ((StringBuilder)localObject2).append(em.b().n().a.offerId);
      ((StringBuilder)localObject2).append("t2");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ((fz)localObject1).a(a.a().d, "TencentUnipay", (String)localObject2);
      int i1 = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i1 = i.a((String)localObject1);
      }
      return i1;
    }
    catch (Exception localException) {}
    return i2;
  }
  
  public boolean x()
  {
    return a.L;
  }
  
  public boolean y()
  {
    return this.G;
  }
  
  public boolean z()
  {
    return this.H;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.tool.APAppDataInterface
 * JD-Core Version:    0.7.0.1
 */