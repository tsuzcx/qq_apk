package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.IndoorLevel;
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
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.widget.e.c;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  implements b
{
  private static final String hOl;
  Context context;
  private ImageView cuM;
  public ArrayList<a.b> hOA;
  private Map<String, Polyline> hOB;
  private a.a hOC;
  private Map<String, d> hOD;
  public ArrayList<c> hOE;
  public ArrayList<Polygon> hOF;
  private boolean hOG;
  private d hOH;
  private com.tencent.mm.plugin.appbrand.t.b.a.b hOI;
  private final int hOJ;
  private AtomicBoolean hOK;
  private AtomicBoolean hOL;
  private String hOg;
  FrameLayout hOh;
  protected final SoSoMapView hOi;
  private b.k hOj;
  private b.n hOk;
  private String hOm;
  private String hOn;
  private int hOo;
  private CameraPosition hOp;
  SurfaceView hOq;
  private Runnable hOr;
  private b.l hOs;
  private b.u hOt;
  private b.v hOu;
  private boolean hOv;
  private Runnable hOw;
  private b.t hOx;
  private b.e hOy;
  public ArrayList<Circle> hOz;
  private boolean isBackground;
  private long lastCheckTime;
  private int mMapType;
  
  static
  {
    AppMethodBeat.i(146056);
    hOl = com.tencent.luggage.g.i.y("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    AppMethodBeat.o(146056);
  }
  
  public a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(51177);
    this.hOr = new a.22(this);
    this.hOv = false;
    this.hOz = new ArrayList();
    this.hOA = new ArrayList();
    this.hOB = new ConcurrentHashMap();
    this.hOC = new a.a(this);
    this.hOD = new ConcurrentHashMap();
    this.hOE = new ArrayList();
    this.hOF = new ArrayList();
    this.hOI = new a.15(this);
    this.lastCheckTime = 0L;
    this.hOJ = 500;
    this.hOK = new AtomicBoolean(false);
    this.hOL = new AtomicBoolean(false);
    this.context = paramContext;
    this.hOg = paramString;
    this.hOh = new FrameLayout(paramContext);
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.hOh.setBackgroundColor(0);
    this.hOh.setLayoutParams(paramString);
    this.hOi = new SoSoMapView(paramContext, B(paramMap));
    this.hOh.addView(this.hOi, new FrameLayout.LayoutParams(-1, -1));
    this.cuM = new ImageView(paramContext);
    this.cuM.setScaleType(ImageView.ScaleType.FIT_XY);
    this.hOh.addView(this.cuM, new ViewGroup.LayoutParams(-1, -1));
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s, init", new Object[] { this });
    this.hOi.getMap().setInfoWindowAdapter(this.hOC);
    this.hOi.getMap().setMapAnchor(0.5F, 0.5F);
    this.hOi.getMap().enableMultipleInfowindow(true);
    this.hOi.getMap().setMapStyle(this.hOo);
    this.hOi.getMap().setOnInfoWindowClickListener(new a.1(this));
    this.hOi.getMap().setOnMarkerClickListener(new a.12(this));
    this.hOi.getMap().setOnMapClickListener(new a.17(this));
    this.hOi.getMap().setOnMapLoadedListener(new a.18(this));
    this.hOi.getMap().setOnMapPoiClickListener(new a.19(this));
    this.hOi.getMap().setOnIndoorStateChangeListener(new TencentMap.OnIndoorStateChangeListener()
    {
      public final boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(51171);
        ab.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
        if (a.i(a.this) != null)
        {
          b.e locale = a.aDG();
          a.a(a.this, locale);
          a.i(a.this).a(locale);
        }
        AppMethodBeat.o(51171);
        return true;
      }
      
      public final boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(51169);
        ab.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingFocused]");
        AppMethodBeat.o(51169);
        return true;
      }
      
      public final boolean onIndoorLevelActivated(IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(51170);
        ab.v("MicroMsg.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", new Object[] { paramAnonymousIndoorBuilding });
        if (a.i(a.this) != null)
        {
          b.e locale = new b.e();
          locale.buildingId = paramAnonymousIndoorBuilding.getBuidlingId();
          locale.buildingName = paramAnonymousIndoorBuilding.getBuildingName();
          locale.hPg = new LinkedList();
          Iterator localIterator = paramAnonymousIndoorBuilding.getLevels().iterator();
          while (localIterator.hasNext())
          {
            IndoorLevel localIndoorLevel = (IndoorLevel)localIterator.next();
            b.f localf = new b.f();
            localf.floorName = localIndoorLevel.getName();
            locale.hPg.add(localf);
          }
          locale.hPh = paramAnonymousIndoorBuilding.getActiveLevelIndex();
          a.a(a.this, locale);
          a.i(a.this).a(locale);
        }
        AppMethodBeat.o(51170);
        return true;
      }
    });
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
    this.hOi.onCreate(null);
    onResume();
    AppMethodBeat.o(51177);
  }
  
  private static void a(float paramFloat1, float paramFloat2, Bitmap paramBitmap, ImageView paramImageView)
  {
    AppMethodBeat.i(51222);
    float f;
    if (paramFloat1 != 0.0F)
    {
      f = paramFloat1;
      paramFloat1 = paramFloat2;
      if (paramFloat2 != 0.0F) {}
    }
    else
    {
      f = com.tencent.mm.plugin.appbrand.s.g.pO(paramBitmap.getWidth());
      paramFloat1 = com.tencent.mm.plugin.appbrand.s.g.pO(paramBitmap.getHeight());
    }
    if ((f > 0.0F) && (paramFloat1 > 0.0F) && ((f != paramBitmap.getWidth()) || (paramFloat1 != paramBitmap.getHeight())))
    {
      paramFloat2 = f / paramBitmap.getWidth();
      paramFloat1 /= paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat2, paramFloat1);
      paramImageView.setImageBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true));
      AppMethodBeat.o(51222);
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
    paramImageView.setScaleType(ImageView.ScaleType.CENTER);
    AppMethodBeat.o(51222);
  }
  
  private void a(String paramString, d paramd)
  {
    AppMethodBeat.i(51223);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.hOD.put(paramString, paramd);
    AppMethodBeat.o(51223);
  }
  
  private Bundle aDF()
  {
    AppMethodBeat.i(51230);
    Bundle localBundle = new Bundle();
    if (!hOl.equals(this.hOm))
    {
      String str = bo.nullAsNil(localBundle.getString("smallAppKey"));
      localBundle.putString("smallAppKey", str + this.hOm + "#" + this.hOn + ";");
    }
    AppMethodBeat.o(51230);
    return localBundle;
  }
  
  private static b.e aDq()
  {
    AppMethodBeat.i(51179);
    b.e locale = new b.e();
    locale.buildingId = "";
    locale.buildingName = "";
    locale.hPg = new LinkedList();
    locale.hPh = -1;
    AppMethodBeat.o(51179);
    return locale;
  }
  
  private SurfaceView aDr()
  {
    AppMethodBeat.i(51182);
    if (this.hOq != null)
    {
      localSurfaceView = this.hOq;
      AppMethodBeat.o(51182);
      return localSurfaceView;
    }
    this.hOq = h(this.hOi);
    SurfaceView localSurfaceView = this.hOq;
    AppMethodBeat.o(51182);
    return localSurfaceView;
  }
  
  private void aDs()
  {
    AppMethodBeat.i(51183);
    if (this.hOq == null) {
      this.hOq = aDr();
    }
    if (this.hOq != null)
    {
      al.ae(this.hOr);
      this.hOq.setVisibility(0);
      AppMethodBeat.o(51183);
      return;
    }
    ab.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
    AppMethodBeat.o(51183);
  }
  
  private static SurfaceView h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51233);
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() == 0))
    {
      AppMethodBeat.o(51233);
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
        AppMethodBeat.o(51233);
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
    AppMethodBeat.o(51233);
    return null;
  }
  
  protected TencentMapOptions B(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(51178);
    TencentMapOptions localTencentMapOptions = new TencentMapOptions();
    if (paramMap == null)
    {
      ab.w("MicroMsg.DefaultTencentMapView", "params is null, return");
      AppMethodBeat.o(51178);
      return localTencentMapOptions;
    }
    String str = f.a(paramMap, "theme", "normal");
    boolean bool = str.equals("handDraw");
    localTencentMapOptions.enableHandDrawMap(bool);
    this.mMapType = f.a(paramMap, "mapType", 1);
    localTencentMapOptions.setMapType(this.mMapType);
    this.hOm = f.a(paramMap, "subKey", "");
    this.hOn = f.a(paramMap, "subId", "");
    if (bo.isNullOrNil(this.hOm))
    {
      this.hOm = hOl;
      this.hOn = "";
    }
    localTencentMapOptions.setSubInfo(this.hOm, this.hOn);
    this.hOo = f.a(paramMap, "styleId", 0);
    ab.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.hOn, this.hOm });
    ab.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(this.mMapType), this.hOn, this.hOm, Integer.valueOf(this.hOo) });
    AppMethodBeat.o(51178);
    return localTencentMapOptions;
  }
  
  public final boolean Cg(String paramString)
  {
    AppMethodBeat.i(51215);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", new Object[] { this, paramString });
    Polyline localPolyline = (Polyline)this.hOB.get(paramString);
    if (localPolyline == null)
    {
      ab.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(51215);
      return false;
    }
    localPolyline.remove();
    this.hOB.remove(paramString);
    AppMethodBeat.o(51215);
    return true;
  }
  
  public final b.q Ch(String paramString)
  {
    AppMethodBeat.i(51218);
    paramString = (b.q)this.hOD.get(paramString);
    AppMethodBeat.o(51218);
    return paramString;
  }
  
  public final boolean Ci(String paramString)
  {
    AppMethodBeat.i(51220);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    d locald = (d)this.hOD.get(paramString);
    if (locald == null)
    {
      ab.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      AppMethodBeat.o(51220);
      return false;
    }
    locald.hPb.remove();
    if (locald.hPc != null)
    {
      if ((locald.hPc.getMarkerView() != null) && ((locald.hPc.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.e.d)locald.hPc.getMarkerView());
      }
      locald.hPc.remove();
      this.hOD.remove(paramString + "#label");
    }
    this.hOD.remove(paramString);
    AppMethodBeat.o(51220);
    return true;
  }
  
  public final void L(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146051);
    this.hOi.getIController().animateTo(paramFloat1, paramFloat2);
    AppMethodBeat.o(146051);
  }
  
  public final void M(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(51206);
    this.hOi.getIController().setCenter(paramFloat1, paramFloat2);
    AppMethodBeat.o(51206);
  }
  
  public final void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(51231);
    if ((!this.hOG) || (this.isBackground))
    {
      AppMethodBeat.o(51231);
      return;
    }
    if (this.hOH != null) {
      this.hOH.N(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(51231);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    AppMethodBeat.i(51209);
    TencentMap localTencentMap = this.hOi.getMap();
    if (localTencentMap != null)
    {
      localTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(paramFloat1, paramFloat2), paramFloat3, paramFloat5, paramFloat4)));
      this.hOw = null;
    }
    AppMethodBeat.o(51209);
  }
  
  public final void a(b.b arg1)
  {
    AppMethodBeat.i(51211);
    Object localObject1 = new CircleOptions();
    ((CircleOptions)localObject1).center(new LatLng(???.latitude, ???.longitude));
    ((CircleOptions)localObject1).radius(???.radius);
    ((CircleOptions)localObject1).strokeColor(???.strokeColor);
    ((CircleOptions)localObject1).strokeWidth(???.strokeWidth);
    ((CircleOptions)localObject1).fillColor(???.fillColor);
    localObject1 = this.hOi.getMap().addCircle((CircleOptions)localObject1);
    synchronized (this.hOz)
    {
      this.hOz.add(localObject1);
      AppMethodBeat.o(51211);
      return;
    }
  }
  
  public final void a(b.j paramj, com.tencent.mm.plugin.appbrand.e.a parama)
  {
    AppMethodBeat.i(51216);
    Object localObject = new PolylineOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramj.hPm.iterator();
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
      ((PolylineOptions)localObject).setDottedLine(paramj.hPn);
      ((PolylineOptions)localObject).edgeColor(paramj.borderColor);
      ((PolylineOptions)localObject).edgeWidth(paramj.borderWidth);
      if (paramj.hPo)
      {
        parama = parama.bB(paramj.hPp);
        ((PolylineOptions)localObject).arrowTexture(new BitmapDescriptor(parama));
        if (parama == null) {
          ((PolylineOptions)localObject).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), 2130837748)));
        }
      }
      ((PolylineOptions)localObject).zIndex(1.0F);
      if ((!bo.isNullOrNil(paramj.buildingId)) && (!bo.isNullOrNil(paramj.floorName))) {
        ((PolylineOptions)localObject).indoorInfo(new IndoorInfo(paramj.buildingId, paramj.floorName));
      }
      ((PolylineOptions)localObject).arrowGap(paramj.hPq);
      if (this.hOi.getMap().isHandDrawMapEnable()) {
        ((PolylineOptions)localObject).level(OverlayLevel.OverlayLevelAboveBuildings);
      }
      localObject = this.hOi.getMap().addPolyline((PolylineOptions)localObject);
      if (localObject != null) {
        break;
      }
      ab.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
      AppMethodBeat.o(51216);
      return;
      ((PolylineOptions)localObject).color(paramj.color);
    }
    if (bo.isNullOrNil(paramj.id)) {}
    for (parama = paramj.hashCode();; parama = paramj.id)
    {
      this.hOB.put(bo.bf(parama, paramj.toString()), localObject);
      AppMethodBeat.o(51216);
      return;
    }
  }
  
  public final void a(b.k paramk)
  {
    this.hOj = paramk;
  }
  
  public final void a(b.l paraml)
  {
    this.hOs = paraml;
  }
  
  public final void a(b.n paramn)
  {
    this.hOk = paramn;
  }
  
  public final void a(b.s params)
  {
    AppMethodBeat.i(51186);
    this.hOi.getMap().setTencentMapGestureListener(new a.23(this));
    this.hOi.getMap().setOnMapCameraChangeListener(new a.2(this, params));
    AppMethodBeat.o(51186);
  }
  
  public final void a(b.t paramt)
  {
    this.hOx = paramt;
  }
  
  public final void a(b.v paramv)
  {
    this.hOu = paramv;
  }
  
  public final void a(String paramString, int paramInt, b.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(51217);
    Polyline localPolyline = (Polyline)this.hOB.get(paramString);
    if (localPolyline == null)
    {
      ab.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", new Object[] { paramString });
      AppMethodBeat.o(51217);
      return;
    }
    localPolyline.setEraseable(paramBoolean);
    localPolyline.eraseTo(paramInt, new LatLng(paramh.latitude, paramh.longitude));
    AppMethodBeat.o(51217);
  }
  
  public final void a(String paramString, b.r paramr, com.tencent.mm.plugin.appbrand.e.a parama)
  {
    Object localObject1 = null;
    AppMethodBeat.i(51221);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    Object localObject2 = new MarkerOptions();
    ((MarkerOptions)localObject2).position(new LatLng(paramr.latitude, paramr.longitude));
    if (!bo.isNullOrNil(paramr.title)) {
      ((MarkerOptions)localObject2).title(paramr.title);
    }
    if (!bo.isNullOrNil(paramr.hPu)) {
      ((MarkerOptions)localObject2).contentDescription(paramr.hPu);
    }
    ((MarkerOptions)localObject2).rotation(paramr.rotate);
    ((MarkerOptions)localObject2).alpha(paramr.alpha);
    Object localObject3 = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130969299, null);
    ImageView localImageView = (ImageView)((FrameLayout)localObject3).findViewById(2131821263);
    float f1 = paramr.hPs;
    float f2 = paramr.hPt;
    if (parama != null) {
      localObject1 = parama.a(paramr.hPe, null, new a.8(this, f1, f2, localImageView));
    }
    if (localObject1 != null) {
      a(f1, f2, (Bitmap)localObject1, localImageView);
    }
    for (;;)
    {
      ((MarkerOptions)localObject2).markerView((View)localObject3);
      ((MarkerOptions)localObject2).anchor(paramr.bna, paramr.bnb);
      ((MarkerOptions)localObject2).tag(paramString);
      ((MarkerOptions)localObject2).infoWindowHideAnimation(new a.9(this));
      ((MarkerOptions)localObject2).infoWindowShowAnimation(new a.10(this));
      ((MarkerOptions)localObject2).visible(true);
      ((MarkerOptions)localObject2).zIndex(paramr.zIndex + 2);
      if ((!bo.isNullOrNil(paramr.buildingId)) && (!bo.isNullOrNil(paramr.floorName))) {
        ((MarkerOptions)localObject2).indoorInfo(new IndoorInfo(paramr.buildingId, paramr.floorName));
      }
      parama = this.hOi.getMap().addMarker((MarkerOptions)localObject2);
      localObject2 = new d();
      ((d)localObject2).hPb = parama;
      ((d)localObject2).data = paramr.data;
      ((d)localObject2).hPr = paramr;
      a(paramString, (d)localObject2);
      if ((paramr.hPv != null) && (paramr.hPv.hPC == b.r.a.hPE)) {
        ((d)localObject2).hPb.showInfoWindow();
      }
      if (paramr.hPw != null)
      {
        localObject3 = new MarkerOptions();
        ((MarkerOptions)localObject3).position(new LatLng(paramr.latitude, paramr.longitude));
        ((MarkerOptions)localObject3).alpha(paramr.alpha);
        localObject1 = i.aDJ();
        parama = (com.tencent.mm.plugin.appbrand.e.a)localObject1;
        if (localObject1 == null) {
          parama = new com.tencent.mm.plugin.appbrand.widget.e.d(this.context);
        }
        parama.setText("");
        parama.setTextSize(12);
        parama.setTextColor(com.tencent.mm.plugin.appbrand.widget.e.d.jrs);
        parama.setTextPadding(0);
        parama.setGravity("center");
        int i = com.tencent.mm.plugin.appbrand.widget.e.d.jrt;
        parama.x(0, 0, i, i);
        parama.setTextColor(paramr.hPw.color);
        parama.setTextSize(paramr.hPw.hPx);
        parama.setText(paramr.hPw.content);
        parama.setTextPadding(paramr.hPw.padding);
        parama.setGravity(paramr.hPw.hfl);
        parama.x(paramr.hPw.hPy, paramr.hPw.borderWidth, paramr.hPw.borderColor, paramr.hPw.bgColor);
        parama.setX(paramr.hPw.x);
        parama.setY(paramr.hPw.y);
        parama.measure(0, 0);
        ((MarkerOptions)localObject3).anchor(parama.getAnchorX(), parama.getAnchorY());
        ((MarkerOptions)localObject3).markerView(parama);
        ((MarkerOptions)localObject3).visible(true);
        ((MarkerOptions)localObject3).tag(paramString + "#label");
        ((MarkerOptions)localObject3).zIndex(paramr.zIndex + 3);
        if ((!bo.isNullOrNil(paramr.buildingId)) && (!bo.isNullOrNil(paramr.floorName))) {
          ((MarkerOptions)localObject3).indoorInfo(new IndoorInfo(paramr.buildingId, paramr.floorName));
        }
        ((d)localObject2).hPc = this.hOi.getMap().addMarker((MarkerOptions)localObject3);
        a(paramString + "#label", (d)localObject2);
      }
      AppMethodBeat.o(51221);
      return;
      ab.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
    }
  }
  
  public final void a(String paramString, LinkedList<b.g> paramLinkedList, b.o paramo)
  {
    AppMethodBeat.i(51224);
    paramString = (d)Ch(paramString);
    if ((paramString == null) || (paramString.hPb == null))
    {
      ab.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      paramo.ei(false);
      AppMethodBeat.o(51224);
      return;
    }
    if (paramLinkedList.size() <= 0)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
      paramo.ei(false);
      AppMethodBeat.o(51224);
      return;
    }
    Object localObject = (b.g)paramLinkedList.get(0);
    ((b.g)localObject).hPj = paramString.hPb.getPosition().getLatitude();
    ((b.g)localObject).hPi = paramString.hPb.getPosition().getLongitude();
    int j = paramLinkedList.size();
    int i = 1;
    if (i < j)
    {
      localObject = (b.g)paramLinkedList.get(i - 1);
      b.g localg = (b.g)paramLinkedList.get(i);
      if (((b.g)localObject).rotate == 0.0F) {
        localg.hPi = ((b.g)localObject).longitude;
      }
      for (localg.hPj = ((b.g)localObject).latitude;; localg.hPj = paramString.hPb.getPosition().getLatitude())
      {
        i += 1;
        break;
        localg.hPi = paramString.hPb.getPosition().getLongitude();
      }
    }
    localObject = new c(paramLinkedList, paramString.hPb, this.hOi);
    paramo = new a.11(this, paramo);
    ((c)localObject).nC.addListener(paramo);
    m.runOnUiThread(new a.13(this, (c)localObject));
    if (paramString.hPc != null) {
      m.runOnUiThread(new a.14(this, new c(paramLinkedList, paramString.hPc, this.hOi)));
    }
    AppMethodBeat.o(51224);
  }
  
  public final boolean a(b.c paramc, b.m paramm, com.tencent.mm.plugin.appbrand.e.a parama)
  {
    AppMethodBeat.i(51213);
    if (bo.isNullOrNil(paramc.hPe))
    {
      AppMethodBeat.o(51213);
      return false;
    }
    Object localObject = parama.bB(paramc.hPe);
    if (localObject == null)
    {
      AppMethodBeat.o(51213);
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
      i = com.tencent.mm.plugin.appbrand.s.g.pO(((Bitmap)localObject).getHeight());
      if (paramc.width != 0) {
        break label217;
      }
    }
    label217:
    for (int j = com.tencent.mm.plugin.appbrand.s.g.pO(((Bitmap)localObject).getWidth());; j = paramc.width)
    {
      localObject = new FrameLayout.LayoutParams(j, i);
      ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
      boolean bool = paramc.hPf;
      paramc = paramc.data;
      parama.setOnTouchListener(new a.5(this, bool, parama));
      parama.setOnClickListener(new a.6(this, bool, paramm, paramc));
      m.runOnUiThread(new a.7(this, parama, (FrameLayout.LayoutParams)localObject));
      AppMethodBeat.o(51213);
      return true;
      i = paramc.height;
      break;
    }
  }
  
  public final boolean a(b.d arg1, com.tencent.mm.plugin.appbrand.e.a parama)
  {
    AppMethodBeat.i(51226);
    if (bo.isNullOrNil(???.hPe))
    {
      AppMethodBeat.o(51226);
      return false;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new LatLng(???.latitude, ???.longitude));
    parama = parama.bB(???.hPe);
    if ((parama != null) && (!parama.isRecycled())) {
      localMarkerOptions.icon(new BitmapDescriptor(parama));
    }
    localMarkerOptions.rotation(???.rotate);
    parama = this.hOi.getMap().addMarker(localMarkerOptions);
    synchronized (this.hOE)
    {
      this.hOE.add(new c(parama));
      AppMethodBeat.o(51226);
      return true;
    }
  }
  
  public final boolean a(b.w arg1)
  {
    AppMethodBeat.i(51228);
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.hPm.iterator();
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
    localObject1 = this.hOi.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.hOF)
    {
      this.hOF.add(localObject1);
      AppMethodBeat.o(51228);
      return true;
    }
  }
  
  public final void aDA()
  {
    AppMethodBeat.i(51212);
    m.runOnUiThread(new a.4(this));
    AppMethodBeat.o(51212);
  }
  
  public final void aDB()
  {
    AppMethodBeat.i(51214);
    Iterator localIterator = this.hOB.values().iterator();
    while (localIterator.hasNext()) {
      ((Polyline)localIterator.next()).remove();
    }
    this.hOB.clear();
    AppMethodBeat.o(51214);
  }
  
  public final void aDC()
  {
    AppMethodBeat.i(51219);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.hOD.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      locald.hPb.remove();
      if (locald.hPc != null)
      {
        if ((locald.hPc.getMarkerView() != null) && ((locald.hPc.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.e.d)locald.hPc.getMarkerView());
        }
        locald.hPc.remove();
      }
    }
    this.hOD.clear();
    AppMethodBeat.o(51219);
  }
  
  public final void aDD()
  {
    AppMethodBeat.i(51225);
    synchronized (this.hOE)
    {
      Iterator localIterator = this.hOE.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).hPb.remove();
      }
    }
    this.hOE.clear();
    AppMethodBeat.o(51225);
  }
  
  public final void aDE()
  {
    AppMethodBeat.i(51227);
    synchronized (this.hOF)
    {
      Iterator localIterator = this.hOF.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.hOF.clear();
    AppMethodBeat.o(51227);
  }
  
  public final b.x aDt()
  {
    AppMethodBeat.i(51185);
    Object localObject2 = this.hOi.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.i();
    ((b.i)localObject1).hPk = new b.h(((LatLngBounds)localObject2).getSouthwest().getLatitude(), ((LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.i)localObject1).hPl = new b.h(((LatLngBounds)localObject2).getNortheast().getLatitude(), ((LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.y();
    ((b.y)localObject2).hPG = ((b.i)localObject1);
    localObject1 = new b.x();
    ((b.x)localObject1).hPF = ((b.y)localObject2);
    AppMethodBeat.o(51185);
    return localObject1;
  }
  
  public final void aDu()
  {
    AppMethodBeat.i(51187);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.hOw = new a.3(this);
    if ((this.hOH != null) && (this.hOG))
    {
      this.hOw.run();
      this.hOw = null;
    }
    AppMethodBeat.o(51187);
  }
  
  public final float aDv()
  {
    AppMethodBeat.i(51192);
    if (this.hOp != null)
    {
      float f = this.hOp.getBearing();
      AppMethodBeat.o(51192);
      return f;
    }
    ab.e("MicroMsg.DefaultTencentMapView", "getRotate fail, curCameraPosition is null");
    AppMethodBeat.o(51192);
    return 0.0F;
  }
  
  public final b.e aDw()
  {
    AppMethodBeat.i(51204);
    if (this.hOy != null)
    {
      locale = this.hOy;
      AppMethodBeat.o(51204);
      return locale;
    }
    b.e locale = aDq();
    AppMethodBeat.o(51204);
    return locale;
  }
  
  public boolean aDx()
  {
    return false;
  }
  
  public final b.h aDy()
  {
    AppMethodBeat.i(51207);
    Object localObject = this.hOi.getMap().getMapCenter();
    localObject = new b.h(((LatLng)localObject).getLatitude(), ((LatLng)localObject).getLongitude());
    AppMethodBeat.o(51207);
    return localObject;
  }
  
  public final void aDz()
  {
    AppMethodBeat.i(51210);
    synchronized (this.hOz)
    {
      Iterator localIterator = this.hOz.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.hOz.clear();
    AppMethodBeat.o(51210);
  }
  
  public final void ar(float paramFloat)
  {
    AppMethodBeat.i(51188);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s zoomTo scale:%f", new Object[] { this, Float.valueOf(paramFloat) });
    TencentMap localTencentMap = this.hOi.getMap();
    if (localTencentMap != null) {
      localTencentMap.animateCamera(CameraUpdateFactory.zoomTo(paramFloat));
    }
    AppMethodBeat.o(51188);
  }
  
  public final void as(float paramFloat)
  {
    AppMethodBeat.i(51189);
    TencentMap localTencentMap = this.hOi.getMap();
    if ((localTencentMap != null) && (this.hOp != null)) {
      localTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(this.hOp).skew(this.hOp.getSkew()).bearing(paramFloat).build()));
    }
    AppMethodBeat.o(51189);
  }
  
  public final void at(float paramFloat)
  {
    AppMethodBeat.i(51190);
    TencentMap localTencentMap = this.hOi.getMap();
    if ((localTencentMap != null) && (this.hOp != null)) {
      localTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(this.hOp).skew(paramFloat).bearing(this.hOp.getBearing()).build()));
    }
    AppMethodBeat.o(51190);
  }
  
  public final void ck(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51203);
    this.hOi.getMap().setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(51203);
  }
  
  public final void ej(boolean paramBoolean)
  {
    AppMethodBeat.i(51194);
    this.hOi.getUiSettings().setZoomGesturesEnabled(paramBoolean);
    AppMethodBeat.o(51194);
  }
  
  public final void ek(boolean paramBoolean)
  {
    AppMethodBeat.i(51195);
    this.hOi.getUiSettings().setScrollGesturesEnabled(paramBoolean);
    AppMethodBeat.o(51195);
  }
  
  public final void el(boolean paramBoolean)
  {
    AppMethodBeat.i(51196);
    this.hOi.getUiSettings().setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(51196);
  }
  
  public final void em(boolean paramBoolean)
  {
    AppMethodBeat.i(51197);
    this.hOi.getUiSettings().setCompassEnabled(paramBoolean);
    AppMethodBeat.o(51197);
  }
  
  public final void en(boolean paramBoolean)
  {
    AppMethodBeat.i(51198);
    this.hOi.getMap().set3DEnable(paramBoolean);
    AppMethodBeat.o(51198);
  }
  
  public final void eo(boolean paramBoolean)
  {
    AppMethodBeat.i(51199);
    this.hOi.getUiSettings().setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(51199);
  }
  
  public final void ep(boolean paramBoolean)
  {
    AppMethodBeat.i(51200);
    this.hOi.getMap().setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(51200);
  }
  
  public final void eq(boolean paramBoolean)
  {
    AppMethodBeat.i(51201);
    this.hOi.getMap().setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(51201);
  }
  
  public final void er(boolean paramBoolean)
  {
    AppMethodBeat.i(51202);
    this.hOi.getMap().setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(51202);
  }
  
  public final void es(boolean paramBoolean)
  {
    AppMethodBeat.i(51205);
    this.hOi.getUiSettings().setIndoorLevelPickerEnabled(paramBoolean);
    AppMethodBeat.o(51205);
  }
  
  public final void et(boolean paramBoolean)
  {
    AppMethodBeat.i(146052);
    this.hOi.getUiSettings().setScaleControlsEnabled(paramBoolean);
    AppMethodBeat.o(146052);
  }
  
  public final void eu(boolean paramBoolean)
  {
    AppMethodBeat.i(51229);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.hOG = paramBoolean;
    d locald;
    if (paramBoolean)
    {
      if (this.hOH != null)
      {
        locald = this.hOH;
        if (locald.hPb != null) {
          locald.hPb.setVisible(true);
        }
      }
      ((com.tencent.mm.plugin.appbrand.t.b.a)e.q(com.tencent.mm.plugin.appbrand.t.b.a.class)).b("gcj02", this.hOI, aDF());
      g.a(this);
      AppMethodBeat.o(51229);
      return;
    }
    if (this.hOH != null)
    {
      locald = this.hOH;
      if (locald.hPb != null) {
        locald.hPb.setVisible(false);
      }
    }
    ((com.tencent.mm.plugin.appbrand.t.b.a)e.q(com.tencent.mm.plugin.appbrand.t.b.a.class)).c("gcj02", this.hOI, aDF());
    g.b(this);
    AppMethodBeat.o(51229);
  }
  
  public void g(SurfaceTexture paramSurfaceTexture) {}
  
  public final float getSkew()
  {
    AppMethodBeat.i(51193);
    if (this.hOp != null)
    {
      float f = this.hOp.getSkew();
      AppMethodBeat.o(51193);
      return f;
    }
    ab.e("MicroMsg.DefaultTencentMapView", "getRotate fail, curCameraPosition is null");
    AppMethodBeat.o(51193);
    return 0.0F;
  }
  
  public final View getView()
  {
    return this.hOh;
  }
  
  public final int getZoomLevel()
  {
    AppMethodBeat.i(51191);
    int i = this.hOi.getMap().getZoomLevel();
    AppMethodBeat.o(51191);
    return i;
  }
  
  public final void h(List<b.h> paramList, int paramInt)
  {
    AppMethodBeat.i(51208);
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.h localh = (b.h)paramList.next();
      localLinkedList.add(new LatLng(localh.latitude, localh.longitude));
    }
    localBuilder.include(localLinkedList);
    this.hOi.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.hOw = null;
    AppMethodBeat.o(51208);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51184);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.hOL.set(true);
    this.hOi.getMap().setOnMapCameraChangeListener(null);
    aDC();
    aDB();
    aDB();
    aDA();
    aDD();
    aDE();
    if (this.hOi != null)
    {
      this.hOi.clean();
      this.hOi.onDestroy();
    }
    if (this.hOH != null)
    {
      d locald = this.hOH;
      if (locald.hPb != null)
      {
        locald.hPb.remove();
        locald.hPb = null;
      }
      this.hOH = null;
    }
    AppMethodBeat.o(51184);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51181);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.cuM.setVisibility(0);
      if (this.hOq == null) {
        this.hOq = aDr();
      }
      if (this.hOq != null)
      {
        al.p(this.hOr, 100L);
        this.hOi.setVisibility(4);
        this.hOi.getMap().getScreenShot(new a.21(this));
      }
    }
    for (;;)
    {
      this.isBackground = true;
      if (this.hOG)
      {
        ((com.tencent.mm.plugin.appbrand.t.b.a)e.q(com.tencent.mm.plugin.appbrand.t.b.a.class)).c("gcj02", this.hOI, aDF());
        g.b(this);
      }
      AppMethodBeat.o(51181);
      return;
      ab.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
      break;
      this.hOi.onPause();
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51180);
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    if (this.mMapType == 0)
    {
      this.cuM.setVisibility(4);
      this.hOi.setVisibility(0);
      this.hOi.onResume();
      aDs();
    }
    for (;;)
    {
      this.isBackground = false;
      if (this.hOG)
      {
        ((com.tencent.mm.plugin.appbrand.t.b.a)e.q(com.tencent.mm.plugin.appbrand.t.b.a.class)).b("gcj02", this.hOI, aDF());
        g.a(this);
      }
      AppMethodBeat.o(51180);
      return;
      this.hOi.onResume();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2) {}
  
  public void onTouchEvent(MotionEvent paramMotionEvent) {}
  
  public String toString()
  {
    AppMethodBeat.i(51232);
    String str = "DefaultTencentMapView{mapId=" + this.hOg + '}';
    AppMethodBeat.o(51232);
    return str;
  }
  
  public final class c
  {
    Marker hPb;
    
    public c(Marker paramMarker)
    {
      this.hPb = paramMarker;
    }
  }
  
  public static final class d
    extends b.q
  {
    public Marker hPb;
    public Marker hPc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a
 * JD-Core Version:    0.7.0.1
 */