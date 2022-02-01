package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable.OnSelectedListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.List;

public final class or
  extends oo<ap>
  implements ap, fd
{
  private static final double J = 1.0E-010D;
  private static final int m = 180;
  private static final int n = 1;
  private GeoPoint[] A;
  private boolean B;
  private boolean C;
  private ArrayList<px> D;
  private ArrayList<px> E;
  private PolygonOptions F;
  private mk G;
  private String H;
  private BitmapDescriptor I;
  final PolygonInfo a;
  private List<GeoPoint> o;
  private List<LatLng> p;
  private ft[] q;
  private GeoPoint r;
  private Rect s;
  private Rect t;
  private px u;
  private final byte[] v;
  private or.b w;
  private String x;
  private GeoPoint y;
  private Rect z;
  
  public or(az paramaz, PolygonOptions paramPolygonOptions)
  {
    super(paramaz);
    AppMethodBeat.i(221949);
    this.o = new ArrayList();
    this.v = new byte[0];
    this.w = new or.b((byte)0);
    this.y = new GeoPoint();
    this.z = new Rect();
    this.B = false;
    this.C = false;
    this.a = new PolygonInfo();
    this.a.polygonId = -1;
    this.F = paramPolygonOptions;
    this.G = paramaz.b();
    if ((paramPolygonOptions != null) && (!gz.a(this.H))) {
      this.G.i.a(this);
    }
    a(paramPolygonOptions);
    AppMethodBeat.o(221949);
  }
  
  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return (paramDouble3 - paramDouble1) * (paramDouble6 - paramDouble2) - (paramDouble5 - paramDouble1) * (paramDouble4 - paramDouble2);
  }
  
  private static double a(LatLng paramLatLng1, or.a[] paramArrayOfa, LatLng paramLatLng2)
  {
    AppMethodBeat.i(222172);
    int i3 = paramArrayOfa.length;
    LatLng localLatLng1 = new LatLng(0.0D, 0.0D);
    LatLng localLatLng2 = new LatLng(0.0D, 0.0D);
    Object localObject = paramArrayOfa[0];
    LatLng localLatLng3 = localObject.a[0];
    localObject = localObject.a[1];
    double d1 = kr.a(paramLatLng1, localLatLng3, (Coordinate)localObject);
    localLatLng1.latitude = localLatLng3.latitude;
    localLatLng1.longitude = localLatLng3.longitude;
    localLatLng2.latitude = ((LatLng)localObject).latitude;
    localLatLng2.longitude = ((LatLng)localObject).longitude;
    int i = 1;
    double d2;
    if (i < i3)
    {
      localObject = paramArrayOfa[i];
      localLatLng3 = localObject.a[0];
      localObject = localObject.a[1];
      d2 = kr.a(paramLatLng1, localLatLng3, (Coordinate)localObject);
      if (d2 >= d1) {
        break label424;
      }
      localLatLng1.latitude = localLatLng3.latitude;
      localLatLng1.longitude = localLatLng3.longitude;
      localLatLng2.latitude = ((LatLng)localObject).latitude;
      localLatLng2.longitude = ((LatLng)localObject).longitude;
      d1 = d2;
    }
    label265:
    label424:
    for (;;)
    {
      i += 1;
      break;
      int j = 0;
      localLatLng1 = kr.a(paramLatLng1, localLatLng1, localLatLng2);
      localLatLng2 = new LatLng(0.0D, 0.0D);
      d1 = 0.0D;
      int k = 0;
      i = 0;
      int i2;
      int i1;
      if (k == 0)
      {
        localLatLng3 = kr.a(paramLatLng1, localLatLng1, j);
        d2 = kr.a(localLatLng3, localLatLng1);
        i2 = 0;
        i1 = k;
        if (i2 < i3)
        {
          localObject = paramArrayOfa[i2];
          if (kr.a(localLatLng3, d2, localObject.a[0], localObject.a[1])) {
            i1 = 1;
          }
        }
        else
        {
          if (i1 != 0) {
            break label365;
          }
          localLatLng2.latitude = localLatLng3.latitude;
          localLatLng2.longitude = localLatLng3.longitude;
          j += 5;
          d1 = d2;
        }
      }
      for (;;)
      {
        i += 1;
        k = i1;
        break;
        i2 += 1;
        break label265;
        label365:
        if (i == 0)
        {
          localLatLng2.latitude = localLatLng3.latitude;
          localLatLng2.longitude = localLatLng3.longitude;
          d1 = d2;
          continue;
          paramLatLng2.latitude = localLatLng2.latitude;
          paramLatLng2.longitude = localLatLng2.longitude;
          AppMethodBeat.o(222172);
          return d1;
        }
      }
    }
  }
  
  private double a(or.a[] paramArrayOfa, LatLng paramLatLng)
  {
    AppMethodBeat.i(222160);
    List localList = c();
    if (localList.isEmpty())
    {
      AppMethodBeat.o(222160);
      return 0.0D;
    }
    localList = jz.a(localList);
    if ((localList == null) || (localList.isEmpty()))
    {
      AppMethodBeat.o(222160);
      return 0.0D;
    }
    int k = localList.size();
    LatLng[] arrayOfLatLng = new LatLng[k];
    double[] arrayOfDouble = new double[k];
    int i = 0;
    while (i < k)
    {
      arrayOfLatLng[i] = new LatLng(0.0D, 0.0D);
      arrayOfDouble[i] = a((LatLng)localList.get(i), paramArrayOfa, arrayOfLatLng[i]);
      if (Double.isNaN(arrayOfDouble[i])) {
        arrayOfDouble[i] = 0.0D;
      }
      i += 1;
    }
    double d1 = arrayOfDouble[0];
    i = 1;
    int j = 0;
    while (i < k)
    {
      double d2 = d1;
      if (arrayOfDouble[i] > d1)
      {
        d2 = arrayOfDouble[i];
        j = i;
      }
      i += 1;
      d1 = d2;
    }
    paramLatLng.latitude = arrayOfLatLng[j].latitude;
    paramLatLng.longitude = arrayOfLatLng[j].longitude;
    d1 = arrayOfDouble[j];
    AppMethodBeat.o(222160);
    return d1;
  }
  
  private int a(GeoPoint paramGeoPoint, ep paramep)
  {
    AppMethodBeat.i(222108);
    Object localObject2 = this.o;
    Object localObject1 = jz.a((List)localObject2);
    int j = ((List)localObject2).size();
    localObject2 = new ArrayList();
    int i = 0;
    while (i < j - 1)
    {
      ((List)localObject2).add(new or.a(this, (LatLng)((List)localObject1).get(i), (LatLng)((List)localObject1).get(i + 1)));
      i += 1;
    }
    ((List)localObject2).add(new or.a(this, (LatLng)((List)localObject1).get(j - 1), (LatLng)((List)localObject1).get(0)));
    localObject1 = (or.a[])((List)localObject2).toArray(new or.a[((List)localObject2).size()]);
    localObject2 = new LatLng(0.0D, 0.0D);
    double d1 = a((or.a[])localObject1, (LatLng)localObject2);
    double d2 = ((LatLng)localObject2).longitude;
    double d3 = ((LatLng)localObject2).latitude;
    this.z = new Rect((int)((d2 + d1) * 1000000.0D), (int)((d3 + d1) * 1000000.0D), (int)((d2 - d1) * 1000000.0D), (int)((d3 - d1) * 1000000.0D));
    paramGeoPoint.setLatitudeE6(this.z.centerY());
    paramGeoPoint.setLongitudeE6(this.z.centerX());
    paramGeoPoint = new GeoPoint(this.z.top, this.z.left);
    localObject1 = new GeoPoint(this.z.top, this.z.right);
    localObject2 = new GeoPoint(this.z.bottom, this.z.right);
    GeoPoint localGeoPoint = new GeoPoint(this.z.bottom, this.z.left);
    paramGeoPoint = a(new fl[] { paramep.a(paramGeoPoint), paramep.a((GeoPoint)localObject1), paramep.a((GeoPoint)localObject2), paramep.a(localGeoPoint) });
    new Rect((int)paramGeoPoint[0].a, (int)paramGeoPoint[0].b, (int)paramGeoPoint[1].a, (int)paramGeoPoint[1].b);
    AppMethodBeat.o(222108);
    return 1;
  }
  
  private Rect a(or.a[] paramArrayOfa)
  {
    AppMethodBeat.i(222149);
    LatLng localLatLng = new LatLng(0.0D, 0.0D);
    double d1 = a(paramArrayOfa, localLatLng);
    double d2 = localLatLng.longitude;
    double d3 = localLatLng.latitude;
    paramArrayOfa = new Rect((int)((d2 + d1) * 1000000.0D), (int)((d3 + d1) * 1000000.0D), (int)((d2 - d1) * 1000000.0D), (int)((d3 - d1) * 1000000.0D));
    AppMethodBeat.o(222149);
    return paramArrayOfa;
  }
  
  private void a(List<GeoPoint> paramList)
  {
    AppMethodBeat.i(221959);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(221959);
      return;
    }
    if (this.o == null) {
      this.o = new ArrayList();
    }
    for (;;)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        GeoPoint localGeoPoint = (GeoPoint)paramList.get(i);
        if (localGeoPoint != null)
        {
          q();
          this.o.add(localGeoPoint);
        }
        i += 1;
      }
      this.o.clear();
    }
    AppMethodBeat.o(221959);
  }
  
  private static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7)
  {
    boolean bool2 = false;
    double d = (paramDouble3 - paramDouble1) * (paramDouble7 - paramDouble6) - (paramDouble4 - paramDouble2) * (180.0D - paramDouble5);
    boolean bool1 = bool2;
    if (d != 0.0D)
    {
      paramDouble7 = ((paramDouble2 - paramDouble6) * (180.0D - paramDouble5) - (paramDouble1 - paramDouble5) * (paramDouble7 - paramDouble6)) / d;
      paramDouble1 = ((paramDouble2 - paramDouble6) * (paramDouble3 - paramDouble1) - (paramDouble1 - paramDouble5) * (paramDouble4 - paramDouble2)) / d;
      bool1 = bool2;
      if (paramDouble7 >= 0.0D)
      {
        bool1 = bool2;
        if (paramDouble7 <= 1.0D)
        {
          bool1 = bool2;
          if (paramDouble1 >= 0.0D)
          {
            bool1 = bool2;
            if (paramDouble1 <= 1.0D) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(Rect paramRect)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.t != null)
    {
      bool1 = bool2;
      if (paramRect != null)
      {
        bool1 = bool2;
        if (this.t.right >= paramRect.left)
        {
          bool1 = bool2;
          if (this.t.left <= paramRect.right)
          {
            bool1 = bool2;
            if (this.t.bottom <= paramRect.top)
            {
              bool1 = bool2;
              if (this.t.top >= paramRect.bottom) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(222026);
    if ((this.o == null) || (this.o.size() <= 1))
    {
      AppMethodBeat.o(222026);
      return false;
    }
    double d1 = paramGeoPoint.getLongitudeE6();
    double d2 = paramGeoPoint.getLatitudeE6();
    int i = 0;
    int k = this.o.size();
    int j = 0;
    GeoPoint localGeoPoint;
    double d3;
    double d4;
    double d5;
    double d6;
    if (j < k - 1)
    {
      paramGeoPoint = (GeoPoint)this.o.get(j);
      localGeoPoint = (GeoPoint)this.o.get(j + 1);
      d3 = paramGeoPoint.getLongitudeE6();
      d4 = paramGeoPoint.getLatitudeE6();
      d5 = localGeoPoint.getLongitudeE6();
      d6 = localGeoPoint.getLatitudeE6();
      if (b(d1, d2, d3, d4, d5, d6))
      {
        AppMethodBeat.o(222026);
        return true;
      }
      if (Math.abs(d6 - d4) < 1.E-009D) {
        break label519;
      }
      if (b(d3, d4, d1, d2, 180.0D, d2))
      {
        if (d4 <= d6) {
          break label519;
        }
        i += 1;
      }
    }
    label519:
    for (;;)
    {
      j += 1;
      break;
      if (b(d5, d6, d1, d2, 180.0D, d2))
      {
        if (d6 > d4) {
          i += 1;
        }
      }
      else if (a(d3, d4, d5, d6, d1, d2, d2))
      {
        i += 1;
        continue;
        paramGeoPoint = (GeoPoint)this.o.get(k - 1);
        localGeoPoint = (GeoPoint)this.o.get(0);
        d3 = paramGeoPoint.getLongitudeE6();
        d4 = paramGeoPoint.getLatitudeE6();
        d5 = localGeoPoint.getLongitudeE6();
        d6 = localGeoPoint.getLatitudeE6();
        if (b(d1, d2, d3, d4, d5, d6))
        {
          AppMethodBeat.o(222026);
          return true;
        }
        j = i;
        if (Math.abs(d6 - d4) >= 1.E-009D)
        {
          if (!b(d3, d4, d1, d2, 180.0D, d2)) {
            break label442;
          }
          j = i;
          if (d4 > d6) {
            j = i + 1;
          }
        }
        if (j % 2 == 1) {}
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(222026);
          return bool;
          label442:
          if (b(d5, d6, d1, d2, 180.0D, d2))
          {
            j = i;
            if (d6 <= d4) {
              break;
            }
            j = i + 1;
            break;
          }
          j = i;
          if (!a(d3, d4, d5, d6, d1, d2, d2)) {
            break;
          }
          j = i + 1;
          break;
        }
      }
    }
  }
  
  private boolean a(ft paramft)
  {
    AppMethodBeat.i(221988);
    if ((this.p == null) || (this.p.size() <= 2))
    {
      AppMethodBeat.o(221988);
      return false;
    }
    int i1 = 0;
    this.q = new ft[this.p.size() + 1];
    int i = 0;
    while (i < this.p.size())
    {
      this.q[i] = this.G.n.b((LatLng)this.p.get(i));
      this.q[i].setX(this.q[i].c - paramft.c);
      this.q[i].setY(this.q[i].b - paramft.b);
      i += 1;
    }
    this.q[this.p.size()] = this.G.n.b((LatLng)this.p.get(0));
    this.q[this.p.size()].setX(this.q[this.p.size()].c - paramft.c);
    this.q[this.p.size()].setY(this.q[this.p.size()].b - paramft.b);
    int k;
    int i2;
    label319:
    double d;
    label504:
    int j;
    if (this.q[0].c >= 0.0D) {
      if (this.q[0].b >= 0.0D)
      {
        i = 0;
        k = 1;
        i2 = i;
        if ((k > this.q.length - 1) || ((this.q[k].c == 0.0D) && (this.q[k].b == 0.0D))) {
          break label662;
        }
        d = this.q[k].b * this.q[(k - 1)].c - this.q[k].c * this.q[(k - 1)].b;
        if ((d == 0.0D) && (this.q[(k - 1)].c * this.q[k].c <= 0.0D) && (this.q[(k - 1)].b * this.q[k].b <= 0.0D)) {
          break label662;
        }
        if (this.q[k].c < 0.0D) {
          break label576;
        }
        if (this.q[k].b < 0.0D) {
          break label570;
        }
        i = 0;
        if (i != (i2 + 1) % 4) {
          break label603;
        }
        j = i1 + 1;
      }
    }
    for (;;)
    {
      k += 1;
      i1 = j;
      i2 = i;
      break label319;
      i = 3;
      break;
      if (this.q[0].b >= 0.0D)
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      label570:
      i = 3;
      break label504;
      label576:
      if (this.q[k].b >= 0.0D)
      {
        i = 1;
        break label504;
      }
      i = 2;
      break label504;
      label603:
      if (i == (i2 + 3) % 4)
      {
        j = i1 - 1;
      }
      else
      {
        j = i1;
        if (i == (i2 + 2) % 4) {
          if (d > 0.0D) {
            j = i1 + 2;
          } else {
            j = i1 - 2;
          }
        }
      }
    }
    label662:
    if ((k <= this.p.size()) || (i1 != 0))
    {
      AppMethodBeat.o(221988);
      return true;
    }
    AppMethodBeat.o(221988);
    return false;
  }
  
  private static fl[] a(fl[] paramArrayOffl)
  {
    AppMethodBeat.i(222118);
    double d6 = paramArrayOffl[0].a;
    double d4 = paramArrayOffl[0].b;
    double d2 = paramArrayOffl[0].a;
    double d1 = paramArrayOffl[0].b;
    int i = 1;
    double d5;
    double d3;
    if (i < 4)
    {
      double d7 = paramArrayOffl[i].a;
      d5 = paramArrayOffl[i].b;
      d3 = d6;
      if (d7 < d6) {
        d3 = d7;
      }
      if (d7 <= d2) {
        break label178;
      }
      d2 = d7;
    }
    label178:
    for (;;)
    {
      d6 = d4;
      if (d5 < d4) {
        d6 = d5;
      }
      if (d5 > d1) {
        d1 = d5;
      }
      for (;;)
      {
        i += 1;
        d4 = d6;
        d6 = d3;
        break;
        paramArrayOffl = new fl(d6, d4);
        fl localfl = new fl(d2, d1);
        AppMethodBeat.o(222118);
        return new fl[] { paramArrayOffl, localfl };
      }
    }
  }
  
  private static boolean b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    AppMethodBeat.i(222045);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6)) < 1.E-009D)
    {
      bool1 = bool2;
      if ((paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble5) <= 0.0D)
      {
        bool1 = bool2;
        if ((paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble6) <= 0.0D) {
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(222045);
    return bool1;
  }
  
  private boolean c(ep paramep)
  {
    AppMethodBeat.i(222086);
    if ((this.a == null) || (this.F == null) || (!this.F.isValid()))
    {
      AppMethodBeat.o(222086);
      return false;
    }
    Object localObject2 = f();
    if (localObject2 == null)
    {
      AppMethodBeat.o(222086);
      return false;
    }
    Object localObject4 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).left);
    Object localObject3 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).right);
    Object localObject1 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).left);
    localObject2 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).right);
    localObject4 = paramep.a((GeoPoint)localObject4);
    localObject3 = paramep.a((GeoPoint)localObject3);
    localObject1 = paramep.a((GeoPoint)localObject1);
    paramep = a(new fl[] { localObject4, paramep.a((GeoPoint)localObject2), localObject3, localObject1 });
    paramep = new Rect((int)paramep[0].a, (int)paramep[0].b, (int)paramep[1].a, (int)paramep[1].b);
    if ((Math.abs(paramep.width()) > 5) && (Math.abs(paramep.height()) > 5))
    {
      AppMethodBeat.o(222086);
      return true;
    }
    AppMethodBeat.o(222086);
    return false;
  }
  
  private void d(ep paramep)
  {
    AppMethodBeat.i(222096);
    if (this.G == null)
    {
      AppMethodBeat.o(222096);
      return;
    }
    if (gz.a(this.H))
    {
      AppMethodBeat.o(222096);
      return;
    }
    synchronized (this.v)
    {
      if (this.w == null) {
        this.w = new or.b((byte)0);
      }
      ??? = new GeoPoint(this.z.top, this.z.left);
      GeoPoint localGeoPoint1 = new GeoPoint(this.z.top, this.z.right);
      GeoPoint localGeoPoint2 = new GeoPoint(this.z.bottom, this.z.right);
      GeoPoint localGeoPoint3 = new GeoPoint(this.z.bottom, this.z.left);
      paramep = a(new fl[] { paramep.a((GeoPoint)???), paramep.a(localGeoPoint1), paramep.a(localGeoPoint2), paramep.a(localGeoPoint3) });
      new Rect((int)paramep[0].a, (int)paramep[0].b, (int)paramep[1].a, (int)paramep[1].b);
      AppMethodBeat.o(222096);
      return;
    }
  }
  
  private int e(ep paramep)
  {
    AppMethodBeat.i(222127);
    GeoPoint localGeoPoint1 = new GeoPoint(this.z.top, this.z.left);
    GeoPoint localGeoPoint2 = new GeoPoint(this.z.top, this.z.right);
    GeoPoint localGeoPoint3 = new GeoPoint(this.z.bottom, this.z.right);
    GeoPoint localGeoPoint4 = new GeoPoint(this.z.bottom, this.z.left);
    paramep = a(new fl[] { paramep.a(localGeoPoint1), paramep.a(localGeoPoint2), paramep.a(localGeoPoint3), paramep.a(localGeoPoint4) });
    new Rect((int)paramep[0].a, (int)paramep[0].b, (int)paramep[1].a, (int)paramep[1].b);
    AppMethodBeat.o(222127);
    return 1;
  }
  
  private void e()
  {
    AppMethodBeat.i(221970);
    if (-1 == this.a.polygonId)
    {
      this.a.polygonId = this.G.a(this.a);
      AppMethodBeat.o(221970);
      return;
    }
    if (p()) {
      this.G.b(this.a);
    }
    AppMethodBeat.o(221970);
  }
  
  private Rect f()
  {
    AppMethodBeat.i(222005);
    if (this.s != null)
    {
      localObject = this.s;
      AppMethodBeat.o(222005);
      return localObject;
    }
    if ((this.o == null) || (this.o.isEmpty()) || (this.o.size() < 3))
    {
      AppMethodBeat.o(222005);
      return null;
    }
    Object localObject = (GeoPoint)this.o.get(0);
    int k = ((GeoPoint)localObject).getLatitudeE6();
    int i = ((GeoPoint)localObject).getLongitudeE6();
    int i4 = this.o.size();
    int i3 = 1;
    int j = k;
    int i1 = i;
    int i2 = i;
    i = i3;
    while (i < i4)
    {
      localObject = (GeoPoint)this.o.get(i);
      i3 = ((GeoPoint)localObject).getLatitudeE6();
      int i5 = ((GeoPoint)localObject).getLongitudeE6();
      i2 = Math.min(i2, i5);
      i1 = Math.max(i1, i5);
      k = Math.max(k, i3);
      j = Math.min(j, i3);
      i += 1;
    }
    this.s = new Rect(i2, k, i1, j);
    localObject = this.s;
    AppMethodBeat.o(222005);
    return localObject;
  }
  
  private Rect g()
  {
    AppMethodBeat.i(222016);
    if (this.t != null)
    {
      localObject = this.t;
      AppMethodBeat.o(222016);
      return localObject;
    }
    if ((this.o == null) || (this.o.isEmpty()) || (this.o.size() < 3))
    {
      AppMethodBeat.o(222016);
      return null;
    }
    Object localObject = (GeoPoint)this.o.get(0);
    localObject = this.G.n.b(((GeoPoint)localObject).toLatLng());
    int i2 = (int)((ft)localObject).x();
    int i1 = (int)((ft)localObject).x();
    int k = (int)((ft)localObject).y();
    int j = (int)((ft)localObject).y();
    int i3 = this.o.size();
    int i = 1;
    while (i < i3)
    {
      localObject = this.G.n.b(((GeoPoint)this.o.get(i)).toLatLng());
      i2 = (int)Math.min(i2, ((ft)localObject).x());
      i1 = (int)Math.max(i1, ((ft)localObject).x());
      k = (int)Math.min(k, ((ft)localObject).y());
      j = (int)Math.max(j, ((ft)localObject).y());
      i += 1;
    }
    this.t = new Rect(i2, k, i1, j);
    localObject = this.t;
    AppMethodBeat.o(222016);
    return localObject;
  }
  
  private ap h()
  {
    return this;
  }
  
  private Rect i()
  {
    AppMethodBeat.i(222072);
    if (this.G != null)
    {
      Object localObject1 = new fl(0.0D, 0.0D);
      localObject1 = this.G.n.a((fl)localObject1).toLatLng();
      localObject1 = this.G.n.b((LatLng)localObject1);
      Object localObject2 = new fl(this.G.o.width(), this.G.o.height());
      localObject2 = this.G.n.a((fl)localObject2).toLatLng();
      localObject2 = this.G.n.b((LatLng)localObject2);
      localObject1 = new Rect((int)((ft)localObject1).x(), (int)((ft)localObject1).y(), (int)((ft)localObject2).x(), (int)((ft)localObject2).y());
      AppMethodBeat.o(222072);
      return localObject1;
    }
    AppMethodBeat.o(222072);
    return null;
  }
  
  private static int t()
  {
    return 1;
  }
  
  private or.a[] u()
  {
    AppMethodBeat.i(222141);
    Object localObject2 = this.o;
    Object localObject1 = jz.a((List)localObject2);
    int j = ((List)localObject2).size();
    localObject2 = new ArrayList();
    int i = 0;
    while (i < j - 1)
    {
      ((List)localObject2).add(new or.a(this, (LatLng)((List)localObject1).get(i), (LatLng)((List)localObject1).get(i + 1)));
      i += 1;
    }
    ((List)localObject2).add(new or.a(this, (LatLng)((List)localObject1).get(j - 1), (LatLng)((List)localObject1).get(0)));
    localObject1 = (or.a[])((List)localObject2).toArray(new or.a[((List)localObject2).size()]);
    AppMethodBeat.o(222141);
    return localObject1;
  }
  
  public final Rect a(ep paramep)
  {
    AppMethodBeat.i(222354);
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
    AppMethodBeat.o(222354);
    return paramep;
  }
  
  public final void a(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(222183);
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(222183);
      return;
    }
    setFillColor(paramPolygonOptions.getFillColor());
    setStrokeColor(paramPolygonOptions.getStrokeColor());
    setStrokeWidth(paramPolygonOptions.getStrokeWidth());
    setZIndex(paramPolygonOptions.getZIndex());
    setVisible(paramPolygonOptions.isVisible());
    setLevel(paramPolygonOptions.getLevel());
    setClickable(paramPolygonOptions.isClickable());
    setPoints(paramPolygonOptions.getPoints());
    Object localObject = paramPolygonOptions.getPattern();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int[] arrayOfInt = new int[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfInt[i] = ((Integer)((List)localObject).get(i)).intValue();
        i += 1;
      }
      this.a.pattern = arrayOfInt;
    }
    localObject = paramPolygonOptions.getTexture();
    if (this.I != localObject)
    {
      this.I = ((BitmapDescriptor)localObject);
      this.I.getBitmap(this.G.getContext());
      this.a.textureName = this.I.getFormater().getBitmapId();
    }
    this.a.textureSpacing = paramPolygonOptions.getTextureSpacing();
    q();
    AppMethodBeat.o(222183);
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(222363);
    Rect localRect = new Rect();
    new Rect();
    if (this.a != null) {
      localRect = f();
    }
    if (this.u != null)
    {
      paramep = this.u.b(paramep);
      localRect.left = Math.min(localRect.left, paramep.left);
      localRect.top = Math.min(localRect.top, paramep.top);
      localRect.right = Math.max(localRect.right, paramep.right);
      localRect.bottom = Math.max(localRect.bottom, paramep.bottom);
    }
    AppMethodBeat.o(222363);
    return localRect;
  }
  
  public final PolygonInfo b()
  {
    return this.a;
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(222375);
    if (paramInt == fv.a)
    {
      AppMethodBeat.o(222375);
      return;
    }
    Object localObject1;
    if (this.G != null)
    {
      localObject1 = this.G.n;
      if ((this.G == null) || (gz.a(this.H))) {}
    }
    synchronized (this.v)
    {
      if (this.w == null) {
        this.w = new or.b((byte)0);
      }
      ??? = new GeoPoint(this.z.top, this.z.left);
      GeoPoint localGeoPoint1 = new GeoPoint(this.z.top, this.z.right);
      GeoPoint localGeoPoint2 = new GeoPoint(this.z.bottom, this.z.right);
      GeoPoint localGeoPoint3 = new GeoPoint(this.z.bottom, this.z.left);
      localObject1 = a(new fl[] { ((ep)localObject1).a((GeoPoint)???), ((ep)localObject1).a(localGeoPoint1), ((ep)localObject1).a(localGeoPoint2), ((ep)localObject1).a(localGeoPoint3) });
      new Rect((int)localObject1[0].a, (int)localObject1[0].b, (int)localObject1[1].a, (int)localObject1[1].b);
      AppMethodBeat.o(222375);
      return;
    }
  }
  
  public final List<GeoPoint> c()
  {
    AppMethodBeat.i(222311);
    ArrayList localArrayList = new ArrayList(49);
    Object localObject = f();
    int i = ((Rect)localObject).left;
    int j = ((Rect)localObject).right;
    j = ((Rect)localObject).top;
    int k = ((Rect)localObject).bottom;
    k = Math.abs(((Rect)localObject).width());
    int i1 = Math.abs(((Rect)localObject).height());
    double d1 = i - 0.125D * k;
    double d2 = j - 0.125D * i1;
    double d3 = i - 0.25D * k;
    double d4 = j - 0.25D * i1;
    double d5 = i - 0.375D * k;
    double d6 = j - 0.375D * i1;
    double d7 = i - 0.5D * k;
    double d8 = j - 0.5D * i1;
    double d9 = i - 0.625D * k;
    double d10 = j - 0.625D * i1;
    double d11 = i - 0.75D * k;
    double d12 = j - 0.75D * i1;
    double d13 = i - k * 0.825D;
    double d14 = j - 0.825D * i1;
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    AppMethodBeat.o(222311);
    return localArrayList;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(222291);
    List localList = getPoints();
    if ((localList == null) || (localList.size() < 3) || (paramLatLng == null))
    {
      AppMethodBeat.o(222291);
      return false;
    }
    int j = localList.size() - 1;
    int k = 0;
    int i = 0;
    while (i < localList.size())
    {
      if (((LatLng)localList.get(i)).equals(paramLatLng))
      {
        AppMethodBeat.o(222291);
        return true;
      }
      i += 1;
    }
    i = 0;
    if (i < localList.size())
    {
      int i1;
      if ((((LatLng)localList.get(i)).latitude >= paramLatLng.latitude) || (((LatLng)localList.get(j)).latitude < paramLatLng.latitude))
      {
        i1 = k;
        if (((LatLng)localList.get(j)).latitude < paramLatLng.latitude)
        {
          i1 = k;
          if (((LatLng)localList.get(i)).latitude < paramLatLng.latitude) {}
        }
      }
      else if (((LatLng)localList.get(i)).longitude > paramLatLng.longitude)
      {
        i1 = k;
        if (((LatLng)localList.get(j)).longitude > paramLatLng.longitude) {}
      }
      else
      {
        if (((LatLng)localList.get(i)).longitude + (paramLatLng.latitude - ((LatLng)localList.get(i)).latitude) / (((LatLng)localList.get(j)).latitude - ((LatLng)localList.get(i)).latitude) * (((LatLng)localList.get(j)).longitude - ((LatLng)localList.get(i)).longitude) > paramLatLng.longitude) {
          break label379;
        }
      }
      label379:
      for (j = 1;; j = 0)
      {
        i1 = k ^ j;
        j = i;
        i += 1;
        k = i1;
        break;
      }
    }
    AppMethodBeat.o(222291);
    return k;
  }
  
  public final GeoPoint d()
  {
    AppMethodBeat.i(222319);
    Object localObject = f();
    localObject = new GeoPoint(((Rect)localObject).centerY(), ((Rect)localObject).centerX());
    AppMethodBeat.o(222319);
    return localObject;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(222268);
    if (this.p != null)
    {
      localList = this.p;
      AppMethodBeat.o(222268);
      return localList;
    }
    List localList = jz.a(this.o);
    AppMethodBeat.o(222268);
    return localList;
  }
  
  public final void h_()
  {
    AppMethodBeat.i(222250);
    if (this.G == null)
    {
      AppMethodBeat.o(222250);
      return;
    }
    this.G.i.b(this);
    if (this.a != null) {
      this.G.a(this.a.polygonId);
    }
    if (this.o != null)
    {
      this.o.clear();
      this.o = null;
    }
    synchronized (this.v)
    {
      if (this.w != null)
      {
        or.b localb = this.w;
        if ((localb.a != null) && (!localb.a.isRecycled()))
        {
          localb.a.recycle();
          localb.a = null;
        }
        this.w = null;
      }
      if (this.u != null)
      {
        this.G.k.b(this.u);
        this.G.v = true;
        this.u = null;
      }
      this.B = false;
      AppMethodBeat.o(222250);
      return;
    }
  }
  
  public final boolean handleOnTap()
  {
    return true;
  }
  
  public final boolean isSelected()
  {
    return false;
  }
  
  public final void j()
  {
    AppMethodBeat.i(222238);
    if (this.G == null)
    {
      AppMethodBeat.o(222238);
      return;
    }
    if ((this.a.polygonId >= 0) && (!p()))
    {
      AppMethodBeat.o(222238);
      return;
    }
    if ((this.o == null) || (this.o.size() <= 2))
    {
      AppMethodBeat.o(222238);
      return;
    }
    this.a.color = this.e;
    this.a.borderColor = this.f;
    this.a.borderWidth = this.d;
    this.a.zIndex = getZIndex();
    this.a.level = getLevel();
    int j = this.o.size();
    this.a.points = new LatLng[j];
    int i = 0;
    while (i < j)
    {
      GeoPoint localGeoPoint = (GeoPoint)this.o.get(i);
      this.a.points[i] = localGeoPoint.toLatLng();
      i += 1;
    }
    this.G.v = true;
    q();
    AppMethodBeat.o(222238);
  }
  
  public final void j_()
  {
    int j = -1;
    int k = 0;
    AppMethodBeat.i(222210);
    mk localmk = this.G;
    if (localmk == null)
    {
      AppMethodBeat.o(222210);
      return;
    }
    Object localObject1 = localmk.n;
    if (!isVisible())
    {
      localmk.a(this.a.polygonId);
      this.a.polygonId = -1;
      AppMethodBeat.o(222210);
      return;
    }
    int i = k;
    if (this.a != null)
    {
      i = k;
      if (this.F != null)
      {
        if (this.F.isValid()) {
          break label110;
        }
        i = k;
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(222210);
      return;
      label110:
      Object localObject3 = f();
      i = k;
      if (localObject3 != null)
      {
        Object localObject5 = new GeoPoint(((Rect)localObject3).top, ((Rect)localObject3).left);
        Object localObject4 = new GeoPoint(((Rect)localObject3).bottom, ((Rect)localObject3).right);
        Object localObject2 = new GeoPoint(((Rect)localObject3).bottom, ((Rect)localObject3).left);
        localObject3 = new GeoPoint(((Rect)localObject3).top, ((Rect)localObject3).right);
        localObject5 = ((ep)localObject1).a((GeoPoint)localObject5);
        localObject4 = ((ep)localObject1).a((GeoPoint)localObject4);
        localObject2 = ((ep)localObject1).a((GeoPoint)localObject2);
        localObject1 = a(new fl[] { localObject5, ((ep)localObject1).a((GeoPoint)localObject3), localObject4, localObject2 });
        localObject1 = new Rect((int)localObject1[0].a, (int)localObject1[0].b, (int)localObject1[1].a, (int)localObject1[1].b);
        i = k;
        if (Math.abs(((Rect)localObject1).width()) > 5)
        {
          i = k;
          if (Math.abs(((Rect)localObject1).height()) > 5) {
            i = 1;
          }
        }
      }
    }
    if (gz.a(this.H)) {
      j();
    }
    if (-1 == this.a.polygonId)
    {
      this.a.polygonId = this.G.a(this.a);
      if (this.u != null)
      {
        this.u.j_();
        this.x = this.u.f();
        if (!this.C)
        {
          k = this.u.f();
          if (this.a != null) {
            break label487;
          }
        }
      }
    }
    label487:
    for (i = j;; i = this.a.polygonId)
    {
      localmk.a(k, i);
      this.C = true;
      AppMethodBeat.o(222210);
      return;
      if (!p()) {
        break;
      }
      this.G.b(this.a);
      break;
    }
  }
  
  public final int k_()
  {
    if (this.a == null) {
      return -1;
    }
    return this.a.polygonId;
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222228);
    if ((this.G == null) || (!isVisible()))
    {
      AppMethodBeat.o(222228);
      return false;
    }
    label219:
    int i;
    if ((this.t != null) || (this.o == null) || (this.o.isEmpty()) || (this.o.size() < 3))
    {
      if (this.G == null) {
        break label505;
      }
      localObject1 = new fl(0.0D, 0.0D);
      localObject1 = this.G.n.a((fl)localObject1).toLatLng();
      localObject1 = this.G.n.b((LatLng)localObject1);
      Object localObject2 = new fl(this.G.o.width(), this.G.o.height());
      localObject2 = this.G.n.a((fl)localObject2).toLatLng();
      localObject2 = this.G.n.b((LatLng)localObject2);
      localObject1 = new Rect((int)((ft)localObject1).x(), (int)((ft)localObject1).y(), (int)((ft)localObject2).x(), (int)((ft)localObject2).y());
      if ((this.t == null) || (localObject1 == null)) {
        break label516;
      }
      if ((this.t.right < ((Rect)localObject1).left) || (this.t.left > ((Rect)localObject1).right) || (this.t.bottom > ((Rect)localObject1).top) || (this.t.top < ((Rect)localObject1).bottom)) {
        break label511;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        break label521;
      }
      AppMethodBeat.o(222228);
      return false;
      localObject1 = (GeoPoint)this.o.get(0);
      localObject1 = this.G.n.b(((GeoPoint)localObject1).toLatLng());
      int i2 = (int)((ft)localObject1).x();
      int i1 = (int)((ft)localObject1).x();
      int k = (int)((ft)localObject1).y();
      int j = (int)((ft)localObject1).y();
      int i3 = this.o.size();
      i = 1;
      while (i < i3)
      {
        localObject1 = this.G.n.b(((GeoPoint)this.o.get(i)).toLatLng());
        i2 = (int)Math.min(i2, ((ft)localObject1).x());
        i1 = (int)Math.max(i1, ((ft)localObject1).x());
        k = (int)Math.min(k, ((ft)localObject1).y());
        j = (int)Math.max(j, ((ft)localObject1).y());
        i += 1;
      }
      this.t = new Rect(i2, k, i1, j);
      break;
      label505:
      localObject1 = null;
      break label219;
      label511:
      i = 0;
      continue;
      label516:
      i = 0;
    }
    label521:
    Object localObject1 = this.G.n.a(new fl(paramFloat1, paramFloat2));
    boolean bool = a(this.G.n.b(((GeoPoint)localObject1).toLatLng()));
    AppMethodBeat.o(222228);
    return bool;
  }
  
  public final void setOptions(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(222274);
    a(paramPolygonOptions);
    AppMethodBeat.o(222274);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(222259);
    this.p = paramList;
    if (paramList == null)
    {
      AppMethodBeat.o(222259);
      return;
    }
    int j = paramList.size();
    if (j <= 0)
    {
      AppMethodBeat.o(222259);
      return;
    }
    if (this.F != null) {
      this.F.setPoints(new ArrayList(paramList));
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Object localObject = (LatLng)paramList.get(i);
      if (localObject != null)
      {
        localObject = GeoPoint.from((LatLng)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    a(localArrayList);
    AppMethodBeat.o(222259);
  }
  
  public final void setSelected(boolean paramBoolean) {}
  
  public final void setSelectedListener(Selectable.OnSelectedListener paramOnSelectedListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.or
 * JD-Core Version:    0.7.0.1
 */