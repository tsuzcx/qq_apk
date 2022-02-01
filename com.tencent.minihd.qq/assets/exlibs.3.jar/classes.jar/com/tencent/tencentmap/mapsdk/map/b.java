package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class b
{
  private Handler a = null;
  private List<a> b = null;
  private n c = null;
  private final int d = 16;
  private final int e = 10;
  private final int f = 15;
  
  public b()
  {
    if (this.a == null) {
      this.a = new Handler();
    }
    if (this.b == null) {
      this.b = new ArrayList();
    }
  }
  
  private void c()
  {
    if (this.b == null) {
      return;
    }
    this.a.removeCallbacksAndMessages(null);
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.b.remove(0);
      if (locala != null) {
        locala.b();
      }
      i += 1;
    }
  }
  
  private void c(int paramInt)
  {
    long l = ' ';
    double[] arrayOfDouble = new double[16];
    double d1 = Math.pow(2.0D, paramInt);
    paramInt = 1;
    while (paramInt < 16)
    {
      double d2 = q.a(d1, 1.0D, l, paramInt * 10);
      double d3 = d1 / d2;
      d1 = d2;
      arrayOfDouble[(16 - paramInt)] = d3;
      paramInt += 1;
    }
    arrayOfDouble[0] = d1;
    paramInt = 0;
    while (paramInt < 16)
    {
      b localb = new b(this);
      b.a(localb, arrayOfDouble[paramInt]);
      this.b.add(localb);
      paramInt += 1;
    }
  }
  
  private void d(int paramInt)
  {
    long l = ' ';
    double[] arrayOfDouble = new double[16];
    double d1 = Math.pow(0.5D, paramInt);
    paramInt = 1;
    while (paramInt < 16)
    {
      double d2 = q.a(d1, 1.0D, l, paramInt * 10);
      double d3 = d1 / d2;
      d1 = d2;
      arrayOfDouble[(16 - paramInt)] = d3;
      paramInt += 1;
    }
    arrayOfDouble[0] = d1;
    paramInt = 0;
    while (paramInt < 16)
    {
      b localb = new b(this);
      b.a(localb, arrayOfDouble[paramInt]);
      this.b.add(localb);
      paramInt += 1;
    }
  }
  
  public void a()
  {
    if (this.b == null) {}
    int j;
    do
    {
      return;
      j = this.b.size();
    } while (j <= 0);
    int i = 0;
    label24:
    a locala;
    int m;
    int k;
    if (i < j)
    {
      locala = (a)this.b.get(i);
      if (locala != null) {
        break label64;
      }
      m = j;
      k = i;
    }
    for (;;)
    {
      i = k + 1;
      j = m;
      break label24;
      break;
      label64:
      k = i;
      m = j;
      if ((locala instanceof a))
      {
        this.b.remove(i);
        k = i - 1;
        m = j - 1;
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F)) {}
    float f4;
    float f3;
    do
    {
      return;
      f4 = paramFloat1 / 10;
      f3 = paramFloat2 / 10;
    } while ((f4 == 0.0F) && (f3 == 0.0F));
    if (this.b.size() > 0) {
      a();
    }
    this.a.removeCallbacksAndMessages(null);
    float f1 = 0.0F;
    float f2 = 0.0F;
    int i = 1;
    for (;;)
    {
      float f5 = f2;
      float f6 = f1;
      if (i > 10) {
        break;
      }
      float f7 = i * paramFloat1 + i * f4 * i / 2.0F;
      float f8 = i * paramFloat2 + i * f3 * i / 2.0F;
      f1 = f7;
      f2 = f8;
      a locala = new a(this);
      locala.a((int)(f7 - f6), (int)(f8 - f5));
      this.b.add(locala);
      f4 = (float)(f4 * 0.5D);
      f3 = (float)(f3 * 0.5D);
      i += 1;
    }
    a(true);
  }
  
  public void a(GeoPoint paramGeoPoint, Message paramMessage, Runnable paramRunnable)
  {
    if (this.b == null) {}
    while (paramGeoPoint == null) {
      return;
    }
    if (this.b.size() > 0) {
      a();
    }
    this.a.removeCallbacksAndMessages(null);
    Object localObject1 = this.c.a.h();
    Object localObject2 = this.c.c.k.toPixels(paramGeoPoint, null);
    Point localPoint = this.c.c.c();
    int k = ((Point)localObject2).x;
    int m = localPoint.x;
    int i = ((Point)localObject2).y;
    int j = localPoint.y;
    k = Math.abs(k - m);
    i = Math.abs(i - j);
    if (k > i) {}
    for (float f1 = k;; f1 = i)
    {
      j = (int)Math.ceil(f1 / 15.0F);
      i = j;
      if (j > 16) {
        i = 16;
      }
      f1 = paramGeoPoint.getLatitudeE6() - ((GeoPoint)localObject1).getLatitudeE6();
      float f2 = paramGeoPoint.getLongitudeE6() - ((GeoPoint)localObject1).getLongitudeE6();
      k = Math.round(f1 / i);
      m = Math.round(f2 / i);
      j = 1;
      while (j < i)
      {
        int n = ((GeoPoint)localObject1).getLatitudeE6();
        int i1 = ((GeoPoint)localObject1).getLongitudeE6();
        localObject2 = new a(this);
        ((a)localObject2).b(n + k * j, i1 + m * j);
        this.b.add(localObject2);
        j += 1;
      }
    }
    localObject1 = new a(this);
    ((a)localObject1).b(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    if (paramMessage != null) {
      ((a)localObject1).a(paramMessage);
    }
    if (paramRunnable != null) {
      ((a)localObject1).a(paramRunnable);
    }
    this.b.add(localObject1);
    a(true);
  }
  
  public void a(n paramn)
  {
    this.c = paramn;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {}
    a locala;
    do
    {
      return;
      if (this.b.size() <= 0)
      {
        this.c.a.a(false, false, true);
        return;
      }
      locala = (a)this.b.remove(0);
    } while (locala == null);
    if (paramBoolean == true)
    {
      this.a.post(locala);
      return;
    }
    this.a.postDelayed(locala, 10L);
  }
  
  public boolean a(int paramInt)
  {
    if (this.b == null) {}
    int i;
    do
    {
      return false;
      i = this.c.a.g();
    } while (this.c.a.c() == i);
    c(paramInt);
    a(true);
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {}
    int i;
    do
    {
      return false;
      i = this.c.a.g();
    } while (this.c.a.c() == i);
    c localc = new c(this);
    localc.a(paramInt1, paramInt2);
    this.b.add(localc);
    c(1);
    paramInt1 = this.c.a.e() / 2;
    paramInt2 = this.c.a.f() / 2;
    localc = new c(this);
    localc.a(paramInt1, paramInt2);
    this.b.add(localc);
    a(true);
    return true;
  }
  
  public void b()
  {
    c();
    this.b = null;
    this.a = null;
    this.c = null;
  }
  
  public boolean b(int paramInt)
  {
    if (this.b == null) {}
    int i;
    do
    {
      return false;
      i = this.c.a.g();
    } while (this.c.a.d() == i);
    d(paramInt);
    a(true);
    return true;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if (this.b == null) {}
    int i;
    do
    {
      return false;
      i = this.c.a.g();
    } while (this.c.a.d() == i);
    c localc = new c(this);
    localc.a(paramInt1, paramInt2);
    this.b.add(localc);
    d(1);
    paramInt1 = this.c.a.e() / 2;
    paramInt2 = this.c.a.f() / 2;
    localc = new c(this);
    localc.a(paramInt1, paramInt2);
    this.b.add(localc);
    a(true);
    return true;
  }
  
  static class a
    extends a
  {
    protected b a = null;
    private GeoPoint b = null;
    private Message c = null;
    private Runnable d = null;
    private int e = 0;
    private int f = 0;
    
    public a(b paramb)
    {
      this.a = paramb;
    }
    
    void a()
    {
      if (b.a(this.a) == null) {
        return;
      }
      if (this.b != null) {
        b.a(this.a).a.c(this.b);
      }
      for (;;)
      {
        this.a.a(false);
        if (this.d != null)
        {
          this.d.run();
          this.d = null;
        }
        if (this.c != null)
        {
          this.c.getTarget().sendMessage(this.c);
          this.c = null;
        }
        b();
        return;
        b.a(this.a).d.scrollBy(this.e, this.f);
      }
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      this.e = paramInt1;
      this.f = paramInt2;
    }
    
    public void a(Message paramMessage)
    {
      this.c = paramMessage;
    }
    
    public void a(Runnable paramRunnable)
    {
      this.d = paramRunnable;
    }
    
    void b()
    {
      this.b = null;
      this.a = null;
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      if (this.b == null)
      {
        this.b = new GeoPoint(paramInt1, paramInt2);
        return;
      }
      this.b.setLatitudeE6(paramInt1);
      this.b.setLongitudeE6(paramInt2);
    }
    
    public void run()
    {
      a();
    }
  }
  
  static class b
    extends a
  {
    protected b a = null;
    private double b = 0.0D;
    
    public b(b paramb)
    {
      this.a = paramb;
    }
    
    void a()
    {
      if (b.a(this.a) == null) {
        return;
      }
      b.a(this.a).a.a(this.b);
      this.a.a(false);
      b();
    }
    
    void b()
    {
      this.a = null;
    }
    
    public void run()
    {
      a();
    }
  }
  
  static class c
    extends b.b
  {
    private int b = 0;
    private int c = 0;
    
    public c(b paramb)
    {
      super();
    }
    
    void a()
    {
      Point localPoint = new Point(this.b, this.c);
      GeoPoint localGeoPoint = b.a(this.a).c.k.fromPixels(this.b, this.c);
      b.a(this.a).c.a(localPoint);
      b.a(this.a).a.b(localGeoPoint);
      this.a.a(false);
      b();
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.b
 * JD-Core Version:    0.7.0.1
 */