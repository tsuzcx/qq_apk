package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.ViewConfiguration;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class pk
  implements es
{
  private static final int i = 8;
  private static final float j = 10.0F;
  boolean a;
  public pn b;
  public boolean c;
  public az d;
  private final long e;
  private final long f;
  private float g;
  private float h;
  private bd k;
  private float l;
  private float m;
  private final float n;
  
  public pk(bd parambd)
  {
    AppMethodBeat.i(225302);
    this.e = 250L;
    this.f = 1200L;
    this.g = ViewConfiguration.getMinimumFlingVelocity();
    this.h = ViewConfiguration.getMaximumFlingVelocity();
    this.c = false;
    this.k = parambd;
    this.d = ((az)parambd.b());
    if (this.d != null)
    {
      this.d.a(this);
      Object localObject = this.d.G();
      if (localObject != null)
      {
        localObject = ViewConfiguration.get((Context)localObject);
        this.g = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
        this.h = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
      }
    }
    this.b = new pn();
    this.n = (parambd.h() * 2.5F);
    AppMethodBeat.o(225302);
  }
  
  private void a(pn parampn)
  {
    AppMethodBeat.i(225313);
    this.b = parampn;
    boolean bool = parampn.a();
    if (this.d == null)
    {
      AppMethodBeat.o(225313);
      return;
    }
    if (bool)
    {
      this.d.b(this);
      AppMethodBeat.o(225313);
      return;
    }
    this.d.a(this);
    AppMethodBeat.o(225313);
  }
  
  private boolean e()
  {
    boolean bool = this.c;
    this.c = false;
    return bool;
  }
  
  private void l(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225340);
    this.c = true;
    if (this.a)
    {
      AppMethodBeat.o(225340);
      return;
    }
    float f1 = paramFloat1 / 64.0F;
    float f2 = paramFloat2 / 64.0F;
    if ((Math.abs(f1) < this.n) && (Math.abs(f2) < this.n))
    {
      AppMethodBeat.o(225340);
      return;
    }
    long l1 = ((Math.max(Math.abs(paramFloat1), Math.abs(paramFloat2)) - this.g) / (this.h - this.g) * 950.0F);
    Object localObject = new PointF(f1, f2);
    final long l2 = System.currentTimeMillis();
    this.a = true;
    localObject = new iu(new double[] { 0.0D, 0.0D }, l2)
    {
      public final boolean a()
      {
        AppMethodBeat.i(225217);
        long l = System.currentTimeMillis() - l2;
        if (l > this.b)
        {
          pk.this.a = false;
          AppMethodBeat.o(225217);
          return true;
        }
        double d1;
        if (this.c.x != 0.0F)
        {
          d1 = ir.a(l, this.c.x, -this.c.x, this.b);
          this.A[0] = d1;
        }
        if (this.c.y != 0.0F)
        {
          d1 = ir.a(l, this.c.y, -this.c.y, this.b);
          this.A[1] = d1;
        }
        AppMethodBeat.o(225217);
        return false;
      }
      
      public final void b()
      {
        pk.this.a = false;
      }
    };
    this.k.a().a((iu)localObject);
    AppMethodBeat.o(225340);
  }
  
  private boolean m(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225353);
    Object localObject = this.k.c();
    if (((bi)localObject).d.h.a(paramFloat1, paramFloat2))
    {
      AppMethodBeat.o(225353);
      return true;
    }
    TappedElement localTappedElement = ((bi)localObject).a.f().a(paramFloat1, paramFloat2);
    if (localTappedElement != null)
    {
      if ((localTappedElement.type == 1) && (((bi)localObject).e != null))
      {
        new fq(localTappedElement.name, jz.a(localTappedElement.pixelX, localTappedElement.pixelY));
        AppMethodBeat.o(225353);
        return true;
      }
      if ((localTappedElement.type == 6) && (((bi)localObject).f != null))
      {
        localObject = ((bi)localObject).f.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Iterator)localObject).next();
        }
        AppMethodBeat.o(225353);
        return true;
      }
    }
    AppMethodBeat.o(225353);
    return false;
  }
  
  public final void a() {}
  
  public final boolean a(float paramFloat)
  {
    AppMethodBeat.i(225482);
    if (this.b.d())
    {
      double d1 = paramFloat / 8.0F * 2.0F;
      ac localac = this.k.a();
      localac.o.e();
      localac.b(new iu(102, new double[] { 0.0D, d1 }));
      AppMethodBeat.o(225482);
      return true;
    }
    AppMethodBeat.o(225482);
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225373);
    final ac localac;
    Runnable local1;
    if (this.b.f())
    {
      localac = this.k.a();
      local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224887);
          localac.p();
          AppMethodBeat.o(224887);
        }
      };
      if (localac.L)
      {
        v.b localb = localac.A.r;
        if (localb == null) {
          break label140;
        }
        paramFloat1 = localac.z.g().width() * (localb.a + 0.5F);
        paramFloat2 = localac.z.g().height() * (localb.b + 0.5F);
      }
      if (localac.l())
      {
        localac.z.f().c(paramFloat1, paramFloat2);
        local1.run();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(225373);
      return false;
      label140:
      localac.a(local1);
    }
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(225516);
    if (this.b.j())
    {
      paramDouble1 = paramDouble2 / paramDouble1;
      final ac localac = this.k.a();
      localac.a(paramDouble1, paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224751);
          localac.p();
          AppMethodBeat.o(224751);
        }
      });
    }
    AppMethodBeat.o(225516);
    return false;
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(225510);
    if (this.b.e())
    {
      ac localac = this.k.a();
      double d1 = paramFloat;
      double d2 = paramPointF1.x;
      double d3 = paramPointF1.y;
      double d4 = paramPointF2.x;
      double d5 = paramPointF2.y;
      localac.o.e();
      localac.b(new iu(103, new double[] { d1, d2, d3, d4, d5 }));
    }
    AppMethodBeat.o(225510);
    return false;
  }
  
  public final boolean b()
  {
    AppMethodBeat.i(225467);
    kl.a(new Object[0]);
    if (this.b.i())
    {
      final ac localac = this.k.a();
      localac.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224804);
          localac.p();
          AppMethodBeat.o(224804);
        }
      });
    }
    AppMethodBeat.o(225467);
    return false;
  }
  
  public final boolean b(float paramFloat)
  {
    return false;
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225385);
    if (this.b.g())
    {
      Object localObject = this.k.c();
      if (((bi)localObject).d.h.a(paramFloat1, paramFloat2))
      {
        AppMethodBeat.o(225385);
        return true;
      }
      TappedElement localTappedElement = ((bi)localObject).a.f().a(paramFloat1, paramFloat2);
      if (localTappedElement != null)
      {
        if ((localTappedElement.type == 1) && (((bi)localObject).e != null))
        {
          new fq(localTappedElement.name, jz.a(localTappedElement.pixelX, localTappedElement.pixelY));
          AppMethodBeat.o(225385);
          return true;
        }
        if ((localTappedElement.type == 6) && (((bi)localObject).f != null))
        {
          localObject = ((bi)localObject).f.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Iterator)localObject).next();
          }
          AppMethodBeat.o(225385);
          return true;
        }
      }
      AppMethodBeat.o(225385);
      return false;
    }
    AppMethodBeat.o(225385);
    return false;
  }
  
  public final boolean c()
  {
    AppMethodBeat.i(225476);
    if (this.a)
    {
      this.k.a().o.e();
      this.a = false;
    }
    AppMethodBeat.o(225476);
    return false;
  }
  
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225406);
    if ((this.b.b()) && (this.b.c()))
    {
      this.c = true;
      if (!this.a)
      {
        float f1 = paramFloat1 / 64.0F;
        float f2 = paramFloat2 / 64.0F;
        if ((Math.abs(f1) >= this.n) || (Math.abs(f2) >= this.n))
        {
          long l1 = ((Math.max(Math.abs(paramFloat1), Math.abs(paramFloat2)) - this.g) / (this.h - this.g) * 950.0F);
          Object localObject = new PointF(f1, f2);
          long l2 = System.currentTimeMillis();
          this.a = true;
          localObject = new iu(new double[] { 0.0D, 0.0D }, l2)
          {
            public final boolean a()
            {
              AppMethodBeat.i(225217);
              long l = System.currentTimeMillis() - l2;
              if (l > this.b)
              {
                pk.this.a = false;
                AppMethodBeat.o(225217);
                return true;
              }
              double d1;
              if (this.c.x != 0.0F)
              {
                d1 = ir.a(l, this.c.x, -this.c.x, this.b);
                this.A[0] = d1;
              }
              if (this.c.y != 0.0F)
              {
                d1 = ir.a(l, this.c.y, -this.c.y, this.b);
                this.A[1] = d1;
              }
              AppMethodBeat.o(225217);
              return false;
            }
            
            public final void b()
            {
              pk.this.a = false;
            }
          };
          this.k.a().a((iu)localObject);
        }
      }
    }
    AppMethodBeat.o(225406);
    return false;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225416);
    if (this.b.b())
    {
      ac localac = this.k.a();
      if (localac.z != null)
      {
        sc localsc = localac.z.f();
        if (localsc != null)
        {
          localsc.b(paramFloat1, paramFloat2);
          localac.c();
        }
      }
    }
    AppMethodBeat.o(225416);
    return false;
  }
  
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean f(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225432);
    if (this.b.f())
    {
      this.l = this.k.a().A.b.p;
      this.m = paramFloat2;
    }
    AppMethodBeat.o(225432);
    return false;
  }
  
  public final boolean g(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225447);
    kl.a(new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (this.b.f()) {
      this.k.a().c(Math.pow(2.0D, 10.0F * (this.m - paramFloat2) / this.k.g().height()) * this.l);
    }
    AppMethodBeat.o(225447);
    return true;
  }
  
  public final boolean h(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean i(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225523);
    this.k.a().o.e();
    AppMethodBeat.o(225523);
    return false;
  }
  
  public final boolean j(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean k(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pk
 * JD-Core Version:    0.7.0.1
 */