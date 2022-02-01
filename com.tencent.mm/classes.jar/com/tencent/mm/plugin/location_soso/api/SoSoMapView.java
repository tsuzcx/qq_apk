package com.tencent.mm.plugin.location_soso.api;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.k.e;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
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
    AppMethodBeat.i(146626);
    this.tagsView = new HashMap();
    this.firstanim = true;
    init();
    AppMethodBeat.o(146626);
  }
  
  public SoSoMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(146627);
    this.tagsView = new HashMap();
    this.firstanim = true;
    init();
    AppMethodBeat.o(146627);
  }
  
  public SoSoMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    AppMethodBeat.i(146628);
    this.tagsView = new HashMap();
    this.firstanim = true;
    init();
    AppMethodBeat.o(146628);
  }
  
  private void init()
  {
    AppMethodBeat.i(146631);
    this.mViewManager = new ViewManager(getMap());
    getMap().set3DEnable(true);
    this.iController = new b()
    {
      public void animateTo(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(146623);
        ad.d("MicroMsg.SoSoMapView", "animteTo slat:" + paramAnonymousDouble1 + " slong:" + paramAnonymousDouble2);
        if (SoSoMapView.this.firstanim) {
          SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(paramAnonymousDouble1, paramAnonymousDouble2)));
        }
        for (;;)
        {
          SoSoMapView.access$002(SoSoMapView.this, false);
          AppMethodBeat.o(146623);
          return;
          SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(paramAnonymousDouble1, paramAnonymousDouble2)));
        }
      }
      
      public void animateTo(double paramAnonymousDouble1, double paramAnonymousDouble2, int paramAnonymousInt)
      {
        AppMethodBeat.i(146622);
        ad.d("MicroMsg.SoSoMapView", "animteTo slat:" + paramAnonymousDouble1 + " slong:" + paramAnonymousDouble2 + " zoom:" + paramAnonymousInt);
        if (SoSoMapView.this.firstanim) {
          SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(paramAnonymousDouble1, paramAnonymousDouble2), paramAnonymousInt));
        }
        for (;;)
        {
          SoSoMapView.access$002(SoSoMapView.this, false);
          AppMethodBeat.o(146622);
          return;
          SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(paramAnonymousDouble1, paramAnonymousDouble2), paramAnonymousInt));
        }
      }
      
      public void offsetCenter(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(146625);
        setCenter(SoSoMapView.this.getMapCenterX() / 1000000.0D + paramAnonymousDouble1, SoSoMapView.this.getMapCenterY() / 1000000.0D + paramAnonymousDouble2);
        AppMethodBeat.o(146625);
      }
      
      public void setCenter(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(146624);
        SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(paramAnonymousDouble1, paramAnonymousDouble2)));
        AppMethodBeat.o(146624);
      }
      
      public void setZoom(int paramAnonymousInt)
      {
        AppMethodBeat.i(146621);
        ad.d("MicroMsg.SoSoMapView", "set Zoom %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.zoomTo(paramAnonymousInt));
        AppMethodBeat.o(146621);
      }
    };
    AppMethodBeat.o(146631);
  }
  
  private void setEnableForeignMap(boolean paramBoolean)
  {
    AppMethodBeat.i(146630);
    try
    {
      Method localMethod = MapView.class.getDeclaredMethod("setForeignEnabled", new Class[] { Boolean.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(146630);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SoSoMapView", localException, "", new Object[0]);
      AppMethodBeat.o(146630);
    }
  }
  
  public void addAnimTrackView(View paramView, double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(146655);
    this.tagsView.put(paramString, paramView);
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
    AppMethodBeat.o(146655);
  }
  
  public void addLocationPin(View paramView)
  {
    AppMethodBeat.i(146648);
    addView(paramView, 0.0D, 0.0D);
    AppMethodBeat.o(146648);
  }
  
  public void addNullView(View paramView)
  {
    AppMethodBeat.i(146636);
    ad.d("MicroMsg.SoSoMapView", "addNullView ");
    addView(paramView);
    AppMethodBeat.o(146636);
  }
  
  public void addOverlay(Object paramObject) {}
  
  public void addPinView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146633);
    this.mViewManager.addPinView(paramView, paramDouble1, paramDouble2);
    AppMethodBeat.o(146633);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146632);
    this.mViewManager.addView(paramView, paramDouble1, paramDouble2);
    AppMethodBeat.o(146632);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(146660);
    new GeoPoint((int)(1000000.0D * paramDouble1), (int)(1000000.0D * paramDouble2));
    if (paramInt == -2)
    {
      addView(paramView, new MapView.LayoutParams(-2, -2, new LatLng(paramDouble1, paramDouble2), 17));
      AppMethodBeat.o(146660);
      return;
    }
    if (paramInt == -1)
    {
      addView(paramView, new MapView.LayoutParams(-1, -1, new LatLng(paramDouble1, paramDouble2), 17));
      AppMethodBeat.o(146660);
      return;
    }
    addView(paramView, new MapView.LayoutParams(paramInt, paramInt, new LatLng(paramDouble1, paramDouble2), 17));
    AppMethodBeat.o(146660);
  }
  
  public void addView(Object paramObject, double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(146641);
    this.tagsView.put(paramString, paramObject);
    AppMethodBeat.o(146641);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(146665);
    this.mViewManager.animateCamera(paramCameraUpdate);
    AppMethodBeat.o(146665);
  }
  
  public void clean()
  {
    AppMethodBeat.i(146647);
    this.tagsView.clear();
    this.mViewManager.destroy();
    AppMethodBeat.o(146647);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(146658);
    this.mViewManager.destroy();
    AppMethodBeat.o(146658);
  }
  
  public void disableDarkMode()
  {
    AppMethodBeat.i(182828);
    this.mViewManager.disableDarkMode();
    AppMethodBeat.o(182828);
  }
  
  public Circle drawAccuracyCircle(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(146664);
    Circle localCircle = this.mViewManager.drawAccuracyCircle(paramDouble1, paramDouble2, paramDouble3);
    AppMethodBeat.o(146664);
    return localCircle;
  }
  
  public void enableDarkMode()
  {
    AppMethodBeat.i(182827);
    this.mViewManager.enableDarkMode();
    AppMethodBeat.o(182827);
  }
  
  public Collection<Object> getChilds()
  {
    AppMethodBeat.i(146643);
    Collection localCollection = this.tagsView.values();
    AppMethodBeat.o(146643);
    return localCollection;
  }
  
  public MapController getController()
  {
    AppMethodBeat.i(146629);
    MapController localMapController = getMapController();
    AppMethodBeat.o(146629);
    return localMapController;
  }
  
  public b getIController()
  {
    return this.iController;
  }
  
  public int getMapCenterX()
  {
    AppMethodBeat.i(146637);
    if (getMapCenter() != null)
    {
      int i = (int)(getMapCenter().getLatitude() * 1000000.0D);
      AppMethodBeat.o(146637);
      return i;
    }
    AppMethodBeat.o(146637);
    return 0;
  }
  
  public int getMapCenterY()
  {
    AppMethodBeat.i(146638);
    if (getMapCenter() != null)
    {
      int i = (int)(getMapCenter().getLongitude() * 1000000.0D);
      AppMethodBeat.o(146638);
      return i;
    }
    AppMethodBeat.o(146638);
    return 0;
  }
  
  public Point getPointByGeoPoint(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146654);
    Point localPoint = new Point();
    getProjection().toPixels(new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D)), localPoint);
    AppMethodBeat.o(146654);
    return localPoint;
  }
  
  public Set<String> getTags()
  {
    AppMethodBeat.i(146645);
    Set localSet = this.tagsView.keySet();
    AppMethodBeat.o(146645);
    return localSet;
  }
  
  public Object getViewByItag(String paramString)
  {
    AppMethodBeat.i(146642);
    if (this.tagsView.containsKey(paramString))
    {
      paramString = this.tagsView.get(paramString);
      AppMethodBeat.o(146642);
      return paramString;
    }
    AppMethodBeat.o(146642);
    return null;
  }
  
  public e getViewManager()
  {
    return this.mViewManager;
  }
  
  public int getZoom()
  {
    AppMethodBeat.i(146652);
    int i = getZoomLevel();
    AppMethodBeat.o(146652);
    return i;
  }
  
  public int getZoomLevel()
  {
    AppMethodBeat.i(146634);
    TencentMap localTencentMap = getMap();
    if (localTencentMap == null)
    {
      AppMethodBeat.o(146634);
      return 16;
    }
    int i = localTencentMap.getZoomLevel();
    AppMethodBeat.o(146634);
    return i;
  }
  
  public float metersToEquatorPixels(double paramDouble)
  {
    AppMethodBeat.i(146657);
    float f = getProjection().metersToEquatorPixels((float)paramDouble);
    AppMethodBeat.o(146657);
    return f;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(146644);
    this.mViewManager.removeView(paramView);
    Iterator localIterator = this.tagsView.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.tagsView.get(str).equals(paramView))
      {
        this.tagsView.remove(str);
        AppMethodBeat.o(146644);
        return;
      }
    }
    AppMethodBeat.o(146644);
  }
  
  public Object removeViewByTag(String paramString)
  {
    AppMethodBeat.i(146646);
    paramString = this.tagsView.get(paramString);
    if ((paramString instanceof View)) {
      removeView((View)paramString);
    }
    AppMethodBeat.o(146646);
    return paramString;
  }
  
  public void requestMapFocus()
  {
    AppMethodBeat.i(146640);
    requestFocus();
    AppMethodBeat.o(146640);
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean) {}
  
  public void setCanRotate(boolean paramBoolean)
  {
    AppMethodBeat.i(146666);
    UiSettings localUiSettings = getUiSettings();
    if (localUiSettings != null) {
      localUiSettings.setRotateGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(146666);
  }
  
  public void setLogoMargin(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(146635);
    UiSettings localUiSettings = getUiSettings();
    if (localUiSettings != null) {
      localUiSettings.setLogoPosition(1, paramArrayOfInt);
    }
    AppMethodBeat.o(146635);
  }
  
  public void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146659);
    getMap().setMapAnchor(paramFloat1, paramFloat2);
    AppMethodBeat.o(146659);
  }
  
  public void setMapViewOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(146653);
    setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(146653);
  }
  
  public void setMarkerClickListener(View paramView, TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(146662);
    this.mViewManager.setMarkerClick(paramView, paramOnMarkerClickListener);
    AppMethodBeat.o(146662);
  }
  
  public void updateAnimViewLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146656);
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
    AppMethodBeat.o(146656);
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146650);
    ad.d("MicroMsg.SoSoMapView", "updateLocationPinLayout");
    updateLocaitonPinLayout(paramView, paramDouble1, paramDouble2, false);
    AppMethodBeat.o(146650);
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(146651);
    this.mViewManager.updateLocationPinLayout(paramView, paramDouble1, paramDouble2, paramBoolean);
    AppMethodBeat.o(146651);
  }
  
  public void updateMarkerView(View paramView)
  {
    AppMethodBeat.i(146663);
    this.mViewManager.updateMarkerView(paramView);
    AppMethodBeat.o(146663);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146639);
    this.mViewManager.updateViewLayout(paramView, paramDouble1, paramDouble2, false);
    AppMethodBeat.o(146639);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(146661);
    new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
    AppMethodBeat.o(146661);
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(146649);
    getIController().setCenter(paramDouble1, paramDouble2);
    ad.d("MicroMsg.SoSoMapView", "zoomToSpan " + (int)(1000000.0D * paramDouble3) + " " + (int)(1000000.0D * paramDouble4) + "  " + 1000000.0D * paramDouble1 + " " + 1000000.0D * paramDouble2);
    if ((paramDouble3 == 0.0D) || (paramDouble4 == 0.0D))
    {
      AppMethodBeat.o(146649);
      return;
    }
    if (getController() != null) {
      getController().zoomToSpan(paramDouble3, paramDouble4);
    }
    AppMethodBeat.o(146649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.api.SoSoMapView
 * JD-Core Version:    0.7.0.1
 */