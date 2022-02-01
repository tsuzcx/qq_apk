package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class on
  extends oo<ag>
  implements ag, nu
{
  private static final int a = 128;
  private GeoPoint m;
  private double n;
  private float o;
  private CircleOptions p;
  private CircleInfo q;
  private mk r;
  
  public on(az paramaz)
  {
    super(paramaz);
    AppMethodBeat.i(222025);
    this.m = new GeoPoint(39909230, 116397428);
    this.n = 0.0D;
    this.o = 1000.0F;
    this.q = new CircleInfo();
    this.r = paramaz.b();
    AppMethodBeat.o(222025);
  }
  
  private static double a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(222095);
    paramDouble1 /= Math.cos(3.141592653589793D * paramDouble2 / 180.0D);
    AppMethodBeat.o(222095);
    return paramDouble1;
  }
  
  private static ft a(LatLng paramLatLng)
  {
    AppMethodBeat.i(222110);
    double d = paramLatLng.latitude;
    paramLatLng = new ft(paramLatLng.longitude * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
    AppMethodBeat.o(222110);
    return paramLatLng;
  }
  
  private static LatLng a(ft paramft)
  {
    AppMethodBeat.i(222123);
    float f = (float)(paramft.c * 180.0D / 20037508.34D);
    paramft = new LatLng((float)(57.295779513082323D * (2.0D * Math.atan(Math.exp((float)(paramft.b * 180.0D / 20037508.34D) * 3.141592653589793D / 180.0D)) - 1.570796326794897D)), f);
    AppMethodBeat.o(222123);
    return paramft;
  }
  
  private void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(222036);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(222036);
      return;
    }
    if (this.m == null) {
      this.m = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      q();
      AppMethodBeat.o(222036);
      return;
      this.m.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.m.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  private double d()
  {
    return this.o;
  }
  
  private void e()
  {
    AppMethodBeat.i(222067);
    sc localsc;
    if (a() == -1)
    {
      localsc = this.r.g;
      this.k = ((Integer)localsc.a(new sc.57(localsc, this.q), Integer.valueOf(-1))).intValue();
      AppMethodBeat.o(222067);
      return;
    }
    int i;
    CircleInfo localCircleInfo;
    if (p())
    {
      localsc = this.r.g;
      i = a();
      localCircleInfo = this.q;
      if ((localsc.e != 0L) && (localCircleInfo != null)) {
        break label109;
      }
    }
    for (;;)
    {
      this.r.v = true;
      AppMethodBeat.o(222067);
      return;
      label109:
      localsc.a(new sc.68(localsc, i, localCircleInfo));
    }
  }
  
  private ag f()
  {
    return this;
  }
  
  public final Rect a(ep paramep)
  {
    AppMethodBeat.i(222279);
    Object localObject1 = b(paramep);
    int i = ((Rect)localObject1).left;
    int j = ((Rect)localObject1).right;
    int k = ((Rect)localObject1).top;
    int i1 = ((Rect)localObject1).bottom;
    Object localObject2 = new GeoPoint(k, i);
    Object localObject4 = new GeoPoint(i1, i);
    Object localObject3 = new GeoPoint(i1, j);
    localObject1 = new GeoPoint(k, j);
    localObject2 = paramep.a((GeoPoint)localObject2);
    localObject4 = paramep.a((GeoPoint)localObject4);
    localObject3 = paramep.a((GeoPoint)localObject3);
    paramep = paramep.a((GeoPoint)localObject1);
    paramep = new Rect((int)Math.min(Math.min(((fl)localObject2).a, ((fl)localObject4).a), Math.min(((fl)localObject3).a, paramep.a)), (int)Math.min(Math.min(((fl)localObject2).b, ((fl)localObject4).b), Math.min(((fl)localObject3).b, paramep.b)), (int)Math.max(Math.max(((fl)localObject2).a, ((fl)localObject4).a), Math.max(((fl)localObject3).a, paramep.a)), (int)Math.max(Math.max(((fl)localObject2).b, ((fl)localObject4).b), Math.max(((fl)localObject3).b, paramep.b)));
    AppMethodBeat.o(222279);
    return paramep;
  }
  
  public final void a(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(222136);
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(222136);
      return;
    }
    this.p = paramCircleOptions;
    LatLng localLatLng = paramCircleOptions.getCenter();
    if (localLatLng != null) {
      a(GeoPoint.from(localLatLng));
    }
    setRadius(paramCircleOptions.getRadius());
    setStrokeWidth(paramCircleOptions.getStrokeWidth());
    setStrokeColor(paramCircleOptions.getStrokeColor());
    setFillColor(paramCircleOptions.getFillColor());
    setZIndex(paramCircleOptions.getZIndex());
    setVisible(paramCircleOptions.isVisible());
    setLevel(paramCircleOptions.getLevel());
    this.p = paramCircleOptions;
    q();
    AppMethodBeat.o(222136);
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(222299);
    double d = a(this.n, this.m.getLatitudeE6() / 1000000.0D);
    Object localObject = a(new LatLng(this.m.getLatitudeE6() / 1000000.0D, this.m.getLongitudeE6() / 1000000.0D));
    paramep = new ft(((ft)localObject).c - d, ((ft)localObject).b + d);
    localObject = new ft(((ft)localObject).c + d, ((ft)localObject).b - d);
    paramep = a(paramep);
    localObject = a((ft)localObject);
    Rect localRect = new Rect();
    localRect.left = ((int)(paramep.longitude * 1000000.0D));
    localRect.top = ((int)(paramep.latitude * 1000000.0D));
    localRect.right = ((int)(((LatLng)localObject).longitude * 1000000.0D));
    localRect.bottom = ((int)(((LatLng)localObject).latitude * 1000000.0D));
    AppMethodBeat.o(222299);
    return localRect;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(222153);
    Object localObject = getCenter();
    double d4 = ((LatLng)localObject).longitude;
    double d3 = ((LatLng)localObject).latitude;
    double d2 = paramLatLng.longitude;
    double d1 = paramLatLng.latitude;
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramLatLng = new double[3];
    localObject = new double[3];
    paramLatLng[0] = (d5 * d6);
    paramLatLng[1] = (d6 * d1);
    paramLatLng[2] = d2;
    localObject[0] = (d4 * d3);
    localObject[1] = (d4 * d7);
    localObject[2] = d8;
    if (Math.asin(Math.sqrt((paramLatLng[0] - localObject[0]) * (paramLatLng[0] - localObject[0]) + (paramLatLng[1] - localObject[1]) * (paramLatLng[1] - localObject[1]) + (paramLatLng[2] - localObject[2]) * (paramLatLng[2] - localObject[2])) / 2.0D) * 12742001.579854401D < getRadius())
    {
      AppMethodBeat.o(222153);
      return true;
    }
    AppMethodBeat.o(222153);
    return false;
  }
  
  public final boolean g_()
  {
    return false;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(222173);
    if (this.m != null)
    {
      LatLng localLatLng = this.m.toLatLng();
      AppMethodBeat.o(222173);
      return localLatLng;
    }
    AppMethodBeat.o(222173);
    return null;
  }
  
  public final double getRadius()
  {
    return this.n;
  }
  
  public final void h_()
  {
    AppMethodBeat.i(222261);
    sc localsc;
    int i;
    if ((a() != -1) && (this.r != null))
    {
      localsc = this.r.g;
      i = a();
      if ((localsc.e != 0L) && (i >= 0) && (localsc.j != null)) {
        break label66;
      }
    }
    for (;;)
    {
      this.k = -1;
      AppMethodBeat.o(222261);
      return;
      label66:
      localsc.a(new sc.79(localsc, i));
    }
  }
  
  public final void j()
  {
    AppMethodBeat.i(222246);
    if (((a() > 0) && (!p())) || (this.r == null))
    {
      AppMethodBeat.o(222246);
      return;
    }
    if ((this.m == null) || (this.n <= 0.0D))
    {
      AppMethodBeat.o(222246);
      return;
    }
    this.q.zIndex = ((int)this.g);
    this.q.borderColor = this.f;
    this.q.borderWidth = this.d;
    this.q.fillColor = this.e;
    this.q.radius = ((float)this.n);
    this.q.centerX = this.m.getLongitudeE6();
    this.q.centerY = this.m.getLatitudeE6();
    this.q.isVisible = this.h;
    this.q.level = this.j;
    q();
    AppMethodBeat.o(222246);
  }
  
  public final void j_()
  {
    AppMethodBeat.i(222219);
    if (this.r == null)
    {
      AppMethodBeat.o(222219);
      return;
    }
    j();
    sc localsc;
    if (a() == -1)
    {
      localsc = this.r.g;
      this.k = ((Integer)localsc.a(new sc.57(localsc, this.q), Integer.valueOf(-1))).intValue();
      AppMethodBeat.o(222219);
      return;
    }
    int i;
    CircleInfo localCircleInfo;
    if (p())
    {
      localsc = this.r.g;
      i = a();
      localCircleInfo = this.q;
      if ((localsc.e != 0L) && (localCircleInfo != null)) {
        break label130;
      }
    }
    for (;;)
    {
      this.r.v = true;
      AppMethodBeat.o(222219);
      return;
      label130:
      localsc.a(new sc.68(localsc, i, localCircleInfo));
    }
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222230);
    if ((this.m == null) || (this.r == null))
    {
      AppMethodBeat.o(222230);
      return false;
    }
    GeoPoint localGeoPoint = this.r.n.a(new fl(paramFloat1, paramFloat2));
    if (Math.hypot(localGeoPoint.getLatitudeE6() - this.m.getLatitudeE6(), localGeoPoint.getLongitudeE6() - this.m.getLongitudeE6()) <= this.o)
    {
      AppMethodBeat.o(222230);
      return true;
    }
    AppMethodBeat.o(222230);
    return false;
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(222163);
    a(GeoPoint.from(paramLatLng));
    AppMethodBeat.o(222163);
  }
  
  public final void setOptions(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(222207);
    a(paramCircleOptions);
    AppMethodBeat.o(222207);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(222187);
    if (paramDouble < 0.0D)
    {
      AppMethodBeat.o(222187);
      return;
    }
    double d = paramDouble;
    if (paramDouble == 0.0D) {
      d = 1.0E-010D;
    }
    if ((this.p == null) || (this.p.getCenter() == null))
    {
      AppMethodBeat.o(222187);
      return;
    }
    this.n = d;
    this.o = ((float)gw.a(d, this.p.getCenter().latitude));
    q();
    AppMethodBeat.o(222187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.on
 * JD-Core Version:    0.7.0.1
 */