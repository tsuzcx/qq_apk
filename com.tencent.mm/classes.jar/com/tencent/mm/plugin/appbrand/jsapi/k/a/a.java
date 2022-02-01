package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
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
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.widget.e.c;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.MarkerTranslateAnimator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterItemClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  implements b
{
  private static final String lYC;
  private static long lZa;
  FrameLayout container;
  Context context;
  private ImageView dKU;
  private b.o lYA;
  private b.s lYB;
  private String lYD;
  private String lYE;
  private int lYF;
  private boolean lYG;
  private boolean lYH;
  private volatile HashMap<String, MarkerTranslateAnimator> lYI;
  private volatile HashMap<String, MarkerTranslateAnimator> lYJ;
  private volatile ClusterManager<f> lYK;
  private DefaultClusterRenderer<f> lYL;
  private boolean lYM;
  private boolean lYN;
  SurfaceView lYO;
  private Runnable lYP;
  private b.m lYQ;
  private b.y lYR;
  private b.z lYS;
  private boolean lYT;
  private b.w lYU;
  private Runnable lYV;
  private b.x lYW;
  private b.f lYX;
  private Map<String, CustomLayer> lYY;
  private ArrayList<String> lYZ;
  private String lYv;
  protected final SoSoMapView lYw;
  private boolean lYx;
  private b.l lYy;
  private b.p lYz;
  private HashMap<String, GroundOverlay> lZA;
  private Queue<Runnable> lZb;
  private CancelableCallback lZc;
  public ArrayList<Circle> lZd;
  public ArrayList<b> lZe;
  private Map<String, Polyline> lZf;
  private a lZg;
  private Map<String, g> lZh;
  public ArrayList<c> lZi;
  public ArrayList<Polygon> lZj;
  private boolean lZk;
  private d lZl;
  private com.tencent.mm.plugin.appbrand.utils.b.a.b lZm;
  private final int lZn;
  private AtomicBoolean lZo;
  private AtomicBoolean lZp;
  private b.q lZq;
  private ArrayList<f> lZr;
  private ArrayList<String> lZs;
  private ArrayList<Integer> lZt;
  private AtomicInteger lZu;
  private HashMap<Integer, Cluster<f>> lZv;
  private HashMap<String, b.v> lZw;
  private com.tencent.mm.plugin.appbrand.f.a lZx;
  boolean lZy;
  boolean lZz;
  private long lastCheckTime;
  private int mMapType;
  
  static
  {
    AppMethodBeat.i(146554);
    lYC = com.tencent.mm.plugin.appbrand.ac.b.eM("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    lZa = 500L;
    AppMethodBeat.o(146554);
  }
  
  public a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146490);
    this.lYI = new HashMap();
    this.lYJ = new HashMap();
    this.lYM = false;
    this.lYN = false;
    this.lYP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146485);
        a.this.lYO.setVisibility(4);
        AppMethodBeat.o(146485);
      }
    };
    this.lYT = false;
    this.lYY = new ConcurrentHashMap();
    this.lYZ = new ArrayList();
    this.lZb = new LinkedList();
    this.lZc = new CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(146463);
        a.s(a.this).poll();
        if (!a.s(a.this).isEmpty()) {
          ((Runnable)a.s(a.this).peek()).run();
        }
        AppMethodBeat.o(146463);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(146462);
        a.s(a.this).poll();
        if (!a.s(a.this).isEmpty()) {
          ((Runnable)a.s(a.this).peek()).run();
        }
        AppMethodBeat.o(146462);
      }
    };
    this.lZd = new ArrayList();
    this.lZe = new ArrayList();
    this.lZf = new ConcurrentHashMap();
    this.lZg = new a();
    this.lZh = new ConcurrentHashMap();
    this.lZi = new ArrayList();
    this.lZj = new ArrayList();
    this.lZm = new com.tencent.mm.plugin.appbrand.utils.b.a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, final com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(217212);
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(217212);
          return;
        }
        Log.d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude) });
        if (!a.bHl())
        {
          Log.w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
          AppMethodBeat.o(217212);
          return;
        }
        if ((!a.r(a.this)) || (a.x(a.this)))
        {
          AppMethodBeat.o(217212);
          return;
        }
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217211);
            d locald;
            double d1;
            double d2;
            if (a.this.lYw != null)
            {
              if (a.d(a.this) == null)
              {
                a.a(a.this, new d(a.u(a.this)));
                locald = a.d(a.this);
                localObject = a.this.lYw;
                com.tencent.mm.plugin.appbrand.utils.b.a.a locala = paramAnonymousa;
                MarkerOptions localMarkerOptions = new MarkerOptions();
                localMarkerOptions.anchor(0.5F, 0.5F);
                localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(locala.latitude, locala.longitude));
                localMarkerOptions.markerView(locald);
                localMarkerOptions.zIndex(2147483647);
                localMarkerOptions.flat(true);
                localMarkerOptions.tag("AnchorPoint");
                locald.maj = ((SoSoMapView)localObject).getMap().addMarker(localMarkerOptions);
              }
              locald = a.d(a.this);
              d1 = paramAnonymousa.latitude;
              d2 = paramAnonymousa.longitude;
              Object localObject = paramAnonymousa.provider;
              double d3 = paramAnonymousa.dxQ;
              if ((locald.mbj != -1.0D) || (locald.mbk != -1.0D)) {
                break label398;
              }
              locald.mbj = d1;
              locald.mbh = d1;
              locald.mbk = d2;
              locald.mbi = d2;
              if ((locald.mbj != -1.0D) && (locald.mbk != -1.0D)) {
                locald.mbo = f.a(locald.mbk, locald.mbj, d2, d1, (String)localObject, d3);
              }
              if ((locald.mbm != 900.0F) && (locald.mbl != 900.0F)) {
                break label433;
              }
              float f = (float)f.h(d1, d2);
              locald.mbl = f;
              locald.mbm = f;
            }
            for (;;)
            {
              if (locald.maj != null) {
                locald.maj.setPosition(new com.tencent.mapsdk.raster.model.LatLng(d1, d2));
              }
              AppMethodBeat.o(217211);
              return;
              label398:
              locald.mbj = locald.mbh;
              locald.mbk = locald.mbi;
              locald.mbi = d2;
              locald.mbh = d1;
              break;
              label433:
              locald.mbm = locald.mbl;
              locald.mbl = ((float)f.h(d1, d2));
            }
          }
        });
        AppMethodBeat.o(217212);
      }
    };
    this.lastCheckTime = 0L;
    this.lZn = 500;
    this.lZo = new AtomicBoolean(false);
    this.lZp = new AtomicBoolean(false);
    this.lZr = new ArrayList();
    this.lZs = new ArrayList();
    this.lZt = new ArrayList();
    this.lZu = new AtomicInteger(100);
    this.lZv = new HashMap();
    this.lZw = new HashMap();
    this.lZA = new HashMap();
    this.context = paramContext;
    this.lYv = paramString;
    this.container = new FrameLayout(paramContext);
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.container.setBackgroundColor(0);
    this.container.setLayoutParams(paramString);
    this.lYw = new SoSoMapView(paramContext, P(paramMap));
    this.container.addView(this.lYw, new FrameLayout.LayoutParams(-1, -1));
    this.dKU = new ImageView(paramContext);
    this.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
    this.container.addView(this.dKU, new ViewGroup.LayoutParams(-1, -1));
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s, init", new Object[] { this });
    this.lYw.getMap().setInfoWindowAdapter(this.lZg);
    this.lYw.getMap().setMapAnchor(0.5F, 0.5F);
    this.lYw.getMap().enableMultipleInfowindow(true);
    this.lYw.getMap().setMapStyle(this.lYF);
    paramContext = this.lYw.getMap();
    if (this.lYH) {}
    for (int i = 1008;; i = 1000)
    {
      paramContext.setMapType(i);
      this.lYw.getMap().setHandDrawMapEnable(this.lYG);
      this.lYw.getMap().setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener()
      {
        public final void onInfoWindowClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146458);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146458);
            return;
          }
          paramAnonymousMarker = a.this.ZU((String)paramAnonymousMarker.getTag());
          if (paramAnonymousMarker == null)
          {
            Log.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          if (a.a(a.this) == null)
          {
            Log.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          a.a(a.this).a(paramAnonymousMarker);
          AppMethodBeat.o(146458);
        }
      });
      this.lYw.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146468);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146468);
            return false;
          }
          Log.i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", new Object[] { this, paramAnonymousMarker.getTag() });
          if ((Util.isNullOrNil((String)paramAnonymousMarker.getTag())) && (a.b(a.this) != null) && (((a.e)a.b(a.this).getRenderer()).getCluster(paramAnonymousMarker) != null))
          {
            paramAnonymousMarker = ((a.e)a.b(a.this).getRenderer()).getCluster(paramAnonymousMarker);
            bool = a.this.b(paramAnonymousMarker);
            AppMethodBeat.o(146468);
            return bool;
          }
          if (Util.isNullOrNil((String)paramAnonymousMarker.getTag()))
          {
            Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
            AppMethodBeat.o(146468);
            return false;
          }
          if (((String)paramAnonymousMarker.getTag()).endsWith("AnchorPoint"))
          {
            if ((a.c(a.this) != null) && (a.d(a.this) != null))
            {
              Log.w("MicroMsg.DefaultTencentMapView", "click anchor point");
              a.c(a.this).d(a.d(a.this).getLatitude(), a.d(a.this).getLongitude());
            }
            AppMethodBeat.o(146468);
            return true;
          }
          a.g localg = a.this.ZU((String)paramAnonymousMarker.getTag());
          if (localg == null)
          {
            Log.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return false;
          }
          if (a.e(a.this) == null)
          {
            Log.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return false;
          }
          if (localg.maM != null)
          {
            if (!((String)paramAnonymousMarker.getTag()).endsWith("#label")) {
              break label443;
            }
            Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, do nothing");
          }
          for (;;)
          {
            if (localg.maj != null) {
              localg.maj.set2Top();
            }
            if (localg.maq != null) {
              localg.maq.set2Top();
            }
            Object localObject;
            if (a.d(a.this) != null)
            {
              localObject = a.d(a.this);
              if (((d)localObject).maj != null) {
                ((d)localObject).maj.set2Top();
              }
            }
            if (localg.maM.mao <= 0) {
              break;
            }
            a.a(a.this, localg.maM.mao);
            AppMethodBeat.o(146468);
            return true;
            label443:
            b.v.a locala = localg.maM.maR;
            if (localg.maj != null) {
              localObject = localg.maj;
            }
            for (;;)
            {
              if ((locala != null) && (locala.maY == b.v.a.mbb) && (localObject != null))
              {
                if (!((Marker)localObject).isInfoWindowShown())
                {
                  a.a(a.this, (Marker)localObject);
                  break;
                  localObject = paramAnonymousMarker;
                  continue;
                }
                ((Marker)localObject).hideInfoWindow();
                break;
              }
            }
            if ((locala != null) && (localObject != null)) {
              a.a(a.this, (Marker)localObject);
            }
          }
          if (((String)paramAnonymousMarker.getTag()).endsWith("#label"))
          {
            Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
            bool = a.f(a.this).c(localg);
            AppMethodBeat.o(146468);
            return bool;
          }
          boolean bool = a.e(a.this).b(localg);
          AppMethodBeat.o(146468);
          return bool;
        }
      });
      this.lYw.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener()
      {
        public final void onMapClick(com.tencent.mapsdk.raster.model.LatLng paramAnonymousLatLng)
        {
          AppMethodBeat.i(146478);
          Iterator localIterator = a.g(a.this).values().iterator();
          while (localIterator.hasNext())
          {
            a.g localg = (a.g)localIterator.next();
            if ((localg.maM != null) && (localg.maM.maR != null) && (localg.maM.maR.maY == b.v.a.mbb) && (localg.maj != null) && (localg.maj.isInfoWindowShown())) {
              localg.maj.hideInfoWindow();
            }
          }
          if (a.h(a.this) != null)
          {
            a.h(a.this).e(paramAnonymousLatLng.getLongitude(), paramAnonymousLatLng.getLatitude());
            AppMethodBeat.o(146478);
            return;
          }
          AppMethodBeat.o(146478);
        }
      });
      this.lYw.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener()
      {
        public final void onMapLoaded()
        {
          AppMethodBeat.i(146479);
          if (a.i(a.this) != null) {
            a.i(a.this);
          }
          a.j(a.this);
          a.k(a.this);
          if (a.l(a.this).size() > 0)
          {
            Object localObject = new ArrayList();
            ((ArrayList)localObject).addAll(a.l(a.this));
            localObject = ((ArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              a.this.ZR(str);
            }
            a.l(a.this).clear();
          }
          AppMethodBeat.o(146479);
        }
      });
      this.lYw.getMap().setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener()
      {
        public final void onClicked(MapPoi paramAnonymousMapPoi)
        {
          AppMethodBeat.i(146480);
          if (a.m(a.this) != null)
          {
            b.t localt = new b.t();
            localt.latitude = paramAnonymousMapPoi.getPosition().getLatitude();
            localt.longitude = paramAnonymousMapPoi.getPosition().getLongitude();
            localt.name = paramAnonymousMapPoi.getName();
            if (((paramAnonymousMapPoi instanceof IndoorMapPoi)) && (!Util.isNullOrNil(((IndoorMapPoi)paramAnonymousMapPoi).getBuildingId())))
            {
              localt.buildingId = ((IndoorMapPoi)paramAnonymousMapPoi).getBuildingId();
              localt.floorName = ((IndoorMapPoi)paramAnonymousMapPoi).getFloorName();
            }
            a.m(a.this).a(localt);
          }
          AppMethodBeat.o(146480);
        }
      });
      this.lYw.getMap().setOnIndoorStateChangeListener(new TencentMap.OnIndoorStateChangeListener()
      {
        public final boolean onIndoorBuildingDeactivated()
        {
          AppMethodBeat.i(146483);
          Log.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
          if (a.n(a.this) != null)
          {
            b.f localf = a.bHj();
            a.a(a.this, localf);
            a.n(a.this).a(localf);
          }
          AppMethodBeat.o(146483);
          return true;
        }
        
        public final boolean onIndoorBuildingFocused()
        {
          AppMethodBeat.i(146481);
          Log.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingFocused]");
          AppMethodBeat.o(146481);
          return true;
        }
        
        public final boolean onIndoorLevelActivated(IndoorBuilding paramAnonymousIndoorBuilding)
        {
          AppMethodBeat.i(146482);
          Log.v("MicroMsg.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", new Object[] { paramAnonymousIndoorBuilding });
          if (a.n(a.this) != null)
          {
            b.f localf = new b.f();
            localf.buildingId = paramAnonymousIndoorBuilding.getBuidlingId();
            localf.buildingName = paramAnonymousIndoorBuilding.getBuildingName();
            localf.maA = new LinkedList();
            Iterator localIterator = paramAnonymousIndoorBuilding.getLevels().iterator();
            while (localIterator.hasNext())
            {
              IndoorLevel localIndoorLevel = (IndoorLevel)localIterator.next();
              b.g localg = new b.g();
              localg.floorName = localIndoorLevel.getName();
              localf.maA.add(localg);
            }
            localf.maB = paramAnonymousIndoorBuilding.getActiveLevelIndex();
            a.a(a.this, localf);
            a.n(a.this).a(localf);
          }
          AppMethodBeat.o(146482);
          return true;
        }
      });
      Log.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
      this.lYw.onCreate(null);
      onResume();
      AppMethodBeat.o(146490);
      return;
    }
  }
  
  private f ZX(String paramString)
  {
    AppMethodBeat.i(217241);
    Iterator localIterator = this.lZr.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (paramString.contains(f.a(localf)))
      {
        AppMethodBeat.o(217241);
        return localf;
      }
    }
    AppMethodBeat.o(217241);
    return null;
  }
  
  private static int ZY(String paramString)
  {
    AppMethodBeat.i(217249);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(217249);
      return -1;
    }
    int i;
    if (paramString.equals("abovelabels"))
    {
      i = OverlayLevel.OverlayLevelAboveLabels;
      AppMethodBeat.o(217249);
      return i;
    }
    if (paramString.equals("abovebuildings"))
    {
      i = OverlayLevel.OverlayLevelAboveBuildings;
      AppMethodBeat.o(217249);
      return i;
    }
    if (paramString.equals("aboveroads"))
    {
      i = OverlayLevel.OverlayLevelAboveRoads;
      AppMethodBeat.o(217249);
      return i;
    }
    AppMethodBeat.o(217249);
    return -1;
  }
  
  private static CameraUpdate a(TencentMap paramTencentMap, float paramFloat1, float paramFloat2, float paramFloat3, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146523);
    if ((paramFloat1 == -1.0F) && (paramFloat2 == -1.0F) && (paramFloat3 == -1.0F) && (paramDouble1 != -1.0D) && (paramDouble2 != -1.0D))
    {
      paramTencentMap = CameraUpdateFactory.newLatLng(new com.tencent.mapsdk.raster.model.LatLng(paramDouble1, paramDouble2));
      AppMethodBeat.o(146523);
      return paramTencentMap;
    }
    Object localObject = paramTencentMap.getCameraPosition();
    localObject = new CameraPosition.Builder((CameraPosition)localObject).bearing(((CameraPosition)localObject).getBearing()).skew(((CameraPosition)localObject).getSkew());
    Log.v("MicroMsg.DefaultTencentMapView", "tencentMap.getCameraPosition:%s rotate:%f skew:%f", new Object[] { paramTencentMap.getCameraPosition(), Float.valueOf(paramTencentMap.getCameraPosition().getBearing()), Float.valueOf(paramTencentMap.getCameraPosition().getSkew()) });
    if (paramFloat1 != -1.0F)
    {
      ((CameraPosition.Builder)localObject).zoom(paramFloat1);
      Log.i("MicroMsg.DefaultTencentMapView", "map_scale zoom:%f", new Object[] { Float.valueOf(paramFloat1) });
    }
    if (paramFloat2 != -1.0F) {
      ((CameraPosition.Builder)localObject).bearing(paramFloat2);
    }
    if (paramFloat3 != -1.0F) {
      ((CameraPosition.Builder)localObject).skew(paramFloat3);
    }
    if ((paramDouble1 != -1.0D) && (paramDouble2 != -1.0D)) {
      ((CameraPosition.Builder)localObject).target(new com.tencent.mapsdk.raster.model.LatLng(paramDouble1, paramDouble2));
    }
    paramTencentMap = CameraUpdateFactory.newCameraPosition(((CameraPosition.Builder)localObject).build());
    AppMethodBeat.o(146523);
    return paramTencentMap;
  }
  
  /* Error */
  private org.json.JSONObject a(Cluster<f> paramCluster, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 656
    //   3: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_2
    //   9: ifeq +211 -> 220
    //   12: aload_0
    //   13: getfield 344	com/tencent/mm/plugin/appbrand/jsapi/k/a/a:lZu	Ljava/util/concurrent/atomic/AtomicInteger;
    //   16: invokevirtual 660	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 338	com/tencent/mm/plugin/appbrand/jsapi/k/a/a:lZt	Ljava/util/ArrayList;
    //   24: iload_3
    //   25: invokestatic 665	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 668	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 346	com/tencent/mm/plugin/appbrand/jsapi/k/a/a:lZv	Ljava/util/HashMap;
    //   36: iload_3
    //   37: invokestatic 665	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aload_1
    //   41: invokevirtual 671	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_1
    //   46: invokeinterface 677 1 0
    //   51: invokeinterface 680 1 0
    //   56: astore 4
    //   58: aload 4
    //   60: invokeinterface 514 1 0
    //   65: ifeq +29 -> 94
    //   68: aload 4
    //   70: invokeinterface 518 1 0
    //   75: checkcast 113	com/tencent/mm/plugin/appbrand/jsapi/k/a/a$f
    //   78: iload_3
    //   79: putfield 683	com/tencent/mm/plugin/appbrand/jsapi/k/a/a$f:mao	I
    //   82: goto -24 -> 58
    //   85: astore_1
    //   86: ldc_w 656
    //   89: invokestatic 259	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: areturn
    //   94: new 685	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 686	org/json/JSONObject:<init>	()V
    //   101: astore 4
    //   103: aload 4
    //   105: ldc_w 688
    //   108: iload_3
    //   109: invokevirtual 691	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   112: pop
    //   113: new 685	org/json/JSONObject
    //   116: dup
    //   117: invokespecial 686	org/json/JSONObject:<init>	()V
    //   120: astore 5
    //   122: aload 5
    //   124: ldc_w 693
    //   127: aload_1
    //   128: invokeinterface 697 1 0
    //   133: invokevirtual 701	com/tencent/mapsdk/raster/model/LatLng:getLatitude	()D
    //   136: invokevirtual 704	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 5
    //   142: ldc_w 706
    //   145: aload_1
    //   146: invokeinterface 697 1 0
    //   151: invokevirtual 709	com/tencent/mapsdk/raster/model/LatLng:getLongitude	()D
    //   154: invokevirtual 704	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 711
    //   163: aload 5
    //   165: invokevirtual 714	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: new 643	org/json/JSONArray
    //   172: dup
    //   173: invokespecial 644	org/json/JSONArray:<init>	()V
    //   176: astore 5
    //   178: aload_1
    //   179: invokeinterface 677 1 0
    //   184: invokeinterface 680 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 514 1 0
    //   196: ifeq +64 -> 260
    //   199: aload 5
    //   201: aload_1
    //   202: invokeinterface 518 1 0
    //   207: checkcast 113	com/tencent/mm/plugin/appbrand/jsapi/k/a/a$f
    //   210: invokestatic 521	com/tencent/mm/plugin/appbrand/jsapi/k/a/a$f:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/k/a/a$f;)Ljava/lang/String;
    //   213: invokevirtual 651	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   216: pop
    //   217: goto -27 -> 190
    //   220: aload_1
    //   221: invokeinterface 677 1 0
    //   226: invokeinterface 680 1 0
    //   231: astore 4
    //   233: aload 4
    //   235: invokeinterface 514 1 0
    //   240: ifeq -146 -> 94
    //   243: aload 4
    //   245: invokeinterface 518 1 0
    //   250: checkcast 113	com/tencent/mm/plugin/appbrand/jsapi/k/a/a$f
    //   253: getfield 683	com/tencent/mm/plugin/appbrand/jsapi/k/a/a$f:mao	I
    //   256: istore_3
    //   257: goto -163 -> 94
    //   260: aload 4
    //   262: ldc_w 716
    //   265: aload 5
    //   267: invokevirtual 714	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   270: pop
    //   271: ldc_w 656
    //   274: invokestatic 259	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload 4
    //   279: areturn
    //   280: astore_1
    //   281: goto -195 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	a
    //   0	284	1	paramCluster	Cluster<f>
    //   0	284	2	paramBoolean	boolean
    //   7	250	3	i	int
    //   56	222	4	localObject1	Object
    //   120	146	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	58	85	org/json/JSONException
    //   58	82	85	org/json/JSONException
    //   94	190	85	org/json/JSONException
    //   190	217	85	org/json/JSONException
    //   220	233	85	org/json/JSONException
    //   233	257	85	org/json/JSONException
    //   260	271	85	org/json/JSONException
    //   12	58	280	java/lang/Exception
    //   58	82	280	java/lang/Exception
    //   94	190	280	java/lang/Exception
    //   190	217	280	java/lang/Exception
    //   220	233	280	java/lang/Exception
    //   233	257	280	java/lang/Exception
    //   260	271	280	java/lang/Exception
  }
  
  private static void a(float paramFloat1, float paramFloat2, Bitmap paramBitmap, ImageView paramImageView)
  {
    AppMethodBeat.i(146537);
    if (paramImageView == null)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "markerIcon is null, err");
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
      f = com.tencent.mm.plugin.appbrand.ac.g.zD(paramBitmap.getWidth());
      paramFloat1 = com.tencent.mm.plugin.appbrand.ac.g.zD(paramBitmap.getHeight());
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
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(146538);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.lZh.put(paramString, paramg);
    AppMethodBeat.o(146538);
  }
  
  private void a(String paramString, b.v paramv, g paramg)
  {
    AppMethodBeat.i(217233);
    if (ZU(paramString + "#label") != null)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "addLabelMarker label is exist, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(217233);
      return;
    }
    if (paramv.maS == null)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "addLabelMarker labelStyle is null, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(217233);
      return;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
    Object localObject2 = i.bHn();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.appbrand.widget.e.d(this.context);
    }
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).reset();
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).setTextColor(paramv.maS.color);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).setTextSize(paramv.maS.maT);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).setText(paramv.maS.content);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).setTextPadding(paramv.maS.padding);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).setGravity(paramv.maS.kZR);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).A(paramv.maS.maU, paramv.maS.rc, paramv.maS.borderColor, paramv.maS.bgColor);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).setX(paramv.maS.x);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).setY(paramv.maS.y);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).eN(paramv.maS.width, paramv.maS.height);
    ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).measure(0, 0);
    localMarkerOptions.anchor(((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).getAnchorX(), ((com.tencent.mm.plugin.appbrand.widget.e.d)localObject1).getAnchorY());
    localMarkerOptions.markerView((View)localObject1);
    localMarkerOptions.visible(true);
    localMarkerOptions.tag(paramString + "#label");
    localMarkerOptions.zIndex(paramv.zIndex + 3);
    localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
    if ((!Util.isNullOrNil(paramv.buildingId)) && (!Util.isNullOrNil(paramv.floorName))) {
      localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
    }
    localObject2 = this.lYw.getMap().addMarker(localMarkerOptions);
    localObject1 = paramg;
    if (paramg == null)
    {
      localObject1 = new g();
      ((g)localObject1).data = paramv.data;
      ((g)localObject1).maM = paramv;
    }
    ((g)localObject1).maq = ((Marker)localObject2);
    a(paramString + "#label", (g)localObject1);
    AppMethodBeat.o(217233);
  }
  
  private boolean a(b.aa paramaa)
  {
    AppMethodBeat.i(217239);
    if (this.lYw.getMap() == null)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster map is null");
      AppMethodBeat.o(217239);
      return false;
    }
    if (!bHg())
    {
      Log.e("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster mClusterManager is not initialize");
      AppMethodBeat.o(217239);
      return false;
    }
    f localf = b(paramaa);
    this.lZr.add(localf);
    this.lZs.add(f.a(localf));
    this.lYK.addItem(localf);
    this.lYK.cluster();
    Log.i("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster mClusterItems:%d， id:%s， latitude:%f, longitude:%f", new Object[] { Integer.valueOf(this.lZr.size()), paramaa.id, Double.valueOf(localf.getPosition().getLatitude()), Double.valueOf(localf.getPosition().getLongitude()) });
    AppMethodBeat.o(217239);
    return true;
  }
  
  private void aa(Runnable paramRunnable)
  {
    AppMethodBeat.i(146524);
    this.lZb.add(paramRunnable);
    if (this.lZb.size() == 1) {
      paramRunnable.run();
    }
    AppMethodBeat.o(146524);
  }
  
  private static f b(b.aa paramaa)
  {
    AppMethodBeat.i(217240);
    com.tencent.mapsdk.raster.model.LatLng localLatLng = new com.tencent.mapsdk.raster.model.LatLng(paramaa.mbd.latitude, paramaa.mbd.longitude);
    paramaa = new f(paramaa.id, localLatLng);
    AppMethodBeat.o(217240);
    return paramaa;
  }
  
  private void b(final Marker paramMarker)
  {
    AppMethodBeat.i(217235);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMarker.showInfoWindow();
      AppMethodBeat.o(217235);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217197);
        paramMarker.showInfoWindow();
        AppMethodBeat.o(217197);
      }
    });
    AppMethodBeat.o(217235);
  }
  
  private static b.f bGS()
  {
    AppMethodBeat.i(146492);
    b.f localf = new b.f();
    localf.buildingId = "";
    localf.buildingName = "";
    localf.maA = new LinkedList();
    localf.maB = -1;
    AppMethodBeat.o(146492);
    return localf;
  }
  
  private void bGT()
  {
    AppMethodBeat.i(146496);
    if (this.lYO == null) {
      this.lYO = getSurfaceView();
    }
    if (this.lYO != null)
    {
      MMHandlerThread.removeRunnable(this.lYP);
      this.lYO.setVisibility(0);
      AppMethodBeat.o(146496);
      return;
    }
    Log.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
    AppMethodBeat.o(146496);
  }
  
  private Bundle bHf()
  {
    AppMethodBeat.i(146545);
    Bundle localBundle = new Bundle();
    if (!lYC.equals(this.lYD))
    {
      String str = Util.nullAsNil(localBundle.getString("smallAppKey"));
      localBundle.putString("smallAppKey", str + this.lYD + "#" + this.lYE + ";");
    }
    AppMethodBeat.o(146545);
    return localBundle;
  }
  
  private boolean bHi()
  {
    AppMethodBeat.i(217242);
    Log.i("MicroMsg.DefaultTencentMapView", "removeAllMapCluster");
    if (this.lYK != null)
    {
      Iterator localIterator = this.lZr.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        this.lYK.removeItem(localf);
      }
      this.lZs.clear();
      this.lZr.clear();
      this.lYK.cluster();
      this.lZt.clear();
      this.lZw.clear();
      AppMethodBeat.o(217242);
      return true;
    }
    AppMethodBeat.o(217242);
    return false;
  }
  
  private void c(String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    Object localObject3 = null;
    AppMethodBeat.i(217234);
    Object localObject1;
    if ((paramv.mao > 0) && (this.lZt.contains(Integer.valueOf(paramv.mao))))
    {
      localObject1 = (Cluster)this.lZv.get(Integer.valueOf(paramv.mao));
      if (localObject1 == null) {
        break label506;
      }
      localObject1 = ((e)this.lYK.getRenderer()).getMarker((Cluster)localObject1);
    }
    for (;;)
    {
      final ImageView localImageView;
      Object localObject2;
      if (localObject1 != null)
      {
        if (paramv.maN) {
          ((Marker)localObject1).setPosition(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        }
        if (!Util.isNullOrNil(paramv.title)) {
          ((Marker)localObject1).setTitle(paramv.title);
        }
        if (!Util.isNullOrNil(paramv.maQ)) {
          ((Marker)localObject1).setContentDescription(paramv.maQ);
        }
        ((Marker)localObject1).setRotation(paramv.mat);
        ((Marker)localObject1).setAlpha(paramv.alpha);
        final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493818, null);
        localImageView = (ImageView)localFrameLayout.findViewById(2131304498);
        final float f1 = paramv.maO;
        final float f2 = paramv.maP;
        localObject2 = localObject3;
        if (parama != null)
        {
          if (!Util.isNullOrNil(paramv.mav))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            localObject2 = parama.a(paramv.mav, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void Q(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(217194);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if (this.lZR != null)
                  {
                    Log.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                    this.lZR.setMarkerView(localFrameLayout);
                  }
                }
                AppMethodBeat.o(217194);
              }
            });
          }
        }
        else
        {
          label282:
          if (localObject2 == null) {
            break label482;
          }
          a(f1, f2, (Bitmap)localObject2, localImageView);
          label298:
          ((Marker)localObject1).setMarkerView(localFrameLayout);
          ((Marker)localObject1).setAnchor(paramv.anchorX, paramv.anchorY);
          ((Marker)localObject1).setTag(paramString);
          ((Marker)localObject1).setInfoWindowHideAnimation(new Animation() {});
          ((Marker)localObject1).setInfoWindowShowAnimation(new Animation() {});
          ((Marker)localObject1).setVisible(true);
          ((Marker)localObject1).setZIndex(paramv.zIndex + 2);
          ((Marker)localObject1).setLevel(OverlayLevel.OverlayLevelAboveLabels);
        }
      }
      else
      {
        AppMethodBeat.o(217234);
        return;
        if (!paramv.maN) {
          break label500;
        }
        localObject1 = ZX(paramString);
        if (localObject1 == null) {
          break label494;
        }
      }
      label482:
      label494:
      for (localObject1 = ((e)this.lYK.getRenderer()).getMarker((ClusterItem)localObject1);; localObject1 = null)
      {
        this.lZw.put(paramString, paramv);
        if (this.lZx == null) {
          this.lZx = parama;
        }
        break;
        localObject2 = localObject3;
        if (localImageView == null) {
          break label282;
        }
        localImageView.setImageBitmap(null);
        localObject2 = localObject3;
        break label282;
        Log.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
        break label298;
      }
      label500:
      localObject1 = null;
      continue;
      label506:
      localObject1 = null;
    }
  }
  
  private SurfaceView getSurfaceView()
  {
    AppMethodBeat.i(146495);
    if (this.lYO != null)
    {
      localSurfaceView = this.lYO;
      AppMethodBeat.o(146495);
      return localSurfaceView;
    }
    this.lYO = i(this.lYw);
    SurfaceView localSurfaceView = this.lYO;
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
  
  private void i(List<com.tencent.mapsdk.raster.model.LatLng> paramList, int paramInt)
  {
    AppMethodBeat.i(217228);
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramList);
    this.lYT = false;
    this.lYw.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.lYV = null;
    AppMethodBeat.o(217228);
  }
  
  public final void L(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146546);
    if ((!this.lZk) || (this.lYx))
    {
      AppMethodBeat.o(146546);
      return;
    }
    if (this.lZl != null) {
      this.lZl.L(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(146546);
  }
  
  protected TencentMapOptions P(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146491);
    TencentMapOptions localTencentMapOptions = new TencentMapOptions();
    if (paramMap == null)
    {
      Log.w("MicroMsg.DefaultTencentMapView", "params is null, return");
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
    }
    String str = f.a(paramMap, "theme", "normal");
    this.lYG = str.equals("handDraw");
    this.mMapType = f.a(paramMap, "mapType", 1);
    localTencentMapOptions.setMapType(this.mMapType);
    this.lYD = f.a(paramMap, "subKey", "");
    this.lYE = f.a(paramMap, "subId", "");
    boolean bool;
    if (f.a(paramMap, "enableDarkMode", 0) == 1)
    {
      bool = true;
      this.lYH = bool;
      if (!Util.isNullOrNil(this.lYD)) {
        break label288;
      }
      this.lYD = lYC;
      this.lYE = "";
    }
    for (;;)
    {
      localTencentMapOptions.setSubInfo(this.lYD, this.lYE);
      this.lYF = f.a(paramMap, "styleId", 0);
      Log.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.lYE, this.lYD });
      Log.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d enableDarkmode:%b", new Object[] { str, Boolean.valueOf(this.lYG), Integer.valueOf(this.mMapType), this.lYE, this.lYD, Integer.valueOf(this.lYF), Boolean.valueOf(this.lYH) });
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
      bool = false;
      break;
      label288:
      this.lYH = false;
    }
  }
  
  public final void ZR(String paramString)
  {
    AppMethodBeat.i(182814);
    if (!this.lYN)
    {
      if (!this.lYZ.contains(paramString)) {
        this.lYZ.add(paramString);
      }
      Log.e("MicroMsg.DefaultTencentMapView", "addCustomLayer, wait map loaded callback");
      AppMethodBeat.o(182814);
      return;
    }
    CustomLayer localCustomLayer1 = this.lYw.getMap().addCustomLayer(new CustomLayerOptions().layerId(paramString));
    if (localCustomLayer1 != null)
    {
      Log.v("MicroMsg.DefaultTencentMapView", "addCustomLayer success, layerId:%s", new Object[] { paramString });
      CustomLayer localCustomLayer2 = (CustomLayer)this.lYY.remove(paramString);
      if (localCustomLayer2 != null) {
        localCustomLayer2.remove();
      }
      this.lYY.put(paramString, localCustomLayer1);
      AppMethodBeat.o(182814);
      return;
    }
    Log.e("MicroMsg.DefaultTencentMapView", "addCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182814);
  }
  
  public final void ZS(String paramString)
  {
    AppMethodBeat.i(182815);
    CustomLayer localCustomLayer = (CustomLayer)this.lYY.remove(paramString);
    if (localCustomLayer != null)
    {
      Log.v("MicroMsg.DefaultTencentMapView", "removeCustomLayer success, layerId:%s", new Object[] { paramString });
      localCustomLayer.remove();
      AppMethodBeat.o(182815);
      return;
    }
    Log.e("MicroMsg.DefaultTencentMapView", "removeCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182815);
  }
  
  public final boolean ZT(String paramString)
  {
    AppMethodBeat.i(146530);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", new Object[] { this, paramString });
    Polyline localPolyline = (Polyline)this.lZf.get(paramString);
    if (localPolyline == null)
    {
      Log.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146530);
      return false;
    }
    localPolyline.remove();
    this.lZf.remove(paramString);
    AppMethodBeat.o(146530);
    return true;
  }
  
  public final g ZU(String paramString)
  {
    AppMethodBeat.i(146533);
    paramString = (g)this.lZh.get(paramString);
    AppMethodBeat.o(146533);
    return paramString;
  }
  
  public final boolean ZV(String paramString)
  {
    AppMethodBeat.i(146535);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    if (this.lZs.contains(paramString))
    {
      Log.i("MicroMsg.DefaultTencentMapView", "removeMapMarkerClusterGeometry id:%s", new Object[] { paramString });
      if ((this.lYK != null) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = this.lZr.iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          if (paramString.contains(f.a(localf)))
          {
            this.lYK.removeItem(localf);
            this.lZr.remove(localf);
            this.lZs.remove(paramString);
            if (localf.mao > 0)
            {
              ZW(localf.mao);
              this.lZt.remove(Integer.valueOf(localf.mao));
              this.lZv.remove(Integer.valueOf(localf.mao));
            }
            Log.i("MicroMsg.DefaultTencentMapView", "remove MapMarker ClusterGeometry success id:%s", new Object[] { paramString });
            this.lYK.cluster();
          }
        }
      }
    }
    Object localObject = (g)this.lZh.get(paramString);
    if (localObject == null)
    {
      Log.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146535);
      return false;
    }
    if (((g)localObject).maj != null) {
      ((g)localObject).maj.remove();
    }
    if (((g)localObject).maq != null)
    {
      if ((((g)localObject).maq.getMarkerView() != null) && ((((g)localObject).maq.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.e.d)((g)localObject).maq.getMarkerView());
      }
      ((g)localObject).maq.remove();
      this.lZh.remove(paramString + "#label");
    }
    ((g)localObject).mar = null;
    this.lZh.remove(paramString);
    AppMethodBeat.o(146535);
    return true;
  }
  
  public final boolean ZW(String paramString)
  {
    AppMethodBeat.i(217231);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeLabelMarker markerId:%s", new Object[] { this, paramString });
    g localg = (g)this.lZh.remove(paramString + "#label");
    if (localg == null)
    {
      Log.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(217231);
      return false;
    }
    if (localg.maq != null)
    {
      if ((localg.maq.getMarkerView() != null) && ((localg.maq.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.e.d)localg.maq.getMarkerView());
      }
      localg.maq.remove();
    }
    AppMethodBeat.o(217231);
    return true;
  }
  
  public final Point a(b.i parami)
  {
    AppMethodBeat.i(217247);
    Log.i("MicroMsg.DefaultTencentMapView", "toScreenLocation");
    parami = new com.tencent.mapsdk.raster.model.LatLng(parami.latitude, parami.longitude);
    parami = this.lYw.getMap().getProjection().toScreenLocation(parami);
    AppMethodBeat.o(217247);
    return parami;
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
    Log.v("MicroMsg.DefaultTencentMapView", "start map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    if ((paramFloat1 == -1.0F) && (paramFloat2 == -1.0F) && (paramFloat3 == -1.0F) && (paramDouble1 == -1.0D) && (paramDouble2 == -1.0D))
    {
      AppMethodBeat.o(146522);
      return;
    }
    final TencentMap localTencentMap = this.lYw.getMap();
    if (localTencentMap != null)
    {
      if (paramBoolean)
      {
        aa(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146464);
            CameraUpdate localCameraUpdate = a.b(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, this.iVF);
            Log.v("MicroMsg.DefaultTencentMapView", "doing map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(this.iVF), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
            a.a(a.this, false);
            localTencentMap.animateCamera(localCameraUpdate, a.bHk(), a.t(a.this));
            AppMethodBeat.o(146464);
          }
        });
        AppMethodBeat.o(146522);
        return;
      }
      CameraUpdate localCameraUpdate = a(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, paramDouble2);
      this.lYT = false;
      localTencentMap.moveCamera(localCameraUpdate);
    }
    AppMethodBeat.o(146522);
  }
  
  public final void a(b.b arg1)
  {
    AppMethodBeat.i(146526);
    Object localObject1 = new CircleOptions();
    ((CircleOptions)localObject1).center(new com.tencent.mapsdk.raster.model.LatLng(???.latitude, ???.longitude));
    ((CircleOptions)localObject1).radius(???.radius);
    ((CircleOptions)localObject1).strokeColor(???.strokeColor);
    ((CircleOptions)localObject1).strokeWidth(???.strokeWidth);
    ((CircleOptions)localObject1).fillColor(???.fillColor);
    int i = ZY(???.mau);
    if (i >= 0) {
      ((CircleOptions)localObject1).level(i);
    }
    for (;;)
    {
      localObject1 = this.lYw.getMap().addCircle((CircleOptions)localObject1);
      synchronized (this.lZd)
      {
        this.lZd.add(localObject1);
        AppMethodBeat.o(146526);
        return;
        ((CircleOptions)localObject1).level(OverlayLevel.OverlayLevelAboveLabels);
      }
    }
  }
  
  public final void a(b.k paramk, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    int i = 0;
    AppMethodBeat.i(146531);
    Object localObject1 = new PolylineOptions();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramk.maG.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      b.i locali = (b.i)((Iterator)localObject3).next();
      ((List)localObject2).add(new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude));
    }
    ((PolylineOptions)localObject1).addAll((Iterable)localObject2);
    if ((paramk.maL != null) && (paramk.maL.size() > 0))
    {
      Log.i("MicroMsg.DefaultTencentMapView", "colorList size:%d ", new Object[] { Integer.valueOf(paramk.maL.size()) });
      int j = paramk.maL.size();
      localObject2 = new int[j];
      localObject3 = new int[j];
      while (i < j)
      {
        localObject2[i] = ((Integer)paramk.maL.get(i)).intValue();
        localObject3[i] = i;
        i += 1;
      }
      ((PolylineOptions)localObject1).colors((int[])localObject2, (int[])localObject3);
      ((PolylineOptions)localObject1).width(paramk.width);
      ((PolylineOptions)localObject1).setDottedLine(paramk.maH);
      ((PolylineOptions)localObject1).edgeColor(paramk.borderColor);
      ((PolylineOptions)localObject1).edgeWidth(paramk.rc);
      if (paramk.maI)
      {
        parama = parama.cR(paramk.maJ);
        ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(parama));
        if (parama == null) {
          ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), 2131231015)));
        }
      }
      ((PolylineOptions)localObject1).zIndex(1.0F);
      if ((!Util.isNullOrNil(paramk.buildingId)) && (!Util.isNullOrNil(paramk.floorName))) {
        ((PolylineOptions)localObject1).indoorInfo(new IndoorInfo(paramk.buildingId, paramk.floorName));
      }
      ((PolylineOptions)localObject1).arrowGap(paramk.maK);
      i = ZY(paramk.mau);
      if (i < 0) {
        break label472;
      }
      ((PolylineOptions)localObject1).level(i);
    }
    for (;;)
    {
      ((PolylineOptions)localObject1).lineCap(true);
      localObject1 = this.lYw.getMap().addPolyline((PolylineOptions)localObject1);
      if (localObject1 != null) {
        break label484;
      }
      Log.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
      AppMethodBeat.o(146531);
      return;
      if (paramk.style != -1)
      {
        ((PolylineOptions)localObject1).color(paramk.style);
        break;
      }
      ((PolylineOptions)localObject1).color(paramk.color);
      break;
      label472:
      ((PolylineOptions)localObject1).level(OverlayLevel.OverlayLevelAboveRoads);
    }
    label484:
    if (Util.isNullOrNil(paramk.id)) {}
    for (parama = paramk.hashCode();; parama = paramk.id)
    {
      this.lZf.put(Util.nullAs(parama, paramk.toString()), localObject1);
      AppMethodBeat.o(146531);
      return;
    }
  }
  
  public final void a(b.l paraml)
  {
    this.lYy = paraml;
  }
  
  public final void a(b.m paramm)
  {
    this.lYQ = paramm;
  }
  
  public final void a(b.o paramo)
  {
    this.lYA = paramo;
  }
  
  public final void a(b.p paramp)
  {
    this.lYz = paramp;
  }
  
  public final void a(b.s params)
  {
    this.lYB = params;
  }
  
  public final void a(b.w paramw)
  {
    AppMethodBeat.i(146499);
    this.lYU = paramw;
    this.lYw.getMap().setTencentMapGestureListener(new TencentMap.TencentMapGestureListener()
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
    this.lYw.getMap().setOnMapCameraChangeListener(new TencentMap.OnMapCameraChangeListener()
    {
      public final void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(146459);
        if (a.p(a.this) != null)
        {
          b.a locala = new b.a();
          locala.mas = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.mat = paramAnonymousCameraPosition.getBearing();
          locala.skew = paramAnonymousCameraPosition.getSkew();
          a.p(a.this).a(locala, a.q(a.this));
        }
        AppMethodBeat.o(146459);
      }
      
      public final void onCameraChangeFinish(CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(146460);
        if (a.p(a.this) != null)
        {
          b.a locala = new b.a();
          locala.mas = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.mat = paramAnonymousCameraPosition.getBearing();
          locala.skew = paramAnonymousCameraPosition.getSkew();
          a.p(a.this).b(locala, a.q(a.this));
          a.a(a.this, false);
        }
        a.j(a.this);
        AppMethodBeat.o(146460);
      }
    });
    AppMethodBeat.o(146499);
  }
  
  public final void a(b.x paramx)
  {
    this.lYW = paramx;
  }
  
  public final void a(b.z paramz)
  {
    this.lYS = paramz;
  }
  
  public final void a(String paramString, int paramInt, b.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(146532);
    Polyline localPolyline = (Polyline)this.lZf.get(paramString);
    if (localPolyline == null)
    {
      Log.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146532);
      return;
    }
    localPolyline.setEraseable(paramBoolean);
    localPolyline.eraseTo(paramInt, new com.tencent.mapsdk.raster.model.LatLng(parami.latitude, parami.longitude));
    AppMethodBeat.o(146532);
  }
  
  public final void a(String paramString, b.v paramv)
  {
    AppMethodBeat.i(182816);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s updateMarker markerId:%s", new Object[] { this, paramString });
    final g localg = ZU(paramString);
    if (localg != null) {
      if (paramv.maR != null)
      {
        if (paramv.maR.view == null) {
          break label578;
        }
        localg.maM.maR = paramv.maR;
        if (localg.maj != null) {
          localg.maj.setInfoWindowOffset(paramv.maR.maZ, paramv.maR.mba);
        }
        if ((localg.maj == null) || (paramv.maR.maY != b.v.a.mbc)) {
          break label532;
        }
        b(localg.maj);
      }
    }
    for (;;)
    {
      if (paramv.maS != null)
      {
        localg.maq.remove();
        ZV(paramString + "#label");
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        com.tencent.mm.plugin.appbrand.widget.e.d locald2 = i.bHn();
        com.tencent.mm.plugin.appbrand.widget.e.d locald1 = locald2;
        if (locald2 == null) {
          locald1 = new com.tencent.mm.plugin.appbrand.widget.e.d(this.context);
        }
        locald1.reset();
        locald1.setTextColor(paramv.maS.color);
        locald1.setTextSize(paramv.maS.maT);
        locald1.setText(paramv.maS.content);
        locald1.setTextPadding(paramv.maS.padding);
        locald1.setGravity(paramv.maS.kZR);
        locald1.A(paramv.maS.maU, paramv.maS.rc, paramv.maS.borderColor, paramv.maS.bgColor);
        locald1.setX(paramv.maS.x);
        locald1.setY(paramv.maS.y);
        locald1.eN(paramv.maS.width, paramv.maS.height);
        locald1.measure(0, 0);
        localMarkerOptions.anchor(locald1.getAnchorX(), locald1.getAnchorY());
        localMarkerOptions.markerView(locald1);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramv.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!Util.isNullOrNil(paramv.buildingId)) && (!Util.isNullOrNil(paramv.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
        }
        localg.maq = this.lYw.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", localg);
      }
      AppMethodBeat.o(182816);
      return;
      label532:
      if (localg.maj != null) {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localg.maj.refreshInfoWindow();
        }
        else
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(217196);
              localg.maj.refreshInfoWindow();
              AppMethodBeat.o(217196);
            }
          });
          continue;
          label578:
          localg.mar = null;
        }
      }
    }
  }
  
  public final void a(final String paramString, final b.v paramv, final com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(146536);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramString, paramv, parama);
      AppMethodBeat.o(146536);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217192);
        a.this.b(paramString, paramv, parama);
        AppMethodBeat.o(217192);
      }
    });
    AppMethodBeat.o(146536);
  }
  
  public final void a(final String paramString, ArrayList<b.i> arg2, long paramLong, boolean paramBoolean, b.r arg6)
  {
    AppMethodBeat.i(217236);
    g localg = ZU(paramString);
    if ((localg == null) || (localg.maj == null))
    {
      Log.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      ???.hv(false);
      AppMethodBeat.o(217236);
      return;
    }
    if (???.size() <= 0)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      ???.hv(false);
      AppMethodBeat.o(217236);
      return;
    }
    synchronized (this.lYI)
    {
      if (this.lYI.containsKey(paramString)) {
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217202);
            this.lZX.cancelAnimation();
            AppMethodBeat.o(217202);
          }
        });
      }
      ??? = new com.tencent.mapsdk.raster.model.LatLng[???.size()];
      ??? = ???.iterator();
      int i = 0;
      if (???.hasNext())
      {
        b.i locali = (b.i)???.next();
        ???[i] = new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude);
        i += 1;
      }
    }
    ??? = new MarkerTranslateAnimator(localg.maj, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
    ???.addAnimatorListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(217205);
        Log.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationCancel");
        if (paramr != null) {
          paramr.bGP();
        }
        synchronized (a.v(a.this))
        {
          a.v(a.this).remove(paramString);
          AppMethodBeat.o(217205);
          return;
        }
      }
      
      public final void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(217204);
        Log.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationEnd");
        if (paramr != null) {
          paramr.hv(true);
        }
        synchronized (a.v(a.this))
        {
          a.v(a.this).remove(paramString);
          AppMethodBeat.o(217204);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217203);
        Log.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationStart");
        AppMethodBeat.o(217203);
      }
    });
    synchronized (this.lYI)
    {
      this.lYI.put(paramString, ???);
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217206);
          Log.d("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator start");
          paramArrayList.startAnimation();
          AppMethodBeat.o(217206);
        }
      });
      if (localg.maq != null)
      {
        Log.d("MicroMsg.DefaultTencentMapView", "labelMarker do move animator");
        synchronized (this.lYJ)
        {
          if (this.lYJ.containsKey(paramString)) {
            m.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(217207);
                this.lZX.cancelAnimation();
                AppMethodBeat.o(217207);
              }
            });
          }
          ??? = new MarkerTranslateAnimator(localg.maq, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
          ???.addAnimatorListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator arg1)
            {
              AppMethodBeat.i(217209);
              synchronized (a.w(a.this))
              {
                a.w(a.this).remove(paramString);
                AppMethodBeat.o(217209);
                return;
              }
            }
            
            public final void onAnimationEnd(Animator arg1)
            {
              AppMethodBeat.i(217208);
              synchronized (a.w(a.this))
              {
                a.w(a.this).remove(paramString);
                AppMethodBeat.o(217208);
                return;
              }
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          });
        }
      }
    }
    synchronized (this.lYJ)
    {
      this.lYJ.put(paramString, ???);
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217210);
          paramr.startAnimation();
          AppMethodBeat.o(217210);
        }
      });
      AppMethodBeat.o(217236);
      return;
      paramString = finally;
      AppMethodBeat.o(217236);
      throw paramString;
      paramString = finally;
      AppMethodBeat.o(217236);
      throw paramString;
    }
  }
  
  public final void a(String paramString, LinkedList<b.h> paramLinkedList, final b.r paramr)
  {
    AppMethodBeat.i(146539);
    paramString = ZU(paramString);
    if ((paramString == null) || (paramString.maj == null))
    {
      Log.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      paramr.hv(false);
      AppMethodBeat.o(146539);
      return;
    }
    if (paramLinkedList.size() <= 0)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      paramr.hv(false);
      AppMethodBeat.o(146539);
      return;
    }
    Object localObject = (b.h)paramLinkedList.get(0);
    ((b.h)localObject).maD = paramString.maj.getPosition().getLatitude();
    ((b.h)localObject).maC = paramString.maj.getPosition().getLongitude();
    int j = paramLinkedList.size();
    int i = 1;
    if (i < j)
    {
      localObject = (b.h)paramLinkedList.get(i - 1);
      b.h localh = (b.h)paramLinkedList.get(i);
      if (((b.h)localObject).mat == 0.0F) {
        localh.maC = ((b.h)localObject).longitude;
      }
      for (localh.maD = ((b.h)localObject).latitude;; localh.maD = paramString.maj.getPosition().getLatitude())
      {
        i += 1;
        break;
        localh.maC = paramString.maj.getPosition().getLongitude();
      }
    }
    localObject = new c(paramLinkedList, paramString.maj, this.lYw);
    paramr = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217199);
        Log.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
        if (paramr != null) {
          paramr.hv(true);
        }
        AppMethodBeat.o(217199);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217198);
        Log.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
        AppMethodBeat.o(217198);
      }
    };
    ((c)localObject).xc.addListener(paramr);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217200);
        this.lZV.xc.start();
        AppMethodBeat.o(217200);
      }
    });
    if (paramString.maq != null) {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217201);
          this.lZW.xc.start();
          AppMethodBeat.o(217201);
        }
      });
    }
    AppMethodBeat.o(146539);
  }
  
  public final boolean a(final int paramInt, b.e parame, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(217244);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, id < 0 or options is null");
      AppMethodBeat.o(217244);
      return false;
    }
    Log.i("MicroMsg.DefaultTencentMapView", "remove GroundOverlay id:%d, first ,and than add again", new Object[] { Integer.valueOf(paramInt) });
    xf(paramInt);
    Log.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    final GroundOverlayOptions localGroundOverlayOptions = new GroundOverlayOptions();
    if ((parame.may != null) && (parame.maz != null))
    {
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng1.longitude = parame.may.longitude;
      localLatLng1.latitude = parame.may.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng2.longitude = parame.maz.longitude;
      localLatLng2.latitude = parame.maz.latitude;
      localGroundOverlayOptions.latLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng2, localLatLng1));
    }
    localGroundOverlayOptions.alpha(parame.alpha);
    localGroundOverlayOptions.visible(parame.visible);
    localGroundOverlayOptions.zIndex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.mav)))
    {
      parame = parama.a(parame.mav, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void Q(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(217216);
          if (paramAnonymousBitmap != null)
          {
            localGroundOverlayOptions.bitmap(BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
            paramAnonymousBitmap = a.this.lYw.getMap().addGroundOverlay(localGroundOverlayOptions);
            if (paramAnonymousBitmap == null)
            {
              Log.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
              AppMethodBeat.o(217216);
              return;
            }
            a.F(a.this).put(paramInt, paramAnonymousBitmap);
            Log.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(217216);
            return;
          }
          Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay load bitmap is null");
          AppMethodBeat.o(217216);
        }
      });
      if (parame != null)
      {
        localGroundOverlayOptions.bitmap(BitmapDescriptorFactory.fromBitmap(parame));
        parame = this.lYw.getMap().addGroundOverlay(localGroundOverlayOptions);
        if (parame == null)
        {
          Log.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
          AppMethodBeat.o(217244);
          return false;
        }
        this.lZA.put(String.valueOf(paramInt), parame);
        Log.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    while (parama == null)
    {
      AppMethodBeat.o(217244);
      return true;
    }
    Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(217244);
    return false;
  }
  
  public final boolean a(b.ab arg1)
  {
    AppMethodBeat.i(146543);
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.maG.iterator();
    while (localIterator.hasNext())
    {
      b.i locali = (b.i)localIterator.next();
      localArrayList.add(new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude));
    }
    ((PolygonOptions)localObject1).addAll(localArrayList);
    ((PolygonOptions)localObject1).fillColor(???.fillColor);
    ((PolygonOptions)localObject1).strokeColor(???.strokeColor);
    ((PolygonOptions)localObject1).strokeWidth(???.strokeWidth);
    ((PolygonOptions)localObject1).zIndex(???.zIndex);
    int i = ZY(???.mau);
    if (i >= 0) {
      ((PolygonOptions)localObject1).level(i);
    }
    localObject1 = this.lYw.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.lZj)
    {
      this.lZj.add(localObject1);
      AppMethodBeat.o(146543);
      return true;
    }
  }
  
  public final boolean a(b.c paramc, b.n paramn, final com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(146528);
    if (Util.isNullOrNil(paramc.mav))
    {
      AppMethodBeat.o(146528);
      return false;
    }
    Object localObject = parama.cR(paramc.mav);
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
      i = com.tencent.mm.plugin.appbrand.ac.g.zD(((Bitmap)localObject).getHeight());
      if (paramc.width != 0) {
        break label217;
      }
    }
    label217:
    for (int j = com.tencent.mm.plugin.appbrand.ac.g.zD(((Bitmap)localObject).getWidth());; j = paramc.width)
    {
      localObject = new FrameLayout.LayoutParams(j, i);
      ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
      boolean bool = paramc.maw;
      paramc = paramc.data;
      parama.setOnTouchListener(new a.7(this, bool, parama));
      parama.setOnClickListener(new a.8(this, bool, paramn, paramc));
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(146469);
          ((ViewGroup)a.this.container).addView(parama, this.lZI);
          synchronized (a.this.lZe)
          {
            a.this.lZe.add(new a.b(a.this, parama));
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
  
  public final boolean a(b.d arg1, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(146541);
    if (Util.isNullOrNil(???.mav))
    {
      AppMethodBeat.o(146541);
      return false;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(???.latitude, ???.longitude));
    parama = parama.cR(???.mav);
    if ((parama != null) && (!parama.isRecycled())) {
      localMarkerOptions.icon(new BitmapDescriptor(parama));
    }
    localMarkerOptions.rotation(???.mat);
    parama = this.lYw.getMap().addMarker(localMarkerOptions);
    synchronized (this.lZi)
    {
      this.lZi.add(new c(parama));
      AppMethodBeat.o(146541);
      return true;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, final int paramInt1, final int paramInt2, b.q paramq)
  {
    AppMethodBeat.i(217238);
    boolean bool;
    if (this.lYw.getMap() == null)
    {
      bool = false;
      if (bool)
      {
        this.lZq = paramq;
        this.lZy = paramBoolean2;
        this.lZz = paramBoolean1;
        Log.i("MicroMsg.DefaultTencentMapView", "initMapMarkerCluster zoomOnClick:%b, enableDefaultStyle:%b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      }
      AppMethodBeat.o(217238);
      return bool;
    }
    this.lYM = true;
    Runnable local36 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217215);
        if (a.b(a.this) == null) {
          a.a(a.this, new a.d(a.this, a.u(a.this), a.this.lYw.getMap()));
        }
        if (a.z(a.this) == null)
        {
          a.a(a.this, new a.e(a.this, a.u(a.this), a.this.lYw.getMap(), a.b(a.this)));
          a.z(a.this).setMinClusterSize(paramInt1);
          NonHierarchicalDistanceBasedAlgorithm localNonHierarchicalDistanceBasedAlgorithm = new NonHierarchicalDistanceBasedAlgorithm(a.u(a.this));
          localNonHierarchicalDistanceBasedAlgorithm.setMaxDistanceAtZoom(paramInt2);
          a.b(a.this).setAlgorithm(localNonHierarchicalDistanceBasedAlgorithm);
        }
        for (;;)
        {
          a.b(a.this).setOnClusterClickListener(new ClusterManager.OnClusterClickListener()
          {
            public final boolean onClusterClick(Cluster<a.f> paramAnonymous2Cluster)
            {
              AppMethodBeat.i(217214);
              boolean bool = a.this.b(paramAnonymous2Cluster);
              AppMethodBeat.o(217214);
              return bool;
            }
          });
          a.b(a.this).setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener() {});
          Log.i("MicroMsg.DefaultTencentMapView", "init map marker cluster finish");
          a.b(a.this).setRenderer(a.z(a.this));
          a.b(a.this).setClusterEnabled(true);
          a.this.lYw.getMap().setOnMapCameraChangeListener(a.b(a.this));
          a.A(a.this);
          AppMethodBeat.o(217215);
          return;
          a.z(a.this).setMinClusterSize(paramInt1);
          if ((a.b(a.this).getAlgorithm() != null) && ((a.b(a.this).getAlgorithm() instanceof NonHierarchicalDistanceBasedAlgorithm))) {
            ((NonHierarchicalDistanceBasedAlgorithm)a.b(a.this).getAlgorithm()).setMaxDistanceAtZoom(paramInt2);
          }
        }
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper()) {
      local36.run();
    }
    for (;;)
    {
      bool = true;
      break;
      MMHandlerThread.postToMainThread(local36);
    }
  }
  
  public final void b(final String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(217232);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s _addMarker markerId:%s", new Object[] { this, paramString });
    if (this.lZp.get())
    {
      Log.e("MicroMsg.DefaultTencentMapView", "map:%s _addMarker markerId:%s fail", new Object[] { this, paramString });
      AppMethodBeat.o(217232);
      return;
    }
    Object localObject1;
    g localg;
    MarkerOptions localMarkerOptions;
    final FrameLayout localFrameLayout;
    if (paramv.mao > 0)
    {
      localObject1 = paramv.mao;
      if (this.lZz)
      {
        Log.i("MicroMsg.DefaultTencentMapView", "cluster item use default style");
        AppMethodBeat.o(217232);
        return;
      }
      c((String)localObject1, paramv, parama);
      localg = new g();
      localg.data = paramv.data;
      localg.maM = paramv;
      a((String)localObject1, localg);
      if ((!paramv.maN) && (!TextUtils.isEmpty(paramString)))
      {
        localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        if (!Util.isNullOrNil(paramv.title)) {
          localMarkerOptions.title(paramv.title);
        }
        if (!Util.isNullOrNil(paramv.maQ)) {
          localMarkerOptions.contentDescription(paramv.maQ);
        }
        localMarkerOptions.rotation(paramv.mat);
        localMarkerOptions.alpha(paramv.alpha);
        localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493818, null);
        final ImageView localImageView = (ImageView)localFrameLayout.findViewById(2131304498);
        final float f1 = paramv.maO;
        final float f2 = paramv.maP;
        Object localObject3 = null;
        Object localObject2 = localObject3;
        if (parama != null)
        {
          localObject2 = localObject3;
          if (!Util.isNullOrNil(paramv.mav))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            localObject2 = parama.a(paramv.mav, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void Q(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(217193);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if ((a.this.ZU(paramString) != null) && (a.this.ZU(paramString).maj != null))
                  {
                    paramAnonymousBitmap = a.this.ZU(paramString).maj;
                    if (paramAnonymousBitmap != null) {
                      paramAnonymousBitmap.setMarkerView(localFrameLayout);
                    }
                    Log.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                  }
                }
                AppMethodBeat.o(217193);
              }
            });
          }
        }
        if (localObject2 == null) {
          break label700;
        }
        a(f1, f2, (Bitmap)localObject2, localImageView);
      }
    }
    for (;;)
    {
      localMarkerOptions.markerView(localFrameLayout);
      localMarkerOptions.anchor(paramv.anchorX, paramv.anchorY);
      localMarkerOptions.tag(localObject1);
      localMarkerOptions.infoWindowHideAnimation(new Animation() {});
      localMarkerOptions.infoWindowShowAnimation(new Animation() {});
      localMarkerOptions.visible(true);
      localMarkerOptions.zIndex(paramv.zIndex + 2);
      localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
      if ((!Util.isNullOrNil(paramv.buildingId)) && (!Util.isNullOrNil(paramv.floorName))) {
        localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
      }
      if (paramv.maR != null) {
        localMarkerOptions.infoWindowOffset(paramv.maR.maZ, paramv.maR.mba);
      }
      paramString = this.lYw.getMap().addMarker(localMarkerOptions);
      localg.maj = paramString;
      paramString.getZIndex();
      if ((paramv.maR != null) && (paramv.maR.maY == b.v.a.mbc)) {
        b(localg.maj);
      }
      if (((!paramv.maN) || (paramv.mao != 0)) && (paramv.maS != null)) {
        a((String)localObject1, paramv, localg);
      }
      AppMethodBeat.o(217232);
      return;
      if (paramv.maN)
      {
        localObject1 = new b.aa();
        ((b.aa)localObject1).mbd = new b.i(paramv.latitude, paramv.longitude);
        ((b.aa)localObject1).id = paramString;
        a((b.aa)localObject1);
        c(paramString, paramv, parama);
      }
      localObject1 = paramString;
      break;
      label700:
      Log.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
    }
  }
  
  public final boolean b(final int paramInt, b.e parame, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(217246);
    if (!this.lZA.containsKey(String.valueOf(paramInt)))
    {
      Log.e("MicroMsg.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(217246);
      return false;
    }
    final GroundOverlay localGroundOverlay = (GroundOverlay)this.lZA.get(String.valueOf(paramInt));
    if (localGroundOverlay == null)
    {
      Log.e("MicroMsg.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay is null");
      AppMethodBeat.o(217246);
      return false;
    }
    Log.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((parame.may != null) && (parame.maz != null))
    {
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng1.longitude = parame.may.longitude;
      localLatLng1.latitude = parame.may.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng2.longitude = parame.maz.longitude;
      localLatLng2.latitude = parame.maz.latitude;
      localGroundOverlay.setLatLongBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng2, localLatLng1));
    }
    localGroundOverlay.setAlpha(parame.alpha);
    localGroundOverlay.setVisibility(parame.visible);
    localGroundOverlay.setZindex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.mav)))
    {
      parame = parama.a(parame.mav, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void Q(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(217217);
          if (paramAnonymousBitmap != null)
          {
            localGroundOverlay.setBitmap(BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
            Log.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(217217);
            return;
          }
          Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay load bitmap is null");
          AppMethodBeat.o(217217);
        }
      });
      if (parame != null)
      {
        localGroundOverlay.setBitmap(BitmapDescriptorFactory.fromBitmap(parame));
        Log.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    while (parama == null)
    {
      AppMethodBeat.o(217246);
      return true;
    }
    Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(217246);
    return false;
  }
  
  public final boolean b(Cluster<f> paramCluster)
  {
    AppMethodBeat.i(217237);
    Log.i("MicroMsg.DefaultTencentMapView", "onClusterClick");
    if (this.lZy)
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramCluster.getItems().iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((f)localIterator.next()).getPosition());
      }
      i(localLinkedList, 0);
    }
    if (this.lZq != null) {
      this.lZq.aa(a(paramCluster, false));
    }
    AppMethodBeat.o(217237);
    return true;
  }
  
  public final b.ac bGU()
  {
    AppMethodBeat.i(146498);
    Object localObject2 = this.lYw.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.j();
    ((b.j)localObject1).maE = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.j)localObject1).maF = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.ad();
    ((b.ad)localObject2).mbf = ((b.j)localObject1);
    localObject1 = new b.ac();
    ((b.ac)localObject1).mbe = ((b.ad)localObject2);
    AppMethodBeat.o(146498);
    return localObject1;
  }
  
  public final void bGV()
  {
    AppMethodBeat.i(146501);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.lYV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146461);
        if ((a.d(a.this) != null) && (a.r(a.this)))
        {
          double d1 = a.d(a.this).getLatitude();
          double d2 = a.d(a.this).getLongitude();
          a.this.lYw.getIController().animateTo(d1, d2);
          Log.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        }
        AppMethodBeat.o(146461);
      }
    };
    if ((this.lZl != null) && (this.lZk))
    {
      this.lYV.run();
      this.lYV = null;
    }
    AppMethodBeat.o(146501);
  }
  
  public final b.f bGW()
  {
    AppMethodBeat.i(146515);
    if (this.lYX != null)
    {
      localf = this.lYX;
      AppMethodBeat.o(146515);
      return localf;
    }
    b.f localf = bGS();
    AppMethodBeat.o(146515);
    return localf;
  }
  
  public boolean bGX()
  {
    return false;
  }
  
  public final b.i bGY()
  {
    AppMethodBeat.i(146519);
    Object localObject = this.lYw.getMap().getMapCenter();
    localObject = new b.i(((com.tencent.mapsdk.raster.model.LatLng)localObject).getLatitude(), ((com.tencent.mapsdk.raster.model.LatLng)localObject).getLongitude());
    AppMethodBeat.o(146519);
    return localObject;
  }
  
  public final void bGZ()
  {
    AppMethodBeat.i(146525);
    synchronized (this.lZd)
    {
      Iterator localIterator = this.lZd.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.lZd.clear();
    AppMethodBeat.o(146525);
  }
  
  public final void bHa()
  {
    AppMethodBeat.i(146527);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146465);
        ViewGroup localViewGroup = (ViewGroup)a.this.container;
        synchronized (a.this.lZe)
        {
          Iterator localIterator = a.this.lZe.iterator();
          if (localIterator.hasNext()) {
            localViewGroup.removeView(((a.b)localIterator.next()).mai);
          }
        }
        a.this.lZe.clear();
        AppMethodBeat.o(146465);
      }
    });
    AppMethodBeat.o(146527);
  }
  
  public final void bHb()
  {
    AppMethodBeat.i(146529);
    Iterator localIterator = this.lZf.values().iterator();
    while (localIterator.hasNext()) {
      ((Polyline)localIterator.next()).remove();
    }
    this.lZf.clear();
    AppMethodBeat.o(146529);
  }
  
  public final void bHc()
  {
    AppMethodBeat.i(146534);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.lZh.values().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg.maj != null) {
        localg.maj.remove();
      }
      if (localg.maq != null)
      {
        if ((localg.maq.getMarkerView() != null) && ((localg.maq.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.e.d)localg.maq.getMarkerView());
        }
        localg.maq.remove();
      }
    }
    this.lZh.clear();
    bHi();
    AppMethodBeat.o(146534);
  }
  
  public final void bHd()
  {
    AppMethodBeat.i(146540);
    synchronized (this.lZi)
    {
      Iterator localIterator = this.lZi.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).maj.remove();
      }
    }
    this.lZi.clear();
    AppMethodBeat.o(146540);
  }
  
  public final void bHe()
  {
    AppMethodBeat.i(146542);
    synchronized (this.lZj)
    {
      Iterator localIterator = this.lZj.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.lZj.clear();
    AppMethodBeat.o(146542);
  }
  
  public final boolean bHg()
  {
    return (this.lYK != null) && (this.lYL != null);
  }
  
  public final boolean bHh()
  {
    return this.lYM;
  }
  
  public final void c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(146516);
    com.tencent.mapsdk.raster.model.LatLng localLatLng = this.lYw.getMap().getMapCenter();
    this.lYw.setMapAnchor(paramFloat1, paramFloat2);
    a(localLatLng.getLatitude(), localLatLng.getLongitude(), -1.0F, -1.0F, -1.0F, paramBoolean);
    AppMethodBeat.o(146516);
  }
  
  public final void dy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146514);
    this.lYw.getMap().setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(146514);
  }
  
  public final b.i e(Point paramPoint)
  {
    AppMethodBeat.i(217248);
    Log.i("MicroMsg.DefaultTencentMapView", "fromScreenLocation");
    paramPoint = this.lYw.getMap().getProjection().fromScreenLocation(paramPoint);
    paramPoint = new b.i(paramPoint.getLatitude(), paramPoint.getLongitude());
    AppMethodBeat.o(217248);
    return paramPoint;
  }
  
  public final void f(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146500);
    a(paramDouble1, paramDouble2, -1.0F, -1.0F, -1.0F, true);
    AppMethodBeat.o(146500);
  }
  
  public void g(SurfaceTexture paramSurfaceTexture) {}
  
  public final float getRotate()
  {
    AppMethodBeat.i(146503);
    float f = this.lYw.getMap().getCameraPosition().getBearing();
    AppMethodBeat.o(146503);
    return f;
  }
  
  public final float getSkew()
  {
    AppMethodBeat.i(146504);
    float f = this.lYw.getMap().getCameraPosition().getSkew();
    AppMethodBeat.o(146504);
    return f;
  }
  
  public final View getView()
  {
    return this.container;
  }
  
  public final float getZoom()
  {
    AppMethodBeat.i(217223);
    float f = this.lYw.getMap().getCameraPosition().getZoom();
    AppMethodBeat.o(217223);
    return f;
  }
  
  public final void h(List<b.i> paramList, int paramInt)
  {
    AppMethodBeat.i(146520);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.i locali = (b.i)paramList.next();
      localLinkedList.add(new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude));
    }
    i(localLinkedList, paramInt);
    AppMethodBeat.o(146520);
  }
  
  public final void hA(boolean paramBoolean)
  {
    AppMethodBeat.i(146510);
    this.lYw.getUiSettings().setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146510);
  }
  
  public final void hB(boolean paramBoolean)
  {
    AppMethodBeat.i(146511);
    this.lYw.getMap().setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(146511);
  }
  
  public final void hC(boolean paramBoolean)
  {
    AppMethodBeat.i(146512);
    this.lYw.getMap().setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(146512);
  }
  
  public final void hD(boolean paramBoolean)
  {
    AppMethodBeat.i(146513);
    this.lYw.getMap().setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(146513);
  }
  
  public final void hE(boolean paramBoolean)
  {
    AppMethodBeat.i(146517);
    this.lYw.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
    AppMethodBeat.o(146517);
  }
  
  public final void hF(boolean paramBoolean)
  {
    AppMethodBeat.i(146518);
    this.lYw.getUiSettings().setScaleControlsEnabled(paramBoolean);
    AppMethodBeat.o(146518);
  }
  
  public final void hG(boolean paramBoolean)
  {
    AppMethodBeat.i(217226);
    this.lYw.getMap().showBuilding(paramBoolean);
    AppMethodBeat.o(217226);
  }
  
  public final void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(146544);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.lZk = paramBoolean;
    d locald;
    if (paramBoolean)
    {
      if (this.lZl != null)
      {
        locald = this.lZl;
        if (locald.maj != null) {
          locald.maj.setVisible(true);
        }
      }
      ((com.tencent.mm.plugin.appbrand.utils.b.a)e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.lZm, bHf());
      g.a(this);
      AppMethodBeat.o(146544);
      return;
    }
    if (this.lZl != null)
    {
      locald = this.lZl;
      if (locald.maj != null) {
        locald.maj.setVisible(false);
      }
    }
    ((com.tencent.mm.plugin.appbrand.utils.b.a)e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.lZm, bHf());
    g.b(this);
    AppMethodBeat.o(146544);
  }
  
  public final void hw(boolean paramBoolean)
  {
    AppMethodBeat.i(146505);
    this.lYw.getUiSettings().setZoomGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146505);
  }
  
  public final void hx(boolean paramBoolean)
  {
    AppMethodBeat.i(146506);
    this.lYw.getUiSettings().setScrollGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146506);
  }
  
  public final void hy(boolean paramBoolean)
  {
    AppMethodBeat.i(146507);
    this.lYw.getUiSettings().setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146507);
  }
  
  public final void hz(boolean paramBoolean)
  {
    AppMethodBeat.i(146508);
    this.lYw.getUiSettings().setCompassEnabled(paramBoolean);
    AppMethodBeat.o(146508);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(146497);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.lZp.set(true);
    this.lYw.getMap().setOnMapCameraChangeListener(null);
    bHc();
    bHb();
    bHb();
    bHa();
    bHd();
    bHe();
    Object localObject = this.lYY.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CustomLayer)((Iterator)localObject).next()).remove();
    }
    this.lYY.clear();
    if (this.lYw != null)
    {
      this.lYw.getMap().setOnMapPoiClickListener(null);
      this.lYw.clean();
      this.lYw.onDestroy();
    }
    if (this.lZl != null)
    {
      localObject = this.lZl;
      if (((d)localObject).maj != null)
      {
        ((d)localObject).maj.remove();
        ((d)localObject).maj = null;
      }
      this.lZl = null;
    }
    AppMethodBeat.o(146497);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(146494);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.dKU.setVisibility(0);
      if (this.lYO == null) {
        this.lYO = getSurfaceView();
      }
      if (this.lYO != null)
      {
        MMHandlerThread.postToMainThreadDelayed(this.lYP, 100L);
        this.lYw.setVisibility(4);
        this.lYw.getMap().getScreenShot(new TencentMap.OnScreenShotListener()
        {
          public final void onMapScreenShot(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(146484);
            if (paramAnonymousBitmap != null) {
              a.o(a.this).setImageBitmap(paramAnonymousBitmap);
            }
            AppMethodBeat.o(146484);
          }
        });
      }
    }
    for (;;)
    {
      this.lYx = true;
      if (this.lZk)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.lZm, bHf());
        g.b(this);
      }
      AppMethodBeat.o(146494);
      return;
      Log.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
      break;
      this.lYw.onPause();
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(146493);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.dKU.setVisibility(4);
      this.lYw.setVisibility(0);
      this.lYw.onResume();
      bGT();
    }
    for (;;)
    {
      this.lYx = false;
      if (this.lZk)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.lZm, bHf());
        g.a(this);
      }
      AppMethodBeat.o(146493);
      return;
      this.lYw.onResume();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2) {}
  
  public void onTouchEvent(MotionEvent paramMotionEvent) {}
  
  public final void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(217227);
    this.lYw.getMap().setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(217227);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(217224);
    this.lYw.getMap().setIndoorMaskColor(paramInt);
    AppMethodBeat.o(217224);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(182813);
    Log.i("MicroMsg.DefaultTencentMapView", "map:%s setMapStyle: %d", new Object[] { this, Integer.valueOf(paramInt) });
    this.lYw.getMap().setMapStyle(paramInt);
    AppMethodBeat.o(182813);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(217229);
    this.lYw.getMap().setMaxZoomLevel(paramInt);
    Log.i("MicroMsg.DefaultTencentMapView", "map_scale setMaxZoomLevel:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(217229);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(217230);
    this.lYw.getMap().setMinZoomLevel(paramInt);
    Log.i("MicroMsg.DefaultTencentMapView", "map_scale setMinZoomLevel:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(217230);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217225);
    this.lYw.getMap().setPoisEnabled(paramBoolean);
    AppMethodBeat.o(217225);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146547);
    String str = "DefaultTencentMapView{mapId=" + this.lYv + '}';
    AppMethodBeat.o(146547);
    return str;
  }
  
  public final boolean xf(int paramInt)
  {
    AppMethodBeat.i(217245);
    if (!this.lZA.containsKey(String.valueOf(paramInt)))
    {
      Log.e("MicroMsg.DefaultTencentMapView", "removeGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(217245);
      return false;
    }
    Log.i("MicroMsg.DefaultTencentMapView", "removeGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    GroundOverlay localGroundOverlay = (GroundOverlay)this.lZA.remove(String.valueOf(paramInt));
    if (localGroundOverlay != null)
    {
      localGroundOverlay.remove();
      AppMethodBeat.o(217245);
      return true;
    }
    AppMethodBeat.o(217245);
    return false;
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
      if (Util.isNullOrNil((String)paramMarker.getTag()))
      {
        Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (((String)paramMarker.getTag()).endsWith("#label"))
      {
        AppMethodBeat.o(146488);
        return null;
      }
      paramMarker = a.this.ZU((String)paramMarker.getTag());
      if (paramMarker == null)
      {
        Log.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (paramMarker.maM == null)
      {
        Log.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      b.v.a locala = paramMarker.maM.maR;
      if (locala == null)
      {
        AppMethodBeat.o(146488);
        return null;
      }
      if (locala.view != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view is %b", new Object[] { paramMarker, Boolean.valueOf(bool) });
        if (locala.view == null) {
          break;
        }
        if (paramMarker.mar == null) {
          paramMarker.mar = new ImageView(a.u(a.this));
        }
        localObject = BitmapUtil.getBitmapFromView(locala.view);
        if (localObject == null) {
          Log.e("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view exist but bitmap is null");
        }
        paramMarker.mar.setImageBitmap((Bitmap)localObject);
        paramMarker = paramMarker.mar;
        AppMethodBeat.o(146488);
        return paramMarker;
      }
      a locala1 = a.this;
      Object localObject = i.bHm();
      paramMarker = (Marker)localObject;
      if (localObject == null) {
        paramMarker = new com.tencent.mm.plugin.appbrand.widget.e.b(locala1.context);
      }
      paramMarker.setText("");
      paramMarker.setTextSize(12);
      paramMarker.setTextColor(com.tencent.mm.plugin.appbrand.widget.e.b.oyv);
      paramMarker.setTitlePadding(0);
      paramMarker.setGravity("center");
      int i = com.tencent.mm.plugin.appbrand.widget.e.b.oyw;
      paramMarker.A(0, 0, i, i);
      paramMarker.setText(locala.content);
      paramMarker.setTextSize(locala.maT);
      paramMarker.setTextColor(locala.color);
      paramMarker.setTitlePadding(locala.padding);
      paramMarker.setGravity(locala.kZR);
      paramMarker.A(locala.maU, locala.rc, locala.borderColor, locala.bgColor);
      AppMethodBeat.o(146488);
      return paramMarker;
    }
    
    public final void onInfoWindowDettached(Marker paramMarker, View paramView)
    {
      AppMethodBeat.i(146489);
      if ((paramView instanceof com.tencent.mm.plugin.appbrand.widget.e.b))
      {
        Log.d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
        i.a((com.tencent.mm.plugin.appbrand.widget.e.b)paramView);
      }
      AppMethodBeat.o(146489);
    }
  }
  
  public final class b
  {
    ImageView mai;
    
    public b(ImageView paramImageView)
    {
      this.mai = paramImageView;
    }
  }
  
  public final class c
  {
    Marker maj;
    
    public c(Marker paramMarker)
    {
      this.maj = paramMarker;
    }
  }
  
  final class d
    extends ClusterManager<a.f>
  {
    public d(Context paramContext, TencentMap paramTencentMap)
    {
      super(paramTencentMap);
    }
    
    public final void onCameraChange(CameraPosition paramCameraPosition)
    {
      AppMethodBeat.i(217218);
      super.onCameraChange(paramCameraPosition);
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.mas = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.mat = paramCameraPosition.getBearing();
        locala.skew = paramCameraPosition.getSkew();
        a.p(a.this).a(locala, a.q(a.this));
      }
      AppMethodBeat.o(217218);
    }
    
    public final void onCameraChangeFinish(CameraPosition paramCameraPosition)
    {
      AppMethodBeat.i(217219);
      super.onCameraChangeFinish(paramCameraPosition);
      Log.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish");
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.mas = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.mat = paramCameraPosition.getBearing();
        locala.skew = paramCameraPosition.getSkew();
        a.p(a.this).b(locala, a.q(a.this));
        a.a(a.this, false);
      }
      a.j(a.this);
      if ((a.b(a.this) != null) && (a.b(a.this).getAlgorithm().getClusters(paramCameraPosition.getZoom()).size() > 0))
      {
        paramCameraPosition = ((NonHierarchicalDistanceBasedAlgorithm)((PreCachingAlgorithmDecorator)a.b(a.this).getAlgorithm()).getAlgorithm()).getClusters(paramCameraPosition.getZoom());
        Log.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish cluster size:%d", new Object[] { Integer.valueOf(paramCameraPosition.size()) });
        paramCameraPosition = paramCameraPosition.iterator();
        while (paramCameraPosition.hasNext()) {
          Log.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish cluster item size:%d", new Object[] { Integer.valueOf(((Cluster)paramCameraPosition.next()).getItems().size()) });
        }
      }
      AppMethodBeat.o(217219);
    }
  }
  
  final class e
    extends DefaultClusterRenderer<a.f>
  {
    public e(TencentMap paramTencentMap, ClusterManager<a.f> paramClusterManager)
    {
      super(paramClusterManager, localClusterManager);
    }
    
    public final void onBeforeClusterRendered(Cluster<a.f> paramCluster, MarkerOptions paramMarkerOptions)
    {
      AppMethodBeat.i(217221);
      super.onBeforeClusterRendered(paramCluster, paramMarkerOptions);
      Log.i("MicroMsg.DefaultTencentMapView", "onBeforeClusterRendered, cluster size:%d", new Object[] { Integer.valueOf(paramCluster.getItems().size()) });
      paramMarkerOptions = paramCluster.getItems().iterator();
      while (paramMarkerOptions.hasNext())
      {
        a.f localf = (a.f)paramMarkerOptions.next();
        if (localf.mao > 0) {
          a.this.ZW(localf.mao);
        }
        a.this.ZW(a.f.a(localf));
      }
      if (a.E(a.this) != null) {
        a.E(a.this).p(a.a(a.this, paramCluster));
      }
      AppMethodBeat.o(217221);
    }
  }
  
  static final class f
    implements ClusterItem
  {
    private String id;
    private com.tencent.mapsdk.raster.model.LatLng man;
    int mao;
    
    f(String paramString, com.tencent.mapsdk.raster.model.LatLng paramLatLng)
    {
      this.id = paramString;
      this.man = paramLatLng;
    }
    
    public final com.tencent.mapsdk.raster.model.LatLng getPosition()
    {
      return this.man;
    }
  }
  
  public static final class g
    extends b.u
  {
    public Marker maj;
    public Marker maq;
    public ImageView mar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a.a
 * JD-Core Version:    0.7.0.1
 */