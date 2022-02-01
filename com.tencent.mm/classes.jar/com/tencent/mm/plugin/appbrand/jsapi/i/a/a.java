package com.tencent.mm.plugin.appbrand.jsapi.i.a;

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
import com.tencent.mm.plugin.appbrand.widget.d.c;
import com.tencent.mm.plugin.appbrand.z.m;
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
  private static final String kPP;
  private static long kQm;
  FrameLayout container;
  Context context;
  private ImageView dsD;
  private String kPI;
  protected final SoSoMapView kPJ;
  private boolean kPK;
  private b.l kPL;
  private b.p kPM;
  private b.o kPN;
  private b.s kPO;
  private String kPQ;
  private String kPR;
  private int kPS;
  private boolean kPT;
  private boolean kPU;
  private volatile HashMap<String, MarkerTranslateAnimator> kPV;
  private volatile HashMap<String, MarkerTranslateAnimator> kPW;
  private volatile ClusterManager<f> kPX;
  private DefaultClusterRenderer<f> kPY;
  private boolean kPZ;
  private AtomicBoolean kQA;
  private AtomicBoolean kQB;
  private b.q kQC;
  private ArrayList<f> kQD;
  private ArrayList<String> kQE;
  private ArrayList<Integer> kQF;
  private AtomicInteger kQG;
  private HashMap<Integer, Cluster<f>> kQH;
  private HashMap<String, b.v> kQI;
  private com.tencent.mm.plugin.appbrand.f.a kQJ;
  boolean kQK;
  boolean kQL;
  private HashMap<String, GroundOverlay> kQM;
  SurfaceView kQa;
  private Runnable kQb;
  private b.m kQc;
  private b.y kQd;
  private b.z kQe;
  private boolean kQf;
  private b.w kQg;
  private Runnable kQh;
  private b.x kQi;
  private b.f kQj;
  private Map<String, CustomLayer> kQk;
  private ArrayList<String> kQl;
  private Queue<Runnable> kQn;
  private CancelableCallback kQo;
  public ArrayList<Circle> kQp;
  public ArrayList<a.b> kQq;
  private Map<String, Polyline> kQr;
  private a kQs;
  private Map<String, g> kQt;
  public ArrayList<c> kQu;
  public ArrayList<Polygon> kQv;
  private boolean kQw;
  private d kQx;
  private com.tencent.mm.plugin.appbrand.utils.b.a.b kQy;
  private final int kQz;
  private long lastCheckTime;
  private int mMapType;
  
  static
  {
    AppMethodBeat.i(146554);
    kPP = com.tencent.mm.plugin.appbrand.z.b.er("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    kQm = 500L;
    AppMethodBeat.o(146554);
  }
  
  public a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146490);
    this.kPV = new HashMap();
    this.kPW = new HashMap();
    this.kPZ = false;
    this.kQb = new a.42(this);
    this.kQf = false;
    this.kQk = new ConcurrentHashMap();
    this.kQl = new ArrayList();
    this.kQn = new LinkedList();
    this.kQo = new CancelableCallback()
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
    this.kQp = new ArrayList();
    this.kQq = new ArrayList();
    this.kQr = new ConcurrentHashMap();
    this.kQs = new a();
    this.kQt = new ConcurrentHashMap();
    this.kQu = new ArrayList();
    this.kQv = new ArrayList();
    this.kQy = new com.tencent.mm.plugin.appbrand.utils.b.a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, final com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(199864);
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(199864);
          return;
        }
        ad.d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude) });
        if (!a.ble())
        {
          ad.w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
          AppMethodBeat.o(199864);
          return;
        }
        if ((!a.r(a.this)) || (a.x(a.this)))
        {
          AppMethodBeat.o(199864);
          return;
        }
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199863);
            d locald;
            double d1;
            double d2;
            if (a.this.kPJ != null)
            {
              if (a.d(a.this) == null)
              {
                a.a(a.this, new d(a.u(a.this)));
                locald = a.d(a.this);
                localObject = a.this.kPJ;
                com.tencent.mm.plugin.appbrand.utils.b.a.a locala = paramAnonymousa;
                MarkerOptions localMarkerOptions = new MarkerOptions();
                localMarkerOptions.anchor(0.5F, 0.5F);
                localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(locala.latitude, locala.longitude));
                localMarkerOptions.markerView(locald);
                localMarkerOptions.zIndex(2147483647);
                localMarkerOptions.flat(true);
                localMarkerOptions.tag("AnchorPoint");
                locald.kRu = ((SoSoMapView)localObject).getMap().addMarker(localMarkerOptions);
              }
              locald = a.d(a.this);
              d1 = paramAnonymousa.latitude;
              d2 = paramAnonymousa.longitude;
              Object localObject = paramAnonymousa.provider;
              double d3 = paramAnonymousa.dfE;
              if ((locald.kSr != -1.0D) || (locald.kSs != -1.0D)) {
                break label398;
              }
              locald.kSr = d1;
              locald.kSp = d1;
              locald.kSs = d2;
              locald.kSq = d2;
              if ((locald.kSr != -1.0D) && (locald.kSs != -1.0D)) {
                locald.kSw = f.a(locald.kSs, locald.kSr, d2, d1, (String)localObject, d3);
              }
              if ((locald.kSu != 900.0F) && (locald.kSt != 900.0F)) {
                break label433;
              }
              float f = (float)f.h(d1, d2);
              locald.kSt = f;
              locald.kSu = f;
            }
            for (;;)
            {
              if (locald.kRu != null) {
                locald.kRu.setPosition(new com.tencent.mapsdk.raster.model.LatLng(d1, d2));
              }
              AppMethodBeat.o(199863);
              return;
              label398:
              locald.kSr = locald.kSp;
              locald.kSs = locald.kSq;
              locald.kSq = d2;
              locald.kSp = d1;
              break;
              label433:
              locald.kSu = locald.kSt;
              locald.kSt = ((float)f.h(d1, d2));
            }
          }
        });
        AppMethodBeat.o(199864);
      }
    };
    this.lastCheckTime = 0L;
    this.kQz = 500;
    this.kQA = new AtomicBoolean(false);
    this.kQB = new AtomicBoolean(false);
    this.kQD = new ArrayList();
    this.kQE = new ArrayList();
    this.kQF = new ArrayList();
    this.kQG = new AtomicInteger(100);
    this.kQH = new HashMap();
    this.kQI = new HashMap();
    this.kQM = new HashMap();
    this.context = paramContext;
    this.kPI = paramString;
    this.container = new FrameLayout(paramContext);
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.container.setBackgroundColor(0);
    this.container.setLayoutParams(paramString);
    this.kPJ = new SoSoMapView(paramContext, F(paramMap));
    this.container.addView(this.kPJ, new FrameLayout.LayoutParams(-1, -1));
    this.dsD = new ImageView(paramContext);
    this.dsD.setScaleType(ImageView.ScaleType.FIT_XY);
    this.container.addView(this.dsD, new ViewGroup.LayoutParams(-1, -1));
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s, init", new Object[] { this });
    this.kPJ.getMap().setInfoWindowAdapter(this.kQs);
    this.kPJ.getMap().setMapAnchor(0.5F, 0.5F);
    this.kPJ.getMap().enableMultipleInfowindow(true);
    this.kPJ.getMap().setMapStyle(this.kPS);
    paramContext = this.kPJ.getMap();
    if (this.kPU) {}
    for (int i = 1008;; i = 1000)
    {
      paramContext.setMapType(i);
      this.kPJ.getMap().setHandDrawMapEnable(this.kPT);
      this.kPJ.getMap().setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener()
      {
        public final void onInfoWindowClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146458);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146458);
            return;
          }
          paramAnonymousMarker = a.this.PL((String)paramAnonymousMarker.getTag());
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
      this.kPJ.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener()
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
          if ((bt.isNullOrNil((String)paramAnonymousMarker.getTag())) && (a.b(a.this) != null) && (((a.e)a.b(a.this).getRenderer()).getCluster(paramAnonymousMarker) != null))
          {
            paramAnonymousMarker = ((a.e)a.b(a.this).getRenderer()).getCluster(paramAnonymousMarker);
            bool = a.this.b(paramAnonymousMarker);
            AppMethodBeat.o(146468);
            return bool;
          }
          if (bt.isNullOrNil((String)paramAnonymousMarker.getTag()))
          {
            ad.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
            AppMethodBeat.o(146468);
            return false;
          }
          if (((String)paramAnonymousMarker.getTag()).endsWith("AnchorPoint"))
          {
            if ((a.c(a.this) != null) && (a.d(a.this) != null))
            {
              ad.w("MicroMsg.DefaultTencentMapView", "click anchor point");
              a.c(a.this).d(a.d(a.this).getLatitude(), a.d(a.this).getLongitude());
            }
            AppMethodBeat.o(146468);
            return true;
          }
          a.g localg = a.this.PL((String)paramAnonymousMarker.getTag());
          if (localg == null)
          {
            ad.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return false;
          }
          if (a.e(a.this) == null)
          {
            ad.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return false;
          }
          if (localg.kRU != null)
          {
            if (!((String)paramAnonymousMarker.getTag()).endsWith("#label")) {
              break label443;
            }
            ad.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, do nothing");
          }
          for (;;)
          {
            if (localg.kRu != null) {
              localg.kRu.set2Top();
            }
            if (localg.kRA != null) {
              localg.kRA.set2Top();
            }
            Object localObject;
            if (a.d(a.this) != null)
            {
              localObject = a.d(a.this);
              if (((d)localObject).kRu != null) {
                ((d)localObject).kRu.set2Top();
              }
            }
            if (localg.kRU.kRz <= 0) {
              break;
            }
            a.a(a.this, localg.kRU.kRz);
            AppMethodBeat.o(146468);
            return true;
            label443:
            b.v.a locala = localg.kRU.kRZ;
            if (localg.kRu != null) {
              localObject = localg.kRu;
            }
            for (;;)
            {
              if ((locala != null) && (locala.kSg == b.v.a.kSj) && (localObject != null))
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
            ad.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
            bool = a.f(a.this).c(localg);
            AppMethodBeat.o(146468);
            return bool;
          }
          boolean bool = a.e(a.this).b(localg);
          AppMethodBeat.o(146468);
          return bool;
        }
      });
      this.kPJ.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener()
      {
        public final void onMapClick(com.tencent.mapsdk.raster.model.LatLng paramAnonymousLatLng)
        {
          AppMethodBeat.i(146478);
          Iterator localIterator = a.g(a.this).values().iterator();
          while (localIterator.hasNext())
          {
            a.g localg = (a.g)localIterator.next();
            if ((localg.kRU != null) && (localg.kRU.kRZ != null) && (localg.kRU.kRZ.kSg == b.v.a.kSj) && (localg.kRu.isInfoWindowShown())) {
              localg.kRu.hideInfoWindow();
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
      this.kPJ.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener()
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
              a.this.PI(str);
            }
            a.l(a.this).clear();
          }
          AppMethodBeat.o(146479);
        }
      });
      this.kPJ.getMap().setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener()
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
            if (((paramAnonymousMapPoi instanceof IndoorMapPoi)) && (!bt.isNullOrNil(((IndoorMapPoi)paramAnonymousMapPoi).getBuildingId())))
            {
              localt.buildingId = ((IndoorMapPoi)paramAnonymousMapPoi).getBuildingId();
              localt.floorName = ((IndoorMapPoi)paramAnonymousMapPoi).getFloorName();
            }
            a.m(a.this).a(localt);
          }
          AppMethodBeat.o(146480);
        }
      });
      this.kPJ.getMap().setOnIndoorStateChangeListener(new TencentMap.OnIndoorStateChangeListener()
      {
        public final boolean onIndoorBuildingDeactivated()
        {
          AppMethodBeat.i(146483);
          ad.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
          if (a.n(a.this) != null)
          {
            b.f localf = a.blc();
            a.a(a.this, localf);
            a.n(a.this).a(localf);
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
          if (a.n(a.this) != null)
          {
            b.f localf = new b.f();
            localf.buildingId = paramAnonymousIndoorBuilding.getBuidlingId();
            localf.buildingName = paramAnonymousIndoorBuilding.getBuildingName();
            localf.kRI = new LinkedList();
            Iterator localIterator = paramAnonymousIndoorBuilding.getLevels().iterator();
            while (localIterator.hasNext())
            {
              IndoorLevel localIndoorLevel = (IndoorLevel)localIterator.next();
              b.g localg = new b.g();
              localg.floorName = localIndoorLevel.getName();
              localf.kRI.add(localg);
            }
            localf.kRJ = paramAnonymousIndoorBuilding.getActiveLevelIndex();
            a.a(a.this, localf);
            a.n(a.this).a(localf);
          }
          AppMethodBeat.o(146482);
          return true;
        }
      });
      ad.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
      this.kPJ.onCreate(null);
      onResume();
      AppMethodBeat.o(146490);
      return;
    }
  }
  
  private f PO(String paramString)
  {
    AppMethodBeat.i(199891);
    Iterator localIterator = this.kQD.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (paramString.contains(f.a(localf)))
      {
        AppMethodBeat.o(199891);
        return localf;
      }
    }
    AppMethodBeat.o(199891);
    return null;
  }
  
  private void X(Runnable paramRunnable)
  {
    AppMethodBeat.i(146524);
    this.kQn.add(paramRunnable);
    if (this.kQn.size() == 1) {
      paramRunnable.run();
    }
    AppMethodBeat.o(146524);
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
    //   0: ldc_w 633
    //   3: invokestatic 232	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_2
    //   9: ifeq +211 -> 220
    //   12: aload_0
    //   13: getfield 336	com/tencent/mm/plugin/appbrand/jsapi/i/a/a:kQG	Ljava/util/concurrent/atomic/AtomicInteger;
    //   16: invokevirtual 636	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 330	com/tencent/mm/plugin/appbrand/jsapi/i/a/a:kQF	Ljava/util/ArrayList;
    //   24: iload_3
    //   25: invokestatic 641	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 642	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 338	com/tencent/mm/plugin/appbrand/jsapi/i/a/a:kQH	Ljava/util/HashMap;
    //   36: iload_3
    //   37: invokestatic 641	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aload_1
    //   41: invokevirtual 645	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_1
    //   46: invokeinterface 651 1 0
    //   51: invokeinterface 654 1 0
    //   56: astore 4
    //   58: aload 4
    //   60: invokeinterface 504 1 0
    //   65: ifeq +29 -> 94
    //   68: aload 4
    //   70: invokeinterface 508 1 0
    //   75: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/i/a/a$f
    //   78: iload_3
    //   79: putfield 657	com/tencent/mm/plugin/appbrand/jsapi/i/a/a$f:kRz	I
    //   82: goto -24 -> 58
    //   85: astore_1
    //   86: ldc_w 633
    //   89: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: areturn
    //   94: new 659	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 660	org/json/JSONObject:<init>	()V
    //   101: astore 4
    //   103: aload 4
    //   105: ldc_w 662
    //   108: iload_3
    //   109: invokevirtual 665	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   112: pop
    //   113: new 659	org/json/JSONObject
    //   116: dup
    //   117: invokespecial 660	org/json/JSONObject:<init>	()V
    //   120: astore 5
    //   122: aload 5
    //   124: ldc_w 667
    //   127: aload_1
    //   128: invokeinterface 671 1 0
    //   133: invokevirtual 675	com/tencent/mapsdk/raster/model/LatLng:getLatitude	()D
    //   136: invokevirtual 678	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 5
    //   142: ldc_w 680
    //   145: aload_1
    //   146: invokeinterface 671 1 0
    //   151: invokevirtual 683	com/tencent/mapsdk/raster/model/LatLng:getLongitude	()D
    //   154: invokevirtual 678	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 685
    //   163: aload 5
    //   165: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: new 620	org/json/JSONArray
    //   172: dup
    //   173: invokespecial 621	org/json/JSONArray:<init>	()V
    //   176: astore 5
    //   178: aload_1
    //   179: invokeinterface 651 1 0
    //   184: invokeinterface 654 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 504 1 0
    //   196: ifeq +64 -> 260
    //   199: aload 5
    //   201: aload_1
    //   202: invokeinterface 508 1 0
    //   207: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/i/a/a$f
    //   210: invokestatic 511	com/tencent/mm/plugin/appbrand/jsapi/i/a/a$f:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/i/a/a$f;)Ljava/lang/String;
    //   213: invokevirtual 628	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   216: pop
    //   217: goto -27 -> 190
    //   220: aload_1
    //   221: invokeinterface 651 1 0
    //   226: invokeinterface 654 1 0
    //   231: astore 4
    //   233: aload 4
    //   235: invokeinterface 504 1 0
    //   240: ifeq -146 -> 94
    //   243: aload 4
    //   245: invokeinterface 508 1 0
    //   250: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/i/a/a$f
    //   253: getfield 657	com/tencent/mm/plugin/appbrand/jsapi/i/a/a$f:kRz	I
    //   256: istore_3
    //   257: goto -163 -> 94
    //   260: aload 4
    //   262: ldc_w 690
    //   265: aload 5
    //   267: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   270: pop
    //   271: ldc_w 633
    //   274: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      f = com.tencent.mm.plugin.appbrand.z.g.vJ(paramBitmap.getWidth());
      paramFloat1 = com.tencent.mm.plugin.appbrand.z.g.vJ(paramBitmap.getHeight());
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
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.kQt.put(paramString, paramg);
    AppMethodBeat.o(146538);
  }
  
  private void a(String paramString, b.v paramv, g paramg)
  {
    AppMethodBeat.i(199883);
    if (PL(paramString + "#label") != null)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "addLabelMarker label is exist, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(199883);
      return;
    }
    if (paramv.kSa == null)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "addLabelMarker labelStyle is null, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(199883);
      return;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
    Object localObject2 = i.blg();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.appbrand.widget.d.d(this.context);
    }
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).reset();
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).setTextColor(paramv.kSa.color);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).setTextSize(paramv.kSa.kSb);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).setText(paramv.kSa.content);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).setTextPadding(paramv.kSa.padding);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).setGravity(paramv.kSa.jTE);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).A(paramv.kSa.kSc, paramv.kSa.borderWidth, paramv.kSa.borderColor, paramv.kSa.bgColor);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).setX(paramv.kSa.x);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).setY(paramv.kSa.y);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).eA(paramv.kSa.width, paramv.kSa.height);
    ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).measure(0, 0);
    localMarkerOptions.anchor(((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).getAnchorX(), ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).getAnchorY());
    localMarkerOptions.markerView((View)localObject1);
    localMarkerOptions.visible(true);
    localMarkerOptions.tag(paramString + "#label");
    localMarkerOptions.zIndex(paramv.zIndex + 3);
    localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
    if ((!bt.isNullOrNil(paramv.buildingId)) && (!bt.isNullOrNil(paramv.floorName))) {
      localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
    }
    localObject2 = this.kPJ.getMap().addMarker(localMarkerOptions);
    localObject1 = paramg;
    if (paramg == null)
    {
      localObject1 = new g();
      ((g)localObject1).data = paramv.data;
      ((g)localObject1).kRU = paramv;
    }
    ((g)localObject1).kRA = ((Marker)localObject2);
    a(paramString + "#label", (g)localObject1);
    AppMethodBeat.o(199883);
  }
  
  private boolean a(b.aa paramaa)
  {
    AppMethodBeat.i(199889);
    if (this.kPJ.getMap() == null)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster map is null");
      AppMethodBeat.o(199889);
      return false;
    }
    if (!bla())
    {
      ad.e("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster mClusterManager is not initialize");
      AppMethodBeat.o(199889);
      return false;
    }
    f localf = b(paramaa);
    this.kQD.add(localf);
    this.kQE.add(f.a(localf));
    this.kPX.addItem(localf);
    this.kPX.cluster();
    ad.i("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster mClusterItems:%d， id:%s， latitude:%f, longitude:%f", new Object[] { Integer.valueOf(this.kQD.size()), paramaa.id, Double.valueOf(localf.getPosition().getLatitude()), Double.valueOf(localf.getPosition().getLongitude()) });
    AppMethodBeat.o(199889);
    return true;
  }
  
  private static f b(b.aa paramaa)
  {
    AppMethodBeat.i(199890);
    com.tencent.mapsdk.raster.model.LatLng localLatLng = new com.tencent.mapsdk.raster.model.LatLng(paramaa.kSl.latitude, paramaa.kSl.longitude);
    paramaa = new f(paramaa.id, localLatLng);
    AppMethodBeat.o(199890);
    return paramaa;
  }
  
  private void b(final Marker paramMarker)
  {
    AppMethodBeat.i(199885);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMarker.showInfoWindow();
      AppMethodBeat.o(199885);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199849);
        paramMarker.showInfoWindow();
        AppMethodBeat.o(199849);
      }
    });
    AppMethodBeat.o(199885);
  }
  
  private static b.f bkM()
  {
    AppMethodBeat.i(146492);
    b.f localf = new b.f();
    localf.buildingId = "";
    localf.buildingName = "";
    localf.kRI = new LinkedList();
    localf.kRJ = -1;
    AppMethodBeat.o(146492);
    return localf;
  }
  
  private void bkN()
  {
    AppMethodBeat.i(146496);
    if (this.kQa == null) {
      this.kQa = getSurfaceView();
    }
    if (this.kQa != null)
    {
      aq.aA(this.kQb);
      this.kQa.setVisibility(0);
      AppMethodBeat.o(146496);
      return;
    }
    ad.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
    AppMethodBeat.o(146496);
  }
  
  private Bundle bkZ()
  {
    AppMethodBeat.i(146545);
    Bundle localBundle = new Bundle();
    if (!kPP.equals(this.kPQ))
    {
      String str = bt.nullAsNil(localBundle.getString("smallAppKey"));
      localBundle.putString("smallAppKey", str + this.kPQ + "#" + this.kPR + ";");
    }
    AppMethodBeat.o(146545);
    return localBundle;
  }
  
  private boolean blb()
  {
    AppMethodBeat.i(199892);
    ad.i("MicroMsg.DefaultTencentMapView", "removeAllMapCluster");
    if (this.kPX != null)
    {
      Iterator localIterator = this.kQD.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        this.kPX.removeItem(localf);
      }
      this.kQE.clear();
      this.kQD.clear();
      this.kPX.cluster();
      this.kQF.clear();
      this.kQI.clear();
      AppMethodBeat.o(199892);
      return true;
    }
    AppMethodBeat.o(199892);
    return false;
  }
  
  private void c(String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    Object localObject3 = null;
    AppMethodBeat.i(199884);
    Object localObject1;
    if ((paramv.kRz > 0) && (this.kQF.contains(Integer.valueOf(paramv.kRz))))
    {
      localObject1 = (Cluster)this.kQH.get(Integer.valueOf(paramv.kRz));
      if (localObject1 == null) {
        break label506;
      }
      localObject1 = ((e)this.kPX.getRenderer()).getMarker((Cluster)localObject1);
    }
    for (;;)
    {
      final ImageView localImageView;
      Object localObject2;
      if (localObject1 != null)
      {
        if (paramv.kRV) {
          ((Marker)localObject1).setPosition(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        }
        if (!bt.isNullOrNil(paramv.title)) {
          ((Marker)localObject1).setTitle(paramv.title);
        }
        if (!bt.isNullOrNil(paramv.kRY)) {
          ((Marker)localObject1).setContentDescription(paramv.kRY);
        }
        ((Marker)localObject1).setRotation(paramv.kRD);
        ((Marker)localObject1).setAlpha(paramv.alpha);
        final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493687, null);
        localImageView = (ImageView)localFrameLayout.findViewById(2131302158);
        final float f1 = paramv.kRW;
        final float f2 = paramv.kRX;
        localObject2 = localObject3;
        if (parama != null)
        {
          if (!bt.isNullOrNil(paramv.kRE))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            localObject2 = parama.a(paramv.kRE, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void M(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(199846);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if (this.kRd != null)
                  {
                    ad.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                    this.kRd.setMarkerView(localFrameLayout);
                  }
                }
                AppMethodBeat.o(199846);
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
        AppMethodBeat.o(199884);
        return;
        if (!paramv.kRV) {
          break label500;
        }
        localObject1 = PO(paramString);
        if (localObject1 == null) {
          break label494;
        }
      }
      label482:
      label494:
      for (localObject1 = ((e)this.kPX.getRenderer()).getMarker((ClusterItem)localObject1);; localObject1 = null)
      {
        this.kQI.put(paramString, paramv);
        if (this.kQJ == null) {
          this.kQJ = parama;
        }
        break;
        localObject2 = localObject3;
        if (localImageView == null) {
          break label282;
        }
        localImageView.setImageBitmap(null);
        localObject2 = localObject3;
        break label282;
        ad.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
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
    if (this.kQa != null)
    {
      localSurfaceView = this.kQa;
      AppMethodBeat.o(146495);
      return localSurfaceView;
    }
    this.kQa = i(this.kPJ);
    SurfaceView localSurfaceView = this.kQa;
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
    AppMethodBeat.i(199878);
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramList);
    this.kPJ.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.kQh = null;
    AppMethodBeat.o(199878);
  }
  
  protected TencentMapOptions F(Map<String, Object> paramMap)
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
    this.kPT = str.equals("handDraw");
    this.mMapType = f.a(paramMap, "mapType", 1);
    localTencentMapOptions.setMapType(this.mMapType);
    this.kPQ = f.a(paramMap, "subKey", "");
    this.kPR = f.a(paramMap, "subId", "");
    boolean bool;
    if (f.a(paramMap, "enableDarkMode", 0) == 1)
    {
      bool = true;
      this.kPU = bool;
      if (!bt.isNullOrNil(this.kPQ)) {
        break label288;
      }
      this.kPQ = kPP;
      this.kPR = "";
    }
    for (;;)
    {
      localTencentMapOptions.setSubInfo(this.kPQ, this.kPR);
      this.kPS = f.a(paramMap, "styleId", 0);
      ad.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.kPR, this.kPQ });
      ad.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d enableDarkmode:%b", new Object[] { str, Boolean.valueOf(this.kPT), Integer.valueOf(this.mMapType), this.kPR, this.kPQ, Integer.valueOf(this.kPS), Boolean.valueOf(this.kPU) });
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
      bool = false;
      break;
      label288:
      this.kPU = false;
    }
  }
  
  public final void H(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146546);
    if ((!this.kQw) || (this.kPK))
    {
      AppMethodBeat.o(146546);
      return;
    }
    if (this.kQx != null) {
      this.kQx.H(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(146546);
  }
  
  public final void PI(String paramString)
  {
    AppMethodBeat.i(182814);
    if (!this.kPZ)
    {
      if (!this.kQl.contains(paramString)) {
        this.kQl.add(paramString);
      }
      ad.e("MicroMsg.DefaultTencentMapView", "addCustomLayer, wait map loaded callback");
      AppMethodBeat.o(182814);
      return;
    }
    CustomLayer localCustomLayer1 = this.kPJ.getMap().addCustomLayer(new CustomLayerOptions().layerId(paramString));
    if (localCustomLayer1 != null)
    {
      ad.v("MicroMsg.DefaultTencentMapView", "addCustomLayer success, layerId:%s", new Object[] { paramString });
      CustomLayer localCustomLayer2 = (CustomLayer)this.kQk.remove(paramString);
      if (localCustomLayer2 != null) {
        localCustomLayer2.remove();
      }
      this.kQk.put(paramString, localCustomLayer1);
      AppMethodBeat.o(182814);
      return;
    }
    ad.e("MicroMsg.DefaultTencentMapView", "addCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182814);
  }
  
  public final void PJ(String paramString)
  {
    AppMethodBeat.i(182815);
    CustomLayer localCustomLayer = (CustomLayer)this.kQk.remove(paramString);
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
  
  public final boolean PK(String paramString)
  {
    AppMethodBeat.i(146530);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", new Object[] { this, paramString });
    Polyline localPolyline = (Polyline)this.kQr.get(paramString);
    if (localPolyline == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146530);
      return false;
    }
    localPolyline.remove();
    this.kQr.remove(paramString);
    AppMethodBeat.o(146530);
    return true;
  }
  
  public final g PL(String paramString)
  {
    AppMethodBeat.i(146533);
    paramString = (g)this.kQt.get(paramString);
    AppMethodBeat.o(146533);
    return paramString;
  }
  
  public final boolean PM(String paramString)
  {
    AppMethodBeat.i(146535);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    if (this.kQE.contains(paramString))
    {
      ad.i("MicroMsg.DefaultTencentMapView", "removeMapMarkerClusterGeometry id:%s", new Object[] { paramString });
      if ((this.kPX != null) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = this.kQD.iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          if (paramString.contains(f.a(localf)))
          {
            this.kPX.removeItem(localf);
            this.kQD.remove(localf);
            this.kQE.remove(paramString);
            if (localf.kRz > 0)
            {
              PN(localf.kRz);
              this.kQF.remove(Integer.valueOf(localf.kRz));
              this.kQH.remove(Integer.valueOf(localf.kRz));
            }
            ad.i("MicroMsg.DefaultTencentMapView", "remove MapMarker ClusterGeometry success id:%s", new Object[] { paramString });
            this.kPX.cluster();
          }
        }
      }
    }
    Object localObject = (g)this.kQt.get(paramString);
    if (localObject == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146535);
      return false;
    }
    if (((g)localObject).kRu != null) {
      ((g)localObject).kRu.remove();
    }
    if (((g)localObject).kRA != null)
    {
      if ((((g)localObject).kRA.getMarkerView() != null) && ((((g)localObject).kRA.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.d.d)((g)localObject).kRA.getMarkerView());
      }
      ((g)localObject).kRA.remove();
      this.kQt.remove(paramString + "#label");
    }
    ((g)localObject).kRB = null;
    this.kQt.remove(paramString);
    AppMethodBeat.o(146535);
    return true;
  }
  
  public final boolean PN(String paramString)
  {
    AppMethodBeat.i(199881);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s removeLabelMarker markerId:%s", new Object[] { this, paramString });
    g localg = (g)this.kQt.remove(paramString + "#label");
    if (localg == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(199881);
      return false;
    }
    if (localg.kRA != null)
    {
      if ((localg.kRA.getMarkerView() != null) && ((localg.kRA.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.d.d)localg.kRA.getMarkerView());
      }
      localg.kRA.remove();
    }
    AppMethodBeat.o(199881);
    return true;
  }
  
  public final Point a(b.i parami)
  {
    AppMethodBeat.i(199897);
    ad.i("MicroMsg.DefaultTencentMapView", "toScreenLocation");
    parami = new com.tencent.mapsdk.raster.model.LatLng(parami.latitude, parami.longitude);
    parami = this.kPJ.getMap().getProjection().toScreenLocation(parami);
    AppMethodBeat.o(199897);
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
    ad.v("MicroMsg.DefaultTencentMapView", "start map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    if ((paramFloat1 == -1.0F) && (paramFloat2 == -1.0F) && (paramFloat3 == -1.0F) && (paramDouble1 == -1.0D) && (paramDouble2 == -1.0D))
    {
      AppMethodBeat.o(146522);
      return;
    }
    final TencentMap localTencentMap = this.kPJ.getMap();
    if (localTencentMap != null)
    {
      if (paramBoolean)
      {
        X(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146464);
            CameraUpdate localCameraUpdate = a.b(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, this.hXP);
            ad.v("MicroMsg.DefaultTencentMapView", "doing map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(this.hXP), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
            localTencentMap.animateCamera(localCameraUpdate, a.bld(), a.t(a.this));
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
    ((CircleOptions)localObject1).center(new com.tencent.mapsdk.raster.model.LatLng(???.latitude, ???.longitude));
    ((CircleOptions)localObject1).radius(???.radius);
    ((CircleOptions)localObject1).strokeColor(???.strokeColor);
    ((CircleOptions)localObject1).strokeWidth(???.strokeWidth);
    ((CircleOptions)localObject1).fillColor(???.fillColor);
    localObject1 = this.kPJ.getMap().addCircle((CircleOptions)localObject1);
    synchronized (this.kQp)
    {
      this.kQp.add(localObject1);
      AppMethodBeat.o(146526);
      return;
    }
  }
  
  public final void a(b.k paramk, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    int i = 0;
    AppMethodBeat.i(146531);
    Object localObject1 = new PolylineOptions();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramk.kRO.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      b.i locali = (b.i)((Iterator)localObject3).next();
      ((List)localObject2).add(new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude));
    }
    ((PolylineOptions)localObject1).addAll((Iterable)localObject2);
    if ((paramk.kRT != null) && (paramk.kRT.size() > 0))
    {
      ad.i("MicroMsg.DefaultTencentMapView", "colorList size:%d ", new Object[] { Integer.valueOf(paramk.kRT.size()) });
      int j = paramk.kRT.size();
      localObject2 = new int[j];
      localObject3 = new int[j];
      while (i < j)
      {
        localObject2[i] = ((Integer)paramk.kRT.get(i)).intValue();
        localObject3[i] = i;
        i += 1;
      }
      ((PolylineOptions)localObject1).colors((int[])localObject2, (int[])localObject3);
    }
    for (;;)
    {
      ((PolylineOptions)localObject1).width(paramk.width);
      ((PolylineOptions)localObject1).setDottedLine(paramk.kRP);
      ((PolylineOptions)localObject1).edgeColor(paramk.borderColor);
      ((PolylineOptions)localObject1).edgeWidth(paramk.borderWidth);
      if (paramk.kRQ)
      {
        parama = parama.cz(paramk.kRR);
        ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(parama));
        if (parama == null) {
          ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), 2131230986)));
        }
      }
      ((PolylineOptions)localObject1).zIndex(1.0F);
      if ((!bt.isNullOrNil(paramk.buildingId)) && (!bt.isNullOrNil(paramk.floorName))) {
        ((PolylineOptions)localObject1).indoorInfo(new IndoorInfo(paramk.buildingId, paramk.floorName));
      }
      ((PolylineOptions)localObject1).arrowGap(paramk.kRS);
      ((PolylineOptions)localObject1).level(OverlayLevel.OverlayLevelAboveLabels);
      ((PolylineOptions)localObject1).lineCap(true);
      localObject1 = this.kPJ.getMap().addPolyline((PolylineOptions)localObject1);
      if (localObject1 != null) {
        break;
      }
      ad.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
      AppMethodBeat.o(146531);
      return;
      if (paramk.style != -1) {
        ((PolylineOptions)localObject1).color(paramk.style);
      } else {
        ((PolylineOptions)localObject1).color(paramk.color);
      }
    }
    if (bt.isNullOrNil(paramk.id)) {}
    for (parama = paramk.hashCode();; parama = paramk.id)
    {
      this.kQr.put(bt.bI(parama, paramk.toString()), localObject1);
      AppMethodBeat.o(146531);
      return;
    }
  }
  
  public final void a(b.l paraml)
  {
    this.kPL = paraml;
  }
  
  public final void a(b.m paramm)
  {
    this.kQc = paramm;
  }
  
  public final void a(b.o paramo)
  {
    this.kPN = paramo;
  }
  
  public final void a(b.p paramp)
  {
    this.kPM = paramp;
  }
  
  public final void a(b.s params)
  {
    this.kPO = params;
  }
  
  public final void a(b.w paramw)
  {
    AppMethodBeat.i(146499);
    this.kQg = paramw;
    this.kPJ.getMap().setTencentMapGestureListener(new TencentMap.TencentMapGestureListener()
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
    this.kPJ.getMap().setOnMapCameraChangeListener(new TencentMap.OnMapCameraChangeListener()
    {
      public final void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(146459);
        if (a.p(a.this) != null)
        {
          b.a locala = new b.a();
          locala.kRC = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.kRD = paramAnonymousCameraPosition.getBearing();
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
          locala.kRC = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.kRD = paramAnonymousCameraPosition.getBearing();
          locala.skew = paramAnonymousCameraPosition.getSkew();
          a.p(a.this).b(locala, a.q(a.this));
        }
        a.j(a.this);
        AppMethodBeat.o(146460);
      }
    });
    AppMethodBeat.o(146499);
  }
  
  public final void a(b.x paramx)
  {
    this.kQi = paramx;
  }
  
  public final void a(b.z paramz)
  {
    this.kQe = paramz;
  }
  
  public final void a(String paramString, int paramInt, b.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(146532);
    Polyline localPolyline = (Polyline)this.kQr.get(paramString);
    if (localPolyline == null)
    {
      ad.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
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
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s updateMarker markerId:%s", new Object[] { this, paramString });
    final g localg = PL(paramString);
    if (localg != null) {
      if (paramv.kRZ != null)
      {
        if (paramv.kRZ.view == null) {
          break label546;
        }
        localg.kRU.kRZ = paramv.kRZ;
        if ((localg.kRu == null) || (paramv.kRZ.kSg != b.v.a.kSk)) {
          break label500;
        }
        b(localg.kRu);
      }
    }
    label546:
    for (;;)
    {
      if (paramv.kSa != null)
      {
        localg.kRA.remove();
        PM(paramString + "#label");
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        com.tencent.mm.plugin.appbrand.widget.d.d locald2 = i.blg();
        com.tencent.mm.plugin.appbrand.widget.d.d locald1 = locald2;
        if (locald2 == null) {
          locald1 = new com.tencent.mm.plugin.appbrand.widget.d.d(this.context);
        }
        locald1.reset();
        locald1.setTextColor(paramv.kSa.color);
        locald1.setTextSize(paramv.kSa.kSb);
        locald1.setText(paramv.kSa.content);
        locald1.setTextPadding(paramv.kSa.padding);
        locald1.setGravity(paramv.kSa.jTE);
        locald1.A(paramv.kSa.kSc, paramv.kSa.borderWidth, paramv.kSa.borderColor, paramv.kSa.bgColor);
        locald1.setX(paramv.kSa.x);
        locald1.setY(paramv.kSa.y);
        locald1.eA(paramv.kSa.width, paramv.kSa.height);
        locald1.measure(0, 0);
        localMarkerOptions.anchor(locald1.getAnchorX(), locald1.getAnchorY());
        localMarkerOptions.markerView(locald1);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramv.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!bt.isNullOrNil(paramv.buildingId)) && (!bt.isNullOrNil(paramv.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
        }
        localg.kRA = this.kPJ.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", localg);
      }
      AppMethodBeat.o(182816);
      return;
      label500:
      if (localg.kRu != null) {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localg.kRu.refreshInfoWindow();
        }
        else
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199848);
              localg.kRu.refreshInfoWindow();
              AppMethodBeat.o(199848);
            }
          });
          continue;
          localg.kRB = null;
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
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199844);
        a.this.b(paramString, paramv, parama);
        AppMethodBeat.o(199844);
      }
    });
    AppMethodBeat.o(146536);
  }
  
  public final void a(final String paramString, ArrayList<b.i> arg2, long paramLong, boolean paramBoolean, b.r arg6)
  {
    AppMethodBeat.i(199886);
    g localg = PL(paramString);
    if ((localg == null) || (localg.kRu == null))
    {
      ad.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      ???.gz(false);
      AppMethodBeat.o(199886);
      return;
    }
    if (???.size() <= 0)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      ???.gz(false);
      AppMethodBeat.o(199886);
      return;
    }
    synchronized (this.kPV)
    {
      if (this.kPV.containsKey(paramString)) {
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199854);
            this.kRj.cancelAnimation();
            AppMethodBeat.o(199854);
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
    ??? = new MarkerTranslateAnimator(localg.kRu, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
    ???.addAnimatorListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(199857);
        ad.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationCancel");
        if (paramr != null) {
          paramr.bkJ();
        }
        synchronized (a.v(a.this))
        {
          a.v(a.this).remove(paramString);
          AppMethodBeat.o(199857);
          return;
        }
      }
      
      public final void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(199856);
        ad.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationEnd");
        if (paramr != null) {
          paramr.gz(true);
        }
        synchronized (a.v(a.this))
        {
          a.v(a.this).remove(paramString);
          AppMethodBeat.o(199856);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(199855);
        ad.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationStart");
        AppMethodBeat.o(199855);
      }
    });
    synchronized (this.kPV)
    {
      this.kPV.put(paramString, ???);
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199858);
          ad.d("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator start");
          paramArrayList.startAnimation();
          AppMethodBeat.o(199858);
        }
      });
      if (localg.kRA != null)
      {
        ad.d("MicroMsg.DefaultTencentMapView", "labelMarker do move animator");
        synchronized (this.kPW)
        {
          if (this.kPW.containsKey(paramString)) {
            m.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(199859);
                this.kRj.cancelAnimation();
                AppMethodBeat.o(199859);
              }
            });
          }
          ??? = new MarkerTranslateAnimator(localg.kRA, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
          ???.addAnimatorListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator arg1)
            {
              AppMethodBeat.i(199861);
              synchronized (a.w(a.this))
              {
                a.w(a.this).remove(paramString);
                AppMethodBeat.o(199861);
                return;
              }
            }
            
            public final void onAnimationEnd(Animator arg1)
            {
              AppMethodBeat.i(199860);
              synchronized (a.w(a.this))
              {
                a.w(a.this).remove(paramString);
                AppMethodBeat.o(199860);
                return;
              }
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          });
        }
      }
    }
    synchronized (this.kPW)
    {
      this.kPW.put(paramString, ???);
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199862);
          paramr.startAnimation();
          AppMethodBeat.o(199862);
        }
      });
      AppMethodBeat.o(199886);
      return;
      paramString = finally;
      AppMethodBeat.o(199886);
      throw paramString;
      paramString = finally;
      AppMethodBeat.o(199886);
      throw paramString;
    }
  }
  
  public final void a(String paramString, LinkedList<b.h> paramLinkedList, final b.r paramr)
  {
    AppMethodBeat.i(146539);
    paramString = PL(paramString);
    if ((paramString == null) || (paramString.kRu == null))
    {
      ad.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      paramr.gz(false);
      AppMethodBeat.o(146539);
      return;
    }
    if (paramLinkedList.size() <= 0)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      paramr.gz(false);
      AppMethodBeat.o(146539);
      return;
    }
    Object localObject = (b.h)paramLinkedList.get(0);
    ((b.h)localObject).kRL = paramString.kRu.getPosition().getLatitude();
    ((b.h)localObject).kRK = paramString.kRu.getPosition().getLongitude();
    int j = paramLinkedList.size();
    int i = 1;
    if (i < j)
    {
      localObject = (b.h)paramLinkedList.get(i - 1);
      b.h localh = (b.h)paramLinkedList.get(i);
      if (((b.h)localObject).kRD == 0.0F) {
        localh.kRK = ((b.h)localObject).longitude;
      }
      for (localh.kRL = ((b.h)localObject).latitude;; localh.kRL = paramString.kRu.getPosition().getLatitude())
      {
        i += 1;
        break;
        localh.kRK = paramString.kRu.getPosition().getLongitude();
      }
    }
    localObject = new c(paramLinkedList, paramString.kRu, this.kPJ);
    paramr = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(199851);
        ad.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
        if (paramr != null) {
          paramr.gz(true);
        }
        AppMethodBeat.o(199851);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(199850);
        ad.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
        AppMethodBeat.o(199850);
      }
    };
    ((c)localObject).wV.addListener(paramr);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199852);
        this.kRh.wV.start();
        AppMethodBeat.o(199852);
      }
    });
    if (paramString.kRA != null) {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199853);
          this.kRi.wV.start();
          AppMethodBeat.o(199853);
        }
      });
    }
    AppMethodBeat.o(146539);
  }
  
  public final boolean a(final int paramInt, b.e parame, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(199894);
    if (paramInt < 0)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, id < 0 or options is null");
      AppMethodBeat.o(199894);
      return false;
    }
    ad.i("MicroMsg.DefaultTencentMapView", "remove GroundOverlay id:%d, first ,and than add again", new Object[] { Integer.valueOf(paramInt) });
    tg(paramInt);
    ad.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    final GroundOverlayOptions localGroundOverlayOptions = new GroundOverlayOptions();
    if ((parame.kRG != null) && (parame.kRH != null))
    {
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng1.longitude = parame.kRG.longitude;
      localLatLng1.latitude = parame.kRG.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng2.longitude = parame.kRH.longitude;
      localLatLng2.latitude = parame.kRH.latitude;
      localGroundOverlayOptions.latLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng2, localLatLng1));
    }
    localGroundOverlayOptions.alpha(parame.alpha);
    localGroundOverlayOptions.visible(parame.visible);
    localGroundOverlayOptions.zIndex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.kRE)))
    {
      parame = parama.a(parame.kRE, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void M(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(199868);
          if (paramAnonymousBitmap != null)
          {
            localGroundOverlayOptions.bitmap(BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
            paramAnonymousBitmap = a.this.kPJ.getMap().addGroundOverlay(localGroundOverlayOptions);
            if (paramAnonymousBitmap == null)
            {
              ad.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
              AppMethodBeat.o(199868);
              return;
            }
            a.E(a.this).put(paramInt, paramAnonymousBitmap);
            ad.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(199868);
            return;
          }
          ad.e("MicroMsg.DefaultTencentMapView", "groundOverlay load bitmap is null");
          AppMethodBeat.o(199868);
        }
      });
      if (parame != null)
      {
        localGroundOverlayOptions.bitmap(BitmapDescriptorFactory.fromBitmap(parame));
        parame = this.kPJ.getMap().addGroundOverlay(localGroundOverlayOptions);
        if (parame == null)
        {
          ad.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
          AppMethodBeat.o(199894);
          return false;
        }
        this.kQM.put(String.valueOf(paramInt), parame);
        ad.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    while (parama == null)
    {
      AppMethodBeat.o(199894);
      return true;
    }
    ad.e("MicroMsg.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(199894);
    return false;
  }
  
  public final boolean a(b.ab arg1)
  {
    AppMethodBeat.i(146543);
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.kRO.iterator();
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
    localObject1 = this.kPJ.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.kQv)
    {
      this.kQv.add(localObject1);
      AppMethodBeat.o(146543);
      return true;
    }
  }
  
  public final boolean a(b.c paramc, b.n paramn, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(146528);
    if (bt.isNullOrNil(paramc.kRE))
    {
      AppMethodBeat.o(146528);
      return false;
    }
    Object localObject = parama.cz(paramc.kRE);
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
      i = com.tencent.mm.plugin.appbrand.z.g.vJ(((Bitmap)localObject).getHeight());
      if (paramc.width != 0) {
        break label217;
      }
    }
    label217:
    for (int j = com.tencent.mm.plugin.appbrand.z.g.vJ(((Bitmap)localObject).getWidth());; j = paramc.width)
    {
      localObject = new FrameLayout.LayoutParams(j, i);
      ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
      boolean bool = paramc.kRF;
      paramc = paramc.data;
      parama.setOnTouchListener(new a.7(this, bool, parama));
      parama.setOnClickListener(new a.8(this, bool, paramn, paramc));
      m.runOnUiThread(new a.10(this, parama, (FrameLayout.LayoutParams)localObject));
      AppMethodBeat.o(146528);
      return true;
      i = paramc.height;
      break;
    }
  }
  
  public final boolean a(b.d arg1, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(146541);
    if (bt.isNullOrNil(???.kRE))
    {
      AppMethodBeat.o(146541);
      return false;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(???.latitude, ???.longitude));
    parama = parama.cz(???.kRE);
    if ((parama != null) && (!parama.isRecycled())) {
      localMarkerOptions.icon(new BitmapDescriptor(parama));
    }
    localMarkerOptions.rotation(???.kRD);
    parama = this.kPJ.getMap().addMarker(localMarkerOptions);
    synchronized (this.kQu)
    {
      this.kQu.add(new c(parama));
      AppMethodBeat.o(146541);
      return true;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, final int paramInt1, final int paramInt2, b.q paramq)
  {
    AppMethodBeat.i(199888);
    boolean bool;
    if (this.kPJ.getMap() == null)
    {
      bool = false;
      if (bool)
      {
        this.kQC = paramq;
        this.kQK = paramBoolean2;
        this.kQL = paramBoolean1;
        ad.i("MicroMsg.DefaultTencentMapView", "initMapMarkerCluster zoomOnClick:%b, enableDefaultStyle:%b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      }
      AppMethodBeat.o(199888);
      return bool;
    }
    Runnable local36 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199867);
        if (a.b(a.this) == null) {
          a.a(a.this, new a.d(a.this, a.u(a.this), a.this.kPJ.getMap()));
        }
        if (a.z(a.this) == null)
        {
          a.a(a.this, new a.e(a.this, a.u(a.this), a.this.kPJ.getMap(), a.b(a.this)));
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
              AppMethodBeat.i(199866);
              boolean bool = a.this.b(paramAnonymous2Cluster);
              AppMethodBeat.o(199866);
              return bool;
            }
          });
          a.b(a.this).setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener() {});
          ad.i("MicroMsg.DefaultTencentMapView", "init map marker cluster finish");
          a.b(a.this).setRenderer(a.z(a.this));
          a.b(a.this).setClusterEnabled(true);
          a.this.kPJ.getMap().setOnMapCameraChangeListener(a.b(a.this));
          AppMethodBeat.o(199867);
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
      aq.f(local36);
    }
  }
  
  public final void b(final String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(199882);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    if (this.kQB.get())
    {
      ad.e("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s fail", new Object[] { this, paramString });
      AppMethodBeat.o(199882);
      return;
    }
    Object localObject1;
    g localg;
    MarkerOptions localMarkerOptions;
    final FrameLayout localFrameLayout;
    if (paramv.kRz > 0)
    {
      localObject1 = paramv.kRz;
      if (this.kQL)
      {
        ad.i("MicroMsg.DefaultTencentMapView", "cluster item use default style");
        AppMethodBeat.o(199882);
        return;
      }
      c((String)localObject1, paramv, parama);
      localg = new g();
      localg.data = paramv.data;
      localg.kRU = paramv;
      a((String)localObject1, localg);
      if ((!paramv.kRV) && (!TextUtils.isEmpty(paramString)))
      {
        localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        if (!bt.isNullOrNil(paramv.title)) {
          localMarkerOptions.title(paramv.title);
        }
        if (!bt.isNullOrNil(paramv.kRY)) {
          localMarkerOptions.contentDescription(paramv.kRY);
        }
        localMarkerOptions.rotation(paramv.kRD);
        localMarkerOptions.alpha(paramv.alpha);
        localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493687, null);
        final ImageView localImageView = (ImageView)localFrameLayout.findViewById(2131302158);
        final float f1 = paramv.kRW;
        final float f2 = paramv.kRX;
        Object localObject3 = null;
        Object localObject2 = localObject3;
        if (parama != null)
        {
          localObject2 = localObject3;
          if (!bt.isNullOrNil(paramv.kRE))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            localObject2 = parama.a(paramv.kRE, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void M(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(199845);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if ((a.this.PL(paramString) != null) && (a.this.PL(paramString).kRu != null))
                  {
                    paramAnonymousBitmap = a.this.PL(paramString).kRu;
                    if (paramAnonymousBitmap != null) {
                      paramAnonymousBitmap.setMarkerView(localFrameLayout);
                    }
                    ad.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                  }
                }
                AppMethodBeat.o(199845);
              }
            });
          }
        }
        if (localObject2 == null) {
          break label691;
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
      if ((!bt.isNullOrNil(paramv.buildingId)) && (!bt.isNullOrNil(paramv.floorName))) {
        localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
      }
      if (paramv.kRZ != null) {
        localMarkerOptions.infoWindowOffset(paramv.kRZ.kSh, paramv.kRZ.kSi);
      }
      localg.kRu = this.kPJ.getMap().addMarker(localMarkerOptions);
      if ((paramv.kRZ != null) && (paramv.kRZ.kSg == b.v.a.kSk)) {
        b(localg.kRu);
      }
      if (((!paramv.kRV) || (paramv.kRz != 0)) && (paramv.kSa != null)) {
        a((String)localObject1, paramv, localg);
      }
      AppMethodBeat.o(199882);
      return;
      if (paramv.kRV)
      {
        localObject1 = new b.aa();
        ((b.aa)localObject1).kSl = new b.i(paramv.latitude, paramv.longitude);
        ((b.aa)localObject1).id = paramString;
        a((b.aa)localObject1);
        c(paramString, paramv, parama);
      }
      localObject1 = paramString;
      break;
      label691:
      ad.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
    }
  }
  
  public final boolean b(final int paramInt, b.e parame, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(199896);
    if (!this.kQM.containsKey(String.valueOf(paramInt)))
    {
      ad.e("MicroMsg.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(199896);
      return false;
    }
    final GroundOverlay localGroundOverlay = (GroundOverlay)this.kQM.get(String.valueOf(paramInt));
    if (localGroundOverlay == null)
    {
      ad.e("MicroMsg.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay is null");
      AppMethodBeat.o(199896);
      return false;
    }
    ad.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((parame.kRG != null) && (parame.kRH != null))
    {
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng1.longitude = parame.kRG.longitude;
      localLatLng1.latitude = parame.kRG.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng2.longitude = parame.kRH.longitude;
      localLatLng2.latitude = parame.kRH.latitude;
      localGroundOverlay.setLatLongBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng2, localLatLng1));
    }
    localGroundOverlay.setAlpha(parame.alpha);
    localGroundOverlay.setVisibility(parame.visible);
    localGroundOverlay.setZindex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.kRE)))
    {
      parame = parama.a(parame.kRE, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void M(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(199869);
          if (paramAnonymousBitmap != null)
          {
            localGroundOverlay.setBitmap(BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
            ad.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(199869);
            return;
          }
          ad.e("MicroMsg.DefaultTencentMapView", "groundOverlay load bitmap is null");
          AppMethodBeat.o(199869);
        }
      });
      if (parame != null)
      {
        localGroundOverlay.setBitmap(BitmapDescriptorFactory.fromBitmap(parame));
        ad.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    while (parama == null)
    {
      AppMethodBeat.o(199896);
      return true;
    }
    ad.e("MicroMsg.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(199896);
    return false;
  }
  
  public final boolean b(Cluster<f> paramCluster)
  {
    AppMethodBeat.i(199887);
    ad.i("MicroMsg.DefaultTencentMapView", "onClusterClick");
    if (this.kQK)
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramCluster.getItems().iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((f)localIterator.next()).getPosition());
      }
      i(localLinkedList, 0);
    }
    if (this.kQC != null) {
      this.kQC.R(a(paramCluster, false));
    }
    AppMethodBeat.o(199887);
    return true;
  }
  
  public final b.ac bkO()
  {
    AppMethodBeat.i(146498);
    Object localObject2 = this.kPJ.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.j();
    ((b.j)localObject1).kRM = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.j)localObject1).kRN = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.ad();
    ((b.ad)localObject2).kSn = ((b.j)localObject1);
    localObject1 = new b.ac();
    ((b.ac)localObject1).kSm = ((b.ad)localObject2);
    AppMethodBeat.o(146498);
    return localObject1;
  }
  
  public final void bkP()
  {
    AppMethodBeat.i(146501);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.kQh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146461);
        if ((a.d(a.this) != null) && (a.r(a.this)))
        {
          double d1 = a.d(a.this).getLatitude();
          double d2 = a.d(a.this).getLongitude();
          a.this.kPJ.getIController().animateTo(d1, d2);
          ad.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        }
        AppMethodBeat.o(146461);
      }
    };
    if ((this.kQx != null) && (this.kQw))
    {
      this.kQh.run();
      this.kQh = null;
    }
    AppMethodBeat.o(146501);
  }
  
  public final b.f bkQ()
  {
    AppMethodBeat.i(146515);
    if (this.kQj != null)
    {
      localf = this.kQj;
      AppMethodBeat.o(146515);
      return localf;
    }
    b.f localf = bkM();
    AppMethodBeat.o(146515);
    return localf;
  }
  
  public boolean bkR()
  {
    return false;
  }
  
  public final b.i bkS()
  {
    AppMethodBeat.i(146519);
    Object localObject = this.kPJ.getMap().getMapCenter();
    localObject = new b.i(((com.tencent.mapsdk.raster.model.LatLng)localObject).getLatitude(), ((com.tencent.mapsdk.raster.model.LatLng)localObject).getLongitude());
    AppMethodBeat.o(146519);
    return localObject;
  }
  
  public final void bkT()
  {
    AppMethodBeat.i(146525);
    synchronized (this.kQp)
    {
      Iterator localIterator = this.kQp.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.kQp.clear();
    AppMethodBeat.o(146525);
  }
  
  public final void bkU()
  {
    AppMethodBeat.i(146527);
    m.runOnUiThread(new a.6(this));
    AppMethodBeat.o(146527);
  }
  
  public final void bkV()
  {
    AppMethodBeat.i(146529);
    Iterator localIterator = this.kQr.values().iterator();
    while (localIterator.hasNext()) {
      ((Polyline)localIterator.next()).remove();
    }
    this.kQr.clear();
    AppMethodBeat.o(146529);
  }
  
  public final void bkW()
  {
    AppMethodBeat.i(146534);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.kQt.values().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg.kRu != null) {
        localg.kRu.remove();
      }
      if (localg.kRA != null)
      {
        if ((localg.kRA.getMarkerView() != null) && ((localg.kRA.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.d.d)localg.kRA.getMarkerView());
        }
        localg.kRA.remove();
      }
    }
    this.kQt.clear();
    blb();
    AppMethodBeat.o(146534);
  }
  
  public final void bkX()
  {
    AppMethodBeat.i(146540);
    synchronized (this.kQu)
    {
      Iterator localIterator = this.kQu.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).kRu.remove();
      }
    }
    this.kQu.clear();
    AppMethodBeat.o(146540);
  }
  
  public final void bkY()
  {
    AppMethodBeat.i(146542);
    synchronized (this.kQv)
    {
      Iterator localIterator = this.kQv.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.kQv.clear();
    AppMethodBeat.o(146542);
  }
  
  public final boolean bla()
  {
    return (this.kPX != null) && (this.kPY != null);
  }
  
  public final void c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(146516);
    com.tencent.mapsdk.raster.model.LatLng localLatLng = this.kPJ.getMap().getMapCenter();
    this.kPJ.setMapAnchor(paramFloat1, paramFloat2);
    a(localLatLng.getLatitude(), localLatLng.getLongitude(), -1.0F, -1.0F, -1.0F, paramBoolean);
    AppMethodBeat.o(146516);
  }
  
  public final b.i d(Point paramPoint)
  {
    AppMethodBeat.i(199898);
    ad.i("MicroMsg.DefaultTencentMapView", "fromScreenLocation");
    paramPoint = this.kPJ.getMap().getProjection().fromScreenLocation(paramPoint);
    paramPoint = new b.i(paramPoint.getLatitude(), paramPoint.getLongitude());
    AppMethodBeat.o(199898);
    return paramPoint;
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146514);
    this.kPJ.getMap().setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(146514);
  }
  
  public final void f(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146500);
    a(paramDouble1, paramDouble2, -1.0F, -1.0F, -1.0F, true);
    AppMethodBeat.o(146500);
  }
  
  public void g(SurfaceTexture paramSurfaceTexture) {}
  
  public final void gA(boolean paramBoolean)
  {
    AppMethodBeat.i(146505);
    this.kPJ.getUiSettings().setZoomGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146505);
  }
  
  public final void gB(boolean paramBoolean)
  {
    AppMethodBeat.i(146506);
    this.kPJ.getUiSettings().setScrollGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146506);
  }
  
  public final void gC(boolean paramBoolean)
  {
    AppMethodBeat.i(146507);
    this.kPJ.getUiSettings().setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146507);
  }
  
  public final void gD(boolean paramBoolean)
  {
    AppMethodBeat.i(146508);
    this.kPJ.getUiSettings().setCompassEnabled(paramBoolean);
    AppMethodBeat.o(146508);
  }
  
  public final void gE(boolean paramBoolean)
  {
    AppMethodBeat.i(146509);
    this.kPJ.getMap().set3DEnable(paramBoolean);
    AppMethodBeat.o(146509);
  }
  
  public final void gF(boolean paramBoolean)
  {
    AppMethodBeat.i(146510);
    this.kPJ.getUiSettings().setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146510);
  }
  
  public final void gG(boolean paramBoolean)
  {
    AppMethodBeat.i(146511);
    this.kPJ.getMap().setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(146511);
  }
  
  public final void gH(boolean paramBoolean)
  {
    AppMethodBeat.i(146512);
    this.kPJ.getMap().setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(146512);
  }
  
  public final void gI(boolean paramBoolean)
  {
    AppMethodBeat.i(146513);
    this.kPJ.getMap().setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(146513);
  }
  
  public final void gJ(boolean paramBoolean)
  {
    AppMethodBeat.i(146517);
    this.kPJ.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
    AppMethodBeat.o(146517);
  }
  
  public final void gK(boolean paramBoolean)
  {
    AppMethodBeat.i(146518);
    this.kPJ.getUiSettings().setScaleControlsEnabled(paramBoolean);
    AppMethodBeat.o(146518);
  }
  
  public final void gL(boolean paramBoolean)
  {
    AppMethodBeat.i(146544);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.kQw = paramBoolean;
    d locald;
    if (paramBoolean)
    {
      if (this.kQx != null)
      {
        locald = this.kQx;
        if (locald.kRu != null) {
          locald.kRu.setVisible(true);
        }
      }
      ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.kQy, bkZ());
      g.a(this);
      AppMethodBeat.o(146544);
      return;
    }
    if (this.kQx != null)
    {
      locald = this.kQx;
      if (locald.kRu != null) {
        locald.kRu.setVisible(false);
      }
    }
    ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.kQy, bkZ());
    g.b(this);
    AppMethodBeat.o(146544);
  }
  
  public final float getRotate()
  {
    AppMethodBeat.i(146503);
    float f = this.kPJ.getMap().getCameraPosition().getBearing();
    AppMethodBeat.o(146503);
    return f;
  }
  
  public final float getSkew()
  {
    AppMethodBeat.i(146504);
    float f = this.kPJ.getMap().getCameraPosition().getSkew();
    AppMethodBeat.o(146504);
    return f;
  }
  
  public final View getView()
  {
    return this.container;
  }
  
  public final float getZoom()
  {
    AppMethodBeat.i(199875);
    float f = this.kPJ.getMap().getCameraPosition().getZoom();
    AppMethodBeat.o(199875);
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
  
  public final void onDestroy()
  {
    AppMethodBeat.i(146497);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.kQB.set(true);
    this.kPJ.getMap().setOnMapCameraChangeListener(null);
    bkW();
    bkV();
    bkV();
    bkU();
    bkX();
    bkY();
    Object localObject = this.kQk.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CustomLayer)((Iterator)localObject).next()).remove();
    }
    this.kQk.clear();
    if (this.kPJ != null)
    {
      this.kPJ.getMap().setOnMapPoiClickListener(null);
      this.kPJ.clean();
      this.kPJ.onDestroy();
    }
    if (this.kQx != null)
    {
      localObject = this.kQx;
      if (((d)localObject).kRu != null)
      {
        ((d)localObject).kRu.remove();
        ((d)localObject).kRu = null;
      }
      this.kQx = null;
    }
    AppMethodBeat.o(146497);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(146494);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.dsD.setVisibility(0);
      if (this.kQa == null) {
        this.kQa = getSurfaceView();
      }
      if (this.kQa != null)
      {
        aq.o(this.kQb, 100L);
        this.kPJ.setVisibility(4);
        this.kPJ.getMap().getScreenShot(new TencentMap.OnScreenShotListener()
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
      this.kPK = true;
      if (this.kQw)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.kQy, bkZ());
        g.b(this);
      }
      AppMethodBeat.o(146494);
      return;
      ad.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
      break;
      this.kPJ.onPause();
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(146493);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.dsD.setVisibility(4);
      this.kPJ.setVisibility(0);
      this.kPJ.onResume();
      bkN();
    }
    for (;;)
    {
      this.kPK = false;
      if (this.kQw)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.kQy, bkZ());
        g.a(this);
      }
      AppMethodBeat.o(146493);
      return;
      this.kPJ.onResume();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2) {}
  
  public void onTouchEvent(MotionEvent paramMotionEvent) {}
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(199876);
    this.kPJ.getMap().setIndoorMaskColor(paramInt);
    AppMethodBeat.o(199876);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(182813);
    ad.i("MicroMsg.DefaultTencentMapView", "map:%s setMapStyle: %d", new Object[] { this, Integer.valueOf(paramInt) });
    this.kPJ.getMap().setMapStyle(paramInt);
    AppMethodBeat.o(182813);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(199879);
    this.kPJ.getMap().setMaxZoomLevel(paramInt);
    AppMethodBeat.o(199879);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(199880);
    this.kPJ.getMap().setMinZoomLevel(paramInt);
    AppMethodBeat.o(199880);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(199877);
    this.kPJ.getMap().setPoisEnabled(paramBoolean);
    AppMethodBeat.o(199877);
  }
  
  public final boolean tg(int paramInt)
  {
    AppMethodBeat.i(199895);
    if (!this.kQM.containsKey(String.valueOf(paramInt)))
    {
      ad.e("MicroMsg.DefaultTencentMapView", "removeGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(199895);
      return false;
    }
    ad.i("MicroMsg.DefaultTencentMapView", "removeGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    GroundOverlay localGroundOverlay = (GroundOverlay)this.kQM.remove(String.valueOf(paramInt));
    if (localGroundOverlay != null)
    {
      localGroundOverlay.remove();
      AppMethodBeat.o(199895);
      return true;
    }
    AppMethodBeat.o(199895);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(146547);
    String str = "DefaultTencentMapView{mapId=" + this.kPI + '}';
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
      paramMarker = a.this.PL((String)paramMarker.getTag());
      if (paramMarker == null)
      {
        ad.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (paramMarker.kRU == null)
      {
        ad.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      b.v.a locala = paramMarker.kRU.kRZ;
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
        if (paramMarker.kRB == null) {
          paramMarker.kRB = new ImageView(a.u(a.this));
        }
        localObject = com.tencent.mm.sdk.platformtools.g.ga(locala.view);
        if (localObject == null) {
          ad.e("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view exist but bitmap is null");
        }
        paramMarker.kRB.setImageBitmap((Bitmap)localObject);
        paramMarker = paramMarker.kRB;
        AppMethodBeat.o(146488);
        return paramMarker;
      }
      a locala1 = a.this;
      Object localObject = i.blf();
      paramMarker = (Marker)localObject;
      if (localObject == null) {
        paramMarker = new com.tencent.mm.plugin.appbrand.widget.d.b(locala1.context);
      }
      paramMarker.setText("");
      paramMarker.setTextSize(12);
      paramMarker.setTextColor(com.tencent.mm.plugin.appbrand.widget.d.b.njG);
      paramMarker.setTitlePadding(0);
      paramMarker.setGravity("center");
      int i = com.tencent.mm.plugin.appbrand.widget.d.b.njH;
      paramMarker.A(0, 0, i, i);
      paramMarker.setText(locala.content);
      paramMarker.setTextSize(locala.kSb);
      paramMarker.setTextColor(locala.color);
      paramMarker.setTitlePadding(locala.padding);
      paramMarker.setGravity(locala.jTE);
      paramMarker.A(locala.kSc, locala.borderWidth, locala.borderColor, locala.bgColor);
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
  
  public final class c
  {
    Marker kRu;
    
    public c(Marker paramMarker)
    {
      this.kRu = paramMarker;
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
      AppMethodBeat.i(199870);
      super.onCameraChange(paramCameraPosition);
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.kRC = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.kRD = paramCameraPosition.getBearing();
        locala.skew = paramCameraPosition.getSkew();
        a.p(a.this).a(locala, a.q(a.this));
      }
      AppMethodBeat.o(199870);
    }
    
    public final void onCameraChangeFinish(CameraPosition paramCameraPosition)
    {
      AppMethodBeat.i(199871);
      super.onCameraChangeFinish(paramCameraPosition);
      ad.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish");
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.kRC = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.kRD = paramCameraPosition.getBearing();
        locala.skew = paramCameraPosition.getSkew();
        a.p(a.this).b(locala, a.q(a.this));
      }
      a.j(a.this);
      if ((a.b(a.this) != null) && (a.b(a.this).getAlgorithm().getClusters(paramCameraPosition.getZoom()).size() > 0))
      {
        paramCameraPosition = ((NonHierarchicalDistanceBasedAlgorithm)((PreCachingAlgorithmDecorator)a.b(a.this).getAlgorithm()).getAlgorithm()).getClusters(paramCameraPosition.getZoom());
        ad.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish cluster size:%d", new Object[] { Integer.valueOf(paramCameraPosition.size()) });
        paramCameraPosition = paramCameraPosition.iterator();
        while (paramCameraPosition.hasNext()) {
          ad.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish cluster item size:%d", new Object[] { Integer.valueOf(((Cluster)paramCameraPosition.next()).getItems().size()) });
        }
      }
      AppMethodBeat.o(199871);
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
      AppMethodBeat.i(199873);
      super.onBeforeClusterRendered(paramCluster, paramMarkerOptions);
      ad.i("MicroMsg.DefaultTencentMapView", "onBeforeClusterRendered, cluster size:%d", new Object[] { Integer.valueOf(paramCluster.getItems().size()) });
      paramMarkerOptions = paramCluster.getItems().iterator();
      while (paramMarkerOptions.hasNext())
      {
        a.f localf = (a.f)paramMarkerOptions.next();
        if (localf.kRz > 0) {
          a.this.PN(localf.kRz);
        } else {
          a.this.PN(a.f.a(localf));
        }
      }
      if (a.D(a.this) != null) {
        a.D(a.this).o(a.a(a.this, paramCluster));
      }
      AppMethodBeat.o(199873);
    }
  }
  
  static final class f
    implements ClusterItem
  {
    private String id;
    private com.tencent.mapsdk.raster.model.LatLng kRy;
    int kRz;
    
    f(String paramString, com.tencent.mapsdk.raster.model.LatLng paramLatLng)
    {
      this.id = paramString;
      this.kRy = paramLatLng;
    }
    
    public final com.tencent.mapsdk.raster.model.LatLng getPosition()
    {
      return this.kRy;
    }
  }
  
  public static final class g
    extends b.u
  {
    public Marker kRA;
    public ImageView kRB;
    public Marker kRu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.a
 * JD-Core Version:    0.7.0.1
 */