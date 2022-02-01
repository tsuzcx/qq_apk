package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.SubMarkerInfo;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider;
import com.tencent.mapsdk.engine.jni.JNI;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.io.File;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;

public final class mk
  extends bq
  implements bd, ff
{
  private static final int K = 50;
  private static final int L = 6;
  private static final int N = 100;
  private static final int O = 100;
  private static final float P = 2.0F;
  public qw A;
  public boolean B;
  public Rect C;
  public int D;
  public int E;
  public CustomRender F;
  public oe G;
  public qe H;
  public List<oc> I;
  public bh J;
  private final int M;
  private final LinkedBlockingQueue<a> Q;
  private nt R;
  private ku<Integer, Integer> S;
  private boolean T;
  private boolean U;
  private int V;
  private int W;
  private float X;
  private float Y;
  private boolean Z;
  private mk.d aa;
  private Rect ab;
  private boolean ac;
  private int ad;
  private String ae;
  public sc g;
  public lv h;
  public ac i;
  public qs j;
  public bi k;
  public mj l;
  public az m;
  public ep n;
  public Rect o;
  public boolean p;
  public boolean q;
  public w r;
  public f s;
  public v t;
  public no u;
  public volatile boolean v;
  public boolean w;
  public np x;
  public c y;
  public e z;
  
  public mk(Context paramContext, TencentMapOptions paramTencentMapOptions, bn parambn)
  {
    super(paramContext, paramTencentMapOptions, parambn);
    AppMethodBeat.i(223059);
    this.v = false;
    this.w = true;
    this.T = true;
    this.B = true;
    this.U = false;
    this.V = 0;
    this.W = 0;
    this.X = 0.5F;
    this.Y = 0.5F;
    this.Z = true;
    this.D = 18;
    this.E = 14;
    this.m = ((az)parambn);
    this.J = new bh(this.m, this);
    this.g = new sc(paramContext, this);
    this.t = new v(this);
    this.o = new Rect();
    this.k = new bi(this.J, this);
    this.m.a(this.k);
    this.H = new qe(getContext(), this);
    this.n = new x(this);
    this.i = new ac(this);
    this.g.f = this.i;
    this.h = new lv();
    this.l = new mj(this, this.g);
    this.s = new f((byte)0);
    this.Q = new LinkedBlockingQueue();
    this.I = new CopyOnWriteArrayList();
    if (getContext() != null) {}
    for (this.M = ((int)(getContext().getResources().getDisplayMetrics().density * 6.0F + 0.5D));; this.M = 6)
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      int i1 = paramContext.getDefaultDisplay().getWidth();
      int i2 = paramContext.getDefaultDisplay().getHeight();
      if (this.o != null) {
        this.o.set(0, 0, i1, i2);
      }
      AppMethodBeat.o(223059);
      return;
    }
  }
  
  private sc F()
  {
    return this.g;
  }
  
  private boolean G()
  {
    AppMethodBeat.i(223080);
    if (this.g == null)
    {
      AppMethodBeat.o(223080);
      return false;
    }
    sc localsc = this.g;
    if (localsc.e == 0L)
    {
      AppMethodBeat.o(223080);
      return false;
    }
    if (System.currentTimeMillis() - localsc.k > 560L)
    {
      localsc.d.nativeClearDownloadURLCache(localsc.e);
      localsc.k = System.currentTimeMillis();
    }
    boolean bool = localsc.d.nativeGenerateTextures(localsc.e);
    AppMethodBeat.o(223080);
    return bool;
  }
  
  private lc H()
  {
    AppMethodBeat.i(223088);
    lc locallc = this.u.d();
    AppMethodBeat.o(223088);
    return locallc;
  }
  
  private lv I()
  {
    return this.h;
  }
  
  private void J()
  {
    AppMethodBeat.i(223112);
    if (this.g == null)
    {
      AppMethodBeat.o(223112);
      return;
    }
    this.v = true;
    this.B = true;
    if (this.w)
    {
      ??? = this.i.o;
      if (((y)???).d != null) {
        ((y)???).d.destroy();
      }
      ((y)???).d = new y.a((y)???);
      ((y)???).d.start();
      this.w = false;
    }
    for (;;)
    {
      if (this.m != null) {
        this.m.getMapRenderView().d();
      }
      if (this.p) {
        this.g.k();
      }
      if ((this.q) && (this.j != null)) {
        this.j.b();
      }
      qw localqw;
      if (this.A != null)
      {
        localqw = this.A;
        localqw.g = false;
      }
      synchronized (localqw.j)
      {
        localqw.j.notifyAll();
        AppMethodBeat.o(223112);
        return;
        ??? = this.i;
        if (((ac)???).o != null) {
          ((ac)???).o.b();
        }
      }
    }
  }
  
  private void K()
  {
    AppMethodBeat.i(223123);
    if (this.g == null)
    {
      AppMethodBeat.o(223123);
      return;
    }
    this.v = false;
    this.B = false;
    if (this.A != null) {
      this.A.g = true;
    }
    ac localac = this.i;
    if (localac.o != null) {
      localac.o.a();
    }
    this.g.l();
    if ((this.q) && (this.j != null)) {
      this.j.a();
    }
    AppMethodBeat.o(223123);
  }
  
  private void L()
  {
    AppMethodBeat.i(223130);
    if ((this.q) && (this.j != null)) {
      this.j.a();
    }
    AppMethodBeat.o(223130);
  }
  
  private void M()
  {
    AppMethodBeat.i(223141);
    if ((this.q) && (this.j != null)) {
      this.j.b();
    }
    AppMethodBeat.o(223141);
  }
  
  private void N()
  {
    AppMethodBeat.i(223165);
    if (this.g == null)
    {
      AppMethodBeat.o(223165);
      return;
    }
    a(new a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222741);
        if (mk.a(mk.this) != null) {
          mk.b(mk.this).a(paramAnonymousGL10);
        }
        AppMethodBeat.o(222741);
      }
    });
    AppMethodBeat.o(223165);
  }
  
  private w O()
  {
    return this.r;
  }
  
  private void P()
  {
    AppMethodBeat.i(223203);
    if (this.g == null)
    {
      AppMethodBeat.o(223203);
      return;
    }
    if (this.h != null) {
      this.h.a();
    }
    AppMethodBeat.o(223203);
  }
  
  private Rect Q()
  {
    return this.C;
  }
  
  private void R()
  {
    this.v = true;
  }
  
  private int S()
  {
    AppMethodBeat.i(223315);
    if (this.g != null)
    {
      int i1 = this.g.e();
      AppMethodBeat.o(223315);
      return i1;
    }
    AppMethodBeat.o(223315);
    return -1;
  }
  
  private void T()
  {
    AppMethodBeat.i(223331);
    if (this.g != null) {
      this.g.d();
    }
    AppMethodBeat.o(223331);
  }
  
  private void U()
  {
    AppMethodBeat.i(223345);
    if (this.g != null) {
      this.g.f();
    }
    AppMethodBeat.o(223345);
  }
  
  private boolean V()
  {
    return this.q;
  }
  
  private void W()
  {
    AppMethodBeat.i(223543);
    if (this.z == null) {
      this.z = new e();
    }
    e locale = this.z;
    locale.c.g.u();
    locale.a = null;
    locale.b = null;
    AppMethodBeat.o(223543);
  }
  
  private boolean X()
  {
    AppMethodBeat.i(223650);
    if (this.g == null)
    {
      AppMethodBeat.o(223650);
      return false;
    }
    sc localsc = this.g;
    if (((Integer)localsc.a(new sc.137(localsc, A()), Integer.valueOf(0))).intValue() == 1)
    {
      AppMethodBeat.o(223650);
      return true;
    }
    AppMethodBeat.o(223650);
    return false;
  }
  
  private String[] Y()
  {
    AppMethodBeat.i(223676);
    Object localObject2 = this.i.q();
    Object localObject1 = new Point(((Rect)localObject2).centerX(), ((Rect)localObject2).centerY());
    Point localPoint1 = new Point(((Rect)localObject2).left, ((Rect)localObject2).top);
    Point localPoint2 = new Point(((Rect)localObject2).left, ((Rect)localObject2).bottom);
    Point localPoint3 = new Point(((Rect)localObject2).right, ((Rect)localObject2).top);
    localObject2 = new Point(((Rect)localObject2).right, ((Rect)localObject2).bottom);
    HashSet localHashSet = new HashSet();
    int i1 = 0;
    while (i1 < 5)
    {
      Object localObject3 = new Point[] { localObject1, localPoint1, localPoint2, localPoint3, localObject2 }[i1];
      localObject3 = a(new GeoPoint(((Point)localObject3).y, ((Point)localObject3).x));
      if (!gz.a((String)localObject3)) {
        localHashSet.add(localObject3);
      }
      i1 += 1;
    }
    localObject1 = (String[])localHashSet.toArray(new String[0]);
    AppMethodBeat.o(223676);
    return localObject1;
  }
  
  private void Z()
  {
    AppMethodBeat.i(223700);
    if (this.g != null)
    {
      this.g.k();
      this.p = true;
    }
    AppMethodBeat.o(223700);
  }
  
  private float a(double paramDouble, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224401);
    if ((paramGeoPoint == null) || (this.t == null) || (this.n == null))
    {
      AppMethodBeat.o(224401);
      return 0.0F;
    }
    double d = this.n.metersPerPixel(paramGeoPoint.getLatitudeE6() / 1000000.0D);
    if (d != 0.0D)
    {
      float f = (float)(paramDouble / d);
      AppMethodBeat.o(224401);
      return f;
    }
    AppMethodBeat.o(224401);
    return 0.0F;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    int i2 = 255;
    AppMethodBeat.i(223490);
    if (this.g == null)
    {
      AppMethodBeat.o(223490);
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
                    if (this.o != null)
                    {
                      localMaskLayer.width = this.o.width();
                      localMaskLayer.height = this.o.height();
                    }
                    localMaskLayer.zIndex = paramFloat;
                    localMaskLayer.layer = paramInt5;
                    sc localsc = this.g;
                    paramInt1 = ((Integer)localsc.a(new sc.84(localsc, localMaskLayer), Integer.valueOf(0))).intValue();
                    AppMethodBeat.o(223490);
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
  
  @Deprecated
  private int a(TileOverlayCallback paramTileOverlayCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(224111);
    if (this.g != null)
    {
      int i1 = this.g.a(paramTileOverlayCallback, paramBoolean);
      AppMethodBeat.o(224111);
      return i1;
    }
    AppMethodBeat.o(224111);
    return -1;
  }
  
  private AnnocationTextResult a(AnnocationText paramAnnocationText)
  {
    AppMethodBeat.i(223558);
    sc localsc = this.g;
    paramAnnocationText = (AnnocationTextResult)localsc.a(new sc.22(localsc, paramAnnocationText), null);
    AppMethodBeat.o(223558);
    return paramAnnocationText;
  }
  
  public static nh a(fn paramfn)
  {
    AppMethodBeat.i(223610);
    nh localnh = new nh(paramfn.u, paramfn.b);
    if (!TextUtils.isEmpty(paramfn.h))
    {
      SubMarkerInfo localSubMarkerInfo = new SubMarkerInfo();
      localSubMarkerInfo.iconName(paramfn.h);
      localSubMarkerInfo.iconWidth(paramfn.i);
      localSubMarkerInfo.iconHeight(paramfn.j);
      localSubMarkerInfo.avoidAnnotation(true);
      localSubMarkerInfo.avoidOtherMarker(true);
      localnh.subMarkerInfo(localSubMarkerInfo);
    }
    localnh.iconWidth(paramfn.c);
    localnh.iconHeight(paramfn.d);
    localnh.avoidAnnotation(true);
    localnh.avoidOtherMarker(true);
    localnh.scale(paramfn.g, paramfn.g);
    localnh.priority(paramfn.r);
    localnh.displayLevel(2);
    localnh.minScaleLevel(paramfn.s);
    localnh.maxScaleLevel(paramfn.t);
    AppMethodBeat.o(223610);
    return localnh;
  }
  
  private Circle a(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(223458);
    if (this.J == null)
    {
      AppMethodBeat.o(223458);
      return null;
    }
    paramCircleOptions = this.J.a(paramCircleOptions);
    AppMethodBeat.o(223458);
    return paramCircleOptions;
  }
  
  private GroundOverlay a(GroundOverlayOptions paramGroundOverlayOptions)
  {
    AppMethodBeat.i(224501);
    if (this.g == null)
    {
      AppMethodBeat.o(224501);
      return null;
    }
    if (this.d != null)
    {
      gj localgj = this.d.n();
      localgj.a += 1;
    }
    paramGroundOverlayOptions = (GroundOverlay)this.k.a(new my(this.g.z(), paramGroundOverlayOptions));
    AppMethodBeat.o(224501);
    return paramGroundOverlayOptions;
  }
  
  private IntersectionOverlay a(IntersectionOverlayOptions paramIntersectionOverlayOptions)
  {
    AppMethodBeat.i(224514);
    if (this.g == null)
    {
      AppMethodBeat.o(224514);
      return null;
    }
    paramIntersectionOverlayOptions = (IntersectionOverlay)this.k.a(new ne(paramIntersectionOverlayOptions));
    AppMethodBeat.o(224514);
    return paramIntersectionOverlayOptions;
  }
  
  private Marker a(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(223471);
    if ((this.J == null) || (paramMarkerOptions == null))
    {
      AppMethodBeat.o(223471);
      return null;
    }
    paramMarkerOptions = this.J.a(paramMarkerOptions);
    AppMethodBeat.o(223471);
    return paramMarkerOptions;
  }
  
  private VectorHeatOverlay a(VectorHeatOverlayOptions paramVectorHeatOverlayOptions)
  {
    AppMethodBeat.i(224467);
    if (this.g == null)
    {
      AppMethodBeat.o(224467);
      return null;
    }
    if (this.d != null) {
      this.d.h().a();
    }
    paramVectorHeatOverlayOptions = (VectorHeatOverlay)this.k.a(new mr(paramVectorHeatOverlayOptions));
    AppMethodBeat.o(224467);
    return paramVectorHeatOverlayOptions;
  }
  
  private List<Integer> a(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(223641);
    sc localsc = this.g;
    paramRect = (List)localsc.a(new sc.23(localsc, paramRect, paramInt), null);
    AppMethodBeat.o(223641);
    return paramRect;
  }
  
  private void a(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(224313);
    if (this.g != null) {
      this.g.a(paramInt, paramFloat);
    }
    AppMethodBeat.o(224313);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(224095);
    if (this.g != null)
    {
      sc localsc = this.g;
      if ((0L == localsc.e) || (localsc.j == null))
      {
        AppMethodBeat.o(224095);
        return;
      }
      localsc.a(new sc.158(localsc, paramInt1, paramInt2, paramInt3));
    }
    AppMethodBeat.o(224095);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(223905);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.16(localsc, paramInt2, paramInt1, paramInt3, paramInt4));
    }
    AppMethodBeat.o(223905);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(223439);
    Object localObject;
    if ((this.g != null) && (this.S != null))
    {
      localObject = (Integer)this.S.a(Integer.valueOf(paramInt));
      if (localObject == null) {
        break label77;
      }
    }
    label77:
    for (int i1 = ((Integer)localObject).intValue();; i1 = 0)
    {
      localObject = this.g;
      ((sc)localObject).a(new sc.81((sc)localObject, paramInt, i1, paramBoolean));
      AppMethodBeat.o(223439);
      return;
    }
  }
  
  private void a(Rect paramRect)
  {
    AppMethodBeat.i(223233);
    if ((this.o == null) || (paramRect == null))
    {
      AppMethodBeat.o(223233);
      return;
    }
    this.C = paramRect;
    int i1 = this.o.width();
    int i2 = this.o.height();
    a(paramRect.left, paramRect.bottom, i1 - paramRect.right - paramRect.left, i2 - paramRect.bottom - paramRect.top, true);
    AppMethodBeat.o(223233);
  }
  
  private void a(Rect paramRect, int paramInt1, int paramInt2, fg paramfg)
  {
    AppMethodBeat.i(223816);
    if ((paramRect == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramfg == null))
    {
      AppMethodBeat.o(223816);
      return;
    }
    f.a(this.s, null, paramRect, paramfg, paramInt1, paramInt2);
    AppMethodBeat.o(223816);
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    AppMethodBeat.i(223936);
    if (this.g != null) {
      this.g.a(paramRect1, paramRect2, paramBoolean);
    }
    AppMethodBeat.o(223936);
  }
  
  private void a(GeoPoint paramGeoPoint, RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(224057);
    if ((paramRectF != null) && (this.C != null))
    {
      paramRectF.left -= this.C.left;
      paramRectF.top -= this.C.top;
      paramRectF.right -= this.C.right;
      paramRectF.bottom -= this.C.bottom;
    }
    if (this.g != null)
    {
      sc localsc = this.g;
      int i1 = this.E;
      int i2 = this.D;
      if ((0L == localsc.e) || (localsc.j == null))
      {
        AppMethodBeat.o(224057);
        return;
      }
      localsc.j.a(new sc.164(localsc, paramRectF, paramGeoPoint, i1, i2, paramBoolean));
    }
    AppMethodBeat.o(224057);
  }
  
  private void a(eq parameq, int paramInt1, int paramInt2, fg paramfg)
  {
    AppMethodBeat.i(223793);
    Rect localRect = parameq.getBound(this.n);
    if ((parameq == null) || (localRect == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramfg == null))
    {
      AppMethodBeat.o(223793);
      return;
    }
    f.a(this.s, parameq, localRect, paramfg, paramInt1, paramInt2);
    AppMethodBeat.o(223793);
  }
  
  private void a(eq parameq, Rect paramRect, int paramInt1, int paramInt2, fg paramfg)
  {
    AppMethodBeat.i(223806);
    if ((parameq == null) || (paramRect == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramfg == null))
    {
      AppMethodBeat.o(223806);
      return;
    }
    f.a(this.s, parameq, paramRect, paramfg, paramInt1, paramInt2);
    AppMethodBeat.o(223806);
  }
  
  private void a(es parames)
  {
    AppMethodBeat.i(224609);
    if (this.m != null) {
      this.m.a(parames);
    }
    AppMethodBeat.o(224609);
  }
  
  private void a(ob paramob)
  {
    AppMethodBeat.i(224225);
    if (this.g != null) {
      this.g.d.setMapCallbackGetGLContext(paramob);
    }
    AppMethodBeat.o(224225);
  }
  
  private void a(oe paramoe)
  {
    this.G = paramoe;
  }
  
  private void a(qp paramqp)
  {
    AppMethodBeat.i(223372);
    if (this.j != null)
    {
      Object localObject = this.j;
      if ((((qs)localObject).b != null) && (paramqp != null))
      {
        localObject = ((qs)localObject).b;
        if ((((qr)localObject).a == null) || (paramqp == null))
        {
          AppMethodBeat.o(223372);
          return;
        }
        ((qr)localObject).a.add(paramqp);
      }
    }
    AppMethodBeat.o(223372);
  }
  
  private void a(CustomRender paramCustomRender)
  {
    this.F = paramCustomRender;
    this.v = true;
  }
  
  private void a(Language paramLanguage)
  {
    AppMethodBeat.i(224346);
    if (this.y == null) {
      this.y = new c();
    }
    c localc = this.y;
    if (localc.a.g != null)
    {
      sc localsc = localc.a.g;
      localsc.a(new sc.26(localsc, paramLanguage.ordinal()));
      localc.a.v = true;
      localc.a.v = true;
      localc.a(paramLanguage);
    }
    AppMethodBeat.o(224346);
  }
  
  private void a(OverSeaTileProvider paramOverSeaTileProvider)
  {
    AppMethodBeat.i(224560);
    if (this.m == null)
    {
      AppMethodBeat.o(224560);
      return;
    }
    this.m.a(paramOverSeaTileProvider);
    AppMethodBeat.o(224560);
  }
  
  private void a(TrafficStyle paramTrafficStyle)
  {
    AppMethodBeat.i(224576);
    if (this.g == null)
    {
      AppMethodBeat.o(224576);
      return;
    }
    this.g.a(paramTrafficStyle);
    AppMethodBeat.o(224576);
  }
  
  private void a(VectorOverlay paramVectorOverlay, VectorOverlayProvider paramVectorOverlayProvider)
  {
    AppMethodBeat.i(224485);
    if (this.g == null)
    {
      AppMethodBeat.o(224485);
      return;
    }
    if ((paramVectorOverlayProvider instanceof AggregationOverlayProvider))
    {
      paramVectorOverlay = (mq)paramVectorOverlay;
      paramVectorOverlay = (mq)this.k.a(mq.class, paramVectorOverlay.c());
      if (paramVectorOverlay != null)
      {
        paramVectorOverlay.a(new mr((AggregationOverlayProvider)paramVectorOverlayProvider));
        AppMethodBeat.o(224485);
        return;
      }
      a(paramVectorOverlayProvider);
      AppMethodBeat.o(224485);
      return;
    }
    if ((paramVectorOverlayProvider instanceof GradientVectorOverlayProvider))
    {
      paramVectorOverlay = (mz)paramVectorOverlay;
      paramVectorOverlay = (mz)this.k.a(mz.class, paramVectorOverlay.c());
      if (paramVectorOverlay != null)
      {
        paramVectorOverlay.a(new nb((GradientVectorOverlayProvider)paramVectorOverlayProvider));
        AppMethodBeat.o(224485);
        return;
      }
      a(paramVectorOverlayProvider);
      AppMethodBeat.o(224485);
      return;
    }
    if ((paramVectorOverlayProvider instanceof ArcLineOverlayProvider))
    {
      paramVectorOverlay = (mt)paramVectorOverlay;
      paramVectorOverlay = (mt)this.k.a(mt.class, paramVectorOverlay.c());
      if (paramVectorOverlay != null)
      {
        paramVectorOverlay.a(new mv((ArcLineOverlayProvider)paramVectorOverlayProvider));
        AppMethodBeat.o(224485);
        return;
      }
      a(paramVectorOverlayProvider);
      AppMethodBeat.o(224485);
      return;
    }
    if ((paramVectorOverlayProvider instanceof DotScatterPlotOverlayProvider))
    {
      paramVectorOverlay = (ni)paramVectorOverlay;
      paramVectorOverlay = (ni)this.k.a(ni.class, paramVectorOverlay.c());
      if (paramVectorOverlay != null)
      {
        paramVectorOverlay.a(new nk(this.g.z(), (DotScatterPlotOverlayProvider)paramVectorOverlayProvider));
        AppMethodBeat.o(224485);
        return;
      }
      a(paramVectorOverlayProvider);
      AppMethodBeat.o(224485);
      return;
    }
    if ((paramVectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider))
    {
      paramVectorOverlay = (ni)paramVectorOverlay;
      paramVectorOverlay = (ni)this.k.a(ni.class, paramVectorOverlay.c());
      if (paramVectorOverlay != null)
      {
        paramVectorOverlay.a(new nk(this.g.z(), (BitmapScatterPlotOverlayProvider)paramVectorOverlayProvider));
        AppMethodBeat.o(224485);
        return;
      }
      a(paramVectorOverlayProvider);
      AppMethodBeat.o(224485);
      return;
    }
    if ((paramVectorOverlayProvider instanceof TrailOverlayProvider))
    {
      paramVectorOverlay = (nl)paramVectorOverlay;
      paramVectorOverlay = (nl)this.k.a(nl.class, paramVectorOverlay.c());
      if (paramVectorOverlay != null)
      {
        paramVectorOverlay.a(new nn((TrailOverlayProvider)paramVectorOverlayProvider));
        AppMethodBeat.o(224485);
        return;
      }
      a(paramVectorOverlayProvider);
    }
    AppMethodBeat.o(224485);
  }
  
  private void a(List<MapRouteSection> paramList, List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(223532);
    if (this.z == null) {
      this.z = new e();
    }
    e locale = this.z;
    locale.a = paramList;
    locale.b = paramList1;
    locale.c.g.a(paramList, paramList1);
    AppMethodBeat.o(223532);
  }
  
  private void a(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(223421);
    if ((this.g == null) || (paramArrayOfInt == null) || (paramInt == 0))
    {
      AppMethodBeat.o(223421);
      return;
    }
    this.g.a(paramArrayOfInt, paramInt);
    AppMethodBeat.o(223421);
  }
  
  private void a(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(223405);
    if ((this.g == null) || (paramArrayOfInt == null) || (paramInt == 0))
    {
      AppMethodBeat.o(223405);
      return;
    }
    sc localsc = this.g;
    localsc.a(new sc.123(localsc, paramArrayOfInt, paramInt, paramBoolean));
    AppMethodBeat.o(223405);
  }
  
  private boolean a(Context paramContext, nr paramnr)
  {
    AppMethodBeat.i(223070);
    String str1 = this.R.c();
    String str2 = this.R.a();
    String str3 = this.R.b();
    try
    {
      if (!this.u.a()) {
        str1 = this.R.d();
      }
      kh.b("TDZ", "newEngine config:".concat(String.valueOf(str1)));
      this.r.a();
      boolean bool = this.g.a(paramContext, paramnr, this.r, str1, str2, str3);
      return bool;
    }
    finally
    {
      this.r.b();
      AppMethodBeat.o(223070);
    }
  }
  
  private void aa()
  {
    AppMethodBeat.i(223712);
    if (this.g != null)
    {
      this.g.l();
      this.p = false;
    }
    AppMethodBeat.o(223712);
  }
  
  private boolean ab()
  {
    return this.p;
  }
  
  private boolean ac()
  {
    return this.U;
  }
  
  private void ad()
  {
    AppMethodBeat.i(223747);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.94(localsc));
    }
    AppMethodBeat.o(223747);
  }
  
  private void ae()
  {
    AppMethodBeat.i(223762);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.95(localsc));
    }
    AppMethodBeat.o(223762);
  }
  
  private void af()
  {
    AppMethodBeat.i(223836);
    this.s.a();
    AppMethodBeat.o(223836);
  }
  
  private void ag()
  {
    this.v = true;
  }
  
  private boolean ah()
  {
    AppMethodBeat.i(223870);
    if (this.i.i() > 1.0E-010D)
    {
      AppMethodBeat.o(223870);
      return true;
    }
    AppMethodBeat.o(223870);
    return false;
  }
  
  private String[] ai()
  {
    AppMethodBeat.i(223966);
    if (this.g != null)
    {
      Object localObject = this.g;
      localObject = (String[])((sc)localObject).a(new sc.135((sc)localObject), null);
      AppMethodBeat.o(223966);
      return localObject;
    }
    AppMethodBeat.o(223966);
    return null;
  }
  
  private String aj()
  {
    AppMethodBeat.i(223979);
    if (this.g != null)
    {
      Object localObject = this.g;
      localObject = (String)((sc)localObject).a(new sc.139((sc)localObject), null);
      AppMethodBeat.o(223979);
      return localObject;
    }
    AppMethodBeat.o(223979);
    return null;
  }
  
  private Rect ak()
  {
    AppMethodBeat.i(224006);
    if (this.g != null)
    {
      Object localObject = this.g;
      localObject = (Rect)((sc)localObject).a(new sc.138((sc)localObject), null);
      AppMethodBeat.o(224006);
      return localObject;
    }
    AppMethodBeat.o(224006);
    return null;
  }
  
  @Deprecated
  private boolean al()
  {
    AppMethodBeat.i(224195);
    if (this.g != null)
    {
      boolean bool = this.g.t();
      AppMethodBeat.o(224195);
      return bool;
    }
    AppMethodBeat.o(224195);
    return false;
  }
  
  private void am()
  {
    AppMethodBeat.i(224326);
    if (this.g == null)
    {
      AppMethodBeat.o(224326);
      return;
    }
    sc localsc = this.g;
    boolean bool = this.B;
    if (localsc.e != 0L) {
      localsc.a(new sc.29(localsc, bool));
    }
    AppMethodBeat.o(224326);
  }
  
  private mj an()
  {
    return this.l;
  }
  
  private qw ao()
  {
    return this.A;
  }
  
  private no ap()
  {
    return this.u;
  }
  
  private String aq()
  {
    return this.ae;
  }
  
  private bh ar()
  {
    return this.J;
  }
  
  @Deprecated
  private boolean as()
  {
    AppMethodBeat.i(224672);
    if (this.g != null)
    {
      boolean bool = this.g.j();
      AppMethodBeat.o(224672);
      return bool;
    }
    AppMethodBeat.o(224672);
    return false;
  }
  
  private String at()
  {
    AppMethodBeat.i(224697);
    if (this.g == null)
    {
      AppMethodBeat.o(224697);
      return null;
    }
    Object localObject = this.g;
    localObject = (String)((sc)localObject).a(new sc.41((sc)localObject), null);
    AppMethodBeat.o(224697);
    return localObject;
  }
  
  private String au()
  {
    AppMethodBeat.i(224712);
    if (this.g == null)
    {
      AppMethodBeat.o(224712);
      return null;
    }
    String str = this.g.a();
    AppMethodBeat.o(224712);
    return str;
  }
  
  private void av()
  {
    AppMethodBeat.i(224732);
    if (this.G != null) {
      this.G.m_();
    }
    AppMethodBeat.o(224732);
  }
  
  private void aw()
  {
    AppMethodBeat.i(224745);
    if ((this.I != null) && (!this.I.isEmpty()))
    {
      Iterator localIterator = this.I.iterator();
      while (localIterator.hasNext()) {
        ((oc)localIterator.next()).h();
      }
    }
    AppMethodBeat.o(224745);
  }
  
  private void ax()
  {
    AppMethodBeat.i(224760);
    if ((this.I != null) && (!this.I.isEmpty()))
    {
      Iterator localIterator = this.I.iterator();
      while (localIterator.hasNext()) {
        ((oc)localIterator.next()).i();
      }
    }
    AppMethodBeat.o(224760);
  }
  
  private qe ay()
  {
    return this.H;
  }
  
  private int b(fn paramfn)
  {
    AppMethodBeat.i(223571);
    if ((this.k != null) && (paramfn.u != null))
    {
      paramfn = a(paramfn);
      paramfn = (nf)this.k.a(paramfn);
      if (paramfn != null)
      {
        int i1 = paramfn.c();
        AppMethodBeat.o(223571);
        return i1;
      }
    }
    AppMethodBeat.o(223571);
    return -1;
  }
  
  private String b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223996);
    if (this.g != null)
    {
      sc localsc = this.g;
      paramGeoPoint = (String)localsc.a(new sc.140(localsc, paramGeoPoint), null);
      AppMethodBeat.o(223996);
      return paramGeoPoint;
    }
    AppMethodBeat.o(223996);
    return null;
  }
  
  @Deprecated
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(224146);
    if (this.g == null)
    {
      AppMethodBeat.o(224146);
      return;
    }
    this.g.a(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(224146);
  }
  
  private void b(es parames)
  {
    AppMethodBeat.i(224624);
    if (this.m != null) {
      this.m.b(parames);
    }
    AppMethodBeat.o(224624);
  }
  
  private void b(oc paramoc)
  {
    AppMethodBeat.i(224365);
    if (!this.I.isEmpty()) {
      this.I.remove(paramoc);
    }
    AppMethodBeat.o(224365);
  }
  
  private void b(qp paramqp)
  {
    AppMethodBeat.i(223388);
    if (this.j != null)
    {
      Object localObject = this.j;
      if ((((qs)localObject).b != null) && (paramqp != null))
      {
        localObject = ((qs)localObject).b;
        if ((((qr)localObject).a == null) || (paramqp == null))
        {
          AppMethodBeat.o(223388);
          return;
        }
        ((qr)localObject).a.remove(paramqp);
      }
    }
    AppMethodBeat.o(223388);
  }
  
  private void b(GL10 paramGL10)
  {
    AppMethodBeat.i(223280);
    if (this.Q.size() == 0)
    {
      AppMethodBeat.o(223280);
      return;
    }
    int i1 = 1;
    while (i1 != 0)
    {
      a locala = (a)this.Q.poll();
      if (locala != null) {
        try
        {
          locala.a(paramGL10);
        }
        catch (Exception localException) {}
      } else {
        i1 = 0;
      }
    }
    AppMethodBeat.o(223280);
  }
  
  private static Point[] b(Rect paramRect)
  {
    AppMethodBeat.i(223686);
    Point localPoint1 = new Point(paramRect.centerX(), paramRect.centerY());
    Point localPoint2 = new Point(paramRect.left, paramRect.top);
    Point localPoint3 = new Point(paramRect.left, paramRect.bottom);
    Point localPoint4 = new Point(paramRect.right, paramRect.top);
    paramRect = new Point(paramRect.right, paramRect.bottom);
    AppMethodBeat.o(223686);
    return new Point[] { localPoint1, localPoint2, localPoint3, localPoint4, paramRect };
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223218);
    if (this.g == null)
    {
      AppMethodBeat.o(223218);
      return;
    }
    this.v = true;
    this.o.set(0, 0, paramInt1, paramInt2);
    a(0, 0, paramInt1, paramInt2, false);
    this.i.n();
    AppMethodBeat.o(223218);
  }
  
  private void c(fn paramfn)
  {
    AppMethodBeat.i(223582);
    if (this.k != null)
    {
      nh localnh = a(paramfn);
      Object localObject = this.k;
      int i1 = paramfn.a;
      paramfn = (mn)((bi)localObject).i.get(localnh.getClass());
      if (paramfn != null)
      {
        localObject = paramfn.a(i1);
        if (localObject != null)
        {
          ((mm)localObject).a(localnh);
          paramfn.a((mm)localObject);
        }
      }
    }
    AppMethodBeat.o(223582);
  }
  
  private boolean c(String paramString)
  {
    AppMethodBeat.i(223777);
    if (this.g == null)
    {
      AppMethodBeat.o(223777);
      return false;
    }
    sc localsc = this.g;
    boolean bool = ((Boolean)localsc.a(new sc.89(localsc, paramString), Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(223777);
    return bool;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223263);
    if (this.o != null) {
      this.o.set(0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(223263);
  }
  
  private void d(String paramString)
  {
    AppMethodBeat.i(224281);
    if (this.g != null)
    {
      sc localsc = this.g;
      if (0L != localsc.e) {
        localsc.a(new sc.127(localsc, paramString));
      }
    }
    AppMethodBeat.o(224281);
  }
  
  private boolean d(int paramInt)
  {
    AppMethodBeat.i(223291);
    if (paramInt != mk.b.f.g)
    {
      AppMethodBeat.o(223291);
      return false;
    }
    if (this.F != null)
    {
      this.F.onDrawFrame();
      AppMethodBeat.o(223291);
      return true;
    }
    AppMethodBeat.o(223291);
    return false;
  }
  
  private void e(int paramInt)
  {
    AppMethodBeat.i(223518);
    if (this.g == null)
    {
      AppMethodBeat.o(223518);
      return;
    }
    sc localsc = this.g;
    localsc.a(new sc.86(localsc, paramInt));
    AppMethodBeat.o(223518);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    int i1 = 255;
    AppMethodBeat.i(223502);
    if (this.g == null)
    {
      AppMethodBeat.o(223502);
      return;
    }
    if (paramInt2 < 0) {
      paramInt2 = 0;
    }
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
        sc localsc = this.g;
        localsc.a(new sc.85(localsc, paramInt1, paramInt2));
        AppMethodBeat.o(223502);
        return;
      }
    }
  }
  
  private void e(String paramString)
  {
    AppMethodBeat.i(224300);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.25(localsc, paramString));
    }
    AppMethodBeat.o(224300);
  }
  
  private int f(String paramString)
  {
    AppMethodBeat.i(224686);
    if (this.g == null)
    {
      AppMethodBeat.o(224686);
      return -1;
    }
    sc localsc = this.g;
    int i1 = ((Integer)localsc.a(new sc.40(localsc, paramString), Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(224686);
    return i1;
  }
  
  private void f(int paramInt)
  {
    AppMethodBeat.i(223595);
    if (this.k != null)
    {
      mm localmm = this.k.a(nf.class, paramInt);
      if (localmm != null) {
        localmm.remove();
      }
    }
    AppMethodBeat.o(223595);
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223620);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(223620);
      return;
    }
    sc localsc = this.g;
    localsc.a(new sc.53(localsc, paramInt1, paramInt2));
    AppMethodBeat.o(223620);
  }
  
  private void g(int paramInt)
  {
    AppMethodBeat.i(223630);
    sc localsc = this.g;
    localsc.a(new sc.54(localsc, paramInt));
    AppMethodBeat.o(223630);
  }
  
  private void g(int paramInt1, int paramInt2)
  {
    this.E = paramInt1;
    this.D = paramInt2;
  }
  
  private void g(String paramString)
  {
    AppMethodBeat.i(224784);
    if (this.x == null)
    {
      AppMethodBeat.o(224784);
      return;
    }
    this.x.a(paramString);
    AppMethodBeat.o(224784);
  }
  
  private void h(int paramInt)
  {
    AppMethodBeat.i(223662);
    if (this.g == null)
    {
      AppMethodBeat.o(223662);
      return;
    }
    sc localsc = this.g;
    localsc.a(new sc.148(localsc, paramInt));
    AppMethodBeat.o(223662);
  }
  
  @Deprecated
  private void h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224130);
    if (this.g != null) {
      this.g.b(paramInt1, paramInt2);
    }
    AppMethodBeat.o(224130);
  }
  
  private void i(int paramInt)
  {
    AppMethodBeat.i(223946);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.133(localsc, paramInt));
    }
    AppMethodBeat.o(223946);
  }
  
  private void i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224239);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.18(localsc, paramInt1, paramInt2));
    }
    AppMethodBeat.o(224239);
  }
  
  private void i(boolean paramBoolean)
  {
    AppMethodBeat.i(223173);
    this.g.g(paramBoolean);
    AppMethodBeat.o(223173);
  }
  
  private void j(int paramInt)
  {
    AppMethodBeat.i(224030);
    if (this.g != null)
    {
      sc localsc = this.g;
      if (0L != localsc.e) {
        localsc.a(new sc.146(localsc, paramInt));
      }
    }
    AppMethodBeat.o(224030);
  }
  
  private void j(boolean paramBoolean)
  {
    AppMethodBeat.i(223888);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.114(localsc, paramBoolean));
    }
    AppMethodBeat.o(223888);
  }
  
  private void k(int paramInt)
  {
    AppMethodBeat.i(224076);
    if (this.g != null) {
      this.g.b(paramInt);
    }
    if (this.t != null) {
      this.t.b.n = paramInt;
    }
    AppMethodBeat.o(224076);
  }
  
  private void k(boolean paramBoolean)
  {
    AppMethodBeat.i(223917);
    sc localsc = this.g;
    if (0L != localsc.e) {
      localsc.a(new sc.147(localsc, paramBoolean));
    }
    AppMethodBeat.o(223917);
  }
  
  @Deprecated
  private void l(int paramInt)
  {
    AppMethodBeat.i(224162);
    if (this.g != null)
    {
      this.g.d(paramInt);
      this.v = true;
    }
    AppMethodBeat.o(224162);
  }
  
  private void l(boolean paramBoolean)
  {
    AppMethodBeat.i(224018);
    if (this.g != null)
    {
      sc localsc = this.g;
      if (localsc.e != 0L) {
        localsc.a(new sc.143(localsc, paramBoolean));
      }
    }
    AppMethodBeat.o(224018);
  }
  
  @Deprecated
  private void m(int paramInt)
  {
    AppMethodBeat.i(224182);
    if (this.g != null) {
      this.g.e(paramInt);
    }
    AppMethodBeat.o(224182);
  }
  
  @Deprecated
  private void m(boolean paramBoolean)
  {
    AppMethodBeat.i(224209);
    if (this.g != null) {
      this.g.h(paramBoolean);
    }
    AppMethodBeat.o(224209);
  }
  
  private void n(boolean paramBoolean)
  {
    AppMethodBeat.i(224252);
    ac localac = this.i;
    localac.G = paramBoolean;
    localac.z.f().b(localac.G);
    AppMethodBeat.o(224252);
  }
  
  private static boolean n(int paramInt)
  {
    AppMethodBeat.i(224530);
    boolean bool = v.b(paramInt);
    AppMethodBeat.o(224530);
    return bool;
  }
  
  private void o(int paramInt)
  {
    AppMethodBeat.i(224546);
    sc localsc = this.g;
    localsc.a(new sc.132(localsc, paramInt));
    AppMethodBeat.o(224546);
  }
  
  private void o(boolean paramBoolean)
  {
    AppMethodBeat.i(224265);
    if (this.g != null) {
      this.g.b(paramBoolean);
    }
    this.v = true;
    AppMethodBeat.o(224265);
  }
  
  private void p(boolean paramBoolean)
  {
    AppMethodBeat.i(224640);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.36(localsc, paramBoolean));
    }
    AppMethodBeat.o(224640);
  }
  
  private void q(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.L = paramBoolean;
    }
  }
  
  public final String A()
  {
    AppMethodBeat.i(225289);
    String str = a(this.i.A.m);
    AppMethodBeat.o(225289);
    return str;
  }
  
  public final Language B()
  {
    AppMethodBeat.i(225545);
    if (this.y == null) {
      this.y = new c();
    }
    Language localLanguage = this.y.a();
    AppMethodBeat.o(225545);
    return localLanguage;
  }
  
  public final bm C()
  {
    AppMethodBeat.i(225696);
    if (this.m == null)
    {
      AppMethodBeat.o(225696);
      return null;
    }
    bm localbm = (bm)this.m.getMapContext();
    AppMethodBeat.o(225696);
    return localbm;
  }
  
  public final ArrayList<MapPoi> D()
  {
    AppMethodBeat.i(225779);
    if (this.g == null)
    {
      AppMethodBeat.o(225779);
      return null;
    }
    ArrayList localArrayList = this.g.w();
    AppMethodBeat.o(225779);
    return localArrayList;
  }
  
  public final boolean E()
  {
    AppMethodBeat.i(225793);
    if (this.g == null)
    {
      AppMethodBeat.o(225793);
      return false;
    }
    sc localsc = this.g;
    boolean bool = ((Boolean)localsc.a(new sc.43(localsc, 1), Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(225793);
    return bool;
  }
  
  public final int a(PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(225216);
    if ((this.g == null) || (paramPolygonInfo == null))
    {
      AppMethodBeat.o(225216);
      return -1;
    }
    sc localsc = this.g;
    int i1 = ((Integer)localsc.a(new sc.46(localsc, paramPolygonInfo), Integer.valueOf(0))).intValue();
    if (this.S == null) {
      this.S = new ku();
    }
    this.S.a(Integer.valueOf(i1), Integer.valueOf(paramPolygonInfo.borderLineId));
    AppMethodBeat.o(225216);
    return i1;
  }
  
  public final int a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225471);
    if (this.g != null)
    {
      int i1 = this.g.a(paramString, paramFloat1, paramFloat2);
      AppMethodBeat.o(225471);
      return i1;
    }
    AppMethodBeat.o(225471);
    return 0;
  }
  
  public final TappedElement a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225593);
    if (this.g != null)
    {
      TappedElement localTappedElement = this.g.a(paramFloat1, paramFloat2);
      AppMethodBeat.o(225593);
      return localTappedElement;
    }
    AppMethodBeat.o(225593);
    return null;
  }
  
  public final ac a()
  {
    return this.i;
  }
  
  public final Polyline a(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(225274);
    if ((this.J == null) || (paramPolylineOptions == null))
    {
      AppMethodBeat.o(225274);
      return null;
    }
    paramPolylineOptions = this.J.a(paramPolylineOptions);
    AppMethodBeat.o(225274);
    return paramPolylineOptions;
  }
  
  public final <V extends VectorOverlay> V a(VectorOverlayProvider paramVectorOverlayProvider)
  {
    AppMethodBeat.i(225633);
    if (this.g == null)
    {
      AppMethodBeat.o(225633);
      return null;
    }
    if ((paramVectorOverlayProvider instanceof AggregationOverlayProvider))
    {
      if (this.d != null) {
        this.d.h().a();
      }
      paramVectorOverlayProvider = (mq)this.k.a(new mr((AggregationOverlayProvider)paramVectorOverlayProvider));
      AppMethodBeat.o(225633);
      return paramVectorOverlayProvider;
    }
    Object localObject;
    if ((paramVectorOverlayProvider instanceof GradientVectorOverlayProvider))
    {
      if (this.d != null)
      {
        localObject = this.d.i();
        ((gk)localObject).a += 1;
      }
      paramVectorOverlayProvider = (mz)this.k.a(new nb((GradientVectorOverlayProvider)paramVectorOverlayProvider));
      AppMethodBeat.o(225633);
      return paramVectorOverlayProvider;
    }
    if ((paramVectorOverlayProvider instanceof ArcLineOverlayProvider))
    {
      if (this.d != null)
      {
        localObject = this.d.j();
        ((ge)localObject).a += 1;
      }
      paramVectorOverlayProvider = (mt)this.k.a(new mv((ArcLineOverlayProvider)paramVectorOverlayProvider));
      AppMethodBeat.o(225633);
      return paramVectorOverlayProvider;
    }
    if ((paramVectorOverlayProvider instanceof DotScatterPlotOverlayProvider))
    {
      if (this.d != null)
      {
        localObject = this.d.k();
        ((gi)localObject).a += 1;
      }
      paramVectorOverlayProvider = (ni)this.k.a(new nk(this.g.z(), (DotScatterPlotOverlayProvider)paramVectorOverlayProvider));
      AppMethodBeat.o(225633);
      return paramVectorOverlayProvider;
    }
    if ((paramVectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider))
    {
      if (this.d != null)
      {
        localObject = this.d.l();
        ((gf)localObject).a += 1;
      }
      paramVectorOverlayProvider = (ni)this.k.a(new nk(this.g.z(), (BitmapScatterPlotOverlayProvider)paramVectorOverlayProvider));
      AppMethodBeat.o(225633);
      return paramVectorOverlayProvider;
    }
    if ((paramVectorOverlayProvider instanceof TrailOverlayProvider))
    {
      if (this.d != null)
      {
        localObject = this.d.m();
        ((gs)localObject).a += 1;
      }
      paramVectorOverlayProvider = (nl)this.k.a(new nn((TrailOverlayProvider)paramVectorOverlayProvider));
      AppMethodBeat.o(225633);
      return paramVectorOverlayProvider;
    }
    AppMethodBeat.o(225633);
    return null;
  }
  
  public final String a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(225306);
    if (this.g == null)
    {
      AppMethodBeat.o(225306);
      return "";
    }
    paramGeoPoint = this.g.a(paramGeoPoint);
    AppMethodBeat.o(225306);
    return paramGeoPoint;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(225426);
    if (this.g != null) {
      this.g.a(paramFloat);
    }
    AppMethodBeat.o(225426);
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(225143);
    this.X = paramFloat1;
    this.Y = paramFloat2;
    double d5 = paramFloat1;
    double d2 = paramFloat2;
    double d3 = d2;
    double d4 = d5;
    if (this.o != null)
    {
      double d1 = d2;
      if (this.W > 0) {
        d1 = 0.5D - (0.5D - d2) * this.o.height() / this.W;
      }
      d3 = d1;
      d4 = d5;
      if (this.V > 0)
      {
        d4 = 0.5D - (0.5D - d5) * this.o.width() / this.V;
        d3 = d1;
      }
    }
    this.g.a((float)d4, (float)d3, paramBoolean);
    AppMethodBeat.o(225143);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(225246);
    Object localObject;
    if ((this.g != null) && (this.S != null))
    {
      localObject = (Integer)this.S.a(Integer.valueOf(paramInt));
      if (localObject == null) {
        break label70;
      }
    }
    label70:
    for (int i1 = ((Integer)localObject).intValue();; i1 = 0)
    {
      localObject = this.g;
      ((sc)localObject).a(new sc.83((sc)localObject, paramInt, i1));
      AppMethodBeat.o(225246);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225524);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.17(localsc, paramInt1, paramInt2));
    }
    AppMethodBeat.o(225524);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(225123);
    this.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.V = paramInt3;
    this.W = paramInt4;
    if (paramBoolean) {
      a(this.X, this.Y, this.Z);
    }
    AppMethodBeat.o(225123);
  }
  
  public final void a(GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(225397);
    if (this.g != null) {
      this.g.a(paramGeoPoint, paramFloat1, paramFloat2, paramBoolean);
    }
    AppMethodBeat.o(225397);
  }
  
  public final void a(ez paramez)
  {
    AppMethodBeat.i(225558);
    if (this.y == null) {
      this.y = new c();
    }
    this.y.a(paramez);
    AppMethodBeat.o(225558);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(224958);
    try
    {
      this.Q.put(parama);
      AppMethodBeat.o(224958);
      return;
    }
    catch (InterruptedException parama)
    {
      kh.a(parama.getMessage(), parama);
      Thread.currentThread().interrupt();
      AppMethodBeat.o(224958);
    }
  }
  
  public final void a(nt paramnt)
  {
    AppMethodBeat.i(224914);
    if (paramnt == null)
    {
      AppMethodBeat.o(224914);
      return;
    }
    this.R = paramnt;
    if (this.g != null)
    {
      paramnt = this.R.c();
      String str1 = this.R.a();
      String str2 = this.R.b();
      kh.b("TDZ", "resetMapPath config:".concat(String.valueOf(paramnt)));
      if ((!gz.a(str2)) && (!gz.a(str1))) {
        try
        {
          this.r.a();
          sc localsc = this.g;
          localsc.a(new sc.28(localsc, paramnt, str1, str2));
          return;
        }
        finally
        {
          this.r.b();
          AppMethodBeat.o(224914);
        }
      }
    }
    AppMethodBeat.o(224914);
  }
  
  public final void a(oa paramoa)
  {
    if (this.g != null) {
      this.g.i = paramoa;
    }
  }
  
  public final void a(oc paramoc)
  {
    AppMethodBeat.i(225573);
    if (this.I != null) {
      this.I.add(paramoc);
    }
    AppMethodBeat.o(225573);
  }
  
  public final void a(LatLngBounds paramLatLngBounds, int paramInt)
  {
    AppMethodBeat.i(225809);
    if (this.g == null)
    {
      AppMethodBeat.o(225809);
      return;
    }
    if ((paramLatLngBounds == null) || (paramLatLngBounds.isEmptySpan()))
    {
      this.g.a(null, null, 0);
      AppMethodBeat.o(225809);
      return;
    }
    sc localsc = this.g;
    double d1 = paramLatLngBounds.getLonWest();
    double d2 = paramLatLngBounds.getLatSouth();
    double d3 = paramLatLngBounds.getLonEast();
    double d4 = paramLatLngBounds.getLatNorth();
    double d5 = this.V;
    double d6 = this.W;
    localsc.a(new double[] { d1, d2, d3, d4 }, new double[] { 0.0D, 0.0D, d5, d6 }, paramInt);
    AppMethodBeat.o(225809);
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(225325);
    if (this.g != null)
    {
      sc localsc = this.g;
      if (localsc.e != 0L) {
        localsc.a(new sc.31(localsc, paramString));
      }
    }
    AppMethodBeat.o(225325);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225763);
    if (this.g == null)
    {
      AppMethodBeat.o(225763);
      return;
    }
    this.g.a(paramString1, paramString2);
    AppMethodBeat.o(225763);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(225203);
    if (this.j != null)
    {
      this.q = paramBoolean;
      if (paramBoolean)
      {
        if (this.g != null)
        {
          localObject = this.g;
          ((sc)localObject).a(new sc.94((sc)localObject));
        }
        Object localObject = this.j;
        if (((qs)localObject).a == null) {
          break label148;
        }
        ((qs)localObject).a.i.a((fh)localObject);
        if (((qs)localObject).b == null) {
          ((qs)localObject).b = new qr(((qs)localObject).a, ((qs)localObject).c);
        }
        try
        {
          ((qs)localObject).b.start();
          AppMethodBeat.o(225203);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(225203);
          return;
        }
      }
      if (this.g != null)
      {
        sc localsc = this.g;
        localsc.a(new sc.95(localsc));
      }
      this.j.c();
    }
    label148:
    AppMethodBeat.o(225203);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(225411);
    if (this.g != null)
    {
      sc localsc = this.g;
      if ((0L == localsc.e) || (localsc.j == null))
      {
        AppMethodBeat.o(225411);
        return;
      }
      localsc.a(new sc.117(localsc, false, paramBoolean1, false, paramBoolean2));
    }
    AppMethodBeat.o(225411);
  }
  
  public final void a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(225458);
    if (this.g != null)
    {
      sc localsc = this.g;
      if (localsc.e != 0L) {
        localsc.a(new sc.144(localsc, paramArrayOfString));
      }
    }
    AppMethodBeat.o(225458);
  }
  
  public final boolean a(Context paramContext, no paramno, lc paramlc, nr paramnr)
  {
    AppMethodBeat.i(224894);
    this.u = paramno;
    nt localnt = paramno.c();
    this.R = localnt;
    this.x = paramno.e();
    this.r = new w(paramContext, this, localnt, this.x);
    if (this.j == null) {
      this.j = new qs(this, paramlc);
    }
    boolean bool = a(paramContext, paramnr);
    if (bool)
    {
      if (this.a != null) {
        this.g.a(this.a.getTrafficStyle());
      }
      paramContext = this.g;
      if (0L != paramContext.e) {
        paramContext.a(new sc.119(paramContext));
      }
      this.g.f(true);
      this.g.a(20);
      this.g.b(3);
      this.i.a(this);
      b(this.M, this.M);
    }
    AppMethodBeat.o(224894);
    return bool;
  }
  
  public final boolean a(GL10 paramGL10)
  {
    boolean bool2 = true;
    AppMethodBeat.i(225181);
    if (this.g == null)
    {
      AppMethodBeat.o(225181);
      return false;
    }
    Object localObject1 = this.k;
    if (((bi)localObject1).i != null)
    {
      localObject1 = ((bi)localObject1).i.values();
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty()))
      {
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((mn)((Iterator)localObject1).next()).d();
        }
      }
    }
    this.i.o.g();
    if (this.Q.size() != 0)
    {
      int i1 = 1;
      while (i1 != 0)
      {
        localObject1 = (a)this.Q.poll();
        if (localObject1 != null) {
          try
          {
            ((a)localObject1).a(paramGL10);
          }
          catch (Exception localException) {}
        } else {
          i1 = 0;
        }
      }
    }
    Object localObject2 = this.g;
    ((sc)localObject2).a(new sc.167((sc)localObject2));
    localObject2 = this.g;
    boolean bool1 = bool2;
    label263:
    Object localObject3;
    long l2;
    if (!((Boolean)((sc)localObject2).a(new sc.168((sc)localObject2), Boolean.FALSE)).booleanValue())
    {
      if (this.v) {
        bool1 = bool2;
      }
    }
    else if (bool1)
    {
      localObject2 = this.s.c();
      if (localObject2 != null) {
        break label471;
      }
      this.k.d.h.a(paramGL10);
      l1 = System.currentTimeMillis();
      localObject3 = this.g;
      ((Boolean)((sc)localObject3).a(new sc.82((sc)localObject3), Boolean.FALSE)).booleanValue();
      this.v = false;
      if (!this.m.N())
      {
        l2 = System.currentTimeMillis() - l1;
        localObject3 = kl.c("VECTOR_RENDER_LOOP", "nativeTotalTime");
        if (localObject3 == null) {
          break label527;
        }
      }
    }
    label518:
    label527:
    for (long l1 = ((Long)localObject3).longValue();; l1 = 0L)
    {
      kl.a("VECTOR_RENDER_LOOP", "nativeTime", Long.valueOf(l2));
      kl.a("VECTOR_RENDER_LOOP", "nativeTotalTime", Long.valueOf(l1 + l2));
      kl.e("VECTOR_RENDER_LOOP");
      if ((!this.s.b()) && (localObject2 != null))
      {
        if (((g)localObject2).c()) {
          break label518;
        }
        if ((!this.g.j()) && (((g)localObject2).e < 100)) {
          break label503;
        }
        ((g)localObject2).e = 0;
        this.s.a(paramGL10);
      }
      for (;;)
      {
        if (this.l != null) {
          this.l.a();
        }
        AppMethodBeat.o(225181);
        return bool1;
        bool1 = false;
        break;
        label471:
        if ((this.s == null) || (!this.g.j())) {
          break label263;
        }
        this.s.a(paramGL10, this.l);
        break label263;
        label503:
        ((g)localObject2).e += 1;
        continue;
        ((g)localObject2).e = 0;
      }
    }
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(225499);
    if (this.g != null) {
      this.g.a(paramInt);
    }
    if (this.t != null) {
      this.t.b.o = paramInt;
    }
    AppMethodBeat.o(225499);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225534);
    if (this.g != null) {
      this.g.a(paramInt1 + 50, paramInt2 + 50);
    }
    AppMethodBeat.o(225534);
  }
  
  public final void b(PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(225230);
    if ((this.g == null) || (paramPolygonInfo == null))
    {
      AppMethodBeat.o(225230);
      return;
    }
    sc localsc = this.g;
    localsc.a(new sc.80(localsc, paramPolygonInfo));
    AppMethodBeat.o(225230);
  }
  
  public final void b(ez paramez)
  {
    AppMethodBeat.i(225583);
    if (this.y == null) {
      this.y = new c();
    }
    this.y.b(paramez);
    AppMethodBeat.o(225583);
  }
  
  public final void b(String paramString)
  {
    AppMethodBeat.i(225341);
    if (this.g != null)
    {
      this.ae = paramString;
      sc localsc = this.g;
      if (localsc.e != 0L) {
        localsc.a(new sc.32(localsc, paramString));
      }
    }
    AppMethodBeat.o(225341);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(225358);
    if (this.U == paramBoolean)
    {
      AppMethodBeat.o(225358);
      return;
    }
    this.U = paramBoolean;
    if (this.g != null) {
      this.g.a(paramBoolean);
    }
    AppMethodBeat.o(225358);
  }
  
  public final bi c()
  {
    return this.k;
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(225680);
    if (this.i != null) {
      this.i.b(paramInt);
    }
    AppMethodBeat.o(225680);
  }
  
  public final void c(boolean paramBoolean)
  {
    AppMethodBeat.i(225368);
    this.T = paramBoolean;
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.114(localsc, paramBoolean));
    }
    AppMethodBeat.o(225368);
  }
  
  public final ep d()
  {
    return this.n;
  }
  
  public final void d(boolean paramBoolean)
  {
    AppMethodBeat.i(225441);
    if (this.g != null)
    {
      kh.b("TDZ", "setIndoorEnabled:".concat(String.valueOf(paramBoolean)));
      this.g.c(paramBoolean);
    }
    AppMethodBeat.o(225441);
  }
  
  public final void d_() {}
  
  public final v e()
  {
    return this.t;
  }
  
  public final void e(boolean paramBoolean)
  {
    AppMethodBeat.i(225487);
    if (this.g != null) {
      this.g.e(paramBoolean);
    }
    AppMethodBeat.o(225487);
  }
  
  public final sc f()
  {
    return this.g;
  }
  
  public final void f(boolean paramBoolean)
  {
    AppMethodBeat.i(225613);
    if (this.A == null) {
      this.A = new qw(this);
    }
    qw localqw = this.A;
    localqw.f = paramBoolean;
    if (paramBoolean) {
      try
      {
        synchronized (localqw.j)
        {
          localqw.j.start();
          AppMethodBeat.o(225613);
          return;
        }
        localException.f = false;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(225613);
        return;
      }
    }
    synchronized (localException.j)
    {
      localException.j.notifyAll();
      AppMethodBeat.o(225613);
      return;
    }
  }
  
  public final Rect g()
  {
    return this.o;
  }
  
  public final void g(boolean paramBoolean)
  {
    AppMethodBeat.i(225706);
    if (this.g != null) {
      this.g.i(paramBoolean);
    }
    AppMethodBeat.o(225706);
  }
  
  public final float h()
  {
    AppMethodBeat.i(225061);
    if (getContext() == null)
    {
      AppMethodBeat.o(225061);
      return 1.0F;
    }
    float f = ha.a(getContext());
    AppMethodBeat.o(225061);
    return f;
  }
  
  public final void h(boolean paramBoolean)
  {
    AppMethodBeat.i(225712);
    if (this.g != null)
    {
      sc localsc = this.g;
      localsc.a(new sc.34(localsc, paramBoolean));
    }
    AppMethodBeat.o(225712);
  }
  
  public final Object i()
  {
    AppMethodBeat.i(225077);
    Object localObject = this.a.getExtSurface();
    AppMethodBeat.o(225077);
    return localObject;
  }
  
  public final int j()
  {
    AppMethodBeat.i(225092);
    int i1 = this.a.getExtSurfaceWidth();
    AppMethodBeat.o(225092);
    return i1;
  }
  
  public final int k()
  {
    AppMethodBeat.i(225107);
    int i1 = this.a.getExtSurfaceHeight();
    AppMethodBeat.o(225107);
    return i1;
  }
  
  public final boolean l()
  {
    AppMethodBeat.i(225646);
    boolean bool = v.b(this.i.m());
    AppMethodBeat.o(225646);
    return bool;
  }
  
  public final float m()
  {
    AppMethodBeat.i(225658);
    float f = this.a.getMapFrameRate();
    AppMethodBeat.o(225658);
    return f;
  }
  
  public final boolean n()
  {
    AppMethodBeat.i(225669);
    boolean bool = this.a.isOpaque();
    AppMethodBeat.o(225669);
    return bool;
  }
  
  public final Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> q()
  {
    AppMethodBeat.i(224874);
    HashMap localHashMap = new HashMap();
    localHashMap.put(dv.class, rc.class);
    AppMethodBeat.o(224874);
    return localHashMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225601);
    if (this.t != null)
    {
      String str = this.t.toString();
      AppMethodBeat.o(225601);
      return str;
    }
    AppMethodBeat.o(225601);
    return "";
  }
  
  public final String v()
  {
    AppMethodBeat.i(225728);
    Object localObject = null;
    if (this.g != null)
    {
      localObject = this.g;
      localObject = (String)((sc)localObject).a(new sc.37((sc)localObject), "");
    }
    AppMethodBeat.o(225728);
    return localObject;
  }
  
  public final String w()
  {
    AppMethodBeat.i(225740);
    Object localObject = null;
    if (this.g != null)
    {
      localObject = this.g;
      localObject = (String)((sc)localObject).a(new sc.38((sc)localObject), "");
    }
    AppMethodBeat.o(225740);
    return localObject;
  }
  
  public final br y()
  {
    return this.g;
  }
  
  public final void z()
  {
    AppMethodBeat.i(224945);
    if (this.H != null)
    {
      ??? = this.H;
      if ((((qe)???).g != null) && (!((qe)???).g.isEmpty())) {
        break label406;
      }
    }
    for (;;)
    {
      ??? = getContext();
      if (??? != null)
      {
        ??? = new File(mf.a((Context)???, null).b().getPath() + "/tile/");
        if (((File)???).exists())
        {
          ??? = ((File)???).listFiles();
          if ((??? != null) && (???.length != 0)) {
            break label467;
          }
        }
      }
      a(null);
      this.G = null;
      this.i.b(this);
      this.I.clear();
      if (this.z != null)
      {
        ??? = this.z;
        ((e)???).c.b((ez)???);
      }
      ??? = this.i;
      if (((ac)???).o != null)
      {
        ??? = ((ac)???).o;
        if (((y)???).d != null) {
          ((y)???).d.destroy();
        }
      }
      this.w = true;
      if (this.A != null)
      {
        ??? = this.A;
        ((qw)???).h = true;
        ((qw)???).f = false;
      }
      synchronized (((qw)???).j)
      {
        ((qw)???).j.notifyAll();
        if (this.k != null) {
          this.k.b();
        }
        if (this.j != null) {
          this.j.c();
        }
        if (this.g == null) {
          break;
        }
        ??? = this.g;
      }
      try
      {
        ((sc)???).m.lock();
        if (((sc)???).g != null)
        {
          ((sc)???).g.b(((sc)???).h);
          ((sc)???).g.a();
        }
        long l1;
        if (((sc)???).e != 0L)
        {
          l1 = ((sc)???).e;
          ((sc)???).e = 0L;
        }
        synchronized (((sc)???).l)
        {
          ((sc)???).d.nativeDestroyEngine(l1);
          ((sc)???).j = null;
          ((sc)???).d.destory();
          return;
          label406:
          ??? = (pz[])((qe)???).g.values().toArray(new pz[((qe)???).g.keySet().size()]);
          int i1 = 0;
          while (i1 < ???.length)
          {
            ???[i1].remove();
            i1 += 1;
          }
          label467:
          l1 = System.currentTimeMillis();
          int i2 = ???.length;
          i1 = 0;
          while (i1 < i2)
          {
            ??? = ???[i1];
            if (l1 - ((File)???).lastModified() > TimeUnit.DAYS.toMillis(7L)) {
              ka.b((File)???);
            }
            i1 += 1;
          }
          localObject3 = finally;
          AppMethodBeat.o(224945);
          throw localObject3;
        }
        AppMethodBeat.o(224945);
      }
      finally
      {
        ((sc)???).m.unlock();
        AppMethodBeat.o(224945);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(GL10 paramGL10);
  }
  
  public final class c
  {
    private List<ez> b;
    
    public c()
    {
      AppMethodBeat.i(221822);
      this.b = new CopyOnWriteArrayList();
      AppMethodBeat.o(221822);
    }
    
    private void b(Language paramLanguage)
    {
      AppMethodBeat.i(221830);
      if (mk.a(mk.this) != null)
      {
        sc localsc = mk.a(mk.this);
        localsc.a(new sc.26(localsc, paramLanguage.ordinal()));
        mk.e(mk.this);
        mk.this.v = true;
        a(paramLanguage);
      }
      AppMethodBeat.o(221830);
    }
    
    public final Language a()
    {
      AppMethodBeat.i(221838);
      if (mk.a(mk.this) == null)
      {
        localLanguage = Language.zh;
        AppMethodBeat.o(221838);
        return localLanguage;
      }
      if (mk.a(mk.this).v() == 1)
      {
        localLanguage = Language.en;
        AppMethodBeat.o(221838);
        return localLanguage;
      }
      Language localLanguage = Language.zh;
      AppMethodBeat.o(221838);
      return localLanguage;
    }
    
    public final void a(ez paramez)
    {
      AppMethodBeat.i(221847);
      if (paramez == null)
      {
        AppMethodBeat.o(221847);
        return;
      }
      synchronized (this.b)
      {
        if (!this.b.contains(paramez)) {
          this.b.add(paramez);
        }
        AppMethodBeat.o(221847);
        return;
      }
    }
    
    public final void a(Language paramLanguage)
    {
      try
      {
        AppMethodBeat.i(221868);
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          ez localez = (ez)localIterator.next();
          if (localez != null) {
            localez.a(paramLanguage);
          }
        }
        AppMethodBeat.o(221868);
      }
      finally {}
    }
    
    public final void b(ez paramez)
    {
      AppMethodBeat.i(221856);
      if (paramez == null)
      {
        AppMethodBeat.o(221856);
        return;
      }
      this.b.remove(paramez);
      AppMethodBeat.o(221856);
    }
  }
  
  public final class e
    implements ez
  {
    public List<MapRouteSection> a;
    public List<GeoPoint> b;
    
    public e()
    {
      AppMethodBeat.i(221871);
      mk.this.a(this);
      AppMethodBeat.o(221871);
    }
    
    private void a()
    {
      AppMethodBeat.i(221878);
      mk.this.b(this);
      AppMethodBeat.o(221878);
    }
    
    private void a(List<MapRouteSection> paramList, List<GeoPoint> paramList1)
    {
      AppMethodBeat.i(221885);
      this.a = paramList;
      this.b = paramList1;
      mk.a(mk.this).a(paramList, paramList1);
      AppMethodBeat.o(221885);
    }
    
    private void b()
    {
      AppMethodBeat.i(221894);
      mk.a(mk.this).u();
      this.a = null;
      this.b = null;
      AppMethodBeat.o(221894);
    }
    
    public final void a(Language paramLanguage)
    {
      AppMethodBeat.i(221905);
      if (paramLanguage == Language.zh)
      {
        if ((this.a != null) && (this.b != null))
        {
          mk.a(mk.this).a(this.a, this.b);
          AppMethodBeat.o(221905);
        }
      }
      else {
        mk.a(mk.this).u();
      }
      AppMethodBeat.o(221905);
    }
  }
  
  public final class f
  {
    private final ArrayList<mk.g> b;
    private mk.g c;
    
    private f()
    {
      AppMethodBeat.i(221786);
      this.b = new ArrayList();
      AppMethodBeat.o(221786);
    }
    
    private Bitmap a(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(221821);
      int i = paramInt1 * paramInt2;
      int[] arrayOfInt2 = new int[i];
      int[] arrayOfInt1 = new int[i];
      IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt2);
      localIntBuffer.position(0);
      paramGL10.glReadPixels((mk.d(mk.this).width() - paramInt1) / 2, (mk.d(mk.this).height() - paramInt2) / 2, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
      i = 0;
      while (i < paramInt2)
      {
        int j = 0;
        while (j < paramInt1)
        {
          int k = arrayOfInt2[(i * paramInt1 + j)];
          arrayOfInt1[((paramInt2 - i - 1) * paramInt1 + j)] = (k & 0xFF00FF00 | k << 16 & 0xFF0000 | k >> 16 & 0xFF);
          j += 1;
        }
        i += 1;
      }
      try
      {
        paramGL10 = Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
        AppMethodBeat.o(221821);
        return paramGL10;
      }
      catch (OutOfMemoryError paramGL10)
      {
        for (;;)
        {
          paramGL10 = Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
        }
      }
    }
    
    private void a(eq arg1, Rect paramRect, fg paramfg, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(221792);
      paramRect = new mk.g(mk.this, ???, paramRect, paramfg, paramInt1, paramInt2, (byte)0);
      synchronized (this.b)
      {
        this.b.add(paramRect);
        kh.a("snapshot addSnapshotRequest");
        mk.this.v = true;
        AppMethodBeat.o(221792);
        return;
      }
    }
    
    private void a(mk.g paramg)
    {
      AppMethodBeat.i(221811);
      if ((paramg == null) || (paramg.a()))
      {
        AppMethodBeat.o(221811);
        return;
      }
      paramg.b();
      synchronized (this.b)
      {
        this.b.remove(paramg);
        mk.c(mk.this).f();
        AppMethodBeat.o(221811);
        return;
      }
    }
    
    private mk.g d()
    {
      AppMethodBeat.i(221798);
      mk.g localg = null;
      synchronized (this.b)
      {
        if (this.b.size() > 0) {
          localg = (mk.g)this.b.get(0);
        }
        AppMethodBeat.o(221798);
        return localg;
      }
    }
    
    /* Error */
    public final void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 140
      //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: ldc 142
      //   9: invokestatic 105	com/tencent/mapsdk/internal/kh:a	(Ljava/lang/String;)V
      //   12: aload_0
      //   13: getfield 33	com/tencent/mapsdk/internal/mk$f:b	Ljava/util/ArrayList;
      //   16: astore_1
      //   17: aload_1
      //   18: monitorenter
      //   19: aload_0
      //   20: getfield 33	com/tencent/mapsdk/internal/mk$f:b	Ljava/util/ArrayList;
      //   23: invokevirtual 145	java/util/ArrayList:clear	()V
      //   26: aload_1
      //   27: monitorexit
      //   28: aload_0
      //   29: getfield 147	com/tencent/mapsdk/internal/mk$f:c	Lcom/tencent/mapsdk/internal/mk$g;
      //   32: ifnull +18 -> 50
      //   35: aload_0
      //   36: getfield 147	com/tencent/mapsdk/internal/mk$f:c	Lcom/tencent/mapsdk/internal/mk$g;
      //   39: astore_1
      //   40: aload_1
      //   41: iconst_1
      //   42: putfield 151	com/tencent/mapsdk/internal/mk$g:j	I
      //   45: aload_1
      //   46: iconst_0
      //   47: putfield 154	com/tencent/mapsdk/internal/mk$g:e	I
      //   50: ldc 140
      //   52: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   55: aload_0
      //   56: monitorexit
      //   57: return
      //   58: astore_2
      //   59: aload_1
      //   60: monitorexit
      //   61: ldc 140
      //   63: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_2
      //   67: athrow
      //   68: astore_1
      //   69: aload_0
      //   70: monitorexit
      //   71: aload_1
      //   72: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	f
      //   68	4	1	localObject2	Object
      //   58	9	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   19	28	58	finally
      //   2	19	68	finally
      //   28	50	68	finally
      //   50	55	68	finally
      //   59	68	68	finally
    }
    
    public final void a(GL10 paramGL10)
    {
      try
      {
        AppMethodBeat.i(221880);
        if ((this.c != null) && (!this.c.c()))
        {
          a(paramGL10, this.c.g, this.c.h);
          a(this.c);
        }
        AppMethodBeat.o(221880);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final void a(GL10 paramGL10, mj parammj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 170
      //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 18	com/tencent/mapsdk/internal/mk$f:a	Lcom/tencent/mapsdk/internal/mk;
      //   11: invokestatic 173	com/tencent/mapsdk/internal/mk:a	(Lcom/tencent/mapsdk/internal/mk;)Lcom/tencent/mapsdk/internal/sc;
      //   14: ifnonnull +11 -> 25
      //   17: ldc 170
      //   19: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: aload_0
      //   23: monitorexit
      //   24: return
      //   25: aload_0
      //   26: getfield 147	com/tencent/mapsdk/internal/mk$f:c	Lcom/tencent/mapsdk/internal/mk$g;
      //   29: getfield 176	com/tencent/mapsdk/internal/mk$g:f	Lcom/tencent/mapsdk/internal/eq;
      //   32: astore_3
      //   33: aload_3
      //   34: ifnull +10 -> 44
      //   37: aload_3
      //   38: aload_1
      //   39: invokeinterface 180 2 0
      //   44: aload_2
      //   45: invokevirtual 184	com/tencent/mapsdk/internal/mj:a	()V
      //   48: ldc 170
      //   50: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   53: goto -31 -> 22
      //   56: astore_1
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_1
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	f
      //   0	61	1	paramGL10	GL10
      //   0	61	2	parammj	mj
      //   32	6	3	localeq	eq
      // Exception table:
      //   from	to	target	type
      //   2	22	56	finally
      //   25	33	56	finally
      //   37	44	56	finally
      //   44	53	56	finally
    }
    
    public final boolean b()
    {
      AppMethodBeat.i(221846);
      for (;;)
      {
        synchronized (this.b)
        {
          if (this.b != null) {
            if (this.b.isEmpty())
            {
              break label56;
              AppMethodBeat.o(221846);
              return bool;
            }
            else
            {
              bool = false;
            }
          }
        }
        label56:
        boolean bool = true;
      }
    }
    
    public final mk.g c()
    {
      mk.g localg = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221860);
          this.c = d();
          if (this.c == null)
          {
            AppMethodBeat.o(221860);
            return localg;
          }
          if (this.c.c())
          {
            a(this.c);
            AppMethodBeat.o(221860);
            continue;
          }
          mk.c(mk.this).e();
        }
        finally {}
        Object localObject2 = this.c.i;
        int k = this.c.g;
        int i = this.c.h;
        Rect localRect = new Rect();
        int j = (int)(ha.a(mk.this.getContext()) * 20.0F);
        k = (mk.d(mk.this).width() - k) / 2 + j;
        localRect.right = k;
        localRect.left = k;
        i = (mk.d(mk.this).height() - i) / 2 + j;
        localRect.bottom = i;
        localRect.top = i;
        mk.c(mk.this).c((Rect)localObject2, localRect);
        localObject2 = this.c;
        AppMethodBeat.o(221860);
      }
    }
  }
  
  final class g
  {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    int e = 0;
    eq f;
    int g;
    int h;
    Rect i;
    int j;
    private fg l;
    
    private g(eq parameq, Rect paramRect, fg paramfg, int paramInt1, int paramInt2)
    {
      this.f = parameq;
      this.i = paramRect;
      this.l = paramfg;
      this.g = paramInt1;
      this.h = paramInt2;
      this.j = 0;
    }
    
    private void a(int paramInt)
    {
      this.j = paramInt;
    }
    
    private void d()
    {
      this.j = 1;
      this.e = 0;
    }
    
    private boolean e()
    {
      AppMethodBeat.i(221806);
      StringBuilder localStringBuilder = new StringBuilder("is processing:");
      if (this.j == 3) {}
      for (boolean bool = true;; bool = false)
      {
        kh.a(bool);
        if (this.j != 3) {
          break;
        }
        AppMethodBeat.o(221806);
        return true;
      }
      AppMethodBeat.o(221806);
      return false;
    }
    
    /* Error */
    public final boolean a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 48	com/tencent/mapsdk/internal/mk$g:j	I
      //   6: istore_1
      //   7: iload_1
      //   8: iconst_2
      //   9: if_icmpne +9 -> 18
      //   12: iconst_1
      //   13: istore_2
      //   14: aload_0
      //   15: monitorexit
      //   16: iload_2
      //   17: ireturn
      //   18: iconst_0
      //   19: istore_2
      //   20: goto -6 -> 14
      //   23: astore_3
      //   24: aload_0
      //   25: monitorexit
      //   26: aload_3
      //   27: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	28	0	this	g
      //   6	4	1	m	int
      //   13	7	2	bool	boolean
      //   23	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	23	finally
    }
    
    public final void b()
    {
      try
      {
        this.j = 2;
        this.e = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final boolean c()
    {
      return this.j == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mk
 * JD-Core Version:    0.7.0.1
 */