package com.tencent.mapsdk.vector;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.ab;
import com.tencent.mapsdk.internal.ac;
import com.tencent.mapsdk.internal.ac.1;
import com.tencent.mapsdk.internal.ac.4;
import com.tencent.mapsdk.internal.ac.5;
import com.tencent.mapsdk.internal.ac.6;
import com.tencent.mapsdk.internal.ac.7;
import com.tencent.mapsdk.internal.ac.a;
import com.tencent.mapsdk.internal.ad;
import com.tencent.mapsdk.internal.ae;
import com.tencent.mapsdk.internal.ah;
import com.tencent.mapsdk.internal.ai;
import com.tencent.mapsdk.internal.an;
import com.tencent.mapsdk.internal.ar;
import com.tencent.mapsdk.internal.av;
import com.tencent.mapsdk.internal.aw;
import com.tencent.mapsdk.internal.az;
import com.tencent.mapsdk.internal.ba;
import com.tencent.mapsdk.internal.bd;
import com.tencent.mapsdk.internal.bf;
import com.tencent.mapsdk.internal.bg;
import com.tencent.mapsdk.internal.bh;
import com.tencent.mapsdk.internal.bi;
import com.tencent.mapsdk.internal.bj;
import com.tencent.mapsdk.internal.bj.a;
import com.tencent.mapsdk.internal.bk;
import com.tencent.mapsdk.internal.bm;
import com.tencent.mapsdk.internal.bn;
import com.tencent.mapsdk.internal.bt;
import com.tencent.mapsdk.internal.dv;
import com.tencent.mapsdk.internal.eh;
import com.tencent.mapsdk.internal.ep;
import com.tencent.mapsdk.internal.eq;
import com.tencent.mapsdk.internal.er;
import com.tencent.mapsdk.internal.es;
import com.tencent.mapsdk.internal.et;
import com.tencent.mapsdk.internal.eu;
import com.tencent.mapsdk.internal.ev;
import com.tencent.mapsdk.internal.ew;
import com.tencent.mapsdk.internal.ex;
import com.tencent.mapsdk.internal.ez;
import com.tencent.mapsdk.internal.fa;
import com.tencent.mapsdk.internal.fb;
import com.tencent.mapsdk.internal.fc;
import com.tencent.mapsdk.internal.fd;
import com.tencent.mapsdk.internal.ff;
import com.tencent.mapsdk.internal.fg;
import com.tencent.mapsdk.internal.fh;
import com.tencent.mapsdk.internal.fi;
import com.tencent.mapsdk.internal.fl;
import com.tencent.mapsdk.internal.gj;
import com.tencent.mapsdk.internal.gq;
import com.tencent.mapsdk.internal.gu;
import com.tencent.mapsdk.internal.gv;
import com.tencent.mapsdk.internal.gv.a;
import com.tencent.mapsdk.internal.gz;
import com.tencent.mapsdk.internal.ha;
import com.tencent.mapsdk.internal.hs;
import com.tencent.mapsdk.internal.id;
import com.tencent.mapsdk.internal.ie;
import com.tencent.mapsdk.internal.io;
import com.tencent.mapsdk.internal.iu;
import com.tencent.mapsdk.internal.jw;
import com.tencent.mapsdk.internal.jw.b.a;
import com.tencent.mapsdk.internal.ka;
import com.tencent.mapsdk.internal.kh;
import com.tencent.mapsdk.internal.lu;
import com.tencent.mapsdk.internal.mf;
import com.tencent.mapsdk.internal.mj;
import com.tencent.mapsdk.internal.mk;
import com.tencent.mapsdk.internal.mk.c;
import com.tencent.mapsdk.internal.mk.e;
import com.tencent.mapsdk.internal.mk.f;
import com.tencent.mapsdk.internal.mq;
import com.tencent.mapsdk.internal.mr;
import com.tencent.mapsdk.internal.mt;
import com.tencent.mapsdk.internal.mv;
import com.tencent.mapsdk.internal.my;
import com.tencent.mapsdk.internal.mz;
import com.tencent.mapsdk.internal.nb;
import com.tencent.mapsdk.internal.nf;
import com.tencent.mapsdk.internal.ni;
import com.tencent.mapsdk.internal.nk;
import com.tencent.mapsdk.internal.nl;
import com.tencent.mapsdk.internal.nn;
import com.tencent.mapsdk.internal.nt;
import com.tencent.mapsdk.internal.oa;
import com.tencent.mapsdk.internal.oc;
import com.tencent.mapsdk.internal.oe;
import com.tencent.mapsdk.internal.oi;
import com.tencent.mapsdk.internal.om;
import com.tencent.mapsdk.internal.or;
import com.tencent.mapsdk.internal.ox;
import com.tencent.mapsdk.internal.oy;
import com.tencent.mapsdk.internal.oy.d;
import com.tencent.mapsdk.internal.oz;
import com.tencent.mapsdk.internal.pb;
import com.tencent.mapsdk.internal.pb.a;
import com.tencent.mapsdk.internal.pk;
import com.tencent.mapsdk.internal.pn;
import com.tencent.mapsdk.internal.ps;
import com.tencent.mapsdk.internal.qe;
import com.tencent.mapsdk.internal.qp;
import com.tencent.mapsdk.internal.qr;
import com.tencent.mapsdk.internal.qs;
import com.tencent.mapsdk.internal.rd;
import com.tencent.mapsdk.internal.rg;
import com.tencent.mapsdk.internal.rg.1;
import com.tencent.mapsdk.internal.sc;
import com.tencent.mapsdk.internal.sc.127;
import com.tencent.mapsdk.internal.sc.132;
import com.tencent.mapsdk.internal.sc.135;
import com.tencent.mapsdk.internal.sc.136;
import com.tencent.mapsdk.internal.sc.137;
import com.tencent.mapsdk.internal.sc.138;
import com.tencent.mapsdk.internal.sc.139;
import com.tencent.mapsdk.internal.sc.140;
import com.tencent.mapsdk.internal.sc.141;
import com.tencent.mapsdk.internal.sc.142;
import com.tencent.mapsdk.internal.sc.143;
import com.tencent.mapsdk.internal.sc.146;
import com.tencent.mapsdk.internal.sc.147;
import com.tencent.mapsdk.internal.sc.148;
import com.tencent.mapsdk.internal.sc.150;
import com.tencent.mapsdk.internal.sc.16;
import com.tencent.mapsdk.internal.sc.164;
import com.tencent.mapsdk.internal.sc.18;
import com.tencent.mapsdk.internal.sc.22;
import com.tencent.mapsdk.internal.sc.23;
import com.tencent.mapsdk.internal.sc.26;
import com.tencent.mapsdk.internal.sc.36;
import com.tencent.mapsdk.internal.sc.40;
import com.tencent.mapsdk.internal.sc.41;
import com.tencent.mapsdk.internal.sc.54;
import com.tencent.mapsdk.internal.sc.84;
import com.tencent.mapsdk.internal.sc.85;
import com.tencent.mapsdk.internal.sc.86;
import com.tencent.mapsdk.internal.sc.89;
import com.tencent.mapsdk.internal.sj;
import com.tencent.mapsdk.internal.sq;
import com.tencent.mapsdk.internal.sr;
import com.tencent.mapsdk.internal.sr.1;
import com.tencent.mapsdk.internal.v;
import com.tencent.mapsdk.internal.v.a;
import com.tencent.mapsdk.internal.w;
import com.tencent.mapsdk.internal.y;
import com.tencent.mapsdk.internal.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolygonClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolylineClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnTrafficEventClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer.OnAoiLayerLoadListener;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapFontSize;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VectorMap
  extends bk
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 11;
  public static final int h = 15;
  public static final int i = 18;
  public static final float j = 40.0F;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int t = 0;
  public static final int u = 1;
  public static final int v = 2;
  public static final int w = 3;
  private static final int x = 1;
  private static final int y = 2;
  private static final int z = 3;
  private pb A;
  private ae B;
  private Projection C;
  private z D;
  private ab E;
  private ad F;
  private boolean G;
  private boolean H;
  private UiSettings I;
  private boolean J;
  private TencentMapPro K;
  private sr L;
  private float M;
  private GeoPoint N;
  private int O;
  public boolean n;
  public mk o;
  public boolean p;
  public bg q;
  public bf r;
  public oz s;
  
  public VectorMap(mk parammk)
  {
    AppMethodBeat.i(221094);
    this.n = false;
    this.p = true;
    this.A = null;
    this.r = null;
    this.B = null;
    this.C = null;
    this.E = null;
    this.F = null;
    this.G = false;
    this.H = false;
    this.N = new GeoPoint();
    this.O = 0;
    this.o = parammk;
    AppMethodBeat.o(221094);
  }
  
  private String[] A()
  {
    AppMethodBeat.i(221147);
    Object localObject1 = this.o;
    Object localObject2 = ((mk)localObject1).i.q();
    Point localPoint1 = new Point(((Rect)localObject2).centerX(), ((Rect)localObject2).centerY());
    Point localPoint2 = new Point(((Rect)localObject2).left, ((Rect)localObject2).top);
    Point localPoint3 = new Point(((Rect)localObject2).left, ((Rect)localObject2).bottom);
    Point localPoint4 = new Point(((Rect)localObject2).right, ((Rect)localObject2).top);
    localObject2 = new Point(((Rect)localObject2).right, ((Rect)localObject2).bottom);
    HashSet localHashSet = new HashSet();
    int i1 = 0;
    while (i1 < 5)
    {
      Object localObject3 = new Point[] { localPoint1, localPoint2, localPoint3, localPoint4, localObject2 }[i1];
      localObject3 = ((mk)localObject1).a(new GeoPoint(((Point)localObject3).y, ((Point)localObject3).x));
      if (!gz.a((String)localObject3)) {
        localHashSet.add(localObject3);
      }
      i1 += 1;
    }
    localObject1 = (String[])localHashSet.toArray(new String[0]);
    AppMethodBeat.o(221147);
    return localObject1;
  }
  
  private Rect B()
  {
    AppMethodBeat.i(221153);
    Rect localRect = this.o.i.q();
    AppMethodBeat.o(221153);
    return localRect;
  }
  
  private Rect C()
  {
    AppMethodBeat.i(221161);
    Rect localRect = this.o.i.r();
    AppMethodBeat.o(221161);
    return localRect;
  }
  
  private int D()
  {
    return this.o.i.A.b.q;
  }
  
  private GeoPoint E()
  {
    AppMethodBeat.i(221194);
    GeoPoint localGeoPoint = this.o.i.s();
    AppMethodBeat.o(221194);
    return localGeoPoint;
  }
  
  private GeoPoint F()
  {
    AppMethodBeat.i(221199);
    GeoPoint localGeoPoint = this.o.i.t();
    AppMethodBeat.o(221199);
    return localGeoPoint;
  }
  
  private boolean G()
  {
    return this.o.p;
  }
  
  private static void H() {}
  
  private boolean I()
  {
    return this.o.q;
  }
  
  private boolean J()
  {
    AppMethodBeat.i(221326);
    mk localmk = this.o;
    if (localmk.g != null)
    {
      sc localsc = localmk.g;
      if (((Integer)localsc.a(new sc.137(localsc, localmk.A()), Integer.valueOf(0))).intValue() == 1)
      {
        AppMethodBeat.o(221326);
        return true;
      }
    }
    AppMethodBeat.o(221326);
    return false;
  }
  
  private static boolean K()
  {
    return true;
  }
  
  private float L()
  {
    AppMethodBeat.i(221336);
    float f1 = this.o.i.A.b.a();
    AppMethodBeat.o(221336);
    return f1;
  }
  
  private void M()
  {
    AppMethodBeat.i(221341);
    this.o.i.a(null);
    AppMethodBeat.o(221341);
  }
  
  private void N()
  {
    AppMethodBeat.i(221343);
    this.o.i.b(null);
    AppMethodBeat.o(221343);
  }
  
  private void O()
  {
    AppMethodBeat.i(221345);
    this.o.i.p();
    AppMethodBeat.o(221345);
  }
  
  private boolean P()
  {
    AppMethodBeat.i(221346);
    boolean bool = this.o.i.k();
    AppMethodBeat.o(221346);
    return bool;
  }
  
  private void Q()
  {
    AppMethodBeat.i(221349);
    ac localac = this.o.i;
    localac.o();
    localac.j();
    AppMethodBeat.o(221349);
  }
  
  private void R()
  {
    AppMethodBeat.i(221351);
    ac localac = this.o.i;
    localac.o();
    localac.a(localac.h(), 40.0D, true);
    AppMethodBeat.o(221351);
  }
  
  private void S()
  {
    AppMethodBeat.i(221353);
    ac localac = this.o.i;
    localac.o();
    localac.o.e();
    localac.a(0.0D, 0.0D);
    AppMethodBeat.o(221353);
  }
  
  private void T()
  {
    AppMethodBeat.i(221355);
    ac localac = this.o.i;
    localac.o();
    localac.o.e();
    localac.a(localac.h(), 40.0D);
    AppMethodBeat.o(221355);
  }
  
  private void U()
  {
    AppMethodBeat.i(221358);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.d();
    }
    AppMethodBeat.o(221358);
  }
  
  private void V()
  {
    AppMethodBeat.i(221360);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.f();
    }
    AppMethodBeat.o(221360);
  }
  
  private void W()
  {
    AppMethodBeat.i(221364);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.e();
    }
    AppMethodBeat.o(221364);
  }
  
  private void X()
  {
    AppMethodBeat.i(221378);
    w localw = this.o.r;
    if (localw == null)
    {
      AppMethodBeat.o(221378);
      return;
    }
    localw.c();
    AppMethodBeat.o(221378);
  }
  
  private void Y()
  {
    this.o.k.g = null;
  }
  
  private void Z()
  {
    AppMethodBeat.i(221505);
    this.o.s.a();
    AppMethodBeat.o(221505);
  }
  
  private double a(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(221551);
    ac localac = this.o.i;
    Rect localRect = new Rect(localac.z.g());
    if (paramRect2 != null)
    {
      localRect.left += paramRect2.left;
      localRect.right -= paramRect2.right;
      localRect.top += paramRect2.top;
      localRect.bottom -= paramRect2.bottom;
    }
    double d1 = localac.a(paramRect1, localRect);
    AppMethodBeat.o(221551);
    return d1;
  }
  
  private float a(double paramDouble, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(222232);
    mk localmk = this.o;
    if ((paramGeoPoint == null) || (localmk.t == null) || (localmk.n == null))
    {
      AppMethodBeat.o(222232);
      return 0.0F;
    }
    double d1 = localmk.n.metersPerPixel(paramGeoPoint.getLatitudeE6() / 1000000.0D);
    if (d1 != 0.0D)
    {
      float f1 = (float)(paramDouble / d1);
      AppMethodBeat.o(222232);
      return f1;
    }
    AppMethodBeat.o(222232);
    return 0.0F;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    int i2 = 255;
    AppMethodBeat.i(221589);
    Object localObject = this.o;
    if (((mk)localObject).g == null)
    {
      AppMethodBeat.o(221589);
      return -1;
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 255) {}
      for (int i1 = 255;; i1 = paramInt1)
      {
        if (paramInt2 < 0) {}
        for (paramInt1 = 0;; paramInt1 = paramInt2)
        {
          if (paramInt1 > 255) {}
          for (paramInt2 = 255;; paramInt2 = paramInt1)
          {
            if (paramInt3 < 0) {}
            for (paramInt1 = 0;; paramInt1 = paramInt3)
            {
              if (paramInt1 > 255) {}
              for (paramInt3 = 255;; paramInt3 = paramInt1)
              {
                if (paramInt4 < 0) {}
                for (paramInt1 = 0;; paramInt1 = paramInt4)
                {
                  if (paramInt1 > 255) {
                    paramInt1 = i2;
                  }
                  for (;;)
                  {
                    MaskLayer localMaskLayer = new MaskLayer();
                    localMaskLayer.color = new int[] { i1, paramInt2, paramInt3, 255 - paramInt1 };
                    if (((mk)localObject).o != null)
                    {
                      localMaskLayer.width = ((mk)localObject).o.width();
                      localMaskLayer.height = ((mk)localObject).o.height();
                    }
                    localMaskLayer.zIndex = paramFloat;
                    localMaskLayer.layer = paramInt5;
                    localObject = ((mk)localObject).g;
                    paramInt1 = ((Integer)((sc)localObject).a(new sc.84((sc)localObject, localMaskLayer), Integer.valueOf(0))).intValue();
                    AppMethodBeat.o(221589);
                    return paramInt1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(221801);
    Object localObject = this.o.i;
    ((ac)localObject).H = paramInt1;
    ((ac)localObject).I = paramInt2;
    ((ac)localObject).J = paramInt3;
    ((ac)localObject).K = paramInt4;
    if ((((ac)localObject).C != null) && (((ac)localObject).C.width() > 0) && (((ac)localObject).C.height() > 0))
    {
      if ((paramInt1 + paramInt3 > ((ac)localObject).C.width()) || (paramInt2 + paramInt4 > ((ac)localObject).C.height()))
      {
        AppMethodBeat.o(221801);
        return -1;
      }
      PointF localPointF = ((ac)localObject).a();
      ((ac)localObject).a(localPointF.x, localPointF.y, paramBoolean);
      AppMethodBeat.o(221801);
      return 0;
    }
    ((ac)localObject).a(new ac.1((ac)localObject, paramBoolean));
    if ((((ac)localObject).z instanceof mk))
    {
      localObject = ((mk)((ac)localObject).z).getContext();
      if ((paramInt1 + paramInt3 > ha.b((Context)localObject)) || (paramInt2 + paramInt4 > ha.c((Context)localObject)))
      {
        AppMethodBeat.o(221801);
        return -1;
      }
      AppMethodBeat.o(221801);
      return 0;
    }
    AppMethodBeat.o(221801);
    return -2;
  }
  
  @Deprecated
  private int a(TileOverlayCallback paramTileOverlayCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(222134);
    mk localmk = this.o;
    if (localmk.g != null)
    {
      int i1 = localmk.g.a(paramTileOverlayCallback, paramBoolean);
      AppMethodBeat.o(222134);
      return i1;
    }
    AppMethodBeat.o(222134);
    return -1;
  }
  
  private int a(PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(221570);
    int i1 = this.o.a(paramPolygonInfo);
    AppMethodBeat.o(221570);
    return i1;
  }
  
  private AnnocationTextResult a(AnnocationText paramAnnocationText)
  {
    AppMethodBeat.i(221629);
    sc localsc = this.o.g;
    paramAnnocationText = (AnnocationTextResult)localsc.a(new sc.22(localsc, paramAnnocationText), null);
    AppMethodBeat.o(221629);
    return paramAnnocationText;
  }
  
  private ie a(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(221521);
    ac localac = this.o.i;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(221521);
      return null;
    case 0: 
      paramObject1 = io.a(localac, new int[] { 0, 1 });
      AppMethodBeat.o(221521);
      return paramObject1;
    case 1: 
      paramObject1 = io.a(localac, new hs(), new Object[] { paramObject1, paramObject2 });
      AppMethodBeat.o(221521);
      return paramObject1;
    case 2: 
      d1 = ((Number)paramObject1).doubleValue();
      d2 = ((Number)paramObject2).doubleValue();
      paramObject1 = io.a(localac, 3, new double[] { Math.log10(d1) / Math.log10(2.0D), Math.log10(d2) / Math.log10(2.0D) });
      AppMethodBeat.o(221521);
      return paramObject1;
    case 3: 
      d1 = ((Number)paramObject1).doubleValue();
      d2 = ((Number)paramObject2).doubleValue();
      paramObject1 = io.a(localac, 2, new double[] { localac.h(), d2 - d1 + localac.h() });
      AppMethodBeat.o(221521);
      return paramObject1;
    }
    double d1 = ((Number)paramObject1).doubleValue();
    double d2 = ((Number)paramObject2).doubleValue();
    paramObject1 = io.a(localac, 4, new double[] { localac.i(), d2 - d1 + localac.i() });
    AppMethodBeat.o(221521);
    return paramObject1;
  }
  
  private List<Integer> a(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(221621);
    sc localsc = this.o.g;
    paramRect = (List)localsc.a(new sc.23(localsc, paramRect, paramInt), null);
    AppMethodBeat.o(221621);
    return paramRect;
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(221817);
    y localy = this.o.i.o;
    synchronized (localy.c)
    {
      while ((!localy.b.isEmpty()) && (((iu)localy.b.get(localy.b.size() - 1)).z == 3))
      {
        iu localiu = (iu)localy.b.remove(localy.b.size() - 1);
        paramDouble1 += localiu.A[0];
        paramDouble2 += localiu.A[1];
      }
      localy.a(new iu(3, new double[] { paramDouble1, paramDouble2 }));
      AppMethodBeat.o(221817);
      return;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    AppMethodBeat.i(222102);
    this.o.i.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, null);
    AppMethodBeat.o(222102);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(221968);
    sc localsc = this.o.g;
    if (0L != localsc.e) {
      localsc.a(new sc.142(localsc, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    }
    AppMethodBeat.o(221968);
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(221189);
    this.o.i.b(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(221189);
  }
  
  private void a(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221652);
    ac localac = this.o.i;
    localac.a(paramInt, new ac.5(localac, paramFloat));
    AppMethodBeat.o(221652);
  }
  
  @Deprecated
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(222166);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.a(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(222166);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(222083);
    if (this.o != null)
    {
      Object localObject = this.o;
      if (((mk)localObject).g != null)
      {
        localObject = ((mk)localObject).g;
        ((sc)localObject).a(new sc.16((sc)localObject, paramInt2, paramInt1, paramInt3, paramInt4));
      }
    }
    AppMethodBeat.o(222083);
  }
  
  private void a(Rect paramRect)
  {
    AppMethodBeat.i(221750);
    this.o.i.a(paramRect);
    AppMethodBeat.o(221750);
  }
  
  private void a(Rect paramRect, int paramInt1, int paramInt2, fg paramfg)
  {
    AppMethodBeat.i(221498);
    mk localmk = this.o;
    if (paramRect == null) {
      paramRect = this.o.i.q();
    }
    while ((paramRect == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramfg == null))
    {
      AppMethodBeat.o(221498);
      return;
    }
    mk.f.a(localmk.s, null, paramRect, paramfg, paramInt1, paramInt2);
    AppMethodBeat.o(221498);
  }
  
  private void a(GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(221879);
    this.M = paramFloat1;
    this.N.setLatitudeE6(paramGeoPoint.getLatitudeE6());
    this.N.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    if (this.o != null)
    {
      this.o.a(this.N, this.M, paramFloat2, paramBoolean);
      if ((this.O == 1) || (this.O == 2)) {
        a(this.N, r());
      }
      if ((this.O == 2) && (!ae())) {
        b(this.M);
      }
    }
    AppMethodBeat.o(221879);
  }
  
  private void a(GeoPoint paramGeoPoint, float paramFloat, Runnable paramRunnable)
  {
    AppMethodBeat.i(221716);
    ac localac = this.o.i;
    if (paramGeoPoint != null)
    {
      localac.o.e();
      int i1 = 0;
      double d1 = localac.A.b.p;
      double d2 = paramFloat / d1;
      if (d2 > 1.0D) {
        i1 = (int)(d2 / 0.5D);
      }
      for (;;)
      {
        int i2 = Math.max(60, Math.min(120, i1 >> 1 << 1));
        d1 = Math.log10(d1) / Math.log10(2.0D);
        d2 = Math.log10(paramFloat) / Math.log10(2.0D);
        GeoPoint localGeoPoint = localac.A.m;
        i1 = 0;
        while (i1 < i2)
        {
          double d3 = Math.pow(2.0D, lu.a(d1, d2, i2, i1 + 1));
          double d4 = lu.a(localGeoPoint.getLatitudeE6(), paramGeoPoint.getLatitudeE6(), i2, i1 + 1);
          double d5 = lu.a(localGeoPoint.getLongitudeE6(), paramGeoPoint.getLongitudeE6(), i2, i1 + 1);
          kh.a("debug location anim zoomOut:" + d4 + "," + d5);
          localac.b(new iu(120, new double[] { d3, d4, d5 }));
          i1 += 1;
        }
        if (d2 >= 1.0D) {
          break;
        }
        if (d2 != 1.0D) {
          i1 = (int)(0.5D / d2);
        }
      }
      localac.b(paramGeoPoint, paramRunnable);
      AppMethodBeat.o(221716);
      return;
      if (paramRunnable != null) {
        localac.b(new iu(paramRunnable));
      }
    }
    AppMethodBeat.o(221716);
  }
  
  private void a(GeoPoint paramGeoPoint, int paramInt)
  {
    AppMethodBeat.i(221698);
    this.o.i.a(paramGeoPoint, paramInt, null);
    AppMethodBeat.o(221698);
  }
  
  private void a(GeoPoint paramGeoPoint, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(221707);
    this.o.i.a(paramGeoPoint, paramInt, paramRunnable);
    AppMethodBeat.o(221707);
  }
  
  private void a(GeoPoint paramGeoPoint, Rect paramRect)
  {
    double d2 = 0.0D;
    AppMethodBeat.i(221729);
    ac localac = this.o.i;
    ep localep = localac.B;
    paramGeoPoint = localep.a(paramGeoPoint);
    double d1;
    if (!paramRect.contains((int)paramGeoPoint.a, (int)paramGeoPoint.b))
    {
      if (paramGeoPoint.a >= paramRect.left) {
        break label158;
      }
      d1 = paramRect.left - paramGeoPoint.a;
    }
    for (;;)
    {
      if (paramGeoPoint.b < paramRect.top) {
        d2 = paramRect.top - paramGeoPoint.b;
      }
      for (;;)
      {
        paramGeoPoint = localep.a(localac.A.m);
        paramGeoPoint.a -= d1;
        paramGeoPoint.b -= d2;
        localac.a(localep.a(paramGeoPoint), null);
        AppMethodBeat.o(221729);
        return;
        label158:
        if (paramGeoPoint.a <= paramRect.right) {
          break label213;
        }
        d1 = paramRect.right - paramGeoPoint.a;
        break;
        if (paramGeoPoint.b > paramRect.bottom) {
          d2 = paramRect.bottom - paramGeoPoint.b;
        }
      }
      label213:
      d1 = 0.0D;
    }
  }
  
  private void a(GeoPoint paramGeoPoint, RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(221898);
    if (this.o != null)
    {
      mk localmk = this.o;
      if ((paramRectF != null) && (localmk.C != null))
      {
        paramRectF.left -= localmk.C.left;
        paramRectF.top -= localmk.C.top;
        paramRectF.right -= localmk.C.right;
        paramRectF.bottom -= localmk.C.bottom;
      }
      if (localmk.g != null)
      {
        sc localsc = localmk.g;
        int i1 = localmk.E;
        int i2 = localmk.D;
        if ((0L == localsc.e) || (localsc.j == null))
        {
          AppMethodBeat.o(221898);
          return;
        }
        localsc.j.a(new sc.164(localsc, paramRectF, paramGeoPoint, i1, i2, paramBoolean));
      }
    }
    AppMethodBeat.o(221898);
  }
  
  private void a(GeoPoint paramGeoPoint, id paramid)
  {
    AppMethodBeat.i(222225);
    ac localac = this.o.i;
    boolean bool = false;
    Object localObject = localac.r();
    if (localObject != null) {
      bool = ((Rect)localObject).contains(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    }
    paramid = new ac.6(localac, paramid);
    float f3 = localac.A.b.p;
    fl localfl1;
    fl localfl2;
    int i2;
    int i1;
    double d1;
    double d2;
    if (!bool)
    {
      localObject = localac.A.m;
      localfl1 = localac.B.a((GeoPoint)localObject);
      localfl2 = localac.B.a(paramGeoPoint);
      i2 = 1;
      i1 = i2;
      if (localac.C != null)
      {
        d1 = Math.abs(localfl1.a - localfl2.a);
        d2 = Math.abs(localfl1.b - localfl2.b);
        if (d1 <= localac.C.width())
        {
          i1 = i2;
          if (d2 <= localac.C.height()) {}
        }
        else
        {
          i1 = 0;
        }
      }
      if (i1 == 0)
      {
        if (localac.C == null) {
          break label531;
        }
        i2 = localac.C.width();
        i1 = localac.C.height();
      }
    }
    for (;;)
    {
      float f1;
      if ((i2 == 0) || (i1 == 0) || (localObject == null) || (paramGeoPoint == null)) {
        f1 = 1.0F;
      }
      for (;;)
      {
        localac.b(new GeoPoint((paramGeoPoint.getLatitudeE6() + ((GeoPoint)localObject).getLatitudeE6()) / 2, (paramGeoPoint.getLongitudeE6() + ((GeoPoint)localObject).getLongitudeE6()) / 2), f1, new ac.7(localac, paramGeoPoint, f3, paramid));
        AppMethodBeat.o(222225);
        return;
        localfl1 = ac.a((GeoPoint)localObject);
        localfl2 = ac.a(paramGeoPoint);
        d2 = localfl2.a - localfl1.a;
        d1 = d2;
        if (d2 < 0.0D) {
          d1 = Math.abs(d2);
        }
        double d3 = localfl2.b - localfl1.b;
        d2 = d3;
        if (d3 < 0.0D) {
          d2 = Math.abs(d3);
        }
        i2 = i2 - localac.H - localac.J;
        int i3 = i1 - localac.I - localac.K;
        i1 = i2;
        if (i2 <= 0) {
          i1 = 1;
        }
        i2 = i3;
        if (i3 <= 0) {
          i2 = 1;
        }
        float f2 = (float)(20.0D - Math.max(Math.log(1.0D * d1 / i1) / Math.log(2.0D), Math.log(d2 * 1.0D / i2) / Math.log(2.0D)));
        f1 = f2;
        if (localac.A != null) {
          f1 = v.a.a((int)f2);
        }
      }
      localac.b(paramGeoPoint, paramid);
      AppMethodBeat.o(222225);
      return;
      localac.b(paramGeoPoint, paramid);
      AppMethodBeat.o(222225);
      return;
      label531:
      i1 = 0;
      i2 = 0;
    }
  }
  
  private void a(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    AppMethodBeat.i(221669);
    ac localac = this.o.i;
    if (paramGeoPoint != null) {
      localac.a(paramGeoPoint, localac.A.b.q, paramRunnable);
    }
    AppMethodBeat.o(221669);
  }
  
  private void a(ac.a parama)
  {
    this.o.i.D = parama;
  }
  
  private void a(eq parameq)
  {
    AppMethodBeat.i(221228);
    this.o.k.a(parameq);
    this.o.v = true;
    AppMethodBeat.o(221228);
  }
  
  private void a(eq parameq, int paramInt1, int paramInt2, fg paramfg)
  {
    AppMethodBeat.i(221493);
    mk localmk = this.o;
    Rect localRect = parameq.getBound(localmk.n);
    if ((parameq == null) || (localRect == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramfg == null))
    {
      AppMethodBeat.o(221493);
      return;
    }
    mk.f.a(localmk.s, parameq, localRect, paramfg, paramInt1, paramInt2);
    AppMethodBeat.o(221493);
  }
  
  private void a(es parames)
  {
    AppMethodBeat.i(221825);
    if (this.o != null)
    {
      mk localmk = this.o;
      if (localmk.m != null) {
        localmk.m.a(parames);
      }
    }
    AppMethodBeat.o(221825);
  }
  
  private void a(et paramet)
  {
    AppMethodBeat.i(221466);
    bi localbi = this.o.k;
    if (paramet == null)
    {
      AppMethodBeat.o(221466);
      return;
    }
    if (localbi.f == null) {
      localbi.f = new ArrayList();
    }
    localbi.f.add(paramet);
    AppMethodBeat.o(221466);
  }
  
  private void a(eu parameu)
  {
    this.o.k.e = parameu;
  }
  
  private void a(ev paramev)
  {
    AppMethodBeat.i(221285);
    ac localac = this.o.i;
    if (paramev != null) {
      synchronized (localac.r)
      {
        if (!localac.r.contains(paramev)) {
          localac.r.add(paramev);
        }
        AppMethodBeat.o(221285);
        return;
      }
    }
    AppMethodBeat.o(221285);
  }
  
  private void a(ew paramew)
  {
    this.o.k.g = paramew;
  }
  
  private void a(ex paramex)
  {
    AppMethodBeat.i(221296);
    ac localac = this.o.i;
    if (paramex != null)
    {
      if (localac.s == null) {
        localac.s = new ArrayList();
      }
      synchronized (localac.t)
      {
        if (!localac.s.contains(paramex)) {
          localac.s.add(paramex);
        }
        AppMethodBeat.o(221296);
        return;
      }
    }
    AppMethodBeat.o(221296);
  }
  
  private void a(ez paramez)
  {
    AppMethodBeat.i(222277);
    this.o.a(paramez);
    AppMethodBeat.o(222277);
  }
  
  private void a(fa paramfa)
  {
    AppMethodBeat.i(221275);
    ac localac = this.o.i;
    if (paramfa != null) {
      synchronized (localac.q)
      {
        if (!localac.q.contains(paramfa)) {
          localac.q.add(paramfa);
        }
        AppMethodBeat.o(221275);
        return;
      }
    }
    AppMethodBeat.o(221275);
  }
  
  private void a(fb paramfb)
  {
    AppMethodBeat.i(221384);
    ac localac = this.o.i;
    if (paramfb != null) {
      synchronized (localac.x)
      {
        if (!localac.x.contains(paramfb)) {
          localac.x.add(paramfb);
        }
        AppMethodBeat.o(221384);
        return;
      }
    }
    AppMethodBeat.o(221384);
  }
  
  private void a(fc paramfc)
  {
    AppMethodBeat.i(221424);
    ac localac = this.o.i;
    if (paramfc != null) {
      synchronized (localac.u)
      {
        if (!localac.u.contains(paramfc)) {
          localac.u.add(paramfc);
        }
        AppMethodBeat.o(221424);
        return;
      }
    }
    AppMethodBeat.o(221424);
  }
  
  private void a(ff paramff)
  {
    AppMethodBeat.i(221404);
    this.o.i.a(paramff);
    AppMethodBeat.o(221404);
  }
  
  private void a(fi paramfi)
  {
    AppMethodBeat.i(221438);
    this.o.i.a(paramfi);
    AppMethodBeat.o(221438);
  }
  
  private void a(nt paramnt)
  {
    AppMethodBeat.i(221107);
    if (this.o != null) {
      this.o.a(paramnt);
    }
    AppMethodBeat.o(221107);
  }
  
  private void a(oa paramoa)
  {
    AppMethodBeat.i(222042);
    this.o.a(paramoa);
    AppMethodBeat.o(222042);
  }
  
  private void a(oe paramoe)
  {
    if (this.o == null) {
      return;
    }
    this.o.G = paramoe;
  }
  
  private void a(oi paramoi)
  {
    AppMethodBeat.i(221445);
    this.o.i.a(paramoi);
    AppMethodBeat.o(221445);
  }
  
  private void a(qp paramqp)
  {
    AppMethodBeat.i(221557);
    Object localObject = this.o;
    if (((mk)localObject).j != null)
    {
      localObject = ((mk)localObject).j;
      if ((((qs)localObject).b != null) && (paramqp != null))
      {
        localObject = ((qs)localObject).b;
        if ((((qr)localObject).a == null) || (paramqp == null))
        {
          AppMethodBeat.o(221557);
          return;
        }
        ((qr)localObject).a.add(paramqp);
      }
    }
    AppMethodBeat.o(221557);
  }
  
  private void a(Language paramLanguage)
  {
    AppMethodBeat.i(222253);
    Object localObject = this.o;
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
    AppMethodBeat.o(222253);
  }
  
  private void a(LatLngBounds paramLatLngBounds, int paramInt)
  {
    AppMethodBeat.i(222414);
    if (this.o == null)
    {
      AppMethodBeat.o(222414);
      return;
    }
    this.o.a(paramLatLngBounds, paramInt);
    AppMethodBeat.o(222414);
  }
  
  private void a(List<MapRouteSection> paramList, List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(221614);
    Object localObject = this.o;
    if (((mk)localObject).z == null) {
      ((mk)localObject).z = new mk.e((mk)localObject);
    }
    localObject = ((mk)localObject).z;
    ((mk.e)localObject).a = paramList;
    ((mk.e)localObject).b = paramList1;
    mk.a(((mk.e)localObject).c).a(paramList, paramList1);
    AppMethodBeat.o(221614);
  }
  
  private static boolean a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221102);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(221102);
      return false;
    }
    int i1 = paramGeoPoint.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    boolean bool = GeometryConstants.BOUNDARY_WORLD.contains(i2, i1);
    AppMethodBeat.o(221102);
    return bool;
  }
  
  private boolean a(String paramString)
  {
    AppMethodBeat.i(221217);
    Object localObject = this.o;
    if (((mk)localObject).g == null)
    {
      AppMethodBeat.o(221217);
      return false;
    }
    localObject = ((mk)localObject).g;
    boolean bool = ((Boolean)((sc)localObject).a(new sc.89((sc)localObject, paramString), Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(221217);
    return bool;
  }
  
  private boolean a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221369);
    w localw = this.o.r;
    if (localw == null)
    {
      AppMethodBeat.o(221369);
      return false;
    }
    if (localw.b == null)
    {
      AppMethodBeat.o(221369);
      return false;
    }
    boolean bool = w.a(new File(localw.b.c()), paramString, paramArrayOfByte, localw.d);
    AppMethodBeat.o(221369);
    return bool;
  }
  
  private boolean aA()
  {
    return this.n;
  }
  
  private void aB()
  {
    this.n = true;
  }
  
  private ArrayList<MapPoi> aC()
  {
    AppMethodBeat.i(222368);
    if (this.o == null)
    {
      AppMethodBeat.o(222368);
      return null;
    }
    ArrayList localArrayList = this.o.D();
    AppMethodBeat.o(222368);
    return localArrayList;
  }
  
  private String aD()
  {
    AppMethodBeat.i(222388);
    if (this.o == null)
    {
      AppMethodBeat.o(222388);
      return null;
    }
    Object localObject = this.o;
    if (((mk)localObject).g == null)
    {
      AppMethodBeat.o(222388);
      return null;
    }
    localObject = ((mk)localObject).g;
    localObject = (String)((sc)localObject).a(new sc.41((sc)localObject), null);
    AppMethodBeat.o(222388);
    return localObject;
  }
  
  private String aE()
  {
    AppMethodBeat.i(222398);
    if (this.o == null)
    {
      AppMethodBeat.o(222398);
      return null;
    }
    Object localObject = this.o;
    if (((mk)localObject).g == null)
    {
      AppMethodBeat.o(222398);
      return null;
    }
    localObject = ((mk)localObject).g.a();
    AppMethodBeat.o(222398);
    return localObject;
  }
  
  private mk aF()
  {
    return this.o;
  }
  
  private bg aG()
  {
    return this.q;
  }
  
  private void aH()
  {
    AppMethodBeat.i(222436);
    Object localObject;
    if (this.r != null)
    {
      localObject = this.r;
      ((bf)localObject).c();
      ((bf)localObject).a = null;
      this.r = null;
    }
    if (this.q != null)
    {
      localObject = this.q;
      if (((bg)localObject).b != null)
      {
        ((VectorMap)((bg)localObject).b.e_).b(((bg)localObject).k);
        sj localsj = ((bg)localObject).b;
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
        ((bg)localObject).b = null;
      }
      if (((bg)localObject).c != null) {
        ((bg)localObject).c = null;
      }
      if (gv.b != null) {
        gv.b.c();
      }
      this.q = null;
    }
    AppMethodBeat.o(222436);
  }
  
  private void aI()
  {
    Object localObject;
    if (this.F != null)
    {
      localObject = this.F;
      if (((ad)localObject).a != null) {
        ((ad)localObject).a = null;
      }
      this.F = null;
    }
    if (this.E != null)
    {
      localObject = this.E;
      if (((ab)localObject).a != null) {
        ((ab)localObject).a = null;
      }
      this.E = null;
    }
    if (this.D != null)
    {
      localObject = this.D;
      if (((z)localObject).b != null) {
        ((z)localObject).b = null;
      }
      this.D = null;
    }
    if (this.C != null) {
      this.C = null;
    }
    if (this.B != null)
    {
      localObject = this.B;
      if (((ae)localObject).a != null) {
        ((ae)localObject).a = null;
      }
      this.B = null;
    }
  }
  
  private long aa()
  {
    AppMethodBeat.i(221529);
    long l1 = this.o.i.o.c();
    AppMethodBeat.o(221529);
    return l1;
  }
  
  private void ab()
  {
    AppMethodBeat.i(221535);
    this.o.i.o.a();
    AppMethodBeat.o(221535);
  }
  
  private void ac()
  {
    AppMethodBeat.i(221540);
    this.o.i.o.b();
    AppMethodBeat.o(221540);
  }
  
  private String ad()
  {
    AppMethodBeat.i(221637);
    String str = this.o.toString();
    AppMethodBeat.o(221637);
    return str;
  }
  
  private boolean ae()
  {
    AppMethodBeat.i(221745);
    boolean bool = this.o.i.o.f();
    AppMethodBeat.o(221745);
    return bool;
  }
  
  private void af()
  {
    this.o.i.o.e = 60;
  }
  
  private int ag()
  {
    return this.o.i.A.d;
  }
  
  private Rect ah()
  {
    return this.o.o;
  }
  
  private void ai()
  {
    AppMethodBeat.i(221835);
    this.o.i.e();
    AppMethodBeat.o(221835);
  }
  
  private void aj()
  {
    AppMethodBeat.i(221842);
    this.o.i.f();
    AppMethodBeat.o(221842);
  }
  
  private void ak()
  {
    AppMethodBeat.i(221849);
    mk localmk = this.o;
    if ((localmk.q) && (localmk.j != null)) {
      localmk.j.a();
    }
    AppMethodBeat.o(221849);
  }
  
  private void al()
  {
    AppMethodBeat.i(221858);
    mk localmk = this.o;
    if ((localmk.q) && (localmk.j != null)) {
      localmk.j.b();
    }
    AppMethodBeat.o(221858);
  }
  
  private int am()
  {
    return this.O;
  }
  
  private bf an()
  {
    return this.r;
  }
  
  private String[] ao()
  {
    AppMethodBeat.i(221937);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      localObject = (String[])((sc)localObject).a(new sc.135((sc)localObject), null);
      AppMethodBeat.o(221937);
      return localObject;
    }
    AppMethodBeat.o(221937);
    return null;
  }
  
  private String ap()
  {
    AppMethodBeat.i(221944);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      localObject = (String)((sc)localObject).a(new sc.139((sc)localObject), null);
      AppMethodBeat.o(221944);
      return localObject;
    }
    AppMethodBeat.o(221944);
    return null;
  }
  
  private Rect aq()
  {
    AppMethodBeat.i(221977);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      localObject = (Rect)((sc)localObject).a(new sc.138((sc)localObject), null);
      AppMethodBeat.o(221977);
      return localObject;
    }
    AppMethodBeat.o(221977);
    return null;
  }
  
  private v ar()
  {
    AppMethodBeat.i(222055);
    v localv = this.o.i.g();
    AppMethodBeat.o(222055);
    return localv;
  }
  
  private void as()
  {
    AppMethodBeat.i(222107);
    this.o.i.j();
    AppMethodBeat.o(222107);
  }
  
  private mj at()
  {
    return this.o.l;
  }
  
  private v au()
  {
    return this.o.t;
  }
  
  private boolean av()
  {
    AppMethodBeat.i(222171);
    boolean bool = this.o.H.f.t();
    AppMethodBeat.o(222171);
    return bool;
  }
  
  private Language aw()
  {
    AppMethodBeat.i(222263);
    Language localLanguage = this.o.B();
    AppMethodBeat.o(222263);
    return localLanguage;
  }
  
  private void ax()
  {
    AppMethodBeat.i(222271);
    if (this.r == null) {
      this.r = new bf(this.o, this.D);
    }
    if (this.E == null) {
      this.E = new ab(this.r);
    }
    AppMethodBeat.o(222271);
  }
  
  private boolean ay()
  {
    return this.p;
  }
  
  private String az()
  {
    AppMethodBeat.i(222343);
    String str = null;
    if (this.o != null) {
      str = this.o.v();
    }
    AppMethodBeat.o(222343);
    return str;
  }
  
  private void b(double paramDouble)
  {
    AppMethodBeat.i(221809);
    ac localac = this.o.i;
    localac.a((360.0D - paramDouble) % 360.0D, localac.i(), true);
    AppMethodBeat.o(221809);
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221184);
    this.o.i.b(paramFloat1, paramFloat2, true);
    AppMethodBeat.o(221184);
  }
  
  private void b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(221776);
    this.o.i.a(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(221776);
  }
  
  private void b(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(222211);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.a(paramInt, paramFloat);
    }
    AppMethodBeat.o(222211);
  }
  
  private void b(Rect paramRect)
  {
    AppMethodBeat.i(221780);
    this.o.i.b(paramRect);
    AppMethodBeat.o(221780);
  }
  
  private void b(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(221659);
    this.o.i.b(paramRect1, paramRect2);
    AppMethodBeat.o(221659);
  }
  
  private void b(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    AppMethodBeat.i(221681);
    this.o.i.a(paramGeoPoint, paramRunnable);
    AppMethodBeat.o(221681);
  }
  
  private void b(PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(221577);
    this.o.b(paramPolygonInfo);
    AppMethodBeat.o(221577);
  }
  
  private void b(ba paramba)
  {
    AppMethodBeat.i(222115);
    ac localac = this.o.i;
    if (localac.v != null) {
      synchronized (localac.w)
      {
        localac.v.remove(paramba);
        AppMethodBeat.o(222115);
        return;
      }
    }
    AppMethodBeat.o(222115);
  }
  
  private void b(eq parameq)
  {
    AppMethodBeat.i(221234);
    this.o.k.a(parameq);
    this.o.v = true;
    AppMethodBeat.o(221234);
  }
  
  private void b(es parames)
  {
    AppMethodBeat.i(221829);
    if (this.o != null)
    {
      mk localmk = this.o;
      if (localmk.m != null) {
        localmk.m.b(parames);
      }
    }
    AppMethodBeat.o(221829);
  }
  
  private void b(et paramet)
  {
    AppMethodBeat.i(221471);
    bi localbi = this.o.k;
    if ((paramet == null) || (localbi.f == null))
    {
      AppMethodBeat.o(221471);
      return;
    }
    localbi.f.remove(paramet);
    AppMethodBeat.o(221471);
  }
  
  private void b(ev paramev)
  {
    AppMethodBeat.i(221290);
    ac localac = this.o.i;
    synchronized (localac.r)
    {
      localac.r.remove(paramev);
      AppMethodBeat.o(221290);
      return;
    }
  }
  
  private void b(ex paramex)
  {
    AppMethodBeat.i(221300);
    ac localac = this.o.i;
    if (localac.s != null) {
      synchronized (localac.t)
      {
        localac.s.remove(paramex);
        AppMethodBeat.o(221300);
        return;
      }
    }
    AppMethodBeat.o(221300);
  }
  
  private void b(ez paramez)
  {
    AppMethodBeat.i(222287);
    this.o.b(paramez);
    AppMethodBeat.o(222287);
  }
  
  private void b(fa paramfa)
  {
    AppMethodBeat.i(221280);
    ac localac = this.o.i;
    synchronized (localac.q)
    {
      localac.q.remove(paramfa);
      AppMethodBeat.o(221280);
      return;
    }
  }
  
  private void b(fb paramfb)
  {
    AppMethodBeat.i(221392);
    ac localac = this.o.i;
    synchronized (localac.x)
    {
      localac.x.remove(paramfb);
      AppMethodBeat.o(221392);
      return;
    }
  }
  
  private void b(fc paramfc)
  {
    AppMethodBeat.i(221431);
    ac localac = this.o.i;
    synchronized (localac.u)
    {
      localac.u.remove(paramfc);
      AppMethodBeat.o(221431);
      return;
    }
  }
  
  private void b(fd paramfd)
  {
    AppMethodBeat.i(221416);
    this.o.i.b(paramfd);
    AppMethodBeat.o(221416);
  }
  
  private void b(ff paramff)
  {
    AppMethodBeat.i(221412);
    this.o.i.b(paramff);
    AppMethodBeat.o(221412);
  }
  
  private void b(fi paramfi)
  {
    AppMethodBeat.i(221454);
    this.o.i.b(paramfi);
    AppMethodBeat.o(221454);
  }
  
  private void b(oc paramoc)
  {
    AppMethodBeat.i(222297);
    mk localmk = this.o;
    if (!localmk.I.isEmpty()) {
      localmk.I.remove(paramoc);
    }
    AppMethodBeat.o(222297);
  }
  
  private void b(oi paramoi)
  {
    AppMethodBeat.i(221448);
    this.o.i.b(paramoi);
    AppMethodBeat.o(221448);
  }
  
  private void b(qp paramqp)
  {
    AppMethodBeat.i(221562);
    Object localObject = this.o;
    if (((mk)localObject).j != null)
    {
      localObject = ((mk)localObject).j;
      if ((((qs)localObject).b != null) && (paramqp != null))
      {
        localObject = ((qs)localObject).b;
        if ((((qr)localObject).a == null) || (paramqp == null))
        {
          AppMethodBeat.o(221562);
          return;
        }
        ((qr)localObject).a.remove(paramqp);
      }
    }
    AppMethodBeat.o(221562);
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(222017);
    sc localsc = this.o.g;
    if (0L != localsc.e) {
      localsc.a(new sc.150(localsc, paramString));
    }
    AppMethodBeat.o(222017);
  }
  
  private static boolean b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221122);
    boolean bool = eh.a.contains(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    AppMethodBeat.o(221122);
    return bool;
  }
  
  private boolean b(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221372);
    w localw = this.o.r;
    if (localw == null)
    {
      AppMethodBeat.o(221372);
      return false;
    }
    if (localw.b == null)
    {
      AppMethodBeat.o(221372);
      return false;
    }
    boolean bool = w.a(new File(localw.b.e()), paramString, paramArrayOfByte, localw.e);
    AppMethodBeat.o(221372);
    return bool;
  }
  
  private String c(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221134);
    paramGeoPoint = this.o.a(paramGeoPoint);
    AppMethodBeat.o(221134);
    return paramGeoPoint;
  }
  
  private void c(double paramDouble)
  {
    AppMethodBeat.i(222093);
    this.o.i.a((float)paramDouble);
    AppMethodBeat.o(222093);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221770);
    this.o.i.a(paramFloat1, paramFloat2, true);
    AppMethodBeat.o(221770);
  }
  
  private void c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(222065);
    this.o.i.M = true;
    this.o.i.a(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(222065);
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(221176);
    this.o.i.a(paramInt);
    AppMethodBeat.o(221176);
  }
  
  private void c(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(221737);
    this.o.i.c(paramRect1, paramRect2);
    AppMethodBeat.o(221737);
  }
  
  private void c(eq parameq)
  {
    AppMethodBeat.i(221242);
    this.o.k.a(parameq);
    this.o.v = true;
    AppMethodBeat.o(221242);
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(222206);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      if (0L != ((sc)localObject).e) {
        ((sc)localObject).a(new sc.127((sc)localObject, paramString));
      }
    }
    AppMethodBeat.o(222206);
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(221206);
    if (paramBoolean)
    {
      localmk = this.o;
      if (localmk.g != null)
      {
        localmk.g.k();
        localmk.p = true;
      }
      AppMethodBeat.o(221206);
      return;
    }
    mk localmk = this.o;
    if (localmk.g != null)
    {
      localmk.g.l();
      localmk.p = false;
    }
    AppMethodBeat.o(221206);
  }
  
  private void d(float paramFloat)
  {
    AppMethodBeat.i(221867);
    this.M = paramFloat;
    if (this.o != null)
    {
      this.o.a(paramFloat);
      if ((this.O == 2) && (!ae())) {
        b(this.M);
      }
    }
    AppMethodBeat.o(221867);
  }
  
  private void d(float paramFloat1, float paramFloat2)
  {
    if (this.o != null)
    {
      ac localac = this.o.i;
      localac.E = paramFloat1;
      localac.F = paramFloat2;
    }
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(221317);
    this.o.i.a(paramInt);
    AppMethodBeat.o(221317);
  }
  
  private void d(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221306);
    this.o.i.a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6(), 1);
    AppMethodBeat.o(221306);
  }
  
  private void d(eq parameq)
  {
    try
    {
      AppMethodBeat.i(221255);
      this.o.k.a(parameq);
      this.o.v = true;
      AppMethodBeat.o(221255);
      return;
    }
    finally
    {
      parameq = finally;
      throw parameq;
    }
  }
  
  private void d(String paramString)
  {
    AppMethodBeat.i(222304);
    this.o.a(paramString);
    AppMethodBeat.o(222304);
  }
  
  private void d(boolean paramBoolean)
  {
    AppMethodBeat.i(221985);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      if (((sc)localObject).e != 0L) {
        ((sc)localObject).a(new sc.143((sc)localObject, paramBoolean));
      }
    }
    AppMethodBeat.o(221985);
  }
  
  private static boolean d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221113);
    boolean bool = GeometryConstants.BOUNDARY_WORLD.contains(paramInt2, paramInt1);
    AppMethodBeat.o(221113);
    return bool;
  }
  
  private void e(int paramInt)
  {
    AppMethodBeat.i(221330);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      ((sc)localObject).a(new sc.148((sc)localObject, paramInt));
    }
    AppMethodBeat.o(221330);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    int i1 = 255;
    AppMethodBeat.i(221601);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      if (paramInt2 >= 0) {
        break label86;
      }
      paramInt2 = 0;
    }
    label86:
    for (;;)
    {
      if (paramInt2 > 255) {
        paramInt2 = i1;
      }
      for (;;)
      {
        i1 = 255 - paramInt2;
        paramInt2 = i1;
        if (i1 == 0) {
          paramInt2 = 1;
        }
        localObject = ((mk)localObject).g;
        ((sc)localObject).a(new sc.85((sc)localObject, paramInt1, paramInt2));
        AppMethodBeat.o(221601);
        return;
      }
    }
  }
  
  private void e(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221312);
    if (paramGeoPoint == null) {}
    int i1;
    int i2;
    for (boolean bool = false;; bool = GeometryConstants.BOUNDARY_WORLD.contains(i2, i1))
    {
      if (bool) {
        this.o.i.a(paramGeoPoint, null);
      }
      AppMethodBeat.o(221312);
      return;
      i1 = paramGeoPoint.getLatitudeE6();
      i2 = paramGeoPoint.getLongitudeE6();
    }
  }
  
  private void e(eq parameq)
  {
    try
    {
      AppMethodBeat.i(221260);
      this.o.k.a(parameq);
      this.o.v = true;
      AppMethodBeat.o(221260);
      return;
    }
    finally
    {
      parameq = finally;
      throw parameq;
    }
  }
  
  private void e(String paramString)
  {
    AppMethodBeat.i(222309);
    this.o.b(paramString);
    AppMethodBeat.o(222309);
  }
  
  private void e(boolean paramBoolean)
  {
    AppMethodBeat.i(222003);
    sc localsc = this.o.g;
    if (0L != localsc.e) {
      localsc.a(new sc.147(localsc, paramBoolean));
    }
    AppMethodBeat.o(222003);
  }
  
  private boolean e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222461);
    Object localObject1 = this.o.k;
    Object localObject2 = ((bi)localObject1).a.f().a(paramFloat1, paramFloat2);
    int i1;
    boolean bool1;
    label124:
    boolean bool2;
    label215:
    ox localox;
    if ((localObject2 != null) && (((TappedElement)localObject2).type == 3))
    {
      if (((bi)localObject1).h != null) {
        ((bi)localObject1).h.R();
      }
      i1 = 1;
      if (i1 == 0)
      {
        if (this.r == null) {
          break label485;
        }
        localObject1 = this.r;
        localObject2 = ((bf)localObject1).g.k.a.f().a(paramFloat1, paramFloat2);
        if ((localObject2 == null) || (((TappedElement)localObject2).type != 6)) {
          break label479;
        }
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (((bf)localObject1).i != null)
          {
            localObject2 = new LatLng();
            if (((bf)localObject1).e != null)
            {
              ((LatLng)localObject2).setAltitude(((bf)localObject1).e.getAltitude());
              ((LatLng)localObject2).setLongitude(((bf)localObject1).e.getLongitude());
              ((LatLng)localObject2).setLatitude(((bf)localObject1).e.getLatitude());
            }
            bool2 = ((bf)localObject1).i.onMyLocationClicked((LatLng)localObject2);
          }
        }
        if (!bool2)
        {
          localObject1 = a(paramFloat1, paramFloat2);
          if ((localObject1 == null) || (this.s == null)) {
            break label502;
          }
          localObject2 = this.s;
          if ((((oz)localObject2).c == null) || (localObject1 == null) || (((TappedElement)localObject1).type != 4)) {
            break label497;
          }
          long l1 = ((TappedElement)localObject1).itemId;
          Iterator localIterator1 = ((oz)localObject2).a.iterator();
          label287:
          if (!localIterator1.hasNext()) {
            break label515;
          }
          localox = (ox)localIterator1.next();
          if ((localox.b == null) || (localox.b.a == null) || (localox.b.a.j == null)) {
            break label491;
          }
          Iterator localIterator2 = localox.b.a.j.iterator();
          while (localIterator2.hasNext())
          {
            localObject1 = (oy.d)localIterator2.next();
            nf localnf = (nf)localox.a.b.k.a(nf.class, ((oy.d)localObject1).a);
            if ((localnf != null) && (localnf.e_() == l1)) {
              label426:
              if (localObject1 == null) {
                break label495;
              }
            }
          }
        }
      }
    }
    label515:
    for (localObject1 = ox.a(localox.getId(), (oy.d)localObject1);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((oz)localObject2).c.onClicked((MapPoi)localObject1);
        i1 = 1;
      }
      for (;;)
      {
        if (i1 == 0) {
          break label507;
        }
        AppMethodBeat.o(222461);
        return true;
        i1 = 0;
        break;
        label479:
        bool1 = false;
        break label124;
        label485:
        bool2 = false;
        break label215;
        label491:
        localObject1 = null;
        break label426;
        label495:
        break label287;
        label497:
        i1 = 0;
        continue;
        label502:
        i1 = 0;
      }
      label507:
      AppMethodBeat.o(222461);
      return false;
    }
  }
  
  private static float f(int paramInt)
  {
    AppMethodBeat.i(221338);
    float f1 = v.a.a(paramInt);
    AppMethodBeat.o(221338);
    return f1;
  }
  
  private int f(String paramString)
  {
    AppMethodBeat.i(222380);
    if (this.o == null)
    {
      AppMethodBeat.o(222380);
      return -1;
    }
    Object localObject = this.o;
    if (((mk)localObject).g == null)
    {
      AppMethodBeat.o(222380);
      return -1;
    }
    localObject = ((mk)localObject).g;
    int i1 = ((Integer)((sc)localObject).a(new sc.40((sc)localObject, paramString), Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(222380);
    return i1;
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    if (this.o != null)
    {
      mk localmk = this.o;
      localmk.E = paramInt1;
      localmk.D = paramInt2;
    }
  }
  
  private void f(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221689);
    a(paramGeoPoint, r());
    AppMethodBeat.o(221689);
  }
  
  private void f(eq parameq)
  {
    AppMethodBeat.i(221267);
    this.o.k.b(parameq);
    this.o.v = true;
    AppMethodBeat.o(221267);
  }
  
  private void f(boolean paramBoolean)
  {
    AppMethodBeat.i(222007);
    this.o.e(paramBoolean);
    AppMethodBeat.o(222007);
  }
  
  private boolean f(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222467);
    bi localbi = this.o.k;
    TappedElement localTappedElement = localbi.a.f().a(paramFloat1, paramFloat2);
    if ((localTappedElement != null) && (localTappedElement.type == 3))
    {
      if (localbi.h != null) {
        localbi.h.R();
      }
      AppMethodBeat.o(222467);
      return true;
    }
    AppMethodBeat.o(222467);
    return false;
  }
  
  private String g(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221953);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      paramGeoPoint = (String)((sc)localObject).a(new sc.140((sc)localObject, paramGeoPoint), null);
      AppMethodBeat.o(221953);
      return paramGeoPoint;
    }
    AppMethodBeat.o(221953);
    return null;
  }
  
  private void g(int paramInt)
  {
    AppMethodBeat.i(221582);
    this.o.a(paramInt);
    AppMethodBeat.o(221582);
  }
  
  @Deprecated
  private void g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222144);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.b(paramInt1, paramInt2);
    }
    AppMethodBeat.o(222144);
  }
  
  private void g(boolean paramBoolean)
  {
    AppMethodBeat.i(222023);
    this.o.g.f(paramBoolean);
    AppMethodBeat.o(222023);
  }
  
  private boolean g(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(222477);
    if (this.r != null)
    {
      bf localbf = this.r;
      Object localObject = localbf.g.k.a.f().a(paramFloat1, paramFloat2);
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((TappedElement)localObject).type == 6) {
          bool1 = true;
        }
      }
      if ((bool1) && (localbf.i != null))
      {
        localObject = new LatLng();
        if (localbf.e != null)
        {
          ((LatLng)localObject).setAltitude(localbf.e.getAltitude());
          ((LatLng)localObject).setLongitude(localbf.e.getLongitude());
          ((LatLng)localObject).setLatitude(localbf.e.getLatitude());
        }
        bool1 = localbf.i.onMyLocationClicked((LatLng)localObject);
        AppMethodBeat.o(222477);
        return bool1;
      }
      AppMethodBeat.o(222477);
      return bool1;
    }
    AppMethodBeat.o(222477);
    return false;
  }
  
  private ps h(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221960);
    sc localsc = this.o.g;
    GeoPoint localGeoPoint = paramGeoPoint;
    if (paramGeoPoint == null) {
      localGeoPoint = new GeoPoint();
    }
    paramGeoPoint = (ps)localsc.a(new sc.136(localsc, localGeoPoint), null);
    AppMethodBeat.o(221960);
    return paramGeoPoint;
  }
  
  private void h(int paramInt)
  {
    AppMethodBeat.i(221608);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      ((sc)localObject).a(new sc.86((sc)localObject, paramInt));
    }
    AppMethodBeat.o(221608);
  }
  
  private void h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222186);
    this.o.a(paramInt1, paramInt2);
    AppMethodBeat.o(222186);
  }
  
  private void h(boolean paramBoolean)
  {
    AppMethodBeat.i(222177);
    this.o.H.f.h(paramBoolean);
    AppMethodBeat.o(222177);
  }
  
  private boolean h(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222487);
    Object localObject = a(paramFloat1, paramFloat2);
    oz localoz;
    ox localox;
    if ((localObject != null) && (this.s != null))
    {
      localoz = this.s;
      if ((localoz.c != null) && (localObject != null) && (((TappedElement)localObject).type == 4))
      {
        long l1 = ((TappedElement)localObject).itemId;
        Iterator localIterator1 = localoz.a.iterator();
        if (!localIterator1.hasNext()) {
          break label274;
        }
        localox = (ox)localIterator1.next();
        if ((localox.b != null) && (localox.b.a != null) && (localox.b.a.j != null))
        {
          Iterator localIterator2 = localox.b.a.j.iterator();
          while (localIterator2.hasNext())
          {
            localObject = (oy.d)localIterator2.next();
            nf localnf = (nf)localox.a.b.k.a(nf.class, ((oy.d)localObject).a);
            if ((localnf != null) && (localnf.e_() == l1)) {
              label210:
              if (localObject == null) {
                break label256;
              }
            }
          }
        }
      }
    }
    label256:
    label274:
    for (localObject = ox.a(localox.getId(), (oy.d)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        localoz.c.onClicked((MapPoi)localObject);
        AppMethodBeat.o(222487);
        return true;
        localObject = null;
        break label210;
        break;
      }
      AppMethodBeat.o(222487);
      return false;
      AppMethodBeat.o(222487);
      return false;
    }
  }
  
  private void i(int paramInt)
  {
    AppMethodBeat.i(221643);
    ac localac = this.o.i;
    localac.a(paramInt, new ac.4(localac));
    AppMethodBeat.o(221643);
  }
  
  private void i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222192);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      ((sc)localObject).a(new sc.18((sc)localObject, paramInt1, paramInt2));
    }
    AppMethodBeat.o(222192);
  }
  
  private void i(boolean paramBoolean)
  {
    AppMethodBeat.i(222200);
    ac localac = this.o.i;
    localac.G = paramBoolean;
    localac.z.f().b(localac.G);
    AppMethodBeat.o(222200);
  }
  
  private boolean i(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(222243);
    ac localac = this.o.i;
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(222243);
      return true;
    }
    Object localObject = localac.r();
    if (localObject != null) {}
    for (boolean bool = ((Rect)localObject).contains(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());; bool = false)
    {
      localObject = localac.B.a(localac.A.m);
      paramGeoPoint = localac.B.a(paramGeoPoint);
      if (localac.C != null)
      {
        double d1 = Math.abs(((fl)localObject).a - paramGeoPoint.a);
        double d2 = Math.abs(((fl)localObject).b - paramGeoPoint.b);
        if ((d1 <= localac.C.width()) && (d2 <= localac.C.height())) {}
      }
      for (int i1 = 0;; i1 = 1)
      {
        if ((!bool) && (i1 == 0))
        {
          AppMethodBeat.o(222243);
          return true;
        }
        AppMethodBeat.o(222243);
        return false;
      }
    }
  }
  
  private void j(int paramInt)
  {
    AppMethodBeat.i(221763);
    this.o.i.o.a(paramInt);
    AppMethodBeat.o(221763);
  }
  
  private void j(boolean paramBoolean)
  {
    AppMethodBeat.i(222318);
    this.p = paramBoolean;
    this.o.g(paramBoolean);
    AppMethodBeat.o(222318);
  }
  
  private void k(int paramInt)
  {
    int i1 = 17;
    AppMethodBeat.i(221911);
    if (this.o == null)
    {
      AppMethodBeat.o(221911);
      return;
    }
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.O = paramInt;
        AppMethodBeat.o(221911);
        return;
        this.o.a(false, false);
      }
    case 1: 
      this.o.a(false, false);
      if (getMapStyle() != 11) {
        break;
      }
    }
    for (;;)
    {
      i1 -= 1;
      ac localac;
      if (this.O == 2)
      {
        localac = this.o.i;
        localac.a(i1, new ac.4(localac));
        break;
      }
      int i2 = r();
      if (i2 > i1) {
        i1 = i2;
      }
      for (;;)
      {
        a(this.N, i1);
        break;
        if (getMapStyle() == 11) {}
        for (;;)
        {
          int i3 = r();
          i2 = i1;
          if (i3 > i1) {
            i2 = i3;
          }
          if (this.N.getLatitudeE6() != 0) {
            this.o.i.a(this.N.getLatitudeE6(), this.N.getLongitudeE6(), 2);
          }
          float f1 = this.M;
          localac = this.o.i;
          localac.a(i2, new ac.5(localac, f1));
          new Handler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221085);
              VectorMap.a(VectorMap.this).a(true, false);
              AppMethodBeat.o(221085);
            }
          }, 1000L);
          break;
          this.o.a(false, true);
          break;
          i1 = 18;
        }
      }
      i1 = 18;
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.o != null)
    {
      mk localmk = this.o;
      if (localmk.i != null) {
        localmk.i.L = paramBoolean;
      }
    }
  }
  
  private static int l(int paramInt)
  {
    int i1 = 3;
    if (paramInt < 3) {
      paramInt = i1;
    }
    for (;;)
    {
      if (paramInt > 22) {
        return 22;
      }
      return paramInt;
    }
  }
  
  private void m(int paramInt)
  {
    AppMethodBeat.i(221994);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      if (0L != ((sc)localObject).e) {
        ((sc)localObject).a(new sc.146((sc)localObject, paramInt));
      }
    }
    AppMethodBeat.o(221994);
  }
  
  private void n(int paramInt)
  {
    AppMethodBeat.i(222034);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.b(paramInt);
    }
    if (localmk.t != null) {
      localmk.t.b.n = paramInt;
    }
    AppMethodBeat.o(222034);
  }
  
  @Deprecated
  private void o(int paramInt)
  {
    AppMethodBeat.i(222152);
    mk localmk = this.o;
    if (localmk.g != null)
    {
      localmk.g.d(paramInt);
      localmk.v = true;
    }
    AppMethodBeat.o(222152);
  }
  
  @Deprecated
  private void p(int paramInt)
  {
    AppMethodBeat.i(222158);
    mk localmk = this.o;
    if (localmk.g != null) {
      localmk.g.e(paramInt);
    }
    AppMethodBeat.o(222158);
  }
  
  private static int y()
  {
    return 20;
  }
  
  private String z()
  {
    AppMethodBeat.i(221140);
    String str = this.o.A();
    AppMethodBeat.o(221140);
    return str;
  }
  
  public final TappedElement a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(223420);
    TappedElement localTappedElement = this.o.a(paramFloat1, paramFloat2);
    AppMethodBeat.o(223420);
    return localTappedElement;
  }
  
  public final void a(double paramDouble)
  {
    AppMethodBeat.i(222763);
    this.o.i.c(paramDouble);
    AppMethodBeat.o(222763);
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(222737);
    this.o.i.a(paramFloat);
    AppMethodBeat.o(222737);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(223072);
    super.a(paramInt);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223072);
      return;
    }
    kh.b("TDZ", "setIndoorConfigType:".concat(String.valueOf(paramInt)));
    sc localsc = this.o.g;
    localsc.a(new sc.132(localsc, paramInt));
    AppMethodBeat.o(223072);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222732);
    this.o.i.a(paramInt1, paramInt2, 1);
    AppMethodBeat.o(222732);
  }
  
  public final void a(Bundle paramBundle)
  {
    AppMethodBeat.i(222507);
    super.a(paramBundle);
    this.L = ((sr)this.o.b);
    paramBundle = rg.a();
    Object localObject1 = this.o.getContext();
    if ((paramBundle.d) || (paramBundle.e)) {}
    for (;;)
    {
      this.q = new bg(this.o, this.L.getMapRenderView(), this.o.a);
      this.B = new ae(this.q);
      this.D = new z(this.q);
      this.K = new TencentMapPro(this.q, this.B);
      this.s = new oz(this.o);
      this.F = new ad(this.q.d);
      paramBundle = new bj.a()
      {
        public final void a()
        {
          AppMethodBeat.i(221081);
          VectorMap.this.setMyLocationEnabled(true);
          Object localObject = VectorMap.this.getMyLocation();
          if (localObject != null)
          {
            localObject = new LatLng(((Location)localObject).getLatitude(), ((Location)localObject).getLongitude());
            VectorMap.this.animateCamera(CameraUpdateFactory.newLatLng((LatLng)localObject));
          }
          AppMethodBeat.o(221081);
        }
      };
      localObject1 = this.q.d;
      if (((bj)localObject1).d != null) {
        ((bj)localObject1).d.d = paramBundle;
      }
      Object localObject2 = this.q;
      paramBundle = this.o.k;
      localObject1 = this.o.a;
      localObject2 = ((bg)localObject2).d;
      if ((localObject1 != null) && (((TencentMapOptions)localObject1).getExtSurface() != null) && (((bj)localObject2).e != null) && (localObject1 != null))
      {
        rd localrd = ((bj)localObject2).e;
        if ((localrd.o != null) && (paramBundle != null)) {
          localrd.o.add(paramBundle);
        }
        int i1 = ((TencentMapOptions)localObject1).getExtSurfaceWidth();
        int i2 = ((TencentMapOptions)localObject1).getExtSurfaceHeight();
        ((bj)localObject2).b.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        ((bj)localObject2).b(i1, i2);
      }
      this.A = new pb(this.q);
      paramBundle = this.A;
      localObject1 = this.o.k;
      localObject2 = this.o.a;
      paramBundle.a.a((pb.a)localObject1, (TencentMapOptions)localObject2);
      this.A.a();
      this.J = true;
      AppMethodBeat.o(222507);
      return;
      if (localObject1 != null)
      {
        paramBundle.b = (((Context)localObject1).getFilesDir() + "/frontiers.dat");
        paramBundle.c = (paramBundle.b + ".bak");
      }
      jw.a(new rg.1(paramBundle)).a(Boolean.FALSE);
    }
  }
  
  public final void a(ba paramba)
  {
    AppMethodBeat.i(223189);
    this.o.i.a(paramba);
    AppMethodBeat.o(223189);
  }
  
  public final void a(er paramer)
  {
    this.o.k.h = paramer;
  }
  
  public final void a(fd paramfd)
  {
    AppMethodBeat.i(222772);
    this.o.i.a(paramfd);
    AppMethodBeat.o(222772);
  }
  
  public final void a(fh paramfh)
  {
    AppMethodBeat.i(222717);
    this.o.i.a(paramfh);
    AppMethodBeat.o(222717);
  }
  
  public final void a(iu paramiu)
  {
    AppMethodBeat.i(223037);
    this.o.i.b(paramiu);
    AppMethodBeat.o(223037);
  }
  
  public final void a(oc paramoc)
  {
    AppMethodBeat.i(223412);
    this.o.a(paramoc);
    AppMethodBeat.o(223412);
  }
  
  public final void a(pn parampn)
  {
    AppMethodBeat.i(223062);
    Object localObject = this.o.i;
    if (((ac)localObject).p == null) {
      ((ac)localObject).p = ((ac)localObject).y.M();
    }
    localObject = ((ac)localObject).p;
    ((pk)localObject).b = parampn;
    boolean bool = parampn.a();
    if (((pk)localObject).d != null)
    {
      if (bool)
      {
        ((pk)localObject).d.b((es)localObject);
        AppMethodBeat.o(223062);
        return;
      }
      ((pk)localObject).d.a((es)localObject);
    }
    AppMethodBeat.o(223062);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(223530);
    if ((this.G) || (this.q == null))
    {
      AppMethodBeat.o(223530);
      return;
    }
    this.q.a.setZOrderMediaOverlay(paramBoolean);
    AppMethodBeat.o(223530);
  }
  
  public final void a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(223161);
    this.o.a(paramArrayOfString);
    AppMethodBeat.o(223161);
  }
  
  public final boolean a()
  {
    return (this.J) && (!this.H) && (!this.G);
  }
  
  public AoiLayer addAoiLayer(String paramString, AoiLayerOptions paramAoiLayerOptions, AoiLayer.OnAoiLayerLoadListener paramOnAoiLayerLoadListener)
  {
    AppMethodBeat.i(223602);
    if ((this.G) || (this.s == null))
    {
      AppMethodBeat.o(223602);
      return null;
    }
    oz localoz = this.s;
    Object localObject = localoz.a.iterator();
    ox localox;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localox = (ox)((Iterator)localObject).next();
    } while ((localox.getId() == null) || (!localox.getId().equals(paramString)));
    for (;;)
    {
      localObject = localox;
      if (localox == null)
      {
        localox = new ox(localoz, paramString, paramAoiLayerOptions, localoz);
        localoz.a.add(localox);
        localObject = localox;
        if (paramOnAoiLayerLoadListener != null)
        {
          localoz.d.put(paramString, paramOnAoiLayerLoadListener);
          localObject = localox;
        }
      }
      ((ox)localObject).a(paramAoiLayerOptions);
      n();
      AppMethodBeat.o(223602);
      return localObject;
      localox = null;
    }
  }
  
  public Arc addArc(ArcOptions paramArcOptions)
  {
    AppMethodBeat.i(223267);
    if ((this.G) || (this.o == null) || (paramArcOptions == null))
    {
      AppMethodBeat.o(223267);
      return null;
    }
    bh localbh = this.o.J;
    paramArcOptions = new om(paramArcOptions, localbh.f);
    ar localar = new ar(paramArcOptions);
    localbh.a.put(paramArcOptions.getId(), localar);
    localbh.c.add(localar);
    localbh.a(paramArcOptions);
    AppMethodBeat.o(223267);
    return localar;
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(223238);
    if ((this.G) || (paramCircleOptions == null) || (this.o == null))
    {
      AppMethodBeat.o(223238);
      return null;
    }
    paramCircleOptions = this.o.J.a(paramCircleOptions);
    AppMethodBeat.o(223238);
    return paramCircleOptions;
  }
  
  public CustomLayer addCustomLayer(CustomLayerOptions paramCustomLayerOptions)
  {
    AppMethodBeat.i(223206);
    super.addCustomLayer(paramCustomLayerOptions);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223206);
      return null;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(223206);
      return null;
    }
    paramCustomLayerOptions = localz.b.a(paramCustomLayerOptions);
    AppMethodBeat.o(223206);
    return paramCustomLayerOptions;
  }
  
  public GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    gj localgj = null;
    AppMethodBeat.i(223578);
    if ((this.G) || (this.o == null) || (paramGroundOverlayOptions == null))
    {
      AppMethodBeat.o(223578);
      return null;
    }
    mk localmk = this.o;
    if (localmk.g == null) {}
    for (paramGroundOverlayOptions = localgj;; paramGroundOverlayOptions = (GroundOverlay)localmk.k.a(new my(localmk.g.z(), paramGroundOverlayOptions)))
    {
      n();
      AppMethodBeat.o(223578);
      return paramGroundOverlayOptions;
      if (localmk.d != null)
      {
        localgj = localmk.d.n();
        localgj.a += 1;
      }
    }
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(223250);
    if ((this.G) || (this.o == null) || (paramMarkerOptions == null))
    {
      AppMethodBeat.o(223250);
      return null;
    }
    paramMarkerOptions = this.o.J.a(paramMarkerOptions);
    AppMethodBeat.o(223250);
    return paramMarkerOptions;
  }
  
  public void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    AppMethodBeat.i(222903);
    super.addOnMapLoadedCallback(paramOnMapLoadedCallback);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222903);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnMapLoadedCallback);
    }
    AppMethodBeat.o(222903);
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(223228);
    if ((this.G) || (this.o == null) || (paramPolygonOptions == null))
    {
      AppMethodBeat.o(223228);
      return null;
    }
    bh localbh = this.o.J;
    paramPolygonOptions = new or(localbh.f, paramPolygonOptions);
    aw localaw = new aw(paramPolygonOptions);
    localbh.a.put(paramPolygonOptions.getId(), localaw);
    localbh.d.add(localaw);
    localbh.a(paramPolygonOptions);
    AppMethodBeat.o(223228);
    return localaw;
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(223217);
    if ((this.G) || (this.o == null) || (paramPolylineOptions == null))
    {
      AppMethodBeat.o(223217);
      return null;
    }
    paramPolylineOptions = this.o.J.a(paramPolylineOptions);
    AppMethodBeat.o(223217);
    return paramPolylineOptions;
  }
  
  public void addTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(222965);
    super.addTencentMapGestureListener(paramTencentMapGestureListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222965);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramTencentMapGestureListener);
    }
    AppMethodBeat.o(222965);
  }
  
  public TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(223199);
    super.addTileOverlay(paramTileOverlayOptions);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223199);
      return null;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(223199);
      return null;
    }
    paramTileOverlayOptions = localz.b.a(paramTileOverlayOptions);
    AppMethodBeat.o(223199);
    return paramTileOverlayOptions;
  }
  
  public VectorHeatOverlay addVectorHeatOverlay(VectorHeatOverlayOptions paramVectorHeatOverlayOptions)
  {
    Object localObject = null;
    AppMethodBeat.i(223549);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223549);
      return null;
    }
    mk localmk = this.o;
    if (localmk.g == null) {}
    for (paramVectorHeatOverlayOptions = localObject;; paramVectorHeatOverlayOptions = (VectorHeatOverlay)localmk.k.a(new mr(paramVectorHeatOverlayOptions)))
    {
      n();
      AppMethodBeat.o(223549);
      return paramVectorHeatOverlayOptions;
      if (localmk.d != null) {
        localmk.d.h().a();
      }
    }
  }
  
  public <L extends VectorOverlay> L addVectorOverlay(VectorOverlayProvider paramVectorOverlayProvider)
  {
    AppMethodBeat.i(223557);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223557);
      return null;
    }
    paramVectorOverlayProvider = this.o.a(paramVectorOverlayProvider);
    n();
    AppMethodBeat.o(223557);
    return paramVectorOverlayProvider;
  }
  
  public VisualLayer addVisualLayer(VisualLayerOptions paramVisualLayerOptions)
  {
    AppMethodBeat.i(223586);
    dv localdv = (dv)getMapComponent(dv.class);
    if (localdv != null)
    {
      paramVisualLayerOptions = localdv.a(paramVisualLayerOptions);
      AppMethodBeat.o(223586);
      return paramVisualLayerOptions;
    }
    AppMethodBeat.o(223586);
    return null;
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(222590);
    if ((this.G) || (this.D == null) || (this.D.b()))
    {
      AppMethodBeat.o(222590);
      return;
    }
    this.D.a(paramCameraUpdate, 500L, null);
    AppMethodBeat.o(222590);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(222607);
    if ((this.G) || (this.D == null) || (this.D.b()))
    {
      AppMethodBeat.o(222607);
      return;
    }
    this.D.a(paramCameraUpdate, paramLong, paramCancelableCallback);
    AppMethodBeat.o(222607);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(222600);
    if ((this.G) || (this.D == null) || (this.D.b()))
    {
      AppMethodBeat.o(222600);
      return;
    }
    this.D.a(paramCameraUpdate, 500L, paramCancelableCallback);
    AppMethodBeat.o(222600);
  }
  
  public final void b()
  {
    AppMethodBeat.i(223619);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223619);
      return;
    }
    if (this.s != null) {
      this.L.a(this.s);
    }
    AppMethodBeat.o(223619);
  }
  
  public final void b(float paramFloat)
  {
    AppMethodBeat.i(222743);
    this.o.i.b(paramFloat);
    AppMethodBeat.o(222743);
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(223166);
    this.o.b(paramInt);
    AppMethodBeat.o(223166);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223171);
    this.o.i.a(paramInt1, paramInt2);
    AppMethodBeat.o(223171);
  }
  
  public final void b(fh paramfh)
  {
    AppMethodBeat.i(222725);
    this.o.i.b(paramfh);
    AppMethodBeat.o(222725);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(222746);
    this.o.a(paramBoolean);
    AppMethodBeat.o(222746);
  }
  
  public final void c()
  {
    AppMethodBeat.i(223627);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223627);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.j();
    }
    this.H = false;
    AppMethodBeat.o(223627);
  }
  
  public final void c(float paramFloat)
  {
    AppMethodBeat.i(223178);
    this.o.i.a(paramFloat);
    AppMethodBeat.o(223178);
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223319);
    this.o.b(paramInt1, paramInt2);
    AppMethodBeat.o(223319);
  }
  
  public CameraPosition calculateZoomToSpanLevel(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(222978);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222978);
      return null;
    }
    paramInt1 = Math.abs(paramInt1);
    paramInt2 = Math.abs(paramInt2);
    paramInt3 = Math.abs(paramInt3);
    paramInt4 = Math.abs(paramInt4);
    Object localObject = null;
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (IOverlay)paramList.next();
        if ((localObject instanceof eq)) {
          localArrayList.add((eq)localObject);
        }
      }
    }
    paramList = this.D;
    if (paramList.b == null)
    {
      AppMethodBeat.o(222978);
      return null;
    }
    paramList = paramList.b.a((List)localObject, paramList1, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(222978);
    return paramList;
  }
  
  public void clear()
  {
    AppMethodBeat.i(223284);
    super.clear();
    clearAllOverlays();
    AppMethodBeat.o(223284);
  }
  
  public void clearAllOverlays()
  {
    AppMethodBeat.i(223275);
    super.clearAllOverlays();
    if ((this.G) || (this.L == null))
    {
      AppMethodBeat.o(223275);
      return;
    }
    this.L.l();
    AppMethodBeat.o(223275);
  }
  
  public void clearCache()
  {
    AppMethodBeat.i(223292);
    super.clearCache();
    ka.f(mf.a(getMapContext().getContext(), null).c());
    AppMethodBeat.o(223292);
  }
  
  public void clearRouteNameSegments()
  {
    AppMethodBeat.i(222805);
    Object localObject = this.o;
    if (((mk)localObject).z == null) {
      ((mk)localObject).z = new mk.e((mk)localObject);
    }
    localObject = ((mk)localObject).z;
    mk.a(((mk.e)localObject).c).u();
    ((mk.e)localObject).a = null;
    ((mk.e)localObject).b = null;
    AppMethodBeat.o(222805);
  }
  
  public final void d()
  {
    AppMethodBeat.i(223634);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223634);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.n();
    }
    this.H = true;
    AppMethodBeat.o(223634);
  }
  
  public final void e()
  {
    if ((!this.G) && (this.D == null)) {}
  }
  
  public void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(223462);
    super.enableMultipleInfowindow(paramBoolean);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223462);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.f(paramBoolean);
    }
    AppMethodBeat.o(223462);
  }
  
  public final void f()
  {
    AppMethodBeat.i(223644);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223644);
      return;
    }
    if (this.s != null) {
      this.L.b(this.s);
    }
    AppMethodBeat.o(223644);
  }
  
  public final void g()
  {
    AppMethodBeat.i(223657);
    super.g();
    if (this.G)
    {
      AppMethodBeat.o(223657);
      return;
    }
    if (this.D != null)
    {
      localObject = this.D;
      if (((z)localObject).b != null) {
        ((z)localObject).b.m();
      }
    }
    if (this.A != null) {
      this.A.b();
    }
    if (this.s != null)
    {
      localObject = this.s;
      ((oz)localObject).c = null;
      ((oz)localObject).a.clear();
      ((oz)localObject).d.clear();
    }
    Object localObject = rg.a();
    if (((rg)localObject).j.decrementAndGet() == 0)
    {
      rg.a.clear();
      ((rg)localObject).d = false;
    }
    if (this.F != null)
    {
      localObject = this.F;
      if (((ad)localObject).a != null) {
        ((ad)localObject).a = null;
      }
      this.F = null;
    }
    if (this.E != null)
    {
      localObject = this.E;
      if (((ab)localObject).a != null) {
        ((ab)localObject).a = null;
      }
      this.E = null;
    }
    if (this.D != null)
    {
      localObject = this.D;
      if (((z)localObject).b != null) {
        ((z)localObject).b = null;
      }
      this.D = null;
    }
    if (this.C != null) {
      this.C = null;
    }
    if (this.B != null)
    {
      localObject = this.B;
      if (((ae)localObject).a != null) {
        ((ae)localObject).a = null;
      }
      this.B = null;
    }
    if (this.r != null)
    {
      localObject = this.r;
      ((bf)localObject).c();
      ((bf)localObject).a = null;
      this.r = null;
    }
    if (this.q != null)
    {
      localObject = this.q;
      if (((bg)localObject).b != null)
      {
        ((VectorMap)((bg)localObject).b.e_).b(((bg)localObject).k);
        sj localsj = ((bg)localObject).b;
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
        ((bg)localObject).b = null;
      }
      if (((bg)localObject).c != null) {
        ((bg)localObject).c = null;
      }
      if (gv.b != null) {
        gv.b.c();
      }
      this.q = null;
    }
    this.G = true;
    AppMethodBeat.o(223657);
  }
  
  public String getActivedIndoorBuilding(LatLng paramLatLng)
  {
    AppMethodBeat.i(223103);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223103);
      return null;
    }
    Object localObject = this.D;
    if (((z)localObject).b != null)
    {
      localObject = ((z)localObject).b.u();
      if (localObject != null)
      {
        if ((((IndoorBuilding)localObject).getBuildingLatLng() != null) && (paramLatLng != null))
        {
          paramLatLng.latitude = ((IndoorBuilding)localObject).getBuildingLatLng().latitude;
          paramLatLng.longitude = ((IndoorBuilding)localObject).getBuildingLatLng().longitude;
        }
        paramLatLng = ((IndoorBuilding)localObject).getBuildingName();
        AppMethodBeat.o(223103);
        return paramLatLng;
      }
    }
    AppMethodBeat.o(223103);
    return null;
  }
  
  public String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(223095);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223095);
      return null;
    }
    Object localObject = this.D;
    if (((z)localObject).b != null)
    {
      localObject = ((z)localObject).b.s();
      AppMethodBeat.o(223095);
      return localObject;
    }
    AppMethodBeat.o(223095);
    return null;
  }
  
  public List<LatLng> getBounderPoints(Marker paramMarker)
  {
    AppMethodBeat.i(223054);
    if ((paramMarker == null) || (this.o == null))
    {
      AppMethodBeat.o(223054);
      return null;
    }
    paramMarker = (av)this.o.J.a(paramMarker.getId(), av.class);
    if (paramMarker != null)
    {
      paramMarker = paramMarker.a.e();
      AppMethodBeat.o(223054);
      return paramMarker;
    }
    AppMethodBeat.o(223054);
    return null;
  }
  
  public CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(222542);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222542);
      return null;
    }
    CameraPosition localCameraPosition = this.D.a();
    AppMethodBeat.o(222542);
    return localCameraPosition;
  }
  
  public String getCityName(LatLng paramLatLng)
  {
    AppMethodBeat.i(222953);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222953);
      return "";
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(222953);
      return null;
    }
    paramLatLng = localz.b.a(paramLatLng);
    AppMethodBeat.o(222953);
    return paramLatLng;
  }
  
  public String getDebugError()
  {
    AppMethodBeat.i(223494);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223494);
      return null;
    }
    Object localObject = this.D;
    if (((z)localObject).b == null)
    {
      AppMethodBeat.o(223494);
      return null;
    }
    localObject = ((z)localObject).b.z();
    AppMethodBeat.o(223494);
    return localObject;
  }
  
  public int getIndoorFloorId()
  {
    AppMethodBeat.i(223090);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223090);
      return -1;
    }
    z localz = this.D;
    if (localz.b != null)
    {
      int i1 = localz.b.r();
      AppMethodBeat.o(223090);
      return i1;
    }
    AppMethodBeat.o(223090);
    return -1;
  }
  
  public MapLanguage getLanguage()
  {
    AppMethodBeat.i(223349);
    Object localObject = this.o.B();
    switch (3.a[localObject.ordinal()])
    {
    default: 
      localObject = MapLanguage.LAN_CHINESE;
      AppMethodBeat.o(223349);
      return localObject;
    }
    localObject = MapLanguage.LAN_ENGLISH;
    AppMethodBeat.o(223349);
    return localObject;
  }
  
  public TencentMapContext getMapContext()
  {
    return this.o;
  }
  
  public int getMapHeight()
  {
    AppMethodBeat.i(223479);
    int i1 = this.o.b.getMapRenderView().getHeight();
    AppMethodBeat.o(223479);
    return i1;
  }
  
  public Rect getMapPadding()
  {
    AppMethodBeat.i(223047);
    Rect localRect = this.o.i.b();
    AppMethodBeat.o(223047);
    return localRect;
  }
  
  protected TencentMapPro getMapPro()
  {
    return this.K;
  }
  
  public int getMapStyle()
  {
    AppMethodBeat.i(222636);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222636);
      return -1;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(222636);
      return -1;
    }
    int i1 = localz.b.f();
    AppMethodBeat.o(222636);
    return i1;
  }
  
  public int getMapType()
  {
    AppMethodBeat.i(223309);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223309);
      return 1000;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(223309);
      return 1000;
    }
    int i1 = localz.b.A();
    AppMethodBeat.o(223309);
    return i1;
  }
  
  public int getMapWidth()
  {
    AppMethodBeat.i(223472);
    int i1 = this.o.b.getMapRenderView().getWidth();
    AppMethodBeat.o(223472);
    return i1;
  }
  
  public float getMaxZoomLevel()
  {
    AppMethodBeat.i(222559);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222559);
      return 0.0F;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(222559);
      return -1.0F;
    }
    float f1 = localz.b.b();
    AppMethodBeat.o(222559);
    return f1;
  }
  
  public float getMinZoomLevel()
  {
    AppMethodBeat.i(222566);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222566);
      return 0.0F;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(222566);
      return -1.0F;
    }
    float f1 = localz.b.c();
    AppMethodBeat.o(222566);
    return f1;
  }
  
  public Location getMyLocation()
  {
    AppMethodBeat.i(222686);
    if (this.G)
    {
      AppMethodBeat.o(222686);
      return null;
    }
    ax();
    Object localObject = this.E;
    if (((ab)localObject).a != null)
    {
      localObject = ((ab)localObject).a.e();
      AppMethodBeat.o(222686);
      return localObject;
    }
    AppMethodBeat.o(222686);
    return null;
  }
  
  public UiSettings getUiSettings()
  {
    AppMethodBeat.i(222696);
    if (this.G)
    {
      AppMethodBeat.o(222696);
      return null;
    }
    if (this.I == null) {
      this.I = new sq(this.F);
    }
    UiSettings localUiSettings = this.I;
    AppMethodBeat.o(222696);
    return localUiSettings;
  }
  
  public String getVersion()
  {
    AppMethodBeat.i(222983);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222983);
      return "";
    }
    Object localObject = this.D;
    if (((z)localObject).b == null)
    {
      AppMethodBeat.o(222983);
      return "";
    }
    localObject = ((z)localObject).b.o();
    AppMethodBeat.o(222983);
    return localObject;
  }
  
  public float getZoomToSpanLevel(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(222551);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222551);
      return 0.0F;
    }
    if ((paramLatLng1 == null) || (paramLatLng2 == null))
    {
      AppMethodBeat.o(222551);
      return -1.0F;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(222551);
      return -1.0F;
    }
    float f1 = localz.b.a(paramLatLng1, paramLatLng2);
    AppMethodBeat.o(222551);
    return f1;
  }
  
  public boolean isBlockRouteEnabled()
  {
    return false;
  }
  
  public boolean isDestroyed()
  {
    return this.G;
  }
  
  public boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(223451);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223451);
      return false;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(223451);
      return false;
    }
    boolean bool = localz.b.w();
    AppMethodBeat.o(223451);
    return bool;
  }
  
  public boolean isMyLocationEnabled()
  {
    AppMethodBeat.i(222673);
    if (this.G)
    {
      AppMethodBeat.o(222673);
      return false;
    }
    ax();
    ab localab = this.E;
    if (localab.a != null)
    {
      boolean bool = localab.a.d();
      AppMethodBeat.o(222673);
      return bool;
    }
    AppMethodBeat.o(222673);
    return false;
  }
  
  public boolean isSateLiteEnable()
  {
    AppMethodBeat.i(222665);
    if (getMapType() == 1011)
    {
      AppMethodBeat.o(222665);
      return true;
    }
    AppMethodBeat.o(222665);
    return false;
  }
  
  public boolean isTrafficEnabled()
  {
    AppMethodBeat.i(222641);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222641);
      return false;
    }
    z localz = this.D;
    if (localz.b == null)
    {
      AppMethodBeat.o(222641);
      return false;
    }
    boolean bool = localz.b.h();
    AppMethodBeat.o(222641);
    return bool;
  }
  
  public void loadKMLFile(String paramString)
  {
    AppMethodBeat.i(223328);
    super.loadKMLFile(paramString);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223328);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramString);
    }
    AppMethodBeat.o(223328);
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(222582);
    if ((this.G) || (this.D == null) || (this.D.b()))
    {
      AppMethodBeat.o(222582);
      return;
    }
    this.D.a(paramCameraUpdate);
    AppMethodBeat.o(222582);
  }
  
  public final void n()
  {
    this.o.v = true;
  }
  
  public final int o()
  {
    return this.o.t.b.n;
  }
  
  public final int p()
  {
    return this.o.t.b.o;
  }
  
  public final GeoPoint q()
  {
    return this.o.i.A.m;
  }
  
  public final int r()
  {
    return this.o.i.A.b.q;
  }
  
  public void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    AppMethodBeat.i(222915);
    super.removeOnMapLoadedCallback(paramOnMapLoadedCallback);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222915);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.b(paramOnMapLoadedCallback);
    }
    AppMethodBeat.o(222915);
  }
  
  public void removeTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(222973);
    super.removeTencentMapGestureListener(paramTencentMapGestureListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222973);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.b(paramTencentMapGestureListener);
    }
    AppMethodBeat.o(222973);
  }
  
  public final float s()
  {
    return this.o.i.A.b.p;
  }
  
  public void setBaseMapEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223608);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223608);
      return;
    }
    this.o.h(paramBoolean);
    AppMethodBeat.o(223608);
  }
  
  public void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(223010);
    super.setBuilding3dEffectEnable(paramBoolean);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223010);
      return;
    }
    this.o.c(paramBoolean);
    AppMethodBeat.o(223010);
  }
  
  public void setBuildingEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(222997);
    super.setBuildingEnable(paramBoolean);
    setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(222997);
  }
  
  public void setCameraCenterProportion(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(223115);
    super.setCameraCenterProportion(paramFloat1, paramFloat2);
    setCameraCenterProportion(paramFloat1, paramFloat2, true);
    AppMethodBeat.o(223115);
  }
  
  public void setCameraCenterProportion(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(223120);
    super.setCameraCenterProportion(paramFloat1, paramFloat2, paramBoolean);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223120);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramFloat1, paramFloat2, paramBoolean);
    }
    AppMethodBeat.o(223120);
  }
  
  public void setCustomRender(CustomRender paramCustomRender)
  {
    AppMethodBeat.i(223539);
    super.setCustomRender(paramCustomRender);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223539);
      return;
    }
    mk localmk = this.o;
    localmk.F = paramCustomRender;
    localmk.v = true;
    AppMethodBeat.o(223539);
  }
  
  public void setDrawPillarWith2DStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(223337);
    super.setDrawPillarWith2DStyle(paramBoolean);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223337);
      return;
    }
    mk localmk = this.o;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localmk.c(paramBoolean);
      AppMethodBeat.o(223337);
      return;
    }
  }
  
  public void setForeignLanguage(Language paramLanguage)
  {
    AppMethodBeat.i(223487);
    super.setForeignLanguage(paramLanguage);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223487);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.b(paramLanguage);
    }
    AppMethodBeat.o(223487);
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(223441);
    super.setHandDrawMapEnable(paramBoolean);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223441);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.e(paramBoolean);
    }
    AppMethodBeat.o(223441);
  }
  
  public void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223066);
    super.setIndoorEnabled(paramBoolean);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223066);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.c(paramBoolean);
    }
    AppMethodBeat.o(223066);
  }
  
  public void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(223078);
    super.setIndoorFloor(paramInt);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223078);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.c(paramInt);
    }
    AppMethodBeat.o(223078);
  }
  
  public void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223083);
    super.setIndoorFloor(paramString1, paramString2);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223083);
      return;
    }
    z localz = this.D;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(223083);
      return;
    }
    localz.b.a(paramString1, paramString2);
    AppMethodBeat.o(223083);
  }
  
  public void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(223157);
    super.setIndoorMaskColor(paramInt);
    sc localsc = this.o.g;
    if (0L != localsc.e) {
      localsc.a(new sc.141(localsc, paramInt));
    }
    AppMethodBeat.o(223157);
  }
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(223380);
    super.setInfoWindowAdapter(paramInfoWindowAdapter);
    if ((this.G) || (this.L == null))
    {
      AppMethodBeat.o(223380);
      return;
    }
    this.L.aI = paramInfoWindowAdapter;
    AppMethodBeat.o(223380);
  }
  
  public void setLocationSource(LocationSource paramLocationSource)
  {
    AppMethodBeat.i(222690);
    super.setLocationSource(paramLocationSource);
    if (this.G)
    {
      AppMethodBeat.o(222690);
      return;
    }
    ax();
    ab localab = this.E;
    if (localab.a != null) {
      localab.a.a(paramLocationSource);
    }
    AppMethodBeat.o(222690);
  }
  
  public void setMapCenterAndScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(223018);
    super.setMapCenterAndScale(paramFloat1, paramFloat2, paramFloat3);
    if ((this.G) || (this.q == null))
    {
      AppMethodBeat.o(223018);
      return;
    }
    sj localsj = this.q.b;
    float f2;
    if (localsj.aB != null)
    {
      float f1 = localsj.aB.i.A.b.p;
      f2 = sr.b(paramFloat3);
      if (Math.abs(f1 - f2) <= 0.0001D) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      localsj.aD = 0;
      jw.a(new sr.1(localsj, (paramFloat2 - localsj.aC) / 10.0F, paramFloat1, paramFloat2, paramFloat3, bool, f2));
      AppMethodBeat.o(223018);
      return;
    }
  }
  
  public void setMapFontSize(MapFontSize paramMapFontSize)
  {
    AppMethodBeat.i(222817);
    if ((this.G) || (this.D == null) || (paramMapFontSize == null))
    {
      AppMethodBeat.o(222817);
      return;
    }
    mk localmk = this.o;
    int i1 = paramMapFontSize.getValue();
    paramMapFontSize = localmk.g;
    paramMapFontSize.a(new sc.54(paramMapFontSize, i1));
    AppMethodBeat.o(222817);
  }
  
  public void setMapFrameRate(float paramFloat)
  {
    AppMethodBeat.i(223665);
    super.setMapFrameRate(paramFloat);
    if (this.L != null)
    {
      sr localsr = this.L;
      if (localsr.c != null) {
        localsr.c.a(paramFloat);
      }
    }
    AppMethodBeat.o(223665);
  }
  
  public void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(222706);
    super.setMapStyle(paramInt);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222706);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramInt);
    }
    AppMethodBeat.o(222706);
  }
  
  public void setMapType(int paramInt)
  {
    AppMethodBeat.i(223300);
    super.setMapType(paramInt);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223300);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.f(paramInt);
    }
    AppMethodBeat.o(223300);
  }
  
  public void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(223131);
    super.setMaxZoomLevel(paramInt);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223131);
      return;
    }
    paramInt = l(paramInt);
    z localz = this.D;
    if (localz.b != null) {
      localz.b.d(paramInt);
    }
    if (this.D.a().zoom > paramInt) {
      animateCamera(CameraUpdateFactory.zoomTo(paramInt));
    }
    AppMethodBeat.o(223131);
  }
  
  public void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(223149);
    super.setMinZoomLevel(paramInt);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223149);
      return;
    }
    paramInt = l(paramInt);
    z localz = this.D;
    if (localz.b != null) {
      localz.b.e(paramInt);
    }
    if (this.D.a().zoom < paramInt) {
      animateCamera(CameraUpdateFactory.zoomTo(paramInt));
    }
    AppMethodBeat.o(223149);
  }
  
  public void setMyLocationClickListener(TencentMap.OnMyLocationClickListener paramOnMyLocationClickListener)
  {
    AppMethodBeat.i(222875);
    super.setMyLocationClickListener(paramOnMyLocationClickListener);
    if (this.G)
    {
      AppMethodBeat.o(222875);
      return;
    }
    if (this.r == null) {
      ax();
    }
    this.r.i = paramOnMyLocationClickListener;
    AppMethodBeat.o(222875);
  }
  
  public void setMyLocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(222679);
    super.setMyLocationEnabled(paramBoolean);
    if (this.G)
    {
      AppMethodBeat.o(222679);
      return;
    }
    ax();
    if (!paramBoolean)
    {
      localab = this.E;
      if (localab.a != null) {
        localab.a.c();
      }
      AppMethodBeat.o(222679);
      return;
    }
    if (isMyLocationEnabled())
    {
      AppMethodBeat.o(222679);
      return;
    }
    ab localab = this.E;
    if (localab.a != null) {
      localab.a.b();
    }
    AppMethodBeat.o(222679);
  }
  
  public void setMyLocationStyle(MyLocationStyle paramMyLocationStyle)
  {
    AppMethodBeat.i(223390);
    super.setMyLocationStyle(paramMyLocationStyle);
    if (this.E == null) {
      ax();
    }
    ab localab = this.E;
    if (localab.a != null) {
      localab.a.a(paramMyLocationStyle);
    }
    AppMethodBeat.o(223390);
  }
  
  public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    AppMethodBeat.i(222833);
    super.setOnCameraChangeListener(paramOnCameraChangeListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222833);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnCameraChangeListener);
    }
    AppMethodBeat.o(222833);
  }
  
  public void setOnCompassClickedListener(TencentMap.OnCompassClickedListener paramOnCompassClickedListener)
  {
    AppMethodBeat.i(222895);
    super.setOnCompassClickedListener(paramOnCompassClickedListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222895);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnCompassClickedListener);
    }
    AppMethodBeat.o(222895);
  }
  
  public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(223402);
    super.setOnIndoorStateChangeListener(paramOnIndoorStateChangeListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223402);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnIndoorStateChangeListener);
    }
    AppMethodBeat.o(223402);
  }
  
  public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(223370);
    super.setOnInfoWindowClickListener(paramOnInfoWindowClickListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223370);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnInfoWindowClickListener);
    }
    AppMethodBeat.o(223370);
  }
  
  public void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(222845);
    super.setOnMapClickListener(paramOnMapClickListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222845);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnMapClickListener);
    }
    AppMethodBeat.o(222845);
  }
  
  public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(222854);
    super.setOnMapLongClickListener(paramOnMapLongClickListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222854);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnMapLongClickListener);
    }
    AppMethodBeat.o(222854);
  }
  
  public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(223109);
    super.setOnMapPoiClickListener(paramOnMapPoiClickListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223109);
      return;
    }
    if (this.s != null) {
      this.s.c = paramOnMapPoiClickListener;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnMapPoiClickListener);
    }
    AppMethodBeat.o(223109);
  }
  
  public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(223357);
    super.setOnMarkerClickListener(paramOnMarkerClickListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223357);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnMarkerClickListener);
    }
    AppMethodBeat.o(223357);
  }
  
  public void setOnMarkerDragListener(TencentMap.OnMarkerDragListener paramOnMarkerDragListener)
  {
    AppMethodBeat.i(223364);
    super.setOnMarkerDragListener(paramOnMarkerDragListener);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223364);
      return;
    }
    this.o.k.c = paramOnMarkerDragListener;
    AppMethodBeat.o(223364);
  }
  
  public void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
    AppMethodBeat.i(222884);
    super.setOnMyLocationChangeListener(paramOnMyLocationChangeListener);
    if (this.G)
    {
      AppMethodBeat.o(222884);
      return;
    }
    if (this.r == null) {
      ax();
    }
    this.r.c = paramOnMyLocationChangeListener;
    AppMethodBeat.o(222884);
  }
  
  public void setOnPolygonClickListener(TencentMap.OnPolygonClickListener paramOnPolygonClickListener)
  {
    AppMethodBeat.i(222869);
    super.setOnPolygonClickListener(paramOnPolygonClickListener);
    if ((this.G) || (this.L == null))
    {
      AppMethodBeat.o(222869);
      return;
    }
    this.L.a(paramOnPolygonClickListener);
    AppMethodBeat.o(222869);
  }
  
  public void setOnPolylineClickListener(TencentMap.OnPolylineClickListener paramOnPolylineClickListener)
  {
    AppMethodBeat.i(222862);
    super.setOnPolylineClickListener(paramOnPolylineClickListener);
    if ((this.G) || (this.L == null))
    {
      AppMethodBeat.o(222862);
      return;
    }
    this.L.a(paramOnPolylineClickListener);
    AppMethodBeat.o(222862);
  }
  
  public void setOnTapMapViewInfoWindowHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(222575);
    super.setOnTapMapViewInfoWindowHidden(paramBoolean);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222575);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.g(paramBoolean);
    }
    AppMethodBeat.o(222575);
  }
  
  public void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener paramOnTrafficEventClickListener)
  {
    AppMethodBeat.i(223525);
    super.setOnTrafficEventClickListener(paramOnTrafficEventClickListener);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223525);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramOnTrafficEventClickListener);
    }
    AppMethodBeat.o(223525);
  }
  
  public void setOverSeaEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(223671);
    super.setOverSeaEnable(paramBoolean);
    if (this.L != null) {
      this.L.m(paramBoolean);
    }
    AppMethodBeat.o(223671);
  }
  
  public void setOverSeaTileProvider(OverSeaTileProvider paramOverSeaTileProvider)
  {
    AppMethodBeat.i(223592);
    super.setOverSeaTileProvider(paramOverSeaTileProvider);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223592);
      return;
    }
    mk localmk = this.o;
    if (localmk.m != null) {
      localmk.m.a(paramOverSeaTileProvider);
    }
    AppMethodBeat.o(223592);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(223026);
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.q != null) {
      this.q.a(paramInt1, paramInt2, paramInt3, paramInt4, false);
    }
    AppMethodBeat.o(223026);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(223033);
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    if (this.q != null) {
      this.q.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
    AppMethodBeat.o(223033);
  }
  
  public void setPointToCenter(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223124);
    super.setPointToCenter(paramInt1, paramInt2);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223124);
      return;
    }
    ep localep = v();
    if (localep != null) {
      this.D.a(CameraUpdateFactory.newLatLng(localep.fromScreenLocation(new Point(paramInt1, paramInt2))));
    }
    AppMethodBeat.o(223124);
  }
  
  public void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223504);
    super.setPoisEnabled(paramBoolean);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223504);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.i(paramBoolean);
    }
    AppMethodBeat.o(223504);
  }
  
  public void setRestrictBounds(LatLngBounds paramLatLngBounds, RestrictBoundsFitMode paramRestrictBoundsFitMode)
  {
    AppMethodBeat.i(223513);
    super.setRestrictBounds(paramLatLngBounds, paramRestrictBoundsFitMode);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(223513);
      return;
    }
    z localz = this.D;
    if (paramRestrictBoundsFitMode == null) {}
    for (int i1 = 0;; i1 = paramRestrictBoundsFitMode.ordinal())
    {
      if (localz.b != null) {
        localz.b.a(paramLatLngBounds, i1);
      }
      AppMethodBeat.o(223513);
      return;
    }
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(222659);
    super.setSatelliteEnabled(paramBoolean);
    if (paramBoolean)
    {
      setMapType(1011);
      AppMethodBeat.o(222659);
      return;
    }
    setMapType(1000);
    AppMethodBeat.o(222659);
  }
  
  public void setTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(222958);
    super.setTencentMapGestureListener(paramTencentMapGestureListener);
    addTencentMapGestureListener(paramTencentMapGestureListener);
    AppMethodBeat.o(222958);
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(222650);
    super.setTrafficEnabled(paramBoolean);
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222650);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.a(paramBoolean);
    }
    AppMethodBeat.o(222650);
  }
  
  public void showBuilding(boolean paramBoolean)
  {
    AppMethodBeat.i(223007);
    super.showBuilding(paramBoolean);
    Object localObject = this.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      ((sc)localObject).a(new sc.36((sc)localObject, paramBoolean));
    }
    AppMethodBeat.o(223007);
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    AppMethodBeat.i(222938);
    super.snapshot(paramSnapshotReadyCallback);
    snapshot(paramSnapshotReadyCallback, Bitmap.Config.ARGB_8888);
    AppMethodBeat.o(222938);
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(222929);
    super.snapshot(paramSnapshotReadyCallback, paramConfig);
    snapshot(paramSnapshotReadyCallback, paramConfig, 0);
    AppMethodBeat.o(222929);
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig, int paramInt)
  {
    AppMethodBeat.i(222922);
    super.snapshot(paramSnapshotReadyCallback, paramConfig, paramInt);
    if (this.D != null)
    {
      z localz = this.D;
      if ((localz.b == null) || (paramSnapshotReadyCallback == null))
      {
        AppMethodBeat.o(222922);
        return;
      }
      localz.c = paramSnapshotReadyCallback;
      paramSnapshotReadyCallback = localz.d;
      if (localz.b != null) {
        localz.b.a(paramSnapshotReadyCallback, paramConfig, paramInt);
      }
    }
    AppMethodBeat.o(222922);
  }
  
  public void stopAnimation()
  {
    AppMethodBeat.i(222614);
    super.stopAnimation();
    if ((this.G) || (this.D == null))
    {
      AppMethodBeat.o(222614);
      return;
    }
    z localz = this.D;
    if (localz.b != null) {
      localz.b.d();
    }
    AppMethodBeat.o(222614);
  }
  
  public final float t()
  {
    AppMethodBeat.i(222788);
    float f1 = this.o.i.h();
    AppMethodBeat.o(222788);
    return f1;
  }
  
  public final float u()
  {
    AppMethodBeat.i(222796);
    float f1 = this.o.i.i();
    AppMethodBeat.o(222796);
    return f1;
  }
  
  public void updateVectorOverlay(VectorOverlay paramVectorOverlay, VectorOverlayProvider paramVectorOverlayProvider)
  {
    AppMethodBeat.i(223570);
    if ((this.G) || (this.o == null))
    {
      AppMethodBeat.o(223570);
      return;
    }
    mk localmk = this.o;
    if (localmk.g != null)
    {
      if (!(paramVectorOverlayProvider instanceof AggregationOverlayProvider)) {
        break label108;
      }
      paramVectorOverlay = (mq)paramVectorOverlay;
      paramVectorOverlay = (mq)localmk.k.a(mq.class, paramVectorOverlay.c());
      if (paramVectorOverlay == null) {
        break label99;
      }
      paramVectorOverlay.a(new mr((AggregationOverlayProvider)paramVectorOverlayProvider));
    }
    for (;;)
    {
      n();
      AppMethodBeat.o(223570);
      return;
      label99:
      localmk.a(paramVectorOverlayProvider);
      continue;
      label108:
      if ((paramVectorOverlayProvider instanceof GradientVectorOverlayProvider))
      {
        paramVectorOverlay = (mz)paramVectorOverlay;
        paramVectorOverlay = (mz)localmk.k.a(mz.class, paramVectorOverlay.c());
        if (paramVectorOverlay != null) {
          paramVectorOverlay.a(new nb((GradientVectorOverlayProvider)paramVectorOverlayProvider));
        } else {
          localmk.a(paramVectorOverlayProvider);
        }
      }
      else if ((paramVectorOverlayProvider instanceof ArcLineOverlayProvider))
      {
        paramVectorOverlay = (mt)paramVectorOverlay;
        paramVectorOverlay = (mt)localmk.k.a(mt.class, paramVectorOverlay.c());
        if (paramVectorOverlay != null) {
          paramVectorOverlay.a(new mv((ArcLineOverlayProvider)paramVectorOverlayProvider));
        } else {
          localmk.a(paramVectorOverlayProvider);
        }
      }
      else if ((paramVectorOverlayProvider instanceof DotScatterPlotOverlayProvider))
      {
        paramVectorOverlay = (ni)paramVectorOverlay;
        paramVectorOverlay = (ni)localmk.k.a(ni.class, paramVectorOverlay.c());
        if (paramVectorOverlay != null) {
          paramVectorOverlay.a(new nk(localmk.g.z(), (DotScatterPlotOverlayProvider)paramVectorOverlayProvider));
        } else {
          localmk.a(paramVectorOverlayProvider);
        }
      }
      else if ((paramVectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider))
      {
        paramVectorOverlay = (ni)paramVectorOverlay;
        paramVectorOverlay = (ni)localmk.k.a(ni.class, paramVectorOverlay.c());
        if (paramVectorOverlay != null) {
          paramVectorOverlay.a(new nk(localmk.g.z(), (BitmapScatterPlotOverlayProvider)paramVectorOverlayProvider));
        } else {
          localmk.a(paramVectorOverlayProvider);
        }
      }
      else if ((paramVectorOverlayProvider instanceof TrailOverlayProvider))
      {
        paramVectorOverlay = (nl)paramVectorOverlay;
        paramVectorOverlay = (nl)localmk.k.a(nl.class, paramVectorOverlay.c());
        if (paramVectorOverlay != null) {
          paramVectorOverlay.a(new nn((TrailOverlayProvider)paramVectorOverlayProvider));
        } else {
          localmk.a(paramVectorOverlayProvider);
        }
      }
    }
  }
  
  public final ep v()
  {
    if ((this.G) || (this.o == null)) {
      return null;
    }
    return this.o.n;
  }
  
  public final void w()
  {
    AppMethodBeat.i(223041);
    this.o.i.o.e();
    AppMethodBeat.o(223041);
  }
  
  public final String x()
  {
    AppMethodBeat.i(223614);
    String str = null;
    if (this.o != null) {
      str = this.o.w();
    }
    AppMethodBeat.o(223614);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.vector.VectorMap
 * JD-Core Version:    0.7.0.1
 */