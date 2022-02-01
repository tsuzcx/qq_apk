package com.e.a.a.a.a;

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
  private HashMap<Integer, e> aalK;
  List<com.tencent.tencentmap.mapsdk.maps.model.Marker> aalL;
  private boolean aalM;
  private TencentMapGestureListener aalN;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter aalO;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter> aalP;
  private TencentMap.OnMarkerDraggedListener aalQ;
  List<TencentMap.OnMarkerDraggedListener> aalR;
  private TencentMap.OnMapLoadedListener aalS;
  List<TencentMap.OnMapLoadedListener> aalT;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener aalU;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener> aalV;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener aalW;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener> aalX;
  private TencentMap.OnMapCameraChangeListener aalY;
  List<TencentMap.OnMapCameraChangeListener> aalZ;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener aama;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener> aamb;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener aamc;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener> aamd;
  private com.tencent.tencentmap.mapsdk.maps.TencentMap mTencentMap;
  
  public i(com.tencent.tencentmap.mapsdk.maps.TencentMap paramTencentMap)
  {
    AppMethodBeat.i(188870);
    this.aalK = new HashMap();
    this.aalL = new ArrayList();
    this.aalM = false;
    this.mTencentMap = paramTencentMap;
    this.mTencentMap.setInfoWindowAdapter(this);
    this.mTencentMap.setOnMarkerDragListener(this);
    this.mTencentMap.setOnMapLoadedCallback(this);
    this.mTencentMap.setOnInfoWindowClickListener(this);
    this.mTencentMap.setOnMarkerClickListener(this);
    this.mTencentMap.setOnCameraChangeListener(this);
    this.mTencentMap.setOnMapClickListener(this);
    this.mTencentMap.setOnMapLongClickListener(this);
    AppMethodBeat.o(188870);
  }
  
  private e a(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(188932);
    if (paramMarker == null)
    {
      AppMethodBeat.o(188932);
      return null;
    }
    paramMarker = (e)this.aalK.get(Integer.valueOf(paramMarker.getId().hashCode()));
    AppMethodBeat.o(188932);
    return paramMarker;
  }
  
  public final Circle addCircle(com.tencent.mapsdk.raster.model.CircleOptions paramCircleOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.CircleOptions localCircleOptions = null;
    AppMethodBeat.i(188873);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188873);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(188873);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCircleOptions == null) {}
    for (paramCircleOptions = localCircleOptions;; paramCircleOptions = localCircleOptions)
    {
      paramCircleOptions = new b(localTencentMap.addCircle(paramCircleOptions));
      AppMethodBeat.o(188873);
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
    AppMethodBeat.i(189059);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189059);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCustomLayerOptions == null) {}
    for (paramCustomLayerOptions = localObject;; paramCustomLayerOptions = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(paramCustomLayerOptions.getLayerId()))
    {
      paramCustomLayerOptions = new c(localTencentMap.addCustomLayer(paramCustomLayerOptions));
      AppMethodBeat.o(189059);
      return paramCustomLayerOptions;
    }
  }
  
  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    AppMethodBeat.i(189130);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189130);
      return null;
    }
    if (paramGroundOverlayOptions == null)
    {
      AppMethodBeat.o(189130);
      return null;
    }
    paramGroundOverlayOptions = this.mTencentMap.addGroundOverlay(paramGroundOverlayOptions);
    AppMethodBeat.o(189130);
    return paramGroundOverlayOptions;
  }
  
  public final void addInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(188928);
    if (paramInfoWindowAdapter == null)
    {
      AppMethodBeat.o(188928);
      return;
    }
    if (this.aalP == null) {
      this.aalP = new LinkedList();
    }
    this.aalP.add(paramInfoWindowAdapter);
    AppMethodBeat.o(188928);
  }
  
  public final com.tencent.mapsdk.raster.model.Marker addMarker(com.tencent.mapsdk.raster.model.MarkerOptions paramMarkerOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions localMarkerOptions = null;
    AppMethodBeat.i(188875);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188875);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(188875);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramMarkerOptions == null) {}
    do
    {
      paramMarkerOptions = new e(this, localTencentMap.addMarker(localMarkerOptions));
      this.aalK.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
      AppMethodBeat.o(188875);
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
      if (paramMarkerOptions.getCollisions() != null) {
        localMarkerOptions.collisionBy(paramMarkerOptions.getCollisions());
      }
      break;
    }
  }
  
  public final void addOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(188960);
    if (paramOnInfoWindowClickListener == null)
    {
      AppMethodBeat.o(188960);
      return;
    }
    if (this.aalV == null) {
      this.aalV = new LinkedList();
    }
    this.aalV.add(paramOnInfoWindowClickListener);
    AppMethodBeat.o(188960);
  }
  
  public final void addOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(188971);
    if (paramOnMapCameraChangeListener == null)
    {
      AppMethodBeat.o(188971);
      return;
    }
    if (this.aalZ == null) {
      this.aalZ = new LinkedList();
    }
    this.aalZ.add(paramOnMapCameraChangeListener);
    AppMethodBeat.o(188971);
  }
  
  public final void addOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(188978);
    if (paramOnMapClickListener == null)
    {
      AppMethodBeat.o(188978);
      return;
    }
    if (this.aamb == null) {
      this.aamb = new LinkedList();
    }
    this.aamb.add(paramOnMapClickListener);
    AppMethodBeat.o(188978);
  }
  
  public final void addOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(188951);
    if (paramOnMapLoadedListener == null)
    {
      AppMethodBeat.o(188951);
      return;
    }
    if (this.aalT == null) {
      this.aalT = new LinkedList();
    }
    this.aalT.add(paramOnMapLoadedListener);
    AppMethodBeat.o(188951);
  }
  
  public final void addOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(188983);
    if (paramOnMapLongClickListener == null)
    {
      AppMethodBeat.o(188983);
      return;
    }
    if (this.aamd == null) {
      this.aamd = new LinkedList();
    }
    this.aamd.add(paramOnMapLongClickListener);
    AppMethodBeat.o(188983);
  }
  
  public final void addOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(188966);
    if (paramOnMarkerClickListener == null)
    {
      AppMethodBeat.o(188966);
      return;
    }
    if (this.aalX == null) {
      this.aalX = new LinkedList();
    }
    this.aalX.add(paramOnMarkerClickListener);
    AppMethodBeat.o(188966);
  }
  
  public final void addOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(188940);
    if (paramOnMarkerDraggedListener == null)
    {
      AppMethodBeat.o(188940);
      return;
    }
    if (this.aalR == null) {
      this.aalR = new LinkedList();
    }
    this.aalR.add(paramOnMarkerDraggedListener);
    AppMethodBeat.o(188940);
  }
  
  public final Polygon addPolygon(com.tencent.mapsdk.raster.model.PolygonOptions paramPolygonOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(188880);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188880);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(188880);
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
      AppMethodBeat.o(188880);
      return paramPolygonOptions;
      com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions localPolygonOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
      List localList = l.lf(paramPolygonOptions.getPoints());
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
    AppMethodBeat.i(188878);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188878);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(188878);
      return null;
    }
    paramPolylineOptions = new f(this.mTencentMap.addPolyline(l.a(paramPolylineOptions)));
    AppMethodBeat.o(188878);
    return paramPolylineOptions;
  }
  
  public final TileOverlay addTileOverlay(com.tencent.mapsdk.raster.model.TileOverlayOptions paramTileOverlayOptions)
  {
    Object localObject = null;
    com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions localTileOverlayOptions = null;
    AppMethodBeat.i(189033);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189033);
      return null;
    }
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(189033);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramTileOverlayOptions == null)
    {
      paramTileOverlayOptions = localTileOverlayOptions;
      paramTileOverlayOptions = new k(localTencentMap.addTileOverlay(paramTileOverlayOptions));
      AppMethodBeat.o(189033);
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
    AppMethodBeat.i(188911);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188911);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(188911);
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(188914);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188914);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap), paramLong, new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(187258);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onCancel();
          }
          AppMethodBeat.o(187258);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(187254);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onFinish();
          }
          AppMethodBeat.o(187254);
        }
      });
    }
    AppMethodBeat.o(188914);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(188882);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188882);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)));
    }
    AppMethodBeat.o(188882);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(188887);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188887);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), paramLong, new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(187461);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(187461);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(187460);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(187460);
      }
    });
    AppMethodBeat.o(188887);
  }
  
  @Deprecated
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, final Runnable paramRunnable)
  {
    AppMethodBeat.i(188885);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188885);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(186759);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(186759);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(186757);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(186757);
        }
      });
    }
    AppMethodBeat.o(188885);
  }
  
  public final void clearAllOverlays()
  {
    AppMethodBeat.i(188889);
    if (this.mTencentMap != null) {
      this.mTencentMap.clear();
    }
    AppMethodBeat.o(188889);
  }
  
  public final boolean clearCache()
  {
    return false;
  }
  
  public final void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(189010);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189010);
      return;
    }
    this.mTencentMap.enableMultipleInfowindow(paramBoolean);
    AppMethodBeat.o(189010);
  }
  
  public final String getActivedIndoorBuilding(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(189001);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189001);
      return null;
    }
    paramLatLng = this.mTencentMap.getActivedIndoorBuilding(l.c(paramLatLng));
    AppMethodBeat.o(189001);
    return paramLatLng;
  }
  
  public final String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(189003);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189003);
      return null;
    }
    String[] arrayOfString = this.mTencentMap.getActivedIndoorFloorNames();
    AppMethodBeat.o(189003);
    return arrayOfString;
  }
  
  public final com.tencent.mapsdk.raster.model.CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(189029);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189029);
      return null;
    }
    com.tencent.mapsdk.raster.model.CameraPosition localCameraPosition = l.a(this.mTencentMap.getCameraPosition());
    AppMethodBeat.o(189029);
    return localCameraPosition;
  }
  
  public final String getDebugError()
  {
    AppMethodBeat.i(189031);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189031);
      return null;
    }
    String str = this.mTencentMap.getDebugError();
    AppMethodBeat.o(189031);
    return str;
  }
  
  public final int getIndoorFloorId()
  {
    AppMethodBeat.i(189007);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189007);
      return 0;
    }
    int i = this.mTencentMap.getIndoorFloorId();
    AppMethodBeat.o(189007);
    return i;
  }
  
  public final View getInfoContents(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    return null;
  }
  
  public final View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(189087);
    e locale = a(paramMarker);
    paramMarker = null;
    View localView = null;
    if (this.aalP != null)
    {
      Iterator localIterator = this.aalP.iterator();
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
    AppMethodBeat.o(189087);
    return paramMarker;
  }
  
  public final com.tencent.mapsdk.raster.model.LatLng getMapCenter()
  {
    AppMethodBeat.i(188893);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188893);
      return null;
    }
    this.mTencentMap.getCameraPosition();
    com.tencent.mapsdk.raster.model.LatLng localLatLng = l.a(this.mTencentMap.getCameraPosition().target);
    AppMethodBeat.o(188893);
    return localLatLng;
  }
  
  public final int getMapType()
  {
    AppMethodBeat.i(189056);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189056);
      return 1000;
    }
    int i = this.mTencentMap.getMapType();
    AppMethodBeat.o(189056);
    return i;
  }
  
  public final int getMaxZoomLevel()
  {
    AppMethodBeat.i(188897);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188897);
      return 19;
    }
    int i = (int)this.mTencentMap.getMaxZoomLevel();
    AppMethodBeat.o(188897);
    return i;
  }
  
  public final int getMinZoomLevel()
  {
    AppMethodBeat.i(188898);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188898);
      return 4;
    }
    int i = (int)this.mTencentMap.getMinZoomLevel();
    AppMethodBeat.o(188898);
    return i;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(189058);
    h localh = new h(this.mTencentMap);
    AppMethodBeat.o(189058);
    return localh;
  }
  
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(189062);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189062);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(187835);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(187835);
      }
    });
    AppMethodBeat.o(189062);
  }
  
  @Deprecated
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(189063);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189063);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(187480);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(187480);
      }
    });
    AppMethodBeat.o(189063);
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(188902);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188902);
      return null;
    }
    String str = this.mTencentMap.getVersion();
    AppMethodBeat.o(188902);
    return str;
  }
  
  public final int getZoomLevel()
  {
    AppMethodBeat.i(188894);
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null))
    {
      AppMethodBeat.o(188894);
      return -1;
    }
    int i = (int)this.mTencentMap.getCameraPosition().zoom;
    AppMethodBeat.o(188894);
    return i;
  }
  
  public final boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public final boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(189079);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189079);
      return false;
    }
    boolean bool = this.mTencentMap.isHandDrawMapEnable();
    AppMethodBeat.o(189079);
    return bool;
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.aalM;
  }
  
  public final boolean isTrafficEnabled()
  {
    AppMethodBeat.i(189065);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189065);
      return false;
    }
    boolean bool = this.mTencentMap.isTrafficEnabled();
    AppMethodBeat.o(189065);
    return bool;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(188909);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188909);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.moveCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(188909);
  }
  
  public final void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(189094);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.aalZ != null)
    {
      Iterator localIterator = this.aalZ.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChange(paramCameraPosition);
      }
    }
    AppMethodBeat.o(189094);
  }
  
  public final void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(189096);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.aalZ != null)
    {
      Iterator localIterator = this.aalZ.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChangeFinish(paramCameraPosition);
      }
    }
    AppMethodBeat.o(189096);
  }
  
  public final void onInfoWindowClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(189098);
    paramMarker = a(paramMarker);
    if (this.aalV != null)
    {
      Iterator localIterator = this.aalV.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener)localIterator.next()).onInfoWindowClick(paramMarker);
      }
    }
    AppMethodBeat.o(189098);
  }
  
  public final void onInfoWindowClickLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(189104);
    paramLatLng = l.a(paramLatLng);
    if (this.aamb != null)
    {
      Iterator localIterator = this.aamb.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener)localIterator.next()).onMapClick(paramLatLng);
      }
    }
    AppMethodBeat.o(189104);
  }
  
  public final void onMapLoaded()
  {
    AppMethodBeat.i(189108);
    if (this.aalT != null)
    {
      Iterator localIterator = this.aalT.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapLoadedListener)localIterator.next()).onMapLoaded();
      }
    }
    AppMethodBeat.o(189108);
  }
  
  public final void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(189109);
    paramLatLng = l.a(paramLatLng);
    if (this.aamd != null)
    {
      Iterator localIterator = this.aamd.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener)localIterator.next()).onMapLongClick(paramLatLng);
      }
    }
    AppMethodBeat.o(189109);
  }
  
  public final boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(189112);
    paramMarker = a(paramMarker);
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.aalX != null)
    {
      Iterator localIterator = this.aalX.iterator();
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
    AppMethodBeat.o(189112);
    return bool1;
  }
  
  public final void onMarkerDrag(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(189122);
    paramMarker = a(paramMarker);
    if (this.aalR != null)
    {
      Iterator localIterator = this.aalR.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDrag(paramMarker);
      }
    }
    AppMethodBeat.o(189122);
  }
  
  public final void onMarkerDragEnd(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(189123);
    paramMarker = a(paramMarker);
    if (this.aalR != null)
    {
      Iterator localIterator = this.aalR.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragEnd(paramMarker);
      }
    }
    AppMethodBeat.o(189123);
  }
  
  public final void onMarkerDragStart(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(189119);
    paramMarker = a(paramMarker);
    if (this.aalR != null)
    {
      Iterator localIterator = this.aalR.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragStart(paramMarker);
      }
    }
    AppMethodBeat.o(189119);
  }
  
  public final void remmoveOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(188962);
    if ((paramOnInfoWindowClickListener == null) || (this.aalV == null))
    {
      AppMethodBeat.o(188962);
      return;
    }
    this.aalV.remove(paramOnInfoWindowClickListener);
    AppMethodBeat.o(188962);
  }
  
  public final void removeInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(188929);
    if ((paramInfoWindowAdapter == null) || (this.aalP == null))
    {
      AppMethodBeat.o(188929);
      return;
    }
    this.aalP.remove(paramInfoWindowAdapter);
    AppMethodBeat.o(188929);
  }
  
  public final void removeOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(188974);
    if ((paramOnMapCameraChangeListener == null) || (this.aalZ == null))
    {
      AppMethodBeat.o(188974);
      return;
    }
    this.aalZ.remove(paramOnMapCameraChangeListener);
    AppMethodBeat.o(188974);
  }
  
  public final void removeOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(188979);
    if ((paramOnMapClickListener == null) || (this.aamb == null))
    {
      AppMethodBeat.o(188979);
      return;
    }
    this.aamb.remove(paramOnMapClickListener);
    AppMethodBeat.o(188979);
  }
  
  public final void removeOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(188953);
    if ((paramOnMapLoadedListener == null) || (this.aalT == null))
    {
      AppMethodBeat.o(188953);
      return;
    }
    this.aalT.remove(paramOnMapLoadedListener);
    AppMethodBeat.o(188953);
  }
  
  public final void removeOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(188985);
    if ((paramOnMapLongClickListener == null) || (this.aamd == null))
    {
      AppMethodBeat.o(188985);
      return;
    }
    this.aamd.remove(paramOnMapLongClickListener);
    AppMethodBeat.o(188985);
  }
  
  public final void removeOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(188967);
    if ((paramOnMarkerClickListener == null) || (this.aalX == null))
    {
      AppMethodBeat.o(188967);
      return;
    }
    this.aalX.remove(paramOnMarkerClickListener);
    AppMethodBeat.o(188967);
  }
  
  public final void removeOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(188942);
    if ((paramOnMarkerDraggedListener == null) || (this.aalR == null))
    {
      AppMethodBeat.o(188942);
      return;
    }
    this.aalR.remove(paramOnMarkerDraggedListener);
    AppMethodBeat.o(188942);
  }
  
  public final void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(189022);
    this.mTencentMap.removeTencentMapGestureListener(this.aalN);
    AppMethodBeat.o(189022);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(188915);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188915);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2));
    AppMethodBeat.o(188915);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(188916);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188916);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(187096);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(187096);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(187092);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(187092);
      }
    });
    AppMethodBeat.o(188916);
  }
  
  public final void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(189072);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189072);
      return;
    }
    this.mTencentMap.setBuildingEnable(paramBoolean);
    AppMethodBeat.o(189072);
  }
  
  public final void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(189138);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189138);
      return;
    }
    this.mTencentMap.setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(189138);
  }
  
  public final void setCenter(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(188871);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188871);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(188871);
  }
  
  @Deprecated
  public final void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.mTencentMap == null) {}
  }
  
  public final void setForeignLanguage(com.tencent.mapsdk.raster.model.Language paramLanguage)
  {
    AppMethodBeat.i(189026);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189026);
      return;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramLanguage != null) {}
    switch (l.3.aamo[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
    }
    for (;;)
    {
      localTencentMap.setForeignLanguage(paramLanguage);
      AppMethodBeat.o(189026);
      return;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      continue;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
    }
  }
  
  public final void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(189075);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189075);
      return;
    }
    this.mTencentMap.setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(189075);
  }
  
  public final void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(188994);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188994);
      return;
    }
    this.mTencentMap.setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(188994);
  }
  
  public final void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(188996);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188996);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramInt);
    AppMethodBeat.o(188996);
  }
  
  public final void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188998);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188998);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(188998);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(189000);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189000);
      return;
    }
    this.mTencentMap.setIndoorMaskColor(paramInt);
    AppMethodBeat.o(189000);
  }
  
  public final void setInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(188926);
    if ((paramInfoWindowAdapter == null) && (this.aalO != null)) {
      removeInfoWindowAdapter(this.aalO);
    }
    this.aalO = paramInfoWindowAdapter;
    addInfoWindowAdapter(this.aalO);
    AppMethodBeat.o(188926);
  }
  
  public final void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(189073);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189073);
      return;
    }
    this.mTencentMap.setCameraCenterProportion(paramFloat1, paramFloat2, false);
    this.mTencentMap.getUiSettings().setGestureScaleByMapCenter(true);
    AppMethodBeat.o(189073);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(188990);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188990);
      return;
    }
    this.mTencentMap.setMapStyle(paramInt);
    AppMethodBeat.o(188990);
  }
  
  public final void setMapType(int paramInt)
  {
    AppMethodBeat.i(189055);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189055);
      return;
    }
    this.mTencentMap.setMapType(paramInt);
    AppMethodBeat.o(189055);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(189126);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189126);
      return;
    }
    this.mTencentMap.setMaxZoomLevel(paramInt);
    AppMethodBeat.o(189126);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(189128);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189128);
      return;
    }
    this.mTencentMap.setMinZoomLevel(paramInt);
    AppMethodBeat.o(189128);
  }
  
  public final void setOnIndoorStateChangeListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(188993);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188993);
      return;
    }
    this.mTencentMap.setOnIndoorStateChangeListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener()
    {
      public final boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(189267);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(189267);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingDeactivated();
        AppMethodBeat.o(189267);
        return bool;
      }
      
      public final boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(189265);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(189265);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        AppMethodBeat.o(189265);
        return bool;
      }
      
      public final boolean onIndoorLevelActivated(com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(189266);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(189266);
          return false;
        }
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener localOnIndoorStateChangeListener = paramOnIndoorStateChangeListener;
        if (paramAnonymousIndoorBuilding == null) {
          paramAnonymousIndoorBuilding = null;
        }
        for (;;)
        {
          boolean bool = localOnIndoorStateChangeListener.onIndoorLevelActivated(paramAnonymousIndoorBuilding);
          AppMethodBeat.o(189266);
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
    AppMethodBeat.o(188993);
  }
  
  public final void setOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(188957);
    if ((paramOnInfoWindowClickListener == null) && (this.aalU != null)) {
      remmoveOnInfoWindowClickListener(this.aalU);
    }
    this.aalU = paramOnInfoWindowClickListener;
    addOnInfoWindowClickListener(this.aalU);
    AppMethodBeat.o(188957);
  }
  
  public final void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(188969);
    if ((paramOnMapCameraChangeListener == null) && (this.aalY != null)) {
      removeOnMapCameraChangeListener(this.aalY);
    }
    this.aalY = paramOnMapCameraChangeListener;
    addOnMapCameraChangeListener(this.aalY);
    AppMethodBeat.o(188969);
  }
  
  public final void setOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(188976);
    if ((paramOnMapClickListener == null) && (this.aama != null)) {
      removeOnMapClickListener(this.aama);
    }
    this.aama = paramOnMapClickListener;
    addOnMapClickListener(this.aama);
    AppMethodBeat.o(188976);
  }
  
  public final void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(188946);
    if ((paramOnMapLoadedListener == null) && (this.aalS != null)) {
      removeOnMapLoadedListener(this.aalS);
    }
    this.aalS = paramOnMapLoadedListener;
    addOnMapLoadedListener(this.aalS);
    AppMethodBeat.o(188946);
  }
  
  public final void setOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(188981);
    if ((paramOnMapLongClickListener == null) && (this.aamc != null)) {
      removeOnMapLongClickListener(this.aamc);
    }
    this.aamc = paramOnMapLongClickListener;
    addOnMapLongClickListener(this.aamc);
    AppMethodBeat.o(188981);
  }
  
  public final void setOnMapPoiClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(188988);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188988);
      return;
    }
    this.mTencentMap.setOnMapPoiClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener()
    {
      public final void onClicked(com.tencent.tencentmap.mapsdk.maps.model.MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(189619);
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
          AppMethodBeat.o(189619);
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
    AppMethodBeat.o(188988);
  }
  
  public final void setOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(188964);
    if ((paramOnMarkerClickListener == null) && (this.aalW != null)) {
      removeOnMarkerClickListener(this.aalW);
    }
    this.aalW = paramOnMarkerClickListener;
    addOnMarkerClickListener(this.aalW);
    AppMethodBeat.o(188964);
  }
  
  public final void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(188937);
    if ((paramOnMarkerDraggedListener == null) && (this.aalQ != null)) {
      removeOnMarkerDraggedListener(this.aalQ);
    }
    this.aalQ = paramOnMarkerDraggedListener;
    addOnMarkerDraggedListener(this.aalQ);
    AppMethodBeat.o(188937);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189034);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189034);
      return;
    }
    this.mTencentMap.setPoisEnabled(paramBoolean);
    AppMethodBeat.o(189034);
  }
  
  public final void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(188907);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188907);
      return;
    }
    this.aalM = paramBoolean;
    this.mTencentMap.setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(188907);
  }
  
  public final void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(189015);
    if ((this.mTencentMap == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(189015);
      return;
    }
    if (this.aalN != null) {
      this.mTencentMap.removeTencentMapGestureListener(this.aalN);
    }
    this.aalN = new TencentMapGestureListener()
    {
      public final boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(187014);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187014);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDoubleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(187014);
        return bool;
      }
      
      public final boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(187024);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187024);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDown(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(187024);
        return bool;
      }
      
      public final boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(187017);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187017);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onFling(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(187017);
        return bool;
      }
      
      public final boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(187021);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187021);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onLongPress(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(187021);
        return bool;
      }
      
      public final void onMapStable()
      {
        AppMethodBeat.i(187026);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187026);
          return;
        }
        paramTencentMapGestureListener.onMapStable();
        AppMethodBeat.o(187026);
      }
      
      public final boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(187020);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187020);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onScroll(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(187020);
        return bool;
      }
      
      public final boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(187016);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187016);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onSingleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(187016);
        return bool;
      }
      
      public final boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(187025);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(187025);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onUp(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(187025);
        return bool;
      }
    };
    this.mTencentMap.setTencentMapGestureListener(this.aalN);
    AppMethodBeat.o(189015);
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189064);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189064);
      return;
    }
    this.mTencentMap.setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(189064);
  }
  
  public final void setZoom(int paramInt)
  {
    AppMethodBeat.i(188872);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188872);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomTo(paramInt));
    AppMethodBeat.o(188872);
  }
  
  public final void showBuilding(boolean paramBoolean)
  {
    AppMethodBeat.i(189133);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189133);
      return;
    }
    this.mTencentMap.showBuilding(paramBoolean);
    AppMethodBeat.o(189133);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(189061);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(189061);
      return;
    }
    this.mTencentMap.stopAnimation();
    AppMethodBeat.o(189061);
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(188917);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188917);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomIn());
    AppMethodBeat.o(188917);
  }
  
  public final void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188919);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188919);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(188919);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(188922);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188922);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomOut());
    AppMethodBeat.o(188922);
  }
  
  public final void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188923);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188923);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(188923);
  }
  
  public final void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(188925);
    zoomToSpan(new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(188925);
  }
  
  public final void zoomToSpan(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(188924);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(188924);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(l.c(paramLatLng1), l.c(paramLatLng2)), 0));
    AppMethodBeat.o(188924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */