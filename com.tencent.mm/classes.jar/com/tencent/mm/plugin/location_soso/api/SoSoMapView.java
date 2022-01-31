package com.tencent.mm.plugin.location_soso.api;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.p.e;
import com.tencent.mm.sdk.platformtools.y;
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
  private boolean firstanim = true;
  private b iController;
  private ViewManager mViewManager;
  private HashMap<String, Object> tagsView = new HashMap();
  
  public SoSoMapView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SoSoMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SoSoMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    init();
  }
  
  private void init()
  {
    this.mViewManager = new ViewManager(getMap());
    getMap().set3DEnable(true);
    this.iController = new SoSoMapView.1(this);
  }
  
  private void setEnableForeignMap(boolean paramBoolean)
  {
    try
    {
      Method localMethod = MapView.class.getDeclaredMethod("setForeignEnabled", new Class[] { Boolean.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SoSoMapView", localException, "", new Object[0]);
    }
  }
  
  public void addAnimTrackView(View paramView, double paramDouble1, double paramDouble2, String paramString)
  {
    this.tagsView.put(paramString, paramView);
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
  }
  
  public void addLocationPin(View paramView)
  {
    addView(paramView, 0.0D, 0.0D);
  }
  
  public void addNullView(View paramView)
  {
    y.d("MicroMsg.SoSoMapView", "addNullView ");
    addView(paramView);
  }
  
  public void addOverlay(Object paramObject) {}
  
  public void addPinView(View paramView, double paramDouble1, double paramDouble2)
  {
    this.mViewManager.addPinView(paramView, paramDouble1, paramDouble2);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2)
  {
    this.mViewManager.addView(paramView, paramDouble1, paramDouble2);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2, int paramInt)
  {
    new GeoPoint((int)(1000000.0D * paramDouble1), (int)(1000000.0D * paramDouble2));
    if (paramInt == -2)
    {
      addView(paramView, new MapView.LayoutParams(-2, -2, new LatLng(paramDouble1, paramDouble2), 17));
      return;
    }
    if (paramInt == -1)
    {
      addView(paramView, new MapView.LayoutParams(-1, -1, new LatLng(paramDouble1, paramDouble2), 17));
      return;
    }
    addView(paramView, new MapView.LayoutParams(paramInt, paramInt, new LatLng(paramDouble1, paramDouble2), 17));
  }
  
  public void addView(Object paramObject, double paramDouble1, double paramDouble2, String paramString)
  {
    this.tagsView.put(paramString, paramObject);
  }
  
  public void clean()
  {
    this.tagsView.clear();
    this.mViewManager.destroy();
  }
  
  public void destroy()
  {
    this.mViewManager.destroy();
  }
  
  public Collection<Object> getChilds()
  {
    return this.tagsView.values();
  }
  
  public MapController getController()
  {
    return getMapController();
  }
  
  public b getIController()
  {
    return this.iController;
  }
  
  public int getMapCenterX()
  {
    if (getMapCenter() != null) {
      return (int)(getMapCenter().getLatitude() * 1000000.0D);
    }
    return 0;
  }
  
  public int getMapCenterY()
  {
    if (getMapCenter() != null) {
      return (int)(getMapCenter().getLongitude() * 1000000.0D);
    }
    return 0;
  }
  
  public Point getPointByGeoPoint(double paramDouble1, double paramDouble2)
  {
    Point localPoint = new Point();
    getProjection().toPixels(new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D)), localPoint);
    return localPoint;
  }
  
  public Set<String> getTags()
  {
    return this.tagsView.keySet();
  }
  
  public Object getViewByItag(String paramString)
  {
    if (this.tagsView.containsKey(paramString)) {
      return this.tagsView.get(paramString);
    }
    return null;
  }
  
  public e getViewManager()
  {
    return this.mViewManager;
  }
  
  public int getZoom()
  {
    return getZoomLevel();
  }
  
  public int getZoomLevel()
  {
    if (getMap() == null) {
      return 16;
    }
    return getMap().getZoomLevel();
  }
  
  public float metersToEquatorPixels(double paramDouble)
  {
    return getProjection().metersToEquatorPixels((float)paramDouble);
  }
  
  public void removeView(View paramView)
  {
    this.mViewManager.removeView(paramView);
    Iterator localIterator = this.tagsView.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.tagsView.get(str).equals(paramView)) {
        this.tagsView.remove(str);
      }
    }
  }
  
  public Object removeViewByTag(String paramString)
  {
    paramString = this.tagsView.get(paramString);
    if ((paramString instanceof View)) {
      removeView((View)paramString);
    }
    return paramString;
  }
  
  public void requestMapFocus()
  {
    requestFocus();
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean) {}
  
  public void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    getMap().setMapAnchor(paramFloat1, paramFloat2);
  }
  
  public void setMapViewOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    setOnTouchListener(paramOnTouchListener);
  }
  
  public void updateAnimViewLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    y.d("MicroMsg.SoSoMapView", "updateLocationPinLayout");
    updateLocaitonPinLayout(paramView, paramDouble1, paramDouble2, false);
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    this.mViewManager.updateLocaitonPinLayout(paramView, paramDouble1, paramDouble2, paramBoolean);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    this.mViewManager.updateViewLayout(paramView, paramDouble1, paramDouble2, false);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2, int paramInt)
  {
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    getIController().setCenter(paramDouble1, paramDouble2);
    y.d("MicroMsg.SoSoMapView", "zoomToSpan " + (int)(1000000.0D * paramDouble3) + " " + (int)(1000000.0D * paramDouble4) + "  " + 1000000.0D * paramDouble1 + " " + 1000000.0D * paramDouble2);
    if ((paramDouble3 == 0.0D) || (paramDouble4 == 0.0D)) {}
    while (getController() == null) {
      return;
    }
    getController().zoomToSpan(paramDouble3, paramDouble4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.api.SoSoMapView
 * JD-Core Version:    0.7.0.1
 */