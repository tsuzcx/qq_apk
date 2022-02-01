package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;

public final class rz
  extends iu
{
  public static final long b = 500L;
  public static final int c = 10000;
  public int I;
  public int J;
  public int K;
  public int L;
  public boolean M;
  public boolean N;
  public boolean O;
  public double P;
  public boolean Q;
  public int R;
  public int S;
  public boolean T;
  int U;
  int V;
  int W;
  int X;
  int Y;
  int Z;
  public a a;
  public int aa;
  public int ab;
  public boolean ac;
  float ad;
  float ae;
  float af;
  public float ag;
  public boolean ah;
  float ai;
  float aj;
  float ak;
  public float al;
  private final Runnable am;
  private final Runnable an;
  private boolean ao;
  private Interpolator ap;
  private boolean aq;
  private int ar;
  private int as;
  private boolean at;
  private float au;
  private float av;
  private double aw;
  private double ax;
  private double ay;
  private double az;
  protected long d;
  protected long e;
  public TencentMap.CancelableCallback f;
  public boolean g;
  public boolean h;
  
  public rz()
  {
    super(10000, null);
    AppMethodBeat.i(223589);
    this.am = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223044);
        if (rz.a(rz.this) == null)
        {
          AppMethodBeat.o(223044);
          return;
        }
        rz.a(rz.this).onFinish();
        AppMethodBeat.o(223044);
      }
    };
    this.an = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223031);
        if (rz.a(rz.this) == null)
        {
          AppMethodBeat.o(223031);
          return;
        }
        rz.a(rz.this).onCancel();
        AppMethodBeat.o(223031);
      }
    };
    this.a = null;
    this.d = 500L;
    this.ao = false;
    this.e = 0L;
    this.ap = new LinearInterpolator();
    this.f = null;
    this.g = false;
    this.aq = false;
    this.h = false;
    this.I = 0;
    this.J = 0;
    this.K = 0;
    this.ar = 0;
    this.L = 0;
    this.as = 0;
    this.M = false;
    this.N = false;
    this.O = false;
    this.at = false;
    this.au = 0.0F;
    this.av = 0.0F;
    this.aw = 0.0D;
    this.ax = 0.0D;
    this.P = 0.0D;
    this.ay = 0.0D;
    this.az = 1.0D;
    this.Q = false;
    this.R = 0;
    this.S = 0;
    this.T = false;
    this.U = 0;
    this.V = 0;
    this.W = 0;
    this.X = 0;
    this.Y = 0;
    this.Z = 0;
    this.aa = 0;
    this.ab = 0;
    this.ac = false;
    this.ad = 0.0F;
    this.ae = 0.0F;
    this.af = 0.0F;
    this.ag = 0.0F;
    this.ah = false;
    this.ai = 0.0F;
    this.aj = 0.0F;
    this.ak = 0.0F;
    this.al = 0.0F;
    AppMethodBeat.o(223589);
  }
  
  private void a(double paramDouble)
  {
    this.aw = paramDouble;
    this.O = true;
  }
  
  private void a(a parama)
  {
    this.a = parama;
  }
  
  private void a(TencentMap.CancelableCallback paramCancelableCallback)
  {
    this.f = paramCancelableCallback;
  }
  
  private static long c()
  {
    AppMethodBeat.i(223599);
    long l = SystemClock.uptimeMillis();
    AppMethodBeat.o(223599);
    return l;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.h = false;
    }
    this.I = paramInt1;
    this.J = paramInt2;
    this.h = true;
  }
  
  private boolean d()
  {
    return this.h;
  }
  
  private static float e(float paramFloat)
  {
    return (paramFloat % 360.0F + 360.0F) % 360.0F;
  }
  
  private int e()
  {
    return this.K;
  }
  
  private static float f(float paramFloat)
  {
    paramFloat = (paramFloat % 360.0F + 360.0F) % 360.0F;
    if (paramFloat > 45.0F) {
      return 45.0F;
    }
    return paramFloat;
  }
  
  private int f()
  {
    return this.L;
  }
  
  private boolean g()
  {
    return (this.N) || (this.M) || (this.O);
  }
  
  private float h()
  {
    return (float)this.P;
  }
  
  private boolean i()
  {
    return this.Q;
  }
  
  private int j()
  {
    return this.R;
  }
  
  private int k()
  {
    return this.S;
  }
  
  private boolean l()
  {
    return this.T;
  }
  
  private int m()
  {
    return this.aa;
  }
  
  private int n()
  {
    return this.ab;
  }
  
  private float o()
  {
    return this.ag;
  }
  
  private boolean p()
  {
    return this.ac;
  }
  
  private boolean q()
  {
    return this.ah;
  }
  
  private float r()
  {
    return this.al;
  }
  
  private void s()
  {
    this.g = true;
  }
  
  private boolean t()
  {
    return this.g;
  }
  
  public final void a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    this.au = paramFloat;
    this.M = true;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.R = paramInt1;
    this.S = paramInt2;
    this.Q = true;
  }
  
  public final void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(223779);
    int i;
    int j;
    label207:
    GeoPoint localGeoPoint;
    label240:
    float f2;
    if (!this.ao)
    {
      this.ao = true;
      if (this.h)
      {
        this.ar = 0;
        this.as = 0;
      }
      if ((this.M) || (this.N) || (this.O)) {
        this.ax = (1.0D / Math.pow(2.0D, 20.0F - this.a.f()));
      }
      if (!this.M) {
        break label810;
      }
      if (this.a.h())
      {
        i = 22;
        j = i;
        if (this.a != null) {
          j = Math.min(this.a.b(), i);
        }
        if (this.au >= j) {
          this.au = j;
        }
        if (this.a != null)
        {
          f1 = this.a.f();
          if (Math.abs(this.au - f1) < 0.001D) {
            this.at = true;
          }
        }
        this.aw = (1.0D / Math.pow(2.0D, 20.0F - this.au));
        if ((this.T) && (this.a != null))
        {
          if (this.g != true) {
            break label870;
          }
          localGeoPoint = this.a.g();
          if (localGeoPoint != null)
          {
            this.W = localGeoPoint.getLatitudeE6();
            this.X = localGeoPoint.getLongitudeE6();
            this.Y = (this.U - this.W);
            this.Z = (this.V - this.X);
          }
        }
        if (this.ac)
        {
          if (this.a != null) {
            this.ae = this.a.d();
          }
          this.af = (this.ad - this.ae);
          if (this.af <= 180.0F) {
            break label884;
          }
          this.af -= 360.0F;
        }
        label351:
        if ((this.ah) && (this.a != null))
        {
          this.aj = this.a.e();
          this.ak = (this.ai - this.aj);
        }
        this.e = SystemClock.uptimeMillis();
      }
    }
    else
    {
      if (this.aq) {
        break label916;
      }
      f2 = (float)(SystemClock.uptimeMillis() - this.e) / (float)this.d;
      f1 = f2;
      if (f2 <= 1.0F) {}
    }
    label916:
    for (float f1 = 1.0F;; f1 = 1.0F)
    {
      f2 = this.ap.getInterpolation(f1);
      this.aq = true;
      if (this.h)
      {
        this.K = ((int)(this.I * f2));
        this.L = ((int)(this.J * f2));
        i = this.K;
        j = this.ar;
        int k = this.L;
        int m = this.as;
        this.ar = this.K;
        this.as = this.L;
        this.K = (i - j);
        this.L = (k - m);
        if ((Math.abs(this.I) > 0) || (Math.abs(this.J) > 0)) {
          this.aq = false;
        }
      }
      if ((this.M) || (this.N) || (this.O))
      {
        this.P = (this.ax + (this.aw - this.ax) * f2);
        if (!this.at) {
          this.aq = false;
        }
      }
      if (this.T)
      {
        this.aa = (this.W + (int)(this.Y * f2));
        this.ab = (this.X + (int)(this.Z * f2));
        if ((Math.abs(this.Y) > 1) || (Math.abs(this.Z) > 1)) {
          this.aq = false;
        }
      }
      if (this.ac)
      {
        this.ag = (this.ae + this.af * f2);
        if (Math.abs(this.af) > 1.0F) {
          this.aq = false;
        }
      }
      if (this.ah)
      {
        float f3 = this.aj;
        this.al = (f2 * this.ak + f3);
        if (Math.abs(this.ak) > 1.0F) {
          this.aq = false;
        }
      }
      if (f1 >= 1.0F)
      {
        if ((this.f != null) && (this.a != null)) {
          this.a.a(this.am);
        }
        AppMethodBeat.o(223779);
        return true;
        i = 20;
        break;
        label810:
        if (!this.N) {
          break label207;
        }
        if (Math.abs(this.av) < 0.001D) {
          this.at = true;
        }
        this.aw = (1.0D / Math.pow(2.0D, 20.0F - (this.a.f() + this.av)));
        break label207;
        label870:
        localGeoPoint = this.a.c();
        break label240;
        label884:
        if (this.af >= -180.0F) {
          break label351;
        }
        this.af += 360.0F;
        break label351;
      }
      AppMethodBeat.o(223779);
      return false;
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(223846);
    super.b();
    this.aq = true;
    if ((this.f != null) && (this.a != null)) {
      this.a.a(this.an);
    }
    AppMethodBeat.o(223846);
  }
  
  public final void b(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.av = paramFloat;
    this.N = true;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.U = paramInt1;
    this.V = paramInt2;
    this.T = true;
  }
  
  public final void c(float paramFloat)
  {
    AppMethodBeat.i(223823);
    this.ad = e(paramFloat);
    this.ac = true;
    AppMethodBeat.o(223823);
  }
  
  public final void d(float paramFloat)
  {
    AppMethodBeat.i(223833);
    this.ai = f(paramFloat);
    this.ah = true;
    AppMethodBeat.o(223833);
  }
  
  public static abstract interface a
  {
    public abstract float a();
    
    public abstract void a(Runnable paramRunnable);
    
    public abstract int b();
    
    public abstract GeoPoint c();
    
    public abstract float d();
    
    public abstract float e();
    
    public abstract float f();
    
    public abstract GeoPoint g();
    
    public abstract boolean h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rz
 * JD-Core Version:    0.7.0.1
 */