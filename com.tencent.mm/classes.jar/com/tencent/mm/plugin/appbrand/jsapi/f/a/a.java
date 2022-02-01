package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
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
import com.tencent.mm.plugin.appbrand.widget.d.c;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
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
  private static long kuJ;
  private static final String kur;
  FrameLayout container;
  Context context;
  private ImageView dhf;
  private Runnable kuA;
  private b.l kuB;
  private b.w kuC;
  private b.x kuD;
  private boolean kuE;
  private Runnable kuF;
  private b.v kuG;
  private b.e kuH;
  private Map<String, CustomLayer> kuI;
  private Queue<Runnable> kuK;
  private CancelableCallback kuL;
  public ArrayList<Circle> kuM;
  public ArrayList<b> kuN;
  private Map<String, Polyline> kuO;
  private a kuP;
  private Map<String, d> kuQ;
  public ArrayList<c> kuR;
  public ArrayList<Polygon> kuS;
  private boolean kuT;
  private d kuU;
  private com.tencent.mm.plugin.appbrand.utils.b.a.b kuV;
  private final int kuW;
  private AtomicBoolean kuX;
  private AtomicBoolean kuY;
  private String kuk;
  public final SoSoMapView kul;
  private boolean kum;
  private b.k kun;
  private b.o kuo;
  private b.n kup;
  private b.q kuq;
  private String kus;
  private String kut;
  private int kuu;
  private boolean kuv;
  private boolean kuw;
  private volatile HashMap<String, MarkerTranslateAnimator> kux;
  private volatile HashMap<String, MarkerTranslateAnimator> kuy;
  SurfaceView kuz;
  private long lastCheckTime;
  private int mMapType;
  
  static
  {
    AppMethodBeat.i(146554);
    kur = com.tencent.mm.plugin.appbrand.z.b.ei("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    kuJ = 500L;
    AppMethodBeat.o(146554);
  }
  
  public a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146490);
    this.kux = new HashMap();
    this.kuy = new HashMap();
    this.kuA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146485);
        a.this.kuz.setVisibility(4);
        AppMethodBeat.o(146485);
      }
    };
    this.kuE = false;
    this.kuI = new ConcurrentHashMap();
    this.kuK = new LinkedList();
    this.kuL = new CancelableCallback()
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
    this.kuM = new ArrayList();
    this.kuN = new ArrayList();
    this.kuO = new ConcurrentHashMap();
    this.kuP = new a();
    this.kuQ = new ConcurrentHashMap();
    this.kuR = new ArrayList();
    this.kuS = new ArrayList();
    this.kuV = new com.tencent.mm.plugin.appbrand.utils.b.a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, final com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(205791);
        if (paramAnonymousInt != 0)
        {
          ac.e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(205791);
          return;
        }
        ac.d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude) });
        if (!a.bhx())
        {
          ac.w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
          AppMethodBeat.o(205791);
          return;
        }
        if ((!a.n(a.this)) || (a.t(a.this)))
        {
          AppMethodBeat.o(205791);
          return;
        }
        l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205790);
            d locald;
            double d1;
            double d2;
            if (a.this.kul != null)
            {
              if (a.c(a.this) == null)
              {
                a.a(a.this, new d(a.q(a.this)));
                locald = a.c(a.this);
                localObject = a.this.kul;
                com.tencent.mm.plugin.appbrand.utils.b.a.a locala = paramAnonymousa;
                MarkerOptions localMarkerOptions = new MarkerOptions();
                localMarkerOptions.anchor(0.5F, 0.5F);
                localMarkerOptions.position(new LatLng(locala.latitude, locala.longitude));
                localMarkerOptions.markerView(locald);
                localMarkerOptions.zIndex(2147483647);
                localMarkerOptions.flat(true);
                localMarkerOptions.tag("AnchorPoint");
                locald.kvx = ((SoSoMapView)localObject).getMap().addMarker(localMarkerOptions);
              }
              locald = a.c(a.this);
              d1 = paramAnonymousa.latitude;
              d2 = paramAnonymousa.longitude;
              Object localObject = paramAnonymousa.provider;
              double d3 = paramAnonymousa.cUo;
              if ((locald.kwl != -1.0D) || (locald.kwm != -1.0D)) {
                break label398;
              }
              locald.kwl = d1;
              locald.kwj = d1;
              locald.kwm = d2;
              locald.kwk = d2;
              if ((locald.kwl != -1.0D) && (locald.kwm != -1.0D)) {
                locald.kwq = f.a(locald.kwm, locald.kwl, d2, d1, (String)localObject, d3);
              }
              if ((locald.kwo != 900.0F) && (locald.kwn != 900.0F)) {
                break label433;
              }
              float f = (float)f.h(d1, d2);
              locald.kwn = f;
              locald.kwo = f;
            }
            for (;;)
            {
              if (locald.kvx != null) {
                locald.kvx.setPosition(new LatLng(d1, d2));
              }
              AppMethodBeat.o(205790);
              return;
              label398:
              locald.kwl = locald.kwj;
              locald.kwm = locald.kwk;
              locald.kwk = d2;
              locald.kwj = d1;
              break;
              label433:
              locald.kwo = locald.kwn;
              locald.kwn = ((float)f.h(d1, d2));
            }
          }
        });
        AppMethodBeat.o(205791);
      }
    };
    this.lastCheckTime = 0L;
    this.kuW = 500;
    this.kuX = new AtomicBoolean(false);
    this.kuY = new AtomicBoolean(false);
    this.context = paramContext;
    this.kuk = paramString;
    this.container = new FrameLayout(paramContext);
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.container.setBackgroundColor(0);
    this.container.setLayoutParams(paramString);
    this.kul = new SoSoMapView(paramContext, F(paramMap));
    this.container.addView(this.kul, new FrameLayout.LayoutParams(-1, -1));
    this.dhf = new ImageView(paramContext);
    this.dhf.setScaleType(ImageView.ScaleType.FIT_XY);
    this.container.addView(this.dhf, new ViewGroup.LayoutParams(-1, -1));
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s, init", new Object[] { this });
    this.kul.getMap().setInfoWindowAdapter(this.kuP);
    this.kul.getMap().setMapAnchor(0.5F, 0.5F);
    this.kul.getMap().enableMultipleInfowindow(true);
    this.kul.getMap().setMapStyle(this.kuu);
    paramContext = this.kul.getMap();
    if (this.kuw) {}
    for (int i = 1008;; i = 1000)
    {
      paramContext.setMapType(i);
      this.kul.getMap().setHandDrawMapEnable(this.kuv);
      this.kul.getMap().setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener()
      {
        public final void onInfoWindowClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146458);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146458);
            return;
          }
          paramAnonymousMarker = a.this.Mp((String)paramAnonymousMarker.getTag());
          if (paramAnonymousMarker == null)
          {
            ac.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          if (a.a(a.this) == null)
          {
            ac.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146458);
            return;
          }
          a.a(a.this).a(paramAnonymousMarker);
          AppMethodBeat.o(146458);
        }
      });
      this.kul.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(146468);
          if (paramAnonymousMarker == null)
          {
            AppMethodBeat.o(146468);
            return false;
          }
          ac.i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", new Object[] { this, paramAnonymousMarker.getTag() });
          if (bs.isNullOrNil((String)paramAnonymousMarker.getTag()))
          {
            ac.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
            AppMethodBeat.o(146468);
            return true;
          }
          if (((String)paramAnonymousMarker.getTag()).endsWith("AnchorPoint"))
          {
            if ((a.b(a.this) != null) && (a.c(a.this) != null))
            {
              ac.w("MicroMsg.DefaultTencentMapView", "click anchor point");
              a.b(a.this).d(a.c(a.this).getLatitude(), a.c(a.this).getLongitude());
            }
            AppMethodBeat.o(146468);
            return true;
          }
          a.d locald = a.this.Mp((String)paramAnonymousMarker.getTag());
          if (locald == null)
          {
            ac.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return true;
          }
          if (a.d(a.this) == null)
          {
            ac.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
            AppMethodBeat.o(146468);
            return true;
          }
          Object localObject;
          if (locald.kvQ != null)
          {
            localObject = locald.kvQ.kvU;
            if ((localObject == null) || (((b.t.a)localObject).kwb != b.t.a.kwe)) {
              break label405;
            }
            if (locald.kvx.isInfoWindowShown()) {
              break label393;
            }
            a.a(a.this, locald);
          }
          for (;;)
          {
            if (locald.kvx != null) {
              locald.kvx.set2Top();
            }
            if (locald.kvy != null) {
              locald.kvy.set2Top();
            }
            if (a.c(a.this) != null)
            {
              localObject = a.c(a.this);
              if (((d)localObject).kvx != null) {
                ((d)localObject).kvx.set2Top();
              }
            }
            if (!((String)paramAnonymousMarker.getTag()).endsWith("#label")) {
              break;
            }
            ac.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
            bool = a.e(a.this).c(locald);
            AppMethodBeat.o(146468);
            return bool;
            label393:
            locald.kvx.hideInfoWindow();
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
      this.kul.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener()
      {
        public final void onMapClick(LatLng paramAnonymousLatLng)
        {
          AppMethodBeat.i(146478);
          Iterator localIterator = a.f(a.this).values().iterator();
          while (localIterator.hasNext())
          {
            a.d locald = (a.d)localIterator.next();
            if ((locald.kvQ != null) && (locald.kvQ.kvU != null) && (locald.kvQ.kvU.kwb == b.t.a.kwe) && (locald.kvx.isInfoWindowShown())) {
              locald.kvx.hideInfoWindow();
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
      this.kul.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener()
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
      this.kul.getMap().setOnMapPoiClickListener(new a.29(this));
      this.kul.getMap().setOnIndoorStateChangeListener(new a.30(this));
      ac.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
      this.kul.onCreate(null);
      onResume();
      AppMethodBeat.o(146490);
      return;
    }
  }
  
  private void Y(Runnable paramRunnable)
  {
    AppMethodBeat.i(146524);
    this.kuK.add(paramRunnable);
    if (this.kuK.size() == 1) {
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
    ac.v("MicroMsg.DefaultTencentMapView", "tencentMap.getCameraPosition:%s rotate:%f skew:%f", new Object[] { paramTencentMap.getCameraPosition(), Float.valueOf(paramTencentMap.getCameraPosition().getBearing()), Float.valueOf(paramTencentMap.getCameraPosition().getSkew()) });
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
      ac.e("MicroMsg.DefaultTencentMapView", "markerIcon is null, err");
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
      f = com.tencent.mm.plugin.appbrand.z.g.ve(paramBitmap.getWidth());
      paramFloat1 = com.tencent.mm.plugin.appbrand.z.g.ve(paramBitmap.getHeight());
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
      paramd.kvx.showInfoWindow();
      AppMethodBeat.o(182817);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146473);
        paramd.kvx.showInfoWindow();
        AppMethodBeat.o(146473);
      }
    });
    AppMethodBeat.o(182817);
  }
  
  private void a(String paramString, d paramd)
  {
    AppMethodBeat.i(146538);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.kuQ.put(paramString, paramd);
    AppMethodBeat.o(146538);
  }
  
  private static b.e bhh()
  {
    AppMethodBeat.i(146492);
    b.e locale = new b.e();
    locale.buildingId = "";
    locale.buildingName = "";
    locale.kvE = new LinkedList();
    locale.kvF = -1;
    AppMethodBeat.o(146492);
    return locale;
  }
  
  private void bhi()
  {
    AppMethodBeat.i(146496);
    if (this.kuz == null) {
      this.kuz = getSurfaceView();
    }
    if (this.kuz != null)
    {
      ap.aB(this.kuA);
      this.kuz.setVisibility(0);
      AppMethodBeat.o(146496);
      return;
    }
    ac.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
    AppMethodBeat.o(146496);
  }
  
  private Bundle bhu()
  {
    AppMethodBeat.i(146545);
    Bundle localBundle = new Bundle();
    if (!kur.equals(this.kus))
    {
      String str = bs.nullAsNil(localBundle.getString("smallAppKey"));
      localBundle.putString("smallAppKey", str + this.kus + "#" + this.kut + ";");
    }
    AppMethodBeat.o(146545);
    return localBundle;
  }
  
  private SurfaceView getSurfaceView()
  {
    AppMethodBeat.i(146495);
    if (this.kuz != null)
    {
      localSurfaceView = this.kuz;
      AppMethodBeat.o(146495);
      return localSurfaceView;
    }
    this.kuz = i(this.kul);
    SurfaceView localSurfaceView = this.kuz;
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
  
  protected TencentMapOptions F(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146491);
    TencentMapOptions localTencentMapOptions = new TencentMapOptions();
    if (paramMap == null)
    {
      ac.w("MicroMsg.DefaultTencentMapView", "params is null, return");
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
    }
    String str = f.a(paramMap, "theme", "normal");
    this.kuv = str.equals("handDraw");
    this.mMapType = f.a(paramMap, "mapType", 1);
    localTencentMapOptions.setMapType(this.mMapType);
    this.kus = f.a(paramMap, "subKey", "");
    this.kut = f.a(paramMap, "subId", "");
    boolean bool;
    if (f.a(paramMap, "enableDarkMode", 0) == 1)
    {
      bool = true;
      this.kuw = bool;
      if (!bs.isNullOrNil(this.kus)) {
        break label288;
      }
      this.kus = kur;
      this.kut = "";
    }
    for (;;)
    {
      localTencentMapOptions.setSubInfo(this.kus, this.kut);
      this.kuu = f.a(paramMap, "styleId", 0);
      ac.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.kut, this.kus });
      ac.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d enableDarkmode:%b", new Object[] { str, Boolean.valueOf(this.kuv), Integer.valueOf(this.mMapType), this.kut, this.kus, Integer.valueOf(this.kuu), Boolean.valueOf(this.kuw) });
      AppMethodBeat.o(146491);
      return localTencentMapOptions;
      bool = false;
      break;
      label288:
      this.kuw = false;
    }
  }
  
  public final void G(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146546);
    if ((!this.kuT) || (this.kum))
    {
      AppMethodBeat.o(146546);
      return;
    }
    if (this.kuU != null) {
      this.kuU.G(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(146546);
  }
  
  public final void Mm(String paramString)
  {
    AppMethodBeat.i(182814);
    CustomLayer localCustomLayer1 = this.kul.getMap().addCustomLayer(new CustomLayerOptions().layerId(paramString));
    if (localCustomLayer1 != null)
    {
      ac.v("MicroMsg.DefaultTencentMapView", "addCustomLayer success, layerId:%s", new Object[] { paramString });
      CustomLayer localCustomLayer2 = (CustomLayer)this.kuI.remove(paramString);
      if (localCustomLayer2 != null) {
        localCustomLayer2.remove();
      }
      this.kuI.put(paramString, localCustomLayer1);
      AppMethodBeat.o(182814);
      return;
    }
    ac.e("MicroMsg.DefaultTencentMapView", "addCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182814);
  }
  
  public final void Mn(String paramString)
  {
    AppMethodBeat.i(182815);
    CustomLayer localCustomLayer = (CustomLayer)this.kuI.remove(paramString);
    if (localCustomLayer != null)
    {
      ac.v("MicroMsg.DefaultTencentMapView", "removeCustomLayer success, layerId:%s", new Object[] { paramString });
      localCustomLayer.remove();
      AppMethodBeat.o(182815);
      return;
    }
    ac.e("MicroMsg.DefaultTencentMapView", "removeCustomLayer fail, layerId:%s", new Object[] { paramString });
    AppMethodBeat.o(182815);
  }
  
  public final boolean Mo(String paramString)
  {
    AppMethodBeat.i(146530);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", new Object[] { this, paramString });
    Polyline localPolyline = (Polyline)this.kuO.get(paramString);
    if (localPolyline == null)
    {
      ac.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146530);
      return false;
    }
    localPolyline.remove();
    this.kuO.remove(paramString);
    AppMethodBeat.o(146530);
    return true;
  }
  
  public final d Mp(String paramString)
  {
    AppMethodBeat.i(146533);
    paramString = (d)this.kuQ.get(paramString);
    AppMethodBeat.o(146533);
    return paramString;
  }
  
  public final boolean Mq(String paramString)
  {
    AppMethodBeat.i(146535);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    d locald = (d)this.kuQ.get(paramString);
    if (locald == null)
    {
      ac.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(146535);
      return false;
    }
    locald.kvx.remove();
    if (locald.kvy != null)
    {
      if ((locald.kvy.getMarkerView() != null) && ((locald.kvy.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.d.d)locald.kvy.getMarkerView());
      }
      locald.kvy.remove();
      this.kuQ.remove(paramString + "#label");
    }
    locald.kvz = null;
    this.kuQ.remove(paramString);
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
    ac.v("MicroMsg.DefaultTencentMapView", "start map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    if ((paramFloat1 == -1.0F) && (paramFloat2 == -1.0F) && (paramFloat3 == -1.0F) && (paramDouble1 == -1.0D) && (paramDouble2 == -1.0D))
    {
      AppMethodBeat.o(146522);
      return;
    }
    final TencentMap localTencentMap = this.kul.getMap();
    if (localTencentMap != null)
    {
      if (paramBoolean)
      {
        Y(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146464);
            CameraUpdate localCameraUpdate = a.b(localTencentMap, paramFloat1, paramFloat2, paramFloat3, paramDouble1, this.hFk);
            ac.v("MicroMsg.DefaultTencentMapView", "doing map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", new Object[] { this, Double.valueOf(paramDouble1), Double.valueOf(this.hFk), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
            localTencentMap.animateCamera(localCameraUpdate, a.bhw(), a.p(a.this));
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
    localObject1 = this.kul.getMap().addCircle((CircleOptions)localObject1);
    synchronized (this.kuM)
    {
      this.kuM.add(localObject1);
      AppMethodBeat.o(146526);
      return;
    }
  }
  
  public final void a(b.j paramj, com.tencent.mm.plugin.appbrand.g.a parama)
  {
    int i = 0;
    AppMethodBeat.i(146531);
    Object localObject1 = new PolylineOptions();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramj.kvK.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      b.h localh = (b.h)((Iterator)localObject3).next();
      ((List)localObject2).add(new LatLng(localh.latitude, localh.longitude));
    }
    ((PolylineOptions)localObject1).addAll((Iterable)localObject2);
    if ((paramj.kvP != null) && (paramj.kvP.size() > 0))
    {
      ac.i("MicroMsg.DefaultTencentMapView", "colorList size:%d ", new Object[] { Integer.valueOf(paramj.kvP.size()) });
      int j = paramj.kvP.size();
      localObject2 = new int[j];
      localObject3 = new int[j];
      while (i < j)
      {
        localObject2[i] = ((Integer)paramj.kvP.get(i)).intValue();
        localObject3[i] = i;
        i += 1;
      }
      ((PolylineOptions)localObject1).colors((int[])localObject2, (int[])localObject3);
    }
    for (;;)
    {
      ((PolylineOptions)localObject1).width(paramj.width);
      ((PolylineOptions)localObject1).setDottedLine(paramj.kvL);
      ((PolylineOptions)localObject1).edgeColor(paramj.borderColor);
      ((PolylineOptions)localObject1).edgeWidth(paramj.borderWidth);
      if (paramj.kvM)
      {
        parama = parama.bH(paramj.kvN);
        ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(parama));
        if (parama == null) {
          ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), 2131230986)));
        }
      }
      ((PolylineOptions)localObject1).zIndex(1.0F);
      if ((!bs.isNullOrNil(paramj.buildingId)) && (!bs.isNullOrNil(paramj.floorName))) {
        ((PolylineOptions)localObject1).indoorInfo(new IndoorInfo(paramj.buildingId, paramj.floorName));
      }
      ((PolylineOptions)localObject1).arrowGap(paramj.kvO);
      ((PolylineOptions)localObject1).level(OverlayLevel.OverlayLevelAboveLabels);
      localObject1 = this.kul.getMap().addPolyline((PolylineOptions)localObject1);
      if (localObject1 != null) {
        break;
      }
      ac.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
      AppMethodBeat.o(146531);
      return;
      if (paramj.style != -1) {
        ((PolylineOptions)localObject1).color(paramj.style);
      } else {
        ((PolylineOptions)localObject1).color(paramj.color);
      }
    }
    if (bs.isNullOrNil(paramj.id)) {}
    for (parama = paramj.hashCode();; parama = paramj.id)
    {
      this.kuO.put(bs.bG(parama, paramj.toString()), localObject1);
      AppMethodBeat.o(146531);
      return;
    }
  }
  
  public final void a(b.k paramk)
  {
    this.kun = paramk;
  }
  
  public final void a(b.l paraml)
  {
    this.kuB = paraml;
  }
  
  public final void a(b.n paramn)
  {
    this.kup = paramn;
  }
  
  public final void a(b.o paramo)
  {
    this.kuo = paramo;
  }
  
  public final void a(b.q paramq)
  {
    this.kuq = paramq;
  }
  
  public final void a(b.u paramu)
  {
    AppMethodBeat.i(146499);
    this.kul.getMap().setTencentMapGestureListener(new TencentMap.TencentMapGestureListener()
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
    this.kul.getMap().setOnMapCameraChangeListener(new a.2(this, paramu));
    AppMethodBeat.o(146499);
  }
  
  public final void a(b.v paramv)
  {
    this.kuG = paramv;
  }
  
  public final void a(b.x paramx)
  {
    this.kuD = paramx;
  }
  
  public final void a(String paramString, int paramInt, b.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(146532);
    Polyline localPolyline = (Polyline)this.kuO.get(paramString);
    if (localPolyline == null)
    {
      ac.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
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
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s updateMarker markerId:%s", new Object[] { this, paramString });
    final d locald = Mp(paramString);
    if (locald != null) {
      if (paramt.kvU != null)
      {
        if (paramt.kvU.view == null) {
          break label519;
        }
        locald.kvQ.kvU = paramt.kvU;
        if (paramt.kvU.kwb != b.t.a.kwf) {
          break label481;
        }
        a(locald);
      }
    }
    label519:
    for (;;)
    {
      if (paramt.kvV != null)
      {
        locald.kvy.remove();
        Mq(paramString + "#label");
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new LatLng(paramt.latitude, paramt.longitude));
        localMarkerOptions.alpha(paramt.alpha);
        com.tencent.mm.plugin.appbrand.widget.d.d locald2 = i.bhz();
        com.tencent.mm.plugin.appbrand.widget.d.d locald1 = locald2;
        if (locald2 == null) {
          locald1 = new com.tencent.mm.plugin.appbrand.widget.d.d(this.context);
        }
        locald1.reset();
        locald1.setTextColor(paramt.kvV.color);
        locald1.setTextSize(paramt.kvV.kvW);
        locald1.setText(paramt.kvV.content);
        locald1.setTextPadding(paramt.kvV.padding);
        locald1.setGravity(paramt.kvV.jzJ);
        locald1.z(paramt.kvV.kvX, paramt.kvV.borderWidth, paramt.kvV.borderColor, paramt.kvV.bgColor);
        locald1.setX(paramt.kvV.x);
        locald1.setY(paramt.kvV.y);
        locald1.measure(0, 0);
        localMarkerOptions.anchor(locald1.getAnchorX(), locald1.getAnchorY());
        localMarkerOptions.markerView(locald1);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramt.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!bs.isNullOrNil(paramt.buildingId)) && (!bs.isNullOrNil(paramt.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramt.buildingId, paramt.floorName));
        }
        locald.kvy = this.kul.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", locald);
      }
      AppMethodBeat.o(182816);
      return;
      label481:
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        locald.kvx.refreshInfoWindow();
      }
      else
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182805);
            locald.kvx.refreshInfoWindow();
            AppMethodBeat.o(182805);
          }
        });
        continue;
        locald.kvz = null;
      }
    }
  }
  
  public final void a(final String paramString, b.t paramt, com.tencent.mm.plugin.appbrand.g.a parama)
  {
    AppMethodBeat.i(146536);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    if (this.kuY.get())
    {
      ac.e("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s fail", new Object[] { this, paramString });
      AppMethodBeat.o(146536);
      return;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new LatLng(paramt.latitude, paramt.longitude));
    if (!bs.isNullOrNil(paramt.title)) {
      localMarkerOptions.title(paramt.title);
    }
    if (!bs.isNullOrNil(paramt.kvT)) {
      localMarkerOptions.contentDescription(paramt.kvT);
    }
    localMarkerOptions.rotation(paramt.kvB);
    localMarkerOptions.alpha(paramt.alpha);
    final FrameLayout localFrameLayout = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493687, null);
    final ImageView localImageView = (ImageView)localFrameLayout.findViewById(2131302158);
    final float f1 = paramt.kvR;
    final float f2 = paramt.kvS;
    d locald = null;
    Object localObject = locald;
    if (parama != null)
    {
      localObject = locald;
      if (!bs.isNullOrNil(paramt.kvC))
      {
        if (localImageView != null) {
          localImageView.setImageBitmap(null);
        }
        localObject = parama.a(paramt.kvC, null, new com.tencent.mm.plugin.appbrand.g.a.b()
        {
          public final void M(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(146470);
            if (paramAnonymousBitmap != null)
            {
              a.b(f1, f2, paramAnonymousBitmap, localImageView);
              if ((a.this.Mp(paramString) != null) && (a.this.Mp(paramString).kvx != null))
              {
                ac.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                a.this.Mp(paramString).kvx.setMarkerView(localFrameLayout);
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
      if ((!bs.isNullOrNil(paramt.buildingId)) && (!bs.isNullOrNil(paramt.floorName))) {
        localMarkerOptions.indoorInfo(new IndoorInfo(paramt.buildingId, paramt.floorName));
      }
      if (paramt.kvU != null) {
        localMarkerOptions.infoWindowOffset(paramt.kvU.kwc, paramt.kvU.kwd);
      }
      parama = this.kul.getMap().addMarker(localMarkerOptions);
      locald = new d();
      locald.kvx = parama;
      locald.data = paramt.data;
      locald.kvQ = paramt;
      a(paramString, locald);
      if ((paramt.kvU != null) && (paramt.kvU.kwb == b.t.a.kwf)) {
        a(locald);
      }
      if (paramt.kvV != null)
      {
        localMarkerOptions = new MarkerOptions();
        localMarkerOptions.position(new LatLng(paramt.latitude, paramt.longitude));
        localMarkerOptions.alpha(paramt.alpha);
        localObject = i.bhz();
        parama = (com.tencent.mm.plugin.appbrand.g.a)localObject;
        if (localObject == null) {
          parama = new com.tencent.mm.plugin.appbrand.widget.d.d(this.context);
        }
        parama.reset();
        parama.setTextColor(paramt.kvV.color);
        parama.setTextSize(paramt.kvV.kvW);
        parama.setText(paramt.kvV.content);
        parama.setTextPadding(paramt.kvV.padding);
        parama.setGravity(paramt.kvV.jzJ);
        parama.z(paramt.kvV.kvX, paramt.kvV.borderWidth, paramt.kvV.borderColor, paramt.kvV.bgColor);
        parama.setX(paramt.kvV.x);
        parama.setY(paramt.kvV.y);
        parama.measure(0, 0);
        localMarkerOptions.anchor(parama.getAnchorX(), parama.getAnchorY());
        localMarkerOptions.markerView(parama);
        localMarkerOptions.visible(true);
        localMarkerOptions.tag(paramString + "#label");
        localMarkerOptions.zIndex(paramt.zIndex + 3);
        localMarkerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if ((!bs.isNullOrNil(paramt.buildingId)) && (!bs.isNullOrNil(paramt.floorName))) {
          localMarkerOptions.indoorInfo(new IndoorInfo(paramt.buildingId, paramt.floorName));
        }
        locald.kvy = this.kul.getMap().addMarker(localMarkerOptions);
        a(paramString + "#label", locald);
      }
      AppMethodBeat.o(146536);
      return;
      ac.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
    }
  }
  
  public final void a(final String paramString, ArrayList<b.h> arg2, long paramLong, boolean paramBoolean, b.p arg6)
  {
    AppMethodBeat.i(205797);
    d locald = Mp(paramString);
    if ((locald == null) || (locald.kvx == null))
    {
      ac.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      ???.gt(false);
      AppMethodBeat.o(205797);
      return;
    }
    if (???.size() <= 0)
    {
      ac.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      ???.gt(false);
      AppMethodBeat.o(205797);
      return;
    }
    synchronized (this.kux)
    {
      if (this.kux.containsKey(paramString)) {
        l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205781);
            this.kvr.cancelAnimation();
            AppMethodBeat.o(205781);
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
    ??? = new MarkerTranslateAnimator(locald.kvx, paramLong, (LatLng[])???, paramBoolean);
    ???.addAnimatorListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(205784);
        ac.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationCancel");
        if (paramp != null) {
          paramp.bhe();
        }
        synchronized (a.r(a.this))
        {
          a.r(a.this).remove(paramString);
          AppMethodBeat.o(205784);
          return;
        }
      }
      
      public final void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(205783);
        ac.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationEnd");
        if (paramp != null) {
          paramp.gt(true);
        }
        synchronized (a.r(a.this))
        {
          a.r(a.this).remove(paramString);
          AppMethodBeat.o(205783);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205782);
        ac.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationStart");
        AppMethodBeat.o(205782);
      }
    });
    synchronized (this.kux)
    {
      this.kux.put(paramString, ???);
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205785);
          ac.d("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator start");
          paramArrayList.startAnimation();
          AppMethodBeat.o(205785);
        }
      });
      if (locald.kvy != null)
      {
        ac.d("MicroMsg.DefaultTencentMapView", "labelMarker do move animator");
        synchronized (this.kuy)
        {
          if (this.kuy.containsKey(paramString)) {
            l.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(205786);
                this.kvr.cancelAnimation();
                AppMethodBeat.o(205786);
              }
            });
          }
          ??? = new MarkerTranslateAnimator(locald.kvy, paramLong, (LatLng[])???, paramBoolean);
          ???.addAnimatorListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator arg1)
            {
              AppMethodBeat.i(205788);
              synchronized (a.s(a.this))
              {
                a.s(a.this).remove(paramString);
                AppMethodBeat.o(205788);
                return;
              }
            }
            
            public final void onAnimationEnd(Animator arg1)
            {
              AppMethodBeat.i(205787);
              synchronized (a.s(a.this))
              {
                a.s(a.this).remove(paramString);
                AppMethodBeat.o(205787);
                return;
              }
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          });
        }
      }
    }
    synchronized (this.kuy)
    {
      this.kuy.put(paramString, ???);
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205789);
          paramp.startAnimation();
          AppMethodBeat.o(205789);
        }
      });
      AppMethodBeat.o(205797);
      return;
      paramString = finally;
      AppMethodBeat.o(205797);
      throw paramString;
      paramString = finally;
      AppMethodBeat.o(205797);
      throw paramString;
    }
  }
  
  public final void a(String paramString, LinkedList<b.g> paramLinkedList, final b.p paramp)
  {
    AppMethodBeat.i(146539);
    paramString = Mp(paramString);
    if ((paramString == null) || (paramString.kvx == null))
    {
      ac.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      paramp.gt(false);
      AppMethodBeat.o(146539);
      return;
    }
    if (paramLinkedList.size() <= 0)
    {
      ac.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      paramp.gt(false);
      AppMethodBeat.o(146539);
      return;
    }
    Object localObject = (b.g)paramLinkedList.get(0);
    ((b.g)localObject).kvH = paramString.kvx.getPosition().getLatitude();
    ((b.g)localObject).kvG = paramString.kvx.getPosition().getLongitude();
    int j = paramLinkedList.size();
    int i = 1;
    if (i < j)
    {
      localObject = (b.g)paramLinkedList.get(i - 1);
      b.g localg = (b.g)paramLinkedList.get(i);
      if (((b.g)localObject).kvB == 0.0F) {
        localg.kvG = ((b.g)localObject).longitude;
      }
      for (localg.kvH = ((b.g)localObject).latitude;; localg.kvH = paramString.kvx.getPosition().getLatitude())
      {
        i += 1;
        break;
        localg.kvG = paramString.kvx.getPosition().getLongitude();
      }
    }
    localObject = new c(paramLinkedList, paramString.kvx, this.kul);
    paramp = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(182807);
        ac.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
        if (paramp != null) {
          paramp.gt(true);
        }
        AppMethodBeat.o(182807);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(182806);
        ac.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
        AppMethodBeat.o(182806);
      }
    };
    ((c)localObject).vc.addListener(paramp);
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(182808);
        this.kvp.vc.start();
        AppMethodBeat.o(182808);
      }
    });
    if (paramString.kvy != null) {
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182809);
          this.kvq.vc.start();
          AppMethodBeat.o(182809);
        }
      });
    }
    AppMethodBeat.o(146539);
  }
  
  public final boolean a(b.c paramc, b.m paramm, final com.tencent.mm.plugin.appbrand.g.a parama)
  {
    AppMethodBeat.i(146528);
    if (bs.isNullOrNil(paramc.kvC))
    {
      AppMethodBeat.o(146528);
      return false;
    }
    Object localObject = parama.bH(paramc.kvC);
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
      i = com.tencent.mm.plugin.appbrand.z.g.ve(((Bitmap)localObject).getHeight());
      if (paramc.width != 0) {
        break label217;
      }
    }
    label217:
    for (int j = com.tencent.mm.plugin.appbrand.z.g.ve(((Bitmap)localObject).getWidth());; j = paramc.width)
    {
      localObject = new FrameLayout.LayoutParams(j, i);
      ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
      boolean bool = paramc.kvD;
      paramc = paramc.data;
      parama.setOnTouchListener(new a.7(this, bool, parama));
      parama.setOnClickListener(new a.8(this, bool, paramm, paramc));
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(146469);
          ((ViewGroup)a.this.container).addView(parama, this.kvh);
          synchronized (a.this.kuN)
          {
            a.this.kuN.add(new a.b(a.this, parama));
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
    if (bs.isNullOrNil(???.kvC))
    {
      AppMethodBeat.o(146541);
      return false;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new LatLng(???.latitude, ???.longitude));
    parama = parama.bH(???.kvC);
    if ((parama != null) && (!parama.isRecycled())) {
      localMarkerOptions.icon(new BitmapDescriptor(parama));
    }
    localMarkerOptions.rotation(???.kvB);
    parama = this.kul.getMap().addMarker(localMarkerOptions);
    synchronized (this.kuR)
    {
      this.kuR.add(new c(parama));
      AppMethodBeat.o(146541);
      return true;
    }
  }
  
  public final boolean a(b.y arg1)
  {
    AppMethodBeat.i(146543);
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.kvK.iterator();
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
    localObject1 = this.kul.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.kuS)
    {
      this.kuS.add(localObject1);
      AppMethodBeat.o(146543);
      return true;
    }
  }
  
  public final b.z bhj()
  {
    AppMethodBeat.i(146498);
    Object localObject2 = this.kul.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.i();
    ((b.i)localObject1).kvI = new b.h(((LatLngBounds)localObject2).getSouthwest().getLatitude(), ((LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.i)localObject1).kvJ = new b.h(((LatLngBounds)localObject2).getNortheast().getLatitude(), ((LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.aa();
    ((b.aa)localObject2).kwh = ((b.i)localObject1);
    localObject1 = new b.z();
    ((b.z)localObject1).kwg = ((b.aa)localObject2);
    AppMethodBeat.o(146498);
    return localObject1;
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(146501);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.kuF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146461);
        if ((a.c(a.this) != null) && (a.n(a.this)))
        {
          double d1 = a.c(a.this).getLatitude();
          double d2 = a.c(a.this).getLongitude();
          a.this.kul.getIController().animateTo(d1, d2);
          ac.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        }
        AppMethodBeat.o(146461);
      }
    };
    if ((this.kuU != null) && (this.kuT))
    {
      this.kuF.run();
      this.kuF = null;
    }
    AppMethodBeat.o(146501);
  }
  
  public final b.e bhl()
  {
    AppMethodBeat.i(146515);
    if (this.kuH != null)
    {
      locale = this.kuH;
      AppMethodBeat.o(146515);
      return locale;
    }
    b.e locale = bhh();
    AppMethodBeat.o(146515);
    return locale;
  }
  
  public boolean bhm()
  {
    return false;
  }
  
  public final b.h bhn()
  {
    AppMethodBeat.i(146519);
    Object localObject = this.kul.getMap().getMapCenter();
    localObject = new b.h(((LatLng)localObject).getLatitude(), ((LatLng)localObject).getLongitude());
    AppMethodBeat.o(146519);
    return localObject;
  }
  
  public final void bho()
  {
    AppMethodBeat.i(146525);
    synchronized (this.kuM)
    {
      Iterator localIterator = this.kuM.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.kuM.clear();
    AppMethodBeat.o(146525);
  }
  
  public final void bhp()
  {
    AppMethodBeat.i(146527);
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146465);
        ViewGroup localViewGroup = (ViewGroup)a.this.container;
        synchronized (a.this.kuN)
        {
          Iterator localIterator = a.this.kuN.iterator();
          if (localIterator.hasNext()) {
            localViewGroup.removeView(((a.b)localIterator.next()).kvw);
          }
        }
        a.this.kuN.clear();
        AppMethodBeat.o(146465);
      }
    });
    AppMethodBeat.o(146527);
  }
  
  public final void bhq()
  {
    AppMethodBeat.i(146529);
    Iterator localIterator = this.kuO.values().iterator();
    while (localIterator.hasNext()) {
      ((Polyline)localIterator.next()).remove();
    }
    this.kuO.clear();
    AppMethodBeat.o(146529);
  }
  
  public final void bhr()
  {
    AppMethodBeat.i(146534);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.kuQ.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      locald.kvx.remove();
      if (locald.kvy != null)
      {
        if ((locald.kvy.getMarkerView() != null) && ((locald.kvy.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.d.d)locald.kvy.getMarkerView());
        }
        locald.kvy.remove();
      }
    }
    this.kuQ.clear();
    AppMethodBeat.o(146534);
  }
  
  public final void bhs()
  {
    AppMethodBeat.i(146540);
    synchronized (this.kuR)
    {
      Iterator localIterator = this.kuR.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).kvx.remove();
      }
    }
    this.kuR.clear();
    AppMethodBeat.o(146540);
  }
  
  public final void bht()
  {
    AppMethodBeat.i(146542);
    synchronized (this.kuS)
    {
      Iterator localIterator = this.kuS.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.kuS.clear();
    AppMethodBeat.o(146542);
  }
  
  public final void c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(146516);
    LatLng localLatLng = this.kul.getMap().getMapCenter();
    this.kul.setMapAnchor(paramFloat1, paramFloat2);
    a(localLatLng.getLatitude(), localLatLng.getLongitude(), -1.0F, -1.0F, -1.0F, paramBoolean);
    AppMethodBeat.o(146516);
  }
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146514);
    this.kul.getMap().setIndoorFloor(paramString1, paramString2);
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
    AppMethodBeat.i(146511);
    this.kul.getMap().setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(146511);
  }
  
  public final void gB(boolean paramBoolean)
  {
    AppMethodBeat.i(146512);
    this.kul.getMap().setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(146512);
  }
  
  public final void gC(boolean paramBoolean)
  {
    AppMethodBeat.i(146513);
    this.kul.getMap().setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(146513);
  }
  
  public final void gD(boolean paramBoolean)
  {
    AppMethodBeat.i(146517);
    this.kul.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
    AppMethodBeat.o(146517);
  }
  
  public final void gE(boolean paramBoolean)
  {
    AppMethodBeat.i(146518);
    this.kul.getUiSettings().setScaleControlsEnabled(paramBoolean);
    AppMethodBeat.o(146518);
  }
  
  public final void gF(boolean paramBoolean)
  {
    AppMethodBeat.i(146544);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.kuT = paramBoolean;
    d locald;
    if (paramBoolean)
    {
      if (this.kuU != null)
      {
        locald = this.kuU;
        if (locald.kvx != null) {
          locald.kvx.setVisible(true);
        }
      }
      ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.kuV, bhu());
      g.a(this);
      AppMethodBeat.o(146544);
      return;
    }
    if (this.kuU != null)
    {
      locald = this.kuU;
      if (locald.kvx != null) {
        locald.kvx.setVisible(false);
      }
    }
    ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.kuV, bhu());
    g.b(this);
    AppMethodBeat.o(146544);
  }
  
  public final float getRotate()
  {
    AppMethodBeat.i(146503);
    float f = this.kul.getMap().getCameraPosition().getBearing();
    AppMethodBeat.o(146503);
    return f;
  }
  
  public final float getSkew()
  {
    AppMethodBeat.i(146504);
    float f = this.kul.getMap().getCameraPosition().getSkew();
    AppMethodBeat.o(146504);
    return f;
  }
  
  public final View getView()
  {
    return this.container;
  }
  
  public final float getZoom()
  {
    AppMethodBeat.i(205793);
    float f = this.kul.getMap().getCameraPosition().getZoom();
    AppMethodBeat.o(205793);
    return f;
  }
  
  public final void gu(boolean paramBoolean)
  {
    AppMethodBeat.i(146505);
    this.kul.getUiSettings().setZoomGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146505);
  }
  
  public final void gv(boolean paramBoolean)
  {
    AppMethodBeat.i(146506);
    this.kul.getUiSettings().setScrollGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146506);
  }
  
  public final void gw(boolean paramBoolean)
  {
    AppMethodBeat.i(146507);
    this.kul.getUiSettings().setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146507);
  }
  
  public final void gx(boolean paramBoolean)
  {
    AppMethodBeat.i(146508);
    this.kul.getUiSettings().setCompassEnabled(paramBoolean);
    AppMethodBeat.o(146508);
  }
  
  public final void gy(boolean paramBoolean)
  {
    AppMethodBeat.i(146509);
    this.kul.getMap().set3DEnable(paramBoolean);
    AppMethodBeat.o(146509);
  }
  
  public final void gz(boolean paramBoolean)
  {
    AppMethodBeat.i(146510);
    this.kul.getUiSettings().setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(146510);
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
    this.kul.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.kuF = null;
    AppMethodBeat.o(146520);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(146497);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.kuY.set(true);
    this.kul.getMap().setOnMapCameraChangeListener(null);
    bhr();
    bhq();
    bhq();
    bhp();
    bhs();
    bht();
    Object localObject = this.kuI.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CustomLayer)((Iterator)localObject).next()).remove();
    }
    this.kuI.clear();
    if (this.kul != null)
    {
      this.kul.getMap().setOnMapPoiClickListener(null);
      this.kul.clean();
      this.kul.onDestroy();
    }
    if (this.kuU != null)
    {
      localObject = this.kuU;
      if (((d)localObject).kvx != null)
      {
        ((d)localObject).kvx.remove();
        ((d)localObject).kvx = null;
      }
      this.kuU = null;
    }
    AppMethodBeat.o(146497);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(146494);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.dhf.setVisibility(0);
      if (this.kuz == null) {
        this.kuz = getSurfaceView();
      }
      if (this.kuz != null)
      {
        ap.n(this.kuA, 100L);
        this.kul.setVisibility(4);
        this.kul.getMap().getScreenShot(new TencentMap.OnScreenShotListener()
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
      this.kum = true;
      if (this.kuT)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.kuV, bhu());
        g.b(this);
      }
      AppMethodBeat.o(146494);
      return;
      ac.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
      break;
      this.kul.onPause();
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(146493);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.dhf.setVisibility(4);
      this.kul.setVisibility(0);
      this.kul.onResume();
      bhi();
    }
    for (;;)
    {
      this.kum = false;
      if (this.kuT)
      {
        ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.kuV, bhu());
        g.a(this);
      }
      AppMethodBeat.o(146493);
      return;
      this.kul.onResume();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2) {}
  
  public void onTouchEvent(MotionEvent paramMotionEvent) {}
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(205794);
    this.kul.getMap().setIndoorMaskColor(paramInt);
    AppMethodBeat.o(205794);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(182813);
    ac.i("MicroMsg.DefaultTencentMapView", "map:%s setMapStyle: %d", new Object[] { this, Integer.valueOf(paramInt) });
    this.kul.getMap().setMapStyle(paramInt);
    AppMethodBeat.o(182813);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(205795);
    this.kul.getMap().setMaxZoomLevel(paramInt);
    AppMethodBeat.o(205795);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(205796);
    this.kul.getMap().setMinZoomLevel(paramInt);
    AppMethodBeat.o(205796);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146547);
    String str = "DefaultTencentMapView{mapId=" + this.kuk + '}';
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
      if (bs.isNullOrNil((String)paramMarker.getTag()))
      {
        ac.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (((String)paramMarker.getTag()).endsWith("#label"))
      {
        AppMethodBeat.o(146488);
        return null;
      }
      paramMarker = a.this.Mp((String)paramMarker.getTag());
      if (paramMarker == null)
      {
        ac.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      if (paramMarker.kvQ == null)
      {
        ac.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
        AppMethodBeat.o(146488);
        return null;
      }
      b.t.a locala = paramMarker.kvQ.kvU;
      if (locala == null)
      {
        AppMethodBeat.o(146488);
        return null;
      }
      if (locala.view != null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view is %b", new Object[] { paramMarker, Boolean.valueOf(bool) });
        if (locala.view == null) {
          break;
        }
        if (paramMarker.kvz == null) {
          paramMarker.kvz = new ImageView(a.q(a.this));
        }
        localObject = com.tencent.mm.sdk.platformtools.f.fL(locala.view);
        if (localObject == null) {
          ac.e("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view exist but bitmap is null");
        }
        paramMarker.kvz.setImageBitmap((Bitmap)localObject);
        paramMarker = paramMarker.kvz;
        AppMethodBeat.o(146488);
        return paramMarker;
      }
      a locala1 = a.this;
      Object localObject = i.bhy();
      paramMarker = (Marker)localObject;
      if (localObject == null) {
        paramMarker = new com.tencent.mm.plugin.appbrand.widget.d.b(locala1.context);
      }
      paramMarker.setText("");
      paramMarker.setTextSize(12);
      paramMarker.setTextColor(com.tencent.mm.plugin.appbrand.widget.d.b.mJk);
      paramMarker.setTitlePadding(0);
      paramMarker.setGravity("center");
      int i = com.tencent.mm.plugin.appbrand.widget.d.b.mJl;
      paramMarker.z(0, 0, i, i);
      paramMarker.setText(locala.content);
      paramMarker.setTextSize(locala.kvW);
      paramMarker.setTextColor(locala.color);
      paramMarker.setTitlePadding(locala.padding);
      paramMarker.setGravity(locala.jzJ);
      paramMarker.z(locala.kvX, locala.borderWidth, locala.borderColor, locala.bgColor);
      AppMethodBeat.o(146488);
      return paramMarker;
    }
    
    public final void onInfoWindowDettached(Marker paramMarker, View paramView)
    {
      AppMethodBeat.i(146489);
      if ((paramView instanceof com.tencent.mm.plugin.appbrand.widget.d.b))
      {
        ac.d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
        i.a((com.tencent.mm.plugin.appbrand.widget.d.b)paramView);
      }
      AppMethodBeat.o(146489);
    }
  }
  
  public final class b
  {
    ImageView kvw;
    
    public b(ImageView paramImageView)
    {
      this.kvw = paramImageView;
    }
  }
  
  public final class c
  {
    Marker kvx;
    
    public c(Marker paramMarker)
    {
      this.kvx = paramMarker;
    }
  }
  
  public static final class d
    extends b.s
  {
    public Marker kvx;
    public Marker kvy;
    public ImageView kvz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.a
 * JD-Core Version:    0.7.0.1
 */