package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.luggage.a.e;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.CustomLayerOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.OverlayLevel;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.widget.d.c;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.MarkerTranslateAnimator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  implements b
{
  private static final String jTG;
  private static long jTY;
  Context context;
  private ImageView djK;
  protected final SoSoMapView jTA;
  private boolean jTB;
  private b.k jTC;
  private b.o jTD;
  private b.n jTE;
  private b.q jTF;
  private String jTH;
  private String jTI;
  private int jTJ;
  private boolean jTK;
  private boolean jTL;
  private volatile HashMap<String, MarkerTranslateAnimator> jTM;
  private volatile HashMap<String, MarkerTranslateAnimator> jTN;
  SurfaceView jTO;
  private Runnable jTP;
  private b.l jTQ;
  private b.w jTR;
  private b.x jTS;
  private boolean jTT;
  private Runnable jTU;
  private b.v jTV;
  private b.e jTW;
  private Map<String, CustomLayer> jTX;
  private Queue<Runnable> jTZ;
  private String jTy;
  FrameLayout jTz;
  private CancelableCallback jUa;
  public ArrayList<Circle> jUb;
  public ArrayList<b> jUc;
  private Map<String, Polyline> jUd;
  private a jUe;
  private Map<String, d> jUf;
  public ArrayList<c> jUg;
  public ArrayList<Polygon> jUh;
  private boolean jUi;
  private d jUj;
  private com.tencent.mm.plugin.appbrand.utils.b.a.b jUk;
  private final int jUl;
  private AtomicBoolean jUm;
  private AtomicBoolean jUn;
  private long lastCheckTime;
  private int mMapType;
  
  static
  {
    AppMethodBeat.i(146554);
    jTG = com.tencent.mm.plugin.appbrand.aa.b.dW("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    jTY = 500L;
    AppMethodBeat.o(146554);
  }
  
  public a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146490);
    this.jTM = new HashMap();
    this.jTN = new HashMap();
    this.jTP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146485);
        a.this.jTO.setVisibility(4);
        AppMethodBeat.o(146485);
      }
    };
    this.jTT = false;
    this.jTX = new ConcurrentHashMap();
    this.jTZ = new LinkedList();
    this.jUa = new CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(146463);
        a.o(a.this).poll();
        if (!a.o(a.this).isEmpty()) {
          ((Runnable)a.o(a.this).peek()).run();
        }
        AppMethodBeat.o(146463);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(146462);
        a.o(a.this).poll();
        if (!a.o(a.this).isEmpty()) {
          ((Runnable)a.o(a.this).peek()).run();
        }
        AppMethodBeat.o(146462);
      }
    };
    this.jUb = new ArrayList();
    this.jUc = new ArrayList();
    this.jUd = new ConcurrentHashMap();
    this.jUe = new a();
    this.jUf = new ConcurrentHashMap();
    this.jUg = new ArrayList();
    this.jUh = new ArrayList();
    this.jUk = new com.tencent.mm.plugin.appbrand.utils.b.a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, final com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(193607);
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(193607);
          return;
        }
        ad.d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude) });
        if (!a.baE())
        {
          ad.w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
          AppMethodBeat.o(193607);
          return;
        }
        if ((!a.n(a.this)) || (a.t(a.this)))
        {
          AppMethodBeat.o(193607);
          return;
        }
        l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193606);
            d locald;
            double d1;
            double d2;
            if (a.this.jTA != null)
            {
              if (a.c(a.this) == null)
              {
                a.a(a.this, new d(a.q(a.this)));
                locald = a.c(a.this);
                localObject = a.this.jTA;
                com.tencent.mm.plugin.appbrand.utils.b.a.a locala = paramAnonymousa;
                MarkerOptions localMarkerOptions = new MarkerOptions();
                localMarkerOptions.anchor(0.5F, 0.5F);
                localMarkerOptions.position(new LatLng(locala.latitude, locala.longitude));
                localMarkerOptions.markerView(locald);
                localMarkerOptions.zIndex(2147483647);
                localMarkerOptions.flat(true);
                localMarkerOptions.tag("AnchorPoint");
                locald.jUM = ((SoSoMapView)localObject).getMap().addMarker(localMarkerOptions);
              }
              locald = a.c(a.this);
              d1 = paramAnonymousa.latitude;
              d2 = paramAnonymousa.longitude;
              Object localObject = paramAnonymousa.provider;
              double d3 = paramAnonymousa.cWS;
              if ((locald.jVz != -1.0D) || (locald.jVA != -1.0D)) {
                break label398;
              }
              locald.jVz = d1;
              locald.jVx = d1;
              locald.jVA = d2;
              locald.jVy = d2;
              if ((locald.jVz != -1.0D) && (locald.jVA != -1.0D)) {
                locald.jVE = f.a(locald.jVA, locald.jVz, d2, d1, (String)localObject, d3);
              }
              if ((locald.jVC != 900.0F) && (locald.jVB != 900.0F)) {
                break label433;
              }
              float f = (float)f.h(d1, d2);
              locald.jVB = f;
              locald.jVC = f;
            }
            for (;;)
            {
              if (locald.jUM != null) {
                locald.jUM.setPosition(new LatLng(d1, d2));
              }
              AppMethodBeat.o(193606);
              return;
              label398:
              locald.jVz = locald.jVx;
              locald.jVA = locald.jVy;
              locald.jVy = d2;
              locald.jVx = d1;
              break;
              label433:
              locald.jVC = locald.jVB;
              locald.jVB = ((float)f.h(d1, d2));
            }
          }
        });
        AppMethodBeat.o(193607);
      }
    };
    this.lastCheckTime = 0L;
    this.jUl = 500;
    this.jUm = new AtomicBoolean(false);
    this.jUn = new AtomicBoolean(false);
    this.context = paramContext;
    this.jTy = paramString;
    this.jTz = new FrameLayout(paramContext);
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.jTz.setBackgroundColor(0);
    this.jTz.setLayoutParams(paramString);
    this.jTA = new SoSoMapView(paramContext, G(paramMap));
    this.jTz.addView(this.jTA, new FrameLayout.LayoutParams(-1, -1));
    this.djK = new ImageView(paramContext);
    this.djK.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jTz.addView(this.djK, new ViewGroup.LayoutParams(-1, -1));
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s, init", new Object[] { this });
    this.jTA.getMap().setInfoWindowAdapter(this.jUe);
    this.jTA.getMap().setMapAnchor(0.5F, 0.5F);
    this.jTA.getMap().enableMultipleInfowindow(true);
    this.jTA.getMap().setMapStyle(this.jTJ);
    paramContext = this.jTA.getMap();
    if (this.jTL) {}
    for (int i = 1008;; i = 1000)
    {
      paramContext.setMapType(i);
      this.jTA.getMap().setHandDrawMapEnable(this.jTK);
      this.jTA.getMap().setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener()
      {
        public final void onInfoWindowClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146458);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146458);
            return;
          }
          paramAnonymousMarker = a.this.Ik((String)paramAnonymousMarker.getTag());
          if (paramAnonymousMarker == null)
          {
            ad.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          if (a.a(a.this) == null)
          {
            ad.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          a.a(a.this).a(paramAnonymousMarker);
          AppMethodBeat.o(146458);
        }
      });
      this.jTA.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146468);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146468);
            return false;
          }
          ad.i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", new Object[] { this, paramAnonymousMarker.getTag() });
          if (bt.isNullOrNil((String)paramAnonymousMarker.getTag()))
          {
            ad.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
            AppMethodBeat.o(146468);
            return true;
          }
          if (((String)paramAnonymousMarker.getTag()).endsWith("AnchorPoint"))
          {
            if ((a.b(a.this) != null) && (a.c(a.this) != null))
            {
              ad.w("MicroMsg.DefaultTencentMapView", "click anchor point");
              a.b(a.this).d(a.c(a.this).getLatitude(), a.c(a.this).getLongitude());
            }
            AppMethodBeat.o(146468);
            return true;
          }
          a.d locald = a.this.Ik((String)paramAnonymousMarker.getTag());
          if (locald == null)
          {
            ad.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return true;
          }
          if (a.d(a.this) == null)
          {
            ad.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return true;
          }
          Object localObject;
          if (locald.jVe != null)
          {
            localObject = locald.jVe.jVi;
            if ((localObject == null) || (((b.t.a)localObject).jVp != b.t.a.jVs)) {
              break label405;
            }
            if (locald.jUM.isInfoWindowShown()) {
              break label393;
            }
            a.a(a.this, locald);
          }
          for (;;)
          {
            if (locald.jUM != null) {
              locald.jUM.set2Top();
            }
            if (locald.jUN != null) {
              locald.jUN.set2Top();
            }
            if (a.c(a.this) != null)
            {
              localObject = a.c(a.this);
              if (((d)localObject).jUM != null) {
                ((d)localObject).jUM.set2Top();
              }
            }
            if (!((String)paramAnonymousMarker.getTag()).endsWith("#label")) {
              break;
            }
            ad.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
            bool = a.e(a.this).c(locald);
            AppMethodBeat.o(146468);
            return bool;
            label393:
            locald.jUM.hideInfoWindow();
            continue;
            label405:
            if (localObject != null) {
              a.a(a.this, locald);
            }
          }
          boolean bool = a.d(a.this).b(locald);
          AppMethodBeat.o(146468);
          return bool;
        }
      });
      this.jTA.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener()
      {
        public final void onMapClick(LatLng paramAnonymousLatLng)
        {
          AppMethodBeat.i(146478);
          Iterator localIterator = a.f(a.this).values().iterator();
          while (localIterator.hasNext())
          {
            a.d locald = (a.d)localIterator.next();
            if ((locald.jVe != null) && (locald.jVe.jVi != null) && (locald.jVe.jVi.jVp == b.t.a.jVs) && (locald.jUM.isInfoWindowShown())) {
              locald.jUM.hideInfoWindow();
            }
          }
          if (a.g(a.this) != null)
          {
            a.g(a.this).e(paramAnonymousLatLng.getLongitude(), paramAnonymousLatLng.getLatitude());
            AppMethodBeat.o(146478);
            return;
          }
          AppMethodBeat.o(146478);
        }
      });
      this.jTA.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener()
      {
        public final void onMapLoaded()
        {
          AppMethodBeat.i(146479);
          if (a.h(a.this) != null) {
            a.h(a.this);
          }
          a.i(a.this);
          AppMethodBeat.o(146479);
        }
      });
      this.jTA.getMap().setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener()
      {
        public final void onClicked(MapPoi paramAnonymousMapPoi)
        {
          AppMethodBeat.i(146480);
          if (a.j(a.this) != null)
          {
            b.r localr = new b.r();
            localr.latitude = paramAnonymousMapPoi.getPosition().getLatitude();
            localr.longitude = paramAnonymousMapPoi.getPosition().getLongitude();
            localr.name = paramAnonymousMapPoi.getName();
            if (((paramAnonymousMapPoi instanceof IndoorMapPoi)) && (!bt.isNullOrNil(((IndoorMapPoi)paramAnonymousMapPoi).getBuildingId())))
            {
              localr.buildingId = ((IndoorMapPoi)paramAnonymousMapPoi).getBuildingId();
              localr.floorName = ((IndoorMapPoi)paramAnonymousMapPoi).getFloorName();
            }
            a.j(a.this).a(localr);
          }
          AppMethodBeat.o(146480);
        }
      });
      this.jTA.getMap().setOnIndoorStateChangeListener(new TencentMap.OnIndoorStateChangeListener()
      {
        public final boolean onIndoorBuildingDeactivated()
        {
          AppMethodBeat.i(146483);
          ad.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
          if (a.k(a.this) != null)
          {
            b.e locale = a.baC();
            a.a(a.this, locale);
            a.k(a.this).a(locale);
          }
          AppMethodBeat.o(146483);
          return true;
        }
        
        public final boolean onIndoorBuildingFocused()
        {
          AppMethodBeat.i(146481);
          ad.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingFocused]");
          AppMethodBeat.o(146481);
          return true;
        }
        
        public final boolean onIndoorLevelActivated(IndoorBuilding paramAnonymousIndoorBuilding)
        {
          AppMethodBeat.i(146482);
          ad.v("MicroMsg.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", new Object[] { paramAnonymousIndoorBuilding });
          if (a.k(a.this) != null)
          {
            b.e locale = new b.e();
            locale.buildingId = paramAnonymousIndoorBuilding.getBuidlingId();
            locale.buildingName = paramAnonymousIndoorBuilding.getBuildingName();
            locale.jUT = new LinkedList();
            Iterator localIterator = paramAnonymousIndoorBuilding.getLevels().iterator();
            while (localIterator.hasNext())
            {
              IndoorLevel localIndoorLevel = (IndoorLevel)localIterator.next();
              b.f localf = new b.f();
              localf.floorName = localIndoorLevel.getName();
              locale.jUT.add(localf);
            }
            locale.jUU = paramAnonymousIndoorBuilding.getActiveLevelIndex();
            a.a(a.this, locale);
            a.k(a.this).a(locale);
          }
          AppMethodBeat.o(146482);
          return true;
        }
      });
      ad.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
      this.jTA.onCreate(null);
      onResume();
      AppMethodBeat.o(146490);
      return;
    }
  }
  
  private void W(Runnable paramRunnable)
  {
    AppMethodBeat.i(146524);
    this.jTZ.add(paramRunnable);
    if (this.jTZ.size() == 1) {
      paramRunnable.run();
    }
    AppMethodBeat.o(146524);
  }
  
  private static CameraUpdate a(TencentMap paramTencentMap, float paramFloat1, float paramFloat2, float paramFloat3, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146523);
    if ((paramFloat1 == -1.0F) && (paramFloat2 == -1.0F) && (paramFloat3 == -1.0F) && (paramDouble1 != -1.0D) && (paramDouble2 != -1.0D))
    {
      paramTencentMap = CameraUpdateFactory.newLatLng(new LatLng(paramDouble1, paramDouble2));
      AppMethodBeat.o(146523);
      return paramTencentMap;
    }
    Object localObject = paramTencentMap.getCameraPosition();
    localObject = new CameraPosition.Builder((CameraPosition)localObject).bearing(((CameraPosition)localObject).getBearing()).skew(((CameraPosition)localObject).getSkew());
    ad.v("MicroMsg.DefaultTencentMapView", "tencentMap.getCameraPosition:%s rotate:%f skew:%f", new Object[] { paramTencentMap.getCameraPosition(), Float.valueOf(paramTencentMap.getCameraPosition().getBearing()), Float.valueOf(paramTencentMap.getCameraPosition().getSkew()) });
    if (paramFloat1 != -1.0F) {
      ((CameraPosition.Builder)localObject).zoom(paramFloat1);
    }
    if (paramFloat2 != -1.0F) {
      ((CameraPosition.Builder)localObject).bearing(paramFloat2);
    }
    if (paramFloat3 != -1.0F) {
      ((CameraPosition.Builder)localObject).skew(paramFloat3);
    }
    if ((paramDouble1 != -1.0D) && (paramDouble2 != -1.0D)) {
      ((CameraPosition.Builder)localObject).target(new LatLng(paramDouble1, paramDouble2));
    }
    paramTencentMap = CameraUpdateFactory.newCameraPosition(((CameraPosition.Builder)localObject).build());
    AppMethodBeat.o(146523);
    return paramTencentMap;
  }
  
  private static void a(float paramFloat1, float paramFloat2, Bitmap paramBitmap, ImageView paramImageView)
  {
    AppMethodBeat.i(146537);
    if (paramImageView == null)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "markerIcon is null, err");
      AppMethodBeat.o(146537);
      return;
    }
    float f;
    if (paramFloat1 != 0.0F)
    {
      f = paramFloat1;
      paramFloat1 = paramFloat2;
      if (paramFloat2 != 0.0F) {}
    }
    else
    {
      f = com.tencent.mm.plugin.appbrand.aa.g.um(paramBitmap.getWidth());
      paramFloat1 = com.tencent.mm.plugin.appbrand.aa.g.um(paramBitmap.getHeight());
    }
    if ((f > 0.0F) && (paramFloat1 > 0.0F) && ((f != paramBitmap.getWidth()) || (paramFloat1 != paramBitmap.getHeight())))
    {
      paramFloat2 = f / paramBitmap.getWidth();
      paramFloat1 /= paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat2, paramFloat1);
      paramImageView.setImageBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true));
      AppMethodBeat.o(146537);
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
    paramImageView.setScaleType(ImageView.ScaleType.CENTER);
    AppMethodBeat.o(146537);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(182817);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramd.jUM.showInfoWindow();
      AppMethodBeat.o(182817);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146473);
        paramd.jUM.showInfoWindow();
        AppMethodBeat.o(146473);
      }
    });
    AppMethodBeat.o(182817);
  }
  
  private void a(String paramString, d paramd)
  {
    AppMethodBeat.i(146538);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.jUf.put(paramString, paramd);
    AppMethodBeat.o(146538);
  }
  
  private Bundle baB()
  {
    AppMethodBeat.i(146545);
    Bundle localBundle = new Bundle();
    if (!jTG.equals(this.jTH))
    {
      String str = bt.nullAsNil(localBundle.getString("smallAppKey"));
      localBundle.putString("smallAppKey", str + this.jTH + "#" + this.jTI + ";");
    }
    AppMethodBeat.o(146545);
    return localBundle;
  }
  
  private static b.e bao()
  {
    AppMethodBeat.i(146492);
    b.e locale = new b.e();
    locale.buildingId = "";
    locale.buildingName = "";
    locale.jUT = new LinkedList();
    locale.jUU = -1;
    AppMethodBeat.o(146492);
    return locale;
  }
  
  private void bap()
  {
    AppMethodBeat.i(146496);
    if (this.jTO == null) {
      this.jTO = getSurfaceView();
    }
    if (this.jTO != null)
    {
      aq.az(this.jTP);
      this.jTO.setVisibility(0);
      AppMethodBeat.o(146496);
      return;
    }
    ad.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
    AppMethodBeat.o(146496);
  }
  
  private SurfaceView getSurfaceView()
  {
    AppMethodBeat.i(146495);
    if (this.jTO != null)
    {
      localSurfaceView = this.jTO;
      AppMethodBeat.o(146495);
      return localSurfaceView;
    }
    this.jTO = i(this.jTA);
    SurfaceView localSurfaceView = this.jTO;
    AppMethodBeat.o(146495);
    return localSurfaceView;
  }
  
  private static SurfaceView i(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(146548);
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() == 0))
    {
      AppMethodBeat.o(146548);
      return null;
    }
    int j = paramViewGroup.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label85;
      }
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof SurfaceView))
      {
        paramViewGroup = (SurfaceView)localView;
        AppMethodBeat.o(146548);
        return paramViewGroup;
      }
      if ((localView instanceof ViewGroup))
      {
        paramViewGroup = (ViewGroup)localView;
        break;
      }
      i += 1;
    }
    label85:
    AppMethodBeat.o(146548);
    return null;
  }
  
  public final void D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146546);
    if ((!this.jUi) || (this.jTB))
    {
      AppMethodBeat.o(146546);
      return;
    }
    if (this.jUj != null) {
      this.jUj.D(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(146546);
  }
  
  protected TencentMapOptions G(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146491);
    TencentMapOptions localTencentMapOptions = new TencentMapOptions();
    if (paramMap == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "params is null, return");
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
    }
    String str = f.a(paramMap, "theme", "normal");
    this.jTK = str.equals("handDraw");
    this.mMapType = f.a(paramMap, "mapType", 1);
    localTencentMapOptions.setMapType(this.mMapType);
    this.jTH = f.a(paramMap, "subKey", "");
    this.jTI = f.a(paramMap, "subId", "");
    boolean bool;
    if (f.a(paramMap, "enableDarkMode", 0) == 1)
    {
      bool = true;
      this.jTL = bool;
      if (!bt.isNullOrNil(this.jTH)) {
        break label288;
      }
      this.jTH = jTG;
      this.jTI = "";
    }
    for (;;)
    {
      localTencentMapOptions.setSubInfo(this.jTH, this.jTI);
      this.jTJ = f.a(paramMap, "styleId", 0);
      ad.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.jTI, this.jTH });
      ad.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d enableDarkmode:%b", new Object[] { str, Boolean.valueOf(this.jTK), Integer.valueOf(this.mMapType), this.jTI, this.jTH, Integer.valueOf(this.jTJ), Boolean.valueOf(this.jTL) });
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
      bool = false;
      break;
      label288:
      this.jTL = false;
    }
  }
  
  public final void Ih(String paramString)
  {
    AppMethodBeat.i(182814);
    CustomLayer localCustomLayer1 = this.jTA.getMap().addCustomLayer(new CustomLayerOptions().layerId(paramString));
    if (localCustomLayer1 != null)
    {
      ad.v("MicroMsg.DefaultTencentMapView", "addCustomLayer success, layerId:%s", new Object[] { paramString });
      CustomLayer localCustomLayer2 = (CustomLayer)this.jTX.remove(paramString);
      if (localCustomLayer2 != null) {
        localCustomLayer2.remove();
      }
      this.jTX.put(paramString, localCustomLayer1);
      AppMethodBeat.o(182814);
      return;
    }
    ad.e("MicroMsg.DefaultTencentMapView", "addCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182814);
  }
  
  public final void Ii(String paramString)
  {
    AppMethodBeat.i(182815);
    CustomLayer localCustomLayer = (CustomLayer)this.jTX.remove(paramString);
    if (localCustomLayer != null)
    {
      ad.v("MicroMsg.DefaultTencentMapView", "removeCustomLayer success, layerId:%s", new Object[] { paramString });
      localCustomLayer.remove();
      AppMethodBeat.o(182815);
      return;
    }
    ad.e("MicroMsg.DefaultTencentMapView", "removeCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182815);
  }
  
  public final boolean Ij(String paramString)
  {
    AppMethodBeat.i(146530);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", new Object[] { this, paramString });
    Polyline localPolyline = (Polyline)this.jUd.get(paramString);
    if (localPolyline == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146530);
      return false;
    }
    localPolyline.remove();
    this.jUd.remove(paramString);
    AppMethodBeat.o(146530);
    return true;
  }
  
  public final d Ik(String paramString)
  {
    AppMethodBeat.i(146533);
    paramString = (d)this.jUf.get(paramString);
    AppMethodBeat.o(146533);
    return paramString;
  }
  
  public final boolean Il(String paramString)
  {
    AppMethodBeat.i(146535);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    d locald = (d)this.jUf.get(paramString);
    if (locald == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146535);
      return false;
    }
    locald.jUM.remove();
    if (locald.jUN != null)
    {
      if ((locald.jUN.getMarkerView() != null) && ((locald.jUN.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.d.d)locald.jUN.getMarkerView());
      }
      locald.jUN.remove();
      this.jUf.remove(paramString + "#label");
    }
    locald.jUO = null;
    this.jUf.remove(paramString);
    AppMethodBeat.o(146535);
    return true;
  }
  
  public final void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(146521);
    a(paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramFloat3, false);
    AppMethodBeat.o(146521);
  }
  
  public final void a(final double paramDouble1, double paramDouble2, final float paramFloat1, final float paramFloat2, final float paramFloat3, boolean paramBoolean)
  {
    AppMethodBeat.i(146522);
    ad.v("MicroMsg.DefaultTencentMapView", "start map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    if ((paramFloat1 == -1.0F) && (paramFloat2 == -1.0F) && (paramFloat3 == -1.0F) && (paramDouble1 == -1.0D) && (paramDouble2 == -1.0D))
    {
      AppMethodBeat.o(146522);
      return;
    }
    final TencentMap localTencentMap = this.jTA.getMap();
    if (localTencentMap != null)
    {
      if (paramBoolean)
      {
        W(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146464);
            CameraUpdate localCameraUpdate = a.b(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, this.heH);
            ad.v("MicroMsg.DefaultTencentMapView", "doing map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(this.heH), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
            localTencentMap.animateCamera(localCameraUpdate, a.baD(), a.p(a.this));
            AppMethodBeat.o(146464);
          }
        });
        AppMethodBeat.o(146522);
        return;
      }
      localTencentMap.moveCamera(a(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, paramDouble2));
    }
    AppMethodBeat.o(146522);
  }
  
  public final void a(b.b arg1)
  {
    AppMethodBeat.i(146526);
    Object localObject1 = new CircleOptions();
    ((CircleOptions)localObject1).center(new LatLng(???.latitude, ???.longitude));
    ((CircleOptions)localObject1).radius(???.radius);
    ((CircleOptions)localObject1).strokeColor(???.strokeColor);
    ((CircleOptions)localObject1).strokeWidth(???.strokeWidth);
    ((CircleOptions)localObject1).fillColor(???.fillColor);
    localObject1 = this.jTA.getMap().addCircle((CircleOptions)localObject1);
    synchronized (this.jUb)
    {
      this.jUb.add(localObject1);
      AppMethodBeat.o(146526);
      return;
    }
  }
  
  public final void a(b.j paramj, com.tencent.mm.plugin.appbrand.g.a parama)
  {
    AppMethodBeat.i(146531);
    Object localObject = new PolylineOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramj.jUZ.iterator();
    while (localIterator.hasNext())
    {
      b.h localh = (b.h)localIterator.next();
      localArrayList.add(new LatLng(localh.latitude, localh.longitude));
    }
    ((PolylineOptions)localObject).addAll(localArrayList);
    if (paramj.style != -1) {
      ((PolylineOptions)localObject).color(paramj.style);
    }
    for (;;)
    {
      ((PolylineOptions)localObject).width(paramj.width);
      ((PolylineOptions)localObject).setDottedLine(paramj.jVa);
      ((PolylineOptions)localObject).edgeColor(paramj.borderColor);
      ((PolylineOptions)localObject).edgeWidth(paramj.borderWidth);
      if (paramj.jVb)
      {
        parama = parama.bR(paramj.jVc);
        ((PolylineOptions)localObject).arrowTexture(new BitmapDescriptor(parama));
        if (parama == null) {
          ((PolylineOptions)localObject).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), 2131230986)));
        }
      }
      ((PolylineOptions)localObject).zIndex(1.0F);
      if ((!bt.isNullOrNil(paramj.buildingId)) && (!bt.isNullOrNil(paramj.floorName))) {
        ((PolylineOptions)localObject).indoorInfo(new IndoorInfo(paramj.buildingId, paramj.floorName));
      }
      ((PolylineOptions)localObject).arrowGap(paramj.jVd);
      ((PolylineOptions)localObject).level(OverlayLevel.OverlayLevelAboveLabels);
      localObject = this.jTA.getMap().addPolyline((PolylineOptions)localObject);
      if (localObject != null) {
        break;
      }
      ad.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
      AppMethodBeat.o(146531);
      return;
      ((PolylineOptions)localObject).color(paramj.color);
    }
    if (bt.isNullOrNil(paramj.id)) {}
    for (parama = paramj.hashCode();; parama = paramj.id)
    {
      this.jUd.put(bt.by(parama, paramj.toString()), localObject);
      AppMethodBeat.o(146531);
      return;
    }
  }
  
  public final void a(b.k paramk)
  {
    this.jTC = paramk;
  }
  
  public final void a(b.l paraml)
  {
    this.jTQ = paraml;
  }
  
  public final void a(b.n paramn)
  {
    this.jTE = paramn;
  }
  
  public final void a(b.o paramo)
  {
    this.jTD = paramo;
  }
  
  public final void a(b.q paramq)
  {
    this.jTF = paramq;
  }
  
  public final void a(final b.u paramu)
  {
    AppMethodBeat.i(146499);
    this.jTA.getMap().setTencentMapGestureListener(new TencentMap.TencentMapGestureListener()
    {
      public final boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(146486);
        a.a(a.this, true);
        AppMethodBeat.o(146486);
        return false;
      }
      
      public final boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final void onMapStable()
      {
        AppMethodBeat.i(146487);
        a.a(a.this, false);
        AppMethodBeat.o(146487);
      }
      
      public final boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
    });
    this.jTA.getMap().setOnMapCameraChangeListener(new TencentMap.OnMapCameraChangeListener()
    {
      public final void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(146459);
        if (paramu != null)
        {
          b.a locala = new b.a();
          locala.jUP = new b.h(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.jUQ = paramAnonymousCameraPosition.getBearing();
          locala.skew = paramAnonymousCameraPosition.getSkew();
          paramu.a(locala, a.m(a.this));
        }
        AppMethodBeat.o(146459);
      }
      
      public final void onCameraChangeFinish(CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(146460);
        if (paramu != null)
        {
          b.a locala = new b.a();
          locala.jUP = new b.h(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.jUQ = paramAnonymousCameraPosition.getBearing();
          locala.skew = paramAnonymousCameraPosition.getSkew();
          paramu.b(locala, a.m(a.this));
        }
        a.i(a.this);
        AppMethodBeat.o(146460);
      }
    });
    AppMethodBeat.o(146499);
  }
  
  public final void a(b.v paramv)
  {
    this.jTV = paramv;
  }
  
  public final void a(b.x paramx)
  {
    this.jTS = paramx;
  }
  
  public final void a(String paramString, int paramInt, b.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(146532);
    Polyline localPolyline = (Polyline)this.jUd.get(paramString);
    if (localPolyline == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146532);
      return;
    }
    localPolyline.setEraseable(paramBoolean);
    localPolyline.eraseTo(paramInt, new LatLng(paramh.latitude, paramh.longitude));
    AppMethodBeat.o(146532);
  }
  
  public final void a(String paramString, b.t paramt)
  {
    AppMethodBeat.i(182816);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s updateMarker markerId:%s", new Object[] { this, paramString });
    final d locald = Ik(paramString);
    if (locald != null) {
      if (paramt.jVi != null)
      {
        if (paramt.jVi.view == null) {
          break label519;
        }
        locald.jVe.jVi = paramt.jVi;
        if (paramt.jVi.jVp != b.t.a.jVt) {
          break label481;
        }
        a(locald);
      }
    }
    label519:
    for (;;)
    {
      if (paramt.jVj != null)
      {
        locald.jUN.remove();
        Il(paramString + "#label");
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new LatLng(paramt.latitude, paramt.longitude));
        localMarkerOptions.alpha(paramt.alpha);
        com.tencent.mm.plugin.appbrand.widget.d.d locald2 = i.baG();
        com.tencent.mm.plugin.appbrand.widget.d.d locald1 = locald2;
        if (locald2 == null) {
          locald1 = new com.tencent.mm.plugin.appbrand.widget.d.d(this.context);
        }
        locald1.reset();
        locald1.setTextColor(paramt.jVj.color);
        locald1.setTextSize(paramt.jVj.jVk);
        locald1.setText(paramt.jVj.content);
        locald1.setTextPadding(paramt.jVj.padding);
        locald1.setGravity(paramt.jVj.iZu);
        locald1.z(paramt.jVj.jVl, paramt.jVj.borderWidth, paramt.jVj.borderColor, paramt.jVj.bgColor);
        locald1.setX(paramt.jVj.x);
        locald1.setY(paramt.jVj.y);
        locald1.measure(0, 0);
        localMarkerOptions.anchor(locald1.getAnchorX(), locald1.getAnchorY());
        localMarkerOptions.markerView(locald1);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramt.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!bt.isNullOrNil(paramt.buildingId)) && (!bt.isNullOrNil(paramt.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramt.buildingId, paramt.floorName));
        }
        locald.jUN = this.jTA.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", locald);
      }
      AppMethodBeat.o(182816);
      return;
      label481:
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        locald.jUM.refreshInfoWindow();
      }
      else
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182805);
            locald.jUM.refreshInfoWindow();
            AppMethodBeat.o(182805);
          }
        });
        continue;
        locald.jUO = null;
      }
    }
  }
  
  public final void a(final String paramString, b.t paramt, com.tencent.mm.plugin.appbrand.g.a parama)
  {
    AppMethodBeat.i(146536);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    if (this.jUn.get())
    {
      ad.e("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s fail", new Object[] { this, paramString });
      AppMethodBeat.o(146536);
      return;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new LatLng(paramt.latitude, paramt.longitude));
    if (!bt.isNullOrNil(paramt.title)) {
      localMarkerOptions.title(paramt.title);
    }
    if (!bt.isNullOrNil(paramt.jVh)) {
      localMarkerOptions.contentDescription(paramt.jVh);
    }
    localMarkerOptions.rotation(paramt.jUQ);
    localMarkerOptions.alpha(paramt.alpha);
    final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493687, null);
    final ImageView localImageView = (ImageView)localFrameLayout.findViewById(2131302158);
    final float f1 = paramt.jVf;
    final float f2 = paramt.jVg;
    d locald = null;
    Object localObject = locald;
    if (parama != null)
    {
      localObject = locald;
      if (!bt.isNullOrNil(paramt.jUR))
      {
        if (localImageView != null) {
          localImageView.setImageBitmap(null);
        }
        localObject = parama.a(paramt.jUR, null, new com.tencent.mm.plugin.appbrand.g.a.b()
        {
          public final void M(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(146470);
            if (paramAnonymousBitmap != null)
            {
              a.b(f1, f2, paramAnonymousBitmap, localImageView);
              if ((a.this.Ik(paramString) != null) && (a.this.Ik(paramString).jUM != null))
              {
                ad.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                a.this.Ik(paramString).jUM.setMarkerView(localFrameLayout);
              }
            }
            AppMethodBeat.o(146470);
          }
        });
      }
    }
    if (localObject != null) {
      a(f1, f2, (Bitmap)localObject, localImageView);
    }
    for (;;)
    {
      localMarkerOptions.markerView(localFrameLayout);
      localMarkerOptions.anchor(paramt.anchorX, paramt.anchorY);
      localMarkerOptions.tag(paramString);
      localMarkerOptions.infoWindowHideAnimation(new Animation() {});
      localMarkerOptions.infoWindowShowAnimation(new Animation() {});
      localMarkerOptions.visible(true);
      localMarkerOptions.zIndex(paramt.zIndex + 2);
      localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
      if ((!bt.isNullOrNil(paramt.buildingId)) && (!bt.isNullOrNil(paramt.floorName))) {
        localMarkerOptions.indoorInfo(new IndoorInfo(paramt.buildingId, paramt.floorName));
      }
      if (paramt.jVi != null) {
        localMarkerOptions.infoWindowOffset(paramt.jVi.jVq, paramt.jVi.jVr);
      }
      parama = this.jTA.getMap().addMarker(localMarkerOptions);
      locald = new d();
      locald.jUM = parama;
      locald.data = paramt.data;
      locald.jVe = paramt;
      a(paramString, locald);
      if ((paramt.jVi != null) && (paramt.jVi.jVp == b.t.a.jVt)) {
        a(locald);
      }
      if (paramt.jVj != null)
      {
        localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new LatLng(paramt.latitude, paramt.longitude));
        localMarkerOptions.alpha(paramt.alpha);
        localObject = i.baG();
        parama = (com.tencent.mm.plugin.appbrand.g.a)localObject;
        if (localObject == null) {
          parama = new com.tencent.mm.plugin.appbrand.widget.d.d(this.context);
        }
        parama.reset();
        parama.setTextColor(paramt.jVj.color);
        parama.setTextSize(paramt.jVj.jVk);
        parama.setText(paramt.jVj.content);
        parama.setTextPadding(paramt.jVj.padding);
        parama.setGravity(paramt.jVj.iZu);
        parama.z(paramt.jVj.jVl, paramt.jVj.borderWidth, paramt.jVj.borderColor, paramt.jVj.bgColor);
        parama.setX(paramt.jVj.x);
        parama.setY(paramt.jVj.y);
        parama.measure(0, 0);
        localMarkerOptions.anchor(parama.getAnchorX(), parama.getAnchorY());
        localMarkerOptions.markerView(parama);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramt.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!bt.isNullOrNil(paramt.buildingId)) && (!bt.isNullOrNil(paramt.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramt.buildingId, paramt.floorName));
        }
        locald.jUN = this.jTA.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", locald);
      }
      AppMethodBeat.o(146536);
      return;
      ad.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
    }
  }
  
  public final void a(final String paramString, ArrayList<b.h> arg2, long paramLong, boolean paramBoolean, b.p arg6)
  {
    AppMethodBeat.i(193610);
    d locald = Ik(paramString);
    if ((locald == null) || (locald.jUM == null))
    {
      ad.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      ???.fX(false);
      AppMethodBeat.o(193610);
      return;
    }
    if (???.size() <= 0)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      ???.fX(false);
      AppMethodBeat.o(193610);
      return;
    }
    synchronized (this.jTM)
    {
      if (this.jTM.containsKey(paramString)) {
        l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193597);
            this.jUG.cancelAnimation();
            AppMethodBeat.o(193597);
          }
        });
      }
      ??? = new LatLng[???.size()];
      ??? = ???.iterator();
      int i = 0;
      if (???.hasNext())
      {
        b.h localh = (b.h)???.next();
        ???[i] = new LatLng(localh.latitude, localh.longitude);
        i += 1;
      }
    }
    ??? = new MarkerTranslateAnimator(locald.jUM, paramLong, (LatLng[])???, paramBoolean);
    ???.addAnimatorListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(193600);
        ad.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationCancel");
        if (paramp != null) {
          paramp.bal();
        }
        synchronized (a.r(a.this))
        {
          a.r(a.this).remove(paramString);
          AppMethodBeat.o(193600);
          return;
        }
      }
      
      public final void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(193599);
        ad.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationEnd");
        if (paramp != null) {
          paramp.fX(true);
        }
        synchronized (a.r(a.this))
        {
          a.r(a.this).remove(paramString);
          AppMethodBeat.o(193599);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193598);
        ad.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationStart");
        AppMethodBeat.o(193598);
      }
    });
    synchronized (this.jTM)
    {
      this.jTM.put(paramString, ???);
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193601);
          ad.d("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator start");
          paramArrayList.startAnimation();
          AppMethodBeat.o(193601);
        }
      });
      if (locald.jUN != null)
      {
        ad.d("MicroMsg.DefaultTencentMapView", "labelMarker do move animator");
        synchronized (this.jTN)
        {
          if (this.jTN.containsKey(paramString)) {
            l.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(193602);
                this.jUG.cancelAnimation();
                AppMethodBeat.o(193602);
              }
            });
          }
          ??? = new MarkerTranslateAnimator(locald.jUN, paramLong, (LatLng[])???, paramBoolean);
          ???.addAnimatorListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator arg1)
            {
              AppMethodBeat.i(193604);
              synchronized (a.s(a.this))
              {
                a.s(a.this).remove(paramString);
                AppMethodBeat.o(193604);
                return;
              }
            }
            
            public final void onAnimationEnd(Animator arg1)
            {
              AppMethodBeat.i(193603);
              synchronized (a.s(a.this))
              {
                a.s(a.this).remove(paramString);
                AppMethodBeat.o(193603);
                return;
              }
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          });
        }
      }
    }
    synchronized (this.jTN)
    {
      this.jTN.put(paramString, ???);
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193605);
          paramp.startAnimation();
          AppMethodBeat.o(193605);
        }
      });
      AppMethodBeat.o(193610);
      return;
      paramString = finally;
      AppMethodBeat.o(193610);
      throw paramString;
      paramString = finally;
      AppMethodBeat.o(193610);
      throw paramString;
    }
  }
  
  public final void a(String paramString, LinkedList<b.g> paramLinkedList, final b.p paramp)
  {
    AppMethodBeat.i(146539);
    paramString = Ik(paramString);
    if ((paramString == null) || (paramString.jUM == null))
    {
      ad.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      paramp.fX(false);
      AppMethodBeat.o(146539);
      return;
    }
    if (paramLinkedList.size() <= 0)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      paramp.fX(false);
      AppMethodBeat.o(146539);
      return;
    }
    Object localObject = (b.g)paramLinkedList.get(0);
    ((b.g)localObject).jUW = paramString.jUM.getPosition().getLatitude();
    ((b.g)localObject).jUV = paramString.jUM.getPosition().getLongitude();
    int j = paramLinkedList.size();
    int i = 1;
    if (i < j)
    {
      localObject = (b.g)paramLinkedList.get(i - 1);
      b.g localg = (b.g)paramLinkedList.get(i);
      if (((b.g)localObject).jUQ == 0.0F) {
        localg.jUV = ((b.g)localObject).longitude;
      }
      for (localg.jUW = ((b.g)localObject).latitude;; localg.jUW = paramString.jUM.getPosition().getLatitude())
      {
        i += 1;
        break;
        localg.jUV = paramString.jUM.getPosition().getLongitude();
      }
    }
    localObject = new c(paramLinkedList, paramString.jUM, this.jTA);
    paramp = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(182807);
        ad.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
        if (paramp != null) {
          paramp.fX(true);
        }
        AppMethodBeat.o(182807);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(182806);
        ad.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
        AppMethodBeat.o(182806);
      }
    };
    ((c)localObject).uc.addListener(paramp);
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(182808);
        this.jUE.uc.start();
        AppMethodBeat.o(182808);
      }
    });
    if (paramString.jUN != null) {
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182809);
          this.jUF.uc.start();
          AppMethodBeat.o(182809);
        }
      });
    }
    AppMethodBeat.o(146539);
  }
  
  public final boolean a(final b.c paramc, final b.m paramm, final com.tencent.mm.plugin.appbrand.g.a parama)
  {
    AppMethodBeat.i(146528);
    if (bt.isNullOrNil(paramc.jUR))
    {
      AppMethodBeat.o(146528);
      return false;
    }
    Object localObject = parama.bR(paramc.jUR);
    if (localObject == null)
    {
      AppMethodBeat.o(146528);
      return false;
    }
    parama = new ImageView(this.context);
    parama.setScaleType(ImageView.ScaleType.FIT_XY);
    parama.setImageBitmap((Bitmap)localObject);
    int k = paramc.left;
    int m = paramc.top;
    int i;
    if (paramc.height == 0)
    {
      i = com.tencent.mm.plugin.appbrand.aa.g.um(((Bitmap)localObject).getHeight());
      if (paramc.width != 0) {
        break label217;
      }
    }
    label217:
    for (int j = com.tencent.mm.plugin.appbrand.aa.g.um(((Bitmap)localObject).getWidth());; j = paramc.width)
    {
      localObject = new FrameLayout.LayoutParams(j, i);
      ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
      final boolean bool = paramc.jUS;
      paramc = paramc.data;
      parama.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(146466);
          int i;
          if (bool)
          {
            i = paramAnonymousMotionEvent.getAction();
            if (i != 0) {
              break label40;
            }
            parama.setColorFilter(Color.parseColor("#88888888"));
          }
          for (;;)
          {
            AppMethodBeat.o(146466);
            return false;
            label40:
            if ((i == 3) || (i == 1)) {
              parama.clearColorFilter();
            }
          }
        }
      });
      parama.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(146467);
          if ((bool) && (paramm != null)) {
            paramm.Ig(paramc);
          }
          AppMethodBeat.o(146467);
        }
      });
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(146469);
          ((ViewGroup)a.this.jTz).addView(parama, this.jUw);
          synchronized (a.this.jUc)
          {
            a.this.jUc.add(new a.b(a.this, parama));
            AppMethodBeat.o(146469);
            return;
          }
        }
      });
      AppMethodBeat.o(146528);
      return true;
      i = paramc.height;
      break;
    }
  }
  
  public final boolean a(b.d arg1, com.tencent.mm.plugin.appbrand.g.a parama)
  {
    AppMethodBeat.i(146541);
    if (bt.isNullOrNil(???.jUR))
    {
      AppMethodBeat.o(146541);
      return false;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new LatLng(???.latitude, ???.longitude));
    parama = parama.bR(???.jUR);
    if ((parama != null) && (!parama.isRecycled())) {
      localMarkerOptions.icon(new BitmapDescriptor(parama));
    }
    localMarkerOptions.rotation(???.jUQ);
    parama = this.jTA.getMap().addMarker(localMarkerOptions);
    synchronized (this.jUg)
    {
      this.jUg.add(new c(parama));
      AppMethodBeat.o(146541);
      return true;
    }
  }
  
  public final boolean a(b.y arg1)
  {
    AppMethodBeat.i(146543);
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.jUZ.iterator();
    while (localIterator.hasNext())
    {
      b.h localh = (b.h)localIterator.next();
      localArrayList.add(new LatLng(localh.latitude, localh.longitude));
    }
    ((PolygonOptions)localObject1).addAll(localArrayList);
    ((PolygonOptions)localObject1).fillColor(???.fillColor);
    ((PolygonOptions)localObject1).strokeColor(???.strokeColor);
    ((PolygonOptions)localObject1).strokeWidth(???.strokeWidth);
    ((PolygonOptions)localObject1).zIndex(???.zIndex);
    localObject1 = this.jTA.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.jUh)
    {
      this.jUh.add(localObject1);
      AppMethodBeat.o(146543);
      return true;
    }
  }
  
  public final void baA()
  {
    AppMethodBeat.i(146542);
    synchronized (this.jUh)
    {
      Iterator localIterator = this.jUh.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.jUh.clear();
    AppMethodBeat.o(146542);
  }
  
  public final b.z baq()
  {
    AppMethodBeat.i(146498);
    Object localObject2 = this.jTA.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.i();
    ((b.i)localObject1).jUX = new b.h(((LatLngBounds)localObject2).getSouthwest().getLatitude(), ((LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.i)localObject1).jUY = new b.h(((LatLngBounds)localObject2).getNortheast().getLatitude(), ((LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.aa();
    ((b.aa)localObject2).jVv = ((b.i)localObject1);
    localObject1 = new b.z();
    ((b.z)localObject1).jVu = ((b.aa)localObject2);
    AppMethodBeat.o(146498);
    return localObject1;
  }
  
  public final void bar()
  {
    AppMethodBeat.i(146501);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.jTU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146461);
        if ((a.c(a.this) != null) && (a.n(a.this)))
        {
          double d1 = a.c(a.this).getLatitude();
          double d2 = a.c(a.this).getLongitude();
          a.this.jTA.getIController().animateTo(d1, d2);
          ad.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        }
        AppMethodBeat.o(146461);
      }
    };
    if ((this.jUj != null) && (this.jUi))
    {
      this.jTU.run();
      this.jTU = null;
    }
    AppMethodBeat.o(146501);
  }
  
  public final b.e bas()
  {
    AppMethodBeat.i(146515);
    if (this.jTW != null)
    {
      locale = this.jTW;
      AppMethodBeat.o(146515);
      return locale;
    }
    b.e locale = bao();
    AppMethodBeat.o(146515);
    return locale;
  }
  
  public boolean bat()
  {
    return false;
  }
  
  public final b.h bau()
  {
    AppMethodBeat.i(146519);
    Object localObject = this.jTA.getMap().getMapCenter();
    localObject = new b.h(((LatLng)localObject).getLatitude(), ((LatLng)localObject).getLongitude());
    AppMethodBeat.o(146519);
    return localObject;
  }
  
  public final void bav()
  {
    AppMethodBeat.i(146525);
    synchronized (this.jUb)
    {
      Iterator localIterator = this.jUb.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.jUb.clear();
    AppMethodBeat.o(146525);
  }
  
  public final void baw()
  {
    AppMethodBeat.i(146527);
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146465);
        ViewGroup localViewGroup = (ViewGroup)a.this.jTz;
        synchronized (a.this.jUc)
        {
          Iterator localIterator = a.this.jUc.iterator();
          if (localIterator.hasNext()) {
            localViewGroup.removeView(((a.b)localIterator.next()).jUL);
          }
        }
        a.this.jUc.clear();
        AppMethodBeat.o(146465);
      }
    });
    AppMethodBeat.o(146527);
  }
  
  public final void bax()
  {
    AppMethodBeat.i(146529);
    Iterator localIterator = this.jUd.values().iterator();
    while (localIterator.hasNext()) {
      ((Polyline)localIterator.next()).remove();
    }
    this.jUd.clear();
    AppMethodBeat.o(146529);
  }
  
  public final void bay()
  {
    AppMethodBeat.i(146534);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.jUf.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      locald.jUM.remove();
      if (locald.jUN != null)
      {
        if ((locald.jUN.getMarkerView() != null) && ((locald.jUN.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.d.d)locald.jUN.getMarkerView());
        }
        locald.jUN.remove();
      }
    }
    this.jUf.clear();
    AppMethodBeat.o(146534);
  }
  
  public final void baz()
  {
    AppMethodBeat.i(146540);
    synchronized (this.jUg)
    {
      Iterator localIterator = this.jUg.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).jUM.remove();
      }
    }
    this.jUg.clear();
    AppMethodBeat.o(146540);
  }
  
  public final void c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(146516);
    LatLng localLatLng = this.jTA.getMap().getMapCenter();
    this.jTA.setMapAnchor(paramFloat1, paramFloat2);
    a(localLatLng.getLatitude(), localLatLng.getLongitude(), -1.0F, -1.0F, -1.0F, paramBoolean);
    AppMethodBeat.o(146516);
  }
  
  public final void cT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146514);
    this.jTA.getMap().setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(146514);
  }
  
  public final void f(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146500);
    a(paramDouble1, paramDouble2, -1.0F, -1.0F, -1.0F, true);
    AppMethodBeat.o(146500);
  }
  
  public final void fY(boolean paramBoolean)
  {
    AppMethodBeat.i(146505);
    this.jTA.getUiSettings().setZoomGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146505);
  }
  
  public final void fZ(boolean paramBoolean)
  {
    AppMethodBeat.i(146506);
    this.jTA.getUiSettings().setScrollGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146506);
  }
  
  public void g(SurfaceTexture paramSurfaceTexture) {}
  
  public final void ga(boolean paramBoolean)
  {
    AppMethodBeat.i(146507);
    this.jTA.getUiSettings().setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146507);
  }
  
  public final void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(146508);
    this.jTA.getUiSettings().setCompassEnabled(paramBoolean);
    AppMethodBeat.o(146508);
  }
  
  public final void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(146509);
    this.jTA.getMap().set3DEnable(paramBoolean);
    AppMethodBeat.o(146509);
  }
  
  public final void gd(boolean paramBoolean)
  {
    AppMethodBeat.i(146510);
    this.jTA.getUiSettings().setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146510);
  }
  
  public final void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(146511);
    this.jTA.getMap().setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(146511);
  }
  
  public final float getRotate()
  {
    AppMethodBeat.i(146503);
    float f = this.jTA.getMap().getCameraPosition().getBearing();
    AppMethodBeat.o(146503);
    return f;
  }
  
  public final float getSkew()
  {
    AppMethodBeat.i(146504);
    float f = this.jTA.getMap().getCameraPosition().getSkew();
    AppMethodBeat.o(146504);
    return f;
  }
  
  public final View getView()
  {
    return this.jTz;
  }
  
  public final float getZoom()
  {
    AppMethodBeat.i(193609);
    float f = this.jTA.getMap().getCameraPosition().getZoom();
    AppMethodBeat.o(193609);
    return f;
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(146512);
    this.jTA.getMap().setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(146512);
  }
  
  public final void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(146513);
    this.jTA.getMap().setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(146513);
  }
  
  public final void gh(boolean paramBoolean)
  {
    AppMethodBeat.i(146517);
    this.jTA.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
    AppMethodBeat.o(146517);
  }
  
  public final void gi(boolean paramBoolean)
  {
    AppMethodBeat.i(146518);
    this.jTA.getUiSettings().setScaleControlsEnabled(paramBoolean);
    AppMethodBeat.o(146518);
  }
  
  public final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(146544);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.jUi = paramBoolean;
    d locald;
    if (paramBoolean)
    {
      if (this.jUj != null)
      {
        locald = this.jUj;
        if (locald.jUM != null) {
          locald.jUM.setVisible(true);
        }
      }
      ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.jUk, baB());
      g.a(this);
      AppMethodBeat.o(146544);
      return;
    }
    if (this.jUj != null)
    {
      locald = this.jUj;
      if (locald.jUM != null) {
        locald.jUM.setVisible(false);
      }
    }
    ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.jUk, baB());
    g.b(this);
    AppMethodBeat.o(146544);
  }
  
  public final void h(List<b.h> paramList, int paramInt)
  {
    AppMethodBeat.i(146520);
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.h localh = (b.h)paramList.next();
      localLinkedList.add(new LatLng(localh.latitude, localh.longitude));
    }
    localBuilder.include(localLinkedList);
    this.jTA.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.jTU = null;
    AppMethodBeat.o(146520);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(146497);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.jUn.set(true);
    this.jTA.getMap().setOnMapCameraChangeListener(null);
    bay();
    bax();
    bax();
    baw();
    baz();
    baA();
    Object localObject = this.jTX.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CustomLayer)((Iterator)localObject).next()).remove();
    }
    this.jTX.clear();
    if (this.jTA != null)
    {
      this.jTA.getMap().setOnMapPoiClickListener(null);
      this.jTA.clean();
      this.jTA.onDestroy();
    }
    if (this.jUj != null)
    {
      localObject = this.jUj;
      if (((d)localObject).jUM != null)
      {
        ((d)localObject).jUM.remove();
        ((d)localObject).jUM = null;
      }
      this.jUj = null;
    }
    AppMethodBeat.o(146497);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(146494);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.djK.setVisibility(0);
      if (this.jTO == null) {
        this.jTO = getSurfaceView();
      }
      if (this.jTO != null)
      {
        aq.n(this.jTP, 100L);
        this.jTA.setVisibility(4);
        this.jTA.getMap().getScreenShot(new TencentMap.OnScreenShotListener()
        {
          public final void onMapScreenShot(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(146484);
            if (paramAnonymousBitmap != null) {
              a.l(a.this).setImageBitmap(paramAnonymousBitmap);
            }
            AppMethodBeat.o(146484);
          }
        });
      }
    }
    for (;;)
    {
      this.jTB = true;
      if (this.jUi)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.jUk, baB());
        g.b(this);
      }
      AppMethodBeat.o(146494);
      return;
      ad.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
      break;
      this.jTA.onPause();
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(146493);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.djK.setVisibility(4);
      this.jTA.setVisibility(0);
      this.jTA.onResume();
      bap();
    }
    for (;;)
    {
      this.jTB = false;
      if (this.jUi)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.jUk, baB());
        g.a(this);
      }
      AppMethodBeat.o(146493);
      return;
      this.jTA.onResume();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2) {}
  
  public void onTouchEvent(MotionEvent paramMotionEvent) {}
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(182813);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s setMapStyle: %d", new Object[] { this, Integer.valueOf(paramInt) });
    this.jTA.getMap().setMapStyle(paramInt);
    AppMethodBeat.o(182813);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146547);
    String str = "DefaultTencentMapView{mapId=" + this.jTy + '}';
    AppMethodBeat.o(146547);
    return str;
  }
  
  public final class a
    implements TencentMap.InfoWindowAdapter
  {
    public a() {}
    
    public final View getInfoWindow(Marker paramMarker)
    {
      AppMethodBeat.i(146488);
      if (paramMarker == null)
      {
        AppMethodBeat.o(146488);
        return null;
      }
      if (bt.isNullOrNil((String)paramMarker.getTag()))
      {
        ad.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (((String)paramMarker.getTag()).endsWith("#label"))
      {
        AppMethodBeat.o(146488);
        return null;
      }
      paramMarker = a.this.Ik((String)paramMarker.getTag());
      if (paramMarker == null)
      {
        ad.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (paramMarker.jVe == null)
      {
        ad.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      b.t.a locala = paramMarker.jVe.jVi;
      if (locala == null)
      {
        AppMethodBeat.o(146488);
        return null;
      }
      if (locala.view != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view is %b", new Object[] { paramMarker, Boolean.valueOf(bool) });
        if (locala.view == null) {
          break;
        }
        if (paramMarker.jUO == null) {
          paramMarker.jUO = new ImageView(a.q(a.this));
        }
        localObject = com.tencent.mm.sdk.platformtools.f.fy(locala.view);
        if (localObject == null) {
          ad.e("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view exist but bitmap is null");
        }
        paramMarker.jUO.setImageBitmap((Bitmap)localObject);
        paramMarker = paramMarker.jUO;
        AppMethodBeat.o(146488);
        return paramMarker;
      }
      a locala1 = a.this;
      Object localObject = i.baF();
      paramMarker = (Marker)localObject;
      if (localObject == null) {
        paramMarker = new com.tencent.mm.plugin.appbrand.widget.d.b(locala1.context);
      }
      paramMarker.setText("");
      paramMarker.setTextSize(12);
      paramMarker.setTextColor(com.tencent.mm.plugin.appbrand.widget.d.b.mhj);
      paramMarker.setTitlePadding(0);
      paramMarker.setGravity("center");
      int i = com.tencent.mm.plugin.appbrand.widget.d.b.mhk;
      paramMarker.z(0, 0, i, i);
      paramMarker.setText(locala.content);
      paramMarker.setTextSize(locala.jVk);
      paramMarker.setTextColor(locala.color);
      paramMarker.setTitlePadding(locala.padding);
      paramMarker.setGravity(locala.iZu);
      paramMarker.z(locala.jVl, locala.borderWidth, locala.borderColor, locala.bgColor);
      AppMethodBeat.o(146488);
      return paramMarker;
    }
    
    public final void onInfoWindowDettached(Marker paramMarker, View paramView)
    {
      AppMethodBeat.i(146489);
      if ((paramView instanceof com.tencent.mm.plugin.appbrand.widget.d.b))
      {
        ad.d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
        i.a((com.tencent.mm.plugin.appbrand.widget.d.b)paramView);
      }
      AppMethodBeat.o(146489);
    }
  }
  
  public final class b
  {
    ImageView jUL;
    
    public b(ImageView paramImageView)
    {
      this.jUL = paramImageView;
    }
  }
  
  public final class c
  {
    Marker jUM;
    
    public c(Marker paramMarker)
    {
      this.jUM = paramMarker;
    }
  }
  
  public static final class d
    extends b.s
  {
    public Marker jUM;
    public Marker jUN;
    public ImageView jUO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a
 * JD-Core Version:    0.7.0.1
 */