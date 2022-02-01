package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class n
{
  public b a;
  public a b;
  public p c = null;
  MapController d;
  b e = null;
  r f = null;
  byte[] g = new byte[0];
  boolean h = false;
  q.b i = q.b.a;
  boolean j = false;
  private m k = null;
  private o l = null;
  private View m = null;
  private MapView.a n = null;
  private MapView.b o = null;
  private boolean p = true;
  private boolean q = true;
  
  public n(Context paramContext)
  {
    q.c(paramContext);
    q.a(paramContext);
    q.b(paramContext);
    this.a = new b();
    this.n = this.a;
    this.c = new p(this.a);
    this.c.a();
    this.k = new m(this);
    this.b = new a(paramContext);
    a(this, paramContext);
    this.d = new MapController(this);
    this.e = new b();
    this.e.a(this);
    this.f = new r(paramContext);
    this.f.a(this);
    this.l = new o(paramContext);
    this.l.a(this);
    this.m = this.l;
  }
  
  private void a(n paramn, Context paramContext)
  {
    paramn = new l();
    this.b.a(paramn, true);
  }
  
  int a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < this.a.d()) {
      i1 = this.a.d();
    }
    paramInt = i1;
    if (i1 > this.a.c()) {
      paramInt = this.a.c();
    }
    return paramInt;
  }
  
  View a()
  {
    return this.m;
  }
  
  void a(MapView.b paramb)
  {
    this.o = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      if (this.q) {
        bool = this.f.a(paramMotionEvent);
      }
      return bool;
      this.j = false;
      continue;
      this.j = true;
    }
  }
  
  void b()
  {
    if ((this.o != null) && (this.o.a() != null)) {
      this.o.a().a();
    }
  }
  
  MapView.a c()
  {
    return this.n;
  }
  
  MapView.b d()
  {
    return this.o;
  }
  
  void e()
  {
    this.k.a(1);
  }
  
  void f()
  {
    this.k.b(1);
  }
  
  void g() {}
  
  void h()
  {
    if (this.a.d == true) {
      return;
    }
    this.a.a(false, false, false);
    this.b.b();
  }
  
  public void i()
  {
    this.a.d = false;
    this.k.a();
  }
  
  void j()
  {
    this.a.d = false;
    this.k.a(1);
    this.k.b(1);
    this.a.a(false, false, false);
  }
  
  void k()
  {
    this.k.a(1);
    this.k.b(1);
    this.a.d = true;
    if (this.p == true) {
      this.k.b();
    }
  }
  
  void l() {}
  
  public void m()
  {
    this.f.a.setIsLongpressEnabled(false);
    this.b.c();
    this.b.d();
  }
  
  public final boolean n()
  {
    return q.a == q.a.a;
  }
  
  class a
  {
    public List<i> a = null;
    public List<f> b = null;
    public List<Overlay> c = new ArrayList();
    byte[] d = new byte[0];
    byte[] e = new byte[0];
    public boolean f = false;
    public boolean g = false;
    private List<Overlay> i = new ArrayList();
    private int j = 0;
    private int k = 0;
    private final String l = "http://pwh.map.qq.com/ih?dt=tile&rt=m256&c=%s";
    private final String m = "http://rtt.map.qq.com/m?c=%s&sp=128x2";
    private int n = 0;
    private Matrix o = new Matrix();
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.n = a((DisplayMetrics)localObject);
      if (this.a == null) {
        this.a = new ArrayList();
      }
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (q.a == q.a.c) {
        a();
      }
      n.a(n.this).a(1);
      localObject = q.b.c;
      if (q.d == true) {
        localObject = q.b.b;
      }
      b((q.b)localObject, paramContext);
      n.a(n.this).a(10);
    }
    
    private int a(DisplayMetrics paramDisplayMetrics)
    {
      int i1 = paramDisplayMetrics.widthPixels;
      int i2 = paramDisplayMetrics.heightPixels;
      return ((int)(i1 / 0.9F / 256.0F) + 2) * ((int)(i2 / 0.9F / 256.0F) + 2) + (i1 / 256 + 1) * (i2 / 256 + 1);
    }
    
    private String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int i1 = paramInt3;
      if (paramBoolean == true) {
        i1 = (int)Math.pow(2.0D, paramInt4 + 1) - 1 - paramInt3;
      }
      paramInt3 = (int)Math.floor(paramInt2 / paramInt1);
      paramInt1 = (int)Math.floor(i1 / paramInt1);
      return paramInt4 + "/" + paramInt3 + "/" + paramInt1 + "/" + paramInt2 + "_" + i1;
    }
    
    private String a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
    {
      if (paramArrayOfInt == null) {}
      do
      {
        return null;
        i1 = paramArrayOfInt.length;
      } while (i1 < 3);
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = i1 / 3;
      int i1 = 0;
      while (i1 < i2)
      {
        if (i1 != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(a(paramInt, paramArrayOfInt[(i1 * 3)], paramArrayOfInt[(i1 * 3 + 1)], paramArrayOfInt[(i1 * 3 + 2)], paramBoolean));
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    
    private void b(Canvas paramCanvas)
    {
      int i2 = this.a.size();
      int i1 = 0;
      if (i1 < i2)
      {
        i locali = (i)this.a.get(i1);
        if (locali == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (locali.l) {
            locali.c(paramCanvas);
          }
        }
      }
    }
    
    private void b(String paramString)
    {
      if (paramString.equals("") == true) {
        return;
      }
      int i2 = this.a.size();
      int i1 = 0;
      label23:
      i locali;
      if (i1 < i2)
      {
        locali = (i)this.a.get(i1);
        if (locali != null) {
          break label55;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label23;
        break;
        label55:
        if ((!locali.h.equals(paramString)) && (locali.k == true) && (locali.l == true)) {
          locali.l = false;
        }
      }
    }
    
    private void c(Canvas paramCanvas)
    {
      if (n.c(n.this) == null) {}
      MapView localMapView;
      do
      {
        do
        {
          return;
          localMapView = n.c(n.this).a();
        } while (localMapView == null);
        localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          Overlay localOverlay = (Overlay)localIterator.next();
          if (localOverlay != null) {
            localOverlay.draw(paramCanvas, localMapView);
          }
        }
      } while (n.this.i == q.b.b);
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        ((Overlay)localIterator.next()).draw(paramCanvas, localMapView);
      }
    }
    
    private boolean c(String paramString)
    {
      if (this.a == null) {
        return false;
      }
      int i2 = this.a.size();
      int i1 = 0;
      label21:
      i locali;
      if (i1 < i2)
      {
        locali = (i)this.a.get(i1);
        if (locali != null) {
          break label53;
        }
      }
      label53:
      while (locali.h.equals(paramString) != true)
      {
        i1 += 1;
        break label21;
        break;
      }
      return true;
    }
    
    private void f()
    {
      int i2 = this.a.size();
      int i1 = 0;
      if (i1 < i2)
      {
        i locali = (i)this.a.get(i1);
        if (locali == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          locali.p = i1;
        }
      }
    }
    
    void a()
    {
      if (this.b == null) {
        return;
      }
      f localf = new f(q.c());
      synchronized (this.e)
      {
        if (this.b.size() == 0) {
          this.b.add(localf);
        }
        return;
      }
    }
    
    void a(int paramInt)
    {
      if (this.i == null) {}
      int i2;
      do
      {
        return;
        i2 = this.i.size();
      } while (i2 <= 0);
      int i1 = 0;
      label24:
      Overlay localOverlay;
      if (i1 < i2)
      {
        localOverlay = (Overlay)this.i.get(i1);
        if (localOverlay != null) {
          break label56;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label24;
        break;
        label56:
        if ((localOverlay instanceof l)) {
          ((l)localOverlay).b(paramInt);
        }
      }
    }
    
    void a(int paramInt, float paramFloat)
    {
      if (this.i == null) {}
      int i2;
      do
      {
        return;
        i2 = this.i.size();
      } while (i2 <= 0);
      int i1 = 0;
      label26:
      Overlay localOverlay;
      if (i1 < i2)
      {
        localOverlay = (Overlay)this.i.get(i1);
        if (localOverlay != null) {
          break label59;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label26;
        break;
        label59:
        if ((localOverlay instanceof l)) {
          ((l)localOverlay).a(paramInt, paramFloat, n.b(n.this).getContext());
        }
      }
    }
    
    void a(int paramInt1, int paramInt2, Context paramContext)
    {
      if (this.i == null) {}
      int i2;
      do
      {
        return;
        i2 = this.i.size();
      } while (i2 <= 0);
      int i1 = 0;
      label27:
      Overlay localOverlay;
      if (i1 < i2)
      {
        localOverlay = (Overlay)this.i.get(i1);
        if (localOverlay != null) {
          break label64;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label27;
        break;
        label64:
        if ((localOverlay instanceof l)) {
          ((l)localOverlay).a(paramInt1, paramInt2, paramContext);
        }
      }
    }
    
    void a(Context paramContext)
    {
      j localj = new j();
      localj.t = new x()
      {
        public String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
        {
          if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length != 3)) {
            return null;
          }
          n.a.a(n.a.this);
          if (n.a.b(n.a.this) > 3) {
            n.a.a(n.a.this, 0);
          }
          int i = n.a.b(n.a.this);
          paramAnonymousInt = i;
          if (i > 3) {
            paramAnonymousInt = 3;
          }
          i = paramAnonymousVarArgs[0];
          int j = paramAnonymousVarArgs[1];
          int k = paramAnonymousVarArgs[2];
          int m = (int)Math.pow(2.0D, paramAnonymousVarArgs[2] + 1);
          return "http://mt" + paramAnonymousInt + ".google.com/vt/lyrs=m@159000000&hl=zh-CN&gl=cn&x=" + i + "&y=" + (m - 1 - j) + "&z=" + (k + 1) + "&s=Gali";
        }
      };
      localj.h = "map_google";
      localj.k = true;
      localj.l = true;
      localj.m = true;
      localj.i = 18;
      localj.j = 2;
      localj.r = 1;
      localj.s = q.b.b;
      synchronized (this.d)
      {
        a(localj, paramContext);
        return;
      }
    }
    
    public void a(Canvas paramCanvas)
    {
      float f1 = n.this.a.b();
      if (f1 != 1.0F)
      {
        paramCanvas.save();
        this.o.reset();
        this.o.postScale(f1, f1, n.this.c.c().x, n.this.c.c().y);
        paramCanvas.concat(this.o);
      }
      b(paramCanvas);
      if (f1 != 1.0F) {
        paramCanvas.restore();
      }
      c(paramCanvas);
    }
    
    public void a(Overlay paramOverlay, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.i.add(paramOverlay);
        return;
      }
      this.i.remove(paramOverlay);
    }
    
    void a(q.b paramb, Context paramContext)
    {
      if (this.i == null) {}
      int i2;
      do
      {
        return;
        i2 = this.i.size();
      } while (i2 <= 0);
      int i1 = 0;
      label26:
      Overlay localOverlay;
      if (i1 < i2)
      {
        localOverlay = (Overlay)this.i.get(i1);
        if (localOverlay != null) {
          break label59;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label26;
        break;
        label59:
        if ((localOverlay instanceof l)) {
          ((l)localOverlay).a(paramb, paramContext);
        }
      }
    }
    
    public boolean a(MotionEvent paramMotionEvent)
    {
      if (n.c(n.this) == null) {}
      MapView localMapView;
      do
      {
        return false;
        localMapView = n.c(n.this).a();
      } while (localMapView == null);
      boolean bool1 = false;
      Iterator localIterator = this.c.iterator();
      boolean bool2;
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        Overlay localOverlay = (Overlay)localIterator.next();
        bool2 = bool1;
        if (localOverlay != null) {
          bool2 = localOverlay.onTouchEvent(paramMotionEvent, localMapView);
        }
        bool1 = bool2;
      } while (!bool2);
      return bool2;
    }
    
    public boolean a(GeoPoint paramGeoPoint)
    {
      boolean bool2 = false;
      v.c localc2 = n.this.c.g();
      v.c localc1 = null;
      int i2 = this.a.size();
      int i1 = 0;
      paramGeoPoint = localc1;
      if (i1 < i2)
      {
        paramGeoPoint = (j)this.a.get(i1);
        if (paramGeoPoint == null) {}
        do
        {
          do
          {
            i1 += 1;
            break;
          } while (!paramGeoPoint.k);
          paramGeoPoint = (g)paramGeoPoint;
        } while (paramGeoPoint.k != true);
        paramGeoPoint = paramGeoPoint.w;
      }
      if (paramGeoPoint == null) {
        return false;
      }
      paramGeoPoint = paramGeoPoint.iterator();
      do
      {
        bool1 = bool2;
        if (!paramGeoPoint.hasNext()) {
          break;
        }
        localc1 = (v.c)paramGeoPoint.next();
      } while ((localc1.a != localc2.a) || (localc1.b != localc2.b) || (localc1.c != localc2.c));
      boolean bool1 = bool2;
      if (localc1.g != null) {
        bool1 = true;
      }
      return bool1;
    }
    
    boolean a(j paramj, Context paramContext)
    {
      boolean bool1 = false;
      boolean bool2;
      if (paramj == null) {
        bool2 = bool1;
      }
      do
      {
        do
        {
          return bool2;
          bool2 = bool1;
        } while (paramj.h.equals("") == true);
        bool2 = bool1;
      } while (c(paramj.h) == true);
      Object localObject;
      label69:
      int i1;
      if (!paramj.h.equals("trafficmap_raster"))
      {
        localObject = new g();
        ((w)localObject).a(paramj);
        ((w)localObject).a(n.this);
        ((w)localObject).u = new d(this.n, ((w)localObject).n, ((w)localObject).o);
        ((w)localObject).v = new k(paramContext, (j)localObject);
        ((w)localObject).v.a(((w)localObject).u);
        ((w)localObject).e();
        bool1 = false;
        i1 = this.a.size();
        if ((((w)localObject).k) && (i1 != 0)) {
          break label224;
        }
        bool1 = this.a.add(localObject);
      }
      for (;;)
      {
        f();
        bool2 = bool1;
        if (((w)localObject).l != true) {
          break;
        }
        a(((w)localObject).h, true);
        return bool1;
        localObject = new w();
        break label69;
        label224:
        i1 -= 1;
        bool2 = bool1;
        if (i1 >= 0)
        {
          paramj = (i)this.a.get(i1);
          if (paramj == null) {}
          while (paramj.k)
          {
            i1 -= 1;
            break;
          }
          this.a.add(i1, localObject);
          bool2 = true;
        }
        bool1 = bool2;
        if (!bool2) {
          bool1 = this.a.add(localObject);
        }
      }
    }
    
    boolean a(String paramString)
    {
      if (paramString.equals("") == true) {
        return false;
      }
      a(paramString, false);
      int i2 = this.a.size();
      int i1 = 0;
      label31:
      i locali;
      if (i1 < i2)
      {
        locali = (i)this.a.get(i1);
        if (locali != null) {
          break label63;
        }
      }
      label63:
      while (!locali.h.equals(paramString))
      {
        i1 += 1;
        break label31;
        break;
      }
      locali.l = false;
      this.a.remove(locali);
      locali.b();
      f();
      return true;
    }
    
    boolean a(String paramString, boolean paramBoolean)
    {
      if (paramString.equals("") == true) {
        return false;
      }
      int i2 = this.a.size();
      int i1 = 0;
      label25:
      i locali;
      if (i1 < i2)
      {
        locali = (i)this.a.get(i1);
        if (locali != null) {
          break label58;
        }
      }
      label58:
      do
      {
        do
        {
          i1 += 1;
          break label25;
          break;
        } while (locali.h.equals(paramString) != true);
        locali.l = paramBoolean;
        if (!locali.k) {
          return true;
        }
      } while (paramBoolean != true);
      if (locali.i > locali.j)
      {
        n.this.a.b(locali.i);
        n.this.a.c(locali.j);
        n.this.c.b();
        if (n.this.a.g() > locali.i) {
          n.this.a.a(locali.i);
        }
        if (n.this.a.g() < locali.j) {
          n.this.a.a(locali.j);
        }
      }
      b(paramString);
      n.this.a.a(false, false, false);
      return true;
    }
    
    void b()
    {
      if (q.a == q.a.c) {}
      Date localDate;
      do
      {
        do
        {
          return;
        } while (q.b == null);
        localDate = q.b();
      } while ((localDate == null) || ((q.b.getYear() == localDate.getYear()) && (q.b.getMonth() == localDate.getMonth()) && (q.b.getDate() == localDate.getDate())));
      q.a = q.a.c;
      a();
      n.a(n.this).a(1);
    }
    
    void b(int paramInt)
    {
      if (this.i == null) {}
      int i2;
      do
      {
        return;
        i2 = this.i.size();
      } while (i2 <= 0);
      int i1 = 0;
      label24:
      Overlay localOverlay;
      if (i1 < i2)
      {
        localOverlay = (Overlay)this.i.get(i1);
        if (localOverlay != null) {
          break label56;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label24;
        break;
        label56:
        if ((localOverlay instanceof l)) {
          ((l)localOverlay).a(paramInt);
        }
      }
    }
    
    void b(Context paramContext)
    {
      j localj = new j();
      localj.t = new x()
      {
        public String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
        {
          if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length != 3)) {
            return null;
          }
          n.a.c(n.a.this);
          if (n.a.d(n.a.this) > 3) {
            n.a.b(n.a.this, 0);
          }
          int j = n.a.d(n.a.this);
          int i = j;
          if (j > 3) {
            i = 3;
          }
          j = paramAnonymousVarArgs[0];
          int k = paramAnonymousVarArgs[1];
          int m = paramAnonymousVarArgs[2];
          paramAnonymousVarArgs = n.a.a(n.a.this, paramAnonymousInt, j, k, m + 1, false);
          return "http://p" + i + ".map.gtimg.com/sateTiles/" + paramAnonymousVarArgs + ".jpg";
        }
      };
      localj.h = "map_satellite";
      localj.k = true;
      localj.l = true;
      localj.m = true;
      localj.i = 17;
      localj.j = 1;
      localj.r = 1;
      localj.s = q.b.d;
      synchronized (this.d)
      {
        a(localj, paramContext);
        return;
      }
    }
    
    protected void b(GeoPoint paramGeoPoint)
    {
      int i1 = this.c.size() - 1;
      while (i1 >= 0)
      {
        Overlay localOverlay = (Overlay)this.c.get(i1);
        if (localOverlay != null) {
          localOverlay.onEmptyTap(paramGeoPoint);
        }
        i1 -= 1;
      }
    }
    
    final void b(q.b arg1, Context paramContext)
    {
      if (??? == q.b.a) {}
      while (n.this.i == ???) {
        return;
      }
      String str = "";
      if (n.this.i == q.b.b)
      {
        str = "map_google";
        synchronized (this.d)
        {
          a(str);
          if (??? != q.b.c) {}
        }
      }
      for (;;)
      {
        synchronized (this.d)
        {
          c(paramContext);
          n.this.i = q.b.c;
          a(n.this.i, paramContext);
          return;
          if (n.this.i == q.b.c)
          {
            str = "map_raster";
            break;
          }
          if (n.this.i != q.b.d) {
            break;
          }
          str = "map_satellite";
          break;
          ??? = finally;
          throw ???;
        }
        if (??? == q.b.d) {
          synchronized (this.d)
          {
            b(paramContext);
            n.this.i = q.b.d;
          }
        }
        if (??? != q.b.b) {
          continue;
        }
        synchronized (this.d)
        {
          a(paramContext);
          n.this.i = q.b.b;
        }
      }
    }
    
    protected boolean b(MotionEvent paramMotionEvent)
    {
      if (n.c(n.this) == null) {}
      MapView localMapView;
      do
      {
        return false;
        localMapView = n.c(n.this).a();
      } while (localMapView == null);
      boolean bool2 = false;
      paramMotionEvent = n.this.c.k.fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      int i1 = this.c.size() - 1;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i1 >= 0)
        {
          Overlay localOverlay = (Overlay)this.c.get(i1);
          if ((localOverlay != null) && (localOverlay.onTap(paramMotionEvent, localMapView))) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i1 -= 1;
      }
    }
    
    public void c()
    {
      int i2 = this.c.size();
      int i1 = 0;
      Overlay localOverlay;
      while (i1 < i2)
      {
        localOverlay = (Overlay)this.c.remove(0);
        if (localOverlay != null) {
          localOverlay.onRemoveOverlay();
        }
        i1 += 1;
      }
      i2 = this.i.size();
      i1 = 0;
      while (i1 < i2)
      {
        localOverlay = (Overlay)this.i.remove(0);
        if (localOverlay != null) {
          localOverlay.onRemoveOverlay();
        }
        i1 += 1;
      }
    }
    
    void c(int paramInt)
    {
      if (this.i == null) {}
      int i2;
      do
      {
        return;
        i2 = this.i.size();
      } while (i2 <= 0);
      int i1 = 0;
      label24:
      Overlay localOverlay;
      if (i1 < i2)
      {
        localOverlay = (Overlay)this.i.get(i1);
        if (localOverlay != null) {
          break label56;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label24;
        break;
        label56:
        if ((localOverlay instanceof l)) {
          ((l)localOverlay).c(paramInt);
        }
      }
    }
    
    void c(Context paramContext)
    {
      j localj = new j();
      localj.t = new x()
      {
        public String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
        {
          return String.format("http://pwh.map.qq.com/ih?dt=tile&rt=m256&c=%s", new Object[] { n.a.a(n.a.this, paramAnonymousInt, paramAnonymousVarArgs, false) });
        }
      };
      localj.h = "map_raster";
      localj.k = true;
      localj.l = true;
      localj.m = true;
      localj.i = 18;
      localj.j = 2;
      localj.r = 3;
      localj.s = q.b.c;
      synchronized (this.d)
      {
        a(localj, paramContext);
        return;
      }
    }
    
    public boolean c(MotionEvent paramMotionEvent)
    {
      if (n.c(n.this) == null) {}
      MapView localMapView;
      do
      {
        return false;
        localMapView = n.c(n.this).a();
      } while (localMapView == null);
      boolean bool2 = false;
      GeoPoint localGeoPoint = n.this.c.k.fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      int i1 = this.c.size() - 1;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i1 >= 0)
        {
          Overlay localOverlay = (Overlay)this.c.get(i1);
          if ((localOverlay != null) && (localOverlay.onLongPress(localGeoPoint, paramMotionEvent, localMapView))) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i1 -= 1;
      }
    }
    
    public void d()
    {
      if (this.b != null) {}
      for (;;)
      {
        int i2;
        int i1;
        Object localObject1;
        synchronized (this.e)
        {
          i2 = this.b.size();
          i1 = 0;
          if (i1 < i2)
          {
            localObject1 = (f)this.b.remove(0);
            if (localObject1 == null) {
              break label147;
            }
            ((f)localObject1).d();
            break label147;
          }
          if (this.a == null) {
            break;
          }
        }
        synchronized (this.d)
        {
          i2 = this.a.size();
          i1 = 0;
          if (i1 < i2)
          {
            localObject1 = (i)this.a.remove(0);
            if (localObject1 == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              localObject2 = finally;
              throw localObject2;
              localObject2.b();
            }
          }
          return;
        }
        label147:
        i1 += 1;
      }
    }
    
    void d(Context paramContext)
    {
      j localj = new j();
      localj.n = true;
      localj.o = 120000L;
      localj.t = new x()
      {
        public String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
        {
          return String.format("http://rtt.map.qq.com/m?c=%s&sp=128x2", new Object[] { n.a.a(n.a.this, paramAnonymousInt, paramAnonymousVarArgs, true) });
        }
      };
      localj.h = "trafficmap_raster";
      localj.k = false;
      localj.l = true;
      localj.m = false;
      localj.i = 18;
      localj.j = 10;
      localj.r = 3;
      synchronized (this.d)
      {
        a(localj, paramContext);
        return;
      }
    }
    
    public List<Overlay> e()
    {
      return this.c;
    }
  }
  
  public class b
    implements MapView.a
  {
    boolean a = false;
    boolean b = false;
    boolean c = true;
    public boolean d = false;
    GeoPoint e = null;
    GeoPoint f = null;
    private int h = 0;
    private int i = 0;
    private double j = 1.0D;
    private final float k;
    private final float l;
    private final float m = 0.9F;
    private float n = 0.0F;
    private float o = 0.0F;
    
    public b()
    {
      if (q.a())
      {
        this.k = 1.0F;
        this.l = 2.0F;
        return;
      }
      this.k = 0.9F;
      this.l = 1.8F;
    }
    
    private void a(PointF paramPointF)
    {
      n.this.c.a.x = paramPointF.x;
      n.this.c.a.y = paramPointF.y;
      n.this.c.e();
    }
    
    private void a(MapView paramMapView, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      paramView.measure(paramInt1, paramInt2);
      int i1;
      label31:
      int i2;
      if (paramInt1 == -2)
      {
        i1 = paramView.getMeasuredWidth();
        if (paramInt2 != -2) {
          break label106;
        }
        paramInt1 = paramView.getMeasuredHeight();
        i2 = paramInt5 & 0x7;
        paramInt5 &= 0x70;
        if (i2 != 5) {
          break label123;
        }
        paramInt2 = paramInt3 - i1;
        label58:
        if (paramInt5 != 80) {
          break label145;
        }
        paramInt3 = paramInt4 - paramInt1;
      }
      for (;;)
      {
        paramView.layout(paramInt2, paramInt3, paramInt2 + i1, paramInt3 + paramInt1);
        return;
        i1 = paramInt1;
        if (paramInt1 != -1) {
          break;
        }
        i1 = paramMapView.getMeasuredWidth();
        break;
        label106:
        paramInt1 = paramInt2;
        if (paramInt2 != -1) {
          break label31;
        }
        paramInt1 = paramMapView.getMeasuredHeight();
        break label31;
        label123:
        paramInt2 = paramInt3;
        if (i2 != 1) {
          break label58;
        }
        paramInt2 = paramInt3 - i1 / 2;
        break label58;
        label145:
        paramInt3 = paramInt4;
        if (paramInt5 == 16) {
          paramInt3 = paramInt4 - paramInt1 / 2;
        }
      }
    }
    
    private void a(MapView paramMapView, View paramView, MapView.LayoutParams paramLayoutParams)
    {
      if (paramLayoutParams.point != null)
      {
        Point localPoint = n.this.c.k.toPixels(paramLayoutParams.point, null);
        localPoint.x += paramLayoutParams.x;
        localPoint.y += paramLayoutParams.y;
        a(paramMapView, paramView, paramLayoutParams.width, paramLayoutParams.height, localPoint.x, localPoint.y, paramLayoutParams.alignment);
      }
    }
    
    private void b(MapView paramMapView, View paramView, MapView.LayoutParams paramLayoutParams)
    {
      a(paramMapView, paramView, paramLayoutParams.width, paramLayoutParams.height, paramLayoutParams.x, paramLayoutParams.y, paramLayoutParams.alignment);
    }
    
    private void j()
    {
      int i2 = n.this.b.a.size();
      int i1 = 0;
      if (i1 < i2)
      {
        i locali = (i)n.this.b.a.get(i1);
        if (locali == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          locali.g();
        }
      }
    }
    
    private void k()
    {
      if (n.c(n.this) == null) {}
      MapView localMapView;
      do
      {
        return;
        localMapView = n.c(n.this).a();
      } while (localMapView == null);
      int i2 = localMapView.getChildCount();
      int i1 = 0;
      if (i1 < i2)
      {
        View localView = localMapView.getChildAt(i1);
        if (localView == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          if ((localView.getLayoutParams() instanceof MapView.LayoutParams))
          {
            MapView.LayoutParams localLayoutParams = (MapView.LayoutParams)localView.getLayoutParams();
            if (localLayoutParams.mode == 0) {
              a(localMapView, localView, localLayoutParams);
            } else {
              b(localMapView, localView, localLayoutParams);
            }
          }
        }
      }
      localMapView.b();
    }
    
    void a()
    {
      this.j = 1.0D;
    }
    
    public void a(double paramDouble)
    {
      double d1 = paramDouble * this.j;
      int i2 = g();
      int i3 = c();
      int i4 = d();
      if (d1 > this.l) {
        for (;;)
        {
          i1 = i2;
          paramDouble = d1;
          if (d1 <= this.l) {
            break;
          }
          i1 = i2;
          paramDouble = d1;
          if (i2 >= i3) {
            break;
          }
          d1 /= 2.0D;
          i2 += 1;
        }
      }
      int i1 = i2;
      paramDouble = d1;
      if (d1 < this.k) {
        for (;;)
        {
          i1 = i2;
          paramDouble = d1;
          if (d1 >= this.k) {
            break;
          }
          i1 = i2;
          paramDouble = d1;
          if (i2 <= i4) {
            break;
          }
          d1 *= 2.0D;
          i2 -= 1;
        }
      }
      d1 = paramDouble;
      if (i1 == i3)
      {
        d1 = paramDouble;
        if (paramDouble > 1.0D) {
          d1 = 1.0D;
        }
      }
      paramDouble = d1;
      if (i1 == i4)
      {
        paramDouble = d1;
        if (d1 < 1.0D) {
          paramDouble = 1.0D;
        }
      }
      this.j = paramDouble;
      if (i1 != g())
      {
        a(i1);
        return;
      }
      if (n.c(n.this) != null)
      {
        MapView localMapView = n.c(n.this).a();
        if (localMapView != null) {
          localMapView.invalidate();
        }
      }
      n.b(n.this).requestLayout();
    }
    
    void a(float paramFloat1, float paramFloat2)
    {
      if (this.c == true) {}
      do
      {
        return;
        this.n += paramFloat1;
        this.o += paramFloat2;
        if (Math.abs((int)this.n) >= this.h)
        {
          this.c = true;
          return;
        }
      } while (Math.abs((int)this.o) < this.i);
      this.c = true;
    }
    
    public void a(int paramInt)
    {
      if (paramInt != n.this.c.e)
      {
        if (paramInt > n.this.c.e) {
          a(false);
        }
        n.this.c.f();
        n.this.c.e = paramInt;
        n.this.c.b();
        if (n.c(n.this) != null)
        {
          MapView localMapView = n.c(n.this).a();
          if (localMapView != null)
          {
            localMapView.c();
            localMapView.a(true, true);
          }
        }
        j();
      }
      a(false, false, true);
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.h) || (paramInt2 != this.i))
      {
        this.h = paramInt1;
        this.i = paramInt2;
        a(true, false, false);
      }
    }
    
    public void a(GeoPoint paramGeoPoint)
    {
      if (paramGeoPoint == null) {
        return;
      }
      a(true);
      a(n.this.c.a(paramGeoPoint, n.this.c.e));
      a(false, false, false);
    }
    
    void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, boolean paramBoolean)
    {
      if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null)) {}
      int i1;
      int i2;
      do
      {
        return;
        if ((this.h == 0) || (this.i == 0))
        {
          this.e = paramGeoPoint1;
          this.f = paramGeoPoint2;
          return;
        }
        i1 = n.this.a.c();
        PointF localPointF1 = n.this.c.a(paramGeoPoint1, i1);
        PointF localPointF2 = n.this.c.a(paramGeoPoint2, i1);
        float f2 = localPointF2.x - localPointF1.x;
        float f1 = f2;
        if (f2 < 0.0F) {
          f1 = Math.abs(f2);
        }
        float f3 = localPointF2.y - localPointF1.y;
        f2 = f3;
        if (f3 < 0.0F) {
          f2 = Math.abs(f3);
        }
        f3 = b();
        i1 = e();
        i2 = f();
        i1 = (int)Math.ceil(Math.max(Math.log(f1 * f3 / i1) / Math.log(2.0D), Math.log(f2 * f3 / i2) / Math.log(2.0D)));
        if (paramBoolean == true)
        {
          paramGeoPoint1 = new GeoPoint((paramGeoPoint1.getLatitudeE6() + paramGeoPoint2.getLatitudeE6()) / 2, (paramGeoPoint1.getLongitudeE6() + paramGeoPoint2.getLongitudeE6()) / 2);
          n.this.d.animateTo(paramGeoPoint1);
        }
        i1 = c() - i1;
        i2 = g();
      } while (i2 == i1);
      if (i1 > i2)
      {
        n.this.e.a(i1 - i2);
        return;
      }
      n.this.e.b(i2 - i1);
    }
    
    void a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      if (!paramBoolean)
      {
        this.n = 0.0F;
        this.o = 0.0F;
      }
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((n.this.c == null) || (n.this.b == null)) {}
      Object localObject;
      do
      {
        return;
        n.this.c.f();
        localObject = new ArrayList();
        int i2 = n.this.b.a.size();
        int i1 = 0;
        if (i1 < i2)
        {
          i locali = (i)n.this.b.a.get(i1);
          if (locali == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            locali.a((ArrayList)localObject, paramBoolean2, paramBoolean3);
          }
        }
        ((ArrayList)localObject).clear();
        localObject = n.c(n.this).a();
      } while (localObject == null);
      ((MapView)localObject).postInvalidate();
      ((MapView)localObject).requestLayout();
    }
    
    public float b()
    {
      return (float)this.j;
    }
    
    public void b(int paramInt)
    {
      if (paramInt <= 0) {
        return;
      }
      n.this.c.d = paramInt;
    }
    
    public void b(GeoPoint paramGeoPoint)
    {
      if (paramGeoPoint == null) {
        return;
      }
      a(n.this.c.a(paramGeoPoint, n.this.c.e));
      a(false, false, false);
    }
    
    public int c()
    {
      return n.this.c.d;
    }
    
    public void c(int paramInt)
    {
      if (paramInt <= 0) {
        return;
      }
      n.this.c.c = paramInt;
    }
    
    public void c(GeoPoint paramGeoPoint)
    {
      GeoPoint localGeoPoint = n.this.a.h();
      if ((paramGeoPoint != null) && (!paramGeoPoint.equals(localGeoPoint)))
      {
        a(n.this.c.a(paramGeoPoint, n.this.c.e));
        a(false, true, false);
      }
    }
    
    public int d()
    {
      return n.this.c.c;
    }
    
    public int e()
    {
      return this.h;
    }
    
    public int f()
    {
      return this.i;
    }
    
    public int g()
    {
      return n.this.c.e;
    }
    
    public GeoPoint h()
    {
      return n.this.c.b(n.this.c.a, n.this.c.e);
    }
    
    public void i()
    {
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.n
 * JD-Core Version:    0.7.0.1
 */