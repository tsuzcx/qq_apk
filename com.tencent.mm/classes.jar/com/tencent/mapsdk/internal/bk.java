package com.tencent.mapsdk.internal;

import android.graphics.Bitmap.Config;
import android.os.Bundle;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolygonClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolylineClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnTrafficEventClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapFontSize;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;

public abstract class bk
  implements bs, TencentMap
{
  public void a(int paramInt)
  {
    kl.a("API_STATUS", "setIndoorConfigType", Integer.valueOf(paramInt));
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract boolean a();
  
  public Arc addArc(ArcOptions paramArcOptions)
  {
    if (paramArcOptions != null) {}
    for (paramArcOptions = paramArcOptions.toString();; paramArcOptions = "")
    {
      kl.a("API_STATUS", "addArc", paramArcOptions);
      return null;
    }
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    if (paramCircleOptions != null) {}
    for (paramCircleOptions = paramCircleOptions.toString();; paramCircleOptions = "")
    {
      kl.a("API_STATUS", "addCircle", paramCircleOptions);
      return null;
    }
  }
  
  public CustomLayer addCustomLayer(CustomLayerOptions paramCustomLayerOptions)
  {
    getMapContext().getContext();
    if (paramCustomLayerOptions != null) {}
    for (paramCustomLayerOptions = paramCustomLayerOptions.getLayerId();; paramCustomLayerOptions = "")
    {
      kl.a("API_STATUS", "addCustomLayer", kl.a(paramCustomLayerOptions));
      return null;
    }
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions != null) {}
    for (paramMarkerOptions = paramMarkerOptions.toString();; paramMarkerOptions = "")
    {
      kl.a("API_STATUS", "addMarker", paramMarkerOptions);
      return null;
    }
  }
  
  public void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    if (paramOnMapLoadedCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "addOnMapLoadedCallback", Boolean.valueOf(bool));
      return;
    }
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    if (paramPolygonOptions != null) {}
    for (paramPolygonOptions = paramPolygonOptions.toString();; paramPolygonOptions = "")
    {
      kl.a("API_STATUS", "addPolygon", paramPolygonOptions);
      return null;
    }
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    if (paramPolylineOptions != null) {}
    for (paramPolylineOptions = paramPolylineOptions.toString();; paramPolylineOptions = "")
    {
      kl.a("API_STATUS", "addPolyline", paramPolylineOptions);
      return null;
    }
  }
  
  public void addTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (paramTencentMapGestureListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "addTencentMapGestureListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
  {
    if (paramTileOverlayOptions != null) {}
    for (paramTileOverlayOptions = paramTileOverlayOptions.toString();; paramTileOverlayOptions = "")
    {
      kl.a("API_STATUS", "addTileOverlay", paramTileOverlayOptions);
      return null;
    }
  }
  
  protected abstract void b();
  
  public final void b(Bundle paramBundle)
  {
    kl.b("M_ON_CREATE");
    a(paramBundle);
    kl.d("M_ON_CREATE");
  }
  
  protected abstract void c();
  
  public void clear()
  {
    kl.a("API_STATUS", "clear", Integer.valueOf(kl.e("API_STATUS", "clear")));
  }
  
  public void clearAllOverlays()
  {
    kl.a("API_STATUS", "clearAllOverlays", Integer.valueOf(kl.e("API_STATUS", "clearAllOverlays")));
  }
  
  public void clearCache()
  {
    kl.a("API_STATUS", "clearCache", Integer.valueOf(kl.e("API_STATUS", "clearCache")));
  }
  
  protected abstract void d();
  
  protected abstract void e();
  
  public void enableMultipleInfowindow(boolean paramBoolean)
  {
    kl.a("API_STATUS", "enableMultipleInfowindow", Boolean.valueOf(paramBoolean));
  }
  
  protected abstract void f();
  
  protected void g() {}
  
  public <T extends TencentMapComponent.Component> T getMapComponent(Class<T> paramClass)
  {
    return getMapContext().getMapComponent(paramClass);
  }
  
  public final void h()
  {
    kl.b("M_ON_START");
    b();
    kl.d("M_ON_START");
  }
  
  public final void i()
  {
    kl.b("M_ON_RESUME");
    c();
    kl.d("M_ON_RESUME");
  }
  
  public final void j()
  {
    kl.b("M_ON_PAUSE");
    d();
    kl.d("M_ON_PAUSE");
  }
  
  public final void k()
  {
    kl.b("M_ON_RESTART");
    kl.d("M_ON_RESTART");
  }
  
  public final void l()
  {
    kl.b("M_ON_STOP");
    f();
    kl.d("M_ON_STOP");
  }
  
  public void loadKMLFile(String paramString)
  {
    kl.a("API_STATUS", "loadKMLFile", paramString);
  }
  
  public final void m()
  {
    kl.b("M_ON_DESTROY");
    g();
    kl.d("M_ON_DESTROY");
  }
  
  public void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    if (paramOnMapLoadedCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "removeOnMapLoadedCallback", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void removeTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (paramTencentMapGestureListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "removeTencentMapGestureListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setBlockRouteEnabled(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setBlockRouteEnabled", Boolean.valueOf(paramBoolean));
  }
  
  public void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setBuilding3dEffectEnable", Boolean.valueOf(paramBoolean));
  }
  
  public void setBuildingEnable(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setBuildingEnable", Boolean.valueOf(paramBoolean));
  }
  
  public void setCameraCenterProportion(float paramFloat1, float paramFloat2)
  {
    kl.a("API_STATUS", "setCameraCenterProportion", paramFloat1 + "#" + paramFloat2);
  }
  
  public void setCameraCenterProportion(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    kl.a("API_STATUS", "setCameraCenterProportion", paramFloat1 + "#" + paramFloat2 + "#" + paramBoolean);
  }
  
  public void setCustomRender(CustomRender paramCustomRender)
  {
    kl.a("API_STATUS", "setCustomRender", paramCustomRender);
  }
  
  public void setDrawPillarWith2DStyle(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setDrawPillarWith2DStyle", Boolean.valueOf(paramBoolean));
  }
  
  public void setForeignLanguage(Language paramLanguage)
  {
    kl.a("API_STATUS", "setForeignLanguage", paramLanguage);
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setHandDrawMapEnable", Boolean.valueOf(paramBoolean));
  }
  
  public void setIndoorEnabled(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setIndoorEnabled", Boolean.valueOf(paramBoolean));
  }
  
  public void setIndoorFloor(int paramInt)
  {
    kl.a("API_STATUS", "setIndoorFloor", Integer.valueOf(paramInt));
  }
  
  public void setIndoorFloor(String paramString1, String paramString2)
  {
    kl.a("API_STATUS", "setIndoorFloor", paramString1 + "#" + paramString2);
  }
  
  public void setIndoorMaskColor(int paramInt)
  {
    kl.a("API_STATUS", "setIndoorMaskColor", Integer.valueOf(paramInt));
  }
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    if (paramInfoWindowAdapter != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setInfoWindowAdapter", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setLocationSource(LocationSource paramLocationSource)
  {
    if (paramLocationSource != null) {
      kl.a("API_STATUS", "setLocationSource", paramLocationSource.getClass().getSimpleName());
    }
  }
  
  public void setMapCenterAndScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    kl.a("API_STATUS", "setMapCenterAndScale", paramFloat1 + "#" + paramFloat2 + "#" + paramFloat3);
  }
  
  public void setMapFontSize(MapFontSize paramMapFontSize)
  {
    kl.a("API_STATUS", "setMapFontSize", paramMapFontSize);
  }
  
  public void setMapFrameRate(float paramFloat)
  {
    kl.a("API_STATUS", "setMapFrameRate", Float.valueOf(paramFloat));
  }
  
  public void setMapStyle(int paramInt)
  {
    kl.a("API_STATUS", "setMapStyle", Integer.valueOf(paramInt));
  }
  
  public void setMapType(int paramInt)
  {
    kl.a("API_STATUS", "setMapType", Integer.valueOf(paramInt));
  }
  
  public void setMaxZoomLevel(int paramInt)
  {
    kl.a("API_STATUS", "setMaxZoomLevel", Integer.valueOf(paramInt));
  }
  
  public void setMinZoomLevel(int paramInt)
  {
    kl.a("API_STATUS", "setMinZoomLevel", Integer.valueOf(paramInt));
  }
  
  public void setMyLocationClickListener(TencentMap.OnMyLocationClickListener paramOnMyLocationClickListener)
  {
    if (paramOnMyLocationClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setMyLocationClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setMyLocationEnabled(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setMyLocationEnabled", Boolean.valueOf(paramBoolean));
  }
  
  public void setMyLocationStyle(MyLocationStyle paramMyLocationStyle)
  {
    if (paramMyLocationStyle != null) {}
    for (paramMyLocationStyle = paramMyLocationStyle.toString();; paramMyLocationStyle = "")
    {
      kl.a("API_STATUS", "setMyLocationStyle", paramMyLocationStyle);
      return;
    }
  }
  
  public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (paramOnCameraChangeListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnCameraChangeListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnCompassClickedListener(TencentMap.OnCompassClickedListener paramOnCompassClickedListener)
  {
    if (paramOnCompassClickedListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnCompassClickedListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    if (paramOnIndoorStateChangeListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnIndoorStateChangeListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if (paramOnInfoWindowClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "OnInfoWindowClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    if (paramOnMapClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnMapClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnMapLoadedCallback(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    addOnMapLoadedCallback(paramOnMapLoadedCallback);
  }
  
  public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    if (paramOnMapLongClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnMapLongClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    if (paramOnMapPoiClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnMapPoiClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    if (paramOnMarkerClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnMarkerClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnMarkerDragListener(TencentMap.OnMarkerDragListener paramOnMarkerDragListener)
  {
    if (paramOnMarkerDragListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "OnMarkerDragListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
    if (paramOnMyLocationChangeListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnMyLocationChangeListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnPolygonClickListener(TencentMap.OnPolygonClickListener paramOnPolygonClickListener)
  {
    if (paramOnPolygonClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnPolygonClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnPolylineClickListener(TencentMap.OnPolylineClickListener paramOnPolylineClickListener)
  {
    if (paramOnPolylineClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnPolylineClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOnTapMapViewInfoWindowHidden(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setOnTapMapViewInfoWindowHidden", Boolean.valueOf(paramBoolean));
  }
  
  public void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener paramOnTrafficEventClickListener)
  {
    if (paramOnTrafficEventClickListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setOnTrafficEventClickListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setOverSeaEnable(boolean paramBoolean)
  {
    kl.a("API_STATUS", "enableOverSea", Boolean.valueOf(paramBoolean));
  }
  
  public void setOverSeaTileProvider(OverSeaTileProvider paramOverSeaTileProvider)
  {
    kl.a("API_STATUS", "setOverSeaTileProvider", paramOverSeaTileProvider);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    kl.a("API_STATUS", "setPadding", paramInt1 + "#" + paramInt2 + "#" + paramInt3 + "#" + paramInt4);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    kl.a("API_STATUS", "setPadding", paramInt1 + "#" + paramInt2 + "#" + paramInt3 + "#" + paramInt4 + "#" + paramBoolean);
  }
  
  public void setPointToCenter(int paramInt1, int paramInt2)
  {
    kl.a("API_STATUS", "setPointToCenter", paramInt1 + "#" + paramInt2);
  }
  
  public void setPoisEnabled(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setPoisEnabled", Boolean.valueOf(paramBoolean));
  }
  
  public void setRestrictBounds(LatLngBounds paramLatLngBounds, RestrictBoundsFitMode paramRestrictBoundsFitMode)
  {
    if (paramLatLngBounds == null) {}
    for (paramLatLngBounds = "null restrictBounds";; paramLatLngBounds = paramLatLngBounds.toString() + "#" + paramRestrictBoundsFitMode)
    {
      kl.a("API_STATUS", "setRestrictBounds", paramLatLngBounds);
      return;
    }
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setSatelliteEnabled", Boolean.valueOf(paramBoolean));
  }
  
  public void setTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (paramTencentMapGestureListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "setTencentMapGestureListener", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    kl.a("API_STATUS", "setTrafficEnabled", Boolean.valueOf(paramBoolean));
  }
  
  public void showBuilding(boolean paramBoolean)
  {
    kl.a("API_STATUS", "showBuilding", Boolean.valueOf(paramBoolean));
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    if (paramSnapshotReadyCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "snapshot", Boolean.valueOf(bool));
      return;
    }
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSnapshotReadyCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "snapshot", bool + "#" + paramConfig);
      return;
    }
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSnapshotReadyCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      kl.a("API_STATUS", "snapshot", bool + "#" + paramConfig + "#" + paramInt);
      return;
    }
  }
  
  public void stopAnimation()
  {
    kl.a("API_STATUS", "stopAnimation", Integer.valueOf(kl.e("API_STATUS", "stopAnimation")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bk
 * JD-Core Version:    0.7.0.1
 */