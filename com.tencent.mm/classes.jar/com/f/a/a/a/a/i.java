package com.f.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.mapsdk.raster.model.UrlTileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i
  implements com.tencent.tencentmap.mapsdk.map.TencentMap, com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter, TencentMap.OnCameraChangeListener, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener, TencentMap.OnMapLoadedCallback, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener, TencentMap.OnMarkerDragListener
{
  private HashMap<Integer, e> MzB;
  List<com.tencent.tencentmap.mapsdk.maps.model.Marker> MzC;
  private boolean MzD;
  private TencentMapGestureListener MzE;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter MzF;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter> MzG;
  private TencentMap.OnMarkerDraggedListener MzH;
  List<TencentMap.OnMarkerDraggedListener> MzI;
  private TencentMap.OnMapLoadedListener MzJ;
  List<TencentMap.OnMapLoadedListener> MzK;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener MzL;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener> MzM;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener MzN;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener> MzO;
  private TencentMap.OnMapCameraChangeListener MzP;
  List<TencentMap.OnMapCameraChangeListener> MzQ;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener MzR;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener> MzS;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener MzT;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener> MzU;
  private com.tencent.tencentmap.mapsdk.maps.TencentMap mTencentMap;
  
  public i(com.tencent.tencentmap.mapsdk.maps.TencentMap paramTencentMap)
  {
    AppMethodBeat.i(200064);
    this.MzB = new HashMap();
    this.MzC = new ArrayList();
    this.MzD = false;
    this.mTencentMap = paramTencentMap;
    this.mTencentMap.setInfoWindowAdapter(this);
    this.mTencentMap.setOnMarkerDragListener(this);
    this.mTencentMap.setOnMapLoadedCallback(this);
    this.mTencentMap.setOnInfoWindowClickListener(this);
    this.mTencentMap.setOnMarkerClickListener(this);
    this.mTencentMap.setOnCameraChangeListener(this);
    this.mTencentMap.setOnMapClickListener(this);
    this.mTencentMap.setOnMapLongClickListener(this);
    AppMethodBeat.o(200064);
  }
  
  private e a(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(200095);
    if (paramMarker == null)
    {
      AppMethodBeat.o(200095);
      return null;
    }
    paramMarker = (e)this.MzB.get(Integer.valueOf(paramMarker.getId().hashCode()));
    AppMethodBeat.o(200095);
    return paramMarker;
  }
  
  public final Circle addCircle(com.tencent.mapsdk.raster.model.CircleOptions paramCircleOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.CircleOptions localCircleOptions = null;
    AppMethodBeat.i(200067);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200067);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(200067);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCircleOptions == null) {}
    for (paramCircleOptions = localCircleOptions;; paramCircleOptions = localCircleOptions)
    {
      paramCircleOptions = new b(localTencentMap.addCircle(paramCircleOptions));
      AppMethodBeat.o(200067);
      return paramCircleOptions;
      localCircleOptions = new com.tencent.tencentmap.mapsdk.maps.model.CircleOptions();
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng = l.c(paramCircleOptions.getCenter());
      if (localLatLng != null) {
        localCircleOptions.center(localLatLng);
      }
      localCircleOptions.center(l.c(paramCircleOptions.getCenter())).fillColor(paramCircleOptions.getFillColor()).radius(paramCircleOptions.getRadius()).strokeColor(paramCircleOptions.getStrokeColor()).strokeWidth(paramCircleOptions.getStrokeWidth()).visible(paramCircleOptions.isVisible()).zIndex((int)paramCircleOptions.getZIndex()).level(paramCircleOptions.getLevel());
    }
  }
  
  public final CustomLayer addCustomLayer(com.tencent.mapsdk.raster.model.CustomLayerOptions paramCustomLayerOptions)
  {
    Object localObject = null;
    AppMethodBeat.i(200138);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200138);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCustomLayerOptions == null) {}
    for (paramCustomLayerOptions = localObject;; paramCustomLayerOptions = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(paramCustomLayerOptions.getLayerId()))
    {
      paramCustomLayerOptions = new c(localTencentMap.addCustomLayer(paramCustomLayerOptions));
      AppMethodBeat.o(200138);
      return paramCustomLayerOptions;
    }
  }
  
  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    AppMethodBeat.i(200161);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200161);
      return null;
    }
    if (paramGroundOverlayOptions == null)
    {
      AppMethodBeat.o(200161);
      return null;
    }
    paramGroundOverlayOptions = this.mTencentMap.addGroundOverlay(paramGroundOverlayOptions);
    AppMethodBeat.o(200161);
    return paramGroundOverlayOptions;
  }
  
  public final void addInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(200093);
    if (paramInfoWindowAdapter == null)
    {
      AppMethodBeat.o(200093);
      return;
    }
    if (this.MzG == null) {
      this.MzG = new LinkedList();
    }
    this.MzG.add(paramInfoWindowAdapter);
    AppMethodBeat.o(200093);
  }
  
  public final com.tencent.mapsdk.raster.model.Marker addMarker(com.tencent.mapsdk.raster.model.MarkerOptions paramMarkerOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions localMarkerOptions = null;
    AppMethodBeat.i(200068);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200068);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(200068);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramMarkerOptions == null) {}
    do
    {
      paramMarkerOptions = new e(this, localTencentMap.addMarker(localMarkerOptions));
      this.MzB.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
      AppMethodBeat.o(200068);
      return paramMarkerOptions;
      localObject = l.c(paramMarkerOptions.getPosition());
    } while (localObject == null);
    localMarkerOptions = new com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions((com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject);
    Object localObject = localMarkerOptions.alpha(paramMarkerOptions.getAlpha()).visible(paramMarkerOptions.isVisible()).draggable(paramMarkerOptions.isDraggable()).anchor(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV()).rotation(paramMarkerOptions.getRotation()).indoorInfo(l.a(paramMarkerOptions.getIndoorInfo())).zIndex(paramMarkerOptions.getZIndex()).level(paramMarkerOptions.getLevel()).flat(paramMarkerOptions.isFlat());
    if (paramMarkerOptions.isFlat() != paramMarkerOptions.isClockwise()) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).clockwise(bool).infoWindowOffset(paramMarkerOptions.getInfoWindowOffsetX(), paramMarkerOptions.getInfowindowOffsetY()).contentDescription(paramMarkerOptions.getContentDescription());
      if (paramMarkerOptions.getIcon() != null) {
        localMarkerOptions.icon(BitmapDescriptorFactory.fromBitmap(paramMarkerOptions.getIcon().getBitmap()));
      }
      if (paramMarkerOptions.getMarkerView() != null) {
        localMarkerOptions.icon(BitmapDescriptorFactory.fromView(paramMarkerOptions.getMarkerView()));
      }
      if (paramMarkerOptions.getSnippet() != null) {
        localMarkerOptions.snippet(paramMarkerOptions.getSnippet());
      }
      if (paramMarkerOptions.getTitle() != null) {
        localMarkerOptions.title(paramMarkerOptions.getTitle());
      }
      if (paramMarkerOptions.getTag() != null) {
        localMarkerOptions.tag(paramMarkerOptions.getTag());
      }
      break;
    }
  }
  
  public final void addOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(200103);
    if (paramOnInfoWindowClickListener == null)
    {
      AppMethodBeat.o(200103);
      return;
    }
    if (this.MzM == null) {
      this.MzM = new LinkedList();
    }
    this.MzM.add(paramOnInfoWindowClickListener);
    AppMethodBeat.o(200103);
  }
  
  public final void addOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(200109);
    if (paramOnMapCameraChangeListener == null)
    {
      AppMethodBeat.o(200109);
      return;
    }
    if (this.MzQ == null) {
      this.MzQ = new LinkedList();
    }
    this.MzQ.add(paramOnMapCameraChangeListener);
    AppMethodBeat.o(200109);
  }
  
  public final void addOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(200112);
    if (paramOnMapClickListener == null)
    {
      AppMethodBeat.o(200112);
      return;
    }
    if (this.MzS == null) {
      this.MzS = new LinkedList();
    }
    this.MzS.add(paramOnMapClickListener);
    AppMethodBeat.o(200112);
  }
  
  public final void addOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(200100);
    if (paramOnMapLoadedListener == null)
    {
      AppMethodBeat.o(200100);
      return;
    }
    if (this.MzK == null) {
      this.MzK = new LinkedList();
    }
    this.MzK.add(paramOnMapLoadedListener);
    AppMethodBeat.o(200100);
  }
  
  public final void addOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(200115);
    if (paramOnMapLongClickListener == null)
    {
      AppMethodBeat.o(200115);
      return;
    }
    if (this.MzU == null) {
      this.MzU = new LinkedList();
    }
    this.MzU.add(paramOnMapLongClickListener);
    AppMethodBeat.o(200115);
  }
  
  public final void addOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(200106);
    if (paramOnMarkerClickListener == null)
    {
      AppMethodBeat.o(200106);
      return;
    }
    if (this.MzO == null) {
      this.MzO = new LinkedList();
    }
    this.MzO.add(paramOnMarkerClickListener);
    AppMethodBeat.o(200106);
  }
  
  public final void addOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(200097);
    if (paramOnMarkerDraggedListener == null)
    {
      AppMethodBeat.o(200097);
      return;
    }
    if (this.MzI == null) {
      this.MzI = new LinkedList();
    }
    this.MzI.add(paramOnMarkerDraggedListener);
    AppMethodBeat.o(200097);
  }
  
  public final Polygon addPolygon(com.tencent.mapsdk.raster.model.PolygonOptions paramPolygonOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200070);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200070);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(200070);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    Object localObject1;
    if (paramPolygonOptions == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      paramPolygonOptions = new g(localTencentMap.addPolygon(localObject1));
      AppMethodBeat.o(200070);
      return paramPolygonOptions;
      com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions localPolygonOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
      List localList = l.iV(paramPolygonOptions.getPoints());
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 2)
        {
          localPolygonOptions.addAll(localList);
          localPolygonOptions.visible(paramPolygonOptions.isVisible()).zIndex((int)paramPolygonOptions.getZIndex()).level(paramPolygonOptions.getLevel()).strokeWidth(paramPolygonOptions.getStrokeWidth()).strokeColor(paramPolygonOptions.getStrokeColor()).fillColor(paramPolygonOptions.getFillColor());
          localObject1 = localPolygonOptions;
        }
      }
    }
  }
  
  public final Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(200069);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200069);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(200069);
      return null;
    }
    paramPolylineOptions = new f(this.mTencentMap.addPolyline(l.a(paramPolylineOptions)));
    AppMethodBeat.o(200069);
    return paramPolylineOptions;
  }
  
  public final TileOverlay addTileOverlay(com.tencent.mapsdk.raster.model.TileOverlayOptions paramTileOverlayOptions)
  {
    Object localObject = null;
    com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions localTileOverlayOptions = null;
    AppMethodBeat.i(200133);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200133);
      return null;
    }
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(200133);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramTileOverlayOptions == null)
    {
      paramTileOverlayOptions = localTileOverlayOptions;
      paramTileOverlayOptions = new k(localTencentMap.addTileOverlay(paramTileOverlayOptions));
      AppMethodBeat.o(200133);
      return paramTileOverlayOptions;
    }
    localTileOverlayOptions = new com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions();
    com.tencent.mapsdk.raster.model.TileProvider localTileProvider = paramTileOverlayOptions.getTileProvider();
    if (localTileProvider == null) {}
    for (;;)
    {
      paramTileOverlayOptions = localTileOverlayOptions.tileProvider((com.tencent.tencentmap.mapsdk.maps.model.TileProvider)localObject).diskCacheDir(paramTileOverlayOptions.getDiskCacheDir()).versionInfo(paramTileOverlayOptions.getVersionInfo()).zIndex(paramTileOverlayOptions.getZIndex()).betterQuality(paramTileOverlayOptions.isBetterQuality());
      break;
      if ((localTileProvider instanceof UrlTileProvider)) {
        localObject = new l.1(((UrlTileProvider)localTileProvider).mWidth, ((UrlTileProvider)localTileProvider).mHeight, localTileProvider);
      } else {
        localObject = new l.2(localTileProvider);
      }
    }
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(200082);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200082);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(200082);
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(200083);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200083);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap), paramLong, new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(200047);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onCancel();
          }
          AppMethodBeat.o(200047);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(200046);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onFinish();
          }
          AppMethodBeat.o(200046);
        }
      });
    }
    AppMethodBeat.o(200083);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(200071);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200071);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)));
    }
    AppMethodBeat.o(200071);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(200073);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200073);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), paramLong, new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(200045);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(200045);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(200044);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(200044);
      }
    });
    AppMethodBeat.o(200073);
  }
  
  @Deprecated
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, final Runnable paramRunnable)
  {
    AppMethodBeat.i(200072);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200072);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(200043);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(200043);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(200042);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(200042);
        }
      });
    }
    AppMethodBeat.o(200072);
  }
  
  public final void clearAllOverlays()
  {
    AppMethodBeat.i(200074);
    if (this.mTencentMap != null) {
      this.mTencentMap.clear();
    }
    AppMethodBeat.o(200074);
  }
  
  public final boolean clearCache()
  {
    return false;
  }
  
  public final void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(200127);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200127);
      return;
    }
    this.mTencentMap.enableMultipleInfowindow(paramBoolean);
    AppMethodBeat.o(200127);
  }
  
  public final String getActivedIndoorBuilding(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(200124);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200124);
      return null;
    }
    paramLatLng = this.mTencentMap.getActivedIndoorBuilding(l.c(paramLatLng));
    AppMethodBeat.o(200124);
    return paramLatLng;
  }
  
  public final String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(200125);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200125);
      return null;
    }
    String[] arrayOfString = this.mTencentMap.getActivedIndoorFloorNames();
    AppMethodBeat.o(200125);
    return arrayOfString;
  }
  
  public final com.tencent.mapsdk.raster.model.CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(200131);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200131);
      return null;
    }
    com.tencent.mapsdk.raster.model.CameraPosition localCameraPosition = l.a(this.mTencentMap.getCameraPosition());
    AppMethodBeat.o(200131);
    return localCameraPosition;
  }
  
  public final String getDebugError()
  {
    AppMethodBeat.i(200132);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200132);
      return null;
    }
    String str = this.mTencentMap.getDebugError();
    AppMethodBeat.o(200132);
    return str;
  }
  
  public final int getIndoorFloorId()
  {
    AppMethodBeat.i(200126);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200126);
      return 0;
    }
    int i = this.mTencentMap.getIndoorFloorId();
    AppMethodBeat.o(200126);
    return i;
  }
  
  public final View getInfoContents(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    return null;
  }
  
  public final View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(200148);
    e locale = a(paramMarker);
    paramMarker = null;
    View localView = null;
    if (this.MzG != null)
    {
      Iterator localIterator = this.MzG.iterator();
      paramMarker = localView;
      while (localIterator.hasNext())
      {
        localView = ((com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter)localIterator.next()).getInfoWindow(locale);
        paramMarker = localView;
        if (localView != null) {
          paramMarker = localView;
        }
      }
    }
    AppMethodBeat.o(200148);
    return paramMarker;
  }
  
  public final com.tencent.mapsdk.raster.model.LatLng getMapCenter()
  {
    AppMethodBeat.i(200075);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200075);
      return null;
    }
    this.mTencentMap.getCameraPosition();
    com.tencent.mapsdk.raster.model.LatLng localLatLng = l.a(this.mTencentMap.getCameraPosition().target);
    AppMethodBeat.o(200075);
    return localLatLng;
  }
  
  public final int getMapType()
  {
    AppMethodBeat.i(200136);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200136);
      return 1000;
    }
    int i = this.mTencentMap.getMapType();
    AppMethodBeat.o(200136);
    return i;
  }
  
  public final int getMaxZoomLevel()
  {
    AppMethodBeat.i(200077);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200077);
      return 19;
    }
    int i = (int)this.mTencentMap.getMaxZoomLevel();
    AppMethodBeat.o(200077);
    return i;
  }
  
  public final int getMinZoomLevel()
  {
    AppMethodBeat.i(200078);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200078);
      return 4;
    }
    int i = (int)this.mTencentMap.getMinZoomLevel();
    AppMethodBeat.o(200078);
    return i;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(200137);
    h localh = new h(this.mTencentMap);
    AppMethodBeat.o(200137);
    return localh;
  }
  
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(200140);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200140);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(200062);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(200062);
      }
    });
    AppMethodBeat.o(200140);
  }
  
  @Deprecated
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(200141);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200141);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(200063);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(200063);
      }
    });
    AppMethodBeat.o(200141);
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(200079);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200079);
      return null;
    }
    String str = this.mTencentMap.getVersion();
    AppMethodBeat.o(200079);
    return str;
  }
  
  public final int getZoomLevel()
  {
    AppMethodBeat.i(200076);
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null))
    {
      AppMethodBeat.o(200076);
      return -1;
    }
    int i = (int)this.mTencentMap.getCameraPosition().zoom;
    AppMethodBeat.o(200076);
    return i;
  }
  
  public final boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public final boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(200147);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200147);
      return false;
    }
    boolean bool = this.mTencentMap.isHandDrawMapEnable();
    AppMethodBeat.o(200147);
    return bool;
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.MzD;
  }
  
  public final boolean isTrafficEnabled()
  {
    AppMethodBeat.i(200143);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200143);
      return false;
    }
    boolean bool = this.mTencentMap.isTrafficEnabled();
    AppMethodBeat.o(200143);
    return bool;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(200081);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200081);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.moveCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(200081);
  }
  
  public final void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(200149);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.MzQ != null)
    {
      Iterator localIterator = this.MzQ.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChange(paramCameraPosition);
      }
    }
    AppMethodBeat.o(200149);
  }
  
  public final void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(200150);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.MzQ != null)
    {
      Iterator localIterator = this.MzQ.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChangeFinish(paramCameraPosition);
      }
    }
    AppMethodBeat.o(200150);
  }
  
  public final void onInfoWindowClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(200151);
    paramMarker = a(paramMarker);
    if (this.MzM != null)
    {
      Iterator localIterator = this.MzM.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener)localIterator.next()).onInfoWindowClick(paramMarker);
      }
    }
    AppMethodBeat.o(200151);
  }
  
  public final void onInfoWindowClickLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(200152);
    paramLatLng = l.a(paramLatLng);
    if (this.MzS != null)
    {
      Iterator localIterator = this.MzS.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener)localIterator.next()).onMapClick(paramLatLng);
      }
    }
    AppMethodBeat.o(200152);
  }
  
  public final void onMapLoaded()
  {
    AppMethodBeat.i(200153);
    if (this.MzK != null)
    {
      Iterator localIterator = this.MzK.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapLoadedListener)localIterator.next()).onMapLoaded();
      }
    }
    AppMethodBeat.o(200153);
  }
  
  public final void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(200154);
    paramLatLng = l.a(paramLatLng);
    if (this.MzU != null)
    {
      Iterator localIterator = this.MzU.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener)localIterator.next()).onMapLongClick(paramLatLng);
      }
    }
    AppMethodBeat.o(200154);
  }
  
  public final boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(200155);
    paramMarker = a(paramMarker);
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.MzO != null)
    {
      Iterator localIterator = this.MzO.iterator();
      bool1 = bool2;
      while (localIterator.hasNext())
      {
        bool2 = ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener)localIterator.next()).onMarkerClick(paramMarker);
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(200155);
    return bool1;
  }
  
  public final void onMarkerDrag(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(200157);
    paramMarker = a(paramMarker);
    if (this.MzI != null)
    {
      Iterator localIterator = this.MzI.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDrag(paramMarker);
      }
    }
    AppMethodBeat.o(200157);
  }
  
  public final void onMarkerDragEnd(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(200158);
    paramMarker = a(paramMarker);
    if (this.MzI != null)
    {
      Iterator localIterator = this.MzI.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragEnd(paramMarker);
      }
    }
    AppMethodBeat.o(200158);
  }
  
  public final void onMarkerDragStart(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(200156);
    paramMarker = a(paramMarker);
    if (this.MzI != null)
    {
      Iterator localIterator = this.MzI.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragStart(paramMarker);
      }
    }
    AppMethodBeat.o(200156);
  }
  
  public final void remmoveOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(200104);
    if ((paramOnInfoWindowClickListener == null) || (this.MzM == null))
    {
      AppMethodBeat.o(200104);
      return;
    }
    this.MzM.remove(paramOnInfoWindowClickListener);
    AppMethodBeat.o(200104);
  }
  
  public final void removeInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(200094);
    if ((paramInfoWindowAdapter == null) || (this.MzG == null))
    {
      AppMethodBeat.o(200094);
      return;
    }
    this.MzG.remove(paramInfoWindowAdapter);
    AppMethodBeat.o(200094);
  }
  
  public final void removeOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(200110);
    if ((paramOnMapCameraChangeListener == null) || (this.MzQ == null))
    {
      AppMethodBeat.o(200110);
      return;
    }
    this.MzQ.remove(paramOnMapCameraChangeListener);
    AppMethodBeat.o(200110);
  }
  
  public final void removeOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(200113);
    if ((paramOnMapClickListener == null) || (this.MzS == null))
    {
      AppMethodBeat.o(200113);
      return;
    }
    this.MzS.remove(paramOnMapClickListener);
    AppMethodBeat.o(200113);
  }
  
  public final void removeOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(200101);
    if ((paramOnMapLoadedListener == null) || (this.MzK == null))
    {
      AppMethodBeat.o(200101);
      return;
    }
    this.MzK.remove(paramOnMapLoadedListener);
    AppMethodBeat.o(200101);
  }
  
  public final void removeOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(200116);
    if ((paramOnMapLongClickListener == null) || (this.MzU == null))
    {
      AppMethodBeat.o(200116);
      return;
    }
    this.MzU.remove(paramOnMapLongClickListener);
    AppMethodBeat.o(200116);
  }
  
  public final void removeOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(200107);
    if ((paramOnMarkerClickListener == null) || (this.MzO == null))
    {
      AppMethodBeat.o(200107);
      return;
    }
    this.MzO.remove(paramOnMarkerClickListener);
    AppMethodBeat.o(200107);
  }
  
  public final void removeOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(200098);
    if ((paramOnMarkerDraggedListener == null) || (this.MzI == null))
    {
      AppMethodBeat.o(200098);
      return;
    }
    this.MzI.remove(paramOnMarkerDraggedListener);
    AppMethodBeat.o(200098);
  }
  
  public final void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(200129);
    this.mTencentMap.removeTencentMapGestureListener(this.MzE);
    AppMethodBeat.o(200129);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200084);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200084);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2));
    AppMethodBeat.o(200084);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(200085);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200085);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(200049);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(200049);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(200048);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(200048);
      }
    });
    AppMethodBeat.o(200085);
  }
  
  public final void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(200144);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200144);
      return;
    }
    this.mTencentMap.setBuildingEnable(paramBoolean);
    AppMethodBeat.o(200144);
  }
  
  public final void setCenter(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(200065);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200065);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(200065);
  }
  
  @Deprecated
  public final void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.mTencentMap == null) {}
  }
  
  public final void setForeignLanguage(com.tencent.mapsdk.raster.model.Language paramLanguage)
  {
    AppMethodBeat.i(200130);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200130);
      return;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramLanguage != null) {}
    switch (l.3.MAf[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
    }
    for (;;)
    {
      localTencentMap.setForeignLanguage(paramLanguage);
      AppMethodBeat.o(200130);
      return;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      continue;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
    }
  }
  
  public final void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(200146);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200146);
      return;
    }
    this.mTencentMap.setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(200146);
  }
  
  public final void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200120);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200120);
      return;
    }
    this.mTencentMap.setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(200120);
  }
  
  public final void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(200121);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200121);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramInt);
    AppMethodBeat.o(200121);
  }
  
  public final void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200122);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200122);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(200122);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(200123);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200123);
      return;
    }
    this.mTencentMap.setIndoorMaskColor(paramInt);
    AppMethodBeat.o(200123);
  }
  
  public final void setInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(200092);
    if ((paramInfoWindowAdapter == null) && (this.MzF != null)) {
      removeInfoWindowAdapter(this.MzF);
    }
    this.MzF = paramInfoWindowAdapter;
    addInfoWindowAdapter(this.MzF);
    AppMethodBeat.o(200092);
  }
  
  public final void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200145);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200145);
      return;
    }
    this.mTencentMap.setCameraCenterProportion(paramFloat1, paramFloat2, false);
    this.mTencentMap.getUiSettings().setGestureScaleByMapCenter(true);
    AppMethodBeat.o(200145);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(200118);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200118);
      return;
    }
    this.mTencentMap.setMapStyle(paramInt);
    AppMethodBeat.o(200118);
  }
  
  public final void setMapType(int paramInt)
  {
    AppMethodBeat.i(200135);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200135);
      return;
    }
    this.mTencentMap.setMapType(paramInt);
    AppMethodBeat.o(200135);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(200159);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200159);
      return;
    }
    this.mTencentMap.setMaxZoomLevel(paramInt);
    AppMethodBeat.o(200159);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(200160);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200160);
      return;
    }
    this.mTencentMap.setMinZoomLevel(paramInt);
    AppMethodBeat.o(200160);
  }
  
  public final void setOnIndoorStateChangeListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(200119);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200119);
      return;
    }
    this.mTencentMap.setOnIndoorStateChangeListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener()
    {
      public final boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(200053);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(200053);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingDeactivated();
        AppMethodBeat.o(200053);
        return bool;
      }
      
      public final boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(200051);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(200051);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        AppMethodBeat.o(200051);
        return bool;
      }
      
      public final boolean onIndoorLevelActivated(com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(200052);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(200052);
          return false;
        }
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener localOnIndoorStateChangeListener = paramOnIndoorStateChangeListener;
        if (paramAnonymousIndoorBuilding == null) {
          paramAnonymousIndoorBuilding = null;
        }
        for (;;)
        {
          boolean bool = localOnIndoorStateChangeListener.onIndoorLevelActivated(paramAnonymousIndoorBuilding);
          AppMethodBeat.o(200052);
          return bool;
          Object localObject = paramAnonymousIndoorBuilding.getLevels();
          if (localObject == null)
          {
            localObject = null;
            if (localObject == null) {
              paramAnonymousIndoorBuilding = null;
            }
          }
          else
          {
            localObject = new CopyOnWriteArrayList((Collection)localObject);
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = ((List)localObject).iterator();
            for (;;)
            {
              localObject = localArrayList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = (com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel)localIterator.next();
              if (localObject == null)
              {
                localObject = null;
                break;
              }
              localArrayList.add(new com.tencent.mapsdk.raster.model.IndoorLevel(((com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel)localObject).getName()));
            }
          }
          paramAnonymousIndoorBuilding = new com.tencent.mapsdk.raster.model.IndoorBuilding(paramAnonymousIndoorBuilding.getBuidlingId(), paramAnonymousIndoorBuilding.getBuildingName(), (List)localObject, paramAnonymousIndoorBuilding.getActiveLevelIndex());
        }
      }
    });
    AppMethodBeat.o(200119);
  }
  
  public final void setOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(200102);
    if ((paramOnInfoWindowClickListener == null) && (this.MzL != null)) {
      remmoveOnInfoWindowClickListener(this.MzL);
    }
    this.MzL = paramOnInfoWindowClickListener;
    addOnInfoWindowClickListener(this.MzL);
    AppMethodBeat.o(200102);
  }
  
  public final void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(200108);
    if ((paramOnMapCameraChangeListener == null) && (this.MzP != null)) {
      removeOnMapCameraChangeListener(this.MzP);
    }
    this.MzP = paramOnMapCameraChangeListener;
    addOnMapCameraChangeListener(this.MzP);
    AppMethodBeat.o(200108);
  }
  
  public final void setOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(200111);
    if ((paramOnMapClickListener == null) && (this.MzR != null)) {
      removeOnMapClickListener(this.MzR);
    }
    this.MzR = paramOnMapClickListener;
    addOnMapClickListener(this.MzR);
    AppMethodBeat.o(200111);
  }
  
  public final void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(200099);
    if ((paramOnMapLoadedListener == null) && (this.MzJ != null)) {
      removeOnMapLoadedListener(this.MzJ);
    }
    this.MzJ = paramOnMapLoadedListener;
    addOnMapLoadedListener(this.MzJ);
    AppMethodBeat.o(200099);
  }
  
  public final void setOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(200114);
    if ((paramOnMapLongClickListener == null) && (this.MzT != null)) {
      removeOnMapLongClickListener(this.MzT);
    }
    this.MzT = paramOnMapLongClickListener;
    addOnMapLongClickListener(this.MzT);
    AppMethodBeat.o(200114);
  }
  
  public final void setOnMapPoiClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(200117);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200117);
      return;
    }
    this.mTencentMap.setOnMapPoiClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener()
    {
      public final void onClicked(com.tencent.tencentmap.mapsdk.maps.model.MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(200050);
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener localOnMapPoiClickListener;
        if (paramOnMapPoiClickListener != null)
        {
          localOnMapPoiClickListener = paramOnMapPoiClickListener;
          if (paramAnonymousMapPoi != null) {
            break label36;
          }
          paramAnonymousMapPoi = null;
        }
        for (;;)
        {
          localOnMapPoiClickListener.onClicked(paramAnonymousMapPoi);
          AppMethodBeat.o(200050);
          return;
          label36:
          if ((paramAnonymousMapPoi instanceof com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi))
          {
            paramAnonymousMapPoi = (com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi)paramAnonymousMapPoi;
            paramAnonymousMapPoi = new com.tencent.mapsdk.raster.model.IndoorMapPoi(paramAnonymousMapPoi.getName(), l.a(paramAnonymousMapPoi.getPosition()), paramAnonymousMapPoi.getBuildingId(), paramAnonymousMapPoi.getBuildingName(), paramAnonymousMapPoi.getFloorName());
          }
          else
          {
            paramAnonymousMapPoi = new com.tencent.mapsdk.raster.model.MapPoi(paramAnonymousMapPoi.getName(), l.a(paramAnonymousMapPoi.getPosition()));
          }
        }
      }
    });
    AppMethodBeat.o(200117);
  }
  
  public final void setOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(200105);
    if ((paramOnMarkerClickListener == null) && (this.MzN != null)) {
      removeOnMarkerClickListener(this.MzN);
    }
    this.MzN = paramOnMarkerClickListener;
    addOnMarkerClickListener(this.MzN);
    AppMethodBeat.o(200105);
  }
  
  public final void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(200096);
    if ((paramOnMarkerDraggedListener == null) && (this.MzH != null)) {
      removeOnMarkerDraggedListener(this.MzH);
    }
    this.MzH = paramOnMarkerDraggedListener;
    addOnMarkerDraggedListener(this.MzH);
    AppMethodBeat.o(200096);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200134);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200134);
      return;
    }
    this.mTencentMap.setPoisEnabled(paramBoolean);
    AppMethodBeat.o(200134);
  }
  
  public final void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200080);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200080);
      return;
    }
    this.MzD = paramBoolean;
    this.mTencentMap.setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(200080);
  }
  
  public final void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(200128);
    if ((this.mTencentMap == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(200128);
      return;
    }
    if (this.MzE != null) {
      this.mTencentMap.removeTencentMapGestureListener(this.MzE);
    }
    this.MzE = new TencentMapGestureListener()
    {
      public final boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(200054);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200054);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDoubleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(200054);
        return bool;
      }
      
      public final boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(200059);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200059);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDown(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(200059);
        return bool;
      }
      
      public final boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(200056);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200056);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onFling(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(200056);
        return bool;
      }
      
      public final boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(200058);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200058);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onLongPress(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(200058);
        return bool;
      }
      
      public final void onMapStable()
      {
        AppMethodBeat.i(200061);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200061);
          return;
        }
        paramTencentMapGestureListener.onMapStable();
        AppMethodBeat.o(200061);
      }
      
      public final boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(200057);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200057);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onScroll(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(200057);
        return bool;
      }
      
      public final boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(200055);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200055);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onSingleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(200055);
        return bool;
      }
      
      public final boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(200060);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(200060);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onUp(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(200060);
        return bool;
      }
    };
    this.mTencentMap.setTencentMapGestureListener(this.MzE);
    AppMethodBeat.o(200128);
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200142);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200142);
      return;
    }
    this.mTencentMap.setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(200142);
  }
  
  public final void setZoom(int paramInt)
  {
    AppMethodBeat.i(200066);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200066);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomTo(paramInt));
    AppMethodBeat.o(200066);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(200139);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200139);
      return;
    }
    this.mTencentMap.stopAnimation();
    AppMethodBeat.o(200139);
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(200086);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200086);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomIn());
    AppMethodBeat.o(200086);
  }
  
  public final void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200087);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200087);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(200087);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(200088);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200088);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomOut());
    AppMethodBeat.o(200088);
  }
  
  public final void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200089);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200089);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(200089);
  }
  
  public final void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(200091);
    zoomToSpan(new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(200091);
  }
  
  public final void zoomToSpan(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(200090);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(200090);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(l.c(paramLatLng1), l.c(paramLatLng2)), 0));
    AppMethodBeat.o(200090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */