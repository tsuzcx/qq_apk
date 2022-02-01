package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

class g
  extends w
{
  private List<v.c> C = null;
  private List<v.c> D = null;
  private List<v.a> E = null;
  private List<v.a> F = null;
  private a G = new a()
  {
    public void a()
    {
      if (g.this.f == null) {
        return;
      }
      g.this.f.b();
    }
  };
  byte[] a = new byte[0];
  boolean b = false;
  PaintFlagsDrawFilter c = null;
  int d = 0;
  boolean e = false;
  
  private ArrayList<v.a> a(ArrayList<v.b> paramArrayList, int paramInt, boolean paramBoolean)
  {
    this.b = false;
    this.e = true;
    Object localObject1;
    if (paramArrayList == null)
    {
      localObject1 = null;
      return localObject1;
    }
    if (!this.l) {
      return null;
    }
    if ((paramInt > this.i) || (paramInt < this.j)) {
      return null;
    }
    int j = paramArrayList.size();
    if (j <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      localObject1 = localArrayList;
      if (paramInt >= j) {
        break;
      }
      localObject1 = (v.b)paramArrayList.get(paramInt);
      if (localObject1 != null) {
        break label103;
      }
      paramInt += 1;
    }
    label103:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((v.b)localObject1).a);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(((v.b)localObject1).b);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(((v.b)localObject1).c);
    localObject2 = this.u.a(((StringBuilder)localObject2).toString());
    v.c localc = new v.c(((v.b)localObject1).a, ((v.b)localObject1).b, ((v.b)localObject1).c);
    localc.e = ((v.b)localObject1).e;
    localc.f = ((v.b)localObject1).f;
    if (localObject2 != null)
    {
      localc.g = ((e.a)localObject2).a;
      label234:
      this.w.add(localc);
      if (localc.g != null) {
        break label325;
      }
    }
    label325:
    for (int i = 1;; i = 0)
    {
      if (i == 1) {
        this.b = true;
      }
      if ((!paramBoolean) && (i == 1)) {
        localArrayList.add(new v.a(((v.b)localObject1).a, ((v.b)localObject1).b, ((v.b)localObject1).c));
      }
      break;
      if (this.e != true) {
        break label234;
      }
      this.e = false;
      break label234;
    }
  }
  
  private void a(List<v.b> paramList, List<v.a> paramList1, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.l) || (paramInt > this.i) || (paramInt < this.j));
      i = paramList.size();
    } while (i <= 0);
    paramInt = 0;
    label47:
    v.b localb;
    if (paramInt < i)
    {
      localb = (v.b)paramList.get(paramInt);
      if (localb != null) {
        break label77;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label47;
      break;
      label77:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localb.a);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(localb.b);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(localb.c);
      localObject = this.u.a(((StringBuilder)localObject).toString());
      v.c localc = new v.c(localb.a, localb.b, localb.c);
      if (localObject != null) {
        localc.g = ((e.a)localObject).a;
      }
      localc.e = localb.e;
      localc.f = localb.f;
      this.D.add(localc);
      if ((!paramBoolean) && (localc.g == null)) {
        paramList1.add(0, new v.a(localb.a, localb.b, localb.c));
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Point paramPoint)
  {
    paramFloat1 = paramFloat4 * paramFloat3 * (paramFloat1 - paramPoint.x) + paramPoint.x;
    paramFloat2 = paramFloat4 * paramFloat3 * (paramFloat2 - paramPoint.y) + paramPoint.y;
    paramFloat3 = 256.0F * paramFloat4 * paramFloat3;
    if ((paramFloat1 > this.f.a.e()) || (paramFloat1 < -paramFloat3)) {}
    while ((paramFloat2 > this.f.a.f()) || (paramFloat2 < -paramFloat3)) {
      return false;
    }
    return true;
  }
  
  private void b(List<v.a> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    synchronized (this.a)
    {
      if (this.F == null) {
        return;
      }
    }
    if (paramBoolean == true) {
      this.F.clear();
    }
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        v.a locala = (v.a)paramList.get(i);
        if ((locala != null) && (!a(this.E, locala))) {
          this.F.add(locala);
        }
      }
      else
      {
        d();
        return;
      }
      i += 1;
    }
  }
  
  private void d(Canvas paramCanvas)
  {
    if (this.C == null) {}
    int j;
    do
    {
      return;
      j = this.C.size();
    } while (j <= 0);
    RectF localRectF = new RectF();
    Point localPoint = this.f.c.c();
    int i = 0;
    label47:
    v.c localc;
    if (i < j)
    {
      localc = (v.c)this.C.get(i);
      if (localc != null) {
        break label80;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label80:
      if (localc.i)
      {
        Bitmap localBitmap = localc.g;
        if (localBitmap != null)
        {
          float f = localc.h;
          Matrix localMatrix = new Matrix();
          localMatrix.setScale(f, f, localPoint.x, localPoint.y);
          paramCanvas.save();
          paramCanvas.concat(localMatrix);
          localRectF.left = localc.e;
          localRectF.right = (localRectF.left + localBitmap.getWidth());
          localRectF.top = localc.f;
          localRectF.bottom = (localRectF.top + localBitmap.getHeight());
          q.a(paramCanvas, localBitmap, localRectF);
          paramCanvas.restore();
        }
      }
    }
  }
  
  private boolean d(v.a parama)
  {
    if (parama == null) {
      return false;
    }
    boolean bool = this.v.a(parama, this.G);
    f(parama);
    return bool;
  }
  
  private boolean e(v.a parama)
  {
    if (this.E == null) {}
    while (this.E.contains(parama) == true) {
      return false;
    }
    return this.E.add(parama);
  }
  
  private boolean f(v.a parama)
  {
    synchronized (this.a)
    {
      if (this.E == null) {
        return false;
      }
      boolean bool = this.E.remove(parama);
      return bool;
    }
  }
  
  private v.a m()
  {
    synchronized (this.a)
    {
      if (this.F == null) {
        return null;
      }
      if (this.F.size() <= 0) {
        return null;
      }
    }
    v.a locala = (v.a)this.F.remove(0);
    e(locala);
    int i = this.F.size();
    if (i > 0) {
      d();
    }
    return locala;
  }
  
  private void n()
  {
    this.d = 0;
    if (this.C == null) {}
    int i2;
    do
    {
      return;
      i2 = this.C.size();
    } while (i2 <= 0);
    float f3 = this.f.a.b();
    Point localPoint = this.f.c.c();
    int j = -1;
    PointF localPointF = null;
    int n = -1;
    int m = -1;
    float f2 = 0.0F;
    float f1 = 0.0F;
    int k = 0;
    int i = 0;
    if (i < i2)
    {
      v.c localc = (v.c)this.C.get(i);
      int i1;
      int i5;
      int i4;
      int i3;
      if (localc == null)
      {
        i1 = i2;
        i5 = k;
        i4 = m;
        i3 = n;
      }
      for (;;)
      {
        i += 1;
        n = i3;
        m = i4;
        k = i5;
        i2 = i1;
        break;
        if (localc.c == this.f.c.e)
        {
          localc.g = null;
          this.C.remove(i);
          i -= 1;
          i1 = i2 - 1;
          i3 = n;
          i4 = m;
          i5 = k;
        }
        else
        {
          e.a locala = this.u.a(localc.toString());
          if (locala == null)
          {
            localc.g = null;
            this.C.remove(i);
            i -= 1;
            i1 = i2 - 1;
            i3 = n;
            i4 = m;
            i5 = k;
          }
          else
          {
            localc.g = locala.a;
            i1 = n;
            n = m;
            m = k;
            k = j;
            if (j != localc.c)
            {
              localPointF = this.f.c.a(this.f.c.d(), localc.c);
              i1 = (int)Math.floor(localPointF.x / 256.0F);
              n = (int)Math.floor(localPointF.y / 256.0F);
              f2 = localPoint.x - localPointF.x % 256.0F;
              f1 = localPoint.y - (256.0F - localPointF.y % 256.0F);
              k = localc.c;
              m = (int)Math.pow(2.0D, localc.c + 1);
            }
            this.f.c.a(localc, localPointF, i1, n, f2, f1, m);
            j = localc.c;
            float f4 = (float)Math.pow(2.0D, this.f.c.e - j);
            boolean bool = a(localc.e, localc.f, f4, f3, localPoint);
            localc.h = f4;
            localc.i = bool;
            if (!localc.i)
            {
              localc.g = null;
              i3 = i1;
              i4 = n;
              i5 = m;
              j = k;
              i1 = i2;
            }
            else
            {
              this.d += 1;
              i3 = i1;
              i4 = n;
              i5 = m;
              j = k;
              i1 = i2;
            }
          }
        }
      }
    }
  }
  
  protected void a()
  {
    super.a();
    synchronized (this.a)
    {
      this.E.clear();
      this.F.clear();
      return;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.c == null) {
      this.c = new PaintFlagsDrawFilter(0, 2);
    }
    paramCanvas.setDrawFilter(this.c);
    super.a(paramCanvas);
    paramCanvas.setDrawFilter(null);
  }
  
  protected void a(ArrayList<v.b> arg1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (??? == null) {
      return;
    }
    Object localObject1 = ???;
    if (???.size() == 0) {
      localObject1 = this.f.c.a(this.f.a.g(), this.f.a.e(), this.f.a.f(), this.f.a.b());
    }
    a(this.w);
    a(this.D);
    for (;;)
    {
      synchronized (this.A)
      {
        this.z.clear();
        n();
        paramBoolean2 = this.f.a.c;
        ??? = a((ArrayList)localObject1, this.f.a.g(), paramBoolean1);
        if (paramBoolean2 == true)
        {
          int j = this.f.a.g() - 2;
          int i = j;
          if (j < this.f.a.d()) {
            i = this.f.a.d();
          }
          if (i != this.f.a.g()) {
            a(this.f.c.b(i, this.f.a.e(), this.f.a.f(), this.f.a.b()), ???, i, paramBoolean1);
          }
        }
        if ((??? != null) && (???.size() > 0))
        {
          if (this.m == true)
          {
            a(null, true);
            b(???, true);
          }
        }
        else
        {
          if (??? == null) {
            break;
          }
          ???.clear();
          return;
        }
      }
      a(???, true);
    }
  }
  
  protected void b()
  {
    super.b();
    this.v.a(null);
    synchronized (this.a)
    {
      this.E.clear();
      this.E = null;
      this.F.clear();
      this.F = null;
      return;
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (this.e == true) {}
    int j;
    do
    {
      do
      {
        return;
        d(paramCanvas);
      } while (!this.b);
      j = this.D.size();
    } while (j <= 0);
    Object localObject1 = new Matrix();
    int i = ((v.c)this.D.get(0)).c;
    float f = (float)Math.pow(2.0D, this.f.c.e - i);
    Object localObject2 = this.f.c.c();
    ((Matrix)localObject1).setScale(f, f, ((Point)localObject2).x, ((Point)localObject2).y);
    paramCanvas.save();
    paramCanvas.concat((Matrix)localObject1);
    RectF localRectF = new RectF();
    i = 0;
    if (i < j)
    {
      v.c localc = (v.c)this.D.get(i);
      if (localc == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = localc.g;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          a(localc);
          localObject1 = localc.g;
        }
        if (localObject1 != null)
        {
          localRectF.left = localc.e;
          localRectF.right = (localRectF.left + ((Bitmap)localObject1).getWidth());
          localRectF.top = localc.f;
          localRectF.bottom = (localRectF.top + ((Bitmap)localObject1).getHeight());
          q.a(paramCanvas, (Bitmap)localObject1, localRectF);
        }
      }
    }
    paramCanvas.restore();
  }
  
  protected void c()
  {
    if (this.g == true) {}
    v.a locala;
    do
    {
      return;
      locala = m();
    } while (locala == null);
    if (d(locala) == true)
    {
      a(locala);
      return;
    }
    a(locala, null, false);
  }
  
  void d()
  {
    if (this.f != null) {
      this.f.f();
    }
  }
  
  protected void e()
  {
    this.w = new ArrayList();
    this.D = new ArrayList();
    this.C = new ArrayList();
    this.E = new ArrayList();
    this.x = new ArrayList();
    this.F = new ArrayList();
    this.y = new ArrayList();
    this.z = new ArrayList();
    this.a = new byte[0];
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    return this.h.equals(paramObject.h);
  }
  
  protected int f()
  {
    return 16;
  }
  
  protected void g()
  {
    if (this.C == null) {
      return;
    }
    int j = this.D.size();
    int i;
    v.c localc;
    if (j > 0)
    {
      i = 0;
      if (i < j)
      {
        localc = (v.c)this.D.get(i);
        if (localc == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localc.g != null) && (!this.C.contains(localc))) {
            this.C.add(localc);
          }
        }
      }
    }
    j = this.w.size();
    if (j > 0)
    {
      i = 0;
      if (i < j)
      {
        localc = (v.c)this.w.get(i);
        if (localc == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localc.g != null) && (!this.C.contains(localc))) {
            this.C.add(localc);
          }
        }
      }
    }
    a(this.w);
    a(this.D);
  }
  
  public int hashCode()
  {
    return this.p;
  }
  
  public String toString()
  {
    return this.h;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.g
 * JD-Core Version:    0.7.0.1
 */