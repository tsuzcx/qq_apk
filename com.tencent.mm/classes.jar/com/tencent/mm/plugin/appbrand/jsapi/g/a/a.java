package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
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
import org.json.JSONObject;

public final class a
  implements b
{
  private String appId;
  ImageView bNu;
  Context context;
  b.l gtA;
  private String gtB;
  private String gtC;
  private int gtD;
  SurfaceView gtE;
  private Runnable gtF = new a.19(this);
  b.j gtG;
  b.r gtH;
  boolean gtI = false;
  Runnable gtJ;
  public ArrayList<Circle> gtK = new ArrayList();
  public ArrayList<a.b> gtL = new ArrayList();
  public ArrayList<Polyline> gtM = new ArrayList();
  private a.a gtN = new a.a(this);
  Map<String, a.d> gtO = new ConcurrentHashMap();
  public ArrayList<a.c> gtP = new ArrayList();
  public ArrayList<Polygon> gtQ = new ArrayList();
  boolean gtR;
  d gtS;
  private final int gtT = 500;
  AtomicBoolean gtU = new AtomicBoolean(false);
  private AtomicBoolean gtV = new AtomicBoolean(false);
  private String gtw;
  private FrameLayout gtx;
  final SoSoMapView gty;
  b.i gtz;
  private boolean isBackground;
  private long lastCheckTime = 0L;
  private int mapId;
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt, JSONObject paramJSONObject)
  {
    this.context = paramContext;
    this.appId = paramString1;
    this.gtw = paramString2;
    this.mapId = paramInt;
    this.gtx = new FrameLayout(paramContext);
    paramString1 = new FrameLayout.LayoutParams(-1, -1);
    this.gtx.setBackgroundColor(0);
    this.gtx.setLayoutParams(paramString1);
    paramString1 = new TencentMapOptions();
    paramString2 = paramJSONObject.optString("theme", "normal");
    boolean bool = paramString2.equals("handDraw");
    paramString1.enableHandDrawMap(bool);
    if (paramJSONObject.optBoolean("isVector", true)) {
      paramString1.setMapType(1);
    }
    for (;;)
    {
      this.gtB = paramJSONObject.optString("subKey", "");
      this.gtC = this.appId;
      if (bk.bl(this.gtB))
      {
        this.gtB = "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX";
        this.gtC = "";
      }
      paramString1.setSubInfo(this.gtB, this.gtC);
      this.gtD = paramJSONObject.optInt("styleId", 0);
      y.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", new Object[] { this.gtC, this.gtB });
      y.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]isHandDraw:%b, isVector:%b, subId:%s, subKey:%s, styleId:%d", new Object[] { paramString2, Boolean.valueOf(bool), this.gtC, this.gtB, Integer.valueOf(this.gtD) });
      this.gty = new SoSoMapView(paramContext, paramString1);
      this.gtx.addView(this.gty, new FrameLayout.LayoutParams(-1, -1));
      this.bNu = new ImageView(paramContext);
      this.bNu.setScaleType(ImageView.ScaleType.FIT_XY);
      this.gtx.addView(this.bNu, new ViewGroup.LayoutParams(-1, -1));
      y.i("MicroMsg.DefaultTencentMapView", "map:%s, init", new Object[] { this });
      this.gty.getMap().setInfoWindowAdapter(this.gtN);
      this.gty.getMap().setMapAnchor(0.5F, 0.5F);
      this.gty.getMap().enableMultipleInfowindow(true);
      this.gty.getMap().setMapStyle(this.gtD);
      this.gty.getMap().setOnInfoWindowClickListener(new a.1(this));
      this.gty.getMap().setOnMarkerClickListener(new a.12(this));
      this.gty.getMap().setOnMapClickListener(new a.15(this));
      this.gty.getMap().setOnMapLoadedListener(new a.16(this));
      this.gty.getMap().setOnMapPoiClickListener(new a.17(this));
      return;
      paramString1.setMapType(0);
    }
  }
  
  static void a(float paramFloat1, float paramFloat2, Bitmap paramBitmap, ImageView paramImageView)
  {
    float f;
    if (paramFloat1 != 0.0F)
    {
      f = paramFloat1;
      paramFloat1 = paramFloat2;
      if (paramFloat2 != 0.0F) {}
    }
    else
    {
      f = h.my(paramBitmap.getWidth());
      paramFloat1 = h.my(paramBitmap.getHeight());
    }
    if ((f > 0.0F) && (paramFloat1 > 0.0F) && ((f != paramBitmap.getWidth()) || (paramFloat1 != paramBitmap.getHeight())))
    {
      paramFloat2 = f / paramBitmap.getWidth();
      paramFloat1 /= paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat2, paramFloat1);
      paramImageView.setImageBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true));
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
    paramImageView.setScaleType(ImageView.ScaleType.CENTER);
  }
  
  private void a(String paramString, a.d paramd)
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    this.gtO.put(paramString, paramd);
  }
  
  private SurfaceView ajh()
  {
    if (this.gtE != null) {
      return this.gtE;
    }
    Object localObject = this.gty;
    if ((localObject == null) || (((ViewGroup)localObject).getChildCount() == 0)) {
      localObject = null;
    }
    for (;;)
    {
      label30:
      this.gtE = ((SurfaceView)localObject);
      return this.gtE;
      int j = ((ViewGroup)localObject).getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label100;
        }
        View localView = ((ViewGroup)localObject).getChildAt(i);
        if ((localView instanceof SurfaceView))
        {
          localObject = (SurfaceView)localView;
          break label30;
        }
        if ((localView instanceof ViewGroup))
        {
          localObject = (ViewGroup)localView;
          break;
        }
        i += 1;
      }
      label100:
      localObject = null;
    }
  }
  
  public final void F(float paramFloat1, float paramFloat2)
  {
    this.gty.getIController().setCenter(paramFloat1, paramFloat2);
  }
  
  public final void G(float paramFloat1, float paramFloat2)
  {
    if ((!this.gtR) || (this.isBackground)) {}
    while (this.gtS == null) {
      return;
    }
    this.gtS.G(paramFloat1, paramFloat2);
  }
  
  public final void a(double paramDouble1, double paramDouble2, String paramString, double paramDouble3)
  {
    if ((!this.gtR) || (this.isBackground)) {
      return;
    }
    n.runOnUiThread(new a.13(this, paramDouble1, paramDouble2, paramString, paramDouble3));
  }
  
  public final void a(b.b arg1)
  {
    Object localObject1 = new CircleOptions();
    ((CircleOptions)localObject1).center(new LatLng(???.latitude, ???.longitude));
    ((CircleOptions)localObject1).radius(???.radius);
    ((CircleOptions)localObject1).strokeColor(???.strokeColor);
    ((CircleOptions)localObject1).strokeWidth(???.strokeWidth);
    ((CircleOptions)localObject1).fillColor(???.fillColor);
    localObject1 = this.gty.getMap().addCircle((CircleOptions)localObject1);
    synchronized (this.gtK)
    {
      this.gtK.add(localObject1);
      return;
    }
  }
  
  public final void a(b.h arg1)
  {
    Object localObject1 = new PolylineOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.gus.iterator();
    while (localIterator.hasNext())
    {
      b.f localf = (b.f)localIterator.next();
      localArrayList.add(new LatLng(localf.latitude, localf.longitude));
    }
    ((PolylineOptions)localObject1).addAll(localArrayList);
    ((PolylineOptions)localObject1).color(???.color);
    ((PolylineOptions)localObject1).width(???.width);
    ((PolylineOptions)localObject1).setDottedLine(???.gut);
    ((PolylineOptions)localObject1).edgeColor(???.guu);
    ((PolylineOptions)localObject1).edgeWidth(???.borderWidth);
    if (???.guv)
    {
      ??? = ((com.tencent.mm.plugin.appbrand.d.a)com.tencent.luggage.b.e.i(com.tencent.mm.plugin.appbrand.d.a.class)).ba(???.guw);
      ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(???));
      if (??? == null) {
        ((PolylineOptions)localObject1).arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), com.tencent.luggage.h.a.a.app_brand_map_line_texture_arrow)));
      }
    }
    ((PolylineOptions)localObject1).zIndex(1.0F);
    localObject1 = this.gty.getMap().addPolyline((PolylineOptions)localObject1);
    if (localObject1 == null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
      return;
    }
    synchronized (this.gtM)
    {
      this.gtM.add(localObject1);
      return;
    }
  }
  
  public final void a(b.i parami)
  {
    this.gtz = parami;
  }
  
  public final void a(b.j paramj)
  {
    this.gtG = paramj;
  }
  
  public final void a(b.l paraml)
  {
    this.gtA = paraml;
  }
  
  public final void a(b.q paramq)
  {
    this.gty.getMap().setTencentMapGestureListener(new a.21(this));
    this.gty.getMap().setOnMapCameraChangeListener(new a.2(this, paramq));
  }
  
  public final void a(b.r paramr)
  {
    this.gtH = paramr;
  }
  
  public final void a(String paramString, b.p paramp)
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", new Object[] { this, paramString });
    Object localObject1 = new MarkerOptions();
    ((MarkerOptions)localObject1).position(new LatLng(paramp.latitude, paramp.longitude));
    if (!bk.bl(paramp.title)) {
      ((MarkerOptions)localObject1).title(paramp.title);
    }
    ((MarkerOptions)localObject1).rotation(paramp.rotate);
    ((MarkerOptions)localObject1).alpha(paramp.alpha);
    Object localObject2 = (FrameLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(com.tencent.luggage.h.a.c.default_tencent_map_marker_icon, null);
    Object localObject3 = (ImageView)((FrameLayout)localObject2).findViewById(com.tencent.luggage.h.a.b.marker_icon);
    float f1 = paramp.guy;
    float f2 = paramp.guz;
    Object localObject4 = ((com.tencent.mm.plugin.appbrand.d.a)com.tencent.luggage.b.e.i(com.tencent.mm.plugin.appbrand.d.a.class)).a(paramp.gum, null, new a.6(this, f1, f2, (ImageView)localObject3));
    if (localObject4 != null) {
      a(f1, f2, (Bitmap)localObject4, (ImageView)localObject3);
    }
    for (;;)
    {
      ((MarkerOptions)localObject1).markerView((View)localObject2);
      ((MarkerOptions)localObject1).anchor(paramp.aWt, paramp.aWu);
      ((MarkerOptions)localObject1).tag(paramString);
      ((MarkerOptions)localObject1).infoWindowHideAnimation(new Animation() {});
      ((MarkerOptions)localObject1).infoWindowShowAnimation(new a.8(this));
      ((MarkerOptions)localObject1).visible(true);
      ((MarkerOptions)localObject1).zIndex(paramp.zIndex + 2);
      localObject1 = this.gty.getMap().addMarker((MarkerOptions)localObject1);
      localObject3 = new a.d();
      ((a.d)localObject3).guj = ((Marker)localObject1);
      ((a.d)localObject3).data = paramp.data;
      ((a.d)localObject3).gux = paramp;
      a(paramString, (a.d)localObject3);
      if ((paramp.guA != null) && (paramp.guA.guH == b.p.a.guJ)) {
        ((a.d)localObject3).guj.showInfoWindow();
      }
      if (paramp.guB != null)
      {
        localObject4 = new MarkerOptions();
        ((MarkerOptions)localObject4).position(new LatLng(paramp.latitude, paramp.longitude));
        ((MarkerOptions)localObject4).alpha(paramp.alpha);
        localObject2 = i.ajt();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new com.tencent.mm.plugin.appbrand.widget.d.e(this.context);
        }
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setText("");
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setTextSize(12);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setTextColor(com.tencent.mm.plugin.appbrand.widget.d.e.hzp);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setTextPadding(0);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setGravity("center");
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).p(0, 0, com.tencent.mm.plugin.appbrand.widget.d.e.hzq, com.tencent.mm.plugin.appbrand.widget.d.e.hzq);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setTextColor(paramp.guB.color);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setTextSize(paramp.guB.guC);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setText(paramp.guB.content);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setTextPadding(paramp.guB.padding);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setGravity(paramp.guB.fMb);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).p(paramp.guB.guD, paramp.guB.borderWidth, paramp.guB.guu, paramp.guB.bgColor);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setX(paramp.guB.x);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).setY(paramp.guB.y);
        ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).measure(0, 0);
        ((MarkerOptions)localObject4).anchor(((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).getAnchorX(), ((com.tencent.mm.plugin.appbrand.widget.d.e)localObject1).getAnchorY());
        ((MarkerOptions)localObject4).markerView((View)localObject1);
        ((MarkerOptions)localObject4).visible(true);
        ((MarkerOptions)localObject4).tag(paramString + "#label");
        ((MarkerOptions)localObject4).zIndex(paramp.zIndex + 2);
        ((a.d)localObject3).guk = this.gty.getMap().addMarker((MarkerOptions)localObject4);
        a(paramString + "#label", (a.d)localObject3);
      }
      return;
      y.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
    }
  }
  
  public final void a(String paramString, LinkedList<b.e> paramLinkedList, b.m paramm)
  {
    paramString = (a.d)ug(paramString);
    if ((paramString == null) || (paramString.guj == null))
    {
      y.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
      paramm.df(false);
    }
    do
    {
      return;
      if (paramLinkedList.size() <= 0)
      {
        y.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
        paramm.df(false);
        return;
      }
      Object localObject = (b.e)paramLinkedList.get(0);
      ((b.e)localObject).gup = paramString.guj.getPosition().getLatitude();
      ((b.e)localObject).guo = paramString.guj.getPosition().getLongitude();
      int j = paramLinkedList.size();
      int i = 1;
      if (i < j)
      {
        localObject = (b.e)paramLinkedList.get(i - 1);
        b.e locale = (b.e)paramLinkedList.get(i);
        if (((b.e)localObject).rotate == 0.0F) {
          locale.guo = ((b.e)localObject).longitude;
        }
        for (locale.gup = ((b.e)localObject).latitude;; locale.gup = paramString.guj.getPosition().getLatitude())
        {
          i += 1;
          break;
          locale.guo = paramString.guj.getPosition().getLongitude();
        }
      }
      localObject = new com.tencent.mm.plugin.appbrand.widget.d.d(paramLinkedList, paramString.guj, this.gty);
      paramm = new a.9(this, paramm);
      ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject).mF.addListener(paramm);
      n.runOnUiThread(new a.10(this, (com.tencent.mm.plugin.appbrand.widget.d.d)localObject));
    } while (paramString.guk == null);
    n.runOnUiThread(new a.11(this, new com.tencent.mm.plugin.appbrand.widget.d.d(paramLinkedList, paramString.guk, this.gty)));
  }
  
  public final boolean a(b.c paramc)
  {
    return a(paramc, null);
  }
  
  public final boolean a(b.c arg1, b.k paramk)
  {
    if (??? == null) {
      return false;
    }
    if (bk.bl(???.gum)) {
      return false;
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.d.a)com.tencent.luggage.b.e.i(com.tencent.mm.plugin.appbrand.d.a.class)).ba(???.gum);
    if (localObject == null) {
      return false;
    }
    ImageView localImageView = new ImageView(this.context);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageBitmap((Bitmap)localObject);
    int k = ???.left;
    int m = ???.top;
    int i;
    if (???.height == 0) {
      i = h.my(((Bitmap)localObject).getHeight());
    }
    for (;;)
    {
      int j;
      if (???.width == 0)
      {
        j = h.my(((Bitmap)localObject).getWidth());
        localObject = new FrameLayout.LayoutParams(j, i);
        ((FrameLayout.LayoutParams)localObject).setMargins(k, m, 0, 0);
        boolean bool = ???.gun;
        ??? = ???.data;
        localImageView.setOnTouchListener(new a.4(this, bool, localImageView));
        localImageView.setOnClickListener(new a.5(this, bool, paramk, ???));
        ((ViewGroup)this.gtx).addView(localImageView, (ViewGroup.LayoutParams)localObject);
      }
      synchronized (this.gtL)
      {
        this.gtL.add(new a.b(this, localImageView));
        return true;
        i = ???.height;
        continue;
        j = ???.width;
      }
    }
  }
  
  public final boolean a(b.d arg1)
  {
    if (bk.bl(???.gum)) {
      return false;
    }
    Object localObject1 = new MarkerOptions();
    ((MarkerOptions)localObject1).position(new LatLng(???.latitude, ???.longitude));
    Bitmap localBitmap = ((com.tencent.mm.plugin.appbrand.d.a)com.tencent.luggage.b.e.i(com.tencent.mm.plugin.appbrand.d.a.class)).ba(???.gum);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      ((MarkerOptions)localObject1).icon(new BitmapDescriptor(localBitmap));
    }
    ((MarkerOptions)localObject1).rotation(???.rotate);
    localObject1 = this.gty.getMap().addMarker((MarkerOptions)localObject1);
    synchronized (this.gtP)
    {
      this.gtP.add(new a.c(this, (Marker)localObject1));
      return true;
    }
  }
  
  public final boolean a(b.s arg1)
  {
    Object localObject1 = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ???.gus.iterator();
    while (localIterator.hasNext())
    {
      b.f localf = (b.f)localIterator.next();
      localArrayList.add(new LatLng(localf.latitude, localf.longitude));
    }
    ((PolygonOptions)localObject1).addAll(localArrayList);
    ((PolygonOptions)localObject1).fillColor(???.fillColor);
    ((PolygonOptions)localObject1).strokeColor(???.strokeColor);
    ((PolygonOptions)localObject1).strokeWidth(???.strokeWidth);
    ((PolygonOptions)localObject1).zIndex(???.zIndex);
    localObject1 = this.gty.getMap().addPolygon((PolygonOptions)localObject1);
    synchronized (this.gtQ)
    {
      this.gtQ.add(localObject1);
      return true;
    }
  }
  
  public final void ajg()
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", new Object[] { this });
    this.gty.onCreate(null);
  }
  
  public final b.t aji()
  {
    Object localObject2 = this.gty.getProjection().getVisibleRegion().getLatLngBounds();
    Object localObject1 = new b.g();
    ((b.g)localObject1).guq = new b.f(((LatLngBounds)localObject2).getSouthwest().getLatitude(), ((LatLngBounds)localObject2).getSouthwest().getLongitude());
    ((b.g)localObject1).gur = new b.f(((LatLngBounds)localObject2).getNortheast().getLatitude(), ((LatLngBounds)localObject2).getNortheast().getLongitude());
    localObject2 = new b.u();
    ((b.u)localObject2).guL = ((b.g)localObject1);
    localObject1 = new b.t();
    ((b.t)localObject1).guK = ((b.u)localObject2);
    return localObject1;
  }
  
  public final void ajj()
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", new Object[] { this });
    this.gtJ = new a.3(this);
    if ((this.gtS != null) && (this.gtR))
    {
      this.gtJ.run();
      this.gtJ = null;
    }
  }
  
  public final b.f ajk()
  {
    LatLng localLatLng = this.gty.getMap().getMapCenter();
    return new b.f(localLatLng.getLatitude(), localLatLng.getLongitude());
  }
  
  public final void ajl()
  {
    synchronized (this.gtK)
    {
      Iterator localIterator = this.gtK.iterator();
      if (localIterator.hasNext()) {
        ((Circle)localIterator.next()).remove();
      }
    }
    this.gtK.clear();
  }
  
  public final void ajm()
  {
    ViewGroup localViewGroup = (ViewGroup)this.gtx;
    synchronized (this.gtL)
    {
      Iterator localIterator = this.gtL.iterator();
      if (localIterator.hasNext()) {
        localViewGroup.removeView(((a.b)localIterator.next()).gui);
      }
    }
    this.gtL.clear();
  }
  
  public final void ajn()
  {
    synchronized (this.gtM)
    {
      Iterator localIterator = this.gtM.iterator();
      if (localIterator.hasNext()) {
        ((Polyline)localIterator.next()).remove();
      }
    }
    this.gtM.clear();
  }
  
  public final void ajo()
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", new Object[] { this });
    Iterator localIterator = this.gtO.values().iterator();
    while (localIterator.hasNext())
    {
      a.d locald = (a.d)localIterator.next();
      locald.guj.remove();
      if (locald.guk != null)
      {
        if ((locald.guk.getMarkerView() != null) && ((locald.guk.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.e))) {
          i.a((com.tencent.mm.plugin.appbrand.widget.d.e)locald.guk.getMarkerView());
        }
        locald.guk.remove();
      }
    }
    this.gtO.clear();
  }
  
  public final void ajp()
  {
    synchronized (this.gtP)
    {
      Iterator localIterator = this.gtP.iterator();
      if (localIterator.hasNext()) {
        ((a.c)localIterator.next()).guj.remove();
      }
    }
    this.gtP.clear();
  }
  
  public final void ajq()
  {
    synchronized (this.gtQ)
    {
      Iterator localIterator = this.gtQ.iterator();
      if (localIterator.hasNext()) {
        ((Polygon)localIterator.next()).remove();
      }
    }
    this.gtQ.clear();
  }
  
  public final void c(float paramFloat1, float paramFloat2, int paramInt)
  {
    TencentMap localTencentMap = this.gty.getMap();
    if (localTencentMap != null)
    {
      localTencentMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(paramFloat1, paramFloat2), paramInt));
      this.gtJ = null;
    }
  }
  
  public final void dg(boolean paramBoolean)
  {
    this.gty.getUiSettings().setZoomGesturesEnabled(paramBoolean);
  }
  
  public final void dh(boolean paramBoolean)
  {
    this.gty.getUiSettings().setScrollGesturesEnabled(paramBoolean);
  }
  
  public final void di(boolean paramBoolean)
  {
    this.gty.getUiSettings().setRotateGesturesEnabled(paramBoolean);
  }
  
  public final void dj(boolean paramBoolean)
  {
    this.gty.getUiSettings().setCompassEnabled(paramBoolean);
  }
  
  public final void dk(boolean paramBoolean)
  {
    this.gty.getMap().set3DEnable(paramBoolean);
  }
  
  public final void dl(boolean paramBoolean)
  {
    this.gty.getUiSettings().setTiltGesturesEnabled(paramBoolean);
  }
  
  public final void dm(boolean paramBoolean)
  {
    this.gty.getMap().setSatelliteEnabled(paramBoolean);
  }
  
  public final void dn(boolean paramBoolean)
  {
    this.gty.getMap().setTrafficEnabled(paramBoolean);
  }
  
  public final void jdMethod_do(boolean paramBoolean)
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s show location", new Object[] { this });
    this.gtR = paramBoolean;
    if (paramBoolean)
    {
      f.a(this);
      return;
    }
    f.b(this);
  }
  
  public final void e(List<b.f> paramList, int paramInt)
  {
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.f localf = (b.f)paramList.next();
      localLinkedList.add(new LatLng(localf.latitude, localf.longitude));
    }
    localBuilder.include(localLinkedList);
    this.gty.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    this.gtJ = null;
  }
  
  public final View getView()
  {
    return this.gtx;
  }
  
  public final int getZoomLevel()
  {
    return this.gty.getMap().getZoomLevel();
  }
  
  public final void lv(int paramInt)
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s zoomTo scale:%d", new Object[] { this, Integer.valueOf(paramInt) });
    TencentMap localTencentMap = this.gty.getMap();
    if (localTencentMap != null) {
      localTencentMap.animateCamera(CameraUpdateFactory.zoomTo(paramInt));
    }
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", new Object[] { this });
    this.gtV.set(true);
    this.gty.getMap().setOnMapCameraChangeListener(null);
    ajo();
    ajn();
    ajn();
    ajm();
    ajp();
    ajq();
    ai.d(new a.20(this));
    if (this.gtS != null)
    {
      d locald = this.gtS;
      if (locald.guj != null)
      {
        locald.guj.remove();
        locald.guj = null;
      }
    }
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", new Object[] { this });
    this.bNu.setVisibility(0);
    if (this.gtE == null) {
      this.gtE = ajh();
    }
    if (this.gtE != null) {
      ai.l(this.gtF, 100L);
    }
    for (;;)
    {
      this.gty.setVisibility(4);
      this.gty.getMap().getScreenShot(new a.18(this));
      this.isBackground = true;
      return;
      y.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
    }
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", new Object[] { this });
    this.bNu.setVisibility(4);
    this.gty.setVisibility(0);
    this.gty.onResume();
    if (this.gtE == null) {
      this.gtE = ajh();
    }
    if (this.gtE != null)
    {
      ai.S(this.gtF);
      this.gtE.setVisibility(0);
    }
    for (;;)
    {
      this.isBackground = false;
      return;
      y.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
    }
  }
  
  public final String toString()
  {
    return "DefaultTencentMapView{appId='" + this.appId + '\'' + ", componentId='" + this.gtw + '\'' + ", mapId=" + this.mapId + '}';
  }
  
  public final b.o ug(String paramString)
  {
    return (b.o)this.gtO.get(paramString);
  }
  
  public final void uh(String paramString)
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", new Object[] { this, paramString });
    a.d locald = (a.d)this.gtO.get(paramString);
    if (locald == null)
    {
      y.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", new Object[] { paramString });
      return;
    }
    locald.guj.remove();
    if (locald.guk != null)
    {
      if ((locald.guk.getMarkerView() != null) && ((locald.guk.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.d.e))) {
        i.a((com.tencent.mm.plugin.appbrand.widget.d.e)locald.guk.getMarkerView());
      }
      locald.guk.remove();
      this.gtO.remove(paramString + "#label");
    }
    this.gtO.remove(paramString);
  }
  
  public final void x(Bundle paramBundle)
  {
    if (!"E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX".equals(this.gtB))
    {
      String str = bk.pm(paramBundle.getString("smallAppKey"));
      paramBundle.putString("smallAppKey", str + this.gtB + "#" + this.gtC + ";");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a
 * JD-Core Version:    0.7.0.1
 */