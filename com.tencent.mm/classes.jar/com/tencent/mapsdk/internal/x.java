package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public final class x
  extends fw
  implements ep
{
  public static final int a = 268435456;
  private static final int e = 19;
  private static final int f = 14;
  protected v b;
  protected mk c;
  private sc g;
  
  public x(bd parambd)
  {
    super(40075016.68D);
    AppMethodBeat.i(223182);
    this.g = parambd.f();
    this.b = parambd.e();
    this.c = ((mk)parambd);
    AppMethodBeat.o(223182);
  }
  
  private Rect a(List<? extends Boundable> paramList, List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(223282);
    int j;
    int i2;
    int i3;
    int k;
    int m;
    int n;
    int i1;
    Object localObject;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      i = 0;
      j = 0;
      i2 = 0;
      i3 = 0;
      do
      {
        do
        {
          k = i;
          m = j;
          n = i2;
          i1 = i3;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (Boundable)paramList.next();
        } while (localObject == null);
        localObject = ((Boundable)localObject).getBound(this);
      } while (localObject == null);
      k = i3;
      if (i3 == 0) {
        k = ((Rect)localObject).left;
      }
      m = i2;
      if (i2 == 0) {
        m = ((Rect)localObject).right;
      }
      n = j;
      if (j == 0) {
        n = ((Rect)localObject).top;
      }
      j = i;
      if (i == 0) {
        j = ((Rect)localObject).bottom;
      }
      i3 = k;
      if (((Rect)localObject).left < k) {
        i3 = ((Rect)localObject).left;
      }
      i2 = m;
      if (((Rect)localObject).right > m) {
        i2 = ((Rect)localObject).right;
      }
      k = n;
      if (((Rect)localObject).top > n) {
        k = ((Rect)localObject).top;
      }
      if (((Rect)localObject).bottom >= j) {
        break label479;
      }
    }
    label473:
    label479:
    for (int i = ((Rect)localObject).bottom;; i = j)
    {
      j = k;
      break;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = k;
      i3 = m;
      int i4 = n;
      int i5 = i1;
      if (paramList1 != null)
      {
        paramList = paramList1.iterator();
        j = m;
        i = k;
        do
        {
          i2 = i;
          i3 = j;
          i4 = n;
          i5 = i1;
          if (!paramList.hasNext()) {
            break;
          }
          paramList1 = (GeoPoint)paramList.next();
        } while (paramList1 == null);
        k = i1;
        if (i1 == 0) {
          k = paramList1.getLongitudeE6();
        }
        m = n;
        if (n == 0) {
          m = paramList1.getLongitudeE6();
        }
        i2 = j;
        if (j == 0) {
          i2 = paramList1.getLatitudeE6();
        }
        j = i;
        if (i == 0) {
          j = paramList1.getLatitudeE6();
        }
        i1 = k;
        if (paramList1.getLongitudeE6() < k) {
          i1 = paramList1.getLongitudeE6();
        }
        n = m;
        if (paramList1.getLongitudeE6() > m) {
          n = paramList1.getLongitudeE6();
        }
        k = i2;
        if (paramList1.getLatitudeE6() > i2) {
          k = paramList1.getLatitudeE6();
        }
        if (paramList1.getLatitudeE6() >= j) {
          break label473;
        }
      }
      for (i = paramList1.getLatitudeE6();; i = j)
      {
        j = k;
        break;
        paramList = new Rect(i5, i3, i4, i2);
        AppMethodBeat.o(223282);
        return paramList;
      }
    }
  }
  
  private GeoPoint a(GeoPoint paramGeoPoint, Rect paramRect)
  {
    AppMethodBeat.i(223307);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(223307);
      return null;
    }
    paramGeoPoint = a(paramGeoPoint);
    if ((paramGeoPoint != null) && (paramRect != null))
    {
      paramGeoPoint = a(new fl(paramGeoPoint.a - (paramRect.left - paramRect.right) * 0.5D, paramGeoPoint.b - (paramRect.top - paramRect.bottom) * 0.5D));
      AppMethodBeat.o(223307);
      return paramGeoPoint;
    }
    AppMethodBeat.o(223307);
    return null;
  }
  
  private GeoPoint a(GeoPoint paramGeoPoint, v.b paramb)
  {
    AppMethodBeat.i(223318);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(223318);
      return null;
    }
    paramGeoPoint = a(paramGeoPoint);
    if ((paramGeoPoint != null) && (paramb != null))
    {
      double d2 = paramGeoPoint.a;
      double d3 = paramGeoPoint.b;
      paramGeoPoint = new Rect(this.c.o);
      int i = paramGeoPoint.width();
      int j = paramGeoPoint.height();
      float f1 = paramb.a + 0.5F;
      float f2 = paramb.b + 0.5F;
      double d1;
      if (f1 < 0.25D)
      {
        d1 = d2 + (0.25D - f1) * i;
        if (f2 >= 0.25D) {
          break label195;
        }
        d2 = f2;
        d2 = d3 + j * (0.25D - d2);
      }
      for (;;)
      {
        paramGeoPoint = a(new fl(d1, d2));
        AppMethodBeat.o(223318);
        return paramGeoPoint;
        d1 = d2;
        if (f1 <= 0.75D) {
          break;
        }
        d1 = d2 - (f1 - 0.75D) * i;
        break;
        label195:
        d2 = d3;
        if (f2 > 0.75D)
        {
          d2 = f2;
          d2 = d3 - j * (d2 - 0.75D);
        }
      }
    }
    AppMethodBeat.o(223318);
    return null;
  }
  
  public static fl a(v paramv, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223210);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(223210);
      return null;
    }
    int i = paramv.d >> 1;
    double d1 = paramv.e;
    double d2 = paramv.f;
    double d3 = Math.min(Math.max(Math.sin(paramGeoPoint.getLatitudeE6() / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
    double d4 = i;
    double d5 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    double d6 = i;
    paramv = new fl(d1 * d5 + d4, d2 * Math.log((1.0D + d3) / (1.0D - d3)) * 0.5D + d6);
    AppMethodBeat.o(223210);
    return paramv;
  }
  
  private static LatLng a(Context paramContext, fl paramfl)
  {
    AppMethodBeat.i(223330);
    double d3 = ha.a(paramContext) * 2.684355E+008F;
    double d1 = d3 / 2.0D;
    double d2 = d3 / 360.0D;
    d3 /= 6.283185307179586D;
    d2 = (paramfl.a - d1) / d2;
    paramContext = new LatLng(Math.asin(1.0D - 2.0D / (Math.pow(2.718281828459045D, (paramfl.b - d1) / 0.5D / d3) + 1.0D)) * 180.0D / 3.141592653589793D, d2);
    AppMethodBeat.o(223330);
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(223249);
    this.b.c(paramInt);
    AppMethodBeat.o(223249);
  }
  
  private void a(v paramv)
  {
    this.b = paramv;
  }
  
  public static ft b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223229);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(223229);
      return null;
    }
    double d = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    paramGeoPoint = new ft(paramGeoPoint.getLongitudeE6() / 1000000.0D * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
    AppMethodBeat.o(223229);
    return paramGeoPoint;
  }
  
  private v b()
  {
    return this.b;
  }
  
  private static LatLng b(ft paramft)
  {
    AppMethodBeat.i(223241);
    if (paramft == null)
    {
      AppMethodBeat.o(223241);
      return null;
    }
    double d = paramft.x() / 20037508.34D;
    paramft = new LatLng(57.295779513082323D * (Math.atan(Math.exp(paramft.y() / 20037508.34D * 180.0D * 3.141592653589793D / 180.0D)) * 2.0D - 1.570796326794897D), d * 180.0D);
    AppMethodBeat.o(223241);
    return paramft;
  }
  
  private void b(float paramFloat)
  {
    AppMethodBeat.i(223266);
    this.b.a(paramFloat);
    AppMethodBeat.o(223266);
  }
  
  private fl c(fl paramfl)
  {
    AppMethodBeat.i(223221);
    if (paramfl == null)
    {
      AppMethodBeat.o(223221);
      return null;
    }
    fl localfl = this.b.q;
    int i = this.b.n.width() / 2;
    int j = this.b.n.height() / 2;
    paramfl = new fl(i + (paramfl.a - localfl.a), j - (paramfl.b - localfl.b));
    AppMethodBeat.o(223221);
    return paramfl;
  }
  
  private boolean c()
  {
    v.b localb = this.b.r;
    if (localb == null) {}
    while ((localb.a == 0.0F) && (localb.b == 0.0F)) {
      return false;
    }
    return true;
  }
  
  private boolean d()
  {
    AppMethodBeat.i(223296);
    v.b localb = this.b.r;
    if (localb == null)
    {
      AppMethodBeat.o(223296);
      return false;
    }
    if ((Math.abs(localb.a) > 0.25D) || (Math.abs(localb.b) > 0.25D))
    {
      AppMethodBeat.o(223296);
      return true;
    }
    AppMethodBeat.o(223296);
    return false;
  }
  
  public final double a(Point paramPoint1, Point paramPoint2)
  {
    AppMethodBeat.i(223544);
    GeoPoint localGeoPoint1 = a(new fl(paramPoint1.x, paramPoint1.y));
    GeoPoint localGeoPoint2 = a(new fl(paramPoint2.x, paramPoint2.y));
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(localGeoPoint1.getLatitudeE6() / 1000000.0D, localGeoPoint1.getLongitudeE6() / 1000000.0D, localGeoPoint2.getLatitudeE6() / 1000000.0D, localGeoPoint2.getLongitudeE6() / 1000000.0D, arrayOfFloat);
    int i = (int)Math.sqrt(Math.pow(paramPoint1.x - paramPoint2.x, 2.0D) + Math.pow(paramPoint1.y - paramPoint2.y, 2.0D));
    double d = arrayOfFloat[0] / i;
    AppMethodBeat.o(223544);
    return d;
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng3)
  {
    AppMethodBeat.i(223601);
    Context localContext = this.c.getContext();
    Object localObject = this.c.i.b();
    boolean bool = this.c.i.M;
    int i3 = ((Rect)localObject).left;
    int i4 = ((Rect)localObject).right;
    int i1 = ((Rect)localObject).top;
    int i2 = ((Rect)localObject).bottom;
    int m = this.c.o.width();
    int n = this.c.o.height();
    float f3 = this.c.t.b.o;
    float f2 = this.c.t.b.n;
    localObject = this.c.t.r;
    if ((m == 0) || (n == 0) || (paramLatLng1 == null) || (paramLatLng2 == null))
    {
      AppMethodBeat.o(223601);
      return -2.0F;
    }
    if ((paramInt1 + paramInt2 + i3 + i4 > m) || (paramInt3 + paramInt4 + i1 + i2 > n))
    {
      AppMethodBeat.o(223601);
      return -1.0F;
    }
    fl localfl1 = a(localContext, paramLatLng1);
    fl localfl2 = a(localContext, paramLatLng2);
    double d2 = localfl2.a - localfl1.a;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = Math.abs(d2);
    }
    d2 = localfl2.b - localfl1.b;
    if (d2 < 0.0D) {
      d2 = Math.abs(d2);
    }
    for (;;)
    {
      int j = m - paramInt1 - paramInt2 - i3 - i4;
      int k = n - paramInt3 - paramInt4 - i1 - i2;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      j = k;
      if (k <= 0) {
        j = 1;
      }
      d1 = Math.max(d1 / i, d2 / j);
      float f4 = (float)(20.0D - Math.log(d1) / Math.log(2.0D));
      float f1 = f4;
      if (f3 < f4)
      {
        d1 = Math.pow(2.0D, 20.0F - f3);
        f1 = f3;
      }
      if (f2 > f1)
      {
        d1 = Math.pow(2.0D, 20.0F - f2);
        f1 = f2;
      }
      for (;;)
      {
        double d3;
        double d4;
        double d5;
        if (paramLatLng3 != null)
        {
          paramLatLng1 = new LatLng((paramLatLng1.latitude + paramLatLng2.latitude) / 2.0D, (paramLatLng1.longitude + paramLatLng2.longitude) / 2.0D);
          d2 = (paramInt2 - paramInt1) * d1 / 2.0D;
          d3 = (paramInt3 - paramInt4) * d1 / 2.0D;
          paramLatLng1 = a(localContext, paramLatLng1);
          paramLatLng1.a = (d2 + paramLatLng1.a);
          paramLatLng1.b = (d3 + paramLatLng1.b);
          d4 = paramLatLng1.a;
          d5 = paramLatLng1.b;
          if (!bool) {
            break label894;
          }
          paramInt1 = i3 - i4;
          paramInt2 = i1 - i2;
          f2 = paramInt1 / (2.0F * m) + 0.5F;
          if (f2 >= 0.25D) {
            break label830;
          }
          paramInt1 = (int)(-0.5D * m);
          f2 = paramInt2 / (2.0F * n) + 0.5F;
          if (f2 >= 0.25D) {
            break label852;
          }
          paramInt2 = (int)(-0.5D * n);
          label623:
          double d7 = paramInt1 * d1 / 2.0D;
          double d6 = paramInt2 * d1 / 2.0D;
          if (localObject != null) {
            break label875;
          }
          d3 = 0.0D;
          d2 = 0.0D;
          label657:
          d3 = d4 - d7 + d3 * m * d1;
          d1 = d5 - d6 - d2 * n * d1;
        }
        for (d2 = d3;; d2 = d4)
        {
          paramLatLng1 = new fl(d2, d1);
          d3 = ha.a(localContext) * 2.684355E+008F;
          d1 = d3 / 2.0D;
          d2 = d3 / 360.0D;
          d3 /= 6.283185307179586D;
          d2 = (paramLatLng1.a - d1) / d2;
          paramLatLng1 = new LatLng(Math.asin(1.0D - 2.0D / (Math.pow(2.718281828459045D, (paramLatLng1.b - d1) / 0.5D / d3) + 1.0D)) * 180.0D / 3.141592653589793D, d2);
          paramLatLng3.latitude = paramLatLng1.latitude;
          paramLatLng3.longitude = paramLatLng1.longitude;
          AppMethodBeat.o(223601);
          return f1;
          label830:
          if (f2 <= 0.75D) {
            break;
          }
          paramInt1 = (int)(0.5D * m);
          break;
          label852:
          if (f2 <= 0.75D) {
            break label623;
          }
          paramInt2 = (int)(0.5D * n);
          break label623;
          label875:
          d3 = ((v.b)localObject).a;
          d2 = ((v.b)localObject).b;
          break label657;
          label894:
          d1 = d5;
        }
      }
    }
  }
  
  public final PointF a(LatLng paramLatLng)
  {
    AppMethodBeat.i(223551);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(223551);
      return null;
    }
    double d1 = paramLatLng.longitude / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.latitude));
    d2 = Math.log((1.0D + d2) / (1.0D - d2)) * 0.5D / -6.283185307179586D;
    paramLatLng = new PointF((float)((d1 + 0.5D) * 268435456.0D), (float)((d2 + 0.5D) * 268435456.0D));
    AppMethodBeat.o(223551);
    return paramLatLng;
  }
  
  public final GeoPoint a(fl paramfl)
  {
    AppMethodBeat.i(223393);
    if (paramfl == null)
    {
      AppMethodBeat.o(223393);
      return null;
    }
    float f4 = (float)paramfl.a;
    float f3 = (float)paramfl.b;
    float f2 = f4;
    float f1 = f3;
    if (this.c != null)
    {
      paramfl = this.c.C;
      f2 = f4;
      f1 = f3;
      if (paramfl != null)
      {
        f2 = f4 - paramfl.left;
        f1 = f3 - paramfl.top;
      }
    }
    paramfl = this.g;
    paramfl = (GeoPoint)paramfl.b(new sc.87(paramfl, null, f2, f1), new GeoPoint());
    AppMethodBeat.o(223393);
    return paramfl;
  }
  
  public final fl a(Context paramContext, LatLng paramLatLng)
  {
    AppMethodBeat.i(223609);
    double d3 = ha.a(paramContext) * 2.684355E+008F;
    double d1 = d3 / 2.0D;
    double d2 = d3 / 360.0D;
    d3 /= 6.283185307179586D;
    double d4 = Math.min(Math.max(Math.sin(paramLatLng.latitude * 0.0174532925199433D), -0.9999D), 0.9999D);
    paramContext = new fl(d2 * paramLatLng.longitude + d1, d3 * Math.log((1.0D + d4) / (1.0D - d4)) * 0.5D + d1);
    AppMethodBeat.o(223609);
    return paramContext;
  }
  
  public final fl a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223406);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(223406);
      return null;
    }
    double d1 = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    paramGeoPoint = this.g.a(d1, d2);
    float f4 = paramGeoPoint.x;
    float f3 = paramGeoPoint.y;
    float f2 = f4;
    float f1 = f3;
    if (this.c != null)
    {
      paramGeoPoint = this.c.C;
      f2 = f4;
      f1 = f3;
      if (paramGeoPoint != null)
      {
        f2 = f4 + paramGeoPoint.left;
        f1 = f3 + paramGeoPoint.top;
      }
    }
    paramGeoPoint = new fl(f2, f1);
    AppMethodBeat.o(223406);
    return paramGeoPoint;
  }
  
  public final LatLng a(PointF paramPointF)
  {
    AppMethodBeat.i(223427);
    float f1 = this.c.t.p.r();
    Object localObject1 = this.b.n;
    float f2 = ((Rect)localObject1).width();
    float f3 = ((Rect)localObject1).height();
    localObject1 = this.b.m;
    if (localObject1 == null)
    {
      paramPointF = new LatLng(0.0D, 0.0D);
      AppMethodBeat.o(223427);
      return paramPointF;
    }
    fl localfl = c(jz.a((GeoPoint)localObject1));
    Object localObject2 = this.b.r;
    android.graphics.Matrix localMatrix;
    if (localObject2 == null)
    {
      localObject1 = new PointF(f2 / 2.0F, f3 / 2.0F);
      localMatrix = new android.graphics.Matrix();
      localMatrix.setRotate(-f1);
      if (localObject2 != null) {
        break label336;
      }
      localMatrix.preTranslate(-0.5F * f2, -0.5F * f3);
      localMatrix.postTranslate(0.5F * f2, 0.5F * f3);
    }
    for (;;)
    {
      localObject2 = new float[2];
      localMatrix.mapPoints((float[])localObject2, new float[] { paramPointF.x, paramPointF.y });
      double d1 = 20037508.34D / ((1 << this.b.b.q) * 256) * gw.m();
      double d2 = localfl.a;
      double d3 = localObject2[0] - ((PointF)localObject1).x;
      double d4 = localfl.b;
      paramPointF = b(new fl(d2 + d3 * d1, (localObject2[1] - ((PointF)localObject1).y) * d1 + d4));
      AppMethodBeat.o(223427);
      return paramPointF;
      localObject1 = new PointF((((v.b)localObject2).a + 0.5F) * f2, (((v.b)localObject2).b + 0.5F) * f3);
      break;
      label336:
      localMatrix.preTranslate((-0.5F - ((v.b)localObject2).a) * f2, (-0.5F - ((v.b)localObject2).b) * f3);
      localMatrix.postTranslate((((v.b)localObject2).a + 0.5F) * f2, (((v.b)localObject2).b + 0.5F) * f3);
    }
  }
  
  public final LatLng a(ft paramft)
  {
    AppMethodBeat.i(223624);
    double d = paramft.x() / 20037508.34D;
    paramft = new LatLng((Math.atan(Math.exp(paramft.y() / 20037508.34D * 180.0D * 3.141592653589793D / 180.0D)) * 2.0D - 1.570796326794897D) * 57.295779513082323D, d * 180.0D);
    AppMethodBeat.o(223624);
    return paramft;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(223561);
    v localv = this.b;
    if (localv.p != null)
    {
      sc localsc = localv.p;
      localsc.a(new sc.160(localsc, paramFloat));
    }
    localv.b.p = paramFloat;
    int i = fv.c;
    AppMethodBeat.o(223561);
  }
  
  public final void a(final List<? extends Boundable> paramList, final List<GeoPoint> paramList1, final Rect paramRect, final ep.a parama)
  {
    AppMethodBeat.i(223580);
    if ((paramList.isEmpty()) && ((paramList1 == null) || (paramList1.isEmpty())))
    {
      AppMethodBeat.o(223580);
      return;
    }
    Object localObject = new Rect(this.c.o);
    ((Rect)localObject).left += paramRect.left;
    ((Rect)localObject).right -= paramRect.right;
    ((Rect)localObject).top += paramRect.top;
    ((Rect)localObject).bottom -= paramRect.bottom;
    final int i = ((Rect)localObject).width();
    final int j = ((Rect)localObject).height();
    localObject = this.c.i.o;
    final int k = ((y)localObject).e;
    this.c.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221508);
        GeoPoint localGeoPoint2 = x.this.b.m;
        float f2 = x.this.b.b.p;
        paramAnonymousGL10 = null;
        float f1 = 4.0F;
        float f3 = x.this.b.b.l;
        for (;;)
        {
          Object localObject;
          GeoPoint localGeoPoint1;
          if (f1 >= f3)
          {
            x.this.a(f1);
            localObject = x.a(x.this, paramList, paramList1);
            localGeoPoint1 = new GeoPoint(((Rect)localObject).centerY(), ((Rect)localObject).centerX());
            x.this.c(localGeoPoint1);
            paramAnonymousGL10 = new GeoPoint(((Rect)localObject).top, ((Rect)localObject).left);
            localObject = new GeoPoint(((Rect)localObject).bottom, ((Rect)localObject).right);
            paramAnonymousGL10 = x.this.a(paramAnonymousGL10);
            localObject = x.this.a((GeoPoint)localObject);
            Rect localRect = new Rect();
            localRect.left = ((int)Math.min(paramAnonymousGL10.a, ((fl)localObject).a));
            localRect.right = ((int)Math.max(paramAnonymousGL10.a, ((fl)localObject).a));
            localRect.top = ((int)Math.min(paramAnonymousGL10.b, ((fl)localObject).b));
            localRect.bottom = ((int)Math.max(paramAnonymousGL10.b, ((fl)localObject).b));
            if ((i < localRect.width()) || (j < localRect.height())) {
              break label413;
            }
            if (x.a(x.this)) {
              break label365;
            }
            paramAnonymousGL10 = x.a(x.this, localGeoPoint1, paramRect);
          }
          for (;;)
          {
            f1 = Math.max(f3, f1);
            if (k != 60) {
              this.g.a(k);
            }
            x.this.c(localGeoPoint2);
            x.this.a(f2);
            if (parama == null) {
              break;
            }
            label365:
            try
            {
              parama.a(f1, paramAnonymousGL10);
              AppMethodBeat.o(221508);
              return;
            }
            catch (Exception paramAnonymousGL10) {}
            paramAnonymousGL10 = localGeoPoint1;
            if (x.b(x.this))
            {
              localObject = x.this.b.r;
              paramAnonymousGL10 = localGeoPoint1;
              if (localObject != null) {
                paramAnonymousGL10 = x.a(x.this, localGeoPoint1, (v.b)localObject);
              }
            }
          }
          label413:
          f1 /= 1.01F;
          paramAnonymousGL10 = localGeoPoint1;
        }
        AppMethodBeat.o(221508);
      }
    });
    if (k != 60) {
      ((y)localObject).e = 60;
    }
    AppMethodBeat.o(223580);
  }
  
  public final LatLng[] a()
  {
    AppMethodBeat.i(223440);
    Object localObject1 = this.c.o;
    float f1 = ((Rect)localObject1).width();
    float f2 = ((Rect)localObject1).height();
    Object localObject2 = new PointF(0.0F, 0.0F);
    Object localObject4 = new PointF(f1, 0.0F);
    Object localObject3 = new PointF(f1, f2);
    localObject1 = new PointF(0.0F, f2);
    localObject2 = this.c.n.a((PointF)localObject2);
    localObject4 = this.c.n.a((PointF)localObject4);
    localObject3 = this.c.n.a((PointF)localObject3);
    localObject1 = this.c.n.a((PointF)localObject1);
    AppMethodBeat.o(223440);
    return new LatLng[] { localObject2, localObject4, localObject3, localObject1 };
  }
  
  public final ft b(LatLng paramLatLng)
  {
    AppMethodBeat.i(223615);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(223615);
      return null;
    }
    paramLatLng = b(GeoPoint.from(paramLatLng));
    AppMethodBeat.o(223615);
    return paramLatLng;
  }
  
  public final void c(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223572);
    Object localObject = this.b;
    int n = paramGeoPoint.getLatitudeE6();
    int k = paramGeoPoint.getLongitudeE6();
    int i = 1 << 20 - ((v)localObject).b.q;
    int j;
    if (131072 > i)
    {
      j = (((v)localObject).n.width() * 131072 - ((v)localObject).n.width() * i) / 2;
      i = (((v)localObject).n.height() * 131072 - i * ((v)localObject).n.height()) / 2;
    }
    for (;;)
    {
      int i1 = ((v)localObject).c.left - j;
      int m = ((v)localObject).c.right + j;
      j = ((v)localObject).c.top - i;
      int i2 = i + ((v)localObject).c.bottom;
      if (n < j) {}
      for (i = j;; i = n)
      {
        j = i;
        if (i > i2) {
          j = i2;
        }
        if (k < i1) {}
        for (i = i1;; i = k)
        {
          k = i;
          if (i > m) {
            k = m;
          }
          paramGeoPoint = new GeoPoint(j, k);
          localObject = ((v)localObject).p;
          ((sc)localObject).j.a(new sc.154((sc)localObject, paramGeoPoint));
          AppMethodBeat.o(223572);
          return;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  public final LatLng fromScreenLocation(Point paramPoint)
  {
    AppMethodBeat.i(223453);
    paramPoint = a(new fl(paramPoint.x, paramPoint.y)).toLatLng();
    AppMethodBeat.o(223453);
    return paramPoint;
  }
  
  public final VisibleRegion getVisibleRegion()
  {
    AppMethodBeat.i(223528);
    Object localObject2 = (sj)this.c.b;
    Object localObject3 = new Point(0, ((sj)localObject2).al);
    Object localObject4 = new Point(((sj)localObject2).ak, ((sj)localObject2).al);
    Object localObject1 = new Point(0, 0);
    localObject2 = new Point(((sj)localObject2).ak, 0);
    localObject3 = fromScreenLocation((Point)localObject3);
    localObject4 = fromScreenLocation((Point)localObject4);
    localObject1 = fromScreenLocation((Point)localObject1);
    localObject2 = fromScreenLocation((Point)localObject2);
    localObject1 = new VisibleRegion((LatLng)localObject3, (LatLng)localObject4, (LatLng)localObject1, (LatLng)localObject2, LatLngBounds.builder().include((LatLng)localObject3).include((LatLng)localObject4).include((LatLng)localObject1).include((LatLng)localObject2).build());
    AppMethodBeat.o(223528);
    return localObject1;
  }
  
  public final float[] glModelMatrix(PointF paramPointF, float paramFloat)
  {
    AppMethodBeat.i(223514);
    if (paramPointF == null)
    {
      AppMethodBeat.o(223514);
      return null;
    }
    float[] arrayOfFloat1 = new float[16];
    android.opengl.Matrix.setIdentityM(arrayOfFloat1, 0);
    Object localObject = this.g.d.nativeGLProjectMatrix();
    float[] arrayOfFloat2 = this.g.y();
    GeoPoint localGeoPoint = this.g.n();
    android.opengl.Matrix.multiplyMM(arrayOfFloat1, 0, (float[])localObject, 0, arrayOfFloat2, 0);
    localObject = a(jz.a(localGeoPoint));
    android.opengl.Matrix.translateM(arrayOfFloat1, 0, paramPointF.x - ((PointF)localObject).x, ((PointF)localObject).y - paramPointF.y, 0.0F);
    android.opengl.Matrix.scaleM(arrayOfFloat1, 0, paramFloat, paramFloat, paramFloat);
    AppMethodBeat.o(223514);
    return arrayOfFloat1;
  }
  
  public final float glPixelRatio()
  {
    AppMethodBeat.i(223535);
    float f1 = this.g.d.nativeGLViewScaleRatio();
    AppMethodBeat.o(223535);
    return f1;
  }
  
  public final float[] glProjectionMatrix()
  {
    AppMethodBeat.i(223483);
    float[] arrayOfFloat = this.g.d.nativeGLProjectMatrix();
    AppMethodBeat.o(223483);
    return arrayOfFloat;
  }
  
  public final PointF glVertexForCoordinate(LatLng paramLatLng)
  {
    AppMethodBeat.i(223499);
    paramLatLng = a(paramLatLng);
    AppMethodBeat.o(223499);
    return paramLatLng;
  }
  
  public final float[] glViewMatrix()
  {
    AppMethodBeat.i(223492);
    float[] arrayOfFloat = this.g.y();
    AppMethodBeat.o(223492);
    return arrayOfFloat;
  }
  
  public final double metersPerPixel(double paramDouble)
  {
    AppMethodBeat.i(223477);
    double d = 40076000.0D / (Math.pow(2.0D, this.b.a()) * 256.0D * gw.m());
    paramDouble = Math.cos(3.141592653589793D * paramDouble / 180.0D);
    AppMethodBeat.o(223477);
    return d * paramDouble;
  }
  
  public final Point toScreenLocation(LatLng paramLatLng)
  {
    AppMethodBeat.i(223466);
    paramLatLng = this.g.a(paramLatLng.latitude, paramLatLng.longitude);
    float f4 = paramLatLng.x;
    float f3 = paramLatLng.y;
    float f2 = f4;
    float f1 = f3;
    if (this.c != null)
    {
      paramLatLng = this.c.C;
      f2 = f4;
      f1 = f3;
      if (paramLatLng != null)
      {
        f2 = f4 + paramLatLng.left;
        f1 = f3 + paramLatLng.top;
      }
    }
    paramLatLng = new fl(f2, f1);
    Point localPoint = new Point();
    localPoint.x = ((int)Math.round(paramLatLng.a));
    localPoint.y = ((int)Math.round(paramLatLng.b));
    AppMethodBeat.o(223466);
    return localPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.x
 * JD-Core Version:    0.7.0.1
 */