package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayer.OnLayerStatusChangedListener;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.sdk.comps.vis.VisualLayerOptionsBuilder;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.CustomLayerOptions;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.OverlayLevel;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.jsapi.media.e.a;
import com.tencent.mm.plugin.appbrand.widget.g.c;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
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
import java.io.InputStream;
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
  private static final String sbS;
  private static long scq;
  FrameLayout container;
  Context context;
  private ImageView hIz;
  private long lastCheckTime;
  private Object lockObj;
  private Object mLock;
  private int mMapType;
  private boolean mUq;
  private String sbM;
  protected final SoSoMapView sbN;
  private b.l sbO;
  private b.p sbP;
  private b.o sbQ;
  private b.s sbR;
  private String sbT;
  private String sbU;
  private int sbV;
  private boolean sbW;
  private boolean sbX;
  private volatile HashMap<String, MarkerTranslateAnimator> sbY;
  private volatile HashMap<String, MarkerTranslateAnimator> sbZ;
  private boolean scA;
  private d scB;
  private com.tencent.mm.plugin.appbrand.utils.b.a.b scC;
  private final int scD;
  private AtomicBoolean scE;
  private AtomicBoolean scF;
  private b.q scG;
  private ArrayList<g> scH;
  private ArrayList<String> scI;
  private ArrayList<Integer> scJ;
  private AtomicInteger scK;
  private HashMap<Integer, Cluster<g>> scL;
  private HashMap<String, b.v> scM;
  private com.tencent.mm.plugin.appbrand.f.a scN;
  boolean scO;
  boolean scP;
  private HashMap<String, GroundOverlay> scQ;
  private HashMap<String, VisualLayer> scR;
  private HashMap<String, Arc> scS;
  private HashMap<String, VisualLayer.OnLayerStatusChangedListener> scT;
  private volatile ClusterManager<g> sca;
  private DefaultClusterRenderer<g> scb;
  private boolean scc;
  private boolean scd;
  SurfaceView sce;
  private Runnable scf;
  private b.m scg;
  private b.y sch;
  private b.z sci;
  private boolean scj;
  private b.w sck;
  private Runnable scl;
  private b.x scm;
  private b.f scn;
  private Map<String, CustomLayer> sco;
  private ArrayList<String> scp;
  private Queue<Runnable> scr;
  private CancelableCallback scs;
  public ArrayList<Circle> sct;
  public ArrayList<b> scu;
  private Map<String, Polyline> scv;
  private a.a scw;
  private Map<String, a.h> scx;
  public ArrayList<c> scy;
  public ArrayList<Polygon> scz;
  
  static
  {
    AppMethodBeat.i(146554);
    sbS = com.tencent.mm.plugin.appbrand.af.b.fr("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    scq = 500L;
    AppMethodBeat.o(146554);
  }
  
  public a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146490);
    this.sbY = new HashMap();
    this.sbZ = new HashMap();
    this.scc = false;
    this.scd = false;
    this.mLock = new Object();
    this.scf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146485);
        a.this.sce.setVisibility(4);
        AppMethodBeat.o(146485);
      }
    };
    this.scj = false;
    this.sco = new ConcurrentHashMap();
    this.scp = new ArrayList();
    this.scr = new LinkedList();
    this.scs = new CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(329452);
        a.s(a.this).poll();
        if (!a.s(a.this).isEmpty()) {
          ((Runnable)a.s(a.this).peek()).run();
        }
        AppMethodBeat.o(329452);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(329447);
        a.s(a.this).poll();
        if (!a.s(a.this).isEmpty()) {
          ((Runnable)a.s(a.this).peek()).run();
        }
        AppMethodBeat.o(329447);
      }
    };
    this.sct = new ArrayList();
    this.scu = new ArrayList();
    this.scv = new ConcurrentHashMap();
    this.scw = new a.a(this);
    this.scx = new ConcurrentHashMap();
    this.scy = new ArrayList();
    this.scz = new ArrayList();
    this.scC = new com.tencent.mm.plugin.appbrand.utils.b.a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, final com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(329436);
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.Map.DefaultTencentMapView", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(329436);
          return;
        }
        Log.d("MicroMsg.Map.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude) });
        if (!a.ctb())
        {
          Log.w("MicroMsg.Map.DefaultTencentMapView", "refresh location fail, no perrmission");
          AppMethodBeat.o(329436);
          return;
        }
        if ((!a.r(a.this)) || (a.y(a.this)))
        {
          AppMethodBeat.o(329436);
          return;
        }
        o.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(329464);
            d locald;
            double d1;
            double d2;
            if (a.this.sbN != null)
            {
              if (a.d(a.this) == null)
              {
                a.a(a.this, new d(a.u(a.this)));
                locald = a.d(a.this);
                localObject = a.this.sbN;
                com.tencent.mm.plugin.appbrand.utils.b.a.a locala = paramAnonymousa;
                MarkerOptions localMarkerOptions = new MarkerOptions();
                localMarkerOptions.anchor(0.5F, 0.5F);
                localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(locala.latitude, locala.longitude));
                localMarkerOptions.markerView(locald);
                localMarkerOptions.zIndex(2147483647);
                localMarkerOptions.flat(true);
                localMarkerOptions.tag("AnchorPoint");
                locald.sdB = ((SoSoMapView)localObject).getMap().addMarker(localMarkerOptions);
              }
              locald = a.d(a.this);
              d1 = paramAnonymousa.latitude;
              d2 = paramAnonymousa.longitude;
              Object localObject = paramAnonymousa.provider;
              double d3 = paramAnonymousa.huN;
              if ((locald.seC != -1.0D) || (locald.seD != -1.0D)) {
                break label398;
              }
              locald.seC = d1;
              locald.seA = d1;
              locald.seD = d2;
              locald.seB = d2;
              if ((locald.seC != -1.0D) && (locald.seD != -1.0D)) {
                locald.seH = f.a(locald.seD, locald.seC, d2, d1, (String)localObject, d3);
              }
              if ((locald.seF != 900.0F) && (locald.seE != 900.0F)) {
                break label433;
              }
              float f = (float)f.k(d1, d2);
              locald.seE = f;
              locald.seF = f;
            }
            for (;;)
            {
              if (locald.sdB != null) {
                locald.sdB.setPosition(new com.tencent.mapsdk.raster.model.LatLng(d1, d2));
              }
              AppMethodBeat.o(329464);
              return;
              label398:
              locald.seC = locald.seA;
              locald.seD = locald.seB;
              locald.seB = d2;
              locald.seA = d1;
              break;
              label433:
              locald.seF = locald.seE;
              locald.seE = ((float)f.k(d1, d2));
            }
          }
        });
        AppMethodBeat.o(329436);
      }
    };
    this.lastCheckTime = 0L;
    this.scD = 500;
    this.scE = new AtomicBoolean(false);
    this.scF = new AtomicBoolean(false);
    this.lockObj = new Object();
    this.scH = new ArrayList();
    this.scI = new ArrayList();
    this.scJ = new ArrayList();
    this.scK = new AtomicInteger(100);
    this.scL = new HashMap();
    this.scM = new HashMap();
    this.scQ = new HashMap();
    this.scR = new HashMap();
    this.scS = new HashMap();
    this.scT = new HashMap();
    this.context = paramContext;
    this.sbM = paramString;
    this.container = new FrameLayout(paramContext);
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.container.setBackgroundColor(0);
    this.container.setLayoutParams(paramString);
    paramString = P(paramMap);
    boolean bool;
    if ((paramMap.containsKey("isOverseasUser")) && (((Boolean)paramMap.get("isOverseasUser")).booleanValue()))
    {
      bool = true;
      if (bool) {
        paramString.setServiceProtocol(1, Integer.valueOf(com.tencent.luggage.i.a.d.sdk_protocol));
      }
      Log.i("MicroMsg.Map.DefaultTencentMapView", "isOverseaUser:%b", new Object[] { Boolean.valueOf(bool) });
      this.sbN = new SoSoMapView(paramContext, paramString);
      this.container.addView(this.sbN, new FrameLayout.LayoutParams(-1, -1));
      this.hIz = new ImageView(paramContext);
      this.hIz.setScaleType(ImageView.ScaleType.FIT_XY);
      this.container.addView(this.hIz, new ViewGroup.LayoutParams(-1, -1));
      Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s, init", new Object[] { this });
      this.sbN.getMap().setInfoWindowAdapter(this.scw);
      this.sbN.getMap().setMapAnchor(0.5F, 0.5F);
      this.sbN.getMap().enableMultipleInfowindow(true);
      this.sbN.getMap().setMapStyle(this.sbV);
      paramContext = this.sbN.getMap();
      if (!this.sbX) {
        break label849;
      }
    }
    label849:
    for (int i = 1008;; i = 1000)
    {
      paramContext.setMapType(i);
      this.sbN.getMap().setHandDrawMapEnable(this.sbW);
      this.sbN.getMap().setOnInfoWindowClickListener(new a.1(this));
      this.sbN.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener()
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
              a.c(a.this).g(a.d(a.this).getLatitude(), a.d(a.this).getLongitude());
            }
            AppMethodBeat.o(146468);
            return true;
          }
          a.h localh = a.this.aaH((String)paramAnonymousMarker.getTag());
          if (localh == null)
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
          if (localh.sec != null)
          {
            if (!((String)paramAnonymousMarker.getTag()).endsWith("#label")) {
              break label443;
            }
            Log.w("MicroMsg.Map.DefaultTencentMapView", "realMarker.getTag is label marker, do nothing");
          }
          for (;;)
          {
            if (localh.sdB != null) {
              localh.sdB.set2Top();
            }
            if (localh.sdI != null) {
              localh.sdI.set2Top();
            }
            Object localObject;
            if (a.d(a.this) != null)
            {
              localObject = a.d(a.this);
              if (((d)localObject).sdB != null) {
                ((d)localObject).sdB.set2Top();
              }
            }
            if (localh.sec.sdH <= 0) {
              break;
            }
            a.a(a.this, localh.sec.sdH);
            AppMethodBeat.o(146468);
            return true;
            label443:
            b.v.a locala = localh.sec.sei;
            if (localh.sdB != null) {
              localObject = localh.sdB;
            }
            for (;;)
            {
              if ((locala != null) && (locala.seo == b.v.a.ses) && (localObject != null))
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
            bool = a.f(a.this).c(localh);
            AppMethodBeat.o(146468);
            return bool;
          }
          boolean bool = a.e(a.this).b(localh);
          AppMethodBeat.o(146468);
          return bool;
        }
      });
      this.sbN.getMap().setOnMapClickListener(new a.20(this));
      this.sbN.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener()
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
              a.this.aaE(str);
            }
            a.l(a.this).clear();
          }
          AppMethodBeat.o(146479);
        }
      });
      this.sbN.getMap().setOnMapPoiClickListener(new a.41(this));
      this.sbN.getMap().setOnIndoorStateChangeListener(new a.42(this));
      Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
      this.sbN.onCreate(null);
      onResume();
      AppMethodBeat.o(146490);
      return;
      bool = false;
      break;
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
  private org.json.JSONObject a(Cluster<g> paramCluster, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 664
    //   3: invokestatic 243	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_2
    //   9: ifeq +211 -> 220
    //   12: aload_0
    //   13: getfield 351	com/tencent/mm/plugin/appbrand/jsapi/o/a/a:scK	Ljava/util/concurrent/atomic/AtomicInteger;
    //   16: invokevirtual 668	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 345	com/tencent/mm/plugin/appbrand/jsapi/o/a/a:scJ	Ljava/util/ArrayList;
    //   24: iload_3
    //   25: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 671	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 353	com/tencent/mm/plugin/appbrand/jsapi/o/a/a:scL	Ljava/util/HashMap;
    //   36: iload_3
    //   37: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aload_1
    //   41: invokevirtual 674	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_1
    //   46: invokeinterface 680 1 0
    //   51: invokeinterface 686 1 0
    //   56: astore 4
    //   58: aload 4
    //   60: invokeinterface 691 1 0
    //   65: ifeq +29 -> 94
    //   68: aload 4
    //   70: invokeinterface 695 1 0
    //   75: checkcast 108	com/tencent/mm/plugin/appbrand/jsapi/o/a/a$g
    //   78: iload_3
    //   79: putfield 698	com/tencent/mm/plugin/appbrand/jsapi/o/a/a$g:sdH	I
    //   82: goto -24 -> 58
    //   85: astore_1
    //   86: ldc_w 664
    //   89: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: areturn
    //   94: new 700	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 701	org/json/JSONObject:<init>	()V
    //   101: astore 4
    //   103: aload 4
    //   105: ldc_w 703
    //   108: iload_3
    //   109: invokevirtual 706	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   112: pop
    //   113: new 700	org/json/JSONObject
    //   116: dup
    //   117: invokespecial 701	org/json/JSONObject:<init>	()V
    //   120: astore 5
    //   122: aload 5
    //   124: ldc_w 708
    //   127: aload_1
    //   128: invokeinterface 712 1 0
    //   133: invokevirtual 716	com/tencent/mapsdk/raster/model/LatLng:getLatitude	()D
    //   136: invokevirtual 719	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 5
    //   142: ldc_w 721
    //   145: aload_1
    //   146: invokeinterface 712 1 0
    //   151: invokevirtual 724	com/tencent/mapsdk/raster/model/LatLng:getLongitude	()D
    //   154: invokevirtual 719	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 726
    //   163: aload 5
    //   165: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: new 651	org/json/JSONArray
    //   172: dup
    //   173: invokespecial 652	org/json/JSONArray:<init>	()V
    //   176: astore 5
    //   178: aload_1
    //   179: invokeinterface 680 1 0
    //   184: invokeinterface 686 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 691 1 0
    //   196: ifeq +64 -> 260
    //   199: aload 5
    //   201: aload_1
    //   202: invokeinterface 695 1 0
    //   207: checkcast 108	com/tencent/mm/plugin/appbrand/jsapi/o/a/a$g
    //   210: invokestatic 732	com/tencent/mm/plugin/appbrand/jsapi/o/a/a$g:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/o/a/a$g;)Ljava/lang/String;
    //   213: invokevirtual 659	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   216: pop
    //   217: goto -27 -> 190
    //   220: aload_1
    //   221: invokeinterface 680 1 0
    //   226: invokeinterface 686 1 0
    //   231: astore 4
    //   233: aload 4
    //   235: invokeinterface 691 1 0
    //   240: ifeq -146 -> 94
    //   243: aload 4
    //   245: invokeinterface 695 1 0
    //   250: checkcast 108	com/tencent/mm/plugin/appbrand/jsapi/o/a/a$g
    //   253: getfield 698	com/tencent/mm/plugin/appbrand/jsapi/o/a/a$g:sdH	I
    //   256: istore_3
    //   257: goto -163 -> 94
    //   260: aload 4
    //   262: ldc_w 734
    //   265: aload 5
    //   267: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   270: pop
    //   271: ldc_w 664
    //   274: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload 4
    //   279: areturn
    //   280: astore_1
    //   281: goto -195 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	a
    //   0	284	1	paramCluster	Cluster<g>
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
      f = com.tencent.mm.plugin.appbrand.af.i.DC(paramBitmap.getWidth());
      paramFloat1 = com.tencent.mm.plugin.appbrand.af.i.DC(paramBitmap.getHeight());
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
  
  private void a(String paramString, a.h paramh)
  {
    AppMethodBeat.i(146538);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.scx.put(paramString, paramh);
    AppMethodBeat.o(146538);
  }
  
  private void a(String paramString, b.v paramv, a.h paramh)
  {
    AppMethodBeat.i(329491);
    if (aaH(paramString + "#label") != null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker label is exist, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(329491);
      return;
    }
    if ((paramv == null) || (paramv.sej == null))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker labelStyle is null, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(329491);
      return;
    }
    if ((paramv.sdH > 0) && (!this.scJ.contains(Integer.valueOf(paramv.sdH))))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker marker is not exist, don't add, label id:%s", new Object[] { paramString + "#label" });
      AppMethodBeat.o(329491);
      return;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "addLabelMarker label id:%s, content:%s", new Object[] { paramString + "#label", paramv.sej.content });
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
    Object localObject2 = i.ctd();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.appbrand.widget.g.d(this.context);
    }
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).reset();
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).setTextColor(paramv.sej.color);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).setTextSize(paramv.sej.fontSize);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).setText(paramv.sej.content);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).setTextPadding(paramv.sej.padding);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).setGravity(paramv.sej.qTN);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).J(paramv.sej.sek, paramv.sej.borderWidth, paramv.sej.borderColor, paramv.sej.bgColor);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).setX(paramv.sej.x);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).setY(paramv.sej.y);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).gf(paramv.sej.width, paramv.sej.height);
    ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).measure(0, 0);
    localMarkerOptions.anchor(((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).getAnchorX(), ((com.tencent.mm.plugin.appbrand.widget.g.d)localObject1).getAnchorY());
    localMarkerOptions.markerView((View)localObject1);
    localMarkerOptions.visible(true);
    localMarkerOptions.tag(paramString + "#label");
    localMarkerOptions.zIndex(paramv.zIndex + 3);
    localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
    if ((!Util.isNullOrNil(paramv.buildingId)) && (!Util.isNullOrNil(paramv.floorName))) {
      localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
    }
    localObject2 = this.sbN.getMap().addMarker(localMarkerOptions);
    localObject1 = paramh;
    if (paramh == null)
    {
      localObject1 = new a.h();
      ((a.h)localObject1).sec = paramv;
    }
    ((a.h)localObject1).sdI = ((Marker)localObject2);
    ((a.h)localObject1).data = paramv.data;
    a(paramString + "#label", (a.h)localObject1);
    AppMethodBeat.o(329491);
  }
  
  private boolean a(b.aa paramaa)
  {
    AppMethodBeat.i(329529);
    if (this.sbN.getMap() == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addMapMarkerCluster map is null");
      AppMethodBeat.o(329529);
      return false;
    }
    if (!csV())
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addMapMarkerCluster mClusterManager is not initialize");
      AppMethodBeat.o(329529);
      return false;
    }
    if ((this.scI.contains(paramaa.id)) && (aaK(paramaa.id) != null)) {}
    for (int i = 0;; i = 1)
    {
      g localg;
      if (i != 0)
      {
        ??? = new com.tencent.mapsdk.raster.model.LatLng(paramaa.seu.latitude, paramaa.seu.longitude);
        localg = new g(paramaa.id, (com.tencent.mapsdk.raster.model.LatLng)???);
      }
      for (;;)
      {
        synchronized (this.lockObj)
        {
          this.scH.add(localg);
          this.scI.add(g.a(localg));
          this.sca.addItem(localg);
          this.sca.cluster();
          Log.i("MicroMsg.Map.DefaultTencentMapView", "addMapMarkerCluster mClusterItems:%d， id:%s， latitude:%f, longitude:%f", new Object[] { Integer.valueOf(this.scH.size()), paramaa.id, Double.valueOf(localg.getPosition().getLatitude()), Double.valueOf(localg.getPosition().getLongitude()) });
          AppMethodBeat.o(329529);
          return true;
        }
        Log.i("MicroMsg.Map.DefaultTencentMapView", "cluster item is added!");
      }
    }
  }
  
  private g aaK(String paramString)
  {
    AppMethodBeat.i(329540);
    Iterator localIterator = this.scH.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (paramString.contains(g.a(localg)))
      {
        AppMethodBeat.o(329540);
        return localg;
      }
    }
    AppMethodBeat.o(329540);
    return null;
  }
  
  private boolean aaL(String paramString)
  {
    AppMethodBeat.i(329550);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeMapMarkerClusterGeometry id:%s", new Object[] { paramString });
    if ((this.sca != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      synchronized (this.lockObj)
      {
        Iterator localIterator = this.scH.iterator();
        if (!localIterator.hasNext()) {
          break label256;
        }
        localg = (g)localIterator.next();
        if (!paramString.contains(g.a(localg))) {
          continue;
        }
        if (localg == null) {
          break label248;
        }
        this.sca.removeItem(localg);
      }
      synchronized (this.lockObj)
      {
        this.scH.remove(localg);
        this.scI.remove(paramString);
        this.scM.remove(paramString);
        if (localg.sdH > 0)
        {
          aaJ(localg.sdH);
          this.scJ.remove(Integer.valueOf(localg.sdH));
          this.scL.remove(Integer.valueOf(localg.sdH));
        }
        Log.i("MicroMsg.Map.DefaultTencentMapView", "remove MapMarker ClusterGeometry success id:%s", new Object[] { paramString });
        this.sca.cluster();
        AppMethodBeat.o(329550);
        return true;
        paramString = finally;
        AppMethodBeat.o(329550);
        throw paramString;
      }
      label248:
      AppMethodBeat.o(329550);
      return false;
      label256:
      g localg = null;
    }
  }
  
  private static int aaM(String paramString)
  {
    AppMethodBeat.i(329573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(329573);
      return -1;
    }
    int i;
    if (paramString.equals("abovelabels"))
    {
      i = OverlayLevel.OverlayLevelAboveLabels;
      AppMethodBeat.o(329573);
      return i;
    }
    if (paramString.equals("abovebuildings"))
    {
      i = OverlayLevel.OverlayLevelAboveBuildings;
      AppMethodBeat.o(329573);
      return i;
    }
    if (paramString.equals("aboveroads"))
    {
      i = OverlayLevel.OverlayLevelAboveRoads;
      AppMethodBeat.o(329573);
      return i;
    }
    AppMethodBeat.o(329573);
    return -1;
  }
  
  private void ai(Runnable paramRunnable)
  {
    AppMethodBeat.i(146524);
    this.scr.add(paramRunnable);
    if (this.scr.size() == 1) {
      paramRunnable.run();
    }
    AppMethodBeat.o(146524);
  }
  
  private void b(final Marker paramMarker)
  {
    AppMethodBeat.i(329504);
    if (paramMarker == null)
    {
      AppMethodBeat.o(329504);
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMarker.showInfoWindow();
      AppMethodBeat.o(329504);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329423);
        paramMarker.showInfoWindow();
        AppMethodBeat.o(329423);
      }
    });
    AppMethodBeat.o(329504);
  }
  
  /* Error */
  private static Bitmap c(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: ldc_w 1292
    //   3: invokestatic 243	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 427
    //   9: ldc_w 1294
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: invokestatic 437	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_0
    //   24: invokestatic 1300	com/tencent/mm/plugin/appbrand/m/a:Q	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   27: astore_0
    //   28: aload_0
    //   29: invokestatic 1303	com/tencent/mm/plugin/appbrand/m/a:getCompatibleRewindBufferSize	()I
    //   32: invokevirtual 1308	java/io/InputStream:mark	(I)V
    //   35: new 1310	android/graphics/BitmapFactory$Options
    //   38: dup
    //   39: invokespecial 1311	android/graphics/BitmapFactory$Options:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: iconst_1
    //   45: putfield 1314	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   48: invokestatic 1318	com/tencent/mm/plugin/appbrand/jsapi/o/a/a:csY	()Lcom/tencent/mm/plugin/appbrand/jsapi/media/e;
    //   51: aload_0
    //   52: aload_2
    //   53: invokeinterface 1323 3 0
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 1324	java/io/InputStream:reset	()V
    //   63: aload_2
    //   64: getfield 1327	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   67: iconst_1
    //   68: if_icmpgt +8 -> 76
    //   71: aload_2
    //   72: iconst_1
    //   73: putfield 1327	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   76: aload_2
    //   77: getfield 1330	android/graphics/BitmapFactory$Options:outHeight	I
    //   80: aload_2
    //   81: getfield 1333	android/graphics/BitmapFactory$Options:outWidth	I
    //   84: imul
    //   85: aload_2
    //   86: getfield 1327	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: idiv
    //   90: aload_2
    //   91: getfield 1327	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   94: idiv
    //   95: ldc_w 1334
    //   98: if_icmple +96 -> 194
    //   101: aload_2
    //   102: aload_2
    //   103: getfield 1327	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   106: iconst_1
    //   107: iadd
    //   108: putfield 1327	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   111: goto -35 -> 76
    //   114: astore_0
    //   115: ldc_w 427
    //   118: ldc_w 1336
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_1
    //   128: aastore
    //   129: invokestatic 1037	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: ldc_w 427
    //   135: aload_0
    //   136: ldc_w 1338
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 1342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc_w 1292
    //   149: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: ldc_w 427
    //   158: ldc_w 1336
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: aastore
    //   169: invokestatic 1037	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: ldc_w 427
    //   175: aload_0
    //   176: ldc_w 1344
    //   179: iconst_0
    //   180: anewarray 4	java/lang/Object
    //   183: invokestatic 1342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: ldc_w 1292
    //   189: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aconst_null
    //   193: areturn
    //   194: aload_2
    //   195: iconst_0
    //   196: putfield 1314	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   199: aload_2
    //   200: iconst_1
    //   201: putfield 1347	android/graphics/BitmapFactory$Options:inMutable	Z
    //   204: invokestatic 1318	com/tencent/mm/plugin/appbrand/jsapi/o/a/a:csY	()Lcom/tencent/mm/plugin/appbrand/jsapi/media/e;
    //   207: aload_0
    //   208: aload_2
    //   209: invokeinterface 1323 3 0
    //   214: astore_0
    //   215: ldc_w 1292
    //   218: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_0
    //   222: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramInputStream	InputStream
    //   0	223	1	paramString	String
    //   42	167	2	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   59	76	114	finally
    //   76	111	114	finally
    //   194	215	114	finally
    //   48	59	154	java/lang/IllegalArgumentException
  }
  
  private void c(String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(329500);
    Object localObject;
    if ((paramv.sdH > 0) && (this.scJ.contains(Integer.valueOf(paramv.sdH))))
    {
      localObject = (Cluster)this.scL.get(Integer.valueOf(paramv.sdH));
      if (localObject == null) {
        break label545;
      }
      localObject = ((e)this.sca.getRenderer()).getMarker((Cluster)localObject);
    }
    for (;;)
    {
      final ImageView localImageView;
      if (localObject != null)
      {
        if (paramv.sed) {
          ((Marker)localObject).setPosition(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        }
        if (!Util.isNullOrNil(paramv.title)) {
          ((Marker)localObject).setTitle(paramv.title);
        }
        if (!Util.isNullOrNil(paramv.seg)) {
          ((Marker)localObject).setContentDescription(paramv.seg);
        }
        ((Marker)localObject).setRotation(paramv.aBi);
        ((Marker)localObject).setAlpha(paramv.alpha);
        final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(com.tencent.luggage.i.a.c.default_tencent_map_marker_icon, null);
        localImageView = (ImageView)localFrameLayout.findViewById(com.tencent.luggage.i.a.b.marker_icon);
        final float f1 = paramv.see;
        final float f2 = paramv.sef;
        if (parama != null) {
          if (!Util.isNullOrNil(paramv.sdM))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            parama = parama.a(paramv.sdM, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void W(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(329461);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if (this.sdk != null)
                  {
                    Log.v("MicroMsg.Map.DefaultTencentMapView", "setMarkerView");
                    this.sdk.setMarkerView(localFrameLayout);
                  }
                }
                AppMethodBeat.o(329461);
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
            if ((TextUtils.isEmpty(paramv.seh)) || (!paramv.seh.equals("withLabel"))) {
              break label518;
            }
            ((Marker)localObject).setCollisions(new Collision[] { MarkerCollisionItem.POI });
            AppMethodBeat.o(329500);
            return;
            if (!paramv.sed) {
              break label539;
            }
            localObject = aaK(paramString);
            if (localObject == null) {
              break label533;
            }
          }
        }
      }
      label518:
      label533:
      for (localObject = ((e)this.sca.getRenderer()).getMarker((ClusterItem)localObject);; localObject = null)
      {
        this.scM.put(paramString, paramv);
        if (this.scN == null) {
          this.scN = parama;
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
        AppMethodBeat.o(329500);
        return;
      }
      label539:
      localObject = null;
      continue;
      label545:
      localObject = null;
    }
  }
  
  private static b.f csH()
  {
    AppMethodBeat.i(146492);
    b.f localf = new b.f();
    localf.buildingId = "";
    localf.buildingName = "";
    localf.sdQ = new LinkedList();
    localf.sdR = -1;
    AppMethodBeat.o(146492);
    return localf;
  }
  
  private void csI()
  {
    AppMethodBeat.i(146496);
    if (this.sce == null) {
      this.sce = getSurfaceView();
    }
    if (this.sce != null)
    {
      MMHandlerThread.removeRunnable(this.scf);
      this.sce.setVisibility(0);
      AppMethodBeat.o(146496);
      return;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "showTencentMap err");
    AppMethodBeat.o(146496);
  }
  
  private Bundle csU()
  {
    AppMethodBeat.i(146545);
    Bundle localBundle = new Bundle();
    if (!sbS.equals(this.sbT))
    {
      String str = Util.nullAsNil(localBundle.getString("smallAppKey"));
      localBundle.putString("smallAppKey", str + this.sbT + "#" + this.sbU + ";");
    }
    AppMethodBeat.o(146545);
    return localBundle;
  }
  
  private boolean csX()
  {
    AppMethodBeat.i(329557);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeAllMapCluster");
    if (this.sca != null)
    {
      Object localObject2 = new ArrayList();
      synchronized (this.lockObj)
      {
        ((ArrayList)localObject2).addAll(this.scH);
        this.scI.clear();
        this.scH.clear();
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (g)((Iterator)???).next();
          this.sca.removeItem((ClusterItem)localObject2);
        }
      }
      this.scM.clear();
      AppMethodBeat.o(329557);
      return true;
    }
    AppMethodBeat.o(329557);
    return false;
  }
  
  private static com.tencent.mm.plugin.appbrand.jsapi.media.e csY()
  {
    AppMethodBeat.i(329587);
    com.tencent.mm.plugin.appbrand.jsapi.media.e locale = e.a.a((com.tencent.mm.plugin.appbrand.jsapi.media.e)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.media.e.class));
    AppMethodBeat.o(329587);
    return locale;
  }
  
  private SurfaceView getSurfaceView()
  {
    AppMethodBeat.i(146495);
    if (this.sce != null)
    {
      localSurfaceView = this.sce;
      AppMethodBeat.o(146495);
      return localSurfaceView;
    }
    this.sce = m(this.sbN);
    SurfaceView localSurfaceView = this.sce;
    AppMethodBeat.o(146495);
    return localSurfaceView;
  }
  
  private static SurfaceView m(ViewGroup paramViewGroup)
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
  
  private void r(List<com.tencent.mapsdk.raster.model.LatLng> paramList, int paramInt)
  {
    AppMethodBeat.i(329484);
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramList);
    this.scj = false;
    this.sbN.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.scl = null;
    AppMethodBeat.o(329484);
  }
  
  public final boolean AO(int paramInt)
  {
    AppMethodBeat.i(330033);
    if (!this.scQ.containsKey(String.valueOf(paramInt)))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "removeGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(330033);
      return false;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    GroundOverlay localGroundOverlay = (GroundOverlay)this.scQ.remove(String.valueOf(paramInt));
    if (localGroundOverlay != null)
    {
      localGroundOverlay.remove();
      AppMethodBeat.o(330033);
      return true;
    }
    AppMethodBeat.o(330033);
    return false;
  }
  
  public final void AP(int paramInt)
  {
    AppMethodBeat.i(330104);
    if (this.scS.containsKey(String.valueOf(paramInt)))
    {
      ((Arc)this.scS.remove(String.valueOf(paramInt))).remove();
      Log.i("MicroMsg.Map.DefaultTencentMapView", "removeMapArc success id:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(330104);
      return;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeMapArc fail id:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(330104);
  }
  
  public void B(MotionEvent paramMotionEvent) {}
  
  protected TencentMapOptions P(Map<String, Object> paramMap)
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
    this.sbW = str.equals("handDraw");
    this.mMapType = f.a(paramMap, "mapType", 1);
    localTencentMapOptions.setMapType(this.mMapType);
    this.sbT = f.a(paramMap, "subKey", "");
    this.sbU = f.a(paramMap, "subId", "");
    boolean bool;
    if (f.a(paramMap, "enableDarkMode", 0) == 1)
    {
      bool = true;
      this.sbX = bool;
      if (!Util.isNullOrNil(this.sbT)) {
        break label288;
      }
      this.sbT = sbS;
      this.sbU = "";
    }
    for (;;)
    {
      localTencentMapOptions.setSubInfo(this.sbT, this.sbU);
      this.sbV = f.a(paramMap, "styleId", 0);
      Log.d("MicroMsg.Map.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.sbU, this.sbT });
      Log.i("MicroMsg.Map.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d enableDarkmode:%b", new Object[] { str, Boolean.valueOf(this.sbW), Integer.valueOf(this.mMapType), this.sbU, this.sbT, Integer.valueOf(this.sbV), Boolean.valueOf(this.sbX) });
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
      bool = false;
      break;
      label288:
      this.sbX = false;
    }
  }
  
  public final Point a(b.i parami)
  {
    AppMethodBeat.i(330047);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "toScreenLocation");
    parami = new com.tencent.mapsdk.raster.model.LatLng(parami.latitude, parami.longitude);
    parami = this.sbN.getMap().getProjection().toScreenLocation(parami);
    AppMethodBeat.o(330047);
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
    final TencentMap localTencentMap = this.sbN.getMap();
    if (localTencentMap != null)
    {
      if (paramBoolean)
      {
        ai(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146465);
            CameraUpdate localCameraUpdate = a.b(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, this.oEH);
            Log.v("MicroMsg.Map.DefaultTencentMapView", "doing map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(this.oEH), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
            a.a(a.this, false);
            localTencentMap.animateCamera(localCameraUpdate, a.cta(), a.t(a.this));
            AppMethodBeat.o(146465);
          }
        });
        AppMethodBeat.o(146522);
        return;
      }
      CameraUpdate localCameraUpdate = a(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, paramDouble2);
      this.scj = false;
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
    int i = aaM(???.sdL);
    if (i >= 0) {
      ((CircleOptions)localObject1).level(i);
    }
    for (;;)
    {
      localObject1 = this.sbN.getMap().addCircle((CircleOptions)localObject1);
      synchronized (this.sct)
      {
        this.sct.add(localObject1);
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
    Object localObject3 = paramk.sdW.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      b.i locali = (b.i)((Iterator)localObject3).next();
      ((List)localObject2).add(new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude));
    }
    ((PolylineOptions)localObject1).addAll((Iterable)localObject2);
    if ((paramk.seb != null) && (paramk.seb.size() > 0))
    {
      Log.i("MicroMsg.Map.DefaultTencentMapView", "colorList size:%d ", new Object[] { Integer.valueOf(paramk.seb.size()) });
      int j = paramk.seb.size();
      localObject2 = new int[j];
      localObject3 = new int[j];
      while (i < j)
      {
        localObject2[i] = ((Integer)paramk.seb.get(i)).intValue();
        localObject3[i] = i;
        i += 1;
      }
      ((PolylineOptions)localObject1).colors((int[])localObject2, (int[])localObject3);
      ((PolylineOptions)localObject1).setEnableGradient(paramk.enableGradient);
      ((PolylineOptions)localObject1).width(paramk.width);
      ((PolylineOptions)localObject1).setDottedLine(paramk.sdX);
      ((PolylineOptions)localObject1).edgeColor(paramk.borderColor);
      ((PolylineOptions)localObject1).edgeWidth(paramk.borderWidth);
      if (paramk.sdY)
      {
        parama = parama.eC(paramk.sdZ);
        ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(parama));
        if (parama == null) {
          ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), com.tencent.luggage.i.a.a.app_brand_map_line_texture_arrow)));
        }
      }
      ((PolylineOptions)localObject1).zIndex(1.0F);
      if ((!Util.isNullOrNil(paramk.buildingId)) && (!Util.isNullOrNil(paramk.floorName))) {
        ((PolylineOptions)localObject1).indoorInfo(new IndoorInfo(paramk.buildingId, paramk.floorName));
      }
      ((PolylineOptions)localObject1).arrowGap(paramk.sea);
      i = aaM(paramk.sdL);
      if (i < 0) {
        break label501;
      }
      ((PolylineOptions)localObject1).level(i);
    }
    for (;;)
    {
      ((PolylineOptions)localObject1).lineCap(true);
      ((PolylineOptions)localObject1).setTextStyle(paramk.textStyle);
      ((PolylineOptions)localObject1).setSegmentTexts(paramk.segmentTexts);
      localObject1 = this.sbN.getMap().addPolyline((PolylineOptions)localObject1);
      if (localObject1 != null) {
        break label513;
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
      label501:
      ((PolylineOptions)localObject1).level(OverlayLevel.OverlayLevelAboveRoads);
    }
    label513:
    if (Util.isNullOrNil(paramk.id)) {}
    for (parama = paramk.hashCode();; parama = paramk.id)
    {
      this.scv.put(Util.nullAs(parama, paramk.toString()), localObject1);
      AppMethodBeat.o(146531);
      return;
    }
  }
  
  public final void a(b.l paraml)
  {
    this.sbO = paraml;
  }
  
  public final void a(b.m paramm)
  {
    this.scg = paramm;
  }
  
  public final void a(b.o paramo)
  {
    this.sbQ = paramo;
  }
  
  public final void a(b.p paramp)
  {
    this.sbP = paramp;
  }
  
  public final void a(b.s params)
  {
    this.sbR = params;
  }
  
  public final void a(b.w paramw)
  {
    AppMethodBeat.i(146499);
    this.sck = paramw;
    this.sbN.getMap().setTencentMapGestureListener(new TencentMap.TencentMapGestureListener()
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
    this.sbN.getMap().setOnMapCameraChangeListener(new TencentMap.OnMapCameraChangeListener()
    {
      public final void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(146459);
        if (a.p(a.this) != null)
        {
          b.a locala = new b.a();
          locala.sdK = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.aBi = paramAnonymousCameraPosition.getBearing();
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
          locala.sdK = new b.i(paramAnonymousCameraPosition.getTarget().getLatitude(), paramAnonymousCameraPosition.getTarget().getLongitude());
          locala.zoom = paramAnonymousCameraPosition.getZoom();
          locala.aBi = paramAnonymousCameraPosition.getBearing();
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
    this.scm = paramx;
  }
  
  public final void a(b.z paramz)
  {
    this.sci = paramz;
  }
  
  public final void a(String paramString, int paramInt, b.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(146532);
    Polyline localPolyline = (Polyline)this.scv.get(paramString);
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
    AppMethodBeat.i(329816);
    if ((parama != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = parama.a(paramString, null, new com.tencent.mm.plugin.appbrand.f.a.b()
      {
        public final void W(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(329451);
          if (paramAnonymousBitmap != null)
          {
            if ((a.d(a.this) != null) && (a.d(a.this).getRealMarker() != null))
            {
              a.d(a.this).getRealMarker().setIcon(com.tencent.mapsdk.raster.model.BitmapDescriptorFactory.fromBitmap(paramAnonymousBitmap));
              Log.i("MicroMsg.Map.DefaultTencentMapView", "setMapLocMarkerIcon success");
              AppMethodBeat.o(329451);
            }
          }
          else {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "setMapLocMarkerIcon load bitmap is null");
          }
          AppMethodBeat.o(329451);
        }
      });
      if ((paramString != null) && (this.scB != null) && (this.scB.getRealMarker() != null))
      {
        this.scB.getRealMarker().setIcon(com.tencent.mapsdk.raster.model.BitmapDescriptorFactory.fromBitmap(paramString));
        Log.i("MicroMsg.Map.DefaultTencentMapView", "setMapLocMarkerIcon success");
      }
    }
    AppMethodBeat.o(329816);
  }
  
  public final void a(String paramString, b.v paramv)
  {
    AppMethodBeat.i(182816);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s updateMarker markerId:%s", new Object[] { this, paramString });
    final a.h localh = aaH(paramString);
    if (localh != null) {
      if (paramv.sei != null)
      {
        if (paramv.sei.view == null) {
          break label609;
        }
        localh.sec.sei = paramv.sei;
        if (localh.sdB != null)
        {
          ??? = localh.sdB;
          if (??? != null)
          {
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label547;
            }
            ((Marker)???).setInfoWindowOffset(paramv.sei.sep, paramv.sei.ser);
          }
        }
        if ((localh.sdB == null) || (paramv.sei.seo != b.v.a.set)) {
          break label563;
        }
        b(localh.sdB);
      }
    }
    for (;;)
    {
      if (paramv.sej != null)
      {
        localh.sdI.remove();
        aaI(paramString + "#label");
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        com.tencent.mm.plugin.appbrand.widget.g.d locald = i.ctd();
        ??? = locald;
        if (locald == null) {
          ??? = new com.tencent.mm.plugin.appbrand.widget.g.d(this.context);
        }
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).reset();
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).setTextColor(paramv.sej.color);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).setTextSize(paramv.sej.fontSize);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).setText(paramv.sej.content);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).setTextPadding(paramv.sej.padding);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).setGravity(paramv.sej.qTN);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).J(paramv.sej.sek, paramv.sej.borderWidth, paramv.sej.borderColor, paramv.sej.bgColor);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).setX(paramv.sej.x);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).setY(paramv.sej.y);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).gf(paramv.sej.width, paramv.sej.height);
        ((com.tencent.mm.plugin.appbrand.widget.g.d)???).measure(0, 0);
        localMarkerOptions.anchor(((com.tencent.mm.plugin.appbrand.widget.g.d)???).getAnchorX(), ((com.tencent.mm.plugin.appbrand.widget.g.d)???).getAnchorY());
        localMarkerOptions.markerView((View)???);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramv.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!Util.isNullOrNil(paramv.buildingId)) && (!Util.isNullOrNil(paramv.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramv.buildingId, paramv.floorName));
        }
        localh.sdI = this.sbN.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", localh);
      }
      AppMethodBeat.o(182816);
      return;
      label547:
      MMHandlerThread.postToMainThread(new a.25(this, (Marker)???, paramv));
      break;
      label563:
      if (localh.sdB == null) {
        continue;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        localh.sdB.refreshInfoWindow();
        continue;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329422);
          localh.sdB.refreshInfoWindow();
          AppMethodBeat.o(329422);
        }
      });
      continue;
      label609:
      synchronized (this.mLock)
      {
        localh.sdJ = null;
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
        AppMethodBeat.i(329458);
        a.this.b(paramString, paramv, parama);
        AppMethodBeat.o(329458);
      }
    });
    AppMethodBeat.o(146536);
  }
  
  public final void a(final String paramString, ArrayList<b.i> arg2, long paramLong, boolean paramBoolean, b.r arg6)
  {
    AppMethodBeat.i(329952);
    a.h localh = aaH(paramString);
    if ((localh == null) || (localh.sdB == null))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "get marker failed!");
      ???.jp(false);
      AppMethodBeat.o(329952);
      return;
    }
    if (???.size() <= 0)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "keyFrame is empty, err, return");
      ???.jp(false);
      AppMethodBeat.o(329952);
      return;
    }
    synchronized (this.sbY)
    {
      if (this.sbY.containsKey(paramString)) {
        o.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(329432);
            this.sdq.cancelAnimation();
            AppMethodBeat.o(329432);
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
    ??? = new MarkerTranslateAnimator(localh.sdB, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
    ???.addAnimatorListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(329454);
        Log.i("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationCancel");
        if (paramr != null) {
          paramr.csE();
        }
        synchronized (a.w(a.this))
        {
          a.w(a.this).remove(paramString);
          AppMethodBeat.o(329454);
          return;
        }
      }
      
      public final void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(329450);
        Log.i("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationEnd");
        if (paramr != null) {
          paramr.jp(true);
        }
        synchronized (a.w(a.this))
        {
          a.w(a.this).remove(paramString);
          AppMethodBeat.o(329450);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(329444);
        Log.i("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationStart");
        AppMethodBeat.o(329444);
      }
    });
    synchronized (this.sbY)
    {
      this.sbY.put(paramString, ???);
      o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329441);
          Log.d("MicroMsg.Map.DefaultTencentMapView", "MarkerTranslateAnimator start");
          paramArrayList.startAnimation();
          AppMethodBeat.o(329441);
        }
      });
      if (localh.sdI != null)
      {
        Log.d("MicroMsg.Map.DefaultTencentMapView", "labelMarker do move animator");
        synchronized (this.sbZ)
        {
          if (this.sbZ.containsKey(paramString)) {
            o.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(329443);
                this.sdq.cancelAnimation();
                AppMethodBeat.o(329443);
              }
            });
          }
          ??? = new MarkerTranslateAnimator(localh.sdI, paramLong, (com.tencent.mapsdk.raster.model.LatLng[])???, paramBoolean);
          ???.addAnimatorListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator arg1)
            {
              AppMethodBeat.i(329453);
              synchronized (a.x(a.this))
              {
                a.x(a.this).remove(paramString);
                AppMethodBeat.o(329453);
                return;
              }
            }
            
            public final void onAnimationEnd(Animator arg1)
            {
              AppMethodBeat.i(329449);
              synchronized (a.x(a.this))
              {
                a.x(a.this).remove(paramString);
                AppMethodBeat.o(329449);
                return;
              }
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          });
        }
      }
    }
    synchronized (this.sbZ)
    {
      this.sbZ.put(paramString, ???);
      o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329434);
          paramr.startAnimation();
          AppMethodBeat.o(329434);
        }
      });
      AppMethodBeat.o(329952);
      return;
      paramString = finally;
      AppMethodBeat.o(329952);
      throw paramString;
      paramString = finally;
      AppMethodBeat.o(329952);
      throw paramString;
    }
  }
  
  public final void a(String paramString, LinkedList<b.h> paramLinkedList, final b.r paramr)
  {
    AppMethodBeat.i(146539);
    paramString = aaH(paramString);
    if ((paramString == null) || (paramString.sdB == null))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "get marker failed!");
      paramr.jp(false);
      AppMethodBeat.o(146539);
      return;
    }
    if (paramLinkedList.size() <= 0)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "keyFrame is empty, err, return");
      paramr.jp(false);
      AppMethodBeat.o(146539);
      return;
    }
    Object localObject = (b.h)paramLinkedList.get(0);
    ((b.h)localObject).sdT = paramString.sdB.getPosition().getLatitude();
    ((b.h)localObject).sdS = paramString.sdB.getPosition().getLongitude();
    int j = paramLinkedList.size();
    int i = 1;
    if (i < j)
    {
      localObject = (b.h)paramLinkedList.get(i - 1);
      b.h localh = (b.h)paramLinkedList.get(i);
      if (((b.h)localObject).aBi == 0.0F) {
        localh.sdS = ((b.h)localObject).longitude;
      }
      for (localh.sdT = ((b.h)localObject).latitude;; localh.sdT = paramString.sdB.getPosition().getLatitude())
      {
        i += 1;
        break;
        localh.sdS = paramString.sdB.getPosition().getLongitude();
      }
    }
    localObject = new c(paramLinkedList, paramString.sdB, this.sbN);
    paramr = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(329430);
        Log.d("MicroMsg.Map.DefaultTencentMapView", "MarkerAnimator end");
        if (paramr != null) {
          paramr.jp(true);
        }
        AppMethodBeat.o(329430);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(329427);
        Log.d("MicroMsg.Map.DefaultTencentMapView", "MarkerAnimator start");
        AppMethodBeat.o(329427);
      }
    };
    ((c)localObject).cis.addListener(paramr);
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329426);
        this.sdo.cis.start();
        AppMethodBeat.o(329426);
      }
    });
    if (paramString.sdI != null) {
      o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329429);
          this.sdp.cis.start();
          AppMethodBeat.o(329429);
        }
      });
    }
    AppMethodBeat.o(146539);
  }
  
  public final boolean a(final int paramInt, b.e parame, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(330031);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay fail, id < 0 or options is null");
      AppMethodBeat.o(330031);
      return false;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "remove GroundOverlay id:%d, first ,and than add again", new Object[] { Integer.valueOf(paramInt) });
    AO(paramInt);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    final GroundOverlayOptions localGroundOverlayOptions = new GroundOverlayOptions();
    Object localObject;
    if ((parame.sdO != null) && (parame.sdP != null))
    {
      localObject = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      ((com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject).longitude = parame.sdO.longitude;
      ((com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject).latitude = parame.sdO.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng.longitude = parame.sdP.longitude;
      localLatLng.latitude = parame.sdP.latitude;
      localGroundOverlayOptions.latLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng, (com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject));
    }
    localGroundOverlayOptions.alpha(parame.alpha);
    localGroundOverlayOptions.visible(parame.visible);
    localGroundOverlayOptions.zIndex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.sdM)))
    {
      localObject = parame.sdM;
      parama.a(parame.sdM, new com.tencent.mm.plugin.appbrand.f.a.c()
      {
        public final void N(InputStream paramAnonymousInputStream)
        {
          AppMethodBeat.i(329440);
          if (paramAnonymousInputStream == null)
          {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay, openRead failed, url=%s", new Object[] { this.owD });
            AppMethodBeat.o(329440);
            return;
          }
          Bitmap localBitmap = a.d(paramAnonymousInputStream, this.owD);
          org.apache.commons.b.d.ai(paramAnonymousInputStream);
          if ((localBitmap != null) && (!localBitmap.isRecycled()))
          {
            localGroundOverlayOptions.bitmap(com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory.fromBitmap(localBitmap));
            localBitmap.recycle();
            paramAnonymousInputStream = a.this.sbN.getMap().addGroundOverlay(localGroundOverlayOptions);
            if (paramAnonymousInputStream == null)
            {
              Log.e("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
              AppMethodBeat.o(329440);
              return;
            }
            a.G(a.this).put(paramInt, paramAnonymousInputStream);
            Log.i("MicroMsg.Map.DefaultTencentMapView", "addGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(329440);
            return;
          }
          Log.e("MicroMsg.Map.DefaultTencentMapView", "groundOverlay decode bitmap fail");
          AppMethodBeat.o(329440);
        }
      });
    }
    while (parama == null)
    {
      AppMethodBeat.o(330031);
      return true;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(330031);
    return false;
  }
  
  public final boolean a(int paramInt1, b.i parami1, b.i parami2, b.i parami3, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(330095);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "addMapArc id:%d", new Object[] { Integer.valueOf(paramInt1) });
    if (this.scS.containsKey(String.valueOf(paramInt1)))
    {
      ((Arc)this.scS.remove(String.valueOf(paramInt1))).remove();
      Log.i("MicroMsg.Map.DefaultTencentMapView", "removeMapArc success id:%d first and add again", new Object[] { Integer.valueOf(paramInt1) });
    }
    ArcOptions localArcOptions = new ArcOptions();
    com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
    localLatLng.latitude = parami1.latitude;
    localLatLng.longitude = parami1.longitude;
    parami1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
    parami1.latitude = parami2.latitude;
    parami1.longitude = parami2.longitude;
    if (parami3 != null)
    {
      parami2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      parami2.latitude = parami3.latitude;
      parami2.longitude = parami3.longitude;
      localArcOptions.pass(parami2);
    }
    localArcOptions.points(localLatLng, parami1);
    localArcOptions.angle(paramFloat1);
    localArcOptions.width(paramFloat2);
    localArcOptions.color(paramInt2);
    parami1 = this.sbN.getMap().addArc(localArcOptions);
    if (parami1 != null)
    {
      Log.i("MicroMsg.Map.DefaultTencentMapView", "addMapArc success, id:%d", new Object[] { Integer.valueOf(paramInt1) });
      this.scS.put(String.valueOf(paramInt1), parami1);
      AppMethodBeat.o(330095);
      return true;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "addMapArc fail, id:%d", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(330095);
    return false;
  }
  
  public final boolean a(b.ab arg1)
  {
    AppMethodBeat.i(146543);
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.sdW.iterator();
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
    int i = aaM(???.sdL);
    if (i >= 0) {
      ((PolygonOptions)localObject1).level(i);
    }
    ??? = ???.sev;
    if ((??? != null) && (???.length >= 2) && ((???[0] > 0) || (???[1] > 0)))
    {
      localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(???[0]));
      localArrayList.add(Integer.valueOf(???[1]));
      ((PolygonOptions)localObject1).pattern(localArrayList);
    }
    localObject1 = this.sbN.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.scz)
    {
      this.scz.add(localObject1);
      AppMethodBeat.o(146543);
      return true;
    }
  }
  
  public final boolean a(b.c paramc, b.n paramn, final com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(146528);
    if (Util.isNullOrNil(paramc.sdM))
    {
      AppMethodBeat.o(146528);
      return false;
    }
    Object localObject = parama.eC(paramc.sdM);
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
      i = com.tencent.mm.plugin.appbrand.af.i.DC(((Bitmap)localObject).getHeight());
      if (paramc.width != 0) {
        break label217;
      }
    }
    label217:
    for (int j = com.tencent.mm.plugin.appbrand.af.i.DC(((Bitmap)localObject).getWidth());; j = paramc.width)
    {
      localObject = new FrameLayout.LayoutParams(j, i);
      ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
      boolean bool = paramc.sdN;
      paramc = paramc.data;
      parama.setOnTouchListener(new a.8(this, bool, parama));
      parama.setOnClickListener(new a.10(this, bool, paramn, paramc));
      o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329462);
          ((ViewGroup)a.this.container).addView(parama, this.sdb);
          synchronized (a.this.scu)
          {
            a.this.scu.add(new a.b(a.this, parama));
            AppMethodBeat.o(329462);
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
    if (Util.isNullOrNil(???.sdM))
    {
      AppMethodBeat.o(146541);
      return false;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(???.latitude, ???.longitude));
    parama = parama.eC(???.sdM);
    if ((parama != null) && (!parama.isRecycled())) {
      localMarkerOptions.icon(new BitmapDescriptor(parama));
    }
    localMarkerOptions.rotation(???.aBi);
    parama = this.sbN.getMap().addMarker(localMarkerOptions);
    synchronized (this.scy)
    {
      this.scy.add(new c(parama));
      AppMethodBeat.o(146541);
      return true;
    }
  }
  
  public final boolean a(b.j paramj)
  {
    AppMethodBeat.i(330082);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "setMapBoundary");
    if ((paramj.sdU != null) && (paramj.sdV != null))
    {
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng1 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng1.longitude = paramj.sdU.longitude;
      localLatLng1.latitude = paramj.sdU.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng2.longitude = paramj.sdV.longitude;
      localLatLng2.latitude = paramj.sdV.latitude;
      paramj = new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng2, localLatLng1);
      this.sbN.getMap().setMapBoundary(paramj);
      AppMethodBeat.o(330082);
      return true;
    }
    AppMethodBeat.o(330082);
    return false;
  }
  
  public final boolean a(String paramString1, int paramInt1, double paramDouble, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(330070);
    if (this.scR.containsKey(String.valueOf(paramString1)))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "VisualLayer not exist, remove visualLayer id:%s first, and than add again", new Object[] { paramString1 });
      aaN(paramString1);
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "addMapVisualLayer id:%s", new Object[] { paramString1 });
    Object localObject = new VisualLayerOptions(paramString1).newBuilder();
    ((VisualLayerOptionsBuilder)localObject).setTimeInterval(paramInt1);
    ((VisualLayerOptionsBuilder)localObject).setZIndex(paramInt2);
    ((VisualLayerOptionsBuilder)localObject).setAlpha((float)paramDouble);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramInt1 = aaM(paramString2);
      if (paramInt1 >= 0) {
        ((VisualLayerOptionsBuilder)localObject).setLevel(paramInt1);
      }
    }
    for (;;)
    {
      paramString2 = this.sbN.getMap().addVisualLayer(((VisualLayerOptionsBuilder)localObject).build());
      if (paramString2 != null) {
        break;
      }
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addMapVisualLayer fail id:%s", new Object[] { paramString1 });
      AppMethodBeat.o(330070);
      return false;
      ((VisualLayerOptionsBuilder)localObject).setLevel(OverlayLevel.OverlayLevelAboveBuildings);
      continue;
      ((VisualLayerOptionsBuilder)localObject).setLevel(OverlayLevel.OverlayLevelAboveBuildings);
    }
    localObject = new a.f(this, paramString1);
    paramString2.addLayerStatusChangedListener((VisualLayer.OnLayerStatusChangedListener)localObject);
    this.scR.put(paramString1, paramString2);
    this.scT.put(paramString1, localObject);
    AppMethodBeat.o(330070);
    return true;
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, final int paramInt1, final int paramInt2, b.q paramq)
  {
    AppMethodBeat.i(330021);
    boolean bool;
    if (this.sbN.getMap() == null)
    {
      bool = false;
      if (bool)
      {
        this.scG = paramq;
        this.scO = paramBoolean2;
        this.scP = paramBoolean1;
        Log.i("MicroMsg.Map.DefaultTencentMapView", "initMapMarkerCluster zoomOnClick:%b, enableDefaultStyle:%b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      }
      AppMethodBeat.o(330021);
      return bool;
    }
    this.scc = true;
    Runnable local38 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329442);
        if (a.b(a.this) == null) {
          a.a(a.this, new a.d(a.this, a.u(a.this), a.this.sbN.getMap()));
        }
        if (a.A(a.this) == null)
        {
          a.a(a.this, new a.e(a.this, a.u(a.this), a.this.sbN.getMap(), a.b(a.this)));
          a.A(a.this).setMinClusterSize(paramInt1);
          NonHierarchicalDistanceBasedAlgorithm localNonHierarchicalDistanceBasedAlgorithm = new NonHierarchicalDistanceBasedAlgorithm(a.u(a.this));
          localNonHierarchicalDistanceBasedAlgorithm.setMaxDistanceAtZoom(paramInt2);
          a.b(a.this).setAlgorithm(localNonHierarchicalDistanceBasedAlgorithm);
        }
        for (;;)
        {
          a.b(a.this).setOnClusterClickListener(new ClusterManager.OnClusterClickListener()
          {
            public final boolean onClusterClick(Cluster<a.g> paramAnonymous2Cluster)
            {
              AppMethodBeat.i(329446);
              boolean bool = a.this.b(paramAnonymous2Cluster);
              AppMethodBeat.o(329446);
              return bool;
            }
          });
          a.b(a.this).setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener() {});
          Log.i("MicroMsg.Map.DefaultTencentMapView", "init map marker cluster finish");
          a.b(a.this).setRenderer(a.A(a.this));
          a.b(a.this).setClusterEnabled(true);
          a.this.sbN.getMap().setOnMapCameraChangeListener(a.b(a.this));
          a.B(a.this);
          AppMethodBeat.o(329442);
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
  
  public final void aaE(String paramString)
  {
    AppMethodBeat.i(182814);
    if (!this.scd)
    {
      if (!this.scp.contains(paramString)) {
        this.scp.add(paramString);
      }
      Log.e("MicroMsg.Map.DefaultTencentMapView", "addCustomLayer, wait map loaded callback");
      AppMethodBeat.o(182814);
      return;
    }
    CustomLayer localCustomLayer1 = this.sbN.getMap().addCustomLayer(new CustomLayerOptions().layerId(paramString));
    if (localCustomLayer1 != null)
    {
      Log.v("MicroMsg.Map.DefaultTencentMapView", "addCustomLayer success, layerId:%s", new Object[] { paramString });
      CustomLayer localCustomLayer2 = (CustomLayer)this.sco.remove(paramString);
      if (localCustomLayer2 != null) {
        localCustomLayer2.remove();
      }
      this.sco.put(paramString, localCustomLayer1);
      AppMethodBeat.o(182814);
      return;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "addCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182814);
  }
  
  public final void aaF(String paramString)
  {
    AppMethodBeat.i(182815);
    CustomLayer localCustomLayer = (CustomLayer)this.sco.remove(paramString);
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
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(146530);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeLine lineId:%s", new Object[] { this, paramString });
    Polyline localPolyline = (Polyline)this.scv.get(paramString);
    if (localPolyline == null)
    {
      Log.w("MicroMsg.Map.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146530);
      return false;
    }
    localPolyline.remove();
    this.scv.remove(paramString);
    AppMethodBeat.o(146530);
    return true;
  }
  
  public final a.h aaH(String paramString)
  {
    AppMethodBeat.i(146533);
    paramString = (a.h)this.scx.get(paramString);
    AppMethodBeat.o(146533);
    return paramString;
  }
  
  public final boolean aaI(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(146535);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    if (this.scI.contains(paramString)) {
      aaL(paramString);
    }
    a.h localh = (a.h)this.scx.get(paramString);
    if (localh != null)
    {
      if (localh.sdB != null) {
        localh.sdB.remove();
      }
      if (localh.sdI != null)
      {
        if ((localh.sdI.getMarkerView() != null) && ((localh.sdI.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.g.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.g.d)localh.sdI.getMarkerView());
        }
        localh.sdI.remove();
      }
    }
    label334:
    for (;;)
    {
      synchronized (this.mLock)
      {
        localh.sdJ = null;
        this.scx.remove(paramString);
        bool1 = true;
        ??? = (a.h)this.scx.remove(paramString + "#label");
        if (??? == null) {
          break label334;
        }
        if (((a.h)???).sdI != null) {
          ((a.h)???).sdI.remove();
        }
        if (((a.h)???).sdB != null) {
          ((a.h)???).sdB.remove();
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
  
  public final boolean aaJ(String paramString)
  {
    AppMethodBeat.i(329904);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeLabelMarker markerId:%s", new Object[] { this, paramString });
    a.h localh = (a.h)this.scx.remove(paramString + "#label");
    if (localh == null)
    {
      Log.w("MicroMsg.Map.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(329904);
      return false;
    }
    if (localh.sdI != null)
    {
      if ((localh.sdI.getMarkerView() != null) && ((localh.sdI.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.g.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.g.d)localh.sdI.getMarkerView());
      }
      localh.sdI.remove();
    }
    AppMethodBeat.o(329904);
    return true;
  }
  
  public final boolean aaN(String paramString)
  {
    AppMethodBeat.i(330076);
    if (!this.scR.containsKey(String.valueOf(paramString)))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "removeMapVisualLayer fail, VisualLayer not exist");
      AppMethodBeat.o(330076);
      return false;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "removeMapVisualLayer layerId:%s", new Object[] { paramString });
    VisualLayer localVisualLayer = (VisualLayer)this.scR.remove(String.valueOf(paramString));
    if (localVisualLayer != null)
    {
      paramString = (VisualLayer.OnLayerStatusChangedListener)this.scT.remove(paramString);
      if (paramString != null) {
        localVisualLayer.removeLayerStatusChangedListener(paramString);
      }
      localVisualLayer.remove();
      AppMethodBeat.o(330076);
      return true;
    }
    AppMethodBeat.o(330076);
    return false;
  }
  
  public final void aq(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146546);
    if ((!this.scA) || (this.mUq))
    {
      AppMethodBeat.o(146546);
      return;
    }
    if (this.scB != null) {
      this.scB.aq(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(146546);
  }
  
  public final void b(final String paramString, b.v paramv, com.tencent.mm.plugin.appbrand.f.a parama)
  {
    AppMethodBeat.i(329922);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s _addMarker markerId:%s", new Object[] { this, paramString });
    if (this.scF.get())
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "map:%s _addMarker markerId:%s fail", new Object[] { this, paramString });
      AppMethodBeat.o(329922);
      return;
    }
    Object localObject1;
    a.h localh;
    if (paramv.sdH > 0)
    {
      localObject1 = paramv.sdH;
      if (this.scP)
      {
        Log.i("MicroMsg.Map.DefaultTencentMapView", "cluster item use default style");
        AppMethodBeat.o(329922);
        return;
      }
      if ((paramv.sdH > 0) && (this.scJ.contains(Integer.valueOf(paramv.sdH))))
      {
        c((String)localObject1, paramv, parama);
        localh = (a.h)this.scx.get(localObject1);
        if (localh != null) {
          break label877;
        }
        localh = new a.h();
      }
    }
    label435:
    label846:
    label858:
    label867:
    label877:
    for (;;)
    {
      localh.data = paramv.data;
      localh.sec = paramv;
      a((String)localObject1, localh);
      MarkerOptions localMarkerOptions;
      if ((!paramv.sed) && (!TextUtils.isEmpty(paramString)))
      {
        localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new com.tencent.mapsdk.raster.model.LatLng(paramv.latitude, paramv.longitude));
        if (!Util.isNullOrNil(paramv.title)) {
          localMarkerOptions.title(paramv.title);
        }
        if (!Util.isNullOrNil(paramv.seg)) {
          localMarkerOptions.contentDescription(paramv.seg);
        }
        localMarkerOptions.rotation(paramv.aBi);
        localMarkerOptions.alpha(paramv.alpha);
        final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(com.tencent.luggage.i.a.c.default_tencent_map_marker_icon, null);
        final ImageView localImageView = (ImageView)localFrameLayout.findViewById(com.tencent.luggage.i.a.b.marker_icon);
        final float f1 = paramv.see;
        final float f2 = paramv.sef;
        Object localObject3 = null;
        Object localObject2 = localObject3;
        if (parama != null)
        {
          localObject2 = localObject3;
          if (!Util.isNullOrNil(paramv.sdM))
          {
            if (localImageView != null) {
              localImageView.setImageBitmap(null);
            }
            localObject2 = parama.a(paramv.sdM, null, new com.tencent.mm.plugin.appbrand.f.a.b()
            {
              public final void W(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(329460);
                if (paramAnonymousBitmap != null)
                {
                  a.b(f1, f2, paramAnonymousBitmap, localImageView);
                  if ((a.this.aaH(paramString) != null) && (a.this.aaH(paramString).sdB != null))
                  {
                    paramAnonymousBitmap = a.this.aaH(paramString).sdB;
                    if (paramAnonymousBitmap != null) {
                      paramAnonymousBitmap.setMarkerView(localFrameLayout);
                    }
                    Log.v("MicroMsg.Map.DefaultTencentMapView", "setMarkerView");
                  }
                }
                AppMethodBeat.o(329460);
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
        if (paramv.sei != null) {
          localMarkerOptions.infoWindowOffset(paramv.sei.sep, paramv.sei.ser);
        }
        if ((TextUtils.isEmpty(paramv.seh)) || (!paramv.seh.equals("withLabel"))) {
          break label858;
        }
        localMarkerOptions.setCollisions(new MarkerCollisionItem[] { MarkerCollisionItem.POI });
        label627:
        paramString = this.sbN.getMap().addMarker(localMarkerOptions);
        localh.sdB = paramString;
        if ((TextUtils.isEmpty(paramv.seh)) || (!paramv.seh.equals("withLabel"))) {
          break label867;
        }
        paramString.setCollisions(new Collision[] { MarkerCollisionItem.POI });
      }
      for (;;)
      {
        paramString.getZIndex();
        if ((paramv.sei != null) && (paramv.sei.seo == b.v.a.set)) {
          b(localh.sdB);
        }
        if (((!paramv.sed) || (paramv.sdH != -1)) && (paramv.sej != null)) {
          a((String)localObject1, paramv, localh);
        }
        AppMethodBeat.o(329922);
        return;
        Log.e("MicroMsg.Map.DefaultTencentMapView", "cluster marker not exist, don't add, must remove exist label");
        aaJ((String)localObject1);
        AppMethodBeat.o(329922);
        return;
        if (paramv.sed)
        {
          localObject1 = new b.aa();
          ((b.aa)localObject1).seu = new b.i(paramv.latitude, paramv.longitude);
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
    AppMethodBeat.i(330039);
    if (!this.scQ.containsKey(String.valueOf(paramInt)))
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay not exist");
      AppMethodBeat.o(330039);
      return false;
    }
    final GroundOverlay localGroundOverlay = (GroundOverlay)this.scQ.get(String.valueOf(paramInt));
    if (localGroundOverlay == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay is null");
      AppMethodBeat.o(330039);
      return false;
    }
    Log.i("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay id:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    if ((parame.sdO != null) && (parame.sdP != null))
    {
      localObject = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      ((com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject).longitude = parame.sdO.longitude;
      ((com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject).latitude = parame.sdO.latitude;
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
      localLatLng.longitude = parame.sdP.longitude;
      localLatLng.latitude = parame.sdP.latitude;
      localGroundOverlay.setLatLongBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(localLatLng, (com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject));
    }
    localGroundOverlay.setAlpha(parame.alpha);
    localGroundOverlay.setVisibility(parame.visible);
    localGroundOverlay.setZindex(parame.zIndex);
    if ((parama != null) && (!TextUtils.isEmpty(parame.sdM)))
    {
      localObject = parame.sdM;
      parama.a(parame.sdM, new com.tencent.mm.plugin.appbrand.f.a.c()
      {
        public final void N(InputStream paramAnonymousInputStream)
        {
          AppMethodBeat.i(329465);
          if (paramAnonymousInputStream == null)
          {
            Log.e("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay, openRead failed, url=%s", new Object[] { this.owD });
            AppMethodBeat.o(329465);
            return;
          }
          Bitmap localBitmap = a.d(paramAnonymousInputStream, this.owD);
          org.apache.commons.b.d.ai(paramAnonymousInputStream);
          if ((localBitmap != null) && (!localBitmap.isRecycled()))
          {
            localGroundOverlay.setBitmap(com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory.fromBitmap(localBitmap));
            localBitmap.recycle();
            Log.i("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay success id:%d", new Object[] { Integer.valueOf(paramInt) });
            AppMethodBeat.o(329465);
            return;
          }
          Log.e("MicroMsg.Map.DefaultTencentMapView", "updateGroundOverlay decode bitmap fail");
          AppMethodBeat.o(329465);
        }
      });
    }
    while (parama == null)
    {
      AppMethodBeat.o(330039);
      return true;
    }
    Log.e("MicroMsg.Map.DefaultTencentMapView", "groundOverlay icon path is null");
    AppMethodBeat.o(330039);
    return false;
  }
  
  public final boolean b(Cluster<g> paramCluster)
  {
    AppMethodBeat.i(330005);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "onClusterClick");
    if (this.scO)
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramCluster.getItems().iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((g)localIterator.next()).getPosition());
      }
      r(localLinkedList, 0);
    }
    if (this.scG != null) {
      this.scG.ao(a(paramCluster, false));
    }
    AppMethodBeat.o(330005);
    return true;
  }
  
  public final b.ac csJ()
  {
    AppMethodBeat.i(146498);
    Object localObject2 = this.sbN.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.j();
    ((b.j)localObject1).sdU = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.j)localObject1).sdV = new b.i(((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLatitude(), ((com.tencent.mapsdk.raster.model.LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.ad();
    ((b.ad)localObject2).sey = ((b.j)localObject1);
    localObject1 = new b.ac();
    ((b.ac)localObject1).sew = ((b.ad)localObject2);
    AppMethodBeat.o(146498);
    return localObject1;
  }
  
  public final void csK()
  {
    AppMethodBeat.i(146501);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.scl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146461);
        if ((a.d(a.this) != null) && (a.r(a.this)))
        {
          double d1 = a.d(a.this).getLatitude();
          double d2 = a.d(a.this).getLongitude();
          a.this.sbN.getIController().animateTo(d1, d2);
          Log.d("MicroMsg.Map.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        }
        AppMethodBeat.o(146461);
      }
    };
    if ((this.scB != null) && (this.scA))
    {
      this.scl.run();
      this.scl = null;
    }
    AppMethodBeat.o(146501);
  }
  
  public final b.f csL()
  {
    AppMethodBeat.i(146515);
    if (this.scn != null)
    {
      localf = this.scn;
      AppMethodBeat.o(146515);
      return localf;
    }
    b.f localf = csH();
    AppMethodBeat.o(146515);
    return localf;
  }
  
  public boolean csM()
  {
    return false;
  }
  
  public final b.i csN()
  {
    AppMethodBeat.i(146519);
    Object localObject = this.sbN.getMap().getMapCenter();
    localObject = new b.i(((com.tencent.mapsdk.raster.model.LatLng)localObject).getLatitude(), ((com.tencent.mapsdk.raster.model.LatLng)localObject).getLongitude());
    AppMethodBeat.o(146519);
    return localObject;
  }
  
  public final void csO()
  {
    AppMethodBeat.i(146525);
    synchronized (this.sct)
    {
      Iterator localIterator = this.sct.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.sct.clear();
    AppMethodBeat.o(146525);
  }
  
  public final void csP()
  {
    AppMethodBeat.i(146527);
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329455);
        ViewGroup localViewGroup = (ViewGroup)a.this.container;
        synchronized (a.this.scu)
        {
          Iterator localIterator = a.this.scu.iterator();
          if (localIterator.hasNext()) {
            localViewGroup.removeView(((a.b)localIterator.next()).sdA);
          }
        }
        a.this.scu.clear();
        AppMethodBeat.o(329455);
      }
    });
    AppMethodBeat.o(146527);
  }
  
  public final void csQ()
  {
    AppMethodBeat.i(146529);
    Iterator localIterator = this.scv.values().iterator();
    while (localIterator.hasNext()) {
      ((Polyline)localIterator.next()).remove();
    }
    this.scv.clear();
    AppMethodBeat.o(146529);
  }
  
  public final void csR()
  {
    AppMethodBeat.i(146534);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.scx.values().iterator();
    while (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      if (localh.sdB != null) {
        localh.sdB.remove();
      }
      if (localh.sdI != null)
      {
        if ((localh.sdI.getMarkerView() != null) && ((localh.sdI.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.g.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.g.d)localh.sdI.getMarkerView());
        }
        localh.sdI.remove();
      }
    }
    this.scx.clear();
    csX();
    AppMethodBeat.o(146534);
  }
  
  public final void csS()
  {
    AppMethodBeat.i(146540);
    synchronized (this.scy)
    {
      Iterator localIterator = this.scy.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).sdB.remove();
      }
    }
    this.scy.clear();
    AppMethodBeat.o(146540);
  }
  
  public final void csT()
  {
    AppMethodBeat.i(146542);
    synchronized (this.scz)
    {
      Iterator localIterator = this.scz.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.scz.clear();
    AppMethodBeat.o(146542);
  }
  
  public final boolean csV()
  {
    return (this.sca != null) && (this.scb != null);
  }
  
  public final boolean csW()
  {
    return this.scc;
  }
  
  public final void ec(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146514);
    this.sbN.getMap().setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(146514);
  }
  
  public final b.i f(Point paramPoint)
  {
    AppMethodBeat.i(330057);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "fromScreenLocation");
    paramPoint = this.sbN.getMap().getProjection().fromScreenLocation(paramPoint);
    paramPoint = new b.i(paramPoint.getLatitude(), paramPoint.getLongitude());
    AppMethodBeat.o(330057);
    return paramPoint;
  }
  
  public final void g(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(146516);
    com.tencent.mapsdk.raster.model.LatLng localLatLng = this.sbN.getMap().getMapCenter();
    this.sbN.setMapAnchor(paramFloat1, paramFloat2);
    a(localLatLng.getLatitude(), localLatLng.getLongitude(), -1.0F, -1.0F, -1.0F, paramBoolean);
    AppMethodBeat.o(146516);
  }
  
  public final float getRotate()
  {
    AppMethodBeat.i(146503);
    float f = this.sbN.getMap().getCameraPosition().getBearing();
    AppMethodBeat.o(146503);
    return f;
  }
  
  public final float getSkew()
  {
    AppMethodBeat.i(146504);
    float f = this.sbN.getMap().getCameraPosition().getSkew();
    AppMethodBeat.o(146504);
    return f;
  }
  
  public final View getView()
  {
    return this.container;
  }
  
  public final float getZoom()
  {
    AppMethodBeat.i(329719);
    float f = this.sbN.getMap().getCameraPosition().getZoom();
    AppMethodBeat.o(329719);
    return f;
  }
  
  public final void i(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146500);
    a(paramDouble1, paramDouble2, -1.0F, -1.0F, -1.0F, true);
    AppMethodBeat.o(146500);
  }
  
  public final void jA(boolean paramBoolean)
  {
    AppMethodBeat.i(329811);
    this.sbN.getMap().showBuilding(paramBoolean);
    AppMethodBeat.o(329811);
  }
  
  public final void jB(boolean paramBoolean)
  {
    AppMethodBeat.i(146544);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.scA = paramBoolean;
    d locald;
    if (paramBoolean)
    {
      if (this.scB != null)
      {
        locald = this.scB;
        if (locald.sdB != null)
        {
          Log.i("MicroMsg.AppbrandMapLocationPoint", "resumeMapView");
          locald.sdB.setVisible(true);
        }
      }
      ((com.tencent.mm.plugin.appbrand.utils.b.a)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.scC, csU());
      g.a(this);
      AppMethodBeat.o(146544);
      return;
    }
    if (this.scB != null)
    {
      locald = this.scB;
      if (locald.sdB != null)
      {
        Log.i("MicroMsg.AppbrandMapLocationPoint", "pauseMapView");
        locald.sdB.setVisible(false);
      }
    }
    ((com.tencent.mm.plugin.appbrand.utils.b.a)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.scC, csU());
    g.b(this);
    AppMethodBeat.o(146544);
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(146505);
    this.sbN.getUiSettings().setZoomGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146505);
  }
  
  public final void jr(boolean paramBoolean)
  {
    AppMethodBeat.i(146506);
    this.sbN.getUiSettings().setScrollGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146506);
  }
  
  public final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(146507);
    this.sbN.getUiSettings().setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146507);
  }
  
  public final void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(146508);
    this.sbN.getUiSettings().setCompassEnabled(paramBoolean);
    AppMethodBeat.o(146508);
  }
  
  public final void ju(boolean paramBoolean)
  {
    AppMethodBeat.i(146510);
    this.sbN.getUiSettings().setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146510);
  }
  
  public final void jv(boolean paramBoolean)
  {
    AppMethodBeat.i(146511);
    this.sbN.getMap().setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(146511);
  }
  
  public final void jw(boolean paramBoolean)
  {
    AppMethodBeat.i(146512);
    this.sbN.getMap().setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(146512);
  }
  
  public final void jx(boolean paramBoolean)
  {
    AppMethodBeat.i(146513);
    this.sbN.getMap().setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(146513);
  }
  
  public final void jy(boolean paramBoolean)
  {
    AppMethodBeat.i(146517);
    this.sbN.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
    AppMethodBeat.o(146517);
  }
  
  public final void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(146518);
    this.sbN.getUiSettings().setScaleControlsEnabled(paramBoolean);
    AppMethodBeat.o(146518);
  }
  
  public void m(Surface paramSurface) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(146497);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.scF.set(true);
    this.sbN.getMap().setOnMapCameraChangeListener(null);
    csR();
    csQ();
    csQ();
    csP();
    csS();
    csT();
    Object localObject = this.sco.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CustomLayer)((Iterator)localObject).next()).remove();
    }
    this.sco.clear();
    if (this.sbN != null)
    {
      this.sbN.getMap().setOnMapPoiClickListener(null);
      this.sbN.clean();
      this.sbN.onDestroy();
    }
    if (this.scB != null)
    {
      localObject = this.scB;
      if (((d)localObject).sdB != null)
      {
        ((d)localObject).sdB.remove();
        ((d)localObject).sdB = null;
      }
      this.scB = null;
    }
    AppMethodBeat.o(146497);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(146494);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.hIz.setVisibility(0);
      if (this.sce == null) {
        this.sce = getSurfaceView();
      }
      if (this.sce != null)
      {
        MMHandlerThread.postToMainThreadDelayed(this.scf, 100L);
        this.sbN.setVisibility(4);
        this.sbN.getMap().getScreenShot(new TencentMap.OnScreenShotListener()
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
      this.mUq = true;
      if (this.scA)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.scC, csU());
        g.b(this);
      }
      AppMethodBeat.o(146494);
      return;
      Log.e("MicroMsg.Map.DefaultTencentMapView", "hideTencentMap err");
      break;
      this.sbN.onPause();
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(146493);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.hIz.setVisibility(4);
      this.sbN.setVisibility(0);
      this.sbN.onResume();
      csI();
    }
    for (;;)
    {
      this.mUq = false;
      if (this.scA)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.scC, csU());
        g.a(this);
      }
      AppMethodBeat.o(146493);
      return;
      this.sbN.onResume();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2) {}
  
  public final void q(List<b.i> paramList, int paramInt)
  {
    AppMethodBeat.i(146520);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.i locali = (b.i)paramList.next();
      localLinkedList.add(new com.tencent.mapsdk.raster.model.LatLng(locali.latitude, locali.longitude));
    }
    r(localLinkedList, paramInt);
    AppMethodBeat.o(146520);
  }
  
  public final void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(329813);
    this.sbN.getMap().setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(329813);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(329753);
    this.sbN.getMap().setIndoorMaskColor(paramInt);
    AppMethodBeat.o(329753);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(182813);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map:%s setMapStyle: %d", new Object[] { this, Integer.valueOf(paramInt) });
    this.sbN.getMap().setMapStyle(paramInt);
    AppMethodBeat.o(182813);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(329824);
    this.sbN.getMap().setMaxZoomLevel(paramInt);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map_scale setMaxZoomLevel:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(329824);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(329826);
    this.sbN.getMap().setMinZoomLevel(paramInt);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "map_scale setMinZoomLevel:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(329826);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(329808);
    this.sbN.getMap().setPoisEnabled(paramBoolean);
    AppMethodBeat.o(329808);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146547);
    String str = "DefaultTencentMapView{mapId=" + this.sbM + '}';
    AppMethodBeat.o(146547);
    return str;
  }
  
  public final class b
  {
    ImageView sdA;
    
    public b(ImageView paramImageView)
    {
      this.sdA = paramImageView;
    }
  }
  
  public final class c
  {
    Marker sdB;
    
    public c(Marker paramMarker)
    {
      this.sdB = paramMarker;
    }
  }
  
  final class d
    extends ClusterManager<a.g>
  {
    public d(Context paramContext, TencentMap paramTencentMap)
    {
      super(paramTencentMap);
    }
    
    public final void onCameraChange(CameraPosition paramCameraPosition)
    {
      AppMethodBeat.i(329420);
      super.onCameraChange(paramCameraPosition);
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.sdK = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.aBi = paramCameraPosition.getBearing();
        locala.skew = paramCameraPosition.getSkew();
        a.p(a.this).a(locala, a.q(a.this));
      }
      AppMethodBeat.o(329420);
    }
    
    public final void onCameraChangeFinish(CameraPosition paramCameraPosition)
    {
      AppMethodBeat.i(329425);
      super.onCameraChangeFinish(paramCameraPosition);
      Log.i("MicroMsg.Map.DefaultTencentMapView", "onCameraChangeFinish");
      if (a.p(a.this) != null)
      {
        b.a locala = new b.a();
        locala.sdK = new b.i(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
        locala.zoom = paramCameraPosition.getZoom();
        locala.aBi = paramCameraPosition.getBearing();
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
      AppMethodBeat.o(329425);
    }
  }
  
  final class e
    extends DefaultClusterRenderer<a.g>
  {
    public e(TencentMap paramTencentMap, ClusterManager<a.g> paramClusterManager)
    {
      super(paramClusterManager, localClusterManager);
    }
    
    public final void onBeforeClusterRendered(Cluster<a.g> paramCluster, MarkerOptions paramMarkerOptions)
    {
      AppMethodBeat.i(329431);
      super.onBeforeClusterRendered(paramCluster, paramMarkerOptions);
      Log.i("MicroMsg.Map.DefaultTencentMapView", "onBeforeClusterRendered, cluster size:%d", new Object[] { Integer.valueOf(paramCluster.getItems().size()) });
      Object localObject = paramCluster.getItems().iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.g localg = (a.g)((Iterator)localObject).next();
        if (localg.sdH > 0) {
          a.this.aaJ(localg.sdH);
        }
        a.this.aaJ(a.g.a(localg));
      }
      if (!a.this.scP) {
        paramMarkerOptions.alpha(0.0F);
      }
      if (a.F(a.this) != null)
      {
        paramMarkerOptions = paramCluster.getItems().iterator();
        if (paramMarkerOptions.hasNext())
        {
          localObject = (a.g)paramMarkerOptions.next();
          if ((a.h)a.g(a.this).get(a.g.a((a.g)localObject)) != null) {}
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label263;
          }
          a.F(a.this).s(a.a(a.this, paramCluster));
          AppMethodBeat.o(329431);
          return;
          if (((a.g)localObject).sdH <= 0) {
            break;
          }
        }
        label263:
        Log.e("MicroMsg.Map.DefaultTencentMapView", "don't send ClusterCreateEvent");
      }
      AppMethodBeat.o(329431);
    }
  }
  
  static final class g
    implements ClusterItem
  {
    private String id;
    private com.tencent.mapsdk.raster.model.LatLng sdG;
    int sdH;
    
    g(String paramString, com.tencent.mapsdk.raster.model.LatLng paramLatLng)
    {
      this.id = paramString;
      this.sdG = paramLatLng;
    }
    
    public final com.tencent.mapsdk.raster.model.LatLng getPosition()
    {
      return this.sdG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a
 * JD-Core Version:    0.7.0.1
 */