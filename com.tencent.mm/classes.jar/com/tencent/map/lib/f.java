package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.element.c;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.gl.JNICallback.l;
import com.tencent.map.lib.listener.a;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hj;
import com.tencent.tencentmap.mapsdk.maps.a.ho;
import com.tencent.tencentmap.mapsdk.maps.a.hp;
import com.tencent.tencentmap.mapsdk.maps.a.hr;
import com.tencent.tencentmap.mapsdk.maps.a.ht;
import com.tencent.tencentmap.mapsdk.maps.a.hu;
import com.tencent.tencentmap.mapsdk.maps.a.hv;
import com.tencent.tencentmap.mapsdk.maps.a.if;
import com.tencent.tencentmap.mapsdk.maps.a.ih;
import com.tencent.tencentmap.mapsdk.maps.a.ii;
import com.tencent.tencentmap.mapsdk.maps.a.ii.a;
import com.tencent.tencentmap.mapsdk.maps.a.ij;
import com.tencent.tencentmap.mapsdk.maps.a.ik;
import com.tencent.tencentmap.mapsdk.maps.a.iq;
import com.tencent.tencentmap.mapsdk.maps.a.ir;
import com.tencent.tencentmap.mapsdk.maps.a.it;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private boolean a;
  private ik b;
  private int c;
  private int d;
  private GeoPoint e;
  private int f;
  
  public f(ik paramik)
  {
    AppMethodBeat.i(146997);
    this.a = false;
    this.c = 20;
    this.d = 3;
    this.e = new GeoPoint();
    this.f = 0;
    this.b = paramik;
    AppMethodBeat.o(146997);
  }
  
  public int A()
  {
    AppMethodBeat.i(147014);
    int i = this.b.a(2, true);
    AppMethodBeat.o(147014);
    return i;
  }
  
  public MapLanguage B()
  {
    AppMethodBeat.i(147016);
    MapLanguage localMapLanguage = this.b.x();
    AppMethodBeat.o(147016);
    return localMapLanguage;
  }
  
  public boolean C()
  {
    AppMethodBeat.i(147017);
    boolean bool = this.b.A();
    AppMethodBeat.o(147017);
    return bool;
  }
  
  public void D()
  {
    AppMethodBeat.i(147018);
    this.b.B();
    AppMethodBeat.o(147018);
  }
  
  public String E()
  {
    AppMethodBeat.i(147019);
    String str = null;
    if (this.b != null) {
      str = this.b.D();
    }
    AppMethodBeat.o(147019);
    return str;
  }
  
  public boolean F()
  {
    return this.a;
  }
  
  public ArrayList<MapPoi> G()
  {
    AppMethodBeat.i(147020);
    if (this.b == null)
    {
      AppMethodBeat.o(147020);
      return null;
    }
    ArrayList localArrayList = this.b.F();
    AppMethodBeat.o(147020);
    return localArrayList;
  }
  
  public String H()
  {
    AppMethodBeat.i(147021);
    if (this.b == null)
    {
      AppMethodBeat.o(147021);
      return null;
    }
    String str = this.b.G();
    AppMethodBeat.o(147021);
    return str;
  }
  
  public String I()
  {
    AppMethodBeat.i(147022);
    if (this.b == null)
    {
      AppMethodBeat.o(147022);
      return null;
    }
    String str = this.b.H();
    AppMethodBeat.o(147022);
    return str;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97961);
    paramInt1 = this.b.a().a(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(97961);
    return paramInt1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    AppMethodBeat.i(97950);
    paramInt1 = this.b.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat);
    AppMethodBeat.o(97950);
    return paramInt1;
  }
  
  public int a(CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(97947);
    int i = this.b.a(paramCircleInfo);
    AppMethodBeat.o(97947);
    return i;
  }
  
  public int a(Polygon2D paramPolygon2D)
  {
    AppMethodBeat.i(97944);
    int i = this.b.a(paramPolygon2D);
    AppMethodBeat.o(97944);
    return i;
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(97909);
    paramGeoPoint = this.b.a(paramGeoPoint);
    AppMethodBeat.o(97909);
    return paramGeoPoint;
  }
  
  public void a()
  {
    AppMethodBeat.i(97904);
    this.b.w();
    AppMethodBeat.o(97904);
  }
  
  public void a(double paramDouble)
  {
    AppMethodBeat.i(97927);
    this.b.a().j(paramDouble);
    AppMethodBeat.o(97927);
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, Runnable paramRunnable)
  {
    AppMethodBeat.i(97979);
    this.b.a().a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramRunnable);
    AppMethodBeat.o(97979);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(97919);
    this.b.a().c(paramFloat);
    AppMethodBeat.o(97919);
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(97977);
    this.b.a().a(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(97977);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(97907);
    this.b.a().b(paramInt);
    AppMethodBeat.o(97907);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97918);
    this.b.a().a(paramInt1, paramInt2);
    AppMethodBeat.o(97918);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97988);
    this.b.a(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(97988);
  }
  
  public void a(int paramInt, CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(97948);
    this.b.a(paramInt, paramCircleInfo);
    AppMethodBeat.o(97948);
  }
  
  public void a(e parame)
  {
    AppMethodBeat.i(97963);
    this.b.a().a(parame);
    AppMethodBeat.o(97963);
  }
  
  public void a(j paramj)
  {
    AppMethodBeat.i(97911);
    this.b.c().a(paramj);
    this.b.q();
    AppMethodBeat.o(97911);
  }
  
  public void a(JNICallback.b paramb)
  {
    AppMethodBeat.i(97991);
    this.b.a(paramb);
    AppMethodBeat.o(97991);
  }
  
  public void a(JNICallback.c paramc)
  {
    AppMethodBeat.i(97992);
    this.b.a(paramc);
    AppMethodBeat.o(97992);
  }
  
  public void a(JNICallback.d paramd)
  {
    AppMethodBeat.i(97989);
    this.b.a(paramd);
    AppMethodBeat.o(97989);
  }
  
  public void a(JNICallback.e parame)
  {
    AppMethodBeat.i(97973);
    this.b.a(parame);
    AppMethodBeat.o(97973);
  }
  
  public void a(JNICallback.h paramh)
  {
    AppMethodBeat.i(147023);
    if (this.b == null)
    {
      AppMethodBeat.o(147023);
      return;
    }
    this.b.a(paramh);
    AppMethodBeat.o(147023);
  }
  
  public void a(JNICallback.k paramk)
  {
    AppMethodBeat.i(97993);
    this.b.a(paramk);
    AppMethodBeat.o(97993);
  }
  
  public void a(JNICallback.l paraml)
  {
    AppMethodBeat.i(147015);
    this.b.a(paraml);
    AppMethodBeat.o(147015);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(97940);
    this.b.c().a(parama);
    AppMethodBeat.o(97940);
  }
  
  public void a(ho paramho)
  {
    AppMethodBeat.i(146998);
    this.b.a().a(paramho);
    AppMethodBeat.o(146998);
  }
  
  public void a(hp paramhp)
  {
    AppMethodBeat.i(147002);
    this.b.a().a(paramhp);
    AppMethodBeat.o(147002);
  }
  
  public void a(hr paramhr)
  {
    AppMethodBeat.i(147003);
    this.b.a().a(paramhr);
    AppMethodBeat.o(147003);
  }
  
  public void a(ht paramht)
  {
    AppMethodBeat.i(147000);
    this.b.a().a(paramht);
    AppMethodBeat.o(147000);
  }
  
  public void a(hv paramhv)
  {
    AppMethodBeat.i(147007);
    this.b.a().c(paramhv);
    AppMethodBeat.o(147007);
  }
  
  public void a(ii.a parama)
  {
    AppMethodBeat.i(147009);
    this.b.a().a(parama);
    AppMethodBeat.o(147009);
  }
  
  public void a(ir paramir)
  {
    AppMethodBeat.i(147010);
    this.b.a().a(paramir);
    AppMethodBeat.o(147010);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(97928);
    this.b.a().a(paramRunnable);
    AppMethodBeat.o(97928);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(97997);
    this.b.b(paramString);
    AppMethodBeat.o(97997);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98009);
    if (this.b != null) {
      this.b.a(paramString1, paramString2);
    }
    AppMethodBeat.o(98009);
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(97953);
    this.b.a(paramList, paramList1);
    AppMethodBeat.o(97953);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(97922);
    this.b.a(paramBoolean);
    AppMethodBeat.o(97922);
  }
  
  public void a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(97970);
    this.b.a(paramArrayOfString);
    AppMethodBeat.o(97970);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97941);
    boolean bool = this.b.c().a(paramFloat1, paramFloat2);
    AppMethodBeat.o(97941);
    return bool;
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97934);
    it localit = this.b.o();
    if (localit == null)
    {
      AppMethodBeat.o(97934);
      return false;
    }
    boolean bool = localit.a(paramString, paramArrayOfByte);
    AppMethodBeat.o(97934);
    return bool;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public TappedElement b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(98000);
    TappedElement localTappedElement = this.b.a(paramFloat1, paramFloat2);
    AppMethodBeat.o(98000);
    return localTappedElement;
  }
  
  public void b(double paramDouble)
  {
    AppMethodBeat.i(97978);
    this.b.a().h(paramDouble);
    AppMethodBeat.o(97978);
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(97920);
    this.b.a().b(paramFloat);
    AppMethodBeat.o(97920);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(97910);
    this.b.a().a(paramInt);
    AppMethodBeat.o(97910);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97951);
    this.b.c(paramInt1, paramInt2);
    AppMethodBeat.o(97951);
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(97917);
    this.b.a().a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    AppMethodBeat.o(97917);
  }
  
  public void b(j paramj)
  {
    AppMethodBeat.i(97912);
    this.b.c().b(paramj);
    this.b.q();
    AppMethodBeat.o(97912);
  }
  
  public void b(Polygon2D paramPolygon2D)
  {
    AppMethodBeat.i(97945);
    this.b.b(paramPolygon2D);
    AppMethodBeat.o(97945);
  }
  
  public void b(ho paramho)
  {
    AppMethodBeat.i(146999);
    this.b.a().b(paramho);
    AppMethodBeat.o(146999);
  }
  
  public void b(hr paramhr)
  {
    AppMethodBeat.i(147004);
    this.b.a().b(paramhr);
    AppMethodBeat.o(147004);
  }
  
  public void b(ht paramht)
  {
    AppMethodBeat.i(147001);
    this.b.a().b(paramht);
    AppMethodBeat.o(147001);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(97929);
    this.b.a().b(paramRunnable);
    AppMethodBeat.o(97929);
  }
  
  public void b(String paramString)
  {
    AppMethodBeat.i(97999);
    this.b.a(paramString);
    AppMethodBeat.o(97999);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(97955);
    if (this.b != null) {
      this.b.d(paramBoolean);
    }
    AppMethodBeat.o(97955);
  }
  
  public boolean b(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97935);
    it localit = this.b.o();
    if (localit == null)
    {
      AppMethodBeat.o(97935);
      return false;
    }
    boolean bool = localit.b(paramString, paramArrayOfByte);
    AppMethodBeat.o(97935);
    return bool;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public c c(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(147008);
    paramGeoPoint = this.b.i().b(paramGeoPoint);
    AppMethodBeat.o(147008);
    return paramGeoPoint;
  }
  
  public void c(float paramFloat)
  {
    AppMethodBeat.i(97976);
    this.b.a().a(paramFloat);
    AppMethodBeat.o(97976);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(97946);
    this.b.c(paramInt);
    AppMethodBeat.o(97946);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97975);
    this.b.a().b(paramInt1, paramInt2);
    AppMethodBeat.o(97975);
  }
  
  public void c(String paramString)
  {
    AppMethodBeat.i(98003);
    this.b.c(paramString);
    AppMethodBeat.o(98003);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(97956);
    if (this.b != null) {
      this.b.e(paramBoolean);
    }
    AppMethodBeat.o(97956);
  }
  
  public int d()
  {
    AppMethodBeat.i(97905);
    int i = this.b.e().n();
    AppMethodBeat.o(97905);
    return i;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(97949);
    this.b.a(paramInt);
    AppMethodBeat.o(97949);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97994);
    this.b.d(paramInt1, paramInt2);
    AppMethodBeat.o(97994);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(97964);
    this.b.f(paramBoolean);
    AppMethodBeat.o(97964);
  }
  
  public int e()
  {
    AppMethodBeat.i(97906);
    int i = this.b.a().u();
    AppMethodBeat.o(97906);
    return i;
  }
  
  public int e(boolean paramBoolean)
  {
    AppMethodBeat.i(97985);
    int i = this.b.a(1, paramBoolean);
    AppMethodBeat.o(97985);
    return i;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(97952);
    this.b.b(paramInt);
    AppMethodBeat.o(97952);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97996);
    this.b.e(paramInt1, paramInt2);
    AppMethodBeat.o(97996);
  }
  
  public GeoPoint f()
  {
    AppMethodBeat.i(97908);
    GeoPoint localGeoPoint = this.b.a().n();
    AppMethodBeat.o(97908);
    return localGeoPoint;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(97965);
    this.b.d(paramInt);
    AppMethodBeat.o(97965);
  }
  
  public void f(boolean paramBoolean)
  {
    AppMethodBeat.i(97995);
    this.b.g(paramBoolean);
    AppMethodBeat.o(97995);
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(97971);
    this.c = paramInt;
    this.b.i().d(paramInt);
    this.b.e().c(paramInt);
    AppMethodBeat.o(97971);
  }
  
  public void g(boolean paramBoolean)
  {
    AppMethodBeat.i(98001);
    this.b.i(paramBoolean);
    AppMethodBeat.o(98001);
  }
  
  public boolean g()
  {
    AppMethodBeat.i(97921);
    boolean bool = this.b.u();
    AppMethodBeat.o(97921);
    return bool;
  }
  
  public int h()
  {
    AppMethodBeat.i(97923);
    int i = this.b.a().m();
    AppMethodBeat.o(97923);
    return i;
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(97972);
    this.d = paramInt;
    this.b.i().e(paramInt);
    AppMethodBeat.o(97972);
  }
  
  public void h(boolean paramBoolean)
  {
    AppMethodBeat.i(98002);
    this.b.j(paramBoolean);
    AppMethodBeat.o(98002);
  }
  
  public float i()
  {
    AppMethodBeat.i(97924);
    float f1 = this.b.a().l();
    AppMethodBeat.o(97924);
    return f1;
  }
  
  public void i(int paramInt)
  {
    AppMethodBeat.i(97986);
    this.b.e(paramInt);
    AppMethodBeat.o(97986);
  }
  
  public void i(boolean paramBoolean)
  {
    AppMethodBeat.i(98004);
    this.b.h(paramBoolean);
    AppMethodBeat.o(98004);
  }
  
  public float j()
  {
    AppMethodBeat.i(97925);
    float f1 = h();
    double d1 = k();
    f1 = (float)(f1 + Math.log(d1) / Math.log(2.0D));
    AppMethodBeat.o(97925);
    return f1;
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(97987);
    this.b.f(paramInt);
    AppMethodBeat.o(97987);
  }
  
  public void j(boolean paramBoolean)
  {
    AppMethodBeat.i(98007);
    if (this.b != null) {
      this.b.k(paramBoolean);
    }
    AppMethodBeat.o(98007);
  }
  
  public float k()
  {
    AppMethodBeat.i(97926);
    float f1 = this.b.a().q();
    AppMethodBeat.o(97926);
    return f1;
  }
  
  public void k(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void l()
  {
    AppMethodBeat.i(97930);
    this.b.a().s();
    AppMethodBeat.o(97930);
  }
  
  public void m()
  {
    AppMethodBeat.i(97931);
    this.b.s();
    AppMethodBeat.o(97931);
  }
  
  public void n()
  {
    AppMethodBeat.i(97932);
    this.b.t();
    AppMethodBeat.o(97932);
  }
  
  public void o()
  {
    AppMethodBeat.i(97933);
    this.b.r();
    AppMethodBeat.o(97933);
  }
  
  public void p()
  {
    AppMethodBeat.i(97936);
    it localit = this.b.o();
    if (localit == null)
    {
      AppMethodBeat.o(97936);
      return;
    }
    localit.c();
    AppMethodBeat.o(97936);
  }
  
  public float q()
  {
    AppMethodBeat.i(97942);
    float f1 = this.b.a().o();
    AppMethodBeat.o(97942);
    return f1;
  }
  
  public float r()
  {
    AppMethodBeat.i(97943);
    float f1 = this.b.a().p();
    AppMethodBeat.o(97943);
    return f1;
  }
  
  public void s()
  {
    AppMethodBeat.i(97954);
    this.b.v();
    AppMethodBeat.o(97954);
  }
  
  public hu t()
  {
    AppMethodBeat.i(147005);
    hu localhu = this.b.d();
    AppMethodBeat.o(147005);
    return localhu;
  }
  
  @Deprecated
  public hu u()
  {
    AppMethodBeat.i(147006);
    hj localhj = new hj(this.b);
    AppMethodBeat.o(147006);
    return localhj;
  }
  
  public void v()
  {
    AppMethodBeat.i(97960);
    this.b.a().A();
    AppMethodBeat.o(97960);
  }
  
  public Rect w()
  {
    AppMethodBeat.i(97962);
    Rect localRect = this.b.a().b();
    AppMethodBeat.o(97962);
    return localRect;
  }
  
  public ih x()
  {
    AppMethodBeat.i(147011);
    ih localih = this.b.y();
    AppMethodBeat.o(147011);
    return localih;
  }
  
  public iq y()
  {
    AppMethodBeat.i(147012);
    iq localiq = this.b.e();
    AppMethodBeat.o(147012);
    return localiq;
  }
  
  public int z()
  {
    AppMethodBeat.i(147013);
    int i = this.b.a(3, true);
    AppMethodBeat.o(147013);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.f
 * JD-Core Version:    0.7.0.1
 */