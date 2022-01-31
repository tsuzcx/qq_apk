package com.tencent.mm.plugin.location_soso.api;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.k.e;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SoSoMapView
  extends MapView
  implements d
{
  public static final String TAG = "MicroMsg.SoSoMapView";
  private boolean firstanim;
  private b iController;
  private ViewManager mViewManager;
  private HashMap<String, Object> tagsView;
  
  public SoSoMapView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51299);
    this.tagsView = new HashMap();
    this.firstanim = true;
    init();
    AppMethodBeat.o(51299);
  }
  
  public SoSoMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51300);
    this.tagsView = new HashMap();
    this.firstanim = true;
    init();
    AppMethodBeat.o(51300);
  }
  
  public SoSoMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    AppMethodBeat.i(51301);
    this.tagsView = new HashMap();
    this.firstanim = true;
    init();
    AppMethodBeat.o(51301);
  }
  
  private void init()
  {
    AppMethodBeat.i(51304);
    this.mViewManager = new ViewManager(getMap());
    getMap().set3DEnable(true);
    this.iController = new SoSoMapView.1(this);
    AppMethodBeat.o(51304);
  }
  
  private void setEnableForeignMap(boolean paramBoolean)
  {
    AppMethodBeat.i(51303);
    try
    {
      Method localMethod = MapView.class.getDeclaredMethod("setForeignEnabled", new Class[] { Boolean.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(51303);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SoSoMapView", localException, "", new Object[0]);
      AppMethodBeat.o(51303);
    }
  }
  
  public void addAnimTrackView(View paramView, double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(51327);
    this.tagsView.put(paramString, paramView);
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
    AppMethodBeat.o(51327);
  }
  
  public void addLocationPin(View paramView)
  {
    AppMethodBeat.i(51320);
    addView(paramView, 0.0D, 0.0D);
    AppMethodBeat.o(51320);
  }
  
  public void addNullView(View paramView)
  {
    AppMethodBeat.i(51308);
    ab.d("MicroMsg.SoSoMapView", "addNullView ");
    addView(paramView);
    AppMethodBeat.o(51308);
  }
  
  public void addOverlay(Object paramObject) {}
  
  public void addPinView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51306);
    this.mViewManager.addPinView(paramView, paramDouble1, paramDouble2);
    AppMethodBeat.o(51306);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51305);
    this.mViewManager.addView(paramView, paramDouble1, paramDouble2);
    AppMethodBeat.o(51305);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(51332);
    new GeoPoint((int)(1000000.0D * paramDouble1), (int)(1000000.0D * paramDouble2));
    if (paramInt == -2)
    {
      addView(paramView, new MapView.LayoutParams(-2, -2, new LatLng(paramDouble1, paramDouble2), 17));
      AppMethodBeat.o(51332);
      return;
    }
    if (paramInt == -1)
    {
      addView(paramView, new MapView.LayoutParams(-1, -1, new LatLng(paramDouble1, paramDouble2), 17));
      AppMethodBeat.o(51332);
      return;
    }
    addView(paramView, new MapView.LayoutParams(paramInt, paramInt, new LatLng(paramDouble1, paramDouble2), 17));
    AppMethodBeat.o(51332);
  }
  
  public void addView(Object paramObject, double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(51313);
    this.tagsView.put(paramString, paramObject);
    AppMethodBeat.o(51313);
  }
  
  public void clean()
  {
    AppMethodBeat.i(51319);
    this.tagsView.clear();
    this.mViewManager.destroy();
    AppMethodBeat.o(51319);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(51330);
    this.mViewManager.destroy();
    AppMethodBeat.o(51330);
  }
  
  public Collection<Object> getChilds()
  {
    AppMethodBeat.i(51315);
    Collection localCollection = this.tagsView.values();
    AppMethodBeat.o(51315);
    return localCollection;
  }
  
  public MapController getController()
  {
    AppMethodBeat.i(51302);
    MapController localMapController = getMapController();
    AppMethodBeat.o(51302);
    return localMapController;
  }
  
  public b getIController()
  {
    return this.iController;
  }
  
  public int getMapCenterX()
  {
    AppMethodBeat.i(51309);
    if (getMapCenter() != null)
    {
      int i = (int)(getMapCenter().getLatitude() * 1000000.0D);
      AppMethodBeat.o(51309);
      return i;
    }
    AppMethodBeat.o(51309);
    return 0;
  }
  
  public int getMapCenterY()
  {
    AppMethodBeat.i(51310);
    if (getMapCenter() != null)
    {
      int i = (int)(getMapCenter().getLongitude() * 1000000.0D);
      AppMethodBeat.o(51310);
      return i;
    }
    AppMethodBeat.o(51310);
    return 0;
  }
  
  public Point getPointByGeoPoint(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51326);
    Point localPoint = new Point();
    getProjection().toPixels(new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D)), localPoint);
    AppMethodBeat.o(51326);
    return localPoint;
  }
  
  public Set<String> getTags()
  {
    AppMethodBeat.i(51317);
    Set localSet = this.tagsView.keySet();
    AppMethodBeat.o(51317);
    return localSet;
  }
  
  public Object getViewByItag(String paramString)
  {
    AppMethodBeat.i(51314);
    if (this.tagsView.containsKey(paramString))
    {
      paramString = this.tagsView.get(paramString);
      AppMethodBeat.o(51314);
      return paramString;
    }
    AppMethodBeat.o(51314);
    return null;
  }
  
  public e getViewManager()
  {
    return this.mViewManager;
  }
  
  public int getZoom()
  {
    AppMethodBeat.i(51324);
    int i = getZoomLevel();
    AppMethodBeat.o(51324);
    return i;
  }
  
  public int getZoomLevel()
  {
    AppMethodBeat.i(51307);
    TencentMap localTencentMap = getMap();
    if (localTencentMap == null)
    {
      AppMethodBeat.o(51307);
      return 16;
    }
    int i = localTencentMap.getZoomLevel();
    AppMethodBeat.o(51307);
    return i;
  }
  
  public float metersToEquatorPixels(double paramDouble)
  {
    AppMethodBeat.i(51329);
    float f = getProjection().metersToEquatorPixels((float)paramDouble);
    AppMethodBeat.o(51329);
    return f;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(51316);
    this.mViewManager.removeView(paramView);
    Iterator localIterator = this.tagsView.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.tagsView.get(str).equals(paramView))
      {
        this.tagsView.remove(str);
        AppMethodBeat.o(51316);
        return;
      }
    }
    AppMethodBeat.o(51316);
  }
  
  public Object removeViewByTag(String paramString)
  {
    AppMethodBeat.i(51318);
    paramString = this.tagsView.get(paramString);
    if ((paramString instanceof View)) {
      removeView((View)paramString);
    }
    AppMethodBeat.o(51318);
    return paramString;
  }
  
  public void requestMapFocus()
  {
    AppMethodBeat.i(51312);
    requestFocus();
    AppMethodBeat.o(51312);
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean) {}
  
  public void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(51331);
    getMap().setMapAnchor(paramFloat1, paramFloat2);
    AppMethodBeat.o(51331);
  }
  
  public void setMapViewOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(51325);
    setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(51325);
  }
  
  public void updateAnimViewLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51328);
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
    AppMethodBeat.o(51328);
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51322);
    ab.d("MicroMsg.SoSoMapView", "updateLocationPinLayout");
    updateLocaitonPinLayout(paramView, paramDouble1, paramDouble2, false);
    AppMethodBeat.o(51322);
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(51323);
    this.mViewManager.updateLocaitonPinLayout(paramView, paramDouble1, paramDouble2, paramBoolean);
    AppMethodBeat.o(51323);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51311);
    this.mViewManager.updateViewLayout(paramView, paramDouble1, paramDouble2, false);
    AppMethodBeat.o(51311);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(51333);
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
    AppMethodBeat.o(51333);
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(51321);
    getIController().setCenter(paramDouble1, paramDouble2);
    ab.d("MicroMsg.SoSoMapView", "zoomToSpan " + (int)(1000000.0D * paramDouble3) + " " + (int)(1000000.0D * paramDouble4) + "  " + 1000000.0D * paramDouble1 + " " + 1000000.0D * paramDouble2);
    if ((paramDouble3 == 0.0D) || (paramDouble4 == 0.0D))
    {
      AppMethodBeat.o(51321);
      return;
    }
    if (getController() != null) {
      getController().zoomToSpan(paramDouble3, paramDouble4);
    }
    AppMethodBeat.o(51321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.api.SoSoMapView
 * JD-Core Version:    0.7.0.1
 */