package com.tencent.mm.plugin.appbrand.jsapi.l.a;

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
import com.tencent.mm.plugin.appbrand.widget.f.c;
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
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionItem;
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
  private static long oWT;
  private static final String oWv;
  FrameLayout container;
  Context context;
  private ImageView fDJ;
  private long lastCheckTime;
  private Object lockObj;
  private Object mLock;
  private int mMapType;
  private boolean oWA;
  private volatile HashMap<String, MarkerTranslateAnimator> oWB;
  private volatile HashMap<String, MarkerTranslateAnimator> oWC;
  private volatile ClusterManager<f> oWD;
  private DefaultClusterRenderer<f> oWE;
  private boolean oWF;
  private boolean oWG;
  SurfaceView oWH;
  private Runnable oWI;
  private b.m oWJ;
  private b.y oWK;
  private b.z oWL;
  private boolean oWM;
  private b.w oWN;
  private Runnable oWO;
  private b.x oWP;
  private b.f oWQ;
  private Map<String, CustomLayer> oWR;
  private ArrayList<String> oWS;
  private Queue<Runnable> oWU;
  private CancelableCallback oWV;
  public ArrayList<Circle> oWW;
  public ArrayList<b> oWX;
  private Map<String, Polyline> oWY;
  private a oWZ;
  private String oWo;
  protected final SoSoMapView oWp;
  private boolean oWq;
  private b.l oWr;
  private b.p oWs;
  private b.o oWt;
  private b.s oWu;
  private String oWw;
  private String oWx;
  private int oWy;
  private boolean oWz;
  private Map<String, g> oXa;
  public ArrayList<c> oXb;
  public ArrayList<Polygon> oXc;
  private boolean oXd;
  private d oXe;
  private com.tencent.mm.plugin.appbrand.utils.b.a.b oXf;
  private final int oXg;
  private AtomicBoolean oXh;
  private AtomicBoolean oXi;
  private b.q oXj;
  private ArrayList<f> oXk;
  private ArrayList<String> oXl;
  private ArrayList<Integer> oXm;
  private AtomicInteger oXn;
  private HashMap<Integer, Cluster<f>> oXo;
  private HashMap<String, b.v> oXp;
  private com.tencent.mm.plugin.appbrand.f.a oXq;
  boolean oXr;
  boolean oXs;
  private HashMap<String, GroundOverlay> oXt;
  
  static
  {
    AppMethodBeat.i(146554);
    oWv = com.tencent.mm.plugin.appbrand.ac.b.fa("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    oWT = 500L;
    AppMethodBeat.o(146554);
  }
  
  public a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146490);
    this.oWB = new HashMap();
    this.oWC = new HashMap();
    this.oWF = false;
    this.oWG = false;
    this.mLock = new Object();
    this.oWI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146485);
        a.this.oWH.setVisibility(4);
        AppMethodBeat.o(146485);
      }
    };
    this.oWM = false;
    this.oWR = new ConcurrentHashMap();
    this.oWS = new ArrayList();
    this.oWU = new LinkedList();
    this.oWV = new CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(187075);
        a.s(a.this).poll();
        if (!a.s(a.this).isEmpty()) {
          ((Runnable)a.s(a.this).peek()).run();
        }
        AppMethodBeat.o(187075);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(187072);
        a.s(a.this).poll();
        if (!a.s(a.this).isEmpty()) {
          ((Runnable)a.s(a.this).peek()).run();
        }
        AppMethodBeat.o(187072);
      }
    };
    this.oWW = new ArrayList();
    this.oWX = new ArrayList();
    this.oWY = new ConcurrentHashMap();
    this.oWZ = new a();
    this.oXa = new ConcurrentHashMap();
    this.oXb = new ArrayList();
    this.oXc = new ArrayList();
    this.oXf = new com.tencent.mm.plugin.appbrand.utils.b.a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, final com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(187273);
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.Map.DefaultTencentMapView", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(187273);
          return;
        }
        Log.d("MicroMsg.Map.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude) });
        if (!a.bST())
        {
          Log.w("MicroMsg.Map.DefaultTencentMapView", "refresh location fail, no perrmission");
          AppMethodBeat.o(187273);
          return;
        }
        if ((!a.r(a.this)) || (a.y(a.this)))
        {
          AppMethodBeat.o(187273);
          return;
        }
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189666);
            d locald;
            double d1;
            double d2;
            if (a.this.oWp != null)
            {
              if (a.d(a.this) == null)
              {
                a.a(a.this, new d(a.u(a.this)));
                locald = a.d(a.this);
                localObject = a.this.oWp;
                com.tencent.mm.plugin.appbrand.utils.b.a.a locala = paramAnonymousa;
                MarkerOptions localMarkerOptions = new MarkerOptions();
                localMarkerOptions.anchor(0.5F, 0.5F);
                localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(locala.latitude, locala.longitude));
                localMarkerOptions.markerView(locald);
                localMarkerOptions.zIndex(2147483647);
                localMarkerOptions.flat(true);
                localMarkerOptions.tag("AnchorPoint");
                locald.oYb = ((SoSoMapView)localObject).getMap().addMarker(localMarkerOptions);
              }
              locald = a.d(a.this);
              d1 = paramAnonymousa.latitude;
              d2 = paramAnonymousa.longitude;
              Object localObject = paramAnonymousa.provider;
              double d3 = paramAnonymousa.fqE;
              if ((locald.oZa != -1.0D) || (locald.oZb != -1.0D)) {
                break label398;
              }
              locald.oZa = d1;
              locald.oYY = d1;
              locald.oZb = d2;
              locald.oYZ = d2;
              if ((locald.oZa != -1.0D) && (locald.oZb != -1.0D)) {
                locald.oZf = f.a(locald.oZb, locald.oZa, d2, d1, (String)localObject, d3);
              }
              if ((locald.oZd != 900.0F) && (locald.oZc != 900.0F)) {
                break label433;
              }
              float f = (float)f.g(d1, d2);
              locald.oZc = f;
              locald.oZd = f;
            }
            for (;;)
            {
              if (locald.oYb != null) {
                locald.oYb.setPosition(new com.tencent.mapsdk.raster.model.LatLng(d1, d2));
              }
              AppMethodBeat.o(189666);
              return;
              label398:
              locald.oZa = locald.oYY;
              locald.oZb = locald.oYZ;
              locald.oYZ = d2;
              locald.oYY = d1;
              break;
              label433:
              locald.oZd = locald.oZc;
              locald.oZc = ((float)f.g(d1, d2));
            }
          }
        });
        AppMethodBeat.o(187273);
      }
    };
    this.lastCheckTime = 0L;
    this.oXg = 500;
    this.oXh = new AtomicBoolean(false);
    this.oXi = new AtomicBoolean(false);
    this.lockObj = new Object();
    this.oXk = new ArrayList();
    this.oXl = new ArrayList();
    this.oXm = new ArrayList();
    this.oXn = new AtomicInteger(100);
    this.oXo = new HashMap();
    this.oXp = new HashMap();
    this.oXt = new HashMap();
    this.context = paramContext;
    this.oWo = paramString;
    this.container = new FrameLayout(paramContext);
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.container.setBackgroundColor(0);
    this.container.setLayoutParams(paramString);
    this.oWp = new SoSoMapView(paramContext, I(paramMap));
    this.container.addView(this.oWp, new FrameLayout.LayoutParams(-1, -1));
    this.fDJ = new ImageView(paramContext);
    this.fDJ.setScaleType(ImageView.ScaleType.FIT_XY);
    this.container.addView(this.fDJ, new ViewGroup.LayoutParams(-1, -1));
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s, init", new Object[] { this });
    this.oWp.getMap().setInfoWindowAdapter(this.oWZ);
    this.oWp.getMap().setMapAnchor(0.5F, 0.5F);
    this.oWp.getMap().enableMultipleInfowindow(true);
    this.oWp.getMap().setMapStyle(this.oWy);
    paramContext = this.oWp.getMap();
    if (this.oWA) {}
    for (int i = 1008;; i = 1000)
    {
      paramContext.setMapType(i);
      this.oWp.getMap().setHandDrawMapEnable(this.oWz);
      this.oWp.getMap().setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener()
      {
        public final void onInfoWindowClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146458);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146458);
            return;
          }
          paramAnonymousMarker = a.this.ahK((String)paramAnonymousMarker.getTag());
          if (paramAnonymousMarker == null)
          {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          if (a.a(a.this) == null)
          {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          a.a(a.this).a(paramAnonymousMarker);
          AppMethodBeat.o(146458);
        }
      });
      this.oWp.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146468);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146468);
            return false;
          }
          Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", new Object[] { this, paramAnonymousMarker.getTag() });
          if ((Util.isNullOrNil((String)paramAnonymousMarker.getTag())) && (a.b(a.this) != null) && (((a.e)a.b(a.this).getRenderer()).getCluster(paramAnonymousMarker) != null))
          {
            paramAnonymousMarker = ((a.e)a.b(a.this).getRenderer()).getCluster(paramAnonymousMarker);
            bool = a.this.b(paramAnonymousMarker);
            AppMethodBeat.o(146468);
            return bool;
          }
          if (Util.isNullOrNil((String)paramAnonymousMarker.getTag()))
          {
            Log.w("MicroMsg.Map.DefaultTencentMapView", "realMarker.getTag is null, return");
            AppMethodBeat.o(146468);
            return false;
          }
          if (((String)paramAnonymousMarker.getTag()).endsWith("AnchorPoint"))
          {
            if ((a.c(a.this) != null) && (a.d(a.this) != null))
            {
              Log.w("MicroMsg.Map.DefaultTencentMapView", "click anchor point");
              a.c(a.this).c(a.d(a.this).getLatitude(), a.d(a.this).getLongitude());
            }
            AppMethodBeat.o(146468);
            return true;
          }
          a.g localg = a.this.ahK((String)paramAnonymousMarker.getTag());
          if (localg == null)
          {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return false;
          }
          if (a.e(a.this) == null)
          {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return false;
          }
          if (localg.oYC != null)
          {
            if (!((String)paramAnonymousMarker.getTag()).endsWith("#label")) {
              break label443;
            }
            Log.w("MicroMsg.Map.DefaultTencentMapView", "realMarker.getTag is label marker, do nothing");
          }
          for (;;)
          {
            if (localg.oYb != null) {
              localg.oYb.set2Top();
            }
            if (localg.oYh != null) {
              localg.oYh.set2Top();
            }
            Object localObject;
            if (a.d(a.this) != null)
            {
              localObject = a.d(a.this);
              if (((d)localObject).oYb != null) {
                ((d)localObject).oYb.set2Top();
              }
            }
            if (localg.oYC.oYg <= 0) {
              break;
            }
            a.a(a.this, localg.oYC.oYg);
            AppMethodBeat.o(146468);
            return true;
            label443:
            b.v.a locala = localg.oYC.oYI;
            if (localg.oYb != null) {
              localObject = localg.oYb;
            }
            for (;;)
            {
              if ((locala != null) && (locala.oYP == b.v.a.oYS) && (localObject != null))
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
            Log.w("MicroMsg.Map.DefaultTencentMapView", "realMarker.getTag is label marker, return");
            bool = a.f(a.this).c(localg);
            AppMethodBeat.o(146468);
            return bool;
          }
          boolean bool = a.e(a.this).b(localg);
          AppMethodBeat.o(146468);
          return bool;
        }
      });
      this.oWp.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener()
      {
        public final void onMapClick(com.tencent.mapsdk.raster.model.LatLng paramAnonymousLatLng)
        {
          AppMethodBeat.i(146478);
          Iterator localIterator = a.g(a.this).values().iterator();
          while (localIterator.hasNext())
          {
            a.g localg = (a.g)localIterator.next();
            if ((localg.oYC != null) && (localg.oYC.oYI != null) && (localg.oYC.oYI.oYP == b.v.a.oYS) && (localg.oYb != null) && (localg.oYb.isInfoWindowShown())) {
              localg.oYb.hideInfoWindow();
            }
          }
          if (a.h(a.this) != null)
          {
            a.h(a.this).d(paramAnonymousLatLng.getLongitude(), paramAnonymousLatLng.getLatitude());
            AppMethodBeat.o(146478);
            return;
          }
          AppMethodBeat.o(146478);
        }
      });
      this.oWp.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener()
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
              a.this.ahH(str);
            }
            a.l(a.this).clear();
          }
          AppMethodBeat.o(146479);
        }
      });
      this.oWp.getMap().setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener()
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
      this.oWp.getMap().setOnIndoorStateChangeListener(new TencentMap.OnIndoorStateChangeListener()
      {
        public final boolean onIndoorBuildingDeactivated()
        {
          AppMethodBeat.i(146483);
          Log.v("MicroMsg.Map.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
          if (a.n(a.this) != null)
          {
            b.f localf = a.bSR();
            a.a(a.this, localf);
            a.n(a.this).a(localf);
          }
          AppMethodBeat.o(146483);
          return true;
        }
        
        public final boolean onIndoorBuildingFocused()
        {
          AppMethodBeat.i(146481);
          Log.v("MicroMsg.Map.DefaultTencentMapView", "[onIndoorBuildingFocused]");
          AppMethodBeat.o(146481);
          return true;
        }
        
        public final boolean onIndoorLevelActivated(IndoorBuilding paramAnonymousIndoorBuilding)
        {
          AppMethodBeat.i(146482);
          Log.v("MicroMsg.Map.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", new Object[] { paramAnonymousIndoorBuilding });
          if (a.n(a.this) != null)
          {
            b.f localf = new b.f();
            localf.buildingId = paramAnonymousIndoorBuilding.getBuidlingId();
            localf.buildingName = paramAnonymousIndoorBuilding.getBuildingName();
            localf.oYq = new LinkedList();
            Iterator localIterator = paramAnonymousIndoorBuilding.getLevels().iterator();
            while (localIterator.hasNext())
            {
              IndoorLevel localIndoorLevel = (IndoorLevel)localIterator.next();
              b.g localg = new b.g();
              localg.floorName = localIndoorLevel.getName();
              localf.oYq.add(localg);
            }
            localf.oYr = paramAnonymousIndoorBuilding.getActiveLevelIndex();
            a.a(a.this, localf);
            a.n(a.this).a(localf);
          }
          AppMethodBeat.o(146482);
          return true;
        }
      });
      Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
      this.oWp.onCreate(null);
      onResume();
      AppMethodBeat.o(146490);
      return;
    }
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
    Log.v("MicroMsg.Map.DefaultTencentMapView", "tencentMap.getCameraPosition:%s rotate:%f skew:%f", new Object[] { paramTencentMap.getCameraPosition(), Float.valueOf(paramTencentMap.getCameraPosition().getBearing()), Float.valueOf(paramTencentMap.getCameraPosition().getSkew()) });
    if (paramFloat1 != -1.0F)
    {
      ((CameraPosition.Builder)localObject).zoom(paramFloat1);
      Log.i("MicroMsg.Map.DefaultTencentMapView", "map_scale zoom:%f", new Object[] { Float.valueOf(paramFloat1) });
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
    //   0: ldc_w 613
    //   3: invokestatic 247	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_2
    //   9: ifeq +211 -> 220
    //   12: aload_0
    //   13: getfield 355	com/tencent/mm/plugin/appbrand/jsapi/l/a/a:oXn	Ljava/util/concurrent/atomic/AtomicInteger;
    //   16: invokevirtual 617	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 349	com/tencent/mm/plugin/appbrand/jsapi/l/a/a:oXm	Ljava/util/ArrayList;
    //   24: iload_3
    //   25: invokestatic 622	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 626	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 357	com/tencent/mm/plugin/appbrand/jsapi/l/a/a:oXo	Ljava/util/HashMap;
    //   36: iload_3
    //   37: invokestatic 622	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aload_1
    //   41: invokevirtual 629	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_1
    //   46: invokeinterface 635 1 0
    //   51: invokeinterface 641 1 0
    //   56: astore 4
    //   58: aload 4
    //   60: invokeinterface 647 1 0
    //   65: ifeq +29 -> 94
    //   68: aload 4
    //   70: invokeinterface 651 1 0
    //   75: checkcast 117	com/tencent/mm/plugin/appbrand/jsapi/l/a/a$f
    //   78: iload_3
    //   79: putfield 654	com/tencent/mm/plugin/appbrand/jsapi/l/a/a$f:oYg	I
    //   82: goto -24 -> 58
    //   85: astore_1
    //   86: ldc_w 613
    //   89: invokestatic 266	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: areturn
    //   94: new 656	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 657	org/json/JSONObject:<init>	()V
    //   101: astore 4
    //   103: aload 4
    //   105: ldc_w 659
    //   108: iload_3
    //   109: invokevirtual 662	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   112: pop
    //   113: new 656	org/json/JSONObject
    //   116: dup
    //   117: invokespecial 657	org/json/JSONObject:<init>	()V
    //   120: astore 5
    //   122: aload 5
    //   124: ldc_w 664
    //   127: aload_1
    //   128: invokeinterface 668 1 0
    //   133: invokevirtual 672	com/tencent/mapsdk/raster/model/LatLng:getLatitude	()D
    //   136: invokevirtual 675	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 5
    //   142: ldc_w 677
    //   145: aload_1
    //   146: invokeinterface 668 1 0
    //   151: invokevirtual 680	com/tencent/mapsdk/raster/model/LatLng:getLongitude	()D
    //   154: invokevirtual 675	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 682
    //   163: aload 5
    //   165: invokevirtual 685	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: new 600	org/json/JSONArray
    //   172: dup
    //   173: invokespecial 601	org/json/JSONArray:<init>	()V
    //   176: astore 5
    //   178: aload_1
    //   179: invokeinterface 635 1 0
    //   184: invokeinterface 641 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 647 1 0
    //   196: ifeq +64 -> 260
    //   199: aload 5
    //   201: aload_1
    //   202: invokeinterface 651 1 0
    //   207: checkcast 117	com/tencent/mm/plugin/appbrand/jsapi/l/a/a$f
    //   210: invokestatic 688	com/tencent/mm/plugin/appbrand/jsapi/l/a/a$f:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/l/a/a$f;)Ljava/lang/String;
    //   213: invokevirtual 608	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   216: pop
    //   217: goto -27 -> 190
    //   220: aload_1
    //   221: invokeinterface 635 1 0
    //   226: invokeinterface 641 1 0
    //   231: astore 4
    //   233: aload 4
    //   235: invokeinterface 647 1 0
    //   240: ifeq -146 -> 94
    //   243: aload 4
    //   245: invokeinterface 651 1 0
    //   250: checkcast 117	com/tencent/mm/plugin/appbrand/jsapi/l/a/a$f
    //   253: getfield 654	com/tencent/mm/plugin/appbrand/jsapi/l/a/a$f:oYg	I
    //   256: istore_3
    //   257: goto -163 -> 94
    //   260: aload 4
    //   262: ldc_w 690
    //   265: aload 5
    //   267: invokevirtual 685	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   270: pop
    //   271: ldc_w 613
    //   274: invokestatic 266	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      Log.e("MicroMsg.Map.DefaultTencentMapView", "markerIcon is null, err");
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
      f = com.tencent.mm.plugin.appbrand.ac.g.Di(paramBitmap.getWidth());
      paramFloat1 = com.tencent.mm.plugin.appbrand.ac.g.Di(paramBitmap.getHeight());
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
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.oXa.put(paramString, paramg);
    AppMethodBeat.o(146538);
  }
  
  private void a(String paramString, b.v paramv, g paramg)
  {
    AppMethodBeat.i(187724);
    if (ahK(paramString + "#label") != null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker label is exist, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(187724);
      return;
    }
    if ((paramv == null) || (paramv.oYJ == null))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker labelStyle is null, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(187724);
      return;
    }
    if ((paramv.oYg > 0) && (!this.oXm.contains(Integer.valueOf(paramv.oYg))))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker marker is not exist, don't add, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(187724);
      return;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker label id:%s, content:%s", new Object[] { paramString + "#label", paramv.oYJ.content });
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
    Object localObject2 = i.bSV();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.appbrand.widget.f.d(this.context);
    }
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).reset();
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).setTextColor(paramv.oYJ.color);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).setTextSize(paramv.oYJ.oYK);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).setText(paramv.oYJ.content);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).setTextPadding(paramv.oYJ.padding);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).setGravity(paramv.oYJ.nUc);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).D(paramv.oYJ.oYL, paramv.oYJ.borderWidth, paramv.oYJ.borderColor, paramv.oYJ.bgColor);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).setX(paramv.oYJ.x);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).setY(paramv.oYJ.y);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).fm(paramv.oYJ.width, paramv.oYJ.height);
    ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).measure(0, 0);
    localMarkerOptions.anchor(((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).getAnchorX(), ((com.tencent.mm.plugin.appbrand.widget.f.d)localObject1).getAnchorY());
    localMarkerOptions.markerView((View)localObject1);
    localMarkerOptions.visible(true);
    localMarkerOptions.tag(paramString + "#label");
    localMarkerOptions.zIndex(paramv.zIndex + 3);
    localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
    if ((!Util.isNullOrNil(paramv.buildingId)) && (!Util.isNullOrNil(paramv.floorName))) {
      localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
    }
    localObject2 = this.oWp.getMap().addMarker(localMarkerOptions);
    localObject1 = paramg;
    if (paramg == null)
    {
      localObject1 = new g();
      ((g)localObject1).oYC = paramv;
    }
    ((g)localObject1).oYh = ((Marker)localObject2);
    ((g)localObject1).data = paramv.data;
    a(paramString + "#label", (g)localObject1);
    AppMethodBeat.o(187724);
  }
  
  private boolean a(b.aa paramaa)
  {
    AppMethodBeat.i(187760);
    if (this.oWp.getMap() == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addMapMarkerCluster map is null");
      AppMethodBeat.o(187760);
      return false;
    }
    if (!bSO())
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addMapMarkerCluster mClusterManager is not initialize");
      AppMethodBeat.o(187760);
      return false;
    }
    if ((this.oXl.contains(paramaa.id)) && (ahN(paramaa.id) != null)) {}
    for (int i = 0;; i = 1)
    {
      f localf;
      if (i != 0)
      {
        ??? = new com.tencent.mapsdk.raster.model.LatLng(paramaa.oYU.latitude, paramaa.oYU.longitude);
        localf = new f(paramaa.id, (com.tencent.mapsdk.raster.model.LatLng)???);
      }
      for (;;)
      {
        synchronized (this.lockObj)
        {
          this.oXk.add(localf);
          this.oXl.add(f.a(localf));
          this.oWD.addItem(localf);
          this.oWD.cluster();
          Log.i("MicroMsg.Map.DefaultTencentMapView", "addMapMarkerCluster mClusterItems:%d， id:%s， latitude:%f, longitude:%f", new Object[] { Integer.valueOf(this.oXk.size()), paramaa.id, Double.valueOf(localf.getPosition().getLatitude()), Double.valueOf(localf.getPosition().getLongitude()) });
          AppMethodBeat.o(187760);
          return true;
        }
        Log.i("MicroMsg.Map.DefaultTencentMapView", "cluster item is added!");
      }
    }
  }
  
  private void ac(Runnable paramRunnable)
  {
    AppMethodBeat.i(146524);
    this.oWU.add(paramRunnable);
    if (this.oWU.size() == 1) {
      paramRunnable.run();
    }
    AppMethodBeat.o(146524);
  }
  
  private f ahN(String paramString)
  {
    AppMethodBeat.i(187761);
    Iterator localIterator = this.oXk.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (paramString.contains(f.a(localf)))
      {
        AppMethodBeat.o(187761);
        return localf;
      }
    }
    AppMethodBeat.o(187761);
    return null;
  }
  
  private boolean ahO(String paramString)
  {
    AppMethodBeat.i(187762);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeMapMarkerClusterGeometry id:%s", new Object[] { paramString });
    if ((this.oWD != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      synchronized (this.lockObj)
      {
        Iterator localIterator = this.oXk.iterator();
        if (!localIterator.hasNext()) {
          break label256;
        }
        localf = (f)localIterator.next();
        if (!paramString.contains(f.a(localf))) {
          continue;
        }
        if (localf == null) {
          break label248;
        }
        this.oWD.removeItem(localf);
      }
      synchronized (this.lockObj)
      {
        this.oXk.remove(localf);
        this.oXl.remove(paramString);
        this.oXp.remove(paramString);
        if (localf.oYg > 0)
        {
          ahM(localf.oYg);
          this.oXm.remove(Integer.valueOf(localf.oYg));
          this.oXo.remove(Integer.valueOf(localf.oYg));
        }
        Log.i("MicroMsg.Map.DefaultTencentMapView", "remove MapMarker ClusterGeometry success id:%s", new Object[] { paramString });
        this.oWD.cluster();
        AppMethodBeat.o(187762);
        return true;
        paramString = finally;
        AppMethodBeat.o(187762);
        throw paramString;
      }
      label248:
      AppMethodBeat.o(187762);
      return false;
      label256:
      f localf = null;
    }
  }
  
  private static int ahP(String paramString)
  {
    AppMethodBeat.i(187774);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(187774);
      return -1;
    }
    int i;
    if (paramString.equals("abovelabels"))
    {
      i = OverlayLevel.OverlayLevelAboveLabels;
      AppMethodBeat.o(187774);
      return i;
    }
    if (paramString.equals("abovebuildings"))
    {
      i = OverlayLevel.OverlayLevelAboveBuildings;
      AppMethodBeat.o(187774);
      return i;
    }
    if (paramString.equals("aboveroads"))
    {
      i = OverlayLevel.OverlayLevelAboveRoads;
      AppMethodBeat.o(187774);
      return i;
    }
    AppMethodBeat.o(187774);
    return -1;
  }
  
  private void b(final Marker paramMarker)
  {
    AppMethodBeat.i(187727);
    if (paramMarker == null)
    {
      AppMethodBeat.o(187727);
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMarker.showInfoWindow();
      AppMethodBeat.o(187727);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187083);
        paramMarker.showInfoWindow();
        AppMethodBeat.o(187083);
      }
    });
    AppMethodBeat.o(187727);
  }
  
  private static b.f bSA()
  {
    AppMethodBeat.i(146492);
    b.f localf = new b.f();
    localf.buildingId = "";
    localf.buildingName = "";
    localf.oYq = new LinkedList();
    localf.oYr = -1;
    AppMethodBeat.o(146492);
    return localf;
  }
  
  private void bSB()
  {
    AppMethodBeat.i(146496);
    if (this.oWH == null) {
      this.oWH = getSurfaceView();
    }
    if (this.oWH != null)
    {
      MMHandlerThread.removeRunnable(this.oWI);
      this.oWH.setVisibility(0);
      AppMethodBeat.o(146496);
      return;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "showTencentMap err");
    AppMethodBeat.o(146496);
  }
  
  private Bundle bSN()
  {
    AppMethodBeat.i(146545);
    Bundle localBundle = new Bundle();
    if (!oWv.equals(this.oWw))
    {
      String str = Util.nullAsNil(localBundle.getString("smallAppKey"));
      localBundle.putString("smallAppKey", str + this.oWw + "#" + this.oWx + ";");
    }
    AppMethodBeat.o(146545);
    return localBundle;
  }
  
  private boolean bSQ()
  {
    AppMethodBeat.i(187764);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeAllMapCluster");
    if (this.oWD != null)
    {
      Object localObject2 = new ArrayList();
      synchronized (this.lockObj)
      {
        ((ArrayList)localObject2).addAll(this.oXk);
        this.oXl.clear();
        this.oXk.clear();
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (f)((Iterator)???).next();
          this.oWD.removeItem((ClusterItem)localObject2);
        }
      }
      this.oXp.clear();
      AppMethodBeat.o(187764);
      return true;
    }
    AppMethodBeat.o(187764);
    return false;
  }
  
  private void c(String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(187725);
    Object localObject;
    if ((paramv.oYg > 0) && (this.oXm.contains(Integer.valueOf(paramv.oYg))))
    {
      localObject = (Cluster)this.oXo.get(Integer.valueOf(paramv.oYg));
      if (localObject == null) {
        break label545;
      }
      localObject = ((e)this.oWD.getRenderer()).getMarker((Cluster)localObject);
    }
    for (;;)
    {
      final ImageView localImageView;
      if (localObject != null)
      {
        if (paramv.oYD) {
          ((Marker)localObject).setPosition(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        }
        if (!Util.isNullOrNil(paramv.title)) {
          ((Marker)localObject).setTitle(paramv.title);
        }
        if (!Util.isNullOrNil(paramv.oYG)) {
          ((Marker)localObject).setContentDescription(paramv.oYG);
        }
        ((Marker)localObject).setRotation(paramv.oYk);
        ((Marker)localObject).setAlpha(paramv.alpha);
        final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(com.tencent.luggage.h.a.c.default_tencent_map_marker_icon, null);
        localImageView = (ImageView)localFrameLayout.findViewById(com.tencent.luggage.h.a.b.marker_icon);
        final float f1 = paramv.oYE;
        final float f2 = paramv.oYF;
        if (parama != null) {
          if (!Util.isNullOrNil(paramv.oYm))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            parama = parama.a(paramv.oYm, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void O(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(187483);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if (this.oXK != null)
                  {
                    Log.v("MicroMsg.Map.DefaultTencentMapView", "setMarkerView");
                    this.oXK.setMarkerView(localFrameLayout);
                  }
                }
                AppMethodBeat.o(187483);
              }
            });
            label274:
            if (parama == null) {
              break label506;
            }
            a(f1, f2, parama, localImageView);
            label288:
            ((Marker)localObject).setMarkerView(localFrameLayout);
            ((Marker)localObject).setAnchor(paramv.anchorX, paramv.anchorY);
            ((Marker)localObject).setTag(paramString);
            ((Marker)localObject).setInfoWindowHideAnimation(new Animation() {});
            ((Marker)localObject).setInfoWindowShowAnimation(new Animation() {});
            ((Marker)localObject).setVisible(true);
            ((Marker)localObject).setZIndex(paramv.zIndex + 2);
            ((Marker)localObject).setLevel(OverlayLevel.OverlayLevelAboveLabels);
            if ((TextUtils.isEmpty(paramv.oYH)) || (!paramv.oYH.equals("withLabel"))) {
              break label518;
            }
            ((Marker)localObject).setCollisions(new Collision[] { MarkerCollisionItem.POI });
            AppMethodBeat.o(187725);
            return;
            if (!paramv.oYD) {
              break label539;
            }
            localObject = ahN(paramString);
            if (localObject == null) {
              break label533;
            }
          }
        }
      }
      label518:
      label533:
      for (localObject = ((e)this.oWD.getRenderer()).getMarker((ClusterItem)localObject);; localObject = null)
      {
        this.oXp.put(paramString, paramv);
        if (this.oXq == null) {
          this.oXq = parama;
        }
        break;
        if (localImageView != null) {
          localImageView.setImageBitmap(null);
        }
        parama = null;
        break label274;
        label506:
        Log.e("MicroMsg.Map.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
        break label288;
        ((Marker)localObject).setCollisions(null);
        AppMethodBeat.o(187725);
        return;
      }
      label539:
      localObject = null;
      continue;
      label545:
      localObject = null;
    }
  }
  
  private SurfaceView getSurfaceView()
  {
    AppMethodBeat.i(146495);
    if (this.oWH != null)
    {
      localSurfaceView = this.oWH;
      AppMethodBeat.o(146495);
      return localSurfaceView;
    }
    this.oWH = j(this.oWp);
    SurfaceView localSurfaceView = this.oWH;
    AppMethodBeat.o(146495);
    return localSurfaceView;
  }
  
  private void i(List<com.tencent.mapsdk.raster.model.LatLng> paramList, int paramInt)
  {
    AppMethodBeat.i(187684);
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramList);
    this.oWM = false;
    this.oWp.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.oWO = null;
    AppMethodBeat.o(187684);
  }
  
  private static SurfaceView j(ViewGroup paramViewGroup)
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
  
  public final boolean AB(int paramInt)
  {
    AppMethodBeat.i(187769);
    if (!this.oXt.containsKey(String.valueOf(paramInt)))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "removeGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(187769);
      return false;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    GroundOverlay localGroundOverlay = (GroundOverlay)this.oXt.remove(String.valueOf(paramInt));
    if (localGroundOverlay != null)
    {
      localGroundOverlay.remove();
      AppMethodBeat.o(187769);
      return true;
    }
    AppMethodBeat.o(187769);
    return false;
  }
  
  public void B(MotionEvent paramMotionEvent) {}
  
  protected TencentMapOptions I(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146491);
    TencentMapOptions localTencentMapOptions = new TencentMapOptions();
    if (paramMap == null)
    {
      Log.w("MicroMsg.Map.DefaultTencentMapView", "params is null, return");
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
    }
    String str = f.a(paramMap, "theme", "normal");
    this.oWz = str.equals("handDraw");
    this.mMapType = f.a(paramMap, "mapType", 1);
    localTencentMapOptions.setMapType(this.mMapType);
    this.oWw = f.a(paramMap, "subKey", "");
    this.oWx = f.a(paramMap, "subId", "");
    boolean bool;
    if (f.a(paramMap, "enableDarkMode", 0) == 1)
    {
      bool = true;
      this.oWA = bool;
      if (!Util.isNullOrNil(this.oWw)) {
        break label288;
      }
      this.oWw = oWv;
      this.oWx = "";
    }
    for (;;)
    {
      localTencentMapOptions.setSubInfo(this.oWw, this.oWx);
      this.oWy = f.a(paramMap, "styleId", 0);
      Log.d("MicroMsg.Map.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.oWx, this.oWw });
      Log.i("MicroMsg.Map.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d enableDarkmode:%b", new Object[] { str, Boolean.valueOf(this.oWz), Integer.valueOf(this.mMapType), this.oWx, this.oWw, Integer.valueOf(this.oWy), Boolean.valueOf(this.oWA) });
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
      bool = false;
      break;
      label288:
      this.oWA = false;
    }
  }
  
  public final void M(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146546);
    if ((!this.oXd) || (this.oWq))
    {
      AppMethodBeat.o(146546);
      return;
    }
    if (this.oXe != null) {
      this.oXe.M(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(146546);
  }
  
  public final Point a(b.i parami)
  {
    AppMethodBeat.i(187771);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "toScreenLocation");
    parami = new com.tencent.mapsdk.raster.model.LatLng(parami.latitude, parami.longitude);
    parami = this.oWp.getMap().getProjection().toScreenLocation(parami);
    AppMethodBeat.o(187771);
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
    Log.v("MicroMsg.Map.DefaultTencentMapView", "start map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    if ((paramFloat1 == -1.0F) && (paramFloat2 == -1.0F) && (paramFloat3 == -1.0F) && (paramDouble1 == -1.0D) && (paramDouble2 == -1.0D))
    {
      AppMethodBeat.o(146522);
      return;
    }
    final TencentMap localTencentMap = this.oWp.getMap();
    if (localTencentMap != null)
    {
      if (paramBoolean)
      {
        ac(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146465);
            CameraUpdate localCameraUpdate = a.b(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, this.lMa);
            Log.v("MicroMsg.Map.DefaultTencentMapView", "doing map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(this.lMa), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
            a.a(a.this, false);
            localTencentMap.animateCamera(localCameraUpdate, a.bSS(), a.t(a.this));
            AppMethodBeat.o(146465);
          }
        });
        AppMethodBeat.o(146522);
        return;
      }
      CameraUpdate localCameraUpdate = a(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, paramDouble2);
      this.oWM = false;
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
    int i = ahP(???.oYl);
    if (i >= 0) {
      ((CircleOptions)localObject1).level(i);
    }
    for (;;)
    {
      localObject1 = this.oWp.getMap().addCircle((CircleOptions)localObject1);
      synchronized (this.oWW)
      {
        this.oWW.add(localObject1);
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
    Object localObject3 = paramk.oYw.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      b.i locali = (b.i)((Iterator)localObject3).next();
      ((List)localObject2).add(new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude));
    }
    ((PolylineOptions)localObject1).addAll((Iterable)localObject2);
    if ((paramk.oYB != null) && (paramk.oYB.size() > 0))
    {
      Log.i("MicroMsg.Map.DefaultTencentMapView", "colorList size:%d ", new Object[] { Integer.valueOf(paramk.oYB.size()) });
      int j = paramk.oYB.size();
      localObject2 = new int[j];
      localObject3 = new int[j];
      while (i < j)
      {
        localObject2[i] = ((Integer)paramk.oYB.get(i)).intValue();
        localObject3[i] = i;
        i += 1;
      }
      ((PolylineOptions)localObject1).colors((int[])localObject2, (int[])localObject3);
      ((PolylineOptions)localObject1).setEnableGradient(paramk.enableGradient);
      ((PolylineOptions)localObject1).width(paramk.width);
      ((PolylineOptions)localObject1).setDottedLine(paramk.oYx);
      ((PolylineOptions)localObject1).edgeColor(paramk.borderColor);
      ((PolylineOptions)localObject1).edgeWidth(paramk.borderWidth);
      if (paramk.oYy)
      {
        parama = parama.dp(paramk.oYz);
        ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(parama));
        if (parama == null) {
          ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), com.tencent.luggage.h.a.a.app_brand_map_line_texture_arrow)));
        }
      }
      ((PolylineOptions)localObject1).zIndex(1.0F);
      if ((!Util.isNullOrNil(paramk.buildingId)) && (!Util.isNullOrNil(paramk.floorName))) {
        ((PolylineOptions)localObject1).indoorInfo(new IndoorInfo(paramk.buildingId, paramk.floorName));
      }
      ((PolylineOptions)localObject1).arrowGap(paramk.oYA);
      i = ahP(paramk.oYl);
      if (i < 0) {
        break label481;
      }
      ((PolylineOptions)localObject1).level(i);
    }
    for (;;)
    {
      ((PolylineOptions)localObject1).lineCap(true);
      localObject1 = this.oWp.getMap().addPolyline((PolylineOptions)localObject1);
      if (localObject1 != null) {
        break label493;
      }
      Log.e("MicroMsg.Map.DefaultTencentMapView", "polyline is null, return");
      AppMethodBeat.o(146531);
      return;
      if (paramk.style != -1)
      {
        ((PolylineOptions)localObject1).color(paramk.style);
        break;
      }
      ((PolylineOptions)localObject1).color(paramk.color);
      break;
      label481:
      ((PolylineOptions)localObject1).level(OverlayLevel.OverlayLevelAboveRoads);
    }
    label493:
    if (Util.isNullOrNil(paramk.id)) {}
    for (parama = paramk.hashCode();; parama = paramk.id)
    {
      this.oWY.put(Util.nullAs(parama, paramk.toString()), localObject1);
      AppMethodBeat.o(146531);
      return;
    }
  }
  
  public final void a(b.l paraml)
  {
    this.oWr = paraml;
  }
  
  public final void a(b.m paramm)
  {
    this.oWJ = paramm;
  }
  
  public final void a(b.o paramo)
  {
    this.oWt = paramo;
  }
  
  public final void a(b.p paramp)
  {
    this.oWs = paramp;
  }
  
  public final void a(b.s params)
  {
    this.oWu = params;
  }
  
  public final void a(b.w paramw)
  {
    AppMethodBeat.i(146499);
    this.oWN = paramw;
    this.oWp.getMap().setTencentMapGestureListener(new TencentMap.TencentMapGestureListener()
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
    this.oWp.getMap().setOnMapCameraChangeListener(new TencentMap.OnMapCameraChangeListener()
    {
      public final void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(146459);
        if (a.p(a.this) != null)
        {
          b.a locala = new b.a();
          locala.oYj = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.oYk = paramAnonymousCameraPosition.getBearing();
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
          locala.oYj = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.oYk = paramAnonymousCameraPosition.getBearing();
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
    this.oWP = paramx;
  }
  
  public final void a(b.z paramz)
  {
    this.oWL = paramz;
  }
  
  public final void a(String paramString, int paramInt, b.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(146532);
    Polyline localPolyline = (Polyline)this.oWY.get(paramString);
    if (localPolyline == null)
    {
      Log.w("MicroMsg.Map.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146532);
      return;
    }
    localPolyline.setEraseable(paramBoolean);
    localPolyline.eraseTo(paramInt, new com.tencent.mapsdk.raster.model.LatLng(parami.latitude, parami.longitude));
    AppMethodBeat.o(146532);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(187681);
    if ((parama != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = parama.a(paramString, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void O(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(187553);
          if (paramAnonymousBitmap != null)
          {
            if ((a.d(a.this) != null) && (a.d(a.this).getRealMarker() != null))
            {
              a.d(a.this).getRealMarker().setIcon(com.tencent.mapsdk.raster.model.BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
              Log.i("MicroMsg.Map.DefaultTencentMapView", "setMapLocMarkerIcon success");
              AppMethodBeat.o(187553);
            }
          }
          else {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "setMapLocMarkerIcon load bitmap is null");
          }
          AppMethodBeat.o(187553);
        }
      });
      if ((paramString != null) && (this.oXe != null) && (this.oXe.getRealMarker() != null))
      {
        this.oXe.getRealMarker().setIcon(com.tencent.mapsdk.raster.model.BitmapDescriptorFactory.fromBitmap(paramString));
        Log.i("MicroMsg.Map.DefaultTencentMapView", "setMapLocMarkerIcon success");
      }
    }
    AppMethodBeat.o(187681);
  }
  
  public final void a(String paramString, final b.v paramv)
  {
    AppMethodBeat.i(182816);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s updateMarker markerId:%s", new Object[] { this, paramString });
    final g localg = ahK(paramString);
    if (localg != null) {
      if (paramv.oYI != null)
      {
        if (paramv.oYI.view == null) {
          break label609;
        }
        localg.oYC.oYI = paramv.oYI;
        if (localg.oYb != null)
        {
          ??? = localg.oYb;
          if (??? != null)
          {
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label547;
            }
            ((Marker)???).setInfoWindowOffset(paramv.oYI.oYQ, paramv.oYI.oYR);
          }
        }
        if ((localg.oYb == null) || (paramv.oYI.oYP != b.v.a.oYT)) {
          break label563;
        }
        b(localg.oYb);
      }
    }
    for (;;)
    {
      if (paramv.oYJ != null)
      {
        localg.oYh.remove();
        ahL(paramString + "#label");
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        com.tencent.mm.plugin.appbrand.widget.f.d locald = i.bSV();
        ??? = locald;
        if (locald == null) {
          ??? = new com.tencent.mm.plugin.appbrand.widget.f.d(this.context);
        }
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).reset();
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).setTextColor(paramv.oYJ.color);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).setTextSize(paramv.oYJ.oYK);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).setText(paramv.oYJ.content);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).setTextPadding(paramv.oYJ.padding);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).setGravity(paramv.oYJ.nUc);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).D(paramv.oYJ.oYL, paramv.oYJ.borderWidth, paramv.oYJ.borderColor, paramv.oYJ.bgColor);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).setX(paramv.oYJ.x);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).setY(paramv.oYJ.y);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).fm(paramv.oYJ.width, paramv.oYJ.height);
        ((com.tencent.mm.plugin.appbrand.widget.f.d)???).measure(0, 0);
        localMarkerOptions.anchor(((com.tencent.mm.plugin.appbrand.widget.f.d)???).getAnchorX(), ((com.tencent.mm.plugin.appbrand.widget.f.d)???).getAnchorY());
        localMarkerOptions.markerView((View)???);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramv.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!Util.isNullOrNil(paramv.buildingId)) && (!Util.isNullOrNil(paramv.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
        }
        localg.oYh = this.oWp.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", localg);
      }
      AppMethodBeat.o(182816);
      return;
      label547:
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189279);
          this.oXL.setInfoWindowOffset(paramv.oYI.oYQ, paramv.oYI.oYR);
          AppMethodBeat.o(189279);
        }
      });
      break;
      label563:
      if (localg.oYb == null) {
        continue;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        localg.oYb.refreshInfoWindow();
        continue;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187853);
          localg.oYb.refreshInfoWindow();
          AppMethodBeat.o(187853);
        }
      });
      continue;
      label609:
      synchronized (this.mLock)
      {
        localg.oYi = null;
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
        AppMethodBeat.i(187581);
        a.this.b(paramString, paramv, parama);
        AppMethodBeat.o(187581);
      }
    });
    AppMethodBeat.o(146536);
  }
  
  public final void a(final String paramString, ArrayList<b.i> arg2, long paramLong, boolean paramBoolean, b.r arg6)
  {
    AppMethodBeat.i(187734);
    g localg = ahK(paramString);
    if ((localg == null) || (localg.oYb == null))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "get marker failed!");
      ???.il(false);
      AppMethodBeat.o(187734);
      return;
    }
    if (???.size() <= 0)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "keyFrame is empty, err, return");
      ???.il(false);
      AppMethodBeat.o(187734);
      return;
    }
    synchronized (this.oWB)
    {
      if (this.oWB.containsKey(paramString)) {
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187453);
            this.oXQ.cancelAnimation();
            AppMethodBeat.o(187453);
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
    ??? = new MarkerTranslateAnimator(localg.oYb, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
    ???.addAnimatorListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(186865);
        Log.i("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationCancel");
        if (paramr != null) {
          paramr.bSx();
        }
        synchronized (a.w(a.this))
        {
          a.w(a.this).remove(paramString);
          AppMethodBeat.o(186865);
          return;
        }
      }
      
      public final void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(186863);
        Log.i("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationEnd");
        if (paramr != null) {
          paramr.il(true);
        }
        synchronized (a.w(a.this))
        {
          a.w(a.this).remove(paramString);
          AppMethodBeat.o(186863);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186861);
        Log.i("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationStart");
        AppMethodBeat.o(186861);
      }
    });
    synchronized (this.oWB)
    {
      this.oWB.put(paramString, ???);
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189214);
          Log.d("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator start");
          paramArrayList.startAnimation();
          AppMethodBeat.o(189214);
        }
      });
      if (localg.oYh != null)
      {
        Log.d("MicroMsg.Map.DefaultTencentMapView", "labelMarker do move animator");
        synchronized (this.oWC)
        {
          if (this.oWC.containsKey(paramString)) {
            m.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187005);
                this.oXQ.cancelAnimation();
                AppMethodBeat.o(187005);
              }
            });
          }
          ??? = new MarkerTranslateAnimator(localg.oYh, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
          ???.addAnimatorListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator arg1)
            {
              AppMethodBeat.i(187848);
              synchronized (a.x(a.this))
              {
                a.x(a.this).remove(paramString);
                AppMethodBeat.o(187848);
                return;
              }
            }
            
            public final void onAnimationEnd(Animator arg1)
            {
              AppMethodBeat.i(187845);
              synchronized (a.x(a.this))
              {
                a.x(a.this).remove(paramString);
                AppMethodBeat.o(187845);
                return;
              }
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          });
        }
      }
    }
    synchronized (this.oWC)
    {
      this.oWC.put(paramString, ???);
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187498);
          paramr.startAnimation();
          AppMethodBeat.o(187498);
        }
      });
      AppMethodBeat.o(187734);
      return;
      paramString = finally;
      AppMethodBeat.o(187734);
      throw paramString;
      paramString = finally;
      AppMethodBeat.o(187734);
      throw paramString;
    }
  }
  
  public final void a(String paramString, LinkedList<b.h> paramLinkedList, final b.r paramr)
  {
    AppMethodBeat.i(146539);
    paramString = ahK(paramString);
    if ((paramString == null) || (paramString.oYb == null))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "get marker failed!");
      paramr.il(false);
      AppMethodBeat.o(146539);
      return;
    }
    if (paramLinkedList.size() <= 0)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "keyFrame is empty, err, return");
      paramr.il(false);
      AppMethodBeat.o(146539);
      return;
    }
    Object localObject = (b.h)paramLinkedList.get(0);
    ((b.h)localObject).oYt = paramString.oYb.getPosition().getLatitude();
    ((b.h)localObject).oYs = paramString.oYb.getPosition().getLongitude();
    int j = paramLinkedList.size();
    int i = 1;
    if (i < j)
    {
      localObject = (b.h)paramLinkedList.get(i - 1);
      b.h localh = (b.h)paramLinkedList.get(i);
      if (((b.h)localObject).oYk == 0.0F) {
        localh.oYs = ((b.h)localObject).longitude;
      }
      for (localh.oYt = ((b.h)localObject).latitude;; localh.oYt = paramString.oYb.getPosition().getLatitude())
      {
        i += 1;
        break;
        localh.oYs = paramString.oYb.getPosition().getLongitude();
      }
    }
    localObject = new c(paramLinkedList, paramString.oYb, this.oWp);
    paramr = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(187633);
        Log.d("MicroMsg.Map.DefaultTencentMapView", "MarkerAnimator end");
        if (paramr != null) {
          paramr.il(true);
        }
        AppMethodBeat.o(187633);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(187630);
        Log.d("MicroMsg.Map.DefaultTencentMapView", "MarkerAnimator start");
        AppMethodBeat.o(187630);
      }
    };
    ((c)localObject).atV.addListener(paramr);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187070);
        this.oXO.atV.start();
        AppMethodBeat.o(187070);
      }
    });
    if (paramString.oYh != null) {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187361);
          this.oXP.atV.start();
          AppMethodBeat.o(187361);
        }
      });
    }
    AppMethodBeat.o(146539);
  }
  
  public final boolean a(final int paramInt, b.e parame, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(187768);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay fail, id < 0 or options is null");
      AppMethodBeat.o(187768);
      return false;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "remove GroundOverlay id:%d, first ,and than add again", new Object[] { Integer.valueOf(paramInt) });
    AB(paramInt);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    final GroundOverlayOptions localGroundOverlayOptions = new GroundOverlayOptions();
    if ((parame.oYo != null) && (parame.oYp != null))
    {
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng1.longitude = parame.oYo.longitude;
      localLatLng1.latitude = parame.oYo.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng2.longitude = parame.oYp.longitude;
      localLatLng2.latitude = parame.oYp.latitude;
      localGroundOverlayOptions.latLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng2, localLatLng1));
    }
    localGroundOverlayOptions.alpha(parame.alpha);
    localGroundOverlayOptions.visible(parame.visible);
    localGroundOverlayOptions.zIndex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.oYm)))
    {
      parame = parama.a(parame.oYm, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void O(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(188519);
          if (paramAnonymousBitmap != null)
          {
            localGroundOverlayOptions.bitmap(com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
            paramAnonymousBitmap = a.this.oWp.getMap().addGroundOverlay(localGroundOverlayOptions);
            if (paramAnonymousBitmap == null)
            {
              Log.e("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
              AppMethodBeat.o(188519);
              return;
            }
            a.G(a.this).put(paramInt, paramAnonymousBitmap);
            Log.i("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(188519);
            return;
          }
          Log.e("MicroMsg.Map.DefaultTencentMapView", "groundOverlay load bitmap is null");
          AppMethodBeat.o(188519);
        }
      });
      if (parame != null)
      {
        localGroundOverlayOptions.bitmap(com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory.fromBitmap(parame));
        parame = this.oWp.getMap().addGroundOverlay(localGroundOverlayOptions);
        if (parame == null)
        {
          Log.e("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
          AppMethodBeat.o(187768);
          return false;
        }
        this.oXt.put(String.valueOf(paramInt), parame);
        Log.i("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    while (parama == null)
    {
      AppMethodBeat.o(187768);
      return true;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(187768);
    return false;
  }
  
  public final boolean a(b.ab arg1)
  {
    AppMethodBeat.i(146543);
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.oYw.iterator();
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
    int i = ahP(???.oYl);
    if (i >= 0) {
      ((PolygonOptions)localObject1).level(i);
    }
    localObject1 = this.oWp.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.oXc)
    {
      this.oXc.add(localObject1);
      AppMethodBeat.o(146543);
      return true;
    }
  }
  
  public final boolean a(b.c paramc, b.n paramn, final com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(146528);
    if (Util.isNullOrNil(paramc.oYm))
    {
      AppMethodBeat.o(146528);
      return false;
    }
    Object localObject = parama.dp(paramc.oYm);
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
      i = com.tencent.mm.plugin.appbrand.ac.g.Di(((Bitmap)localObject).getHeight());
      if (paramc.width != 0) {
        break label217;
      }
    }
    label217:
    for (int j = com.tencent.mm.plugin.appbrand.ac.g.Di(((Bitmap)localObject).getWidth());; j = paramc.width)
    {
      localObject = new FrameLayout.LayoutParams(j, i);
      ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
      boolean bool = paramc.oYn;
      paramc = paramc.data;
      parama.setOnTouchListener(new a.8(this, bool, parama));
      parama.setOnClickListener(new a.10(this, bool, paramn, paramc));
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187030);
          ((ViewGroup)a.this.container).addView(parama, this.oXB);
          synchronized (a.this.oWX)
          {
            a.this.oWX.add(new a.b(a.this, parama));
            AppMethodBeat.o(187030);
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
    if (Util.isNullOrNil(???.oYm))
    {
      AppMethodBeat.o(146541);
      return false;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(???.latitude, ???.longitude));
    parama = parama.dp(???.oYm);
    if ((parama != null) && (!parama.isRecycled())) {
      localMarkerOptions.icon(new BitmapDescriptor(parama));
    }
    localMarkerOptions.rotation(???.oYk);
    parama = this.oWp.getMap().addMarker(localMarkerOptions);
    synchronized (this.oXb)
    {
      this.oXb.add(new c(parama));
      AppMethodBeat.o(146541);
      return true;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, final int paramInt1, final int paramInt2, b.q paramq)
  {
    AppMethodBeat.i(187756);
    boolean bool;
    if (this.oWp.getMap() == null)
    {
      bool = false;
      if (bool)
      {
        this.oXj = paramq;
        this.oXr = paramBoolean2;
        this.oXs = paramBoolean1;
        Log.i("MicroMsg.Map.DefaultTencentMapView", "initMapMarkerCluster zoomOnClick:%b, enableDefaultStyle:%b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      }
      AppMethodBeat.o(187756);
      return bool;
    }
    this.oWF = true;
    Runnable local38 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189588);
        if (a.b(a.this) == null) {
          a.a(a.this, new a.d(a.this, a.u(a.this), a.this.oWp.getMap()));
        }
        if (a.A(a.this) == null)
        {
          a.a(a.this, new a.e(a.this, a.u(a.this), a.this.oWp.getMap(), a.b(a.this)));
          a.A(a.this).setMinClusterSize(paramInt1);
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
              AppMethodBeat.i(187458);
              boolean bool = a.this.b(paramAnonymous2Cluster);
              AppMethodBeat.o(187458);
              return bool;
            }
          });
          a.b(a.this).setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener() {});
          Log.i("MicroMsg.Map.DefaultTencentMapView", "init map marker cluster finish");
          a.b(a.this).setRenderer(a.A(a.this));
          a.b(a.this).setClusterEnabled(true);
          a.this.oWp.getMap().setOnMapCameraChangeListener(a.b(a.this));
          a.B(a.this);
          AppMethodBeat.o(189588);
          return;
          a.A(a.this).setMinClusterSize(paramInt1);
          if ((a.b(a.this).getAlgorithm() != null) && ((a.b(a.this).getAlgorithm() instanceof NonHierarchicalDistanceBasedAlgorithm))) {
            ((NonHierarchicalDistanceBasedAlgorithm)a.b(a.this).getAlgorithm()).setMaxDistanceAtZoom(paramInt2);
          }
        }
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper()) {
      local38.run();
    }
    for (;;)
    {
      bool = true;
      break;
      MMHandlerThread.postToMainThread(local38);
    }
  }
  
  public final void ahH(String paramString)
  {
    AppMethodBeat.i(182814);
    if (!this.oWG)
    {
      if (!this.oWS.contains(paramString)) {
        this.oWS.add(paramString);
      }
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addCustomLayer, wait map loaded callback");
      AppMethodBeat.o(182814);
      return;
    }
    CustomLayer localCustomLayer1 = this.oWp.getMap().addCustomLayer(new CustomLayerOptions().layerId(paramString));
    if (localCustomLayer1 != null)
    {
      Log.v("MicroMsg.Map.DefaultTencentMapView", "addCustomLayer success, layerId:%s", new Object[] { paramString });
      CustomLayer localCustomLayer2 = (CustomLayer)this.oWR.remove(paramString);
      if (localCustomLayer2 != null) {
        localCustomLayer2.remove();
      }
      this.oWR.put(paramString, localCustomLayer1);
      AppMethodBeat.o(182814);
      return;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "addCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182814);
  }
  
  public final void ahI(String paramString)
  {
    AppMethodBeat.i(182815);
    CustomLayer localCustomLayer = (CustomLayer)this.oWR.remove(paramString);
    if (localCustomLayer != null)
    {
      Log.v("MicroMsg.Map.DefaultTencentMapView", "removeCustomLayer success, layerId:%s", new Object[] { paramString });
      localCustomLayer.remove();
      AppMethodBeat.o(182815);
      return;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "removeCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182815);
  }
  
  public final boolean ahJ(String paramString)
  {
    AppMethodBeat.i(146530);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeLine lineId:%s", new Object[] { this, paramString });
    Polyline localPolyline = (Polyline)this.oWY.get(paramString);
    if (localPolyline == null)
    {
      Log.w("MicroMsg.Map.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146530);
      return false;
    }
    localPolyline.remove();
    this.oWY.remove(paramString);
    AppMethodBeat.o(146530);
    return true;
  }
  
  public final g ahK(String paramString)
  {
    AppMethodBeat.i(146533);
    paramString = (g)this.oXa.get(paramString);
    AppMethodBeat.o(146533);
    return paramString;
  }
  
  public final boolean ahL(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(146535);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    if (this.oXl.contains(paramString)) {
      ahO(paramString);
    }
    g localg = (g)this.oXa.get(paramString);
    if (localg != null)
    {
      if (localg.oYb != null) {
        localg.oYb.remove();
      }
      if (localg.oYh != null)
      {
        if ((localg.oYh.getMarkerView() != null) && ((localg.oYh.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.f.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.f.d)localg.oYh.getMarkerView());
        }
        localg.oYh.remove();
      }
    }
    label334:
    for (;;)
    {
      synchronized (this.mLock)
      {
        localg.oYi = null;
        this.oXa.remove(paramString);
        bool1 = true;
        ??? = (g)this.oXa.remove(paramString + "#label");
        if (??? == null) {
          break label334;
        }
        if (((g)???).oYh != null) {
          ((g)???).oYh.remove();
        }
        if (((g)???).oYb != null) {
          ((g)???).oYb.remove();
        }
        Log.i("MicroMsg.Map.DefaultTencentMapView", "remove labelMarker id:%s", new Object[] { paramString + "#label" });
        bool1 = bool2;
        AppMethodBeat.o(146535);
        return bool1;
      }
      Log.w("MicroMsg.Map.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      boolean bool1 = false;
    }
  }
  
  public final boolean ahM(String paramString)
  {
    AppMethodBeat.i(187721);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeLabelMarker markerId:%s", new Object[] { this, paramString });
    g localg = (g)this.oXa.remove(paramString + "#label");
    if (localg == null)
    {
      Log.w("MicroMsg.Map.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(187721);
      return false;
    }
    if (localg.oYh != null)
    {
      if ((localg.oYh.getMarkerView() != null) && ((localg.oYh.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.f.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.f.d)localg.oYh.getMarkerView());
      }
      localg.oYh.remove();
    }
    AppMethodBeat.o(187721);
    return true;
  }
  
  public final void b(final String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(187723);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s _addMarker markerId:%s", new Object[] { this, paramString });
    if (this.oXi.get())
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "map:%s _addMarker markerId:%s fail", new Object[] { this, paramString });
      AppMethodBeat.o(187723);
      return;
    }
    Object localObject1;
    g localg;
    if (paramv.oYg > 0)
    {
      localObject1 = paramv.oYg;
      if (this.oXs)
      {
        Log.i("MicroMsg.Map.DefaultTencentMapView", "cluster item use default style");
        AppMethodBeat.o(187723);
        return;
      }
      if ((paramv.oYg > 0) && (this.oXm.contains(Integer.valueOf(paramv.oYg))))
      {
        c((String)localObject1, paramv, parama);
        localg = (g)this.oXa.get(localObject1);
        if (localg != null) {
          break label877;
        }
        localg = new g();
      }
    }
    label435:
    label846:
    label858:
    label867:
    label877:
    for (;;)
    {
      localg.data = paramv.data;
      localg.oYC = paramv;
      a((String)localObject1, localg);
      MarkerOptions localMarkerOptions;
      if ((!paramv.oYD) && (!TextUtils.isEmpty(paramString)))
      {
        localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        if (!Util.isNullOrNil(paramv.title)) {
          localMarkerOptions.title(paramv.title);
        }
        if (!Util.isNullOrNil(paramv.oYG)) {
          localMarkerOptions.contentDescription(paramv.oYG);
        }
        localMarkerOptions.rotation(paramv.oYk);
        localMarkerOptions.alpha(paramv.alpha);
        final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(com.tencent.luggage.h.a.c.default_tencent_map_marker_icon, null);
        final ImageView localImageView = (ImageView)localFrameLayout.findViewById(com.tencent.luggage.h.a.b.marker_icon);
        final float f1 = paramv.oYE;
        final float f2 = paramv.oYF;
        Object localObject3 = null;
        Object localObject2 = localObject3;
        if (parama != null)
        {
          localObject2 = localObject3;
          if (!Util.isNullOrNil(paramv.oYm))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            localObject2 = parama.a(paramv.oYm, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void O(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(189775);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if ((a.this.ahK(paramString) != null) && (a.this.ahK(paramString).oYb != null))
                  {
                    paramAnonymousBitmap = a.this.ahK(paramString).oYb;
                    if (paramAnonymousBitmap != null) {
                      paramAnonymousBitmap.setMarkerView(localFrameLayout);
                    }
                    Log.v("MicroMsg.Map.DefaultTencentMapView", "setMarkerView");
                  }
                }
                AppMethodBeat.o(189775);
              }
            });
          }
        }
        if (localObject2 == null) {
          break label846;
        }
        a(f1, f2, (Bitmap)localObject2, localImageView);
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
        if (paramv.oYI != null) {
          localMarkerOptions.infoWindowOffset(paramv.oYI.oYQ, paramv.oYI.oYR);
        }
        if ((TextUtils.isEmpty(paramv.oYH)) || (!paramv.oYH.equals("withLabel"))) {
          break label858;
        }
        localMarkerOptions.setCollisions(new MarkerCollisionItem[] { MarkerCollisionItem.POI });
        label627:
        paramString = this.oWp.getMap().addMarker(localMarkerOptions);
        localg.oYb = paramString;
        if ((TextUtils.isEmpty(paramv.oYH)) || (!paramv.oYH.equals("withLabel"))) {
          break label867;
        }
        paramString.setCollisions(new Collision[] { MarkerCollisionItem.POI });
      }
      for (;;)
      {
        paramString.getZIndex();
        if ((paramv.oYI != null) && (paramv.oYI.oYP == b.v.a.oYT)) {
          b(localg.oYb);
        }
        if (((!paramv.oYD) || (paramv.oYg != -1)) && (paramv.oYJ != null)) {
          a((String)localObject1, paramv, localg);
        }
        AppMethodBeat.o(187723);
        return;
        Log.e("MicroMsg.Map.DefaultTencentMapView", "cluster marker not exist, don't add, must remove exist label");
        ahM((String)localObject1);
        AppMethodBeat.o(187723);
        return;
        if (paramv.oYD)
        {
          localObject1 = new b.aa();
          ((b.aa)localObject1).oYU = new b.i(paramv.latitude, paramv.longitude);
          ((b.aa)localObject1).id = paramString;
          a((b.aa)localObject1);
          c(paramString, paramv, parama);
        }
        localObject1 = paramString;
        break;
        Log.e("MicroMsg.Map.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
        break label435;
        localMarkerOptions.setCollisions(null);
        break label627;
        paramString.setCollisions(null);
      }
    }
  }
  
  public final boolean b(final int paramInt, b.e parame, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(187770);
    if (!this.oXt.containsKey(String.valueOf(paramInt)))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(187770);
      return false;
    }
    final GroundOverlay localGroundOverlay = (GroundOverlay)this.oXt.get(String.valueOf(paramInt));
    if (localGroundOverlay == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay is null");
      AppMethodBeat.o(187770);
      return false;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((parame.oYo != null) && (parame.oYp != null))
    {
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng1.longitude = parame.oYo.longitude;
      localLatLng1.latitude = parame.oYo.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng2.longitude = parame.oYp.longitude;
      localLatLng2.latitude = parame.oYp.latitude;
      localGroundOverlay.setLatLongBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng2, localLatLng1));
    }
    localGroundOverlay.setAlpha(parame.alpha);
    localGroundOverlay.setVisibility(parame.visible);
    localGroundOverlay.setZindex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.oYm)))
    {
      parame = parama.a(parame.oYm, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void O(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(188147);
          if (paramAnonymousBitmap != null)
          {
            localGroundOverlay.setBitmap(com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
            Log.i("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(188147);
            return;
          }
          Log.e("MicroMsg.Map.DefaultTencentMapView", "groundOverlay load bitmap is null");
          AppMethodBeat.o(188147);
        }
      });
      if (parame != null)
      {
        localGroundOverlay.setBitmap(com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory.fromBitmap(parame));
        Log.i("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    while (parama == null)
    {
      AppMethodBeat.o(187770);
      return true;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(187770);
    return false;
  }
  
  public final boolean b(Cluster<f> paramCluster)
  {
    AppMethodBeat.i(187752);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "onClusterClick");
    if (this.oXr)
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramCluster.getItems().iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((f)localIterator.next()).getPosition());
      }
      i(localLinkedList, 0);
    }
    if (this.oXj != null) {
      this.oXj.ae(a(paramCluster, false));
    }
    AppMethodBeat.o(187752);
    return true;
  }
  
  public final b.ac bSC()
  {
    AppMethodBeat.i(146498);
    Object localObject2 = this.oWp.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.j();
    ((b.j)localObject1).oYu = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.j)localObject1).oYv = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.ad();
    ((b.ad)localObject2).oYW = ((b.j)localObject1);
    localObject1 = new b.ac();
    ((b.ac)localObject1).oYV = ((b.ad)localObject2);
    AppMethodBeat.o(146498);
    return localObject1;
  }
  
  public final void bSD()
  {
    AppMethodBeat.i(146501);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.oWO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146461);
        if ((a.d(a.this) != null) && (a.r(a.this)))
        {
          double d1 = a.d(a.this).getLatitude();
          double d2 = a.d(a.this).getLongitude();
          a.this.oWp.getIController().animateTo(d1, d2);
          Log.d("MicroMsg.Map.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        }
        AppMethodBeat.o(146461);
      }
    };
    if ((this.oXe != null) && (this.oXd))
    {
      this.oWO.run();
      this.oWO = null;
    }
    AppMethodBeat.o(146501);
  }
  
  public final b.f bSE()
  {
    AppMethodBeat.i(146515);
    if (this.oWQ != null)
    {
      localf = this.oWQ;
      AppMethodBeat.o(146515);
      return localf;
    }
    b.f localf = bSA();
    AppMethodBeat.o(146515);
    return localf;
  }
  
  public boolean bSF()
  {
    return false;
  }
  
  public final b.i bSG()
  {
    AppMethodBeat.i(146519);
    Object localObject = this.oWp.getMap().getMapCenter();
    localObject = new b.i(((com.tencent.mapsdk.raster.model.LatLng)localObject).getLatitude(), ((com.tencent.mapsdk.raster.model.LatLng)localObject).getLongitude());
    AppMethodBeat.o(146519);
    return localObject;
  }
  
  public final void bSH()
  {
    AppMethodBeat.i(146525);
    synchronized (this.oWW)
    {
      Iterator localIterator = this.oWW.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.oWW.clear();
    AppMethodBeat.o(146525);
  }
  
  public final void bSI()
  {
    AppMethodBeat.i(146527);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189602);
        ViewGroup localViewGroup = (ViewGroup)a.this.container;
        synchronized (a.this.oWX)
        {
          Iterator localIterator = a.this.oWX.iterator();
          if (localIterator.hasNext()) {
            localViewGroup.removeView(((a.b)localIterator.next()).oYa);
          }
        }
        a.this.oWX.clear();
        AppMethodBeat.o(189602);
      }
    });
    AppMethodBeat.o(146527);
  }
  
  public final void bSJ()
  {
    AppMethodBeat.i(146529);
    Iterator localIterator = this.oWY.values().iterator();
    while (localIterator.hasNext()) {
      ((Polyline)localIterator.next()).remove();
    }
    this.oWY.clear();
    AppMethodBeat.o(146529);
  }
  
  public final void bSK()
  {
    AppMethodBeat.i(146534);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.oXa.values().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg.oYb != null) {
        localg.oYb.remove();
      }
      if (localg.oYh != null)
      {
        if ((localg.oYh.getMarkerView() != null) && ((localg.oYh.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.f.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.f.d)localg.oYh.getMarkerView());
        }
        localg.oYh.remove();
      }
    }
    this.oXa.clear();
    bSQ();
    AppMethodBeat.o(146534);
  }
  
  public final void bSL()
  {
    AppMethodBeat.i(146540);
    synchronized (this.oXb)
    {
      Iterator localIterator = this.oXb.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).oYb.remove();
      }
    }
    this.oXb.clear();
    AppMethodBeat.o(146540);
  }
  
  public final void bSM()
  {
    AppMethodBeat.i(146542);
    synchronized (this.oXc)
    {
      Iterator localIterator = this.oXc.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.oXc.clear();
    AppMethodBeat.o(146542);
  }
  
  public final boolean bSO()
  {
    return (this.oWD != null) && (this.oWE != null);
  }
  
  public final boolean bSP()
  {
    return this.oWF;
  }
  
  public final void c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(146516);
    com.tencent.mapsdk.raster.model.LatLng localLatLng = this.oWp.getMap().getMapCenter();
    this.oWp.setMapAnchor(paramFloat1, paramFloat2);
    a(localLatLng.getLatitude(), localLatLng.getLongitude(), -1.0F, -1.0F, -1.0F, paramBoolean);
    AppMethodBeat.o(146516);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146514);
    this.oWp.getMap().setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(146514);
  }
  
  public final b.i e(Point paramPoint)
  {
    AppMethodBeat.i(187773);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "fromScreenLocation");
    paramPoint = this.oWp.getMap().getProjection().fromScreenLocation(paramPoint);
    paramPoint = new b.i(paramPoint.getLatitude(), paramPoint.getLongitude());
    AppMethodBeat.o(187773);
    return paramPoint;
  }
  
  public final void e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146500);
    a(paramDouble1, paramDouble2, -1.0F, -1.0F, -1.0F, true);
    AppMethodBeat.o(146500);
  }
  
  public final float getRotate()
  {
    AppMethodBeat.i(146503);
    float f = this.oWp.getMap().getCameraPosition().getBearing();
    AppMethodBeat.o(146503);
    return f;
  }
  
  public final float getSkew()
  {
    AppMethodBeat.i(146504);
    float f = this.oWp.getMap().getCameraPosition().getSkew();
    AppMethodBeat.o(146504);
    return f;
  }
  
  public final View getView()
  {
    return this.container;
  }
  
  public final float getZoom()
  {
    AppMethodBeat.i(187659);
    float f = this.oWp.getMap().getCameraPosition().getZoom();
    AppMethodBeat.o(187659);
    return f;
  }
  
  public void h(SurfaceTexture paramSurfaceTexture) {}
  
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
  
  public final void im(boolean paramBoolean)
  {
    AppMethodBeat.i(146505);
    this.oWp.getUiSettings().setZoomGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146505);
  }
  
  public final void in(boolean paramBoolean)
  {
    AppMethodBeat.i(146506);
    this.oWp.getUiSettings().setScrollGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146506);
  }
  
  public final void io(boolean paramBoolean)
  {
    AppMethodBeat.i(146507);
    this.oWp.getUiSettings().setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146507);
  }
  
  public final void ip(boolean paramBoolean)
  {
    AppMethodBeat.i(146508);
    this.oWp.getUiSettings().setCompassEnabled(paramBoolean);
    AppMethodBeat.o(146508);
  }
  
  public final void iq(boolean paramBoolean)
  {
    AppMethodBeat.i(146510);
    this.oWp.getUiSettings().setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146510);
  }
  
  public final void ir(boolean paramBoolean)
  {
    AppMethodBeat.i(146511);
    this.oWp.getMap().setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(146511);
  }
  
  public final void is(boolean paramBoolean)
  {
    AppMethodBeat.i(146512);
    this.oWp.getMap().setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(146512);
  }
  
  public final void it(boolean paramBoolean)
  {
    AppMethodBeat.i(146513);
    this.oWp.getMap().setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(146513);
  }
  
  public final void iu(boolean paramBoolean)
  {
    AppMethodBeat.i(146517);
    this.oWp.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
    AppMethodBeat.o(146517);
  }
  
  public final void iv(boolean paramBoolean)
  {
    AppMethodBeat.i(146518);
    this.oWp.getUiSettings().setScaleControlsEnabled(paramBoolean);
    AppMethodBeat.o(146518);
  }
  
  public final void iw(boolean paramBoolean)
  {
    AppMethodBeat.i(187677);
    this.oWp.getMap().showBuilding(paramBoolean);
    AppMethodBeat.o(187677);
  }
  
  public final void ix(boolean paramBoolean)
  {
    AppMethodBeat.i(146544);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.oXd = paramBoolean;
    d locald;
    if (paramBoolean)
    {
      if (this.oXe != null)
      {
        locald = this.oXe;
        if (locald.oYb != null)
        {
          Log.i("MicroMsg.AppbrandMapLocationPoint", "resumeMapView");
          locald.oYb.setVisible(true);
        }
      }
      ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.oXf, bSN());
      g.a(this);
      AppMethodBeat.o(146544);
      return;
    }
    if (this.oXe != null)
    {
      locald = this.oXe;
      if (locald.oYb != null)
      {
        Log.i("MicroMsg.AppbrandMapLocationPoint", "pauseMapView");
        locald.oYb.setVisible(false);
      }
    }
    ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.oXf, bSN());
    g.b(this);
    AppMethodBeat.o(146544);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(146497);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.oXi.set(true);
    this.oWp.getMap().setOnMapCameraChangeListener(null);
    bSK();
    bSJ();
    bSJ();
    bSI();
    bSL();
    bSM();
    Object localObject = this.oWR.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CustomLayer)((Iterator)localObject).next()).remove();
    }
    this.oWR.clear();
    if (this.oWp != null)
    {
      this.oWp.getMap().setOnMapPoiClickListener(null);
      this.oWp.clean();
      this.oWp.onDestroy();
    }
    if (this.oXe != null)
    {
      localObject = this.oXe;
      if (((d)localObject).oYb != null)
      {
        ((d)localObject).oYb.remove();
        ((d)localObject).oYb = null;
      }
      this.oXe = null;
    }
    AppMethodBeat.o(146497);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(146494);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.fDJ.setVisibility(0);
      if (this.oWH == null) {
        this.oWH = getSurfaceView();
      }
      if (this.oWH != null)
      {
        MMHandlerThread.postToMainThreadDelayed(this.oWI, 100L);
        this.oWp.setVisibility(4);
        this.oWp.getMap().getScreenShot(new TencentMap.OnScreenShotListener()
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
      this.oWq = true;
      if (this.oXd)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.oXf, bSN());
        g.b(this);
      }
      AppMethodBeat.o(146494);
      return;
      Log.e("MicroMsg.Map.DefaultTencentMapView", "hideTencentMap err");
      break;
      this.oWp.onPause();
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(146493);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.fDJ.setVisibility(4);
      this.oWp.setVisibility(0);
      this.oWp.onResume();
      bSB();
    }
    for (;;)
    {
      this.oWq = false;
      if (this.oXd)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.oXf, bSN());
        g.a(this);
      }
      AppMethodBeat.o(146493);
      return;
      this.oWp.onResume();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2) {}
  
  public final void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(187679);
    this.oWp.getMap().setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(187679);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(187667);
    this.oWp.getMap().setIndoorMaskColor(paramInt);
    AppMethodBeat.o(187667);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(182813);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s setMapStyle: %d", new Object[] { this, Integer.valueOf(paramInt) });
    this.oWp.getMap().setMapStyle(paramInt);
    AppMethodBeat.o(182813);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(187688);
    this.oWp.getMap().setMaxZoomLevel(paramInt);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map_scale setMaxZoomLevel:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(187688);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(187692);
    this.oWp.getMap().setMinZoomLevel(paramInt);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map_scale setMinZoomLevel:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(187692);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(187676);
    this.oWp.getMap().setPoisEnabled(paramBoolean);
    AppMethodBeat.o(187676);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146547);
    String str = "DefaultTencentMapView{mapId=" + this.oWo + '}';
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
      if (Util.isNullOrNil((String)paramMarker.getTag()))
      {
        Log.w("MicroMsg.Map.DefaultTencentMapView", "realMarker.getTag is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (((String)paramMarker.getTag()).endsWith("#label"))
      {
        AppMethodBeat.o(146488);
        return null;
      }
      paramMarker = a.this.ahK((String)paramMarker.getTag());
      if (paramMarker == null)
      {
        Log.e("MicroMsg.Map.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (paramMarker.oYC == null)
      {
        Log.e("MicroMsg.Map.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      Object localObject2 = paramMarker.oYC.oYI;
      if (localObject2 == null)
      {
        AppMethodBeat.o(146488);
        return null;
      }
      boolean bool;
      if (((b.v.a)localObject2).view != null) {
        bool = true;
      }
      for (;;)
      {
        Log.i("MicroMsg.Map.DefaultTencentMapView", "marker:%s calloutStyle.view is %b", new Object[] { paramMarker, Boolean.valueOf(bool) });
        if (((b.v.a)localObject2).view != null)
        {
          if (paramMarker.oYi == null) {
            paramMarker.oYi = new ImageView(a.u(a.this));
          }
          localObject2 = BitmapUtil.getBitmapFromView(((b.v.a)localObject2).view);
          if (localObject2 == null) {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "marker:%s calloutStyle.view exist but bitmap is null");
          }
          synchronized (a.v(a.this))
          {
            if (paramMarker.oYi != null) {
              paramMarker.oYi.setImageBitmap((Bitmap)localObject2);
            }
            paramMarker = paramMarker.oYi;
            AppMethodBeat.o(146488);
            return paramMarker;
            bool = false;
          }
        }
      }
      a locala = a.this;
      ??? = i.bSU();
      paramMarker = (Marker)???;
      if (??? == null) {
        paramMarker = new com.tencent.mm.plugin.appbrand.widget.f.b(locala.context);
      }
      paramMarker.setText("");
      paramMarker.setTextSize(12);
      paramMarker.setTextColor(com.tencent.mm.plugin.appbrand.widget.f.b.rBb);
      paramMarker.setTitlePadding(0);
      paramMarker.setGravity("center");
      int i = com.tencent.mm.plugin.appbrand.widget.f.b.rBc;
      paramMarker.D(0, 0, i, i);
      paramMarker.setText(((b.v.a)localObject2).content);
      paramMarker.setTextSize(((b.v.a)localObject2).oYK);
      paramMarker.setTextColor(((b.v.a)localObject2).color);
      paramMarker.setTitlePadding(((b.v.a)localObject2).padding);
      paramMarker.setGravity(((b.v.a)localObject2).nUc);
      paramMarker.D(((b.v.a)localObject2).oYL, ((b.v.a)localObject2).borderWidth, ((b.v.a)localObject2).borderColor, ((b.v.a)localObject2).bgColor);
      AppMethodBeat.o(146488);
      return paramMarker;
    }
    
    public final void onInfoWindowDettached(Marker paramMarker, View paramView)
    {
      AppMethodBeat.i(146489);
      if ((paramView instanceof com.tencent.mm.plugin.appbrand.widget.f.b))
      {
        Log.d("MicroMsg.Map.DefaultTencentMapView", "recycler calloutView");
        i.a((com.tencent.mm.plugin.appbrand.widget.f.b)paramView);
      }
      AppMethodBeat.o(146489);
    }
  }
  
  public final class b
  {
    ImageView oYa;
    
    public b(ImageView paramImageView)
    {
      this.oYa = paramImageView;
    }
  }
  
  public final class c
  {
    Marker oYb;
    
    public c(Marker paramMarker)
    {
      this.oYb = paramMarker;
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
      AppMethodBeat.i(187546);
      super.onCameraChange(paramCameraPosition);
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.oYj = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.oYk = paramCameraPosition.getBearing();
        locala.skew = paramCameraPosition.getSkew();
        a.p(a.this).a(locala, a.q(a.this));
      }
      AppMethodBeat.o(187546);
    }
    
    public final void onCameraChangeFinish(CameraPosition paramCameraPosition)
    {
      AppMethodBeat.i(187548);
      super.onCameraChangeFinish(paramCameraPosition);
      Log.i("MicroMsg.Map.DefaultTencentMapView", "onCameraChangeFinish");
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.oYj = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.oYk = paramCameraPosition.getBearing();
        locala.skew = paramCameraPosition.getSkew();
        a.p(a.this).b(locala, a.q(a.this));
        a.a(a.this, false);
      }
      a.j(a.this);
      if ((a.b(a.this) != null) && (a.b(a.this).getAlgorithm().getClusters(paramCameraPosition.getZoom()).size() > 0))
      {
        paramCameraPosition = ((NonHierarchicalDistanceBasedAlgorithm)((PreCachingAlgorithmDecorator)a.b(a.this).getAlgorithm()).getAlgorithm()).getClusters(paramCameraPosition.getZoom());
        Log.i("MicroMsg.Map.DefaultTencentMapView", "onCameraChangeFinish cluster size:%d", new Object[] { Integer.valueOf(paramCameraPosition.size()) });
        paramCameraPosition = paramCameraPosition.iterator();
        while (paramCameraPosition.hasNext()) {
          Log.i("MicroMsg.Map.DefaultTencentMapView", "onCameraChangeFinish cluster item size:%d", new Object[] { Integer.valueOf(((Cluster)paramCameraPosition.next()).getItems().size()) });
        }
      }
      AppMethodBeat.o(187548);
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
      AppMethodBeat.i(189560);
      super.onBeforeClusterRendered(paramCluster, paramMarkerOptions);
      Log.i("MicroMsg.Map.DefaultTencentMapView", "onBeforeClusterRendered, cluster size:%d", new Object[] { Integer.valueOf(paramCluster.getItems().size()) });
      paramMarkerOptions = paramCluster.getItems().iterator();
      a.f localf;
      while (paramMarkerOptions.hasNext())
      {
        localf = (a.f)paramMarkerOptions.next();
        if (localf.oYg > 0) {
          a.this.ahM(localf.oYg);
        }
        a.this.ahM(a.f.a(localf));
      }
      if (a.F(a.this) != null)
      {
        paramMarkerOptions = paramCluster.getItems().iterator();
        if (paramMarkerOptions.hasNext())
        {
          localf = (a.f)paramMarkerOptions.next();
          if ((a.g)a.g(a.this).get(a.f.a(localf)) != null) {}
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label244;
          }
          a.F(a.this).p(a.a(a.this, paramCluster));
          AppMethodBeat.o(189560);
          return;
          if (localf.oYg <= 0) {
            break;
          }
        }
        label244:
        Log.e("MicroMsg.Map.DefaultTencentMapView", "don't send ClusterCreateEvent");
      }
      AppMethodBeat.o(189560);
    }
  }
  
  static final class f
    implements ClusterItem
  {
    private String id;
    private com.tencent.mapsdk.raster.model.LatLng oYf;
    int oYg;
    
    f(String paramString, com.tencent.mapsdk.raster.model.LatLng paramLatLng)
    {
      this.id = paramString;
      this.oYf = paramLatLng;
    }
    
    public final com.tencent.mapsdk.raster.model.LatLng getPosition()
    {
      return this.oYf;
    }
  }
  
  public static final class g
    extends b.u
  {
    public Marker oYb;
    public Marker oYh;
    public ImageView oYi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.a
 * JD-Core Version:    0.7.0.1
 */