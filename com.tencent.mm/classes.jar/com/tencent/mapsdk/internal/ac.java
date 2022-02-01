package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ac
  implements fh, ib, ix, ns, od
{
  private static final int O = 20;
  private static final int P = 0;
  private static final int Q = 1;
  private static final int R = 2;
  private static final int S = 3;
  private static final int T = 4;
  public static final int a = 12;
  public static final int b = 11;
  public static final int c = 10;
  public static final int d = 18;
  public static final int e = 13;
  public static final int f = 15;
  public static final int g = 15;
  public static final int h = 17;
  public static final int i = 18;
  public static final int j = 16;
  public static final int k = 18;
  public static final int l = 12;
  public static int m = 116307503;
  public static int n = 39984186;
  public v A;
  public ep B;
  public Rect C;
  public a D;
  public float E;
  public float F;
  public boolean G;
  public int H;
  public int I;
  public int J;
  public int K;
  public boolean L;
  public boolean M;
  private List<oi> U;
  private List<fd> V;
  private List<fh> W;
  private final List<fi> X;
  private List<ff> Y;
  private Stack<v> Z;
  private Rect aa;
  private Runnable ab;
  public y o;
  public pk p;
  public List<fa> q;
  public List<ev> r;
  public List<ex> s;
  public final byte[] t;
  public List<fc> u;
  public List<ba> v;
  public final byte[] w;
  public List<fb> x;
  public az y;
  public bd z;
  
  public ac(bd parambd)
  {
    AppMethodBeat.i(223706);
    this.t = new byte[0];
    this.w = new byte[0];
    this.Z = new Stack();
    this.D = null;
    this.E = 0.5F;
    this.F = 0.5F;
    this.G = false;
    this.H = 0;
    this.I = 0;
    this.J = 0;
    this.K = 0;
    this.L = false;
    this.z = parambd;
    this.y = ((az)parambd.b());
    this.A = parambd.e();
    this.B = parambd.d();
    this.C = parambd.g();
    this.o = new y(this);
    this.o.i = this;
    a(this.o);
    this.V = new CopyOnWriteArrayList();
    this.u = new CopyOnWriteArrayList();
    this.q = new CopyOnWriteArrayList();
    this.r = new CopyOnWriteArrayList();
    this.U = new CopyOnWriteArrayList();
    this.X = new CopyOnWriteArrayList();
    this.x = new CopyOnWriteArrayList();
    this.Y = new CopyOnWriteArrayList();
    this.W = new CopyOnWriteArrayList();
    a(eh.a);
    AppMethodBeat.o(223706);
  }
  
  private void A()
  {
    AppMethodBeat.i(223754);
    if (this.o != null) {
      this.o.a();
    }
    AppMethodBeat.o(223754);
  }
  
  private void B()
  {
    AppMethodBeat.i(223764);
    if (this.o != null)
    {
      y localy = this.o;
      if (localy.d != null) {
        localy.d.destroy();
      }
    }
    AppMethodBeat.o(223764);
  }
  
  private y C()
  {
    return this.o;
  }
  
  private void D()
  {
    AppMethodBeat.i(223819);
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      if ((fb)localIterator.next() != null) {}
    }
    AppMethodBeat.o(223819);
  }
  
  private void E()
  {
    AppMethodBeat.i(223828);
    kh.a("skew notifySkew");
    Iterator localIterator = this.Y.iterator();
    while (localIterator.hasNext()) {
      if ((ff)localIterator.next() != null) {}
    }
    AppMethodBeat.o(223828);
  }
  
  private void F()
  {
    AppMethodBeat.i(223853);
    GeoPoint localGeoPoint = new GeoPoint(n, m);
    v localv = this.A;
    Rect localRect = this.z.g();
    int i1 = localGeoPoint.getLatitudeE6();
    int i2 = localGeoPoint.getLongitudeE6();
    localv.n = localRect;
    localv.c = GeometryConstants.BOUNDARY_WORLD;
    localv.c(13);
    localv.a(0);
    localv.a(i1, i2, false);
    c();
    this.z.f().b(this.G);
    AppMethodBeat.o(223853);
  }
  
  private float G()
  {
    return this.A.b.p;
  }
  
  private int H()
  {
    return this.A.b.q;
  }
  
  private GeoPoint I()
  {
    return this.A.m;
  }
  
  private float J()
  {
    AppMethodBeat.i(223969);
    float f1 = this.A.b.a();
    AppMethodBeat.o(223969);
    return f1;
  }
  
  private void K()
  {
    AppMethodBeat.i(224021);
    this.A.a(0.0F);
    this.A.b(0.0F);
    D();
    E();
    c();
    AppMethodBeat.o(224021);
  }
  
  private void L()
  {
    AppMethodBeat.i(224143);
    o();
    a(h(), 40.0D, true);
    AppMethodBeat.o(224143);
  }
  
  private void M()
  {
    AppMethodBeat.i(224153);
    o();
    a(h(), 40.0D, true);
    AppMethodBeat.o(224153);
  }
  
  private boolean N()
  {
    if (this.p != null)
    {
      pk localpk = this.p;
      boolean bool = localpk.c;
      localpk.c = false;
      return bool;
    }
    return false;
  }
  
  private void O()
  {
    AppMethodBeat.i(224200);
    o();
    j();
    AppMethodBeat.o(224200);
  }
  
  private void P()
  {
    AppMethodBeat.i(224212);
    o();
    this.o.e();
    a(0.0D, 0.0D);
    AppMethodBeat.o(224212);
  }
  
  private void Q()
  {
    AppMethodBeat.i(224223);
    o();
    this.o.e();
    a(h(), 40.0D);
    AppMethodBeat.o(224223);
  }
  
  private boolean R()
  {
    return this.A.b.q > this.A.b.n;
  }
  
  private void S()
  {
    AppMethodBeat.i(224276);
    b(0);
    AppMethodBeat.o(224276);
  }
  
  private void T()
  {
    AppMethodBeat.i(224288);
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext()) {
      if ((fa)localIterator.next() != null) {}
    }
    c();
    AppMethodBeat.o(224288);
  }
  
  private void U()
  {
    AppMethodBeat.i(224298);
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext()) {
      if ((ev)localIterator.next() != null) {}
    }
    T();
    AppMethodBeat.o(224298);
  }
  
  private void V()
  {
    AppMethodBeat.i(224343);
    Iterator localIterator = this.W.iterator();
    while (localIterator.hasNext())
    {
      fh localfh = (fh)localIterator.next();
      if (localfh != null) {
        try
        {
          localfh.u();
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(224343);
  }
  
  private Rect W()
  {
    AppMethodBeat.i(224513);
    Object localObject = s();
    GeoPoint localGeoPoint = t();
    localObject = new Rect(((GeoPoint)localObject).getLongitudeE6(), ((GeoPoint)localObject).getLatitudeE6(), localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6());
    AppMethodBeat.o(224513);
    return localObject;
  }
  
  private void X()
  {
    AppMethodBeat.i(224523);
    this.o.e();
    AppMethodBeat.o(224523);
  }
  
  private boolean Y()
  {
    AppMethodBeat.i(224533);
    boolean bool = this.o.f();
    AppMethodBeat.o(224533);
    return bool;
  }
  
  private boolean Z()
  {
    AppMethodBeat.i(224541);
    boolean bool = this.o.g();
    AppMethodBeat.o(224541);
    return bool;
  }
  
  private double a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(223926);
    paramGeoPoint1 = this.B.a(paramGeoPoint1);
    paramGeoPoint2 = this.B.a(paramGeoPoint2);
    double d1 = paramGeoPoint2.a - paramGeoPoint1.a;
    double d2 = paramGeoPoint2.b - paramGeoPoint1.b;
    d1 = Math.sqrt(d2 * d2 + d1 * d1);
    AppMethodBeat.o(223926);
    return d1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, final boolean paramBoolean)
  {
    AppMethodBeat.i(223719);
    this.H = paramInt1;
    this.I = paramInt2;
    this.J = paramInt3;
    this.K = paramInt4;
    Object localObject;
    if ((this.C != null) && (this.C.width() > 0) && (this.C.height() > 0))
    {
      if ((paramInt1 + paramInt3 > this.C.width()) || (paramInt2 + paramInt4 > this.C.height()))
      {
        AppMethodBeat.o(223719);
        return -1;
      }
      localObject = a();
      a(((PointF)localObject).x, ((PointF)localObject).y, paramBoolean);
      AppMethodBeat.o(223719);
      return 0;
    }
    a(new oi()
    {
      public final void a()
      {
        AppMethodBeat.i(221767);
        PointF localPointF = ac.a(ac.this);
        ac.this.a(localPointF.x, localPointF.y, paramBoolean);
        ac.this.b(this);
        AppMethodBeat.o(221767);
      }
    });
    if ((this.z instanceof mk))
    {
      localObject = ((mk)this.z).getContext();
      if ((paramInt1 + paramInt3 > ha.b((Context)localObject)) || (paramInt2 + paramInt4 > ha.c((Context)localObject)))
      {
        AppMethodBeat.o(223719);
        return -1;
      }
      AppMethodBeat.o(223719);
      return 0;
    }
    AppMethodBeat.o(223719);
    return -2;
  }
  
  public static fl a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224635);
    double d2 = Math.min(Math.max(Math.sin(paramGeoPoint.getLatitudeE6() / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
    double d1 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    d2 = Math.log((1.0D + d2) / (1.0D - d2));
    paramGeoPoint = new fl();
    paramGeoPoint.a(d1 * 745654.04444444447D + 134217728.0D, d2 * 42722829.723526977D * 0.5D + 134217728.0D);
    AppMethodBeat.o(224635);
    return paramGeoPoint;
  }
  
  private ie a(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(224558);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(224558);
      return null;
    case 0: 
      paramObject1 = io.a(this, new int[] { 0, 1 });
      AppMethodBeat.o(224558);
      return paramObject1;
    case 1: 
      paramObject1 = io.a(this, new hs(), new Object[] { paramObject1, paramObject2 });
      AppMethodBeat.o(224558);
      return paramObject1;
    case 2: 
      d1 = ((Number)paramObject1).doubleValue();
      d2 = ((Number)paramObject2).doubleValue();
      paramObject1 = io.a(this, 3, new double[] { Math.log10(d1) / Math.log10(2.0D), Math.log10(d2) / Math.log10(2.0D) });
      AppMethodBeat.o(224558);
      return paramObject1;
    case 3: 
      d1 = ((Number)paramObject1).doubleValue();
      d2 = ((Number)paramObject2).doubleValue();
      paramObject1 = io.a(this, 2, new double[] { h(), d2 - d1 + h() });
      AppMethodBeat.o(224558);
      return paramObject1;
    }
    double d1 = ((Number)paramObject1).doubleValue();
    double d2 = ((Number)paramObject2).doubleValue();
    paramObject1 = io.a(this, 4, new double[] { i(), d2 - d1 + i() });
    AppMethodBeat.o(224558);
    return paramObject1;
  }
  
  private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    AppMethodBeat.i(224069);
    this.o.e();
    b(new iu(103, new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 }));
    AppMethodBeat.o(224069);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(223907);
    if (this.z != null)
    {
      sc localsc = this.z.f();
      if (localsc != null)
      {
        localsc.b(paramFloat1, paramFloat2);
        c();
      }
    }
    AppMethodBeat.o(223907);
  }
  
  private void a(float paramFloat1, float paramFloat2, Runnable paramRunnable)
  {
    AppMethodBeat.i(224094);
    if (this.L)
    {
      v.b localb = this.A.r;
      if (localb != null)
      {
        paramFloat1 = this.z.g().width() * (localb.a + 0.5F);
        paramFloat2 = this.z.g().height() * (localb.b + 0.5F);
      }
    }
    else
    {
      if (l())
      {
        this.z.f().c(paramFloat1, paramFloat2);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      AppMethodBeat.o(224094);
      return;
    }
    a(paramRunnable);
    AppMethodBeat.o(224094);
  }
  
  private void a(int paramInt, final double paramDouble)
  {
    AppMethodBeat.i(224507);
    a(paramInt, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221769);
        ac.a(ac.this, (360.0D - paramDouble) % 360.0D, 40.0D);
        AppMethodBeat.o(221769);
      }
    });
    AppMethodBeat.o(224507);
  }
  
  private void a(int paramInt, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223863);
    a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6(), 1);
    a(paramInt);
    AppMethodBeat.o(223863);
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    AppMethodBeat.i(223916);
    if (!x())
    {
      AppMethodBeat.o(223916);
      return;
    }
    Rect localRect1 = new Rect(this.C);
    if (paramRect2 != null)
    {
      localRect1.left += paramRect2.left;
      localRect1.right -= paramRect2.right;
      localRect1.top += paramRect2.top;
      localRect1.bottom -= paramRect2.bottom;
    }
    paramRect2 = new GeoPoint(paramRect1.top, paramRect1.left);
    paramRect1 = new GeoPoint(paramRect1.bottom, paramRect1.right);
    Rect localRect2 = new Rect();
    localRect2.left = Math.min(paramRect2.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect2.right = Math.max(paramRect2.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect2.top = Math.min(paramRect2.getLatitudeE6(), paramRect1.getLatitudeE6());
    localRect2.bottom = Math.max(paramRect2.getLatitudeE6(), paramRect1.getLatitudeE6());
    this.z.f().a(localRect2, localRect1, paramBoolean);
    AppMethodBeat.o(223916);
  }
  
  private void a(GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(223877);
    a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6(), 1);
    a(paramFloat1);
    b(paramFloat2);
    a(paramFloat3);
    AppMethodBeat.o(223877);
  }
  
  private void a(GeoPoint paramGeoPoint, Rect paramRect)
  {
    double d2 = 0.0D;
    AppMethodBeat.i(224411);
    ep localep = this.B;
    paramGeoPoint = localep.a(paramGeoPoint);
    if (paramRect.contains((int)paramGeoPoint.a, (int)paramGeoPoint.b))
    {
      AppMethodBeat.o(224411);
      return;
    }
    double d1;
    if (paramGeoPoint.a < paramRect.left) {
      d1 = paramRect.left - paramGeoPoint.a;
    }
    for (;;)
    {
      if (paramGeoPoint.b < paramRect.top) {
        d2 = paramRect.top - paramGeoPoint.b;
      }
      for (;;)
      {
        paramGeoPoint = localep.a(this.A.m);
        paramGeoPoint.a -= d1;
        paramGeoPoint.b -= d2;
        a(localep.a(paramGeoPoint), null);
        AppMethodBeat.o(224411);
        return;
        if (paramGeoPoint.a <= paramRect.right) {
          break label208;
        }
        d1 = paramRect.right - paramGeoPoint.a;
        break;
        if (paramGeoPoint.b > paramRect.bottom) {
          d2 = paramRect.bottom - paramGeoPoint.b;
        }
      }
      label208:
      d1 = 0.0D;
    }
  }
  
  private void a(final GeoPoint paramGeoPoint, final id paramid)
  {
    AppMethodBeat.i(224593);
    boolean bool = false;
    Object localObject = r();
    if (localObject != null) {
      bool = ((Rect)localObject).contains(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    }
    paramid = new Runnable()
    {
      public final void run() {}
    };
    final float f3 = this.A.b.p;
    fl localfl1;
    fl localfl2;
    int i2;
    int i1;
    double d1;
    double d2;
    if (!bool)
    {
      localObject = this.A.m;
      localfl1 = this.B.a((GeoPoint)localObject);
      localfl2 = this.B.a(paramGeoPoint);
      i2 = 1;
      i1 = i2;
      if (this.C != null)
      {
        d1 = Math.abs(localfl1.a - localfl2.a);
        d2 = Math.abs(localfl1.b - localfl2.b);
        if (d1 <= this.C.width())
        {
          i1 = i2;
          if (d2 <= this.C.height()) {}
        }
        else
        {
          i1 = 0;
        }
      }
      if (i1 == 0)
      {
        if (this.C == null) {
          break label501;
        }
        i2 = this.C.width();
        i1 = this.C.height();
      }
    }
    for (;;)
    {
      float f1;
      if ((i2 == 0) || (i1 == 0) || (localObject == null) || (paramGeoPoint == null)) {
        f1 = 1.0F;
      }
      for (;;)
      {
        b(new GeoPoint((paramGeoPoint.getLatitudeE6() + ((GeoPoint)localObject).getLatitudeE6()) / 2, (paramGeoPoint.getLongitudeE6() + ((GeoPoint)localObject).getLongitudeE6()) / 2), f1, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221760);
            ac.a(ac.this, paramGeoPoint, f3, paramid);
            AppMethodBeat.o(221760);
          }
        });
        AppMethodBeat.o(224593);
        return;
        localfl1 = a((GeoPoint)localObject);
        localfl2 = a(paramGeoPoint);
        d2 = localfl2.a - localfl1.a;
        d1 = d2;
        if (d2 < 0.0D) {
          d1 = Math.abs(d2);
        }
        double d3 = localfl2.b - localfl1.b;
        d2 = d3;
        if (d3 < 0.0D) {
          d2 = Math.abs(d3);
        }
        i2 = i2 - this.H - this.J;
        int i3 = i1 - this.I - this.K;
        i1 = i2;
        if (i2 <= 0) {
          i1 = 1;
        }
        i2 = i3;
        if (i3 <= 0) {
          i2 = 1;
        }
        float f2 = (float)(20.0D - Math.max(Math.log(1.0D * d1 / i1) / Math.log(2.0D), Math.log(d2 * 1.0D / i2) / Math.log(2.0D)));
        f1 = f2;
        if (this.A != null) {
          f1 = v.a.a((int)f2);
        }
      }
      b(paramGeoPoint, paramid);
      AppMethodBeat.o(224593);
      return;
      b(paramGeoPoint, paramid);
      AppMethodBeat.o(224593);
      return;
      label501:
      i1 = 0;
      i2 = 0;
    }
  }
  
  private void a(a parama)
  {
    this.D = parama;
  }
  
  private void a(ev paramev)
  {
    AppMethodBeat.i(224378);
    if (paramev == null)
    {
      AppMethodBeat.o(224378);
      return;
    }
    synchronized (this.r)
    {
      if (!this.r.contains(paramev)) {
        this.r.add(paramev);
      }
      AppMethodBeat.o(224378);
      return;
    }
  }
  
  private void a(ex paramex)
  {
    AppMethodBeat.i(224306);
    if (paramex == null)
    {
      AppMethodBeat.o(224306);
      return;
    }
    if (this.s == null) {
      this.s = new ArrayList();
    }
    synchronized (this.t)
    {
      if (!this.s.contains(paramex)) {
        this.s.add(paramex);
      }
      AppMethodBeat.o(224306);
      return;
    }
  }
  
  private void a(fa paramfa)
  {
    AppMethodBeat.i(224353);
    if (paramfa == null)
    {
      AppMethodBeat.o(224353);
      return;
    }
    synchronized (this.q)
    {
      if (!this.q.contains(paramfa)) {
        this.q.add(paramfa);
      }
      AppMethodBeat.o(224353);
      return;
    }
  }
  
  private void a(fb paramfb)
  {
    AppMethodBeat.i(223802);
    if (paramfb == null)
    {
      AppMethodBeat.o(223802);
      return;
    }
    synchronized (this.x)
    {
      if (!this.x.contains(paramfb)) {
        this.x.add(paramfb);
      }
      AppMethodBeat.o(223802);
      return;
    }
  }
  
  private void a(fc paramfc)
  {
    AppMethodBeat.i(224322);
    if (paramfc == null)
    {
      AppMethodBeat.o(224322);
      return;
    }
    synchronized (this.u)
    {
      if (!this.u.contains(paramfc)) {
        this.u.add(paramfc);
      }
      AppMethodBeat.o(224322);
      return;
    }
  }
  
  private void a(pn parampn)
  {
    AppMethodBeat.i(223843);
    if (this.p == null) {
      this.p = this.y.M();
    }
    pk localpk = this.p;
    localpk.b = parampn;
    boolean bool = parampn.a();
    if (localpk.d != null)
    {
      if (bool)
      {
        localpk.d.b(localpk);
        AppMethodBeat.o(223843);
        return;
      }
      localpk.d.a(localpk);
    }
    AppMethodBeat.o(223843);
  }
  
  private void a(boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(224131);
    this.o.e();
    final double d1 = m(0.0D - h());
    final double d2 = 0.0D - i();
    if ((d1 == 0.0D) && (d2 == 0.0D))
    {
      if (paramRunnable != null)
      {
        paramRunnable = new iu(paramRunnable);
        paramRunnable.D = true;
        paramRunnable.B = 0L;
        b(paramRunnable);
      }
      AppMethodBeat.o(224131);
      return;
    }
    kh.a("postRotateAndSkew distance:" + d1 + "," + d2);
    final long l1 = System.currentTimeMillis();
    float f1 = (float)(0.1000000014901161D * d1);
    final float f2 = (float)(0.1000000014901161D * d2);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(new iu(new double[] { 0.0D, 0.0D, 0.0D, 0.0D }, paramBoolean, l1)
      {
        public final boolean a()
        {
          AppMethodBeat.i(221740);
          long l = System.currentTimeMillis() - l1;
          double d1 = ir.a(l, f2);
          double d2 = ir.a(l, d1);
          double[] arrayOfDouble = this.A;
          arrayOfDouble[2] += Math.abs(d1);
          arrayOfDouble = this.A;
          arrayOfDouble[3] += Math.abs(d2);
          int i;
          int j;
          if (this.A[2] >= Math.abs(d2))
          {
            i = 1;
            if (this.A[3] < Math.abs(this.e)) {
              break label184;
            }
            j = 1;
            label113:
            if (i == 0) {
              break label190;
            }
            this.A[0] = (this.f - ac.this.h());
            label137:
            if (j == 0) {
              break label200;
            }
            this.A[1] = (this.g - ac.this.i());
          }
          for (;;)
          {
            if ((i == 0) || (j == 0)) {
              break label210;
            }
            AppMethodBeat.o(221740);
            return true;
            i = 0;
            break;
            label184:
            j = 0;
            break label113;
            label190:
            this.A[0] = d1;
            break label137;
            label200:
            this.A[1] = d2;
          }
          label210:
          AppMethodBeat.o(221740);
          return false;
        }
      });
      if (paramRunnable != null)
      {
        paramRunnable = new iu(paramRunnable);
        paramRunnable.D = true;
        paramRunnable.B = 0L;
        b(paramRunnable);
      }
      AppMethodBeat.o(224131);
      return;
    }
  }
  
  private v aa()
  {
    return this.A;
  }
  
  private float b(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(224470);
    if (!x())
    {
      f1 = this.A.b.p;
      AppMethodBeat.o(224470);
      return f1;
    }
    int i4 = paramGeoPoint1.getLatitudeE6();
    int i1 = paramGeoPoint1.getLongitudeE6();
    int i5 = paramGeoPoint2.getLatitudeE6();
    int i2 = paramGeoPoint2.getLongitudeE6();
    int i3 = Math.min(i5, i4);
    i4 = Math.max(i5, i4);
    float f1 = a(new Rect(Math.min(i2, i1), i3, Math.max(i2, i1), i4), this.C);
    AppMethodBeat.o(224470);
    return f1;
  }
  
  private void b(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(223976);
    this.z.f().b((float)paramDouble1, (float)paramDouble2);
    U();
    c();
    AppMethodBeat.o(223976);
  }
  
  private void b(float paramFloat)
  {
    AppMethodBeat.i(223950);
    b(paramFloat);
    AppMethodBeat.o(223950);
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.E = paramFloat1;
    this.F = paramFloat2;
  }
  
  private void b(float paramFloat1, float paramFloat2, Runnable paramRunnable)
  {
    AppMethodBeat.i(224102);
    if (!l())
    {
      AppMethodBeat.o(224102);
      return;
    }
    this.z.f().c(paramFloat1, paramFloat2);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(224102);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223896);
    a(paramInt1, paramInt2, 1);
    AppMethodBeat.o(223896);
  }
  
  private void b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224427);
    a(paramGeoPoint, null);
    AppMethodBeat.o(224427);
  }
  
  private void b(GeoPoint paramGeoPoint, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(224459);
    a(paramGeoPoint, paramInt, paramRunnable);
    AppMethodBeat.o(224459);
  }
  
  private void b(GeoPoint paramGeoPoint, Rect paramRect)
  {
    AppMethodBeat.i(224421);
    ep localep = this.B;
    paramGeoPoint = localep.a(paramGeoPoint);
    double d1 = paramRect.centerX();
    double d2 = paramGeoPoint.a;
    double d3 = paramRect.centerY();
    double d4 = paramGeoPoint.b;
    paramGeoPoint = localep.a(this.A.m);
    paramGeoPoint.a -= d1 - d2;
    paramGeoPoint.b -= d3 - d4;
    a(localep.a(paramGeoPoint), null);
    AppMethodBeat.o(224421);
  }
  
  private void b(ba paramba)
  {
    AppMethodBeat.i(223781);
    if (this.v == null)
    {
      AppMethodBeat.o(223781);
      return;
    }
    synchronized (this.w)
    {
      this.v.remove(paramba);
      AppMethodBeat.o(223781);
      return;
    }
  }
  
  private void b(ev paramev)
  {
    AppMethodBeat.i(224389);
    synchronized (this.r)
    {
      this.r.remove(paramev);
      AppMethodBeat.o(224389);
      return;
    }
  }
  
  private void b(ex paramex)
  {
    AppMethodBeat.i(224316);
    if (this.s == null)
    {
      AppMethodBeat.o(224316);
      return;
    }
    synchronized (this.t)
    {
      this.s.remove(paramex);
      AppMethodBeat.o(224316);
      return;
    }
  }
  
  private void b(fa paramfa)
  {
    AppMethodBeat.i(224364);
    synchronized (this.q)
    {
      this.q.remove(paramfa);
      AppMethodBeat.o(224364);
      return;
    }
  }
  
  private void b(fb paramfb)
  {
    AppMethodBeat.i(223810);
    synchronized (this.x)
    {
      this.x.remove(paramfb);
      AppMethodBeat.o(223810);
      return;
    }
  }
  
  private void b(fc paramfc)
  {
    AppMethodBeat.i(224333);
    synchronized (this.u)
    {
      this.u.remove(paramfc);
      AppMethodBeat.o(224333);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(223791);
    this.G = paramBoolean;
    this.z.f().b(this.G);
    AppMethodBeat.o(223791);
  }
  
  private void b(boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(224189);
    double d1 = m(0.0D - h());
    double d2 = 0.0D - i();
    if ((d1 == 0.0D) && (d2 == 0.0D))
    {
      if (paramRunnable != null)
      {
        paramRunnable = new iu(paramRunnable);
        paramRunnable.D = true;
        paramRunnable.B = 0L;
        b(paramRunnable);
      }
      AppMethodBeat.o(224189);
      return;
    }
    kh.a("postRotateAndSkew distance:" + d1 + "," + d2);
    long l1 = System.currentTimeMillis();
    float f1 = (float)(0.1000000014901161D * d1);
    float f2 = (float)(0.1000000014901161D * d2);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(new iu(new double[] { 0.0D, 0.0D, 0.0D, 0.0D }, paramBoolean, l1)
      {
        public final boolean a()
        {
          AppMethodBeat.i(221740);
          long l = System.currentTimeMillis() - l1;
          double d1 = ir.a(l, f2);
          double d2 = ir.a(l, d1);
          double[] arrayOfDouble = this.A;
          arrayOfDouble[2] += Math.abs(d1);
          arrayOfDouble = this.A;
          arrayOfDouble[3] += Math.abs(d2);
          int i;
          int j;
          if (this.A[2] >= Math.abs(d2))
          {
            i = 1;
            if (this.A[3] < Math.abs(this.e)) {
              break label184;
            }
            j = 1;
            label113:
            if (i == 0) {
              break label190;
            }
            this.A[0] = (this.f - ac.this.h());
            label137:
            if (j == 0) {
              break label200;
            }
            this.A[1] = (this.g - ac.this.i());
          }
          for (;;)
          {
            if ((i == 0) || (j == 0)) {
              break label210;
            }
            AppMethodBeat.o(221740);
            return true;
            i = 0;
            break;
            label184:
            j = 0;
            break label113;
            label190:
            this.A[0] = d1;
            break label137;
            label200:
            this.A[1] = d2;
          }
          label210:
          AppMethodBeat.o(221740);
          return false;
        }
      });
      if (paramRunnable != null)
      {
        paramRunnable = new iu(paramRunnable);
        paramRunnable.D = true;
        paramRunnable.B = 0L;
        b(paramRunnable);
      }
      AppMethodBeat.o(224189);
      return;
    }
  }
  
  private float c(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(224622);
    int i2;
    int i1;
    if (this.C != null)
    {
      i2 = this.C.width();
      i1 = this.C.height();
    }
    for (;;)
    {
      if ((i2 == 0) || (i1 == 0) || (paramGeoPoint1 == null) || (paramGeoPoint2 == null))
      {
        AppMethodBeat.o(224622);
        return 1.0F;
      }
      paramGeoPoint1 = a(paramGeoPoint1);
      paramGeoPoint2 = a(paramGeoPoint2);
      double d2 = paramGeoPoint2.a - paramGeoPoint1.a;
      double d1 = d2;
      if (d2 < 0.0D) {
        d1 = Math.abs(d2);
      }
      double d3 = paramGeoPoint2.b - paramGeoPoint1.b;
      d2 = d3;
      if (d3 < 0.0D) {
        d2 = Math.abs(d3);
      }
      i2 = i2 - this.H - this.J;
      int i3 = i1 - this.I - this.K;
      i1 = i2;
      if (i2 <= 0) {
        i1 = 1;
      }
      i2 = i3;
      if (i3 <= 0) {
        i2 = 1;
      }
      float f1 = (float)(20.0D - Math.max(Math.log(1.0D * d1 / i1) / Math.log(2.0D), Math.log(d2 * 1.0D / i2) / Math.log(2.0D)));
      if (this.A != null)
      {
        f1 = v.a.a((int)f1);
        AppMethodBeat.o(224622);
        return f1;
      }
      AppMethodBeat.o(224622);
      return f1;
      i1 = 0;
      i2 = 0;
    }
  }
  
  private void c(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(224028);
    y localy = this.o;
    synchronized (localy.c)
    {
      while ((!localy.b.isEmpty()) && (((iu)localy.b.get(localy.b.size() - 1)).z == 3))
      {
        iu localiu = (iu)localy.b.remove(localy.b.size() - 1);
        paramDouble1 += localiu.A[0];
        paramDouble2 += localiu.A[1];
      }
      localy.a(new iu(3, new double[] { paramDouble1, paramDouble2 }));
      AppMethodBeat.o(224028);
      return;
    }
  }
  
  private void c(float paramFloat)
  {
    AppMethodBeat.i(223958);
    a(paramFloat);
    AppMethodBeat.o(223958);
  }
  
  private void c(Rect paramRect)
  {
    AppMethodBeat.i(224477);
    b(paramRect, null);
    AppMethodBeat.o(224477);
  }
  
  private void c(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224434);
    a(paramGeoPoint, null);
    AppMethodBeat.o(224434);
  }
  
  private void c(GeoPoint paramGeoPoint, float paramFloat, Runnable paramRunnable)
  {
    AppMethodBeat.i(224653);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(224653);
      return;
    }
    this.o.e();
    int i1 = 0;
    double d1 = this.A.b.p;
    double d2 = paramFloat / d1;
    if (d2 > 1.0D) {
      i1 = (int)(d2 / 0.5D);
    }
    for (;;)
    {
      int i2 = Math.max(60, Math.min(120, i1 >> 1 << 1));
      d1 = Math.log10(d1) / Math.log10(2.0D);
      d2 = Math.log10(paramFloat) / Math.log10(2.0D);
      GeoPoint localGeoPoint = this.A.m;
      i1 = 0;
      while (i1 < i2)
      {
        double d3 = Math.pow(2.0D, lu.a(d1, d2, i2, i1 + 1));
        double d4 = lu.a(localGeoPoint.getLatitudeE6(), paramGeoPoint.getLatitudeE6(), i2, i1 + 1);
        double d5 = lu.a(localGeoPoint.getLongitudeE6(), paramGeoPoint.getLongitudeE6(), i2, i1 + 1);
        kh.a("debug location anim zoomOut:" + d4 + "," + d5);
        b(new iu(120, new double[] { d3, d4, d5 }));
        i1 += 1;
      }
      if (d2 >= 1.0D) {
        break;
      }
      if (d2 != 1.0D) {
        i1 = (int)(0.5D / d2);
      }
    }
    b(paramGeoPoint, paramRunnable);
    AppMethodBeat.o(224653);
    return;
    if (paramRunnable != null) {
      b(new iu(paramRunnable));
    }
    AppMethodBeat.o(224653);
  }
  
  private void c(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    AppMethodBeat.i(224442);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(224442);
      return;
    }
    a(paramGeoPoint, this.A.b.q, paramRunnable);
    AppMethodBeat.o(224442);
  }
  
  private void c(Runnable paramRunnable)
  {
    AppMethodBeat.i(224082);
    if (!l())
    {
      AppMethodBeat.o(224082);
      return;
    }
    float f1 = this.z.g().width() / 2.0F;
    float f2 = this.z.g().height() / 2.0F;
    this.z.f().c(f1, f2);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(224082);
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(224267);
    if (paramBoolean) {}
    for (int i1 = 12;; i1 = 0)
    {
      b(i1);
      AppMethodBeat.o(224267);
      return;
    }
  }
  
  private float d(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(224489);
    Rect localRect = new Rect(this.z.g());
    if (paramRect2 != null)
    {
      localRect.left += paramRect2.left;
      localRect.right -= paramRect2.right;
      localRect.top += paramRect2.top;
      localRect.bottom -= paramRect2.bottom;
    }
    float f1 = a(paramRect1, localRect);
    AppMethodBeat.o(224489);
    return f1;
  }
  
  private void d(double paramDouble)
  {
    AppMethodBeat.i(223986);
    if (paramDouble == 0.0D)
    {
      AppMethodBeat.o(223986);
      return;
    }
    this.A.b(this.A.p.q() + (float)paramDouble);
    c();
    E();
    AppMethodBeat.o(223986);
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(224399);
    Iterator localIterator = this.X.iterator();
    while (localIterator.hasNext())
    {
      fi localfi = (fi)localIterator.next();
      if (localfi != null) {
        try
        {
          localfi.i(paramInt);
        }
        catch (Exception localException) {}
      }
    }
    c();
    AppMethodBeat.o(224399);
  }
  
  private void d(Rect paramRect)
  {
    AppMethodBeat.i(224482);
    b(paramRect, null);
    AppMethodBeat.o(224482);
  }
  
  private void d(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    AppMethodBeat.i(224450);
    a(paramGeoPoint, 18, paramRunnable);
    AppMethodBeat.o(224450);
  }
  
  private void d(iu paramiu)
  {
    AppMethodBeat.i(224251);
    switch (paramiu.z)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(224251);
      return;
      if ((this.y != null) && (this.y.getMapRenderView() != null))
      {
        this.y.getMapRenderView().d();
        AppMethodBeat.o(224251);
        return;
        b(paramiu.A[0], paramiu.A[1]);
        AppMethodBeat.o(224251);
        return;
        f(paramiu.A[0]);
        AppMethodBeat.o(224251);
        return;
        a((float)paramiu.A[0]);
        AppMethodBeat.o(224251);
        return;
        int i6 = this.z.g().width();
        int i5 = this.z.g().height();
        int i4 = i6 / 2;
        int i3 = i5 / 2;
        v.b localb = this.A.r;
        int i2 = i3;
        int i1 = i4;
        if (localb != null)
        {
          float f1 = i4;
          float f2 = localb.a;
          i1 = (int)(f1 + i6 * f2);
          i2 = (int)(i3 + localb.b * i5);
        }
        double d1 = i1;
        double d2 = paramiu.A[1];
        double d3 = i2;
        double d4 = paramiu.A[2];
        double d5 = paramiu.A[3];
        double d6 = i1;
        double d7 = paramiu.A[4];
        double d8 = i2;
        b(d1 - d2, d3 - d4);
        f(paramiu.A[0]);
        b(d5 - d6, d7 - d8);
        AppMethodBeat.o(224251);
        return;
        e(paramiu.A[0]);
        d(paramiu.A[1]);
        AppMethodBeat.o(224251);
        return;
        i1 = this.z.g().width() / 2;
        i2 = this.z.g().height() / 2;
        b(i1 - paramiu.A[1], i2 - paramiu.A[2]);
        e(paramiu.A[0]);
        b(paramiu.A[3] - i1, paramiu.A[4] - i2);
        AppMethodBeat.o(224251);
        return;
        b(paramiu.A[0]);
        AppMethodBeat.o(224251);
        return;
        a(paramiu.A[0]);
        AppMethodBeat.o(224251);
        return;
        this.A.a(0.0F);
        this.A.b(0.0F);
        D();
        E();
        c();
        AppMethodBeat.o(224251);
        return;
        if (paramiu.A.length > 2) {}
        for (i1 = (int)paramiu.A[2];; i1 = 1)
        {
          a((int)paramiu.A[0], (int)paramiu.A[1], i1);
          AppMethodBeat.o(224251);
          return;
        }
        a((float)paramiu.A[0]);
        a((int)paramiu.A[1], (int)paramiu.A[2], 1);
        AppMethodBeat.o(224251);
        return;
        if (paramiu.E != null)
        {
          paramiu.E.run();
          AppMethodBeat.o(224251);
          return;
          if (this.D != null) {
            this.D.a(paramiu);
          }
        }
      }
    }
  }
  
  private void d(Runnable paramRunnable)
  {
    AppMethodBeat.i(224118);
    if (this.A.b.q > this.A.b.n) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      AppMethodBeat.o(224118);
      return;
    }
    sc localsc = this.z.f();
    if ((0L == localsc.e) || (localsc.j == null)) {}
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(224118);
      return;
      localsc.j.a(new sc.163(localsc));
    }
  }
  
  private void d(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  private boolean d(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224606);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(224606);
      return true;
    }
    Object localObject = r();
    if (localObject != null) {}
    for (boolean bool = ((Rect)localObject).contains(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());; bool = false)
    {
      localObject = this.B.a(this.A.m);
      paramGeoPoint = this.B.a(paramGeoPoint);
      if (this.C != null)
      {
        double d1 = Math.abs(((fl)localObject).a - paramGeoPoint.a);
        double d2 = Math.abs(((fl)localObject).b - paramGeoPoint.b);
        if ((d1 <= this.C.width()) && (d2 <= this.C.height())) {}
      }
      for (int i1 = 0;; i1 = 1)
      {
        if ((!bool) && (i1 == 0))
        {
          AppMethodBeat.o(224606);
          return true;
        }
        AppMethodBeat.o(224606);
        return false;
      }
    }
  }
  
  private void e(double paramDouble)
  {
    AppMethodBeat.i(223994);
    if (paramDouble == 0.0D)
    {
      AppMethodBeat.o(223994);
      return;
    }
    this.A.a(this.A.p.r() + (float)paramDouble);
    c();
    D();
    AppMethodBeat.o(223994);
  }
  
  private void e(int paramInt)
  {
    AppMethodBeat.i(224497);
    a(paramInt, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221761);
        ac.a(ac.this, 0.0D, 0.0D);
        AppMethodBeat.o(221761);
      }
    });
    AppMethodBeat.o(224497);
  }
  
  private void f(double paramDouble)
  {
    AppMethodBeat.i(224003);
    a((float)(this.A.b.p * (float)paramDouble));
    AppMethodBeat.o(224003);
  }
  
  private void g(double paramDouble)
  {
    AppMethodBeat.i(224013);
    a((float)paramDouble);
    AppMethodBeat.o(224013);
  }
  
  private void h(double paramDouble)
  {
    AppMethodBeat.i(224036);
    this.o.e();
    b(new iu(102, new double[] { 0.0D, paramDouble }));
    AppMethodBeat.o(224036);
  }
  
  private void i(double paramDouble)
  {
    AppMethodBeat.i(224042);
    this.o.e();
    b(new iu(102, new double[] { paramDouble, 0.0D }));
    AppMethodBeat.o(224042);
  }
  
  private void j(double paramDouble)
  {
    AppMethodBeat.i(224051);
    a((360.0D - paramDouble) % 360.0D, i(), true);
    AppMethodBeat.o(224051);
  }
  
  private void k(double paramDouble)
  {
    AppMethodBeat.i(224059);
    this.o.e();
    b(new iu(100, new double[] { paramDouble }));
    AppMethodBeat.o(224059);
  }
  
  private void l(double paramDouble)
  {
    AppMethodBeat.i(224164);
    a((360.0D - paramDouble) % 360.0D, 40.0D, true);
    AppMethodBeat.o(224164);
  }
  
  private static double m(double paramDouble)
  {
    double d1 = paramDouble % 360.0D;
    if (d1 > 180.0D) {
      paramDouble = d1 - 360.0D;
    }
    do
    {
      return paramDouble;
      paramDouble = d1;
    } while (d1 >= -180.0D);
    return d1 + 360.0D;
  }
  
  private void v()
  {
    this.M = true;
  }
  
  private boolean w()
  {
    return this.M;
  }
  
  private boolean x()
  {
    AppMethodBeat.i(223727);
    if ((this.C != null) && (this.C.width() > 0) && (this.C.height() > 0))
    {
      AppMethodBeat.o(223727);
      return true;
    }
    AppMethodBeat.o(223727);
    return false;
  }
  
  private y y()
  {
    AppMethodBeat.i(223736);
    y localy = this.o;
    if (localy.d != null) {
      localy.d.destroy();
    }
    localy.d = new y.a(localy);
    localy.d.start();
    localy = this.o;
    AppMethodBeat.o(223736);
    return localy;
  }
  
  private void z()
  {
    AppMethodBeat.i(223745);
    if (this.o != null) {
      this.o.b();
    }
    AppMethodBeat.o(223745);
  }
  
  public final float a(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(224813);
    GeoPoint localGeoPoint = new GeoPoint(paramRect1.top, paramRect1.left);
    paramRect1 = new GeoPoint(paramRect1.bottom, paramRect1.right);
    Rect localRect = new Rect();
    localRect.left = Math.min(localGeoPoint.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect.right = Math.max(localGeoPoint.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect.top = Math.min(localGeoPoint.getLatitudeE6(), paramRect1.getLatitudeE6());
    localRect.bottom = Math.max(localGeoPoint.getLatitudeE6(), paramRect1.getLatitudeE6());
    float f1 = (float)this.z.f().a(localRect, paramRect2);
    AppMethodBeat.o(224813);
    return f1;
  }
  
  public final PointF a()
  {
    AppMethodBeat.i(224705);
    int i2;
    int i1;
    if (this.C != null)
    {
      i2 = this.C.width();
      i1 = this.C.height();
    }
    for (;;)
    {
      int i3 = this.H;
      int i4 = (i2 - i3 - this.J) / 2;
      int i5 = this.I;
      int i6 = (i1 - i5 - this.K) / 2;
      if ((i2 != 0) && (i1 != 0))
      {
        localPointF = new PointF((i4 + i3) * 1.0F / i2, (i6 + i5) * 1.0F / i1);
        AppMethodBeat.o(224705);
        return localPointF;
      }
      PointF localPointF = new PointF(0.5F, 0.5F);
      AppMethodBeat.o(224705);
      return localPointF;
      i1 = 0;
      i2 = 0;
    }
  }
  
  public final void a(double paramDouble)
  {
    AppMethodBeat.i(224849);
    if (paramDouble == this.A.p.q())
    {
      AppMethodBeat.o(224849);
      return;
    }
    this.A.b((float)paramDouble);
    c();
    E();
    AppMethodBeat.o(224849);
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(224923);
    paramDouble1 = m(paramDouble1 - h());
    paramDouble2 -= i();
    if ((paramDouble1 == 0.0D) && (paramDouble2 == 0.0D))
    {
      AppMethodBeat.o(224923);
      return;
    }
    kh.a("rotateAndSkew distance:" + paramDouble1 + "," + paramDouble2);
    b(new iu(102, new double[] { paramDouble1, paramDouble2, 0.0D, 0.0D }, true));
    AppMethodBeat.o(224923);
  }
  
  public final void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, Runnable paramRunnable)
  {
    AppMethodBeat.i(224885);
    this.o.e();
    float f1 = this.z.g().width() / 2.0F;
    float f2 = this.z.g().height() / 2.0F;
    v.b localb = this.A.r;
    if (this.L)
    {
      if (localb == null) {
        break label181;
      }
      paramDouble2 = f1 + localb.a * f1 * 2.0F;
    }
    for (paramDouble3 = localb.b * f2 * 2.0F + f2;; paramDouble3 = f2)
    {
      paramDouble5 = paramDouble3;
      paramDouble4 = paramDouble2;
      b(new iu(101, new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 }));
      paramRunnable = new iu(paramRunnable);
      paramRunnable.D = false;
      paramRunnable.B = 0L;
      b(paramRunnable);
      AppMethodBeat.o(224885);
      return;
      label181:
      paramDouble2 = f1;
    }
  }
  
  public final void a(double paramDouble1, final double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(224930);
    final double d1 = m(paramDouble1 - h());
    final double d2 = paramDouble2 - i();
    if ((d1 == 0.0D) && (d2 == 0.0D))
    {
      AppMethodBeat.o(224930);
      return;
    }
    kh.a("postRotateAndSkew distance:" + d1 + "," + d2);
    final long l1 = System.currentTimeMillis();
    float f1 = (float)(0.1000000014901161D * d1);
    final float f2 = (float)(0.1000000014901161D * d2);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(new iu(new double[] { paramDouble1, paramDouble2, 0.0D, 0.0D }, paramBoolean, l1)
      {
        public final boolean a()
        {
          AppMethodBeat.i(221734);
          long l = System.currentTimeMillis() - l1;
          double d1 = ir.a(l, f2);
          double d2 = ir.a(l, d1);
          double[] arrayOfDouble = this.A;
          arrayOfDouble[2] += Math.abs(d1);
          arrayOfDouble = this.A;
          arrayOfDouble[3] += Math.abs(d2);
          int i;
          int j;
          if (this.A[2] >= Math.abs(d2))
          {
            i = 1;
            if (this.A[3] < Math.abs(paramDouble2)) {
              break label184;
            }
            j = 1;
            label113:
            if (i == 0) {
              break label190;
            }
            this.A[0] = (this.f - ac.this.h());
            label137:
            if (j == 0) {
              break label200;
            }
            this.A[1] = (this.g - ac.this.i());
          }
          for (;;)
          {
            if ((i == 0) || (j == 0)) {
              break label210;
            }
            AppMethodBeat.o(221734);
            return true;
            i = 0;
            break;
            label184:
            j = 0;
            break label113;
            label190:
            this.A[0] = d1;
            break label137;
            label200:
            this.A[1] = d2;
          }
          label210:
          AppMethodBeat.o(221734);
          return false;
        }
      });
      AppMethodBeat.o(224930);
      return;
    }
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(224822);
    c(this.A.c(paramFloat));
    AppMethodBeat.o(224822);
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(224965);
    this.A.a(paramFloat1 - 0.5F, paramFloat2 - 0.5F, paramBoolean);
    if (paramBoolean) {
      c();
    }
    AppMethodBeat.o(224965);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(224797);
    if (this.A.c(paramInt)) {
      c(fv.c);
    }
    AppMethodBeat.o(224797);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225295);
    b(paramInt1, paramInt2);
    AppMethodBeat.o(225295);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(224803);
    this.A.a(paramInt1, paramInt2, false);
    if (paramInt3 == 1)
    {
      U();
      c();
    }
    AppMethodBeat.o(224803);
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(225286);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(225286);
      return;
      paramObject = (GeoPoint)paramObject;
      a(paramObject.getLatitudeE6(), paramObject.getLongitudeE6(), 2);
      AppMethodBeat.o(225286);
      return;
      e(((Number)paramObject).doubleValue() - h());
      AppMethodBeat.o(225286);
      return;
      a((float)Math.pow(2.0D, ((Number)paramObject).doubleValue()));
      AppMethodBeat.o(225286);
      return;
      d(((Number)paramObject).doubleValue() - i());
    }
  }
  
  public final void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(225184);
    sc localsc = this.z.f();
    if ((0L == localsc.e) || (localsc.j == null)) {}
    for (;;)
    {
      paramRunnable.run();
      AppMethodBeat.o(225184);
      return;
      localsc.j.a(new sc.161(localsc, paramInt));
    }
  }
  
  public final void a(Rect paramRect)
  {
    AppMethodBeat.i(224762);
    if (!x())
    {
      AppMethodBeat.o(224762);
      return;
    }
    float f1 = a(paramRect, this.C);
    this.A.a(paramRect);
    this.A.d(f1);
    AppMethodBeat.o(224762);
  }
  
  public final void a(GeoPoint paramGeoPoint, float paramFloat, Runnable paramRunnable)
  {
    AppMethodBeat.i(225172);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(225172);
      return;
    }
    if ((paramFloat >= 3.0F) && (paramFloat <= 20.0F)) {
      this.z.f().a(paramGeoPoint, (int)paramFloat);
    }
    this.ab = paramRunnable;
    AppMethodBeat.o(225172);
  }
  
  public final void a(GeoPoint paramGeoPoint, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(225159);
    a(paramGeoPoint, paramInt, paramRunnable);
    AppMethodBeat.o(225159);
  }
  
  public final void a(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    AppMethodBeat.i(225127);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(225127);
      return;
    }
    a(paramGeoPoint, this.A.b.q, paramRunnable);
    AppMethodBeat.o(225127);
  }
  
  public final void a(ba paramba)
  {
    AppMethodBeat.i(224722);
    if (paramba == null)
    {
      AppMethodBeat.o(224722);
      return;
    }
    if (this.v == null) {
      this.v = new CopyOnWriteArrayList();
    }
    synchronized (this.w)
    {
      if (!this.v.contains(paramba)) {
        this.v.add(paramba);
      }
      AppMethodBeat.o(224722);
      return;
    }
  }
  
  public final void a(fd paramfd)
  {
    AppMethodBeat.i(225026);
    if (paramfd == null)
    {
      AppMethodBeat.o(225026);
      return;
    }
    synchronized (this.V)
    {
      if (!this.V.contains(paramfd)) {
        this.V.add(paramfd);
      }
      AppMethodBeat.o(225026);
      return;
    }
  }
  
  public final void a(ff paramff)
  {
    AppMethodBeat.i(224779);
    if (paramff == null)
    {
      AppMethodBeat.o(224779);
      return;
    }
    synchronized (this.Y)
    {
      kh.a("skew addSkewListener");
      if (!this.Y.contains(paramff)) {
        this.Y.add(paramff);
      }
      AppMethodBeat.o(224779);
      return;
    }
  }
  
  public final void a(fh paramfh)
  {
    AppMethodBeat.i(225068);
    if (paramfh == null)
    {
      AppMethodBeat.o(225068);
      return;
    }
    synchronized (this.W)
    {
      if (!this.W.contains(paramfh)) {
        this.W.add(paramfh);
      }
      AppMethodBeat.o(225068);
      return;
    }
  }
  
  public final void a(fi paramfi)
  {
    AppMethodBeat.i(225106);
    if (paramfi == null)
    {
      AppMethodBeat.o(225106);
      return;
    }
    synchronized (this.X)
    {
      if (!this.X.contains(paramfi)) {
        this.X.add(paramfi);
      }
      AppMethodBeat.o(225106);
      return;
    }
  }
  
  public final void a(iu paramiu)
  {
    AppMethodBeat.i(224870);
    this.o.e();
    b(paramiu);
    AppMethodBeat.o(224870);
  }
  
  public final void a(oi paramoi)
  {
    AppMethodBeat.i(225089);
    if (paramoi == null)
    {
      AppMethodBeat.o(225089);
      return;
    }
    if (!this.U.contains(paramoi)) {
      this.U.add(paramoi);
    }
    AppMethodBeat.o(225089);
  }
  
  public final void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(224893);
    if (l())
    {
      float f1 = this.z.g().width() / 2.0F;
      float f2 = this.z.g().height() / 2.0F;
      this.z.f().c(f1, f2);
      if (paramRunnable != null) {
        paramRunnable.run();
      }
    }
    AppMethodBeat.o(224893);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(225337);
    if (paramBoolean)
    {
      if (this.ab != null)
      {
        this.ab.run();
        this.ab = null;
      }
      c();
    }
    AppMethodBeat.o(225337);
  }
  
  public final Rect b()
  {
    AppMethodBeat.i(224715);
    Rect localRect = new Rect(this.H, this.I, this.J, this.K);
    AppMethodBeat.o(224715);
    return localRect;
  }
  
  public final void b(double paramDouble)
  {
    AppMethodBeat.i(224859);
    if (kr.a(paramDouble - this.A.p.r()) == 0.0D)
    {
      AppMethodBeat.o(224859);
      return;
    }
    this.A.a((float)paramDouble);
    c();
    D();
    AppMethodBeat.o(224859);
  }
  
  public final void b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(224971);
    this.A.a(paramFloat1 - 0.5F, paramFloat2 - 0.5F, paramBoolean);
    c();
    AppMethodBeat.o(224971);
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(224955);
    if (this.A.a(paramInt))
    {
      Iterator localIterator = this.X.iterator();
      while (localIterator.hasNext())
      {
        fi localfi = (fi)localIterator.next();
        if (localfi != null) {
          try
          {
            localfi.i(paramInt);
          }
          catch (Exception localException) {}
        }
      }
      c();
    }
    AppMethodBeat.o(224955);
  }
  
  public final void b(Rect paramRect)
  {
    AppMethodBeat.i(224982);
    if ((this.C == null) || (paramRect == null))
    {
      AppMethodBeat.o(224982);
      return;
    }
    this.aa = paramRect;
    mk localmk;
    if ((this.z instanceof mk))
    {
      localmk = (mk)this.z;
      if ((localmk.o != null) && (paramRect != null)) {
        break label71;
      }
    }
    for (;;)
    {
      c();
      AppMethodBeat.o(224982);
      return;
      label71:
      localmk.C = paramRect;
      int i1 = localmk.o.width();
      int i2 = localmk.o.height();
      localmk.a(paramRect.left, paramRect.bottom, i1 - paramRect.right - paramRect.left, i2 - paramRect.bottom - paramRect.top, true);
    }
  }
  
  public final void b(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(225140);
    if (!x())
    {
      AppMethodBeat.o(225140);
      return;
    }
    Rect localRect = new Rect(this.C);
    if (paramRect2 != null)
    {
      localRect.left += paramRect2.left;
      localRect.right -= paramRect2.right;
      localRect.top += paramRect2.top;
      localRect.bottom -= paramRect2.bottom;
    }
    a(paramRect1, paramRect2, true);
    U();
    AppMethodBeat.o(225140);
  }
  
  public final void b(GeoPoint paramGeoPoint, float paramFloat, Runnable paramRunnable)
  {
    AppMethodBeat.i(225312);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(225312);
      return;
    }
    this.o.e();
    int i1 = 0;
    double d1 = this.A.b.p;
    double d2 = paramFloat / d1;
    int i2;
    if (d2 > 1.0D)
    {
      i1 = (int)(d2 / 0.5D);
      i2 = 1;
    }
    for (;;)
    {
      int i3 = Math.max(60, Math.min(120, i1 >> 1 << 1));
      d1 = Math.log10(d1) / Math.log10(2.0D);
      d2 = Math.log10(paramFloat) / Math.log10(2.0D);
      GeoPoint localGeoPoint = this.A.m;
      double d3;
      double d4;
      double d5;
      if (i2 != 0)
      {
        i1 = 0;
        while (i1 < i3)
        {
          d3 = Math.pow(2.0D, lu.c(d1, d2, i3, i1 + 1));
          d4 = lu.e(localGeoPoint.getLatitudeE6(), paramGeoPoint.getLatitudeE6(), i3, i1 + 1);
          d5 = lu.e(localGeoPoint.getLongitudeE6(), paramGeoPoint.getLongitudeE6(), i3, i1 + 1);
          kh.a("debug location anim zoomOut:" + d4 + "," + d5);
          b(new iu(120, new double[] { d3, d4, d5 }));
          i1 += 1;
        }
        if (d2 < 1.0D)
        {
          if (d2 != 1.0D)
          {
            i1 = (int)(0.5D / d2);
            i2 = 0;
          }
        }
        else
        {
          b(paramGeoPoint, paramRunnable);
          AppMethodBeat.o(225312);
        }
      }
      else
      {
        i1 = 0;
        while (i1 < i3)
        {
          d3 = Math.pow(2.0D, lu.b(d1, d2, i3, i1 + 1));
          d4 = lu.d(localGeoPoint.getLatitudeE6(), paramGeoPoint.getLatitudeE6(), i3, i1 + 1);
          d5 = lu.d(localGeoPoint.getLongitudeE6(), paramGeoPoint.getLongitudeE6(), i3, i1 + 1);
          kh.a("debug location anim zoomin:" + d4 + "," + d5);
          b(new iu(120, new double[] { d3, d4, d5 }));
          i1 += 1;
        }
        if (paramRunnable != null) {
          b(new iu(paramRunnable));
        }
        AppMethodBeat.o(225312);
        return;
      }
      i2 = 0;
    }
  }
  
  public final void b(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    AppMethodBeat.i(225326);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(225326);
      return;
    }
    this.o.e();
    GeoPoint localGeoPoint = this.A.m;
    double[] arrayOfDouble = ic.a(localGeoPoint.getLatitudeE6(), paramGeoPoint.getLatitudeE6() - localGeoPoint.getLatitudeE6());
    paramGeoPoint = ic.a(localGeoPoint.getLongitudeE6(), paramGeoPoint.getLongitudeE6() - localGeoPoint.getLongitudeE6());
    int i1 = 0;
    while (i1 < 20)
    {
      b(new iu(4, new double[] { arrayOfDouble[i1], paramGeoPoint[i1] }));
      i1 += 1;
    }
    if (paramRunnable != null) {
      b(new iu(paramRunnable));
    }
    AppMethodBeat.o(225326);
  }
  
  public final void b(fd paramfd)
  {
    AppMethodBeat.i(225034);
    synchronized (this.V)
    {
      this.V.remove(paramfd);
      AppMethodBeat.o(225034);
      return;
    }
  }
  
  public final void b(ff paramff)
  {
    AppMethodBeat.i(224788);
    synchronized (this.Y)
    {
      kh.a("skew addSkewListener");
      this.Y.remove(paramff);
      AppMethodBeat.o(224788);
      return;
    }
  }
  
  public final void b(fh paramfh)
  {
    AppMethodBeat.i(225078);
    synchronized (this.W)
    {
      this.W.remove(paramfh);
      AppMethodBeat.o(225078);
      return;
    }
  }
  
  public final void b(fi paramfi)
  {
    AppMethodBeat.i(225117);
    synchronized (this.X)
    {
      this.X.remove(paramfi);
      AppMethodBeat.o(225117);
      return;
    }
  }
  
  public final void b(iu paramiu)
  {
    AppMethodBeat.i(225241);
    this.o.a(paramiu);
    AppMethodBeat.o(225241);
  }
  
  public final void b(oi paramoi)
  {
    AppMethodBeat.i(225096);
    synchronized (this.U)
    {
      this.U.remove(paramoi);
      AppMethodBeat.o(225096);
      return;
    }
  }
  
  public final void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(224902);
    int i1;
    sc localsc;
    if (this.A.b.q > this.A.b.n)
    {
      i1 = 1;
      if (i1 != 0)
      {
        localsc = this.z.f();
        if ((0L != localsc.e) && (localsc.j != null)) {
          break label83;
        }
      }
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(224902);
      return;
      i1 = 0;
      break;
      label83:
      localsc.j.a(new sc.163(localsc));
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(224728);
    if (this.v == null)
    {
      AppMethodBeat.o(224728);
      return;
    }
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      ba localba = (ba)localIterator.next();
      if (localba != null) {
        try
        {
          localba.a(this.A);
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(224728);
  }
  
  public final void c(double paramDouble)
  {
    AppMethodBeat.i(224875);
    this.o.e();
    b(new iu(108, new double[] { paramDouble }));
    AppMethodBeat.o(224875);
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(225046);
    if (paramInt == fv.a)
    {
      AppMethodBeat.o(225046);
      return;
    }
    Iterator localIterator = this.V.iterator();
    while (localIterator.hasNext())
    {
      fd localfd = (fd)localIterator.next();
      if (localfd != null) {
        localfd.b(paramInt);
      }
    }
    c();
    AppMethodBeat.o(225046);
  }
  
  public final void c(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(225150);
    if (paramRect1 == null)
    {
      AppMethodBeat.o(225150);
      return;
    }
    if ((paramRect1.height() > 0) || (paramRect1.width() > 0)) {
      a(paramRect1, paramRect2, false);
    }
    U();
    AppMethodBeat.o(225150);
  }
  
  public final void c(iu paramiu)
  {
    AppMethodBeat.i(225258);
    if (paramiu != null) {
      switch (paramiu.z)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(225258);
      return;
      if ((this.y != null) && (this.y.getMapRenderView() != null))
      {
        this.y.getMapRenderView().d();
        AppMethodBeat.o(225258);
        return;
        b(paramiu.A[0], paramiu.A[1]);
        AppMethodBeat.o(225258);
        return;
        f(paramiu.A[0]);
        AppMethodBeat.o(225258);
        return;
        a((float)paramiu.A[0]);
        AppMethodBeat.o(225258);
        return;
        int i6 = this.z.g().width();
        int i5 = this.z.g().height();
        int i4 = i6 / 2;
        int i3 = i5 / 2;
        v.b localb = this.A.r;
        int i2 = i3;
        int i1 = i4;
        if (localb != null)
        {
          float f1 = i4;
          float f2 = localb.a;
          i1 = (int)(f1 + i6 * f2);
          i2 = (int)(i3 + localb.b * i5);
        }
        double d1 = i1;
        double d2 = paramiu.A[1];
        double d3 = i2;
        double d4 = paramiu.A[2];
        double d5 = paramiu.A[3];
        double d6 = i1;
        double d7 = paramiu.A[4];
        double d8 = i2;
        b(d1 - d2, d3 - d4);
        f(paramiu.A[0]);
        b(d5 - d6, d7 - d8);
        AppMethodBeat.o(225258);
        return;
        e(paramiu.A[0]);
        d(paramiu.A[1]);
        AppMethodBeat.o(225258);
        return;
        i1 = this.z.g().width() / 2;
        i2 = this.z.g().height() / 2;
        b(i1 - paramiu.A[1], i2 - paramiu.A[2]);
        e(paramiu.A[0]);
        b(paramiu.A[3] - i1, paramiu.A[4] - i2);
        AppMethodBeat.o(225258);
        return;
        b(paramiu.A[0]);
        AppMethodBeat.o(225258);
        return;
        a(paramiu.A[0]);
        AppMethodBeat.o(225258);
        return;
        this.A.a(0.0F);
        this.A.b(0.0F);
        D();
        E();
        c();
        AppMethodBeat.o(225258);
        return;
        if (paramiu.A.length > 2) {}
        for (i1 = (int)paramiu.A[2];; i1 = 1)
        {
          a((int)paramiu.A[0], (int)paramiu.A[1], i1);
          AppMethodBeat.o(225258);
          return;
        }
        a((float)paramiu.A[0]);
        a((int)paramiu.A[1], (int)paramiu.A[2], 1);
        AppMethodBeat.o(225258);
        return;
        if (paramiu.E != null)
        {
          paramiu.E.run();
          AppMethodBeat.o(225258);
          return;
          if (this.D != null) {
            this.D.a(paramiu);
          }
        }
      }
    }
  }
  
  public final void d() {}
  
  public final void e()
  {
    AppMethodBeat.i(224739);
    try
    {
      v localv = (v)this.A.clone();
      kh.a("mapParam stack saveMapParam:" + localv.toString());
      this.Z.push(localv);
      AppMethodBeat.o(224739);
      return;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AppMethodBeat.o(224739);
    }
  }
  
  public final void f()
  {
    AppMethodBeat.i(224755);
    try
    {
      v localv1 = (v)this.Z.pop();
      if (localv1.b.q != this.A.b.q) {
        c(fv.c);
      }
      for (;;)
      {
        if (localv1.p.r() != this.A.p.r())
        {
          localv1.p.r();
          D();
        }
        if (localv1.p.q() != this.A.p.q())
        {
          localv1.p.q();
          E();
        }
        v localv2 = this.A;
        localv2.a = localv1.a;
        v.a locala1 = localv2.b;
        v.a locala2 = localv1.b;
        locala1.l = locala2.l;
        locala1.m = locala2.m;
        locala1.n = locala2.n;
        locala1.o = locala2.o;
        locala1.p = locala2.p;
        locala1.q = locala2.q;
        localv2.c.set(localv1.c);
        localv2.d = localv1.d;
        localv2.e = localv1.e;
        localv2.f = localv1.f;
        localv2.g = localv1.g;
        localv2.h = localv1.h;
        localv2.i = localv1.i;
        localv2.j = localv1.j;
        localv2.k = localv1.k;
        localv2.l = localv1.l;
        localv2.m.setGeoPoint(localv1.m);
        localv2.q.a(localv1.q.a, localv1.q.b);
        localv2.n = localv1.n;
        c();
        AppMethodBeat.o(224755);
        return;
        if (localv1.b.p != this.A.b.p) {
          c(fv.b);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(224755);
    }
  }
  
  public final v g()
  {
    AppMethodBeat.i(224771);
    try
    {
      v localv = (v)this.A.clone();
      AppMethodBeat.o(224771);
      return localv;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AppMethodBeat.o(224771);
    }
    return null;
  }
  
  public final float h()
  {
    AppMethodBeat.i(224832);
    float f1 = this.A.p.r();
    AppMethodBeat.o(224832);
    return f1;
  }
  
  public final float i()
  {
    AppMethodBeat.i(224841);
    float f1 = this.A.p.q();
    AppMethodBeat.o(224841);
    return f1;
  }
  
  public final void j()
  {
    AppMethodBeat.i(224911);
    this.o.e();
    a(0.0D, 0.0D, true);
    AppMethodBeat.o(224911);
  }
  
  public final boolean k()
  {
    AppMethodBeat.i(224937);
    if ((Math.abs(i()) > 1.0E-006D) || (Math.abs(h()) > 1.0F))
    {
      AppMethodBeat.o(224937);
      return true;
    }
    AppMethodBeat.o(224937);
    return false;
  }
  
  public final boolean l()
  {
    return this.A.b.q < this.A.b.o;
  }
  
  public final int m()
  {
    AppMethodBeat.i(224992);
    v localv = this.A;
    if (localv.p == null)
    {
      i1 = localv.a;
      AppMethodBeat.o(224992);
      return i1;
    }
    int i1 = localv.p.s();
    AppMethodBeat.o(224992);
    return i1;
  }
  
  public final void n()
  {
    AppMethodBeat.i(225004);
    b(this.aa);
    Iterator localIterator = this.U.iterator();
    while (localIterator.hasNext())
    {
      oi localoi = (oi)localIterator.next();
      if (localoi != null) {
        try
        {
          localoi.a();
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(225004);
  }
  
  public final void o()
  {
    AppMethodBeat.i(225015);
    if (this.s == null)
    {
      AppMethodBeat.o(225015);
      return;
    }
    k();
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext()) {
      if ((ex)localIterator.next() != null) {}
    }
    AppMethodBeat.o(225015);
  }
  
  public final void p()
  {
    AppMethodBeat.i(225056);
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext()) {
      if ((fc)localIterator.next() != null) {}
    }
    AppMethodBeat.o(225056);
  }
  
  public final Rect q()
  {
    AppMethodBeat.i(225194);
    Object localObject2 = new fl(this.z.g().width(), this.z.g().height());
    Object localObject1 = this.B.a((fl)localObject2);
    ((fl)localObject2).a(0.0D, 0.0D);
    localObject2 = this.B.a((fl)localObject2);
    localObject1 = new Rect(Math.min(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject1).getLongitudeE6()), Math.min(((GeoPoint)localObject2).getLatitudeE6(), ((GeoPoint)localObject1).getLatitudeE6()), Math.max(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject1).getLongitudeE6()), Math.max(((GeoPoint)localObject2).getLatitudeE6(), ((GeoPoint)localObject1).getLatitudeE6()));
    AppMethodBeat.o(225194);
    return localObject1;
  }
  
  public final Rect r()
  {
    AppMethodBeat.i(225211);
    if (this.B == null)
    {
      AppMethodBeat.o(225211);
      return null;
    }
    int i1 = this.H;
    int i2 = this.I;
    Object localObject2 = new fl(i1, i2);
    Object localObject1 = this.B.a((fl)localObject2);
    i1 = this.z.g().width();
    i2 = this.J;
    int i3 = this.z.g().height();
    int i4 = this.K;
    ((fl)localObject2).a(i1 - i2, i3 - i4);
    localObject2 = this.B.a((fl)localObject2);
    localObject1 = new Rect(Math.min(((GeoPoint)localObject1).getLongitudeE6(), ((GeoPoint)localObject2).getLongitudeE6()), Math.min(((GeoPoint)localObject1).getLatitudeE6(), ((GeoPoint)localObject2).getLatitudeE6()), Math.max(((GeoPoint)localObject1).getLongitudeE6(), ((GeoPoint)localObject2).getLongitudeE6()), Math.max(((GeoPoint)localObject1).getLatitudeE6(), ((GeoPoint)localObject2).getLatitudeE6()));
    AppMethodBeat.o(225211);
    return localObject1;
  }
  
  public final GeoPoint s()
  {
    AppMethodBeat.i(225219);
    Object localObject = new fl(0.0D, 0.0D);
    localObject = this.B.a((fl)localObject);
    AppMethodBeat.o(225219);
    return localObject;
  }
  
  public final GeoPoint t()
  {
    AppMethodBeat.i(225226);
    Object localObject = new fl(this.z.g().width(), this.z.g().height());
    localObject = this.B.a((fl)localObject);
    AppMethodBeat.o(225226);
    return localObject;
  }
  
  public final void u()
  {
    AppMethodBeat.i(225271);
    Iterator localIterator = this.W.iterator();
    while (localIterator.hasNext())
    {
      fh localfh = (fh)localIterator.next();
      if (localfh != null) {
        try
        {
          localfh.u();
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(225271);
  }
  
  public static abstract interface a
  {
    public abstract void a(iu paramiu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ac
 * JD-Core Version:    0.7.0.1
 */