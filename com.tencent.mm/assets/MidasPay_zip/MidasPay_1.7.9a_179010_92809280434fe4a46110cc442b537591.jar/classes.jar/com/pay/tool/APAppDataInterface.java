package com.pay.tool;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import midas.x.a;
import midas.x.d6;
import midas.x.h;
import midas.x.i;
import midas.x.o4;
import midas.x.p4;

public class APAppDataInterface
{
  public static APAppDataInterface E;
  public boolean A = false;
  public boolean B = true;
  public String C = "";
  public boolean D = false;
  public String a = "cpay_1.6.2";
  public boolean b;
  public String c = "release";
  public String d = "";
  public String e = "";
  public boolean f = false;
  public boolean g = true;
  public int h = 1;
  public boolean i = true;
  public int j = 0;
  public String k = "";
  public boolean l;
  public String m = "r";
  public int n = -1;
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "0";
  public String t = "";
  public String u = "0";
  public String v = "";
  public String w = "0";
  public int x = 15000;
  public int y = 15000;
  public int z = 15000;
  
  public static APAppDataInterface singleton()
  {
    if (E == null) {
      E = new APAppDataInterface();
    }
    return E;
  }
  
  public String A()
  {
    return E.a;
  }
  
  public String B()
  {
    return E.v;
  }
  
  public String C()
  {
    return E.e;
  }
  
  public boolean D()
  {
    return "release".equals(E.c);
  }
  
  public boolean E()
  {
    return this.A;
  }
  
  public boolean F()
  {
    return this.B;
  }
  
  public int a()
  {
    return E.h;
  }
  
  public void a(int paramInt)
  {
    E.h = paramInt;
  }
  
  public void a(String paramString)
  {
    this.C = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    E.b = paramBoolean;
  }
  
  public String b()
  {
    return a.r().d.getApplicationContext().getPackageName();
  }
  
  public void b(int paramInt)
  {
    E.j = paramInt;
  }
  
  public void b(String paramString)
  {
    E.m = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    E.l = paramBoolean;
  }
  
  public String c()
  {
    String str = a.r().d.getPackageName();
    try
    {
      str = h.a(a.r().d.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public void c(int paramInt)
  {
    E.n = paramInt;
  }
  
  public void c(String paramString)
  {
    E.k = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public String d()
  {
    return this.C;
  }
  
  public void d(int paramInt)
  {
    this.z = paramInt;
    try
    {
      d6 locald6 = new d6();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1.7.9a_");
      ((StringBuilder)localObject).append(p4.p().e().b.offerId);
      ((StringBuilder)localObject).append("t2");
      localObject = ((StringBuilder)localObject).toString();
      locald6.a(a.r().d, "TencentUnipay", (String)localObject, i.a(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(String paramString) {}
  
  public void d(boolean paramBoolean)
  {
    E.D = paramBoolean;
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("X<4w.auBnxNNcjVl");
    localStringBuilder.append(APTools.c);
    return localStringBuilder.toString();
  }
  
  public void e(int paramInt)
  {
    this.y = paramInt;
    try
    {
      d6 locald6 = new d6();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1.7.9a_");
      ((StringBuilder)localObject).append(p4.p().e().b.offerId);
      ((StringBuilder)localObject).append("t3");
      localObject = ((StringBuilder)localObject).toString();
      locald6.a(a.r().d, "TencentUnipay", (String)localObject, i.a(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e(String paramString)
  {
    E.s = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    E.g = paramBoolean;
  }
  
  public String f()
  {
    return E.m;
  }
  
  public void f(int paramInt)
  {
    this.x = paramInt;
    try
    {
      d6 locald6 = new d6();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1.7.9a_");
      ((StringBuilder)localObject).append(p4.p().e().b.offerId);
      ((StringBuilder)localObject).append("t4");
      localObject = ((StringBuilder)localObject).toString();
      locald6.a(a.r().d, "TencentUnipay", (String)localObject, i.a(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f(String paramString)
  {
    E.u = paramString;
  }
  
  public void f(boolean paramBoolean)
  {
    E.i = paramBoolean;
  }
  
  public String g()
  {
    return E.k;
  }
  
  public void g(String paramString)
  {
    this.w = paramString;
  }
  
  public void g(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public String h()
  {
    return E.c;
  }
  
  public void h(String paramString)
  {
    E.q = paramString;
  }
  
  public String i()
  {
    return E.s;
  }
  
  public void i(String paramString)
  {
    this.r = paramString;
  }
  
  public String j()
  {
    return E.u;
  }
  
  public void j(String paramString)
  {
    E.p = paramString;
  }
  
  public String k()
  {
    return this.w;
  }
  
  public void k(String paramString)
  {
    E.o = paramString;
  }
  
  public void l(String paramString) {}
  
  public boolean l()
  {
    return E.D;
  }
  
  public void m(String paramString)
  {
    E.t = paramString;
  }
  
  public boolean m()
  {
    return E.g;
  }
  
  public void n(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean n()
  {
    return E.i;
  }
  
  public String o()
  {
    return E.q;
  }
  
  public void o(String paramString) {}
  
  public String p()
  {
    return this.r;
  }
  
  public void p(String paramString)
  {
    E.v = paramString;
  }
  
  public String q()
  {
    return E.p;
  }
  
  public String r()
  {
    return E.o;
  }
  
  public int s()
  {
    return E.j;
  }
  
  public void setEnv(String paramString)
  {
    E.c = paramString;
  }
  
  public String t()
  {
    return E.t;
  }
  
  public boolean u()
  {
    return E.f;
  }
  
  public int v()
  {
    return E.n;
  }
  
  public String w()
  {
    return this.d;
  }
  
  public int x()
  {
    Object localObject1 = new d6();
    int i2 = this.z;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1.7.9a_");
      ((StringBuilder)localObject2).append(p4.p().e().b.offerId);
      ((StringBuilder)localObject2).append("t2");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ((d6)localObject1).a(a.r().d, "TencentUnipay", (String)localObject2);
      int i1 = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i1 = i.b((String)localObject1);
      }
      return i1;
    }
    catch (Exception localException) {}
    return i2;
  }
  
  public int y()
  {
    Object localObject1 = new d6();
    int i2 = this.y;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1.7.9a_");
      ((StringBuilder)localObject2).append(p4.p().e().b.offerId);
      ((StringBuilder)localObject2).append("t3");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ((d6)localObject1).a(a.r().d, "TencentUnipay", (String)localObject2);
      int i1 = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i1 = i.b((String)localObject1);
      }
      return i1;
    }
    catch (Exception localException) {}
    return i2;
  }
  
  public int z()
  {
    Object localObject1 = new d6();
    int i2 = this.x;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1.7.9a_");
      ((StringBuilder)localObject2).append(p4.p().e().b.offerId);
      ((StringBuilder)localObject2).append("t4");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ((d6)localObject1).a(a.r().d, "TencentUnipay", (String)localObject2);
      int i1 = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i1 = i.b((String)localObject1);
      }
      return i1;
    }
    catch (Exception localException) {}
    return i2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.tool.APAppDataInterface
 * JD-Core Version:    0.7.0.1
 */