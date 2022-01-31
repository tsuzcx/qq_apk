package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.listener.a;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.tencentmap.mapsdk.a.ih;
import com.tencent.tencentmap.mapsdk.a.ii;
import com.tencent.tencentmap.mapsdk.a.in;
import com.tencent.tencentmap.mapsdk.a.io;
import com.tencent.tencentmap.mapsdk.a.iq;
import com.tencent.tencentmap.mapsdk.a.is;
import com.tencent.tencentmap.mapsdk.a.iu;
import com.tencent.tencentmap.mapsdk.a.iv;
import com.tencent.tencentmap.mapsdk.a.jc;
import com.tencent.tencentmap.mapsdk.a.je;
import com.tencent.tencentmap.mapsdk.a.jf;
import com.tencent.tencentmap.mapsdk.a.jf.a;
import com.tencent.tencentmap.mapsdk.a.jg;
import com.tencent.tencentmap.mapsdk.a.jh;
import com.tencent.tencentmap.mapsdk.a.jo;
import com.tencent.tencentmap.mapsdk.a.jp;
import com.tencent.tencentmap.mapsdk.a.jr;
import com.tencent.tencentmap.mapsdk.a.kc;
import com.tencent.tencentmap.mapsdk.a.kj;
import java.util.List;

public class f
{
  private jh a;
  private int b = 19;
  private int c = 3;
  private GeoPoint d = new GeoPoint();
  private int e = 0;
  
  public f(jh paramjh)
  {
    this.a = paramjh;
  }
  
  public kc A()
  {
    return this.a.i().q();
  }
  
  public je B()
  {
    return this.a.B();
  }
  
  public jo C()
  {
    return this.a.e();
  }
  
  public int D()
  {
    return this.a.a(3, true);
  }
  
  public int E()
  {
    return this.a.a(2, true);
  }
  
  public MapLanguage F()
  {
    return this.a.A();
  }
  
  public boolean G()
  {
    return this.a.D();
  }
  
  public void H()
  {
    this.a.E();
  }
  
  public String I()
  {
    String str = null;
    if (this.a != null) {
      str = this.a.H();
    }
    return str;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.a.a().a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    return this.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat);
  }
  
  public int a(Polygon2D paramPolygon2D)
  {
    return this.a.a(paramPolygon2D);
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    return this.a.a(paramGeoPoint);
  }
  
  public void a()
  {
    this.a.x();
  }
  
  public void a(double paramDouble)
  {
    this.a.a().j(paramDouble);
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, Runnable paramRunnable)
  {
    this.a.a().a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramRunnable);
  }
  
  public void a(float paramFloat)
  {
    this.a.a().c(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    this.a.a().a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.a.a().b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(e parame)
  {
    this.a.a().a(parame);
  }
  
  public void a(JNICallback.b paramb)
  {
    this.a.a(paramb);
  }
  
  public void a(JNICallback.c paramc)
  {
    this.a.a(paramc);
  }
  
  public void a(JNICallback.d paramd)
  {
    this.a.a(paramd);
  }
  
  public void a(JNICallback.e parame)
  {
    this.a.a(parame);
  }
  
  public void a(JNICallback.j paramj)
  {
    this.a.a(paramj);
  }
  
  public void a(JNICallback.k paramk)
  {
    this.a.a(paramk);
  }
  
  public void a(a parama)
  {
    this.a.c().a(parama);
  }
  
  public void a(in paramin)
  {
    this.a.a().a(paramin);
  }
  
  public void a(io paramio)
  {
    this.a.a().a(paramio);
  }
  
  public void a(iq paramiq)
  {
    this.a.a().a(paramiq);
  }
  
  public void a(is paramis)
  {
    this.a.a().a(paramis);
  }
  
  public void a(iv paramiv)
  {
    this.a.a().c(paramiv);
  }
  
  public void a(jf.a parama)
  {
    this.a.a().a(parama);
  }
  
  public void a(jp paramjp)
  {
    this.a.a().a(paramjp);
  }
  
  public void a(kj paramkj)
  {
    this.a.c().a(paramkj);
    this.a.r();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.a().a(paramRunnable);
  }
  
  public void a(String paramString)
  {
    this.a.b(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a != null) {
      this.a.a(paramString1, paramString2);
    }
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    this.a.a(paramList, paramList1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.a.a(paramArrayOfString);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return this.a.c().a(paramFloat1, paramFloat2);
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    jr localjr = this.a.p();
    if (localjr == null) {
      return false;
    }
    return localjr.a(paramString, paramArrayOfByte);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public TappedElement b(float paramFloat1, float paramFloat2)
  {
    return this.a.a(paramFloat1, paramFloat2);
  }
  
  public void b(double paramDouble)
  {
    this.a.a().h(paramDouble);
  }
  
  public void b(float paramFloat)
  {
    this.a.a().b(paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.a.a().a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.c(paramInt1, paramInt2);
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    this.a.a().a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
  }
  
  public void b(Polygon2D paramPolygon2D)
  {
    this.a.b(paramPolygon2D);
  }
  
  public void b(in paramin)
  {
    this.a.a().b(paramin);
  }
  
  public void b(iq paramiq)
  {
    this.a.a().b(paramiq);
  }
  
  public void b(is paramis)
  {
    this.a.a().b(paramis);
  }
  
  public void b(kj paramkj)
  {
    this.a.c().b(paramkj);
    this.a.r();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.a.a().b(paramRunnable);
  }
  
  public void b(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.e(paramBoolean);
    }
  }
  
  public boolean b(String paramString, byte[] paramArrayOfByte)
  {
    jr localjr = this.a.p();
    if (localjr == null) {
      return false;
    }
    return localjr.b(paramString, paramArrayOfByte);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public String c(GeoPoint paramGeoPoint)
  {
    return this.a.b(paramGeoPoint);
  }
  
  public void c(float paramFloat)
  {
    this.a.a().a(paramFloat);
  }
  
  public void c(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.a.a().b(paramInt1, paramInt2);
  }
  
  public void c(String paramString)
  {
    this.a.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.f(paramBoolean);
    }
  }
  
  public int d()
  {
    return this.a.e().m();
  }
  
  public void d(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.a.d(paramInt1, paramInt2);
  }
  
  public void d(boolean paramBoolean)
  {
    this.a.g(paramBoolean);
  }
  
  public int e()
  {
    return this.a.a().u();
  }
  
  public int e(boolean paramBoolean)
  {
    return this.a.a(1, paramBoolean);
  }
  
  public void e(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    this.a.e(paramInt1, paramInt2);
  }
  
  public GeoPoint f()
  {
    return this.a.a().n();
  }
  
  public void f(int paramInt)
  {
    this.b = paramInt;
    this.a.i().c(paramInt);
  }
  
  public void f(boolean paramBoolean)
  {
    this.a.h(paramBoolean);
  }
  
  public void g(int paramInt)
  {
    this.c = paramInt;
    this.a.i().d(paramInt);
  }
  
  public void g(boolean paramBoolean)
  {
    this.a.j(paramBoolean);
  }
  
  public boolean g()
  {
    return this.a.v();
  }
  
  public int h()
  {
    return this.a.a().m();
  }
  
  public void h(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public void h(boolean paramBoolean)
  {
    this.a.k(paramBoolean);
  }
  
  public float i()
  {
    return this.a.a().l();
  }
  
  public void i(int paramInt)
  {
    this.a.e(paramInt);
  }
  
  public void i(boolean paramBoolean)
  {
    this.a.i(paramBoolean);
  }
  
  public float j()
  {
    float f = h();
    double d1 = k();
    return (float)(f + Math.log(d1) / Math.log(2.0D));
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.l(paramBoolean);
    }
  }
  
  public float k()
  {
    return this.a.a().q();
  }
  
  public void l()
  {
    this.a.a().s();
  }
  
  public void m()
  {
    this.a.t();
  }
  
  public void n()
  {
    this.a.u();
  }
  
  public void o()
  {
    int i = this.a.s();
    try
    {
      ih.a().a(i);
      ih.a().a(this.a.e());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void p()
  {
    jr localjr = this.a.p();
    if (localjr == null) {
      return;
    }
    localjr.c();
  }
  
  public float q()
  {
    return this.a.a().o();
  }
  
  public float r()
  {
    return this.a.a().p();
  }
  
  public void s()
  {
    this.a.w();
  }
  
  public iu t()
  {
    return this.a.d();
  }
  
  @Deprecated
  public iu u()
  {
    return new ii(this.a);
  }
  
  public void v()
  {
    this.a.a().A();
  }
  
  public Rect w()
  {
    return this.a.a().b();
  }
  
  public int x()
  {
    return this.a.i().o();
  }
  
  public String[] y()
  {
    return this.a.y();
  }
  
  public String z()
  {
    return this.a.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.f
 * JD-Core Version:    0.7.0.1
 */