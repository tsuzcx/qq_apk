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
  private HashMap<Integer, e> MWI;
  List<com.tencent.tencentmap.mapsdk.maps.model.Marker> MWJ;
  private boolean MWK;
  private TencentMapGestureListener MWL;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter MWM;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter> MWN;
  private TencentMap.OnMarkerDraggedListener MWO;
  List<TencentMap.OnMarkerDraggedListener> MWP;
  private TencentMap.OnMapLoadedListener MWQ;
  List<TencentMap.OnMapLoadedListener> MWR;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener MWS;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener> MWT;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener MWU;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener> MWV;
  private TencentMap.OnMapCameraChangeListener MWW;
  List<TencentMap.OnMapCameraChangeListener> MWX;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener MWY;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener> MWZ;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener MXa;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener> MXb;
  private com.tencent.tencentmap.mapsdk.maps.TencentMap mTencentMap;
  
  public i(com.tencent.tencentmap.mapsdk.maps.TencentMap paramTencentMap)
  {
    AppMethodBeat.i(212756);
    this.MWI = new HashMap();
    this.MWJ = new ArrayList();
    this.MWK = false;
    this.mTencentMap = paramTencentMap;
    this.mTencentMap.setInfoWindowAdapter(this);
    this.mTencentMap.setOnMarkerDragListener(this);
    this.mTencentMap.setOnMapLoadedCallback(this);
    this.mTencentMap.setOnInfoWindowClickListener(this);
    this.mTencentMap.setOnMarkerClickListener(this);
    this.mTencentMap.setOnCameraChangeListener(this);
    this.mTencentMap.setOnMapClickListener(this);
    this.mTencentMap.setOnMapLongClickListener(this);
    AppMethodBeat.o(212756);
  }
  
  private e a(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212787);
    if (paramMarker == null)
    {
      AppMethodBeat.o(212787);
      return null;
    }
    paramMarker = (e)this.MWI.get(Integer.valueOf(paramMarker.getId().hashCode()));
    AppMethodBeat.o(212787);
    return paramMarker;
  }
  
  public final Circle addCircle(com.tencent.mapsdk.raster.model.CircleOptions paramCircleOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.CircleOptions localCircleOptions = null;
    AppMethodBeat.i(212759);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212759);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(212759);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCircleOptions == null) {}
    for (paramCircleOptions = localCircleOptions;; paramCircleOptions = localCircleOptions)
    {
      paramCircleOptions = new b(localTencentMap.addCircle(paramCircleOptions));
      AppMethodBeat.o(212759);
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
    AppMethodBeat.i(212830);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212830);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCustomLayerOptions == null) {}
    for (paramCustomLayerOptions = localObject;; paramCustomLayerOptions = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(paramCustomLayerOptions.getLayerId()))
    {
      paramCustomLayerOptions = new c(localTencentMap.addCustomLayer(paramCustomLayerOptions));
      AppMethodBeat.o(212830);
      return paramCustomLayerOptions;
    }
  }
  
  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    AppMethodBeat.i(212853);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212853);
      return null;
    }
    if (paramGroundOverlayOptions == null)
    {
      AppMethodBeat.o(212853);
      return null;
    }
    paramGroundOverlayOptions = this.mTencentMap.addGroundOverlay(paramGroundOverlayOptions);
    AppMethodBeat.o(212853);
    return paramGroundOverlayOptions;
  }
  
  public final void addInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(212785);
    if (paramInfoWindowAdapter == null)
    {
      AppMethodBeat.o(212785);
      return;
    }
    if (this.MWN == null) {
      this.MWN = new LinkedList();
    }
    this.MWN.add(paramInfoWindowAdapter);
    AppMethodBeat.o(212785);
  }
  
  public final com.tencent.mapsdk.raster.model.Marker addMarker(com.tencent.mapsdk.raster.model.MarkerOptions paramMarkerOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions localMarkerOptions = null;
    AppMethodBeat.i(212760);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212760);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(212760);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramMarkerOptions == null) {}
    do
    {
      paramMarkerOptions = new e(this, localTencentMap.addMarker(localMarkerOptions));
      this.MWI.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
      AppMethodBeat.o(212760);
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
    AppMethodBeat.i(212795);
    if (paramOnInfoWindowClickListener == null)
    {
      AppMethodBeat.o(212795);
      return;
    }
    if (this.MWT == null) {
      this.MWT = new LinkedList();
    }
    this.MWT.add(paramOnInfoWindowClickListener);
    AppMethodBeat.o(212795);
  }
  
  public final void addOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(212801);
    if (paramOnMapCameraChangeListener == null)
    {
      AppMethodBeat.o(212801);
      return;
    }
    if (this.MWX == null) {
      this.MWX = new LinkedList();
    }
    this.MWX.add(paramOnMapCameraChangeListener);
    AppMethodBeat.o(212801);
  }
  
  public final void addOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(212804);
    if (paramOnMapClickListener == null)
    {
      AppMethodBeat.o(212804);
      return;
    }
    if (this.MWZ == null) {
      this.MWZ = new LinkedList();
    }
    this.MWZ.add(paramOnMapClickListener);
    AppMethodBeat.o(212804);
  }
  
  public final void addOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(212792);
    if (paramOnMapLoadedListener == null)
    {
      AppMethodBeat.o(212792);
      return;
    }
    if (this.MWR == null) {
      this.MWR = new LinkedList();
    }
    this.MWR.add(paramOnMapLoadedListener);
    AppMethodBeat.o(212792);
  }
  
  public final void addOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(212807);
    if (paramOnMapLongClickListener == null)
    {
      AppMethodBeat.o(212807);
      return;
    }
    if (this.MXb == null) {
      this.MXb = new LinkedList();
    }
    this.MXb.add(paramOnMapLongClickListener);
    AppMethodBeat.o(212807);
  }
  
  public final void addOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(212798);
    if (paramOnMarkerClickListener == null)
    {
      AppMethodBeat.o(212798);
      return;
    }
    if (this.MWV == null) {
      this.MWV = new LinkedList();
    }
    this.MWV.add(paramOnMarkerClickListener);
    AppMethodBeat.o(212798);
  }
  
  public final void addOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(212789);
    if (paramOnMarkerDraggedListener == null)
    {
      AppMethodBeat.o(212789);
      return;
    }
    if (this.MWP == null) {
      this.MWP = new LinkedList();
    }
    this.MWP.add(paramOnMarkerDraggedListener);
    AppMethodBeat.o(212789);
  }
  
  public final Polygon addPolygon(com.tencent.mapsdk.raster.model.PolygonOptions paramPolygonOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(212762);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212762);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(212762);
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
      AppMethodBeat.o(212762);
      return paramPolygonOptions;
      com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions localPolygonOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
      List localList = l.je(paramPolygonOptions.getPoints());
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
    AppMethodBeat.i(212761);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212761);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(212761);
      return null;
    }
    paramPolylineOptions = new f(this.mTencentMap.addPolyline(l.a(paramPolylineOptions)));
    AppMethodBeat.o(212761);
    return paramPolylineOptions;
  }
  
  public final TileOverlay addTileOverlay(com.tencent.mapsdk.raster.model.TileOverlayOptions paramTileOverlayOptions)
  {
    Object localObject = null;
    com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions localTileOverlayOptions = null;
    AppMethodBeat.i(212825);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212825);
      return null;
    }
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(212825);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramTileOverlayOptions == null)
    {
      paramTileOverlayOptions = localTileOverlayOptions;
      paramTileOverlayOptions = new k(localTencentMap.addTileOverlay(paramTileOverlayOptions));
      AppMethodBeat.o(212825);
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
    AppMethodBeat.i(212774);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212774);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(212774);
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(212775);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212775);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap), paramLong, new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(212739);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onCancel();
          }
          AppMethodBeat.o(212739);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(212738);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onFinish();
          }
          AppMethodBeat.o(212738);
        }
      });
    }
    AppMethodBeat.o(212775);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(212763);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212763);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)));
    }
    AppMethodBeat.o(212763);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(212765);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212765);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), paramLong, new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(212737);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(212737);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(212736);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(212736);
      }
    });
    AppMethodBeat.o(212765);
  }
  
  @Deprecated
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, final Runnable paramRunnable)
  {
    AppMethodBeat.i(212764);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212764);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(212735);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(212735);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(212734);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(212734);
        }
      });
    }
    AppMethodBeat.o(212764);
  }
  
  public final void clearAllOverlays()
  {
    AppMethodBeat.i(212766);
    if (this.mTencentMap != null) {
      this.mTencentMap.clear();
    }
    AppMethodBeat.o(212766);
  }
  
  public final boolean clearCache()
  {
    return false;
  }
  
  public final void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(212819);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212819);
      return;
    }
    this.mTencentMap.enableMultipleInfowindow(paramBoolean);
    AppMethodBeat.o(212819);
  }
  
  public final String getActivedIndoorBuilding(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(212816);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212816);
      return null;
    }
    paramLatLng = this.mTencentMap.getActivedIndoorBuilding(l.c(paramLatLng));
    AppMethodBeat.o(212816);
    return paramLatLng;
  }
  
  public final String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(212817);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212817);
      return null;
    }
    String[] arrayOfString = this.mTencentMap.getActivedIndoorFloorNames();
    AppMethodBeat.o(212817);
    return arrayOfString;
  }
  
  public final com.tencent.mapsdk.raster.model.CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(212823);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212823);
      return null;
    }
    com.tencent.mapsdk.raster.model.CameraPosition localCameraPosition = l.a(this.mTencentMap.getCameraPosition());
    AppMethodBeat.o(212823);
    return localCameraPosition;
  }
  
  public final String getDebugError()
  {
    AppMethodBeat.i(212824);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212824);
      return null;
    }
    String str = this.mTencentMap.getDebugError();
    AppMethodBeat.o(212824);
    return str;
  }
  
  public final int getIndoorFloorId()
  {
    AppMethodBeat.i(212818);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212818);
      return 0;
    }
    int i = this.mTencentMap.getIndoorFloorId();
    AppMethodBeat.o(212818);
    return i;
  }
  
  public final View getInfoContents(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    return null;
  }
  
  public final View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212840);
    e locale = a(paramMarker);
    paramMarker = null;
    View localView = null;
    if (this.MWN != null)
    {
      Iterator localIterator = this.MWN.iterator();
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
    AppMethodBeat.o(212840);
    return paramMarker;
  }
  
  public final com.tencent.mapsdk.raster.model.LatLng getMapCenter()
  {
    AppMethodBeat.i(212767);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212767);
      return null;
    }
    this.mTencentMap.getCameraPosition();
    com.tencent.mapsdk.raster.model.LatLng localLatLng = l.a(this.mTencentMap.getCameraPosition().target);
    AppMethodBeat.o(212767);
    return localLatLng;
  }
  
  public final int getMapType()
  {
    AppMethodBeat.i(212828);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212828);
      return 1000;
    }
    int i = this.mTencentMap.getMapType();
    AppMethodBeat.o(212828);
    return i;
  }
  
  public final int getMaxZoomLevel()
  {
    AppMethodBeat.i(212769);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212769);
      return 19;
    }
    int i = (int)this.mTencentMap.getMaxZoomLevel();
    AppMethodBeat.o(212769);
    return i;
  }
  
  public final int getMinZoomLevel()
  {
    AppMethodBeat.i(212770);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212770);
      return 4;
    }
    int i = (int)this.mTencentMap.getMinZoomLevel();
    AppMethodBeat.o(212770);
    return i;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(212829);
    h localh = new h(this.mTencentMap);
    AppMethodBeat.o(212829);
    return localh;
  }
  
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(212832);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212832);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(212754);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(212754);
      }
    });
    AppMethodBeat.o(212832);
  }
  
  @Deprecated
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(212833);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212833);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(212755);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(212755);
      }
    });
    AppMethodBeat.o(212833);
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(212771);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212771);
      return null;
    }
    String str = this.mTencentMap.getVersion();
    AppMethodBeat.o(212771);
    return str;
  }
  
  public final int getZoomLevel()
  {
    AppMethodBeat.i(212768);
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null))
    {
      AppMethodBeat.o(212768);
      return -1;
    }
    int i = (int)this.mTencentMap.getCameraPosition().zoom;
    AppMethodBeat.o(212768);
    return i;
  }
  
  public final boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public final boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(212839);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212839);
      return false;
    }
    boolean bool = this.mTencentMap.isHandDrawMapEnable();
    AppMethodBeat.o(212839);
    return bool;
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.MWK;
  }
  
  public final boolean isTrafficEnabled()
  {
    AppMethodBeat.i(212835);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212835);
      return false;
    }
    boolean bool = this.mTencentMap.isTrafficEnabled();
    AppMethodBeat.o(212835);
    return bool;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(212773);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212773);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.moveCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(212773);
  }
  
  public final void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(212841);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.MWX != null)
    {
      Iterator localIterator = this.MWX.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChange(paramCameraPosition);
      }
    }
    AppMethodBeat.o(212841);
  }
  
  public final void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(212842);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.MWX != null)
    {
      Iterator localIterator = this.MWX.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChangeFinish(paramCameraPosition);
      }
    }
    AppMethodBeat.o(212842);
  }
  
  public final void onInfoWindowClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212843);
    paramMarker = a(paramMarker);
    if (this.MWT != null)
    {
      Iterator localIterator = this.MWT.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener)localIterator.next()).onInfoWindowClick(paramMarker);
      }
    }
    AppMethodBeat.o(212843);
  }
  
  public final void onInfoWindowClickLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(212844);
    paramLatLng = l.a(paramLatLng);
    if (this.MWZ != null)
    {
      Iterator localIterator = this.MWZ.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener)localIterator.next()).onMapClick(paramLatLng);
      }
    }
    AppMethodBeat.o(212844);
  }
  
  public final void onMapLoaded()
  {
    AppMethodBeat.i(212845);
    if (this.MWR != null)
    {
      Iterator localIterator = this.MWR.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapLoadedListener)localIterator.next()).onMapLoaded();
      }
    }
    AppMethodBeat.o(212845);
  }
  
  public final void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(212846);
    paramLatLng = l.a(paramLatLng);
    if (this.MXb != null)
    {
      Iterator localIterator = this.MXb.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener)localIterator.next()).onMapLongClick(paramLatLng);
      }
    }
    AppMethodBeat.o(212846);
  }
  
  public final boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212847);
    paramMarker = a(paramMarker);
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.MWV != null)
    {
      Iterator localIterator = this.MWV.iterator();
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
    AppMethodBeat.o(212847);
    return bool1;
  }
  
  public final void onMarkerDrag(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212849);
    paramMarker = a(paramMarker);
    if (this.MWP != null)
    {
      Iterator localIterator = this.MWP.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDrag(paramMarker);
      }
    }
    AppMethodBeat.o(212849);
  }
  
  public final void onMarkerDragEnd(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212850);
    paramMarker = a(paramMarker);
    if (this.MWP != null)
    {
      Iterator localIterator = this.MWP.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragEnd(paramMarker);
      }
    }
    AppMethodBeat.o(212850);
  }
  
  public final void onMarkerDragStart(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212848);
    paramMarker = a(paramMarker);
    if (this.MWP != null)
    {
      Iterator localIterator = this.MWP.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragStart(paramMarker);
      }
    }
    AppMethodBeat.o(212848);
  }
  
  public final void remmoveOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(212796);
    if ((paramOnInfoWindowClickListener == null) || (this.MWT == null))
    {
      AppMethodBeat.o(212796);
      return;
    }
    this.MWT.remove(paramOnInfoWindowClickListener);
    AppMethodBeat.o(212796);
  }
  
  public final void removeInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(212786);
    if ((paramInfoWindowAdapter == null) || (this.MWN == null))
    {
      AppMethodBeat.o(212786);
      return;
    }
    this.MWN.remove(paramInfoWindowAdapter);
    AppMethodBeat.o(212786);
  }
  
  public final void removeOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(212802);
    if ((paramOnMapCameraChangeListener == null) || (this.MWX == null))
    {
      AppMethodBeat.o(212802);
      return;
    }
    this.MWX.remove(paramOnMapCameraChangeListener);
    AppMethodBeat.o(212802);
  }
  
  public final void removeOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(212805);
    if ((paramOnMapClickListener == null) || (this.MWZ == null))
    {
      AppMethodBeat.o(212805);
      return;
    }
    this.MWZ.remove(paramOnMapClickListener);
    AppMethodBeat.o(212805);
  }
  
  public final void removeOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(212793);
    if ((paramOnMapLoadedListener == null) || (this.MWR == null))
    {
      AppMethodBeat.o(212793);
      return;
    }
    this.MWR.remove(paramOnMapLoadedListener);
    AppMethodBeat.o(212793);
  }
  
  public final void removeOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(212808);
    if ((paramOnMapLongClickListener == null) || (this.MXb == null))
    {
      AppMethodBeat.o(212808);
      return;
    }
    this.MXb.remove(paramOnMapLongClickListener);
    AppMethodBeat.o(212808);
  }
  
  public final void removeOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(212799);
    if ((paramOnMarkerClickListener == null) || (this.MWV == null))
    {
      AppMethodBeat.o(212799);
      return;
    }
    this.MWV.remove(paramOnMarkerClickListener);
    AppMethodBeat.o(212799);
  }
  
  public final void removeOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(212790);
    if ((paramOnMarkerDraggedListener == null) || (this.MWP == null))
    {
      AppMethodBeat.o(212790);
      return;
    }
    this.MWP.remove(paramOnMarkerDraggedListener);
    AppMethodBeat.o(212790);
  }
  
  public final void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(212821);
    this.mTencentMap.removeTencentMapGestureListener(this.MWL);
    AppMethodBeat.o(212821);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(212776);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212776);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2));
    AppMethodBeat.o(212776);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(212777);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212777);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(212741);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(212741);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(212740);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(212740);
      }
    });
    AppMethodBeat.o(212777);
  }
  
  public final void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(212836);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212836);
      return;
    }
    this.mTencentMap.setBuildingEnable(paramBoolean);
    AppMethodBeat.o(212836);
  }
  
  public final void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(212855);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212855);
      return;
    }
    this.mTencentMap.setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(212855);
  }
  
  public final void setCenter(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(212757);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212757);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(212757);
  }
  
  @Deprecated
  public final void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.mTencentMap == null) {}
  }
  
  public final void setForeignLanguage(com.tencent.mapsdk.raster.model.Language paramLanguage)
  {
    AppMethodBeat.i(212822);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212822);
      return;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramLanguage != null) {}
    switch (l.3.MXm[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
    }
    for (;;)
    {
      localTencentMap.setForeignLanguage(paramLanguage);
      AppMethodBeat.o(212822);
      return;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      continue;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
    }
  }
  
  public final void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(212838);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212838);
      return;
    }
    this.mTencentMap.setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(212838);
  }
  
  public final void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212812);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212812);
      return;
    }
    this.mTencentMap.setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(212812);
  }
  
  public final void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(212813);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212813);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramInt);
    AppMethodBeat.o(212813);
  }
  
  public final void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212814);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212814);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(212814);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(212815);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212815);
      return;
    }
    this.mTencentMap.setIndoorMaskColor(paramInt);
    AppMethodBeat.o(212815);
  }
  
  public final void setInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(212784);
    if ((paramInfoWindowAdapter == null) && (this.MWM != null)) {
      removeInfoWindowAdapter(this.MWM);
    }
    this.MWM = paramInfoWindowAdapter;
    addInfoWindowAdapter(this.MWM);
    AppMethodBeat.o(212784);
  }
  
  public final void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(212837);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212837);
      return;
    }
    this.mTencentMap.setCameraCenterProportion(paramFloat1, paramFloat2, false);
    this.mTencentMap.getUiSettings().setGestureScaleByMapCenter(true);
    AppMethodBeat.o(212837);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(212810);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212810);
      return;
    }
    this.mTencentMap.setMapStyle(paramInt);
    AppMethodBeat.o(212810);
  }
  
  public final void setMapType(int paramInt)
  {
    AppMethodBeat.i(212827);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212827);
      return;
    }
    this.mTencentMap.setMapType(paramInt);
    AppMethodBeat.o(212827);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(212851);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212851);
      return;
    }
    this.mTencentMap.setMaxZoomLevel(paramInt);
    AppMethodBeat.o(212851);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(212852);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212852);
      return;
    }
    this.mTencentMap.setMinZoomLevel(paramInt);
    AppMethodBeat.o(212852);
  }
  
  public final void setOnIndoorStateChangeListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(212811);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212811);
      return;
    }
    this.mTencentMap.setOnIndoorStateChangeListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener()
    {
      public final boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(212745);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(212745);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingDeactivated();
        AppMethodBeat.o(212745);
        return bool;
      }
      
      public final boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(212743);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(212743);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        AppMethodBeat.o(212743);
        return bool;
      }
      
      public final boolean onIndoorLevelActivated(com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(212744);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(212744);
          return false;
        }
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener localOnIndoorStateChangeListener = paramOnIndoorStateChangeListener;
        if (paramAnonymousIndoorBuilding == null) {
          paramAnonymousIndoorBuilding = null;
        }
        for (;;)
        {
          boolean bool = localOnIndoorStateChangeListener.onIndoorLevelActivated(paramAnonymousIndoorBuilding);
          AppMethodBeat.o(212744);
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
    AppMethodBeat.o(212811);
  }
  
  public final void setOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(212794);
    if ((paramOnInfoWindowClickListener == null) && (this.MWS != null)) {
      remmoveOnInfoWindowClickListener(this.MWS);
    }
    this.MWS = paramOnInfoWindowClickListener;
    addOnInfoWindowClickListener(this.MWS);
    AppMethodBeat.o(212794);
  }
  
  public final void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(212800);
    if ((paramOnMapCameraChangeListener == null) && (this.MWW != null)) {
      removeOnMapCameraChangeListener(this.MWW);
    }
    this.MWW = paramOnMapCameraChangeListener;
    addOnMapCameraChangeListener(this.MWW);
    AppMethodBeat.o(212800);
  }
  
  public final void setOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(212803);
    if ((paramOnMapClickListener == null) && (this.MWY != null)) {
      removeOnMapClickListener(this.MWY);
    }
    this.MWY = paramOnMapClickListener;
    addOnMapClickListener(this.MWY);
    AppMethodBeat.o(212803);
  }
  
  public final void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(212791);
    if ((paramOnMapLoadedListener == null) && (this.MWQ != null)) {
      removeOnMapLoadedListener(this.MWQ);
    }
    this.MWQ = paramOnMapLoadedListener;
    addOnMapLoadedListener(this.MWQ);
    AppMethodBeat.o(212791);
  }
  
  public final void setOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(212806);
    if ((paramOnMapLongClickListener == null) && (this.MXa != null)) {
      removeOnMapLongClickListener(this.MXa);
    }
    this.MXa = paramOnMapLongClickListener;
    addOnMapLongClickListener(this.MXa);
    AppMethodBeat.o(212806);
  }
  
  public final void setOnMapPoiClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(212809);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212809);
      return;
    }
    this.mTencentMap.setOnMapPoiClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener()
    {
      public final void onClicked(com.tencent.tencentmap.mapsdk.maps.model.MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(212742);
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
          AppMethodBeat.o(212742);
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
    AppMethodBeat.o(212809);
  }
  
  public final void setOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(212797);
    if ((paramOnMarkerClickListener == null) && (this.MWU != null)) {
      removeOnMarkerClickListener(this.MWU);
    }
    this.MWU = paramOnMarkerClickListener;
    addOnMarkerClickListener(this.MWU);
    AppMethodBeat.o(212797);
  }
  
  public final void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(212788);
    if ((paramOnMarkerDraggedListener == null) && (this.MWO != null)) {
      removeOnMarkerDraggedListener(this.MWO);
    }
    this.MWO = paramOnMarkerDraggedListener;
    addOnMarkerDraggedListener(this.MWO);
    AppMethodBeat.o(212788);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212826);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212826);
      return;
    }
    this.mTencentMap.setPoisEnabled(paramBoolean);
    AppMethodBeat.o(212826);
  }
  
  public final void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212772);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212772);
      return;
    }
    this.MWK = paramBoolean;
    this.mTencentMap.setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(212772);
  }
  
  public final void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(212820);
    if ((this.mTencentMap == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(212820);
      return;
    }
    if (this.MWL != null) {
      this.mTencentMap.removeTencentMapGestureListener(this.MWL);
    }
    this.MWL = new TencentMapGestureListener()
    {
      public final boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212746);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212746);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDoubleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212746);
        return bool;
      }
      
      public final boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212751);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212751);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDown(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212751);
        return bool;
      }
      
      public final boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212748);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212748);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onFling(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212748);
        return bool;
      }
      
      public final boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212750);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212750);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onLongPress(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212750);
        return bool;
      }
      
      public final void onMapStable()
      {
        AppMethodBeat.i(212753);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212753);
          return;
        }
        paramTencentMapGestureListener.onMapStable();
        AppMethodBeat.o(212753);
      }
      
      public final boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212749);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212749);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onScroll(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212749);
        return bool;
      }
      
      public final boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212747);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212747);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onSingleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212747);
        return bool;
      }
      
      public final boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212752);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(212752);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onUp(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212752);
        return bool;
      }
    };
    this.mTencentMap.setTencentMapGestureListener(this.MWL);
    AppMethodBeat.o(212820);
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212834);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212834);
      return;
    }
    this.mTencentMap.setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(212834);
  }
  
  public final void setZoom(int paramInt)
  {
    AppMethodBeat.i(212758);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212758);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomTo(paramInt));
    AppMethodBeat.o(212758);
  }
  
  public final void showBuilding(boolean paramBoolean)
  {
    AppMethodBeat.i(212854);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212854);
      return;
    }
    this.mTencentMap.showBuilding(paramBoolean);
    AppMethodBeat.o(212854);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(212831);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212831);
      return;
    }
    this.mTencentMap.stopAnimation();
    AppMethodBeat.o(212831);
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(212778);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212778);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomIn());
    AppMethodBeat.o(212778);
  }
  
  public final void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212779);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212779);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(212779);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(212780);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212780);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomOut());
    AppMethodBeat.o(212780);
  }
  
  public final void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212781);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212781);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(212781);
  }
  
  public final void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(212783);
    zoomToSpan(new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(212783);
  }
  
  public final void zoomToSpan(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(212782);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(212782);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(l.c(paramLatLng1), l.c(paramLatLng2)), 0));
    AppMethodBeat.o(212782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */