package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnDismissCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnTrafficEventClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class bg
  implements ai, aj, al, fe
{
  public bt a;
  public volatile sj b;
  public Context c;
  public bj d;
  public qn e;
  public pi f;
  CameraPosition g;
  final byte[] h;
  ep i;
  public final rz.a j;
  public fh k;
  private String l;
  private pb m;
  private qe n;
  private final GeoPoint o;
  private final GeoPoint p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private float w;
  private final b x;
  private final b y;
  private ac.a z;
  
  public bg(bd parambd, bt parambt, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(225020);
    this.a = null;
    this.b = null;
    this.c = null;
    this.l = null;
    this.d = null;
    this.m = null;
    this.n = null;
    this.e = null;
    this.o = null;
    this.p = null;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.h = new byte[0];
    this.u = -1;
    this.v = 1000;
    this.w = 1.0F;
    this.x = new b(false);
    this.y = new b(true);
    this.z = new ac.a()
    {
      public final void a(iu paramAnonymousiu)
      {
        AppMethodBeat.i(226101);
        if (paramAnonymousiu.z != 10000)
        {
          AppMethodBeat.o(226101);
          return;
        }
        if (!(paramAnonymousiu instanceof rz))
        {
          AppMethodBeat.o(226101);
          return;
        }
        sj localsj = bg.this.b;
        if (localsj == null)
        {
          AppMethodBeat.o(226101);
          return;
        }
        VectorMap localVectorMap = (VectorMap)localsj.e_;
        if (localVectorMap == null)
        {
          AppMethodBeat.o(226101);
          return;
        }
        paramAnonymousiu = (rz)paramAnonymousiu;
        int j;
        if (paramAnonymousiu.Q)
        {
          i = paramAnonymousiu.R;
          j = paramAnonymousiu.S;
          localVectorMap.b(localsj.ak / 2 - i, localsj.al / 2 - j);
        }
        if (paramAnonymousiu.h) {
          localVectorMap.b(paramAnonymousiu.K, paramAnonymousiu.L);
        }
        if ((paramAnonymousiu.N) || (paramAnonymousiu.M) || (paramAnonymousiu.O)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            double d = (float)paramAnonymousiu.P;
            localVectorMap.o.i.a((float)d);
          }
          if (paramAnonymousiu.T)
          {
            i = paramAnonymousiu.aa;
            j = paramAnonymousiu.ab;
            localVectorMap.a(i, j);
            if (paramAnonymousiu.g) {
              localsj.b(i, j);
            }
          }
          if (paramAnonymousiu.ac) {
            localVectorMap.b(paramAnonymousiu.ag);
          }
          if (paramAnonymousiu.ah) {
            localVectorMap.a(paramAnonymousiu.al);
          }
          if (paramAnonymousiu.Q)
          {
            i = paramAnonymousiu.R;
            j = paramAnonymousiu.S;
            localVectorMap.b(i - localsj.ak / 2, j - localsj.al / 2);
          }
          AppMethodBeat.o(226101);
          return;
        }
      }
    };
    this.j = new rz.a()
    {
      public final float a()
      {
        AppMethodBeat.i(226121);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226121);
          return 0.0F;
        }
        float f = ((VectorMap)bg.this.b.e_).s();
        AppMethodBeat.o(226121);
        return f;
      }
      
      public final void a(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(226174);
        if (paramAnonymousRunnable == null)
        {
          AppMethodBeat.o(226174);
          return;
        }
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226174);
          return;
        }
        jw.a(paramAnonymousRunnable, 100L);
        AppMethodBeat.o(226174);
      }
      
      public final int b()
      {
        AppMethodBeat.i(226126);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226126);
          return 0;
        }
        int i = ((VectorMap)bg.this.b.e_).p();
        AppMethodBeat.o(226126);
        return i;
      }
      
      public final GeoPoint c()
      {
        AppMethodBeat.i(226135);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226135);
          return null;
        }
        GeoPoint localGeoPoint = ((VectorMap)bg.this.b.e_).q();
        AppMethodBeat.o(226135);
        return localGeoPoint;
      }
      
      public final float d()
      {
        AppMethodBeat.i(226140);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226140);
          return 0.0F;
        }
        float f = ((VectorMap)bg.this.b.e_).t();
        AppMethodBeat.o(226140);
        return f;
      }
      
      public final float e()
      {
        AppMethodBeat.i(226149);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226149);
          return 0.0F;
        }
        float f = ((VectorMap)bg.this.b.e_).u();
        AppMethodBeat.o(226149);
        return f;
      }
      
      public final float f()
      {
        AppMethodBeat.i(226155);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226155);
          return 0.0F;
        }
        float f = bg.this.D();
        AppMethodBeat.o(226155);
        return f;
      }
      
      public final GeoPoint g()
      {
        AppMethodBeat.i(226163);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226163);
          return null;
        }
        GeoPoint localGeoPoint = bg.this.b.s();
        AppMethodBeat.o(226163);
        return localGeoPoint;
      }
      
      public final boolean h()
      {
        if (bg.this.b == null) {
          return false;
        }
        return bg.this.b.o.f;
      }
    };
    this.k = new fh()
    {
      public final void u()
      {
        AppMethodBeat.i(226173);
        jw.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222995);
            if (bg.this.b == null)
            {
              AppMethodBeat.o(222995);
              return;
            }
            bg.this.b.a(((VectorMap)bg.this.b.e_).o.t.a());
            AppMethodBeat.o(222995);
          }
        });
        AppMethodBeat.o(226173);
      }
    };
    this.c = parambd.getContext().getApplicationContext();
    this.w = ha.a(this.c);
    this.a = parambt;
    this.b = ((sj)parambd.b());
    if (gv.b != null)
    {
      parambt = gv.b;
      if (gv.a.b() != 0) {}
    }
    else
    {
      gv.b = new gv.a(this.c, Math.max(10, paramTencentMapOptions.getMaxIconMemoryCacheSize()) * 1048576);
    }
    for (;;)
    {
      this.b.a(this);
      this.i = ((VectorMap)this.b.e_).v();
      parambt = (VectorMap)this.b.e_;
      ac.a locala = this.z;
      parambt.o.i.D = locala;
      ((VectorMap)this.b.e_).a(this.k);
      if ((paramTencentMapOptions != null) && (!gz.a(paramTencentMapOptions.getSubKey()))) {
        this.l = paramTencentMapOptions.getSubKey();
      }
      this.n = this.b.aB.H;
      this.f = new pi(this.c, this.n, this.b.S());
      this.e = new qn(this.c, this.l);
      if (this.d == null) {
        this.d = new bj(parambd, this.b.d, this.a);
      }
      AppMethodBeat.o(225020);
      return;
      parambt = gv.b;
      gv.a.a();
    }
  }
  
  private bj E()
  {
    return this.d;
  }
  
  private qn F()
  {
    return this.e;
  }
  
  private pi G()
  {
    return this.f;
  }
  
  private void H()
  {
    AppMethodBeat.i(225057);
    if (this.b != null)
    {
      ((VectorMap)this.b.e_).b(this.k);
      sj localsj = this.b;
      if (localsj.B != null) {
        localsj.B.removeCallbacksAndMessages(null);
      }
      if (localsj.H != null) {
        localsj.H.removeCallbacksAndMessages(null);
      }
      if (localsj.r != null)
      {
        localsj.r.clear();
        localsj.r = null;
      }
      localsj.l();
      localsj.s = null;
      localsj.z = null;
      localsj.v = null;
      localsj.D = null;
      localsj.p = null;
      this.b = null;
    }
    if (this.c != null) {
      this.c = null;
    }
    if (gv.b != null) {
      gv.b.c();
    }
    AppMethodBeat.o(225057);
  }
  
  private sj I()
  {
    return this.b;
  }
  
  private Context J()
  {
    return this.c;
  }
  
  private float a(double paramDouble, LatLng paramLatLng)
  {
    AppMethodBeat.i(225290);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(225290);
      return 0.0F;
    }
    paramLatLng = new GeoPoint((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
    mk localmk = ((VectorMap)this.b.e_).o;
    if ((localmk.t == null) || (localmk.n == null))
    {
      AppMethodBeat.o(225290);
      return 0.0F;
    }
    double d1 = localmk.n.metersPerPixel(paramLatLng.getLatitudeE6() / 1000000.0D);
    if (d1 != 0.0D)
    {
      float f1 = (float)(paramDouble / d1);
      AppMethodBeat.o(225290);
      return f1;
    }
    AppMethodBeat.o(225290);
    return 0.0F;
  }
  
  private int a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225204);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(225204);
      return -1;
    }
    if ((paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null))
    {
      AppMethodBeat.o(225204);
      return -1;
    }
    if ((this.b.ak == 0) || (this.b.al == 0))
    {
      this.b.ad = paramLatLngBounds.southwest;
      this.b.ae = paramLatLngBounds.northeast;
      this.b.ag = paramInt1;
      this.b.ah = paramInt2;
      this.b.ai = paramInt3;
      this.b.aj = paramInt4;
      this.b.C = paramCancelableCallback;
      if (paramBoolean) {}
      for (this.b.E = this.y;; this.b.E = this.x)
      {
        int i1 = ha.b(this.c);
        int i2 = ha.c(this.c);
        if ((paramInt1 + paramInt2 + this.q + this.s <= i1) && (paramInt3 + paramInt4 + this.r + this.t <= i2)) {
          break;
        }
        AppMethodBeat.o(225204);
        return -1;
      }
      AppMethodBeat.o(225204);
      return 0;
    }
    this.b.E = null;
    LatLng localLatLng = new LatLng();
    float f1 = this.i.a(paramLatLngBounds.southwest, paramLatLngBounds.northeast, paramInt1, paramInt2, paramInt3, paramInt4, localLatLng);
    if (f1 < 0.0F)
    {
      paramInt1 = (int)f1;
      AppMethodBeat.o(225204);
      return paramInt1;
    }
    if (!paramBoolean)
    {
      ((VectorMap)this.b.e_).a((int)(localLatLng.latitude * 1000000.0D), (int)(localLatLng.longitude * 1000000.0D));
      a(f1, false, paramLong, null);
      ((VectorMap)this.b.e_).b(0.0F);
      ((VectorMap)this.b.e_).a(0.0F);
    }
    for (;;)
    {
      AppMethodBeat.o(225204);
      return 0;
      paramLatLngBounds = new rz();
      paramLatLngBounds.c(0.0F);
      paramLatLngBounds.d(0.0F);
      paramLatLngBounds.b((int)(localLatLng.latitude * 1000000.0D), (int)(localLatLng.longitude * 1000000.0D));
      paramLatLngBounds.a(f1);
      paramLatLngBounds.a = this.j;
      paramLatLngBounds.f = paramCancelableCallback;
      paramLatLngBounds.a(paramLong);
      ((VectorMap)this.b.e_).a(paramLatLngBounds);
    }
  }
  
  private int a(LatLngBounds paramLatLngBounds, int paramInt, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225173);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(225173);
      return -1;
    }
    if ((paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null))
    {
      AppMethodBeat.o(225173);
      return -1;
    }
    if ((this.b.ak == 0) || (this.b.al == 0))
    {
      this.b.ad = paramLatLngBounds.southwest;
      this.b.ae = paramLatLngBounds.northeast;
      this.b.af = paramInt;
      this.b.C = paramCancelableCallback;
      if (paramBoolean) {}
      for (this.b.E = this.y;; this.b.E = this.x)
      {
        int i1 = ha.b(this.c);
        int i2 = ha.c(this.c);
        if ((paramInt * 2 + this.q + this.s <= i1) && (paramInt * 2 + this.r + this.t <= i2)) {
          break;
        }
        AppMethodBeat.o(225173);
        return -1;
      }
      AppMethodBeat.o(225173);
      return 0;
    }
    this.b.E = null;
    LatLng localLatLng = new LatLng(0.0D, 0.0D);
    float f1 = this.i.a(paramLatLngBounds.southwest, paramLatLngBounds.northeast, paramInt, paramInt, paramInt, paramInt, localLatLng);
    if (f1 < 0.0F)
    {
      paramInt = (int)f1;
      AppMethodBeat.o(225173);
      return paramInt;
    }
    if (!paramBoolean)
    {
      ((VectorMap)this.b.e_).a((int)(localLatLng.latitude * 1000000.0D), (int)(localLatLng.longitude * 1000000.0D));
      a(f1, false, paramLong, null);
    }
    for (;;)
    {
      AppMethodBeat.o(225173);
      return 0;
      paramLatLngBounds = new rz();
      paramLatLngBounds.b((int)(localLatLng.latitude * 1000000.0D), (int)(localLatLng.longitude * 1000000.0D));
      paramLatLngBounds.a(f1);
      paramLatLngBounds.a = this.j;
      paramLatLngBounds.f = paramCancelableCallback;
      paramLatLngBounds.a(paramLong);
      ((VectorMap)this.b.e_).a(paramLatLngBounds);
    }
  }
  
  private int a(List<eq> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, final boolean paramBoolean, final long paramLong, final TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225213);
    ep localep = ((VectorMap)this.b.e_).v();
    if (localep == null)
    {
      AppMethodBeat.o(225213);
      return -2147483648;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(225213);
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      eq localeq = (eq)paramList.next();
      if ((localeq != null) && (localeq.getGroupBounds() != null)) {
        localArrayList.addAll(localeq.getGroupBounds());
      }
    }
    if ((this.b.ak == 0) || (this.b.al == 0))
    {
      int i1 = ha.b(this.c);
      int i2 = ha.c(this.c);
      if ((paramInt1 + paramInt2 > i1) || (paramInt3 + paramInt4 > i2))
      {
        AppMethodBeat.o(225213);
        return -1;
      }
      AppMethodBeat.o(225213);
      return 0;
    }
    if ((paramInt1 + paramInt2 > this.b.ak) || (paramInt3 + paramInt4 > this.b.al))
    {
      AppMethodBeat.o(225213);
      return -1;
    }
    localep.a(localArrayList, null, new Rect(paramInt1, paramInt3, paramInt2, paramInt4), new ep.a()
    {
      public final void a(final float paramAnonymousFloat, final GeoPoint paramAnonymousGeoPoint)
      {
        AppMethodBeat.i(226119);
        if (bg.this.b == null)
        {
          AppMethodBeat.o(226119);
          return;
        }
        jw.a(new Runnable()
        {
          public final void run()
          {
            double d1 = 0.0D;
            AppMethodBeat.i(225599);
            if (bg.this.b == null)
            {
              AppMethodBeat.o(225599);
              return;
            }
            double d2;
            if (bg.3.this.a)
            {
              d2 = (int)bg.this.b() - Math.log(1.0F / paramAnonymousFloat) / Math.log(2.0D) - 2.0D;
              if (d2 >= 0.0D) {
                break label254;
              }
            }
            for (;;)
            {
              Object localObject = new rz();
              ((rz)localObject).b(paramAnonymousGeoPoint.getLatitudeE6(), paramAnonymousGeoPoint.getLongitudeE6());
              ((rz)localObject).a((float)d1);
              ((rz)localObject).a = bg.this.j;
              ((rz)localObject).f = bg.3.this.b;
              ((rz)localObject).a(bg.3.this.c);
              ((VectorMap)bg.this.b.e_).a((iu)localObject);
              AppMethodBeat.o(225599);
              return;
              localObject = (VectorMap)bg.this.b.e_;
              GeoPoint localGeoPoint = paramAnonymousGeoPoint;
              ((VectorMap)localObject).o.i.a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6(), 1);
              ((VectorMap)bg.this.b.e_).a(paramAnonymousFloat);
              AppMethodBeat.o(225599);
              return;
              label254:
              d1 = d2;
            }
          }
        });
        AppMethodBeat.o(226119);
      }
    });
    AppMethodBeat.o(225213);
    return 0;
  }
  
  private void a(double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225144);
    if (this.b == null)
    {
      AppMethodBeat.o(225144);
      return;
    }
    int i1 = (int)(1000000.0D * paramDouble1);
    int i2 = (int)(1000000.0D * paramDouble2);
    Object localObject = this.b;
    int i3 = ((VectorMap)this.b.e_).o();
    if (paramFloat < i3) {
      paramFloat = i3;
    }
    for (;;)
    {
      float f1 = paramFloat;
      if (paramFloat > 20.0F) {
        f1 = 20.0F;
      }
      paramDouble1 = 1.0D / Math.pow(2.0D, 20.0F - f1);
      if (!paramBoolean)
      {
        ((VectorMap)this.b.e_).a(i1, i2);
        ((VectorMap)this.b.e_).a((float)paramDouble1);
        AppMethodBeat.o(225144);
        return;
      }
      localObject = new rz();
      ((rz)localObject).b(i1, i2);
      ((rz)localObject).a(f1);
      ((rz)localObject).a = this.j;
      ((rz)localObject).f = paramCancelableCallback;
      ((rz)localObject).a(paramLong);
      ((VectorMap)this.b.e_).a((iu)localObject);
      AppMethodBeat.o(225144);
      return;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225155);
    if (this.b == null)
    {
      AppMethodBeat.o(225155);
      return;
    }
    int i1 = (int)(paramDouble1 * 1000000.0D);
    int i2 = (int)(1000000.0D * paramDouble2);
    if (!paramBoolean)
    {
      ((VectorMap)this.b.e_).a(i1, i2);
      AppMethodBeat.o(225155);
      return;
    }
    rz localrz = new rz();
    localrz.b(i1, i2);
    localrz.a = this.j;
    localrz.f = paramCancelableCallback;
    localrz.a(paramLong);
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225155);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(225280);
    sj localsj = this.b;
    float f2;
    if (localsj.aB != null)
    {
      float f1 = localsj.aB.i.A.b.p;
      f2 = sr.b(paramFloat3);
      if (Math.abs(f1 - f2) <= 0.0001D) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      localsj.aD = 0;
      jw.a(new sr.1(localsj, (paramFloat2 - localsj.aC) / 10.0F, paramFloat1, paramFloat2, paramFloat3, bool, f2));
      AppMethodBeat.o(225280);
      return;
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225119);
    if (this.b == null)
    {
      AppMethodBeat.o(225119);
      return;
    }
    if (paramFloat1 == 0.0F)
    {
      AppMethodBeat.o(225119);
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat1 < 0.0F) {}
      for (paramFloat1 = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat1)));; paramFloat1 = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat1))))
      {
        paramCancelableCallback = (VectorMap)this.b.e_;
        double d1 = paramFloat1;
        double d2 = paramFloat2;
        double d3 = paramFloat3;
        paramCancelableCallback.o.i.a(d1, d2, d3, d2, d3, null);
        AppMethodBeat.o(225119);
        return;
      }
    }
    rz localrz = new rz();
    localrz.a((int)paramFloat2, (int)paramFloat3);
    localrz.b(paramFloat1);
    localrz.a = this.j;
    localrz.f = paramCancelableCallback;
    localrz.a(paramLong);
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225119);
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225093);
    if (this.b == null)
    {
      AppMethodBeat.o(225093);
      return;
    }
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
    {
      AppMethodBeat.o(225093);
      return;
    }
    if (!paramBoolean)
    {
      ((VectorMap)this.b.e_).b((int)paramFloat1, (int)paramFloat2);
      AppMethodBeat.o(225093);
      return;
    }
    rz localrz = new rz();
    int i1 = (int)paramFloat1;
    int i2 = (int)paramFloat2;
    if ((i1 == 0) && (i2 == 0)) {
      localrz.h = false;
    }
    localrz.I = i1;
    localrz.J = i2;
    localrz.h = true;
    localrz.a = this.j;
    localrz.f = paramCancelableCallback;
    localrz.a(paramLong);
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225093);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(225266);
    Object localObject = (VectorMap)this.b.e_;
    if (((VectorMap)localObject).o != null)
    {
      localObject = ((VectorMap)localObject).o;
      if (((mk)localObject).g != null)
      {
        localObject = ((mk)localObject).g;
        ((sc)localObject).a(new sc.16((sc)localObject, paramInt2, paramInt1, paramInt3, paramInt4));
      }
    }
    AppMethodBeat.o(225266);
  }
  
  private void a(bj.a parama)
  {
    bj localbj = this.d;
    if (localbj.d != null) {
      localbj.d.d = parama;
    }
  }
  
  private void a(rd.c paramc, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(225043);
    bj localbj = this.d;
    if ((paramTencentMapOptions != null) && (paramTencentMapOptions.getExtSurface() != null) && (localbj.e != null) && (paramTencentMapOptions != null))
    {
      rd localrd = localbj.e;
      if ((localrd.o != null) && (paramc != null)) {
        localrd.o.add(paramc);
      }
      int i1 = paramTencentMapOptions.getExtSurfaceWidth();
      int i2 = paramTencentMapOptions.getExtSurfaceHeight();
      localbj.b.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
      localbj.b(i1, i2);
    }
    AppMethodBeat.o(225043);
  }
  
  private void a(CameraPosition paramCameraPosition, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225132);
    if (this.b == null)
    {
      AppMethodBeat.o(225132);
      return;
    }
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(225132);
      return;
    }
    GeoPoint localGeoPoint = GeoPoint.from(paramCameraPosition.target);
    float f1 = paramCameraPosition.zoom;
    Object localObject = this.b;
    int i1 = ((VectorMap)this.b.e_).o();
    if (f1 < i1) {
      f1 = i1;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 > 20.0F) {
        f2 = 20.0F;
      }
      if (!paramBoolean)
      {
        double d1 = 1.0D / Math.pow(2.0D, 20.0F - f2);
        if (localGeoPoint != null) {
          ((VectorMap)this.b.e_).a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
        }
        ((VectorMap)this.b.e_).a((float)d1);
        ((VectorMap)this.b.e_).b(paramCameraPosition.bearing);
        if (paramCameraPosition.tilt >= 0.0F) {
          ((VectorMap)this.b.e_).a(paramCameraPosition.tilt);
        }
        AppMethodBeat.o(225132);
        return;
      }
      localObject = new rz();
      if (localGeoPoint != null) {
        ((rz)localObject).b(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
      }
      ((rz)localObject).a(f2);
      ((rz)localObject).c(paramCameraPosition.bearing);
      if (paramCameraPosition.tilt >= 0.0F) {
        ((rz)localObject).d(paramCameraPosition.tilt);
      }
      ((rz)localObject).a = this.j;
      ((rz)localObject).a(paramLong);
      ((rz)localObject).f = paramCancelableCallback;
      ((VectorMap)this.b.e_).a((iu)localObject);
      AppMethodBeat.o(225132);
      return;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225070);
    if (!paramBoolean)
    {
      float f1 = ((VectorMap)this.b.e_).s();
      ((VectorMap)this.b.e_).c(2.0F * f1);
      AppMethodBeat.o(225070);
      return;
    }
    rz localrz = new rz();
    localrz.b(1.0F);
    localrz.a = this.j;
    localrz.f = paramCancelableCallback;
    localrz.a(paramLong);
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225070);
  }
  
  private static List<eq> b(List<IOverlay> paramList)
  {
    AppMethodBeat.i(225224);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IOverlay localIOverlay = (IOverlay)paramList.next();
      if ((localIOverlay instanceof eq)) {
        localArrayList.add((eq)localIOverlay);
      }
    }
    AppMethodBeat.o(225224);
    return localArrayList;
  }
  
  private void b(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225186);
    if (paramBoolean)
    {
      rz localrz = new rz();
      localrz.c(paramFloat1);
      if (paramFloat2 >= 0.0F) {
        localrz.d(paramFloat2);
      }
      localrz.a = this.j;
      localrz.f = paramCancelableCallback;
      localrz.a(paramLong);
      ((VectorMap)this.b.e_).a(localrz);
      AppMethodBeat.o(225186);
      return;
    }
    ((VectorMap)this.b.e_).b(paramFloat1);
    if (paramFloat2 >= 0.0F) {
      ((VectorMap)this.b.e_).a(paramFloat2);
    }
    AppMethodBeat.o(225186);
  }
  
  private void b(float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225104);
    if (this.b == null)
    {
      AppMethodBeat.o(225104);
      return;
    }
    if (paramFloat == 0.0F)
    {
      AppMethodBeat.o(225104);
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat < 0.0F) {}
      for (paramFloat = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat)));; paramFloat = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat))))
      {
        float f1 = ((VectorMap)this.b.e_).s();
        ((VectorMap)this.b.e_).a(paramFloat * f1);
        AppMethodBeat.o(225104);
        return;
      }
    }
    rz localrz = new rz();
    localrz.b(paramFloat);
    localrz.a = this.j;
    localrz.f = paramCancelableCallback;
    localrz.a(paramLong);
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225104);
  }
  
  private void b(boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225082);
    if (!paramBoolean)
    {
      float f1 = ((VectorMap)this.b.e_).s() / 2.0F;
      ((VectorMap)this.b.e_).c(f1);
      AppMethodBeat.o(225082);
      return;
    }
    rz localrz = new rz();
    localrz.b(-1.0F);
    localrz.a = this.j;
    localrz.f = paramCancelableCallback;
    localrz.a(paramLong);
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225082);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    Object localObject = (VectorMap)this.b.e_;
    if (((VectorMap)localObject).o != null)
    {
      localObject = ((VectorMap)localObject).o.i;
      ((ac)localObject).E = paramFloat1;
      ((ac)localObject).F = paramFloat2;
    }
  }
  
  private void j(boolean paramBoolean)
  {
    AppMethodBeat.i(225248);
    this.a.setZOrderMediaOverlay(paramBoolean);
    AppMethodBeat.o(225248);
  }
  
  public final int A()
  {
    return this.v;
  }
  
  public final VisibleRegion B()
  {
    AppMethodBeat.i(225410);
    Object localObject2 = new Point(0, this.b.al);
    Object localObject4 = new Point(this.b.ak, this.b.al);
    Object localObject3 = new Point(0, 0);
    Object localObject1 = new Point(this.b.ak, 0);
    localObject2 = a((Point)localObject2);
    localObject4 = a((Point)localObject4);
    localObject3 = a((Point)localObject3);
    localObject1 = a((Point)localObject1);
    localObject1 = new VisibleRegion((LatLng)localObject2, (LatLng)localObject4, (LatLng)localObject3, (LatLng)localObject1, LatLngBounds.builder().include((LatLng)localObject2).include((LatLng)localObject4).include((LatLng)localObject3).include((LatLng)localObject1).build());
    AppMethodBeat.o(225410);
    return localObject1;
  }
  
  public final bt C()
  {
    return this.a;
  }
  
  public final float D()
  {
    AppMethodBeat.i(225738);
    float f1 = ((VectorMap)this.b.e_).o.t.a();
    AppMethodBeat.o(225738);
    return f1;
  }
  
  public final double a(double paramDouble)
  {
    AppMethodBeat.i(225402);
    paramDouble = ((VectorMap)this.b.e_).v().metersPerPixel(paramDouble);
    AppMethodBeat.o(225402);
    return paramDouble;
  }
  
  public final float a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(225723);
    int i2 = this.b.ak;
    int i1 = this.b.al;
    if ((i2 == 0) || (i1 == 0) || (paramLatLng1 == null) || (paramLatLng2 == null))
    {
      AppMethodBeat.o(225723);
      return 0.0F;
    }
    sj localsj = this.b;
    paramLatLng1 = this.i.a(this.c, paramLatLng1);
    paramLatLng2 = this.i.a(this.c, paramLatLng2);
    double d2 = paramLatLng2.a - paramLatLng1.a;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = Math.abs(d2);
    }
    double d3 = paramLatLng2.b - paramLatLng1.b;
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = Math.abs(d3);
    }
    paramInt2 = i2 - paramInt1 - paramInt2;
    float f1 = paramFloat;
    if (paramFloat == 90.0F) {
      f1 = 89.0F;
    }
    paramInt3 = (int)((i1 - paramInt3 - paramInt4) / Math.cos(f1 * 3.141592653589793D / 180.0D));
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    paramInt2 = paramInt3;
    if (paramInt3 <= 0) {
      paramInt2 = 1;
    }
    double d4 = Math.log(1.0D * d1 / paramInt1) / Math.log(2.0D);
    d3 = Math.log(d2 * 1.0D / paramInt2) / Math.log(2.0D);
    d1 = d4;
    if (d4 < 0.0D) {
      d1 = 0.0D;
    }
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = 0.0D;
    }
    paramFloat = (float)(20.0D - Math.max(d1, d2));
    AppMethodBeat.o(225723);
    return paramFloat;
  }
  
  public final float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    AppMethodBeat.i(225773);
    float f1 = this.i.a(paramLatLng1, paramLatLng2, paramInt1, paramInt2, paramInt3, paramInt4, paramLatLng3);
    AppMethodBeat.o(225773);
    return f1;
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(225623);
    float f1 = a(0, 0, 0, 0, paramLatLng1, paramLatLng2, null);
    AppMethodBeat.o(225623);
    return f1;
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(225765);
    if ((paramLatLng1 == null) || (paramLatLng2 == null))
    {
      AppMethodBeat.o(225765);
      return 0.0F;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramLatLng1);
    localBuilder.include(paramLatLng2);
    if (!paramBoolean) {
      paramFloat = 0.0F;
    }
    for (;;)
    {
      paramFloat = a(paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, localBuilder.build().southwest, localBuilder.build().northeast);
      AppMethodBeat.o(225765);
      return paramFloat;
    }
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt, boolean paramBoolean)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(225755);
    if ((paramLatLng1 == null) || (paramLatLng2 == null))
    {
      AppMethodBeat.o(225755);
      return 0.0F;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramLatLng1);
    localBuilder.include(paramLatLng2);
    if (!paramBoolean) {
      paramFloat = f1;
    }
    for (;;)
    {
      paramFloat = a(paramFloat, 0, 0, paramInt, 0, localBuilder.build().southwest, localBuilder.build().northeast);
      AppMethodBeat.o(225755);
      return paramFloat;
    }
  }
  
  public final float a(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(225750);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(225750);
      return 0.0F;
    }
    int i1;
    if (paramBoolean)
    {
      i1 = this.b.L;
      if (paramBoolean) {
        break label110;
      }
      paramFloat = f1;
    }
    label110:
    for (;;)
    {
      int i2 = i1;
      if (i1 < 0) {
        i2 = this.b.ak / 2;
      }
      paramFloat = a(paramFloat, 0, 0, paramInt, this.b.al - i2, paramLatLngBounds.southwest, paramLatLngBounds.northeast);
      AppMethodBeat.o(225750);
      return paramFloat;
      i1 = this.b.N;
      break;
    }
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(225733);
    Object localObject = ((VectorMap)this.b.e_).o.i;
    ((ac)localObject).H = paramInt1;
    ((ac)localObject).I = paramInt2;
    ((ac)localObject).J = paramInt3;
    ((ac)localObject).K = paramInt4;
    int i1;
    if ((((ac)localObject).C != null) && (((ac)localObject).C.width() > 0) && (((ac)localObject).C.height() > 0)) {
      if ((paramInt1 + paramInt3 > ((ac)localObject).C.width()) || (paramInt2 + paramInt4 > ((ac)localObject).C.height())) {
        i1 = -1;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        this.q = paramInt1;
        this.r = paramInt2;
        this.s = paramInt3;
        this.t = paramInt4;
      }
      AppMethodBeat.o(225733);
      return i1;
      PointF localPointF = ((ac)localObject).a();
      ((ac)localObject).a(localPointF.x, localPointF.y, paramBoolean);
      i1 = 0;
      continue;
      ((ac)localObject).a(new ac.1((ac)localObject, paramBoolean));
      if ((((ac)localObject).z instanceof mk))
      {
        localObject = ((mk)((ac)localObject).z).getContext();
        if ((paramInt1 + paramInt3 > ha.b((Context)localObject)) || (paramInt2 + paramInt4 > ha.c((Context)localObject))) {
          i1 = -1;
        } else {
          i1 = 0;
        }
      }
      else
      {
        i1 = -2;
      }
    }
  }
  
  public final int a(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(225481);
    if (paramCameraUpdate == null)
    {
      AppMethodBeat.o(225481);
      return -1;
    }
    paramCameraUpdate = paramCameraUpdate.getParams();
    if (paramCameraUpdate == null)
    {
      AppMethodBeat.o(225481);
      return -1;
    }
    switch (paramCameraUpdate.iCamerType)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        AppMethodBeat.o(225481);
        return 0;
        a(false, 0L, null);
        continue;
        b(false, 0L, null);
        continue;
        a(paramCameraUpdate.scrollBy_xPixel, paramCameraUpdate.scrollBy_yPixel, false, 0L, null);
        continue;
        a(paramCameraUpdate.zoomTo_zoom, false, 0L, null);
        continue;
        b(paramCameraUpdate.zoomBy_amount, false, 0L, null);
        continue;
        a(paramCameraUpdate.zoomBy_Point_amount, paramCameraUpdate.zoomBy_Point_focus.x, paramCameraUpdate.zoomBy_Point_focus.y, false, 0L, null);
        continue;
        a(paramCameraUpdate.newCameraPosition_cameraPosition, false, 0L, null);
        continue;
        if (paramCameraUpdate.newLatLng_latLng != null)
        {
          a(paramCameraUpdate.newLatLng_latLng.latitude, paramCameraUpdate.newLatLng_latLng.longitude, false, 0L, null);
          continue;
          if (paramCameraUpdate.newLatLngZoom_latLng != null)
          {
            a(paramCameraUpdate.newLatLngZoom_latLng.latitude, paramCameraUpdate.newLatLngZoom_latLng.longitude, paramCameraUpdate.newLatLngZoom_zoom, false, 0L, null);
            continue;
            i1 = a(paramCameraUpdate.newLatLngBounds_bounds, paramCameraUpdate.newLatLngBounds_padding, false, 0L, null);
            AppMethodBeat.o(225481);
            return i1;
            i1 = a(paramCameraUpdate.newLatLngBounds_dimension_bounds, paramCameraUpdate.newLatLngBounds_dimension_padding, paramCameraUpdate.newLatLngBounds_dimension_padding, paramCameraUpdate.newLatLngBounds_dimension_padding, paramCameraUpdate.newLatLngBounds_dimension_padding, false, 0L, null);
            AppMethodBeat.o(225481);
            return i1;
            i1 = a(paramCameraUpdate.newLatLngBounds_dimension_bounds, paramCameraUpdate.newLatLngBoundsRects_padLeft, paramCameraUpdate.newLatLngBoundsRects_padRight, paramCameraUpdate.newLatLngBoundsRects_padTop, paramCameraUpdate.newLatLngBoundsRects_padBom, false, 0L, null);
            AppMethodBeat.o(225481);
            return i1;
            b(paramCameraUpdate.rotateto_rotate, paramCameraUpdate.rotateto_skew, false, 0L, null);
          }
        }
      }
    }
    int i1 = a(b(paramCameraUpdate.elements), paramCameraUpdate.newLatLngBoundsRects_padLeft, paramCameraUpdate.newLatLngBoundsRects_padRight, paramCameraUpdate.newLatLngBoundsRects_padTop, paramCameraUpdate.newLatLngBoundsRects_padBom, false, 0L, null);
    AppMethodBeat.o(225481);
    return i1;
  }
  
  public final int a(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225496);
    if (paramCameraUpdate == null)
    {
      AppMethodBeat.o(225496);
      return -1;
    }
    paramCameraUpdate = paramCameraUpdate.getParams();
    if (paramCameraUpdate == null)
    {
      AppMethodBeat.o(225496);
      return -1;
    }
    if (paramLong < 0L) {
      paramLong = 0L;
    }
    switch (paramCameraUpdate.iCamerType)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        AppMethodBeat.o(225496);
        return 0;
        break;
        a(true, paramLong, paramCancelableCallback);
        continue;
        b(true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.scrollBy_xPixel, paramCameraUpdate.scrollBy_yPixel, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.zoomTo_zoom, true, paramLong, paramCancelableCallback);
        continue;
        b(paramCameraUpdate.zoomBy_amount, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.zoomBy_Point_amount, paramCameraUpdate.zoomBy_Point_focus.x, paramCameraUpdate.zoomBy_Point_focus.y, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.newCameraPosition_cameraPosition, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.newLatLng_latLng.latitude, paramCameraUpdate.newLatLng_latLng.longitude, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.newLatLngZoom_latLng.latitude, paramCameraUpdate.newLatLngZoom_latLng.longitude, paramCameraUpdate.newLatLngZoom_zoom, true, paramLong, paramCancelableCallback);
        continue;
        i1 = a(paramCameraUpdate.newLatLngBounds_bounds, paramCameraUpdate.newLatLngBounds_padding, true, paramLong, paramCancelableCallback);
        AppMethodBeat.o(225496);
        return i1;
        i1 = a(paramCameraUpdate.newLatLngBounds_dimension_bounds, paramCameraUpdate.newLatLngBounds_dimension_padding, paramCameraUpdate.newLatLngBounds_dimension_padding, paramCameraUpdate.newLatLngBounds_dimension_padding, paramCameraUpdate.newLatLngBounds_dimension_padding, true, paramLong, paramCancelableCallback);
        AppMethodBeat.o(225496);
        return i1;
        i1 = a(paramCameraUpdate.newLatLngBounds_dimension_bounds, paramCameraUpdate.newLatLngBoundsRects_padLeft, paramCameraUpdate.newLatLngBoundsRects_padRight, paramCameraUpdate.newLatLngBoundsRects_padTop, paramCameraUpdate.newLatLngBoundsRects_padBom, true, paramLong, paramCancelableCallback);
        AppMethodBeat.o(225496);
        return i1;
        b(paramCameraUpdate.rotateto_rotate, paramCameraUpdate.rotateto_skew, true, paramLong, paramCancelableCallback);
      }
    }
    int i1 = a(b(paramCameraUpdate.elements), paramCameraUpdate.newLatLngBoundsRects_padLeft, paramCameraUpdate.newLatLngBoundsRects_padRight, paramCameraUpdate.newLatLngBoundsRects_padTop, paramCameraUpdate.newLatLngBoundsRects_padBom, true, paramLong, paramCancelableCallback);
    AppMethodBeat.o(225496);
    return i1;
  }
  
  public final CameraPosition a()
  {
    AppMethodBeat.i(225446);
    Object localObject = jz.a(((VectorMap)this.b.e_).q());
    float f1 = ((VectorMap)this.b.e_).t();
    if (f1 < 0.0F) {
      f1 = f1 % 360.0F + 360.0F;
    }
    for (;;)
    {
      float f2 = ((VectorMap)this.b.e_).u();
      float f3 = D();
      kh.b("tms-ret", "zoomLevel: ".concat(String.valueOf(f3)));
      localObject = CameraPosition.builder().zoom(f3).target((LatLng)localObject).bearing(f1).tilt(f2).build();
      AppMethodBeat.o(225446);
      return localObject;
    }
  }
  
  public final CameraPosition a(List<eq> arg1, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(225795);
    if ((this.b.ak == 0) || (this.b.al == 0))
    {
      int i1 = ha.b(this.c);
      int i2 = ha.c(this.c);
      if ((paramInt1 + paramInt2 > i1) || (paramInt3 + paramInt4 > i2))
      {
        AppMethodBeat.o(225795);
        return null;
      }
    }
    else if ((paramInt1 + paramInt2 > this.b.ak) || (paramInt3 + paramInt4 > this.b.al))
    {
      AppMethodBeat.o(225795);
      return null;
    }
    Object localObject = ((VectorMap)this.b.e_).v();
    if (localObject == null)
    {
      AppMethodBeat.o(225795);
      return null;
    }
    double d1;
    double d2;
    double d5;
    double d4;
    double d3;
    if ((??? == null) || (???.isEmpty()))
    {
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        AppMethodBeat.o(225795);
        return null;
      }
      if (paramList1.size() == 1)
      {
        ??? = new CameraPosition((LatLng)paramList1.get(0), ((VectorMap)this.b.e_).o.t.a(), ((VectorMap)this.b.e_).u(), ((VectorMap)this.b.e_).t());
        AppMethodBeat.o(225795);
        return ???;
      }
      d1 = 0.0D;
      d6 = 0.0D;
      ??? = paramList1.iterator();
      d2 = 0.0D;
      d5 = 0.0D;
      while (???.hasNext())
      {
        paramList1 = (LatLng)???.next();
        if (paramList1 != null)
        {
          d4 = d1;
          if (d1 == 0.0D) {
            d4 = paramList1.latitude;
          }
          d3 = d6;
          if (d6 == 0.0D) {
            d3 = paramList1.longitude;
          }
          if (d5 != 0.0D) {
            break label739;
          }
        }
      }
    }
    label739:
    for (double d6 = paramList1.latitude;; d6 = d5)
    {
      d5 = d2;
      if (d2 == 0.0D) {
        d5 = paramList1.longitude;
      }
      d1 = d4;
      if (paramList1.latitude < d4) {
        d1 = paramList1.latitude;
      }
      d2 = d6;
      if (paramList1.latitude > d6) {
        d2 = paramList1.latitude;
      }
      d4 = d3;
      if (paramList1.longitude < d3) {
        d4 = paramList1.longitude;
      }
      if (paramList1.longitude > d5) {}
      for (d3 = paramList1.longitude;; d3 = d5)
      {
        d5 = d2;
        d2 = d3;
        d6 = d4;
        break;
        ??? = new LatLng(d1, d6);
        paramList1 = new LatLng(d5, d2);
        localObject = new LatLng(0.0D, 0.0D);
        float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, ???, paramList1, (LatLng)localObject);
        if (f1 < 0.0F)
        {
          AppMethodBeat.o(225795);
          return null;
        }
        ??? = new CameraPosition((LatLng)localObject, f1, ((VectorMap)this.b.e_).u(), ((VectorMap)this.b.e_).t());
        AppMethodBeat.o(225795);
        return ???;
        ArrayList localArrayList = new ArrayList();
        ??? = ???.iterator();
        while (???.hasNext())
        {
          eq localeq = (eq)???.next();
          if ((localeq != null) && (localeq.getGroupBounds() != null)) {
            localArrayList.addAll(localeq.getGroupBounds());
          }
        }
        ??? = new Rect(paramInt1, paramInt3, paramInt2, paramInt4);
        this.g = null;
        ((ep)localObject).a(localArrayList, GeoPoint.from(paramList1), ???, new ep.a()
        {
          public final void a(float paramAnonymousFloat, GeoPoint arg2)
          {
            double d1 = 0.0D;
            AppMethodBeat.i(226156);
            ??? = jz.a(???);
            double d2 = 20.0D - Math.log(1.0F / paramAnonymousFloat) / Math.log(2.0D);
            if (d2 < 0.0D) {}
            for (;;)
            {
              bg.this.g = new CameraPosition(???, (float)d1, ((VectorMap)bg.this.b.e_).u(), ((VectorMap)bg.this.b.e_).t());
              synchronized (bg.this.h)
              {
                bg.this.h.notifyAll();
                AppMethodBeat.o(226156);
                return;
              }
              d1 = d2;
            }
          }
        });
        synchronized (this.h)
        {
          try
          {
            this.h.wait(1000L);
            ??? = this.g;
            AppMethodBeat.o(225795);
            return ???;
          }
          catch (InterruptedException paramList1)
          {
            for (;;)
            {
              kh.c(Log.getStackTraceString(paramList1));
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public final CameraPosition a(List<eq> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, final TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback)
  {
    AppMethodBeat.i(225813);
    if ((this.b.ak == 0) || (this.b.al == 0))
    {
      ha.b(this.c);
      ha.c(this.c);
    }
    Object localObject;
    while ((paramInt1 + paramInt2 <= this.b.ak) && (paramInt3 + paramInt4 <= this.b.al))
    {
      localObject = ((VectorMap)this.b.e_).v();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(225813);
      return null;
    }
    if (paramAsyncOperateCallback != null) {
      paramAsyncOperateCallback.onOperateFinished(null);
    }
    AppMethodBeat.o(225813);
    return null;
    double d1;
    double d2;
    double d5;
    double d4;
    double d3;
    if (paramList.isEmpty())
    {
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        if (paramAsyncOperateCallback != null) {
          paramAsyncOperateCallback.onOperateFinished(null);
        }
        AppMethodBeat.o(225813);
        return null;
      }
      if (paramList1.size() == 1)
      {
        paramList = new CameraPosition((LatLng)paramList1.get(0), ((VectorMap)this.b.e_).s(), ((VectorMap)this.b.e_).u(), ((VectorMap)this.b.e_).t());
        if (paramAsyncOperateCallback != null) {
          paramAsyncOperateCallback.onOperateFinished(paramList);
        }
        AppMethodBeat.o(225813);
        return paramList;
      }
      d1 = 0.0D;
      d6 = 0.0D;
      paramList = paramList1.iterator();
      d2 = 0.0D;
      d5 = 0.0D;
      while (paramList.hasNext())
      {
        paramList1 = (LatLng)paramList.next();
        if (paramList1 != null)
        {
          d4 = d1;
          if (d1 == 0.0D) {
            d4 = paramList1.latitude;
          }
          d3 = d6;
          if (d6 == 0.0D) {
            d3 = paramList1.longitude;
          }
          if (d5 != 0.0D) {
            break label715;
          }
        }
      }
    }
    label715:
    for (double d6 = paramList1.latitude;; d6 = d5)
    {
      d5 = d2;
      if (d2 == 0.0D) {
        d5 = paramList1.longitude;
      }
      d1 = d4;
      if (paramList1.latitude < d4) {
        d1 = paramList1.latitude;
      }
      d2 = d6;
      if (paramList1.latitude > d6) {
        d2 = paramList1.latitude;
      }
      d4 = d3;
      if (paramList1.longitude < d3) {
        d4 = paramList1.longitude;
      }
      if (paramList1.longitude > d5) {}
      for (d3 = paramList1.longitude;; d3 = d5)
      {
        d5 = d2;
        d2 = d3;
        d6 = d4;
        break;
        paramList = new LatLng(d1, d6);
        paramList1 = new LatLng(d5, d2);
        localObject = new LatLng(0.0D, 0.0D);
        float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramList, paramList1, (LatLng)localObject);
        if (f1 < 0.0F)
        {
          if (paramAsyncOperateCallback != null) {
            paramAsyncOperateCallback.onOperateFinished(null);
          }
          AppMethodBeat.o(225813);
          return null;
        }
        paramList = new CameraPosition((LatLng)localObject, f1, ((VectorMap)this.b.e_).u(), ((VectorMap)this.b.e_).t());
        if (paramAsyncOperateCallback != null) {
          paramAsyncOperateCallback.onOperateFinished(paramList);
        }
        AppMethodBeat.o(225813);
        return paramList;
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          eq localeq = (eq)paramList.next();
          if ((localeq != null) && (localeq.getGroupBounds() != null)) {
            localArrayList.addAll(localeq.getGroupBounds());
          }
        }
        paramList = new Rect(paramInt1, paramInt3, paramInt2, paramInt4);
        this.g = null;
        ((ep)localObject).a(localArrayList, GeoPoint.from(paramList1), paramList, new ep.a()
        {
          public final void a(float paramAnonymousFloat, GeoPoint paramAnonymousGeoPoint)
          {
            double d1 = 0.0D;
            AppMethodBeat.i(226152);
            paramAnonymousGeoPoint = jz.a(paramAnonymousGeoPoint);
            double d2 = 20.0D - Math.log(1.0F / paramAnonymousFloat) / Math.log(2.0D);
            if (d2 < 0.0D) {}
            for (;;)
            {
              bg.this.g = new CameraPosition(paramAnonymousGeoPoint, (float)d1, ((VectorMap)bg.this.b.e_).u(), ((VectorMap)bg.this.b.e_).t());
              if (paramAsyncOperateCallback != null) {
                paramAsyncOperateCallback.onOperateFinished(bg.this.g);
              }
              AppMethodBeat.o(226152);
              return;
              d1 = d2;
            }
          }
        });
        AppMethodBeat.o(225813);
        return null;
      }
    }
  }
  
  public final CustomLayer a(CustomLayerOptions paramCustomLayerOptions)
  {
    AppMethodBeat.i(226109);
    if ((this.f == null) || (this.n == null))
    {
      AppMethodBeat.o(226109);
      return null;
    }
    pi localpi = this.f;
    if (localpi.a != null)
    {
      new StringBuilder("添加个性化图层[").append(paramCustomLayerOptions.getLayerId()).append("]");
      kl.c("TCL");
      Object localObject = localpi.a;
      TileOverlayOptions localTileOverlayOptions = new TileOverlayOptions();
      String str = "custom_layer_" + kr.a(paramCustomLayerOptions.getLayerId());
      localTileOverlayOptions.diskCacheDir(str);
      pj localpj = localpi.a(paramCustomLayerOptions.getLayerId());
      kl.a("TCL", "cache_dir", str);
      if (localpj != null)
      {
        kl.a("TCL", "version", localpj.b);
        kl.a("TCL", "minZoom", Integer.valueOf(localpj.d));
        kl.a("TCL", "maxZoom", Integer.valueOf(localpj.c));
        kl.a("TCL", "layerId", localpj.a);
        localTileOverlayOptions.tileProvider(new pi.1(localpi, localpj));
        localTileOverlayOptions.versionInfo(localpj.b);
      }
      localObject = ((qe)localObject).a(localTileOverlayOptions);
      paramCustomLayerOptions = localpi.a(paramCustomLayerOptions.getLayerId());
      if ((localObject != null) && (paramCustomLayerOptions != null))
      {
        if (paramCustomLayerOptions.e)
        {
          ((pz)localObject).e();
          paramCustomLayerOptions.e = false;
        }
        ((pz)localObject).a(paramCustomLayerOptions.d, paramCustomLayerOptions.c);
      }
      paramCustomLayerOptions = localpi.a.h.d.c();
      paramCustomLayerOptions.a += 1;
      kl.e("TCL");
      paramCustomLayerOptions = new at((pz)localObject);
      AppMethodBeat.o(226109);
      return paramCustomLayerOptions;
    }
    AppMethodBeat.o(226109);
    return null;
  }
  
  public final LatLng a(Point paramPoint)
  {
    AppMethodBeat.i(225381);
    sj localsj = this.b;
    if ((localsj == null) || (localsj.e_ == null) || (((VectorMap)localsj.e_).v() == null))
    {
      AppMethodBeat.o(225381);
      return null;
    }
    paramPoint = jz.a(((VectorMap)localsj.e_).v().a(new fl(paramPoint.x, paramPoint.y)));
    AppMethodBeat.o(225381);
    return paramPoint;
  }
  
  public final TileOverlay a(TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(226098);
    if (this.n == null)
    {
      AppMethodBeat.o(226098);
      return null;
    }
    paramTileOverlayOptions = this.n.b(paramTileOverlayOptions);
    AppMethodBeat.o(226098);
    return paramTileOverlayOptions;
  }
  
  public final String a(LatLng paramLatLng)
  {
    AppMethodBeat.i(225645);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(225645);
      return null;
    }
    paramLatLng = GeoPoint.from(paramLatLng);
    paramLatLng = ((VectorMap)this.b.e_).o.a(paramLatLng);
    AppMethodBeat.o(225645);
    return paramLatLng;
  }
  
  public final List<Rect> a(List<String> paramList)
  {
    AppMethodBeat.i(225867);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(225867);
      return null;
    }
    if (this.b == null)
    {
      AppMethodBeat.o(225867);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    ep localep = ((VectorMap)this.b.e_).v();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = this.b.c((String)localObject);
      if (localObject != null) {
        if ((localObject instanceof oq))
        {
          localArrayList.add(((oq)localObject).a(localep));
        }
        else if ((localObject instanceof os))
        {
          localObject = ((os)localObject).a;
          if (localObject != null) {
            localArrayList.add(((pv)localObject).a(localep));
          }
        }
      }
    }
    AppMethodBeat.o(225867);
    return localArrayList;
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225678);
    if (this.b == null)
    {
      AppMethodBeat.o(225678);
      return;
    }
    float f1;
    if (paramFloat1 < 0.0F)
    {
      f1 = 0.0F;
      if (paramFloat2 >= 0.0F) {
        break label109;
      }
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      int i1 = (int)(this.b.ak * f1);
      int i2 = (int)(this.b.al * paramFloat1);
      this.b.c(i1, i2);
      this.b.O = f1;
      this.b.P = paramFloat1;
      AppMethodBeat.o(225678);
      return;
      f1 = paramFloat1;
      if (paramFloat1 <= 1.0F) {
        break;
      }
      f1 = 1.0F;
      break;
      label109:
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(225827);
    if (this.b == null)
    {
      AppMethodBeat.o(225827);
      return;
    }
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    localVectorMap.o.i.M = true;
    localVectorMap.o.i.a(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(225827);
  }
  
  final void a(float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(225429);
    if (this.b == null)
    {
      AppMethodBeat.o(225429);
      return;
    }
    if (!paramBoolean)
    {
      paramCancelableCallback = this.b;
      paramBoolean = this.b.o.f;
      int i2 = ((VectorMap)this.b.e_).p();
      if (paramBoolean) {}
      for (int i1 = 22;; i1 = 20)
      {
        double d1 = 1.0D / Math.pow(2.0D, 20.0F - Math.min(paramFloat, Math.min(i2, i1)));
        ((VectorMap)this.b.e_).a((float)d1);
        AppMethodBeat.o(225429);
        return;
      }
    }
    rz localrz = new rz();
    localrz.a(paramFloat);
    localrz.a = this.j;
    localrz.f = paramCancelableCallback;
    localrz.a(paramLong);
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225429);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(225513);
    int i1 = f();
    this.u = paramInt;
    if ((paramInt == i1) || (i1 == 1011) || (i1 == 1008))
    {
      AppMethodBeat.o(225513);
      return;
    }
    i1 = paramInt;
    if (this.e != null)
    {
      qm localqm = this.e.a(paramInt);
      if (localqm == null) {
        break label124;
      }
      paramInt = localqm.a;
      gq localgq = this.b.aB.d;
      i1 = paramInt;
      if (localgq != null)
      {
        localgq.p().a(localqm.b);
        i1 = paramInt;
      }
    }
    for (;;)
    {
      this.b.aB.c(i1);
      gw.n();
      AppMethodBeat.o(225513);
      return;
      label124:
      if (paramInt >= 1000)
      {
        i1 = paramInt - 1000;
      }
      else
      {
        i1 = paramInt;
        if (paramInt > 8)
        {
          i1 = paramInt;
          if (paramInt < 989) {
            i1 = paramInt + 11;
          }
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225694);
    if (this.b == null)
    {
      AppMethodBeat.o(225694);
      return;
    }
    this.b.a(paramInt1, paramInt2);
    AppMethodBeat.o(225694);
  }
  
  public final void a(Handler paramHandler, Bitmap.Config paramConfig, int paramInt)
  {
    AppMethodBeat.i(225634);
    sj localsj = this.b;
    localsj.H = paramHandler;
    localsj.J = paramConfig;
    if (paramInt > 0) {}
    for (localsj.I = (System.currentTimeMillis() + paramInt);; localsj.I = 9223372036854775807L)
    {
      localsj.H();
      localsj.F();
      AppMethodBeat.o(225634);
      return;
    }
  }
  
  public final void a(ez paramez)
  {
    AppMethodBeat.i(225889);
    if (this.b == null)
    {
      AppMethodBeat.o(225889);
      return;
    }
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    if (localVectorMap == null)
    {
      AppMethodBeat.o(225889);
      return;
    }
    localVectorMap.o.a(paramez);
    AppMethodBeat.o(225889);
  }
  
  public final void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (this.b == null) {
      return;
    }
    this.b.F = paramOnCameraChangeListener;
  }
  
  public final void a(TencentMap.OnCompassClickedListener paramOnCompassClickedListener)
  {
    if (this.b != null) {
      this.b.D = paramOnCompassClickedListener;
    }
  }
  
  public final void a(TencentMap.OnDismissCallback paramOnDismissCallback)
  {
    this.b.w = paramOnDismissCallback;
  }
  
  public final void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(225939);
    this.b.a(paramOnIndoorStateChangeListener);
    AppMethodBeat.o(225939);
  }
  
  public final void a(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    this.b.z = paramOnInfoWindowClickListener;
  }
  
  public final void a(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    this.b.s = paramOnMapClickListener;
  }
  
  public final void a(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    AppMethodBeat.i(225854);
    this.b.au.add(paramOnMapLoadedCallback);
    AppMethodBeat.o(225854);
  }
  
  public final void a(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.b.v = paramOnMapLongClickListener;
  }
  
  public final void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    this.b.A = paramOnMapPoiClickListener;
  }
  
  public final void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.b.y = paramOnMarkerClickListener;
  }
  
  public final void a(TencentMap.OnTrafficEventClickListener paramOnTrafficEventClickListener)
  {
    if ((this.b == null) || (this.b.e_ == null)) {
      return;
    }
    this.b.aq = paramOnTrafficEventClickListener;
  }
  
  public final void a(Language paramLanguage)
  {
    AppMethodBeat.i(225875);
    if (this.b == null)
    {
      AppMethodBeat.o(225875);
      return;
    }
    Object localObject = (VectorMap)this.b.e_;
    if (localObject == null)
    {
      AppMethodBeat.o(225875);
      return;
    }
    localObject = ((VectorMap)localObject).o;
    if (((mk)localObject).y == null) {
      ((mk)localObject).y = new mk.c((mk)localObject);
    }
    localObject = ((mk)localObject).y;
    if (mk.a(((mk.c)localObject).a) != null)
    {
      sc localsc = mk.a(((mk.c)localObject).a);
      localsc.a(new sc.26(localsc, paramLanguage.ordinal()));
      mk.e(((mk.c)localObject).a);
      ((mk.c)localObject).a.v = true;
      ((mk.c)localObject).a(paramLanguage);
    }
    AppMethodBeat.o(225875);
  }
  
  public final void a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225608);
    a(paramLatLng, paramFloat1, paramFloat2, 0.0F, true);
    AppMethodBeat.o(225608);
  }
  
  public final void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(225835);
    rz localrz = new rz();
    localrz.b((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
    localrz.a(paramFloat3);
    localrz.c(paramFloat1);
    localrz.d(paramFloat2);
    localrz.a = this.j;
    localrz.g = true;
    localrz.a(1000L);
    ((VectorMap)this.b.e_).w();
    ((VectorMap)this.b.e_).a(localrz);
    AppMethodBeat.o(225835);
  }
  
  public final void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    AppMethodBeat.i(225616);
    rz localrz = new rz();
    localrz.b((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
    localrz.a(paramFloat3);
    localrz.c(paramFloat1);
    localrz.d(paramFloat2);
    localrz.a = this.j;
    localrz.g = true;
    localrz.a(1000L);
    if (paramBoolean) {
      localrz.a(this.b.K, this.b.L);
    }
    for (;;)
    {
      ((VectorMap)this.b.e_).w();
      ((VectorMap)this.b.e_).a(localrz);
      AppMethodBeat.o(225616);
      return;
      localrz.a(this.b.M, this.b.N);
    }
  }
  
  public final void a(LatLngBounds paramLatLngBounds, int paramInt)
  {
    AppMethodBeat.i(226132);
    if ((this.b == null) || (this.b.e_ == null))
    {
      AppMethodBeat.o(226132);
      return;
    }
    this.b.aB.a(paramLatLngBounds, paramInt);
    AppMethodBeat.o(226132);
  }
  
  public final void a(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(225654);
    if (this.b == null)
    {
      AppMethodBeat.o(225654);
      return;
    }
    sj localsj = this.b;
    if (localsj.av == null) {
      localsj.av = new TencentMapGestureListenerList();
    }
    localsj.av.addListener(paramTencentMapGestureListener);
    AppMethodBeat.o(225654);
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(226019);
    if (this.b == null)
    {
      AppMethodBeat.o(226019);
      return;
    }
    mk localmk = this.b.aB;
    if (localmk == null)
    {
      AppMethodBeat.o(226019);
      return;
    }
    if (localmk.g != null)
    {
      sc localsc = localmk.g;
      localsc.a(new sc.25(localsc, paramString));
    }
    localmk.v = true;
    AppMethodBeat.o(226019);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226118);
    if ((this.b == null) || (this.b.e_ == null))
    {
      AppMethodBeat.o(226118);
      return;
    }
    mk localmk = this.b.aB;
    if (localmk != null) {
      localmk.a(paramString1, paramString2);
    }
    AppMethodBeat.o(226118);
  }
  
  public final void a(List<MapRouteSection> paramList, List<LatLng> paramList1)
  {
    AppMethodBeat.i(225910);
    if (this.b == null)
    {
      AppMethodBeat.o(225910);
      return;
    }
    Object localObject = (VectorMap)this.b.e_;
    if (localObject == null)
    {
      AppMethodBeat.o(225910);
      return;
    }
    paramList1 = GeoPoint.from(paramList1);
    localObject = ((VectorMap)localObject).o;
    if (((mk)localObject).z == null) {
      ((mk)localObject).z = new mk.e((mk)localObject);
    }
    localObject = ((mk)localObject).z;
    ((mk.e)localObject).a = paramList;
    ((mk.e)localObject).b = paramList1;
    mk.a(((mk.e)localObject).c).a(paramList, paramList1);
    AppMethodBeat.o(225910);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(225526);
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    if (paramBoolean)
    {
      localVectorMap.b(true);
      AppMethodBeat.o(225526);
      return;
    }
    localVectorMap.b(false);
    AppMethodBeat.o(225526);
  }
  
  public final float b()
  {
    AppMethodBeat.i(225457);
    float f1 = ((VectorMap)this.b.e_).p();
    AppMethodBeat.o(225457);
    return f1;
  }
  
  public final int b(String paramString)
  {
    AppMethodBeat.i(226084);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(226084);
      return -1;
    }
    Object localObject = this.b.o;
    if (((aa)localObject).d == null)
    {
      AppMethodBeat.o(226084);
      return -1;
    }
    localObject = ((aa)localObject).d;
    if (((VectorMap)localObject).o == null)
    {
      AppMethodBeat.o(226084);
      return -1;
    }
    localObject = ((VectorMap)localObject).o;
    if (((mk)localObject).g == null)
    {
      AppMethodBeat.o(226084);
      return -1;
    }
    localObject = ((mk)localObject).g;
    int i1 = ((Integer)((sc)localObject).a(new sc.40((sc)localObject, paramString), Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(226084);
    return i1;
  }
  
  public final Point b(LatLng paramLatLng)
  {
    AppMethodBeat.i(225392);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(225392);
      return null;
    }
    Object localObject = this.b;
    if ((localObject == null) || (((bn)localObject).e_ == null) || (((VectorMap)((bn)localObject).e_).v() == null))
    {
      AppMethodBeat.o(225392);
      return null;
    }
    paramLatLng = ((VectorMap)((bn)localObject).e_).v().a(GeoPoint.from(paramLatLng));
    if (paramLatLng == null)
    {
      AppMethodBeat.o(225392);
      return null;
    }
    localObject = new Point();
    ((Point)localObject).x = ((int)Math.round(paramLatLng.a));
    ((Point)localObject).y = ((int)Math.round(paramLatLng.b));
    AppMethodBeat.o(225392);
    return localObject;
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225820);
    if (this.b == null)
    {
      AppMethodBeat.o(225820);
      return;
    }
    float f1;
    if (paramFloat1 < 0.0F)
    {
      f1 = 0.0F;
      if (paramFloat2 >= 0.0F) {
        break label109;
      }
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      int i1 = (int)(this.b.ak * f1);
      int i2 = (int)(this.b.al * paramFloat1);
      this.b.d(i1, i2);
      this.b.Q = f1;
      this.b.R = paramFloat1;
      AppMethodBeat.o(225820);
      return;
      f1 = paramFloat1;
      if (paramFloat1 <= 1.0F) {
        break;
      }
      f1 = 1.0F;
      break;
      label109:
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(225688);
    if (this.b == null)
    {
      AppMethodBeat.o(225688);
      return;
    }
    this.b.a(paramInt);
    AppMethodBeat.o(225688);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 == 0)) {}
  }
  
  public final void b(ez paramez)
  {
    AppMethodBeat.i(225901);
    if (this.b == null)
    {
      AppMethodBeat.o(225901);
      return;
    }
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    if (localVectorMap == null)
    {
      AppMethodBeat.o(225901);
      return;
    }
    localVectorMap.o.b(paramez);
    AppMethodBeat.o(225901);
  }
  
  public final void b(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (this.b == null) {
      return;
    }
    this.b.G = paramOnCameraChangeListener;
  }
  
  public final void b(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    AppMethodBeat.i(225860);
    this.b.au.remove(paramOnMapLoadedCallback);
    AppMethodBeat.o(225860);
  }
  
  public final void b(Language paramLanguage)
  {
    AppMethodBeat.i(226076);
    if ((this.b == null) || (this.b.k == null))
    {
      AppMethodBeat.o(226076);
      return;
    }
    rj localrj = this.b.k;
    if ((paramLanguage != null) && (localrj.b.j != paramLanguage))
    {
      localrj.b.j = paramLanguage;
      if (localrj.c != null) {
        localrj.c.onLanguageChange(paramLanguage);
      }
      localrj.a();
    }
    AppMethodBeat.o(226076);
  }
  
  public final void b(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(225661);
    if (this.b == null)
    {
      AppMethodBeat.o(225661);
      return;
    }
    sj localsj = this.b;
    if (localsj.av != null) {
      localsj.av.removeListener(paramTencentMapGestureListener);
    }
    AppMethodBeat.o(225661);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.b.T = paramBoolean;
  }
  
  public final float c()
  {
    AppMethodBeat.i(225465);
    float f1 = ((VectorMap)this.b.e_).o();
    AppMethodBeat.o(225465);
    return f1;
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(225956);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(225956);
      return;
    }
    aa localaa = this.b.o;
    if (localaa.e != null)
    {
      Object localObject = localaa.e;
      if (((mk)localObject).g != null)
      {
        localObject = ((mk)localObject).g;
        ((sc)localObject).a(new sc.133((sc)localObject, paramInt));
      }
      localaa.c();
    }
    AppMethodBeat.o(225956);
  }
  
  public final void c(boolean paramBoolean)
  {
    AppMethodBeat.i(225947);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(225947);
      return;
    }
    aa localaa = this.b.o;
    if (paramBoolean) {}
    for (int i1 = aa.a.b;; i1 = aa.a.c)
    {
      localaa.c = i1;
      localaa.a(localaa.c);
      AppMethodBeat.o(225947);
      return;
    }
  }
  
  public final void d()
  {
    AppMethodBeat.i(225503);
    ((VectorMap)this.b.e_).w();
    AppMethodBeat.o(225503);
  }
  
  public final void d(int paramInt)
  {
    AppMethodBeat.i(226024);
    if (this.b == null)
    {
      AppMethodBeat.o(226024);
      return;
    }
    this.b.j = paramInt;
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    if (localVectorMap == null)
    {
      AppMethodBeat.o(226024);
      return;
    }
    localVectorMap.b(paramInt);
    localVectorMap.o.v = true;
    AppMethodBeat.o(226024);
  }
  
  public final void d(boolean paramBoolean)
  {
    AppMethodBeat.i(226011);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(226011);
      return;
    }
    Object localObject = this.b.o;
    if (((aa)localObject).d != null)
    {
      localObject = ((aa)localObject).d.o;
      if (((mk)localObject).g != null)
      {
        localObject = ((mk)localObject).g;
        if (((sc)localObject).e != 0L) {
          ((sc)localObject).a(new sc.143((sc)localObject, paramBoolean));
        }
      }
    }
    AppMethodBeat.o(226011);
  }
  
  public final void e() {}
  
  public final void e(int paramInt)
  {
    AppMethodBeat.i(226030);
    if (this.b == null)
    {
      AppMethodBeat.o(226030);
      return;
    }
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    if (localVectorMap == null)
    {
      AppMethodBeat.o(226030);
      return;
    }
    mk localmk = localVectorMap.o;
    if (localmk.g != null) {
      localmk.g.b(paramInt);
    }
    if (localmk.t != null) {
      localmk.t.b.n = paramInt;
    }
    localVectorMap.o.v = true;
    AppMethodBeat.o(226030);
  }
  
  public final void e(boolean paramBoolean)
  {
    AppMethodBeat.i(226037);
    if (this.b == null)
    {
      AppMethodBeat.o(226037);
      return;
    }
    if (paramBoolean)
    {
      this.b.y();
      AppMethodBeat.o(226037);
      return;
    }
    sj localsj = this.b;
    if (localsj.l != null) {
      localsj.l.b();
    }
    AppMethodBeat.o(226037);
  }
  
  public final int f()
  {
    AppMethodBeat.i(225520);
    int i1 = ((mk)this.b.d_).i.m();
    if (this.e != null)
    {
      i1 = this.e.b(i1);
      AppMethodBeat.o(225520);
      return i1;
    }
    AppMethodBeat.o(225520);
    return -1;
  }
  
  public final void f(int paramInt)
  {
    AppMethodBeat.i(226153);
    if ((paramInt != 1000) && (paramInt != 1011) && (paramInt != 1008))
    {
      AppMethodBeat.o(226153);
      return;
    }
    Object localObject;
    if (paramInt == 1008)
    {
      localObject = this.b.aB.d.e();
      ((gh)localObject).a += 1;
    }
    this.v = paramInt;
    int i1 = paramInt;
    if (paramInt == 1000) {
      i1 = this.u;
    }
    paramInt = i1;
    if (this.e != null)
    {
      localObject = this.e.a(i1);
      paramInt = i1;
      if (localObject != null) {
        paramInt = ((qm)localObject).a;
      }
    }
    this.b.aB.c(paramInt);
    AppMethodBeat.o(226153);
  }
  
  public final void f(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.am = paramBoolean;
    }
  }
  
  public final int g()
  {
    return -1;
  }
  
  public final void g(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.i = paramBoolean;
    }
  }
  
  public final void h(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.b.ao = paramBoolean;
  }
  
  public final boolean h()
  {
    return ((VectorMap)this.b.e_).o.q;
  }
  
  public final void i() {}
  
  public final void i(boolean paramBoolean)
  {
    AppMethodBeat.i(226112);
    if ((this.b == null) || (this.b.e_ == null))
    {
      AppMethodBeat.o(226112);
      return;
    }
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    localVectorMap.p = paramBoolean;
    localVectorMap.o.g(paramBoolean);
    AppMethodBeat.o(226112);
  }
  
  public final void j()
  {
    AppMethodBeat.i(225546);
    this.a.a();
    if (this.d != null) {
      this.d.j();
    }
    AppMethodBeat.o(225546);
  }
  
  public final void k() {}
  
  public final void l() {}
  
  public final void m()
  {
    AppMethodBeat.i(225564);
    this.a.c();
    if (this.m != null)
    {
      this.m.b();
      this.m = null;
    }
    bj localbj;
    Object localObject;
    sj localsj;
    if (this.d != null)
    {
      localbj = this.d;
      localObject = localbj.b;
      localsj = localbj.c;
      if ((localObject != null) && (localsj != null)) {
        break label76;
      }
    }
    for (;;)
    {
      this.d = null;
      AppMethodBeat.o(225564);
      return;
      label76:
      if (localbj.j != null) {
        localbj.j.removeCallbacksAndMessages(null);
      }
      ((VectorMap)localsj.e_).o.i.b(localbj);
      localsj.at.remove(localbj);
      localsj.b(localbj);
      ((ViewGroup)localObject).removeAllViews();
      localObject = localbj.i.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((el)((Iterator)localObject).next()).c();
      }
      localbj.i.clear();
    }
  }
  
  public final void n()
  {
    AppMethodBeat.i(225556);
    this.a.b();
    AppMethodBeat.o(225556);
  }
  
  public final String o()
  {
    AppMethodBeat.i(225700);
    String str = gw.h();
    AppMethodBeat.o(225700);
    return str;
  }
  
  public final Language p()
  {
    AppMethodBeat.i(225882);
    if (this.b == null)
    {
      localObject = Language.zh;
      AppMethodBeat.o(225882);
      return localObject;
    }
    Object localObject = (VectorMap)this.b.e_;
    if (localObject == null)
    {
      localObject = Language.zh;
      AppMethodBeat.o(225882);
      return localObject;
    }
    localObject = ((VectorMap)localObject).o.B();
    AppMethodBeat.o(225882);
    return localObject;
  }
  
  public final void q()
  {
    AppMethodBeat.i(225917);
    if (this.b == null)
    {
      AppMethodBeat.o(225917);
      return;
    }
    VectorMap localVectorMap = (VectorMap)this.b.e_;
    if (localVectorMap == null)
    {
      AppMethodBeat.o(225917);
      return;
    }
    localVectorMap.clearRouteNameSegments();
    AppMethodBeat.o(225917);
  }
  
  public final int r()
  {
    AppMethodBeat.i(225976);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(225976);
      return -1;
    }
    aa localaa = this.b.o;
    if (localaa.g == null)
    {
      AppMethodBeat.o(225976);
      return -1;
    }
    int i1 = localaa.g.getActiveLevelIndex();
    AppMethodBeat.o(225976);
    return i1;
  }
  
  public final String[] s()
  {
    AppMethodBeat.i(225985);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(225985);
      return null;
    }
    Object localObject = this.b.o;
    if ((((aa)localObject).g == null) || (((aa)localObject).g.getLevels() == null) || (((aa)localObject).g.getLevels().isEmpty()))
    {
      AppMethodBeat.o(225985);
      return null;
    }
    localObject = ((aa)localObject).g.getLevels();
    String[] arrayOfString = new String[((List)localObject).size()];
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      arrayOfString[i1] = ((IndoorLevel)((List)localObject).get(i1)).getName();
      i1 += 1;
    }
    AppMethodBeat.o(225985);
    return arrayOfString;
  }
  
  public final String t()
  {
    AppMethodBeat.i(225990);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(225990);
      return null;
    }
    Object localObject = this.b.o;
    if (((aa)localObject).g == null)
    {
      AppMethodBeat.o(225990);
      return "";
    }
    localObject = ((aa)localObject).g.getBuildingName();
    AppMethodBeat.o(225990);
    return localObject;
  }
  
  public final IndoorBuilding u()
  {
    if ((this.b == null) || (this.b.o == null)) {
      return null;
    }
    return this.b.o.g;
  }
  
  public final String v()
  {
    AppMethodBeat.i(225969);
    if ((this.b == null) || (this.b.o == null))
    {
      AppMethodBeat.o(225969);
      return null;
    }
    Object localObject = this.b.o;
    if (((aa)localObject).g == null)
    {
      AppMethodBeat.o(225969);
      return null;
    }
    localObject = ((aa)localObject).g.getBuidlingId();
    AppMethodBeat.o(225969);
    return localObject;
  }
  
  public final boolean w()
  {
    if (this.b == null) {}
    sj localsj;
    do
    {
      return false;
      localsj = this.b;
    } while ((localsj.l == null) || (localsj.l.b == null));
    return true;
  }
  
  public final boolean x()
  {
    if (this.b == null) {
      return false;
    }
    return this.b.ao;
  }
  
  public final ArrayList<MapPoi> y()
  {
    AppMethodBeat.i(226069);
    if (this.b == null)
    {
      AppMethodBeat.o(226069);
      return null;
    }
    ArrayList localArrayList = this.b.aB.D();
    AppMethodBeat.o(226069);
    return localArrayList;
  }
  
  public final String z()
  {
    AppMethodBeat.i(226093);
    if ((this.c == null) || (this.b == null))
    {
      AppMethodBeat.o(226093);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject;
      if (!gz.a(this.l))
      {
        localObject = md.a(this.c, this.l);
        localJSONObject.put("cfgVer", String.format("%s-%s-%s,%s-%s-%s,%s-%s-%s", new Object[] { "mapconfig", Integer.valueOf(((mb)localObject).b("mapConfigVersion")), ((mb)localObject).a("mapConfigZipMd5"), "indoormap_style", Integer.valueOf(((mb)localObject).b("indoormap_style_version")), ((mb)localObject).a("indoormap_style_md5"), "indoormap_style_night", Integer.valueOf(((mb)localObject).b("indoormap_style_night_version")), ((mb)localObject).a("indoormap_style_night_md5") }));
        int i1 = ha.b(this.c);
        int i2 = ha.c(this.c);
        localJSONObject.put("resolution", "{" + i1 + "," + i2 + "}");
        localJSONObject.put("density", this.w);
        localObject = (VectorMap)this.b.e_;
        if (((VectorMap)localObject).o != null) {
          break label338;
        }
        localObject = null;
        label261:
        localJSONObject.put("renderStatus", localObject);
        localObject = (VectorMap)this.b.e_;
        if (((VectorMap)localObject).o != null) {
          break label380;
        }
        localObject = null;
      }
      for (;;)
      {
        localJSONObject.put("renderError", localObject);
        localJSONObject.put("sdkver", "4.4.7.7");
        localObject = localJSONObject.toString();
        AppMethodBeat.o(226093);
        return localObject;
        localObject = me.a(this.c);
        break;
        label338:
        localObject = ((VectorMap)localObject).o;
        if (((mk)localObject).g == null)
        {
          localObject = null;
          break label261;
        }
        localObject = ((mk)localObject).g;
        localObject = (String)((sc)localObject).a(new sc.41((sc)localObject), null);
        break label261;
        label380:
        localObject = ((VectorMap)localObject).o;
        if (((mk)localObject).g == null) {
          localObject = null;
        } else {
          localObject = ((mk)localObject).g.a();
        }
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(226093);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  final class b
    implements bg.a
  {
    private boolean b = false;
    
    public b(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public final void a()
    {
      AppMethodBeat.i(223776);
      if ((bg.this.b.ak == 0) || (bg.this.b.al == 0))
      {
        AppMethodBeat.o(223776);
        return;
      }
      bg.this.b.E = null;
      if ((bg.this.b.ad == null) || (bg.this.b.ae == null))
      {
        AppMethodBeat.o(223776);
        return;
      }
      LatLng localLatLng = new LatLng(0.0D, 0.0D);
      float f;
      if ((bg.this.b.ag == 0) && (bg.this.b.ah == 0) && (bg.this.b.ai == 0) && (bg.this.b.aj == 0))
      {
        f = bg.this.i.a(bg.this.b.ad, bg.this.b.ae, 0, 0, 0, 0, localLatLng);
        TencentMap.CancelableCallback localCancelableCallback = bg.this.b.C;
        if (!this.b) {
          break label444;
        }
        rz localrz = new rz();
        localrz.c(0.0F);
        localrz.d(0.0F);
        localrz.b((int)(localLatLng.latitude * 1000000.0D), (int)(localLatLng.longitude * 1000000.0D));
        localrz.a(f);
        localrz.a = bg.this.j;
        localrz.f = localCancelableCallback;
        ((VectorMap)bg.this.b.e_).a(localrz);
      }
      for (;;)
      {
        bg.this.b.ad = null;
        bg.this.b.ae = null;
        bg.this.b.ag = 0;
        bg.this.b.ah = 0;
        bg.this.b.ai = 0;
        bg.this.b.aj = 0;
        bg.this.b.C = null;
        AppMethodBeat.o(223776);
        return;
        f = bg.this.i.a(bg.this.b.ad, bg.this.b.ae, bg.this.b.ag, bg.this.b.ah, bg.this.b.ai, bg.this.b.aj, localLatLng);
        break;
        label444:
        ((VectorMap)bg.this.b.e_).b(0.0F);
        ((VectorMap)bg.this.b.e_).a(0.0F);
        ((VectorMap)bg.this.b.e_).a((int)(localLatLng.latitude * 1000000.0D), (int)(localLatLng.longitude * 1000000.0D));
        bg.this.a(f, false, 0L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bg
 * JD-Core Version:    0.7.0.1
 */