package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import android.graphics.PointF;
import java.util.ArrayList;

class p
{
  public PointF a;
  n.b b = null;
  public int c = 1;
  public int d = 18;
  public int e = 10;
  public final int f = 18;
  float[] g = null;
  double[] h = null;
  double[] i = null;
  double[] j = null;
  a k = null;
  private Point l = null;
  private GeoPoint m = new GeoPoint(39908716, 116397529);
  
  public p(n.b paramb)
  {
    this.b = paramb;
    if (this.k == null) {
      this.k = new a();
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int n;
    if (paramInt2 < 0) {
      n = paramInt2 + paramInt1;
    }
    do
    {
      return n;
      n = paramInt2;
    } while (paramInt2 < paramInt1);
    return paramInt2 - paramInt1;
  }
  
  private void h()
  {
    this.a = a(this.m, this.e);
  }
  
  PointF a(GeoPoint paramGeoPoint, int paramInt)
  {
    double d5 = Math.min(Math.max(Math.sin(paramGeoPoint.getLatitudeE6() / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
    double d1 = this.h[paramInt];
    double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    double d3 = this.i[paramInt];
    double d4 = this.h[paramInt];
    d5 = Math.log((1.0D + d5) / (1.0D - d5));
    double d6 = this.j[paramInt];
    return new PointF((float)(d1 + d2 * d3), (float)(d4 + d5 * d6 * 0.5D));
  }
  
  public GeoPoint a(PointF paramPointF, int paramInt)
  {
    return b(new PointF(this.a.x + (paramPointF.x - this.l.x), this.a.y - (paramPointF.y - this.l.y)), paramInt);
  }
  
  public ArrayList<v.b> a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    int i2 = (int)Math.floor(this.a.x / 256.0F);
    int i3 = (int)Math.floor(this.a.y / 256.0F);
    float f1 = this.l.x - this.a.x % 256.0F;
    float f2 = this.l.y - (256.0F - this.a.y % 256.0F);
    double d3 = paramInt2 * (1.0D / paramFloat - 1.0D) / 2.0D;
    double d2 = f1 + d3;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = 0.0D;
    }
    d3 = paramInt2 * 1.0F - f1 - 256.0F + d3;
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = 0.0D;
    }
    double d5 = paramInt3 * (1.0D / paramFloat - 1.0D) / 2.0D;
    double d4 = f2 + d5;
    d3 = d4;
    if (d4 < 0.0D) {
      d3 = 0.0D;
    }
    d5 = paramInt3 * 1.0F - f2 - 256.0F + d5;
    d4 = d5;
    if (d5 < 0.0D) {
      d4 = 0.0D;
    }
    int i4 = (int)Math.ceil(d1 / 256.0D);
    int i5 = (int)Math.ceil(d2 / 256.0D);
    int i6 = (int)Math.ceil(d3 / 256.0D);
    int i7 = (int)Math.ceil(d4 / 256.0D);
    ArrayList localArrayList = new ArrayList();
    int i8 = (int)Math.pow(2.0D, paramInt1 + 1);
    int n = 1;
    paramInt3 = 1;
    while (paramInt3 != 0)
    {
      paramInt2 = 0;
      paramInt3 = 0;
      int i9 = i3 + n - 1;
      int i1;
      int i10;
      label380:
      v.b localb;
      if (i9 <= i3 + i6)
      {
        i1 = 0;
        paramInt2 = paramInt3;
        if (i1 < n * 2 - 1)
        {
          i10 = i2 - (n - 1) + i1;
          paramInt2 = paramInt3;
          if (i10 >= i2 - i4)
          {
            if (i10 <= i2 + i5) {
              break label380;
            }
            paramInt2 = paramInt3;
          }
          for (;;)
          {
            i1 += 1;
            paramInt3 = paramInt2;
            break;
            paramInt2 = paramInt3;
            if (i9 >= i3 - i7)
            {
              paramInt2 = paramInt3;
              if (i9 <= i3 + i6)
              {
                localb = new v.b(a(i8, i10), a(i8, i9), paramInt1);
                localb.e = (f1 - (n - 1 - i1) * 256);
                localb.f = (f2 - (n - 1) * 256);
                localArrayList.add(localb);
                paramInt2 = paramInt3;
                if (paramInt3 == 0) {
                  paramInt2 = 1;
                }
              }
            }
          }
        }
      }
      i9 = i2 + (n - 1);
      paramInt3 = paramInt2;
      if (i9 <= i2 + i5)
      {
        i1 = 1;
        paramInt3 = paramInt2;
        if (i1 < n * 2 - 1)
        {
          i10 = i3 + n - 1 - i1;
          paramInt3 = paramInt2;
          if (i9 >= i2 - i4)
          {
            if (i9 <= i2 + i5) {
              break label570;
            }
            paramInt3 = paramInt2;
          }
          for (;;)
          {
            i1 += 1;
            paramInt2 = paramInt3;
            break;
            label570:
            paramInt3 = paramInt2;
            if (i10 >= i3 - i7)
            {
              paramInt3 = paramInt2;
              if (i10 <= i3 + i6)
              {
                localb = new v.b(a(i8, i9), a(i8, i10), paramInt1);
                localb.e = ((n - 1) * 256 + f1);
                localb.f = (f2 - (n - 1 - i1) * 256);
                localArrayList.add(localb);
                paramInt3 = paramInt2;
                if (paramInt2 == 0) {
                  paramInt3 = 1;
                }
              }
            }
          }
        }
      }
      i9 = i3 - (n - 1);
      paramInt2 = paramInt3;
      if (i9 >= i3 - i7)
      {
        i1 = 0;
        paramInt2 = paramInt3;
        if (i1 < n * 2 - 2)
        {
          i10 = i2 - (n - 1) + i1;
          paramInt2 = paramInt3;
          if (i10 >= i2 - i4)
          {
            if (i10 <= i2 + i5) {
              break label760;
            }
            paramInt2 = paramInt3;
          }
          for (;;)
          {
            i1 += 1;
            paramInt3 = paramInt2;
            break;
            label760:
            paramInt2 = paramInt3;
            if (i9 >= i3 - i7)
            {
              paramInt2 = paramInt3;
              if (i9 <= i3 + i6)
              {
                localb = new v.b(a(i8, i10), a(i8, i9), paramInt1);
                localb.e = (f1 - (n - 1 - i1) * 256);
                localb.f = ((n - 1) * 256 + f2);
                localArrayList.add(localb);
                paramInt2 = paramInt3;
                if (paramInt3 == 0) {
                  paramInt2 = 1;
                }
              }
            }
          }
        }
      }
      i9 = i2 - (n - 1);
      paramInt3 = paramInt2;
      if (i9 >= i2 - i4)
      {
        i1 = 1;
        paramInt3 = paramInt2;
        if (i1 < n * 2 - 2)
        {
          i10 = i3 + n - 1 - i1;
          paramInt3 = paramInt2;
          if (i9 >= i2 - i4)
          {
            if (i9 <= i2 + i5) {
              break label950;
            }
            paramInt3 = paramInt2;
          }
          for (;;)
          {
            i1 += 1;
            paramInt2 = paramInt3;
            break;
            label950:
            paramInt3 = paramInt2;
            if (i10 >= i3 - i7)
            {
              paramInt3 = paramInt2;
              if (i10 <= i3 + i6)
              {
                localb = new v.b(a(i8, i9), a(i8, i10), paramInt1);
                localb.e = (f1 - (n - 1) * 256);
                localb.f = (f2 - (n - 1 - i1) * 256);
                localArrayList.add(localb);
                paramInt3 = paramInt2;
                if (paramInt2 == 0) {
                  paramInt3 = 1;
                }
              }
            }
          }
        }
      }
      n += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.l = new Point(this.b.e() / 2, this.b.f() / 2);
    this.g = new float[19];
    this.h = new double[19];
    this.i = new double[19];
    this.j = new double[19];
    int n = 0;
    while (n <= 18)
    {
      double d1 = Math.pow(2.0D, n + 1) * 256.0D;
      this.g[n] = ((float)(d1 / 40075700.0D));
      this.h[n] = (d1 / 2.0D);
      this.i[n] = (d1 / 360.0D);
      this.j[n] = (d1 / 6.283185307179586D);
      n += 1;
    }
    h();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = this.a;
    localPointF.x -= paramFloat1;
    localPointF = this.a;
    localPointF.y += paramFloat2;
    e();
  }
  
  public void a(Point paramPoint)
  {
    if (this.l == null) {
      this.l = new Point();
    }
    this.l.x = paramPoint.x;
    this.l.y = paramPoint.y;
  }
  
  public void a(v.b paramb, PointF paramPointF, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    if (paramb == null) {}
    while (paramPointF == null) {
      return;
    }
    int i1 = paramInt1;
    if (paramInt1 == 0) {
      i1 = paramInt3;
    }
    int n = paramInt2;
    if (paramInt2 == 0) {
      n = paramInt3;
    }
    paramInt2 = paramb.a - i1;
    paramInt1 = paramInt2;
    if (paramInt2 < 0)
    {
      i1 = paramInt2 + paramInt3;
      paramInt1 = paramInt2;
      if (i1 < Math.abs(paramInt2)) {
        paramInt1 = i1;
      }
    }
    n = paramb.b - n;
    paramInt2 = n;
    if (n < 0)
    {
      paramInt3 = n + paramInt3;
      paramInt2 = n;
      if (paramInt3 < Math.abs(n)) {
        paramInt2 = paramInt3;
      }
    }
    paramb.e = (paramInt1 * 256 + paramFloat1);
    paramb.f = (paramFloat2 - paramInt2 * 256);
  }
  
  public PointF b(GeoPoint paramGeoPoint, int paramInt)
  {
    paramGeoPoint = a(paramGeoPoint, paramInt);
    return new PointF(this.l.x + (paramGeoPoint.x - this.a.x), this.l.y - (paramGeoPoint.y - this.a.y));
  }
  
  GeoPoint b(PointF paramPointF, int paramInt)
  {
    double d1 = (paramPointF.x - this.h[paramInt]) / this.i[paramInt];
    return new GeoPoint((int)(1000000.0D * (Math.asin(1.0D - 2.0D / (1.0D + Math.pow(2.718281828459045D, (paramPointF.y - this.h[paramInt]) / 0.5D / this.j[paramInt]))) * 180.0D / 3.141592653589793D)), (int)(1000000.0D * d1));
  }
  
  public ArrayList<v.b> b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Object localObject = a(this.m, paramInt1);
    int n = (int)Math.floor(((PointF)localObject).x / 256.0F);
    int i1 = (int)Math.floor(((PointF)localObject).y / 256.0F);
    paramFloat = this.l.x - ((PointF)localObject).x % 256.0F;
    float f1 = this.l.y - (256.0F - ((PointF)localObject).y % 256.0F);
    int i6 = (int)Math.ceil(paramFloat / 256.0F);
    int i2 = (int)Math.ceil((paramInt2 * 1.0F - paramFloat - 256.0F) / 256.0F);
    int i3 = (int)Math.ceil(f1 / 256.0F);
    int i4 = (int)Math.ceil((paramInt3 * 1.0F - f1 - 256.0F) / 256.0F);
    localObject = new ArrayList();
    int i5 = (int)Math.pow(2.0D, paramInt1 + 1);
    paramInt2 = -i6;
    while (paramInt2 <= i2)
    {
      paramInt3 = -i4;
      while (paramInt3 <= i3)
      {
        v.c localc = new v.c(a(i5, n + paramInt2), a(i5, i1 + paramInt3), paramInt1);
        localc.e = (paramInt2 * 256 + paramFloat);
        localc.f = (f1 - paramInt3 * 256);
        ((ArrayList)localObject).add(localc);
        paramInt3 += 1;
      }
      paramInt2 += 1;
    }
    return localObject;
  }
  
  public void b()
  {
    h();
  }
  
  public Point c()
  {
    return new Point(this.l.x, this.l.y);
  }
  
  GeoPoint d()
  {
    return this.m;
  }
  
  public void e()
  {
    int n = (int)this.h[this.e] * 2;
    if (this.a.x < 0.0F)
    {
      localPointF = this.a;
      localPointF.x += n;
    }
    do
    {
      while (this.a.y < 0.0F)
      {
        localPointF = this.a;
        localPointF.y += n;
        return;
        if (this.a.x > n)
        {
          localPointF = this.a;
          localPointF.x -= n;
        }
      }
    } while (this.a.y <= n);
    PointF localPointF = this.a;
    localPointF.y -= n;
  }
  
  public void f()
  {
    this.m = b(this.a, this.e);
  }
  
  public v.c g()
  {
    int n = (int)Math.floor(this.a.x / 256.0F);
    int i1 = (int)Math.floor(this.a.y / 256.0F);
    float f1 = this.l.x;
    float f2 = this.a.x;
    float f3 = this.l.y;
    float f4 = this.a.y;
    v.c localc = new v.c(n, i1, this.b.g());
    localc.e = (f1 - f2 % 256.0F);
    localc.f = (f3 - (256.0F - f4 % 256.0F));
    return localc;
  }
  
  class a
    implements Projection
  {
    a() {}
    
    private double a(double paramDouble)
    {
      return paramDouble / 180.0D * 3.141592653589793D;
    }
    
    private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      double d = a(paramDouble3 - paramDouble1);
      paramDouble2 = a(paramDouble4 - paramDouble2);
      paramDouble1 = a(paramDouble1);
      paramDouble3 = a(paramDouble3);
      paramDouble1 = Math.sin(d / 2.0D) * Math.sin(d / 2.0D) + Math.sin(paramDouble2 / 2.0D) * Math.sin(paramDouble2 / 2.0D) * Math.cos(paramDouble1) * Math.cos(paramDouble3);
      return 6381480.0D * (2.0D * Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)));
    }
    
    private int a(boolean paramBoolean)
    {
      int i = p.this.b.e();
      GeoPoint localGeoPoint1 = fromPixels(0, p.this.b.f());
      GeoPoint localGeoPoint2 = fromPixels(i, 0);
      if (paramBoolean) {
        return Math.abs(localGeoPoint1.getLongitudeE6() - localGeoPoint2.getLongitudeE6());
      }
      return Math.abs(localGeoPoint1.getLatitudeE6() - localGeoPoint2.getLatitudeE6());
    }
    
    public int a()
    {
      return a(false);
    }
    
    Point a(GeoPoint paramGeoPoint, Point paramPoint, int paramInt, float paramFloat)
    {
      paramGeoPoint = p.this.b(paramGeoPoint, paramInt);
      Point localPoint = p.this.c();
      float f1 = paramGeoPoint.x;
      float f2 = localPoint.x;
      float f3 = localPoint.x;
      float f4 = paramGeoPoint.y;
      float f5 = localPoint.y;
      float f6 = localPoint.y;
      paramGeoPoint = new Point(Math.round((f1 - f2) * paramFloat + f3), Math.round((f4 - f5) * paramFloat + f6));
      if (paramPoint != null)
      {
        paramPoint.x = paramGeoPoint.x;
        paramPoint.y = paramGeoPoint.y;
      }
      return paramGeoPoint;
    }
    
    public int b()
    {
      return a(true);
    }
    
    public double distanceBetween(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
    {
      return a(paramGeoPoint1.getLatitudeE6() / 1000000.0D, paramGeoPoint1.getLongitudeE6() / 1000000.0D, paramGeoPoint2.getLatitudeE6() / 1000000.0D, paramGeoPoint2.getLongitudeE6() / 1000000.0D);
    }
    
    public GeoPoint fromPixels(int paramInt1, int paramInt2)
    {
      Object localObject = p.this.c();
      float f = p.this.b.b();
      localObject = new PointF((paramInt1 - ((Point)localObject).x) / f + ((Point)localObject).x, (paramInt2 - ((Point)localObject).y) / f + ((Point)localObject).y);
      return p.this.a((PointF)localObject, p.this.e);
    }
    
    public float metersToEquatorPixels(float paramFloat)
    {
      return paramFloat * p.this.b.b() * p.this.g[p.this.e];
    }
    
    public float metersToPixels(double paramDouble1, double paramDouble2)
    {
      paramDouble1 = paramDouble2 / (float)Math.cos(3.141592653589793D * paramDouble1 / 180.0D);
      return (float)(p.this.b.b() * paramDouble1 * p.this.g[p.this.e]);
    }
    
    public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
    {
      return a(paramGeoPoint, paramPoint, p.this.b.g(), p.this.b.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.p
 * JD-Core Version:    0.7.0.1
 */