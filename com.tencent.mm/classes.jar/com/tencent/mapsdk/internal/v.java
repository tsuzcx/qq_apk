package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;

public final class v
  implements Cloneable
{
  public int a;
  public a b;
  public Rect c;
  public int d;
  public double e;
  public double f;
  public double g;
  public double h;
  public double i;
  public double j;
  public double k;
  public double l;
  public GeoPoint m;
  public Rect n;
  public mk o;
  public sc p;
  public fl q;
  public b r;
  
  public v(mk parammk)
  {
    AppMethodBeat.i(224516);
    this.g = 0.0D;
    this.h = 1.0D;
    this.i = 0.0D;
    this.j = 1.0D;
    this.k = 0.0D;
    this.l = 1.0D;
    this.a = -1;
    this.b = new a();
    this.c = new Rect();
    this.m = new GeoPoint();
    this.q = new fl();
    this.o = parammk;
    this.p = parammk.g;
    AppMethodBeat.o(224516);
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(224808);
    this.q.a(paramDouble1, paramDouble2);
    AppMethodBeat.o(224808);
  }
  
  private void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224543);
    this.n = paramRect;
    this.c = GeometryConstants.BOUNDARY_WORLD;
    c(13);
    a(0);
    a(paramInt1, paramInt2, false);
    AppMethodBeat.o(224543);
  }
  
  private void a(v paramv)
  {
    AppMethodBeat.i(224529);
    this.a = paramv.a;
    a locala1 = this.b;
    a locala2 = paramv.b;
    locala1.l = locala2.l;
    locala1.m = locala2.m;
    locala1.n = locala2.n;
    locala1.o = locala2.o;
    locala1.p = locala2.p;
    locala1.q = locala2.q;
    this.c.set(paramv.c);
    this.d = paramv.d;
    this.e = paramv.e;
    this.f = paramv.f;
    this.g = paramv.g;
    this.h = paramv.h;
    this.i = paramv.i;
    this.j = paramv.j;
    this.k = paramv.k;
    this.l = paramv.l;
    this.m.setGeoPoint(paramv.m);
    this.q.a(paramv.q.a, paramv.q.b);
    this.n = paramv.n;
    AppMethodBeat.o(224529);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224778);
    boolean bool = a(paramInt1, paramInt2, false);
    AppMethodBeat.o(224778);
    return bool;
  }
  
  private boolean a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224774);
    boolean bool = a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6(), true);
    AppMethodBeat.o(224774);
    return bool;
  }
  
  private void b()
  {
    AppMethodBeat.i(224555);
    if (this.o == null)
    {
      AppMethodBeat.o(224555);
      return;
    }
    this.m = this.p.n();
    int i1 = this.p.p();
    float f1 = this.p.o();
    if (i1 != this.b.q) {
      this.o.i.c(fv.c);
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.a(i1, f1);
      }
      this.a = this.p.s();
      AppMethodBeat.o(224555);
      return;
      if (f1 != this.b.p) {
        this.o.i.c(fv.b);
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 8) || (paramInt == 13) || (paramInt == 10);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224801);
    int i1 = 1 << 20 - this.b.q;
    int i2;
    if (131072 > i1)
    {
      i2 = (this.n.width() * 131072 - this.n.width() * i1) / 2;
      i1 = (this.n.height() * 131072 - i1 * this.n.height()) / 2;
    }
    for (;;)
    {
      int i3 = this.c.left - i2;
      i2 = this.c.right + i2;
      int i5 = this.c.top - i1;
      int i4 = i1 + this.c.bottom;
      if (paramInt1 < i5) {
        paramInt1 = i5;
      }
      for (;;)
      {
        i1 = paramInt1;
        if (paramInt1 > i4) {
          i1 = i4;
        }
        if (paramInt2 < i3) {}
        for (paramInt1 = i3;; paramInt1 = paramInt2)
        {
          paramInt2 = paramInt1;
          if (paramInt1 > i2) {
            paramInt2 = i2;
          }
          GeoPoint localGeoPoint = new GeoPoint(i1, paramInt2);
          sc localsc = this.p;
          localsc.j.a(new sc.154(localsc, localGeoPoint));
          AppMethodBeat.o(224801);
          return true;
        }
      }
      i1 = 0;
      i2 = 0;
    }
  }
  
  private boolean b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224792);
    int i5 = paramGeoPoint.getLatitudeE6();
    int i3 = paramGeoPoint.getLongitudeE6();
    int i1 = 1 << 20 - this.b.q;
    int i2;
    if (131072 > i1)
    {
      i2 = (this.n.width() * 131072 - this.n.width() * i1) / 2;
      i1 = (this.n.height() * 131072 - i1 * this.n.height()) / 2;
    }
    for (;;)
    {
      int i6 = this.c.left - i2;
      int i4 = this.c.right + i2;
      i2 = this.c.top - i1;
      int i7 = i1 + this.c.bottom;
      if (i5 < i2) {}
      for (i1 = i2;; i1 = i5)
      {
        i2 = i1;
        if (i1 > i7) {
          i2 = i7;
        }
        if (i3 < i6) {}
        for (i1 = i6;; i1 = i3)
        {
          i3 = i1;
          if (i1 > i4) {
            i3 = i4;
          }
          paramGeoPoint = new GeoPoint(i2, i3);
          sc localsc = this.p;
          localsc.j.a(new sc.154(localsc, paramGeoPoint));
          AppMethodBeat.o(224792);
          return true;
        }
      }
      i1 = 0;
      i2 = 0;
    }
  }
  
  private int c()
  {
    AppMethodBeat.i(224564);
    if (this.p == null)
    {
      i1 = this.a;
      AppMethodBeat.o(224564);
      return i1;
    }
    int i1 = this.p.s();
    AppMethodBeat.o(224564);
    return i1;
  }
  
  private float d()
  {
    AppMethodBeat.i(224585);
    float f1 = this.p.r();
    AppMethodBeat.o(224585);
    return f1;
  }
  
  private void d(int paramInt)
  {
    double d1 = (1 << paramInt) * 256;
    this.d = ((int)d1);
    this.e = (d1 / 360.0D);
    this.f = (d1 / 6.283185307179586D);
  }
  
  private double e()
  {
    return this.g;
  }
  
  private static float e(int paramInt)
  {
    AppMethodBeat.i(224706);
    float f1 = a.a(paramInt);
    AppMethodBeat.o(224706);
    return f1;
  }
  
  private int e(float paramFloat)
  {
    AppMethodBeat.i(224659);
    if (this.p != null)
    {
      sc localsc = this.p;
      localsc.a(new sc.160(localsc, paramFloat));
    }
    this.b.p = paramFloat;
    int i1 = fv.c;
    AppMethodBeat.o(224659);
    return i1;
  }
  
  private double f()
  {
    return this.h;
  }
  
  private void f(int paramInt)
  {
    this.b.o = paramInt;
  }
  
  private double g()
  {
    return this.i;
  }
  
  private void g(int paramInt)
  {
    this.b.n = paramInt;
  }
  
  private double h()
  {
    return this.j;
  }
  
  private double i()
  {
    return this.l;
  }
  
  private double j()
  {
    return this.k;
  }
  
  private float k()
  {
    AppMethodBeat.i(224648);
    float f1 = this.p.q();
    AppMethodBeat.o(224648);
    return f1;
  }
  
  private int l()
  {
    return this.d;
  }
  
  private double m()
  {
    return this.e;
  }
  
  private double n()
  {
    return this.f;
  }
  
  private float o()
  {
    return this.b.p;
  }
  
  private int p()
  {
    return this.b.q;
  }
  
  private float q()
  {
    AppMethodBeat.i(224720);
    float f1 = this.b.a();
    AppMethodBeat.o(224720);
    return f1;
  }
  
  private int r()
  {
    return this.b.n;
  }
  
  private int s()
  {
    return this.b.o;
  }
  
  private static int t()
  {
    return 20;
  }
  
  private float u()
  {
    return this.b.l;
  }
  
  private GeoPoint v()
  {
    return this.m;
  }
  
  private Rect w()
  {
    return this.n;
  }
  
  private fl x()
  {
    return this.q;
  }
  
  private b y()
  {
    return this.r;
  }
  
  private static byte[] z()
  {
    return null;
  }
  
  public final float a()
  {
    AppMethodBeat.i(224921);
    float f1 = (float)(Math.log(this.b.p) / Math.log(2.0D));
    AppMethodBeat.o(224921);
    return 20.0F + f1;
  }
  
  public final float a(float paramFloat)
  {
    AppMethodBeat.i(224876);
    if (this.p.r() == paramFloat)
    {
      AppMethodBeat.o(224876);
      return paramFloat;
    }
    float f1 = paramFloat % 360.0F;
    double d1 = Math.toRadians(paramFloat);
    this.g = Math.sin(d1);
    this.h = Math.cos(d1);
    if (this.p != null)
    {
      sc localsc = this.p;
      localsc.a(new sc.5(localsc, f1));
    }
    AppMethodBeat.o(224876);
    return f1;
  }
  
  public final void a(Rect paramRect)
  {
    AppMethodBeat.i(224933);
    this.c.set(paramRect);
    AppMethodBeat.o(224933);
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(224956);
    if (this.r == null) {
      this.r = new b(paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.o.a(paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(224956);
      return true;
      b localb = this.r;
      localb.a = paramFloat1;
      localb.b = paramFloat2;
    }
  }
  
  public final boolean a(int paramInt)
  {
    AppMethodBeat.i(224865);
    if (this.p == null)
    {
      AppMethodBeat.o(224865);
      return false;
    }
    int i1 = this.p.s();
    if (i1 == paramInt)
    {
      AppMethodBeat.o(224865);
      return false;
    }
    if (i1 == 11) {
      this.o.b(false);
    }
    if (paramInt == 11) {
      this.o.b(true);
    }
    this.a = paramInt;
    this.p.c(paramInt);
    this.p.d(b(paramInt));
    kh.b("TDZ", "setMapStyle : styleId[" + paramInt + "]");
    AppMethodBeat.o(224865);
    return true;
  }
  
  public final boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(224946);
    int i1;
    int i2;
    if (1 << 20 - this.b.q < 0)
    {
      i1 = 0;
      if (131072 <= i1) {
        break label285;
      }
      i2 = (this.n.width() * 131072 - this.n.width() * i1) / 2;
      i1 = (this.n.height() * 131072 - i1 * this.n.height()) / 2;
    }
    for (;;)
    {
      int i3 = this.c.left - i2;
      i2 += this.c.right;
      int i5 = this.c.top - i1;
      int i4 = i1 + this.c.bottom;
      if (paramInt1 < i5) {
        paramInt1 = i5;
      }
      for (;;)
      {
        i1 = paramInt1;
        if (paramInt1 > i4) {
          i1 = i4;
        }
        if (paramInt2 < i3) {}
        for (paramInt1 = i3;; paramInt1 = paramInt2)
        {
          paramInt2 = paramInt1;
          if (paramInt1 > i2) {
            paramInt2 = i2;
          }
          if ((i1 != this.m.getLatitudeE6()) || (paramInt2 != this.m.getLongitudeE6())) {
            bool = true;
          }
          this.m.setLatitudeE6(i1);
          this.m.setLongitudeE6(paramInt2);
          fl localfl = x.a(this, this.m);
          a(localfl.a, localfl.b);
          this.p.a(this.m, paramBoolean);
          AppMethodBeat.o(224946);
          return bool;
          i1 = 20 - this.b.q;
          break;
        }
      }
      label285:
      i1 = 0;
      i2 = 0;
    }
  }
  
  public final float b(float paramFloat)
  {
    AppMethodBeat.i(224884);
    if (this.p.q() == paramFloat)
    {
      AppMethodBeat.o(224884);
      return paramFloat;
    }
    float f1 = Math.max(0.0F, Math.min(40.0F, paramFloat));
    double d1 = Math.toRadians(paramFloat);
    this.i = Math.sin(d1);
    this.j = Math.cos(d1);
    d1 = 1.570796326794897D - d1;
    this.l = Math.cos(d1);
    this.k = Math.sin(d1);
    if (this.p != null)
    {
      sc localsc = this.p;
      localsc.a(new sc.6(localsc, f1));
    }
    AppMethodBeat.o(224884);
    return f1;
  }
  
  public final int c(float paramFloat)
  {
    AppMethodBeat.i(224898);
    int i2 = fv.a;
    float f1 = this.b.p;
    int i3 = this.b.q;
    Object localObject;
    double d1;
    int i1;
    if (this.p != null)
    {
      localObject = this.p;
      d1 = paramFloat;
      if ((0L == ((sc)localObject).e) || (((sc)localObject).j == null))
      {
        paramFloat = this.p.o();
        i1 = this.p.p();
      }
    }
    for (;;)
    {
      this.b.a(i1, paramFloat);
      if (i1 != i3) {
        i1 = fv.c;
      }
      for (;;)
      {
        label102:
        switch (1.a[(i1 - 1)])
        {
        }
        for (;;)
        {
          localObject = x.a(this, this.m);
          this.q.a(((fl)localObject).a, ((fl)localObject).b);
          AppMethodBeat.o(224898);
          return i1;
          ((sc)localObject).j.a(new sc.157((sc)localObject, d1));
          break;
          if (paramFloat == f1) {
            break label242;
          }
          i1 = fv.b;
          break label102;
          d1 = (1 << this.b.q) * 256;
          this.d = ((int)d1);
          this.e = (d1 / 360.0D);
          this.f = (d1 / 6.283185307179586D);
        }
        label242:
        i1 = i2;
      }
      i1 = i3;
      paramFloat = f1;
    }
  }
  
  public final boolean c(int paramInt)
  {
    AppMethodBeat.i(224908);
    if (c(a.a(paramInt)) == fv.c)
    {
      AppMethodBeat.o(224908);
      return true;
    }
    AppMethodBeat.o(224908);
    return false;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(224996);
    v localv = (v)super.clone();
    localv.c = new Rect(this.c);
    localv.b = ((a)this.b.clone());
    localv.m = new GeoPoint(this.m);
    localv.q = new fl(this.q.a, this.q.b);
    AppMethodBeat.o(224996);
    return localv;
  }
  
  public final void d(float paramFloat)
  {
    AppMethodBeat.i(224928);
    a locala1 = this.b;
    a locala2 = new a();
    locala1.n = locala2.q;
    locala1.l = (paramFloat / locala2.a());
    AppMethodBeat.o(224928);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224973);
    if (!(paramObject instanceof v))
    {
      AppMethodBeat.o(224973);
      return false;
    }
    paramObject = (v)paramObject;
    if (!paramObject.m.equals(this.m))
    {
      AppMethodBeat.o(224973);
      return false;
    }
    if (!paramObject.b.equals(this.b))
    {
      AppMethodBeat.o(224973);
      return false;
    }
    if (paramObject.a != this.a)
    {
      AppMethodBeat.o(224973);
      return false;
    }
    AppMethodBeat.o(224973);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(224964);
    int i1 = toString().hashCode();
    AppMethodBeat.o(224964);
    return i1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224985);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.m;
    localStringBuilder1.append("mapParam: ");
    localStringBuilder1.append("center:" + ((GeoPoint)localObject).toString() + " ");
    localStringBuilder1.append("mode:" + this.a + " ");
    localStringBuilder1.append("mapScale:" + this.b.toString() + " ");
    StringBuilder localStringBuilder2 = new StringBuilder("screenRect:");
    if (this.n != null) {}
    for (localObject = this.n.toString();; localObject = "null")
    {
      localStringBuilder1.append((String)localObject + " ");
      localObject = localStringBuilder1.toString();
      AppMethodBeat.o(224985);
      return localObject;
    }
  }
  
  public static final class a
    implements Cloneable
  {
    public static final int a = 20;
    public static final int b = 20;
    public static final int c = 20;
    public static final int d = 19;
    public static final int e = 22;
    public static final int f = 16;
    public static final int g = 3;
    public static final float h = 1.6F;
    public static final float i = 0.8F;
    public static final float j = 4.0F;
    public static final float k = 3.051758E-005F;
    public static final int r = 20;
    public static final int s = 1;
    public static final float t = 1.907349E-006F;
    public float l = 3.051758E-005F;
    public float m = 4.0F;
    public int n = 3;
    public int o = 20;
    public float p;
    public int q;
    
    public static float a(int paramInt)
    {
      return 1.907349E-006F * (1 << paramInt - 1);
    }
    
    private void a(float paramFloat)
    {
      this.p = paramFloat;
    }
    
    private void a(a parama)
    {
      this.l = parama.l;
      this.m = parama.m;
      this.n = parama.n;
      this.o = parama.o;
      this.p = parama.p;
      this.q = parama.q;
    }
    
    private float b()
    {
      return this.p;
    }
    
    private void b(float paramFloat)
    {
      AppMethodBeat.i(221810);
      a locala = new a();
      this.n = locala.q;
      this.l = (paramFloat / locala.a());
      AppMethodBeat.o(221810);
    }
    
    private void b(int paramInt)
    {
      this.o = paramInt;
    }
    
    private int c()
    {
      return this.q;
    }
    
    private void c(int paramInt)
    {
      this.n = paramInt;
    }
    
    private int d()
    {
      return this.n;
    }
    
    private int e()
    {
      return this.o;
    }
    
    private static int f()
    {
      return 20;
    }
    
    private float g()
    {
      return this.l;
    }
    
    public final float a()
    {
      AppMethodBeat.i(221893);
      float f1 = this.p / a(this.q);
      AppMethodBeat.o(221893);
      return f1;
    }
    
    public final void a(int paramInt, float paramFloat)
    {
      this.p = paramFloat;
      this.q = paramInt;
    }
    
    public final Object clone()
    {
      AppMethodBeat.i(221922);
      Object localObject = super.clone();
      AppMethodBeat.o(221922);
      return localObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.p != paramObject.p) || (this.q != paramObject.q));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(221909);
      int i1 = toString().hashCode();
      AppMethodBeat.o(221909);
      return i1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221916);
      String str = "scale:" + this.p + ", scaleLevel:" + this.q;
      AppMethodBeat.o(221916);
      return str;
    }
  }
  
  public static final class b
  {
    public float a = 0.0F;
    public float b = 0.0F;
    
    public b(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
    }
    
    private float a()
    {
      return this.a;
    }
    
    private void a(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
    }
    
    private float b()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.v
 * JD-Core Version:    0.7.0.1
 */