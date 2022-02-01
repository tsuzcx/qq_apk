package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable.OnSelectedListener;
import java.util.HashMap;

public final class px
  extends oo
{
  protected py a;
  protected oj m;
  protected Selectable.OnSelectedListener n;
  protected fl o;
  public hj p;
  private mj q;
  private bd r;
  private hj s;
  private final ao t;
  
  public px(ao paramao, az paramaz, py parampy)
  {
    super(paramaz);
    AppMethodBeat.i(225659);
    this.o = new fl();
    this.s = null;
    this.t = paramao;
    this.q = paramaz.c();
    this.r = ((bd)paramaz.getMapContext());
    this.a = parampy;
    this.m = new oj(this.a);
    this.h = true;
    a(parampy);
    AppMethodBeat.o(225659);
  }
  
  private oj A()
  {
    return this.m;
  }
  
  private boolean B()
  {
    if (this.m != null) {
      return this.m.w;
    }
    return false;
  }
  
  private float C()
  {
    if (this.m != null) {
      return this.m.p;
    }
    return 0.0F;
  }
  
  private float D()
  {
    if (this.m != null) {
      return this.m.q;
    }
    return 0.0F;
  }
  
  private float E()
  {
    if (this.m != null) {
      return this.m.r;
    }
    return 0.0F;
  }
  
  private float F()
  {
    if (this.m != null) {
      return this.m.s;
    }
    return 0.0F;
  }
  
  private boolean G()
  {
    if (this.a != null) {
      return this.a.n;
    }
    return false;
  }
  
  private static boolean H()
  {
    return false;
  }
  
  private boolean I()
  {
    if (this.a != null) {
      return this.a.z;
    }
    return true;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    ((py)localObject).q = paramInt1;
    ((py)localObject).r = paramInt2;
    if (this.m != null)
    {
      localObject = this.m;
      ((oj)localObject).k = paramInt1;
      ((oj)localObject).l = paramInt2;
      ((oj)localObject).o = true;
      this.m.o = true;
    }
  }
  
  private void a(hj paramhj)
  {
    this.p = paramhj;
  }
  
  private void b(hj paramhj)
  {
    AppMethodBeat.i(225676);
    if (paramhj == null)
    {
      AppMethodBeat.o(225676);
      return;
    }
    this.s = paramhj;
    this.s.a();
    AppMethodBeat.o(225676);
  }
  
  private void b(String paramString, Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(225682);
    a(paramString, paramVarArgs);
    AppMethodBeat.o(225682);
  }
  
  private void d(boolean paramBoolean)
  {
    this.a.p = paramBoolean;
  }
  
  private void t()
  {
    if (this.m != null) {
      this.m.o = true;
    }
  }
  
  private GeoPoint u()
  {
    return this.a.i;
  }
  
  private int v()
  {
    return this.a.o;
  }
  
  private float w()
  {
    return this.a.m;
  }
  
  private float x()
  {
    if (this.m != null) {
      return this.m.u;
    }
    return 1.0F;
  }
  
  private float y()
  {
    if (this.m != null) {
      return this.m.v;
    }
    return 1.0F;
  }
  
  private py z()
  {
    return this.a;
  }
  
  public final Rect a(ep paramep)
  {
    AppMethodBeat.i(225887);
    if ((this.m == null) || (this.a == null) || (this.a.i == null))
    {
      AppMethodBeat.o(225887);
      return null;
    }
    fl localfl;
    int j;
    int i;
    if (B())
    {
      paramep = this.a.i;
      localfl = new fl(0.0D, 0.0D);
      if (paramep != null)
      {
        localfl.a = paramep.getLongitudeE6();
        localfl.b = paramep.getLatitudeE6();
      }
      this.o = localfl;
      paramep = new fl();
      localfl = new fl();
      Bitmap localBitmap = this.m.d();
      if (localBitmap == null) {
        break label404;
      }
      j = localBitmap.getWidth();
      i = localBitmap.getHeight();
    }
    for (;;)
    {
      paramep.a = this.o.a;
      localfl.a = (this.o.a + j);
      paramep.b = this.o.b;
      localfl.b = (this.o.b + i);
      j = (int)(this.a.k * j);
      float f = this.a.l;
      i = (int)(i * f);
      paramep.a -= j;
      localfl.a -= j;
      paramep.b -= i;
      localfl.b -= i;
      i = this.a.q;
      j = this.a.r;
      paramep.a += i;
      localfl.a += i;
      paramep.b += j;
      double d = localfl.b;
      localfl.b = (j + d);
      paramep = new Rect((int)paramep.a, (int)paramep.b, (int)localfl.a, (int)localfl.b);
      AppMethodBeat.o(225887);
      return paramep;
      this.o = paramep.a(this.a.i);
      break;
      label404:
      i = 0;
      j = 0;
    }
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(225928);
    py localpy = this.a;
    localpy.m = paramFloat;
    this.a = localpy;
    if (this.m != null)
    {
      this.m.a(paramFloat);
      this.m.o = true;
    }
    AppMethodBeat.o(225928);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225937);
    this.a = this.a.a(paramFloat1, paramFloat2);
    if (this.m != null)
    {
      this.m.a(paramFloat1, paramFloat2);
      this.m.o = true;
    }
    AppMethodBeat.o(225937);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(225921);
    py localpy = this.a;
    localpy.o = paramInt;
    this.a = localpy;
    if (this.m != null)
    {
      this.m.a(paramInt);
      this.m.o = true;
    }
    AppMethodBeat.o(225921);
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(225906);
    Object localObject = this.a;
    ((py)localObject).i = paramGeoPoint;
    this.a = ((py)localObject);
    if (this.m != null)
    {
      localObject = this.m;
      if (paramGeoPoint != null) {
        if (!((oj)localObject).w) {
          break label94;
        }
      }
    }
    label94:
    for (double d = 1.0D;; d = 1000000.0D)
    {
      ((oj)localObject).i = (paramGeoPoint.getLongitudeE6() / d);
      ((oj)localObject).j = (paramGeoPoint.getLatitudeE6() / d);
      ((oj)localObject).o = true;
      this.m.o = true;
      AppMethodBeat.o(225906);
      return;
    }
  }
  
  public final void a(py parampy)
  {
    AppMethodBeat.i(225817);
    if (parampy == null)
    {
      AppMethodBeat.o(225817);
      return;
    }
    this.a = parampy;
    if (this.m == null)
    {
      this.m = new oj(this.a);
      AppMethodBeat.o(225817);
      return;
    }
    this.m.a(parampy);
    AppMethodBeat.o(225817);
  }
  
  public final void a(String paramString, Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(225895);
    this.a = this.a.a(paramString, paramVarArgs);
    if (this.m != null)
    {
      this.m.a(paramString, paramVarArgs);
      this.m.o = true;
    }
    AppMethodBeat.o(225895);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.m != null)
    {
      this.m.w = paramBoolean;
      this.m.o = true;
    }
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(225871);
    if ((this.m == null) || (this.a == null) || (this.a.i == null))
    {
      AppMethodBeat.o(225871);
      return null;
    }
    Object localObject1;
    if (B())
    {
      localObject1 = this.a.i;
      localObject2 = new fl(0.0D, 0.0D);
      if (localObject1 != null)
      {
        ((fl)localObject2).a = ((GeoPoint)localObject1).getLongitudeE6();
        ((fl)localObject2).b = ((GeoPoint)localObject1).getLatitudeE6();
      }
    }
    Bitmap localBitmap;
    for (this.o = ((fl)localObject2);; this.o = paramep.a(this.a.i))
    {
      localObject2 = new fl();
      localObject1 = new fl();
      localBitmap = this.m.d();
      if (localBitmap != null) {
        break;
      }
      AppMethodBeat.o(225871);
      return null;
    }
    int j = localBitmap.getWidth();
    int i = localBitmap.getHeight();
    ((fl)localObject2).a = this.o.a;
    ((fl)localObject1).a = (this.o.a + j);
    ((fl)localObject2).b = this.o.b;
    ((fl)localObject1).b = (this.o.b + i);
    float f = this.a.k;
    j = (int)(j * f);
    f = this.a.l;
    i = (int)(i * f);
    ((fl)localObject2).a -= j;
    ((fl)localObject1).a -= j;
    ((fl)localObject2).b -= i;
    ((fl)localObject1).b -= i;
    i = this.a.q;
    j = this.a.r;
    ((fl)localObject2).a += i;
    ((fl)localObject1).a += i;
    ((fl)localObject2).b += j;
    ((fl)localObject1).b += j;
    Object localObject2 = paramep.a((fl)localObject2);
    paramep = paramep.a((fl)localObject1);
    paramep = new Rect(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject2).getLatitudeE6(), paramep.getLongitudeE6(), paramep.getLatitudeE6());
    AppMethodBeat.o(225871);
    return paramep;
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    if (this.m != null)
    {
      oj localoj = this.m;
      localoj.u = paramFloat1;
      localoj.v = paramFloat2;
      localoj.o = true;
      this.m.o = true;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(225998);
    if (this.a != null) {
      this.a.x = paramBoolean;
    }
    if (this.m != null)
    {
      this.m.b(paramBoolean);
      this.m.o = true;
    }
    AppMethodBeat.o(225998);
  }
  
  public final void c(boolean paramBoolean)
  {
    if (this.m == null) {
      return;
    }
    this.m.z = paramBoolean;
    this.m.o = true;
  }
  
  public final float d()
  {
    return this.a.k;
  }
  
  public final float e()
  {
    return this.a.l;
  }
  
  public final int f()
  {
    if (this.m != null) {
      return this.m.f;
    }
    return -1;
  }
  
  public final ao f_()
  {
    return this.t;
  }
  
  public final void g()
  {
    AppMethodBeat.i(226003);
    if (this.a != null) {
      this.a.y = false;
    }
    if (this.m != null)
    {
      this.m.c(false);
      this.m.o = true;
    }
    AppMethodBeat.o(226003);
  }
  
  public final int getZIndex()
  {
    return this.a.s;
  }
  
  public final void h()
  {
    if (this.m != null) {
      this.m.f = 0;
    }
    if (this.p != null) {
      this.p.b = false;
    }
  }
  
  public final boolean i()
  {
    if (this.m == null) {
      return false;
    }
    return this.m.z;
  }
  
  public final boolean isSelected()
  {
    return this.m.H == 1;
  }
  
  public final void j_()
  {
    AppMethodBeat.i(225832);
    if (this.q == null)
    {
      AppMethodBeat.o(225832);
      return;
    }
    if (!isVisible())
    {
      if (this.m != null) {
        this.m.f = -1;
      }
      AppMethodBeat.o(225832);
      return;
    }
    mj localmj;
    oj localoj;
    sc localsc;
    if (this.s != null)
    {
      if (!this.s.d) {
        this.s.b();
      }
    }
    else
    {
      if ((this.p != null) && (!this.p.d)) {
        this.p.b();
      }
      if (this.m != null)
      {
        localmj = this.q;
        localoj = this.m;
        if ((localoj.f <= 0) || (!localmj.c.containsKey(Integer.valueOf(localoj.f)))) {
          break label255;
        }
        if (localoj.o)
        {
          localsc = localmj.b;
          if (0L != localsc.e) {
            localsc.a(new sc.121(localsc, localoj));
          }
          if (localoj.y)
          {
            gv.b.a(localoj.g, localoj.d());
            localoj.a(false);
          }
        }
        localoj.o = false;
        localmj.d.put(Integer.valueOf(localoj.f), localoj);
      }
    }
    for (;;)
    {
      if (this.m.f != 0) {
        this.k = this.m.f;
      }
      AppMethodBeat.o(225832);
      return;
      this.s = null;
      break;
      label255:
      localsc = localmj.b;
      localoj.f = ((Integer)localsc.a(new sc.120(localsc, localoj), Integer.valueOf(0))).intValue();
      if (localoj.f > 0)
      {
        gv.b.a(localoj.g, localoj.d());
        localoj.a(false);
        localoj.o = false;
        localmj.d.put(Integer.valueOf(localoj.f), localoj);
      }
    }
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225840);
    if ((!isVisible()) || (this.a.i == null) || (this.r == null))
    {
      AppMethodBeat.o(225840);
      return false;
    }
    TappedElement localTappedElement = this.r.f().a(paramFloat1, paramFloat2);
    if ((localTappedElement != null) && (localTappedElement.itemId == f())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.m.b(1);
      }
      for (;;)
      {
        if ((bool) && (this.n != null)) {
          this.n.onSelected(this);
        }
        AppMethodBeat.o(225840);
        return bool;
        this.m.b(0);
      }
    }
  }
  
  public final void setLevel(int paramInt)
  {
    py localpy = this.a;
    localpy.t = paramInt;
    this.a = localpy;
    if (this.m != null)
    {
      this.m.C = paramInt;
      this.m.o = true;
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(225849);
    if (paramBoolean)
    {
      this.m.b(1);
      AppMethodBeat.o(225849);
      return;
    }
    this.m.b(0);
    AppMethodBeat.o(225849);
  }
  
  public final void setSelectedListener(Selectable.OnSelectedListener paramOnSelectedListener)
  {
    this.n = paramOnSelectedListener;
  }
  
  public final void setZIndex(int paramInt)
  {
    py localpy = this.a;
    localpy.s = paramInt;
    this.a = localpy;
    if (this.m != null)
    {
      this.m.D = paramInt;
      this.m.o = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.px
 * JD-Core Version:    0.7.0.1
 */