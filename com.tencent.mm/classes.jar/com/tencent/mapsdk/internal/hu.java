package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.models.GeoPoint;

public abstract class hu
{
  protected long a = 1500L;
  public boolean b = false;
  protected long c = 0L;
  public boolean d = false;
  public boolean e = false;
  public Interpolator f = new LinearInterpolator();
  protected a g = null;
  protected b h = null;
  
  private void a(Interpolator paramInterpolator)
  {
    this.f = paramInterpolator;
  }
  
  private Interpolator c()
  {
    return this.f;
  }
  
  private static long d()
  {
    return SystemClock.uptimeMillis();
  }
  
  private void e()
  {
    this.b = false;
  }
  
  private boolean f()
  {
    return this.b;
  }
  
  private boolean g()
  {
    return this.d;
  }
  
  private boolean h()
  {
    return this.e;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  protected abstract void a(float paramFloat, Interpolator paramInterpolator);
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void a(a parama)
  {
    this.g = parama;
  }
  
  public void a(b paramb)
  {
    this.h = paramb;
  }
  
  public boolean a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    boolean bool = true;
    if (this.a <= 0L) {
      bool = false;
    }
    do
    {
      return bool;
      this.d = true;
      this.c = SystemClock.uptimeMillis();
      this.b = true;
    } while (this.g == null);
    this.g.a();
    return true;
  }
  
  public final void b()
  {
    if (!this.b)
    {
      if ((this.d) && (!this.e) && (this.g != null)) {
        this.g.b();
      }
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.c) / (float)this.a;
    if (f1 > 1.0F)
    {
      this.b = false;
      a(1.0F, this.f);
      if (this.g != null) {
        this.g.b();
      }
      this.e = true;
      return;
    }
    a(f1, this.f);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat);
    
    public abstract void a(float paramFloat1, float paramFloat2);
    
    public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void b(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hu
 * JD-Core Version:    0.7.0.1
 */