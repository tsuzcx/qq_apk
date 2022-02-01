package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oj
  extends ok
  implements ok.a
{
  public static final int a = 1;
  public static final int b = 16;
  public static final int c = 256;
  public static final int d = 4096;
  public static final int e = 65536;
  public boolean A;
  public boolean B;
  public int C;
  public int D;
  private String S;
  private RectF T;
  private int U;
  private int V;
  private int W;
  private int X;
  private boolean Y;
  public int f;
  public String g;
  public Bitmap[] h;
  public double i;
  public double j;
  public int k;
  public int l;
  public float m;
  public float n;
  public boolean o;
  public float p;
  public float q;
  public float r;
  public float s;
  public float t;
  public float u;
  public float v;
  public boolean w;
  public boolean x;
  public boolean y;
  public boolean z;
  
  public oj(py parampy)
  {
    this(parampy.a(), parampy.i, parampy.k, parampy.l, parampy.q, parampy.r, parampy.j);
    AppMethodBeat.i(222097);
    AppMethodBeat.o(222097);
  }
  
  private oj(String paramString, GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(222122);
    this.W = 0;
    this.m = 0.5F;
    this.n = 0.5F;
    this.o = false;
    this.p = 0.0F;
    this.q = 0.0F;
    this.r = 0.0F;
    this.s = 0.0F;
    this.t = 1.0F;
    this.X = 0;
    this.u = 1.0F;
    this.v = 1.0F;
    this.w = false;
    this.x = true;
    this.y = false;
    this.z = true;
    this.A = false;
    this.B = false;
    this.Y = true;
    a(this);
    this.m = paramFloat1;
    this.n = paramFloat2;
    this.k = paramInt1;
    this.l = paramInt2;
    if (paramGeoPoint != null)
    {
      this.i = (paramGeoPoint.getLongitudeE6() / 1000000.0D);
      this.j = (paramGeoPoint.getLatitudeE6() / 1000000.0D);
    }
    a(paramString, paramVarArgs);
    AppMethodBeat.o(222122);
  }
  
  private oj(String paramString, GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, Bitmap... paramVarArgs)
  {
    this(paramString, paramGeoPoint, paramFloat1, paramFloat2, 0, 0, paramVarArgs);
  }
  
  private oj(String paramString, GeoPoint paramGeoPoint, Bitmap... paramVarArgs)
  {
    this(paramString, paramGeoPoint, 0.5F, 0.5F, 0, 0, paramVarArgs);
  }
  
  private boolean A()
  {
    return this.Y;
  }
  
  private int B()
  {
    return this.C;
  }
  
  private int C()
  {
    return this.D;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222130);
    if ((this.U == paramInt1) && (this.V == paramInt2))
    {
      AppMethodBeat.o(222130);
      return;
    }
    this.U = paramInt1;
    this.V = paramInt2;
    float f1 = this.k / paramInt1;
    float f2 = this.l / paramInt2;
    this.T = new RectF(f1, -f2, 0.0F, -0.0F);
    this.m -= f1;
    this.n -= f2;
    this.p = (-this.U * this.m);
    this.q = (this.U + this.p);
    this.r = (this.V * this.n);
    this.s = (this.r - this.V);
    AppMethodBeat.o(222130);
  }
  
  private void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(222148);
    if (paramGeoPoint != null) {
      if (!this.w) {
        break label51;
      }
    }
    label51:
    for (double d1 = 1.0D;; d1 = 1000000.0D)
    {
      this.i = (paramGeoPoint.getLongitudeE6() / d1);
      this.j = (paramGeoPoint.getLatitudeE6() / d1);
      this.o = true;
      AppMethodBeat.o(222148);
      return;
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.u = paramFloat1;
    this.v = paramFloat2;
    this.o = true;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    this.o = true;
  }
  
  private Bitmap c(int paramInt)
  {
    if (this.h == null) {
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.h.length)) {
      return this.h[0];
    }
    return this.h[paramInt];
  }
  
  private void d(int paramInt)
  {
    this.C = paramInt;
  }
  
  private void d(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  private double e()
  {
    return this.i;
  }
  
  private void e(int paramInt)
  {
    this.D = paramInt;
  }
  
  private void e(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  private double f()
  {
    return this.j;
  }
  
  private void f(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  private void g(boolean paramBoolean)
  {
    this.x = paramBoolean;
    this.o = true;
  }
  
  private boolean g()
  {
    return this.o;
  }
  
  private void h(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  private boolean h()
  {
    return this.y;
  }
  
  private String i()
  {
    return this.S;
  }
  
  private int j()
  {
    return this.f;
  }
  
  private float k()
  {
    return this.m;
  }
  
  private float l()
  {
    return this.n;
  }
  
  private float m()
  {
    return this.t;
  }
  
  private float n()
  {
    return this.u;
  }
  
  private float o()
  {
    return this.v;
  }
  
  private boolean p()
  {
    return this.w;
  }
  
  private boolean q()
  {
    return this.z;
  }
  
  private boolean r()
  {
    return this.x;
  }
  
  private boolean s()
  {
    return this.A;
  }
  
  private boolean t()
  {
    return this.B;
  }
  
  private RectF u()
  {
    AppMethodBeat.i(222316);
    RectF localRectF = new RectF(this.T);
    AppMethodBeat.o(222316);
    return localRectF;
  }
  
  private String v()
  {
    return this.g;
  }
  
  private float w()
  {
    return this.p;
  }
  
  private float x()
  {
    return this.q;
  }
  
  private float y()
  {
    return this.r;
  }
  
  private float z()
  {
    return this.s;
  }
  
  public final float a()
  {
    if (this.Y) {
      return 360 - this.X;
    }
    return this.X;
  }
  
  public final void a(float paramFloat)
  {
    this.t = paramFloat;
    this.o = true;
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222435);
    this.m = paramFloat1;
    this.n = paramFloat2;
    a(this.U, this.V);
    this.o = true;
    AppMethodBeat.o(222435);
  }
  
  public final void a(int paramInt)
  {
    this.X = paramInt;
    this.o = true;
  }
  
  public final void a(py parampy)
  {
    AppMethodBeat.i(222529);
    a(parampy.m);
    a(parampy.k, parampy.l);
    a(parampy.o);
    this.w = parampy.u;
    this.z = parampy.v;
    b(parampy.x);
    c(parampy.y);
    this.Y = parampy.z;
    this.x = parampy.n;
    this.o = true;
    this.C = parampy.t;
    this.D = parampy.s;
    AppMethodBeat.o(222529);
  }
  
  /* Error */
  public final void a(String paramString, Bitmap... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 226
    //   4: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +11 -> 19
    //   11: ldc 226
    //   13: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 99	com/tencent/mapsdk/internal/oj:o	Z
    //   24: aload_0
    //   25: iconst_1
    //   26: invokevirtual 228	com/tencent/mapsdk/internal/oj:a	(Z)V
    //   29: aload_0
    //   30: aload_1
    //   31: putfield 194	com/tencent/mapsdk/internal/oj:g	Ljava/lang/String;
    //   34: aload_0
    //   35: aload_2
    //   36: putfield 180	com/tencent/mapsdk/internal/oj:h	[Landroid/graphics/Bitmap;
    //   39: aload_0
    //   40: getfield 92	com/tencent/mapsdk/internal/oj:W	I
    //   43: iflt +12 -> 55
    //   46: aload_0
    //   47: getfield 92	com/tencent/mapsdk/internal/oj:W	I
    //   50: aload_2
    //   51: arraylength
    //   52: if_icmplt +8 -> 60
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 92	com/tencent/mapsdk/internal/oj:W	I
    //   60: aload_2
    //   61: aload_0
    //   62: getfield 92	com/tencent/mapsdk/internal/oj:W	I
    //   65: aaload
    //   66: ifnull +25 -> 91
    //   69: aload_0
    //   70: aload_2
    //   71: aload_0
    //   72: getfield 92	com/tencent/mapsdk/internal/oj:W	I
    //   75: aaload
    //   76: invokevirtual 233	android/graphics/Bitmap:getWidth	()I
    //   79: aload_2
    //   80: aload_0
    //   81: getfield 92	com/tencent/mapsdk/internal/oj:W	I
    //   84: aaload
    //   85: invokevirtual 236	android/graphics/Bitmap:getHeight	()I
    //   88: invokespecial 198	com/tencent/mapsdk/internal/oj:a	(II)V
    //   91: ldc 226
    //   93: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -80 -> 16
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	oj
    //   0	104	1	paramString	String
    //   0	104	2	paramVarArgs	Bitmap[]
    // Exception table:
    //   from	to	target	type
    //   2	7	99	finally
    //   11	16	99	finally
    //   19	55	99	finally
    //   55	60	99	finally
    //   60	91	99	finally
    //   91	96	99	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
    if (!paramBoolean) {
      this.S = this.g;
    }
  }
  
  public final void b(int paramInt)
  {
    try
    {
      AppMethodBeat.i(222481);
      this.W = paramInt;
      this.o = true;
      a(true);
      Bitmap localBitmap = c(paramInt);
      if (localBitmap != null)
      {
        int i1 = localBitmap.getWidth();
        int i2 = localBitmap.getHeight();
        if ((this.U != i1) || (this.V != i2)) {
          a(i1, i2);
        }
      }
      super.b(paramInt);
      AppMethodBeat.o(222481);
      return;
    }
    finally {}
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(222463);
    this.A = paramBoolean;
    kh.b("TDZ", "setAvoidPoi = ".concat(String.valueOf(paramBoolean)));
    this.o = true;
    AppMethodBeat.o(222463);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final String c()
  {
    return this.g;
  }
  
  public final void c(boolean paramBoolean)
  {
    AppMethodBeat.i(222471);
    this.B = paramBoolean;
    kh.b("TDZ", "setAvoidMarker = ".concat(String.valueOf(paramBoolean)));
    this.o = true;
    AppMethodBeat.o(222471);
  }
  
  public final Bitmap d()
  {
    try
    {
      AppMethodBeat.i(222505);
      Bitmap localBitmap = c(this.H);
      AppMethodBeat.o(222505);
      return localBitmap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof oj)) {}
    while (this.f != ((oj)paramObject).f) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(222518);
    int i1 = String.valueOf(this.f).hashCode();
    AppMethodBeat.o(222518);
    return i1 + 527;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oj
 * JD-Core Version:    0.7.0.1
 */