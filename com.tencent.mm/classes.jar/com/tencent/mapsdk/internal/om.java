package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.util.Pair;
import com.tencent.map.tools.IndexCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

public final class om
  extends oo<af>
  implements af
{
  aq a;
  private final mk m;
  private LatLng n;
  private LatLng o;
  private LatLng p;
  private float q;
  private LatLng r;
  private double s;
  private double t;
  private int u;
  private float v;
  private boolean w;
  
  public om(ArcOptions paramArcOptions, az paramaz)
  {
    super(paramaz);
    AppMethodBeat.i(222043);
    this.u = -16776961;
    this.v = 10.0F;
    this.m = paramaz.b();
    if ((this.m == null) || (paramArcOptions == null))
    {
      AppMethodBeat.o(222043);
      return;
    }
    paramaz = paramArcOptions.getStartLatLng();
    LatLng localLatLng1 = paramArcOptions.getPassLatLng();
    LatLng localLatLng2 = paramArcOptions.getEndLatLng();
    if (paramArcOptions.getAngle() >= 0.0F) {}
    for (float f = paramArcOptions.getAngle() % 360.0F; (paramaz == null) || (localLatLng2 == null) || (paramaz.equals(localLatLng2)) || ((localLatLng1 == null) && ((f == 0.0F) || (f == 180.0F))) || ((localLatLng1 != null) && ((localLatLng1.equals(paramaz)) || (localLatLng1.equals(localLatLng2)))); f = paramArcOptions.getAngle() % 360.0F + 360.0F)
    {
      AppMethodBeat.o(222043);
      return;
    }
    if (this.n != paramaz)
    {
      this.n = paramaz;
      q();
    }
    if (this.o != localLatLng2)
    {
      this.o = localLatLng2;
      q();
    }
    if (this.p != localLatLng1)
    {
      this.p = localLatLng1;
      q();
    }
    if (this.q != f)
    {
      this.q = f;
      q();
    }
    setColor(paramArcOptions.getColor());
    setWidth(paramArcOptions.getWidth());
    setStrokeWidth(paramArcOptions.getStrokeWidth());
    setStrokeColor(paramArcOptions.getStrokeColor());
    this.w = paramArcOptions.isShowArrow();
    if (p()) {
      e();
    }
    AppMethodBeat.o(222043);
  }
  
  private void a(float paramFloat)
  {
    AppMethodBeat.i(222082);
    if (this.q != paramFloat)
    {
      this.q = paramFloat;
      q();
    }
    AppMethodBeat.o(222082);
  }
  
  private void a(LatLng paramLatLng)
  {
    AppMethodBeat.i(222057);
    if (this.n != paramLatLng)
    {
      this.n = paramLatLng;
      q();
    }
    AppMethodBeat.o(222057);
  }
  
  private void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  private void b(LatLng paramLatLng)
  {
    AppMethodBeat.i(222066);
    if (this.o != paramLatLng)
    {
      this.o = paramLatLng;
      q();
    }
    AppMethodBeat.o(222066);
  }
  
  private void c(LatLng paramLatLng)
  {
    AppMethodBeat.i(222075);
    if (this.p != paramLatLng)
    {
      this.p = paramLatLng;
      q();
    }
    AppMethodBeat.o(222075);
  }
  
  private af d()
  {
    return this;
  }
  
  private void e()
  {
    AppMethodBeat.i(222105);
    Object localObject1 = this.n;
    Object localObject2 = this.p;
    Object localObject3 = this.o;
    float f2 = this.q;
    localObject1 = this.m.n.b((LatLng)localObject1);
    localObject3 = this.m.n.b((LatLng)localObject3);
    ft localft = new ft(0.0D, 0.0D);
    double d;
    if (f2 == 0.0F)
    {
      localObject2 = this.m.n.b((LatLng)localObject2);
      d = kr.a((Coordinate)localObject1, (Coordinate)localObject2, (Coordinate)localObject3, localft);
      if (kr.a(((ft)localObject1).x(), ((ft)localObject1).y(), ((ft)localObject3).x(), ((ft)localObject3).y(), ((ft)localObject2).x(), ((ft)localObject2).y()) > 0.0D) {}
      for (bool = true;; bool = false)
      {
        this.r = this.m.n.a(localft);
        this.s = kr.b((Coordinate)localObject1, (Coordinate)localObject3, localft);
        this.t = kr.a((Coordinate)localObject1, localft);
        localObject2 = new LatLng[360];
        kr.a(localft, d, (Coordinate)localObject1, (Coordinate)localObject3, bool, new IndexCallback()
        {
          private void a(int paramAnonymousInt, Pair<Double, Double> paramAnonymousPair)
          {
            AppMethodBeat.i(226048);
            paramAnonymousPair = new ft(((Double)paramAnonymousPair.first).doubleValue(), ((Double)paramAnonymousPair.second).doubleValue());
            paramAnonymousPair = om.a(om.this).n.a(paramAnonymousPair);
            this.a[paramAnonymousInt] = paramAnonymousPair;
            AppMethodBeat.o(226048);
          }
        });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.n);
        int i = 0;
        while (i < 360)
        {
          localObject3 = localObject2[i];
          if (localObject3 != null) {
            ((List)localObject1).add(localObject3);
          }
          i += 1;
        }
      }
    }
    if (f2 < 180.0F) {}
    for (boolean bool = true;; bool = false)
    {
      float f1 = f2;
      if (f2 > 180.0F) {
        f1 = 360.0F - f2;
      }
      d = kr.a((Coordinate)localObject1, (Coordinate)localObject3, f1 * 2.0F, bool, localft);
      break;
    }
    ((List)localObject1).add(this.o);
    if (this.a != null) {
      this.a.remove();
    }
    localObject1 = this.m.a(new PolylineOptions().addAll((Iterable)localObject1).color(this.u).width(this.v).borderWidth(getStrokeWidth()).borderColor(getStrokeColor()).zIndex(getZIndex()).level(getLevel()).arrow(this.w).lineCap(true));
    if ((localObject1 instanceof ax)) {
      this.a = ((ax)localObject1).i;
    }
    this.m.v = true;
    AppMethodBeat.o(222105);
  }
  
  public final void a(ArcOptions paramArcOptions)
  {
    AppMethodBeat.i(222179);
    if ((this.m == null) || (paramArcOptions == null))
    {
      AppMethodBeat.o(222179);
      return;
    }
    LatLng localLatLng1 = paramArcOptions.getStartLatLng();
    LatLng localLatLng2 = paramArcOptions.getPassLatLng();
    LatLng localLatLng3 = paramArcOptions.getEndLatLng();
    if (paramArcOptions.getAngle() >= 0.0F) {}
    for (float f = paramArcOptions.getAngle() % 360.0F; (localLatLng1 == null) || (localLatLng3 == null) || (localLatLng1.equals(localLatLng3)) || ((localLatLng2 == null) && ((f == 0.0F) || (f == 180.0F))) || ((localLatLng2 != null) && ((localLatLng2.equals(localLatLng1)) || (localLatLng2.equals(localLatLng3)))); f = paramArcOptions.getAngle() % 360.0F + 360.0F)
    {
      AppMethodBeat.o(222179);
      return;
    }
    if (this.n != localLatLng1)
    {
      this.n = localLatLng1;
      q();
    }
    if (this.o != localLatLng3)
    {
      this.o = localLatLng3;
      q();
    }
    if (this.p != localLatLng2)
    {
      this.p = localLatLng2;
      q();
    }
    if (this.q != f)
    {
      this.q = f;
      q();
    }
    setColor(paramArcOptions.getColor());
    setWidth(paramArcOptions.getWidth());
    setStrokeWidth(paramArcOptions.getStrokeWidth());
    setStrokeColor(paramArcOptions.getStrokeColor());
    this.w = paramArcOptions.isShowArrow();
    if (!p())
    {
      AppMethodBeat.o(222179);
      return;
    }
    e();
    AppMethodBeat.o(222179);
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(222189);
    if (this.r != null)
    {
      Object localObject2 = paramep.b(this.r);
      Object localObject1 = new ft(((ft)localObject2).c - this.t, ((ft)localObject2).b - this.t);
      localObject2 = new ft(((ft)localObject2).c + this.t, ((ft)localObject2).b + this.t);
      localObject1 = paramep.a((ft)localObject1);
      paramep = paramep.a((ft)localObject2);
      localObject2 = new Rect();
      ((Rect)localObject2).left = ((int)(((LatLng)localObject1).longitude * 1000000.0D));
      ((Rect)localObject2).top = ((int)(((LatLng)localObject1).latitude * 1000000.0D));
      ((Rect)localObject2).right = ((int)(paramep.longitude * 1000000.0D));
      ((Rect)localObject2).bottom = ((int)(paramep.latitude * 1000000.0D));
      AppMethodBeat.o(222189);
      return localObject2;
    }
    paramep = super.b(paramep);
    AppMethodBeat.o(222189);
    return paramep;
  }
  
  public final LatLng getCenter()
  {
    return this.r;
  }
  
  public final int getColor()
  {
    return this.u;
  }
  
  public final double getLength()
  {
    return this.s;
  }
  
  public final double getRadius()
  {
    return this.t;
  }
  
  public final float getWidth()
  {
    return this.v;
  }
  
  protected final void h_()
  {
    AppMethodBeat.i(222195);
    super.h_();
    if (this.a != null)
    {
      this.a.remove();
      this.a = null;
    }
    AppMethodBeat.o(222195);
  }
  
  public final void j_()
  {
    AppMethodBeat.i(222124);
    if ((this.m == null) || (this.a == null))
    {
      AppMethodBeat.o(222124);
      return;
    }
    if (!isVisible())
    {
      this.a.remove();
      AppMethodBeat.o(222124);
      return;
    }
    if (p())
    {
      e();
      if ((this.a instanceof em))
      {
        em localem = (em)this.a;
        if (a() == -1)
        {
          this.k = localem.a();
          AppMethodBeat.o(222124);
          return;
        }
        localem.j();
      }
    }
    AppMethodBeat.o(222124);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(222147);
    if (this.u != paramInt)
    {
      this.u = paramInt;
      q();
    }
    AppMethodBeat.o(222147);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(222165);
    if (this.v != paramFloat)
    {
      this.v = paramFloat;
      q();
    }
    AppMethodBeat.o(222165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.om
 * JD-Core Version:    0.7.0.1
 */