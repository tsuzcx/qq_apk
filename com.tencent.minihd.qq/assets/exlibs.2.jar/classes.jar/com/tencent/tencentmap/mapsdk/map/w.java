package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

class w
  extends i
{
  byte[] A = new byte[0];
  byte[] B = new byte[0];
  protected d u = null;
  protected k v = null;
  protected List<v.c> w = null;
  protected List<v.a> x = null;
  protected List<v.a> y = null;
  protected List<v.a> z = null;
  
  private ArrayList<v.a> a(ArrayList<v.b> paramArrayList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if (paramArrayList == null) {
      localObject1 = localArrayList;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject1;
              localObject1 = localArrayList;
            } while (!this.l);
            localObject1 = localArrayList;
          } while (paramInt > this.i);
          localObject1 = localArrayList;
        } while (paramInt < this.j);
        i = paramArrayList.size();
        localObject1 = localArrayList;
      } while (i <= 0);
      localArrayList = new ArrayList();
      paramInt = 0;
      localObject1 = localArrayList;
    } while (paramInt >= i);
    Object localObject1 = (v.b)paramArrayList.get(paramInt);
    if (localObject1 == null) {}
    for (;;)
    {
      paramInt += 1;
      break;
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
      if (localObject2 != null) {
        localc.g = ((e.a)localObject2).a;
      }
      this.w.add(localc);
      if ((!paramBoolean) && (localc.g == null)) {
        localArrayList.add(new v.a(((v.b)localObject1).a, ((v.b)localObject1).b, ((v.b)localObject1).c));
      }
    }
  }
  
  protected void a()
  {
    this.u.a();
    synchronized (this.A)
    {
      this.z.clear();
    }
    synchronized (this.B)
    {
      this.y.clear();
      this.x.clear();
      if (this.w != null)
      {
        int j = this.w.size();
        int i = 0;
        while (i < j)
        {
          ??? = (v.c)this.w.remove(0);
          if (??? != null) {
            ((v.c)???).g = null;
          }
          i += 1;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    int j = this.w.size();
    if (j <= 0) {
      return;
    }
    RectF localRectF = new RectF();
    int i = 0;
    label26:
    v.c localc;
    if (i < j)
    {
      localc = (v.c)this.w.get(i);
      if (localc != null) {
        break label58;
      }
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label58:
      Bitmap localBitmap2 = localc.g;
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        a(localc);
        localBitmap1 = localc.g;
      }
      if (localBitmap1 != null)
      {
        localRectF.left = localc.e;
        localRectF.right = (localRectF.left + localBitmap1.getWidth());
        localRectF.top = localc.f;
        localRectF.bottom = (localRectF.top + localBitmap1.getHeight());
        q.a(paramCanvas, localBitmap1, localRectF);
      }
    }
  }
  
  void a(v.a parama)
  {
    if (parama == null) {}
    while (this.z == null) {
      return;
    }
    synchronized (this.A)
    {
      this.z.add(parama);
      l();
      Thread.yield();
      return;
    }
  }
  
  protected void a(v.a parama, ArrayList<v.a> paramArrayList, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      synchronized (this.B)
      {
        if (this.y == null) {
          return;
        }
        if (paramBoolean == true) {
          this.y.clear();
        }
        if (paramArrayList != null)
        {
          int j = paramArrayList.size();
          i = 0;
          if (i < j)
          {
            v.a locala = (v.a)paramArrayList.get(i);
            if ((locala == null) || (a(this.x, locala))) {
              break label142;
            }
            this.y.add(locala);
          }
        }
      }
      if ((parama != null) && (!a(this.x, parama))) {
        this.y.add(parama);
      }
      k();
      return;
      label142:
      i += 1;
    }
  }
  
  protected void a(v.c paramc)
  {
    if (paramc == null) {}
    while (this.z == null) {
      return;
    }
    int j;
    synchronized (this.A)
    {
      j = this.z.size();
      if (j <= 0) {
        return;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        v.a locala = (v.a)this.z.get(i);
        if (locala == null) {
          return;
        }
        try
        {
          if (!locala.equals(paramc)) {
            break label159;
          }
          paramc.g = this.u.a(paramc.toString()).a;
          boolean bool = this.z.remove(locala);
          int m = i;
          int k = j;
          if (bool == true)
          {
            m = i - 1;
            k = j - 1;
          }
          i = m;
          j = k;
        }
        catch (Exception localException) {}
      }
      else
      {
        return;
      }
      label159:
      i += 1;
    }
  }
  
  protected void a(ArrayList<v.b> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList == null) {
      return;
    }
    a(this.w);
    for (;;)
    {
      synchronized (this.A)
      {
        this.z.clear();
        int i = this.f.a.g();
        if ((i > this.i) || (i < this.j)) {
          break;
        }
        ??? = paramArrayList;
        if (paramArrayList.size() == 0) {
          ??? = this.f.c.a(i, this.f.a.e(), this.f.a.f(), this.f.a.b());
        }
        paramArrayList = a((ArrayList)???, this.f.a.g(), paramBoolean1);
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          if (this.m == true) {
            a(null, true);
          }
        }
        else
        {
          if (paramArrayList == null) {
            break;
          }
          paramArrayList.clear();
          return;
        }
      }
      a(paramArrayList, true);
    }
  }
  
  protected void a(List<v.c> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        v.c localc = (v.c)paramList.remove(0);
        if (localc != null) {
          localc.g = null;
        }
        i += 1;
      }
    }
  }
  
  protected void a(List<v.a> paramList, boolean paramBoolean)
  {
    synchronized (this.B)
    {
      if (this.y == null) {
        return;
      }
      if (paramBoolean == true) {
        this.y.clear();
      }
      if (paramList == null) {
        return;
      }
    }
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        v.a locala = (v.a)paramList.get(i);
        if ((locala != null) && (!a(this.x, locala))) {
          this.y.add(locala);
        }
      }
      else
      {
        k();
        return;
      }
      i += 1;
    }
  }
  
  protected boolean a(List<v.a> paramList, v.a parama)
  {
    if ((paramList == null) || (parama == null)) {}
    int j;
    do
    {
      return false;
      j = paramList.size();
    } while (j <= 0);
    int i = 0;
    label25:
    v.a locala;
    if (i < j)
    {
      locala = (v.a)paramList.get(i);
      if (locala != null) {
        break label55;
      }
    }
    label55:
    while (!locala.equals(parama))
    {
      i += 1;
      break label25;
      break;
    }
    return true;
  }
  
  protected void b()
  {
    this.g = true;
    this.u.a();
    synchronized (this.A)
    {
      this.z.clear();
    }
    synchronized (this.B)
    {
      this.y.clear();
      this.y = null;
      this.x.clear();
      this.x = null;
      if (this.w == null) {
        return;
      }
      int j = this.w.size();
      int i = 0;
      while (i < j)
      {
        ??? = (v.c)this.w.remove(0);
        if (??? != null) {
          ((v.c)???).g = null;
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
    }
    this.w = null;
  }
  
  protected void b(Canvas paramCanvas) {}
  
  protected boolean b(v.a parama)
  {
    if (this.x == null) {}
    while (this.x.contains(parama) == true) {
      return false;
    }
    return this.x.add(parama);
  }
  
  protected void c() {}
  
  protected void c(Canvas paramCanvas)
  {
    if (this.w == null) {
      return;
    }
    b(paramCanvas);
    a(paramCanvas);
  }
  
  protected boolean c(v.a parama)
  {
    synchronized (this.B)
    {
      if (this.x == null) {
        return false;
      }
      if (!this.x.contains(parama)) {
        return false;
      }
    }
    boolean bool = this.x.remove(parama);
    return bool;
  }
  
  protected void e()
  {
    this.w = new ArrayList();
    this.x = new ArrayList();
    this.y = new ArrayList();
    this.z = new ArrayList();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof w)) {
      return false;
    }
    paramObject = (w)paramObject;
    return this.h.equals(paramObject.h);
  }
  
  protected int f()
  {
    return 10;
  }
  
  protected void g() {}
  
  protected void h()
  {
    if (this.g == true) {}
    ArrayList localArrayList;
    Object localObject1;
    do
    {
      int j;
      do
      {
        do
        {
          return;
          localArrayList = j();
        } while (localArrayList == null);
        j = localArrayList.size();
      } while (j <= 0);
      localObject1 = null;
      Object localObject2;
      if (this.t != null)
      {
        u localu = new u(localArrayList);
        localu.d = ((v.a)localArrayList.get(0)).d;
        localu.a(this);
        localObject2 = (Boolean)localu.b();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Boolean.valueOf(false);
        }
        localu.a(null);
      }
      int i = 0;
      if (i < j)
      {
        localObject2 = (v.a)localArrayList.get(i);
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break;
          c((v.a)localObject2);
        }
      }
    } while (((Boolean)localObject1).booleanValue());
    a(null, localArrayList, false);
  }
  
  public int hashCode()
  {
    return this.p;
  }
  
  protected int i()
  {
    return this.r;
  }
  
  protected ArrayList<v.a> j()
  {
    int i;
    ArrayList localArrayList;
    int j;
    v.a locala;
    synchronized (this.B)
    {
      if (this.y == null) {
        return null;
      }
      i = this.y.size();
      if (i <= 0)
      {
        return null;
        throw localArrayList;
      }
      localArrayList = new ArrayList();
    }
  }
  
  protected void k()
  {
    if (this.f != null) {
      this.f.e();
    }
  }
  
  protected void l()
  {
    if (this.f == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.f.d();
      } while (localObject == null);
      localObject = ((MapView.b)localObject).a();
    } while (localObject == null);
    ((MapView)localObject).postInvalidate();
  }
  
  public String toString()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.w
 * JD-Core Version:    0.7.0.1
 */